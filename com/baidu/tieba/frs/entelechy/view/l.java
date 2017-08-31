package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<bj> implements v {
    private View aVm;
    private bj ajF;
    private boolean ajf;
    private final View.OnClickListener aow;
    private HeadPendantClickableView bJq;
    private ThreadGodReplyLayout bJr;
    private View bJs;
    private View.OnClickListener bJw;
    private PlayVoiceBntNew bLe;
    private TextView bLf;
    private ConstrainImageGroup bLg;
    private final View.OnClickListener bLh;
    public LinearLayout blD;
    private ThreadUserInfoLayout blv;
    private ThreadCommentAndPraiseInfoLayout blz;
    public TbImageView crf;
    private com.baidu.tieba.frs.h.g cvV;
    private TbPageContext<?> mF;
    private String mForumName;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajf = true;
        this.bJw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.XA() != null) {
                    l.this.XA().a(view, l.this.ajF);
                }
                l.this.dH(view == l.this.bJr);
            }
        };
        this.bLh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bj> XA = l.this.XA();
                if (XA != null) {
                    view.setTag("2");
                    XA.a(view, l.this.ajF);
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.XA() != null) {
                    l.this.XA().a(view, l.this.ajF);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
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
        this.bJq.setAfterClickListener(this.aow);
        this.aVm = view.findViewById(d.h.divider_line);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLe = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLe.setAfterClickListener(this.bLh);
        this.bLf = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLf.setVisibility(8);
        this.bLg = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bLg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bLg.setChildClickListener(this.bJw);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLg.setImageProcessor(fVar);
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.blv = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.blv.setUserAfterClickListener(this.aow);
        this.blv.setFrom(3);
        this.bJs = view.findViewById(d.h.divider_below_reply_number_layout);
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
        this.blz.setIsBarViewVisible(false);
        this.blz.setShareVisible(true);
        this.blz.setShareReportFrom(1);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blz.setFrom(2);
        this.cvV = new com.baidu.tieba.frs.h.g(this.mF, this.blv);
        this.cvV.setUniqueId(getTag());
        this.bJr = (ThreadGodReplyLayout) view.findViewById(d.h.card_frs_god_reply_layout);
        this.bJr.setOnClickListener(this.bJw);
        this.crf = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.crf.setPageId(getTag());
        this.blD = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
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
            aj.k(this.aVm, d.e.cp_bg_line_c);
            this.bLg.onChangeSkinType();
            this.blz.onChangeSkinType();
            this.blv.onChangeSkinType();
            this.cvV.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(final bj bjVar) {
        boolean z;
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajF = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJw);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        this.bJr.onChangeSkinType();
        if (!XE() && m.jt(this.ajF.getId())) {
            m.a(this.mTitle, this.ajF.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLf, this.ajF.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJr.getGodReplyContent(), this.ajF.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJr.getPraiseNum(), this.ajF.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cvV.T(this.ajF);
        this.blv.c(this.ajF);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.mF.getResources().getDimension(d.f.ds10);
        this.blz.setLayoutParams(layoutParams);
        this.bJr.setFromCDN(this.ajf);
        this.bJr.setData(this.ajF.sR());
        this.blv.setUserAfterClickListener(this.aow);
        this.blz.c(bjVar);
        this.bJs.setVisibility(0);
        this.mStType = m.rs();
        if (this.blv.getHeaderImg() != null) {
            if (this.blv.getIsSimpleThread()) {
                this.blv.getHeaderImg().setVisibility(8);
                this.bJq.setVisibility(8);
            } else if (bjVar.getAuthor() == null || bjVar.getAuthor().getPendantData() == null || StringUtils.isNull(bjVar.getAuthor().getPendantData().pR())) {
                this.bJq.setVisibility(8);
                this.blv.getHeaderImg().setVisibility(0);
                this.blv.getHeaderImg().setData(bjVar);
            } else {
                this.blv.getHeaderImg().setVisibility(4);
                this.bJq.setVisibility(0);
                this.bJq.setData(bjVar);
            }
        }
        boolean D = D(bjVar);
        ArrayList<VoiceData.VoiceModel> rP = bjVar.rP();
        if (com.baidu.tbadk.core.util.v.v(rP)) {
            this.bLe.setVisibility(8);
        } else {
            this.bLe.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rP.get(0);
            this.bLe.setVoiceModel(voiceModel);
            this.bLe.setTag(voiceModel);
            this.bLe.bhr();
            if (voiceModel != null) {
                this.bLe.nj(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> rL = bjVar.rL();
        if (com.baidu.tbadk.core.h.oS().oY() && com.baidu.tbadk.core.util.v.u(rL) != 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            for (int i = 0; i < rL.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rL, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !am.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.u(linkedList) > 0) {
                this.bLg.setVisibility(0);
                this.bLg.setFromCDN(this.ajf);
                this.bLg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z2) {
                        x<bj> XA = l.this.XA();
                        if (z2) {
                            if (XA != null) {
                                view.setTag("1");
                                XA.aTE = true;
                                XA.a(view, l.this.ajF);
                            }
                            l.this.dH(false);
                            return;
                        }
                        if (XA != null) {
                            view.setTag("1");
                            XA.aTE = false;
                            XA.a(view, l.this.ajF);
                        }
                        l.this.a(linkedList2, i2, bjVar);
                    }
                });
                this.bLg.setImageUrls(linkedList);
                z = true;
                XQ();
                h(D, false, z);
                K(bjVar);
            }
            this.bLg.setVisibility(8);
        } else {
            this.bLg.setVisibility(8);
        }
        z = false;
        XQ();
        h(D, false, z);
        K(bjVar);
    }

    public void K(bj bjVar) {
        MetaData author;
        if (bjVar != null && this.crf != null && (author = bjVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.crf.setVisibility(8);
                return;
            }
            this.crf.setVisibility(0);
            this.crf.setImageBitmap(null);
            this.crf.c(themeCard.getCardImageUrlAndroid(), 10, false);
            this.crf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(l.this.mF.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitle.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bLf.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.bLg.getLayoutParams();
        if (!z && z2) {
            layoutParams2.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2);
            } else if (z) {
                layoutParams3.topMargin = 0;
            }
        } else if (z2) {
            layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds13);
        } else if (z) {
            layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10);
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
        this.bLe.setClickable(true);
        int childCount = this.bLg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLg.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajf = z;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.blz != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.blv != null) {
            this.blv.setPageUniqueId(bdUniqueId);
        }
        if (this.bLg != null) {
            this.bLg.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(boolean z) {
        if (this.ajF != null) {
            m.js(this.ajF.getId());
            m.a(this.mTitle, this.ajF.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLf, this.ajF.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJr.getGodReplyContent(), this.ajF.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJr.getPraiseNum(), this.ajF.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            n sx = this.ajF.sx();
            if (sx != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aS(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mF.getPageActivity(), sx.getCartoonId(), sx.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ajF.ZB;
            if (this.ajF.ZA == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.UR;
                long j = kVar.US;
                aq aqVar = new aq();
                aqVar.pageContext = this.mF;
                aqVar.Vp = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.ajF, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajF.getFid()));
            addLocateParam.setForumName(this.ajF.rG());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XE() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.bLe != null) {
            this.bLe.setVoiceManager(voiceManager);
        }
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
