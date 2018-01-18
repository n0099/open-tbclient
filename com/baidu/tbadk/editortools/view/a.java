package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i axN;
    private CommonTabContentView.c bsI;
    private b bsN;
    private InterfaceC0082a bsO;
    private b.a bsR;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int bsP = 0;
    private int bsQ = 0;
    private int kq = 0;
    private int kr = 0;
    private int bsS = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0082a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int bsT;
        public int bsU;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.bsR = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axN = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axN != null) {
            this.axN.b(aVar);
        }
    }

    public b Lu() {
        return this.bsN;
    }

    public void a(b bVar) {
        this.bsN = bVar;
    }

    public InterfaceC0082a Lv() {
        return this.bsO;
    }

    public void a(InterfaceC0082a interfaceC0082a) {
        this.bsO = interfaceC0082a;
    }

    public int Lw() {
        return this.column;
    }

    public void hT(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void hU(int i) {
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
        return this.bsP;
    }

    public int getPaddingRight() {
        return this.bsQ;
    }

    public int Lx() {
        return this.bsS;
    }

    public b.a Ly() {
        return this.bsR;
    }

    public void a(CommonTabContentView.c cVar) {
        this.bsI = cVar;
    }

    public CommonTabContentView.c Lz() {
        return this.bsI;
    }
}
