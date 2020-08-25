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
/* loaded from: classes7.dex */
public class c extends BaseAdapter {
    private ViewGroup fBF;
    private a fCa;
    public List<com.baidu.live.ar.e> azB = new ArrayList();
    private int fzN = -1;
    private int fzO = -1;
    private int fBH = 0;

    /* loaded from: classes7.dex */
    public interface a {
        void b(int i, int[] iArr);
    }

    public c(ViewGroup viewGroup) {
        this.fBF = viewGroup;
    }

    public void a(a aVar) {
        this.fCa = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.azB == null) {
            return 0;
        }
        return this.azB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sy */
    public com.baidu.live.ar.e getItem(int i) {
        return (com.baidu.live.ar.e) ListUtils.getItem(this.azB, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(List<com.baidu.live.ar.e> list, int i) {
        if (!ListUtils.isEmpty(list)) {
            this.azB.clear();
            this.azB.addAll(list);
            this.fzN = i;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.e> getDatas() {
        return this.azB;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final d dVar;
        if (view == null) {
            view = LayoutInflater.from(this.fBF.getContext()).inflate(a.h.face_feature_ar_item_layout, (ViewGroup) null);
            dVar = new d(view);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (dVar != null && dVar.mRootView != null) {
                    dVar.mRootView.getLocationOnScreen(iArr);
                }
                c.this.a(c.this.getItem(i), i, dVar, iArr);
            }
        });
        if (dVar != null) {
            dVar.a(getItem(i));
            if (this.fzN == i) {
                dVar.bFo();
            } else {
                dVar.bFn();
            }
        }
        if (i == 0 && this.fBH != 0) {
            view.setPadding(this.fBH, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.e eVar, int i, d dVar, int[] iArr) {
        if (eVar != null) {
            this.fzO = i;
            if (this.fCa != null) {
                this.fCa.b(i, iArr);
            }
            this.fzN = i;
            if (com.baidu.live.c.AD().getInt("beauty_subitem_redot", 0) == 1) {
                com.baidu.live.c.AD().putBoolean(eVar.getType(), false);
            }
            notifyDataSetChanged();
        }
    }

    public int Ew(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        for (int i = 0; i < this.azB.size(); i++) {
            if (TextUtils.equals(str, this.azB.get(i).getType())) {
                return i;
            }
        }
        return 0;
    }

    public String Ex(String str) {
        int i = 0;
        if (TextUtils.equals(str, "goddessFace")) {
            i = 1;
        } else if (TextUtils.equals(str, "babyFace")) {
            i = 2;
        }
        return com.baidu.minivideo.arface.c.fK(i);
    }

    public void sx(int i) {
        this.fBH = i;
    }
}
