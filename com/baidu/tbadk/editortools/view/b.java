package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected l Cw;
    private CommonTabContentView.c atQ;
    private C0042b atV;
    private a atW;
    private c.a atZ;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int atX = 0;
    private int atY = 0;
    private int aua = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0042b {
        public int aub;
        public int auc;
    }

    public abstract void Bz();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.atZ = aVar;
    }

    public void setEditorTools(l lVar) {
        this.Cw = lVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Cw != null) {
            this.Cw.b(aVar);
        }
    }

    public C0042b Cu() {
        return this.atV;
    }

    public void a(C0042b c0042b) {
        this.atV = c0042b;
    }

    public a Cv() {
        return this.atW;
    }

    public void a(a aVar) {
        this.atW = aVar;
    }

    public int Cw() {
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
        return this.atX;
    }

    public int getPaddingRight() {
        return this.atY;
    }

    public int Cx() {
        return this.aua;
    }

    public void ez(int i) {
        this.aua = i;
    }

    public c.a Cy() {
        return this.atZ;
    }

    public void a(CommonTabContentView.c cVar) {
        this.atQ = cVar;
    }

    public CommonTabContentView.c Cz() {
        return this.atQ;
    }
}
