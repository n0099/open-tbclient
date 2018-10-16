package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes5.dex */
public class b {
    private int column;
    private int dfA;
    private com.baidu.tbadk.editortools.emotiontool.c dfB;
    private int dfC;
    private int dfD;
    private EmotionGroupType dfy;
    private int dfz;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dfB = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c atn() {
        return this.dfB;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.dfy = emotionGroupType;
    }

    public EmotionGroupType ato() {
        return this.dfy;
    }

    public void fs(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fr(int i) {
        this.column = i;
    }

    public int atp() {
        return this.column;
    }

    public void ky(int i) {
        this.dfD = i;
    }

    public int atq() {
        return this.dfD;
    }

    public void kz(int i) {
        this.dfC = i;
    }

    public int atr() {
        return this.dfC;
    }

    public void kA(int i) {
        this.dfz = i;
    }

    public int ats() {
        return this.dfz;
    }

    public void kB(int i) {
        this.startIndex = i;
    }

    public int att() {
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

    public void kC(int i) {
        this.dfA = i;
    }

    public int atu() {
        return this.dfA;
    }
}
