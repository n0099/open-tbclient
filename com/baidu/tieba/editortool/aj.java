package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class aj extends LinearLayout implements View.OnClickListener {
    private PbLocationInfoView arF;
    private ImageView arG;
    private com.baidu.tbadk.editortool.w aro;

    public aj(Context context) {
        this(context, null);
    }

    public aj(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.pb_editor_locationinfo_container, this, true);
        nu();
    }

    private void nu() {
        this.arF = (PbLocationInfoView) findViewById(com.baidu.tieba.v.location_info_view);
        this.arG = (ImageView) findViewById(com.baidu.tieba.v.location_info_del);
        this.arF.setOnClickListener(this);
        this.arG.setOnClickListener(this);
    }

    public void nz() {
        this.arF.sD();
        com.baidu.tbadk.core.util.aw.h(this, com.baidu.tieba.u.bg_tips_location);
        com.baidu.tbadk.core.util.aw.c(this.arG, com.baidu.tieba.u.icon_tips_close);
    }

    public void j(int i, String str) {
        this.arF.k(i, str);
    }

    public void setLocationInfoViewState(int i) {
        j(i, null);
    }

    public int getLocationInfoViewState() {
        return this.arF.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.arF.getVisibility();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.aro = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aro != null) {
            if (view == this.arF) {
                this.aro.handleAction(52, null);
            } else if (view == this.arG) {
                this.aro.handleAction(53, null);
            }
        }
    }
}
