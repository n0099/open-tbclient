package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int column;
    private EmotionGroupType eAI;
    private int eAJ;
    private int eAK;
    private com.baidu.tbadk.editortools.emotiontool.c eAL;
    private int eAM;
    private int eAN;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAL = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aVD() {
        return this.eAL;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.eAI = emotionGroupType;
    }

    public EmotionGroupType aVE() {
        return this.eAI;
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
        this.eAN = i;
    }

    public int aVG() {
        return this.eAN;
    }

    public void oX(int i) {
        this.eAM = i;
    }

    public int aVH() {
        return this.eAM;
    }

    public void oY(int i) {
        this.eAJ = i;
    }

    public int aVI() {
        return this.eAJ;
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
        this.eAK = i;
    }

    public int aVK() {
        return this.eAK;
    }
}
