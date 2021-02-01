package com.baidu.tieba.ala.alaar.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes11.dex */
public class c extends BaseAdapter {
    private ViewGroup gwA;
    private b gwD;
    public final a[] gwz = {new a(a.e.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.e.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.e.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.e.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.e.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.e.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.e.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.e.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.e.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.e.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.e.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.e.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.e.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.e.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.e.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.e.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int gwC = -1;
    private int gwm = 0;
    private ArrayList<Boolean> gwB = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface b {
        void b(int i, int[] iArr, boolean z);
    }

    public c(ViewGroup viewGroup) {
        this.gwA = viewGroup;
        bQE();
    }

    private void bQE() {
        if (this.gwB != null) {
            this.gwB.clear();
            this.gwB.addAll(Arrays.asList(new Boolean[this.gwz.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr, boolean z) {
        if (i >= 0) {
            this.gwB.set(i, true);
            this.gwC = i;
            if (this.gwD != null) {
                this.gwD.b(i, iArr, z);
            }
        }
    }

    public void FP(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gwz.length; i++) {
                if (str.equals(this.gwz[i].gwG)) {
                    c(i, null, false);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gwD = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gwz.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.gwz.length) {
            return null;
        }
        return this.gwz[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0614c c0614c;
        if (view == null) {
            C0614c c0614c2 = new C0614c();
            c0614c2.gwI = new BeautyItemView(this.gwA.getContext());
            c0614c2.gwI.setTag(c0614c2);
            c0614c = c0614c2;
        } else {
            c0614c = (C0614c) view.getTag();
        }
        if (this.gwB.get(i) == null || !this.gwB.get(i).booleanValue()) {
            c0614c.gwI.setUnselectedBackground();
        } else {
            c0614c.gwI.setSelectedBackground();
        }
        c0614c.gwI.setItemIcon(this.gwz[i % this.gwz.length].fia);
        c0614c.gwI.setItemText(this.gwz[i % this.gwz.length].gwF);
        c0614c.gwI.setRedotVisible(FQ(this.gwz[i % this.gwz.length].gwG));
        c0614c.gwI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof C0614c)) {
                    ((C0614c) view2.getTag()).gwI.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (c.this.gwD != null) {
                        c.this.gwD.b(i, iArr, true);
                        return;
                    }
                    return;
                }
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
                    ((C0614c) view2.getTag()).gwI.setSelectedBackground();
                }
                c.this.c(i, iArr, true);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gwm != 0) {
            c0614c.gwI.setPadding(this.gwm, 0, 0, 0);
        } else {
            c0614c.gwI.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            c0614c.gwI.gww.setVisibility(8);
            c0614c.gwI.gws.setVisibility(8);
            c0614c.gwI.gwx.setVisibility(0);
        } else {
            c0614c.gwI.gww.setVisibility(0);
            c0614c.gwI.gws.setVisibility(0);
            c0614c.gwI.gwx.setVisibility(8);
        }
        return c0614c.gwI;
    }

    private boolean FQ(String str) {
        if (com.baidu.live.d.xc().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bQF()) {
            return true;
        }
        return FR(str) && com.baidu.live.d.xc().getBoolean(str, true);
    }

    public boolean bQF() {
        return com.baidu.live.d.xc().getBoolean("naturalFace", true) || com.baidu.live.d.xc().getBoolean("goddessFace", true) || com.baidu.live.d.xc().getBoolean("babyFace", true);
    }

    private boolean FR(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void FS(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && FR(str)) {
            com.baidu.live.d.xc().putBoolean(str, false);
        }
    }

    public void tw(int i) {
        this.gwm = i;
    }

    /* renamed from: com.baidu.tieba.ala.alaar.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0614c {
        BeautyItemView gwI;

        public C0614c() {
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int dAL;
        public int dAM;
        public int fia;
        public String gwF;
        public String gwG;
        public int gwH;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.fia = i;
            this.gwG = str;
            this.dAL = i2;
            this.dAM = i3;
            this.gwF = str2;
            this.gwH = i4;
        }
    }
}
