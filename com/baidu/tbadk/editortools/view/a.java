package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools abj;
    private CommonTabContentView.b fcs;
    private b fcx;
    private InterfaceC0566a fcy;
    private CommonTabHost.a fcz;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int fcA = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0566a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int fcB;
        public int fcC;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.fcz = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abj = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abj != null) {
            this.abj.b(aVar);
        }
    }

    public b bwt() {
        return this.fcx;
    }

    public void a(b bVar) {
        this.fcx = bVar;
    }

    public InterfaceC0566a bwu() {
        return this.fcy;
    }

    public void a(InterfaceC0566a interfaceC0566a) {
        this.fcy = interfaceC0566a;
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

    public void rc(int i) {
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

    public int bwv() {
        return this.fcA;
    }

    public CommonTabHost.a bww() {
        return this.fcz;
    }

    public void a(CommonTabContentView.b bVar) {
        this.fcs = bVar;
    }

    public CommonTabContentView.b bwx() {
        return this.fcs;
    }
}
