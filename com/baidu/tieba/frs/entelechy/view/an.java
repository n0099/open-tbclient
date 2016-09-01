package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.view.FrsPicVoteLayout;
import com.baidu.tieba.frs.view.FrsPicVotePhotoFrame;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class an extends ap {
    private FrsPicVoteLayout bXD;
    private FrsPicVotePhotoFrame bXE;
    private FrsPicVotePhotoFrame bXF;
    private FrsPicVotePhotoFrame bXG;

    public an(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(t.g.vote_img_layout);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(t.g.pic_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bXD = (FrsPicVoteLayout) findViewById;
            int e = com.baidu.adp.lib.util.k.e(getContext(), t.e.ds20);
            if (this.bXD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bXD.getLayoutParams()).topMargin = e;
            }
            if (this.bXK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.bXK.getLayoutParams()).topMargin = e;
            }
            this.bXE = (FrsPicVotePhotoFrame) this.bXD.findViewById(t.g.frs_pic_vote_photoframe_1);
            this.bXF = (FrsPicVotePhotoFrame) this.bXD.findViewById(t.g.frs_pic_vote_photoframe_2);
            this.bXG = (FrsPicVotePhotoFrame) this.bXD.findViewById(t.g.frs_pic_vote_photoframe_3);
            int e2 = com.baidu.adp.lib.util.k.e(getContext(), t.e.ds64);
            int e3 = com.baidu.adp.lib.util.k.e(getContext(), t.e.ds32);
            int e4 = com.baidu.adp.lib.util.k.e(getContext(), t.e.ds4);
            a(this.bXE, e2, e3, e4);
            a(this.bXF, e2, e3, e4);
            a(this.bXG, e2, e3, e4);
            ads();
        }
    }

    public void a(FrsPicVotePhotoFrame frsPicVotePhotoFrame, int i, int i2, int i3) {
        if (frsPicVotePhotoFrame != null) {
            frsPicVotePhotoFrame.an(i, i);
            frsPicVotePhotoFrame.setBlueHeight(i2);
            frsPicVotePhotoFrame.setGradeViewLeftMargin(i3);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    protected void ig(int i) {
        ads();
        this.bXE.onChangeSkinType(i);
        this.bXF.onChangeSkinType(i);
        this.bXG.onChangeSkinType(i);
    }

    private void ads() {
        this.bXE.setGrade(av.getDrawable(t.f.pic_grade_vote_num1));
        this.bXF.setGrade(av.getDrawable(t.f.pic_grade_vote_num2));
        this.bXG.setGrade(av.getDrawable(t.f.pic_grade_vote_num3));
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ap
    protected void l(bg bgVar) {
        if (bgVar != null && bgVar.rs() != null) {
            List<PollOption> list = bgVar.rs().options;
            if (!com.baidu.tbadk.core.l.oG().oM() || com.baidu.tbadk.core.util.y.t(list)) {
                this.bXD.setVisibility(8);
                return;
            }
            this.bXD.setVisibility(0);
            this.bXE.setVisibility(0);
            this.bXF.setVisibility(0);
            int size = list.size() >= 3 ? 3 : list.size();
            this.bXG.setVisibility(size == 3 ? 0 : 4);
            if (size >= 1) {
                PollOption pollOption = list.get(0);
                this.bXE.a(1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), bgVar.rs().total_poll.longValue());
            }
            if (size >= 2) {
                PollOption pollOption2 = list.get(1);
                this.bXF.a(1, pollOption2.image, Boolean.valueOf(this.mIsFromCDN), pollOption2.text, pollOption2.num.longValue(), bgVar.rs().total_poll.longValue());
            }
            if (size >= 3) {
                PollOption pollOption3 = list.get(2);
                this.bXG.a(1, pollOption3.image, Boolean.valueOf(this.mIsFromCDN), pollOption3.text, pollOption3.num.longValue(), bgVar.rs().total_poll.longValue());
            }
        }
    }
}
