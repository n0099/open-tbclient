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
    private ViewGroup eNj;
    private InterfaceC0455b eNy;
    public final a[] eNv = {new a(a.f.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.f.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.f.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.f.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.f.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.f.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.f.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.f.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.f.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.f.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.f.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "鼻宽", 0, 100, 0), new a(a.f.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50)};
    private int eNx = -1;
    private int eNl = 0;
    private ArrayList<Boolean> eNw = new ArrayList<>();

    /* renamed from: com.baidu.tieba.ala.alaar.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0455b {
        void b(int i, int[] iArr);
    }

    public b(ViewGroup viewGroup) {
        this.eNj = viewGroup;
        bkM();
    }

    private void bkM() {
        if (this.eNw != null) {
            this.eNw.clear();
            this.eNw.addAll(Arrays.asList(new Boolean[this.eNv.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr) {
        if (i >= 0) {
            this.eNw.set(i, true);
            this.eNx = i;
            if (this.eNy != null) {
                this.eNy.b(i, iArr);
            }
        }
    }

    public void zl(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.eNv.length; i++) {
                if (str.equals(this.eNv[i].eNA)) {
                    c(i, null);
                    return;
                }
            }
        }
    }

    public void a(InterfaceC0455b interfaceC0455b) {
        this.eNy = interfaceC0455b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eNv.length;
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
            cVar2.eNC = new BeautyItemView(this.eNj.getContext());
            cVar2.eNC.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        if (this.eNw.get(i) == null || !this.eNw.get(i).booleanValue()) {
            cVar.eNC.setUnselectedBackground();
        } else {
            cVar.eNC.setSelectedBackground();
        }
        cVar.eNC.setItemIcon(this.eNv[i % this.eNv.length].mDrawableId);
        cVar.eNC.setItemText(this.eNv[i % this.eNv.length].mShowName);
        cVar.eNC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof c)) {
                    ((c) view2.getTag()).eNC.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (b.this.eNy != null) {
                        b.this.eNy.b(i, iArr);
                        return;
                    }
                    return;
                }
                if (b.this.eNx != i) {
                    View childAt = b.this.eNj.getChildAt(b.this.eNx);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (b.this.eNx >= 0) {
                        b.this.eNw.set(b.this.eNx, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((c) view2.getTag()).eNC.setSelectedBackground();
                }
                b.this.c(i, iArr);
                b.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eNl != 0) {
            cVar.eNC.setPadding(this.eNl, 0, 0, 0);
        } else {
            cVar.eNC.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            cVar.eNC.eNt.setVisibility(8);
            cVar.eNC.eNq.setVisibility(8);
            cVar.eNC.eNu.setVisibility(0);
        } else {
            cVar.eNC.eNt.setVisibility(0);
            cVar.eNC.eNq.setVisibility(0);
            cVar.eNC.eNu.setVisibility(8);
        }
        return cVar.eNC;
    }

    public void oV(int i) {
        this.eNl = i;
    }

    /* loaded from: classes3.dex */
    public class c {
        BeautyItemView eNC;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public String eNA;
        public int eNB;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.eNA = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.eNB = i4;
        }
    }
}
