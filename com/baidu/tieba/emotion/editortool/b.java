package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int column;
    private EmotionGroupType eAM;
    private int eAN;
    private int eAO;
    private com.baidu.tbadk.editortools.emotiontool.c eAP;
    private int eAQ;
    private int eAR;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAP = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aVD() {
        return this.eAP;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.eAM = emotionGroupType;
    }

    public EmotionGroupType aVE() {
        return this.eAM;
    }

    public void jG(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void jF(int i) {
        this.column = i;
    }

    public int aVF() {
        return this.column;
    }

    public void oW(int i) {
        this.eAR = i;
    }

    public int aVG() {
        return this.eAR;
    }

    public void oX(int i) {
        this.eAQ = i;
    }

    public int aVH() {
        return this.eAQ;
    }

    public void oY(int i) {
        this.eAN = i;
    }

    public int aVI() {
        return this.eAN;
    }

    public void oZ(int i) {
        this.startIndex = i;
    }

    public int aVJ() {
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

    public void pa(int i) {
        this.eAO = i;
    }

    public int aVK() {
        return this.eAO;
    }
}
