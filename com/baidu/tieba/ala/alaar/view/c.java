package com.baidu.tieba.ala.alaar.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private ViewGroup ggj;
    private b ggm;
    public final a[] ggi = {new a(a.e.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.e.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.e.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.e.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.e.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.e.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.e.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.e.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.e.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.e.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.e.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.e.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.e.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.e.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.e.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.e.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int ggl = -1;
    private int gfV = 0;
    private ArrayList<Boolean> ggk = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, int[] iArr, boolean z);
    }

    public c(ViewGroup viewGroup) {
        this.ggj = viewGroup;
        bOo();
    }

    private void bOo() {
        if (this.ggk != null) {
            this.ggk.clear();
            this.ggk.addAll(Arrays.asList(new Boolean[this.ggi.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int[] iArr, boolean z) {
        if (i >= 0) {
            this.ggk.set(i, true);
            this.ggl = i;
            if (this.ggm != null) {
                this.ggm.a(i, iArr, z);
            }
        }
    }

    public void Gp(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.ggi.length; i++) {
                if (str.equals(this.ggi[i].ggo)) {
                    b(i, null, false);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.ggm = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ggi.length;
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
        C0629c c0629c;
        if (view == null) {
            C0629c c0629c2 = new C0629c();
            c0629c2.ggq = new BeautyItemView(this.ggj.getContext());
            c0629c2.ggq.setTag(c0629c2);
            c0629c = c0629c2;
        } else {
            c0629c = (C0629c) view.getTag();
        }
        if (this.ggk.get(i) == null || !this.ggk.get(i).booleanValue()) {
            c0629c.ggq.setUnselectedBackground();
        } else {
            c0629c.ggq.setSelectedBackground();
        }
        c0629c.ggq.setItemIcon(this.ggi[i % this.ggi.length].mDrawableId);
        c0629c.ggq.setItemText(this.ggi[i % this.ggi.length].mShowName);
        c0629c.ggq.setRedotVisible(Gq(this.ggi[i % this.ggi.length].ggo));
        c0629c.ggq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof C0629c)) {
                    ((C0629c) view2.getTag()).ggq.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (c.this.ggm != null) {
                        c.this.ggm.a(i, iArr, true);
                        return;
                    }
                    return;
                }
                if (c.this.ggl != i) {
                    View childAt = c.this.ggj.getChildAt(c.this.ggl);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.ggl >= 0) {
                        c.this.ggk.set(c.this.ggl, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0629c) view2.getTag()).ggq.setSelectedBackground();
                }
                c.this.b(i, iArr, true);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gfV != 0) {
            c0629c.ggq.setPadding(this.gfV, 0, 0, 0);
        } else {
            c0629c.ggq.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            c0629c.ggq.ggf.setVisibility(8);
            c0629c.ggq.ggb.setVisibility(8);
            c0629c.ggq.ggg.setVisibility(0);
        } else {
            c0629c.ggq.ggf.setVisibility(0);
            c0629c.ggq.ggb.setVisibility(0);
            c0629c.ggq.ggg.setVisibility(8);
        }
        return c0629c.ggq;
    }

    private boolean Gq(String str) {
        if (com.baidu.live.d.AZ().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bOp()) {
            return true;
        }
        return Gr(str) && com.baidu.live.d.AZ().getBoolean(str, true);
    }

    public boolean bOp() {
        return com.baidu.live.d.AZ().getBoolean("naturalFace", true) || com.baidu.live.d.AZ().getBoolean("goddessFace", true) || com.baidu.live.d.AZ().getBoolean("babyFace", true);
    }

    private boolean Gr(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void Gs(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && Gr(str)) {
            com.baidu.live.d.AZ().putBoolean(str, false);
        }
    }

    public void tI(int i) {
        this.gfV = i;
    }

    /* renamed from: com.baidu.tieba.ala.alaar.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0629c {
        BeautyItemView ggq;

        public C0629c() {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public String ggo;
        public int ggp;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.ggo = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.ggp = i4;
        }
    }
}
