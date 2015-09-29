package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class o {
    private EmotionGroupType aqG;
    private int aqH;
    private int aqI;
    private int aqJ;
    private int aqK;
    private t aqL;
    private int aqM;
    private int aqN;
    private int column;
    private int index;
    private int row;

    public void e(t tVar) {
        this.aqL = tVar;
    }

    public t AR() {
        return this.aqL;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.aqG = emotionGroupType;
    }

    public EmotionGroupType AS() {
        return this.aqG;
    }

    public void eb(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void ec(int i) {
        this.column = i;
    }

    public int AT() {
        return this.column;
    }

    public void ed(int i) {
        this.aqN = i;
    }

    public int AU() {
        return this.aqN;
    }

    public void ee(int i) {
        this.aqM = i;
    }

    public int AV() {
        return this.aqM;
    }

    public void ef(int i) {
        this.aqH = i;
    }

    public int AW() {
        return this.aqH;
    }

    public void eg(int i) {
        this.aqJ = i;
    }

    public int AX() {
        return this.aqJ;
    }

    public void setEndIndex(int i) {
        this.aqK = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void eh(int i) {
        this.aqI = i;
    }

    public int AY() {
        return this.aqI;
    }
}
