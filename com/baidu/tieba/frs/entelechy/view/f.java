package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class f extends i {
    private FrsPicVoteLayout cPm;
    private FrsPicVotePhotoFrame cPn;
    private FrsPicVotePhotoFrame cPo;
    private FrsPicVotePhotoFrame cPp;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(d.g.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(d.g.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.cPm = (FrsPicVoteLayout) findViewById;
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20);
            if (this.cPm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cPm.getLayoutParams()).topMargin = f;
            }
            if (this.cPG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cPG.getLayoutParams()).topMargin = f;
            }
            this.cPn = (FrsPicVotePhotoFrame) this.cPm.findViewById(d.g.frs_pic_vote_photoframe_1);
            this.cPo = (FrsPicVotePhotoFrame) this.cPm.findViewById(d.g.frs_pic_vote_photoframe_2);
            this.cPp = (FrsPicVotePhotoFrame) this.cPm.findViewById(d.g.frs_pic_vote_photoframe_3);
            this.cPn.setPageId(getTag());
            this.cPo.setPageId(getTag());
            this.cPp.setPageId(getTag());
            int f2 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds64);
            int f3 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
            int f4 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds4);
            a(this.cPn, f2, f3, f4);
            a(this.cPo, f2, f3, f4);
            a(this.cPp, f2, f3, f4);
            aod();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.aN(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void kn(int i) {
        aod();
        this.cPn.onChangeSkinType(i);
        this.cPo.onChangeSkinType(i);
        this.cPp.onChangeSkinType(i);
    }

    private void aod() {
        this.cPn.setGrade(aj.getDrawable(d.f.pic_grade_vote_num1));
        this.cPo.setGrade(aj.getDrawable(d.f.pic_grade_vote_num2));
        this.cPp.setGrade(aj.getDrawable(d.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void L(bd bdVar) {
        if (bdVar != null && bdVar.rh() != null) {
            List<PollOption> list = bdVar.rh().options;
            if (!com.baidu.tbadk.core.h.oY().pe() || v.w(list)) {
                this.cPm.setVisibility(8);
                return;
            }
            this.cPm.setVisibility(0);
            this.cPn.setVisibility(0);
            this.cPo.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cPp.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cPn.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bdVar.rh().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cPo.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bdVar.rh().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cPp.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bdVar.rh().total_poll.longValue());
            }
        }
    }
}
