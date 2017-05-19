package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected j Kg;
    private CommonTabContentView.c aBE;
    private C0044b aBJ;
    private a aBK;
    private c.a aBN;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aBL = 0;
    private int aBM = 0;
    private int aBO = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0044b {
        public int aBP;
        public int aBQ;
    }

    public abstract void CC();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.aBN = aVar;
    }

    public void setEditorTools(j jVar) {
        this.Kg = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kg != null) {
            this.Kg.b(aVar);
        }
    }

    public C0044b Ds() {
        return this.aBJ;
    }

    public void a(C0044b c0044b) {
        this.aBJ = c0044b;
    }

    public a Dt() {
        return this.aBK;
    }

    public void a(a aVar) {
        this.aBK = aVar;
    }

    public int Du() {
        return this.column;
    }

    public void eJ(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eK(int i) {
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
        return this.aBL;
    }

    public int getPaddingRight() {
        return this.aBM;
    }

    public int Dv() {
        return this.aBO;
    }

    public void eL(int i) {
        this.aBO = i;
    }

    public c.a Dw() {
        return this.aBN;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aBE = cVar;
    }

    public CommonTabContentView.c Dx() {
        return this.aBE;
    }
}
