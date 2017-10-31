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
    private FrsPicVoteLayout cFt;
    private FrsPicVotePhotoFrame cFu;
    private FrsPicVotePhotoFrame cFv;
    private FrsPicVotePhotoFrame cFw;

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
            this.cFt = (FrsPicVoteLayout) findViewById;
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20);
            if (this.cFt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cFt.getLayoutParams()).topMargin = f;
            }
            if (this.cFN.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.cFN.getLayoutParams()).topMargin = f;
            }
            this.cFu = (FrsPicVotePhotoFrame) this.cFt.findViewById(d.g.frs_pic_vote_photoframe_1);
            this.cFv = (FrsPicVotePhotoFrame) this.cFt.findViewById(d.g.frs_pic_vote_photoframe_2);
            this.cFw = (FrsPicVotePhotoFrame) this.cFt.findViewById(d.g.frs_pic_vote_photoframe_3);
            this.cFu.setPageId(getTag());
            this.cFv.setPageId(getTag());
            this.cFw.setPageId(getTag());
            int f2 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds64);
            int f3 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
            int f4 = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds4);
            a(this.cFu, f2, f3, f4);
            a(this.cFv, f2, f3, f4);
            a(this.cFw, f2, f3, f4);
            alL();
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
    protected void jO(int i) {
        alL();
        this.cFu.onChangeSkinType(i);
        this.cFv.onChangeSkinType(i);
        this.cFw.onChangeSkinType(i);
    }

    private void alL() {
        this.cFu.setGrade(aj.getDrawable(d.f.pic_grade_vote_num1));
        this.cFv.setGrade(aj.getDrawable(d.f.pic_grade_vote_num2));
        this.cFw.setGrade(aj.getDrawable(d.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void H(bh bhVar) {
        if (bhVar != null && bhVar.rf() != null) {
            List<PollOption> list = bhVar.rf().options;
            if (!com.baidu.tbadk.core.h.oT().oZ() || v.v(list)) {
                this.cFt.setVisibility(8);
                return;
            }
            this.cFt.setVisibility(0);
            this.cFu.setVisibility(0);
            this.cFv.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.cFw.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.cFu.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bhVar.rf().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.cFv.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bhVar.rf().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.cFw.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bhVar.rf().total_poll.longValue());
            }
        }
    }
}
