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
    private b gCU;
    private List<com.baidu.tieba.ala.category.b.d> gCV;
    private SparseArray<com.baidu.tieba.ala.category.b.d> gCW = new SparseArray<>(3);
    private Set<String> gCX;
    private final TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void bTO();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gCW.put(a.e.bg_tag_checked1, null);
        this.gCW.put(a.e.bg_tag_checked2, null);
        this.gCW.put(a.e.bg_tag_checked3, null);
        this.gCX = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gCV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.gCV, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.item_ala_live_tag, viewGroup, false);
            aVar = new a();
            aVar.gDa = (TextView) view.findViewById(a.f.ala_live_tag_name_tv);
            aVar.gDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.gCV.get(i), aVar);
                    if (e.this.gCU != null) {
                        e.this.gCU.bTO();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.gCV.get(i);
        aVar.gDa.setText(a(dVar));
        aVar.gDa.setSelected(dVar.isChecked());
        aVar.gDa.setBackgroundResource(dVar.bTY());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gCV = list;
            bTR();
            notifyDataSetChanged();
        }
    }

    public List<String> bTP() {
        ArrayList arrayList = new ArrayList();
        int size = this.gCW.size();
        for (int i = 0; i < size; i++) {
            if (this.gCW.valueAt(i) != null) {
                arrayList.add(this.gCW.valueAt(i).bTX());
            }
        }
        return arrayList;
    }

    public Set<String> bTQ() {
        return this.gCX;
    }

    public void a(b bVar) {
        this.gCU = bVar;
    }

    private void bTR() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.gCV) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.vt(this.gCW.keyAt(i2));
                    this.gCW.put(dVar.bTY(), dVar);
                    this.gCX.add(dVar.bTX());
                    i = i2 + 1;
                } else {
                    dVar.vt(a.e.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bTS = bTS();
            if (bTS == 0) {
                this.mPageContext.showToast(a.h.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.vt(bTS);
            this.gCW.put(bTS, dVar);
        } else {
            dVar.setChecked(false);
            this.gCW.put(dVar.bTY(), null);
            dVar.vt(a.e.bg_tag_unchecked);
        }
        aVar.gDa.setSelected(dVar.isChecked());
        aVar.gDa.setBackgroundResource(dVar.bTY());
    }

    private int bTS() {
        if (this.gCW.valueAt(0) == null) {
            return this.gCW.keyAt(0);
        }
        if (this.gCW.valueAt(1) == null) {
            return this.gCW.keyAt(1);
        }
        if (this.gCW.valueAt(2) == null) {
            return this.gCW.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bTX();
        }
        return dVar.bTX() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView gDa;

        private a() {
        }
    }
}
