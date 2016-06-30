package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private EmotionGroupType brP;
    private int brQ;
    private int brR;
    private int brS;
    private int brT;
    private com.baidu.tbadk.editortools.emotiontool.c brU;
    private int brV;
    private int brW;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.brU = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c Rr() {
        return this.brU;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.brP = emotionGroupType;
    }

    public EmotionGroupType Rs() {
        return this.brP;
    }

    public void ey(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void ex(int i) {
        this.column = i;
    }

    public int Rt() {
        return this.column;
    }

    public void gC(int i) {
        this.brW = i;
    }

    public int Ru() {
        return this.brW;
    }

    public void gD(int i) {
        this.brV = i;
    }

    public int Rv() {
        return this.brV;
    }

    public void gE(int i) {
        this.brQ = i;
    }

    public int Rw() {
        return this.brQ;
    }

    public void gF(int i) {
        this.brS = i;
    }

    public int Rx() {
        return this.brS;
    }

    public void setEndIndex(int i) {
        this.brT = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void gG(int i) {
        this.brR = i;
    }

    public int Ry() {
        return this.brR;
    }
}
