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
    private b gyA;
    private ViewGroup gyx;
    public final a[] gyw = {new a(a.e.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.e.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.e.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.e.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.e.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.e.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.e.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.e.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.e.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.e.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.e.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.e.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.e.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.e.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.e.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.e.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int gyz = -1;
    private int gyj = 0;
    private ArrayList<Boolean> gyy = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface b {
        void b(int i, int[] iArr, boolean z);
    }

    public c(ViewGroup viewGroup) {
        this.gyx = viewGroup;
        bQR();
    }

    private void bQR() {
        if (this.gyy != null) {
            this.gyy.clear();
            this.gyy.addAll(Arrays.asList(new Boolean[this.gyw.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr, boolean z) {
        if (i >= 0) {
            this.gyy.set(i, true);
            this.gyz = i;
            if (this.gyA != null) {
                this.gyA.b(i, iArr, z);
            }
        }
    }

    public void FZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gyw.length; i++) {
                if (str.equals(this.gyw[i].gyD)) {
                    c(i, null, false);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gyA = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gyw.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.gyw.length) {
            return null;
        }
        return this.gyw[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0621c c0621c;
        if (view == null) {
            C0621c c0621c2 = new C0621c();
            c0621c2.gyF = new BeautyItemView(this.gyx.getContext());
            c0621c2.gyF.setTag(c0621c2);
            c0621c = c0621c2;
        } else {
            c0621c = (C0621c) view.getTag();
        }
        if (this.gyy.get(i) == null || !this.gyy.get(i).booleanValue()) {
            c0621c.gyF.setUnselectedBackground();
        } else {
            c0621c.gyF.setSelectedBackground();
        }
        c0621c.gyF.setItemIcon(this.gyw[i % this.gyw.length].fjC);
        c0621c.gyF.setItemText(this.gyw[i % this.gyw.length].gyC);
        c0621c.gyF.setRedotVisible(Ga(this.gyw[i % this.gyw.length].gyD));
        c0621c.gyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof C0621c)) {
                    ((C0621c) view2.getTag()).gyF.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (c.this.gyA != null) {
                        c.this.gyA.b(i, iArr, true);
                        return;
                    }
                    return;
                }
                if (c.this.gyz != i) {
                    View childAt = c.this.gyx.getChildAt(c.this.gyz);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gyz >= 0) {
                        c.this.gyy.set(c.this.gyz, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0621c) view2.getTag()).gyF.setSelectedBackground();
                }
                c.this.c(i, iArr, true);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gyj != 0) {
            c0621c.gyF.setPadding(this.gyj, 0, 0, 0);
        } else {
            c0621c.gyF.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            c0621c.gyF.gyt.setVisibility(8);
            c0621c.gyF.gyp.setVisibility(8);
            c0621c.gyF.gyu.setVisibility(0);
        } else {
            c0621c.gyF.gyt.setVisibility(0);
            c0621c.gyF.gyp.setVisibility(0);
            c0621c.gyF.gyu.setVisibility(8);
        }
        return c0621c.gyF;
    }

    private boolean Ga(String str) {
        if (com.baidu.live.d.xf().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bQS()) {
            return true;
        }
        return Gb(str) && com.baidu.live.d.xf().getBoolean(str, true);
    }

    public boolean bQS() {
        return com.baidu.live.d.xf().getBoolean("naturalFace", true) || com.baidu.live.d.xf().getBoolean("goddessFace", true) || com.baidu.live.d.xf().getBoolean("babyFace", true);
    }

    private boolean Gb(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void Gc(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && Gb(str)) {
            com.baidu.live.d.xf().putBoolean(str, false);
        }
    }

    public void ty(int i) {
        this.gyj = i;
    }

    /* renamed from: com.baidu.tieba.ala.alaar.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0621c {
        BeautyItemView gyF;

        public C0621c() {
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public int dCm;
        public int dCn;
        public int fjC;
        public String gyC;
        public String gyD;
        public int gyE;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.fjC = i;
            this.gyD = str;
            this.dCm = i2;
            this.dCn = i3;
            this.gyC = str2;
            this.gyE = i4;
        }
    }
}
