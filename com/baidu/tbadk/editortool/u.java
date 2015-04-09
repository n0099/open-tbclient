package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class u {
    private EmotionGroupType ajm;
    private int ajn;
    private int ajo;
    private int ajp;
    private int ajq;
    private ad ajr;
    private int ajs;
    private int ajt;
    private int column;
    private int index;
    private int row;

    public void e(ad adVar) {
        this.ajr = adVar;
    }

    public ad yG() {
        return this.ajr;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.ajm = emotionGroupType;
    }

    public EmotionGroupType yH() {
        return this.ajm;
    }

    public void ds(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void dt(int i) {
        this.column = i;
    }

    public int yI() {
        return this.column;
    }

    public void du(int i) {
        this.ajt = i;
    }

    public int yJ() {
        return this.ajt;
    }

    public void dv(int i) {
        this.ajs = i;
    }

    public int yK() {
        return this.ajs;
    }

    public void dw(int i) {
        this.ajn = i;
    }

    public int yL() {
        return this.ajn;
    }

    public void dx(int i) {
        this.ajp = i;
    }

    public int yM() {
        return this.ajp;
    }

    public void setEndIndex(int i) {
        this.ajq = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void dy(int i) {
        this.ajo = i;
    }

    public int yN() {
        return this.ajo;
    }
}
