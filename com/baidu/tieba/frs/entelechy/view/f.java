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
    private FrsPicVoteLayout cnF;
    private FrsPicVotePhotoFrame cnG;
    private FrsPicVotePhotoFrame cnH;
    private FrsPicVotePhotoFrame cnI;

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
            this.cnF = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20);
            if (this.cnF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cnF.getLayoutParams()).topMargin = g;
            }
            if (this.cnZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cnZ.getLayoutParams()).topMargin = g;
            }
            this.cnG = (FrsPicVotePhotoFrame) this.cnF.findViewById(d.h.frs_pic_vote_photoframe_1);
            this.cnH = (FrsPicVotePhotoFrame) this.cnF.findViewById(d.h.frs_pic_vote_photoframe_2);
            this.cnI = (FrsPicVotePhotoFrame) this.cnF.findViewById(d.h.frs_pic_vote_photoframe_3);
            this.cnG.setPageId(getTag());
            this.cnH.setPageId(getTag());
            this.cnI.setPageId(getTag());
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds4);
            a(this.cnG, g2, g3, g4);
            a(this.cnH, g2, g3, g4);
            a(this.cnI, g2, g3, g4);
            ahe();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.au(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void iW(int i) {
        ahe();
        this.cnG.onChangeSkinType(i);
        this.cnH.onChangeSkinType(i);
        this.cnI.onChangeSkinType(i);
    }

    private void ahe() {
        this.cnG.setGrade(ai.getDrawable(d.g.pic_grade_vote_num1));
        this.cnH.setGrade(ai.getDrawable(d.g.pic_grade_vote_num2));
        this.cnI.setGrade(ai.getDrawable(d.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void H(bl blVar) {
        if (blVar != null && blVar.rj() != null) {
            List<PollOption> list = blVar.rj().options;
            if (!com.baidu.tbadk.core.h.oN().oT() || u.v(list)) {
                this.cnF.setVisibility(8);
                return;
            }
            this.cnF.setVisibility(0);
            this.cnG.setVisibility(0);
            this.cnH.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cnI.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cnG.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), blVar.rj().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cnH.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), blVar.rj().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cnI.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), blVar.rj().total_poll.longValue());
            }
        }
    }
}
