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
    private b gMI;
    private List<com.baidu.tieba.ala.category.b.d> gMJ;
    private SparseArray<com.baidu.tieba.ala.category.b.d> gMK = new SparseArray<>(3);
    private Set<String> gML;
    private final TbPageContext mPageContext;

    /* loaded from: classes11.dex */
    public interface b {
        void bTg();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gMK.put(a.e.bg_tag_checked1, null);
        this.gMK.put(a.e.bg_tag_checked2, null);
        this.gMK.put(a.e.bg_tag_checked3, null);
        this.gML = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gMJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.gMJ, i);
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
            aVar.gMO = (TextView) view.findViewById(a.f.ala_live_tag_name_tv);
            aVar.gMO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.gMJ.get(i), aVar);
                    if (e.this.gMI != null) {
                        e.this.gMI.bTg();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.gMJ.get(i);
        aVar.gMO.setText(a(dVar));
        aVar.gMO.setSelected(dVar.isChecked());
        aVar.gMO.setBackgroundResource(dVar.bTq());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gMJ = list;
            bTj();
            notifyDataSetChanged();
        }
    }

    public List<String> bTh() {
        ArrayList arrayList = new ArrayList();
        int size = this.gMK.size();
        for (int i = 0; i < size; i++) {
            if (this.gMK.valueAt(i) != null) {
                arrayList.add(this.gMK.valueAt(i).bTp());
            }
        }
        return arrayList;
    }

    public Set<String> bTi() {
        return this.gML;
    }

    public void a(b bVar) {
        this.gMI = bVar;
    }

    private void bTj() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.gMJ) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.ue(this.gMK.keyAt(i2));
                    this.gMK.put(dVar.bTq(), dVar);
                    this.gML.add(dVar.bTp());
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
            int bTk = bTk();
            if (bTk == 0) {
                this.mPageContext.showToast(a.h.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.ue(bTk);
            this.gMK.put(bTk, dVar);
        } else {
            dVar.setChecked(false);
            this.gMK.put(dVar.bTq(), null);
            dVar.ue(a.e.bg_tag_unchecked);
        }
        aVar.gMO.setSelected(dVar.isChecked());
        aVar.gMO.setBackgroundResource(dVar.bTq());
    }

    private int bTk() {
        if (this.gMK.valueAt(0) == null) {
            return this.gMK.keyAt(0);
        }
        if (this.gMK.valueAt(1) == null) {
            return this.gMK.keyAt(1);
        }
        if (this.gMK.valueAt(2) == null) {
            return this.gMK.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bTp();
        }
        return dVar.bTp() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private TextView gMO;

        private a() {
        }
    }
}
