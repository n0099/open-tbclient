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
    private ViewGroup fqj;
    private b gkO;
    public final a[] gkN = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int fqy = -1;
    private int fql = 0;
    private ArrayList<Boolean> fqx = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.fqj = viewGroup;
        bwm();
    }

    private void bwm() {
        if (this.fqx != null) {
            this.fqx.clear();
            this.fqx.addAll(Arrays.asList(new Boolean[this.gkN.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(int i) {
        if (i >= 0) {
            this.fqx.set(i, true);
            this.fqy = i;
            if (this.gkO != null) {
                this.gkO.onItemSelected(i);
            }
        }
    }

    public void BX(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gkN.length; i++) {
                if (str.equals(this.gkN[i].mFilterName)) {
                    rJ(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gkO = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gkN.length;
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
        C0581c c0581c;
        if (view == null) {
            C0581c c0581c2 = new C0581c();
            c0581c2.gkQ = new AlaLiveMultiBeautyFilterItemView(this.fqj.getContext());
            c0581c2.gkQ.setTag(c0581c2);
            c0581c = c0581c2;
        } else {
            c0581c = (C0581c) view.getTag();
        }
        if (this.fqx.get(i) == null || !this.fqx.get(i).booleanValue()) {
            c0581c.gkQ.setUnselectedBackground();
        } else {
            c0581c.gkQ.setSelectedBackground();
        }
        c0581c.gkQ.setItemIcon(this.gkN[i % this.gkN.length].mDrawableId);
        c0581c.gkQ.setItemText(this.gkN[i % this.gkN.length].mShowName);
        c0581c.gkQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fqy != i) {
                    View childAt = c.this.fqj.getChildAt(c.this.fqy);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.fqy >= 0) {
                        c.this.fqx.set(c.this.fqy, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0581c) view2.getTag()).gkQ.setSelectedBackground();
                }
                c.this.rJ(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fql != 0) {
            c0581c.gkQ.setPadding(this.fql, 0, 0, 0);
        } else {
            c0581c.gkQ.setPadding(0, 0, 0, 0);
        }
        return c0581c.gkQ;
    }

    public void ql(int i) {
        this.fql = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0581c {
        AlaLiveMultiBeautyFilterItemView gkQ;

        C0581c() {
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
