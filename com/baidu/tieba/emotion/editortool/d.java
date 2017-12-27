package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private int column;
    private EmotionGroupType dgR;
    private int dgS;
    private int dgT;
    private com.baidu.tbadk.editortools.emotiontool.c dgU;
    private int dgV;
    private int dgW;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dgU = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c anY() {
        return this.dgU;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.dgR = emotionGroupType;
    }

    public EmotionGroupType anZ() {
        return this.dgR;
    }

    public void hY(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void hX(int i) {
        this.column = i;
    }

    public int aoa() {
        return this.column;
    }

    public void mf(int i) {
        this.dgW = i;
    }

    public int aob() {
        return this.dgW;
    }

    public void mg(int i) {
        this.dgV = i;
    }

    public int aoc() {
        return this.dgV;
    }

    public void mh(int i) {
        this.dgS = i;
    }

    public int aod() {
        return this.dgS;
    }

    public void mi(int i) {
        this.startIndex = i;
    }

    public int aoe() {
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

    public void mj(int i) {
        this.dgT = i;
    }

    public int aof() {
        return this.dgT;
    }
}
