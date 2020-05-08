package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes6.dex */
public class b {
    private int aXG;
    private int aXH;
    private int column;
    private EmotionGroupType gyE;
    private int gyF;
    private int gyG;
    private com.baidu.tbadk.editortools.emotiontool.c gyH;
    private int gyI;
    private int gyJ;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.gyH = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bHg() {
        return this.gyH;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.gyE = emotionGroupType;
    }

    public EmotionGroupType bHh() {
        return this.gyE;
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

    public int bHi() {
        return this.column;
    }

    public void rX(int i) {
        this.gyJ = i;
    }

    public int bHj() {
        return this.gyJ;
    }

    public void rY(int i) {
        this.gyI = i;
    }

    public int bHk() {
        return this.gyI;
    }

    public void rZ(int i) {
        this.gyF = i;
    }

    public int bHl() {
        return this.gyF;
    }

    public void sa(int i) {
        this.aXG = i;
    }

    public int bHm() {
        return this.aXG;
    }

    public void sb(int i) {
        this.aXH = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void sc(int i) {
        this.gyG = i;
    }

    public int bHn() {
        return this.gyG;
    }
}
