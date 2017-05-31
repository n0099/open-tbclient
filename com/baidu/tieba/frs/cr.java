package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.w;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class cr implements a {
    private int bXo = -1;
    private String bXp = null;
    private int mPercent = 0;
    private boolean bXq = false;
    private int[] bXr = {w.g.icon_grade_vote_num1, w.g.icon_grade_vote_num2, w.g.icon_grade_vote_num3};
    private int[] bXs = {w.g.icon_grade_vote_no1, w.g.icon_grade_vote_no2, w.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int BT() {
        return this.bXo;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BQ() {
        return this.bXp;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BR() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int BU() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BS() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void el(boolean z) {
        this.bXq = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bXq ? this.bXr : this.bXs;
        switch (i) {
            case 1:
                this.bXo = iArr[0];
                break;
            case 2:
                this.bXo = iArr[1];
                break;
            case 3:
                this.bXo = iArr[2];
                break;
            default:
                this.bXo = -1;
                break;
        }
        this.bXp = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BV() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
