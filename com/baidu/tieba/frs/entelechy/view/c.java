package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<bu> implements com.baidu.tieba.a.e, y {
    private TextView aeA;
    protected bu aeK;
    private String afG;
    private final View.OnClickListener ahM;
    protected boolean aik;
    private PlayVoiceBntNew aiw;
    private AppletsCellView ajv;
    private RelativeLayout bjv;
    protected View eVD;
    public ThreadUserInfoLayout fRH;
    protected ThreadCommentAndPraiseInfoLayout fRI;
    protected ThreadSourceShareAndPraiseLayout fSu;
    public LinearLayout fdX;
    private ThreadGodReplyLayout gQM;
    private HeadPendantClickableView gQN;
    protected View gRl;
    protected ConstrainImageGroup gRn;
    private View.OnClickListener gRs;
    private final View.OnClickListener gRt;
    public TbImageView gSW;
    private TbImageView gSY;
    private i hKS;
    private String hLc;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aik = true;
        this.gRs = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.bXd().bWX() || com.baidu.tieba.frs.a.bWW().bWX()) {
                    if (c.this.fRI != null) {
                        c.this.fRI.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.bOd() != null) {
                    c.this.bOd().a(view, c.this.aeK);
                }
                c.this.lW(view == c.this.gQM);
            }
        };
        this.gRt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<bu> bOd = c.this.bOd();
                if (bOd != null) {
                    view.setTag("2");
                    bOd.a(view, c.this.aeK);
                }
            }
        };
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bOd() != null) {
                    c.this.bOd().a(view, c.this.aeK);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.gQN = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.gQN.getHeadView() != null) {
            this.gQN.getHeadView().setIsRound(true);
            this.gQN.getHeadView().setDrawBorder(false);
            this.gQN.getHeadView().setDefaultResource(17170445);
            this.gQN.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gQN.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.gQN.setHasPendantStyle();
        if (this.gQN.getPendantView() != null) {
            this.gQN.getPendantView().setIsRound(true);
            this.gQN.getPendantView().setDrawBorder(false);
        }
        this.gQN.setAfterClickListener(this.ahM);
        this.eVD = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.aiw = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.aiw.setAfterClickListener(this.gRt);
        this.aeA = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.aeA.setVisibility(8);
        this.gRl = view.findViewById(R.id.divider_line_above_praise);
        this.gRn = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.gRn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gRn.setChildClickListener(this.gRs);
        f fVar = new f(3);
        fVar.o(1.0d);
        this.gRn.setImageProcessor(fVar);
        this.fRI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.fRH = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.fRH.setUserAfterClickListener(this.ahM);
        this.fRH.setFrom(3);
        this.fRI.setOnClickListener(this.gRs);
        this.fRI.setForumAfterClickListener(this.ahM);
        this.fRI.setReplyTimeVisible(false);
        this.fRI.setShowPraiseNum(true);
        this.fRI.setNeedAddPraiseIcon(true);
        this.fRI.setNeedAddReplyIcon(true);
        this.fRI.setIsBarViewVisible(false);
        this.fRI.setShareVisible(true);
        this.fRI.setShareReportFrom(1);
        this.fRI.setStType("frs_page");
        this.fRI.setFrom(2);
        this.fRI.edR = 3;
        this.fSu = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.fSu != null) {
            this.fSu.eeP.setOnClickListener(this.gRs);
            this.fSu.setFrom(2);
            this.fSu.setShareReportFrom(1);
            this.fSu.setSourceFromForPb(3);
            this.fSu.setStType("frs_page");
            this.fSu.setHideBarName(true);
            this.fSu.eeP.setNeedAddReplyIcon(true);
        }
        this.bjv = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hKS = new i(this.mPageContext, this.bjv);
        this.hKS.setUniqueId(getTag());
        this.gQM = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.gQM.setOnClickListener(this.gRs);
        this.gSW = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.gSW.setPageId(getTag());
        this.gSY = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.gSY != null) {
            this.gSY.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fRI != null) {
                    c.this.fRI.changeSelectStatus();
                }
            }
        });
        this.fRI.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void hy(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(an.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.fdX = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.ajv = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.gRn != null) {
            this.gRn.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gRn != null) {
            this.gRn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gRn != null) {
            this.gRn.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            an.setBackgroundColor(this.eVD, R.color.cp_bg_line_c);
            this.gRn.onChangeSkinType();
            this.fRI.onChangeSkinType();
            this.fRH.onChangeSkinType();
            if (this.ajv != null) {
                this.ajv.onChangeSkinType();
            }
            this.hKS.onChangeSkinType();
            if (this.fSu != null && this.fSu.getVisibility() == 0) {
                this.fSu.onChangeSkinType();
            }
            if (this.gQN != null && this.gQN.getHeadView() != null && (this.gQN.getHeadView() instanceof TbImageView)) {
                this.gQN.getHeadView().setPlaceHolder(1);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(final bu buVar) {
        if (buVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aeK = buVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gRs);
        }
        this.gQM.onChangeSkinType();
        if (!bOm() && m.DP(this.aeK.getId())) {
            m.a(this.mTitle, this.aeK.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.aeA, this.aeK.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            m.a(this.gQM.getGodReplyContent(), this.aeK.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(buVar);
        this.hKS.aA(this.aeK);
        aa(buVar);
        this.fRH.setData(this.aeK);
        this.gQM.setFromCDN(this.aik);
        this.gQM.setData(this.aeK.aTS());
        this.fRH.setUserAfterClickListener(this.ahM);
        qZ(pz(1));
        if (this.fRH.getHeaderImg() != null) {
            if (this.fRH.getIsSimpleThread()) {
                this.fRH.getHeaderImg().setVisibility(8);
                this.gQN.setVisibility(8);
            } else if (buVar.aSp() == null || buVar.aSp().getPendantData() == null || StringUtils.isNull(buVar.aSp().getPendantData().aQl())) {
                this.gQN.setVisibility(8);
                this.fRH.getHeaderImg().setVisibility(0);
                this.fRH.getHeaderImg().setData(buVar);
            } else {
                this.fRH.getHeaderImg().setVisibility(4);
                this.gQN.setVisibility(0);
                this.gQN.setData(buVar);
            }
        }
        at(buVar);
        au(buVar);
        this.ajv.setData(buVar.aTe());
        this.ajv.setForumId(String.valueOf(buVar.getFid()));
        AppletsCellView appletsCellView = this.ajv;
        AppletsCellView appletsCellView2 = this.ajv;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aSC = buVar.aSC();
        if (w.isEmpty(aSC)) {
            this.aiw.setVisibility(8);
        } else {
            this.aiw.bCo();
            this.aiw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aSC.get(0);
            this.aiw.setVoiceModel(voiceModel);
            this.aiw.setTag(voiceModel);
            this.aiw.aYi();
            if (voiceModel != null) {
                this.aiw.yU(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aSy = buVar.aSy();
        if (k.aPA().isShowImages() && w.getCount(aSy) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aSy.size(); i++) {
                MediaData mediaData = (MediaData) w.getItem(aSy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (w.getCount(linkedList) > 0) {
                this.gRn.setVisibility(0);
                this.gRn.setFromCDN(this.aik);
                this.gRn.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        aa<bu> bOd = c.this.bOd();
                        if (z) {
                            if (bOd != null) {
                                view.setTag("1");
                                bOd.agT = true;
                                bOd.a(view, c.this.aeK);
                            }
                            c.this.lW(false);
                            return;
                        }
                        if (bOd != null) {
                            view.setTag("1");
                            bOd.agT = false;
                            bOd.a(view, c.this.aeK);
                        }
                        c.this.a(view, linkedList, i2, buVar);
                    }
                });
                this.gRn.setImageMediaList(linkedList);
            } else {
                this.gRn.setVisibility(8);
            }
        } else {
            this.gRn.setVisibility(8);
        }
        bOu();
        bOv();
        cbS();
        if ((com.baidu.tieba.frs.b.bXd().bWX() || com.baidu.tieba.frs.a.bWW().bWX()) && this.fRI.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.aeK.aUa() || this.aeK.aUb() || this.aeK.aUc()) {
                an.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bOu() {
        if (this.gRl != null && this.gRn != null && this.gQM != null) {
            if (this.gRn.getVisibility() == 8 && this.gQM.getVisibility() == 8 && this.ajv.getVisibility() == 8) {
                this.gRl.setVisibility(0);
            } else {
                this.gRl.setVisibility(8);
            }
        }
    }

    private void aa(final bu buVar) {
        if (this.gSY != null) {
            if (this.gSW == null || buVar == null) {
                this.gSY.setVisibility(8);
            } else if (!StringUtils.isNull(buVar.dNY) && this.gSW.getVisibility() != 0) {
                if (this.hKS != null && this.hKS.cfB() && (this.gSY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gSY.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.gSY.setLayoutParams(layoutParams);
                }
                this.gSY.setVisibility(0);
                this.gSY.setImageDrawable(null);
                this.gSY.startLoad(buVar.dNY, 10, false);
                this.gSY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", buVar.dNZ, true)));
                        }
                        TiebaStatic.log(new ao(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gSY.setVisibility(8);
            }
        }
    }

    public void b(bu buVar) {
        MetaData aSp;
        if (buVar != null && this.gSW != null && (aSp = buVar.aSp()) != null) {
            final ThemeCardInUserData themeCard = aSp.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.gSW.setVisibility(8);
                return;
            }
            this.gSW.setVisibility(0);
            this.gSW.setImageDrawable(null);
            this.gSW.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.gSW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bu buVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            String str = null;
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                str = mediaData.getSrc_pic();
            } else if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                str = mediaData.getPicUrl();
            }
            if (!StringUtils.isNull(str)) {
                arrayList.add(str);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.aik ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(buVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!w.isEmpty(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, buVar.aSt(), String.valueOf(buVar.getFid()), buVar.getTid(), this.aik, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            createConfig.setThreadData(buVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = buVar.getId();
            historyMessage.threadName = buVar.getTitle();
            historyMessage.forumName = buVar.aSt();
            historyMessage.postID = buVar.aSG();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private String a(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            return mediaData.getSrc_pic();
        }
        return picUrl;
    }

    private void bOv() {
        this.aiw.setClickable(true);
        int childCount = this.gRn.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gRn.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fRI != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fRH != null) {
            this.fRH.setPageUniqueId(bdUniqueId);
        }
        if (this.gRn != null) {
            this.gRn.setPageUniqueId(bdUniqueId);
        }
    }

    protected void lW(boolean z) {
        if (this.aeK != null) {
            m.DO(this.aeK.getId());
            m.a(this.mTitle, this.aeK.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.aeA, this.aeK.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            m.a(this.gQM.getGodReplyContent(), this.aeK.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            r aTA = this.aeK.aTA();
            if (aTA != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    be.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aTA.getCartoonId(), aTA.getChapterId(), 2)));
                return;
            }
            o oVar = this.aeK.dNw;
            if (this.aeK.dNv == 1 && oVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = oVar.dHQ;
                long j = oVar.dHR;
                as asVar = new as();
                asVar.pageContext = this.mPageContext;
                asVar.dIg = str;
                asVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, asVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aeK, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aeK.aTw() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean bOm() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
        this.currentPageType = i;
        if (this.fRI != null) {
            this.fRI.edR = i;
            this.fRI.setFrom(2);
        }
        if (this.fRH != null) {
            this.fRH.setFrom(3);
        }
    }

    private boolean at(bu buVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hLc)) {
            buVar.db(this.mUrl, this.hLc);
        }
        SpannableStringBuilder x = buVar.x(false, true);
        if (x == null || StringUtils.isNull(x.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(x));
            this.mTitle.setText(x);
            m.a(this.mTitle, buVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void au(bu buVar) {
        if (buVar != null && pz(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hLc)) {
                buVar.db(this.mUrl, this.hLc);
            }
            SpannableString aTk = buVar.aTk();
            if (aTk != null && !ar.isEmpty(aTk.toString())) {
                this.aeA.setVisibility(0);
                this.aeA.setOnTouchListener(new com.baidu.tieba.view.i(aTk));
                this.aeA.setText(aTk);
                m.a(this.aeA, buVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.aeA.setVisibility(8);
            return;
        }
        this.aeA.setVisibility(8);
    }

    private void cbS() {
        if (this.mTitle != null && this.aiw != null && this.gRn != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiw.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.aiw.setLayoutParams(layoutParams);
            if (this.aiw.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gRn.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.gRn.setLayoutParams(layoutParams2);
            }
        }
    }

    public void qZ(int i) {
        if (this.aeK != null) {
            if (i == 1) {
                this.fRI.setVisibility(8);
                if (this.fSu != null) {
                    this.fSu.setData(this.aeK);
                    return;
                }
                return;
            }
            this.fRI.setData(this.aeK);
            if (this.fSu != null) {
                this.fSu.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }

    public int pz(int i) {
        return com.baidu.tieba.a.d.boB().as(this.afG, i);
    }
}
