package com.baidu.tieba.frs;

import com.baidu.tieba.n;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class fg implements com.baidu.tbadk.widget.vote.a {
    private int bfZ = -1;
    private String bga = null;
    private int bgb = 0;

    @Override // com.baidu.tbadk.widget.vote.a
    public int Gx() {
        return this.bfZ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gu() {
        return this.bga;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gv() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Gy() {
        return this.bgb;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gw() {
        return String.valueOf(this.bgb) + "%";
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        switch (i) {
            case 1:
                this.bfZ = n.e.icon_grade_vote_no1;
                break;
            case 2:
                this.bfZ = n.e.icon_grade_vote_no2;
                break;
            case 3:
                this.bfZ = n.e.icon_grade_vote_no3;
                break;
            default:
                this.bfZ = -1;
                break;
        }
        this.bga = pollOption.text;
        if (j > 0) {
            this.bgb = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.bgb = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Gz() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
