package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
public class j {
    private EditorInfoContainer aqk;

    public j(EditorInfoContainer editorInfoContainer) {
        this.aqk = editorInfoContainer;
    }

    public void sB() {
        if (this.aqk != null) {
            this.aqk.sB();
        }
    }

    public void g(View.OnClickListener onClickListener) {
        if (this.aqk != null && this.aqk.aqd != null) {
            this.aqk.aqd.setOnClickListener(onClickListener);
        }
    }

    public void j(int i, String str) {
        if (this.aqk != null && this.aqk.aqd != null) {
            this.aqk.aqd.k(i, str);
        }
    }

    public void setLocationInfoViewState(int i) {
        j(i, null);
    }

    public int getLocationInfoViewState() {
        if (this.aqk == null || this.aqk.aqd == null) {
            return 0;
        }
        return this.aqk.aqd.getState();
    }

    public void destroy() {
        if (this.aqk != null) {
            this.aqk.setVisibility(8);
        }
    }
}
