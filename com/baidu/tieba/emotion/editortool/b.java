package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes6.dex */
public class b {
    private int aDS;
    private int aDT;
    private int column;
    private EmotionGroupType fTQ;
    private int fTR;
    private int fTS;
    private com.baidu.tbadk.editortools.emotiontool.c fTT;
    private int fTU;
    private int fTV;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fTT = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bxw() {
        return this.fTT;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.fTQ = emotionGroupType;
    }

    public EmotionGroupType bxx() {
        return this.fTQ;
    }

    public void mB(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void mA(int i) {
        this.column = i;
    }

    public int bxy() {
        return this.column;
    }

    public void rG(int i) {
        this.fTV = i;
    }

    public int bxz() {
        return this.fTV;
    }

    public void rH(int i) {
        this.fTU = i;
    }

    public int bxA() {
        return this.fTU;
    }

    public void rI(int i) {
        this.fTR = i;
    }

    public int bxB() {
        return this.fTR;
    }

    public void rJ(int i) {
        this.aDS = i;
    }

    public int bxC() {
        return this.aDS;
    }

    public void rK(int i) {
        this.aDT = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void rL(int i) {
        this.fTS = i;
    }

    public int bxD() {
        return this.fTS;
    }
}
