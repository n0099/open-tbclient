package com.baidu.tieba.ala.liveroom.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes11.dex */
public class c extends BaseAdapter {
    private ViewGroup gwO;
    private b hBv;
    public final a[] hBu = {new a(a.e.img_live_filter_ziran, "delta", "自然"), new a(a.e.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.e.img_live_filter_rouguang, "pink", "柔光"), new a(a.e.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.e.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int gwQ = -1;
    private int gwA = 0;
    private ArrayList<Boolean> gwP = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface b {
        void sG(int i);
    }

    public c(ViewGroup viewGroup) {
        this.gwO = viewGroup;
        bQL();
    }

    private void bQL() {
        if (this.gwP != null) {
            this.gwP.clear();
            this.gwP.addAll(Arrays.asList(new Boolean[this.hBu.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt(int i) {
        if (i >= 0) {
            this.gwP.set(i, true);
            this.gwQ = i;
            if (this.hBv != null) {
                this.hBv.sG(i);
            }
        }
    }

    public void HH(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.hBu.length; i++) {
                if (str.equals(this.hBu[i].mFilterName)) {
                    vt(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hBv = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hBu.length;
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
        C0665c c0665c;
        if (view == null) {
            C0665c c0665c2 = new C0665c();
            c0665c2.hBx = new AlaLiveMultiBeautyFilterItemView(this.gwO.getContext());
            c0665c2.hBx.setTag(c0665c2);
            c0665c = c0665c2;
        } else {
            c0665c = (C0665c) view.getTag();
        }
        if (this.gwP.get(i) == null || !this.gwP.get(i).booleanValue()) {
            c0665c.hBx.setUnselectedBackground();
        } else {
            c0665c.hBx.setSelectedBackground();
        }
        c0665c.hBx.setItemIcon(this.hBu[i % this.hBu.length].fia);
        c0665c.hBx.setItemText(this.hBu[i % this.hBu.length].gwT);
        c0665c.hBx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gwQ != i) {
                    View childAt = c.this.gwO.getChildAt(c.this.gwQ);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gwQ >= 0) {
                        c.this.gwP.set(c.this.gwQ, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0665c) view2.getTag()).hBx.setSelectedBackground();
                }
                c.this.vt(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gwA != 0) {
            c0665c.hBx.setPadding(this.gwA, 0, 0, 0);
        } else {
            c0665c.hBx.setPadding(0, 0, 0, 0);
        }
        return c0665c.hBx;
    }

    public void tw(int i) {
        this.gwA = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0665c {
        AlaLiveMultiBeautyFilterItemView hBx;

        C0665c() {
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int fia;
        public String gwT;
        public String mFilterName;

        public a(int i, String str, String str2) {
            this.fia = i;
            this.mFilterName = str;
            this.gwT = str2;
        }
    }
}
