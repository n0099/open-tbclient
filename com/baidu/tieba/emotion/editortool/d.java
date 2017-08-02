package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private EmotionGroupType bWm;
    private int bWn;
    private int bWo;
    private int bWp;
    private int bWq;
    private com.baidu.tbadk.editortools.emotiontool.c bWr;
    private int bWs;
    private int bWt;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bWr = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aaP() {
        return this.bWr;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bWm = emotionGroupType;
    }

    public EmotionGroupType aaQ() {
        return this.bWm;
    }

    public void eP(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eO(int i) {
        this.column = i;
    }

    public int aaR() {
        return this.column;
    }

    public void hV(int i) {
        this.bWt = i;
    }

    public int aaS() {
        return this.bWt;
    }

    public void hW(int i) {
        this.bWs = i;
    }

    public int aaT() {
        return this.bWs;
    }

    public void hX(int i) {
        this.bWn = i;
    }

    public int aaU() {
        return this.bWn;
    }

    public void hY(int i) {
        this.bWp = i;
    }

    public int aaV() {
        return this.bWp;
    }

    public void setEndIndex(int i) {
        this.bWq = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hZ(int i) {
        this.bWo = i;
    }

    public int aaW() {
        return this.bWo;
    }
}
