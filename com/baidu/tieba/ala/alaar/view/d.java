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
/* loaded from: classes10.dex */
public class d extends BaseAdapter {
    public List<com.baidu.live.ar.h> aAz = new ArrayList();
    private int gsf = -1;
    private int gsg = -1;
    private int gtC = 0;
    private ViewGroup gtQ;
    private a gtZ;

    /* loaded from: classes10.dex */
    public interface a {
        void i(int i, View view, boolean z);
    }

    public d(ViewGroup viewGroup) {
        this.gtQ = viewGroup;
    }

    public void a(a aVar) {
        this.gtZ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAz == null) {
            return 0;
        }
        return this.aAz.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ts */
    public com.baidu.live.ar.h getItem(int i) {
        return (com.baidu.live.ar.h) ListUtils.getItem(this.aAz, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(List<com.baidu.live.ar.h> list, int i) {
        if (!ListUtils.isEmpty(list)) {
            this.aAz.clear();
            this.aAz.addAll(list);
            this.gsf = i;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.h> getDatas() {
        return this.aAz;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final e eVar;
        if (view == null) {
            view = LayoutInflater.from(this.gtQ.getContext()).inflate(a.g.face_feature_ar_item_layout, (ViewGroup) null);
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
            if (this.gsf == i) {
                eVar.bQd();
            } else {
                eVar.bQc();
            }
        }
        if (i == 0 && this.gtC != 0) {
            view.setPadding(this.gtC, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.h hVar, int i, e eVar, int[] iArr, boolean z) {
        if (hVar != null) {
            this.gsg = i;
            if (this.gtZ != null) {
                this.gtZ.i(i, eVar.mRootView, z);
            }
            this.gsf = i;
            if (com.baidu.live.d.xf().getInt("beauty_subitem_redot", 0) == 1) {
                com.baidu.live.d.xf().putBoolean(hVar.getType(), false);
            }
            notifyDataSetChanged();
        }
    }

    public int i(List<com.baidu.live.ar.h> list, String str) {
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

    public String Fv(String str) {
        int i = 0;
        if (TextUtils.equals(str, "goddessFace")) {
            i = 1;
        } else if (TextUtils.equals(str, "babyFace")) {
            i = 2;
        }
        return com.baidu.minivideo.arface.c.fu(i);
    }

    public void tq(int i) {
        this.gtC = i;
    }
}
