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
public class aq extends a<com.baidu.tieba.card.data.l> {
    private boolean ahv;
    private TbPageContext<?> ajr;
    private String alX;
    private final View.OnClickListener alY;
    private View.OnClickListener amb;
    private final View.OnClickListener amk;
    public ThreadUserInfoLayout bcp;
    public ThreadCommentAndPraiseInfoLayout bcq;
    protected LinearLayout bcs;
    private View buR;
    private com.baidu.tbadk.core.view.o buS;
    private HeadPendantClickableView buV;
    public PlayVoiceBntNew bvC;
    private ThreadGodReplyLayout bvD;
    private com.baidu.tieba.card.data.l bvE;
    private TextView bvF;
    private ConstrainImageGroup bvG;
    private View bvH;
    private View.OnClickListener bvI;
    private final View.OnClickListener bvJ;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public aq(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.buS = null;
        this.mSkinType = 3;
        this.ahv = true;
        this.bvI = new ar(this);
        this.bvJ = new as(this);
        this.amk = new at(this);
        this.alY = new au(this);
        this.amb = new av(this);
        View view = getView();
        this.ajr = tbPageContext;
        this.buV = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        if (this.buV.getHeadView() != null) {
            this.buV.getHeadView().setIsRound(true);
            this.buV.getHeadView().setDrawBorder(false);
            this.buV.getHeadView().setDefaultResource(17170445);
            this.buV.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.buV.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.buV.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds70));
        }
        this.buV.vY();
        if (this.buV.getPendantView() != null) {
            this.buV.getPendantView().setIsRound(true);
            this.buV.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bvC = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bvC.setAfterClickListener(this.bvJ);
        this.bvF = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bvG = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bvH = view.findViewById(w.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds8);
        this.bvG.setChildClickListener(this.bvI);
        this.bvG.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.i iVar = new com.baidu.tbadk.widget.layout.i(3);
        iVar.c(1.0d);
        this.bvG.setImageProcessor(iVar);
        this.bcq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bcp = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_user_info_layout);
        this.buR = view.findViewById(w.h.divider_below_reply_number_layout);
        this.buS = new com.baidu.tbadk.core.view.o(this.ajr);
        this.buS.wd();
        this.buS.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bcp.addView(this.buS);
        if (this.bcq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcq.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bcq.setLayoutParams(layoutParams);
        }
        this.bcq.setOnClickListener(this.bvI);
        this.bcq.setReplyTimeVisible(false);
        this.bcq.setShowPraiseNum(true);
        this.bcq.setNeedAddPraiseIcon(true);
        this.bcq.setNeedAddReplyIcon(true);
        this.bcq.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bcq.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bcq.setForumAfterClickListener(new aw(this));
        this.bcs = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.bvD = (ThreadGodReplyLayout) view.findViewById(w.h.card_home_page_god_reply_layout);
        this.bvD.setOnClickListener(this.bvI);
    }

    public void setSingleImageRatio(double d) {
        if (this.bvG != null) {
            this.bvG.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bvG != null) {
            this.bvG.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bvG != null) {
            this.bvG.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            this.bvG.onChangeSkinType();
            this.bcq.onChangeSkinType();
            this.bvD.onChangeSkinType();
            this.bcp.onChangeSkinType();
            if (this.buS != null) {
                this.buS.onChangeSkinType();
            }
            com.baidu.tbadk.core.util.aq.k(this.bvH, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.l lVar) {
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
        this.bvE = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bvI);
        }
        if (this.buS != null && this.bvE.JB() != null) {
            com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
            amVar.cp(this.bvE.JB().getTid());
            amVar.setFid(this.bvE.JB().getFid());
            amVar.a(this.bvE.Wm);
            this.buS.setData(amVar);
        }
        this.bcp.a(lVar.threadData);
        this.bvD.setData(lVar.threadData.sI());
        if (!Te() && ap.hZ(this.bvE.threadData.getId())) {
            ap.a(this.mTitle, this.bvE.JB().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            ap.a(this.bvF, this.bvE.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            ap.a(this.bvD.getGodReplyContent(), this.bvE.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            ap.a(this.bvD.getPraiseNum(), this.bvE.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        }
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        this.bvD.onChangeSkinType();
        this.bcp.setUserAfterClickListener(this.amk);
        this.bcq.a(lVar.threadData);
        this.buR.setVisibility(0);
        this.mStType = ap.rp();
        this.alX = "feed#" + lVar.Tq();
        com.baidu.tbadk.core.data.bk JB = lVar.JB();
        if (this.bcp.getHeaderImg() != null) {
            if (this.bcp.getIsSimpleThread()) {
                this.bcp.getHeaderImg().setVisibility(8);
                this.buV.setVisibility(8);
            } else if (JB.getAuthor() == null || JB.getAuthor().getPendantData() == null || StringUtils.isNull(JB.getAuthor().getPendantData().pT())) {
                this.buV.setVisibility(8);
                this.bcp.getHeaderImg().setVisibility(0);
                this.bcp.getHeaderImg().setData(JB);
            } else {
                this.bcp.getHeaderImg().setVisibility(4);
                this.buV.setVisibility(0);
                this.buV.setData(JB);
            }
        }
        ap.a(JB, this.mTitle);
        boolean z4 = ((StringUtils.isNull(JB.getTitle()) && (JB.rx() == null || JB.rx().size() == 0)) || JB.rN() == 1) ? false : true;
        StringBuilder sb = new StringBuilder();
        if (JB.rG() != null && !StringUtils.isNull(JB.rG())) {
            sb.append(JB.rG());
        }
        ArrayList<MediaData> rI = lVar.threadData.rI();
        if (rI != null) {
            i = rI.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rI.get(i2).getVideoUrl() != null && rI.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rI.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(lVar.JB().g(sb.toString(), true))) {
                SpannableString cv = lVar.threadData.cv(sb.toString());
                this.bvF.setOnTouchListener(new com.baidu.tieba.view.aa(cv));
                this.bvF.setText(cv);
                this.bvF.setVisibility(0);
                ap.a(this.bvF, lVar.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                z = true;
            } else {
                this.bvF.setVisibility(8);
                z = false;
            }
        } else {
            this.bvF.setVisibility(8);
            i = 0;
            z = false;
        }
        ArrayList<VoiceData.VoiceModel> rM = lVar.threadData.rM();
        if (com.baidu.tbadk.core.util.x.r(rM)) {
            this.bvC.setVisibility(8);
            z2 = false;
        } else {
            this.bvC.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rM.get(0);
            this.bvC.setVoiceModel(voiceModel);
            this.bvC.setTag(voiceModel);
            this.bvC.aYC();
            if (voiceModel != null) {
                this.bvC.lT(voiceModel.voice_status.intValue());
            }
            z2 = true;
        }
        if (this.bvE.bxx && z2) {
            this.bvG.setVisibility(8);
        } else if (com.baidu.tbadk.core.r.oV().pb() && com.baidu.tbadk.core.util.x.q(rI) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(rI, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.q(linkedList) > 0) {
                this.bvG.setVisibility(0);
                this.bvG.setFromCDN(this.ahv);
                this.bvG.setImageClickListener(new ax(this, linkedList2, JB));
                this.bvG.setImageUrls(linkedList);
                z3 = true;
            } else {
                this.bvG.setVisibility(8);
            }
        } else {
            this.bvG.setVisibility(8);
        }
        Ti();
        d(z4, z, z3);
        setPageUniqueId(getTag());
    }

    private void d(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvF.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bcq.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bvG.getLayoutParams();
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
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bk bkVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajr.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahv ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bkVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajr.getPageActivity()).createConfig(arrayList, i, bkVar.rD(), String.valueOf(bkVar.getFid()), bkVar.getTid(), this.ahv, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Ti() {
        if (!this.bvE.aAo) {
            this.bvC.setClickable(false);
        } else {
            this.bvC.setClickable(true);
        }
        int childCount = this.bvG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvG.getChildAt(i);
            if (childAt != null) {
                if (!this.bvE.aAo) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahv = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bvG != null) {
            this.bvG.setPageUniqueId(bdUniqueId);
        }
        if (this.buS != null) {
            this.buS.setUniqueId(bdUniqueId);
        }
        if (this.bcp != null) {
            this.bcp.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(o.a aVar) {
        if (this.buS != null) {
            this.buS.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bcp != null) {
            return this.bcp.amf;
        }
        return null;
    }

    public View Tg() {
        if (this.bcp != null) {
            return this.bcp.amg;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tj() {
        da(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(boolean z) {
        if (this.bvE != null && this.bvE.threadData != null) {
            if (!Te()) {
                ap.hY(this.bvE.threadData.getId());
                ap.a(this.mTitle, this.bvE.JB().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                ap.a(this.bvF, this.bvE.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                ap.a(this.bvD.getGodReplyContent(), this.bvE.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                ap.a(this.bvD.getPraiseNum(), this.bvE.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajr.getPageActivity()).createFromThreadCfg(this.bvE.threadData, null, ap.rp(), 18003, true, false, false).addLocateParam(this.bvE.Tr());
            addLocateParam.setForumId(String.valueOf(this.bvE.threadData.getFid()));
            if (this.bvE.bxe == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bvE.bxe);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ajr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Te() {
        return this.bvE.bxx && !this.bvE.aAo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
