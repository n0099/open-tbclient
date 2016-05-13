package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ak extends am {
    private FrsPicVoteLayout bln;
    private FrsPicVotePhotoFrame blo;
    private FrsPicVotePhotoFrame blp;
    private FrsPicVotePhotoFrame blq;

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.c.am
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(t.g.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(t.g.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bln = (FrsPicVoteLayout) findViewById;
            int c = com.baidu.adp.lib.util.k.c(getContext(), t.e.ds20);
            if (this.bln.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bln.getLayoutParams()).topMargin = c;
            }
            if (this.bpW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bpW.getLayoutParams()).topMargin = c;
            }
            this.blo = (FrsPicVotePhotoFrame) this.bln.findViewById(t.g.frs_pic_vote_photoframe_1);
            this.blp = (FrsPicVotePhotoFrame) this.bln.findViewById(t.g.frs_pic_vote_photoframe_2);
            this.blq = (FrsPicVotePhotoFrame) this.bln.findViewById(t.g.frs_pic_vote_photoframe_3);
            int c2 = com.baidu.adp.lib.util.k.c(getContext(), t.e.ds64);
            int c3 = com.baidu.adp.lib.util.k.c(getContext(), t.e.ds32);
            int c4 = com.baidu.adp.lib.util.k.c(getContext(), t.e.ds4);
            a(this.blo, c2, c3, c4);
            a(this.blp, c2, c3, c4);
            a(this.blq, c2, c3, c4);
            SM();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.Z(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.c.am
    protected void gA(int i) {
        SM();
        this.blo.onChangeSkinType(i);
        this.blp.onChangeSkinType(i);
        this.blq.onChangeSkinType(i);
    }

    private void SM() {
        this.blo.setGrade(com.baidu.tbadk.core.util.at.getDrawable(t.f.pic_grade_vote_num1));
        this.blp.setGrade(com.baidu.tbadk.core.util.at.getDrawable(t.f.pic_grade_vote_num2));
        this.blq.setGrade(com.baidu.tbadk.core.util.at.getDrawable(t.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.c.am
    protected void k(ax axVar) {
        if (axVar != null && axVar.qM() != null) {
            List<PollOption> list = axVar.qM().options;
            if (!com.baidu.tbadk.core.l.ob().oh() || com.baidu.tbadk.core.util.y.s(list)) {
                this.bln.setVisibility(8);
                return;
            }
            this.bln.setVisibility(0);
            this.blo.setVisibility(0);
            this.blp.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.blq.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.blo.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), axVar.qM().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.blp.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), axVar.qM().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.blq.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), axVar.qM().total_poll.longValue());
            }
        }
    }
}
