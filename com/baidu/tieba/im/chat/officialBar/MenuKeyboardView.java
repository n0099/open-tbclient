package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class MenuKeyboardView extends LinearLayout implements l {
    private EditorTools Qh;
    private int Qi;

    public MenuKeyboardView(Context context) {
        super(context);
        this.Qi = 0;
        inflate(context, d.i.official_bar_menu_toggle, this);
        setLayoutParams(new RawLayout.a(context.getResources().getDimensionPixelSize(d.e.ds100), -2));
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
        this.Qh = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qi = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qi;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
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
