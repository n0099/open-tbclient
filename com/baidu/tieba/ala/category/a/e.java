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
    private b gKc;
    private List<com.baidu.tieba.ala.category.b.d> gKd;
    private SparseArray<com.baidu.tieba.ala.category.b.d> gKe = new SparseArray<>(3);
    private Set<String> gKf;
    private final TbPageContext mPageContext;

    /* loaded from: classes10.dex */
    public interface b {
        void bSD();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gKe.put(a.e.bg_tag_checked1, null);
        this.gKe.put(a.e.bg_tag_checked2, null);
        this.gKe.put(a.e.bg_tag_checked3, null);
        this.gKf = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gKd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.gKd, i);
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
            aVar.gKi = (TextView) view.findViewById(a.f.ala_live_tag_name_tv);
            aVar.gKi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.gKd.get(i), aVar);
                    if (e.this.gKc != null) {
                        e.this.gKc.bSD();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.gKd.get(i);
        aVar.gKi.setText(a(dVar));
        aVar.gKi.setSelected(dVar.isChecked());
        aVar.gKi.setBackgroundResource(dVar.bSN());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gKd = list;
            bSG();
            notifyDataSetChanged();
        }
    }

    public List<String> bSE() {
        ArrayList arrayList = new ArrayList();
        int size = this.gKe.size();
        for (int i = 0; i < size; i++) {
            if (this.gKe.valueAt(i) != null) {
                arrayList.add(this.gKe.valueAt(i).bSM());
            }
        }
        return arrayList;
    }

    public Set<String> bSF() {
        return this.gKf;
    }

    public void a(b bVar) {
        this.gKc = bVar;
    }

    private void bSG() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.gKd) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.tY(this.gKe.keyAt(i2));
                    this.gKe.put(dVar.bSN(), dVar);
                    this.gKf.add(dVar.bSM());
                    i = i2 + 1;
                } else {
                    dVar.tY(a.e.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bSH = bSH();
            if (bSH == 0) {
                this.mPageContext.showToast(a.h.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.tY(bSH);
            this.gKe.put(bSH, dVar);
        } else {
            dVar.setChecked(false);
            this.gKe.put(dVar.bSN(), null);
            dVar.tY(a.e.bg_tag_unchecked);
        }
        aVar.gKi.setSelected(dVar.isChecked());
        aVar.gKi.setBackgroundResource(dVar.bSN());
    }

    private int bSH() {
        if (this.gKe.valueAt(0) == null) {
            return this.gKe.keyAt(0);
        }
        if (this.gKe.valueAt(1) == null) {
            return this.gKe.keyAt(1);
        }
        if (this.gKe.valueAt(2) == null) {
            return this.gKe.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bSM();
        }
        return dVar.bSM() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        private TextView gKi;

        private a() {
        }
    }
}
