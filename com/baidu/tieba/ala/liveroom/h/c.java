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
    private ViewGroup fEV;
    private b gAi;
    public final a[] gAh = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int fFk = -1;
    private int fEX = 0;
    private ArrayList<Boolean> fFj = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.fEV = viewGroup;
        bGC();
    }

    private void bGC() {
        if (this.fFj != null) {
            this.fFj.clear();
            this.fFj.addAll(Arrays.asList(new Boolean[this.gAh.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo(int i) {
        if (i >= 0) {
            this.fFj.set(i, true);
            this.fFk = i;
            if (this.gAi != null) {
                this.gAi.onItemSelected(i);
            }
        }
    }

    public void EQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gAh.length; i++) {
                if (str.equals(this.gAh[i].mFilterName)) {
                    uo(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gAi = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gAh.length;
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
        C0628c c0628c;
        if (view == null) {
            C0628c c0628c2 = new C0628c();
            c0628c2.gAk = new AlaLiveMultiBeautyFilterItemView(this.fEV.getContext());
            c0628c2.gAk.setTag(c0628c2);
            c0628c = c0628c2;
        } else {
            c0628c = (C0628c) view.getTag();
        }
        if (this.fFj.get(i) == null || !this.fFj.get(i).booleanValue()) {
            c0628c.gAk.setUnselectedBackground();
        } else {
            c0628c.gAk.setSelectedBackground();
        }
        c0628c.gAk.setItemIcon(this.gAh[i % this.gAh.length].mDrawableId);
        c0628c.gAk.setItemText(this.gAh[i % this.gAh.length].mShowName);
        c0628c.gAk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fFk != i) {
                    View childAt = c.this.fEV.getChildAt(c.this.fFk);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.fFk >= 0) {
                        c.this.fFj.set(c.this.fFk, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0628c) view2.getTag()).gAk.setSelectedBackground();
                }
                c.this.uo(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fEX != 0) {
            c0628c.gAk.setPadding(this.fEX, 0, 0, 0);
        } else {
            c0628c.gAk.setPadding(0, 0, 0, 0);
        }
        return c0628c.gAk;
    }

    public void sP(int i) {
        this.fEX = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0628c {
        AlaLiveMultiBeautyFilterItemView gAk;

        C0628c() {
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
