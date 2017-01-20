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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class au extends a<com.baidu.tieba.card.data.n> {
    private TbPageContext<?> FY;
    private TextView aNb;
    public ViewStub aUU;
    public TbImageView aUV;
    protected LinearLayout aUY;
    private boolean acy;
    private final View.OnClickListener agO;
    private final View.OnClickListener agt;
    private View apX;
    private TextView bkS;
    public ThreadCommentAndPraiseInfoLayout bkU;
    private CustomMessageListener blR;
    private com.baidu.tbadk.core.view.o blU;
    private CardGroupDividerView blz;
    public View bmA;
    public UserIconLayout bmB;
    private com.baidu.tieba.card.data.n bmC;
    private ConstrainImageGroup bmD;
    private View.OnClickListener bmE;
    private FrsCommonImageLayout.b bmF;
    private final View.OnClickListener bmG;
    public ClickableHeaderImageView bmy;
    public PlayVoiceBntNew bmz;
    private int mSkinType;

    public au(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.blU = null;
        this.mSkinType = 3;
        this.acy = true;
        this.bmE = new av(this);
        this.blR = new aw(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bmF = new ax(this);
        this.bmG = new ay(this);
        this.agO = new az(this);
        this.agt = new ba(this);
        View view = getView();
        this.FY = tbPageContext;
        this.apX = view.findViewById(r.h.card_home_page_normal_thread_top_line);
        this.bmy = (ClickableHeaderImageView) view.findViewById(r.h.card_home_page_normal_thread_user_header);
        this.aUU = (ViewStub) view.findViewById(r.h.viewstub_headimage_mask);
        this.bmy.setDefaultResource(17170445);
        this.bmy.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.bmy.setDefaultBgResource(r.e.cp_bg_line_e);
        this.bmy.setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds70));
        this.bmB = (UserIconLayout) view.findViewById(r.h.card_home_page_normal_thread_user_layout);
        this.aNb = (TextView) view.findViewById(r.h.card_home_page_normal_thread_title);
        this.bmz = (PlayVoiceBntNew) view.findViewById(r.h.card_home_page_normal_thread_abstract_voice);
        this.bmz.setAfterClickListener(this.bmG);
        this.bkS = (TextView) view.findViewById(r.h.card_home_page_normal_thread_abstract);
        this.bmD = (ConstrainImageGroup) view.findViewById(r.h.card_home_page_normal_thread_img_layout);
        this.bmD.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds4));
        this.bmD.setChildClickListener(this.bmE);
        this.bkU = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.h.card_home_page_normal_thread_info_layout);
        this.bmA = view.findViewById(r.h.divider_below_reply_number_layout);
        this.blU = new com.baidu.tbadk.core.view.o(this.FY);
        this.blU.vX();
        this.bkU.addView(this.blU);
        this.blU.vY();
        this.bkU.setOnClickListener(this.bmE);
        this.aUY = (LinearLayout) view.findViewById(r.h.card_home_page_normal_thread_content_layout);
        this.blz = (CardGroupDividerView) view.findViewById(r.h.header_divider);
    }

    public void setSingleImageRatio(double d) {
        if (this.bmD != null) {
            this.bmD.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bmD != null) {
            this.bmD.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bmD != null) {
            this.bmD.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.j(getView(), r.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.ap.k(this.apX, r.e.cp_bg_line_b);
            this.bmD.tg();
            this.bmB.tg();
            this.bkU.tg();
            if (this.blU != null) {
                this.blU.tg();
            }
            if (this.blz != null) {
                this.blz.tg();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_home_page_multi_img;
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
        this.bmC = nVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bmE);
        }
        if (this.blU != null) {
            this.blU.setData(this.bmC);
        }
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bmC.bou) {
            this.bmy.setVisibility(8);
            this.bmB.setVisibility(8);
        } else {
            this.bmB.setVisibility(0);
            this.bmy.setVisibility(0);
            this.bmy.setData(nVar.threadData);
            this.bmy.setAfterClickListener(this.agO);
            UserTbVipInfoData rx = this.bmC.threadData.rx();
            if (rx != null && rx.getvipV_url() != null && this.aUU != null) {
                if (this.aUV == null) {
                    this.aUU.inflate();
                    this.aUV = (TbImageView) getView().findViewById(r.h.user_head_mask);
                }
                this.aUV.c(rx.getvipV_url(), 10, false);
                this.bmy.setIsBigV(true);
            }
        }
        this.bmB.setData(nVar.threadData);
        this.bmB.setUserAfterClickListener(this.agO);
        if (this.bkU.a(nVar.threadData)) {
            this.bmA.setVisibility(8);
        } else {
            this.bmA.setVisibility(0);
        }
        this.bkU.setForumAfterClickListener(this.agt);
        this.bkU.setStType(at.Mt());
        this.bkU.setYuelaouLocate("feed#" + nVar.Rz());
        com.baidu.tbadk.core.data.bh Ji = nVar.Ji();
        at.a(Ji, this.aNb);
        StringBuilder sb = new StringBuilder();
        if (Ji.rE() != null && !StringUtils.isNull(Ji.rE())) {
            sb.append(Ji.rE());
        }
        ArrayList<MediaData> rG = nVar.threadData.rG();
        if (rG != null) {
            i = rG.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rG.get(i2).getVideoUrl() != null && rG.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rG.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(nVar.Ji().g(sb.toString(), true))) {
                SpannableString cx = nVar.threadData.cx(sb.toString());
                this.bkS.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                this.bkS.setText(cx);
                this.bkS.setVisibility(0);
                at.a(this.bkS, nVar.threadData.getId(), r.e.cp_cont_c, r.e.cp_cont_d);
            } else {
                this.bkS.setVisibility(8);
            }
        } else {
            this.bkS.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rK = nVar.threadData.rK();
        if (com.baidu.tbadk.core.util.w.s(rK)) {
            this.bmz.setVisibility(8);
            z = false;
        } else {
            this.bmz.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rK.get(0);
            this.bmz.setVoiceModel(voiceModel);
            this.bmz.setTag(voiceModel);
            this.bmz.ayK();
            if (voiceModel != null) {
                this.bmz.mj(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bmC.bou && z) {
            this.bmD.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oC().oI() && com.baidu.tbadk.core.util.w.r(rG) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.c(rG, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.w.r(linkedList) > 0) {
                this.bmD.setVisibility(0);
                this.bmD.setFromCDN(this.acy);
                this.bmD.setImageClickListener(new bb(this, linkedList2, Ji));
                this.bmD.setImageUrls(linkedList);
            } else {
                this.bmD.setVisibility(8);
            }
        } else {
            this.bmD.setVisibility(8);
        }
        Rs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bh bhVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.FY.getPageActivity(), r.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.acy ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.FY.getPageActivity()).createConfig(arrayList, i, bhVar.rB(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.acy, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Rs() {
        if (!this.bmC.auD) {
            this.bmz.setClickable(false);
            this.bkU.setBarNameClickEnabled(false);
        } else {
            this.bmz.setClickable(true);
            this.bkU.setBarNameClickEnabled(true);
        }
        int childCount = this.bmD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bmD.getChildAt(i);
            if (childAt != null) {
                if (!this.bmC.auD) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.acy = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bkU != null && this.blR != null) {
            this.bkU.h(bdUniqueId);
            this.blR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blR);
        }
    }

    public void a(o.a aVar) {
        if (this.blU != null) {
            this.blU.setEventCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rt() {
        if (this.bmC != null && this.bmC.threadData != null) {
            if (!Rp()) {
                at.ie(this.bmC.threadData.getId());
            }
            this.FY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.FY.getPageActivity()).createFromThreadCfg(this.bmC.threadData, null, at.Mt(), 18003, true, false, false).addLocateParam(this.bmC.RA())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Rp() {
        return this.bmC.bou && !this.bmC.auD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
