package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class f extends i {
    private FrsPicVoteLayout coQ;
    private FrsPicVotePhotoFrame coR;
    private FrsPicVotePhotoFrame coS;
    private FrsPicVotePhotoFrame coT;

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
            this.coQ = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20);
            if (this.coQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.coQ.getLayoutParams()).topMargin = g;
            }
            if (this.cpk.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cpk.getLayoutParams()).topMargin = g;
            }
            this.coR = (FrsPicVotePhotoFrame) this.coQ.findViewById(d.h.frs_pic_vote_photoframe_1);
            this.coS = (FrsPicVotePhotoFrame) this.coQ.findViewById(d.h.frs_pic_vote_photoframe_2);
            this.coT = (FrsPicVotePhotoFrame) this.coQ.findViewById(d.h.frs_pic_vote_photoframe_3);
            this.coR.setPageId(getTag());
            this.coS.setPageId(getTag());
            this.coT.setPageId(getTag());
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds4);
            a(this.coR, g2, g3, g4);
            a(this.coS, g2, g3, g4);
            a(this.coT, g2, g3, g4);
            ahl();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.av(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void iW(int i) {
        ahl();
        this.coR.onChangeSkinType(i);
        this.coS.onChangeSkinType(i);
        this.coT.onChangeSkinType(i);
    }

    private void ahl() {
        this.coR.setGrade(ai.getDrawable(d.g.pic_grade_vote_num1));
        this.coS.setGrade(ai.getDrawable(d.g.pic_grade_vote_num2));
        this.coT.setGrade(ai.getDrawable(d.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void H(bl blVar) {
        if (blVar != null && blVar.rt() != null) {
            List<PollOption> list = blVar.rt().options;
            if (!com.baidu.tbadk.core.h.oX().pd() || u.v(list)) {
                this.coQ.setVisibility(8);
                return;
            }
            this.coQ.setVisibility(0);
            this.coR.setVisibility(0);
            this.coS.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.coT.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.coR.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), blVar.rt().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.coS.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), blVar.rt().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.coT.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), blVar.rt().total_poll.longValue());
            }
        }
    }
}
