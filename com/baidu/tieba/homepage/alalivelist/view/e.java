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
    private View.OnClickListener aoH;
    private View.OnClickListener aoX;
    private TbImageView bgo;
    private TextView bgp;
    private RelativeLayout bgq;
    private FrameLayout bgu;
    private View bgv;
    private TextView bgx;
    private TextView bgy;
    private ThreadLiveAndRecordUserInfoLayout cRw;
    private d cRz;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Wx() != null) {
                    e.this.Wx().a(view, e.this.cRz);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Wx() != null) {
                    e.this.Wx().a(view, e.this.cRz);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bgq = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bgq.getLayoutParams();
        layoutParams.height = (int) (k.ag(this.mContext) * 0.5625f);
        this.bgq.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bgu = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bgo = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bgo.setDefaultErrorResource(0);
        this.bgo.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bgp = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cRw = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cRw.setForumAfterClickListener(this.aoH);
        this.cRw.setUserAfterClickListener(this.aoX);
        this.cRw.setBarNameClickEnabled(true);
        this.bgv = getView().findViewById(d.h.dividerBottom);
        this.bgx = (TextView) getView().findViewById(d.h.tvRecordThreadCreateTime);
        this.bgy = (TextView) getView().findViewById(d.h.tvRecordThreadDuration);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_record_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cRw == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(d dVar) {
        if (dVar != null && dVar.bcN != null && dVar.bcN.rX() != null) {
            this.cRz = dVar;
            w(this.cRz.bcN);
            this.bgo.c(dVar.bcN.rX().thumbnail_url, 10, false);
            this.bgx.setText(al.r(dVar.bcN.getCreateTime()));
            this.bgy.setText(StringUtils.translateSecondsToString(dVar.bcN.rX().video_duration.intValue()));
            this.cRw.x(dVar.bcN);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void w(bl blVar) {
        String str = "";
        if (blVar.getAuthor() != null) {
            str = blVar.getAuthor().getName_show();
        }
        String title = blVar.getTitle();
        this.bgp.setText(StringUtils.isNull(title) ? this.mContext.getResources().getString(d.l.recommend_ala_record_title, str) : title);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bgq, d.g.addresslist_item_bg);
            ai.i(this.bgp, d.e.cp_cont_i);
            ai.j(this.bgv, d.g.addresslist_item_bg);
            this.cRw.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (i.hr()) {
                j(this.mTbPageContext);
            } else {
                k.F(this.mContext, this.mContext.getString(d.l.neterror));
            }
        }
    }

    private void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cRz != null && this.cRz.bcN != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createFromThreadCfg(this.cRz.bcN, null, "", 0, true, false, false)));
        }
    }
}
