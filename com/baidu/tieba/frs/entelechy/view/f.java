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
    private FrsPicVoteLayout dIE;
    private FrsPicVotePhotoFrame dIF;
    private FrsPicVotePhotoFrame dIG;
    private FrsPicVotePhotoFrame dIH;

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
            this.dIE = (FrsPicVoteLayout) findViewById;
            int s = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds20);
            if (this.dIE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dIE.getLayoutParams()).topMargin = s;
            }
            if (this.dIY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dIY.getLayoutParams()).topMargin = s;
            }
            this.dIF = (FrsPicVotePhotoFrame) this.dIE.findViewById(d.g.frs_pic_vote_photoframe_1);
            this.dIG = (FrsPicVotePhotoFrame) this.dIE.findViewById(d.g.frs_pic_vote_photoframe_2);
            this.dIH = (FrsPicVotePhotoFrame) this.dIE.findViewById(d.g.frs_pic_vote_photoframe_3);
            this.dIF.setPageId(getTag());
            this.dIG.setPageId(getTag());
            this.dIH.setPageId(getTag());
            int s2 = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds64);
            int s3 = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
            int s4 = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds4);
            a(this.dIF, s2, s3, s4);
            a(this.dIG, s2, s3, s4);
            a(this.dIH, s2, s3, s4);
            awF();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.bL(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void no(int i) {
        awF();
        this.dIF.onChangeSkinType(i);
        this.dIG.onChangeSkinType(i);
        this.dIH.onChangeSkinType(i);
    }

    private void awF() {
        this.dIF.setGrade(aj.getDrawable(d.f.pic_grade_vote_num1));
        this.dIG.setGrade(aj.getDrawable(d.f.pic_grade_vote_num2));
        this.dIH.setGrade(aj.getDrawable(d.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void P(bd bdVar) {
        if (bdVar != null && bdVar.yE() != null) {
            List<PollOption> list = bdVar.yE().options;
            if (!com.baidu.tbadk.core.i.wA().wG() || v.E(list)) {
                this.dIE.setVisibility(8);
                return;
            }
            this.dIE.setVisibility(0);
            this.dIF.setVisibility(0);
            this.dIG.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.dIH.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.dIF.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bdVar.yE().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.dIG.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bdVar.yE().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.dIH.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bdVar.yE().total_poll.longValue());
            }
        }
    }
}
