package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes2.dex */
public class ax implements com.baidu.tbadk.widget.vote.a {
    private int dHO = -1;
    private String dHP = null;
    private int aRG = 0;
    private boolean dHQ = false;
    private int[] dHR = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] dHS = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int KJ() {
        return this.dHO;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KG() {
        return this.dHP;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KH() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int KK() {
        return this.aRG;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KI() {
        return this.aRG + "%";
    }

    public void fZ(boolean z) {
        this.dHQ = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.dHQ ? this.dHR : this.dHS;
        switch (i) {
            case 1:
                this.dHO = iArr[0];
                break;
            case 2:
                this.dHO = iArr[1];
                break;
            case 3:
                this.dHO = iArr[2];
                break;
            default:
                this.dHO = -1;
                break;
        }
        this.dHP = pollOption.text;
        if (j > 0) {
            this.aRG = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aRG = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KL() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
