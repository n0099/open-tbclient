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
    private ViewGroup fqj;
    private InterfaceC0542b fqz;
    public final a[] fqw = {new a(a.f.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.f.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.f.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.f.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.f.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.f.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.f.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.f.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.f.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.f.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.f.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.f.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.f.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.f.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.f.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.f.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int fqy = -1;
    private int fql = 0;
    private ArrayList<Boolean> fqx = new ArrayList<>();

    /* renamed from: com.baidu.tieba.ala.alaar.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0542b {
        void b(int i, int[] iArr);
    }

    public b(ViewGroup viewGroup) {
        this.fqj = viewGroup;
        bwm();
    }

    private void bwm() {
        if (this.fqx != null) {
            this.fqx.clear();
            this.fqx.addAll(Arrays.asList(new Boolean[this.fqw.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr) {
        if (i >= 0) {
            this.fqx.set(i, true);
            this.fqy = i;
            if (this.fqz != null) {
                this.fqz.b(i, iArr);
            }
        }
    }

    public void BY(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.fqw.length; i++) {
                if (str.equals(this.fqw[i].fqB)) {
                    c(i, null);
                    return;
                }
            }
        }
    }

    public void a(InterfaceC0542b interfaceC0542b) {
        this.fqz = interfaceC0542b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fqw.length;
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
            cVar2.fqD = new BeautyItemView(this.fqj.getContext());
            cVar2.fqD.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        if (this.fqx.get(i) == null || !this.fqx.get(i).booleanValue()) {
            cVar.fqD.setUnselectedBackground();
        } else {
            cVar.fqD.setSelectedBackground();
        }
        cVar.fqD.setItemIcon(this.fqw[i % this.fqw.length].mDrawableId);
        cVar.fqD.setItemText(this.fqw[i % this.fqw.length].mShowName);
        cVar.fqD.setRedotVisible(BZ(this.fqw[i % this.fqw.length].fqB));
        cVar.fqD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof c)) {
                    ((c) view2.getTag()).fqD.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (b.this.fqz != null) {
                        b.this.fqz.b(i, iArr);
                        return;
                    }
                    return;
                }
                if (b.this.fqy != i) {
                    View childAt = b.this.fqj.getChildAt(b.this.fqy);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (b.this.fqy >= 0) {
                        b.this.fqx.set(b.this.fqy, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((c) view2.getTag()).fqD.setSelectedBackground();
                }
                b.this.c(i, iArr);
                b.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fql != 0) {
            cVar.fqD.setPadding(this.fql, 0, 0, 0);
        } else {
            cVar.fqD.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            cVar.fqD.fqt.setVisibility(8);
            cVar.fqD.fqq.setVisibility(8);
            cVar.fqD.fqu.setVisibility(0);
        } else {
            cVar.fqD.fqt.setVisibility(0);
            cVar.fqD.fqq.setVisibility(0);
            cVar.fqD.fqu.setVisibility(8);
        }
        return cVar.fqD;
    }

    private boolean BZ(String str) {
        if (com.baidu.live.c.vf().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bwn()) {
            return true;
        }
        return Ca(str) && com.baidu.live.c.vf().getBoolean(str, true);
    }

    public boolean bwn() {
        return com.baidu.live.c.vf().getBoolean("naturalFace", true) || com.baidu.live.c.vf().getBoolean("goddessFace", true) || com.baidu.live.c.vf().getBoolean("babyFace", true);
    }

    private boolean Ca(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void Cb(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && Ca(str)) {
            com.baidu.live.c.vf().putBoolean(str, false);
        }
    }

    public void ql(int i) {
        this.fql = i;
    }

    /* loaded from: classes4.dex */
    public class c {
        BeautyItemView fqD;

        public c() {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public String fqB;
        public int fqC;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.fqB = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.fqC = i4;
        }
    }
}
