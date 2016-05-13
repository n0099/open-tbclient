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

    public com.baidu.tbadk.editortools.emotiontool.c LP() {
        return this.aWn;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.aWi = emotionGroupType;
    }

    public EmotionGroupType LQ() {
        return this.aWi;
    }

    public void et(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void es(int i) {
        this.column = i;
    }

    public int LR() {
        return this.column;
    }

    public void fC(int i) {
        this.aWp = i;
    }

    public int LS() {
        return this.aWp;
    }

    public void fD(int i) {
        this.aWo = i;
    }

    public int LT() {
        return this.aWo;
    }

    public void fE(int i) {
        this.aWj = i;
    }

    public int LU() {
        return this.aWj;
    }

    public void fF(int i) {
        this.aWl = i;
    }

    public int LV() {
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

    public void fG(int i) {
        this.aWk = i;
    }

    public int LW() {
        return this.aWk;
    }
}
