package com.baidu.tbadk.editortools.locationtool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d extends LinearLayout implements View.OnClickListener, w {
    private PbLocationInfoView arH;
    private ImageView arI;
    private View arJ;
    private j arK;
    private int arL;
    private boolean arM;

    public d(Context context) {
        this(context, null);
        LayoutInflater.from(context).inflate(i.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vA();
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arL = 0;
        this.arM = true;
        LayoutInflater.from(context).inflate(i.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vA();
    }

    private void initView() {
        this.arH = (PbLocationInfoView) findViewById(i.f.location_info_view);
        this.arJ = findViewById(i.f.pb_editor_location_divider);
        this.arI = (ImageView) findViewById(i.f.location_info_del);
        this.arH.setOnClickListener(this);
        this.arI.setOnClickListener(this);
    }

    public void vA() {
        this.arH.tc();
        am.j(this.arJ, i.c.cp_cont_e);
        am.i(this, i.c.pb_editor_location_bg_alpha);
        am.c(this.arI, i.e.icon_tips_close);
    }

    public void s(int i, String str) {
        this.arH.r(i, str);
    }

    public void setLocationInfoViewState(int i) {
        s(i, null);
    }

    public int getLocationInfoViewState() {
        return this.arH.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.arH.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.arH) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.arI) {
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
                if (aVar2.arG) {
                    ow();
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
        this.arK = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.arK != null) {
            this.arK.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.arL = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.arL;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ow() {
        if (this.arM) {
            this.arM = false;
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
        vA();
    }
}
