package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public class b {
    private int aqP;
    private int aqQ;
    private int column;
    private EmotionGroupType eYG;
    private int eYH;
    private int eYI;
    private com.baidu.tbadk.editortools.emotiontool.c eYJ;
    private int eYK;
    private int eYL;
    private int index;
    private int row;

    public void e(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eYJ = cVar;
    }

    public com.baidu.tbadk.editortools.emotiontool.c bdm() {
        return this.eYJ;
    }

    public void b(EmotionGroupType emotionGroupType) {
        this.eYG = emotionGroupType;
    }

    public EmotionGroupType bdn() {
        return this.eYG;
    }

    public void jU(int i) {
        this.row = i;
    }

    public int getRow() {
        return this.row;
    }

    public void jT(int i) {
        this.column = i;
    }

    public int bdo() {
        return this.column;
    }

    public void pl(int i) {
        this.eYL = i;
    }

    public int bdp() {
        return this.eYL;
    }

    public void pm(int i) {
        this.eYK = i;
    }

    public int bdq() {
        return this.eYK;
    }

    public void po(int i) {
        this.eYH = i;
    }

    public int bdr() {
        return this.eYH;
    }

    public void pp(int i) {
        this.aqP = i;
    }

    public int bds() {
        return this.aqP;
    }

    public void pq(int i) {
        this.aqQ = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    public void pr(int i) {
        this.eYI = i;
    }

    public int bdt() {
        return this.eYI;
    }
}
