package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int column;
    private EmotionGroupType ePY;
    private int ePZ;
    private int eQa;
    private com.baidu.tbadk.editortools.emotiontool.c eQb;
    private int eQc;
    private int eQd;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eQb = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bcM() {
        return this.eQb;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.ePY = emotionGroupType;
    }

    public EmotionGroupType bcN() {
        return this.ePY;
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

    public int bcO() {
        return this.column;
    }

    public void pW(int i) {
        this.eQd = i;
    }

    public int bcP() {
        return this.eQd;
    }

    public void pX(int i) {
        this.eQc = i;
    }

    public int bcQ() {
        return this.eQc;
    }

    public void pY(int i) {
        this.ePZ = i;
    }

    public int bcR() {
        return this.ePZ;
    }

    public void pZ(int i) {
        this.startIndex = i;
    }

    public int bcS() {
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
        this.eQa = i;
    }

    public int bcT() {
        return this.eQa;
    }
}
