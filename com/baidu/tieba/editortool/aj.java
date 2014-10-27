package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class aj extends LinearLayout implements View.OnClickListener {
    private com.baidu.tbadk.editortool.w arf;
    private PbLocationInfoView arw;
    private ImageView arx;

    public aj(Context context) {
        this(context, null);
    }

    public aj(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.pb_editor_locationinfo_container, this, true);
        nu();
    }

    private void nu() {
        this.arw = (PbLocationInfoView) findViewById(com.baidu.tieba.v.location_info_view);
        this.arx = (ImageView) findViewById(com.baidu.tieba.v.location_info_del);
        this.arw.setOnClickListener(this);
        this.arx.setOnClickListener(this);
    }

    public void nz() {
        this.arw.sB();
        com.baidu.tbadk.core.util.aw.h(this, com.baidu.tieba.u.bg_tips_location);
        com.baidu.tbadk.core.util.aw.c(this.arx, com.baidu.tieba.u.icon_tips_close);
    }

    public void j(int i, String str) {
        this.arw.k(i, str);
    }

    public void setLocationInfoViewState(int i) {
        j(i, null);
    }

    public int getLocationInfoViewState() {
        return this.arw.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.arw.getVisibility();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.arf = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.arf != null) {
            if (view == this.arw) {
                this.arf.handleAction(52, null);
            } else if (view == this.arx) {
                this.arf.handleAction(53, null);
            }
        }
    }
}
