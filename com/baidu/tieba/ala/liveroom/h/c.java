package com.baidu.tieba.ala.liveroom.h;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class c extends BaseAdapter {
    private ViewGroup fBF;
    private b gwS;
    public final a[] gwR = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int fBU = -1;
    private int fBH = 0;
    private ArrayList<Boolean> fBT = new ArrayList<>();

    /* loaded from: classes7.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.fBF = viewGroup;
        bFl();
    }

    private void bFl() {
        if (this.fBT != null) {
            this.fBT.clear();
            this.fBT.addAll(Arrays.asList(new Boolean[this.gwR.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV(int i) {
        if (i >= 0) {
            this.fBT.set(i, true);
            this.fBU = i;
            if (this.gwS != null) {
                this.gwS.onItemSelected(i);
            }
        }
    }

    public void Er(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gwR.length; i++) {
                if (str.equals(this.gwR[i].mFilterName)) {
                    tV(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gwS = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gwR.length;
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
        C0632c c0632c;
        if (view == null) {
            C0632c c0632c2 = new C0632c();
            c0632c2.gwU = new AlaLiveMultiBeautyFilterItemView(this.fBF.getContext());
            c0632c2.gwU.setTag(c0632c2);
            c0632c = c0632c2;
        } else {
            c0632c = (C0632c) view.getTag();
        }
        if (this.fBT.get(i) == null || !this.fBT.get(i).booleanValue()) {
            c0632c.gwU.setUnselectedBackground();
        } else {
            c0632c.gwU.setSelectedBackground();
        }
        c0632c.gwU.setItemIcon(this.gwR[i % this.gwR.length].mDrawableId);
        c0632c.gwU.setItemText(this.gwR[i % this.gwR.length].mShowName);
        c0632c.gwU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fBU != i) {
                    View childAt = c.this.fBF.getChildAt(c.this.fBU);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.fBU >= 0) {
                        c.this.fBT.set(c.this.fBU, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0632c) view2.getTag()).gwU.setSelectedBackground();
                }
                c.this.tV(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fBH != 0) {
            c0632c.gwU.setPadding(this.fBH, 0, 0, 0);
        } else {
            c0632c.gwU.setPadding(0, 0, 0, 0);
        }
        return c0632c.gwU;
    }

    public void sx(int i) {
        this.fBH = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C0632c {
        AlaLiveMultiBeautyFilterItemView gwU;

        C0632c() {
        }
    }

    /* loaded from: classes7.dex */
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
