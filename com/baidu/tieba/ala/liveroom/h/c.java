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
    private ViewGroup fRe;
    private b gOB;
    public final a[] gOA = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int fRt = -1;
    private int fRg = 0;
    private ArrayList<Boolean> fRs = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.fRe = viewGroup;
        bJo();
    }

    private void bJo() {
        if (this.fRs != null) {
            this.fRs.clear();
            this.fRs.addAll(Arrays.asList(new Boolean[this.gOA.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uT(int i) {
        if (i >= 0) {
            this.fRs.set(i, true);
            this.fRt = i;
            if (this.gOB != null) {
                this.gOB.onItemSelected(i);
            }
        }
    }

    public void FB(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gOA.length; i++) {
                if (str.equals(this.gOA[i].mFilterName)) {
                    uT(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gOB = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gOA.length;
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
        C0646c c0646c;
        if (view == null) {
            C0646c c0646c2 = new C0646c();
            c0646c2.gOD = new AlaLiveMultiBeautyFilterItemView(this.fRe.getContext());
            c0646c2.gOD.setTag(c0646c2);
            c0646c = c0646c2;
        } else {
            c0646c = (C0646c) view.getTag();
        }
        if (this.fRs.get(i) == null || !this.fRs.get(i).booleanValue()) {
            c0646c.gOD.setUnselectedBackground();
        } else {
            c0646c.gOD.setSelectedBackground();
        }
        c0646c.gOD.setItemIcon(this.gOA[i % this.gOA.length].mDrawableId);
        c0646c.gOD.setItemText(this.gOA[i % this.gOA.length].mShowName);
        c0646c.gOD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fRt != i) {
                    View childAt = c.this.fRe.getChildAt(c.this.fRt);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.fRt >= 0) {
                        c.this.fRs.set(c.this.fRt, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0646c) view2.getTag()).gOD.setSelectedBackground();
                }
                c.this.uT(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fRg != 0) {
            c0646c.gOD.setPadding(this.fRg, 0, 0, 0);
        } else {
            c0646c.gOD.setPadding(0, 0, 0, 0);
        }
        return c0646c.gOD;
    }

    public void tn(int i) {
        this.fRg = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0646c {
        AlaLiveMultiBeautyFilterItemView gOD;

        C0646c() {
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
