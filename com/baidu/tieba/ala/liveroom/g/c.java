package com.baidu.tieba.ala.liveroom.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.k.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private ViewGroup efk;
    private b efn;
    public final a[] efj = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int efm = -1;
    private int efo = 0;
    private ArrayList<Boolean> efl = new ArrayList<>();

    /* loaded from: classes6.dex */
    public interface b {
        void li(int i);
    }

    public c(ViewGroup viewGroup) {
        this.efk = viewGroup;
        aRz();
    }

    private void aRz() {
        if (this.efl != null) {
            this.efl.clear();
            this.efl.addAll(Arrays.asList(new Boolean[this.efj.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(int i) {
        if (i >= 0) {
            this.efl.set(i, true);
            this.efm = i;
            if (this.efn != null) {
                this.efn.li(i);
            }
        }
    }

    public void tG(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.efj.length; i++) {
                if (str.equals(this.efj[i].mFilterName)) {
                    nv(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.efn = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.efj.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0361c c0361c;
        if (view == null) {
            C0361c c0361c2 = new C0361c();
            c0361c2.efr = new AlaLiveMultiBeautyFilterItemView(this.efk.getContext());
            c0361c2.efr.setTag(c0361c2);
            c0361c = c0361c2;
        } else {
            c0361c = (C0361c) view.getTag();
        }
        if (this.efl.get(i) == null || !this.efl.get(i).booleanValue()) {
            c0361c.efr.setUnselectedBackground();
        } else {
            c0361c.efr.setSelectedBackground();
        }
        c0361c.efr.setItemIcon(this.efj[i % this.efj.length].cpr);
        c0361c.efr.setItemText(this.efj[i % this.efj.length].efq);
        c0361c.efr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.efm != i) {
                    View childAt = c.this.efk.getChildAt(c.this.efm);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.efm >= 0) {
                        c.this.efl.set(c.this.efm, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0361c) view2.getTag()).efr.setSelectedBackground();
                }
                c.this.nv(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.efo != 0) {
            c0361c.efr.setPadding(this.efo, 0, 0, 0);
        } else {
            c0361c.efr.setPadding(0, 0, 0, 0);
        }
        return c0361c.efr;
    }

    public void nw(int i) {
        this.efo = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0361c {
        AlaLiveMultiBeautyFilterItemView efr;

        C0361c() {
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public int cpr;
        public String efq;
        public String mFilterName;

        public a(int i, String str, String str2) {
            this.cpr = i;
            this.mFilterName = str;
            this.efq = str2;
        }
    }
}
