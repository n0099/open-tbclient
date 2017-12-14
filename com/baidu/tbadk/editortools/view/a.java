package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i IR;
    private CommonTabContentView.c aED;
    private b aEI;
    private InterfaceC0070a aEJ;
    private b.a aEN;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aEK = 0;
    private int aEL = 0;
    private int Jy = 0;
    private int aEM = 0;
    private int aEO = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aEP;
        public int aEQ;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aEN = aVar;
    }

    public void setEditorTools(i iVar) {
        this.IR = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IR != null) {
            this.IR.b(aVar);
        }
    }

    public b Ef() {
        return this.aEI;
    }

    public void a(b bVar) {
        this.aEI = bVar;
    }

    public InterfaceC0070a Eg() {
        return this.aEJ;
    }

    public void a(InterfaceC0070a interfaceC0070a) {
        this.aEJ = interfaceC0070a;
    }

    public int Eh() {
        return this.column;
    }

    public void eZ(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fa(int i) {
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
        return this.aEK;
    }

    public int getPaddingRight() {
        return this.aEL;
    }

    public int Ei() {
        return this.aEO;
    }

    public b.a Ej() {
        return this.aEN;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aED = cVar;
    }

    public CommonTabContentView.c Ek() {
        return this.aED;
    }
}
