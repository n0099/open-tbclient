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
    private ViewGroup fBJ;
    private b gwW;
    public final a[] gwV = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int fBY = -1;
    private int fBL = 0;
    private ArrayList<Boolean> fBX = new ArrayList<>();

    /* loaded from: classes7.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.fBJ = viewGroup;
        bFm();
    }

    private void bFm() {
        if (this.fBX != null) {
            this.fBX.clear();
            this.fBX.addAll(Arrays.asList(new Boolean[this.gwV.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV(int i) {
        if (i >= 0) {
            this.fBX.set(i, true);
            this.fBY = i;
            if (this.gwW != null) {
                this.gwW.onItemSelected(i);
            }
        }
    }

    public void Es(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gwV.length; i++) {
                if (str.equals(this.gwV[i].mFilterName)) {
                    tV(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gwW = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gwV.length;
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
            c0632c2.gwY = new AlaLiveMultiBeautyFilterItemView(this.fBJ.getContext());
            c0632c2.gwY.setTag(c0632c2);
            c0632c = c0632c2;
        } else {
            c0632c = (C0632c) view.getTag();
        }
        if (this.fBX.get(i) == null || !this.fBX.get(i).booleanValue()) {
            c0632c.gwY.setUnselectedBackground();
        } else {
            c0632c.gwY.setSelectedBackground();
        }
        c0632c.gwY.setItemIcon(this.gwV[i % this.gwV.length].mDrawableId);
        c0632c.gwY.setItemText(this.gwV[i % this.gwV.length].mShowName);
        c0632c.gwY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fBY != i) {
                    View childAt = c.this.fBJ.getChildAt(c.this.fBY);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.fBY >= 0) {
                        c.this.fBX.set(c.this.fBY, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0632c) view2.getTag()).gwY.setSelectedBackground();
                }
                c.this.tV(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fBL != 0) {
            c0632c.gwY.setPadding(this.fBL, 0, 0, 0);
        } else {
            c0632c.gwY.setPadding(0, 0, 0, 0);
        }
        return c0632c.gwY;
    }

    public void sx(int i) {
        this.fBL = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C0632c {
        AlaLiveMultiBeautyFilterItemView gwY;

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
