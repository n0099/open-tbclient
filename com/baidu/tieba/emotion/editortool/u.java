package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class u {
    private EmotionGroupType bFJ;
    private int bFK;
    private int bFL;
    private int bFM;
    private int bFN;
    private com.baidu.tbadk.editortools.emotiontool.c bFO;
    private int bFP;
    private int bFQ;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bFO = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c VE() {
        return this.bFO;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bFJ = emotionGroupType;
    }

    public EmotionGroupType VF() {
        return this.bFJ;
    }

    public void eK(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eJ(int i) {
        this.column = i;
    }

    public int VG() {
        return this.column;
    }

    public void hh(int i) {
        this.bFQ = i;
    }

    public int VH() {
        return this.bFQ;
    }

    public void hi(int i) {
        this.bFP = i;
    }

    public int VI() {
        return this.bFP;
    }

    public void hj(int i) {
        this.bFK = i;
    }

    public int VJ() {
        return this.bFK;
    }

    public void hk(int i) {
        this.bFM = i;
    }

    public int VK() {
        return this.bFM;
    }

    public void setEndIndex(int i) {
        this.bFN = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hl(int i) {
        this.bFL = i;
    }

    public int VL() {
        return this.bFL;
    }
}
