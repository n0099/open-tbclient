package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class b {
    private EmotionGroupType cOJ;
    private int cOK;
    private int cOL;
    private com.baidu.tbadk.editortools.emotiontool.c cOM;
    private int cON;
    private int cOO;
    private int column;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cOM = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c anD() {
        return this.cOM;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cOJ = emotionGroupType;
    }

    public EmotionGroupType anE() {
        return this.cOJ;
    }

    public void eX(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eW(int i) {
        this.column = i;
    }

    public int anF() {
        return this.column;
    }

    public void jq(int i) {
        this.cOO = i;
    }

    public int anG() {
        return this.cOO;
    }

    public void jr(int i) {
        this.cON = i;
    }

    public int anH() {
        return this.cON;
    }

    public void js(int i) {
        this.cOK = i;
    }

    public int anI() {
        return this.cOK;
    }

    public void jt(int i) {
        this.startIndex = i;
    }

    public int anJ() {
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

    public void ju(int i) {
        this.cOL = i;
    }

    public int anK() {
        return this.cOL;
    }
}
