package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private EmotionGroupType bYe;
    private int bYf;
    private int bYg;
    private int bYh;
    private int bYi;
    private com.baidu.tbadk.editortools.emotiontool.c bYj;
    private int bYk;
    private int bYl;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bYj = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c abp() {
        return this.bYj;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bYe = emotionGroupType;
    }

    public EmotionGroupType abq() {
        return this.bYe;
    }

    public void eR(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eQ(int i) {
        this.column = i;
    }

    public int abr() {
        return this.column;
    }

    public void hX(int i) {
        this.bYl = i;
    }

    public int abs() {
        return this.bYl;
    }

    public void hY(int i) {
        this.bYk = i;
    }

    public int abt() {
        return this.bYk;
    }

    public void hZ(int i) {
        this.bYf = i;
    }

    public int abu() {
        return this.bYf;
    }

    public void ia(int i) {
        this.bYh = i;
    }

    public int abv() {
        return this.bYh;
    }

    public void setEndIndex(int i) {
        this.bYi = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void ib(int i) {
        this.bYg = i;
    }

    public int abw() {
        return this.bYg;
    }
}
