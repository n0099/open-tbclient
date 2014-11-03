package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
public class j {
    private EditorInfoContainer aqt;

    public j(EditorInfoContainer editorInfoContainer) {
        this.aqt = editorInfoContainer;
    }

    public void sD() {
        if (this.aqt != null) {
            this.aqt.sD();
        }
    }

    public void g(View.OnClickListener onClickListener) {
        if (this.aqt != null && this.aqt.aqm != null) {
            this.aqt.aqm.setOnClickListener(onClickListener);
        }
    }

    public void j(int i, String str) {
        if (this.aqt != null && this.aqt.aqm != null) {
            this.aqt.aqm.k(i, str);
        }
    }

    public void setLocationInfoViewState(int i) {
        j(i, null);
    }

    public int getLocationInfoViewState() {
        if (this.aqt == null || this.aqt.aqm == null) {
            return 0;
        }
        return this.aqt.aqm.getState();
    }

    public void destroy() {
        if (this.aqt != null) {
            this.aqt.setVisibility(8);
        }
    }
}
