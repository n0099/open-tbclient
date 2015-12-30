package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private EmotionGroupType aTq;
    private int aTr;
    private int aTs;
    private int aTt;
    private int aTu;
    private com.baidu.tbadk.editortools.emotiontool.c aTv;
    private int aTw;
    private int aTx;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aTv = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c JC() {
        return this.aTv;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.aTq = emotionGroupType;
    }

    public EmotionGroupType JD() {
        return this.aTq;
    }

    public void ep(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eo(int i) {
        this.column = i;
    }

    public int JE() {
        return this.column;
    }

    public void fh(int i) {
        this.aTx = i;
    }

    public int JF() {
        return this.aTx;
    }

    public void fi(int i) {
        this.aTw = i;
    }

    public int JG() {
        return this.aTw;
    }

    public void fj(int i) {
        this.aTr = i;
    }

    public int JH() {
        return this.aTr;
    }

    public void fk(int i) {
        this.aTt = i;
    }

    public int JI() {
        return this.aTt;
    }

    public void setEndIndex(int i) {
        this.aTu = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void fl(int i) {
        this.aTs = i;
    }

    public int JJ() {
        return this.aTs;
    }
}
