package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools VN;
    private CommonTabContentView.b cli;
    private b cln;
    private InterfaceC0237a clo;
    private CommonTabHost.a clr;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int clp = 0;
    private int clq = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int cls = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0237a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int clt;
        public int clu;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.clr = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    public b amR() {
        return this.cln;
    }

    public void a(b bVar) {
        this.cln = bVar;
    }

    public InterfaceC0237a amS() {
        return this.clo;
    }

    public void a(InterfaceC0237a interfaceC0237a) {
        this.clo = interfaceC0237a;
    }

    public int amT() {
        return this.column;
    }

    public void jE(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void jF(int i) {
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
        return this.clp;
    }

    public int getPaddingRight() {
        return this.clq;
    }

    public int amU() {
        return this.cls;
    }

    public CommonTabHost.a amV() {
        return this.clr;
    }

    public void a(CommonTabContentView.b bVar) {
        this.cli = bVar;
    }

    public CommonTabContentView.b amW() {
        return this.cli;
    }
}
