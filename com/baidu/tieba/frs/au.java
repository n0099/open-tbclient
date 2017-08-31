package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class au implements com.baidu.tbadk.widget.vote.a {
    private int csB = -1;
    private String csC = null;
    private int aAr = 0;
    private boolean csD = false;
    private int[] csE = {d.g.icon_grade_vote_num1, d.g.icon_grade_vote_num2, d.g.icon_grade_vote_num3};
    private int[] csF = {d.g.icon_grade_vote_no1, d.g.icon_grade_vote_no2, d.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CC() {
        return this.csB;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cz() {
        return this.csC;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CA() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CD() {
        return this.aAr;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CB() {
        return this.aAr + "%";
    }

    public void eT(boolean z) {
        this.csD = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.csD ? this.csE : this.csF;
        switch (i) {
            case 1:
                this.csB = iArr[0];
                break;
            case 2:
                this.csB = iArr[1];
                break;
            case 3:
                this.csB = iArr[2];
                break;
            default:
                this.csB = -1;
                break;
        }
        this.csC = pollOption.text;
        if (j > 0) {
            this.aAr = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aAr = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CE() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
