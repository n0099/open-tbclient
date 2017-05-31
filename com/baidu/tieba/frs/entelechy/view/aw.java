package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class aw extends com.baidu.tieba.card.a<bl> implements cg {
    private View aRT;
    private bl ahM;
    private boolean ahm;
    private TbPageContext<?> ajh;
    private final View.OnClickListener ama;
    private PlayVoiceBntNew bBq;
    private TextView bBr;
    private ConstrainImageGroup bBs;
    private final View.OnClickListener bBt;
    private com.baidu.tieba.frs.f.ae bZq;
    private ThreadUserInfoLayout bdH;
    private ThreadCommentAndPraiseInfoLayout bdI;
    private HeadPendantClickableView bzC;
    private ThreadGodReplyLayout bzD;
    private View bzE;
    private View.OnClickListener bzI;
    private String mForumName;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public aw(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ahm = true;
        this.bzI = new ax(this);
        this.bBt = new ay(this);
        this.ama = new az(this);
        View view = getView();
        setTag(bdUniqueId);
        this.ajh = tbPageContext;
        this.bzC = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bzC.getHeadView() != null) {
            this.bzC.getHeadView().setIsRound(true);
            this.bzC.getHeadView().setDrawBorder(false);
            this.bzC.getHeadView().setDefaultResource(17170445);
            this.bzC.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bzC.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bzC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds70));
        }
        this.bzC.vV();
        if (this.bzC.getPendantView() != null) {
            this.bzC.getPendantView().setIsRound(true);
            this.bzC.getPendantView().setDrawBorder(false);
        }
        this.bzC.setAfterClickListener(this.ama);
        this.aRT = view.findViewById(w.h.divider_line);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bBq = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bBq.setAfterClickListener(this.bBt);
        this.bBr = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bBs = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bBs.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds8));
        this.bBs.setChildClickListener(this.bzI);
        com.baidu.tbadk.widget.layout.i iVar = new com.baidu.tbadk.widget.layout.i(3);
        iVar.c(1.0d);
        this.bBs.setImageProcessor(iVar);
        this.bdI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bdH = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_user_info_layout);
        this.bdH.setUserAfterClickListener(this.ama);
        this.bzE = view.findViewById(w.h.divider_below_reply_number_layout);
        if (this.bdI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bdI.setLayoutParams(layoutParams);
        }
        this.bdI.setOnClickListener(this.bzI);
        this.bdI.setReplyTimeVisible(false);
        this.bdI.setShowPraiseNum(true);
        this.bdI.setNeedAddPraiseIcon(true);
        this.bdI.setNeedAddReplyIcon(true);
        this.bdI.setIsBarViewVisible(false);
        this.bdI.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bdI.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bZq = new com.baidu.tieba.frs.f.ae(this.ajh, this.bdH);
        this.bZq.setUniqueId(getTag());
        this.bzD = (ThreadGodReplyLayout) view.findViewById(w.h.card_frs_god_reply_layout);
        this.bzD.setOnClickListener(this.bzI);
    }

    public void setSingleImageRatio(double d) {
        if (this.bBs != null) {
            this.bBs.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bBs != null) {
            this.bBs.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bBs != null) {
            this.bBs.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.aRT, w.e.cp_bg_line_c);
            this.bBs.onChangeSkinType();
            this.bdI.onChangeSkinType();
            this.bdH.onChangeSkinType();
            this.bZq.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: r */
    public void a(bl blVar) {
        boolean z;
        int i;
        boolean z2;
        boolean z3 = false;
        if (blVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahM = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bzI);
        }
        if (!Uh() && com.baidu.tieba.card.at.ic(this.ahM.getId())) {
            com.baidu.tieba.card.at.a(this.mTitle, this.ahM.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bBr, this.ahM.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bzD.getGodReplyContent(), this.ahM.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bzD.getPraiseNum(), this.ahM.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        }
        this.bZq.K(this.ahM);
        this.bdH.a(this.ahM);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdI.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.ajh.getResources().getDimension(w.f.ds10);
        this.bdI.setLayoutParams(layoutParams);
        this.bzD.setData(this.ahM.sG());
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        this.bzD.onChangeSkinType();
        this.bdH.setUserAfterClickListener(this.ama);
        this.bdI.a(blVar);
        this.bzE.setVisibility(0);
        this.mStType = com.baidu.tieba.card.at.rl();
        if (this.bdH.getHeaderImg() != null) {
            if (this.bdH.getIsSimpleThread()) {
                this.bdH.getHeaderImg().setVisibility(8);
                this.bzC.setVisibility(8);
            } else if (blVar.getAuthor() == null || blVar.getAuthor().getPendantData() == null || StringUtils.isNull(blVar.getAuthor().getPendantData().pL())) {
                this.bzC.setVisibility(8);
                this.bdH.getHeaderImg().setVisibility(0);
                this.bdH.getHeaderImg().setData(blVar);
            } else {
                this.bdH.getHeaderImg().setVisibility(4);
                this.bzC.setVisibility(0);
                this.bzC.setData(blVar);
            }
        }
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rt() == null || blVar.rt().size() == 0)) || blVar.rJ() == 1) {
            this.mTitle.setVisibility(8);
            z = false;
        } else {
            this.mTitle.setVisibility(0);
            blVar.XB = 0;
            blVar.e(false, blVar.sr());
            SpannableStringBuilder rU = blVar.rU();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.aa(rU));
            this.mTitle.setText(rU);
            com.baidu.tieba.card.at.a(this.mTitle, blVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        if (blVar.rC() != null && !StringUtils.isNull(blVar.rC())) {
            sb.append(blVar.rC());
        }
        ArrayList<MediaData> rE = blVar.rE();
        if (rE != null) {
            i = rE.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rE.get(i2).getVideoUrl() != null && rE.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rE.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(blVar.g(sb.toString(), true))) {
                SpannableString cu = blVar.cu(sb.toString());
                this.bBr.setOnTouchListener(new com.baidu.tieba.view.aa(cu));
                this.bBr.setText(cu);
                this.bBr.setVisibility(0);
                com.baidu.tieba.card.at.a(this.bBr, blVar.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                z2 = true;
            } else {
                this.bBr.setVisibility(8);
                z2 = false;
            }
        } else {
            this.bBr.setVisibility(8);
            i = 0;
            z2 = false;
        }
        ArrayList<VoiceData.VoiceModel> rI = blVar.rI();
        if (com.baidu.tbadk.core.util.x.r(rI)) {
            this.bBq.setVisibility(8);
        } else {
            this.bBq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bBq.setVoiceModel(voiceModel);
            this.bBq.setTag(voiceModel);
            this.bBq.aZV();
            if (voiceModel != null) {
                this.bBq.mn(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.r.oN().oT() && com.baidu.tbadk.core.util.x.q(rE) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(rE, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.au.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.q(linkedList) > 0) {
                this.bBs.setVisibility(0);
                this.bBs.setFromCDN(this.ahm);
                this.bBs.setImageClickListener(new ba(this, linkedList2, blVar));
                this.bBs.setImageUrls(linkedList);
                z3 = true;
            } else {
                this.bBs.setVisibility(8);
            }
        } else {
            this.bBs.setVisibility(8);
        }
        Uq();
        e(z, z2, z3);
    }

    private void e(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitle.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bBr.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bdI.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.bBs.getLayoutParams();
        if (!z && z2) {
            layoutParams2.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2);
            } else if (z) {
                layoutParams3.topMargin = 0;
            }
        } else if (z2) {
            layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds13);
        } else if (z) {
            layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajh.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahm ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(blVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajh.getPageActivity()).createConfig(arrayList, i, blVar.rz(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ahm, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Uq() {
        this.bBq.setClickable(true);
        int childCount = this.bBs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bBs.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahm = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bdI != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bdH != null) {
            this.bdH.setPageUniqueId(bdUniqueId);
        }
        if (this.bBs != null) {
            this.bBs.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(boolean z) {
        if (this.ahM != null) {
            com.baidu.tieba.card.at.ib(this.ahM.getId());
            com.baidu.tieba.card.at.a(this.mTitle, this.ahM.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bBr, this.ahM.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bzD.getGodReplyContent(), this.ahM.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bzD.getPraiseNum(), this.ahM.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tbadk.core.data.n sq = this.ahM.sq();
            if (sq != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajh.getPageActivity(), sq.getCartoonId(), sq.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ahM.YH;
            if (this.ahM.YG == 1 && kVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.TX;
                long j = kVar.TY;
                com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
                aqVar.pageContext = this.ajh;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajh.getPageActivity()).createFromThreadCfg(this.ahM, null, com.baidu.tieba.card.at.rl(), 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ahM.getFid()));
            addLocateParam.setForumName(this.ahM.rz());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ajh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Uh() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.bBq != null) {
            this.bBq.setVoiceManager(voiceManager);
        }
    }
}
