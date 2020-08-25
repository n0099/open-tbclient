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
    protected bw afJ;
    private TextView afz;
    private String agH;
    private final View.OnClickListener aiR;
    private PlayVoiceBntNew ajD;
    protected boolean ajr;
    private AppletsCellView akF;
    private RelativeLayout bpu;
    protected View fmE;
    public LinearLayout fum;
    public ThreadUserInfoLayout giZ;
    protected ThreadSourceShareAndPraiseLayout gjM;
    protected ThreadCommentAndPraiseInfoLayout gja;
    protected View hjJ;
    protected ConstrainImageGroup hjL;
    private View.OnClickListener hjQ;
    private final View.OnClickListener hjR;
    private ThreadGodReplyLayout hjl;
    private HeadPendantClickableView hjm;
    public TbImageView hlu;
    private TbImageView hlw;
    private i ifc;
    private String ifm;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajr = true;
        this.hjQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM()) {
                    if (c.this.gja != null) {
                        c.this.gja.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.cbz() != null) {
                    c.this.cbz().a(view, c.this.afJ);
                }
                c.this.ne(view == c.this.hjl);
            }
        };
        this.hjR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<bw> cbz = c.this.cbz();
                if (cbz != null) {
                    view.setTag("2");
                    cbz.a(view, c.this.afJ);
                }
            }
        };
        this.aiR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cbz() != null) {
                    c.this.cbz().a(view, c.this.afJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.hjm = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hjm.getHeadView() != null) {
            this.hjm.getHeadView().setIsRound(true);
            this.hjm.getHeadView().setDrawBorder(false);
            this.hjm.getHeadView().setDefaultResource(17170445);
            this.hjm.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjm.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hjm.setHasPendantStyle();
        if (this.hjm.getPendantView() != null) {
            this.hjm.getPendantView().setIsRound(true);
            this.hjm.getPendantView().setDrawBorder(false);
        }
        this.hjm.setAfterClickListener(this.aiR);
        this.fmE = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.ajD = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.ajD.setAfterClickListener(this.hjR);
        this.afz = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.afz.setVisibility(8);
        this.hjJ = view.findViewById(R.id.divider_line_above_praise);
        this.hjL = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hjL.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hjL.setChildClickListener(this.hjQ);
        f fVar = new f(3);
        fVar.u(1.0d);
        this.hjL.setImageProcessor(fVar);
        this.gja = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.giZ = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.giZ.setUserAfterClickListener(this.aiR);
        this.giZ.setFrom(3);
        this.gja.setOnClickListener(this.hjQ);
        this.gja.setForumAfterClickListener(this.aiR);
        this.gja.setReplyTimeVisible(false);
        this.gja.setShowPraiseNum(true);
        this.gja.setNeedAddPraiseIcon(true);
        this.gja.setNeedAddReplyIcon(true);
        this.gja.setIsBarViewVisible(false);
        this.gja.setShareVisible(true);
        this.gja.setShareReportFrom(1);
        this.gja.setStType("frs_page");
        this.gja.setFrom(2);
        this.gja.etW = 3;
        this.gjM = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.gjM != null) {
            this.gjM.euU.setOnClickListener(this.hjQ);
            this.gjM.setFrom(2);
            this.gjM.setShareReportFrom(1);
            this.gjM.setSourceFromForPb(3);
            this.gjM.setStType("frs_page");
            this.gjM.setHideBarName(true);
            this.gjM.euU.setNeedAddReplyIcon(true);
        }
        this.bpu = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.ifc = new i(this.mPageContext, this.bpu);
        this.ifc.setUniqueId(getTag());
        this.hjl = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.hjl.setOnClickListener(this.hjQ);
        this.hlu = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.hlu.setPageId(getTag());
        this.hlw = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.hlw != null) {
            this.hlw.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gja != null) {
                    c.this.gja.changeSelectStatus();
                }
            }
        });
        this.gja.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iA(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ap.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.fum = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.akF = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.hjL != null) {
            this.hjL.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hjL != null) {
            this.hjL.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hjL != null) {
            this.hjL.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.fmE, R.color.cp_bg_line_c);
            this.hjL.onChangeSkinType();
            this.gja.onChangeSkinType();
            this.giZ.onChangeSkinType();
            if (this.akF != null) {
                this.akF.onChangeSkinType();
            }
            this.ifc.onChangeSkinType();
            if (this.gjM != null && this.gjM.getVisibility() == 0) {
                this.gjM.onChangeSkinType();
            }
            if (this.hjm != null && this.hjm.getHeadView() != null && (this.hjm.getHeadView() instanceof TbImageView)) {
                this.hjm.getHeadView().setPlaceHolder(1);
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
        this.afJ = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hjQ);
        }
        this.hjl.onChangeSkinType();
        if (!cbI() && m.GZ(this.afJ.getId())) {
            m.a(this.mTitle, this.afJ.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.afz, this.afJ.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            m.a(this.hjl.getGodReplyContent(), this.afJ.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        b(bwVar);
        this.ifc.ax(this.afJ);
        X(bwVar);
        this.giZ.setData(this.afJ);
        this.hjl.setFromCDN(this.ajr);
        this.hjl.setData(this.afJ.bgh());
        this.giZ.setUserAfterClickListener(this.aiR);
        tB(rY(1));
        if (this.giZ.getHeaderImg() != null) {
            if (this.giZ.getIsSimpleThread()) {
                this.giZ.getHeaderImg().setVisibility(8);
                this.hjm.setVisibility(8);
            } else if (bwVar.beE() == null || bwVar.beE().getPendantData() == null || StringUtils.isNull(bwVar.beE().getPendantData().bcA())) {
                this.hjm.setVisibility(8);
                this.giZ.getHeaderImg().setVisibility(0);
                this.giZ.getHeaderImg().setData(bwVar);
            } else {
                this.giZ.getHeaderImg().setVisibility(4);
                this.hjm.setVisibility(0);
                this.hjm.setData(bwVar);
            }
        }
        aq(bwVar);
        ar(bwVar);
        this.akF.setData(bwVar.bft());
        this.akF.setForumId(String.valueOf(bwVar.getFid()));
        AppletsCellView appletsCellView = this.akF;
        AppletsCellView appletsCellView2 = this.akF;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> beR = bwVar.beR();
        if (com.baidu.tbadk.core.util.y.isEmpty(beR)) {
            this.ajD.setVisibility(8);
        } else {
            this.ajD.bPe();
            this.ajD.setVisibility(0);
            VoiceData.VoiceModel voiceModel = beR.get(0);
            this.ajD.setVoiceModel(voiceModel);
            this.ajD.setTag(voiceModel);
            this.ajD.changeSkin();
            if (voiceModel != null) {
                this.ajD.BM(voiceModel.voice_status.intValue());
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
                this.hjL.setVisibility(0);
                this.hjL.setFromCDN(this.ajr);
                this.hjL.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        aa<bw> cbz = c.this.cbz();
                        if (z) {
                            if (cbz != null) {
                                view.setTag("1");
                                cbz.ahT = true;
                                cbz.a(view, c.this.afJ);
                            }
                            c.this.ne(false);
                            return;
                        }
                        if (cbz != null) {
                            view.setTag("1");
                            cbz.ahT = false;
                            cbz.a(view, c.this.afJ);
                        }
                        c.this.a(view, linkedList, i2, bwVar);
                    }
                });
                this.hjL.setImageMediaList(linkedList);
            } else {
                this.hjL.setVisibility(8);
            }
        } else {
            this.hjL.setVisibility(8);
        }
        cbQ();
        cbR();
        cpV();
        if ((com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM()) && this.gja.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.afJ.bgp() || this.afJ.bgq() || this.afJ.bgr()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cbQ() {
        if (this.hjJ != null && this.hjL != null && this.hjl != null) {
            if (this.hjL.getVisibility() == 8 && this.hjl.getVisibility() == 8 && this.akF.getVisibility() == 8) {
                this.hjJ.setVisibility(0);
            } else {
                this.hjJ.setVisibility(8);
            }
        }
    }

    private void X(final bw bwVar) {
        if (this.hlw != null) {
            if (this.hlu == null || bwVar == null) {
                this.hlw.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.edF) && this.hlu.getVisibility() != 0) {
                if (this.ifc != null && this.ifc.ctE() && (this.hlw.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlw.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hlw.setLayoutParams(layoutParams);
                }
                this.hlw.setVisibility(0);
                this.hlw.setImageDrawable(null);
                this.hlw.startLoad(bwVar.edF, 10, false);
                this.hlw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bwVar.edG, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hlw.setVisibility(8);
            }
        }
    }

    public void b(bw bwVar) {
        MetaData beE;
        if (bwVar != null && this.hlu != null && (beE = bwVar.beE()) != null) {
            final ThemeCardInUserData themeCard = beE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hlu.setVisibility(8);
                return;
            }
            this.hlu.setVisibility(0);
            this.hlu.setImageDrawable(null);
            this.hlu.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hlu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.urlType = this.ajr ? 13 : 14;
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
            aVar.x(arrayList).mM(i).yP(bwVar.beI()).yQ(String.valueOf(bwVar.getFid())).yR(bwVar.getTid()).hH(this.ajr).yS(arrayList.size() > 0 ? arrayList.get(0) : "").hI(true).a(concurrentHashMap).hJ(true).r(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
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

    private void cbR() {
        this.ajD.setClickable(true);
        int childCount = this.hjL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hjL.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gja != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.giZ != null) {
            this.giZ.setPageUniqueId(bdUniqueId);
        }
        if (this.hjL != null) {
            this.hjL.setPageUniqueId(bdUniqueId);
        }
    }

    protected void ne(boolean z) {
        if (this.afJ != null) {
            m.GY(this.afJ.getId());
            m.a(this.mTitle, this.afJ.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.afz, this.afJ.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            m.a(this.hjl.getGodReplyContent(), this.afJ.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
            r bfP = this.afJ.bfP();
            if (bfP != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bg.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bfP.getCartoonId(), bfP.getChapterId(), 2)));
                return;
            }
            o oVar = this.afJ.edd;
            if (this.afJ.edc == 1 && oVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = oVar.dXk;
                long j = oVar.dXl;
                au auVar = new au();
                auVar.pageContext = this.mPageContext;
                auVar.dXK = str;
                auVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.afJ, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.afJ.bfL() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean cbI() {
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
        if (this.gja != null) {
            this.gja.etW = i;
            this.gja.setFrom(2);
        }
        if (this.giZ != null) {
            this.giZ.setFrom(3);
        }
    }

    private boolean aq(bw bwVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ifm)) {
            bwVar.du(this.mUrl, this.ifm);
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ifm)) {
                bwVar.du(this.mUrl, this.ifm);
            }
            SpannableString bfz = bwVar.bfz();
            if (bfz != null && !at.isEmpty(bfz.toString())) {
                this.afz.setVisibility(0);
                this.afz.setOnTouchListener(new com.baidu.tieba.view.i(bfz));
                this.afz.setText(bfz);
                m.a(this.afz, bwVar.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
                return;
            }
            this.afz.setVisibility(8);
            return;
        }
        this.afz.setVisibility(8);
    }

    private void cpV() {
        if (this.mTitle != null && this.ajD != null && this.hjL != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajD.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.ajD.setLayoutParams(layoutParams);
            if (this.ajD.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hjL.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.hjL.setLayoutParams(layoutParams2);
            }
        }
    }

    public void tB(int i) {
        if (this.afJ != null) {
            if (i == 1) {
                this.gja.setVisibility(8);
                if (this.gjM != null) {
                    this.gjM.setData(this.afJ);
                    return;
                }
                return;
            }
            this.gja.setData(this.afJ);
            if (this.gjM != null) {
                this.gjM.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agH = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAA().au(this.agH, i);
    }
}
