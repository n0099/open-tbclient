package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class f extends i {
    private FrsPicVoteLayout cxA;
    private FrsPicVotePhotoFrame cxB;
    private FrsPicVotePhotoFrame cxC;
    private FrsPicVotePhotoFrame cxD;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(d.h.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(d.h.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.cxA = (FrsPicVoteLayout) findViewById;
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds20);
            if (this.cxA.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cxA.getLayoutParams()).topMargin = f;
            }
            if (this.cxU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cxU.getLayoutParams()).topMargin = f;
            }
            this.cxB = (FrsPicVotePhotoFrame) this.cxA.findViewById(d.h.frs_pic_vote_photoframe_1);
            this.cxC = (FrsPicVotePhotoFrame) this.cxA.findViewById(d.h.frs_pic_vote_photoframe_2);
            this.cxD = (FrsPicVotePhotoFrame) this.cxA.findViewById(d.h.frs_pic_vote_photoframe_3);
            this.cxB.setPageId(getTag());
            this.cxC.setPageId(getTag());
            this.cxD.setPageId(getTag());
            int f2 = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds64);
            int f3 = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds32);
            int f4 = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds4);
            a(this.cxB, f2, f3, f4);
            a(this.cxC, f2, f3, f4);
            a(this.cxD, f2, f3, f4);
            ajy();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.aL(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void jw(int i) {
        ajy();
        this.cxB.onChangeSkinType(i);
        this.cxC.onChangeSkinType(i);
        this.cxD.onChangeSkinType(i);
    }

    private void ajy() {
        this.cxB.setGrade(aj.getDrawable(d.g.pic_grade_vote_num1));
        this.cxC.setGrade(aj.getDrawable(d.g.pic_grade_vote_num2));
        this.cxD.setGrade(aj.getDrawable(d.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void G(bh bhVar) {
        if (bhVar != null && bhVar.rc() != null) {
            List<PollOption> list = bhVar.rc().options;
            if (!com.baidu.tbadk.core.h.oM().oS() || v.u(list)) {
                this.cxA.setVisibility(8);
                return;
            }
            this.cxA.setVisibility(0);
            this.cxB.setVisibility(0);
            this.cxC.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cxD.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cxB.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bhVar.rc().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cxC.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bhVar.rc().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cxD.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bhVar.rc().total_poll.longValue());
            }
        }
    }
}
