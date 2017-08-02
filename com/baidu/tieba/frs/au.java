package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class au implements com.baidu.tbadk.widget.vote.a {
    private int clm = -1;
    private String cln = null;
    private int mPercent = 0;
    private boolean clo = false;
    private int[] clp = {d.g.icon_grade_vote_num1, d.g.icon_grade_vote_num2, d.g.icon_grade_vote_num3};
    private int[] clq = {d.g.icon_grade_vote_no1, d.g.icon_grade_vote_no2, d.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cz() {
        return this.clm;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cw() {
        return this.cln;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cx() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CA() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cy() {
        return this.mPercent + "%";
    }

    public void eO(boolean z) {
        this.clo = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.clo ? this.clp : this.clq;
        switch (i) {
            case 1:
                this.clm = iArr[0];
                break;
            case 2:
                this.clm = iArr[1];
                break;
            case 3:
                this.clm = iArr[2];
                break;
            default:
                this.clm = -1;
                break;
        }
        this.cln = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CB() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
