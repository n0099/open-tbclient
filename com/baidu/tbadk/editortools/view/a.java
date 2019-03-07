package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools VM;
    private CommonTabContentView.b clg;
    private b cll;
    private InterfaceC0203a clm;
    private CommonTabHost.a clp;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int cln = 0;
    private int clo = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int clq = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0203a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int clr;
        public int cls;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.clp = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.VM = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VM != null) {
            this.VM.b(aVar);
        }
    }

    public b amV() {
        return this.cll;
    }

    public void a(b bVar) {
        this.cll = bVar;
    }

    public InterfaceC0203a amW() {
        return this.clm;
    }

    public void a(InterfaceC0203a interfaceC0203a) {
        this.clm = interfaceC0203a;
    }

    public int amX() {
        return this.column;
    }

    public void jF(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void jG(int i) {
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
        return this.cln;
    }

    public int getPaddingRight() {
        return this.clo;
    }

    public int amY() {
        return this.clq;
    }

    public CommonTabHost.a amZ() {
        return this.clp;
    }

    public void a(CommonTabContentView.b bVar) {
        this.clg = bVar;
    }

    public CommonTabContentView.b ana() {
        return this.clg;
    }
}
