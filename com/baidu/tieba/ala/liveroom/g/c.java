package com.baidu.tieba.ala.liveroom.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private ViewGroup flb;
    private b gfG;
    public final a[] gfF = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int flq = -1;
    private int fld = 0;
    private ArrayList<Boolean> flp = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.flb = viewGroup;
        btc();
    }

    private void btc() {
        if (this.flp != null) {
            this.flp.clear();
            this.flp.addAll(Arrays.asList(new Boolean[this.gfF.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(int i) {
        if (i >= 0) {
            this.flp.set(i, true);
            this.flq = i;
            if (this.gfG != null) {
                this.gfG.onItemSelected(i);
            }
        }
    }

    public void Bm(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gfF.length; i++) {
                if (str.equals(this.gfF[i].mFilterName)) {
                    rt(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gfG = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gfF.length;
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
        C0570c c0570c;
        if (view == null) {
            C0570c c0570c2 = new C0570c();
            c0570c2.gfI = new AlaLiveMultiBeautyFilterItemView(this.flb.getContext());
            c0570c2.gfI.setTag(c0570c2);
            c0570c = c0570c2;
        } else {
            c0570c = (C0570c) view.getTag();
        }
        if (this.flp.get(i) == null || !this.flp.get(i).booleanValue()) {
            c0570c.gfI.setUnselectedBackground();
        } else {
            c0570c.gfI.setSelectedBackground();
        }
        c0570c.gfI.setItemIcon(this.gfF[i % this.gfF.length].mDrawableId);
        c0570c.gfI.setItemText(this.gfF[i % this.gfF.length].mShowName);
        c0570c.gfI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.flq != i) {
                    View childAt = c.this.flb.getChildAt(c.this.flq);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.flq >= 0) {
                        c.this.flp.set(c.this.flq, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0570c) view2.getTag()).gfI.setSelectedBackground();
                }
                c.this.rt(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fld != 0) {
            c0570c.gfI.setPadding(this.fld, 0, 0, 0);
        } else {
            c0570c.gfI.setPadding(0, 0, 0, 0);
        }
        return c0570c.gfI;
    }

    public void pW(int i) {
        this.fld = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0570c {
        AlaLiveMultiBeautyFilterItemView gfI;

        C0570c() {
        }
    }

    /* loaded from: classes3.dex */
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
