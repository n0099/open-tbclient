package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected j KM;
    private CommonTabContentView.c aBD;
    private C0040b aBI;
    private a aBJ;
    private c.a aBM;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aBK = 0;
    private int aBL = 0;
    private int aBN = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0040b {
        public int aBO;
        public int aBP;
    }

    public abstract void Dx();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.aBM = aVar;
    }

    public void setEditorTools(j jVar) {
        this.KM = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KM != null) {
            this.KM.b(aVar);
        }
    }

    public C0040b Eo() {
        return this.aBI;
    }

    public void a(C0040b c0040b) {
        this.aBI = c0040b;
    }

    public a Ep() {
        return this.aBJ;
    }

    public void a(a aVar) {
        this.aBJ = aVar;
    }

    public int Eq() {
        return this.column;
    }

    public void eN(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eO(int i) {
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
        return this.aBK;
    }

    public int getPaddingRight() {
        return this.aBL;
    }

    public int Er() {
        return this.aBN;
    }

    public void eP(int i) {
        this.aBN = i;
    }

    public c.a Es() {
        return this.aBM;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aBD = cVar;
    }

    public CommonTabContentView.c Et() {
        return this.aBD;
    }
}
