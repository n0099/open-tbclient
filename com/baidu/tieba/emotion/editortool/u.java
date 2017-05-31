package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class u {
    private int bLA;
    private int bLB;
    private int bLC;
    private com.baidu.tbadk.editortools.emotiontool.c bLD;
    private int bLE;
    private int bLF;
    private EmotionGroupType bLy;
    private int bLz;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bLD = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c WH() {
        return this.bLD;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bLy = emotionGroupType;
    }

    public EmotionGroupType WI() {
        return this.bLy;
    }

    public void eL(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eK(int i) {
        this.column = i;
    }

    public int WJ() {
        return this.column;
    }

    public void hF(int i) {
        this.bLF = i;
    }

    public int WK() {
        return this.bLF;
    }

    public void hG(int i) {
        this.bLE = i;
    }

    public int WL() {
        return this.bLE;
    }

    public void hH(int i) {
        this.bLz = i;
    }

    public int WM() {
        return this.bLz;
    }

    public void hI(int i) {
        this.bLB = i;
    }

    public int WN() {
        return this.bLB;
    }

    public void setEndIndex(int i) {
        this.bLC = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hJ(int i) {
        this.bLA = i;
    }

    public int WO() {
        return this.bLA;
    }
}
