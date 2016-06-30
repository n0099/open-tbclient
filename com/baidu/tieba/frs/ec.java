package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.u;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ec implements a {
    private int bHN = -1;
    private String bHO = null;
    private int bHP = 0;
    private boolean bHQ = false;
    private int[] bHR = {u.f.icon_grade_vote_num1, u.f.icon_grade_vote_num2, u.f.icon_grade_vote_num3};
    private int[] bHS = {u.f.icon_grade_vote_no1, u.f.icon_grade_vote_no2, u.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int HA() {
        return this.bHN;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hx() {
        return this.bHO;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hy() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int HB() {
        return this.bHP;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Hz() {
        return String.valueOf(this.bHP) + "%";
    }

    public void dz(boolean z) {
        this.bHQ = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bHQ ? this.bHR : this.bHS;
        switch (i) {
            case 1:
                this.bHN = iArr[0];
                break;
            case 2:
                this.bHN = iArr[1];
                break;
            case 3:
                this.bHN = iArr[2];
                break;
            default:
                this.bHN = -1;
                break;
        }
        this.bHO = pollOption.text;
        if (j > 0) {
            this.bHP = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.bHP = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String HC() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
