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
    private b gCW;
    private List<com.baidu.tieba.ala.category.b.d> gCX;
    private SparseArray<com.baidu.tieba.ala.category.b.d> gCY = new SparseArray<>(3);
    private Set<String> gCZ;
    private final TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void bTP();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gCY.put(a.e.bg_tag_checked1, null);
        this.gCY.put(a.e.bg_tag_checked2, null);
        this.gCY.put(a.e.bg_tag_checked3, null);
        this.gCZ = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gCX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.gCX, i);
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
            aVar.gDc = (TextView) view.findViewById(a.f.ala_live_tag_name_tv);
            aVar.gDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.gCX.get(i), aVar);
                    if (e.this.gCW != null) {
                        e.this.gCW.bTP();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.gCX.get(i);
        aVar.gDc.setText(a(dVar));
        aVar.gDc.setSelected(dVar.isChecked());
        aVar.gDc.setBackgroundResource(dVar.bTZ());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gCX = list;
            bTS();
            notifyDataSetChanged();
        }
    }

    public List<String> bTQ() {
        ArrayList arrayList = new ArrayList();
        int size = this.gCY.size();
        for (int i = 0; i < size; i++) {
            if (this.gCY.valueAt(i) != null) {
                arrayList.add(this.gCY.valueAt(i).bTY());
            }
        }
        return arrayList;
    }

    public Set<String> bTR() {
        return this.gCZ;
    }

    public void a(b bVar) {
        this.gCW = bVar;
    }

    private void bTS() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.gCX) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.vt(this.gCY.keyAt(i2));
                    this.gCY.put(dVar.bTZ(), dVar);
                    this.gCZ.add(dVar.bTY());
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
            int bTT = bTT();
            if (bTT == 0) {
                this.mPageContext.showToast(a.h.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.vt(bTT);
            this.gCY.put(bTT, dVar);
        } else {
            dVar.setChecked(false);
            this.gCY.put(dVar.bTZ(), null);
            dVar.vt(a.e.bg_tag_unchecked);
        }
        aVar.gDc.setSelected(dVar.isChecked());
        aVar.gDc.setBackgroundResource(dVar.bTZ());
    }

    private int bTT() {
        if (this.gCY.valueAt(0) == null) {
            return this.gCY.keyAt(0);
        }
        if (this.gCY.valueAt(1) == null) {
            return this.gCY.keyAt(1);
        }
        if (this.gCY.valueAt(2) == null) {
            return this.gCY.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bTY();
        }
        return dVar.bTY() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView gDc;

        private a() {
        }
    }
}
