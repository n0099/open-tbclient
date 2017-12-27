package com.baidu.tbadk.j;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class a {
    protected View buY;
    private boolean buZ;

    public a(View view) {
        this.buY = view;
    }

    public boolean Mn() {
        return this.buZ;
    }

    public void j(View view, boolean z) {
        if (view != null && this.buY != null && this.buY.getParent() == null) {
            this.buZ = true;
            d.bj(view).a(view, this.buY, z);
            Mo();
        }
    }

    public void bi(View view) {
        if (view != null && this.buY != null && this.buY.getParent() != null && (view instanceof ViewGroup)) {
            try {
                Mp();
                ((ViewGroup) view).removeView(this.buY);
                this.buZ = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        j(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mp() {
    }
}
