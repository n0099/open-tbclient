package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Ta;
    private CommonTabContentView.b baO;
    private b baT;
    private InterfaceC0169a baU;
    private CommonTabHost.a baX;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int baV = 0;
    private int baW = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int baY = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0169a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int baZ;
        public int bba;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.baX = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    public b MY() {
        return this.baT;
    }

    public void a(b bVar) {
        this.baT = bVar;
    }

    public InterfaceC0169a MZ() {
        return this.baU;
    }

    public void a(InterfaceC0169a interfaceC0169a) {
        this.baU = interfaceC0169a;
    }

    public int Na() {
        return this.column;
    }

    public void fT(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fU(int i) {
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
        return this.baV;
    }

    public int getPaddingRight() {
        return this.baW;
    }

    public int Nb() {
        return this.baY;
    }

    public CommonTabHost.a Nc() {
        return this.baX;
    }

    public void a(CommonTabContentView.b bVar) {
        this.baO = bVar;
    }

    public CommonTabContentView.b Nd() {
        return this.baO;
    }
}
