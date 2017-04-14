package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ak extends as {
    private FrsPicVotePhotoFrame bTA;
    private FrsPicVotePhotoFrame bTB;
    private FrsPicVotePhotoFrame bTC;
    private FrsPicVoteLayout bTz;

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
            this.bTz = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
            if (this.bTz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bTz.getLayoutParams()).topMargin = g;
            }
            if (this.bTM.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bTM.getLayoutParams()).topMargin = g;
            }
            this.bTA = (FrsPicVotePhotoFrame) this.bTz.findViewById(w.h.frs_pic_vote_photoframe_1);
            this.bTB = (FrsPicVotePhotoFrame) this.bTz.findViewById(w.h.frs_pic_vote_photoframe_2);
            this.bTC = (FrsPicVotePhotoFrame) this.bTz.findViewById(w.h.frs_pic_vote_photoframe_3);
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4);
            a(this.bTA, g2, g3, g4);
            a(this.bTB, g2, g3, g4);
            a(this.bTC, g2, g3, g4);
            abQ();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.ao(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void ig(int i) {
        abQ();
        this.bTA.onChangeSkinType(i);
        this.bTB.onChangeSkinType(i);
        this.bTC.onChangeSkinType(i);
    }

    private void abQ() {
        this.bTA.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num1));
        this.bTB.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num2));
        this.bTC.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void t(bi biVar) {
        if (biVar != null && biVar.sd() != null) {
            List<PollOption> list = biVar.sd().options;
            if (!com.baidu.tbadk.core.q.po().pu() || com.baidu.tbadk.core.util.x.q(list)) {
                this.bTz.setVisibility(8);
                return;
            }
            this.bTz.setVisibility(0);
            this.bTA.setVisibility(0);
            this.bTB.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bTC.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bTA.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), biVar.sd().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bTB.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), biVar.sd().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bTC.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), biVar.sd().total_poll.longValue());
            }
        }
    }
}
