package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Fq;
    private CommonTabContentView.b duT;
    private b duY;
    private InterfaceC0378a duZ;
    private CommonTabHost.a dvc;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int dva = 0;
    private int dvb = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int dvd = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0378a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int dve;
        public int dvf;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.dvc = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Fq = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fq != null) {
            this.Fq.b(aVar);
        }
    }

    public b aMH() {
        return this.duY;
    }

    public void a(b bVar) {
        this.duY = bVar;
    }

    public InterfaceC0378a aMI() {
        return this.duZ;
    }

    public void a(InterfaceC0378a interfaceC0378a) {
        this.duZ = interfaceC0378a;
    }

    public int getColumn() {
        return this.column;
    }

    public void mg(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void mh(int i) {
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
        return this.dva;
    }

    public int getPaddingRight() {
        return this.dvb;
    }

    public int aMJ() {
        return this.dvd;
    }

    public CommonTabHost.a aMK() {
        return this.dvc;
    }

    public void a(CommonTabContentView.b bVar) {
        this.duT = bVar;
    }

    public CommonTabContentView.b aML() {
        return this.duT;
    }
}
