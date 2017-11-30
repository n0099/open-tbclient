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
    private FrsPicVoteLayout cOX;
    private FrsPicVotePhotoFrame cOY;
    private FrsPicVotePhotoFrame cOZ;
    private FrsPicVotePhotoFrame cPa;

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
            this.cOX = (FrsPicVoteLayout) findViewById;
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20);
            if (this.cOX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cOX.getLayoutParams()).topMargin = f;
            }
            if (this.cPr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cPr.getLayoutParams()).topMargin = f;
            }
            this.cOY = (FrsPicVotePhotoFrame) this.cOX.findViewById(d.g.frs_pic_vote_photoframe_1);
            this.cOZ = (FrsPicVotePhotoFrame) this.cOX.findViewById(d.g.frs_pic_vote_photoframe_2);
            this.cPa = (FrsPicVotePhotoFrame) this.cOX.findViewById(d.g.frs_pic_vote_photoframe_3);
            this.cOY.setPageId(getTag());
            this.cOZ.setPageId(getTag());
            this.cPa.setPageId(getTag());
            int f2 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds64);
            int f3 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
            int f4 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds4);
            a(this.cOY, f2, f3, f4);
            a(this.cOZ, f2, f3, f4);
            a(this.cPa, f2, f3, f4);
            anU();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.aM(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void kl(int i) {
        anU();
        this.cOY.onChangeSkinType(i);
        this.cOZ.onChangeSkinType(i);
        this.cPa.onChangeSkinType(i);
    }

    private void anU() {
        this.cOY.setGrade(aj.getDrawable(d.f.pic_grade_vote_num1));
        this.cOZ.setGrade(aj.getDrawable(d.f.pic_grade_vote_num2));
        this.cPa.setGrade(aj.getDrawable(d.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void J(bd bdVar) {
        if (bdVar != null && bdVar.rj() != null) {
            List<PollOption> list = bdVar.rj().options;
            if (!com.baidu.tbadk.core.h.pa().pg() || v.w(list)) {
                this.cOX.setVisibility(8);
                return;
            }
            this.cOX.setVisibility(0);
            this.cOY.setVisibility(0);
            this.cOZ.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cPa.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cOY.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bdVar.rj().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cOZ.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bdVar.rj().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cPa.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bdVar.rj().total_poll.longValue());
            }
        }
    }
}
