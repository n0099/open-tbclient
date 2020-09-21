package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools aaS;
    private CommonTabContentView.b eQk;
    private b eQp;
    private InterfaceC0549a eQq;
    private CommonTabHost.a eQr;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int eQs = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0549a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int eQt;
        public int eQu;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.eQr = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aaS = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaS != null) {
            this.aaS.b(aVar);
        }
    }

    public b btJ() {
        return this.eQp;
    }

    public void a(b bVar) {
        this.eQp = bVar;
    }

    public InterfaceC0549a btK() {
        return this.eQq;
    }

    public void a(InterfaceC0549a interfaceC0549a) {
        this.eQq = interfaceC0549a;
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

    public void qE(int i) {
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

    public int btL() {
        return this.eQs;
    }

    public CommonTabHost.a btM() {
        return this.eQr;
    }

    public void a(CommonTabContentView.b bVar) {
        this.eQk = bVar;
    }

    public CommonTabContentView.b btN() {
        return this.eQk;
    }
}
