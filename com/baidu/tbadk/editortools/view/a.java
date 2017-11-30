package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i IT;
    private b aED;
    private InterfaceC0056a aEE;
    private b.a aEI;
    private CommonTabContentView.c aEy;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aEF = 0;
    private int aEG = 0;
    private int Jz = 0;
    private int aEH = 0;
    private int aEJ = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0056a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aEK;
        public int aEL;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aEI = aVar;
    }

    public void setEditorTools(i iVar) {
        this.IT = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IT != null) {
            this.IT.b(aVar);
        }
    }

    public b Ee() {
        return this.aED;
    }

    public void a(b bVar) {
        this.aED = bVar;
    }

    public InterfaceC0056a Ef() {
        return this.aEE;
    }

    public void a(InterfaceC0056a interfaceC0056a) {
        this.aEE = interfaceC0056a;
    }

    public int Eg() {
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
        return this.aEF;
    }

    public int getPaddingRight() {
        return this.aEG;
    }

    public int Eh() {
        return this.aEJ;
    }

    public b.a Ei() {
        return this.aEI;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aEy = cVar;
    }

    public CommonTabContentView.c Ej() {
        return this.aEy;
    }
}
