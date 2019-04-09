package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int column;
    private EmotionGroupType eAu;
    private int eAv;
    private int eAw;
    private com.baidu.tbadk.editortools.emotiontool.c eAx;
    private int eAy;
    private int eAz;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAx = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aVB() {
        return this.eAx;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.eAu = emotionGroupType;
    }

    public EmotionGroupType aVC() {
        return this.eAu;
    }

    public void jF(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void jE(int i) {
        this.column = i;
    }

    public int aVD() {
        return this.column;
    }

    public void oS(int i) {
        this.eAz = i;
    }

    public int aVE() {
        return this.eAz;
    }

    public void oT(int i) {
        this.eAy = i;
    }

    public int aVF() {
        return this.eAy;
    }

    public void oU(int i) {
        this.eAv = i;
    }

    public int aVG() {
        return this.eAv;
    }

    public void oV(int i) {
        this.startIndex = i;
    }

    public int aVH() {
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

    public void oW(int i) {
        this.eAw = i;
    }

    public int aVI() {
        return this.eAw;
    }
}
