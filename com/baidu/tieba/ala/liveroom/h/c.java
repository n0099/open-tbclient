package com.baidu.tieba.ala.liveroom.h;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.r.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private ViewGroup eWb;
    private b eWe;
    public final a[] eWa = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int eWd = -1;
    private int eWf = 0;
    private ArrayList<Boolean> eWc = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.eWb = viewGroup;
        bjK();
    }

    private void bjK() {
        if (this.eWc != null) {
            this.eWc.clear();
            this.eWc.addAll(Arrays.asList(new Boolean[this.eWa.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pN(int i) {
        if (i >= 0) {
            this.eWc.set(i, true);
            this.eWd = i;
            if (this.eWe != null) {
                this.eWe.onItemSelected(i);
            }
        }
    }

    public void yz(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.eWa.length; i++) {
                if (str.equals(this.eWa[i].mFilterName)) {
                    pN(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.eWe = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eWa.length;
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
        C0448c c0448c;
        if (view == null) {
            C0448c c0448c2 = new C0448c();
            c0448c2.eWh = new AlaLiveMultiBeautyFilterItemView(this.eWb.getContext());
            c0448c2.eWh.setTag(c0448c2);
            c0448c = c0448c2;
        } else {
            c0448c = (C0448c) view.getTag();
        }
        if (this.eWc.get(i) == null || !this.eWc.get(i).booleanValue()) {
            c0448c.eWh.setUnselectedBackground();
        } else {
            c0448c.eWh.setSelectedBackground();
        }
        c0448c.eWh.setItemIcon(this.eWa[i % this.eWa.length].mDrawableId);
        c0448c.eWh.setItemText(this.eWa[i % this.eWa.length].mShowName);
        c0448c.eWh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eWd != i) {
                    View childAt = c.this.eWb.getChildAt(c.this.eWd);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.eWd >= 0) {
                        c.this.eWc.set(c.this.eWd, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0448c) view2.getTag()).eWh.setSelectedBackground();
                }
                c.this.pN(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eWf != 0) {
            c0448c.eWh.setPadding(this.eWf, 0, 0, 0);
        } else {
            c0448c.eWh.setPadding(0, 0, 0, 0);
        }
        return c0448c.eWh;
    }

    public void pO(int i) {
        this.eWf = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0448c {
        AlaLiveMultiBeautyFilterItemView eWh;

        C0448c() {
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int mDrawableId;
        public String mFilterName;
        public String mShowName;

        public a(int i, String str, String str2) {
            this.mDrawableId = i;
            this.mFilterName = str;
            this.mShowName = str2;
        }
    }
}
