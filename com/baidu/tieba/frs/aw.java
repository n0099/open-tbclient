package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class aw implements com.baidu.tbadk.widget.vote.a {
    private int cKQ = -1;
    private String cKR = null;
    private int aAY = 0;
    private boolean cKS = false;
    private int[] cKT = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] cKU = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int CL() {
        return this.cKQ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CI() {
        return this.cKR;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CJ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int CM() {
        return this.aAY;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String CK() {
        return this.aAY + "%";
    }

    public void ff(boolean z) {
        this.cKS = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.cKS ? this.cKT : this.cKU;
        switch (i) {
            case 1:
                this.cKQ = iArr[0];
                break;
            case 2:
                this.cKQ = iArr[1];
                break;
            case 3:
                this.cKQ = iArr[2];
                break;
            default:
                this.cKQ = -1;
                break;
        }
        this.cKR = pollOption.text;
        if (j > 0) {
            this.aAY = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.aAY = 0;
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
