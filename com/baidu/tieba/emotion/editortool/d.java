package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private EmotionGroupType bYf;
    private int bYg;
    private int bYh;
    private int bYi;
    private int bYj;
    private com.baidu.tbadk.editortools.emotiontool.c bYk;
    private int bYl;
    private int bYm;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bYk = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c abm() {
        return this.bYk;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bYf = emotionGroupType;
    }

    public EmotionGroupType abn() {
        return this.bYf;
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

    public int abo() {
        return this.column;
    }

    public void hX(int i) {
        this.bYm = i;
    }

    public int abp() {
        return this.bYm;
    }

    public void hY(int i) {
        this.bYl = i;
    }

    public int abq() {
        return this.bYl;
    }

    public void hZ(int i) {
        this.bYg = i;
    }

    public int abr() {
        return this.bYg;
    }

    public void ia(int i) {
        this.bYi = i;
    }

    public int abs() {
        return this.bYi;
    }

    public void setEndIndex(int i) {
        this.bYj = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void ib(int i) {
        this.bYh = i;
    }

    public int abt() {
        return this.bYh;
    }
}
