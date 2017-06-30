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
    private boolean ahU;
    private TbPageContext<?> ajP;
    private String amE;
    private final View.OnClickListener amF;
    private View.OnClickListener amJ;
    private final View.OnClickListener amS;
    private com.baidu.tieba.card.data.l bAA;
    private View.OnClickListener bAB;
    private HeadPendantClickableView bAv;
    private ThreadGodReplyLayout bAw;
    private View bAx;
    private com.baidu.tbadk.core.view.o bAy;
    private View bAz;
    public PlayVoiceBntNew bCj;
    private TextView bCk;
    private ConstrainImageGroup bCl;
    private final View.OnClickListener bCm;
    public ThreadUserInfoLayout bgE;
    public ThreadCommentAndPraiseInfoLayout bgF;
    protected LinearLayout bgH;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public au(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bAy = null;
        this.mSkinType = 3;
        this.ahU = true;
        this.bAB = new av(this);
        this.bCm = new aw(this);
        this.amS = new ax(this);
        this.amF = new ay(this);
        this.amJ = new az(this);
        View view = getView();
        this.ajP = tbPageContext;
        this.bAv = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bAv.getHeadView() != null) {
            this.bAv.getHeadView().setIsRound(true);
            this.bAv.getHeadView().setDrawBorder(false);
            this.bAv.getHeadView().setDefaultResource(17170445);
            this.bAv.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bAv.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bAv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
        }
        this.bAv.wm();
        if (this.bAv.getPendantView() != null) {
            this.bAv.getPendantView().setIsRound(true);
            this.bAv.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bCj = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bCj.setAfterClickListener(this.bCm);
        this.bCk = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bCl = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bAz = view.findViewById(w.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds8);
        this.bCl.setChildClickListener(this.bAB);
        this.bCl.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.i iVar = new com.baidu.tbadk.widget.layout.i(3);
        iVar.e(1.0d);
        this.bCl.setImageProcessor(iVar);
        this.bgF = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bgE = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_user_info_layout);
        this.bAx = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bAy = new com.baidu.tbadk.core.view.o(this.ajP);
        this.bAy.wr();
        this.bAy.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bgE.addView(this.bAy);
        if (this.bgF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgF.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bgF.setLayoutParams(layoutParams);
        }
        this.bgF.setOnClickListener(this.bAB);
        this.bgF.setReplyTimeVisible(false);
        this.bgF.setShowPraiseNum(true);
        this.bgF.setNeedAddPraiseIcon(true);
        this.bgF.setNeedAddReplyIcon(true);
        this.bgF.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bgF.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bgF.setForumAfterClickListener(new ba(this));
        this.bgH = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.bAw = (ThreadGodReplyLayout) view.findViewById(w.h.card_home_page_god_reply_layout);
        this.bAw.setOnClickListener(this.bAB);
    }

    public void setSingleImageRatio(double d) {
        if (this.bCl != null) {
            this.bCl.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bCl != null) {
            this.bCl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bCl != null) {
            this.bCl.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(getView(), w.g.addresslist_item_bg);
            this.bCl.onChangeSkinType();
            this.bgF.onChangeSkinType();
            this.bAw.onChangeSkinType();
            this.bgE.onChangeSkinType();
            if (this.bAy != null) {
                this.bAy.onChangeSkinType();
            }
            com.baidu.tbadk.core.util.as.k(this.bAz, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02f1  */
    @Override // com.baidu.tieba.card.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.card.data.l lVar) {
        boolean z;
        StringBuilder sb;
        ArrayList<MediaData> rB;
        int i;
        boolean z2;
        ArrayList<VoiceData.VoiceModel> rF;
        boolean z3;
        boolean z4 = false;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bAA = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bAB);
        }
        if (this.bAy != null && this.bAA.Mv() != null) {
            com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
            aoVar.cu(this.bAA.Mv().getTid());
            aoVar.setFid(this.bAA.Mv().getFid());
            aoVar.a(this.bAA.Wh);
            this.bAy.setData(aoVar);
        }
        this.bgE.a(lVar.threadData);
        this.bAw.setFromCDN(this.ahU);
        this.bAw.setData(lVar.threadData.sE());
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        this.bAw.onChangeSkinType();
        if (lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bAy.setVisibility(8);
            } else {
                this.bAy.setVisibility(0);
            }
        }
        if (!Vw() && at.iJ(this.bAA.threadData.getId())) {
            at.a(this.mTitle, this.bAA.Mv().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            at.a(this.bCk, this.bAA.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            at.a(this.bAw.getGodReplyContent(), this.bAA.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            at.a(this.bAw.getPraiseNum(), this.bAA.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        }
        this.bgE.setUserAfterClickListener(this.amS);
        this.bgF.a(lVar.threadData);
        this.bAx.setVisibility(0);
        this.mStType = at.ri();
        this.amE = "feed#" + lVar.VS();
        com.baidu.tbadk.core.data.bm Mv = lVar.Mv();
        if (this.bgE.getHeaderImg() != null) {
            if (this.bgE.getIsSimpleThread()) {
                this.bgE.getHeaderImg().setVisibility(8);
                this.bAv.setVisibility(8);
            } else if (Mv.getAuthor() == null || Mv.getAuthor().getPendantData() == null || StringUtils.isNull(Mv.getAuthor().getPendantData().pI())) {
                this.bAv.setVisibility(8);
                this.bgE.getHeaderImg().setVisibility(0);
                this.bgE.getHeaderImg().setData(Mv);
            } else {
                this.bgE.getHeaderImg().setVisibility(4);
                this.bAv.setVisibility(0);
                this.bAv.setData(Mv);
            }
        }
        at.a(Mv, this.mTitle);
        if ((StringUtils.isNull(Mv.getTitle()) && (Mv.rp() == null || Mv.rp().size() == 0)) || Mv.rG() == 1) {
            Mv.e(false, true);
            if (Mv.rR() == null || StringUtils.isNull(Mv.rR().toString())) {
                z = false;
                sb = new StringBuilder();
                if (Mv.rz() != null && !StringUtils.isNull(Mv.rz())) {
                    sb.append(Mv.rz());
                }
                rB = lVar.threadData.rB();
                if (rB == null) {
                    i = rB.size();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 0; i2 < i; i2++) {
                        if (rB.get(i2).getVideoUrl() != null && rB.get(i2).getVideoUrl().endsWith("swf")) {
                            sb2.append(rB.get(i2).getVideoUrl());
                        }
                    }
                    sb.append(sb2.toString());
                    if (!TextUtils.isEmpty(lVar.Mv().g(sb.toString(), true))) {
                        SpannableString cA = lVar.threadData.cA(sb.toString());
                        this.bCk.setOnTouchListener(new com.baidu.tieba.view.aa(cA));
                        this.bCk.setText(cA);
                        this.bCk.setVisibility(0);
                        at.a(this.bCk, lVar.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                        z2 = true;
                    } else {
                        this.bCk.setVisibility(8);
                        z2 = false;
                    }
                } else {
                    this.bCk.setVisibility(8);
                    i = 0;
                    z2 = false;
                }
                rF = lVar.threadData.rF();
                if (!com.baidu.tbadk.core.util.z.t(rF)) {
                    this.bCj.setVisibility(8);
                    z3 = false;
                } else {
                    this.bCj.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rF.get(0);
                    this.bCj.setVoiceModel(voiceModel);
                    this.bCj.setTag(voiceModel);
                    this.bCj.bef();
                    if (voiceModel != null) {
                        this.bCj.my(voiceModel.voice_status.intValue());
                    }
                    z3 = true;
                }
                if (!this.bAA.bEm && z3) {
                    this.bCl.setVisibility(8);
                } else if (!com.baidu.tbadk.core.r.oK().oQ() && com.baidu.tbadk.core.util.z.s(rB) != 0) {
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    for (int i3 = 0; i3 < i; i3++) {
                        MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.z.c(rB, i3);
                        if (mediaData != null && mediaData.getType() == 3) {
                            linkedList.add(mediaData.getThumbnails_url());
                            linkedList2.add(mediaData);
                        }
                    }
                    if (com.baidu.tbadk.core.util.z.s(linkedList) > 0) {
                        this.bCl.setVisibility(0);
                        this.bCl.setFromCDN(this.ahU);
                        this.bCl.setImageClickListener(new bb(this, linkedList2, Mv));
                        this.bCl.setImageUrls(linkedList);
                        z4 = true;
                    } else {
                        this.bCl.setVisibility(8);
                    }
                } else {
                    this.bCl.setVisibility(8);
                }
                VH();
                e(z, z2, z4);
                setPageUniqueId(getTag());
            }
        }
        z = true;
        sb = new StringBuilder();
        if (Mv.rz() != null) {
            sb.append(Mv.rz());
        }
        rB = lVar.threadData.rB();
        if (rB == null) {
        }
        rF = lVar.threadData.rF();
        if (!com.baidu.tbadk.core.util.z.t(rF)) {
        }
        if (!this.bAA.bEm) {
        }
        if (!com.baidu.tbadk.core.r.oK().oQ()) {
        }
        this.bCl.setVisibility(8);
        VH();
        e(z, z2, z4);
        setPageUniqueId(getTag());
    }

    private void e(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCk.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bgF.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bCl.getLayoutParams();
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
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bm bmVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajP.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahU ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bmVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajP.getPageActivity()).createConfig(arrayList, i, bmVar.rw(), String.valueOf(bmVar.getFid()), bmVar.getTid(), this.ahU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void VH() {
        if (!this.bAA.aBd) {
            this.bCj.setClickable(false);
        } else {
            this.bCj.setClickable(true);
        }
        int childCount = this.bCl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bCl.getChildAt(i);
            if (childAt != null) {
                if (!this.bAA.aBd) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahU = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bCl != null) {
            this.bCl.setPageUniqueId(bdUniqueId);
        }
        if (this.bAy != null) {
            this.bAy.setUniqueId(bdUniqueId);
        }
        if (this.bgE != null) {
            this.bgE.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(o.a aVar) {
        if (this.bAy != null) {
            this.bAy.setEventCallback(aVar);
        }
    }

    public View Vu() {
        return this.bAw;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bgE != null) {
            return this.bgE.amN;
        }
        return null;
    }

    public View Vv() {
        if (this.bgE != null) {
            return this.bgE.amO;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VI() {
        du(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(boolean z) {
        if (this.bAA != null && this.bAA.threadData != null) {
            if (!Vw()) {
                at.iI(this.bAA.threadData.getId());
                at.a(this.mTitle, this.bAA.Mv().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                at.a(this.bCk, this.bAA.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                at.a(this.bAw.getGodReplyContent(), this.bAA.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                at.a(this.bAw.getPraiseNum(), this.bAA.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajP.getPageActivity()).createFromThreadCfg(this.bAA.threadData, null, at.ri(), 18003, true, false, false).addLocateParam(this.bAA.VT());
            addLocateParam.setForumId(String.valueOf(this.bAA.threadData.getFid()));
            addLocateParam.setForumName(this.bAA.threadData.rw());
            if (this.bAA.bDU == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bAA.bDU);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ajP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Vw() {
        return this.bAA.bEm && !this.bAA.aBd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
