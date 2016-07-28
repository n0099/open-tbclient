package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.u;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ec implements a {
    private int bJj = -1;
    private String bJk = null;
    private int mPercent = 0;
    private boolean bJl = false;
    private int[] bJm = {u.f.icon_grade_vote_num1, u.f.icon_grade_vote_num2, u.f.icon_grade_vote_num3};
    private int[] bJn = {u.f.icon_grade_vote_no1, u.f.icon_grade_vote_no2, u.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Hy() {
        return this.bJj;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hv() {
        return this.bJk;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hw() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Hz() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hx() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void dw(boolean z) {
        this.bJl = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bJl ? this.bJm : this.bJn;
        switch (i) {
            case 1:
                this.bJj = iArr[0];
                break;
            case 2:
                this.bJj = iArr[1];
                break;
            case 3:
                this.bJj = iArr[2];
                break;
            default:
                this.bJj = -1;
                break;
        }
        this.bJk = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HA() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
