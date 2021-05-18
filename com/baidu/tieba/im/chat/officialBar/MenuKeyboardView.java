package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import d.a.j0.w.n;
/* loaded from: classes4.dex */
public class MenuKeyboardView extends LinearLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f17098e;

    /* renamed from: f  reason: collision with root package name */
    public int f17099f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuKeyboardView.this.d(new d.a.j0.w.a(30, 0, null));
        }
    }

    public MenuKeyboardView(Context context) {
        super(context);
        this.f17099f = 0;
        LinearLayout.inflate(context, R.layout.official_bar_menu_toggle, this);
        setLayoutParams(new RawLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.ds100), -2));
        setOnClickListener(new a());
    }

    @Override // d.a.j0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.a.j0.w.n
    public void d(d.a.j0.w.a aVar) {
        EditorTools editorTools = this.f17098e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.j0.w.n
    public int getToolId() {
        return this.f17099f;
    }

    @Override // d.a.j0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.j0.w.n
    public void init() {
    }

    @Override // d.a.j0.w.b
    public void onAction(d.a.j0.w.a aVar) {
    }

    @Override // d.a.j0.w.n
    public void onChangeSkinType(int i2) {
    }

    @Override // d.a.j0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f17098e = editorTools;
    }

    @Override // d.a.j0.w.n
    public void setToolId(int i2) {
        this.f17099f = i2;
    }
}
