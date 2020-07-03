package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools ZX;
    private b ewC;
    private InterfaceC0495a ewD;
    private CommonTabHost.a ewE;
    private CommonTabContentView.b ewx;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int ewF = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0495a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int ewG;
        public int ewH;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.ewE = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZX != null) {
            this.ZX.b(aVar);
        }
    }

    public b bgh() {
        return this.ewC;
    }

    public void a(b bVar) {
        this.ewC = bVar;
    }

    public InterfaceC0495a bgi() {
        return this.ewD;
    }

    public void a(InterfaceC0495a interfaceC0495a) {
        this.ewD = interfaceC0495a;
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

    public void nK(int i) {
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

    public int bgj() {
        return this.ewF;
    }

    public CommonTabHost.a bgk() {
        return this.ewE;
    }

    public void a(CommonTabContentView.b bVar) {
        this.ewx = bVar;
    }

    public CommonTabContentView.b bgl() {
        return this.ewx;
    }
}
