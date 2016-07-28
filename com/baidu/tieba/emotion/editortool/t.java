package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private EmotionGroupType bue;
    private int buf;
    private int bug;
    private int buh;
    private int bui;
    private com.baidu.tbadk.editortools.emotiontool.c buj;
    private int buk;
    private int bul;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.buj = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c RY() {
        return this.buj;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bue = emotionGroupType;
    }

    public EmotionGroupType RZ() {
        return this.bue;
    }

    public void ey(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void ex(int i) {
        this.column = i;
    }

    public int Sa() {
        return this.column;
    }

    public void gC(int i) {
        this.bul = i;
    }

    public int Sb() {
        return this.bul;
    }

    public void gD(int i) {
        this.buk = i;
    }

    public int Sc() {
        return this.buk;
    }

    public void gE(int i) {
        this.buf = i;
    }

    public int Sd() {
        return this.buf;
    }

    public void gF(int i) {
        this.buh = i;
    }

    public int Se() {
        return this.buh;
    }

    public void setEndIndex(int i) {
        this.bui = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void gG(int i) {
        this.bug = i;
    }

    public int Sf() {
        return this.bug;
    }
}
