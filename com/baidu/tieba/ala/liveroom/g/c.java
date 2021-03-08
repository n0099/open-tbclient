package com.baidu.tieba.ala.liveroom.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class c extends BaseAdapter {
    private ViewGroup gyx;
    private b hDe;
    public final a[] hDd = {new a(a.e.img_live_filter_ziran, "delta", "自然"), new a(a.e.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.e.img_live_filter_rouguang, "pink", "柔光"), new a(a.e.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.e.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int gyz = -1;
    private int gyj = 0;
    private ArrayList<Boolean> gyy = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface b {
        void sI(int i);
    }

    public c(ViewGroup viewGroup) {
        this.gyx = viewGroup;
        bQR();
    }

    private void bQR() {
        if (this.gyy != null) {
            this.gyy.clear();
            this.gyy.addAll(Arrays.asList(new Boolean[this.hDd.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vv(int i) {
        if (i >= 0) {
            this.gyy.set(i, true);
            this.gyz = i;
            if (this.hDe != null) {
                this.hDe.sI(i);
            }
        }
    }

    public void HQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.hDd.length; i++) {
                if (str.equals(this.hDd[i].mFilterName)) {
                    vv(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hDe = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hDd.length;
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
        C0671c c0671c;
        if (view == null) {
            C0671c c0671c2 = new C0671c();
            c0671c2.hDg = new AlaLiveMultiBeautyFilterItemView(this.gyx.getContext());
            c0671c2.hDg.setTag(c0671c2);
            c0671c = c0671c2;
        } else {
            c0671c = (C0671c) view.getTag();
        }
        if (this.gyy.get(i) == null || !this.gyy.get(i).booleanValue()) {
            c0671c.hDg.setUnselectedBackground();
        } else {
            c0671c.hDg.setSelectedBackground();
        }
        c0671c.hDg.setItemIcon(this.hDd[i % this.hDd.length].fjC);
        c0671c.hDg.setItemText(this.hDd[i % this.hDd.length].gyC);
        c0671c.hDg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gyz != i) {
                    View childAt = c.this.gyx.getChildAt(c.this.gyz);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gyz >= 0) {
                        c.this.gyy.set(c.this.gyz, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0671c) view2.getTag()).hDg.setSelectedBackground();
                }
                c.this.vv(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gyj != 0) {
            c0671c.hDg.setPadding(this.gyj, 0, 0, 0);
        } else {
            c0671c.hDg.setPadding(0, 0, 0, 0);
        }
        return c0671c.hDg;
    }

    public void ty(int i) {
        this.gyj = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0671c {
        AlaLiveMultiBeautyFilterItemView hDg;

        C0671c() {
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public int fjC;
        public String gyC;
        public String mFilterName;

        public a(int i, String str, String str2) {
            this.fjC = i;
            this.mFilterName = str;
            this.gyC = str2;
        }
    }
}
