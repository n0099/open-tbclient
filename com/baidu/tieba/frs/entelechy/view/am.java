package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.r;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class am extends ao {
    private FrsPicVoteLayout caO;
    private FrsPicVotePhotoFrame caP;
    private FrsPicVotePhotoFrame caQ;
    private FrsPicVotePhotoFrame caR;

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(r.g.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(r.g.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.caO = (FrsPicVoteLayout) findViewById;
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20);
            if (this.caO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.caO.getLayoutParams()).topMargin = e;
            }
            if (this.caU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.caU.getLayoutParams()).topMargin = e;
            }
            this.caP = (FrsPicVotePhotoFrame) this.caO.findViewById(r.g.frs_pic_vote_photoframe_1);
            this.caQ = (FrsPicVotePhotoFrame) this.caO.findViewById(r.g.frs_pic_vote_photoframe_2);
            this.caR = (FrsPicVotePhotoFrame) this.caO.findViewById(r.g.frs_pic_vote_photoframe_3);
            int e2 = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds64);
            int e3 = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds32);
            int e4 = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds4);
            a(this.caP, e2, e3, e4);
            a(this.caQ, e2, e3, e4);
            a(this.caR, e2, e3, e4);
            aeZ();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.ap(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void ik(int i) {
        aeZ();
        this.caP.onChangeSkinType(i);
        this.caQ.onChangeSkinType(i);
        this.caR.onChangeSkinType(i);
    }

    private void aeZ() {
        this.caP.setGrade(com.baidu.tbadk.core.util.at.getDrawable(r.f.pic_grade_vote_num1));
        this.caQ.setGrade(com.baidu.tbadk.core.util.at.getDrawable(r.f.pic_grade_vote_num2));
        this.caR.setGrade(com.baidu.tbadk.core.util.at.getDrawable(r.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void l(bk bkVar) {
        if (bkVar != null && bkVar.rG() != null) {
            List<PollOption> list = bkVar.rG().options;
            if (!com.baidu.tbadk.core.l.oJ().oP() || com.baidu.tbadk.core.util.x.t(list)) {
                this.caO.setVisibility(8);
                return;
            }
            this.caO.setVisibility(0);
            this.caP.setVisibility(0);
            this.caQ.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.caR.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.caP.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bkVar.rG().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.caQ.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bkVar.rG().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.caR.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bkVar.rG().total_poll.longValue());
            }
        }
    }
}
