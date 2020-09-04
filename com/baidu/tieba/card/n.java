package com.baidu.tieba.card;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class n extends b<com.baidu.tieba.card.data.l> implements com.baidu.tieba.a.e {
    private static final int afz = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView afB;
    private String agJ;
    private final View.OnClickListener aiT;
    public PlayVoiceBntNew ajF;
    private boolean ajt;
    protected LinearLayout fuq;
    public ThreadSourceShareAndPraiseLayout gjQ;
    public ThreadUserInfoLayout gjd;
    public ThreadCommentAndPraiseInfoLayout gje;
    private NEGFeedBackView gjp;
    private View hjN;
    private com.baidu.tieba.card.data.l hjO;
    private ConstrainImageGroup hjP;
    private View hjQ;
    private boolean hjR;
    private RelativeLayout hjS;
    private ThreadForumEnterButton hjT;
    private View.OnClickListener hjU;
    private final View.OnClickListener hjV;
    private ThreadGodReplyLayout hjp;
    private HeadPendantClickableView hjq;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjp = null;
        this.mSkinType = 3;
        this.ajt = true;
        this.hjR = true;
        this.hjU = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.hjO != null) {
                    n.this.hjO.objType = 1;
                }
                if (n.this.cbA() != null) {
                    n.this.cbA().a(view, n.this.hjO);
                }
                n.this.ng(view == n.this.hjp);
            }
        };
        this.hjV = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tieba.card.data.l> cbA = n.this.cbA();
                if (cbA != null) {
                    view.setTag("2");
                    cbA.a(view, n.this.hjO);
                }
            }
        };
        this.aiT = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.hjO == null) {
                    if (n.this.cbA() != null) {
                        n.this.cbA().a(view, n.this.hjO);
                        return;
                    }
                    return;
                }
                if (view == n.this.gjd.getUserName()) {
                    n.this.hjO.objType = 3;
                } else if (view == n.this.gjd.getHeaderImg()) {
                    n.this.hjO.objType = 4;
                } else if (view == n.this.hjP) {
                    n.this.hjO.objType = 2;
                    return;
                } else {
                    n.this.hjO.objType = 1;
                }
                if (n.this.cbA() != null) {
                    n.this.cbA().a(view, n.this.hjO);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hjq = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hjq.getHeadView() != null) {
            this.hjq.getHeadView().setIsRound(true);
            this.hjq.getHeadView().setDrawBorder(false);
            this.hjq.getHeadView().setDefaultResource(17170445);
            this.hjq.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjq.getHeadView().setPlaceHolder(1);
            this.hjq.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hjq.setHasPendantStyle();
        if (this.hjq.getPendantView() != null) {
            this.hjq.getPendantView().setIsRound(true);
            this.hjq.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.ajF = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.ajF.setAfterClickListener(this.hjV);
        this.afB = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.hjP = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hjQ = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.hjP.setChildClickListener(this.hjU);
        this.hjP.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.u(1.0d);
        this.hjP.setImageProcessor(fVar);
        this.hjN = view.findViewById(R.id.divider_line_above_praise);
        this.gje = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gjd = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gjp = new NEGFeedBackView(this.mPageContext);
        this.hjS = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gjp.a(this.hjS, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.gje.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gje.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gje.setLayoutParams(layoutParams);
        }
        this.gje.setOnClickListener(this.hjU);
        this.gje.setReplyTimeVisible(false);
        this.gje.setShowPraiseNum(true);
        this.gje.setNeedAddPraiseIcon(true);
        this.gje.setNeedAddReplyIcon(true);
        this.gje.setShareVisible(true);
        this.gje.setFrom(1);
        this.gje.setShareReportFrom(3);
        this.gje.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cbA() != null) {
                    n.this.cbA().a(view2, n.this.hjO);
                }
                if (n.this.hjO != null && n.this.hjO.dUW != null) {
                    m.GZ(n.this.hjO.dUW.getId());
                    if (!n.this.cbJ()) {
                        m.a(n.this.mTitle, n.this.hjO.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.afB, n.this.hjO.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.hjp.getGodReplyContent(), n.this.hjO.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.fuq = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.hjp = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.hjp.setOnClickListener(this.hjU);
        this.gjQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.gjQ.euY.setOnClickListener(this.hjU);
        this.gjQ.setFrom(1);
        this.gjQ.setShareReportFrom(3);
        this.gjQ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cbA() != null) {
                    n.this.cbA().a(view2, n.this.hjO);
                }
                if (n.this.hjO != null && n.this.hjO.dUW != null && view2 != n.this.gjQ.eun) {
                    m.GZ(n.this.hjO.dUW.getId());
                    if (!n.this.cbJ()) {
                        m.a(n.this.mTitle, n.this.hjO.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.afB, n.this.hjO.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.hjp.getGodReplyContent(), n.this.hjO.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.hjT = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
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
            ap.setBackgroundColor(this.hjN, R.color.transparent);
            this.hjP.onChangeSkinType();
            this.gje.onChangeSkinType();
            this.hjp.onChangeSkinType();
            this.gjd.onChangeSkinType();
            if (this.gjp != null) {
                this.gjp.onChangeSkinType();
            }
            ap.setBackgroundColor(this.hjQ, R.color.cp_bg_line_c);
            if (this.gjQ != null) {
                this.gjQ.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        boolean z;
        if (lVar == null || lVar.bce() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.hjO = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hjU);
        }
        if (this.gjp != null) {
            if (this.hjO.feedBackReasonMap != null && this.hjO.feedBackReasonMap.size() > 0) {
                ar arVar = new ar();
                arVar.setTid(this.hjO.bce().getTid());
                arVar.setFid(this.hjO.bce().getFid());
                arVar.setNid(this.hjO.bce().getNid());
                arVar.setFeedBackReasonMap(this.hjO.feedBackReasonMap);
                this.gjp.setData(arVar);
                this.gjp.setFirstRowSingleColumn(true);
                if (lVar.dUW.beE() != null && !StringUtils.isNull(lVar.dUW.beE().getUserId())) {
                    if (lVar.dUW.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.gjp.setVisibility(8);
                    } else if (this.gjp != null) {
                        this.gjp.setVisibility(this.hjR ? 0 : 8);
                    }
                }
            } else {
                this.gjp.setVisibility(8);
            }
        }
        this.gjd.setData(lVar.dUW);
        this.hjp.setFromCDN(this.ajt);
        this.hjp.setData(lVar.dUW.bgh());
        if (!cbJ() && m.Ha(this.hjO.dUW.getId())) {
            m.a(this.mTitle, this.hjO.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.afB, this.hjO.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.hjp.getGodReplyContent(), this.hjO.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        this.gjd.setUserAfterClickListener(this.aiT);
        final bw bce = lVar.bce();
        if (this.gjd.getHeaderImg() != null) {
            if (this.gjd.getIsSimpleThread()) {
                this.gjd.getHeaderImg().setVisibility(8);
                this.hjq.setVisibility(8);
            } else if (bce.beE() == null || bce.beE().getPendantData() == null || StringUtils.isNull(bce.beE().getPendantData().bcA())) {
                this.hjq.setVisibility(8);
                this.gjd.getHeaderImg().setVisibility(0);
                this.gjd.getHeaderImg().setData(bce);
            } else {
                this.gjd.getHeaderImg().setVisibility(4);
                this.hjq.setVisibility(0);
                this.hjq.setData(bce);
            }
        }
        ay.a(this.mTitle, bce);
        ay.a(this.afB, this.mTitle, bce, afz);
        ArrayList<VoiceData.VoiceModel> beR = lVar.dUW.beR();
        if (com.baidu.tbadk.core.util.y.isEmpty(beR)) {
            this.ajF.setVisibility(8);
            z = false;
        } else {
            this.ajF.setVisibility(0);
            VoiceData.VoiceModel voiceModel = beR.get(0);
            this.ajF.setVoiceModel(voiceModel);
            this.ajF.setTag(voiceModel);
            this.ajF.changeSkin();
            if (voiceModel != null) {
                this.ajF.BM(voiceModel.voice_status.intValue());
            }
            this.ajF.bPf();
            z = true;
        }
        if (this.hjO.hns && z) {
            this.hjP.setVisibility(8);
        } else {
            ArrayList<MediaData> beN = bce.beN();
            if (com.baidu.tbadk.core.k.bbM().isShowImages() && com.baidu.tbadk.core.util.y.getCount(beN) != 0) {
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
                    this.hjP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            aa<com.baidu.tieba.card.data.l> cbA = n.this.cbA();
                            if (cbA != null) {
                                view.setTag("1");
                                if (n.this.aiT != null) {
                                    n.this.aiT.onClick(n.this.hjP);
                                }
                                cbA.a(view, n.this.hjO);
                            }
                            if (z2) {
                                n.this.bpF();
                            } else {
                                n.this.a(view, linkedList, i2, bce);
                            }
                        }
                    });
                    this.hjP.setImageMediaList(linkedList);
                } else {
                    this.hjP.setVisibility(8);
                }
            } else {
                this.hjP.setVisibility(8);
            }
        }
        cbR();
        cbS();
        setPageUniqueId(getTag());
        this.hjT.setVisibility(8);
        tB(rY(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cbR() {
        if (this.hjN != null && this.hjP != null && this.hjp != null) {
            if (this.hjP.getVisibility() == 8 && this.hjp.getVisibility() == 8) {
                this.hjN.setVisibility(0);
            } else {
                this.hjN.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajt ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
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
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(arrayList).mM(i).yQ(bwVar.beI()).yR(String.valueOf(bwVar.getFid())).yS(bwVar.getTid()).hI(this.ajt).yT(arrayList.size() > 0 ? arrayList.get(0) : "").hJ(true).a(concurrentHashMap).hK(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dP = aVar.dP(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dP.getIntent().putExtra("from", "index");
        } else {
            dP.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.beI();
        historyMessage.postID = bwVar.beV();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void cbS() {
        if (!this.hjO.eMb) {
            this.ajF.setClickable(false);
        } else {
            this.ajF.setClickable(true);
        }
        int childCount = this.hjP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hjP.getChildAt(i);
            if (childAt != null) {
                if (!this.hjO.eMb) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajt = z;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hjP != null) {
            this.hjP.setPageUniqueId(bdUniqueId);
        }
        if (this.gjp != null) {
            this.gjp.setUniqueId(bdUniqueId);
        }
        if (this.gjd != null) {
            this.gjd.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpF() {
        ng(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng(boolean z) {
        if (this.hjO != null && this.hjO.dUW != null) {
            if (!cbJ()) {
                m.GZ(this.hjO.dUW.getId());
                m.a(this.mTitle, this.hjO.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.afB, this.hjO.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.hjp.getGodReplyContent(), this.hjO.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.hjO.dUW, null, m.beq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hjO.bch());
            addLocateParam.setForumId(String.valueOf(this.hjO.dUW.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hjO.dUW.beI());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.GZ(this.hjO.bce().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbJ() {
        return this.hjO.hns && !this.hjO.eMb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void nh(boolean z) {
        if (this.hjQ != null) {
            this.hjQ.setVisibility(z ? 0 : 8);
        }
    }

    public void ni(boolean z) {
        this.hjR = z;
    }

    public void tB(int i) {
        if (this.hjO != null && this.hjO.dUW != null) {
            this.mStType = m.beq();
            if (i == 1) {
                this.gje.setVisibility(8);
                this.gjQ.setStType(this.mStType);
                this.gjQ.setData(this.hjO.dUW);
                this.gjd.iC(false);
                return;
            }
            this.gje.setData(this.hjO.dUW);
            this.gje.setStType(this.mStType);
            this.gjQ.setVisibility(8);
            this.gjd.iC(true);
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
