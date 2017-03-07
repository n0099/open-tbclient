package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.w;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class cx implements a {
    private int bQZ = -1;
    private String bRa = null;
    private int mPercent = 0;
    private boolean bRb = false;
    private int[] bRc = {w.g.icon_grade_vote_num1, w.g.icon_grade_vote_num2, w.g.icon_grade_vote_num3};
    private int[] bRd = {w.g.icon_grade_vote_no1, w.g.icon_grade_vote_no2, w.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cw() {
        return this.bQZ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ct() {
        return this.bRa;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cu() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cx() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cv() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void dS(boolean z) {
        this.bRb = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bRb ? this.bRc : this.bRd;
        switch (i) {
            case 1:
                this.bQZ = iArr[0];
                break;
            case 2:
                this.bQZ = iArr[1];
                break;
            case 3:
                this.bQZ = iArr[2];
                break;
            default:
                this.bQZ = -1;
                break;
        }
        this.bRa = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cy() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
