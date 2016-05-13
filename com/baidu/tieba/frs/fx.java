package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.t;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class fx implements a {
    private int bnz = -1;
    private String bnA = null;
    private int bnB = 0;
    private boolean bnC = false;
    private int[] bnD = {t.f.icon_grade_vote_num1, t.f.icon_grade_vote_num2, t.f.icon_grade_vote_num3};
    private int[] bnE = {t.f.icon_grade_vote_no1, t.f.icon_grade_vote_no2, t.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Hz() {
        return this.bnz;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hw() {
        return this.bnA;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hx() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int HA() {
        return this.bnB;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hy() {
        return String.valueOf(this.bnB) + "%";
    }

    public void dc(boolean z) {
        this.bnC = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bnC ? this.bnD : this.bnE;
        switch (i) {
            case 1:
                this.bnz = iArr[0];
                break;
            case 2:
                this.bnz = iArr[1];
                break;
            case 3:
                this.bnz = iArr[2];
                break;
            default:
                this.bnz = -1;
                break;
        }
        this.bnA = pollOption.text;
        if (j > 0) {
            this.bnB = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.bnB = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HB() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
