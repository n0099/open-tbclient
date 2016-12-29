package com.baidu.tieba.frs;

import com.baidu.tieba.r;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class db implements com.baidu.tbadk.widget.vote.a {
    private int bCD = -1;
    private String bCE = null;
    private int mPercent = 0;
    private boolean bCF = false;
    private int[] bCG = {r.f.icon_grade_vote_num1, r.f.icon_grade_vote_num2, r.f.icon_grade_vote_num3};
    private int[] bCH = {r.f.icon_grade_vote_no1, r.f.icon_grade_vote_no2, r.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ch() {
        return this.bCD;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ce() {
        return this.bCE;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cf() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ci() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cg() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void dM(boolean z) {
        this.bCF = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bCF ? this.bCG : this.bCH;
        switch (i) {
            case 1:
                this.bCD = iArr[0];
                break;
            case 2:
                this.bCD = iArr[1];
                break;
            case 3:
                this.bCD = iArr[2];
                break;
            default:
                this.bCD = -1;
                break;
        }
        this.bCE = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cj() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
