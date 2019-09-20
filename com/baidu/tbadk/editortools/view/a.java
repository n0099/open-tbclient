package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools TT;
    private CommonTabContentView.b cvJ;
    private b cvO;
    private InterfaceC0263a cvP;
    private CommonTabHost.a cvT;
    private int KX = 0;
    private int cvQ = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int cvR = 0;
    private int cvS = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int cvU = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0263a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int cvV;
        public int cvW;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.cvT = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TT != null) {
            this.TT.b(aVar);
        }
    }

    public b ato() {
        return this.cvO;
    }

    public void a(b bVar) {
        this.cvO = bVar;
    }

    public InterfaceC0263a atp() {
        return this.cvP;
    }

    public void a(InterfaceC0263a interfaceC0263a) {
        this.cvP = interfaceC0263a;
    }

    public int atq() {
        return this.KX;
    }

    public void kC(int i) {
        this.KX = i;
    }

    public int atr() {
        return this.cvQ;
    }

    public void kD(int i) {
        this.cvQ = i;
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
        return this.cvR;
    }

    public int getPaddingRight() {
        return this.cvS;
    }

    public int ats() {
        return this.cvU;
    }

    public CommonTabHost.a att() {
        return this.cvT;
    }

    public void a(CommonTabContentView.b bVar) {
        this.cvJ = bVar;
    }

    public CommonTabContentView.b atu() {
        return this.cvJ;
    }
}
