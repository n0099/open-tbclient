package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.t;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class dx implements a {
    private int bUk = -1;
    private String bUl = null;
    private int mPercent = 0;
    private boolean bUm = false;
    private int[] bUn = {t.f.icon_grade_vote_num1, t.f.icon_grade_vote_num2, t.f.icon_grade_vote_num3};
    private int[] bUo = {t.f.icon_grade_vote_no1, t.f.icon_grade_vote_no2, t.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cj() {
        return this.bUk;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cg() {
        return this.bUl;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ch() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ck() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ci() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void dS(boolean z) {
        this.bUm = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bUm ? this.bUn : this.bUo;
        switch (i) {
            case 1:
                this.bUk = iArr[0];
                break;
            case 2:
                this.bUk = iArr[1];
                break;
            case 3:
                this.bUk = iArr[2];
                break;
            default:
                this.bUk = -1;
                break;
        }
        this.bUl = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cl() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
