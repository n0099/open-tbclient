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
    private FrsPicVoteLayout dMa;
    private FrsPicVotePhotoFrame dMb;
    private FrsPicVotePhotoFrame dMc;
    private FrsPicVotePhotoFrame dMd;

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
            this.dMa = (FrsPicVoteLayout) findViewById;
            int t = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds20);
            if (this.dMa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dMa.getLayoutParams()).topMargin = t;
            }
            if (this.dMu.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dMu.getLayoutParams()).topMargin = t;
            }
            this.dMb = (FrsPicVotePhotoFrame) this.dMa.findViewById(d.g.frs_pic_vote_photoframe_1);
            this.dMc = (FrsPicVotePhotoFrame) this.dMa.findViewById(d.g.frs_pic_vote_photoframe_2);
            this.dMd = (FrsPicVotePhotoFrame) this.dMa.findViewById(d.g.frs_pic_vote_photoframe_3);
            this.dMb.setPageId(getTag());
            this.dMc.setPageId(getTag());
            this.dMd.setPageId(getTag());
            int t2 = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds64);
            int t3 = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
            int t4 = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds4);
            a(this.dMb, t2, t3, t4);
            a(this.dMc, t2, t3, t4);
            a(this.dMd, t2, t3, t4);
            axJ();
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
        axJ();
        this.dMb.onChangeSkinType(i);
        this.dMc.onChangeSkinType(i);
        this.dMd.onChangeSkinType(i);
    }

    private void axJ() {
        this.dMb.setGrade(aj.getDrawable(d.f.pic_grade_vote_num1));
        this.dMc.setGrade(aj.getDrawable(d.f.pic_grade_vote_num2));
        this.dMd.setGrade(aj.getDrawable(d.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void S(bd bdVar) {
        if (bdVar != null && bdVar.yZ() != null) {
            List<PollOption> list = bdVar.yZ().options;
            if (!com.baidu.tbadk.core.i.xo().xu() || v.E(list)) {
                this.dMa.setVisibility(8);
                return;
            }
            this.dMa.setVisibility(0);
            this.dMb.setVisibility(0);
            this.dMc.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.dMd.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.dMb.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bdVar.yZ().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.dMc.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bdVar.yZ().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.dMd.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bdVar.yZ().total_poll.longValue());
            }
        }
    }
}
