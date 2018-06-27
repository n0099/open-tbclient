package com.baidu.tieba.frs.worldcup.videotopic.d;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bc> {
    private bc atZ;
    private ClickableHeaderImageView aye;
    private TextView ayf;
    private TextView bcI;
    private TbImageView bcJ;
    private ImageView bcK;
    private TextView dKt;
    private FrameLayout dKu;
    private RelativeLayout dKv;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.dKv = (RelativeLayout) view.findViewById(d.g.layout_person);
        this.dKv.setOnClickListener(this);
        this.aye = (ClickableHeaderImageView) view.findViewById(d.g.video_page_user_header);
        this.aye.setDefaultResource(17170445);
        this.aye.setDefaultResource(d.f.icon_default_avatar100);
        this.aye.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.aye.setIsRound(true);
        this.aye.setClickable(false);
        this.ayf = (TextView) view.findViewById(d.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dKu = (FrameLayout) view.findViewById(d.g.layout_video);
        this.dKu.setOnClickListener(this);
        this.bcJ = (TbImageView) view.findViewById(d.g.image_video);
        this.bcJ.setPageId(getTag());
        this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcJ.setGifIconSupport(false);
        this.bcK = (ImageView) view.findViewById(d.g.image_video_play);
        this.bcI = (TextView) view.findViewById(d.g.text_video_duration);
        this.dKt = (TextView) view.findViewById(d.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aj(view);
        if (this.atZ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.atZ));
        }
    }

    private void aj(View view) {
        if (aia() != null) {
            aia().a(view, this.atZ);
        }
        if (this.atZ != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.atZ, this.atZ.vB(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.atZ.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.video_topic_list_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: C */
    public void a(bc bcVar) {
        this.atZ = bcVar;
        if (this.atZ == null) {
            this.dKv.setVisibility(8);
            this.dKu.setVisibility(8);
            return;
        }
        this.dKv.setVisibility(0);
        this.dKu.setVisibility(0);
        aio();
        this.mTextTitle.setText(this.atZ.getTitle());
        if (this.atZ.vw() == null || this.atZ.vw().getPortrait() == null) {
            this.aye.setVisibility(8);
        } else {
            this.aye.setData(this.atZ, false);
            this.ayf.setText(ap.e(this.atZ.vw().getName_show(), 24, "..."));
            this.aye.setVisibility(0);
        }
        this.bcI.setText(ap.cY(this.atZ.vN().video_duration.intValue() * 1000));
        this.dKt.setText(String.format(this.mTbPageContext.getString(d.k.frs_comment_number), ap.A(this.atZ.vn())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aio() {
        if (this.bcJ != null && this.dKu != null) {
            if (this.atZ != null && this.atZ.vN() != null) {
                this.dKu.setVisibility(0);
                this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bcJ.startLoad(this.atZ.vN().thumbnail_url, 10, false);
                return;
            }
            this.dKu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.dKv, d.f.addresslist_item_bg);
            am.c(this.bcK, d.f.btn_icon_play_video_n);
            am.h(this.dKt, d.C0142d.cp_cont_f);
            am.h(this.bcI, d.C0142d.cp_cont_i);
            am.h(this.ayf, d.C0142d.cp_cont_f);
            am.h(this.mTextTitle, d.C0142d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aye.setPageId(bdUniqueId);
        }
    }
}
