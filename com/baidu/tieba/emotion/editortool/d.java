package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private EmotionGroupType cbH;
    private int cbI;
    private int cbJ;
    private int cbK;
    private int cbL;
    private com.baidu.tbadk.editortools.emotiontool.c cbM;
    private int cbN;
    private int cbO;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cbM = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c acj() {
        return this.cbM;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cbH = emotionGroupType;
    }

    public EmotionGroupType ack() {
        return this.cbH;
    }

    public void fb(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fa(int i) {
        this.column = i;
    }

    public int acl() {
        return this.column;
    }

    public void iq(int i) {
        this.cbO = i;
    }

    public int acm() {
        return this.cbO;
    }

    public void ir(int i) {
        this.cbN = i;
    }

    public int acn() {
        return this.cbN;
    }

    public void is(int i) {
        this.cbI = i;
    }

    public int aco() {
        return this.cbI;
    }

    public void it(int i) {
        this.cbK = i;
    }

    public int acp() {
        return this.cbK;
    }

    public void setEndIndex(int i) {
        this.cbL = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void iu(int i) {
        this.cbJ = i;
    }

    public int acq() {
        return this.cbJ;
    }
}
