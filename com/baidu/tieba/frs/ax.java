package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes2.dex */
public class ax implements com.baidu.tbadk.widget.vote.a {
    private int dHV = -1;
    private String dHW = null;
    private int aRP = 0;
    private boolean dHX = false;
    private int[] dHY = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] dHZ = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int KJ() {
        return this.dHV;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KG() {
        return this.dHW;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KH() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int KK() {
        return this.aRP;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String KI() {
        return this.aRP + "%";
    }

    public void fZ(boolean z) {
        this.dHX = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.dHX ? this.dHY : this.dHZ;
        switch (i) {
            case 1:
                this.dHV = iArr[0];
                break;
            case 2:
                this.dHV = iArr[1];
                break;
            case 3:
                this.dHV = iArr[2];
                break;
            default:
                this.dHV = -1;
                break;
        }
        this.dHW = pollOption.text;
        if (j > 0) {
            this.aRP = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aRP = 0;
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
