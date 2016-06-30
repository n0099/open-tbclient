package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected l BW;
    private CommonTabContentView.c atb;
    private C0041b atg;
    private a ath;
    private c.a atk;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int ati = 0;
    private int atj = 0;
    private int atl = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0041b {
        public int atm;
        public int atn;
    }

    public abstract void Bz();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.atk = aVar;
    }

    public void setEditorTools(l lVar) {
        this.BW = lVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BW != null) {
            this.BW.b(aVar);
        }
    }

    public C0041b Cv() {
        return this.atg;
    }

    public void a(C0041b c0041b) {
        this.atg = c0041b;
    }

    public a Cw() {
        return this.ath;
    }

    public void a(a aVar) {
        this.ath = aVar;
    }

    public int Cx() {
        return this.column;
    }

    public void ex(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void ey(int i) {
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
        return this.ati;
    }

    public int getPaddingRight() {
        return this.atj;
    }

    public int Cy() {
        return this.atl;
    }

    public void ez(int i) {
        this.atl = i;
    }

    public c.a Cz() {
        return this.atk;
    }

    public void a(CommonTabContentView.c cVar) {
        this.atb = cVar;
    }

    public CommonTabContentView.c CA() {
        return this.atb;
    }
}
