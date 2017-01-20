package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.r;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class cx implements a {
    private int bJT = -1;
    private String bJU = null;
    private int mPercent = 0;
    private boolean bJV = false;
    private int[] bJW = {r.g.icon_grade_vote_num1, r.g.icon_grade_vote_num2, r.g.icon_grade_vote_num3};
    private int[] bJX = {r.g.icon_grade_vote_no1, r.g.icon_grade_vote_no2, r.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cd() {
        return this.bJT;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ca() {
        return this.bJU;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cb() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ce() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cc() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void dS(boolean z) {
        this.bJV = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bJV ? this.bJW : this.bJX;
        switch (i) {
            case 1:
                this.bJT = iArr[0];
                break;
            case 2:
                this.bJT = iArr[1];
                break;
            case 3:
                this.bJT = iArr[2];
                break;
            default:
                this.bJT = -1;
                break;
        }
        this.bJU = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cf() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
