package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i IS;
    private CommonTabContentView.c aEG;
    private b aEL;
    private InterfaceC0069a aEM;
    private b.a aEQ;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aEN = 0;
    private int aEO = 0;
    private int Jz = 0;
    private int aEP = 0;
    private int aER = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0069a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aES;
        public int aET;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aEQ = aVar;
    }

    public void setEditorTools(i iVar) {
        this.IS = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IS != null) {
            this.IS.b(aVar);
        }
    }

    public b Ef() {
        return this.aEL;
    }

    public void a(b bVar) {
        this.aEL = bVar;
    }

    public InterfaceC0069a Eg() {
        return this.aEM;
    }

    public void a(InterfaceC0069a interfaceC0069a) {
        this.aEM = interfaceC0069a;
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
        return this.aEN;
    }

    public int getPaddingRight() {
        return this.aEO;
    }

    public int Ei() {
        return this.aER;
    }

    public b.a Ej() {
        return this.aEQ;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aEG = cVar;
    }

    public CommonTabContentView.c Ek() {
        return this.aEG;
    }
}
