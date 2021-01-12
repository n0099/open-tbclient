package com.baidu.tieba.ala.liveroom.h;

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
    private ViewGroup gtQ;
    private b hwX;
    public final a[] hwW = {new a(a.e.img_live_filter_ziran, "delta", "自然"), new a(a.e.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.e.img_live_filter_rouguang, "pink", "柔光"), new a(a.e.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.e.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int gtS = -1;
    private int gtC = 0;
    private ArrayList<Boolean> gtR = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface b {
        void sB(int i);
    }

    public c(ViewGroup viewGroup) {
        this.gtQ = viewGroup;
        bQa();
    }

    private void bQa() {
        if (this.gtR != null) {
            this.gtR.clear();
            this.gtR.addAll(Arrays.asList(new Boolean[this.hwW.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi(int i) {
        if (i >= 0) {
            this.gtR.set(i, true);
            this.gtS = i;
            if (this.hwX != null) {
                this.hwX.sB(i);
            }
        }
    }

    public void Hc(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.hwW.length; i++) {
                if (str.equals(this.hwW[i].mFilterName)) {
                    vi(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hwX = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hwW.length;
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
            c0665c2.hwZ = new AlaLiveMultiBeautyFilterItemView(this.gtQ.getContext());
            c0665c2.hwZ.setTag(c0665c2);
            c0665c = c0665c2;
        } else {
            c0665c = (C0665c) view.getTag();
        }
        if (this.gtR.get(i) == null || !this.gtR.get(i).booleanValue()) {
            c0665c.hwZ.setUnselectedBackground();
        } else {
            c0665c.hwZ.setSelectedBackground();
        }
        c0665c.hwZ.setItemIcon(this.hwW[i % this.hwW.length].ffK);
        c0665c.hwZ.setItemText(this.hwW[i % this.hwW.length].gtV);
        c0665c.hwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gtS != i) {
                    View childAt = c.this.gtQ.getChildAt(c.this.gtS);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gtS >= 0) {
                        c.this.gtR.set(c.this.gtS, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0665c) view2.getTag()).hwZ.setSelectedBackground();
                }
                c.this.vi(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gtC != 0) {
            c0665c.hwZ.setPadding(this.gtC, 0, 0, 0);
        } else {
            c0665c.hwZ.setPadding(0, 0, 0, 0);
        }
        return c0665c.hwZ;
    }

    public void tq(int i) {
        this.gtC = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0665c {
        AlaLiveMultiBeautyFilterItemView hwZ;

        C0665c() {
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public int ffK;
        public String gtV;
        public String mFilterName;

        public a(int i, String str, String str2) {
            this.ffK = i;
            this.mFilterName = str;
            this.gtV = str2;
        }
    }
}
