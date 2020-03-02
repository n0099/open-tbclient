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
    private ViewGroup eZS;
    private b eZV;
    public final a[] eZR = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int eZU = -1;
    private int eZW = 0;
    private ArrayList<Boolean> eZT = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.eZS = viewGroup;
        blA();
    }

    private void blA() {
        if (this.eZT != null) {
            this.eZT.clear();
            this.eZT.addAll(Arrays.asList(new Boolean[this.eZR.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(int i) {
        if (i >= 0) {
            this.eZT.set(i, true);
            this.eZU = i;
            if (this.eZV != null) {
                this.eZV.onItemSelected(i);
            }
        }
    }

    public void yT(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.eZR.length; i++) {
                if (str.equals(this.eZR[i].mFilterName)) {
                    pV(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.eZV = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eZR.length;
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
            c0458c2.eZY = new AlaLiveMultiBeautyFilterItemView(this.eZS.getContext());
            c0458c2.eZY.setTag(c0458c2);
            c0458c = c0458c2;
        } else {
            c0458c = (C0458c) view.getTag();
        }
        if (this.eZT.get(i) == null || !this.eZT.get(i).booleanValue()) {
            c0458c.eZY.setUnselectedBackground();
        } else {
            c0458c.eZY.setSelectedBackground();
        }
        c0458c.eZY.setItemIcon(this.eZR[i % this.eZR.length].mDrawableId);
        c0458c.eZY.setItemText(this.eZR[i % this.eZR.length].mShowName);
        c0458c.eZY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eZU != i) {
                    View childAt = c.this.eZS.getChildAt(c.this.eZU);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.eZU >= 0) {
                        c.this.eZT.set(c.this.eZU, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0458c) view2.getTag()).eZY.setSelectedBackground();
                }
                c.this.pV(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eZW != 0) {
            c0458c.eZY.setPadding(this.eZW, 0, 0, 0);
        } else {
            c0458c.eZY.setPadding(0, 0, 0, 0);
        }
        return c0458c.eZY;
    }

    public void pW(int i) {
        this.eZW = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0458c {
        AlaLiveMultiBeautyFilterItemView eZY;

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
