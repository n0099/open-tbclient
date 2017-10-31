package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class av implements com.baidu.tbadk.widget.vote.a {
    private int cBf = -1;
    private String cBg = null;
    private int aAh = 0;
    private boolean cBh = false;
    private int[] cBi = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] cBj = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cp() {
        return this.cBf;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cm() {
        return this.cBg;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cn() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cq() {
        return this.aAh;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Co() {
        return this.aAh + "%";
    }

    public void eI(boolean z) {
        this.cBh = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.cBh ? this.cBi : this.cBj;
        switch (i) {
            case 1:
                this.cBf = iArr[0];
                break;
            case 2:
                this.cBf = iArr[1];
                break;
            case 3:
                this.cBf = iArr[2];
                break;
            default:
                this.cBf = -1;
                break;
        }
        this.cBg = pollOption.text;
        if (j > 0) {
            this.aAh = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aAh = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cr() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
