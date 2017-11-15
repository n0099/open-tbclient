package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class av implements com.baidu.tbadk.widget.vote.a {
    private int cBy = -1;
    private String cBz = null;
    private int aAp = 0;
    private boolean cBA = false;
    private int[] cBB = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] cBC = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CB() {
        return this.cBy;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cy() {
        return this.cBz;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cz() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CC() {
        return this.aAp;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CA() {
        return this.aAp + "%";
    }

    public void eN(boolean z) {
        this.cBA = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.cBA ? this.cBB : this.cBC;
        switch (i) {
            case 1:
                this.cBy = iArr[0];
                break;
            case 2:
                this.cBy = iArr[1];
                break;
            case 3:
                this.cBy = iArr[2];
                break;
            default:
                this.cBy = -1;
                break;
        }
        this.cBz = pollOption.text;
        if (j > 0) {
            this.aAp = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aAp = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CD() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
