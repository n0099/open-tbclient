package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class b {
    private EmotionGroupType cRp;
    private int cRq;
    private int cRr;
    private com.baidu.tbadk.editortools.emotiontool.c cRs;
    private int cRt;
    private int cRu;
    private int column;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cRs = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c aoc() {
        return this.cRs;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cRp = emotionGroupType;
    }

    public EmotionGroupType aod() {
        return this.cRp;
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

    public int aoe() {
        return this.column;
    }

    public void jB(int i) {
        this.cRu = i;
    }

    public int aof() {
        return this.cRu;
    }

    public void jC(int i) {
        this.cRt = i;
    }

    public int aog() {
        return this.cRt;
    }

    public void jD(int i) {
        this.cRq = i;
    }

    public int aoh() {
        return this.cRq;
    }

    public void jE(int i) {
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

    public void jF(int i) {
        this.cRr = i;
    }

    public int aoj() {
        return this.cRr;
    }
}
