package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private int column;
    private EmotionGroupType dlt;
    private int dlu;
    private int dlv;
    private com.baidu.tbadk.editortools.emotiontool.c dlw;
    private int dlx;
    private int dly;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dlw = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c apb() {
        return this.dlw;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.dlt = emotionGroupType;
    }

    public EmotionGroupType apc() {
        return this.dlt;
    }

    public void hU(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void hT(int i) {
        this.column = i;
    }

    public int apd() {
        return this.column;
    }

    public void mi(int i) {
        this.dly = i;
    }

    public int ape() {
        return this.dly;
    }

    public void mj(int i) {
        this.dlx = i;
    }

    public int apf() {
        return this.dlx;
    }

    public void mk(int i) {
        this.dlu = i;
    }

    public int apg() {
        return this.dlu;
    }

    public void ml(int i) {
        this.startIndex = i;
    }

    public int aph() {
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

    public void mm(int i) {
        this.dlv = i;
    }

    public int api() {
        return this.dlv;
    }
}
