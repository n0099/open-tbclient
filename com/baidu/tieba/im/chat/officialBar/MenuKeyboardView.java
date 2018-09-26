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
    private EditorTools SG;
    private int SH;

    public MenuKeyboardView(Context context) {
        super(context);
        this.SH = 0;
        inflate(context, e.h.official_bar_menu_toggle, this);
        setLayoutParams(new RawLayout.a(context.getResources().getDimensionPixelSize(e.C0141e.ds100), -2));
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
        this.SG = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SH = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SH;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pI() {
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
