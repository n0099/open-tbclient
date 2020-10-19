package com.baidu.tieba.ala.category.a;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class e extends BaseAdapter {
    private b geO;
    private List<com.baidu.tieba.ala.category.b.d> geP;
    private SparseArray<com.baidu.tieba.ala.category.b.d> geQ = new SparseArray<>(3);
    private Set<String> geR;
    private final TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void bLJ();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.geQ.put(a.f.bg_tag_checked1, null);
        this.geQ.put(a.f.bg_tag_checked2, null);
        this.geQ.put(a.f.bg_tag_checked3, null);
        this.geR = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.geP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.geP, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.item_ala_live_tag, viewGroup, false);
            aVar = new a();
            aVar.geU = (TextView) view.findViewById(a.g.ala_live_tag_name_tv);
            aVar.geU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.geP.get(i), aVar);
                    if (e.this.geO != null) {
                        e.this.geO.bLJ();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.geP.get(i);
        aVar.geU.setText(a(dVar));
        aVar.geU.setSelected(dVar.isChecked());
        aVar.geU.setBackgroundResource(dVar.bLT());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.geP = list;
            bLM();
            notifyDataSetChanged();
        }
    }

    public List<String> bLK() {
        ArrayList arrayList = new ArrayList();
        int size = this.geQ.size();
        for (int i = 0; i < size; i++) {
            if (this.geQ.valueAt(i) != null) {
                arrayList.add(this.geQ.valueAt(i).bLS());
            }
        }
        return arrayList;
    }

    public Set<String> bLL() {
        return this.geR;
    }

    public void a(b bVar) {
        this.geO = bVar;
    }

    private void bLM() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.geP) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.tL(this.geQ.keyAt(i2));
                    this.geQ.put(dVar.bLT(), dVar);
                    this.geR.add(dVar.bLS());
                    i = i2 + 1;
                } else {
                    dVar.tL(a.f.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bLN = bLN();
            if (bLN == 0) {
                this.mPageContext.showToast(a.i.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.tL(bLN);
            this.geQ.put(bLN, dVar);
        } else {
            dVar.setChecked(false);
            this.geQ.put(dVar.bLT(), null);
            dVar.tL(a.f.bg_tag_unchecked);
        }
        aVar.geU.setSelected(dVar.isChecked());
        aVar.geU.setBackgroundResource(dVar.bLT());
    }

    private int bLN() {
        if (this.geQ.valueAt(0) == null) {
            return this.geQ.keyAt(0);
        }
        if (this.geQ.valueAt(1) == null) {
            return this.geQ.keyAt(1);
        }
        if (this.geQ.valueAt(2) == null) {
            return this.geQ.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bLS();
        }
        return dVar.bLS() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView geU;

        private a() {
        }
    }
}
