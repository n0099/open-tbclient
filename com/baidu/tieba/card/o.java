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
/* loaded from: classes21.dex */
public class o extends b<com.baidu.tieba.card.data.l> implements com.baidu.tieba.a.e {
    private static final int agk = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView agm;
    private String ahu;
    private final View.OnClickListener ajG;
    private boolean akk;
    public PlayVoiceBntNew akw;
    protected LinearLayout fXV;
    public ThreadUserInfoLayout gSQ;
    public ThreadCommentAndPraiseInfoLayout gSR;
    public ThreadSourceShareAndPraiseLayout gTD;
    private NEGFeedBackView gTc;
    private ThreadGodReplyLayout hXG;
    private HeadPendantClickableView hXH;
    private View hYe;
    private com.baidu.tieba.card.data.l hYf;
    private ConstrainImageGroup hYg;
    private View hYh;
    private boolean hYi;
    private RelativeLayout hYj;
    private ThreadForumEnterButton hYk;
    private View.OnClickListener hYl;
    private final View.OnClickListener hYm;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gTc = null;
        this.mSkinType = 3;
        this.akk = true;
        this.hYi = true;
        this.hYl = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.hYf != null) {
                    o.this.hYf.objType = 1;
                }
                if (o.this.cnT() != null) {
                    o.this.cnT().a(view, o.this.hYf);
                }
                o.this.os(view == o.this.hXG);
            }
        };
        this.hYm = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.card.data.l> cnT = o.this.cnT();
                if (cnT != null) {
                    view.setTag("2");
                    cnT.a(view, o.this.hYf);
                }
            }
        };
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.hYf == null) {
                    if (o.this.cnT() != null) {
                        o.this.cnT().a(view, o.this.hYf);
                        return;
                    }
                    return;
                }
                if (view == o.this.gSQ.getUserName()) {
                    o.this.hYf.objType = 3;
                } else if (view == o.this.gSQ.getHeaderImg()) {
                    o.this.hYf.objType = 4;
                } else if (view == o.this.hYg) {
                    o.this.hYf.objType = 2;
                    return;
                } else {
                    o.this.hYf.objType = 1;
                }
                if (o.this.cnT() != null) {
                    o.this.cnT().a(view, o.this.hYf);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hXH = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hXH.getHeadView() != null) {
            this.hXH.getHeadView().setIsRound(true);
            this.hXH.getHeadView().setDrawBorder(false);
            this.hXH.getHeadView().setDefaultResource(17170445);
            this.hXH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hXH.getHeadView().setPlaceHolder(1);
            this.hXH.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hXH.setHasPendantStyle();
        if (this.hXH.getPendantView() != null) {
            this.hXH.getPendantView().setIsRound(true);
            this.hXH.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.akw = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.akw.setAfterClickListener(this.hYm);
        this.agm = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.hYg = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hYh = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.hYg.setChildClickListener(this.hYl);
        this.hYg.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.y(1.0d);
        this.hYg.setImageProcessor(fVar);
        this.hYe = view.findViewById(R.id.divider_line_above_praise);
        this.gSR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gSQ = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gTc = new NEGFeedBackView(this.mPageContext);
        this.hYj = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gTc.a(this.hYj, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.gSR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gSR.setLayoutParams(layoutParams);
        }
        this.gSR.setOnClickListener(this.hYl);
        this.gSR.setReplyTimeVisible(false);
        this.gSR.setShowPraiseNum(true);
        this.gSR.setNeedAddPraiseIcon(true);
        this.gSR.setNeedAddReplyIcon(true);
        this.gSR.setShareVisible(true);
        this.gSR.setFrom(1);
        this.gSR.setShareReportFrom(3);
        this.gSR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (o.this.cnT() != null) {
                    o.this.cnT().a(view2, o.this.hYf);
                }
                if (o.this.hYf != null && o.this.hYf.exA != null) {
                    n.IZ(o.this.hYf.exA.getId());
                    if (!o.this.coc()) {
                        n.a(o.this.mTitle, o.this.hYf.bjZ().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        n.a(o.this.agm, o.this.hYf.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        n.a(o.this.hXG.getGodReplyContent(), o.this.hYf.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.fXV = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.hXG = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.hXG.setOnClickListener(this.hYl);
        this.gTD = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.gTD.eXx.setOnClickListener(this.hYl);
        this.gTD.setFrom(1);
        this.gTD.setShareReportFrom(3);
        this.gTD.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (o.this.cnT() != null) {
                    o.this.cnT().a(view2, o.this.hYf);
                }
                if (o.this.hYf != null && o.this.hYf.exA != null && view2 != o.this.gTD.eWM) {
                    n.IZ(o.this.hYf.exA.getId());
                    if (!o.this.coc()) {
                        n.a(o.this.mTitle, o.this.hYf.bjZ().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        n.a(o.this.agm, o.this.hYf.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        n.a(o.this.hXG.getGodReplyContent(), o.this.hYf.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.hYk = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYg != null) {
            this.hYg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYg != null) {
            this.hYg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hYe, R.color.transparent);
            this.hYg.onChangeSkinType();
            this.gSR.onChangeSkinType();
            this.hXG.onChangeSkinType();
            this.gSQ.onChangeSkinType();
            if (this.gTc != null) {
                this.gTc.onChangeSkinType();
            }
            ap.setBackgroundColor(this.hYh, R.color.cp_bg_line_c);
            if (this.gTD != null) {
                this.gTD.onChangeSkinType();
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
        if (lVar == null || lVar.bjZ() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.hYf = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hYl);
        }
        if (this.gTc != null) {
            if (this.hYf.feedBackReasonMap != null && this.hYf.feedBackReasonMap.size() > 0) {
                ar arVar = new ar();
                arVar.setTid(this.hYf.bjZ().getTid());
                arVar.setFid(this.hYf.bjZ().getFid());
                arVar.setNid(this.hYf.bjZ().getNid());
                arVar.setFeedBackReasonMap(this.hYf.feedBackReasonMap);
                this.gTc.setData(arVar);
                this.gTc.setFirstRowSingleColumn(true);
                if (lVar.exA.bmA() != null && !StringUtils.isNull(lVar.exA.bmA().getUserId())) {
                    if (lVar.exA.bmA().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.gTc.setVisibility(8);
                    } else if (this.gTc != null) {
                        this.gTc.setVisibility(this.hYi ? 0 : 8);
                    }
                }
            } else {
                this.gTc.setVisibility(8);
            }
        }
        this.gSQ.setData(lVar.exA);
        this.hXG.setFromCDN(this.akk);
        this.hXG.setData(lVar.exA.bod());
        if (!coc() && n.Ja(this.hYf.exA.getId())) {
            n.a(this.mTitle, this.hYf.bjZ().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            n.a(this.agm, this.hYf.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            n.a(this.hXG.getGodReplyContent(), this.hYf.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        this.gSQ.setUserAfterClickListener(this.ajG);
        final bw bjZ = lVar.bjZ();
        if (this.gSQ.getHeaderImg() != null) {
            if (this.gSQ.getIsSimpleThread()) {
                this.gSQ.getHeaderImg().setVisibility(8);
                this.hXH.setVisibility(8);
            } else if (bjZ.bmA() == null || bjZ.bmA().getPendantData() == null || StringUtils.isNull(bjZ.bmA().getPendantData().bkw())) {
                this.hXH.setVisibility(8);
                this.gSQ.getHeaderImg().setVisibility(0);
                this.gSQ.getHeaderImg().setData(bjZ);
            } else {
                this.gSQ.getHeaderImg().setVisibility(4);
                this.hXH.setVisibility(0);
                this.hXH.setData(bjZ);
            }
        }
        ay.a(this.mTitle, bjZ);
        ay.a(this.agm, this.mTitle, bjZ, agk);
        ArrayList<VoiceData.VoiceModel> bmN = lVar.exA.bmN();
        if (com.baidu.tbadk.core.util.y.isEmpty(bmN)) {
            this.akw.setVisibility(8);
            z = false;
        } else {
            this.akw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bmN.get(0);
            this.akw.setVoiceModel(voiceModel);
            this.akw.setTag(voiceModel);
            this.akw.changeSkin();
            if (voiceModel != null) {
                this.akw.Dz(voiceModel.voice_status.intValue());
            }
            this.akw.bZl();
            z = true;
        }
        if (this.hYf.ibL && z) {
            this.hYg.setVisibility(8);
        } else {
            ArrayList<MediaData> bmJ = bjZ.bmJ();
            if (com.baidu.tbadk.core.k.bjH().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bmJ) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < bmJ.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bmJ, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hYg.setVisibility(0);
                    this.hYg.setFromCDN(this.akk);
                    this.hYg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.o.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.l> cnT = o.this.cnT();
                            if (cnT != null) {
                                view.setTag("1");
                                if (o.this.ajG != null) {
                                    o.this.ajG.onClick(o.this.hYg);
                                }
                                cnT.a(view, o.this.hYf);
                            }
                            if (z2) {
                                o.this.bxB();
                            } else {
                                o.this.a(view, linkedList, i2, bjZ);
                            }
                        }
                    });
                    this.hYg.setImageMediaList(linkedList);
                } else {
                    this.hYg.setVisibility(8);
                }
            } else {
                this.hYg.setVisibility(8);
            }
        }
        cok();
        col();
        setPageUniqueId(getTag());
        this.hYk.setVisibility(8);
        vf(tj(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cok() {
        if (this.hYe != null && this.hYg != null && this.hXG != null) {
            if (this.hYg.getVisibility() == 8 && this.hXG.getVisibility() == 8) {
                this.hYe.setVisibility(0);
            } else {
                this.hYe.setVisibility(8);
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
                    imageUrlData.urlType = this.akk ? 13 : 14;
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
        aVar.x(arrayList).nP(i).AE(bwVar.bmE()).AF(String.valueOf(bwVar.getFid())).AG(bwVar.getTid()).ix(this.akk).AH(arrayList.size() > 0 ? arrayList.get(0) : "").iy(true).a(concurrentHashMap).iz(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dU.getIntent().putExtra("from", "index");
        } else {
            dU.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.bmE();
        historyMessage.postID = bwVar.bmR();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void col() {
        if (!this.hYf.foQ) {
            this.akw.setClickable(false);
        } else {
            this.akw.setClickable(true);
        }
        int childCount = this.hYg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hYg.getChildAt(i);
            if (childAt != null) {
                if (!this.hYf.foQ) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hYg != null) {
            this.hYg.setPageUniqueId(bdUniqueId);
        }
        if (this.gTc != null) {
            this.gTc.setUniqueId(bdUniqueId);
        }
        if (this.gSQ != null) {
            this.gSQ.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxB() {
        os(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void os(boolean z) {
        if (this.hYf != null && this.hYf.exA != null) {
            if (!coc()) {
                n.IZ(this.hYf.exA.getId());
                n.a(this.mTitle, this.hYf.bjZ().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                n.a(this.agm, this.hYf.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                n.a(this.hXG.getGodReplyContent(), this.hYf.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.hYf.exA, null, n.bmm(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hYf.bkc());
            addLocateParam.setForumId(String.valueOf(this.hYf.exA.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hYf.exA.bmE());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            n.IZ(this.hYf.bjZ().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean coc() {
        return this.hYf.ibL && !this.hYf.foQ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void ot(boolean z) {
        if (this.hYh != null) {
            this.hYh.setVisibility(z ? 0 : 8);
        }
    }

    public void ou(boolean z) {
        this.hYi = z;
    }

    public void vf(int i) {
        if (this.hYf != null && this.hYf.exA != null) {
            this.mStType = n.bmm();
            if (i == 1) {
                this.gSR.setVisibility(8);
                this.gTD.setStType(this.mStType);
                this.gTD.setData(this.hYf.exA);
                this.gSQ.jt(false);
                return;
            }
            this.gSR.setData(this.hYf.exA);
            this.gSR.setStType(this.mStType);
            this.gTD.setVisibility(8);
            this.gSQ.jt(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int tj(int i) {
        return com.baidu.tieba.a.d.bIR().ax(this.ahu, i);
    }
}
