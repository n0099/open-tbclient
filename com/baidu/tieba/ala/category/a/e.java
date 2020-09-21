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
    private b fSv;
    private List<com.baidu.tieba.ala.category.b.d> fSw;
    private SparseArray<com.baidu.tieba.ala.category.b.d> fSx = new SparseArray<>(3);
    private Set<String> fSy;
    private final TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void bIZ();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fSx.put(a.f.bg_tag_checked1, null);
        this.fSx.put(a.f.bg_tag_checked2, null);
        this.fSx.put(a.f.bg_tag_checked3, null);
        this.fSy = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fSw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.fSw, i);
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
            aVar.fSB = (TextView) view.findViewById(a.g.ala_live_tag_name_tv);
            aVar.fSB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.fSw.get(i), aVar);
                    if (e.this.fSv != null) {
                        e.this.fSv.bIZ();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.fSw.get(i);
        aVar.fSB.setText(a(dVar));
        aVar.fSB.setSelected(dVar.isChecked());
        aVar.fSB.setBackgroundResource(dVar.bJj());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.fSw = list;
            bJc();
            notifyDataSetChanged();
        }
    }

    public List<String> bJa() {
        ArrayList arrayList = new ArrayList();
        int size = this.fSx.size();
        for (int i = 0; i < size; i++) {
            if (this.fSx.valueAt(i) != null) {
                arrayList.add(this.fSx.valueAt(i).bJi());
            }
        }
        return arrayList;
    }

    public Set<String> bJb() {
        return this.fSy;
    }

    public void a(b bVar) {
        this.fSv = bVar;
    }

    private void bJc() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.fSw) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.tn(this.fSx.keyAt(i2));
                    this.fSx.put(dVar.bJj(), dVar);
                    this.fSy.add(dVar.bJi());
                    i = i2 + 1;
                } else {
                    dVar.tn(a.f.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bJd = bJd();
            if (bJd == 0) {
                this.mPageContext.showToast(a.i.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.tn(bJd);
            this.fSx.put(bJd, dVar);
        } else {
            dVar.setChecked(false);
            this.fSx.put(dVar.bJj(), null);
            dVar.tn(a.f.bg_tag_unchecked);
        }
        aVar.fSB.setSelected(dVar.isChecked());
        aVar.fSB.setBackgroundResource(dVar.bJj());
    }

    private int bJd() {
        if (this.fSx.valueAt(0) == null) {
            return this.fSx.keyAt(0);
        }
        if (this.fSx.valueAt(1) == null) {
            return this.fSx.keyAt(1);
        }
        if (this.fSx.valueAt(2) == null) {
            return this.fSx.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bJi();
        }
        return dVar.bJi() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView fSB;

        private a() {
        }
    }
}
