package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.u;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ak extends am {
    private FrsPicVoteLayout bMl;
    private FrsPicVotePhotoFrame bMm;
    private FrsPicVotePhotoFrame bMn;
    private FrsPicVotePhotoFrame bMo;

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.am
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(u.g.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(u.g.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bMl = (FrsPicVoteLayout) findViewById;
            int c = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds20);
            if (this.bMl.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bMl.getLayoutParams()).topMargin = c;
            }
            if (this.bMr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bMr.getLayoutParams()).topMargin = c;
            }
            this.bMm = (FrsPicVotePhotoFrame) this.bMl.findViewById(u.g.frs_pic_vote_photoframe_1);
            this.bMn = (FrsPicVotePhotoFrame) this.bMl.findViewById(u.g.frs_pic_vote_photoframe_2);
            this.bMo = (FrsPicVotePhotoFrame) this.bMl.findViewById(u.g.frs_pic_vote_photoframe_3);
            int c2 = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds64);
            int c3 = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds32);
            int c4 = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds4);
            a(this.bMm, c2, c3, c4);
            a(this.bMn, c2, c3, c4);
            a(this.bMo, c2, c3, c4);
            YG();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.ai(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.am
    protected void hD(int i) {
        YG();
        this.bMm.onChangeSkinType(i);
        this.bMn.onChangeSkinType(i);
        this.bMo.onChangeSkinType(i);
    }

    private void YG() {
        this.bMm.setGrade(av.getDrawable(u.f.pic_grade_vote_num1));
        this.bMn.setGrade(av.getDrawable(u.f.pic_grade_vote_num2));
        this.bMo.setGrade(av.getDrawable(u.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.am
    protected void l(be beVar) {
        if (beVar != null && beVar.qo() != null) {
            List<PollOption> list = beVar.qo().options;
            if (!com.baidu.tbadk.core.l.nL().nR() || com.baidu.tbadk.core.util.y.t(list)) {
                this.bMl.setVisibility(8);
                return;
            }
            this.bMl.setVisibility(0);
            this.bMm.setVisibility(0);
            this.bMn.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bMo.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bMm.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), beVar.qo().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bMn.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), beVar.qo().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bMo.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), beVar.qo().total_poll.longValue());
            }
        }
    }
}
