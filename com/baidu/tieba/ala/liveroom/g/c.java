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
    private ViewGroup eZR;
    private b eZU;
    public final a[] eZQ = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int eZT = -1;
    private int eZV = 0;
    private ArrayList<Boolean> eZS = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.eZR = viewGroup;
        bly();
    }

    private void bly() {
        if (this.eZS != null) {
            this.eZS.clear();
            this.eZS.addAll(Arrays.asList(new Boolean[this.eZQ.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(int i) {
        if (i >= 0) {
            this.eZS.set(i, true);
            this.eZT = i;
            if (this.eZU != null) {
                this.eZU.onItemSelected(i);
            }
        }
    }

    public void yT(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.eZQ.length; i++) {
                if (str.equals(this.eZQ[i].mFilterName)) {
                    pV(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.eZU = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eZQ.length;
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
        C0458c c0458c;
        if (view == null) {
            C0458c c0458c2 = new C0458c();
            c0458c2.eZX = new AlaLiveMultiBeautyFilterItemView(this.eZR.getContext());
            c0458c2.eZX.setTag(c0458c2);
            c0458c = c0458c2;
        } else {
            c0458c = (C0458c) view.getTag();
        }
        if (this.eZS.get(i) == null || !this.eZS.get(i).booleanValue()) {
            c0458c.eZX.setUnselectedBackground();
        } else {
            c0458c.eZX.setSelectedBackground();
        }
        c0458c.eZX.setItemIcon(this.eZQ[i % this.eZQ.length].mDrawableId);
        c0458c.eZX.setItemText(this.eZQ[i % this.eZQ.length].mShowName);
        c0458c.eZX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eZT != i) {
                    View childAt = c.this.eZR.getChildAt(c.this.eZT);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.eZT >= 0) {
                        c.this.eZS.set(c.this.eZT, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0458c) view2.getTag()).eZX.setSelectedBackground();
                }
                c.this.pV(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eZV != 0) {
            c0458c.eZX.setPadding(this.eZV, 0, 0, 0);
        } else {
            c0458c.eZX.setPadding(0, 0, 0, 0);
        }
        return c0458c.eZX;
    }

    public void pW(int i) {
        this.eZV = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0458c {
        AlaLiveMultiBeautyFilterItemView eZX;

        C0458c() {
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
