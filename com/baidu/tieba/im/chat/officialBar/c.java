package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.p;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends LinearLayout implements s {
    private com.baidu.tbadk.editortools.i axP;
    private int axQ;

    public c(Context context) {
        super(context);
        this.axQ = 0;
        inflate(context, d.h.official_bar_menu_toggle, this);
        setLayoutParams(new p.a(context.getResources().getDimensionPixelSize(d.e.ds100), -2));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.b(new com.baidu.tbadk.editortools.a(30, 0, null));
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axP = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axQ = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axQ;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
