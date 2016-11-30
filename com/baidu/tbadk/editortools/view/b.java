package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected l EL;
    private c.a axA;
    private CommonTabContentView.c axr;
    private C0042b axw;
    private a axx;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int axy = 0;
    private int axz = 0;
    private int axB = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0042b {
        public int axC;
        public int axD;
    }

    public abstract void Dc();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.axA = aVar;
    }

    public void setEditorTools(l lVar) {
        this.EL = lVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EL != null) {
            this.EL.b(aVar);
        }
    }

    public C0042b DU() {
        return this.axw;
    }

    public void a(C0042b c0042b) {
        this.axw = c0042b;
    }

    public a DV() {
        return this.axx;
    }

    public void a(a aVar) {
        this.axx = aVar;
    }

    public int DW() {
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
        return this.axy;
    }

    public int getPaddingRight() {
        return this.axz;
    }

    public int DX() {
        return this.axB;
    }

    public void eP(int i) {
        this.axB = i;
    }

    public c.a DY() {
        return this.axA;
    }

    public void a(CommonTabContentView.c cVar) {
        this.axr = cVar;
    }

    public CommonTabContentView.c DZ() {
        return this.axr;
    }
}
