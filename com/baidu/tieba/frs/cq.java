package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.vote.a;
import com.baidu.tieba.w;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class cq implements a {
    private int bRy = -1;
    private String bRz = null;
    private int mPercent = 0;
    private boolean bRA = false;
    private int[] bRB = {w.g.icon_grade_vote_num1, w.g.icon_grade_vote_num2, w.g.icon_grade_vote_num3};
    private int[] bRC = {w.g.icon_grade_vote_no1, w.g.icon_grade_vote_no2, w.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int BZ() {
        return this.bRy;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BW() {
        return this.bRz;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BX() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ca() {
        return this.mPercent;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BY() {
        return String.valueOf(this.mPercent) + "%";
    }

    public void dV(boolean z) {
        this.bRA = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.bRA ? this.bRB : this.bRC;
        switch (i) {
            case 1:
                this.bRy = iArr[0];
                break;
            case 2:
                this.bRy = iArr[1];
                break;
            case 3:
                this.bRy = iArr[2];
                break;
            default:
                this.bRy = -1;
                break;
        }
        this.bRz = pollOption.text;
        if (j > 0) {
            this.mPercent = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.mPercent = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cb() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
