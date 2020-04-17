package com.baidu.tieba.ala.liveroom.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private ViewGroup eNj;
    private b fEQ;
    public final a[] fEP = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int eNx = -1;
    private int eNl = 0;
    private ArrayList<Boolean> eNw = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.eNj = viewGroup;
        bkM();
    }

    private void bkM() {
        if (this.eNw != null) {
            this.eNw.clear();
            this.eNw.addAll(Arrays.asList(new Boolean[this.fEP.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(int i) {
        if (i >= 0) {
            this.eNw.set(i, true);
            this.eNx = i;
            if (this.fEQ != null) {
                this.fEQ.onItemSelected(i);
            }
        }
    }

    public void zk(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.fEP.length; i++) {
                if (str.equals(this.fEP[i].mFilterName)) {
                    qr(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.fEQ = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fEP.length;
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
        C0493c c0493c;
        if (view == null) {
            C0493c c0493c2 = new C0493c();
            c0493c2.fES = new AlaLiveMultiBeautyFilterItemView(this.eNj.getContext());
            c0493c2.fES.setTag(c0493c2);
            c0493c = c0493c2;
        } else {
            c0493c = (C0493c) view.getTag();
        }
        if (this.eNw.get(i) == null || !this.eNw.get(i).booleanValue()) {
            c0493c.fES.setUnselectedBackground();
        } else {
            c0493c.fES.setSelectedBackground();
        }
        c0493c.fES.setItemIcon(this.fEP[i % this.fEP.length].mDrawableId);
        c0493c.fES.setItemText(this.fEP[i % this.fEP.length].mShowName);
        c0493c.fES.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eNx != i) {
                    View childAt = c.this.eNj.getChildAt(c.this.eNx);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.eNx >= 0) {
                        c.this.eNw.set(c.this.eNx, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0493c) view2.getTag()).fES.setSelectedBackground();
                }
                c.this.qr(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eNl != 0) {
            c0493c.fES.setPadding(this.eNl, 0, 0, 0);
        } else {
            c0493c.fES.setPadding(0, 0, 0, 0);
        }
        return c0493c.fES;
    }

    public void oV(int i) {
        this.eNl = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0493c {
        AlaLiveMultiBeautyFilterItemView fES;

        C0493c() {
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
