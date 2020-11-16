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
    private b gul;
    private List<com.baidu.tieba.ala.category.b.d> gum;
    private SparseArray<com.baidu.tieba.ala.category.b.d> gun = new SparseArray<>(3);
    private Set<String> guo;
    private final TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void bQe();
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gun.put(a.e.bg_tag_checked1, null);
        this.gun.put(a.e.bg_tag_checked2, null);
        this.gun.put(a.e.bg_tag_checked3, null);
        this.guo = new HashSet();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gum);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public IAdapterData getItem(int i) {
        return (IAdapterData) ListUtils.getItem(this.gum, i);
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
            aVar.gur = (TextView) view.findViewById(a.f.ala_live_tag_name_tv);
            aVar.gur.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.a((com.baidu.tieba.ala.category.b.d) e.this.gum.get(i), aVar);
                    if (e.this.gul != null) {
                        e.this.gul.bQe();
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.category.b.d dVar = this.gum.get(i);
        aVar.gur.setText(a(dVar));
        aVar.gur.setSelected(dVar.isChecked());
        aVar.gur.setBackgroundResource(dVar.bQo());
        return view;
    }

    public void setTagList(List<com.baidu.tieba.ala.category.b.d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gum = list;
            bQh();
            notifyDataSetChanged();
        }
    }

    public List<String> bQf() {
        ArrayList arrayList = new ArrayList();
        int size = this.gun.size();
        for (int i = 0; i < size; i++) {
            if (this.gun.valueAt(i) != null) {
                arrayList.add(this.gun.valueAt(i).bQn());
            }
        }
        return arrayList;
    }

    public Set<String> bQg() {
        return this.guo;
    }

    public void a(b bVar) {
        this.gul = bVar;
    }

    private void bQh() {
        int i;
        int i2 = 0;
        for (com.baidu.tieba.ala.category.b.d dVar : this.gum) {
            if (dVar != null) {
                if (dVar.isChecked() && i2 < 3) {
                    dVar.uM(this.gun.keyAt(i2));
                    this.gun.put(dVar.bQo(), dVar);
                    this.guo.add(dVar.bQn());
                    i = i2 + 1;
                } else {
                    dVar.uM(a.e.bg_tag_unchecked);
                    i = i2;
                }
                i2 = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.d dVar, a aVar) {
        if (!dVar.isChecked()) {
            int bQi = bQi();
            if (bQi == 0) {
                this.mPageContext.showToast(a.h.ala_live_tag_warning, true);
                return;
            }
            dVar.setChecked(true);
            dVar.uM(bQi);
            this.gun.put(bQi, dVar);
        } else {
            dVar.setChecked(false);
            this.gun.put(dVar.bQo(), null);
            dVar.uM(a.e.bg_tag_unchecked);
        }
        aVar.gur.setSelected(dVar.isChecked());
        aVar.gur.setBackgroundResource(dVar.bQo());
    }

    private int bQi() {
        if (this.gun.valueAt(0) == null) {
            return this.gun.keyAt(0);
        }
        if (this.gun.valueAt(1) == null) {
            return this.gun.keyAt(1);
        }
        if (this.gun.valueAt(2) == null) {
            return this.gun.keyAt(2);
        }
        return 0;
    }

    private String a(com.baidu.tieba.ala.category.b.d dVar) {
        if (dVar == null) {
            return "";
        }
        if (dVar.getScore() <= 0) {
            return dVar.bQn();
        }
        return dVar.bQn() + " " + (dVar.getScore() > 999 ? "999+" : String.valueOf(dVar.getScore()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        private TextView gur;

        private a() {
        }
    }
}
