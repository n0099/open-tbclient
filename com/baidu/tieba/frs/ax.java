package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes2.dex */
public class ax implements com.baidu.tbadk.widget.vote.a {
    private int dER = -1;
    private String dES = null;
    private int bpm = 0;
    private boolean dET = false;
    private int[] dEU = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] dEV = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Kd() {
        return this.dER;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ka() {
        return this.dES;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kb() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ke() {
        return this.bpm;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kc() {
        return this.bpm + "%";
    }

    public void fS(boolean z) {
        this.dET = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.dET ? this.dEU : this.dEV;
        switch (i) {
            case 1:
                this.dER = iArr[0];
                break;
            case 2:
                this.dER = iArr[1];
                break;
            case 3:
                this.dER = iArr[2];
                break;
            default:
                this.dER = -1;
                break;
        }
        this.dES = pollOption.text;
        if (j > 0) {
            this.bpm = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.bpm = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kf() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
