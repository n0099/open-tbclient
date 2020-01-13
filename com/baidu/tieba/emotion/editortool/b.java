package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes5.dex */
public class b {
    private int azm;
    private int azn;
    private int column;
    private com.baidu.tbadk.editortools.emotiontool.c fQA;
    private int fQB;
    private int fQC;
    private EmotionGroupType fQx;
    private int fQy;
    private int fQz;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fQA = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bvK() {
        return this.fQA;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.fQx = emotionGroupType;
    }

    public EmotionGroupType bvL() {
        return this.fQx;
    }

    public void mh(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void mg(int i) {
        this.column = i;
    }

    public int bvM() {
        return this.column;
    }

    public void rx(int i) {
        this.fQC = i;
    }

    public int bvN() {
        return this.fQC;
    }

    public void ry(int i) {
        this.fQB = i;
    }

    public int bvO() {
        return this.fQB;
    }

    public void rz(int i) {
        this.fQy = i;
    }

    public int bvP() {
        return this.fQy;
    }

    public void rA(int i) {
        this.azm = i;
    }

    public int bvQ() {
        return this.azm;
    }

    public void rB(int i) {
        this.azn = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void rC(int i) {
        this.fQz = i;
    }

    public int bvR() {
        return this.fQz;
    }
}
