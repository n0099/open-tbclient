package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private int column;
    private EmotionGroupType dot;
    private int dou;
    private int dov;
    private com.baidu.tbadk.editortools.emotiontool.c dow;
    private int dox;
    private int doy;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dow = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c apU() {
        return this.dow;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.dot = emotionGroupType;
    }

    public EmotionGroupType apV() {
        return this.dot;
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

    public int apW() {
        return this.column;
    }

    public void mf(int i) {
        this.doy = i;
    }

    public int apX() {
        return this.doy;
    }

    public void mg(int i) {
        this.dox = i;
    }

    public int apY() {
        return this.dox;
    }

    public void mh(int i) {
        this.dou = i;
    }

    public int apZ() {
        return this.dou;
    }

    public void mi(int i) {
        this.startIndex = i;
    }

    public int aqa() {
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
        this.dov = i;
    }

    public int aqb() {
        return this.dov;
    }
}
