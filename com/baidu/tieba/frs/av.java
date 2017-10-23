package com.baidu.tieba.frs;

import com.baidu.tieba.d;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class av implements com.baidu.tbadk.widget.vote.a {
    private int ctM = -1;
    private String ctN = null;
    private int azw = 0;
    private boolean ctO = false;
    private int[] ctP = {d.g.icon_grade_vote_num1, d.g.icon_grade_vote_num2, d.g.icon_grade_vote_num3};
    private int[] ctQ = {d.g.icon_grade_vote_no1, d.g.icon_grade_vote_no2, d.g.icon_grade_vote_no3};

    @Override // com.baidu.tbadk.widget.vote.a
    public int Ca() {
        return this.ctM;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BX() {
        return this.ctN;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BY() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int Cb() {
        return this.azw;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String BZ() {
        return this.azw + "%";
    }

    public void eM(boolean z) {
        this.ctO = z;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public boolean isSelected() {
        return true;
    }

    public void a(int i, PollOption pollOption, long j) {
        int[] iArr = this.ctO ? this.ctP : this.ctQ;
        switch (i) {
            case 1:
                this.ctM = iArr[0];
                break;
            case 2:
                this.ctM = iArr[1];
                break;
            case 3:
                this.ctM = iArr[2];
                break;
            default:
                this.ctM = -1;
                break;
        }
        this.ctN = pollOption.text;
        if (j > 0) {
            this.azw = (int) ((pollOption.num.longValue() * 100) / j);
        } else {
            this.azw = 0;
        }
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public String Cc() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.vote.a
    public int getId() {
        return 0;
    }
}
