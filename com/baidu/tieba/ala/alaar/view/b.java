package com.baidu.tieba.ala.alaar.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private InterfaceC0476b eND;
    private ViewGroup eNo;
    public final a[] eNA = {new a(a.f.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.f.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.f.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.f.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.f.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.f.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.f.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.f.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.f.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.f.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.f.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "鼻宽", 0, 100, 0), new a(a.f.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50)};
    private int eNC = -1;
    private int eNq = 0;
    private ArrayList<Boolean> eNB = new ArrayList<>();

    /* renamed from: com.baidu.tieba.ala.alaar.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0476b {
        void b(int i, int[] iArr);
    }

    public b(ViewGroup viewGroup) {
        this.eNo = viewGroup;
        bkK();
    }

    private void bkK() {
        if (this.eNB != null) {
            this.eNB.clear();
            this.eNB.addAll(Arrays.asList(new Boolean[this.eNA.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr) {
        if (i >= 0) {
            this.eNB.set(i, true);
            this.eNC = i;
            if (this.eND != null) {
                this.eND.b(i, iArr);
            }
        }
    }

    public void zo(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.eNA.length; i++) {
                if (str.equals(this.eNA[i].eNF)) {
                    c(i, null);
                    return;
                }
            }
        }
    }

    public void a(InterfaceC0476b interfaceC0476b) {
        this.eND = interfaceC0476b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eNA.length;
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
            cVar2.eNH = new BeautyItemView(this.eNo.getContext());
            cVar2.eNH.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        if (this.eNB.get(i) == null || !this.eNB.get(i).booleanValue()) {
            cVar.eNH.setUnselectedBackground();
        } else {
            cVar.eNH.setSelectedBackground();
        }
        cVar.eNH.setItemIcon(this.eNA[i % this.eNA.length].mDrawableId);
        cVar.eNH.setItemText(this.eNA[i % this.eNA.length].mShowName);
        cVar.eNH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof c)) {
                    ((c) view2.getTag()).eNH.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (b.this.eND != null) {
                        b.this.eND.b(i, iArr);
                        return;
                    }
                    return;
                }
                if (b.this.eNC != i) {
                    View childAt = b.this.eNo.getChildAt(b.this.eNC);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (b.this.eNC >= 0) {
                        b.this.eNB.set(b.this.eNC, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((c) view2.getTag()).eNH.setSelectedBackground();
                }
                b.this.c(i, iArr);
                b.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eNq != 0) {
            cVar.eNH.setPadding(this.eNq, 0, 0, 0);
        } else {
            cVar.eNH.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            cVar.eNH.eNy.setVisibility(8);
            cVar.eNH.eNv.setVisibility(8);
            cVar.eNH.eNz.setVisibility(0);
        } else {
            cVar.eNH.eNy.setVisibility(0);
            cVar.eNH.eNv.setVisibility(0);
            cVar.eNH.eNz.setVisibility(8);
        }
        return cVar.eNH;
    }

    public void oV(int i) {
        this.eNq = i;
    }

    /* loaded from: classes3.dex */
    public class c {
        BeautyItemView eNH;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public String eNF;
        public int eNG;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.eNF = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.eNG = i4;
        }
    }
}
