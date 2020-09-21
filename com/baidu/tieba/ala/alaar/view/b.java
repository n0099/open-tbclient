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
public class b extends BaseAdapter {
    private ViewGroup fEV;
    private InterfaceC0584b fFl;
    public final a[] fFi = {new a(a.f.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.f.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.f.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.f.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.f.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.f.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.f.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.f.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.f.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.f.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.f.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.f.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.f.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.f.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.f.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.f.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int fFk = -1;
    private int fEX = 0;
    private ArrayList<Boolean> fFj = new ArrayList<>();

    /* renamed from: com.baidu.tieba.ala.alaar.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0584b {
        void b(int i, int[] iArr);
    }

    public b(ViewGroup viewGroup) {
        this.fEV = viewGroup;
        bGC();
    }

    private void bGC() {
        if (this.fFj != null) {
            this.fFj.clear();
            this.fFj.addAll(Arrays.asList(new Boolean[this.fFi.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr) {
        if (i >= 0) {
            this.fFj.set(i, true);
            this.fFk = i;
            if (this.fFl != null) {
                this.fFl.b(i, iArr);
            }
        }
    }

    public void ER(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.fFi.length; i++) {
                if (str.equals(this.fFi[i].fFn)) {
                    c(i, null);
                    return;
                }
            }
        }
    }

    public void a(InterfaceC0584b interfaceC0584b) {
        this.fFl = interfaceC0584b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fFi.length;
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
            cVar2.fFp = new BeautyItemView(this.fEV.getContext());
            cVar2.fFp.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        if (this.fFj.get(i) == null || !this.fFj.get(i).booleanValue()) {
            cVar.fFp.setUnselectedBackground();
        } else {
            cVar.fFp.setSelectedBackground();
        }
        cVar.fFp.setItemIcon(this.fFi[i % this.fFi.length].mDrawableId);
        cVar.fFp.setItemText(this.fFi[i % this.fFi.length].mShowName);
        cVar.fFp.setRedotVisible(ES(this.fFi[i % this.fFi.length].fFn));
        cVar.fFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof c)) {
                    ((c) view2.getTag()).fFp.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (b.this.fFl != null) {
                        b.this.fFl.b(i, iArr);
                        return;
                    }
                    return;
                }
                if (b.this.fFk != i) {
                    View childAt = b.this.fEV.getChildAt(b.this.fFk);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (b.this.fFk >= 0) {
                        b.this.fFj.set(b.this.fFk, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((c) view2.getTag()).fFp.setSelectedBackground();
                }
                b.this.c(i, iArr);
                b.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fEX != 0) {
            cVar.fFp.setPadding(this.fEX, 0, 0, 0);
        } else {
            cVar.fFp.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            cVar.fFp.fFf.setVisibility(8);
            cVar.fFp.fFc.setVisibility(8);
            cVar.fFp.fFg.setVisibility(0);
        } else {
            cVar.fFp.fFf.setVisibility(0);
            cVar.fFp.fFc.setVisibility(0);
            cVar.fFp.fFg.setVisibility(8);
        }
        return cVar.fFp;
    }

    private boolean ES(String str) {
        if (com.baidu.live.c.AR().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bGD()) {
            return true;
        }
        return ET(str) && com.baidu.live.c.AR().getBoolean(str, true);
    }

    public boolean bGD() {
        return com.baidu.live.c.AR().getBoolean("naturalFace", true) || com.baidu.live.c.AR().getBoolean("goddessFace", true) || com.baidu.live.c.AR().getBoolean("babyFace", true);
    }

    private boolean ET(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void EU(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && ET(str)) {
            com.baidu.live.c.AR().putBoolean(str, false);
        }
    }

    public void sP(int i) {
        this.fEX = i;
    }

    /* loaded from: classes4.dex */
    public class c {
        BeautyItemView fFp;

        public c() {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public String fFn;
        public int fFo;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.fFn = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.fFo = i4;
        }
    }
}
