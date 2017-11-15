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
    private FrsPicVoteLayout cFM;
    private FrsPicVotePhotoFrame cFN;
    private FrsPicVotePhotoFrame cFO;
    private FrsPicVotePhotoFrame cFP;

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
            this.cFM = (FrsPicVoteLayout) findViewById;
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20);
            if (this.cFM.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cFM.getLayoutParams()).topMargin = f;
            }
            if (this.cGg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cGg.getLayoutParams()).topMargin = f;
            }
            this.cFN = (FrsPicVotePhotoFrame) this.cFM.findViewById(d.g.frs_pic_vote_photoframe_1);
            this.cFO = (FrsPicVotePhotoFrame) this.cFM.findViewById(d.g.frs_pic_vote_photoframe_2);
            this.cFP = (FrsPicVotePhotoFrame) this.cFM.findViewById(d.g.frs_pic_vote_photoframe_3);
            this.cFN.setPageId(getTag());
            this.cFO.setPageId(getTag());
            this.cFP.setPageId(getTag());
            int f2 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds64);
            int f3 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
            int f4 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds4);
            a(this.cFN, f2, f3, f4);
            a(this.cFO, f2, f3, f4);
            a(this.cFP, f2, f3, f4);
            alZ();
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
    protected void jN(int i) {
        alZ();
        this.cFN.onChangeSkinType(i);
        this.cFO.onChangeSkinType(i);
        this.cFP.onChangeSkinType(i);
    }

    private void alZ() {
        this.cFN.setGrade(aj.getDrawable(d.f.pic_grade_vote_num1));
        this.cFO.setGrade(aj.getDrawable(d.f.pic_grade_vote_num2));
        this.cFP.setGrade(aj.getDrawable(d.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void H(bh bhVar) {
        if (bhVar != null && bhVar.rf() != null) {
            List<PollOption> list = bhVar.rf().options;
            if (!com.baidu.tbadk.core.h.oT().oZ() || v.v(list)) {
                this.cFM.setVisibility(8);
                return;
            }
            this.cFM.setVisibility(0);
            this.cFN.setVisibility(0);
            this.cFO.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cFP.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cFN.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bhVar.rf().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cFO.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bhVar.rf().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cFP.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bhVar.rf().total_poll.longValue());
            }
        }
    }
}
