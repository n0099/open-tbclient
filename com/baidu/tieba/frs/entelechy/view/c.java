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
import com.baidu.tieba.view.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private TextView JZ;
    protected bj Ki;
    private String La;
    private final View.OnClickListener MT;
    protected boolean Nf;
    private PlayVoiceBntNew Ns;
    private AppletsCellView Oi;
    private RelativeLayout axQ;
    protected View bZT;
    protected ThreadSourceShareAndPraiseLayout eIU;
    public ThreadUserInfoLayout eIg;
    protected ThreadCommentAndPraiseInfoLayout eIh;
    public LinearLayout ect;
    private ThreadGodReplyLayout fDF;
    private HeadPendantClickableView fDG;
    protected View fEe;
    protected ConstrainImageGroup fEg;
    private View.OnClickListener fEl;
    private final View.OnClickListener fEm;
    public TbImageView fFM;
    private TbImageView fFO;
    private i gsY;
    private String gti;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Nf = true;
        this.fEl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bAp().bAq()) {
                    if (c.this.eIh != null) {
                        c.this.eIh.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.brY() != null) {
                    c.this.brY().a(view, c.this.Ki);
                }
                c.this.jW(view == c.this.fDF);
            }
        };
        this.fEm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<bj> brY = c.this.brY();
                if (brY != null) {
                    view.setTag("2");
                    brY.a(view, c.this.Ki);
                }
            }
        };
        this.MT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.brY() != null) {
                    c.this.brY().a(view, c.this.Ki);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.fDG = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.fDG.getHeadView() != null) {
            this.fDG.getHeadView().setIsRound(true);
            this.fDG.getHeadView().setDrawBorder(false);
            this.fDG.getHeadView().setDefaultResource(17170445);
            this.fDG.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fDG.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.fDG.setHasPendantStyle();
        if (this.fDG.getPendantView() != null) {
            this.fDG.getPendantView().setIsRound(true);
            this.fDG.getPendantView().setDrawBorder(false);
        }
        this.fDG.setAfterClickListener(this.MT);
        this.bZT = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.Ns = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.Ns.setAfterClickListener(this.fEm);
        this.JZ = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.JZ.setVisibility(8);
        this.fEe = view.findViewById(R.id.divider_line_above_praise);
        this.fEg = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.fEg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fEg.setChildClickListener(this.fEl);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fEg.setImageProcessor(fVar);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.eIg = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.eIg.setUserAfterClickListener(this.MT);
        this.eIg.setFrom(3);
        this.eIh.setOnClickListener(this.fEl);
        this.eIh.setForumAfterClickListener(this.MT);
        this.eIh.setReplyTimeVisible(false);
        this.eIh.setShowPraiseNum(true);
        this.eIh.setNeedAddPraiseIcon(true);
        this.eIh.setNeedAddReplyIcon(true);
        this.eIh.setIsBarViewVisible(false);
        this.eIh.setShareVisible(true);
        this.eIh.setShareReportFrom(1);
        this.eIh.setStType("frs_page");
        this.eIh.setFrom(2);
        this.eIh.ddq = 3;
        this.eIU = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.eIU != null) {
            this.eIU.dep.setOnClickListener(this.fEl);
            this.eIU.setFrom(2);
            this.eIU.setShareReportFrom(1);
            this.eIU.setSourceFromForPb(3);
            this.eIU.setStType("frs_page");
            this.eIU.setHideBarName(true);
            this.eIU.dep.setNeedAddReplyIcon(true);
        }
        this.axQ = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gsY = new i(this.mPageContext, this.axQ);
        this.gsY.setUniqueId(getTag());
        this.fDF = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.fDF.setOnClickListener(this.fEl);
        this.fFM = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.fFM.setPageId(getTag());
        this.fFO = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.fFO != null) {
            this.fFO.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eIh != null) {
                    c.this.eIh.changeSelectStatus();
                }
            }
        });
        this.eIh.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fH(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.ect = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.Oi = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.fEg != null) {
            this.fEg.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fEg != null) {
            this.fEg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fEg != null) {
            this.fEg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.bZT, R.color.cp_bg_line_c);
            this.fEg.onChangeSkinType();
            this.eIh.onChangeSkinType();
            this.eIg.onChangeSkinType();
            if (this.Oi != null) {
                this.Oi.onChangeSkinType();
            }
            this.gsY.onChangeSkinType();
            if (this.eIU != null && this.eIU.getVisibility() == 0) {
                this.eIU.onChangeSkinType();
            }
            if (this.fDG != null && this.fDG.getHeadView() != null && (this.fDG.getHeadView() instanceof TbImageView)) {
                this.fDG.getHeadView().setPlaceHolder(1);
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
        this.Ki = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fEl);
        }
        this.fDF.onChangeSkinType();
        if (!bsj() && com.baidu.tieba.card.l.zt(this.Ki.getId())) {
            com.baidu.tieba.card.l.a(this.mTitle, this.Ki.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.JZ, this.Ki.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fDF.getGodReplyContent(), this.Ki.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bjVar);
        this.gsY.as(this.Ki);
        V(bjVar);
        this.eIg.setData(this.Ki);
        this.fDF.setFromCDN(this.Nf);
        this.fDF.setData(this.Ki.aBe());
        this.eIg.setUserAfterClickListener(this.MT);
        pp(nL(1));
        if (this.eIg.getHeaderImg() != null) {
            if (this.eIg.getIsSimpleThread()) {
                this.eIg.getHeaderImg().setVisibility(8);
                this.fDG.setVisibility(8);
            } else if (bjVar.azE() == null || bjVar.azE().getPendantData() == null || StringUtils.isNull(bjVar.azE().getPendantData().axX())) {
                this.fDG.setVisibility(8);
                this.eIg.getHeaderImg().setVisibility(0);
                this.eIg.getHeaderImg().setData(bjVar);
            } else {
                this.eIg.getHeaderImg().setVisibility(4);
                this.fDG.setVisibility(0);
                this.fDG.setData(bjVar);
            }
        }
        an(bjVar);
        ao(bjVar);
        this.Oi.setData(bjVar.aAq());
        this.Oi.setForumId(String.valueOf(bjVar.getFid()));
        AppletsCellView appletsCellView = this.Oi;
        AppletsCellView appletsCellView2 = this.Oi;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> azS = bjVar.azS();
        if (v.isEmpty(azS)) {
            this.Ns.setVisibility(8);
        } else {
            this.Ns.cJE();
            this.Ns.setVisibility(0);
            VoiceData.VoiceModel voiceModel = azS.get(0);
            this.Ns.setVoiceModel(voiceModel);
            this.Ns.setTag(voiceModel);
            this.Ns.bEM();
            if (voiceModel != null) {
                this.Ns.wL(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> azO = bjVar.azO();
        if (com.baidu.tbadk.core.i.axf().isShowImages() && v.getCount(azO) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < azO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(azO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.fEg.setVisibility(0);
                this.fEg.setFromCDN(this.Nf);
                this.fEg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        z<bj> brY = c.this.brY();
                        if (z) {
                            if (brY != null) {
                                view.setTag("1");
                                brY.Mn = true;
                                brY.a(view, c.this.Ki);
                            }
                            c.this.jW(false);
                            return;
                        }
                        if (brY != null) {
                            view.setTag("1");
                            brY.Mn = false;
                            brY.a(view, c.this.Ki);
                        }
                        c.this.a(view, linkedList, i2, bjVar);
                    }
                });
                this.fEg.setImageMediaList(linkedList);
            } else {
                this.fEg.setVisibility(8);
            }
        } else {
            this.fEg.setVisibility(8);
        }
        bsr();
        bss();
        bEO();
        if (this.eIh.isInFrsAllThread() && com.baidu.tieba.frs.a.bAp().bAq()) {
            this.mMaskView.setVisibility(0);
            if (this.Ki.aBn() || this.Ki.aBo()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bsr() {
        if (this.fEe != null && this.fEg != null && this.fDF != null) {
            if (this.fEg.getVisibility() == 8 && this.fDF.getVisibility() == 8 && this.Oi.getVisibility() == 8) {
                this.fEe.setVisibility(0);
            } else {
                this.fEe.setVisibility(8);
            }
        }
    }

    private void V(final bj bjVar) {
        if (this.fFO != null) {
            if (this.fFM == null || bjVar == null) {
                this.fFO.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cPE) && this.fFM.getVisibility() != 0) {
                if (this.gsY != null && this.gsY.bIk() && (this.fFO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fFO.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fFO.setLayoutParams(layoutParams);
                }
                this.fFO.setVisibility(0);
                this.fFO.setImageDrawable(null);
                this.fFO.startLoad(bjVar.cPE, 10, false);
                this.fFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bjVar.cPF, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fFO.setVisibility(8);
            }
        }
    }

    public void b(bj bjVar) {
        MetaData azE;
        if (bjVar != null && this.fFM != null && (azE = bjVar.azE()) != null) {
            final ThemeCardInUserData themeCard = azE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fFM.setVisibility(8);
                return;
            }
            this.fFM.setVisibility(0);
            this.fFM.setImageDrawable(null);
            this.fFM.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fFM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.urlType = this.Nf ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.azJ(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.Nf, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
            historyMessage.forumName = bjVar.azJ();
            historyMessage.postID = bjVar.azU();
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

    private void bss() {
        this.Ns.setClickable(true);
        int childCount = this.fEg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fEg.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eIh != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eIg != null) {
            this.eIg.setPageUniqueId(bdUniqueId);
        }
        if (this.fEg != null) {
            this.fEg.setPageUniqueId(bdUniqueId);
        }
    }

    protected void jW(boolean z) {
        if (this.Ki != null) {
            com.baidu.tieba.card.l.zs(this.Ki.getId());
            com.baidu.tieba.card.l.a(this.mTitle, this.Ki.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.JZ, this.Ki.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fDF.getGodReplyContent(), this.Ki.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            p aAN = this.Ki.aAN();
            if (aAN != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aAN.getCartoonId(), aAN.getChapterId(), 2)));
                return;
            }
            m mVar = this.Ki.cPc;
            if (this.Ki.cPb == 1 && mVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = mVar.cJK;
                long j = mVar.cJL;
                ao aoVar = new ao();
                aoVar.pageContext = this.mPageContext;
                aoVar.cJY = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.Ki, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.Ki.aAJ() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean bsj() {
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
    public void pm(int i) {
        this.currentPageType = i;
        if (this.eIh != null) {
            this.eIh.ddq = i;
            if (i == 15) {
                this.eIh.setFrom(10);
            } else {
                this.eIh.setFrom(2);
            }
        }
        if (this.eIg != null) {
            if (i == 15) {
                this.eIg.setFrom(5);
            } else {
                this.eIg.setFrom(3);
            }
        }
    }

    private boolean an(bj bjVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.gti)) {
            bjVar.cg(this.mUrl, this.gti);
        }
        SpannableStringBuilder s = bjVar.s(false, true);
        if (s == null || StringUtils.isNull(s.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new h(s));
            this.mTitle.setText(s);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void ao(bj bjVar) {
        if (bjVar != null && nL(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.gti)) {
                bjVar.cg(this.mUrl, this.gti);
            }
            SpannableString aAw = bjVar.aAw();
            if (aAw != null && !aq.isEmpty(aAw.toString())) {
                this.JZ.setVisibility(0);
                this.JZ.setOnTouchListener(new h(aAw));
                this.JZ.setText(aAw);
                com.baidu.tieba.card.l.a(this.JZ, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.JZ.setVisibility(8);
            return;
        }
        this.JZ.setVisibility(8);
    }

    private void bEO() {
        if (this.mTitle != null && this.Ns != null && this.fEg != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ns.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.Ns.setLayoutParams(layoutParams);
            if (this.Ns.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fEg.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.fEg.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pp(int i) {
        if (this.Ki != null) {
            if (i == 1) {
                this.eIh.setVisibility(8);
                if (this.eIU != null) {
                    this.eIU.setData(this.Ki);
                    return;
                }
                return;
            }
            this.eIh.setData(this.Ki);
            if (this.eIU != null) {
                this.eIU.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aUV().aj(this.La, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fEg != null) {
            this.fEg.setPreloadSizeReadyCallback(bVar);
        }
    }
}
