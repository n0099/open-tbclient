package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class au implements com.baidu.tbadk.widget.vote.a {
    private int cng = -1;
    private String cnh = null;
    private int mPercent = 0;
    private boolean cni = false;
    private int[] cnj = {d.g.icon_grade_vote_num1, d.g.icon_grade_vote_num2, d.g.icon_grade_vote_num3};
    private int[] cnk = {d.g.icon_grade_vote_no1, d.g.icon_grade_vote_no2, d.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CH() {
        return this.cng;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CE() {
        return this.cnh;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CF() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CI() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CG() {
        return this.mPercent + "%";
    }

    public void eQ(boolean z) {
        this.cni = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.cni ? this.cnj : this.cnk;
        switch (i) {
            case 1:
                this.cng = iArr[0];
                break;
            case 2:
                this.cng = iArr[1];
                break;
            case 3:
                this.cng = iArr[2];
                break;
            default:
                this.cng = -1;
                break;
        }
        this.cnh = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CJ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
