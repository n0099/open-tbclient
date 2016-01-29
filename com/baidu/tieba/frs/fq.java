package com.baidu.tieba.frs;

import com.baidu.tieba.t;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class fq implements com.baidu.tbadk.widget.vote.a {
    private int bmN = -1;
    private String bmO = null;
    private int bmP = 0;

    @Override // com.baidu.tbadk.widget.vote.a
    public int HL() {
        return this.bmN;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HI() {
        return this.bmO;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HJ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int HM() {
        return this.bmP;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HK() {
        return String.valueOf(this.bmP) + "%";
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        switch (i) {
            case 1:
                this.bmN = t.f.icon_grade_vote_no1;
                break;
            case 2:
                this.bmN = t.f.icon_grade_vote_no2;
                break;
            case 3:
                this.bmN = t.f.icon_grade_vote_no3;
                break;
            default:
                this.bmN = -1;
                break;
        }
        this.bmO = pollOption.text;
        if (j > 0) {
            this.bmP = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.bmP = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HN() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
