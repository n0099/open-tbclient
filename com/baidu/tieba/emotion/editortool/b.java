package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes13.dex */
public class b {
    private int bqk;
    private int bql;
    private int column;
    private EmotionGroupType hsT;
    private int hsU;
    private int hsV;
    private com.baidu.tbadk.editortools.emotiontool.c hsW;
    private int hsX;
    private int hsY;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hsW = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c cef() {
        return this.hsW;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.hsT = emotionGroupType;
    }

    public EmotionGroupType ceg() {
        return this.hsT;
    }

    public void qn(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int ceh() {
        return this.column;
    }

    public void vM(int i) {
        this.hsY = i;
    }

    public int cei() {
        return this.hsY;
    }

    public void vN(int i) {
        this.hsX = i;
    }

    public int cej() {
        return this.hsX;
    }

    public void vO(int i) {
        this.hsU = i;
    }

    public int cek() {
        return this.hsU;
    }

    public void vP(int i) {
        this.bqk = i;
    }

    public int cel() {
        return this.bqk;
    }

    public void vQ(int i) {
        this.bql = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void vR(int i) {
        this.hsV = i;
    }

    public int cem() {
        return this.hsV;
    }
}
