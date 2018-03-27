package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private int column;
    private int doA;
    private int doB;
    private EmotionGroupType dow;
    private int dox;
    private int doy;
    private com.baidu.tbadk.editortools.emotiontool.c doz;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.doz = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c apV() {
        return this.doz;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.dow = emotionGroupType;
    }

    public EmotionGroupType apW() {
        return this.dow;
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
        this.doB = i;
    }

    public int apY() {
        return this.doB;
    }

    public void mg(int i) {
        this.doA = i;
    }

    public int apZ() {
        return this.doA;
    }

    public void mh(int i) {
        this.dox = i;
    }

    public int aqa() {
        return this.dox;
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
        this.doy = i;
    }

    public int aqc() {
        return this.doy;
    }
}
