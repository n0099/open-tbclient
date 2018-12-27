package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes5.dex */
public class b {
    private int column;
    private EmotionGroupType dqc;
    private int dqd;
    private int dqe;
    private com.baidu.tbadk.editortools.emotiontool.c dqf;
    private int dqg;
    private int dqh;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dqf = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c avo() {
        return this.dqf;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.dqc = emotionGroupType;
    }

    public EmotionGroupType avp() {
        return this.dqc;
    }

    public void fV(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fU(int i) {
        this.column = i;
    }

    public int avq() {
        return this.column;
    }

    public void lt(int i) {
        this.dqh = i;
    }

    public int avr() {
        return this.dqh;
    }

    public void lu(int i) {
        this.dqg = i;
    }

    public int avs() {
        return this.dqg;
    }

    public void lv(int i) {
        this.dqd = i;
    }

    public int avt() {
        return this.dqd;
    }

    public void lw(int i) {
        this.startIndex = i;
    }

    public int avu() {
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

    public void lx(int i) {
        this.dqe = i;
    }

    public int avv() {
        return this.dqe;
    }
}
