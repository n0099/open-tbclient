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
    private FrsPicVoteLayout cwe;
    private FrsPicVotePhotoFrame cwf;
    private FrsPicVotePhotoFrame cwg;
    private FrsPicVotePhotoFrame cwh;

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
            this.cwe = (FrsPicVoteLayout) findViewById;
            int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20);
            if (this.cwe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cwe.getLayoutParams()).topMargin = g;
            }
            if (this.cwy.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cwy.getLayoutParams()).topMargin = g;
            }
            this.cwf = (FrsPicVotePhotoFrame) this.cwe.findViewById(d.h.frs_pic_vote_photoframe_1);
            this.cwg = (FrsPicVotePhotoFrame) this.cwe.findViewById(d.h.frs_pic_vote_photoframe_2);
            this.cwh = (FrsPicVotePhotoFrame) this.cwe.findViewById(d.h.frs_pic_vote_photoframe_3);
            this.cwf.setPageId(getTag());
            this.cwg.setPageId(getTag());
            this.cwh.setPageId(getTag());
            int g2 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds64);
            int g3 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds32);
            int g4 = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds4);
            a(this.cwf, g2, g3, g4);
            a(this.cwg, g2, g3, g4);
            a(this.cwh, g2, g3, g4);
            ajn();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.aC(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void jm(int i) {
        ajn();
        this.cwf.onChangeSkinType(i);
        this.cwg.onChangeSkinType(i);
        this.cwh.onChangeSkinType(i);
    }

    private void ajn() {
        this.cwf.setGrade(aj.getDrawable(d.g.pic_grade_vote_num1));
        this.cwg.setGrade(aj.getDrawable(d.g.pic_grade_vote_num2));
        this.cwh.setGrade(aj.getDrawable(d.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void L(bj bjVar) {
        if (bjVar != null && bjVar.rp() != null) {
            List<PollOption> list = bjVar.rp().options;
            if (!com.baidu.tbadk.core.h.oS().oY() || v.v(list)) {
                this.cwe.setVisibility(8);
                return;
            }
            this.cwe.setVisibility(0);
            this.cwf.setVisibility(0);
            this.cwg.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cwh.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cwf.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bjVar.rp().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cwg.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bjVar.rp().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cwh.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bjVar.rp().total_poll.longValue());
            }
        }
    }
}
