package com.baidu.tieba.frs;

import com.baidu.tieba.n;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class fg implements com.baidu.tbadk.widget.vote.a {
    private int bjR = -1;
    private String bjS = null;
    private int bjT = 0;

    @Override // com.baidu.tbadk.widget.vote.a
    public int Gm() {
        return this.bjR;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gj() {
        return this.bjS;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gk() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Gn() {
        return this.bjT;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gl() {
        return String.valueOf(this.bjT) + "%";
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        switch (i) {
            case 1:
                this.bjR = n.f.icon_grade_vote_no1;
                break;
            case 2:
                this.bjR = n.f.icon_grade_vote_no2;
                break;
            case 3:
                this.bjR = n.f.icon_grade_vote_no3;
                break;
            default:
                this.bjR = -1;
                break;
        }
        this.bjS = pollOption.text;
        if (j > 0) {
            this.bjT = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.bjT = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Go() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
