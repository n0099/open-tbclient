package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools aaA;
    private CommonTabHost.a eNA;
    private CommonTabContentView.b eNt;
    private b eNy;
    private InterfaceC0553a eNz;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int eNB = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0553a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int eNC;
        public int eND;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.eNA = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aaA = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaA != null) {
            this.aaA.b(aVar);
        }
    }

    public b bsF() {
        return this.eNy;
    }

    public void a(b bVar) {
        this.eNy = bVar;
    }

    public InterfaceC0553a bsG() {
        return this.eNz;
    }

    public void a(InterfaceC0553a interfaceC0553a) {
        this.eNz = interfaceC0553a;
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

    public void qn(int i) {
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

    public int bsH() {
        return this.eNB;
    }

    public CommonTabHost.a bsI() {
        return this.eNA;
    }

    public void a(CommonTabContentView.b bVar) {
        this.eNt = bVar;
    }

    public CommonTabContentView.b bsJ() {
        return this.eNt;
    }
}
