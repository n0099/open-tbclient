package com.baidu.tieba.ala.alaar.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class c extends BaseAdapter {
    private ViewGroup gtQ;
    private b gtT;
    public final a[] gtP = {new a(a.e.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.e.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.e.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.e.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.e.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.e.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.e.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.e.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.e.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.e.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.e.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.e.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.e.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.e.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.e.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.e.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int gtS = -1;
    private int gtC = 0;
    private ArrayList<Boolean> gtR = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface b {
        void a(int i, int[] iArr, boolean z);
    }

    public c(ViewGroup viewGroup) {
        this.gtQ = viewGroup;
        bQa();
    }

    private void bQa() {
        if (this.gtR != null) {
            this.gtR.clear();
            this.gtR.addAll(Arrays.asList(new Boolean[this.gtP.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int[] iArr, boolean z) {
        if (i >= 0) {
            this.gtR.set(i, true);
            this.gtS = i;
            if (this.gtT != null) {
                this.gtT.a(i, iArr, z);
            }
        }
    }

    public void Fr(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gtP.length; i++) {
                if (str.equals(this.gtP[i].gtW)) {
                    b(i, null, false);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gtT = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gtP.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.gtP.length) {
            return null;
        }
        return this.gtP[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0615c c0615c;
        if (view == null) {
            C0615c c0615c2 = new C0615c();
            c0615c2.gtY = new BeautyItemView(this.gtQ.getContext());
            c0615c2.gtY.setTag(c0615c2);
            c0615c = c0615c2;
        } else {
            c0615c = (C0615c) view.getTag();
        }
        if (this.gtR.get(i) == null || !this.gtR.get(i).booleanValue()) {
            c0615c.gtY.setUnselectedBackground();
        } else {
            c0615c.gtY.setSelectedBackground();
        }
        c0615c.gtY.setItemIcon(this.gtP[i % this.gtP.length].ffK);
        c0615c.gtY.setItemText(this.gtP[i % this.gtP.length].gtV);
        c0615c.gtY.setRedotVisible(Fs(this.gtP[i % this.gtP.length].gtW));
        c0615c.gtY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof C0615c)) {
                    ((C0615c) view2.getTag()).gtY.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (c.this.gtT != null) {
                        c.this.gtT.a(i, iArr, true);
                        return;
                    }
                    return;
                }
                if (c.this.gtS != i) {
                    View childAt = c.this.gtQ.getChildAt(c.this.gtS);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gtS >= 0) {
                        c.this.gtR.set(c.this.gtS, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0615c) view2.getTag()).gtY.setSelectedBackground();
                }
                c.this.b(i, iArr, true);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gtC != 0) {
            c0615c.gtY.setPadding(this.gtC, 0, 0, 0);
        } else {
            c0615c.gtY.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            c0615c.gtY.gtM.setVisibility(8);
            c0615c.gtY.gtI.setVisibility(8);
            c0615c.gtY.gtN.setVisibility(0);
        } else {
            c0615c.gtY.gtM.setVisibility(0);
            c0615c.gtY.gtI.setVisibility(0);
            c0615c.gtY.gtN.setVisibility(8);
        }
        return c0615c.gtY;
    }

    private boolean Fs(String str) {
        if (com.baidu.live.d.xf().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bQb()) {
            return true;
        }
        return Ft(str) && com.baidu.live.d.xf().getBoolean(str, true);
    }

    public boolean bQb() {
        return com.baidu.live.d.xf().getBoolean("naturalFace", true) || com.baidu.live.d.xf().getBoolean("goddessFace", true) || com.baidu.live.d.xf().getBoolean("babyFace", true);
    }

    private boolean Ft(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void Fu(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && Ft(str)) {
            com.baidu.live.d.xf().putBoolean(str, false);
        }
    }

    public void tq(int i) {
        this.gtC = i;
    }

    /* renamed from: com.baidu.tieba.ala.alaar.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0615c {
        BeautyItemView gtY;

        public C0615c() {
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public int dyG;
        public int dyH;
        public int ffK;
        public String gtV;
        public String gtW;
        public int gtX;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.ffK = i;
            this.gtW = str;
            this.dyG = i2;
            this.dyH = i3;
            this.gtV = str2;
            this.gtX = i4;
        }
    }
}
