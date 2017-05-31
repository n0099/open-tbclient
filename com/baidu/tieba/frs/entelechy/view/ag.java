package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ag extends ao {
    private FrsPicVotePhotoFrame bZA;
    private FrsPicVotePhotoFrame bZB;
    private FrsPicVotePhotoFrame bZC;
    private FrsPicVoteLayout bZz;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(w.h.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(w.h.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bZz = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
            if (this.bZz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bZz.getLayoutParams()).topMargin = g;
            }
            if (this.bZT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bZT.getLayoutParams()).topMargin = g;
            }
            this.bZA = (FrsPicVotePhotoFrame) this.bZz.findViewById(w.h.frs_pic_vote_photoframe_1);
            this.bZB = (FrsPicVotePhotoFrame) this.bZz.findViewById(w.h.frs_pic_vote_photoframe_2);
            this.bZC = (FrsPicVotePhotoFrame) this.bZz.findViewById(w.h.frs_pic_vote_photoframe_3);
            this.bZA.setPageId(getTag());
            this.bZB.setPageId(getTag());
            this.bZC.setPageId(getTag());
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4);
            a(this.bZA, g2, g3, g4);
            a(this.bZB, g2, g3, g4);
            a(this.bZC, g2, g3, g4);
            acc();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.ap(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void iA(int i) {
        acc();
        this.bZA.onChangeSkinType(i);
        this.bZB.onChangeSkinType(i);
        this.bZC.onChangeSkinType(i);
    }

    private void acc() {
        this.bZA.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num1));
        this.bZB.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num2));
        this.bZC.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void C(bl blVar) {
        if (blVar != null && blVar.rj() != null) {
            List<PollOption> list = blVar.rj().options;
            if (!com.baidu.tbadk.core.r.oN().oT() || com.baidu.tbadk.core.util.x.r(list)) {
                this.bZz.setVisibility(8);
                return;
            }
            this.bZz.setVisibility(0);
            this.bZA.setVisibility(0);
            this.bZB.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bZC.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bZA.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), blVar.rj().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bZB.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), blVar.rj().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bZC.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), blVar.rj().total_poll.longValue());
            }
        }
    }
}
