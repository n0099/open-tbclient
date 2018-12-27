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
    private CommonTabContentView.b baR;
    private b baW;
    private InterfaceC0169a baX;
    private CommonTabHost.a bba;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int baY = 0;
    private int baZ = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int bbb = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0169a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int bbc;
        public int bbd;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.bba = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    public b MZ() {
        return this.baW;
    }

    public void a(b bVar) {
        this.baW = bVar;
    }

    public InterfaceC0169a Na() {
        return this.baX;
    }

    public void a(InterfaceC0169a interfaceC0169a) {
        this.baX = interfaceC0169a;
    }

    public int Nb() {
        return this.column;
    }

    public void fU(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fV(int i) {
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
        return this.baY;
    }

    public int getPaddingRight() {
        return this.baZ;
    }

    public int Nc() {
        return this.bbb;
    }

    public CommonTabHost.a Nd() {
        return this.bba;
    }

    public void a(CommonTabContentView.b bVar) {
        this.baR = bVar;
    }

    public CommonTabContentView.b Ne() {
        return this.baR;
    }
}
