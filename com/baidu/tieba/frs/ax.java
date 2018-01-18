package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes2.dex */
public class ax implements com.baidu.tbadk.widget.vote.a {
    private int dEw = -1;
    private String dEx = null;
    private int bpd = 0;
    private boolean dEy = false;
    private int[] dEz = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] dEA = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Kb() {
        return this.dEw;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String JY() {
        return this.dEx;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String JZ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Kc() {
        return this.bpd;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ka() {
        return this.bpd + "%";
    }

    public void fP(boolean z) {
        this.dEy = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.dEy ? this.dEz : this.dEA;
        switch (i) {
            case 1:
                this.dEw = iArr[0];
                break;
            case 2:
                this.dEw = iArr[1];
                break;
            case 3:
                this.dEw = iArr[2];
                break;
            default:
                this.dEw = -1;
                break;
        }
        this.dEx = pollOption.text;
        if (j > 0) {
            this.bpd = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.bpd = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kd() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
