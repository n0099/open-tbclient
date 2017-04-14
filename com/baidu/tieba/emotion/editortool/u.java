package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class u {
    private EmotionGroupType bDl;
    private int bDm;
    private int bDn;
    private int bDo;
    private int bDp;
    private com.baidu.tbadk.editortools.emotiontool.c bDq;
    private int bDr;
    private int bDs;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bDq = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c Vi() {
        return this.bDq;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bDl = emotionGroupType;
    }

    public EmotionGroupType Vj() {
        return this.bDl;
    }

    public void eO(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eN(int i) {
        this.column = i;
    }

    public int Vk() {
        return this.column;
    }

    public void he(int i) {
        this.bDs = i;
    }

    public int Vl() {
        return this.bDs;
    }

    public void hf(int i) {
        this.bDr = i;
    }

    public int Vm() {
        return this.bDr;
    }

    public void hg(int i) {
        this.bDm = i;
    }

    public int Vn() {
        return this.bDm;
    }

    public void hh(int i) {
        this.bDo = i;
    }

    public int Vo() {
        return this.bDo;
    }

    public void setEndIndex(int i) {
        this.bDp = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hi(int i) {
        this.bDn = i;
    }

    public int Vp() {
        return this.bDn;
    }
}
