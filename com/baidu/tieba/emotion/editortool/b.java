package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes5.dex */
public class b {
    private int column;
    private EmotionGroupType dqP;
    private int dqQ;
    private int dqR;
    private com.baidu.tbadk.editortools.emotiontool.c dqS;
    private int dqT;
    private int dqU;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dqS = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c avM() {
        return this.dqS;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.dqP = emotionGroupType;
    }

    public EmotionGroupType avN() {
        return this.dqP;
    }

    public void fV(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fU(int i) {
        this.column = i;
    }

    public int avO() {
        return this.column;
    }

    public void lu(int i) {
        this.dqU = i;
    }

    public int avP() {
        return this.dqU;
    }

    public void lv(int i) {
        this.dqT = i;
    }

    public int avQ() {
        return this.dqT;
    }

    public void lw(int i) {
        this.dqQ = i;
    }

    public int avR() {
        return this.dqQ;
    }

    public void lx(int i) {
        this.startIndex = i;
    }

    public int avS() {
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

    public void ly(int i) {
        this.dqR = i;
    }

    public int avT() {
        return this.dqR;
    }
}
