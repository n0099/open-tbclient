package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int column;
    private EmotionGroupType eAt;
    private int eAu;
    private int eAv;
    private com.baidu.tbadk.editortools.emotiontool.c eAw;
    private int eAx;
    private int eAy;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAw = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aVB() {
        return this.eAw;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.eAt = emotionGroupType;
    }

    public EmotionGroupType aVC() {
        return this.eAt;
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
        this.eAy = i;
    }

    public int aVE() {
        return this.eAy;
    }

    public void oT(int i) {
        this.eAx = i;
    }

    public int aVF() {
        return this.eAx;
    }

    public void oU(int i) {
        this.eAu = i;
    }

    public int aVG() {
        return this.eAu;
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
        this.eAv = i;
    }

    public int aVI() {
        return this.eAv;
    }
}
