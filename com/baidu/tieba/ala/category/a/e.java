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
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private b fyI;
    private List<com.baidu.tieba.ala.category.b.d> fyJ;
    private SparseArray<com.baidu.tieba.ala.category.b.d> fyK = new SparseArray<>(3);
    private Set<String> fyL;
    private final TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface b {
        void bvD();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fyK.put(a.f.bg_tag_checked1, null);
        this.fyK.put(a.f.bg_tag_checked2, null);
        this.fyK.put(a.f.bg_tag_checked3, null);
        this.fyL = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fyJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.fyJ, i);
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
            aVar.fyO = (TextView) view.findViewById(a.g.ala_live_tag_name_tv);
            aVar.fyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.fyJ.get(i), aVar);
                    if (e.this.fyI != null) {
                        e.this.fyI.bvD();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.fyJ.get(i);
        aVar.fyO.setText(a(dVar));
        aVar.fyO.setSelected(dVar.isChecked());
        aVar.fyO.setBackgroundResource(dVar.bvN());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.fyJ = list;
            bvG();
            notifyDataSetChanged();
        }
    }

    public List<String> bvE() {
        ArrayList arrayList = new ArrayList();
        int size = this.fyK.size();
        for (int i = 0; i < size; i++) {
            if (this.fyK.valueAt(i) != null) {
                arrayList.add(this.fyK.valueAt(i).bvM());
            }
        }
        return arrayList;
    }

    public Set<String> bvF() {
        return this.fyL;
    }

    public void a(b bVar) {
        this.fyI = bVar;
    }

    private void bvG() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.fyJ) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.qu(this.fyK.keyAt(i2));
                    this.fyK.put(dVar.bvN(), dVar);
                    this.fyL.add(dVar.bvM());
                    i = i2 + 1;
                } else {
                    dVar.qu(a.f.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bvH = bvH();
            if (bvH == 0) {
                this.mPageContext.showToast(a.i.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.qu(bvH);
            this.fyK.put(bvH, dVar);
        } else {
            dVar.setChecked(false);
            this.fyK.put(dVar.bvN(), null);
            dVar.qu(a.f.bg_tag_unchecked);
        }
        aVar.fyO.setSelected(dVar.isChecked());
        aVar.fyO.setBackgroundResource(dVar.bvN());
    }

    private int bvH() {
        if (this.fyK.valueAt(0) == null) {
            return this.fyK.keyAt(0);
        }
        if (this.fyK.valueAt(1) == null) {
            return this.fyK.keyAt(1);
        }
        if (this.fyK.valueAt(2) == null) {
            return this.fyK.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bvM();
        }
        return dVar.bvM() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private TextView fyO;

        private a() {
        }
    }
}
