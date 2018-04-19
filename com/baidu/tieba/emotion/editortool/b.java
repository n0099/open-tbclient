package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class b {
    private EmotionGroupType cGB;
    private int cGC;
    private int cGD;
    private com.baidu.tbadk.editortools.emotiontool.c cGE;
    private int cGF;
    private int cGG;
    private int column;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cGE = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c akd() {
        return this.cGE;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cGB = emotionGroupType;
    }

    public EmotionGroupType ake() {
        return this.cGB;
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

    public int akf() {
        return this.column;
    }

    public void jq(int i) {
        this.cGG = i;
    }

    public int akg() {
        return this.cGG;
    }

    public void jr(int i) {
        this.cGF = i;
    }

    public int akh() {
        return this.cGF;
    }

    public void js(int i) {
        this.cGC = i;
    }

    public int aki() {
        return this.cGC;
    }

    public void jt(int i) {
        this.startIndex = i;
    }

    public int akj() {
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

    public void ju(int i) {
        this.cGD = i;
    }

    public int akk() {
        return this.cGD;
    }
}
