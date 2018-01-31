package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i axQ;
    private CommonTabContentView.c bsR;
    private b bsW;
    private InterfaceC0083a bsX;
    private b.a bta;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int bsY = 0;
    private int bsZ = 0;
    private int kq = 0;
    private int kr = 0;
    private int btb = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0083a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int btc;
        public int btd;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.bta = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axQ = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axQ != null) {
            this.axQ.b(aVar);
        }
    }

    public b Lw() {
        return this.bsW;
    }

    public void a(b bVar) {
        this.bsW = bVar;
    }

    public InterfaceC0083a Lx() {
        return this.bsX;
    }

    public void a(InterfaceC0083a interfaceC0083a) {
        this.bsX = interfaceC0083a;
    }

    public int Ly() {
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
        return this.bsY;
    }

    public int getPaddingRight() {
        return this.bsZ;
    }

    public int Lz() {
        return this.btb;
    }

    public b.a LA() {
        return this.bta;
    }

    public void a(CommonTabContentView.c cVar) {
        this.bsR = cVar;
    }

    public CommonTabContentView.c LB() {
        return this.bsR;
    }
}
