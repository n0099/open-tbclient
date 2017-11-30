package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private int column;
    private EmotionGroupType csg;
    private int csh;
    private int csi;
    private com.baidu.tbadk.editortools.emotiontool.c csj;
    private int csk;
    private int csl;
    private int endIndex;
    private int index;
    private int row;
    private int startIndex;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.csj = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c agq() {
        return this.csj;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.csg = emotionGroupType;
    }

    public EmotionGroupType agr() {
        return this.csg;
    }

    public void fa(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eZ(int i) {
        this.column = i;
    }

    public int ags() {
        return this.column;
    }

    public void jf(int i) {
        this.csl = i;
    }

    public int agt() {
        return this.csl;
    }

    public void jg(int i) {
        this.csk = i;
    }

    public int agu() {
        return this.csk;
    }

    public void jh(int i) {
        this.csh = i;
    }

    public int agv() {
        return this.csh;
    }

    public void ji(int i) {
        this.startIndex = i;
    }

    public int agw() {
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

    public void jj(int i) {
        this.csi = i;
    }

    public int agx() {
        return this.csi;
    }
}
