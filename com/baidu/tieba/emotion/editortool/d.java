package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private int column;
    private EmotionGroupType dlO;
    private int dlP;
    private int dlQ;
    private com.baidu.tbadk.editortools.emotiontool.c dlR;
    private int dlS;
    private int dlT;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dlR = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c apg() {
        return this.dlR;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.dlO = emotionGroupType;
    }

    public EmotionGroupType aph() {
        return this.dlO;
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

    public int api() {
        return this.column;
    }

    public void mi(int i) {
        this.dlT = i;
    }

    public int apj() {
        return this.dlT;
    }

    public void mj(int i) {
        this.dlS = i;
    }

    public int apk() {
        return this.dlS;
    }

    public void mk(int i) {
        this.dlP = i;
    }

    public int apl() {
        return this.dlP;
    }

    public void ml(int i) {
        this.startIndex = i;
    }

    public int apm() {
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
        this.dlQ = i;
    }

    public int apn() {
        return this.dlQ;
    }
}
