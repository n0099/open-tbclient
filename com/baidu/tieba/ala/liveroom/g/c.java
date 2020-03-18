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
    private ViewGroup faD;
    private b faG;
    public final a[] faC = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int faF = -1;
    private int faH = 0;
    private ArrayList<Boolean> faE = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.faD = viewGroup;
        blG();
    }

    private void blG() {
        if (this.faE != null) {
            this.faE.clear();
            this.faE.addAll(Arrays.asList(new Boolean[this.faC.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(int i) {
        if (i >= 0) {
            this.faE.set(i, true);
            this.faF = i;
            if (this.faG != null) {
                this.faG.onItemSelected(i);
            }
        }
    }

    public void yU(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.faC.length; i++) {
                if (str.equals(this.faC[i].mFilterName)) {
                    pX(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.faG = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.faC.length;
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
            c0458c2.faJ = new AlaLiveMultiBeautyFilterItemView(this.faD.getContext());
            c0458c2.faJ.setTag(c0458c2);
            c0458c = c0458c2;
        } else {
            c0458c = (C0458c) view.getTag();
        }
        if (this.faE.get(i) == null || !this.faE.get(i).booleanValue()) {
            c0458c.faJ.setUnselectedBackground();
        } else {
            c0458c.faJ.setSelectedBackground();
        }
        c0458c.faJ.setItemIcon(this.faC[i % this.faC.length].mDrawableId);
        c0458c.faJ.setItemText(this.faC[i % this.faC.length].mShowName);
        c0458c.faJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.faF != i) {
                    View childAt = c.this.faD.getChildAt(c.this.faF);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.faF >= 0) {
                        c.this.faE.set(c.this.faF, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0458c) view2.getTag()).faJ.setSelectedBackground();
                }
                c.this.pX(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.faH != 0) {
            c0458c.faJ.setPadding(this.faH, 0, 0, 0);
        } else {
            c0458c.faJ.setPadding(0, 0, 0, 0);
        }
        return c0458c.faJ;
    }

    public void pY(int i) {
        this.faH = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0458c {
        AlaLiveMultiBeautyFilterItemView faJ;

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
