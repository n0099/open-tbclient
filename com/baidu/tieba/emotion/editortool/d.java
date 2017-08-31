package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class d {
    private EmotionGroupType cbb;
    private int cbc;
    private int cbd;
    private int cbe;
    private int cbf;
    private com.baidu.tbadk.editortools.emotiontool.c cbg;
    private int cbh;
    private int cbi;
    private int column;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cbg = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c acp() {
        return this.cbg;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.cbb = emotionGroupType;
    }

    public EmotionGroupType acq() {
        return this.cbb;
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

    public int acr() {
        return this.column;
    }

    public void ih(int i) {
        this.cbi = i;
    }

    public int acs() {
        return this.cbi;
    }

    public void ii(int i) {
        this.cbh = i;
    }

    public int act() {
        return this.cbh;
    }

    public void ij(int i) {
        this.cbc = i;
    }

    public int acu() {
        return this.cbc;
    }

    public void ik(int i) {
        this.cbe = i;
    }

    public int acv() {
        return this.cbe;
    }

    public void setEndIndex(int i) {
        this.cbf = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void il(int i) {
        this.cbd = i;
    }

    public int acw() {
        return this.cbd;
    }
}
