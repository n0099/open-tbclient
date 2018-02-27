package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i axG;
    private CommonTabContentView.c buR;
    private b buW;
    private InterfaceC0107a buX;
    private b.a bva;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int buY = 0;
    private int buZ = 0;
    private int kq = 0;
    private int kr = 0;
    private int bvb = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0107a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int bvc;
        public int bvd;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.bva = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axG = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axG != null) {
            this.axG.b(aVar);
        }
    }

    public b Mb() {
        return this.buW;
    }

    public void a(b bVar) {
        this.buW = bVar;
    }

    public InterfaceC0107a Mc() {
        return this.buX;
    }

    public void a(InterfaceC0107a interfaceC0107a) {
        this.buX = interfaceC0107a;
    }

    public int Md() {
        return this.column;
    }

    public void hR(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void hS(int i) {
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
        return this.buY;
    }

    public int getPaddingRight() {
        return this.buZ;
    }

    public int Me() {
        return this.bvb;
    }

    public b.a Mf() {
        return this.bva;
    }

    public void a(CommonTabContentView.c cVar) {
        this.buR = cVar;
    }

    public CommonTabContentView.c Mg() {
        return this.buR;
    }
}
