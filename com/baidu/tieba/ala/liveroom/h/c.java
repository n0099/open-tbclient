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
    private ViewGroup gat;
    private b hap;
    public final a[] hao = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int gav = -1;
    private int gae = 0;
    private ArrayList<Boolean> gau = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.gat = viewGroup;
        bLO();
    }

    private void bLO() {
        if (this.gau != null) {
            this.gau.clear();
            this.gau.addAll(Arrays.asList(new Boolean[this.hao.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn(int i) {
        if (i >= 0) {
            this.gau.set(i, true);
            this.gav = i;
            if (this.hap != null) {
                this.hap.onItemSelected(i);
            }
        }
    }

    public void HE(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.hao.length; i++) {
                if (str.equals(this.hao[i].mFilterName)) {
                    vn(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hap = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hao.length;
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
        C0662c c0662c;
        if (view == null) {
            C0662c c0662c2 = new C0662c();
            c0662c2.har = new AlaLiveMultiBeautyFilterItemView(this.gat.getContext());
            c0662c2.har.setTag(c0662c2);
            c0662c = c0662c2;
        } else {
            c0662c = (C0662c) view.getTag();
        }
        if (this.gau.get(i) == null || !this.gau.get(i).booleanValue()) {
            c0662c.har.setUnselectedBackground();
        } else {
            c0662c.har.setSelectedBackground();
        }
        c0662c.har.setItemIcon(this.hao[i % this.hao.length].mDrawableId);
        c0662c.har.setItemText(this.hao[i % this.hao.length].mShowName);
        c0662c.har.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gav != i) {
                    View childAt = c.this.gat.getChildAt(c.this.gav);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gav >= 0) {
                        c.this.gau.set(c.this.gav, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0662c) view2.getTag()).har.setSelectedBackground();
                }
                c.this.vn(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gae != 0) {
            c0662c.har.setPadding(this.gae, 0, 0, 0);
        } else {
            c0662c.har.setPadding(0, 0, 0, 0);
        }
        return c0662c.har;
    }

    public void ty(int i) {
        this.gae = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0662c {
        AlaLiveMultiBeautyFilterItemView har;

        C0662c() {
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
