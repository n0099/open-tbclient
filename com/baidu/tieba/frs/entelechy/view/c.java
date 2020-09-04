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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, y {
    private TextView afB;
    protected bw afL;
    private String agJ;
    private final View.OnClickListener aiT;
    private PlayVoiceBntNew ajF;
    protected boolean ajt;
    private AppletsCellView akH;
    private RelativeLayout bpx;
    protected View fmI;
    public LinearLayout fuq;
    protected ThreadSourceShareAndPraiseLayout gjQ;
    public ThreadUserInfoLayout gjd;
    protected ThreadCommentAndPraiseInfoLayout gje;
    protected View hjN;
    protected ConstrainImageGroup hjP;
    private View.OnClickListener hjU;
    private final View.OnClickListener hjV;
    private ThreadGodReplyLayout hjp;
    private HeadPendantClickableView hjq;
    private TbImageView hlA;
    public TbImageView hly;
    private i ifi;
    private String ifs;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajt = true;
        this.hjU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) {
                    if (c.this.gje != null) {
                        c.this.gje.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.cbA() != null) {
                    c.this.cbA().a(view, c.this.afL);
                }
                c.this.ng(view == c.this.hjp);
            }
        };
        this.hjV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<bw> cbA = c.this.cbA();
                if (cbA != null) {
                    view.setTag("2");
                    cbA.a(view, c.this.afL);
                }
            }
        };
        this.aiT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cbA() != null) {
                    c.this.cbA().a(view, c.this.afL);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.hjq = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hjq.getHeadView() != null) {
            this.hjq.getHeadView().setIsRound(true);
            this.hjq.getHeadView().setDrawBorder(false);
            this.hjq.getHeadView().setDefaultResource(17170445);
            this.hjq.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjq.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hjq.setHasPendantStyle();
        if (this.hjq.getPendantView() != null) {
            this.hjq.getPendantView().setIsRound(true);
            this.hjq.getPendantView().setDrawBorder(false);
        }
        this.hjq.setAfterClickListener(this.aiT);
        this.fmI = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.ajF = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.ajF.setAfterClickListener(this.hjV);
        this.afB = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.afB.setVisibility(8);
        this.hjN = view.findViewById(R.id.divider_line_above_praise);
        this.hjP = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hjP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hjP.setChildClickListener(this.hjU);
        f fVar = new f(3);
        fVar.u(1.0d);
        this.hjP.setImageProcessor(fVar);
        this.gje = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gjd = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gjd.setUserAfterClickListener(this.aiT);
        this.gjd.setFrom(3);
        this.gje.setOnClickListener(this.hjU);
        this.gje.setForumAfterClickListener(this.aiT);
        this.gje.setReplyTimeVisible(false);
        this.gje.setShowPraiseNum(true);
        this.gje.setNeedAddPraiseIcon(true);
        this.gje.setNeedAddReplyIcon(true);
        this.gje.setIsBarViewVisible(false);
        this.gje.setShareVisible(true);
        this.gje.setShareReportFrom(1);
        this.gje.setStType("frs_page");
        this.gje.setFrom(2);
        this.gje.eua = 3;
        this.gjQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.gjQ != null) {
            this.gjQ.euY.setOnClickListener(this.hjU);
            this.gjQ.setFrom(2);
            this.gjQ.setShareReportFrom(1);
            this.gjQ.setSourceFromForPb(3);
            this.gjQ.setStType("frs_page");
            this.gjQ.setHideBarName(true);
            this.gjQ.euY.setNeedAddReplyIcon(true);
        }
        this.bpx = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.ifi = new i(this.mPageContext, this.bpx);
        this.ifi.setUniqueId(getTag());
        this.hjp = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.hjp.setOnClickListener(this.hjU);
        this.hly = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.hly.setPageId(getTag());
        this.hlA = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.hlA != null) {
            this.hlA.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gje != null) {
                    c.this.gje.changeSelectStatus();
                }
            }
        });
        this.gje.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iB(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ap.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.fuq = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.akH = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.hjP != null) {
            this.hjP.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hjP != null) {
            this.hjP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hjP != null) {
            this.hjP.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.fmI, R.color.cp_bg_line_c);
            this.hjP.onChangeSkinType();
            this.gje.onChangeSkinType();
            this.gjd.onChangeSkinType();
            if (this.akH != null) {
                this.akH.onChangeSkinType();
            }
            this.ifi.onChangeSkinType();
            if (this.gjQ != null && this.gjQ.getVisibility() == 0) {
                this.gjQ.onChangeSkinType();
            }
            if (this.hjq != null && this.hjq.getHeadView() != null && (this.hjq.getHeadView() instanceof TbImageView)) {
                this.hjq.getHeadView().setPlaceHolder(1);
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
    public void a(final bw bwVar) {
        if (bwVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.afL = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hjU);
        }
        this.hjp.onChangeSkinType();
        if (!cbJ() && m.Ha(this.afL.getId())) {
            m.a(this.mTitle, this.afL.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.afB, this.afL.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            m.a(this.hjp.getGodReplyContent(), this.afL.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        b(bwVar);
        this.ifi.ax(this.afL);
        X(bwVar);
        this.gjd.setData(this.afL);
        this.hjp.setFromCDN(this.ajt);
        this.hjp.setData(this.afL.bgh());
        this.gjd.setUserAfterClickListener(this.aiT);
        tB(rY(1));
        if (this.gjd.getHeaderImg() != null) {
            if (this.gjd.getIsSimpleThread()) {
                this.gjd.getHeaderImg().setVisibility(8);
                this.hjq.setVisibility(8);
            } else if (bwVar.beE() == null || bwVar.beE().getPendantData() == null || StringUtils.isNull(bwVar.beE().getPendantData().bcA())) {
                this.hjq.setVisibility(8);
                this.gjd.getHeaderImg().setVisibility(0);
                this.gjd.getHeaderImg().setData(bwVar);
            } else {
                this.gjd.getHeaderImg().setVisibility(4);
                this.hjq.setVisibility(0);
                this.hjq.setData(bwVar);
            }
        }
        aq(bwVar);
        ar(bwVar);
        this.akH.setData(bwVar.bft());
        this.akH.setForumId(String.valueOf(bwVar.getFid()));
        AppletsCellView appletsCellView = this.akH;
        AppletsCellView appletsCellView2 = this.akH;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> beR = bwVar.beR();
        if (com.baidu.tbadk.core.util.y.isEmpty(beR)) {
            this.ajF.setVisibility(8);
        } else {
            this.ajF.bPf();
            this.ajF.setVisibility(0);
            VoiceData.VoiceModel voiceModel = beR.get(0);
            this.ajF.setVoiceModel(voiceModel);
            this.ajF.setTag(voiceModel);
            this.ajF.changeSkin();
            if (voiceModel != null) {
                this.ajF.BM(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> beN = bwVar.beN();
        if (k.bbM().isShowImages() && com.baidu.tbadk.core.util.y.getCount(beN) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < beN.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(beN, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                this.hjP.setVisibility(0);
                this.hjP.setFromCDN(this.ajt);
                this.hjP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        aa<bw> cbA = c.this.cbA();
                        if (z) {
                            if (cbA != null) {
                                view.setTag("1");
                                cbA.ahV = true;
                                cbA.a(view, c.this.afL);
                            }
                            c.this.ng(false);
                            return;
                        }
                        if (cbA != null) {
                            view.setTag("1");
                            cbA.ahV = false;
                            cbA.a(view, c.this.afL);
                        }
                        c.this.a(view, linkedList, i2, bwVar);
                    }
                });
                this.hjP.setImageMediaList(linkedList);
            } else {
                this.hjP.setVisibility(8);
            }
        } else {
            this.hjP.setVisibility(8);
        }
        cbR();
        cbS();
        cpW();
        if ((com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) && this.gje.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.afL.bgp() || this.afL.bgq() || this.afL.bgr()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cbR() {
        if (this.hjN != null && this.hjP != null && this.hjp != null) {
            if (this.hjP.getVisibility() == 8 && this.hjp.getVisibility() == 8 && this.akH.getVisibility() == 8) {
                this.hjN.setVisibility(0);
            } else {
                this.hjN.setVisibility(8);
            }
        }
    }

    private void X(final bw bwVar) {
        if (this.hlA != null) {
            if (this.hly == null || bwVar == null) {
                this.hlA.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.edJ) && this.hly.getVisibility() != 0) {
                if (this.ifi != null && this.ifi.ctF() && (this.hlA.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlA.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hlA.setLayoutParams(layoutParams);
                }
                this.hlA.setVisibility(0);
                this.hlA.setImageDrawable(null);
                this.hlA.startLoad(bwVar.edJ, 10, false);
                this.hlA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bwVar.edK, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hlA.setVisibility(8);
            }
        }
    }

    public void b(bw bwVar) {
        MetaData beE;
        if (bwVar != null && this.hly != null && (beE = bwVar.beE()) != null) {
            final ThemeCardInUserData themeCard = beE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hly.setVisibility(8);
                return;
            }
            this.hly.setVisibility(0);
            this.hly.setImageDrawable(null);
            this.hly.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hly.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.ajt ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).mM(i).yQ(bwVar.beI()).yR(String.valueOf(bwVar.getFid())).yS(bwVar.getTid()).hI(this.ajt).yT(arrayList.size() > 0 ? arrayList.get(0) : "").hJ(true).a(concurrentHashMap).hK(true).r(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig dP = aVar.dP(this.mPageContext.getPageActivity());
            dP.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bwVar.getId();
            historyMessage.threadName = bwVar.getTitle();
            historyMessage.forumName = bwVar.beI();
            historyMessage.postID = bwVar.beV();
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

    private void cbS() {
        this.ajF.setClickable(true);
        int childCount = this.hjP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hjP.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gje != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gjd != null) {
            this.gjd.setPageUniqueId(bdUniqueId);
        }
        if (this.hjP != null) {
            this.hjP.setPageUniqueId(bdUniqueId);
        }
    }

    protected void ng(boolean z) {
        if (this.afL != null) {
            m.GZ(this.afL.getId());
            m.a(this.mTitle, this.afL.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.afB, this.afL.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            m.a(this.hjp.getGodReplyContent(), this.afL.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
            r bfP = this.afL.bfP();
            if (bfP != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bg.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bfP.getCartoonId(), bfP.getChapterId(), 2)));
                return;
            }
            o oVar = this.afL.edh;
            if (this.afL.edg == 1 && oVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = oVar.dXo;
                long j = oVar.dXp;
                au auVar = new au();
                auVar.pageContext = this.mPageContext;
                auVar.dXO = str;
                auVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.afL, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.afL.bfL() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean cbJ() {
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
    public void tz(int i) {
        this.currentPageType = i;
        if (this.gje != null) {
            this.gje.eua = i;
            this.gje.setFrom(2);
        }
        if (this.gjd != null) {
            this.gjd.setFrom(3);
        }
    }

    private boolean aq(bw bwVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ifs)) {
            bwVar.du(this.mUrl, this.ifs);
        }
        SpannableStringBuilder B = bwVar.B(false, true);
        if (B == null || StringUtils.isNull(B.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            m.a(this.mTitle, bwVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        return true;
    }

    private void ar(bw bwVar) {
        if (bwVar != null && rY(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ifs)) {
                bwVar.du(this.mUrl, this.ifs);
            }
            SpannableString bfz = bwVar.bfz();
            if (bfz != null && !at.isEmpty(bfz.toString())) {
                this.afB.setVisibility(0);
                this.afB.setOnTouchListener(new com.baidu.tieba.view.i(bfz));
                this.afB.setText(bfz);
                m.a(this.afB, bwVar.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
                return;
            }
            this.afB.setVisibility(8);
            return;
        }
        this.afB.setVisibility(8);
    }

    private void cpW() {
        if (this.mTitle != null && this.ajF != null && this.hjP != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajF.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.ajF.setLayoutParams(layoutParams);
            if (this.ajF.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hjP.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.hjP.setLayoutParams(layoutParams2);
            }
        }
    }

    public void tB(int i) {
        if (this.afL != null) {
            if (i == 1) {
                this.gje.setVisibility(8);
                if (this.gjQ != null) {
                    this.gjQ.setData(this.afL);
                    return;
                }
                return;
            }
            this.gje.setData(this.afL);
            if (this.gjQ != null) {
                this.gjQ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agJ = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAB().au(this.agJ, i);
    }
}
