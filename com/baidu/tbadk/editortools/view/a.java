package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools abk;
    private CommonTabContentView.b fkQ;
    private b fkV;
    private InterfaceC0580a fkW;
    private CommonTabHost.a fkX;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int fkY = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0580a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int fkZ;
        public int fla;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.fkX = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    public b bym() {
        return this.fkV;
    }

    public void a(b bVar) {
        this.fkV = bVar;
    }

    public InterfaceC0580a byn() {
        return this.fkW;
    }

    public void a(InterfaceC0580a interfaceC0580a) {
        this.fkW = interfaceC0580a;
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

    public void rn(int i) {
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

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int byo() {
        return this.fkY;
    }

    public CommonTabHost.a byp() {
        return this.fkX;
    }

    public void a(CommonTabContentView.b bVar) {
        this.fkQ = bVar;
    }

    public CommonTabContentView.b byq() {
        return this.fkQ;
    }
}
