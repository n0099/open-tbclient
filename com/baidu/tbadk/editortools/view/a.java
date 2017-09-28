package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i JG;
    private b.a aDB;
    private CommonTabContentView.c aDs;
    private b aDx;
    private InterfaceC0056a aDy;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aDz = 0;
    private int aDA = 0;
    private int aDC = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0056a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aDD;
        public int aDE;
    }

    public abstract void CK();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aDB = aVar;
    }

    public void setEditorTools(i iVar) {
        this.JG = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JG != null) {
            this.JG.b(aVar);
        }
    }

    public b DB() {
        return this.aDx;
    }

    public void a(b bVar) {
        this.aDx = bVar;
    }

    public InterfaceC0056a DC() {
        return this.aDy;
    }

    public void a(InterfaceC0056a interfaceC0056a) {
        this.aDy = interfaceC0056a;
    }

    public int DD() {
        return this.column;
    }

    public void fb(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fc(int i) {
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
        return this.aDz;
    }

    public int getPaddingRight() {
        return this.aDA;
    }

    public int DE() {
        return this.aDC;
    }

    public b.a DF() {
        return this.aDB;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aDs = cVar;
    }

    public CommonTabContentView.c DG() {
        return this.aDs;
    }
}
