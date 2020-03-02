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
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private TextView KA;
    protected bj KJ;
    private String LC;
    protected boolean NJ;
    private PlayVoiceBntNew NY;
    private final View.OnClickListener Nw;
    private AppletsCellView OO;
    private RelativeLayout aCQ;
    protected View cem;
    protected ThreadSourceShareAndPraiseLayout eNY;
    public ThreadUserInfoLayout eNl;
    protected ThreadCommentAndPraiseInfoLayout eNm;
    public LinearLayout egG;
    protected View fJN;
    protected ConstrainImageGroup fJP;
    private View.OnClickListener fJU;
    private final View.OnClickListener fJV;
    private ThreadGodReplyLayout fJo;
    private HeadPendantClickableView fJp;
    public TbImageView fLv;
    private TbImageView fLx;
    private i gyk;
    private String gyu;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.NJ = true;
        this.fJU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bCV().bCW()) {
                    if (c.this.eNm != null) {
                        c.this.eNm.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.buG() != null) {
                    c.this.buG().a(view, c.this.KJ);
                }
                c.this.kj(view == c.this.fJo);
            }
        };
        this.fJV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<bj> buG = c.this.buG();
                if (buG != null) {
                    view.setTag("2");
                    buG.a(view, c.this.KJ);
                }
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.buG() != null) {
                    c.this.buG().a(view, c.this.KJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.fJp = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.fJp.getHeadView() != null) {
            this.fJp.getHeadView().setIsRound(true);
            this.fJp.getHeadView().setDrawBorder(false);
            this.fJp.getHeadView().setDefaultResource(17170445);
            this.fJp.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJp.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.fJp.setHasPendantStyle();
        if (this.fJp.getPendantView() != null) {
            this.fJp.getPendantView().setIsRound(true);
            this.fJp.getPendantView().setDrawBorder(false);
        }
        this.fJp.setAfterClickListener(this.Nw);
        this.cem = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.NY = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.NY.setAfterClickListener(this.fJV);
        this.KA = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.KA.setVisibility(8);
        this.fJN = view.findViewById(R.id.divider_line_above_praise);
        this.fJP = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.fJP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fJP.setChildClickListener(this.fJU);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fJP.setImageProcessor(fVar);
        this.eNm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.eNl = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.eNl.setUserAfterClickListener(this.Nw);
        this.eNl.setFrom(3);
        this.eNm.setOnClickListener(this.fJU);
        this.eNm.setForumAfterClickListener(this.Nw);
        this.eNm.setReplyTimeVisible(false);
        this.eNm.setShowPraiseNum(true);
        this.eNm.setNeedAddPraiseIcon(true);
        this.eNm.setNeedAddReplyIcon(true);
        this.eNm.setIsBarViewVisible(false);
        this.eNm.setShareVisible(true);
        this.eNm.setShareReportFrom(1);
        this.eNm.setStType("frs_page");
        this.eNm.setFrom(2);
        this.eNm.dhG = 3;
        this.eNY = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.eNY != null) {
            this.eNY.diH.setOnClickListener(this.fJU);
            this.eNY.setFrom(2);
            this.eNY.setShareReportFrom(1);
            this.eNY.setSourceFromForPb(3);
            this.eNY.setStType("frs_page");
            this.eNY.setHideBarName(true);
            this.eNY.diH.setNeedAddReplyIcon(true);
        }
        this.aCQ = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gyk = new i(this.mPageContext, this.aCQ);
        this.gyk.setUniqueId(getTag());
        this.fJo = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.fJo.setOnClickListener(this.fJU);
        this.fLv = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.fLv.setPageId(getTag());
        this.fLx = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.fLx != null) {
            this.fLx.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eNm != null) {
                    c.this.eNm.changeSelectStatus();
                }
            }
        });
        this.eNm.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fT(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.egG = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.OO = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.fJP != null) {
            this.fJP.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fJP != null) {
            this.fJP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fJP != null) {
            this.fJP.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.cem, R.color.cp_bg_line_c);
            this.fJP.onChangeSkinType();
            this.eNm.onChangeSkinType();
            this.eNl.onChangeSkinType();
            if (this.OO != null) {
                this.OO.onChangeSkinType();
            }
            this.gyk.onChangeSkinType();
            if (this.eNY != null && this.eNY.getVisibility() == 0) {
                this.eNY.onChangeSkinType();
            }
            if (this.fJp != null && this.fJp.getHeadView() != null && (this.fJp.getHeadView() instanceof TbImageView)) {
                this.fJp.getHeadView().setPlaceHolder(1);
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
        this.KJ = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fJU);
        }
        this.fJo.onChangeSkinType();
        if (!buR() && com.baidu.tieba.card.l.zT(this.KJ.getId())) {
            com.baidu.tieba.card.l.a(this.mTitle, this.KJ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.KA, this.KJ.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fJo.getGodReplyContent(), this.KJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bjVar);
        this.gyk.ax(this.KJ);
        X(bjVar);
        this.eNl.setData(this.KJ);
        this.fJo.setFromCDN(this.NJ);
        this.fJo.setData(this.KJ.aDM());
        this.eNl.setUserAfterClickListener(this.Nw);
        pB(oc(1));
        if (this.eNl.getHeaderImg() != null) {
            if (this.eNl.getIsSimpleThread()) {
                this.eNl.getHeaderImg().setVisibility(8);
                this.fJp.setVisibility(8);
            } else if (bjVar.aCo() == null || bjVar.aCo().getPendantData() == null || StringUtils.isNull(bjVar.aCo().getPendantData().aAG())) {
                this.fJp.setVisibility(8);
                this.eNl.getHeaderImg().setVisibility(0);
                this.eNl.getHeaderImg().setData(bjVar);
            } else {
                this.eNl.getHeaderImg().setVisibility(4);
                this.fJp.setVisibility(0);
                this.fJp.setData(bjVar);
            }
        }
        aq(bjVar);
        ar(bjVar);
        this.OO.setData(bjVar.aDa());
        this.OO.setForumId(String.valueOf(bjVar.getFid()));
        AppletsCellView appletsCellView = this.OO;
        AppletsCellView appletsCellView2 = this.OO;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aCC = bjVar.aCC();
        if (v.isEmpty(aCC)) {
            this.NY.setVisibility(8);
        } else {
            this.NY.cMh();
            this.NY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aCC.get(0);
            this.NY.setVoiceModel(voiceModel);
            this.NY.setTag(voiceModel);
            this.NY.bHs();
            if (voiceModel != null) {
                this.NY.wW(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aCy = bjVar.aCy();
        if (com.baidu.tbadk.core.i.azO().isShowImages() && v.getCount(aCy) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aCy.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aCy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.fJP.setVisibility(0);
                this.fJP.setFromCDN(this.NJ);
                this.fJP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        z<bj> buG = c.this.buG();
                        if (z) {
                            if (buG != null) {
                                view.setTag("1");
                                buG.MU = true;
                                buG.a(view, c.this.KJ);
                            }
                            c.this.kj(false);
                            return;
                        }
                        if (buG != null) {
                            view.setTag("1");
                            buG.MU = false;
                            buG.a(view, c.this.KJ);
                        }
                        c.this.a(view, linkedList, i2, bjVar);
                    }
                });
                this.fJP.setImageMediaList(linkedList);
            } else {
                this.fJP.setVisibility(8);
            }
        } else {
            this.fJP.setVisibility(8);
        }
        buZ();
        bva();
        bHu();
        if (this.eNm.isInFrsAllThread() && com.baidu.tieba.frs.a.bCV().bCW()) {
            this.mMaskView.setVisibility(0);
            if (this.KJ.aDV() || this.KJ.aDW()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void buZ() {
        if (this.fJN != null && this.fJP != null && this.fJo != null) {
            if (this.fJP.getVisibility() == 8 && this.fJo.getVisibility() == 8 && this.OO.getVisibility() == 8) {
                this.fJN.setVisibility(0);
            } else {
                this.fJN.setVisibility(8);
            }
        }
    }

    private void X(final bj bjVar) {
        if (this.fLx != null) {
            if (this.fLv == null || bjVar == null) {
                this.fLx.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cTR) && this.fLv.getVisibility() != 0) {
                if (this.gyk != null && this.gyk.bKP() && (this.fLx.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLx.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fLx.setLayoutParams(layoutParams);
                }
                this.fLx.setVisibility(0);
                this.fLx.setImageDrawable(null);
                this.fLx.startLoad(bjVar.cTR, 10, false);
                this.fLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bjVar.cTS, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fLx.setVisibility(8);
            }
        }
    }

    public void b(bj bjVar) {
        MetaData aCo;
        if (bjVar != null && this.fLv != null && (aCo = bjVar.aCo()) != null) {
            final ThemeCardInUserData themeCard = aCo.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fLv.setVisibility(8);
                return;
            }
            this.fLv.setVisibility(0);
            this.fLv.setImageDrawable(null);
            this.fLv.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.urlType = this.NJ ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCt(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
            historyMessage.forumName = bjVar.aCt();
            historyMessage.postID = bjVar.aCE();
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

    private void bva() {
        this.NY.setClickable(true);
        int childCount = this.fJP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fJP.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNm != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eNl != null) {
            this.eNl.setPageUniqueId(bdUniqueId);
        }
        if (this.fJP != null) {
            this.fJP.setPageUniqueId(bdUniqueId);
        }
    }

    protected void kj(boolean z) {
        if (this.KJ != null) {
            com.baidu.tieba.card.l.zS(this.KJ.getId());
            com.baidu.tieba.card.l.a(this.mTitle, this.KJ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.KA, this.KJ.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fJo.getGodReplyContent(), this.KJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            p aDv = this.KJ.aDv();
            if (aDv != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aDv.getCartoonId(), aDv.getChapterId(), 2)));
                return;
            }
            m mVar = this.KJ.cTp;
            if (this.KJ.cTo == 1 && mVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = mVar.cNZ;
                long j = mVar.cOa;
                ao aoVar = new ao();
                aoVar.pageContext = this.mPageContext;
                aoVar.cOn = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.KJ, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.KJ.aDr() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean buR() {
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
    public void pz(int i) {
        this.currentPageType = i;
        if (this.eNm != null) {
            this.eNm.dhG = i;
            this.eNm.setFrom(2);
        }
        if (this.eNl != null) {
            this.eNl.setFrom(3);
        }
    }

    private boolean aq(bj bjVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.gyu)) {
            bjVar.cp(this.mUrl, this.gyu);
        }
        SpannableStringBuilder u = bjVar.u(false, true);
        if (u == null || StringUtils.isNull(u.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new h(u));
            this.mTitle.setText(u);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void ar(bj bjVar) {
        if (bjVar != null && oc(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.gyu)) {
                bjVar.cp(this.mUrl, this.gyu);
            }
            SpannableString aDg = bjVar.aDg();
            if (aDg != null && !aq.isEmpty(aDg.toString())) {
                this.KA.setVisibility(0);
                this.KA.setOnTouchListener(new h(aDg));
                this.KA.setText(aDg);
                com.baidu.tieba.card.l.a(this.KA, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.KA.setVisibility(8);
            return;
        }
        this.KA.setVisibility(8);
    }

    private void bHu() {
        if (this.mTitle != null && this.NY != null && this.fJP != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.NY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.NY.setLayoutParams(layoutParams);
            if (this.NY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fJP.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.fJP.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pB(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNm.setVisibility(8);
                if (this.eNY != null) {
                    this.eNY.setData(this.KJ);
                    return;
                }
                return;
            }
            this.eNm.setData(this.KJ);
            if (this.eNY != null) {
                this.eNY.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXF().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fJP != null) {
            this.fJP.setPreloadSizeReadyCallback(bVar);
        }
    }
}
