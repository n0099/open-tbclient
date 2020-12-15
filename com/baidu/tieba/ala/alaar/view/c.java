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
    private ViewGroup goa;
    private b god;
    public final a[] gnZ = {new a(a.e.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.e.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.e.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.e.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.e.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.e.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.e.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.e.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.e.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.e.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.e.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.e.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.e.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.e.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.e.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.e.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int goc = -1;
    private int gnM = 0;
    private ArrayList<Boolean> gob = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, int[] iArr, boolean z);
    }

    public c(ViewGroup viewGroup) {
        this.goa = viewGroup;
        bRt();
    }

    private void bRt() {
        if (this.gob != null) {
            this.gob.clear();
            this.gob.addAll(Arrays.asList(new Boolean[this.gnZ.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int[] iArr, boolean z) {
        if (i >= 0) {
            this.gob.set(i, true);
            this.goc = i;
            if (this.god != null) {
                this.god.a(i, iArr, z);
            }
        }
    }

    public void GF(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gnZ.length; i++) {
                if (str.equals(this.gnZ[i].gog)) {
                    b(i, null, false);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.god = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gnZ.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.gnZ.length) {
            return null;
        }
        return this.gnZ[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0641c c0641c;
        if (view == null) {
            C0641c c0641c2 = new C0641c();
            c0641c2.goi = new BeautyItemView(this.goa.getContext());
            c0641c2.goi.setTag(c0641c2);
            c0641c = c0641c2;
        } else {
            c0641c = (C0641c) view.getTag();
        }
        if (this.gob.get(i) == null || !this.gob.get(i).booleanValue()) {
            c0641c.goi.setUnselectedBackground();
        } else {
            c0641c.goi.setSelectedBackground();
        }
        c0641c.goi.setItemIcon(this.gnZ[i % this.gnZ.length].faR);
        c0641c.goi.setItemText(this.gnZ[i % this.gnZ.length].gof);
        c0641c.goi.setRedotVisible(GG(this.gnZ[i % this.gnZ.length].gog));
        c0641c.goi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof C0641c)) {
                    ((C0641c) view2.getTag()).goi.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (c.this.god != null) {
                        c.this.god.a(i, iArr, true);
                        return;
                    }
                    return;
                }
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
                    ((C0641c) view2.getTag()).goi.setSelectedBackground();
                }
                c.this.b(i, iArr, true);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gnM != 0) {
            c0641c.goi.setPadding(this.gnM, 0, 0, 0);
        } else {
            c0641c.goi.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            c0641c.goi.gnW.setVisibility(8);
            c0641c.goi.gnS.setVisibility(8);
            c0641c.goi.gnX.setVisibility(0);
        } else {
            c0641c.goi.gnW.setVisibility(0);
            c0641c.goi.gnS.setVisibility(0);
            c0641c.goi.gnX.setVisibility(8);
        }
        return c0641c.goi;
    }

    private boolean GG(String str) {
        if (com.baidu.live.d.BM().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bRu()) {
            return true;
        }
        return GH(str) && com.baidu.live.d.BM().getBoolean(str, true);
    }

    public boolean bRu() {
        return com.baidu.live.d.BM().getBoolean("naturalFace", true) || com.baidu.live.d.BM().getBoolean("goddessFace", true) || com.baidu.live.d.BM().getBoolean("babyFace", true);
    }

    private boolean GH(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void GI(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && GH(str)) {
            com.baidu.live.d.BM().putBoolean(str, false);
        }
    }

    public void uK(int i) {
        this.gnM = i;
    }

    /* renamed from: com.baidu.tieba.ala.alaar.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0641c {
        BeautyItemView goi;

        public C0641c() {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public int faR;
        public String gof;
        public String gog;
        public int goh;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.faR = i;
            this.gog = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.gof = str2;
            this.goh = i4;
        }
    }
}
