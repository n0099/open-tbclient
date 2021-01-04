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
    private b gOI;
    private List<com.baidu.tieba.ala.category.b.d> gOJ;
    private SparseArray<com.baidu.tieba.ala.category.b.d> gOK = new SparseArray<>(3);
    private Set<String> gOL;
    private final TbPageContext mPageContext;

    /* loaded from: classes11.dex */
    public interface b {
        void bWu();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gOK.put(a.e.bg_tag_checked1, null);
        this.gOK.put(a.e.bg_tag_checked2, null);
        this.gOK.put(a.e.bg_tag_checked3, null);
        this.gOL = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gOJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.gOJ, i);
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
            aVar.gOO = (TextView) view.findViewById(a.f.ala_live_tag_name_tv);
            aVar.gOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.gOJ.get(i), aVar);
                    if (e.this.gOI != null) {
                        e.this.gOI.bWu();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.gOJ.get(i);
        aVar.gOO.setText(a(dVar));
        aVar.gOO.setSelected(dVar.isChecked());
        aVar.gOO.setBackgroundResource(dVar.bWE());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gOJ = list;
            bWx();
            notifyDataSetChanged();
        }
    }

    public List<String> bWv() {
        ArrayList arrayList = new ArrayList();
        int size = this.gOK.size();
        for (int i = 0; i < size; i++) {
            if (this.gOK.valueAt(i) != null) {
                arrayList.add(this.gOK.valueAt(i).bWD());
            }
        }
        return arrayList;
    }

    public Set<String> bWw() {
        return this.gOL;
    }

    public void a(b bVar) {
        this.gOI = bVar;
    }

    private void bWx() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.gOJ) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.vE(this.gOK.keyAt(i2));
                    this.gOK.put(dVar.bWE(), dVar);
                    this.gOL.add(dVar.bWD());
                    i = i2 + 1;
                } else {
                    dVar.vE(a.e.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bWy = bWy();
            if (bWy == 0) {
                this.mPageContext.showToast(a.h.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.vE(bWy);
            this.gOK.put(bWy, dVar);
        } else {
            dVar.setChecked(false);
            this.gOK.put(dVar.bWE(), null);
            dVar.vE(a.e.bg_tag_unchecked);
        }
        aVar.gOO.setSelected(dVar.isChecked());
        aVar.gOO.setBackgroundResource(dVar.bWE());
    }

    private int bWy() {
        if (this.gOK.valueAt(0) == null) {
            return this.gOK.keyAt(0);
        }
        if (this.gOK.valueAt(1) == null) {
            return this.gOK.keyAt(1);
        }
        if (this.gOK.valueAt(2) == null) {
            return this.gOK.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bWD();
        }
        return dVar.bWD() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private TextView gOO;

        private a() {
        }
    }
}
