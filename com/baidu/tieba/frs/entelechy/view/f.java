package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class f extends i {
    private FrsPicVoteLayout cwW;
    private FrsPicVotePhotoFrame cwX;
    private FrsPicVotePhotoFrame cwY;
    private FrsPicVotePhotoFrame cwZ;

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
            this.cwW = (FrsPicVoteLayout) findViewById;
            int f = com.baidu.adp.lib.util.k.f(getContext(), d.f.ds20);
            if (this.cwW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cwW.getLayoutParams()).topMargin = f;
            }
            if (this.cxq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cxq.getLayoutParams()).topMargin = f;
            }
            this.cwX = (FrsPicVotePhotoFrame) this.cwW.findViewById(d.h.frs_pic_vote_photoframe_1);
            this.cwY = (FrsPicVotePhotoFrame) this.cwW.findViewById(d.h.frs_pic_vote_photoframe_2);
            this.cwZ = (FrsPicVotePhotoFrame) this.cwW.findViewById(d.h.frs_pic_vote_photoframe_3);
            this.cwX.setPageId(getTag());
            this.cwY.setPageId(getTag());
            this.cwZ.setPageId(getTag());
            int f2 = com.baidu.adp.lib.util.k.f(getContext(), d.f.ds64);
            int f3 = com.baidu.adp.lib.util.k.f(getContext(), d.f.ds32);
            int f4 = com.baidu.adp.lib.util.k.f(getContext(), d.f.ds4);
            a(this.cwX, f2, f3, f4);
            a(this.cwY, f2, f3, f4);
            a(this.cwZ, f2, f3, f4);
            ajy();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.aG(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void jo(int i) {
        ajy();
        this.cwX.onChangeSkinType(i);
        this.cwY.onChangeSkinType(i);
        this.cwZ.onChangeSkinType(i);
    }

    private void ajy() {
        this.cwX.setGrade(aj.getDrawable(d.g.pic_grade_vote_num1));
        this.cwY.setGrade(aj.getDrawable(d.g.pic_grade_vote_num2));
        this.cwZ.setGrade(aj.getDrawable(d.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void L(bj bjVar) {
        if (bjVar != null && bjVar.rp() != null) {
            List<PollOption> list = bjVar.rp().options;
            if (!com.baidu.tbadk.core.h.oS().oY() || v.v(list)) {
                this.cwW.setVisibility(8);
                return;
            }
            this.cwW.setVisibility(0);
            this.cwX.setVisibility(0);
            this.cwY.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cwZ.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cwX.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bjVar.rp().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cwY.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bjVar.rp().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cwZ.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bjVar.rp().total_poll.longValue());
            }
        }
    }
}
