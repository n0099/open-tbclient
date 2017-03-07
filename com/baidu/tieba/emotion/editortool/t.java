package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class t {
    private EmotionGroupType bDs;
    private int bDt;
    private int bDu;
    private int bDv;
    private int bDw;
    private com.baidu.tbadk.editortools.emotiontool.c bDx;
    private int bDy;
    private int bDz;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bDx = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c UK() {
        return this.bDx;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.bDs = emotionGroupType;
    }

    public EmotionGroupType UL() {
        return this.bDs;
    }

    public void eL(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eK(int i) {
        this.column = i;
    }

    public int UM() {
        return this.column;
    }

    public void hb(int i) {
        this.bDz = i;
    }

    public int UN() {
        return this.bDz;
    }

    public void hc(int i) {
        this.bDy = i;
    }

    public int UO() {
        return this.bDy;
    }

    public void hd(int i) {
        this.bDt = i;
    }

    public int UP() {
        return this.bDt;
    }

    public void he(int i) {
        this.bDv = i;
    }

    public int UQ() {
        return this.bDv;
    }

    public void setEndIndex(int i) {
        this.bDw = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void hf(int i) {
        this.bDu = i;
    }

    public int UR() {
        return this.bDu;
    }
}
