package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes4.dex */
public class b {
    private int ayD;
    private int ayE;
    private int column;
    private EmotionGroupType fNo;
    private int fNp;
    private int fNq;
    private com.baidu.tbadk.editortools.emotiontool.c fNr;
    private int fNs;
    private int fNt;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fNr = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c buI() {
        return this.fNr;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.fNo = emotionGroupType;
    }

    public EmotionGroupType buJ() {
        return this.fNo;
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

    public int buK() {
        return this.column;
    }

    public void rs(int i) {
        this.fNt = i;
    }

    public int buL() {
        return this.fNt;
    }

    public void rt(int i) {
        this.fNs = i;
    }

    public int buM() {
        return this.fNs;
    }

    public void ru(int i) {
        this.fNp = i;
    }

    public int buN() {
        return this.fNp;
    }

    public void rv(int i) {
        this.ayD = i;
    }

    public int buO() {
        return this.ayD;
    }

    public void rw(int i) {
        this.ayE = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void rx(int i) {
        this.fNq = i;
    }

    public int buP() {
        return this.fNq;
    }
}
