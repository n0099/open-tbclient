package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class f extends i {
    private FrsPicVoteLayout cxM;
    private FrsPicVotePhotoFrame cxN;
    private FrsPicVotePhotoFrame cxO;
    private FrsPicVotePhotoFrame cxP;

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
            this.cxM = (FrsPicVoteLayout) findViewById;
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds20);
            if (this.cxM.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cxM.getLayoutParams()).topMargin = f;
            }
            if (this.cyg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cyg.getLayoutParams()).topMargin = f;
            }
            this.cxN = (FrsPicVotePhotoFrame) this.cxM.findViewById(d.h.frs_pic_vote_photoframe_1);
            this.cxO = (FrsPicVotePhotoFrame) this.cxM.findViewById(d.h.frs_pic_vote_photoframe_2);
            this.cxP = (FrsPicVotePhotoFrame) this.cxM.findViewById(d.h.frs_pic_vote_photoframe_3);
            this.cxN.setPageId(getTag());
            this.cxO.setPageId(getTag());
            this.cxP.setPageId(getTag());
            int f2 = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds64);
            int f3 = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds32);
            int f4 = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds4);
            a(this.cxN, f2, f3, f4);
            a(this.cxO, f2, f3, f4);
            a(this.cxP, f2, f3, f4);
            ajD();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.aL(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void jx(int i) {
        ajD();
        this.cxN.onChangeSkinType(i);
        this.cxO.onChangeSkinType(i);
        this.cxP.onChangeSkinType(i);
    }

    private void ajD() {
        this.cxN.setGrade(aj.getDrawable(d.g.pic_grade_vote_num1));
        this.cxO.setGrade(aj.getDrawable(d.g.pic_grade_vote_num2));
        this.cxP.setGrade(aj.getDrawable(d.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void G(bh bhVar) {
        if (bhVar != null && bhVar.rj() != null) {
            List<PollOption> list = bhVar.rj().options;
            if (!com.baidu.tbadk.core.h.oT().oZ() || v.u(list)) {
                this.cxM.setVisibility(8);
                return;
            }
            this.cxM.setVisibility(0);
            this.cxN.setVisibility(0);
            this.cxO.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cxP.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cxN.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bhVar.rj().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cxO.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bhVar.rj().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cxP.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bhVar.rj().total_poll.longValue());
            }
        }
    }
}
