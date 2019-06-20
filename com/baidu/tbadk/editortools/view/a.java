package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools TA;
    private CommonTabHost.a ctB;
    private CommonTabContentView.b cts;
    private b ctx;
    private InterfaceC0252a cty;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int ctz = 0;
    private int ctA = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int ctC = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0252a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int ctD;
        public int ctE;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.ctB = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TA != null) {
            this.TA.b(aVar);
        }
    }

    public b arU() {
        return this.ctx;
    }

    public void a(b bVar) {
        this.ctx = bVar;
    }

    public InterfaceC0252a arV() {
        return this.cty;
    }

    public void a(InterfaceC0252a interfaceC0252a) {
        this.cty = interfaceC0252a;
    }

    public int arW() {
        return this.column;
    }

    public void ks(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void kt(int i) {
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
        return this.ctz;
    }

    public int getPaddingRight() {
        return this.ctA;
    }

    public int arX() {
        return this.ctC;
    }

    public CommonTabHost.a arY() {
        return this.ctB;
    }

    public void a(CommonTabContentView.b bVar) {
        this.cts = bVar;
    }

    public CommonTabContentView.b arZ() {
        return this.cts;
    }
}
