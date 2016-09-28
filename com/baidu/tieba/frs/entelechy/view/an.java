package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.r;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class an extends ap {
    private FrsPicVotePhotoFrame bXA;
    private FrsPicVotePhotoFrame bXB;
    private FrsPicVoteLayout bXy;
    private FrsPicVotePhotoFrame bXz;

    public an(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(r.g.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(r.g.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bXy = (FrsPicVoteLayout) findViewById;
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20);
            if (this.bXy.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bXy.getLayoutParams()).topMargin = e;
            }
            if (this.bXF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bXF.getLayoutParams()).topMargin = e;
            }
            this.bXz = (FrsPicVotePhotoFrame) this.bXy.findViewById(r.g.frs_pic_vote_photoframe_1);
            this.bXA = (FrsPicVotePhotoFrame) this.bXy.findViewById(r.g.frs_pic_vote_photoframe_2);
            this.bXB = (FrsPicVotePhotoFrame) this.bXy.findViewById(r.g.frs_pic_vote_photoframe_3);
            int e2 = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds64);
            int e3 = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds32);
            int e4 = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds4);
            a(this.bXz, e2, e3, e4);
            a(this.bXA, e2, e3, e4);
            a(this.bXB, e2, e3, e4);
            adG();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.ao(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    protected void ik(int i) {
        adG();
        this.bXz.onChangeSkinType(i);
        this.bXA.onChangeSkinType(i);
        this.bXB.onChangeSkinType(i);
    }

    private void adG() {
        this.bXz.setGrade(av.getDrawable(r.f.pic_grade_vote_num1));
        this.bXA.setGrade(av.getDrawable(r.f.pic_grade_vote_num2));
        this.bXB.setGrade(av.getDrawable(r.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    protected void m(bi biVar) {
        if (biVar != null && biVar.rE() != null) {
            List<PollOption> list = biVar.rE().options;
            if (!com.baidu.tbadk.core.l.oH().oN() || com.baidu.tbadk.core.util.y.t(list)) {
                this.bXy.setVisibility(8);
                return;
            }
            this.bXy.setVisibility(0);
            this.bXz.setVisibility(0);
            this.bXA.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bXB.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bXz.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), biVar.rE().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bXA.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), biVar.rE().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bXB.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), biVar.rE().total_poll.longValue());
            }
        }
    }
}
