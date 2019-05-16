package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int column;
    private EmotionGroupType ePX;
    private int ePY;
    private int ePZ;
    private com.baidu.tbadk.editortools.emotiontool.c eQa;
    private int eQb;
    private int eQc;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eQa = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bcJ() {
        return this.eQa;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.ePX = emotionGroupType;
    }

    public EmotionGroupType bcK() {
        return this.ePX;
    }

    public void kt(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void ks(int i) {
        this.column = i;
    }

    public int bcL() {
        return this.column;
    }

    public void pW(int i) {
        this.eQc = i;
    }

    public int bcM() {
        return this.eQc;
    }

    public void pX(int i) {
        this.eQb = i;
    }

    public int bcN() {
        return this.eQb;
    }

    public void pY(int i) {
        this.ePY = i;
    }

    public int bcO() {
        return this.ePY;
    }

    public void pZ(int i) {
        this.startIndex = i;
    }

    public int bcP() {
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

    public void qa(int i) {
        this.ePZ = i;
    }

    public int bcQ() {
        return this.ePZ;
    }
}
