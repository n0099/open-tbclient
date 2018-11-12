package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes5.dex */
public class b {
    private int column;
    private EmotionGroupType dgD;
    private int dgE;
    private int dgF;
    private com.baidu.tbadk.editortools.emotiontool.c dgG;
    private int dgH;
    private int dgI;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dgG = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c asN() {
        return this.dgG;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.dgD = emotionGroupType;
    }

    public EmotionGroupType asO() {
        return this.dgD;
    }

    public void fG(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fF(int i) {
        this.column = i;
    }

    public int asP() {
        return this.column;
    }

    public void kQ(int i) {
        this.dgI = i;
    }

    public int asQ() {
        return this.dgI;
    }

    public void kR(int i) {
        this.dgH = i;
    }

    public int asR() {
        return this.dgH;
    }

    public void kS(int i) {
        this.dgE = i;
    }

    public int asS() {
        return this.dgE;
    }

    public void kT(int i) {
        this.startIndex = i;
    }

    public int asT() {
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

    public void kU(int i) {
        this.dgF = i;
    }

    public int asU() {
        return this.dgF;
    }
}
