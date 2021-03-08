package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools ael;
    private CommonTabContentView.b fGg;
    private b fGl;
    private InterfaceC0581a fGm;
    private CommonTabHost.a fGn;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int fGo = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0581a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int fGp;
        public int fGq;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.fGn = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ael != null) {
            this.ael.b(aVar);
        }
    }

    public b bCz() {
        return this.fGl;
    }

    public void a(b bVar) {
        this.fGl = bVar;
    }

    public InterfaceC0581a bCA() {
        return this.fGm;
    }

    public void a(InterfaceC0581a interfaceC0581a) {
        this.fGm = interfaceC0581a;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void ri(int i) {
        this.row = i;
    }

    public int getVerticalSpacing() {
        return this.verticalSpacing;
    }

    public void setVerticalSpacing(int i) {
        this.verticalSpacing = i;
    }

    public int getHorizontalSpacing() {
        return this.horizontalSpacing;
    }

    public void setHorizontalSpacing(int i) {
        this.horizontalSpacing = i;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public void setPaddingLeft(int i) {
        this.mPaddingLeft = i;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public void setPaddingRight(int i) {
        this.mPaddingRight = i;
    }

    public int bCB() {
        return this.fGo;
    }

    public CommonTabHost.a bCC() {
        return this.fGn;
    }

    public void a(CommonTabContentView.b bVar) {
        this.fGg = bVar;
    }

    public CommonTabContentView.b bCD() {
        return this.fGg;
    }
}
