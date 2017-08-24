package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class au implements com.baidu.tbadk.widget.vote.a {
    private int cnh = -1;
    private String cni = null;
    private int mPercent = 0;
    private boolean cnj = false;
    private int[] cnk = {d.g.icon_grade_vote_num1, d.g.icon_grade_vote_num2, d.g.icon_grade_vote_num3};
    private int[] cnl = {d.g.icon_grade_vote_no1, d.g.icon_grade_vote_no2, d.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CH() {
        return this.cnh;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CE() {
        return this.cni;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CF() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CI() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CG() {
        return this.mPercent + "%";
    }

    public void eQ(boolean z) {
        this.cnj = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.cnj ? this.cnk : this.cnl;
        switch (i) {
            case 1:
                this.cnh = iArr[0];
                break;
            case 2:
                this.cnh = iArr[1];
                break;
            case 3:
                this.cnh = iArr[2];
                break;
            default:
                this.cnh = -1;
                break;
        }
        this.cni = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CJ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
