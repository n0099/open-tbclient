package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes2.dex */
public class f extends i {
    private FrsPicVoteLayout dEd;
    private FrsPicVotePhotoFrame dEe;
    private FrsPicVotePhotoFrame dEf;
    private FrsPicVotePhotoFrame dEg;

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
            this.dEd = (FrsPicVoteLayout) findViewById;
            int s = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds20);
            if (this.dEd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dEd.getLayoutParams()).topMargin = s;
            }
            if (this.dEx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dEx.getLayoutParams()).topMargin = s;
            }
            this.dEe = (FrsPicVotePhotoFrame) this.dEd.findViewById(d.g.frs_pic_vote_photoframe_1);
            this.dEf = (FrsPicVotePhotoFrame) this.dEd.findViewById(d.g.frs_pic_vote_photoframe_2);
            this.dEg = (FrsPicVotePhotoFrame) this.dEd.findViewById(d.g.frs_pic_vote_photoframe_3);
            this.dEe.setPageId(getTag());
            this.dEf.setPageId(getTag());
            this.dEg.setPageId(getTag());
            int s2 = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds64);
            int s3 = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
            int s4 = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds4);
            a(this.dEe, s2, s3, s4);
            a(this.dEf, s2, s3, s4);
            a(this.dEg, s2, s3, s4);
            avC();
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
    protected void nl(int i) {
        avC();
        this.dEe.onChangeSkinType(i);
        this.dEf.onChangeSkinType(i);
        this.dEg.onChangeSkinType(i);
    }

    private void avC() {
        this.dEe.setGrade(aj.getDrawable(d.f.pic_grade_vote_num1));
        this.dEf.setGrade(aj.getDrawable(d.f.pic_grade_vote_num2));
        this.dEg.setGrade(aj.getDrawable(d.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void P(be beVar) {
        if (beVar != null && beVar.yJ() != null) {
            List<PollOption> list = beVar.yJ().options;
            if (!com.baidu.tbadk.core.i.wB().wH() || v.G(list)) {
                this.dEd.setVisibility(8);
                return;
            }
            this.dEd.setVisibility(0);
            this.dEe.setVisibility(0);
            this.dEf.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.dEg.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.dEe.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), beVar.yJ().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.dEf.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), beVar.yJ().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.dEg.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), beVar.yJ().total_poll.longValue());
            }
        }
    }
}
