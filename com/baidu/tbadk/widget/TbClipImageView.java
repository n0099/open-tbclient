package com.baidu.tbadk.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class TbClipImageView extends TbImageView {
    public boolean B0;

    public TbClipImageView(Context context) {
        this(context, null, 0);
    }

    public final void b0(Context context, AttributeSet attributeSet, int i2) {
        boolean z;
        boolean z2;
        String trim = Build.MODEL.trim();
        if (trim != null) {
            String[] strArr = {"M040", "M045"};
            int i3 = 0;
            while (true) {
                if (i3 >= 2) {
                    z2 = false;
                    break;
                } else if (strArr[i3].equalsIgnoreCase(trim)) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            String[] strArr2 = {"HTC T329D"};
            int i4 = 0;
            while (true) {
                if (i4 >= 1) {
                    z = false;
                    break;
                } else if (strArr2[i4].equalsIgnoreCase(trim)) {
                    z = true;
                    break;
                } else {
                    i4++;
                }
            }
        } else {
            z = false;
            z2 = false;
        }
        if (!z2 && !z) {
            this.B0 = true;
        } else {
            this.B0 = false;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i2) {
        if (i2 == 0) {
            super.setDrawerType(i2);
        } else if (i2 == 1) {
            super.setDrawerType(this.B0 ? 4 : 5);
        } else {
            super.setDrawerType(i2);
        }
    }

    public TbClipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.B0 = false;
        b0(context, attributeSet, i2);
    }

    public TbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
