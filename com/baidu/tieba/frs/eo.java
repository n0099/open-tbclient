package com.baidu.tieba.frs;

import com.baidu.tieba.i;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class eo implements com.baidu.tbadk.widget.vote.a {
    private int aZW = -1;
    private String aZX = null;
    private int aZY = 0;

    @Override // com.baidu.tbadk.widget.vote.a
    public int Fs() {
        return this.aZW;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fp() {
        return this.aZX;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fq() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ft() {
        return this.aZY;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fr() {
        return String.valueOf(this.aZY) + "%";
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        switch (i) {
            case 1:
                this.aZW = i.e.icon_grade_vote_no1;
                break;
            case 2:
                this.aZW = i.e.icon_grade_vote_no2;
                break;
            case 3:
                this.aZW = i.e.icon_grade_vote_no3;
                break;
            default:
                this.aZW = -1;
                break;
        }
        this.aZX = pollOption.text;
        if (j > 0) {
            this.aZY = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aZY = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Fu() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
