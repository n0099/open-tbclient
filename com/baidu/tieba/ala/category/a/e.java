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
/* loaded from: classes7.dex */
public class e extends BaseAdapter {
    private b fPg;
    private List<com.baidu.tieba.ala.category.b.d> fPh;
    private SparseArray<com.baidu.tieba.ala.category.b.d> fPi = new SparseArray<>(3);
    private Set<String> fPj;
    private final TbPageContext mPageContext;

    /* loaded from: classes7.dex */
    public interface b {
        void bHQ();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fPi.put(a.f.bg_tag_checked1, null);
        this.fPi.put(a.f.bg_tag_checked2, null);
        this.fPi.put(a.f.bg_tag_checked3, null);
        this.fPj = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fPh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.fPh, i);
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
            aVar.fPm = (TextView) view.findViewById(a.g.ala_live_tag_name_tv);
            aVar.fPm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.fPh.get(i), aVar);
                    if (e.this.fPg != null) {
                        e.this.fPg.bHQ();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.fPh.get(i);
        aVar.fPm.setText(a(dVar));
        aVar.fPm.setSelected(dVar.isChecked());
        aVar.fPm.setBackgroundResource(dVar.bIa());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.fPh = list;
            bHT();
            notifyDataSetChanged();
        }
    }

    public List<String> bHR() {
        ArrayList arrayList = new ArrayList();
        int size = this.fPi.size();
        for (int i = 0; i < size; i++) {
            if (this.fPi.valueAt(i) != null) {
                arrayList.add(this.fPi.valueAt(i).bHZ());
            }
        }
        return arrayList;
    }

    public Set<String> bHS() {
        return this.fPj;
    }

    public void a(b bVar) {
        this.fPg = bVar;
    }

    private void bHT() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.fPh) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.sV(this.fPi.keyAt(i2));
                    this.fPi.put(dVar.bIa(), dVar);
                    this.fPj.add(dVar.bHZ());
                    i = i2 + 1;
                } else {
                    dVar.sV(a.f.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bHU = bHU();
            if (bHU == 0) {
                this.mPageContext.showToast(a.i.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.sV(bHU);
            this.fPi.put(bHU, dVar);
        } else {
            dVar.setChecked(false);
            this.fPi.put(dVar.bIa(), null);
            dVar.sV(a.f.bg_tag_unchecked);
        }
        aVar.fPm.setSelected(dVar.isChecked());
        aVar.fPm.setBackgroundResource(dVar.bIa());
    }

    private int bHU() {
        if (this.fPi.valueAt(0) == null) {
            return this.fPi.keyAt(0);
        }
        if (this.fPi.valueAt(1) == null) {
            return this.fPi.keyAt(1);
        }
        if (this.fPi.valueAt(2) == null) {
            return this.fPi.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bHZ();
        }
        return dVar.bHZ() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        private TextView fPm;

        private a() {
        }
    }
}
