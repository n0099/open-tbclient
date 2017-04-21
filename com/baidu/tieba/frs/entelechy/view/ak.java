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
    private FrsPicVoteLayout bVQ;
    private FrsPicVotePhotoFrame bVR;
    private FrsPicVotePhotoFrame bVS;
    private FrsPicVotePhotoFrame bVT;

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
            this.bVQ = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
            if (this.bVQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bVQ.getLayoutParams()).topMargin = g;
            }
            if (this.bWd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bWd.getLayoutParams()).topMargin = g;
            }
            this.bVR = (FrsPicVotePhotoFrame) this.bVQ.findViewById(w.h.frs_pic_vote_photoframe_1);
            this.bVS = (FrsPicVotePhotoFrame) this.bVQ.findViewById(w.h.frs_pic_vote_photoframe_2);
            this.bVT = (FrsPicVotePhotoFrame) this.bVQ.findViewById(w.h.frs_pic_vote_photoframe_3);
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4);
            a(this.bVR, g2, g3, g4);
            a(this.bVS, g2, g3, g4);
            a(this.bVT, g2, g3, g4);
            acR();
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
    protected void im(int i) {
        acR();
        this.bVR.onChangeSkinType(i);
        this.bVS.onChangeSkinType(i);
        this.bVT.onChangeSkinType(i);
    }

    private void acR() {
        this.bVR.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num1));
        this.bVS.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num2));
        this.bVT.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void t(bi biVar) {
        if (biVar != null && biVar.sd() != null) {
            List<PollOption> list = biVar.sd().options;
            if (!com.baidu.tbadk.core.q.po().pu() || com.baidu.tbadk.core.util.x.q(list)) {
                this.bVQ.setVisibility(8);
                return;
            }
            this.bVQ.setVisibility(0);
            this.bVR.setVisibility(0);
            this.bVS.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bVT.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bVR.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), biVar.sd().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bVS.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), biVar.sd().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bVT.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), biVar.sd().total_poll.longValue());
            }
        }
    }
}
