package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected j KO;
    private CommonTabContentView.c aBF;
    private C0040b aBK;
    private a aBL;
    private c.a aBO;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aBM = 0;
    private int aBN = 0;
    private int aBP = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0040b {
        public int aBQ;
        public int aBR;
    }

    public abstract void Dx();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.aBO = aVar;
    }

    public void setEditorTools(j jVar) {
        this.KO = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KO != null) {
            this.KO.b(aVar);
        }
    }

    public C0040b Eo() {
        return this.aBK;
    }

    public void a(C0040b c0040b) {
        this.aBK = c0040b;
    }

    public a Ep() {
        return this.aBL;
    }

    public void a(a aVar) {
        this.aBL = aVar;
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
        return this.aBM;
    }

    public int getPaddingRight() {
        return this.aBN;
    }

    public int Er() {
        return this.aBP;
    }

    public void eP(int i) {
        this.aBP = i;
    }

    public c.a Es() {
        return this.aBO;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aBF = cVar;
    }

    public CommonTabContentView.c Et() {
        return this.aBF;
    }
}
