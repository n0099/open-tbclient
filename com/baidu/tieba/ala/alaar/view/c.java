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
public class c extends BaseAdapter {
    private ViewGroup fRe;
    private a fRz;
    public List<com.baidu.live.ar.e> aDo = new ArrayList();
    private int fPm = -1;
    private int fPn = -1;
    private int fRg = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, int[] iArr);
    }

    public c(ViewGroup viewGroup) {
        this.fRe = viewGroup;
    }

    public void a(a aVar) {
        this.fRz = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDo == null) {
            return 0;
        }
        return this.aDo.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: to */
    public com.baidu.live.ar.e getItem(int i) {
        return (com.baidu.live.ar.e) ListUtils.getItem(this.aDo, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(List<com.baidu.live.ar.e> list, int i) {
        if (!ListUtils.isEmpty(list)) {
            this.aDo.clear();
            this.aDo.addAll(list);
            this.fPm = i;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.e> getDatas() {
        return this.aDo;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final d dVar;
        if (view == null) {
            view = LayoutInflater.from(this.fRe.getContext()).inflate(a.h.face_feature_ar_item_layout, (ViewGroup) null);
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
            if (this.fPm == i) {
                dVar.bJr();
            } else {
                dVar.bJq();
            }
        }
        if (i == 0 && this.fRg != 0) {
            view.setPadding(this.fRg, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.e eVar, int i, d dVar, int[] iArr) {
        if (eVar != null) {
            this.fPn = i;
            if (this.fRz != null) {
                this.fRz.b(i, iArr);
            }
            this.fPm = i;
            if (com.baidu.live.c.AZ().getInt("beauty_subitem_redot", 0) == 1) {
                com.baidu.live.c.AZ().putBoolean(eVar.getType(), false);
            }
            notifyDataSetChanged();
        }
    }

    public int FG(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        for (int i = 0; i < this.aDo.size(); i++) {
            if (TextUtils.equals(str, this.aDo.get(i).getType())) {
                return i;
            }
        }
        return 0;
    }

    public String FH(String str) {
        int i = 0;
        if (TextUtils.equals(str, "goddessFace")) {
            i = 1;
        } else if (TextUtils.equals(str, "babyFace")) {
            i = 2;
        }
        return com.baidu.minivideo.arface.c.gm(i);
    }

    public void tn(int i) {
        this.fRg = i;
    }
}
