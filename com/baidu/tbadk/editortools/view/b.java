package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected j JU;
    private c.a aBA;
    private CommonTabContentView.c aBr;
    private C0044b aBw;
    private a aBx;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aBy = 0;
    private int aBz = 0;
    private int aBB = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0044b {
        public int aBC;
        public int aBD;
    }

    public abstract void Cw();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.aBA = aVar;
    }

    public void setEditorTools(j jVar) {
        this.JU = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JU != null) {
            this.JU.b(aVar);
        }
    }

    public C0044b Dm() {
        return this.aBw;
    }

    public void a(C0044b c0044b) {
        this.aBw = c0044b;
    }

    public a Dn() {
        return this.aBx;
    }

    public void a(a aVar) {
        this.aBx = aVar;
    }

    public int Do() {
        return this.column;
    }

    public void eK(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eL(int i) {
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
        return this.aBy;
    }

    public int getPaddingRight() {
        return this.aBz;
    }

    public int Dp() {
        return this.aBB;
    }

    public void eM(int i) {
        this.aBB = i;
    }

    public c.a Dq() {
        return this.aBA;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aBr = cVar;
    }

    public CommonTabContentView.c Dr() {
        return this.aBr;
    }
}
