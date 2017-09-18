package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class au implements com.baidu.tbadk.widget.vote.a {
    private int ctt = -1;
    private String ctu = null;
    private int aAo = 0;
    private boolean ctv = false;
    private int[] ctw = {d.g.icon_grade_vote_num1, d.g.icon_grade_vote_num2, d.g.icon_grade_vote_num3};
    private int[] cty = {d.g.icon_grade_vote_no1, d.g.icon_grade_vote_no2, d.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CC() {
        return this.ctt;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cz() {
        return this.ctu;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CA() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CD() {
        return this.aAo;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CB() {
        return this.aAo + "%";
    }

    public void eU(boolean z) {
        this.ctv = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.ctv ? this.ctw : this.cty;
        switch (i) {
            case 1:
                this.ctt = iArr[0];
                break;
            case 2:
                this.ctt = iArr[1];
                break;
            case 3:
                this.ctt = iArr[2];
                break;
            default:
                this.ctt = -1;
                break;
        }
        this.ctu = pollOption.text;
        if (j > 0) {
            this.aAo = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aAo = 0;
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
