package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private EmotionGroupType bXs;
    private int bXt;
    private int bXu;
    private int bXv;
    private int bXw;
    private com.baidu.tbadk.editortools.emotiontool.c bXx;
    private int bXy;
    private int bXz;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bXx = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aaU() {
        return this.bXx;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bXs = emotionGroupType;
    }

    public EmotionGroupType aaV() {
        return this.bXs;
    }

    public void eR(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eQ(int i) {
        this.column = i;
    }

    public int aaW() {
        return this.column;
    }

    public void hV(int i) {
        this.bXz = i;
    }

    public int aaX() {
        return this.bXz;
    }

    public void hW(int i) {
        this.bXy = i;
    }

    public int aaY() {
        return this.bXy;
    }

    public void hX(int i) {
        this.bXt = i;
    }

    public int aaZ() {
        return this.bXt;
    }

    public void hY(int i) {
        this.bXv = i;
    }

    public int aba() {
        return this.bXv;
    }

    public void setEndIndex(int i) {
        this.bXw = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hZ(int i) {
        this.bXu = i;
    }

    public int abb() {
        return this.bXu;
    }
}
