package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i JH;
    private CommonTabContentView.c aDf;
    private b aDk;
    private InterfaceC0056a aDl;
    private b.a aDo;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aDm = 0;
    private int aDn = 0;
    private int aDp = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0056a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aDq;
        public int aDr;
    }

    public abstract void CE();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aDo = aVar;
    }

    public void setEditorTools(i iVar) {
        this.JH = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JH != null) {
            this.JH.b(aVar);
        }
    }

    public b Dv() {
        return this.aDk;
    }

    public void a(b bVar) {
        this.aDk = bVar;
    }

    public InterfaceC0056a Dw() {
        return this.aDl;
    }

    public void a(InterfaceC0056a interfaceC0056a) {
        this.aDl = interfaceC0056a;
    }

    public int Dx() {
        return this.column;
    }

    public void fa(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fb(int i) {
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
        return this.aDm;
    }

    public int getPaddingRight() {
        return this.aDn;
    }

    public int Dy() {
        return this.aDp;
    }

    public b.a Dz() {
        return this.aDo;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aDf = cVar;
    }

    public CommonTabContentView.c DA() {
        return this.aDf;
    }
}
