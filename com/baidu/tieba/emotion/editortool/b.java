package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class b {
    private EmotionGroupType cXg;
    private int cXh;
    private int cXi;
    private com.baidu.tbadk.editortools.emotiontool.c cXj;
    private int cXk;
    private int cXl;
    private int column;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cXj = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c apR() {
        return this.cXj;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cXg = emotionGroupType;
    }

    public EmotionGroupType apS() {
        return this.cXg;
    }

    public void fj(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fi(int i) {
        this.column = i;
    }

    public int apT() {
        return this.column;
    }

    public void ka(int i) {
        this.cXl = i;
    }

    public int apU() {
        return this.cXl;
    }

    public void kb(int i) {
        this.cXk = i;
    }

    public int apV() {
        return this.cXk;
    }

    public void kc(int i) {
        this.cXh = i;
    }

    public int apW() {
        return this.cXh;
    }

    public void kd(int i) {
        this.startIndex = i;
    }

    public int apX() {
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

    public void ke(int i) {
        this.cXi = i;
    }

    public int apY() {
        return this.cXi;
    }
}
