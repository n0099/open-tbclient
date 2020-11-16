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
    private ViewGroup gfQ;
    private b hfY;
    public final a[] hfX = {new a(a.e.img_live_filter_ziran, "delta", "自然"), new a(a.e.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.e.img_live_filter_rouguang, "pink", "柔光"), new a(a.e.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.e.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int gfS = -1;
    private int gfC = 0;
    private ArrayList<Boolean> gfR = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.gfQ = viewGroup;
        bNH();
    }

    private void bNH() {
        if (this.gfR != null) {
            this.gfR.clear();
            this.gfR.addAll(Arrays.asList(new Boolean[this.hfX.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY(int i) {
        if (i >= 0) {
            this.gfR.set(i, true);
            this.gfS = i;
            if (this.hfY != null) {
                this.hfY.onItemSelected(i);
            }
        }
    }

    public void Hx(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.hfX.length; i++) {
                if (str.equals(this.hfX[i].mFilterName)) {
                    vY(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hfY = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hfX.length;
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
            c0676c2.hga = new AlaLiveMultiBeautyFilterItemView(this.gfQ.getContext());
            c0676c2.hga.setTag(c0676c2);
            c0676c = c0676c2;
        } else {
            c0676c = (C0676c) view.getTag();
        }
        if (this.gfR.get(i) == null || !this.gfR.get(i).booleanValue()) {
            c0676c.hga.setUnselectedBackground();
        } else {
            c0676c.hga.setSelectedBackground();
        }
        c0676c.hga.setItemIcon(this.hfX[i % this.hfX.length].mDrawableId);
        c0676c.hga.setItemText(this.hfX[i % this.hfX.length].mShowName);
        c0676c.hga.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gfS != i) {
                    View childAt = c.this.gfQ.getChildAt(c.this.gfS);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gfS >= 0) {
                        c.this.gfR.set(c.this.gfS, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0676c) view2.getTag()).hga.setSelectedBackground();
                }
                c.this.vY(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gfC != 0) {
            c0676c.hga.setPadding(this.gfC, 0, 0, 0);
        } else {
            c0676c.hga.setPadding(0, 0, 0, 0);
        }
        return c0676c.hga;
    }

    public void ug(int i) {
        this.gfC = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0676c {
        AlaLiveMultiBeautyFilterItemView hga;

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
