package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class av implements com.baidu.tbadk.widget.vote.a {
    private int cKC = -1;
    private String cKD = null;
    private int aAQ = 0;
    private boolean cKE = false;
    private int[] cKF = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] cKG = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CK() {
        return this.cKC;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CH() {
        return this.cKD;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CI() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CL() {
        return this.aAQ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CJ() {
        return this.aAQ + "%";
    }

    public void fe(boolean z) {
        this.cKE = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.cKE ? this.cKF : this.cKG;
        switch (i) {
            case 1:
                this.cKC = iArr[0];
                break;
            case 2:
                this.cKC = iArr[1];
                break;
            case 3:
                this.cKC = iArr[2];
                break;
            default:
                this.cKC = -1;
                break;
        }
        this.cKD = pollOption.text;
        if (j > 0) {
            this.aAQ = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aAQ = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CM() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
