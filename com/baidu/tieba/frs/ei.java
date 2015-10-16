package com.baidu.tieba.frs;

import com.baidu.tieba.i;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ei implements com.baidu.tbadk.widget.vote.a {
    private int aZD = -1;
    private String aZE = null;
    private int aZF = 0;

    @Override // com.baidu.tbadk.widget.vote.a
    public int Fz() {
        return this.aZD;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fw() {
        return this.aZE;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fx() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int FA() {
        return this.aZF;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fy() {
        return String.valueOf(this.aZF) + "%";
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        switch (i) {
            case 1:
                this.aZD = i.e.icon_grade_vote_no1;
                break;
            case 2:
                this.aZD = i.e.icon_grade_vote_no2;
                break;
            case 3:
                this.aZD = i.e.icon_grade_vote_no3;
                break;
            default:
                this.aZD = -1;
                break;
        }
        this.aZE = pollOption.text;
        if (j > 0) {
            this.aZF = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aZF = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String FB() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
