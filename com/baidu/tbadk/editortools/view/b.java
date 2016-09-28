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
    private CommonTabContentView.c awA;
    private C0042b awF;
    private a awG;
    private c.a awJ;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int awH = 0;
    private int awI = 0;
    private int awK = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0042b {
        public int awL;
        public int awM;
    }

    public abstract void CU();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.awJ = aVar;
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
        return this.awF;
    }

    public void a(C0042b c0042b) {
        this.awF = c0042b;
    }

    public a DQ() {
        return this.awG;
    }

    public void a(a aVar) {
        this.awG = aVar;
    }

    public int DR() {
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
        return this.awH;
    }

    public int getPaddingRight() {
        return this.awI;
    }

    public int DS() {
        return this.awK;
    }

    public void eM(int i) {
        this.awK = i;
    }

    public c.a DT() {
        return this.awJ;
    }

    public void a(CommonTabContentView.c cVar) {
        this.awA = cVar;
    }

    public CommonTabContentView.c DU() {
        return this.awA;
    }
}
