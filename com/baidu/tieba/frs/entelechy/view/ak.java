package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ak extends as {
    private FrsPicVoteLayout bTL;
    private FrsPicVotePhotoFrame bTM;
    private FrsPicVotePhotoFrame bTN;
    private FrsPicVotePhotoFrame bTO;

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(w.h.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(w.h.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bTL = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
            if (this.bTL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bTL.getLayoutParams()).topMargin = g;
            }
            if (this.bTY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bTY.getLayoutParams()).topMargin = g;
            }
            this.bTM = (FrsPicVotePhotoFrame) this.bTL.findViewById(w.h.frs_pic_vote_photoframe_1);
            this.bTN = (FrsPicVotePhotoFrame) this.bTL.findViewById(w.h.frs_pic_vote_photoframe_2);
            this.bTO = (FrsPicVotePhotoFrame) this.bTL.findViewById(w.h.frs_pic_vote_photoframe_3);
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4);
            a(this.bTM, g2, g3, g4);
            a(this.bTN, g2, g3, g4);
            a(this.bTO, g2, g3, g4);
            abu();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.aq(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void id(int i) {
        abu();
        this.bTM.onChangeSkinType(i);
        this.bTN.onChangeSkinType(i);
        this.bTO.onChangeSkinType(i);
    }

    private void abu() {
        this.bTM.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num1));
        this.bTN.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num2));
        this.bTO.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void t(bj bjVar) {
        if (bjVar != null && bjVar.rF() != null) {
            List<PollOption> list = bjVar.rF().options;
            if (!com.baidu.tbadk.core.l.oQ().oW() || com.baidu.tbadk.core.util.x.q(list)) {
                this.bTL.setVisibility(8);
                return;
            }
            this.bTL.setVisibility(0);
            this.bTM.setVisibility(0);
            this.bTN.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bTO.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bTM.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bjVar.rF().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bTN.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bjVar.rF().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bTO.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bjVar.rF().total_poll.longValue());
            }
        }
    }
}
