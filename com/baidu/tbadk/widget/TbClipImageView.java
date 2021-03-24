package com.baidu.tbadk.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class TbClipImageView extends TbImageView {
    public boolean w0;

    public TbClipImageView(Context context) {
        this(context, null, 0);
    }

    public final void f0(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        String trim = Build.MODEL.trim();
        if (trim != null) {
            String[] strArr = {"M040", "M045"};
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    z2 = false;
                    break;
                } else if (strArr[i2].equalsIgnoreCase(trim)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            String[] strArr2 = {"HTC T329D"};
            int i3 = 0;
            while (true) {
                if (i3 >= 1) {
                    z = false;
                    break;
                } else if (strArr2[i3].equalsIgnoreCase(trim)) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            z = false;
            z2 = false;
        }
        if (!z2 && !z) {
            this.w0 = true;
        } else {
            this.w0 = false;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i) {
        if (i == 0) {
            super.setDrawerType(i);
        } else if (i == 1) {
            super.setDrawerType(this.w0 ? 4 : 5);
        } else {
            super.setDrawerType(i);
        }
    }

    public TbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w0 = false;
        f0(context, attributeSet, i);
    }

    public TbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
