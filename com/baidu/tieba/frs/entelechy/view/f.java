package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes2.dex */
public class f extends i {
    private FrsPicVoteLayout dLO;
    private FrsPicVotePhotoFrame dLP;
    private FrsPicVotePhotoFrame dLQ;
    private FrsPicVotePhotoFrame dLR;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(d.g.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(d.g.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.dLO = (FrsPicVoteLayout) findViewById;
            int t = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds20);
            if (this.dLO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dLO.getLayoutParams()).topMargin = t;
            }
            if (this.dMi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dMi.getLayoutParams()).topMargin = t;
            }
            this.dLP = (FrsPicVotePhotoFrame) this.dLO.findViewById(d.g.frs_pic_vote_photoframe_1);
            this.dLQ = (FrsPicVotePhotoFrame) this.dLO.findViewById(d.g.frs_pic_vote_photoframe_2);
            this.dLR = (FrsPicVotePhotoFrame) this.dLO.findViewById(d.g.frs_pic_vote_photoframe_3);
            this.dLP.setPageId(getTag());
            this.dLQ.setPageId(getTag());
            this.dLR.setPageId(getTag());
            int t2 = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds64);
            int t3 = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
            int t4 = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds4);
            a(this.dLP, t2, t3, t4);
            a(this.dLQ, t2, t3, t4);
            a(this.dLR, t2, t3, t4);
            axI();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.bJ(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void nm(int i) {
        axI();
        this.dLP.onChangeSkinType(i);
        this.dLQ.onChangeSkinType(i);
        this.dLR.onChangeSkinType(i);
    }

    private void axI() {
        this.dLP.setGrade(aj.getDrawable(d.f.pic_grade_vote_num1));
        this.dLQ.setGrade(aj.getDrawable(d.f.pic_grade_vote_num2));
        this.dLR.setGrade(aj.getDrawable(d.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void S(bd bdVar) {
        if (bdVar != null && bdVar.yZ() != null) {
            List<PollOption> list = bdVar.yZ().options;
            if (!com.baidu.tbadk.core.i.xo().xu() || v.E(list)) {
                this.dLO.setVisibility(8);
                return;
            }
            this.dLO.setVisibility(0);
            this.dLP.setVisibility(0);
            this.dLQ.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.dLR.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.dLP.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bdVar.yZ().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.dLQ.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bdVar.yZ().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.dLR.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bdVar.yZ().total_poll.longValue());
            }
        }
    }
}
