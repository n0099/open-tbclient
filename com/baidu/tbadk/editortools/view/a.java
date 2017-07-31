package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i Lr;
    private CommonTabContentView.c aEL;
    private b aEQ;
    private InterfaceC0055a aER;
    private b.a aES;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int alP = 0;
    private int alQ = 0;
    private int aET = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aEU;
        public int aEV;
    }

    public abstract void Dl();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aES = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Lr = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lr != null) {
            this.Lr.b(aVar);
        }
    }

    public b Ea() {
        return this.aEQ;
    }

    public void a(b bVar) {
        this.aEQ = bVar;
    }

    public InterfaceC0055a Eb() {
        return this.aER;
    }

    public void a(InterfaceC0055a interfaceC0055a) {
        this.aER = interfaceC0055a;
    }

    public int Ec() {
        return this.column;
    }

    public void eQ(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eR(int i) {
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
        return this.alP;
    }

    public int getPaddingRight() {
        return this.alQ;
    }

    public int Ed() {
        return this.aET;
    }

    public void eS(int i) {
        this.aET = i;
    }

    public b.a Ee() {
        return this.aES;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aEL = cVar;
    }

    public CommonTabContentView.c Ef() {
        return this.aEL;
    }
}
