package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes6.dex */
public class b {
    private int aXB;
    private int aXC;
    private int column;
    private int gyA;
    private com.baidu.tbadk.editortools.emotiontool.c gyB;
    private int gyC;
    private int gyD;
    private EmotionGroupType gyy;
    private int gyz;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.gyB = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bHi() {
        return this.gyB;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.gyy = emotionGroupType;
    }

    public EmotionGroupType bHj() {
        return this.gyy;
    }

    public void mM(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int bHk() {
        return this.column;
    }

    public void rX(int i) {
        this.gyD = i;
    }

    public int bHl() {
        return this.gyD;
    }

    public void rY(int i) {
        this.gyC = i;
    }

    public int bHm() {
        return this.gyC;
    }

    public void rZ(int i) {
        this.gyz = i;
    }

    public int bHn() {
        return this.gyz;
    }

    public void sa(int i) {
        this.aXB = i;
    }

    public int bHo() {
        return this.aXB;
    }

    public void sb(int i) {
        this.aXC = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void sc(int i) {
        this.gyA = i;
    }

    public int bHp() {
        return this.gyA;
    }
}
