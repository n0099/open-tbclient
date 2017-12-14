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
    private FrsPicVoteLayout cPi;
    private FrsPicVotePhotoFrame cPj;
    private FrsPicVotePhotoFrame cPk;
    private FrsPicVotePhotoFrame cPl;

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
            this.cPi = (FrsPicVoteLayout) findViewById;
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20);
            if (this.cPi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cPi.getLayoutParams()).topMargin = f;
            }
            if (this.cPC.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cPC.getLayoutParams()).topMargin = f;
            }
            this.cPj = (FrsPicVotePhotoFrame) this.cPi.findViewById(d.g.frs_pic_vote_photoframe_1);
            this.cPk = (FrsPicVotePhotoFrame) this.cPi.findViewById(d.g.frs_pic_vote_photoframe_2);
            this.cPl = (FrsPicVotePhotoFrame) this.cPi.findViewById(d.g.frs_pic_vote_photoframe_3);
            this.cPj.setPageId(getTag());
            this.cPk.setPageId(getTag());
            this.cPl.setPageId(getTag());
            int f2 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds64);
            int f3 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
            int f4 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds4);
            a(this.cPj, f2, f3, f4);
            a(this.cPk, f2, f3, f4);
            a(this.cPl, f2, f3, f4);
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
        this.cPj.onChangeSkinType(i);
        this.cPk.onChangeSkinType(i);
        this.cPl.onChangeSkinType(i);
    }

    private void aod() {
        this.cPj.setGrade(aj.getDrawable(d.f.pic_grade_vote_num1));
        this.cPk.setGrade(aj.getDrawable(d.f.pic_grade_vote_num2));
        this.cPl.setGrade(aj.getDrawable(d.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void L(bd bdVar) {
        if (bdVar != null && bdVar.rh() != null) {
            List<PollOption> list = bdVar.rh().options;
            if (!com.baidu.tbadk.core.h.oY().pe() || v.w(list)) {
                this.cPi.setVisibility(8);
                return;
            }
            this.cPi.setVisibility(0);
            this.cPj.setVisibility(0);
            this.cPk.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cPl.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cPj.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bdVar.rh().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cPk.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bdVar.rh().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cPl.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bdVar.rh().total_poll.longValue());
            }
        }
    }
}
