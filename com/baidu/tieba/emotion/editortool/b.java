package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes7.dex */
public class b {
    private int bJW;
    private int bJX;
    private int column;
    private EmotionGroupType iAM;
    private int iAN;
    private int iAO;
    private com.baidu.tbadk.editortools.emotiontool.c iAP;
    private int iAQ;
    private int iAR;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iAP = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c ctt() {
        return this.iAP;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.iAM = emotionGroupType;
    }

    public EmotionGroupType ctu() {
        return this.iAM;
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

    public int ctv() {
        return this.column;
    }

    public void xh(int i) {
        this.iAR = i;
    }

    public int ctw() {
        return this.iAR;
    }

    public void xi(int i) {
        this.iAQ = i;
    }

    public int ctx() {
        return this.iAQ;
    }

    public void xj(int i) {
        this.iAN = i;
    }

    public int cty() {
        return this.iAN;
    }

    public void xk(int i) {
        this.bJW = i;
    }

    public int ctz() {
        return this.bJW;
    }

    public void xl(int i) {
        this.bJX = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void xm(int i) {
        this.iAO = i;
    }

    public int ctA() {
        return this.iAO;
    }
}
