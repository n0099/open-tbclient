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
    private ViewGroup faf;
    private b fai;
    public final a[] fae = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int fah = -1;
    private int faj = 0;
    private ArrayList<Boolean> fag = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.faf = viewGroup;
        blB();
    }

    private void blB() {
        if (this.fag != null) {
            this.fag.clear();
            this.fag.addAll(Arrays.asList(new Boolean[this.fae.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(int i) {
        if (i >= 0) {
            this.fag.set(i, true);
            this.fah = i;
            if (this.fai != null) {
                this.fai.onItemSelected(i);
            }
        }
    }

    public void yU(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.fae.length; i++) {
                if (str.equals(this.fae[i].mFilterName)) {
                    pV(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.fai = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fae.length;
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
            c0458c2.fal = new AlaLiveMultiBeautyFilterItemView(this.faf.getContext());
            c0458c2.fal.setTag(c0458c2);
            c0458c = c0458c2;
        } else {
            c0458c = (C0458c) view.getTag();
        }
        if (this.fag.get(i) == null || !this.fag.get(i).booleanValue()) {
            c0458c.fal.setUnselectedBackground();
        } else {
            c0458c.fal.setSelectedBackground();
        }
        c0458c.fal.setItemIcon(this.fae[i % this.fae.length].mDrawableId);
        c0458c.fal.setItemText(this.fae[i % this.fae.length].mShowName);
        c0458c.fal.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fah != i) {
                    View childAt = c.this.faf.getChildAt(c.this.fah);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.fah >= 0) {
                        c.this.fag.set(c.this.fah, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0458c) view2.getTag()).fal.setSelectedBackground();
                }
                c.this.pV(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.faj != 0) {
            c0458c.fal.setPadding(this.faj, 0, 0, 0);
        } else {
            c0458c.fal.setPadding(0, 0, 0, 0);
        }
        return c0458c.fal;
    }

    public void pW(int i) {
        this.faj = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0458c {
        AlaLiveMultiBeautyFilterItemView fal;

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
