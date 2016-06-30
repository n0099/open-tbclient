package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.u;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ai extends ak {
    private FrsPicVoteLayout bKB;
    private FrsPicVotePhotoFrame bKC;
    private FrsPicVotePhotoFrame bKD;
    private FrsPicVotePhotoFrame bKE;

    public ai(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ak
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(u.g.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(u.g.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bKB = (FrsPicVoteLayout) findViewById;
            int c = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds20);
            if (this.bKB.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bKB.getLayoutParams()).topMargin = c;
            }
            if (this.bKH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bKH.getLayoutParams()).topMargin = c;
            }
            this.bKC = (FrsPicVotePhotoFrame) this.bKB.findViewById(u.g.frs_pic_vote_photoframe_1);
            this.bKD = (FrsPicVotePhotoFrame) this.bKB.findViewById(u.g.frs_pic_vote_photoframe_2);
            this.bKE = (FrsPicVotePhotoFrame) this.bKB.findViewById(u.g.frs_pic_vote_photoframe_3);
            int c2 = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds64);
            int c3 = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds32);
            int c4 = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds4);
            a(this.bKC, c2, c3, c4);
            a(this.bKD, c2, c3, c4);
            a(this.bKE, c2, c3, c4);
            Ym();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.ah(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ak
    protected void hD(int i) {
        Ym();
        this.bKC.onChangeSkinType(i);
        this.bKD.onChangeSkinType(i);
        this.bKE.onChangeSkinType(i);
    }

    private void Ym() {
        this.bKC.setGrade(av.getDrawable(u.f.pic_grade_vote_num1));
        this.bKD.setGrade(av.getDrawable(u.f.pic_grade_vote_num2));
        this.bKE.setGrade(av.getDrawable(u.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ak
    protected void j(az azVar) {
        if (azVar != null && azVar.qF() != null) {
            List<PollOption> list = azVar.qF().options;
            if (!com.baidu.tbadk.core.l.nW().oc() || com.baidu.tbadk.core.util.y.t(list)) {
                this.bKB.setVisibility(8);
                return;
            }
            this.bKB.setVisibility(0);
            this.bKC.setVisibility(0);
            this.bKD.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bKE.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bKC.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), azVar.qF().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bKD.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), azVar.qF().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bKE.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), azVar.qF().total_poll.longValue());
            }
        }
    }
}
