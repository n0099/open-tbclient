package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class b {
    private EmotionGroupType cHH;
    private int cHI;
    private int cHJ;
    private com.baidu.tbadk.editortools.emotiontool.c cHK;
    private int cHL;
    private int cHM;
    private int column;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cHK = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c akd() {
        return this.cHK;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cHH = emotionGroupType;
    }

    public EmotionGroupType ake() {
        return this.cHH;
    }

    public void eS(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eR(int i) {
        this.column = i;
    }

    public int akf() {
        return this.column;
    }

    public void jp(int i) {
        this.cHM = i;
    }

    public int akg() {
        return this.cHM;
    }

    public void jq(int i) {
        this.cHL = i;
    }

    public int akh() {
        return this.cHL;
    }

    public void jr(int i) {
        this.cHI = i;
    }

    public int aki() {
        return this.cHI;
    }

    public void js(int i) {
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

    public void jt(int i) {
        this.cHJ = i;
    }

    public int akk() {
        return this.cHJ;
    }
}
