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
    private b goR;
    private List<com.baidu.tieba.ala.category.b.d> goS;
    private SparseArray<com.baidu.tieba.ala.category.b.d> goT = new SparseArray<>(3);
    private Set<String> goU;
    private final TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void bOl();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.goT.put(a.f.bg_tag_checked1, null);
        this.goT.put(a.f.bg_tag_checked2, null);
        this.goT.put(a.f.bg_tag_checked3, null);
        this.goU = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.goS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.goS, i);
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
            aVar.goX = (TextView) view.findViewById(a.g.ala_live_tag_name_tv);
            aVar.goX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.goS.get(i), aVar);
                    if (e.this.goR != null) {
                        e.this.goR.bOl();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.goS.get(i);
        aVar.goX.setText(a(dVar));
        aVar.goX.setSelected(dVar.isChecked());
        aVar.goX.setBackgroundResource(dVar.bOv());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.goS = list;
            bOo();
            notifyDataSetChanged();
        }
    }

    public List<String> bOm() {
        ArrayList arrayList = new ArrayList();
        int size = this.goT.size();
        for (int i = 0; i < size; i++) {
            if (this.goT.valueAt(i) != null) {
                arrayList.add(this.goT.valueAt(i).bOu());
            }
        }
        return arrayList;
    }

    public Set<String> bOn() {
        return this.goU;
    }

    public void a(b bVar) {
        this.goR = bVar;
    }

    private void bOo() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.goS) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.ue(this.goT.keyAt(i2));
                    this.goT.put(dVar.bOv(), dVar);
                    this.goU.add(dVar.bOu());
                    i = i2 + 1;
                } else {
                    dVar.ue(a.f.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bOp = bOp();
            if (bOp == 0) {
                this.mPageContext.showToast(a.i.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.ue(bOp);
            this.goT.put(bOp, dVar);
        } else {
            dVar.setChecked(false);
            this.goT.put(dVar.bOv(), null);
            dVar.ue(a.f.bg_tag_unchecked);
        }
        aVar.goX.setSelected(dVar.isChecked());
        aVar.goX.setBackgroundResource(dVar.bOv());
    }

    private int bOp() {
        if (this.goT.valueAt(0) == null) {
            return this.goT.keyAt(0);
        }
        if (this.goT.valueAt(1) == null) {
            return this.goT.keyAt(1);
        }
        if (this.goT.valueAt(2) == null) {
            return this.goT.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bOu();
        }
        return dVar.bOu() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView goX;

        private a() {
        }
    }
}
