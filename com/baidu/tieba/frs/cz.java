package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.w;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class cz implements a {
    private int bTf = -1;
    private String bTg = null;
    private int mPercent = 0;
    private boolean bTh = false;
    private int[] bTi = {w.g.icon_grade_vote_num1, w.g.icon_grade_vote_num2, w.g.icon_grade_vote_num3};
    private int[] bTj = {w.g.icon_grade_vote_no1, w.g.icon_grade_vote_no2, w.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CU() {
        return this.bTf;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CR() {
        return this.bTg;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CS() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CV() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CT() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void ee(boolean z) {
        this.bTh = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bTh ? this.bTi : this.bTj;
        switch (i) {
            case 1:
                this.bTf = iArr[0];
                break;
            case 2:
                this.bTf = iArr[1];
                break;
            case 3:
                this.bTf = iArr[2];
                break;
            default:
                this.bTf = -1;
                break;
        }
        this.bTg = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CW() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
