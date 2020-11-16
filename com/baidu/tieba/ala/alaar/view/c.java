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
    private ViewGroup gfQ;
    private b gfT;
    public final a[] gfP = {new a(a.e.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.e.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.e.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.e.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.e.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.e.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.e.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.e.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.e.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.e.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.e.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.e.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.e.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.e.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.e.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.e.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int gfS = -1;
    private int gfC = 0;
    private ArrayList<Boolean> gfR = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, int[] iArr, boolean z);
    }

    public c(ViewGroup viewGroup) {
        this.gfQ = viewGroup;
        bNH();
    }

    private void bNH() {
        if (this.gfR != null) {
            this.gfR.clear();
            this.gfR.addAll(Arrays.asList(new Boolean[this.gfP.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int[] iArr, boolean z) {
        if (i >= 0) {
            this.gfR.set(i, true);
            this.gfS = i;
            if (this.gfT != null) {
                this.gfT.a(i, iArr, z);
            }
        }
    }

    public void FQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gfP.length; i++) {
                if (str.equals(this.gfP[i].gfV)) {
                    b(i, null, false);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gfT = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gfP.length;
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
            c0629c2.gfX = new BeautyItemView(this.gfQ.getContext());
            c0629c2.gfX.setTag(c0629c2);
            c0629c = c0629c2;
        } else {
            c0629c = (C0629c) view.getTag();
        }
        if (this.gfR.get(i) == null || !this.gfR.get(i).booleanValue()) {
            c0629c.gfX.setUnselectedBackground();
        } else {
            c0629c.gfX.setSelectedBackground();
        }
        c0629c.gfX.setItemIcon(this.gfP[i % this.gfP.length].mDrawableId);
        c0629c.gfX.setItemText(this.gfP[i % this.gfP.length].mShowName);
        c0629c.gfX.setRedotVisible(FR(this.gfP[i % this.gfP.length].gfV));
        c0629c.gfX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof C0629c)) {
                    ((C0629c) view2.getTag()).gfX.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (c.this.gfT != null) {
                        c.this.gfT.a(i, iArr, true);
                        return;
                    }
                    return;
                }
                if (c.this.gfS != i) {
                    View childAt = c.this.gfQ.getChildAt(c.this.gfS);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gfS >= 0) {
                        c.this.gfR.set(c.this.gfS, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0629c) view2.getTag()).gfX.setSelectedBackground();
                }
                c.this.b(i, iArr, true);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gfC != 0) {
            c0629c.gfX.setPadding(this.gfC, 0, 0, 0);
        } else {
            c0629c.gfX.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            c0629c.gfX.gfM.setVisibility(8);
            c0629c.gfX.gfI.setVisibility(8);
            c0629c.gfX.gfN.setVisibility(0);
        } else {
            c0629c.gfX.gfM.setVisibility(0);
            c0629c.gfX.gfI.setVisibility(0);
            c0629c.gfX.gfN.setVisibility(8);
        }
        return c0629c.gfX;
    }

    private boolean FR(String str) {
        if (com.baidu.live.d.Aq().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bNI()) {
            return true;
        }
        return FS(str) && com.baidu.live.d.Aq().getBoolean(str, true);
    }

    public boolean bNI() {
        return com.baidu.live.d.Aq().getBoolean("naturalFace", true) || com.baidu.live.d.Aq().getBoolean("goddessFace", true) || com.baidu.live.d.Aq().getBoolean("babyFace", true);
    }

    private boolean FS(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void FT(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && FS(str)) {
            com.baidu.live.d.Aq().putBoolean(str, false);
        }
    }

    public void ug(int i) {
        this.gfC = i;
    }

    /* renamed from: com.baidu.tieba.ala.alaar.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0629c {
        BeautyItemView gfX;

        public C0629c() {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public String gfV;
        public int gfW;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.gfV = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.gfW = i4;
        }
    }
}
