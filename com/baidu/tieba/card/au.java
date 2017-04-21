package com.baidu.tieba.card;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class au extends a<com.baidu.tieba.card.data.n> {
    private boolean aid;
    private TbPageContext<?> ajU;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    private View avJ;
    public ViewStub bbW;
    public TbImageView bbX;
    protected LinearLayout bca;
    private TextView btU;
    public ThreadCommentAndPraiseInfoLayout btW;
    private CardGroupDividerView buD;
    private com.baidu.tbadk.core.view.o buV;
    private CustomMessageListener buW;
    public TextView buZ;
    public ClickableHeaderImageView bvD;
    public PlayVoiceBntNew bvE;
    public View bvF;
    public UserIconLayout bvG;
    private com.baidu.tieba.card.data.n bvH;
    private ConstrainImageGroup bvI;
    private View.OnClickListener bvJ;
    private FrsCommonImageLayout.b bvK;
    private final View.OnClickListener bvL;
    private int mSkinType;
    private TextView mTitle;

    public au(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.buV = null;
        this.mSkinType = 3;
        this.aid = true;
        this.bvJ = new av(this);
        this.buW = new aw(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bvK = new ax(this);
        this.bvL = new ay(this);
        this.amx = new az(this);
        this.ama = new ba(this);
        View view = getView();
        this.ajU = tbPageContext;
        this.avJ = view.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.bvD = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bbW = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bvD.setDefaultResource(17170445);
        this.bvD.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bvD.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bvD.setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds70));
        this.bvG = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bvE = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bvE.setAfterClickListener(this.bvL);
        this.btU = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bvI = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bvI.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4));
        this.bvI.setChildClickListener(this.bvJ);
        this.btW = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bvF = view.findViewById(w.h.divider_below_reply_number_layout);
        this.buV = new com.baidu.tbadk.core.view.o(this.ajU);
        this.buV.wQ();
        this.btW.addView(this.buV);
        if (this.btW.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.btW.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.btW.setLayoutParams(layoutParams);
        }
        this.btW.setOnClickListener(this.bvJ);
        this.bca = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.buD = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    public void TM() {
        if (this.buZ == null) {
            this.buZ = new TextView(this.ajU.getPageActivity());
            this.buZ.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds24));
            this.buZ.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds20);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds2);
            this.buZ.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.aq.i(this.buZ, w.e.cp_cont_b);
            this.bvG.addView(this.buZ);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.bvI != null) {
            this.bvI.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bvI != null) {
            this.bvI.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bvI != null) {
            this.bvI.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avJ, w.e.cp_bg_line_b);
            this.bvI.onChangeSkinType();
            this.bvG.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.i(this.buZ, w.e.cp_cont_b);
            this.btW.onChangeSkinType();
            if (this.buV != null) {
                this.buV.onChangeSkinType();
            }
            if (this.buD != null) {
                this.buD.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.n nVar) {
        int i;
        boolean z;
        if (nVar == null || nVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bvH = nVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bvJ);
        }
        if (this.buV != null && this.bvH.Kn() != null) {
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.cp(this.bvH.Kn().getTid());
            alVar.setFid(this.bvH.Kn().getFid());
            alVar.a(this.bvH.WU);
            this.buV.setData(alVar);
        }
        onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bvH.bxz) {
            this.bvD.setVisibility(8);
            this.bvG.setVisibility(8);
        } else {
            this.bvG.setVisibility(0);
            this.bvD.setVisibility(0);
            this.bvD.setData(nVar.threadData);
            this.bvD.setAfterClickListener(this.amx);
            UserTbVipInfoData sp = this.bvH.threadData.sp();
            if (sp != null && sp.getvipV_url() != null && this.bbW != null) {
                if (this.bbX == null) {
                    this.bbW.inflate();
                    this.bbX = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.bbX.c(sp.getvipV_url(), 10, false);
                this.bvD.setIsBigV(true);
            }
        }
        this.bvG.setData(nVar.threadData);
        this.bvG.setUserAfterClickListener(this.amx);
        if (this.btW.a(nVar.threadData)) {
            this.bvF.setVisibility(8);
        } else {
            this.bvF.setVisibility(0);
        }
        if (this.buZ != null) {
            if (nVar.threadData.sj() <= 0) {
                this.buZ.setVisibility(8);
            } else {
                this.buZ.setVisibility(0);
                this.buZ.setText(com.baidu.tbadk.core.util.au.r(nVar.threadData.sj() * 1000));
            }
        }
        this.btW.setForumAfterClickListener(this.ama);
        this.btW.setStType(at.sf());
        this.btW.setYuelaouLocate("feed#" + nVar.TX());
        com.baidu.tbadk.core.data.bi Kn = nVar.Kn();
        at.a(Kn, this.mTitle);
        StringBuilder sb = new StringBuilder();
        if (Kn.sw() != null && !StringUtils.isNull(Kn.sw())) {
            sb.append(Kn.sw());
        }
        ArrayList<MediaData> sy = nVar.threadData.sy();
        if (sy != null) {
            i = sy.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (sy.get(i2).getVideoUrl() != null && sy.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(sy.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(nVar.Kn().g(sb.toString(), true))) {
                SpannableString cx = nVar.threadData.cx(sb.toString());
                this.btU.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                this.btU.setText(cx);
                this.btU.setVisibility(0);
                at.a(this.btU, nVar.threadData.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            } else {
                this.btU.setVisibility(8);
            }
        } else {
            this.btU.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> sC = nVar.threadData.sC();
        if (com.baidu.tbadk.core.util.x.q(sC)) {
            this.bvE.setVisibility(8);
            z = false;
        } else {
            this.bvE.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sC.get(0);
            this.bvE.setVoiceModel(voiceModel);
            this.bvE.setTag(voiceModel);
            this.bvE.bbd();
            if (voiceModel != null) {
                this.bvE.mg(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bvH.bxz && z) {
            this.bvI.setVisibility(8);
        } else if (com.baidu.tbadk.core.q.po().pu() && com.baidu.tbadk.core.util.x.p(sy) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(sy, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.p(linkedList) > 0) {
                this.bvI.setVisibility(0);
                this.bvI.setFromCDN(this.aid);
                this.bvI.setImageClickListener(new bb(this, linkedList2, Kn));
                this.bvI.setImageUrls(linkedList);
            } else {
                this.bvI.setVisibility(8);
            }
        } else {
            this.bvI.setVisibility(8);
        }
        TQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bi biVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajU.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aid ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(biVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajU.getPageActivity()).createConfig(arrayList, i, biVar.st(), String.valueOf(biVar.getFid()), biVar.getTid(), this.aid, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void TQ() {
        if (!this.bvH.aAq) {
            this.bvE.setClickable(false);
            this.btW.setBarNameClickEnabled(false);
        } else {
            this.bvE.setClickable(true);
            this.btW.setBarNameClickEnabled(true);
        }
        int childCount = this.bvI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvI.getChildAt(i);
            if (childAt != null) {
                if (!this.bvH.aAq) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aid = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.btW != null && this.buW != null) {
            this.btW.h(bdUniqueId);
            this.buW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buW);
        }
    }

    public void a(o.a aVar) {
        if (this.buV != null) {
            this.buV.setEventCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TR() {
        if (this.bvH != null && this.bvH.threadData != null) {
            if (!TN()) {
                at.hZ(this.bvH.threadData.getId());
            }
            this.ajU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajU.getPageActivity()).createFromThreadCfg(this.bvH.threadData, null, at.sf(), 18003, true, false, false).addLocateParam(this.bvH.TY())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TN() {
        return this.bvH.bxz && !this.bvH.aAq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
