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
    private ViewGroup gat;
    private b gaw;
    public final a[] gas = {new a(a.f.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.f.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.f.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.f.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.f.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.f.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.f.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.f.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.f.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.f.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.f.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.f.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.f.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.f.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.f.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.f.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int gav = -1;
    private int gae = 0;
    private ArrayList<Boolean> gau = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, int[] iArr, boolean z);
    }

    public c(ViewGroup viewGroup) {
        this.gat = viewGroup;
        bLO();
    }

    private void bLO() {
        if (this.gau != null) {
            this.gau.clear();
            this.gau.addAll(Arrays.asList(new Boolean[this.gas.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int[] iArr, boolean z) {
        if (i >= 0) {
            this.gau.set(i, true);
            this.gav = i;
            if (this.gaw != null) {
                this.gaw.a(i, iArr, z);
            }
        }
    }

    public void Gb(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.gas.length; i++) {
                if (str.equals(this.gas[i].gay)) {
                    b(i, null, false);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gaw = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gas.length;
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
        C0617c c0617c;
        if (view == null) {
            C0617c c0617c2 = new C0617c();
            c0617c2.gaA = new BeautyItemView(this.gat.getContext());
            c0617c2.gaA.setTag(c0617c2);
            c0617c = c0617c2;
        } else {
            c0617c = (C0617c) view.getTag();
        }
        if (this.gau.get(i) == null || !this.gau.get(i).booleanValue()) {
            c0617c.gaA.setUnselectedBackground();
        } else {
            c0617c.gaA.setSelectedBackground();
        }
        c0617c.gaA.setItemIcon(this.gas[i % this.gas.length].mDrawableId);
        c0617c.gaA.setItemText(this.gas[i % this.gas.length].mShowName);
        c0617c.gaA.setRedotVisible(Gc(this.gas[i % this.gas.length].gay));
        c0617c.gaA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof C0617c)) {
                    ((C0617c) view2.getTag()).gaA.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (c.this.gaw != null) {
                        c.this.gaw.a(i, iArr, true);
                        return;
                    }
                    return;
                }
                if (c.this.gav != i) {
                    View childAt = c.this.gat.getChildAt(c.this.gav);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.gav >= 0) {
                        c.this.gau.set(c.this.gav, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0617c) view2.getTag()).gaA.setSelectedBackground();
                }
                c.this.b(i, iArr, true);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.gae != 0) {
            c0617c.gaA.setPadding(this.gae, 0, 0, 0);
        } else {
            c0617c.gaA.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            c0617c.gaA.gao.setVisibility(8);
            c0617c.gaA.gak.setVisibility(8);
            c0617c.gaA.gaq.setVisibility(0);
        } else {
            c0617c.gaA.gao.setVisibility(0);
            c0617c.gaA.gak.setVisibility(0);
            c0617c.gaA.gaq.setVisibility(8);
        }
        return c0617c.gaA;
    }

    private boolean Gc(String str) {
        if (com.baidu.live.d.AZ().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bLP()) {
            return true;
        }
        return Gd(str) && com.baidu.live.d.AZ().getBoolean(str, true);
    }

    public boolean bLP() {
        return com.baidu.live.d.AZ().getBoolean("naturalFace", true) || com.baidu.live.d.AZ().getBoolean("goddessFace", true) || com.baidu.live.d.AZ().getBoolean("babyFace", true);
    }

    private boolean Gd(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void Ge(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && Gd(str)) {
            com.baidu.live.d.AZ().putBoolean(str, false);
        }
    }

    public void ty(int i) {
        this.gae = i;
    }

    /* renamed from: com.baidu.tieba.ala.alaar.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0617c {
        BeautyItemView gaA;

        public C0617c() {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public String gay;
        public int gaz;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.gay = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.gaz = i4;
        }
    }
}
