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
    private ViewGroup gwO;
    private b gwR;
    public final a[] gwN = {new a(a.e.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.e.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.e.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.e.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.e.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.e.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.e.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.e.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.e.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.e.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.e.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.e.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.e.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.e.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.e.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.e.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int gwQ = -1;
    private int gwA = 0;
    private ArrayList<Boolean> gwP = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface b {
        void b(int i, int[] iArr, boolean z);
    }

    public c(ViewGroup viewGroup) {
        this.gwO = viewGroup;
        bQL();
    }

    private void bQL() {
        if (this.gwP != null) {
            this.gwP.clear();
            this.gwP.addAll(Arrays.asList(new Boolean[this.gwN.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr, boolean z) {
        if (i >= 0) {
            this.gwP.set(i, true);
            this.gwQ = i;
            if (this.gwR != null) {
                this.gwR.b(i, iArr, z);
            }
        }
    }

    public void FQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gwN.length; i++) {
                if (str.equals(this.gwN[i].gwU)) {
                    c(i, null, false);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gwR = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gwN.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.gwN.length) {
            return null;
        }
        return this.gwN[i];
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
            c0615c2.gwW = new BeautyItemView(this.gwO.getContext());
            c0615c2.gwW.setTag(c0615c2);
            c0615c = c0615c2;
        } else {
            c0615c = (C0615c) view.getTag();
        }
        if (this.gwP.get(i) == null || !this.gwP.get(i).booleanValue()) {
            c0615c.gwW.setUnselectedBackground();
        } else {
            c0615c.gwW.setSelectedBackground();
        }
        c0615c.gwW.setItemIcon(this.gwN[i % this.gwN.length].fia);
        c0615c.gwW.setItemText(this.gwN[i % this.gwN.length].gwT);
        c0615c.gwW.setRedotVisible(FR(this.gwN[i % this.gwN.length].gwU));
        c0615c.gwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof C0615c)) {
                    ((C0615c) view2.getTag()).gwW.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (c.this.gwR != null) {
                        c.this.gwR.b(i, iArr, true);
                        return;
                    }
                    return;
                }
                if (c.this.gwQ != i) {
                    View childAt = c.this.gwO.getChildAt(c.this.gwQ);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gwQ >= 0) {
                        c.this.gwP.set(c.this.gwQ, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0615c) view2.getTag()).gwW.setSelectedBackground();
                }
                c.this.c(i, iArr, true);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gwA != 0) {
            c0615c.gwW.setPadding(this.gwA, 0, 0, 0);
        } else {
            c0615c.gwW.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            c0615c.gwW.gwK.setVisibility(8);
            c0615c.gwW.gwG.setVisibility(8);
            c0615c.gwW.gwL.setVisibility(0);
        } else {
            c0615c.gwW.gwK.setVisibility(0);
            c0615c.gwW.gwG.setVisibility(0);
            c0615c.gwW.gwL.setVisibility(8);
        }
        return c0615c.gwW;
    }

    private boolean FR(String str) {
        if (com.baidu.live.d.xc().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bQM()) {
            return true;
        }
        return FS(str) && com.baidu.live.d.xc().getBoolean(str, true);
    }

    public boolean bQM() {
        return com.baidu.live.d.xc().getBoolean("naturalFace", true) || com.baidu.live.d.xc().getBoolean("goddessFace", true) || com.baidu.live.d.xc().getBoolean("babyFace", true);
    }

    private boolean FS(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void FT(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && FS(str)) {
            com.baidu.live.d.xc().putBoolean(str, false);
        }
    }

    public void tw(int i) {
        this.gwA = i;
    }

    /* renamed from: com.baidu.tieba.ala.alaar.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0615c {
        BeautyItemView gwW;

        public C0615c() {
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int dAL;
        public int dAM;
        public int fia;
        public String gwT;
        public String gwU;
        public int gwV;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.fia = i;
            this.gwU = str;
            this.dAL = i2;
            this.dAM = i3;
            this.gwT = str2;
            this.gwV = i4;
        }
    }
}
