package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class aw implements com.baidu.tbadk.widget.vote.a {
    private int cKM = -1;
    private String cKN = null;
    private int aAV = 0;
    private boolean cKO = false;
    private int[] cKP = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] cKQ = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CL() {
        return this.cKM;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CI() {
        return this.cKN;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CJ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CM() {
        return this.aAV;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CK() {
        return this.aAV + "%";
    }

    public void ff(boolean z) {
        this.cKO = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.cKO ? this.cKP : this.cKQ;
        switch (i) {
            case 1:
                this.cKM = iArr[0];
                break;
            case 2:
                this.cKM = iArr[1];
                break;
            case 3:
                this.cKM = iArr[2];
                break;
            default:
                this.cKM = -1;
                break;
        }
        this.cKN = pollOption.text;
        if (j > 0) {
            this.aAV = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aAV = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CN() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
