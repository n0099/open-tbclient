package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ag extends ao {
    private FrsPicVoteLayout bTH;
    private FrsPicVotePhotoFrame bTI;
    private FrsPicVotePhotoFrame bTJ;
    private FrsPicVotePhotoFrame bTK;

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
            this.bTH = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
            if (this.bTH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bTH.getLayoutParams()).topMargin = g;
            }
            if (this.bUa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bUa.getLayoutParams()).topMargin = g;
            }
            this.bTI = (FrsPicVotePhotoFrame) this.bTH.findViewById(w.h.frs_pic_vote_photoframe_1);
            this.bTJ = (FrsPicVotePhotoFrame) this.bTH.findViewById(w.h.frs_pic_vote_photoframe_2);
            this.bTK = (FrsPicVotePhotoFrame) this.bTH.findViewById(w.h.frs_pic_vote_photoframe_3);
            this.bTI.setPageId(getTag());
            this.bTJ.setPageId(getTag());
            this.bTK.setPageId(getTag());
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4);
            a(this.bTI, g2, g3, g4);
            a(this.bTJ, g2, g3, g4);
            a(this.bTK, g2, g3, g4);
            aaY();
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
    protected void ic(int i) {
        aaY();
        this.bTI.onChangeSkinType(i);
        this.bTJ.onChangeSkinType(i);
        this.bTK.onChangeSkinType(i);
    }

    private void aaY() {
        this.bTI.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num1));
        this.bTJ.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num2));
        this.bTK.setGrade(com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void x(bk bkVar) {
        if (bkVar != null && bkVar.rn() != null) {
            List<PollOption> list = bkVar.rn().options;
            if (!com.baidu.tbadk.core.r.oV().pb() || com.baidu.tbadk.core.util.x.r(list)) {
                this.bTH.setVisibility(8);
                return;
            }
            this.bTH.setVisibility(0);
            this.bTI.setVisibility(0);
            this.bTJ.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bTK.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bTI.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bkVar.rn().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bTJ.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bkVar.rn().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bTK.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bkVar.rn().total_poll.longValue());
            }
        }
    }
}
