package com.baidu.tbadk.editortools.locationtool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d extends LinearLayout implements View.OnClickListener, w {
    private PbLocationInfoView arI;
    private ImageView arJ;
    private View arK;
    private j arL;
    private int arM;
    private boolean arN;

    public d(Context context) {
        this(context, null);
        LayoutInflater.from(context).inflate(i.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vx();
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arM = 0;
        this.arN = true;
        LayoutInflater.from(context).inflate(i.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vx();
    }

    private void initView() {
        this.arI = (PbLocationInfoView) findViewById(i.f.location_info_view);
        this.arK = findViewById(i.f.pb_editor_location_divider);
        this.arJ = (ImageView) findViewById(i.f.location_info_del);
        this.arI.setOnClickListener(this);
        this.arJ.setOnClickListener(this);
    }

    public void vx() {
        this.arI.sZ();
        an.j(this.arK, i.c.cp_cont_e);
        an.i(this, i.c.pb_editor_location_bg_alpha);
        an.c(this.arJ, i.e.icon_tips_close);
    }

    public void s(int i, String str) {
        this.arI.r(i, str);
    }

    public void setLocationInfoViewState(int i) {
        s(i, null);
    }

    public int getLocationInfoViewState() {
        return this.arI.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.arI.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.arI) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.arJ) {
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
                if (aVar2.arH) {
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
        this.arL = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.arL != null) {
            this.arL.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.arM = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.arM;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ow() {
        if (this.arN) {
            this.arN = false;
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
        vx();
    }
}
