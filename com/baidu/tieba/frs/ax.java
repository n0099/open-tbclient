package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes2.dex */
public class ax implements com.baidu.tbadk.widget.vote.a {
    private int dzV = -1;
    private String dzW = null;
    private int boU = 0;
    private boolean dzX = false;
    private int[] dzY = {d.f.icon_grade_vote_num1, d.f.icon_grade_vote_num2, d.f.icon_grade_vote_num3};
    private int[] dzZ = {d.f.icon_grade_vote_no1, d.f.icon_grade_vote_no2, d.f.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Km() {
        return this.dzV;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kj() {
        return this.dzW;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kk() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Kn() {
        return this.boU;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Kl() {
        return this.boU + "%";
    }

    public void fL(boolean z) {
        this.dzX = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.dzX ? this.dzY : this.dzZ;
        switch (i) {
            case 1:
                this.dzV = iArr[0];
                break;
            case 2:
                this.dzV = iArr[1];
                break;
            case 3:
                this.dzV = iArr[2];
                break;
            default:
                this.dzV = -1;
                break;
        }
        this.dzW = pollOption.text;
        if (j > 0) {
            this.boU = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.boU = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ko() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
