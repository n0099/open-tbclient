package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes13.dex */
public class b {
    private int bxk;
    private int bxl;
    private int column;
    private EmotionGroupType hOZ;
    private int hPa;
    private int hPb;
    private com.baidu.tbadk.editortools.emotiontool.c hPc;
    private int hPd;
    private int hPe;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hPc = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c ckR() {
        return this.hPc;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.hOZ = emotionGroupType;
    }

    public EmotionGroupType ckS() {
        return this.hOZ;
    }

    public void rc(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int ckT() {
        return this.column;
    }

    public void wR(int i) {
        this.hPe = i;
    }

    public int ckU() {
        return this.hPe;
    }

    public void wS(int i) {
        this.hPd = i;
    }

    public int ckV() {
        return this.hPd;
    }

    public void wT(int i) {
        this.hPa = i;
    }

    public int ckW() {
        return this.hPa;
    }

    public void wU(int i) {
        this.bxk = i;
    }

    public int ckX() {
        return this.bxk;
    }

    public void wV(int i) {
        this.bxl = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void wW(int i) {
        this.hPb = i;
    }

    public int ckY() {
        return this.hPb;
    }
}
