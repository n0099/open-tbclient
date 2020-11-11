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
    private b guE;
    private List<com.baidu.tieba.ala.category.b.d> guF;
    private SparseArray<com.baidu.tieba.ala.category.b.d> guG = new SparseArray<>(3);
    private Set<String> guH;
    private final TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void bQL();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.guG.put(a.e.bg_tag_checked1, null);
        this.guG.put(a.e.bg_tag_checked2, null);
        this.guG.put(a.e.bg_tag_checked3, null);
        this.guH = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.guF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.guF, i);
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
            aVar.guK = (TextView) view.findViewById(a.f.ala_live_tag_name_tv);
            aVar.guK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.guF.get(i), aVar);
                    if (e.this.guE != null) {
                        e.this.guE.bQL();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.guF.get(i);
        aVar.guK.setText(a(dVar));
        aVar.guK.setSelected(dVar.isChecked());
        aVar.guK.setBackgroundResource(dVar.bQV());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.guF = list;
            bQO();
            notifyDataSetChanged();
        }
    }

    public List<String> bQM() {
        ArrayList arrayList = new ArrayList();
        int size = this.guG.size();
        for (int i = 0; i < size; i++) {
            if (this.guG.valueAt(i) != null) {
                arrayList.add(this.guG.valueAt(i).bQU());
            }
        }
        return arrayList;
    }

    public Set<String> bQN() {
        return this.guH;
    }

    public void a(b bVar) {
        this.guE = bVar;
    }

    private void bQO() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.guF) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.uo(this.guG.keyAt(i2));
                    this.guG.put(dVar.bQV(), dVar);
                    this.guH.add(dVar.bQU());
                    i = i2 + 1;
                } else {
                    dVar.uo(a.e.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bQP = bQP();
            if (bQP == 0) {
                this.mPageContext.showToast(a.h.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.uo(bQP);
            this.guG.put(bQP, dVar);
        } else {
            dVar.setChecked(false);
            this.guG.put(dVar.bQV(), null);
            dVar.uo(a.e.bg_tag_unchecked);
        }
        aVar.guK.setSelected(dVar.isChecked());
        aVar.guK.setBackgroundResource(dVar.bQV());
    }

    private int bQP() {
        if (this.guG.valueAt(0) == null) {
            return this.guG.keyAt(0);
        }
        if (this.guG.valueAt(1) == null) {
            return this.guG.keyAt(1);
        }
        if (this.guG.valueAt(2) == null) {
            return this.guG.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bQU();
        }
        return dVar.bQU() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView guK;

        private a() {
        }
    }
}
