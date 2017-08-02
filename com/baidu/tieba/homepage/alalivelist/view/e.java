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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<d> {
    private View.OnClickListener anD;
    private View.OnClickListener ann;
    private TbImageView bfd;
    private TextView bfe;
    private RelativeLayout bff;
    private FrameLayout bfi;
    private View bfj;
    private TextView bfl;
    private TextView bfm;
    private ThreadLiveAndRecordUserInfoLayout cOe;
    private d cOh;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.VZ() != null) {
                    e.this.VZ().a(view, e.this.cOh);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.VZ() != null) {
                    e.this.VZ().a(view, e.this.cOh);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bff = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bff.getLayoutParams();
        layoutParams.height = (int) (k.af(this.mContext) * 0.5625f);
        this.bff.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bfi = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bfd = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bfd.setDefaultErrorResource(0);
        this.bfd.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bfe = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cOe = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cOe.setForumAfterClickListener(this.ann);
        this.cOe.setUserAfterClickListener(this.anD);
        this.cOe.setBarNameClickEnabled(true);
        this.bfj = getView().findViewById(d.h.dividerBottom);
        this.bfl = (TextView) getView().findViewById(d.h.tvRecordThreadCreateTime);
        this.bfm = (TextView) getView().findViewById(d.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cOe == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(d dVar) {
        if (dVar != null && dVar.bbB != null && dVar.bbB.rM() != null) {
            this.cOh = dVar;
            w(this.cOh.bbB);
            this.bfd.c(dVar.bbB.rM().thumbnail_url, 10, false);
            this.bfl.setText(al.r(dVar.bbB.getCreateTime()));
            this.bfm.setText(StringUtils.translateSecondsToString(dVar.bbB.rM().video_duration.intValue()));
            this.cOe.x(dVar.bbB);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void w(bl blVar) {
        String str = "";
        if (blVar.getAuthor() != null) {
            str = blVar.getAuthor().getName_show();
        }
        String title = blVar.getTitle();
        this.bfe.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(d.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bff, d.g.addresslist_item_bg);
            ai.i(this.bfe, d.e.cp_cont_i);
            ai.j(this.bfj, d.g.addresslist_item_bg);
            this.cOe.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (i.hh()) {
                j(this.mTbPageContext);
            } else {
                k.F(this.mContext, this.mContext.getString(d.l.neterror));
            }
        }
    }

    private void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cOh != null && this.cOh.bbB != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.cOh.bbB, null, "", 0, true, false, false)));
        }
    }
}
