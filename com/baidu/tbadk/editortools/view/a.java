package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools acn;
    private b fxA;
    private InterfaceC0604a fxB;
    private CommonTabHost.a fxC;
    private CommonTabContentView.b fxv;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int VU = 0;
    private int VT = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int fxD = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0604a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int fxE;
        public int fxF;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.fxC = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    public b bDB() {
        return this.fxA;
    }

    public void a(b bVar) {
        this.fxA = bVar;
    }

    public InterfaceC0604a bDC() {
        return this.fxB;
    }

    public void a(InterfaceC0604a interfaceC0604a) {
        this.fxB = interfaceC0604a;
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

    public void sw(int i) {
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
        return this.VU;
    }

    public void setPaddingLeft(int i) {
        this.VU = i;
    }

    public int getPaddingRight() {
        return this.VT;
    }

    public void setPaddingRight(int i) {
        this.VT = i;
    }

    public int bDD() {
        return this.fxD;
    }

    public CommonTabHost.a bDE() {
        return this.fxC;
    }

    public void a(CommonTabContentView.b bVar) {
        this.fxv = bVar;
    }

    public CommonTabContentView.b bDF() {
        return this.fxv;
    }
}
