package com.baidu.tieba.card;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class au extends a<com.baidu.tieba.card.data.l> {
    private boolean ahm;
    private TbPageContext<?> ajh;
    private String alN;
    private final View.OnClickListener alO;
    private View.OnClickListener alR;
    private final View.OnClickListener ama;
    public PlayVoiceBntNew bBq;
    private TextView bBr;
    private ConstrainImageGroup bBs;
    private final View.OnClickListener bBt;
    public ThreadUserInfoLayout bdH;
    public ThreadCommentAndPraiseInfoLayout bdI;
    protected LinearLayout bdK;
    private HeadPendantClickableView bzC;
    private ThreadGodReplyLayout bzD;
    private View bzE;
    private com.baidu.tbadk.core.view.o bzF;
    private View bzG;
    private com.baidu.tieba.card.data.l bzH;
    private View.OnClickListener bzI;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public au(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bzF = null;
        this.mSkinType = 3;
        this.ahm = true;
        this.bzI = new av(this);
        this.bBt = new aw(this);
        this.ama = new ax(this);
        this.alO = new ay(this);
        this.alR = new az(this);
        View view = getView();
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
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bBq = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bBq.setAfterClickListener(this.bBt);
        this.bBr = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bBs = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bzG = view.findViewById(w.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds8);
        this.bBs.setChildClickListener(this.bzI);
        this.bBs.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.i iVar = new com.baidu.tbadk.widget.layout.i(3);
        iVar.c(1.0d);
        this.bBs.setImageProcessor(iVar);
        this.bdI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bdH = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_user_info_layout);
        this.bzE = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bzF = new com.baidu.tbadk.core.view.o(this.ajh);
        this.bzF.wa();
        this.bzF.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bdH.addView(this.bzF);
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
        this.bdI.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bdI.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bdI.setForumAfterClickListener(new ba(this));
        this.bdK = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.bzD = (ThreadGodReplyLayout) view.findViewById(w.h.card_home_page_god_reply_layout);
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
            this.bBs.onChangeSkinType();
            this.bdI.onChangeSkinType();
            this.bzD.onChangeSkinType();
            this.bdH.onChangeSkinType();
            if (this.bzF != null) {
                this.bzF.onChangeSkinType();
            }
            com.baidu.tbadk.core.util.aq.k(this.bzG, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        int i;
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bzH = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bzI);
        }
        if (this.bzF != null && this.bzH.LH() != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.co(this.bzH.LH().getTid());
            anVar.setFid(this.bzH.LH().getFid());
            anVar.a(this.bzH.Wh);
            this.bzF.setData(anVar);
        }
        this.bdH.a(lVar.threadData);
        this.bzD.setData(lVar.threadData.sG());
        if (!Uh() && at.ic(this.bzH.threadData.getId())) {
            at.a(this.mTitle, this.bzH.LH().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            at.a(this.bBr, this.bzH.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            at.a(this.bzD.getGodReplyContent(), this.bzH.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            at.a(this.bzD.getPraiseNum(), this.bzH.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        }
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        this.bzD.onChangeSkinType();
        this.bdH.setUserAfterClickListener(this.ama);
        this.bdI.a(lVar.threadData);
        this.bzE.setVisibility(0);
        this.mStType = at.rl();
        this.alN = "feed#" + lVar.UB();
        com.baidu.tbadk.core.data.bl LH = lVar.LH();
        if (this.bdH.getHeaderImg() != null) {
            if (this.bdH.getIsSimpleThread()) {
                this.bdH.getHeaderImg().setVisibility(8);
                this.bzC.setVisibility(8);
            } else if (LH.getAuthor() == null || LH.getAuthor().getPendantData() == null || StringUtils.isNull(LH.getAuthor().getPendantData().pL())) {
                this.bzC.setVisibility(8);
                this.bdH.getHeaderImg().setVisibility(0);
                this.bdH.getHeaderImg().setData(LH);
            } else {
                this.bdH.getHeaderImg().setVisibility(4);
                this.bzC.setVisibility(0);
                this.bzC.setData(LH);
            }
        }
        at.a(LH, this.mTitle);
        boolean z4 = ((StringUtils.isNull(LH.getTitle()) && (LH.rt() == null || LH.rt().size() == 0)) || LH.rJ() == 1) ? false : true;
        StringBuilder sb = new StringBuilder();
        if (LH.rC() != null && !StringUtils.isNull(LH.rC())) {
            sb.append(LH.rC());
        }
        ArrayList<MediaData> rE = lVar.threadData.rE();
        if (rE != null) {
            i = rE.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rE.get(i2).getVideoUrl() != null && rE.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rE.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(lVar.LH().g(sb.toString(), true))) {
                SpannableString cu = lVar.threadData.cu(sb.toString());
                this.bBr.setOnTouchListener(new com.baidu.tieba.view.aa(cu));
                this.bBr.setText(cu);
                this.bBr.setVisibility(0);
                at.a(this.bBr, lVar.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                z = true;
            } else {
                this.bBr.setVisibility(8);
                z = false;
            }
        } else {
            this.bBr.setVisibility(8);
            i = 0;
            z = false;
        }
        ArrayList<VoiceData.VoiceModel> rI = lVar.threadData.rI();
        if (com.baidu.tbadk.core.util.x.r(rI)) {
            this.bBq.setVisibility(8);
            z2 = false;
        } else {
            this.bBq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bBq.setVoiceModel(voiceModel);
            this.bBq.setTag(voiceModel);
            this.bBq.aZV();
            if (voiceModel != null) {
                this.bBq.mn(voiceModel.voice_status.intValue());
            }
            z2 = true;
        }
        if (this.bzH.bDt && z2) {
            this.bBs.setVisibility(8);
        } else if (com.baidu.tbadk.core.r.oN().oT() && com.baidu.tbadk.core.util.x.q(rE) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(rE, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.q(linkedList) > 0) {
                this.bBs.setVisibility(0);
                this.bBs.setFromCDN(this.ahm);
                this.bBs.setImageClickListener(new bb(this, linkedList2, LH));
                this.bBs.setImageUrls(linkedList);
                z3 = true;
            } else {
                this.bBs.setVisibility(8);
            }
        } else {
            this.bBs.setVisibility(8);
        }
        Uq();
        e(z4, z, z3);
        setPageUniqueId(getTag());
    }

    private void e(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bBr.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bdI.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bBs.getLayoutParams();
        if (!z && z2) {
            layoutParams.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2);
            } else if (z) {
                layoutParams2.topMargin = 0;
            }
        } else if (z2) {
            layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds13);
        } else if (z) {
            layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bl blVar) {
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
        if (!this.bzH.aAa) {
            this.bBq.setClickable(false);
        } else {
            this.bBq.setClickable(true);
        }
        int childCount = this.bBs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bBs.getChildAt(i);
            if (childAt != null) {
                if (!this.bzH.aAa) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahm = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bBs != null) {
            this.bBs.setPageUniqueId(bdUniqueId);
        }
        if (this.bzF != null) {
            this.bzF.setUniqueId(bdUniqueId);
        }
        if (this.bdH != null) {
            this.bdH.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(o.a aVar) {
        if (this.bzF != null) {
            this.bzF.setEventCallback(aVar);
        }
    }

    public View Uf() {
        return this.bzD;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bdH != null) {
            return this.bdH.alV;
        }
        return null;
    }

    public View Ug() {
        if (this.bdH != null) {
            return this.bdH.alW;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        dr(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(boolean z) {
        if (this.bzH != null && this.bzH.threadData != null) {
            if (!Uh()) {
                at.ib(this.bzH.threadData.getId());
                at.a(this.mTitle, this.bzH.LH().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                at.a(this.bBr, this.bzH.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                at.a(this.bzD.getGodReplyContent(), this.bzH.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                at.a(this.bzD.getPraiseNum(), this.bzH.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajh.getPageActivity()).createFromThreadCfg(this.bzH.threadData, null, at.rl(), 18003, true, false, false).addLocateParam(this.bzH.UC());
            addLocateParam.setForumId(String.valueOf(this.bzH.threadData.getFid()));
            addLocateParam.setForumName(this.bzH.threadData.rz());
            if (this.bzH.bDb == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bzH.bDb);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ajh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Uh() {
        return this.bzH.bDt && !this.bzH.aAa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
