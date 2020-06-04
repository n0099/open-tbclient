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
    private ViewGroup eZW;
    private b fTa;
    public final a[] fSZ = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int fak = -1;
    private int eZY = 0;
    private ArrayList<Boolean> faj = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.eZW = viewGroup;
        bqg();
    }

    private void bqg() {
        if (this.faj != null) {
            this.faj.clear();
            this.faj.addAll(Arrays.asList(new Boolean[this.fSZ.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qU(int i) {
        if (i >= 0) {
            this.faj.set(i, true);
            this.fak = i;
            if (this.fTa != null) {
                this.fTa.onItemSelected(i);
            }
        }
    }

    public void AT(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.fSZ.length; i++) {
                if (str.equals(this.fSZ[i].mFilterName)) {
                    qU(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.fTa = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fSZ.length;
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
        C0561c c0561c;
        if (view == null) {
            C0561c c0561c2 = new C0561c();
            c0561c2.fTc = new AlaLiveMultiBeautyFilterItemView(this.eZW.getContext());
            c0561c2.fTc.setTag(c0561c2);
            c0561c = c0561c2;
        } else {
            c0561c = (C0561c) view.getTag();
        }
        if (this.faj.get(i) == null || !this.faj.get(i).booleanValue()) {
            c0561c.fTc.setUnselectedBackground();
        } else {
            c0561c.fTc.setSelectedBackground();
        }
        c0561c.fTc.setItemIcon(this.fSZ[i % this.fSZ.length].mDrawableId);
        c0561c.fTc.setItemText(this.fSZ[i % this.fSZ.length].mShowName);
        c0561c.fTc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fak != i) {
                    View childAt = c.this.eZW.getChildAt(c.this.fak);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.fak >= 0) {
                        c.this.faj.set(c.this.fak, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0561c) view2.getTag()).fTc.setSelectedBackground();
                }
                c.this.qU(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eZY != 0) {
            c0561c.fTc.setPadding(this.eZY, 0, 0, 0);
        } else {
            c0561c.fTc.setPadding(0, 0, 0, 0);
        }
        return c0561c.fTc;
    }

    public void py(int i) {
        this.eZY = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0561c {
        AlaLiveMultiBeautyFilterItemView fTc;

        C0561c() {
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
