package com.baidu.tieba.frs;

import com.baidu.tieba.t;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class fy implements com.baidu.tbadk.widget.vote.a {
    private int brY = -1;
    private String brZ = null;
    private int bsa = 0;

    @Override // com.baidu.tbadk.widget.vote.a
    public int Jh() {
        return this.brY;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Je() {
        return this.brZ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Jf() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ji() {
        return this.bsa;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Jg() {
        return String.valueOf(this.bsa) + "%";
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        switch (i) {
            case 1:
                this.brY = t.f.icon_grade_vote_no1;
                break;
            case 2:
                this.brY = t.f.icon_grade_vote_no2;
                break;
            case 3:
                this.brY = t.f.icon_grade_vote_no3;
                break;
            default:
                this.brY = -1;
                break;
        }
        this.brZ = pollOption.text;
        if (j > 0) {
            this.bsa = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.bsa = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Jj() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
