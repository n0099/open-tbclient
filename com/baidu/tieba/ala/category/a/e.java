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
    private b fPk;
    private List<com.baidu.tieba.ala.category.b.d> fPl;
    private SparseArray<com.baidu.tieba.ala.category.b.d> fPm = new SparseArray<>(3);
    private Set<String> fPn;
    private final TbPageContext mPageContext;

    /* loaded from: classes7.dex */
    public interface b {
        void bHR();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fPm.put(a.f.bg_tag_checked1, null);
        this.fPm.put(a.f.bg_tag_checked2, null);
        this.fPm.put(a.f.bg_tag_checked3, null);
        this.fPn = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fPl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.fPl, i);
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
            aVar.fPq = (TextView) view.findViewById(a.g.ala_live_tag_name_tv);
            aVar.fPq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.fPl.get(i), aVar);
                    if (e.this.fPk != null) {
                        e.this.fPk.bHR();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.fPl.get(i);
        aVar.fPq.setText(a(dVar));
        aVar.fPq.setSelected(dVar.isChecked());
        aVar.fPq.setBackgroundResource(dVar.bIb());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.fPl = list;
            bHU();
            notifyDataSetChanged();
        }
    }

    public List<String> bHS() {
        ArrayList arrayList = new ArrayList();
        int size = this.fPm.size();
        for (int i = 0; i < size; i++) {
            if (this.fPm.valueAt(i) != null) {
                arrayList.add(this.fPm.valueAt(i).bIa());
            }
        }
        return arrayList;
    }

    public Set<String> bHT() {
        return this.fPn;
    }

    public void a(b bVar) {
        this.fPk = bVar;
    }

    private void bHU() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.fPl) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.sV(this.fPm.keyAt(i2));
                    this.fPm.put(dVar.bIb(), dVar);
                    this.fPn.add(dVar.bIa());
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
            int bHV = bHV();
            if (bHV == 0) {
                this.mPageContext.showToast(a.i.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.sV(bHV);
            this.fPm.put(bHV, dVar);
        } else {
            dVar.setChecked(false);
            this.fPm.put(dVar.bIb(), null);
            dVar.sV(a.f.bg_tag_unchecked);
        }
        aVar.fPq.setSelected(dVar.isChecked());
        aVar.fPq.setBackgroundResource(dVar.bIb());
    }

    private int bHV() {
        if (this.fPm.valueAt(0) == null) {
            return this.fPm.keyAt(0);
        }
        if (this.fPm.valueAt(1) == null) {
            return this.fPm.keyAt(1);
        }
        if (this.fPm.valueAt(2) == null) {
            return this.fPm.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bIa();
        }
        return dVar.bIa() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        private TextView fPq;

        private a() {
        }
    }
}
