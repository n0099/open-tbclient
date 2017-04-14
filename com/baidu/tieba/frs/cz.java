package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.w;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class cz implements a {
    private int bQO = -1;
    private String bQP = null;
    private int mPercent = 0;
    private boolean bQQ = false;
    private int[] bQR = {w.g.icon_grade_vote_num1, w.g.icon_grade_vote_num2, w.g.icon_grade_vote_num3};
    private int[] bQS = {w.g.icon_grade_vote_no1, w.g.icon_grade_vote_no2, w.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CU() {
        return this.bQO;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CR() {
        return this.bQP;
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

    public void dU(boolean z) {
        this.bQQ = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bQQ ? this.bQR : this.bQS;
        switch (i) {
            case 1:
                this.bQO = iArr[0];
                break;
            case 2:
                this.bQO = iArr[1];
                break;
            case 3:
                this.bQO = iArr[2];
                break;
            default:
                this.bQO = -1;
                break;
        }
        this.bQP = pollOption.text;
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
