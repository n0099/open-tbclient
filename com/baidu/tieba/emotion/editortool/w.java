package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class w {
    private EmotionGroupType bRY;
    private int bRZ;
    private int bSa;
    private int bSb;
    private int bSc;
    private com.baidu.tbadk.editortools.emotiontool.c bSd;
    private int bSe;
    private int bSf;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bSd = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aad() {
        return this.bSd;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bRY = emotionGroupType;
    }

    public EmotionGroupType aae() {
        return this.bRY;
    }

    public void eN(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eM(int i) {
        this.column = i;
    }

    public int aaf() {
        return this.column;
    }

    public void hO(int i) {
        this.bSf = i;
    }

    public int aag() {
        return this.bSf;
    }

    public void hP(int i) {
        this.bSe = i;
    }

    public int aah() {
        return this.bSe;
    }

    public void hQ(int i) {
        this.bRZ = i;
    }

    public int aai() {
        return this.bRZ;
    }

    public void hR(int i) {
        this.bSb = i;
    }

    public int aaj() {
        return this.bSb;
    }

    public void setEndIndex(int i) {
        this.bSc = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hS(int i) {
        this.bSa = i;
    }

    public int aak() {
        return this.bSa;
    }
}
