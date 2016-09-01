package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected l EJ;
    private CommonTabContentView.c awX;
    private C0042b axc;
    private a axd;
    private c.a axg;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int axe = 0;
    private int axf = 0;
    private int axh = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0042b {
        public int axi;
        public int axj;
    }

    public abstract void CU();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.axg = aVar;
    }

    public void setEditorTools(l lVar) {
        this.EJ = lVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EJ != null) {
            this.EJ.b(aVar);
        }
    }

    public C0042b DP() {
        return this.axc;
    }

    public void a(C0042b c0042b) {
        this.axc = c0042b;
    }

    public a DQ() {
        return this.axd;
    }

    public void a(a aVar) {
        this.axd = aVar;
    }

    public int DR() {
        return this.column;
    }

    public void eL(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eM(int i) {
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
        return this.axe;
    }

    public int getPaddingRight() {
        return this.axf;
    }

    public int DS() {
        return this.axh;
    }

    public void eN(int i) {
        this.axh = i;
    }

    public c.a DT() {
        return this.axg;
    }

    public void a(CommonTabContentView.c cVar) {
        this.awX = cVar;
    }

    public CommonTabContentView.c DU() {
        return this.awX;
    }
}
