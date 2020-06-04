package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes6.dex */
public class b {
    private int bfa;
    private int bfc;
    private int column;
    private int gNA;
    private int gNB;
    private com.baidu.tbadk.editortools.emotiontool.c gNC;
    private int gND;
    private int gNE;
    private EmotionGroupType gNz;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.gNC = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bNC() {
        return this.gNC;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.gNz = emotionGroupType;
    }

    public EmotionGroupType bND() {
        return this.gNz;
    }

    public void nq(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int bNE() {
        return this.column;
    }

    public void sE(int i) {
        this.gNE = i;
    }

    public int bNF() {
        return this.gNE;
    }

    public void sF(int i) {
        this.gND = i;
    }

    public int bNG() {
        return this.gND;
    }

    public void sG(int i) {
        this.gNA = i;
    }

    public int bNH() {
        return this.gNA;
    }

    public void sH(int i) {
        this.bfa = i;
    }

    public int bNI() {
        return this.bfa;
    }

    public void sI(int i) {
        this.bfc = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void sJ(int i) {
        this.gNB = i;
    }

    public int bNJ() {
        return this.gNB;
    }
}
