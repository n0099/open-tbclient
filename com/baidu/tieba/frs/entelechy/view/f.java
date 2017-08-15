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
    private FrsPicVoteLayout cpy;
    private FrsPicVotePhotoFrame cpz;

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
            this.cpy = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20);
            if (this.cpy.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cpy.getLayoutParams()).topMargin = g;
            }
            if (this.cpS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cpS.getLayoutParams()).topMargin = g;
            }
            this.cpz = (FrsPicVotePhotoFrame) this.cpy.findViewById(d.h.frs_pic_vote_photoframe_1);
            this.cpA = (FrsPicVotePhotoFrame) this.cpy.findViewById(d.h.frs_pic_vote_photoframe_2);
            this.cpB = (FrsPicVotePhotoFrame) this.cpy.findViewById(d.h.frs_pic_vote_photoframe_3);
            this.cpz.setPageId(getTag());
            this.cpA.setPageId(getTag());
            this.cpB.setPageId(getTag());
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds4);
            a(this.cpz, g2, g3, g4);
            a(this.cpA, g2, g3, g4);
            a(this.cpB, g2, g3, g4);
            ahG();
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
        ahG();
        this.cpz.onChangeSkinType(i);
        this.cpA.onChangeSkinType(i);
        this.cpB.onChangeSkinType(i);
    }

    private void ahG() {
        this.cpz.setGrade(ai.getDrawable(d.g.pic_grade_vote_num1));
        this.cpA.setGrade(ai.getDrawable(d.g.pic_grade_vote_num2));
        this.cpB.setGrade(ai.getDrawable(d.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void H(bl blVar) {
        if (blVar != null && blVar.rt() != null) {
            List<PollOption> list = blVar.rt().options;
            if (!com.baidu.tbadk.core.h.oX().pd() || u.v(list)) {
                this.cpy.setVisibility(8);
                return;
            }
            this.cpy.setVisibility(0);
            this.cpz.setVisibility(0);
            this.cpA.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cpB.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cpz.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), blVar.rt().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cpA.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), blVar.rt().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cpB.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), blVar.rt().total_poll.longValue());
            }
        }
    }
}
