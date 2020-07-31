package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class MenuKeyboardView extends LinearLayout implements m {
    private EditorTools ZS;
    private int ZT;

    public MenuKeyboardView(Context context) {
        super(context);
        this.ZT = 0;
        inflate(context, R.layout.official_bar_menu_toggle, this);
        setLayoutParams(new RawLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.ds100), -2));
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

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZT;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }
}
