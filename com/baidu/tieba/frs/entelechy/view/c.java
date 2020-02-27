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
    private RelativeLayout aCP;
    protected View cel;
    protected ThreadSourceShareAndPraiseLayout eNX;
    public ThreadUserInfoLayout eNk;
    protected ThreadCommentAndPraiseInfoLayout eNl;
    public LinearLayout egF;
    protected View fJL;
    protected ConstrainImageGroup fJN;
    private View.OnClickListener fJS;
    private final View.OnClickListener fJT;
    private ThreadGodReplyLayout fJm;
    private HeadPendantClickableView fJn;
    public TbImageView fLt;
    private TbImageView fLv;
    private i gyi;
    private String gys;
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
        this.fJS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bCT().bCU()) {
                    if (c.this.eNl != null) {
                        c.this.eNl.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.buE() != null) {
                    c.this.buE().a(view, c.this.KJ);
                }
                c.this.kj(view == c.this.fJm);
            }
        };
        this.fJT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<bj> buE = c.this.buE();
                if (buE != null) {
                    view.setTag("2");
                    buE.a(view, c.this.KJ);
                }
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.buE() != null) {
                    c.this.buE().a(view, c.this.KJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.fJn = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.fJn.getHeadView() != null) {
            this.fJn.getHeadView().setIsRound(true);
            this.fJn.getHeadView().setDrawBorder(false);
            this.fJn.getHeadView().setDefaultResource(17170445);
            this.fJn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJn.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.fJn.setHasPendantStyle();
        if (this.fJn.getPendantView() != null) {
            this.fJn.getPendantView().setIsRound(true);
            this.fJn.getPendantView().setDrawBorder(false);
        }
        this.fJn.setAfterClickListener(this.Nw);
        this.cel = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.NY = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.NY.setAfterClickListener(this.fJT);
        this.KA = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.KA.setVisibility(8);
        this.fJL = view.findViewById(R.id.divider_line_above_praise);
        this.fJN = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.fJN.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fJN.setChildClickListener(this.fJS);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fJN.setImageProcessor(fVar);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.eNk = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.eNk.setUserAfterClickListener(this.Nw);
        this.eNk.setFrom(3);
        this.eNl.setOnClickListener(this.fJS);
        this.eNl.setForumAfterClickListener(this.Nw);
        this.eNl.setReplyTimeVisible(false);
        this.eNl.setShowPraiseNum(true);
        this.eNl.setNeedAddPraiseIcon(true);
        this.eNl.setNeedAddReplyIcon(true);
        this.eNl.setIsBarViewVisible(false);
        this.eNl.setShareVisible(true);
        this.eNl.setShareReportFrom(1);
        this.eNl.setStType("frs_page");
        this.eNl.setFrom(2);
        this.eNl.dhF = 3;
        this.eNX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.eNX != null) {
            this.eNX.diG.setOnClickListener(this.fJS);
            this.eNX.setFrom(2);
            this.eNX.setShareReportFrom(1);
            this.eNX.setSourceFromForPb(3);
            this.eNX.setStType("frs_page");
            this.eNX.setHideBarName(true);
            this.eNX.diG.setNeedAddReplyIcon(true);
        }
        this.aCP = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gyi = new i(this.mPageContext, this.aCP);
        this.gyi.setUniqueId(getTag());
        this.fJm = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.fJm.setOnClickListener(this.fJS);
        this.fLt = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.fLt.setPageId(getTag());
        this.fLv = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.fLv != null) {
            this.fLv.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eNl != null) {
                    c.this.eNl.changeSelectStatus();
                }
            }
        });
        this.eNl.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fT(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.egF = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.OO = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.fJN != null) {
            this.fJN.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fJN != null) {
            this.fJN.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fJN != null) {
            this.fJN.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.cel, R.color.cp_bg_line_c);
            this.fJN.onChangeSkinType();
            this.eNl.onChangeSkinType();
            this.eNk.onChangeSkinType();
            if (this.OO != null) {
                this.OO.onChangeSkinType();
            }
            this.gyi.onChangeSkinType();
            if (this.eNX != null && this.eNX.getVisibility() == 0) {
                this.eNX.onChangeSkinType();
            }
            if (this.fJn != null && this.fJn.getHeadView() != null && (this.fJn.getHeadView() instanceof TbImageView)) {
                this.fJn.getHeadView().setPlaceHolder(1);
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
            getView().setOnClickListener(this.fJS);
        }
        this.fJm.onChangeSkinType();
        if (!buP() && com.baidu.tieba.card.l.zT(this.KJ.getId())) {
            com.baidu.tieba.card.l.a(this.mTitle, this.KJ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.KA, this.KJ.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fJm.getGodReplyContent(), this.KJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bjVar);
        this.gyi.ax(this.KJ);
        X(bjVar);
        this.eNk.setData(this.KJ);
        this.fJm.setFromCDN(this.NJ);
        this.fJm.setData(this.KJ.aDK());
        this.eNk.setUserAfterClickListener(this.Nw);
        pB(oc(1));
        if (this.eNk.getHeaderImg() != null) {
            if (this.eNk.getIsSimpleThread()) {
                this.eNk.getHeaderImg().setVisibility(8);
                this.fJn.setVisibility(8);
            } else if (bjVar.aCm() == null || bjVar.aCm().getPendantData() == null || StringUtils.isNull(bjVar.aCm().getPendantData().aAE())) {
                this.fJn.setVisibility(8);
                this.eNk.getHeaderImg().setVisibility(0);
                this.eNk.getHeaderImg().setData(bjVar);
            } else {
                this.eNk.getHeaderImg().setVisibility(4);
                this.fJn.setVisibility(0);
                this.fJn.setData(bjVar);
            }
        }
        aq(bjVar);
        ar(bjVar);
        this.OO.setData(bjVar.aCY());
        this.OO.setForumId(String.valueOf(bjVar.getFid()));
        AppletsCellView appletsCellView = this.OO;
        AppletsCellView appletsCellView2 = this.OO;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aCA = bjVar.aCA();
        if (v.isEmpty(aCA)) {
            this.NY.setVisibility(8);
        } else {
            this.NY.cMf();
            this.NY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aCA.get(0);
            this.NY.setVoiceModel(voiceModel);
            this.NY.setTag(voiceModel);
            this.NY.bHq();
            if (voiceModel != null) {
                this.NY.wW(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aCw = bjVar.aCw();
        if (com.baidu.tbadk.core.i.azM().isShowImages() && v.getCount(aCw) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aCw.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aCw, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.fJN.setVisibility(0);
                this.fJN.setFromCDN(this.NJ);
                this.fJN.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        z<bj> buE = c.this.buE();
                        if (z) {
                            if (buE != null) {
                                view.setTag("1");
                                buE.MU = true;
                                buE.a(view, c.this.KJ);
                            }
                            c.this.kj(false);
                            return;
                        }
                        if (buE != null) {
                            view.setTag("1");
                            buE.MU = false;
                            buE.a(view, c.this.KJ);
                        }
                        c.this.a(view, linkedList, i2, bjVar);
                    }
                });
                this.fJN.setImageMediaList(linkedList);
            } else {
                this.fJN.setVisibility(8);
            }
        } else {
            this.fJN.setVisibility(8);
        }
        buX();
        buY();
        bHs();
        if (this.eNl.isInFrsAllThread() && com.baidu.tieba.frs.a.bCT().bCU()) {
            this.mMaskView.setVisibility(0);
            if (this.KJ.aDT() || this.KJ.aDU()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void buX() {
        if (this.fJL != null && this.fJN != null && this.fJm != null) {
            if (this.fJN.getVisibility() == 8 && this.fJm.getVisibility() == 8 && this.OO.getVisibility() == 8) {
                this.fJL.setVisibility(0);
            } else {
                this.fJL.setVisibility(8);
            }
        }
    }

    private void X(final bj bjVar) {
        if (this.fLv != null) {
            if (this.fLt == null || bjVar == null) {
                this.fLv.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cTQ) && this.fLt.getVisibility() != 0) {
                if (this.gyi != null && this.gyi.bKN() && (this.fLv.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLv.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fLv.setLayoutParams(layoutParams);
                }
                this.fLv.setVisibility(0);
                this.fLv.setImageDrawable(null);
                this.fLv.startLoad(bjVar.cTQ, 10, false);
                this.fLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bjVar.cTR, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fLv.setVisibility(8);
            }
        }
    }

    public void b(bj bjVar) {
        MetaData aCm;
        if (bjVar != null && this.fLt != null && (aCm = bjVar.aCm()) != null) {
            final ThemeCardInUserData themeCard = aCm.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fLt.setVisibility(8);
                return;
            }
            this.fLt.setVisibility(0);
            this.fLt.setImageDrawable(null);
            this.fLt.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCr(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
            historyMessage.forumName = bjVar.aCr();
            historyMessage.postID = bjVar.aCC();
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

    private void buY() {
        this.NY.setClickable(true);
        int childCount = this.fJN.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fJN.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNl != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eNk != null) {
            this.eNk.setPageUniqueId(bdUniqueId);
        }
        if (this.fJN != null) {
            this.fJN.setPageUniqueId(bdUniqueId);
        }
    }

    protected void kj(boolean z) {
        if (this.KJ != null) {
            com.baidu.tieba.card.l.zS(this.KJ.getId());
            com.baidu.tieba.card.l.a(this.mTitle, this.KJ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.KA, this.KJ.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fJm.getGodReplyContent(), this.KJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            p aDt = this.KJ.aDt();
            if (aDt != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aDt.getCartoonId(), aDt.getChapterId(), 2)));
                return;
            }
            m mVar = this.KJ.cTo;
            if (this.KJ.cTn == 1 && mVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = mVar.cNY;
                long j = mVar.cNZ;
                ao aoVar = new ao();
                aoVar.pageContext = this.mPageContext;
                aoVar.cOm = str;
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
            if (this.KJ.aDp() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean buP() {
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
        if (this.eNl != null) {
            this.eNl.dhF = i;
            this.eNl.setFrom(2);
        }
        if (this.eNk != null) {
            this.eNk.setFrom(3);
        }
    }

    private boolean aq(bj bjVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.gys)) {
            bjVar.cp(this.mUrl, this.gys);
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.gys)) {
                bjVar.cp(this.mUrl, this.gys);
            }
            SpannableString aDe = bjVar.aDe();
            if (aDe != null && !aq.isEmpty(aDe.toString())) {
                this.KA.setVisibility(0);
                this.KA.setOnTouchListener(new h(aDe));
                this.KA.setText(aDe);
                com.baidu.tieba.card.l.a(this.KA, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.KA.setVisibility(8);
            return;
        }
        this.KA.setVisibility(8);
    }

    private void bHs() {
        if (this.mTitle != null && this.NY != null && this.fJN != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.NY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.NY.setLayoutParams(layoutParams);
            if (this.NY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fJN.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.fJN.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pB(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNl.setVisibility(8);
                if (this.eNX != null) {
                    this.eNX.setData(this.KJ);
                    return;
                }
                return;
            }
            this.eNl.setData(this.KJ);
            if (this.eNX != null) {
                this.eNX.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXD().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fJN != null) {
            this.fJN.setPreloadSizeReadyCallback(bVar);
        }
    }
}
