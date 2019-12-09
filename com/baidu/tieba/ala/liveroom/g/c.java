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
    private ViewGroup eet;
    private b eew;
    public final a[] ees = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int eev = -1;
    private int eex = 0;
    private ArrayList<Boolean> eeu = new ArrayList<>();

    /* loaded from: classes6.dex */
    public interface b {
        void lh(int i);
    }

    public c(ViewGroup viewGroup) {
        this.eet = viewGroup;
        aRx();
    }

    private void aRx() {
        if (this.eeu != null) {
            this.eeu.clear();
            this.eeu.addAll(Arrays.asList(new Boolean[this.ees.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu(int i) {
        if (i >= 0) {
            this.eeu.set(i, true);
            this.eev = i;
            if (this.eew != null) {
                this.eew.lh(i);
            }
        }
    }

    public void tG(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.ees.length; i++) {
                if (str.equals(this.ees[i].mFilterName)) {
                    nu(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.eew = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ees.length;
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
        C0356c c0356c;
        if (view == null) {
            C0356c c0356c2 = new C0356c();
            c0356c2.eeA = new AlaLiveMultiBeautyFilterItemView(this.eet.getContext());
            c0356c2.eeA.setTag(c0356c2);
            c0356c = c0356c2;
        } else {
            c0356c = (C0356c) view.getTag();
        }
        if (this.eeu.get(i) == null || !this.eeu.get(i).booleanValue()) {
            c0356c.eeA.setUnselectedBackground();
        } else {
            c0356c.eeA.setSelectedBackground();
        }
        c0356c.eeA.setItemIcon(this.ees[i % this.ees.length].coA);
        c0356c.eeA.setItemText(this.ees[i % this.ees.length].eez);
        c0356c.eeA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eev != i) {
                    View childAt = c.this.eet.getChildAt(c.this.eev);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.eev >= 0) {
                        c.this.eeu.set(c.this.eev, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0356c) view2.getTag()).eeA.setSelectedBackground();
                }
                c.this.nu(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eex != 0) {
            c0356c.eeA.setPadding(this.eex, 0, 0, 0);
        } else {
            c0356c.eeA.setPadding(0, 0, 0, 0);
        }
        return c0356c.eeA;
    }

    public void nv(int i) {
        this.eex = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0356c {
        AlaLiveMultiBeautyFilterItemView eeA;

        C0356c() {
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public int coA;
        public String eez;
        public String mFilterName;

        public a(int i, String str, String str2) {
            this.coA = i;
            this.mFilterName = str;
            this.eez = str2;
        }
    }
}
