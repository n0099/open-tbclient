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
public class aq extends a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> GO;
    private TextView aNY;
    private boolean adn;
    private final View.OnClickListener ahA;
    private final View.OnClickListener ahg;
    private View aqR;
    public ViewStub baW;
    public TbImageView baX;
    private CardGroupDividerView bbM;
    private TextView bbe;
    public ThreadCommentAndPraiseInfoLayout bbg;
    public ClickableHeaderImageView bcJ;
    public PlayVoiceBntNew bcK;
    public View bcL;
    public UserIconLayout bcM;
    private com.baidu.tieba.card.data.m bcN;
    private ConstrainImageGroup bcO;
    private View.OnClickListener bcP;
    private FrsCommonImageLayout.b bcQ;
    private final View.OnClickListener bcR;
    protected LinearLayout bcd;
    private com.baidu.tbadk.core.view.o bce;
    private CustomMessageListener bct;
    private int mSkinType;

    public aq(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bce = null;
        this.mSkinType = 3;
        this.adn = true;
        this.bcP = new ar(this);
        this.bct = new as(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bcQ = new at(this);
        this.bcR = new au(this);
        this.ahA = new av(this);
        this.ahg = new aw(this);
        View view = getView();
        this.GO = tbPageContext;
        this.aqR = view.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.bcJ = (ClickableHeaderImageView) view.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.baW = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bcJ.setDefaultResource(17170445);
        this.bcJ.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bcJ.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bcJ.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.bcM = (UserIconLayout) view.findViewById(r.g.card_home_page_normal_thread_user_layout);
        this.aNY = (TextView) view.findViewById(r.g.card_home_page_normal_thread_title);
        this.bcK = (PlayVoiceBntNew) view.findViewById(r.g.card_home_page_normal_thread_abstract_voice);
        this.bcK.setAfterClickListener(this.bcR);
        this.bbe = (TextView) view.findViewById(r.g.card_home_page_normal_thread_abstract);
        this.bcO = (ConstrainImageGroup) view.findViewById(r.g.card_home_page_normal_thread_img_layout);
        this.bcO.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4));
        this.bcO.setChildClickListener(this.bcP);
        this.bbg = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_home_page_normal_thread_info_layout);
        this.bcL = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bce = new com.baidu.tbadk.core.view.o(this.GO.getPageActivity());
        this.bce.wd();
        this.bbg.addView(this.bce);
        this.bbg.setOnClickListener(this.bcP);
        this.bcd = (LinearLayout) view.findViewById(r.g.card_home_page_normal_thread_content_layout);
        this.bbM = (CardGroupDividerView) view.findViewById(r.g.header_divider);
    }

    public void setSingleImageRatio(double d) {
        if (this.bcO != null) {
            this.bcO.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bcO != null) {
            this.bcO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.bcO != null) {
            this.bcO.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(getView(), r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.ar.l(this.aqR, r.d.cp_bg_line_b);
            this.bcO.tm();
            this.bcM.tm();
            this.bbg.tm();
            if (this.bce != null) {
                this.bce.tm();
            }
            if (this.bbM != null) {
                this.bbM.tm();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.m mVar) {
        int i;
        boolean z;
        if (mVar == null || mVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bcN = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bcP);
        }
        if (this.bce != null) {
            this.bce.setData(this.bcN);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bcN.beA) {
            this.bcJ.setVisibility(8);
            this.bcM.setVisibility(8);
        } else {
            this.bcM.setVisibility(0);
            this.bcJ.setVisibility(0);
            this.bcJ.setData(mVar.threadData);
            this.bcJ.setAfterClickListener(this.ahA);
            UserTbVipInfoData rF = this.bcN.threadData.rF();
            if (rF != null && rF.getvipV_url() != null && this.baW != null) {
                if (this.baX == null) {
                    this.baW.inflate();
                    this.baX = (TbImageView) getView().findViewById(r.g.user_head_mask);
                }
                this.baX.c(rF.getvipV_url(), 10, false);
                this.bcJ.setIsBigV(true);
            }
        }
        this.bcM.setData(mVar.threadData);
        this.bcM.setUserAfterClickListener(this.ahA);
        if (this.bbg.a(mVar.threadData)) {
            this.bcL.setVisibility(8);
        } else {
            this.bcL.setVisibility(0);
        }
        this.bbg.setForumAfterClickListener(this.ahg);
        this.bbg.setStType(ap.OB());
        this.bbg.setYuelaouLocate("feed#" + mVar.OJ());
        com.baidu.tbadk.core.data.bg IU = mVar.IU();
        ap.a(IU, this.aNY);
        StringBuilder sb = new StringBuilder();
        if (IU.rN() != null && !StringUtils.isNull(IU.rN())) {
            sb.append(IU.rN());
        }
        ArrayList<MediaData> rP = mVar.threadData.rP();
        if (rP != null) {
            i = rP.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rP.get(i2).getVideoUrl() != null && rP.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rP.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(mVar.IU().g(sb.toString(), true))) {
                SpannableString cz = mVar.threadData.cz(sb.toString());
                this.bbe.setOnTouchListener(new com.baidu.tieba.view.x(cz));
                this.bbe.setText(cz);
                this.bbe.setVisibility(0);
                ap.a(this.bbe, mVar.threadData.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
            } else {
                this.bbe.setVisibility(8);
            }
        } else {
            this.bbe.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rT = mVar.threadData.rT();
        if (com.baidu.tbadk.core.util.x.t(rT)) {
            this.bcK.setVisibility(8);
            z = false;
        } else {
            this.bcK.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rT.get(0);
            this.bcK.setVoiceModel(voiceModel);
            this.bcK.setTag(voiceModel);
            this.bcK.axx();
            if (voiceModel != null) {
                this.bcK.lw(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bcN.beA && z) {
            this.bcO.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oJ().oP() && com.baidu.tbadk.core.util.x.s(rP) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(rP, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.s(linkedList) > 0) {
                this.bcO.setVisibility(0);
                this.bcO.setFromCDN(this.adn);
                this.bcO.setImageClickListener(new ax(this, linkedList2, IU));
                this.bcO.setImageUrls(linkedList);
            } else {
                this.bcO.setVisibility(8);
            }
        } else {
            this.bcO.setVisibility(8);
        }
        OC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bg bgVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.GO.getPageActivity(), r.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.adn ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bgVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.GO.getPageActivity()).createConfig(arrayList, i, bgVar.rK(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.adn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void OC() {
        if (!this.bcN.avy) {
            this.bcK.setClickable(false);
            this.bbg.setBarNameClickEnabled(false);
        } else {
            this.bcK.setClickable(true);
            this.bbg.setBarNameClickEnabled(true);
        }
        int childCount = this.bcO.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bcO.getChildAt(i);
            if (childAt != null) {
                if (!this.bcN.avy) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adn = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbg != null && this.bct != null) {
            this.bbg.h(bdUniqueId);
            this.bct.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bct);
        }
    }

    public void a(o.a aVar) {
        if (this.bce != null) {
            this.bce.setEventCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        if (this.bcN != null && this.bcN.threadData != null) {
            if (!Ow()) {
                ap.hL(this.bcN.threadData.getId());
            }
            this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createFromThreadCfg(this.bcN.threadData, null, ap.OB(), 18003, true, false, false).addLocateParam(this.bcN.OK())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ow() {
        return this.bcN.beA && !this.bcN.avy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
