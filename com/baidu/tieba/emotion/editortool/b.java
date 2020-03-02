package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes6.dex */
public class b {
    private int aDD;
    private int aDE;
    private int column;
    private EmotionGroupType fSU;
    private int fSV;
    private int fSW;
    private com.baidu.tbadk.editortools.emotiontool.c fSX;
    private int fSY;
    private int fSZ;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fSX = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bxq() {
        return this.fSX;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.fSU = emotionGroupType;
    }

    public EmotionGroupType bxr() {
        return this.fSU;
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

    public int bxs() {
        return this.column;
    }

    public void rE(int i) {
        this.fSZ = i;
    }

    public int bxt() {
        return this.fSZ;
    }

    public void rF(int i) {
        this.fSY = i;
    }

    public int bxu() {
        return this.fSY;
    }

    public void rG(int i) {
        this.fSV = i;
    }

    public int bxv() {
        return this.fSV;
    }

    public void rH(int i) {
        this.aDD = i;
    }

    public int bxw() {
        return this.aDD;
    }

    public void rI(int i) {
        this.aDE = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void rJ(int i) {
        this.fSW = i;
    }

    public int bxx() {
        return this.fSW;
    }
}
