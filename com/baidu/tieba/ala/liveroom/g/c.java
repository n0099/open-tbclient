package com.baidu.tieba.ala.liveroom.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.q.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private ViewGroup eUo;
    private b eUr;
    public final a[] eUn = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int eUq = -1;
    private int eUs = 0;
    private ArrayList<Boolean> eUp = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.eUo = viewGroup;
        biY();
    }

    private void biY() {
        if (this.eUp != null) {
            this.eUp.clear();
            this.eUp.addAll(Arrays.asList(new Boolean[this.eUn.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pL(int i) {
        if (i >= 0) {
            this.eUp.set(i, true);
            this.eUq = i;
            if (this.eUr != null) {
                this.eUr.onItemSelected(i);
            }
        }
    }

    public void yv(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.eUn.length; i++) {
                if (str.equals(this.eUn[i].mFilterName)) {
                    pL(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.eUr = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eUn.length;
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
        C0444c c0444c;
        if (view == null) {
            C0444c c0444c2 = new C0444c();
            c0444c2.eUv = new AlaLiveMultiBeautyFilterItemView(this.eUo.getContext());
            c0444c2.eUv.setTag(c0444c2);
            c0444c = c0444c2;
        } else {
            c0444c = (C0444c) view.getTag();
        }
        if (this.eUp.get(i) == null || !this.eUp.get(i).booleanValue()) {
            c0444c.eUv.setUnselectedBackground();
        } else {
            c0444c.eUv.setSelectedBackground();
        }
        c0444c.eUv.setItemIcon(this.eUn[i % this.eUn.length].dbO);
        c0444c.eUv.setItemText(this.eUn[i % this.eUn.length].eUu);
        c0444c.eUv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eUq != i) {
                    View childAt = c.this.eUo.getChildAt(c.this.eUq);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.eUq >= 0) {
                        c.this.eUp.set(c.this.eUq, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0444c) view2.getTag()).eUv.setSelectedBackground();
                }
                c.this.pL(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eUs != 0) {
            c0444c.eUv.setPadding(this.eUs, 0, 0, 0);
        } else {
            c0444c.eUv.setPadding(0, 0, 0, 0);
        }
        return c0444c.eUv;
    }

    public void pM(int i) {
        this.eUs = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0444c {
        AlaLiveMultiBeautyFilterItemView eUv;

        C0444c() {
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int dbO;
        public String eUu;
        public String mFilterName;

        public a(int i, String str, String str2) {
            this.dbO = i;
            this.mFilterName = str;
            this.eUu = str2;
        }
    }
}
