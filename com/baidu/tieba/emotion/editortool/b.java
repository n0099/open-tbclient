package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes5.dex */
public class b {
    private int column;
    private EmotionGroupType dnk;
    private int dnl;
    private int dnm;
    private com.baidu.tbadk.editortools.emotiontool.c dnn;
    private int dno;
    private int dnp;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dnn = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c auz() {
        return this.dnn;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.dnk = emotionGroupType;
    }

    public EmotionGroupType auA() {
        return this.dnk;
    }

    public void fU(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fT(int i) {
        this.column = i;
    }

    public int auB() {
        return this.column;
    }

    public void lg(int i) {
        this.dnp = i;
    }

    public int auC() {
        return this.dnp;
    }

    public void lh(int i) {
        this.dno = i;
    }

    public int auD() {
        return this.dno;
    }

    public void li(int i) {
        this.dnl = i;
    }

    public int auE() {
        return this.dnl;
    }

    public void lj(int i) {
        this.startIndex = i;
    }

    public int auF() {
        return this.startIndex;
    }

    public void setEndIndex(int i) {
        this.endIndex = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void lk(int i) {
        this.dnm = i;
    }

    public int auG() {
        return this.dnm;
    }
}
