package com.baidu.tieba.ala.liveroom.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes11.dex */
public class c extends BaseAdapter {
    private ViewGroup gwA;
    private b hBh;
    public final a[] hBg = {new a(a.e.img_live_filter_ziran, "delta", "自然"), new a(a.e.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.e.img_live_filter_rouguang, "pink", "柔光"), new a(a.e.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.e.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int gwC = -1;
    private int gwm = 0;
    private ArrayList<Boolean> gwB = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface b {
        void sG(int i);
    }

    public c(ViewGroup viewGroup) {
        this.gwA = viewGroup;
        bQE();
    }

    private void bQE() {
        if (this.gwB != null) {
            this.gwB.clear();
            this.gwB.addAll(Arrays.asList(new Boolean[this.hBg.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt(int i) {
        if (i >= 0) {
            this.gwB.set(i, true);
            this.gwC = i;
            if (this.hBh != null) {
                this.hBh.sG(i);
            }
        }
    }

    public void HG(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.hBg.length; i++) {
                if (str.equals(this.hBg[i].mFilterName)) {
                    vt(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hBh = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hBg.length;
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
        C0664c c0664c;
        if (view == null) {
            C0664c c0664c2 = new C0664c();
            c0664c2.hBj = new AlaLiveMultiBeautyFilterItemView(this.gwA.getContext());
            c0664c2.hBj.setTag(c0664c2);
            c0664c = c0664c2;
        } else {
            c0664c = (C0664c) view.getTag();
        }
        if (this.gwB.get(i) == null || !this.gwB.get(i).booleanValue()) {
            c0664c.hBj.setUnselectedBackground();
        } else {
            c0664c.hBj.setSelectedBackground();
        }
        c0664c.hBj.setItemIcon(this.hBg[i % this.hBg.length].fia);
        c0664c.hBj.setItemText(this.hBg[i % this.hBg.length].gwF);
        c0664c.hBj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gwC != i) {
                    View childAt = c.this.gwA.getChildAt(c.this.gwC);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gwC >= 0) {
                        c.this.gwB.set(c.this.gwC, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0664c) view2.getTag()).hBj.setSelectedBackground();
                }
                c.this.vt(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gwm != 0) {
            c0664c.hBj.setPadding(this.gwm, 0, 0, 0);
        } else {
            c0664c.hBj.setPadding(0, 0, 0, 0);
        }
        return c0664c.hBj;
    }

    public void tw(int i) {
        this.gwm = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0664c {
        AlaLiveMultiBeautyFilterItemView hBj;

        C0664c() {
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int fia;
        public String gwF;
        public String mFilterName;

        public a(int i, String str, String str2) {
            this.fia = i;
            this.mFilterName = str;
            this.gwF = str2;
        }
    }
}
