package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.w;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class cs implements a {
    private int cfx = -1;
    private String cfy = null;
    private int mPercent = 0;
    private boolean cfz = false;
    private int[] cfA = {w.g.icon_grade_vote_num1, w.g.icon_grade_vote_num2, w.g.icon_grade_vote_num3};
    private int[] cfB = {w.g.icon_grade_vote_no1, w.g.icon_grade_vote_no2, w.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cn() {
        return this.cfx;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ck() {
        return this.cfy;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cl() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Co() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cm() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void eD(boolean z) {
        this.cfz = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.cfz ? this.cfA : this.cfB;
        switch (i) {
            case 1:
                this.cfx = iArr[0];
                break;
            case 2:
                this.cfx = iArr[1];
                break;
            case 3:
                this.cfx = iArr[2];
                break;
            default:
                this.cfx = -1;
                break;
        }
        this.cfy = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cp() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
