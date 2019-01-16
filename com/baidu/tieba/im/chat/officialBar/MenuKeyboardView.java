package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class MenuKeyboardView extends LinearLayout implements l {
    private EditorTools Tj;
    private int Tk;

    public MenuKeyboardView(Context context) {
        super(context);
        this.Tk = 0;
        inflate(context, e.h.official_bar_menu_toggle, this);
        setLayoutParams(new RawLayout.a(context.getResources().getDimensionPixelSize(e.C0210e.ds100), -2));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MenuKeyboardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuKeyboardView.this.b(new com.baidu.tbadk.editortools.a(30, 0, null));
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pR() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
