package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes13.dex */
public class b {
    private int bGx;
    private int bGy;
    private int column;
    private com.baidu.tbadk.editortools.emotiontool.c ihA;
    private int ihB;
    private int ihC;
    private EmotionGroupType ihx;
    private int ihy;
    private int ihz;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.ihA = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c cqz() {
        return this.ihA;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.ihx = emotionGroupType;
    }

    public EmotionGroupType cqA() {
        return this.ihx;
    }

    public void rx(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int cqB() {
        return this.column;
    }

    public void xx(int i) {
        this.ihC = i;
    }

    public int cqC() {
        return this.ihC;
    }

    public void xy(int i) {
        this.ihB = i;
    }

    public int cqD() {
        return this.ihB;
    }

    public void xz(int i) {
        this.ihy = i;
    }

    public int cqE() {
        return this.ihy;
    }

    public void xA(int i) {
        this.bGx = i;
    }

    public int cqF() {
        return this.bGx;
    }

    public void xB(int i) {
        this.bGy = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void xC(int i) {
        this.ihz = i;
    }

    public int cqG() {
        return this.ihz;
    }
}
