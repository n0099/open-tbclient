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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    protected boolean aEU;
    protected bb aFJ;
    private final View.OnClickListener aLf;
    protected View bzH;
    private ThreadGodReplyLayout cVS;
    private View.OnClickListener cVV;
    protected View cYA;
    private TextView cYB;
    protected ConstrainImageGroup cYC;
    private final View.OnClickListener cYF;
    private PlayVoiceBntNew cYz;
    private String cbl;
    public ThreadUserInfoLayout cbx;
    protected ThreadCommentAndPraiseInfoLayout cby;
    private HeadPendantClickableView cci;
    protected ThreadSourceShareAndPraiseLayout ccl;
    public LinearLayout ccx;
    private com.baidu.tieba.frs.vc.g dUH;
    private String dUS;
    private AppletsCellView dUT;
    public TbImageView dai;
    private TbImageView dak;
    private RelativeLayout drR;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aEU = true;
        this.cVV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.aBg().aBh()) {
                    if (e.this.cby != null) {
                        e.this.cby.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (e.this.aqp() != null) {
                    e.this.aqp().a(view, e.this.aFJ);
                }
                e.this.fs(view == e.this.cVS);
            }
        };
        this.cYF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> aqp = e.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, e.this.aFJ);
                }
            }
        };
        this.aLf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aqp() != null) {
                    e.this.aqp().a(view, e.this.aFJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cci = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cci.getHeadView() != null) {
            this.cci.getHeadView().setIsRound(true);
            this.cci.getHeadView().setDrawBorder(false);
            this.cci.getHeadView().setDefaultResource(17170445);
            this.cci.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cci.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cci.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cci.setHasPendantStyle();
        if (this.cci.getPendantView() != null) {
            this.cci.getPendantView().setIsRound(true);
            this.cci.getPendantView().setDrawBorder(false);
        }
        this.cci.setAfterClickListener(this.aLf);
        this.bzH = view.findViewById(e.g.divider_line);
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cYz = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cYz.setAfterClickListener(this.cYF);
        this.cYB = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cYB.setVisibility(8);
        this.cYA = view.findViewById(e.g.divider_line_above_praise);
        this.cYC = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cYC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        this.cYC.setChildClickListener(this.cVV);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cYC.setImageProcessor(eVar);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.cbx = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.cbx.setUserAfterClickListener(this.aLf);
        this.cbx.setFrom(3);
        this.cby.setOnClickListener(this.cVV);
        this.cby.setForumAfterClickListener(this.aLf);
        this.cby.setReplyTimeVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setIsBarViewVisible(false);
        this.cby.setShareVisible(true);
        this.cby.setShareReportFrom(1);
        this.cby.setStType("frs_page");
        this.cby.setFrom(2);
        this.cby.setDisPraiseFrom(2);
        this.cby.awp = 3;
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        if (this.ccl != null) {
            this.ccl.aKN.setOnClickListener(this.cVV);
            this.ccl.setFrom(2);
            this.ccl.setShareReportFrom(1);
            this.ccl.setSourceFromForPb(3);
            this.ccl.setStType("frs_page");
            this.ccl.setHideBarName(true);
            this.ccl.aKN.setNeedAddReplyIcon(true);
        }
        this.drR = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.dUH = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.drR);
        this.dUH.setUniqueId(getTag());
        this.cVS = (ThreadGodReplyLayout) view.findViewById(e.g.card_frs_god_reply_layout);
        this.cVS.setOnClickListener(this.cVV);
        this.dai = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.dai.setPageId(getTag());
        this.dak = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        if (this.dak != null) {
            this.dak.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.cby != null) {
                    e.this.cby.changeSelectStatus();
                }
            }
        });
        this.cby.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bK(boolean z) {
                if (e.this.mMaskView != null) {
                    e.this.mMaskView.setBackgroundColor(al.getColor(z ? e.d.cp_bg_line_d : e.d.transparent));
                }
            }
        });
        this.ccx = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.dUT = (AppletsCellView) view.findViewById(e.g.card_home_page_normal_thread_share_info);
    }

    public ThreadCommentAndPraiseInfoLayout acN() {
        return this.cby;
    }

    public ThreadCommentAndPraiseInfoLayout acO() {
        if (this.ccl != null) {
            return this.ccl.aKN;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.cYC != null) {
            this.cYC.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYC != null) {
            this.cYC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYC != null) {
            this.cYC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.bzH, e.d.cp_bg_line_e);
            this.cYC.onChangeSkinType();
            this.cby.onChangeSkinType();
            this.cbx.onChangeSkinType();
            this.dUH.onChangeSkinType();
            if (this.ccl != null && this.ccl.getVisibility() == 0) {
                this.ccl.onChangeSkinType();
            }
            if (this.dUT != null) {
                this.dUT.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(final bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aFJ = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVV);
        }
        this.cVS.onChangeSkinType();
        if (!aqt() && o.mX(this.aFJ.getId())) {
            o.a(this.mTitle, this.aFJ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cYB, this.aFJ.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cVS.getGodReplyContent(), this.aFJ.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        Q(bbVar);
        this.dUH.af(this.aFJ);
        N(bbVar);
        this.cbx.setData(this.aFJ);
        this.cVS.setFromCDN(this.aEU);
        this.cVS.setData(this.aFJ.Bk());
        this.cbx.setUserAfterClickListener(this.aLf);
        iM(hD(1));
        if (this.cbx.getHeaderImg() != null) {
            if (this.cbx.getIsSimpleThread()) {
                this.cbx.getHeaderImg().setVisibility(8);
                this.cci.setVisibility(8);
            } else if (bbVar.zT() == null || bbVar.zT().getPendantData() == null || StringUtils.isNull(bbVar.zT().getPendantData().yF())) {
                this.cci.setVisibility(8);
                this.cbx.getHeaderImg().setVisibility(0);
                this.cbx.getHeaderImg().setData(bbVar);
            } else {
                this.cbx.getHeaderImg().setVisibility(4);
                this.cci.setVisibility(0);
                this.cci.setData(bbVar);
            }
        }
        L(bbVar);
        M(bbVar);
        this.dUT.setData(bbVar.Az());
        this.dUT.setForumId(String.valueOf(bbVar.getFid()));
        AppletsCellView appletsCellView = this.dUT;
        AppletsCellView appletsCellView2 = this.dUT;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> Ai = bbVar.Ai();
        if (v.I(Ai)) {
            this.cYz.setVisibility(8);
        } else {
            this.cYz.bGc();
            this.cYz.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Ai.get(0);
            this.cYz.setVoiceModel(voiceModel);
            this.cYz.setTag(voiceModel);
            this.cYz.aXt();
            if (voiceModel != null) {
                this.cYz.qK(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> Ae = bbVar.Ae();
        if (com.baidu.tbadk.core.i.xR().xV() && v.H(Ae) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < Ae.size(); i++) {
                MediaData mediaData = (MediaData) v.d(Ae, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.H(linkedList) > 0) {
                this.cYC.setVisibility(0);
                this.cYC.setFromCDN(this.aEU);
                this.cYC.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> aqp = e.this.aqp();
                        if (z) {
                            if (aqp != null) {
                                view.setTag("1");
                                aqp.bwC = true;
                                aqp.a(view, e.this.aFJ);
                            }
                            e.this.fs(false);
                            return;
                        }
                        if (aqp != null) {
                            view.setTag("1");
                            aqp.bwC = false;
                            aqp.a(view, e.this.aFJ);
                        }
                        e.this.a(view, linkedList, i2, bbVar);
                    }
                });
                this.cYC.setImageMediaList(linkedList);
            } else {
                this.cYC.setVisibility(8);
            }
        } else {
            this.cYC.setVisibility(8);
        }
        aqH();
        aqI();
        aFv();
        if (this.cby.isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
            this.mMaskView.setVisibility(0);
            if (this.aFJ.Bu() || this.aFJ.Bv()) {
                al.j(this.mMaskView, e.d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(e.d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aqH() {
        if (this.cYA != null && this.cYC != null && this.cVS != null) {
            if (this.cYC.getVisibility() == 8 && this.cVS.getVisibility() == 8 && this.dUT.getVisibility() == 8) {
                this.cYA.setVisibility(0);
            } else {
                this.cYA.setVisibility(8);
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.dak != null) {
            if (this.dai == null || bbVar == null) {
                this.dak.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avX) && this.dai.getVisibility() != 0) {
                if (this.dUH != null && this.dUH.aIE() && (this.dak.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dak.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.dak.setLayoutParams(layoutParams);
                }
                this.dak.setVisibility(0);
                this.dak.setImageDrawable(null);
                this.dak.startLoad(bbVar.avX, 10, false);
                this.dak.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bbVar.avY, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.dak.setVisibility(8);
            }
        }
    }

    public void Q(bb bbVar) {
        MetaData zT;
        if (bbVar != null && this.dai != null && (zT = bbVar.zT()) != null) {
            final ThemeCardInUserData themeCard = zT.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dai.setVisibility(8);
                return;
            }
            this.dai.setVisibility(0);
            this.dai.setImageDrawable(null);
            this.dai.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.dai.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.aEU ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bbVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.I(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zZ(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bbVar.getId();
            historyMessage.threadName = bbVar.getTitle();
            historyMessage.forumName = bbVar.zZ();
            historyMessage.postID = bbVar.Ak();
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

    private void aqI() {
        this.cYz.setClickable(true);
        int childCount = this.cYC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cYC.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aEU = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cby != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbx != null) {
            this.cbx.setPageUniqueId(bdUniqueId);
        }
        if (this.cYC != null) {
            this.cYC.setPageUniqueId(bdUniqueId);
        }
    }

    protected void fs(boolean z) {
        if (this.aFJ != null) {
            o.mW(this.aFJ.getId());
            o.a(this.mTitle, this.aFJ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cYB, this.aFJ.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cVS.getGodReplyContent(), this.aFJ.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            m AO = this.aFJ.AO();
            if (AO != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bI(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), AO.getCartoonId(), AO.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aFJ.avs;
            if (this.aFJ.avr == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aqR;
                long j = jVar.aqS;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.arf = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aFJ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aFJ.AK() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aqt() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.currentPageType = i;
        if (this.cby != null) {
            this.cby.awp = i;
            if (i == 15) {
                this.cby.setFrom(10);
            } else {
                this.cby.setFrom(2);
                this.cby.setDisPraiseFrom(2);
            }
        }
        if (this.cbx != null) {
            if (i == 15) {
                this.cbx.setFrom(5);
            } else {
                this.cbx.setFrom(3);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cYz != null) {
            this.cYz.setVoiceManager(voiceManager);
        }
    }

    private boolean L(bb bbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dUS)) {
            bbVar.am(this.mUrl, this.dUS);
        }
        SpannableStringBuilder i = bbVar.i(false, true);
        if (i == null || StringUtils.isNull(i.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        return true;
    }

    private void M(bb bbVar) {
        if (bbVar != null && hD(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dUS)) {
                bbVar.am(this.mUrl, this.dUS);
            }
            SpannableString Bm = bbVar.Bm();
            if (Bm != null && !ao.isEmpty(Bm.toString())) {
                this.cYB.setVisibility(0);
                this.cYB.setOnTouchListener(new k(Bm));
                this.cYB.setText(Bm);
                o.a(this.cYB, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cYB.setVisibility(8);
            return;
        }
        this.cYB.setVisibility(8);
    }

    private void aFv() {
        if (this.mTitle != null && this.cYz != null && this.cYC != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYz.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds20);
            this.cYz.setLayoutParams(layoutParams);
            if (this.cYz.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYC.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds28);
                this.cYC.setLayoutParams(layoutParams2);
            }
        }
    }

    public void iM(int i) {
        if (this.aFJ != null) {
            if (i == 1) {
                this.cby.setVisibility(8);
                if (this.ccl != null) {
                    this.ccl.setData(this.aFJ);
                    return;
                }
                return;
            }
            this.cby.setData(this.aFJ);
            if (this.ccl != null) {
                this.ccl.setVisibility(8);
            }
        }
    }

    public void am(String str, String str2) {
        this.mUrl = str;
        this.dUS = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cYC != null) {
            this.cYC.setPreloadSizeReadyCallback(bVar);
        }
    }
}
