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
    private ViewGroup eNo;
    private b fEV;
    public final a[] fEU = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int eNC = -1;
    private int eNq = 0;
    private ArrayList<Boolean> eNB = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.eNo = viewGroup;
        bkK();
    }

    private void bkK() {
        if (this.eNB != null) {
            this.eNB.clear();
            this.eNB.addAll(Arrays.asList(new Boolean[this.fEU.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(int i) {
        if (i >= 0) {
            this.eNB.set(i, true);
            this.eNC = i;
            if (this.fEV != null) {
                this.fEV.onItemSelected(i);
            }
        }
    }

    public void zn(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.fEU.length; i++) {
                if (str.equals(this.fEU[i].mFilterName)) {
                    qr(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.fEV = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fEU.length;
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
        C0514c c0514c;
        if (view == null) {
            C0514c c0514c2 = new C0514c();
            c0514c2.fEX = new AlaLiveMultiBeautyFilterItemView(this.eNo.getContext());
            c0514c2.fEX.setTag(c0514c2);
            c0514c = c0514c2;
        } else {
            c0514c = (C0514c) view.getTag();
        }
        if (this.eNB.get(i) == null || !this.eNB.get(i).booleanValue()) {
            c0514c.fEX.setUnselectedBackground();
        } else {
            c0514c.fEX.setSelectedBackground();
        }
        c0514c.fEX.setItemIcon(this.fEU[i % this.fEU.length].mDrawableId);
        c0514c.fEX.setItemText(this.fEU[i % this.fEU.length].mShowName);
        c0514c.fEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eNC != i) {
                    View childAt = c.this.eNo.getChildAt(c.this.eNC);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.eNC >= 0) {
                        c.this.eNB.set(c.this.eNC, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0514c) view2.getTag()).fEX.setSelectedBackground();
                }
                c.this.qr(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eNq != 0) {
            c0514c.fEX.setPadding(this.eNq, 0, 0, 0);
        } else {
            c0514c.fEX.setPadding(0, 0, 0, 0);
        }
        return c0514c.fEX;
    }

    public void oV(int i) {
        this.eNq = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0514c {
        AlaLiveMultiBeautyFilterItemView fEX;

        C0514c() {
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
