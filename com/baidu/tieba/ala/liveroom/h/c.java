package com.baidu.tieba.ala.liveroom.h;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private ViewGroup ggj;
    private b hgr;
    public final a[] hgq = {new a(a.e.img_live_filter_ziran, "delta", "自然"), new a(a.e.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.e.img_live_filter_rouguang, "pink", "柔光"), new a(a.e.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.e.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int ggl = -1;
    private int gfV = 0;
    private ArrayList<Boolean> ggk = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.ggj = viewGroup;
        bOo();
    }

    private void bOo() {
        if (this.ggk != null) {
            this.ggk.clear();
            this.ggk.addAll(Arrays.asList(new Boolean[this.hgq.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vA(int i) {
        if (i >= 0) {
            this.ggk.set(i, true);
            this.ggl = i;
            if (this.hgr != null) {
                this.hgr.onItemSelected(i);
            }
        }
    }

    public void HW(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.hgq.length; i++) {
                if (str.equals(this.hgq[i].mFilterName)) {
                    vA(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hgr = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hgq.length;
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
        C0676c c0676c;
        if (view == null) {
            C0676c c0676c2 = new C0676c();
            c0676c2.hgt = new AlaLiveMultiBeautyFilterItemView(this.ggj.getContext());
            c0676c2.hgt.setTag(c0676c2);
            c0676c = c0676c2;
        } else {
            c0676c = (C0676c) view.getTag();
        }
        if (this.ggk.get(i) == null || !this.ggk.get(i).booleanValue()) {
            c0676c.hgt.setUnselectedBackground();
        } else {
            c0676c.hgt.setSelectedBackground();
        }
        c0676c.hgt.setItemIcon(this.hgq[i % this.hgq.length].mDrawableId);
        c0676c.hgt.setItemText(this.hgq[i % this.hgq.length].mShowName);
        c0676c.hgt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ggl != i) {
                    View childAt = c.this.ggj.getChildAt(c.this.ggl);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.ggl >= 0) {
                        c.this.ggk.set(c.this.ggl, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0676c) view2.getTag()).hgt.setSelectedBackground();
                }
                c.this.vA(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gfV != 0) {
            c0676c.hgt.setPadding(this.gfV, 0, 0, 0);
        } else {
            c0676c.hgt.setPadding(0, 0, 0, 0);
        }
        return c0676c.hgt;
    }

    public void tI(int i) {
        this.gfV = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0676c {
        AlaLiveMultiBeautyFilterItemView hgt;

        C0676c() {
        }
    }

    /* loaded from: classes4.dex */
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
