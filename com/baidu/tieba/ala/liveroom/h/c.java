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
    private ViewGroup goa;
    private b hpH;
    public final a[] hpG = {new a(a.e.img_live_filter_ziran, "delta", "自然"), new a(a.e.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.e.img_live_filter_rouguang, "pink", "柔光"), new a(a.e.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.e.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int goc = -1;
    private int gnM = 0;
    private ArrayList<Boolean> gob = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.goa = viewGroup;
        bRt();
    }

    private void bRt() {
        if (this.gob != null) {
            this.gob.clear();
            this.gob.addAll(Arrays.asList(new Boolean[this.hpG.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wD(int i) {
        if (i >= 0) {
            this.gob.set(i, true);
            this.goc = i;
            if (this.hpH != null) {
                this.hpH.onItemSelected(i);
            }
        }
    }

    public void Im(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.hpG.length; i++) {
                if (str.equals(this.hpG[i].mFilterName)) {
                    wD(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hpH = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hpG.length;
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
        C0690c c0690c;
        if (view == null) {
            C0690c c0690c2 = new C0690c();
            c0690c2.hpJ = new AlaLiveMultiBeautyFilterItemView(this.goa.getContext());
            c0690c2.hpJ.setTag(c0690c2);
            c0690c = c0690c2;
        } else {
            c0690c = (C0690c) view.getTag();
        }
        if (this.gob.get(i) == null || !this.gob.get(i).booleanValue()) {
            c0690c.hpJ.setUnselectedBackground();
        } else {
            c0690c.hpJ.setSelectedBackground();
        }
        c0690c.hpJ.setItemIcon(this.hpG[i % this.hpG.length].faR);
        c0690c.hpJ.setItemText(this.hpG[i % this.hpG.length].gof);
        c0690c.hpJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.goc != i) {
                    View childAt = c.this.goa.getChildAt(c.this.goc);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.goc >= 0) {
                        c.this.gob.set(c.this.goc, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0690c) view2.getTag()).hpJ.setSelectedBackground();
                }
                c.this.wD(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gnM != 0) {
            c0690c.hpJ.setPadding(this.gnM, 0, 0, 0);
        } else {
            c0690c.hpJ.setPadding(0, 0, 0, 0);
        }
        return c0690c.hpJ;
    }

    public void uK(int i) {
        this.gnM = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0690c {
        AlaLiveMultiBeautyFilterItemView hpJ;

        C0690c() {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public int faR;
        public String gof;
        public String mFilterName;

        public a(int i, String str, String str2) {
            this.faR = i;
            this.mFilterName = str;
            this.gof = str2;
        }
    }
}
