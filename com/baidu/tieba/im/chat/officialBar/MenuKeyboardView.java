package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import d.a.m0.w.n;
/* loaded from: classes4.dex */
public class MenuKeyboardView extends LinearLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f17084e;

    /* renamed from: f  reason: collision with root package name */
    public int f17085f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuKeyboardView.this.d(new d.a.m0.w.a(30, 0, null));
        }
    }

    public MenuKeyboardView(Context context) {
        super(context);
        this.f17085f = 0;
        LinearLayout.inflate(context, R.layout.official_bar_menu_toggle, this);
        setLayoutParams(new RawLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.ds100), -2));
        setOnClickListener(new a());
    }

    @Override // d.a.m0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.a.m0.w.n
    public void d(d.a.m0.w.a aVar) {
        EditorTools editorTools = this.f17084e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.m0.w.n
    public int getToolId() {
        return this.f17085f;
    }

    @Override // d.a.m0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.m0.w.n
    public void init() {
    }

    @Override // d.a.m0.w.b
    public void onAction(d.a.m0.w.a aVar) {
    }

    @Override // d.a.m0.w.n
    public void onChangeSkinType(int i2) {
    }

    @Override // d.a.m0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f17084e = editorTools;
    }

    @Override // d.a.m0.w.n
    public void setToolId(int i2) {
        this.f17085f = i2;
    }
}
