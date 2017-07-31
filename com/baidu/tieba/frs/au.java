package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class au implements com.baidu.tbadk.widget.vote.a {
    private int cmv = -1;
    private String cmw = null;
    private int mPercent = 0;
    private boolean cmx = false;
    private int[] cmy = {d.g.icon_grade_vote_num1, d.g.icon_grade_vote_num2, d.g.icon_grade_vote_num3};
    private int[] cmz = {d.g.icon_grade_vote_no1, d.g.icon_grade_vote_no2, d.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CH() {
        return this.cmv;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CE() {
        return this.cmw;
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

    public void eO(boolean z) {
        this.cmx = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.cmx ? this.cmy : this.cmz;
        switch (i) {
            case 1:
                this.cmv = iArr[0];
                break;
            case 2:
                this.cmv = iArr[1];
                break;
            case 3:
                this.cmv = iArr[2];
                break;
            default:
                this.cmv = -1;
                break;
        }
        this.cmw = pollOption.text;
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
