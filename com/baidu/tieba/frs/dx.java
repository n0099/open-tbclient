package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.r;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class dx implements a {
    private int bUd = -1;
    private String bUe = null;
    private int mPercent = 0;
    private boolean bUf = false;
    private int[] bUg = {r.f.icon_grade_vote_num1, r.f.icon_grade_vote_num2, r.f.icon_grade_vote_num3};
    private int[] bUh = {r.f.icon_grade_vote_no1, r.f.icon_grade_vote_no2, r.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cm() {
        return this.bUd;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cj() {
        return this.bUe;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ck() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cn() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cl() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void dT(boolean z) {
        this.bUf = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bUf ? this.bUg : this.bUh;
        switch (i) {
            case 1:
                this.bUd = iArr[0];
                break;
            case 2:
                this.bUd = iArr[1];
                break;
            case 3:
                this.bUd = iArr[2];
                break;
            default:
                this.bUd = -1;
                break;
        }
        this.bUe = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Co() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
