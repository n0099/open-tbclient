package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class b extends TbImageView {
    private static Method aNn;
    private boolean aNo;

    static {
        aNn = null;
        try {
            aNn = b.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException e) {
        }
    }

    public b(Context context) {
        this(context, null, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNo = false;
        b(context, attributeSet, i);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String trim = Build.MODEL.trim();
        if (trim != null) {
            String[] strArr = {"M040", "M045"};
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z3 = false;
                    break;
                } else if (strArr[i2].equalsIgnoreCase(trim)) {
                    z3 = true;
                    break;
                } else {
                    i2++;
                }
            }
            String[] strArr2 = {"HTC T329D"};
            int length2 = strArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    z2 = z3;
                    z = false;
                    break;
                } else if (strArr2[i3].equalsIgnoreCase(trim)) {
                    z2 = z3;
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
        if (Build.VERSION.SDK_INT >= 11) {
            CompatibleUtile.getInstance().closeViewGpu(this);
            try {
                if (aNn != null) {
                    aNn.invoke(this, 1, null);
                }
            } catch (Exception e) {
            }
        }
        if (z2 || z) {
            this.aNo = false;
        } else {
            this.aNo = true;
        }
    }

    @Override // com.baidu.adp.b.a.b
    public void setDrawerType(int i) {
        if (i == 0) {
            super.setDrawerType(i);
        } else if (i == 1) {
            super.setDrawerType(this.aNo ? 4 : 5);
        } else {
            super.setDrawerType(i);
        }
    }
}
