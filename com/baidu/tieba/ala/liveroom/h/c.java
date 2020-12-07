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
    private ViewGroup gnY;
    private b hpF;
    public final a[] hpE = {new a(a.e.img_live_filter_ziran, "delta", "自然"), new a(a.e.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.e.img_live_filter_rouguang, "pink", "柔光"), new a(a.e.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.e.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int goa = -1;
    private int gnK = 0;
    private ArrayList<Boolean> gnZ = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.gnY = viewGroup;
        bRs();
    }

    private void bRs() {
        if (this.gnZ != null) {
            this.gnZ.clear();
            this.gnZ.addAll(Arrays.asList(new Boolean[this.hpE.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wD(int i) {
        if (i >= 0) {
            this.gnZ.set(i, true);
            this.goa = i;
            if (this.hpF != null) {
                this.hpF.onItemSelected(i);
            }
        }
    }

    public void Im(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.hpE.length; i++) {
                if (str.equals(this.hpE[i].mFilterName)) {
                    wD(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hpF = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hpE.length;
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
        C0690c c0690c;
        if (view == null) {
            C0690c c0690c2 = new C0690c();
            c0690c2.hpH = new AlaLiveMultiBeautyFilterItemView(this.gnY.getContext());
            c0690c2.hpH.setTag(c0690c2);
            c0690c = c0690c2;
        } else {
            c0690c = (C0690c) view.getTag();
        }
        if (this.gnZ.get(i) == null || !this.gnZ.get(i).booleanValue()) {
            c0690c.hpH.setUnselectedBackground();
        } else {
            c0690c.hpH.setSelectedBackground();
        }
        c0690c.hpH.setItemIcon(this.hpE[i % this.hpE.length].faR);
        c0690c.hpH.setItemText(this.hpE[i % this.hpE.length].god);
        c0690c.hpH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.goa != i) {
                    View childAt = c.this.gnY.getChildAt(c.this.goa);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.goa >= 0) {
                        c.this.gnZ.set(c.this.goa, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0690c) view2.getTag()).hpH.setSelectedBackground();
                }
                c.this.wD(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gnK != 0) {
            c0690c.hpH.setPadding(this.gnK, 0, 0, 0);
        } else {
            c0690c.hpH.setPadding(0, 0, 0, 0);
        }
        return c0690c.hpH;
    }

    public void uK(int i) {
        this.gnK = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0690c {
        AlaLiveMultiBeautyFilterItemView hpH;

        C0690c() {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public int faR;
        public String god;
        public String mFilterName;

        public a(int i, String str, String str2) {
            this.faR = i;
            this.mFilterName = str;
            this.god = str2;
        }
    }
}
