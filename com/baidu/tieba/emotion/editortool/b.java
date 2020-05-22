package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes6.dex */
public class b {
    private int bfa;
    private int bfc;
    private int column;
    private EmotionGroupType gNo;
    private int gNp;
    private int gNq;
    private com.baidu.tbadk.editortools.emotiontool.c gNr;
    private int gNs;
    private int gNt;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.gNr = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bNA() {
        return this.gNr;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.gNo = emotionGroupType;
    }

    public EmotionGroupType bNB() {
        return this.gNo;
    }

    public void no(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int bNC() {
        return this.column;
    }

    public void sC(int i) {
        this.gNt = i;
    }

    public int bND() {
        return this.gNt;
    }

    public void sD(int i) {
        this.gNs = i;
    }

    public int bNE() {
        return this.gNs;
    }

    public void sE(int i) {
        this.gNp = i;
    }

    public int bNF() {
        return this.gNp;
    }

    public void sF(int i) {
        this.bfa = i;
    }

    public int bNG() {
        return this.bfa;
    }

    public void sG(int i) {
        this.bfc = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void sH(int i) {
        this.gNq = i;
    }

    public int bNH() {
        return this.gNq;
    }
}
