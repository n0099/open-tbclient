package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class n extends a<com.baidu.tieba.card.data.l> {
    private boolean ajf;
    private String aod;
    private final View.OnClickListener aoe;
    private final View.OnClickListener aow;
    private HeadPendantClickableView bJq;
    private ThreadGodReplyLayout bJr;
    private View bJs;
    private com.baidu.tbadk.core.view.h bJt;
    private View bJu;
    private com.baidu.tieba.card.data.l bJv;
    private View.OnClickListener bJw;
    private View.OnClickListener bKo;
    public PlayVoiceBntNew bLe;
    private TextView bLf;
    private ConstrainImageGroup bLg;
    private final View.OnClickListener bLh;
    protected LinearLayout blD;
    public ThreadUserInfoLayout blv;
    public ThreadCommentAndPraiseInfoLayout blz;
    private TbPageContext<?> mF;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJt = null;
        this.mSkinType = 3;
        this.ajf = true;
        this.bJw = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.XA() != null) {
                    n.this.XA().a(view, n.this.bJv);
                }
                n.this.dH(view == n.this.bJr);
            }
        };
        this.bLh = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> XA = n.this.XA();
                if (XA != null) {
                    view.setTag("2");
                    XA.a(view, n.this.bJv);
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.XA() != null) {
                    n.this.XA().a(view, n.this.bJv);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.XA() != null) {
                    n.this.XA().a(view, n.this.bJv);
                }
            }
        };
        this.bKo = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.bJv != null && !StringUtils.isNull(n.this.bJv.threadData.rG())) {
                    String rG = n.this.bJv.threadData.rG();
                    if (!StringUtils.isNull(n.this.mStType) && !StringUtils.isNull(n.this.aod)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createCfgForpersonalized(rG, n.this.mStType, n.this.aod)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(rG, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                    if (n.this.aoe != null) {
                        n.this.aoe.onClick(view);
                    }
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.bJq = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bJq.getHeadView() != null) {
            this.bJq.getHeadView().setIsRound(true);
            this.bJq.getHeadView().setDrawBorder(false);
            this.bJq.getHeadView().setDefaultResource(17170445);
            this.bJq.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJq.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJq.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds70));
        }
        this.bJq.wB();
        if (this.bJq.getPendantView() != null) {
            this.bJq.getPendantView().setIsRound(true);
            this.bJq.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLe = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLe.setAfterClickListener(this.bLh);
        this.bLf = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLf.setVisibility(8);
        this.bLg = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bJu = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bLg.setChildClickListener(this.bJw);
        this.bLg.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLg.setImageProcessor(fVar);
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.blv = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bJs = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bJt = new com.baidu.tbadk.core.view.h(this.mF);
        this.bJt.wI();
        this.bJt.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.blv.addView(this.bJt);
        if (this.blz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.blz.setLayoutParams(layoutParams);
        }
        this.blz.setOnClickListener(this.bJw);
        this.blz.setReplyTimeVisible(false);
        this.blz.setShowPraiseNum(true);
        this.blz.setNeedAddPraiseIcon(true);
        this.blz.setNeedAddReplyIcon(true);
        this.blz.setShareVisible(true);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blz.setFrom(1);
        this.blz.setShareReportFrom(3);
        this.blz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.XA() != null) {
                    n.this.XA().a(view2, n.this.bJv);
                }
            }
        });
        this.blD = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.bJr = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bJr.setOnClickListener(this.bJw);
    }

    public void setSingleImageRatio(double d) {
        if (this.bLg != null) {
            this.bLg.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLg != null) {
            this.bLg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLg != null) {
            this.bLg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bLg.onChangeSkinType();
            this.blz.onChangeSkinType();
            this.bJr.onChangeSkinType();
            this.blv.onChangeSkinType();
            if (this.bJt != null) {
                this.bJt.onChangeSkinType();
            }
            aj.k(this.bJu, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        boolean z;
        boolean z2 = true;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bJv = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJw);
        }
        if (this.bJt != null && this.bJv.MR() != null) {
            an anVar = new an();
            anVar.cy(this.bJv.MR().getTid());
            anVar.setFid(this.bJv.MR().getFid());
            anVar.a(this.bJv.Xf);
            this.bJt.setData(anVar);
            this.bJt.setFirstRowSingleColumn(true);
        }
        this.blv.c(lVar.threadData);
        this.bJr.setFromCDN(this.ajf);
        this.bJr.setData(lVar.threadData.sR());
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        this.bJr.onChangeSkinType();
        if (lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bJt.setVisibility(8);
            } else {
                this.bJt.setVisibility(0);
            }
        }
        if (!XE() && m.jt(this.bJv.threadData.getId())) {
            m.a(this.mTitle, this.bJv.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLf, this.bJv.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJr.getGodReplyContent(), this.bJv.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJr.getPraiseNum(), this.bJv.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.blv.setUserAfterClickListener(this.aow);
        this.blz.c(lVar.threadData);
        this.bJs.setVisibility(0);
        this.mStType = m.rs();
        this.aod = "feed#" + lVar.Yb();
        final bj MR = lVar.MR();
        if (this.blv.getHeaderImg() != null) {
            if (this.blv.getIsSimpleThread()) {
                this.blv.getHeaderImg().setVisibility(8);
                this.bJq.setVisibility(8);
            } else if (MR.getAuthor() == null || MR.getAuthor().getPendantData() == null || StringUtils.isNull(MR.getAuthor().getPendantData().pR())) {
                this.bJq.setVisibility(8);
                this.blv.getHeaderImg().setVisibility(0);
                this.blv.getHeaderImg().setData(MR);
            } else {
                this.blv.getHeaderImg().setVisibility(4);
                this.bJq.setVisibility(0);
                this.bJq.setData(MR);
            }
        }
        boolean D = D(MR);
        ArrayList<VoiceData.VoiceModel> rP = lVar.threadData.rP();
        if (com.baidu.tbadk.core.util.v.v(rP)) {
            this.bLe.setVisibility(8);
            z = false;
        } else {
            this.bLe.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rP.get(0);
            this.bLe.setVoiceModel(voiceModel);
            this.bLe.setTag(voiceModel);
            this.bLe.bhr();
            if (voiceModel != null) {
                this.bLe.nj(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bJv.bNk && z) {
            this.bLg.setVisibility(8);
            z2 = false;
        } else {
            ArrayList<MediaData> rL = MR.rL();
            if (com.baidu.tbadk.core.h.oS().oY() && com.baidu.tbadk.core.util.v.u(rL) != 0) {
                LinkedList linkedList = new LinkedList();
                final LinkedList linkedList2 = new LinkedList();
                for (int i = 0; i < rL.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rL, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData.getThumbnails_url());
                        linkedList2.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.u(linkedList) > 0) {
                    this.bLg.setVisibility(0);
                    this.bLg.setFromCDN(this.ajf);
                    this.bLg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z3) {
                            x<com.baidu.tieba.card.data.l> XA = n.this.XA();
                            if (XA != null) {
                                view.setTag("1");
                                XA.a(view, n.this.bJv);
                            }
                            if (z3) {
                                n.this.XR();
                            } else {
                                n.this.a(linkedList2, i2, MR);
                            }
                        }
                    });
                    this.bLg.setImageUrls(linkedList);
                } else {
                    this.bLg.setVisibility(8);
                }
            } else {
                this.bLg.setVisibility(8);
            }
            z2 = false;
        }
        XQ();
        h(D, false, z2);
        setPageUniqueId(getTag());
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLf.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bLg.getLayoutParams();
        if (!z && z2) {
            layoutParams.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2);
            } else if (z) {
                layoutParams2.topMargin = 0;
            }
        } else if (z2) {
            layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds13);
        } else if (z) {
            layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.mF.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajf ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bjVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mF.getPageActivity()).createConfig(arrayList, i, bjVar.rG(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.ajf, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void XQ() {
        if (!this.bJv.aCJ) {
            this.bLe.setClickable(false);
        } else {
            this.bLe.setClickable(true);
        }
        int childCount = this.bLg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLg.getChildAt(i);
            if (childAt != null) {
                if (!this.bJv.aCJ) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajf = z;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bLg != null) {
            this.bLg.setPageUniqueId(bdUniqueId);
        }
        if (this.bJt != null) {
            this.bJt.setUniqueId(bdUniqueId);
        }
        if (this.blv != null) {
            this.blv.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(h.a aVar) {
        if (this.bJt != null) {
            this.bJt.setEventCallback(aVar);
        }
    }

    public View XC() {
        return this.bJr;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.blv != null) {
            return this.blv.aor;
        }
        return null;
    }

    public View XD() {
        if (this.blv != null) {
            return this.blv.aos;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XR() {
        dH(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(boolean z) {
        if (this.bJv != null && this.bJv.threadData != null) {
            if (!XE()) {
                m.js(this.bJv.threadData.getId());
                m.a(this.mTitle, this.bJv.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bLf, this.bJv.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bJr.getGodReplyContent(), this.bJv.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bJr.getPraiseNum(), this.bJv.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.bJv.threadData, null, m.rs(), 18003, true, false, false).addLocateParam(this.bJv.Yc());
            addLocateParam.setForumId(String.valueOf(this.bJv.threadData.getFid()));
            addLocateParam.setForumName(this.bJv.threadData.rG());
            if (this.bJv.bMS == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bJv.bMS);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XE() {
        return this.bJv.bNk && !this.bJv.aCJ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean D(bj bjVar) {
        SpannableStringBuilder g = bjVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(g));
            this.mTitle.setText(g);
            m.a(this.mTitle, bjVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        return true;
    }
}
