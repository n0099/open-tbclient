package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class b {
    private EmotionGroupType cRs;
    private int cRt;
    private int cRu;
    private com.baidu.tbadk.editortools.emotiontool.c cRv;
    private int cRw;
    private int cRx;
    private int column;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cRv = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aoc() {
        return this.cRv;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cRs = emotionGroupType;
    }

    public EmotionGroupType aod() {
        return this.cRs;
    }

    public void eY(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eX(int i) {
        this.column = i;
    }

    public int aoe() {
        return this.column;
    }

    public void jC(int i) {
        this.cRx = i;
    }

    public int aof() {
        return this.cRx;
    }

    public void jD(int i) {
        this.cRw = i;
    }

    public int aog() {
        return this.cRw;
    }

    public void jE(int i) {
        this.cRt = i;
    }

    public int aoh() {
        return this.cRt;
    }

    public void jF(int i) {
        this.startIndex = i;
    }

    public int aoi() {
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

    public void jG(int i) {
        this.cRu = i;
    }

    public int aoj() {
        return this.cRu;
    }
}
