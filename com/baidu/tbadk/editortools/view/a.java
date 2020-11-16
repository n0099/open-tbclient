package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools abp;
    private CommonTabContentView.b fpQ;
    private b fpV;
    private InterfaceC0591a fpW;
    private CommonTabHost.a fpX;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int fpY = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0591a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int fpZ;
        public int fqa;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.fpX = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abp != null) {
            this.abp.b(aVar);
        }
    }

    public b bAb() {
        return this.fpV;
    }

    public void a(b bVar) {
        this.fpV = bVar;
    }

    public InterfaceC0591a bAc() {
        return this.fpW;
    }

    public void a(InterfaceC0591a interfaceC0591a) {
        this.fpW = interfaceC0591a;
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

    public void rV(int i) {
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

    public int bAd() {
        return this.fpY;
    }

    public CommonTabHost.a bAe() {
        return this.fpX;
    }

    public void a(CommonTabContentView.b bVar) {
        this.fpQ = bVar;
    }

    public CommonTabContentView.b bAf() {
        return this.fpQ;
    }
}
