package com.baidu.tieba.ala.alaar.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    public List<com.baidu.live.ar.g> aCo = new ArrayList();
    private int ged = -1;
    private int gee = -1;
    private int gfC = 0;
    private ViewGroup gfQ;
    private a gfY;

    /* loaded from: classes4.dex */
    public interface a {
        void i(int i, View view, boolean z);
    }

    public d(ViewGroup viewGroup) {
        this.gfQ = viewGroup;
    }

    public void a(a aVar) {
        this.gfY = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aCo == null) {
            return 0;
        }
        return this.aCo.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ui */
    public com.baidu.live.ar.g getItem(int i) {
        return (com.baidu.live.ar.g) ListUtils.getItem(this.aCo, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(List<com.baidu.live.ar.g> list, int i) {
        if (!ListUtils.isEmpty(list)) {
            this.aCo.clear();
            this.aCo.addAll(list);
            this.ged = i;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.g> getDatas() {
        return this.aCo;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final e eVar;
        if (view == null) {
            view = LayoutInflater.from(this.gfQ.getContext()).inflate(a.g.face_feature_ar_item_layout, (ViewGroup) null);
            eVar = new e(view);
            view.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (eVar != null && eVar.mRootView != null) {
                    eVar.mRootView.getLocationOnScreen(iArr);
                }
                d.this.a(d.this.getItem(i), i, eVar, iArr, true);
            }
        });
        if (eVar != null) {
            eVar.a(getItem(i));
            if (this.ged == i) {
                eVar.bNK();
            } else {
                eVar.bNJ();
            }
        }
        if (i == 0 && this.gfC != 0) {
            view.setPadding(this.gfC, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.g gVar, int i, e eVar, int[] iArr, boolean z) {
        if (gVar != null) {
            this.gee = i;
            if (this.gfY != null) {
                this.gfY.i(i, eVar.mRootView, z);
            }
            this.ged = i;
            if (com.baidu.live.d.Aq().getInt("beauty_subitem_redot", 0) == 1) {
                com.baidu.live.d.Aq().putBoolean(gVar.getType(), false);
            }
            notifyDataSetChanged();
        }
    }

    public int FU(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        for (int i = 0; i < this.aCo.size(); i++) {
            if (TextUtils.equals(str, this.aCo.get(i).getType())) {
                return i;
            }
        }
        return 0;
    }

    public String FV(String str) {
        int i = 0;
        if (TextUtils.equals(str, "goddessFace")) {
            i = 1;
        } else if (TextUtils.equals(str, "babyFace")) {
            i = 2;
        }
        return com.baidu.minivideo.arface.c.gE(i);
    }

    public void ug(int i) {
        this.gfC = i;
    }
}
