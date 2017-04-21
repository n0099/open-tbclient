package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.a<h> {
    private View.OnClickListener ama;
    private View.OnClickListener amx;
    private TextView bcA;
    private TbImageView bcr;
    private TextView bcs;
    private RelativeLayout bct;
    private FrameLayout bcw;
    private View bcx;
    private TextView bcz;
    private ThreadLiveAndRecordUserInfoLayout cvT;
    private h cvW;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amx = new j(this);
        this.ama = new k(this);
        initView();
    }

    private void initView() {
        this.bct = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bct.getLayoutParams();
        layoutParams.height = (int) (com.baidu.adp.lib.util.k.af(this.mContext) * 0.5625f);
        this.bct.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bcw = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bcr = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bcr.setDefaultErrorResource(0);
        this.bcr.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bcs = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.cvT = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.cvT.setForumAfterClickListener(this.ama);
        this.cvT.setUserAfterClickListener(this.amx);
        this.cvT.setBarNameClickEnabled(true);
        this.bcx = getView().findViewById(w.h.dividerBottom);
        this.bcz = (TextView) getView().findViewById(w.h.tvRecordThreadCreateTime);
        this.bcA = (TextView) getView().findViewById(w.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cvT == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(h hVar) {
        if (hVar != null && hVar.bck != null && hVar.bck.sF() != null) {
            this.cvW = hVar;
            l(this.cvW.bck);
            this.bcr.c(hVar.bck.sF().thumbnail_url, 10, false);
            this.bcz.setText(au.q(hVar.bck.getCreateTime()));
            this.bcA.setText(StringUtils.translateSecondsToString(hVar.bck.sF().video_duration.intValue()));
            this.cvT.k(hVar.bck);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void l(bi biVar) {
        String str = "";
        if (biVar.getAuthor() != null) {
            str = biVar.getAuthor().getName_show();
        }
        String title = biVar.getTitle();
        this.bcs.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(w.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.bct, w.g.addresslist_item_bg);
            aq.i(this.bcs, w.e.cp_cont_i);
            aq.j(this.bcx, w.g.addresslist_item_bg);
            this.cvT.onChangeSkinType(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (com.baidu.adp.lib.util.i.hk()) {
                l(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.E(this.mContext, this.mContext.getString(w.l.neterror));
            }
        }
    }

    private void l(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cvW != null && this.cvW.bck != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.cvW.bck, null, "", 0, true, false, false)));
        }
    }
}
