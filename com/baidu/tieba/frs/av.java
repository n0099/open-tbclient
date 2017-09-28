package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class av implements com.baidu.tbadk.widget.vote.a {
    private int ctY = -1;
    private String ctZ = null;
    private int azI = 0;
    private boolean cua = false;
    private int[] cub = {d.g.icon_grade_vote_num1, d.g.icon_grade_vote_num2, d.g.icon_grade_vote_num3};
    private int[] cuc = {d.g.icon_grade_vote_no1, d.g.icon_grade_vote_no2, d.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cg() {
        return this.ctY;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cd() {
        return this.ctZ;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ce() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ch() {
        return this.azI;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cf() {
        return this.azI + "%";
    }

    public void eN(boolean z) {
        this.cua = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.cua ? this.cub : this.cuc;
        switch (i) {
            case 1:
                this.ctY = iArr[0];
                break;
            case 2:
                this.ctY = iArr[1];
                break;
            case 3:
                this.ctY = iArr[2];
                break;
            default:
                this.ctY = -1;
                break;
        }
        this.ctZ = pollOption.text;
        if (j > 0) {
            this.azI = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.azI = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Ci() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
