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
    private FrsPicVoteLayout dLT;
    private FrsPicVotePhotoFrame dLU;
    private FrsPicVotePhotoFrame dLV;
    private FrsPicVotePhotoFrame dLW;

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
            this.dLT = (FrsPicVoteLayout) findViewById;
            int t = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds20);
            if (this.dLT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dLT.getLayoutParams()).topMargin = t;
            }
            if (this.dMn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dMn.getLayoutParams()).topMargin = t;
            }
            this.dLU = (FrsPicVotePhotoFrame) this.dLT.findViewById(d.g.frs_pic_vote_photoframe_1);
            this.dLV = (FrsPicVotePhotoFrame) this.dLT.findViewById(d.g.frs_pic_vote_photoframe_2);
            this.dLW = (FrsPicVotePhotoFrame) this.dLT.findViewById(d.g.frs_pic_vote_photoframe_3);
            this.dLU.setPageId(getTag());
            this.dLV.setPageId(getTag());
            this.dLW.setPageId(getTag());
            int t2 = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds64);
            int t3 = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
            int t4 = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds4);
            a(this.dLU, t2, t3, t4);
            a(this.dLV, t2, t3, t4);
            a(this.dLW, t2, t3, t4);
            axK();
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
        axK();
        this.dLU.onChangeSkinType(i);
        this.dLV.onChangeSkinType(i);
        this.dLW.onChangeSkinType(i);
    }

    private void axK() {
        this.dLU.setGrade(aj.getDrawable(d.f.pic_grade_vote_num1));
        this.dLV.setGrade(aj.getDrawable(d.f.pic_grade_vote_num2));
        this.dLW.setGrade(aj.getDrawable(d.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void S(bd bdVar) {
        if (bdVar != null && bdVar.yZ() != null) {
            List<PollOption> list = bdVar.yZ().options;
            if (!com.baidu.tbadk.core.i.xo().xu() || v.E(list)) {
                this.dLT.setVisibility(8);
                return;
            }
            this.dLT.setVisibility(0);
            this.dLU.setVisibility(0);
            this.dLV.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.dLW.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.dLU.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bdVar.yZ().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.dLV.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bdVar.yZ().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.dLW.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bdVar.yZ().total_poll.longValue());
            }
        }
    }
}
