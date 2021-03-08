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
/* loaded from: classes10.dex */
public class e extends BaseAdapter {
    private b gOF;
    private List<com.baidu.tieba.ala.category.b.d> gOG;
    private SparseArray<com.baidu.tieba.ala.category.b.d> gOH = new SparseArray<>(3);
    private Set<String> gOI;
    private final TbPageContext mPageContext;

    /* loaded from: classes10.dex */
    public interface b {
        void bTt();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gOH.put(a.e.bg_tag_checked1, null);
        this.gOH.put(a.e.bg_tag_checked2, null);
        this.gOH.put(a.e.bg_tag_checked3, null);
        this.gOI = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gOG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.gOG, i);
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
            aVar.gOL = (TextView) view.findViewById(a.f.ala_live_tag_name_tv);
            aVar.gOL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.gOG.get(i), aVar);
                    if (e.this.gOF != null) {
                        e.this.gOF.bTt();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.gOG.get(i);
        aVar.gOL.setText(a(dVar));
        aVar.gOL.setSelected(dVar.isChecked());
        aVar.gOL.setBackgroundResource(dVar.bTD());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gOG = list;
            bTw();
            notifyDataSetChanged();
        }
    }

    public List<String> bTu() {
        ArrayList arrayList = new ArrayList();
        int size = this.gOH.size();
        for (int i = 0; i < size; i++) {
            if (this.gOH.valueAt(i) != null) {
                arrayList.add(this.gOH.valueAt(i).bTC());
            }
        }
        return arrayList;
    }

    public Set<String> bTv() {
        return this.gOI;
    }

    public void a(b bVar) {
        this.gOF = bVar;
    }

    private void bTw() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.gOG) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.ug(this.gOH.keyAt(i2));
                    this.gOH.put(dVar.bTD(), dVar);
                    this.gOI.add(dVar.bTC());
                    i = i2 + 1;
                } else {
                    dVar.ug(a.e.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bTx = bTx();
            if (bTx == 0) {
                this.mPageContext.showToast(a.h.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.ug(bTx);
            this.gOH.put(bTx, dVar);
        } else {
            dVar.setChecked(false);
            this.gOH.put(dVar.bTD(), null);
            dVar.ug(a.e.bg_tag_unchecked);
        }
        aVar.gOL.setSelected(dVar.isChecked());
        aVar.gOL.setBackgroundResource(dVar.bTD());
    }

    private int bTx() {
        if (this.gOH.valueAt(0) == null) {
            return this.gOH.keyAt(0);
        }
        if (this.gOH.valueAt(1) == null) {
            return this.gOH.keyAt(1);
        }
        if (this.gOH.valueAt(2) == null) {
            return this.gOH.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bTC();
        }
        return dVar.bTC() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        private TextView gOL;

        private a() {
        }
    }
}
