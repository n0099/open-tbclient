package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private int aVA;
    private com.baidu.tbadk.editortools.emotiontool.c aVB;
    private int aVC;
    private int aVD;
    private EmotionGroupType aVw;
    private int aVx;
    private int aVy;
    private int aVz;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aVB = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c Lq() {
        return this.aVB;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.aVw = emotionGroupType;
    }

    public EmotionGroupType Lr() {
        return this.aVw;
    }

    public void eJ(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eI(int i) {
        this.column = i;
    }

    public int Ls() {
        return this.column;
    }

    public void fG(int i) {
        this.aVD = i;
    }

    public int Lt() {
        return this.aVD;
    }

    public void fH(int i) {
        this.aVC = i;
    }

    public int Lu() {
        return this.aVC;
    }

    public void fI(int i) {
        this.aVx = i;
    }

    public int Lv() {
        return this.aVx;
    }

    public void fJ(int i) {
        this.aVz = i;
    }

    public int Lw() {
        return this.aVz;
    }

    public void setEndIndex(int i) {
        this.aVA = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void fK(int i) {
        this.aVy = i;
    }

    public int Lx() {
        return this.aVy;
    }
}
