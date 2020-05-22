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
    private ViewGroup eZL;
    private InterfaceC0523b faa;
    public final a[] eZX = {new a(a.f.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.f.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.f.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.f.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.f.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.f.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.f.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.f.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.f.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.f.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.f.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "鼻宽", 0, 100, 0), new a(a.f.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50)};
    private int eZZ = -1;
    private int eZN = 0;
    private ArrayList<Boolean> eZY = new ArrayList<>();

    /* renamed from: com.baidu.tieba.ala.alaar.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0523b {
        void b(int i, int[] iArr);
    }

    public b(ViewGroup viewGroup) {
        this.eZL = viewGroup;
        bqe();
    }

    private void bqe() {
        if (this.eZY != null) {
            this.eZY.clear();
            this.eZY.addAll(Arrays.asList(new Boolean[this.eZX.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr) {
        if (i >= 0) {
            this.eZY.set(i, true);
            this.eZZ = i;
            if (this.faa != null) {
                this.faa.b(i, iArr);
            }
        }
    }

    public void AU(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.eZX.length; i++) {
                if (str.equals(this.eZX[i].fac)) {
                    c(i, null);
                    return;
                }
            }
        }
    }

    public void a(InterfaceC0523b interfaceC0523b) {
        this.faa = interfaceC0523b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eZX.length;
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
            cVar2.fae = new BeautyItemView(this.eZL.getContext());
            cVar2.fae.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        if (this.eZY.get(i) == null || !this.eZY.get(i).booleanValue()) {
            cVar.fae.setUnselectedBackground();
        } else {
            cVar.fae.setSelectedBackground();
        }
        cVar.fae.setItemIcon(this.eZX[i % this.eZX.length].mDrawableId);
        cVar.fae.setItemText(this.eZX[i % this.eZX.length].mShowName);
        cVar.fae.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof c)) {
                    ((c) view2.getTag()).fae.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (b.this.faa != null) {
                        b.this.faa.b(i, iArr);
                        return;
                    }
                    return;
                }
                if (b.this.eZZ != i) {
                    View childAt = b.this.eZL.getChildAt(b.this.eZZ);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (b.this.eZZ >= 0) {
                        b.this.eZY.set(b.this.eZZ, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((c) view2.getTag()).fae.setSelectedBackground();
                }
                b.this.c(i, iArr);
                b.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eZN != 0) {
            cVar.fae.setPadding(this.eZN, 0, 0, 0);
        } else {
            cVar.fae.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            cVar.fae.eZV.setVisibility(8);
            cVar.fae.eZS.setVisibility(8);
            cVar.fae.eZW.setVisibility(0);
        } else {
            cVar.fae.eZV.setVisibility(0);
            cVar.fae.eZS.setVisibility(0);
            cVar.fae.eZW.setVisibility(8);
        }
        return cVar.fae;
    }

    public void pw(int i) {
        this.eZN = i;
    }

    /* loaded from: classes3.dex */
    public class c {
        BeautyItemView fae;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public String fac;
        public int fad;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.fac = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.fad = i4;
        }
    }
}
