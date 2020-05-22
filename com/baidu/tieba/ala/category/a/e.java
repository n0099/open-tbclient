package com.baidu.tieba.ala.category.a;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private b fnj;
    private List<com.baidu.tieba.ala.category.b.d> fnk;
    private SparseArray<com.baidu.tieba.ala.category.b.d> fnl = new SparseArray<>(3);
    private Set<String> fnm;
    private final TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface b {
        void bsG();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fnl.put(a.f.bg_tag_checked1, null);
        this.fnl.put(a.f.bg_tag_checked2, null);
        this.fnl.put(a.f.bg_tag_checked3, null);
        this.fnm = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fnk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.fnk, i);
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
            aVar.fnp = (TextView) view.findViewById(a.g.ala_live_tag_name_tv);
            aVar.fnp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.fnk.get(i), aVar);
                    if (e.this.fnj != null) {
                        e.this.fnj.bsG();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.fnk.get(i);
        aVar.fnp.setText(a(dVar));
        aVar.fnp.setSelected(dVar.isChecked());
        aVar.fnp.setBackgroundResource(dVar.bsQ());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.fnk = list;
            bsJ();
            notifyDataSetChanged();
        }
    }

    public List<String> bsH() {
        ArrayList arrayList = new ArrayList();
        int size = this.fnl.size();
        for (int i = 0; i < size; i++) {
            if (this.fnl.valueAt(i) != null) {
                arrayList.add(this.fnl.valueAt(i).bsP());
            }
        }
        return arrayList;
    }

    public Set<String> bsI() {
        return this.fnm;
    }

    public void a(b bVar) {
        this.fnj = bVar;
    }

    private void bsJ() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.fnk) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.pT(this.fnl.keyAt(i2));
                    this.fnl.put(dVar.bsQ(), dVar);
                    this.fnm.add(dVar.bsP());
                    i = i2 + 1;
                } else {
                    dVar.pT(a.f.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bsK = bsK();
            if (bsK == 0) {
                this.mPageContext.showToast(a.i.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.pT(bsK);
            this.fnl.put(bsK, dVar);
        } else {
            dVar.setChecked(false);
            this.fnl.put(dVar.bsQ(), null);
            dVar.pT(a.f.bg_tag_unchecked);
        }
        aVar.fnp.setSelected(dVar.isChecked());
        aVar.fnp.setBackgroundResource(dVar.bsQ());
    }

    private int bsK() {
        if (this.fnl.valueAt(0) == null) {
            return this.fnl.keyAt(0);
        }
        if (this.fnl.valueAt(1) == null) {
            return this.fnl.keyAt(1);
        }
        if (this.fnl.valueAt(2) == null) {
            return this.fnl.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bsP();
        }
        return dVar.bsP() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private TextView fnp;

        private a() {
        }
    }
}
