package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private EmotionGroupType aWi;
    private int aWj;
    private int aWk;
    private int aWl;
    private int aWm;
    private com.baidu.tbadk.editortools.emotiontool.c aWn;
    private int aWo;
    private int aWp;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aWn = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c LN() {
        return this.aWn;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.aWi = emotionGroupType;
    }

    public EmotionGroupType LO() {
        return this.aWi;
    }

    public void eu(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void et(int i) {
        this.column = i;
    }

    public int LP() {
        return this.column;
    }

    public void fD(int i) {
        this.aWp = i;
    }

    public int LQ() {
        return this.aWp;
    }

    public void fE(int i) {
        this.aWo = i;
    }

    public int LR() {
        return this.aWo;
    }

    public void fF(int i) {
        this.aWj = i;
    }

    public int LS() {
        return this.aWj;
    }

    public void fG(int i) {
        this.aWl = i;
    }

    public int LT() {
        return this.aWl;
    }

    public void setEndIndex(int i) {
        this.aWm = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void fH(int i) {
        this.aWk = i;
    }

    public int LU() {
        return this.aWk;
    }
}
