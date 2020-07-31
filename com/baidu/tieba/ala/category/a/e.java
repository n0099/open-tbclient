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
    private b fDP;
    private List<com.baidu.tieba.ala.category.b.d> fDQ;
    private SparseArray<com.baidu.tieba.ala.category.b.d> fDR = new SparseArray<>(3);
    private Set<String> fDS;
    private final TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void byN();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fDR.put(a.f.bg_tag_checked1, null);
        this.fDR.put(a.f.bg_tag_checked2, null);
        this.fDR.put(a.f.bg_tag_checked3, null);
        this.fDS = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fDQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.fDQ, i);
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
            aVar.fDV = (TextView) view.findViewById(a.g.ala_live_tag_name_tv);
            aVar.fDV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.fDQ.get(i), aVar);
                    if (e.this.fDP != null) {
                        e.this.fDP.byN();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.fDQ.get(i);
        aVar.fDV.setText(a(dVar));
        aVar.fDV.setSelected(dVar.isChecked());
        aVar.fDV.setBackgroundResource(dVar.byX());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.fDQ = list;
            byQ();
            notifyDataSetChanged();
        }
    }

    public List<String> byO() {
        ArrayList arrayList = new ArrayList();
        int size = this.fDR.size();
        for (int i = 0; i < size; i++) {
            if (this.fDR.valueAt(i) != null) {
                arrayList.add(this.fDR.valueAt(i).byW());
            }
        }
        return arrayList;
    }

    public Set<String> byP() {
        return this.fDS;
    }

    public void a(b bVar) {
        this.fDP = bVar;
    }

    private void byQ() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.fDQ) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.qJ(this.fDR.keyAt(i2));
                    this.fDR.put(dVar.byX(), dVar);
                    this.fDS.add(dVar.byW());
                    i = i2 + 1;
                } else {
                    dVar.qJ(a.f.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int byR = byR();
            if (byR == 0) {
                this.mPageContext.showToast(a.i.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.qJ(byR);
            this.fDR.put(byR, dVar);
        } else {
            dVar.setChecked(false);
            this.fDR.put(dVar.byX(), null);
            dVar.qJ(a.f.bg_tag_unchecked);
        }
        aVar.fDV.setSelected(dVar.isChecked());
        aVar.fDV.setBackgroundResource(dVar.byX());
    }

    private int byR() {
        if (this.fDR.valueAt(0) == null) {
            return this.fDR.keyAt(0);
        }
        if (this.fDR.valueAt(1) == null) {
            return this.fDR.keyAt(1);
        }
        if (this.fDR.valueAt(2) == null) {
            return this.fDR.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.byW();
        }
        return dVar.byW() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView fDV;

        private a() {
        }
    }
}
