package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Qj;
    private CommonTabContentView.b aOL;
    private b aOQ;
    private InterfaceC0114a aOR;
    private CommonTabHost.a aOU;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aOS = 0;
    private int aOT = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int aOV = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0114a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aOW;
        public int aOX;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.aOU = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qj = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qj != null) {
            this.Qj.b(aVar);
        }
    }

    public b Iz() {
        return this.aOQ;
    }

    public void a(b bVar) {
        this.aOQ = bVar;
    }

    public InterfaceC0114a IA() {
        return this.aOR;
    }

    public void a(InterfaceC0114a interfaceC0114a) {
        this.aOR = interfaceC0114a;
    }

    public int IB() {
        return this.column;
    }

    public void eW(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eX(int i) {
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
        return this.aOS;
    }

    public int getPaddingRight() {
        return this.aOT;
    }

    public int IC() {
        return this.aOV;
    }

    public CommonTabHost.a ID() {
        return this.aOU;
    }

    public void a(CommonTabContentView.b bVar) {
        this.aOL = bVar;
    }

    public CommonTabContentView.b IE() {
        return this.aOL;
    }
}
