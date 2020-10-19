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
    private ViewGroup fRe;
    private InterfaceC0601b fRu;
    public final a[] fRr = {new a(a.f.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.f.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.f.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.f.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.f.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.f.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.f.ar_beauty_face_width, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), "窄脸", 0, 100, 0), new a(a.f.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.f.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.f.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.f.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.f.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50), new a(a.f.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "瘦鼻", 0, 100, 0), new a(a.f.ar_beauty_nose_length, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), "鼻长", -50, 50, 50), new a(a.f.ar_beauty_eye_distance, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), "眼距", -50, 50, 50), new a(a.f.ar_beauty_upcount, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), "额头", -50, 50, 50)};
    private int fRt = -1;
    private int fRg = 0;
    private ArrayList<Boolean> fRs = new ArrayList<>();

    /* renamed from: com.baidu.tieba.ala.alaar.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0601b {
        void b(int i, int[] iArr);
    }

    public b(ViewGroup viewGroup) {
        this.fRe = viewGroup;
        bJo();
    }

    private void bJo() {
        if (this.fRs != null) {
            this.fRs.clear();
            this.fRs.addAll(Arrays.asList(new Boolean[this.fRr.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr) {
        if (i >= 0) {
            this.fRs.set(i, true);
            this.fRt = i;
            if (this.fRu != null) {
                this.fRu.b(i, iArr);
            }
        }
    }

    public void FC(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.fRr.length; i++) {
                if (str.equals(this.fRr[i].fRw)) {
                    c(i, null);
                    return;
                }
            }
        }
    }

    public void a(InterfaceC0601b interfaceC0601b) {
        this.fRu = interfaceC0601b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fRr.length;
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
            cVar2.fRy = new BeautyItemView(this.fRe.getContext());
            cVar2.fRy.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        if (this.fRs.get(i) == null || !this.fRs.get(i).booleanValue()) {
            cVar.fRy.setUnselectedBackground();
        } else {
            cVar.fRy.setSelectedBackground();
        }
        cVar.fRy.setItemIcon(this.fRr[i % this.fRr.length].mDrawableId);
        cVar.fRy.setItemText(this.fRr[i % this.fRr.length].mShowName);
        cVar.fRy.setRedotVisible(FD(this.fRr[i % this.fRr.length].fRw));
        cVar.fRy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof c)) {
                    ((c) view2.getTag()).fRy.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (b.this.fRu != null) {
                        b.this.fRu.b(i, iArr);
                        return;
                    }
                    return;
                }
                if (b.this.fRt != i) {
                    View childAt = b.this.fRe.getChildAt(b.this.fRt);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (b.this.fRt >= 0) {
                        b.this.fRs.set(b.this.fRt, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((c) view2.getTag()).fRy.setSelectedBackground();
                }
                b.this.c(i, iArr);
                b.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.fRg != 0) {
            cVar.fRy.setPadding(this.fRg, 0, 0, 0);
        } else {
            cVar.fRy.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            cVar.fRy.fRo.setVisibility(8);
            cVar.fRy.fRl.setVisibility(8);
            cVar.fRy.fRp.setVisibility(0);
        } else {
            cVar.fRy.fRo.setVisibility(0);
            cVar.fRy.fRl.setVisibility(0);
            cVar.fRy.fRp.setVisibility(8);
        }
        return cVar.fRy;
    }

    private boolean FD(String str) {
        if (com.baidu.live.c.AZ().getInt("beauty_subitem_redot", 0) != 1) {
            return false;
        }
        if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && bJp()) {
            return true;
        }
        return FE(str) && com.baidu.live.c.AZ().getBoolean(str, true);
    }

    public boolean bJp() {
        return com.baidu.live.c.AZ().getBoolean("naturalFace", true) || com.baidu.live.c.AZ().getBoolean("goddessFace", true) || com.baidu.live.c.AZ().getBoolean("babyFace", true);
    }

    private boolean FE(String str) {
        return TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey()) || TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey());
    }

    public void FF(String str) {
        if (!TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && FE(str)) {
            com.baidu.live.c.AZ().putBoolean(str, false);
        }
    }

    public void tn(int i) {
        this.fRg = i;
    }

    /* loaded from: classes4.dex */
    public class c {
        BeautyItemView fRy;

        public c() {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public String fRw;
        public int fRx;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.fRw = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.fRx = i4;
        }
    }
}
