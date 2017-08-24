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
    private FrsPicVotePhotoFrame cpA;
    private FrsPicVotePhotoFrame cpB;
    private FrsPicVotePhotoFrame cpC;
    private FrsPicVoteLayout cpz;

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
            this.cpz = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20);
            if (this.cpz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cpz.getLayoutParams()).topMargin = g;
            }
            if (this.cpT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cpT.getLayoutParams()).topMargin = g;
            }
            this.cpA = (FrsPicVotePhotoFrame) this.cpz.findViewById(d.h.frs_pic_vote_photoframe_1);
            this.cpB = (FrsPicVotePhotoFrame) this.cpz.findViewById(d.h.frs_pic_vote_photoframe_2);
            this.cpC = (FrsPicVotePhotoFrame) this.cpz.findViewById(d.h.frs_pic_vote_photoframe_3);
            this.cpA.setPageId(getTag());
            this.cpB.setPageId(getTag());
            this.cpC.setPageId(getTag());
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds4);
            a(this.cpA, g2, g3, g4);
            a(this.cpB, g2, g3, g4);
            a(this.cpC, g2, g3, g4);
            ahA();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.aD(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void iY(int i) {
        ahA();
        this.cpA.onChangeSkinType(i);
        this.cpB.onChangeSkinType(i);
        this.cpC.onChangeSkinType(i);
    }

    private void ahA() {
        this.cpA.setGrade(ai.getDrawable(d.g.pic_grade_vote_num1));
        this.cpB.setGrade(ai.getDrawable(d.g.pic_grade_vote_num2));
        this.cpC.setGrade(ai.getDrawable(d.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void H(bl blVar) {
        if (blVar != null && blVar.ru() != null) {
            List<PollOption> list = blVar.ru().options;
            if (!com.baidu.tbadk.core.h.oY().pe() || u.v(list)) {
                this.cpz.setVisibility(8);
                return;
            }
            this.cpz.setVisibility(0);
            this.cpA.setVisibility(0);
            this.cpB.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cpC.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cpA.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), blVar.ru().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cpB.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), blVar.ru().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cpC.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), blVar.ru().total_poll.longValue());
            }
        }
    }
}
