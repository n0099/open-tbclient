package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private EmotionGroupType bwm;
    private int bwn;
    private int bwo;
    private int bwp;
    private int bwq;
    private com.baidu.tbadk.editortools.emotiontool.c bwr;
    private int bws;
    private int bwt;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bwr = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c TM() {
        return this.bwr;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bwm = emotionGroupType;
    }

    public EmotionGroupType TN() {
        return this.bwm;
    }

    public void eQ(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eP(int i) {
        this.column = i;
    }

    public int TO() {
        return this.column;
    }

    public void hf(int i) {
        this.bwt = i;
    }

    public int TP() {
        return this.bwt;
    }

    public void hg(int i) {
        this.bws = i;
    }

    public int TQ() {
        return this.bws;
    }

    public void hh(int i) {
        this.bwn = i;
    }

    public int TR() {
        return this.bwn;
    }

    public void hi(int i) {
        this.bwp = i;
    }

    public int TS() {
        return this.bwp;
    }

    public void setEndIndex(int i) {
        this.bwq = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hj(int i) {
        this.bwo = i;
    }

    public int TT() {
        return this.bwo;
    }
}
