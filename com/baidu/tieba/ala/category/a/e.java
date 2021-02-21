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
/* loaded from: classes11.dex */
public class e extends BaseAdapter {
    private b gMW;
    private List<com.baidu.tieba.ala.category.b.d> gMX;
    private SparseArray<com.baidu.tieba.ala.category.b.d> gMY = new SparseArray<>(3);
    private Set<String> gMZ;
    private final TbPageContext mPageContext;

    /* loaded from: classes11.dex */
    public interface b {
        void bTn();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gMY.put(a.e.bg_tag_checked1, null);
        this.gMY.put(a.e.bg_tag_checked2, null);
        this.gMY.put(a.e.bg_tag_checked3, null);
        this.gMZ = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gMX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.gMX, i);
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
            aVar.gNc = (TextView) view.findViewById(a.f.ala_live_tag_name_tv);
            aVar.gNc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.gMX.get(i), aVar);
                    if (e.this.gMW != null) {
                        e.this.gMW.bTn();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.gMX.get(i);
        aVar.gNc.setText(a(dVar));
        aVar.gNc.setSelected(dVar.isChecked());
        aVar.gNc.setBackgroundResource(dVar.bTx());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gMX = list;
            bTq();
            notifyDataSetChanged();
        }
    }

    public List<String> bTo() {
        ArrayList arrayList = new ArrayList();
        int size = this.gMY.size();
        for (int i = 0; i < size; i++) {
            if (this.gMY.valueAt(i) != null) {
                arrayList.add(this.gMY.valueAt(i).bTw());
            }
        }
        return arrayList;
    }

    public Set<String> bTp() {
        return this.gMZ;
    }

    public void a(b bVar) {
        this.gMW = bVar;
    }

    private void bTq() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.gMX) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.ue(this.gMY.keyAt(i2));
                    this.gMY.put(dVar.bTx(), dVar);
                    this.gMZ.add(dVar.bTw());
                    i = i2 + 1;
                } else {
                    dVar.ue(a.e.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bTr = bTr();
            if (bTr == 0) {
                this.mPageContext.showToast(a.h.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.ue(bTr);
            this.gMY.put(bTr, dVar);
        } else {
            dVar.setChecked(false);
            this.gMY.put(dVar.bTx(), null);
            dVar.ue(a.e.bg_tag_unchecked);
        }
        aVar.gNc.setSelected(dVar.isChecked());
        aVar.gNc.setBackgroundResource(dVar.bTx());
    }

    private int bTr() {
        if (this.gMY.valueAt(0) == null) {
            return this.gMY.keyAt(0);
        }
        if (this.gMY.valueAt(1) == null) {
            return this.gMY.keyAt(1);
        }
        if (this.gMY.valueAt(2) == null) {
            return this.gMY.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bTw();
        }
        return dVar.bTw() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private TextView gNc;

        private a() {
        }
    }
}
