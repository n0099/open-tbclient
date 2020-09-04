package com.baidu.tieba.ala.alaar.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private ViewGroup fBJ;
    private InterfaceC0588b fBZ;
    public final a[] fBW = {new a(a.f.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.f.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.f.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.f.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.f.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.f.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.f.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.f.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.f.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.f.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.f.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.f.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.f.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.f.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.f.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.f.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int fBY = -1;
    private int fBL = 0;
    private ArrayList<Boolean> fBX = new ArrayList<>();

    /* renamed from: com.baidu.tieba.ala.alaar.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0588b {
        void b(int i, int[] iArr);
    }

    public b(ViewGroup viewGroup) {
        this.fBJ = viewGroup;
        bFm();
    }

    private void bFm() {
        if (this.fBX != null) {
            this.fBX.clear();
            this.fBX.addAll(Arrays.asList(new Boolean[this.fBW.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr) {
        if (i >= 0) {
            this.fBX.set(i, true);
            this.fBY = i;
            if (this.fBZ != null) {
                this.fBZ.b(i, iArr);
            }
        }
    }

    public void Et(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.fBW.length; i++) {
                if (str.equals(this.fBW[i].fCb)) {
                    c(i, null);
                    return;
                }
            }
        }
    }

    public void a(InterfaceC0588b interfaceC0588b) {
        this.fBZ = interfaceC0588b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fBW.length;
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
            cVar2.fCd = new BeautyItemView(this.fBJ.getContext());
            cVar2.fCd.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        if (this.fBX.get(i) == null || !this.fBX.get(i).booleanValue()) {
            cVar.fCd.setUnselectedBackground();
        } else {
            cVar.fCd.setSelectedBackground();
        }
        cVar.fCd.setItemIcon(this.fBW[i % this.fBW.length].mDrawableId);
        cVar.fCd.setItemText(this.fBW[i % this.fBW.length].mShowName);
        cVar.fCd.setRedotVisible(Eu(this.fBW[i % this.fBW.length].fCb));
        cVar.fCd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof c)) {
                    ((c) view2.getTag()).fCd.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (b.this.fBZ != null) {
                        b.this.fBZ.b(i, iArr);
                        return;
                    }
                    return;
                }
                if (b.this.fBY != i) {
                    View childAt = b.this.fBJ.getChildAt(b.this.fBY);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (b.this.fBY >= 0) {
                        b.this.fBX.set(b.this.fBY, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((c) view2.getTag()).fCd.setSelectedBackground();
                }
                b.this.c(i, iArr);
                b.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fBL != 0) {
            cVar.fCd.setPadding(this.fBL, 0, 0, 0);
        } else {
            cVar.fCd.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            cVar.fCd.fBT.setVisibility(8);
            cVar.fCd.fBQ.setVisibility(8);
            cVar.fCd.fBU.setVisibility(0);
        } else {
            cVar.fCd.fBT.setVisibility(0);
            cVar.fCd.fBQ.setVisibility(0);
            cVar.fCd.fBU.setVisibility(8);
        }
        return cVar.fCd;
    }

    private boolean Eu(String str) {
        if (com.baidu.live.c.AD().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bFn()) {
            return true;
        }
        return Ev(str) && com.baidu.live.c.AD().getBoolean(str, true);
    }

    public boolean bFn() {
        return com.baidu.live.c.AD().getBoolean("naturalFace", true) || com.baidu.live.c.AD().getBoolean("goddessFace", true) || com.baidu.live.c.AD().getBoolean("babyFace", true);
    }

    private boolean Ev(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void Ew(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && Ev(str)) {
            com.baidu.live.c.AD().putBoolean(str, false);
        }
    }

    public void sx(int i) {
        this.fBL = i;
    }

    /* loaded from: classes7.dex */
    public class c {
        BeautyItemView fCd;

        public c() {
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public String fCb;
        public int fCc;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.fCb = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.fCc = i4;
        }
    }
}
