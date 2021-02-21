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
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    public List<com.baidu.live.ar.h> aCe = new ArrayList();
    private int gvd = -1;
    private int gve = -1;
    private int gwA = 0;
    private ViewGroup gwO;
    private a gwX;

    /* loaded from: classes11.dex */
    public interface a {
        void i(int i, View view, boolean z);
    }

    public d(ViewGroup viewGroup) {
        this.gwO = viewGroup;
    }

    public void a(a aVar) {
        this.gwX = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aCe == null) {
            return 0;
        }
        return this.aCe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ty */
    public com.baidu.live.ar.h getItem(int i) {
        return (com.baidu.live.ar.h) ListUtils.getItem(this.aCe, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(List<com.baidu.live.ar.h> list, int i) {
        if (!ListUtils.isEmpty(list)) {
            this.aCe.clear();
            this.aCe.addAll(list);
            this.gvd = i;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.h> getDatas() {
        return this.aCe;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final e eVar;
        if (view == null) {
            view = LayoutInflater.from(this.gwO.getContext()).inflate(a.g.face_feature_ar_item_layout, (ViewGroup) null);
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
            if (this.gvd == i) {
                eVar.bQO();
            } else {
                eVar.bQN();
            }
        }
        if (i == 0 && this.gwA != 0) {
            view.setPadding(this.gwA, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.h hVar, int i, e eVar, int[] iArr, boolean z) {
        if (hVar != null) {
            this.gve = i;
            if (this.gwX != null) {
                this.gwX.i(i, eVar.mRootView, z);
            }
            this.gvd = i;
            if (com.baidu.live.d.xc().getInt("beauty_subitem_redot", 0) == 1) {
                com.baidu.live.d.xc().putBoolean(hVar.getType(), false);
            }
            notifyDataSetChanged();
        }
    }

    public int h(List<com.baidu.live.ar.h> list, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            if (TextUtils.equals(str, list.get(i).getType())) {
                return i;
            }
        }
        return 0;
    }

    public String FU(String str) {
        int i = 0;
        if (TextUtils.equals(str, "goddessFace")) {
            i = 1;
        } else if (TextUtils.equals(str, "babyFace")) {
            i = 2;
        }
        return com.baidu.minivideo.arface.c.fA(i);
    }

    public void tw(int i) {
        this.gwA = i;
    }
}
