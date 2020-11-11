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
    public List<com.baidu.live.ar.g> aDZ = new ArrayList();
    private int gex = -1;
    private int gey = -1;
    private int gfV = 0;
    private ViewGroup ggj;
    private a ggr;

    /* loaded from: classes4.dex */
    public interface a {
        void i(int i, View view, boolean z);
    }

    public d(ViewGroup viewGroup) {
        this.ggj = viewGroup;
    }

    public void a(a aVar) {
        this.ggr = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDZ == null) {
            return 0;
        }
        return this.aDZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tK */
    public com.baidu.live.ar.g getItem(int i) {
        return (com.baidu.live.ar.g) ListUtils.getItem(this.aDZ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(List<com.baidu.live.ar.g> list, int i) {
        if (!ListUtils.isEmpty(list)) {
            this.aDZ.clear();
            this.aDZ.addAll(list);
            this.gex = i;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.g> getDatas() {
        return this.aDZ;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final e eVar;
        if (view == null) {
            view = LayoutInflater.from(this.ggj.getContext()).inflate(a.g.face_feature_ar_item_layout, (ViewGroup) null);
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
            if (this.gex == i) {
                eVar.bOr();
            } else {
                eVar.bOq();
            }
        }
        if (i == 0 && this.gfV != 0) {
            view.setPadding(this.gfV, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.g gVar, int i, e eVar, int[] iArr, boolean z) {
        if (gVar != null) {
            this.gey = i;
            if (this.ggr != null) {
                this.ggr.i(i, eVar.mRootView, z);
            }
            this.gex = i;
            if (com.baidu.live.d.AZ().getInt("beauty_subitem_redot", 0) == 1) {
                com.baidu.live.d.AZ().putBoolean(gVar.getType(), false);
            }
            notifyDataSetChanged();
        }
    }

    public int Gt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        for (int i = 0; i < this.aDZ.size(); i++) {
            if (TextUtils.equals(str, this.aDZ.get(i).getType())) {
                return i;
            }
        }
        return 0;
    }

    public String Gu(String str) {
        int i = 0;
        if (TextUtils.equals(str, "goddessFace")) {
            i = 1;
        } else if (TextUtils.equals(str, "babyFace")) {
            i = 2;
        }
        return com.baidu.minivideo.arface.c.gI(i);
    }

    public void tI(int i) {
        this.gfV = i;
    }
}
