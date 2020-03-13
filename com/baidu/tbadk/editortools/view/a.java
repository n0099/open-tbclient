package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools FO;
    private b dzC;
    private InterfaceC0390a dzD;
    private CommonTabHost.a dzE;
    private CommonTabContentView.b dzx;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int dzF = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0390a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int dzG;
        public int dzH;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.dzE = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    public b aPz() {
        return this.dzC;
    }

    public void a(b bVar) {
        this.dzC = bVar;
    }

    public InterfaceC0390a aPA() {
        return this.dzD;
    }

    public void a(InterfaceC0390a interfaceC0390a) {
        this.dzD = interfaceC0390a;
    }

    public int getColumn() {
        return this.column;
    }

    public void my(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void mz(int i) {
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

    public int aPB() {
        return this.dzF;
    }

    public CommonTabHost.a aPC() {
        return this.dzE;
    }

    public void a(CommonTabContentView.b bVar) {
        this.dzx = bVar;
    }

    public CommonTabContentView.b aPD() {
        return this.dzx;
    }
}
