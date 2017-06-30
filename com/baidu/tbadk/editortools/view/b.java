package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected j JT;
    private a aCA;
    private c.a aCD;
    private CommonTabContentView.c aCu;
    private C0046b aCz;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aCB = 0;
    private int aCC = 0;
    private int aCE = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0046b {
        public int aCF;
        public int aCG;
    }

    public abstract void CR();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.aCD = aVar;
    }

    public void setEditorTools(j jVar) {
        this.JT = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    public C0046b DG() {
        return this.aCz;
    }

    public void a(C0046b c0046b) {
        this.aCz = c0046b;
    }

    public a DH() {
        return this.aCA;
    }

    public void a(a aVar) {
        this.aCA = aVar;
    }

    public int DI() {
        return this.column;
    }

    public void eM(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eN(int i) {
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
        return this.aCB;
    }

    public int getPaddingRight() {
        return this.aCC;
    }

    public int DJ() {
        return this.aCE;
    }

    public void eO(int i) {
        this.aCE = i;
    }

    public c.a DK() {
        return this.aCD;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aCu = cVar;
    }

    public CommonTabContentView.c DL() {
        return this.aCu;
    }
}
