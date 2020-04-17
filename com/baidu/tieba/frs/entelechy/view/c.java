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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
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
import com.baidu.tieba.card.x;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private RelativeLayout aWM;
    protected bj adG;
    private TextView ady;
    private String aey;
    private PlayVoiceBntNew agG;
    private final View.OnClickListener agi;
    protected boolean agt;
    private AppletsCellView ahs;
    protected View cDw;
    public LinearLayout eGZ;
    public ThreadUserInfoLayout fsq;
    protected ThreadCommentAndPraiseInfoLayout fsr;
    protected ThreadSourceShareAndPraiseLayout ftd;
    private ThreadGodReplyLayout goP;
    private HeadPendantClickableView goQ;
    protected View gpp;
    protected ConstrainImageGroup gpr;
    private View.OnClickListener gpw;
    private final View.OnClickListener gpx;
    public TbImageView gqX;
    private TbImageView gqZ;
    private i hiQ;
    private String hja;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.agt = true;
        this.gpw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bND().bNE()) {
                    if (c.this.fsr != null) {
                        c.this.fsr.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.bEy() != null) {
                    c.this.bEy().a(view, c.this.adG);
                }
                c.this.lr(view == c.this.goP);
            }
        };
        this.gpx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<bj> bEy = c.this.bEy();
                if (bEy != null) {
                    view.setTag("2");
                    bEy.a(view, c.this.adG);
                }
            }
        };
        this.agi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bEy() != null) {
                    c.this.bEy().a(view, c.this.adG);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.goQ = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.goQ.getHeadView() != null) {
            this.goQ.getHeadView().setIsRound(true);
            this.goQ.getHeadView().setDrawBorder(false);
            this.goQ.getHeadView().setDefaultResource(17170445);
            this.goQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goQ.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.goQ.setHasPendantStyle();
        if (this.goQ.getPendantView() != null) {
            this.goQ.getPendantView().setIsRound(true);
            this.goQ.getPendantView().setDrawBorder(false);
        }
        this.goQ.setAfterClickListener(this.agi);
        this.cDw = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.agG = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.agG.setAfterClickListener(this.gpx);
        this.ady = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.ady.setVisibility(8);
        this.gpp = view.findViewById(R.id.divider_line_above_praise);
        this.gpr = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.gpr.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gpr.setChildClickListener(this.gpw);
        f fVar = new f(3);
        fVar.n(1.0d);
        this.gpr.setImageProcessor(fVar);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.fsq = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.fsq.setUserAfterClickListener(this.agi);
        this.fsq.setFrom(3);
        this.fsr.setOnClickListener(this.gpw);
        this.fsr.setForumAfterClickListener(this.agi);
        this.fsr.setReplyTimeVisible(false);
        this.fsr.setShowPraiseNum(true);
        this.fsr.setNeedAddPraiseIcon(true);
        this.fsr.setNeedAddReplyIcon(true);
        this.fsr.setIsBarViewVisible(false);
        this.fsr.setShareVisible(true);
        this.fsr.setShareReportFrom(1);
        this.fsr.setStType("frs_page");
        this.fsr.setFrom(2);
        this.fsr.dIc = 3;
        this.ftd = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.ftd != null) {
            this.ftd.dJa.setOnClickListener(this.gpw);
            this.ftd.setFrom(2);
            this.ftd.setShareReportFrom(1);
            this.ftd.setSourceFromForPb(3);
            this.ftd.setStType("frs_page");
            this.ftd.setHideBarName(true);
            this.ftd.dJa.setNeedAddReplyIcon(true);
        }
        this.aWM = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hiQ = new i(this.mPageContext, this.aWM);
        this.hiQ.setUniqueId(getTag());
        this.goP = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.goP.setOnClickListener(this.gpw);
        this.gqX = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.gqX.setPageId(getTag());
        this.gqZ = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.gqZ != null) {
            this.gqZ.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fsr != null) {
                    c.this.fsr.changeSelectStatus();
                }
            }
        });
        this.fsr.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void gS(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.eGZ = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.ahs = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.gpr != null) {
            this.gpr.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpr != null) {
            this.gpr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpr != null) {
            this.gpr.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.cDw, R.color.cp_bg_line_c);
            this.gpr.onChangeSkinType();
            this.fsr.onChangeSkinType();
            this.fsq.onChangeSkinType();
            if (this.ahs != null) {
                this.ahs.onChangeSkinType();
            }
            this.hiQ.onChangeSkinType();
            if (this.ftd != null && this.ftd.getVisibility() == 0) {
                this.ftd.onChangeSkinType();
            }
            if (this.goQ != null && this.goQ.getHeadView() != null && (this.goQ.getHeadView() instanceof TbImageView)) {
                this.goQ.getHeadView().setPlaceHolder(1);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(final bj bjVar) {
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.adG = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gpw);
        }
        this.goP.onChangeSkinType();
        if (!bEJ() && com.baidu.tieba.card.l.BC(this.adG.getId())) {
            com.baidu.tieba.card.l.a(this.mTitle, this.adG.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.ady, this.adG.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.goP.getGodReplyContent(), this.adG.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bjVar);
        this.hiQ.az(this.adG);
        Y(bjVar);
        this.fsq.setData(this.adG);
        this.goP.setFromCDN(this.agt);
        this.goP.setData(this.adG.aMe());
        this.fsq.setUserAfterClickListener(this.agi);
        pX(or(1));
        if (this.fsq.getHeaderImg() != null) {
            if (this.fsq.getIsSimpleThread()) {
                this.fsq.getHeaderImg().setVisibility(8);
                this.goQ.setVisibility(8);
            } else if (bjVar.aKE() == null || bjVar.aKE().getPendantData() == null || StringUtils.isNull(bjVar.aKE().getPendantData().aIW())) {
                this.goQ.setVisibility(8);
                this.fsq.getHeaderImg().setVisibility(0);
                this.fsq.getHeaderImg().setData(bjVar);
            } else {
                this.fsq.getHeaderImg().setVisibility(4);
                this.goQ.setVisibility(0);
                this.goQ.setData(bjVar);
            }
        }
        as(bjVar);
        at(bjVar);
        this.ahs.setData(bjVar.aLq());
        this.ahs.setForumId(String.valueOf(bjVar.getFid()));
        AppletsCellView appletsCellView = this.ahs;
        AppletsCellView appletsCellView2 = this.ahs;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aKS = bjVar.aKS();
        if (v.isEmpty(aKS)) {
            this.agG.setVisibility(8);
        } else {
            this.agG.cXz();
            this.agG.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aKS.get(0);
            this.agG.setVoiceModel(voiceModel);
            this.agG.setTag(voiceModel);
            this.agG.ckO();
            if (voiceModel != null) {
                this.agG.xC(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aKO = bjVar.aKO();
        if (com.baidu.tbadk.core.i.aIe().isShowImages() && v.getCount(aKO) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aKO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aKO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.gpr.setVisibility(0);
                this.gpr.setFromCDN(this.agt);
                this.gpr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        z<bj> bEy = c.this.bEy();
                        if (z) {
                            if (bEy != null) {
                                view.setTag("1");
                                bEy.afG = true;
                                bEy.a(view, c.this.adG);
                            }
                            c.this.lr(false);
                            return;
                        }
                        if (bEy != null) {
                            view.setTag("1");
                            bEy.afG = false;
                            bEy.a(view, c.this.adG);
                        }
                        c.this.a(view, linkedList, i2, bjVar);
                    }
                });
                this.gpr.setImageMediaList(linkedList);
            } else {
                this.gpr.setVisibility(8);
            }
        } else {
            this.gpr.setVisibility(8);
        }
        bER();
        bES();
        bSg();
        if (this.fsr.isInFrsAllThread() && com.baidu.tieba.frs.a.bND().bNE()) {
            this.mMaskView.setVisibility(0);
            if (this.adG.aMn() || this.adG.aMo()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bER() {
        if (this.gpp != null && this.gpr != null && this.goP != null) {
            if (this.gpr.getVisibility() == 8 && this.goP.getVisibility() == 8 && this.ahs.getVisibility() == 8) {
                this.gpp.setVisibility(0);
            } else {
                this.gpp.setVisibility(8);
            }
        }
    }

    private void Y(final bj bjVar) {
        if (this.gqZ != null) {
            if (this.gqX == null || bjVar == null) {
                this.gqZ.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.dtp) && this.gqX.getVisibility() != 0) {
                if (this.hiQ != null && this.hiQ.bVD() && (this.gqZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqZ.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.gqZ.setLayoutParams(layoutParams);
                }
                this.gqZ.setVisibility(0);
                this.gqZ.setImageDrawable(null);
                this.gqZ.startLoad(bjVar.dtp, 10, false);
                this.gqZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bjVar.dtq, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gqZ.setVisibility(8);
            }
        }
    }

    public void b(bj bjVar) {
        MetaData aKE;
        if (bjVar != null && this.gqX != null && (aKE = bjVar.aKE()) != null) {
            final ThemeCardInUserData themeCard = aKE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.gqX.setVisibility(8);
                return;
            }
            this.gqX.setVisibility(0);
            this.gqX.setImageDrawable(null);
            this.gqX.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.gqX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bj bjVar) {
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
                imageUrlData.urlType = this.agt ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.isEmpty(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aKJ(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.agt, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            createConfig.setThreadData(bjVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bjVar.getId();
            historyMessage.threadName = bjVar.getTitle();
            historyMessage.forumName = bjVar.aKJ();
            historyMessage.postID = bjVar.aKU();
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

    private void bES() {
        this.agG.setClickable(true);
        int childCount = this.gpr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gpr.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fsr != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fsq != null) {
            this.fsq.setPageUniqueId(bdUniqueId);
        }
        if (this.gpr != null) {
            this.gpr.setPageUniqueId(bdUniqueId);
        }
    }

    protected void lr(boolean z) {
        if (this.adG != null) {
            com.baidu.tieba.card.l.BB(this.adG.getId());
            com.baidu.tieba.card.l.a(this.mTitle, this.adG.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.ady, this.adG.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.goP.getGodReplyContent(), this.adG.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            p aLM = this.adG.aLM();
            if (aLM != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aLM.getCartoonId(), aLM.getChapterId(), 2)));
                return;
            }
            m mVar = this.adG.dsN;
            if (this.adG.dsM == 1 && mVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = mVar.dnr;
                long j = mVar.dnt;
                ao aoVar = new ao();
                aoVar.pageContext = this.mPageContext;
                aoVar.dnG = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.adG, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.adG.aLI() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean bEJ() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.currentPageType = i;
        if (this.fsr != null) {
            this.fsr.dIc = i;
            this.fsr.setFrom(2);
        }
        if (this.fsq != null) {
            this.fsq.setFrom(3);
        }
    }

    private boolean as(bj bjVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hja)) {
            bjVar.cz(this.mUrl, this.hja);
        }
        SpannableStringBuilder u = bjVar.u(false, true);
        if (u == null || StringUtils.isNull(u.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(u));
            this.mTitle.setText(u);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void at(bj bjVar) {
        if (bjVar != null && or(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hja)) {
                bjVar.cz(this.mUrl, this.hja);
            }
            SpannableString aLw = bjVar.aLw();
            if (aLw != null && !aq.isEmpty(aLw.toString())) {
                this.ady.setVisibility(0);
                this.ady.setOnTouchListener(new com.baidu.tieba.view.i(aLw));
                this.ady.setText(aLw);
                com.baidu.tieba.card.l.a(this.ady, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.ady.setVisibility(8);
            return;
        }
        this.ady.setVisibility(8);
    }

    private void bSg() {
        if (this.mTitle != null && this.agG != null && this.gpr != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agG.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.agG.setLayoutParams(layoutParams);
            if (this.agG.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gpr.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.gpr.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pX(int i) {
        if (this.adG != null) {
            if (i == 1) {
                this.fsr.setVisibility(8);
                if (this.ftd != null) {
                    this.ftd.setData(this.adG);
                    return;
                }
                return;
            }
            this.fsr.setData(this.adG);
            if (this.ftd != null) {
                this.ftd.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfP().ar(this.aey, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.gpr != null) {
            this.gpr.setPreloadSizeReadyCallback(bVar);
        }
    }
}
