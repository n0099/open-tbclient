package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes2.dex */
public class ax implements com.baidu.tbadk.widget.vote.a {
    private int dHJ = -1;
    private String dHK = null;
    private int aRE = 0;
    private boolean dHL = false;
    private int[] dHM = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] dHN = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int KI() {
        return this.dHJ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KF() {
        return this.dHK;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KG() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int KJ() {
        return this.aRE;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KH() {
        return this.aRE + "%";
    }

    public void fZ(boolean z) {
        this.dHL = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.dHL ? this.dHM : this.dHN;
        switch (i) {
            case 1:
                this.dHJ = iArr[0];
                break;
            case 2:
                this.dHJ = iArr[1];
                break;
            case 3:
                this.dHJ = iArr[2];
                break;
            default:
                this.dHJ = -1;
                break;
        }
        this.dHK = pollOption.text;
        if (j > 0) {
            this.aRE = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aRE = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KK() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
