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
    protected boolean aET;
    protected bb aFI;
    private final View.OnClickListener aLe;
    protected View bzG;
    private ThreadGodReplyLayout cVR;
    private View.OnClickListener cVU;
    private TextView cYA;
    protected ConstrainImageGroup cYB;
    private final View.OnClickListener cYE;
    private PlayVoiceBntNew cYy;
    protected View cYz;
    private String cbk;
    public ThreadUserInfoLayout cbw;
    protected ThreadCommentAndPraiseInfoLayout cbx;
    private HeadPendantClickableView cch;
    protected ThreadSourceShareAndPraiseLayout cck;
    public LinearLayout ccw;
    private com.baidu.tieba.frs.vc.g dUG;
    private String dUR;
    private AppletsCellView dUS;
    public TbImageView dah;
    private TbImageView daj;
    private RelativeLayout drQ;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aET = true;
        this.cVU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.aBg().aBh()) {
                    if (e.this.cbx != null) {
                        e.this.cbx.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (e.this.aqp() != null) {
                    e.this.aqp().a(view, e.this.aFI);
                }
                e.this.fs(view == e.this.cVR);
            }
        };
        this.cYE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> aqp = e.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, e.this.aFI);
                }
            }
        };
        this.aLe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aqp() != null) {
                    e.this.aqp().a(view, e.this.aFI);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cch = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cch.getHeadView() != null) {
            this.cch.getHeadView().setIsRound(true);
            this.cch.getHeadView().setDrawBorder(false);
            this.cch.getHeadView().setDefaultResource(17170445);
            this.cch.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cch.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cch.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cch.setHasPendantStyle();
        if (this.cch.getPendantView() != null) {
            this.cch.getPendantView().setIsRound(true);
            this.cch.getPendantView().setDrawBorder(false);
        }
        this.cch.setAfterClickListener(this.aLe);
        this.bzG = view.findViewById(e.g.divider_line);
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cYy = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cYy.setAfterClickListener(this.cYE);
        this.cYA = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cYA.setVisibility(8);
        this.cYz = view.findViewById(e.g.divider_line_above_praise);
        this.cYB = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cYB.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        this.cYB.setChildClickListener(this.cVU);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cYB.setImageProcessor(eVar);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.cbw = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.cbw.setUserAfterClickListener(this.aLe);
        this.cbw.setFrom(3);
        this.cbx.setOnClickListener(this.cVU);
        this.cbx.setForumAfterClickListener(this.aLe);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setIsBarViewVisible(false);
        this.cbx.setShareVisible(true);
        this.cbx.setShareReportFrom(1);
        this.cbx.setStType("frs_page");
        this.cbx.setFrom(2);
        this.cbx.setDisPraiseFrom(2);
        this.cbx.awo = 3;
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        if (this.cck != null) {
            this.cck.aKM.setOnClickListener(this.cVU);
            this.cck.setFrom(2);
            this.cck.setShareReportFrom(1);
            this.cck.setSourceFromForPb(3);
            this.cck.setStType("frs_page");
            this.cck.setHideBarName(true);
            this.cck.aKM.setNeedAddReplyIcon(true);
        }
        this.drQ = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.dUG = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.drQ);
        this.dUG.setUniqueId(getTag());
        this.cVR = (ThreadGodReplyLayout) view.findViewById(e.g.card_frs_god_reply_layout);
        this.cVR.setOnClickListener(this.cVU);
        this.dah = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.dah.setPageId(getTag());
        this.daj = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        if (this.daj != null) {
            this.daj.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.cbx != null) {
                    e.this.cbx.changeSelectStatus();
                }
            }
        });
        this.cbx.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bK(boolean z) {
                if (e.this.mMaskView != null) {
                    e.this.mMaskView.setBackgroundColor(al.getColor(z ? e.d.cp_bg_line_d : e.d.transparent));
                }
            }
        });
        this.ccw = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.dUS = (AppletsCellView) view.findViewById(e.g.card_home_page_normal_thread_share_info);
    }

    public ThreadCommentAndPraiseInfoLayout acN() {
        return this.cbx;
    }

    public ThreadCommentAndPraiseInfoLayout acO() {
        if (this.cck != null) {
            return this.cck.aKM;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.cYB != null) {
            this.cYB.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYB != null) {
            this.cYB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYB != null) {
            this.cYB.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.bzG, e.d.cp_bg_line_e);
            this.cYB.onChangeSkinType();
            this.cbx.onChangeSkinType();
            this.cbw.onChangeSkinType();
            this.dUG.onChangeSkinType();
            if (this.cck != null && this.cck.getVisibility() == 0) {
                this.cck.onChangeSkinType();
            }
            if (this.dUS != null) {
                this.dUS.onChangeSkinType();
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
        this.aFI = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVU);
        }
        this.cVR.onChangeSkinType();
        if (!aqt() && o.mX(this.aFI.getId())) {
            o.a(this.mTitle, this.aFI.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cYA, this.aFI.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cVR.getGodReplyContent(), this.aFI.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        Q(bbVar);
        this.dUG.af(this.aFI);
        N(bbVar);
        this.cbw.setData(this.aFI);
        this.cVR.setFromCDN(this.aET);
        this.cVR.setData(this.aFI.Bk());
        this.cbw.setUserAfterClickListener(this.aLe);
        iM(hD(1));
        if (this.cbw.getHeaderImg() != null) {
            if (this.cbw.getIsSimpleThread()) {
                this.cbw.getHeaderImg().setVisibility(8);
                this.cch.setVisibility(8);
            } else if (bbVar.zT() == null || bbVar.zT().getPendantData() == null || StringUtils.isNull(bbVar.zT().getPendantData().yF())) {
                this.cch.setVisibility(8);
                this.cbw.getHeaderImg().setVisibility(0);
                this.cbw.getHeaderImg().setData(bbVar);
            } else {
                this.cbw.getHeaderImg().setVisibility(4);
                this.cch.setVisibility(0);
                this.cch.setData(bbVar);
            }
        }
        L(bbVar);
        M(bbVar);
        this.dUS.setData(bbVar.Az());
        this.dUS.setForumId(String.valueOf(bbVar.getFid()));
        AppletsCellView appletsCellView = this.dUS;
        AppletsCellView appletsCellView2 = this.dUS;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> Ai = bbVar.Ai();
        if (v.I(Ai)) {
            this.cYy.setVisibility(8);
        } else {
            this.cYy.bGc();
            this.cYy.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Ai.get(0);
            this.cYy.setVoiceModel(voiceModel);
            this.cYy.setTag(voiceModel);
            this.cYy.aXt();
            if (voiceModel != null) {
                this.cYy.qK(voiceModel.voice_status.intValue());
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
                this.cYB.setVisibility(0);
                this.cYB.setFromCDN(this.aET);
                this.cYB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> aqp = e.this.aqp();
                        if (z) {
                            if (aqp != null) {
                                view.setTag("1");
                                aqp.bwB = true;
                                aqp.a(view, e.this.aFI);
                            }
                            e.this.fs(false);
                            return;
                        }
                        if (aqp != null) {
                            view.setTag("1");
                            aqp.bwB = false;
                            aqp.a(view, e.this.aFI);
                        }
                        e.this.a(view, linkedList, i2, bbVar);
                    }
                });
                this.cYB.setImageMediaList(linkedList);
            } else {
                this.cYB.setVisibility(8);
            }
        } else {
            this.cYB.setVisibility(8);
        }
        aqH();
        aqI();
        aFv();
        if (this.cbx.isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
            this.mMaskView.setVisibility(0);
            if (this.aFI.Bu() || this.aFI.Bv()) {
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
        if (this.cYz != null && this.cYB != null && this.cVR != null) {
            if (this.cYB.getVisibility() == 8 && this.cVR.getVisibility() == 8 && this.dUS.getVisibility() == 8) {
                this.cYz.setVisibility(0);
            } else {
                this.cYz.setVisibility(8);
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.daj != null) {
            if (this.dah == null || bbVar == null) {
                this.daj.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avW) && this.dah.getVisibility() != 0) {
                if (this.dUG != null && this.dUG.aIE() && (this.daj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daj.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.daj.setLayoutParams(layoutParams);
                }
                this.daj.setVisibility(0);
                this.daj.setImageDrawable(null);
                this.daj.startLoad(bbVar.avW, 10, false);
                this.daj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bbVar.avX, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.daj.setVisibility(8);
            }
        }
    }

    public void Q(bb bbVar) {
        MetaData zT;
        if (bbVar != null && this.dah != null && (zT = bbVar.zT()) != null) {
            final ThemeCardInUserData themeCard = zT.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dah.setVisibility(8);
                return;
            }
            this.dah.setVisibility(0);
            this.dah.setImageDrawable(null);
            this.dah.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.dah.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
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
                imageUrlData.urlType = this.aET ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zZ(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aET, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        this.cYy.setClickable(true);
        int childCount = this.cYB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cYB.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aET = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cbx != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbw != null) {
            this.cbw.setPageUniqueId(bdUniqueId);
        }
        if (this.cYB != null) {
            this.cYB.setPageUniqueId(bdUniqueId);
        }
    }

    protected void fs(boolean z) {
        if (this.aFI != null) {
            o.mW(this.aFI.getId());
            o.a(this.mTitle, this.aFI.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cYA, this.aFI.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cVR.getGodReplyContent(), this.aFI.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            m AO = this.aFI.AO();
            if (AO != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bI(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), AO.getCartoonId(), AO.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aFI.avr;
            if (this.aFI.avq == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aqQ;
                long j = jVar.aqR;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.are = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aFI, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aFI.AK() && addLocateParam.getIntent() != null) {
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
        if (this.cbx != null) {
            this.cbx.awo = i;
            if (i == 15) {
                this.cbx.setFrom(10);
            } else {
                this.cbx.setFrom(2);
                this.cbx.setDisPraiseFrom(2);
            }
        }
        if (this.cbw != null) {
            if (i == 15) {
                this.cbw.setFrom(5);
            } else {
                this.cbw.setFrom(3);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cYy != null) {
            this.cYy.setVoiceManager(voiceManager);
        }
    }

    private boolean L(bb bbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dUR)) {
            bbVar.am(this.mUrl, this.dUR);
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dUR)) {
                bbVar.am(this.mUrl, this.dUR);
            }
            SpannableString Bm = bbVar.Bm();
            if (Bm != null && !ao.isEmpty(Bm.toString())) {
                this.cYA.setVisibility(0);
                this.cYA.setOnTouchListener(new k(Bm));
                this.cYA.setText(Bm);
                o.a(this.cYA, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cYA.setVisibility(8);
            return;
        }
        this.cYA.setVisibility(8);
    }

    private void aFv() {
        if (this.mTitle != null && this.cYy != null && this.cYB != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYy.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds20);
            this.cYy.setLayoutParams(layoutParams);
            if (this.cYy.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYB.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds28);
                this.cYB.setLayoutParams(layoutParams2);
            }
        }
    }

    public void iM(int i) {
        if (this.aFI != null) {
            if (i == 1) {
                this.cbx.setVisibility(8);
                if (this.cck != null) {
                    this.cck.setData(this.aFI);
                    return;
                }
                return;
            }
            this.cbx.setData(this.aFI);
            if (this.cck != null) {
                this.cck.setVisibility(8);
            }
        }
    }

    public void am(String str, String str2) {
        this.mUrl = str;
        this.dUR = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cYB != null) {
            this.cYB.setPreloadSizeReadyCallback(bVar);
        }
    }
}
