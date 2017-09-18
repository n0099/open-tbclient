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
    private boolean aje;
    private String aob;
    private final View.OnClickListener aoc;
    private final View.OnClickListener aou;
    private HeadPendantClickableView bKh;
    private ThreadGodReplyLayout bKi;
    private View bKj;
    private com.baidu.tbadk.core.view.h bKk;
    private View bKl;
    private com.baidu.tieba.card.data.l bKm;
    private View.OnClickListener bKn;
    public PlayVoiceBntNew bLV;
    private TextView bLW;
    private ConstrainImageGroup bLX;
    private final View.OnClickListener bLY;
    private View.OnClickListener bLf;
    protected LinearLayout blC;
    public ThreadUserInfoLayout blu;
    public ThreadCommentAndPraiseInfoLayout bly;
    private TbPageContext<?> mF;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bKk = null;
        this.mSkinType = 3;
        this.aje = true;
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.XL() != null) {
                    n.this.XL().a(view, n.this.bKm);
                }
                n.this.dI(view == n.this.bKi);
            }
        };
        this.bLY = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> XL = n.this.XL();
                if (XL != null) {
                    view.setTag("2");
                    XL.a(view, n.this.bKm);
                }
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.XL() != null) {
                    n.this.XL().a(view, n.this.bKm);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.XL() != null) {
                    n.this.XL().a(view, n.this.bKm);
                }
            }
        };
        this.bLf = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.bKm != null && !StringUtils.isNull(n.this.bKm.threadData.rG())) {
                    String rG = n.this.bKm.threadData.rG();
                    if (!StringUtils.isNull(n.this.mStType) && !StringUtils.isNull(n.this.aob)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createCfgForpersonalized(rG, n.this.mStType, n.this.aob)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(rG, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                    if (n.this.aoc != null) {
                        n.this.aoc.onClick(view);
                    }
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.bKh = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bKh.getHeadView() != null) {
            this.bKh.getHeadView().setIsRound(true);
            this.bKh.getHeadView().setDrawBorder(false);
            this.bKh.getHeadView().setDefaultResource(17170445);
            this.bKh.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bKh.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bKh.getHeadView().setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds70));
        }
        this.bKh.wB();
        if (this.bKh.getPendantView() != null) {
            this.bKh.getPendantView().setIsRound(true);
            this.bKh.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLV = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLV.setAfterClickListener(this.bLY);
        this.bLW = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLW.setVisibility(8);
        this.bLX = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bKl = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bLX.setChildClickListener(this.bKn);
        this.bLX.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLX.setImageProcessor(fVar);
        this.bly = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.blu = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bKj = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bKk = new com.baidu.tbadk.core.view.h(this.mF);
        this.bKk.wI();
        this.bKk.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.blu.addView(this.bKk);
        if (this.bly.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bly.setLayoutParams(layoutParams);
        }
        this.bly.setOnClickListener(this.bKn);
        this.bly.setReplyTimeVisible(false);
        this.bly.setShowPraiseNum(true);
        this.bly.setNeedAddPraiseIcon(true);
        this.bly.setNeedAddReplyIcon(true);
        this.bly.setShareVisible(true);
        this.bly.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bly.setFrom(1);
        this.bly.setShareReportFrom(3);
        this.bly.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.XL() != null) {
                    n.this.XL().a(view2, n.this.bKm);
                }
            }
        });
        this.blC = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.bKi = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bKi.setOnClickListener(this.bKn);
    }

    public void setSingleImageRatio(double d) {
        if (this.bLX != null) {
            this.bLX.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLX != null) {
            this.bLX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLX != null) {
            this.bLX.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bLX.onChangeSkinType();
            this.bly.onChangeSkinType();
            this.bKi.onChangeSkinType();
            this.blu.onChangeSkinType();
            if (this.bKk != null) {
                this.bKk.onChangeSkinType();
            }
            aj.k(this.bKl, d.e.cp_bg_line_c);
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
        this.bKm = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bKn);
        }
        if (this.bKk != null && this.bKm.MR() != null) {
            an anVar = new an();
            anVar.cy(this.bKm.MR().getTid());
            anVar.setFid(this.bKm.MR().getFid());
            anVar.a(this.bKm.Xf);
            this.bKk.setData(anVar);
            this.bKk.setFirstRowSingleColumn(true);
        }
        this.blu.c(lVar.threadData);
        this.bKi.setFromCDN(this.aje);
        this.bKi.setData(lVar.threadData.sR());
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        this.bKi.onChangeSkinType();
        if (lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bKk.setVisibility(8);
            } else {
                this.bKk.setVisibility(0);
            }
        }
        if (!XP() && m.jv(this.bKm.threadData.getId())) {
            m.a(this.mTitle, this.bKm.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLW, this.bKm.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bKi.getGodReplyContent(), this.bKm.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bKi.getPraiseNum(), this.bKm.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.blu.setUserAfterClickListener(this.aou);
        this.bly.c(lVar.threadData);
        this.bKj.setVisibility(0);
        this.mStType = m.rs();
        this.aob = "feed#" + lVar.Ym();
        final bj MR = lVar.MR();
        if (this.blu.getHeaderImg() != null) {
            if (this.blu.getIsSimpleThread()) {
                this.blu.getHeaderImg().setVisibility(8);
                this.bKh.setVisibility(8);
            } else if (MR.getAuthor() == null || MR.getAuthor().getPendantData() == null || StringUtils.isNull(MR.getAuthor().getPendantData().pR())) {
                this.bKh.setVisibility(8);
                this.blu.getHeaderImg().setVisibility(0);
                this.blu.getHeaderImg().setData(MR);
            } else {
                this.blu.getHeaderImg().setVisibility(4);
                this.bKh.setVisibility(0);
                this.bKh.setData(MR);
            }
        }
        boolean D = D(MR);
        ArrayList<VoiceData.VoiceModel> rP = lVar.threadData.rP();
        if (com.baidu.tbadk.core.util.v.v(rP)) {
            this.bLV.setVisibility(8);
            z = false;
        } else {
            this.bLV.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rP.get(0);
            this.bLV.setVoiceModel(voiceModel);
            this.bLV.setTag(voiceModel);
            this.bLV.bhC();
            if (voiceModel != null) {
                this.bLV.nl(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bKm.bOb && z) {
            this.bLX.setVisibility(8);
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
                    this.bLX.setVisibility(0);
                    this.bLX.setFromCDN(this.aje);
                    this.bLX.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z3) {
                            x<com.baidu.tieba.card.data.l> XL = n.this.XL();
                            if (XL != null) {
                                view.setTag("1");
                                XL.a(view, n.this.bKm);
                            }
                            if (z3) {
                                n.this.Yc();
                            } else {
                                n.this.a(linkedList2, i2, MR);
                            }
                        }
                    });
                    this.bLX.setImageUrls(linkedList);
                } else {
                    this.bLX.setVisibility(8);
                }
            } else {
                this.bLX.setVisibility(8);
            }
            z2 = false;
        }
        Yb();
        h(D, false, z2);
        setPageUniqueId(getTag());
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLW.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bLX.getLayoutParams();
        if (!z && z2) {
            layoutParams.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds2);
            } else if (z) {
                layoutParams2.topMargin = 0;
            }
        } else if (z2) {
            layoutParams3.topMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds13);
        } else if (z) {
            layoutParams3.topMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds10);
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
                    imageUrlData.urlType = this.aje ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mF.getPageActivity()).createConfig(arrayList, i, bjVar.rG(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.aje, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Yb() {
        if (!this.bKm.aCG) {
            this.bLV.setClickable(false);
        } else {
            this.bLV.setClickable(true);
        }
        int childCount = this.bLX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLX.getChildAt(i);
            if (childAt != null) {
                if (!this.bKm.aCG) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aje = z;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bLX != null) {
            this.bLX.setPageUniqueId(bdUniqueId);
        }
        if (this.bKk != null) {
            this.bKk.setUniqueId(bdUniqueId);
        }
        if (this.blu != null) {
            this.blu.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(h.a aVar) {
        if (this.bKk != null) {
            this.bKk.setEventCallback(aVar);
        }
    }

    public View XN() {
        return this.bKi;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.blu != null) {
            return this.blu.aop;
        }
        return null;
    }

    public View XO() {
        if (this.blu != null) {
            return this.blu.aoq;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yc() {
        dI(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dI(boolean z) {
        if (this.bKm != null && this.bKm.threadData != null) {
            if (!XP()) {
                m.ju(this.bKm.threadData.getId());
                m.a(this.mTitle, this.bKm.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bLW, this.bKm.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bKi.getGodReplyContent(), this.bKm.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bKi.getPraiseNum(), this.bKm.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.bKm.threadData, null, m.rs(), 18003, true, false, false).addLocateParam(this.bKm.Yn());
            addLocateParam.setForumId(String.valueOf(this.bKm.threadData.getFid()));
            addLocateParam.setForumName(this.bKm.threadData.rG());
            if (this.bKm.bNJ == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bKm.bNJ);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XP() {
        return this.bKm.bOb && !this.bKm.aCG;
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
