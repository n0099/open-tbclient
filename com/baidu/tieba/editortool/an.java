package com.baidu.tieba.editortool;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class an {
    private com.baidu.tbadk.editortool.w RC;
    private ap arB;
    private ao arC;
    private at arD;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public an(at atVar) {
        this.arD = atVar;
    }

    public ap Cp() {
        return this.arB;
    }

    public void a(ap apVar) {
        this.arB = apVar;
    }

    public ao Cq() {
        return this.arC;
    }

    public void a(ao aoVar) {
        this.arC = aoVar;
    }

    public int Cr() {
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

    public int Cs() {
        return this.verticalSpacing;
    }

    public void setVerticalSpacing(int i) {
        this.verticalSpacing = i;
    }

    public int Ct() {
        return this.horizontalSpacing;
    }

    public void setHorizontalSpacing(int i) {
        this.horizontalSpacing = i;
    }

    public at Cu() {
        return this.arD;
    }

    public com.baidu.tbadk.editortool.w Cv() {
        return this.RC;
    }

    public void b(com.baidu.tbadk.editortool.w wVar) {
        this.RC = wVar;
    }
}
