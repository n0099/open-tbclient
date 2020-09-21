package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class MenuKeyboardView extends LinearLayout implements n {
    private EditorTools aaS;
    private int aaT;

    public MenuKeyboardView(Context context) {
        super(context);
        this.aaT = 0;
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

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaS != null) {
            this.aaS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaT = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaT;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
