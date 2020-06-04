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
    private b fnu;
    private List<com.baidu.tieba.ala.category.b.d> fnv;
    private SparseArray<com.baidu.tieba.ala.category.b.d> fnw = new SparseArray<>(3);
    private Set<String> fnx;
    private final TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface b {
        void bsI();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fnw.put(a.f.bg_tag_checked1, null);
        this.fnw.put(a.f.bg_tag_checked2, null);
        this.fnw.put(a.f.bg_tag_checked3, null);
        this.fnx = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fnv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.fnv, i);
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
            aVar.fnA = (TextView) view.findViewById(a.g.ala_live_tag_name_tv);
            aVar.fnA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.fnv.get(i), aVar);
                    if (e.this.fnu != null) {
                        e.this.fnu.bsI();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.fnv.get(i);
        aVar.fnA.setText(a(dVar));
        aVar.fnA.setSelected(dVar.isChecked());
        aVar.fnA.setBackgroundResource(dVar.bsS());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.fnv = list;
            bsL();
            notifyDataSetChanged();
        }
    }

    public List<String> bsJ() {
        ArrayList arrayList = new ArrayList();
        int size = this.fnw.size();
        for (int i = 0; i < size; i++) {
            if (this.fnw.valueAt(i) != null) {
                arrayList.add(this.fnw.valueAt(i).bsR());
            }
        }
        return arrayList;
    }

    public Set<String> bsK() {
        return this.fnx;
    }

    public void a(b bVar) {
        this.fnu = bVar;
    }

    private void bsL() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.fnv) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.pV(this.fnw.keyAt(i2));
                    this.fnw.put(dVar.bsS(), dVar);
                    this.fnx.add(dVar.bsR());
                    i = i2 + 1;
                } else {
                    dVar.pV(a.f.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bsM = bsM();
            if (bsM == 0) {
                this.mPageContext.showToast(a.i.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.pV(bsM);
            this.fnw.put(bsM, dVar);
        } else {
            dVar.setChecked(false);
            this.fnw.put(dVar.bsS(), null);
            dVar.pV(a.f.bg_tag_unchecked);
        }
        aVar.fnA.setSelected(dVar.isChecked());
        aVar.fnA.setBackgroundResource(dVar.bsS());
    }

    private int bsM() {
        if (this.fnw.valueAt(0) == null) {
            return this.fnw.keyAt(0);
        }
        if (this.fnw.valueAt(1) == null) {
            return this.fnw.keyAt(1);
        }
        if (this.fnw.valueAt(2) == null) {
            return this.fnw.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bsR();
        }
        return dVar.bsR() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private TextView fnA;

        private a() {
        }
    }
}
