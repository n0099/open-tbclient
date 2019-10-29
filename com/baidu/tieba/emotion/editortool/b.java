package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int arh;
    private int ari;
    private int column;
    private com.baidu.tbadk.editortools.emotiontool.c eZA;
    private int eZB;
    private int eZC;
    private EmotionGroupType eZx;
    private int eZy;
    private int eZz;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eZA = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bdo() {
        return this.eZA;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.eZx = emotionGroupType;
    }

    public EmotionGroupType bdp() {
        return this.eZx;
    }

    public void jV(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void jU(int i) {
        this.column = i;
    }

    public int bdq() {
        return this.column;
    }

    public void pm(int i) {
        this.eZC = i;
    }

    public int bdr() {
        return this.eZC;
    }

    public void po(int i) {
        this.eZB = i;
    }

    public int bds() {
        return this.eZB;
    }

    public void pp(int i) {
        this.eZy = i;
    }

    public int bdt() {
        return this.eZy;
    }

    public void pq(int i) {
        this.arh = i;
    }

    public int bdu() {
        return this.arh;
    }

    public void pr(int i) {
        this.ari = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void ps(int i) {
        this.eZz = i;
    }

    public int bdv() {
        return this.eZz;
    }
}
