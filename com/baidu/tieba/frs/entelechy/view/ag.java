package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ag extends ao {
    private FrsPicVoteLayout chI;
    private FrsPicVotePhotoFrame chJ;
    private FrsPicVotePhotoFrame chK;
    private FrsPicVotePhotoFrame chL;

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
            this.chI = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
            if (this.chI.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.chI.getLayoutParams()).topMargin = g;
            }
            if (this.cic.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cic.getLayoutParams()).topMargin = g;
            }
            this.chJ = (FrsPicVotePhotoFrame) this.chI.findViewById(w.h.frs_pic_vote_photoframe_1);
            this.chK = (FrsPicVotePhotoFrame) this.chI.findViewById(w.h.frs_pic_vote_photoframe_2);
            this.chL = (FrsPicVotePhotoFrame) this.chI.findViewById(w.h.frs_pic_vote_photoframe_3);
            this.chJ.setPageId(getTag());
            this.chK.setPageId(getTag());
            this.chL.setPageId(getTag());
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4);
            a(this.chJ, g2, g3, g4);
            a(this.chK, g2, g3, g4);
            a(this.chL, g2, g3, g4);
            afU();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.av(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void iM(int i) {
        afU();
        this.chJ.onChangeSkinType(i);
        this.chK.onChangeSkinType(i);
        this.chL.onChangeSkinType(i);
    }

    private void afU() {
        this.chJ.setGrade(com.baidu.tbadk.core.util.as.getDrawable(w.g.pic_grade_vote_num1));
        this.chK.setGrade(com.baidu.tbadk.core.util.as.getDrawable(w.g.pic_grade_vote_num2));
        this.chL.setGrade(com.baidu.tbadk.core.util.as.getDrawable(w.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void D(bm bmVar) {
        if (bmVar != null && bmVar.rg() != null) {
            List<PollOption> list = bmVar.rg().options;
            if (!com.baidu.tbadk.core.r.oK().oQ() || com.baidu.tbadk.core.util.z.t(list)) {
                this.chI.setVisibility(8);
                return;
            }
            this.chI.setVisibility(0);
            this.chJ.setVisibility(0);
            this.chK.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.chL.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.chJ.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bmVar.rg().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.chK.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bmVar.rg().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.chL.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bmVar.rg().total_poll.longValue());
            }
        }
    }
}
