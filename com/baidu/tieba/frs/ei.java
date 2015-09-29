package com.baidu.tieba.frs;

import com.baidu.tieba.i;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ei implements com.baidu.tbadk.widget.vote.a {
    private int aZs = -1;
    private String aZt = null;
    private int aZu = 0;

    @Override // com.baidu.tbadk.widget.vote.a
    public int Fz() {
        return this.aZs;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fw() {
        return this.aZt;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fx() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int FA() {
        return this.aZu;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fy() {
        return String.valueOf(this.aZu) + "%";
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        switch (i) {
            case 1:
                this.aZs = i.e.icon_grade_vote_no1;
                break;
            case 2:
                this.aZs = i.e.icon_grade_vote_no2;
                break;
            case 3:
                this.aZs = i.e.icon_grade_vote_no3;
                break;
            default:
                this.aZs = -1;
                break;
        }
        this.aZt = pollOption.text;
        if (j > 0) {
            this.aZu = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aZu = 0;
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
