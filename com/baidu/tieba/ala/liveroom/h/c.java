package com.baidu.tieba.ala.liveroom.h;

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
    private ViewGroup gyx;
    private b hBD;
    public final a[] hBC = {new a(a.e.img_live_filter_ziran, "delta", "自然"), new a(a.e.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.e.img_live_filter_rouguang, "pink", "柔光"), new a(a.e.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.e.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int gyz = -1;
    private int gyj = 0;
    private ArrayList<Boolean> gyy = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface b {
        void uh(int i);
    }

    public c(ViewGroup viewGroup) {
        this.gyx = viewGroup;
        bTS();
    }

    private void bTS() {
        if (this.gyy != null) {
            this.gyy.clear();
            this.gyy.addAll(Arrays.asList(new Boolean[this.hBC.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wO(int i) {
        if (i >= 0) {
            this.gyy.set(i, true);
            this.gyz = i;
            if (this.hBD != null) {
                this.hBD.uh(i);
            }
        }
    }

    public void In(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.hBC.length; i++) {
                if (str.equals(this.hBC[i].mFilterName)) {
                    wO(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hBD = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hBC.length;
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
        C0682c c0682c;
        if (view == null) {
            C0682c c0682c2 = new C0682c();
            c0682c2.hBF = new AlaLiveMultiBeautyFilterItemView(this.gyx.getContext());
            c0682c2.hBF.setTag(c0682c2);
            c0682c = c0682c2;
        } else {
            c0682c = (C0682c) view.getTag();
        }
        if (this.gyy.get(i) == null || !this.gyy.get(i).booleanValue()) {
            c0682c.hBF.setUnselectedBackground();
        } else {
            c0682c.hBF.setSelectedBackground();
        }
        c0682c.hBF.setItemIcon(this.hBC[i % this.hBC.length].fkv);
        c0682c.hBF.setItemText(this.hBC[i % this.hBC.length].gyC);
        c0682c.hBF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
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
                    ((C0682c) view2.getTag()).hBF.setSelectedBackground();
                }
                c.this.wO(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gyj != 0) {
            c0682c.hBF.setPadding(this.gyj, 0, 0, 0);
        } else {
            c0682c.hBF.setPadding(0, 0, 0, 0);
        }
        return c0682c.hBF;
    }

    public void uW(int i) {
        this.gyj = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0682c {
        AlaLiveMultiBeautyFilterItemView hBF;

        C0682c() {
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int fkv;
        public String gyC;
        public String mFilterName;

        public a(int i, String str, String str2) {
            this.fkv = i;
            this.mFilterName = str;
            this.gyC = str2;
        }
    }
}
