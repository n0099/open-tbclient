package com.baidu.tbadk.editortools.locationtool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d extends LinearLayout implements View.OnClickListener, w {
    private PbLocationInfoView atk;
    private ImageView atl;
    private View atm;
    private j atn;
    private int ato;
    private boolean atp;

    public d(Context context) {
        this(context, null);
        LayoutInflater.from(context).inflate(i.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vI();
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ato = 0;
        this.atp = true;
        LayoutInflater.from(context).inflate(i.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vI();
    }

    private void initView() {
        this.atk = (PbLocationInfoView) findViewById(i.f.location_info_view);
        this.atm = findViewById(i.f.pb_editor_location_divider);
        this.atl = (ImageView) findViewById(i.f.location_info_del);
        this.atk.setOnClickListener(this);
        this.atl.setOnClickListener(this);
    }

    public void vI() {
        this.atk.tf();
        al.i(this.atm, i.c.cp_cont_e);
        al.h(this, i.c.pb_editor_location_bg_alpha);
        al.c(this.atl, i.e.icon_tips_close);
    }

    public void s(int i, String str) {
        this.atk.r(i, str);
    }

    public void setLocationInfoViewState(int i) {
        s(i, null);
    }

    public int getLocationInfoViewState() {
        return this.atk.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.atk.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.atk) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.atl) {
            hide();
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 19) {
                if (aVar.data == null) {
                    hide();
                    return;
                }
                a aVar2 = (a) aVar.data;
                if (aVar2.atj) {
                    ov();
                    if (TextUtils.isEmpty(aVar2.addr)) {
                        setLocationInfoViewState(aVar2.state);
                        return;
                    } else {
                        s(aVar2.state, aVar2.addr);
                        return;
                    }
                }
                hide();
            } else if (aVar.code == 20) {
                hide();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.atn = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.atn != null) {
            this.atn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.ato = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.ato;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ov() {
        if (this.atp) {
            this.atp = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        vI();
    }
}
