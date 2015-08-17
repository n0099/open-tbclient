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
    private PbLocationInfoView arA;
    private ImageView arB;
    private View arC;
    private j arD;
    private int arE;
    private boolean arF;

    public d(Context context) {
        this(context, null);
        LayoutInflater.from(context).inflate(i.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vD();
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arE = 0;
        this.arF = true;
        LayoutInflater.from(context).inflate(i.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vD();
    }

    private void initView() {
        this.arA = (PbLocationInfoView) findViewById(i.f.location_info_view);
        this.arC = findViewById(i.f.pb_editor_location_divider);
        this.arB = (ImageView) findViewById(i.f.location_info_del);
        this.arA.setOnClickListener(this);
        this.arB.setOnClickListener(this);
    }

    public void vD() {
        this.arA.ta();
        al.j(this.arC, i.c.cp_cont_e);
        al.i(this, i.c.pb_editor_location_bg_alpha);
        al.c(this.arB, i.e.icon_tips_close);
    }

    public void s(int i, String str) {
        this.arA.r(i, str);
    }

    public void setLocationInfoViewState(int i) {
        s(i, null);
    }

    public int getLocationInfoViewState() {
        return this.arA.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.arA.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.arA) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.arB) {
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
                if (aVar2.arz) {
                    oy();
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
        this.arD = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.arD != null) {
            this.arD.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.arE = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.arE;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void oy() {
        if (this.arF) {
            this.arF = false;
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
        vD();
    }
}
