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
    private ViewGroup eZW;
    private InterfaceC0523b fal;
    public final a[] fai = {new a(a.f.ar_beauty_reset, "beauty_reset", "重置", 0, 100, 0), new a(a.f.ar_beauty_reset, "beauty_reset", "line", 0, 100, 0), new a(a.f.ar_beauty_white, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey(), "美白", 0, 100, 0), new a(a.f.ar_beauty_blur, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey(), "磨皮", 0, 100, 0), new a(a.f.ar_beauty_bigeye, AlaFilterAndBeautyData.BeautyAdjustKey.eye.getJsonKey(), "大眼", 0, 100, 0), new a(a.f.ar_beauty_thinface, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey(), "瘦脸", 0, 100, 0), new a(a.f.ar_beauty_cheekbone, AlaFilterAndBeautyData.BeautyAdjustKey.cheekboneWidth.getJsonKey(), "颧骨", 0, 100, 0), new a(a.f.ar_beauty_vface, AlaFilterAndBeautyData.BeautyAdjustKey.vFace.getJsonKey(), "下颚角", 0, 100, 0), new a(a.f.ar_beauty_facelength, AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts.getJsonKey(), "脸长", 0, 100, 50), new a(a.f.ar_beauty_chin, AlaFilterAndBeautyData.BeautyAdjustKey.chin.getJsonKey(), "下巴", -50, 50, 50), new a(a.f.ar_beauty_nose, AlaFilterAndBeautyData.BeautyAdjustKey.nose.getJsonKey(), "鼻宽", 0, 100, 0), new a(a.f.ar_beauty_mouth, AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth.getJsonKey(), "嘴型", -50, 50, 50)};
    private int fak = -1;
    private int eZY = 0;
    private ArrayList<Boolean> faj = new ArrayList<>();

    /* renamed from: com.baidu.tieba.ala.alaar.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0523b {
        void b(int i, int[] iArr);
    }

    public b(ViewGroup viewGroup) {
        this.eZW = viewGroup;
        bqg();
    }

    private void bqg() {
        if (this.faj != null) {
            this.faj.clear();
            this.faj.addAll(Arrays.asList(new Boolean[this.fai.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int[] iArr) {
        if (i >= 0) {
            this.faj.set(i, true);
            this.fak = i;
            if (this.fal != null) {
                this.fal.b(i, iArr);
            }
        }
    }

    public void AU(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.fai.length; i++) {
                if (str.equals(this.fai[i].fan)) {
                    c(i, null);
                    return;
                }
            }
        }
    }

    public void a(InterfaceC0523b interfaceC0523b) {
        this.fal = interfaceC0523b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fai.length;
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
            cVar2.fap = new BeautyItemView(this.eZW.getContext());
            cVar2.fap.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        if (this.faj.get(i) == null || !this.faj.get(i).booleanValue()) {
            cVar.fap.setUnselectedBackground();
        } else {
            cVar.fap.setSelectedBackground();
        }
        cVar.fap.setItemIcon(this.fai[i % this.fai.length].mDrawableId);
        cVar.fap.setItemText(this.fai[i % this.fai.length].mShowName);
        cVar.fap.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (view2.getTag() != null && (view2.getTag() instanceof c)) {
                    ((c) view2.getTag()).fap.getLocationOnScreen(iArr);
                }
                if (i == 0) {
                    if (b.this.fal != null) {
                        b.this.fal.b(i, iArr);
                        return;
                    }
                    return;
                }
                if (b.this.fak != i) {
                    View childAt = b.this.eZW.getChildAt(b.this.fak);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (b.this.fak >= 0) {
                        b.this.faj.set(b.this.fak, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((c) view2.getTag()).fap.setSelectedBackground();
                }
                b.this.c(i, iArr);
                b.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eZY != 0) {
            cVar.fap.setPadding(this.eZY, 0, 0, 0);
        } else {
            cVar.fap.setPadding(0, 0, 0, 0);
        }
        if (i == 1) {
            cVar.fap.fag.setVisibility(8);
            cVar.fap.fad.setVisibility(8);
            cVar.fap.fah.setVisibility(0);
        } else {
            cVar.fap.fag.setVisibility(0);
            cVar.fap.fad.setVisibility(0);
            cVar.fap.fah.setVisibility(8);
        }
        return cVar.fap;
    }

    public void py(int i) {
        this.eZY = i;
    }

    /* loaded from: classes3.dex */
    public class c {
        BeautyItemView fap;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public String fan;
        public int fao;
        public int mDrawableId;
        public String mShowName;
        public int maxValue;
        public int minValue;

        public a(int i, String str, String str2, int i2, int i3, int i4) {
            this.mDrawableId = i;
            this.fan = str;
            this.minValue = i2;
            this.maxValue = i3;
            this.mShowName = str2;
            this.fao = i4;
        }
    }
}
