package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Za;
    private CommonTabContentView.b dZs;
    private b dZx;
    private InterfaceC0421a dZy;
    private CommonTabHost.a dZz;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int dZA = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0421a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int dZB;
        public int dZC;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.dZz = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Za = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Za != null) {
            this.Za.b(aVar);
        }
    }

    public b aXU() {
        return this.dZx;
    }

    public void a(b bVar) {
        this.dZx = bVar;
    }

    public InterfaceC0421a aXV() {
        return this.dZy;
    }

    public void a(InterfaceC0421a interfaceC0421a) {
        this.dZy = interfaceC0421a;
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

    public void mM(int i) {
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

    public int aXW() {
        return this.dZA;
    }

    public CommonTabHost.a aXX() {
        return this.dZz;
    }

    public void a(CommonTabContentView.b bVar) {
        this.dZs = bVar;
    }

    public CommonTabContentView.b aXY() {
        return this.dZs;
    }
}
