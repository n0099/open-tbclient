package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.r;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ak extends as {
    private FrsPicVoteLayout bMD;
    private FrsPicVotePhotoFrame bME;
    private FrsPicVotePhotoFrame bMF;
    private FrsPicVotePhotoFrame bMG;

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(r.h.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(r.h.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bMD = (FrsPicVoteLayout) findViewById;
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.f.ds20);
            if (this.bMD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bMD.getLayoutParams()).topMargin = e;
            }
            if (this.bMQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bMQ.getLayoutParams()).topMargin = e;
            }
            this.bME = (FrsPicVotePhotoFrame) this.bMD.findViewById(r.h.frs_pic_vote_photoframe_1);
            this.bMF = (FrsPicVotePhotoFrame) this.bMD.findViewById(r.h.frs_pic_vote_photoframe_2);
            this.bMG = (FrsPicVotePhotoFrame) this.bMD.findViewById(r.h.frs_pic_vote_photoframe_3);
            int e2 = com.baidu.adp.lib.util.k.e(getContext(), r.f.ds64);
            int e3 = com.baidu.adp.lib.util.k.e(getContext(), r.f.ds32);
            int e4 = com.baidu.adp.lib.util.k.e(getContext(), r.f.ds4);
            a(this.bME, e2, e3, e4);
            a(this.bMF, e2, e3, e4);
            a(this.bMG, e2, e3, e4);
            aax();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.ak(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void ih(int i) {
        aax();
        this.bME.onChangeSkinType(i);
        this.bMF.onChangeSkinType(i);
        this.bMG.onChangeSkinType(i);
    }

    private void aax() {
        this.bME.setGrade(com.baidu.tbadk.core.util.ap.getDrawable(r.g.pic_grade_vote_num1));
        this.bMF.setGrade(com.baidu.tbadk.core.util.ap.getDrawable(r.g.pic_grade_vote_num2));
        this.bMG.setGrade(com.baidu.tbadk.core.util.ap.getDrawable(r.g.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void t(bh bhVar) {
        if (bhVar != null && bhVar.rm() != null) {
            List<PollOption> list = bhVar.rm().options;
            if (!com.baidu.tbadk.core.l.oC().oI() || com.baidu.tbadk.core.util.w.s(list)) {
                this.bMD.setVisibility(8);
                return;
            }
            this.bMD.setVisibility(0);
            this.bME.setVisibility(0);
            this.bMF.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bMG.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bME.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bhVar.rm().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bMF.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bhVar.rm().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bMG.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bhVar.rm().total_poll.longValue());
            }
        }
    }
}
