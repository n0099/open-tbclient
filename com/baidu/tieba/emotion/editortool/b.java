package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes6.dex */
public class b {
    private int aDC;
    private int aDD;
    private int column;
    private EmotionGroupType fSS;
    private int fST;
    private int fSU;
    private com.baidu.tbadk.editortools.emotiontool.c fSV;
    private int fSW;
    private int fSX;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fSV = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bxo() {
        return this.fSV;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.fSS = emotionGroupType;
    }

    public EmotionGroupType bxp() {
        return this.fSS;
    }

    public void mz(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void my(int i) {
        this.column = i;
    }

    public int bxq() {
        return this.column;
    }

    public void rE(int i) {
        this.fSX = i;
    }

    public int bxr() {
        return this.fSX;
    }

    public void rF(int i) {
        this.fSW = i;
    }

    public int bxs() {
        return this.fSW;
    }

    public void rG(int i) {
        this.fST = i;
    }

    public int bxt() {
        return this.fST;
    }

    public void rH(int i) {
        this.aDC = i;
    }

    public int bxu() {
        return this.aDC;
    }

    public void rI(int i) {
        this.aDD = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void rJ(int i) {
        this.fSU = i;
    }

    public int bxv() {
        return this.fSU;
    }
}
