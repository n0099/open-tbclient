package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Zt;
    private CommonTabContentView.b enI;
    private b enN;
    private InterfaceC0489a enO;
    private CommonTabHost.a enP;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int enQ = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0489a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int enR;
        public int enS;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.enP = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    public b beb() {
        return this.enN;
    }

    public void a(b bVar) {
        this.enN = bVar;
    }

    public InterfaceC0489a bec() {
        return this.enO;
    }

    public void a(InterfaceC0489a interfaceC0489a) {
        this.enO = interfaceC0489a;
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

    public void no(int i) {
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

    public int bed() {
        return this.enQ;
    }

    public CommonTabHost.a bee() {
        return this.enP;
    }

    public void a(CommonTabContentView.b bVar) {
        this.enI = bVar;
    }

    public CommonTabContentView.b bef() {
        return this.enI;
    }
}
