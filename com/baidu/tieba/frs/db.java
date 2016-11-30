package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.r;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class db implements a {
    private int bWt = -1;
    private String bWu = null;
    private int mPercent = 0;
    private boolean bWv = false;
    private int[] bWw = {r.f.icon_grade_vote_num1, r.f.icon_grade_vote_num2, r.f.icon_grade_vote_num3};
    private int[] bWx = {r.f.icon_grade_vote_no1, r.f.icon_grade_vote_no2, r.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cu() {
        return this.bWt;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cr() {
        return this.bWu;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cs() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cv() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ct() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void ec(boolean z) {
        this.bWv = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bWv ? this.bWw : this.bWx;
        switch (i) {
            case 1:
                this.bWt = iArr[0];
                break;
            case 2:
                this.bWt = iArr[1];
                break;
            case 3:
                this.bWt = iArr[2];
                break;
            default:
                this.bWt = -1;
                break;
        }
        this.bWu = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cw() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
