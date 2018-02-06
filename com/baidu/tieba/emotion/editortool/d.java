package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private int column;
    private EmotionGroupType doF;
    private int doG;
    private int doH;
    private com.baidu.tbadk.editortools.emotiontool.c doI;
    private int doJ;
    private int doK;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.doI = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c apV() {
        return this.doI;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.doF = emotionGroupType;
    }

    public EmotionGroupType apW() {
        return this.doF;
    }

    public void hS(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void hR(int i) {
        this.column = i;
    }

    public int apX() {
        return this.column;
    }

    public void mf(int i) {
        this.doK = i;
    }

    public int apY() {
        return this.doK;
    }

    public void mg(int i) {
        this.doJ = i;
    }

    public int apZ() {
        return this.doJ;
    }

    public void mh(int i) {
        this.doG = i;
    }

    public int aqa() {
        return this.doG;
    }

    public void mi(int i) {
        this.startIndex = i;
    }

    public int aqb() {
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
        this.doH = i;
    }

    public int aqc() {
        return this.doH;
    }
}
