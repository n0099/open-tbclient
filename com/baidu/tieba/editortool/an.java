package com.baidu.tieba.editortool;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class an {
    private com.baidu.tbadk.editortool.w RG;
    private ap arK;
    private ao arL;
    private at arM;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public an(at atVar) {
        this.arM = atVar;
    }

    public ap Cr() {
        return this.arK;
    }

    public void a(ap apVar) {
        this.arK = apVar;
    }

    public ao Cs() {
        return this.arL;
    }

    public void a(ao aoVar) {
        this.arL = aoVar;
    }

    public int Ct() {
        return this.column;
    }

    public void es(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void et(int i) {
        this.row = i;
    }

    public int Cu() {
        return this.verticalSpacing;
    }

    public void setVerticalSpacing(int i) {
        this.verticalSpacing = i;
    }

    public int Cv() {
        return this.horizontalSpacing;
    }

    public void setHorizontalSpacing(int i) {
        this.horizontalSpacing = i;
    }

    public at Cw() {
        return this.arM;
    }

    public com.baidu.tbadk.editortool.w Cx() {
        return this.RG;
    }

    public void b(com.baidu.tbadk.editortool.w wVar) {
        this.RG = wVar;
    }
}
