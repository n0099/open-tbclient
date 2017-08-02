package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i JT;
    private b aDA;
    private InterfaceC0055a aDB;
    private b.a aDC;
    private CommonTabContentView.c aDv;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int akv = 0;
    private int akw = 0;
    private int aDD = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aDE;
        public int aDF;
    }

    public abstract void Dd();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aDC = aVar;
    }

    public void setEditorTools(i iVar) {
        this.JT = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    public b DS() {
        return this.aDA;
    }

    public void a(b bVar) {
        this.aDA = bVar;
    }

    public InterfaceC0055a DT() {
        return this.aDB;
    }

    public void a(InterfaceC0055a interfaceC0055a) {
        this.aDB = interfaceC0055a;
    }

    public int DU() {
        return this.column;
    }

    public void eO(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eP(int i) {
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
        return this.akv;
    }

    public int getPaddingRight() {
        return this.akw;
    }

    public int DV() {
        return this.aDD;
    }

    public void eQ(int i) {
        this.aDD = i;
    }

    public b.a DW() {
        return this.aDC;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aDv = cVar;
    }

    public CommonTabContentView.c DX() {
        return this.aDv;
    }
}
