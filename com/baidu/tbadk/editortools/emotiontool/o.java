package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class o {
    private int aqA;
    private v aqB;
    private int aqC;
    private int aqD;
    private EmotionGroupType aqw;
    private int aqx;
    private int aqy;
    private int aqz;
    private int column;
    private int index;
    private int row;

    public void e(v vVar) {
        this.aqB = vVar;
    }

    public v AR() {
        return this.aqB;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.aqw = emotionGroupType;
    }

    public EmotionGroupType AS() {
        return this.aqw;
    }

    public void dS(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void dT(int i) {
        this.column = i;
    }

    public int AT() {
        return this.column;
    }

    public void dU(int i) {
        this.aqD = i;
    }

    public int AU() {
        return this.aqD;
    }

    public void dV(int i) {
        this.aqC = i;
    }

    public int AV() {
        return this.aqC;
    }

    public void dW(int i) {
        this.aqx = i;
    }

    public int AW() {
        return this.aqx;
    }

    public void dX(int i) {
        this.aqz = i;
    }

    public int AX() {
        return this.aqz;
    }

    public void setEndIndex(int i) {
        this.aqA = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void dY(int i) {
        this.aqy = i;
    }

    public int AY() {
        return this.aqy;
    }
}
