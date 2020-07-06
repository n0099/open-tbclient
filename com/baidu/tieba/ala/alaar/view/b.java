package com.baidu.tieba.ala.alaar.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ViewGroup flb;
    private InterfaceC0531b flr;
    public final a[] flo = {new a(a.f.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.f.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.f.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.f.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.f.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.f.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.f.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.f.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.f.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.f.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.f.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.f.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.f.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.f.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.f.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.f.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int flq = -1;
    private int fld = 0;
    private ArrayList<Boolean> flp = new ArrayList<>();

    /* renamed from: com.baidu.tieba.ala.alaar.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0531b {
        void b(int i, int[] iArr);
    }

    public b(ViewGroup viewGroup) {
        this.flb = viewGroup;
        btd();
    }

    private void btd() {
        if (this.flp != null) {
            this.flp.clear();
            this.flp.addAll(Arrays.asList(new Boolean[this.flo.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr) {
        if (i >= 0) {
            this.flp.set(i, true);
            this.flq = i;
            if (this.flr != null) {
                this.flr.b(i, iArr);
            }
        }
    }

    public void Bn(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.flo.length; i++) {
                if (str.equals(this.flo[i].flt)) {
                    c(i, null);
                    return;
                }
            }
        }
    }

    public void a(InterfaceC0531b interfaceC0531b) {
        this.flr = interfaceC0531b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.flo.length;
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
        c cVar;
        if (view == null) {
            c cVar2 = new c();
            cVar2.flv = new BeautyItemView(this.flb.getContext());
            cVar2.flv.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        if (this.flp.get(i) == null || !this.flp.get(i).booleanValue()) {
            cVar.flv.setUnselectedBackground();
        } else {
            cVar.flv.setSelectedBackground();
        }
        cVar.flv.setItemIcon(this.flo[i % this.flo.length].mDrawableId);
        cVar.flv.setItemText(this.flo[i % this.flo.length].mShowName);
        cVar.flv.setRedotVisible(Bo(this.flo[i % this.flo.length].flt));
        cVar.flv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof c)) {
                    ((c) view2.getTag()).flv.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (b.this.flr != null) {
                        b.this.flr.b(i, iArr);
                        return;
                    }
                    return;
                }
                if (b.this.flq != i) {
                    View childAt = b.this.flb.getChildAt(b.this.flq);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (b.this.flq >= 0) {
                        b.this.flp.set(b.this.flq, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((c) view2.getTag()).flv.setSelectedBackground();
                }
                b.this.c(i, iArr);
                b.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fld != 0) {
            cVar.flv.setPadding(this.fld, 0, 0, 0);
        } else {
            cVar.flv.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            cVar.flv.fll.setVisibility(8);
            cVar.flv.fli.setVisibility(8);
            cVar.flv.flm.setVisibility(0);
        } else {
            cVar.flv.fll.setVisibility(0);
            cVar.flv.fli.setVisibility(0);
            cVar.flv.flm.setVisibility(8);
        }
        return cVar.flv;
    }

    private boolean Bo(String str) {
        if (com.baidu.live.c.vf().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bte()) {
            return true;
        }
        return Bp(str) && com.baidu.live.c.vf().getBoolean(str, true);
    }

    public boolean bte() {
        return com.baidu.live.c.vf().getBoolean("naturalFace", true) || com.baidu.live.c.vf().getBoolean("goddessFace", true) || com.baidu.live.c.vf().getBoolean("babyFace", true);
    }

    private boolean Bp(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void Bq(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && Bp(str)) {
            com.baidu.live.c.vf().putBoolean(str, false);
        }
    }

    public void pW(int i) {
        this.fld = i;
    }

    /* loaded from: classes3.dex */
    public class c {
        BeautyItemView flv;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public String flt;
        public int flu;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.flt = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.flu = i4;
        }
    }
}
