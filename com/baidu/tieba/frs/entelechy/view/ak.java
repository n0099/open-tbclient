package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.r;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ak extends as {
    private FrsPicVoteLayout bGo;
    private FrsPicVotePhotoFrame bGp;
    private FrsPicVotePhotoFrame bGq;
    private FrsPicVotePhotoFrame bGr;

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(r.g.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(r.g.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bGo = (FrsPicVoteLayout) findViewById;
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20);
            if (this.bGo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bGo.getLayoutParams()).topMargin = e;
            }
            if (this.bGB.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bGB.getLayoutParams()).topMargin = e;
            }
            this.bGp = (FrsPicVotePhotoFrame) this.bGo.findViewById(r.g.frs_pic_vote_photoframe_1);
            this.bGq = (FrsPicVotePhotoFrame) this.bGo.findViewById(r.g.frs_pic_vote_photoframe_2);
            this.bGr = (FrsPicVotePhotoFrame) this.bGo.findViewById(r.g.frs_pic_vote_photoframe_3);
            int e2 = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds64);
            int e3 = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds32);
            int e4 = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds4);
            a(this.bGp, e2, e3, e4);
            a(this.bGq, e2, e3, e4);
            a(this.bGr, e2, e3, e4);
            Zu();
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
    protected void hu(int i) {
        Zu();
        this.bGp.onChangeSkinType(i);
        this.bGq.onChangeSkinType(i);
        this.bGr.onChangeSkinType(i);
    }

    private void Zu() {
        this.bGp.setGrade(com.baidu.tbadk.core.util.ar.getDrawable(r.f.pic_grade_vote_num1));
        this.bGq.setGrade(com.baidu.tbadk.core.util.ar.getDrawable(r.f.pic_grade_vote_num2));
        this.bGr.setGrade(com.baidu.tbadk.core.util.ar.getDrawable(r.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void q(bg bgVar) {
        if (bgVar != null && bgVar.ru() != null) {
            List<PollOption> list = bgVar.ru().options;
            if (!com.baidu.tbadk.core.l.oJ().oP() || com.baidu.tbadk.core.util.x.t(list)) {
                this.bGo.setVisibility(8);
                return;
            }
            this.bGo.setVisibility(0);
            this.bGp.setVisibility(0);
            this.bGq.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bGr.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bGp.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bgVar.ru().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bGq.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bgVar.ru().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bGr.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bgVar.ru().total_poll.longValue());
            }
        }
    }
}
