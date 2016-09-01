package com.baidu.tieba.card;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class aq extends a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> GM;
    private View aYc;
    public ViewStub aYe;
    public TbImageView aYf;
    private TextView aYh;
    private TextView aYn;
    public ThreadCommentAndPraiseInfoLayout aYp;
    private CustomMessageListener aZB;
    public ClickableHeaderImageView aZR;
    public PlayVoiceBntNew aZS;
    public UserIconLayout aZT;
    private com.baidu.tieba.card.data.m aZU;
    private ConstrainImageGroup aZV;
    private View.OnClickListener aZW;
    private FrsCommonImageLayout.b aZX;
    private final View.OnClickListener aZY;
    protected LinearLayout aZg;
    private boolean adl;
    private final View.OnClickListener ahR;
    private final View.OnClickListener ahu;
    private int mSkinType;

    public aq(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.adl = true;
        this.aZW = new ar(this);
        this.aZB = new as(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aZX = new at(this);
        this.aZY = new au(this);
        this.ahR = new av(this);
        this.ahu = new aw(this);
        View view = getView();
        this.GM = tbPageContext;
        this.aYc = view.findViewById(t.g.card_home_page_normal_thread_top_line);
        this.aZR = (ClickableHeaderImageView) view.findViewById(t.g.card_home_page_normal_thread_user_header);
        this.aYe = (ViewStub) view.findViewById(t.g.viewstub_headimage_mask);
        this.aZR.setDefaultResource(17170445);
        this.aZR.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aZR.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aZR.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds70));
        this.aZT = (UserIconLayout) view.findViewById(t.g.card_home_page_normal_thread_user_layout);
        this.aYh = (TextView) view.findViewById(t.g.card_home_page_normal_thread_title);
        this.aZS = (PlayVoiceBntNew) view.findViewById(t.g.card_home_page_normal_thread_abstract_voice);
        this.aZS.setAfterClickListener(this.aZY);
        this.aYn = (TextView) view.findViewById(t.g.card_home_page_normal_thread_abstract);
        this.aZV = (ConstrainImageGroup) view.findViewById(t.g.card_home_page_normal_thread_img_layout);
        this.aZV.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds4));
        this.aZV.setChildClickListener(this.aZW);
        this.aYp = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_home_page_normal_thread_info_layout);
        this.aYp.setOnClickListener(this.aZW);
        this.aZg = (LinearLayout) view.findViewById(t.g.card_home_page_normal_thread_content_layout);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.aZV != null) {
            this.aZV.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.aZV != null) {
            this.aZV.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aYc, t.d.cp_bg_line_b);
            this.aZV.ti();
            this.aZT.ti();
            this.aYp.ti();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_home_page_multi_img;
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
        this.aZU = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aZW);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.aZU.bbU) {
            this.aZR.setVisibility(8);
            this.aZT.setVisibility(8);
        } else {
            this.aZT.setVisibility(0);
            this.aZR.setVisibility(0);
            this.aZR.setData(mVar.threadData);
            this.aZR.setAfterClickListener(this.ahR);
            UserTbVipInfoData rC = this.aZU.threadData.rC();
            if (rC != null && rC.getvipV_url() != null && this.aYe != null) {
                if (this.aYf == null) {
                    this.aYe.inflate();
                    this.aYf = (TbImageView) getView().findViewById(t.g.user_head_mask);
                }
                this.aYf.c(rC.getvipV_url(), 10, false);
                this.aZR.setIsBigV(true);
            }
        }
        this.aZT.setData(mVar.threadData);
        this.aZT.setUserAfterClickListener(this.ahR);
        this.aYp.setData(mVar.threadData);
        this.aYp.setForumAfterClickListener(this.ahu);
        this.aYp.setStType(ap.ND());
        this.aYp.setYuelaouLocate("feed#" + mVar.NJ());
        if ((StringUtils.isNull(mVar.threadData.getTitle()) && (mVar.threadData.rA() == null || mVar.threadData.rA().size() == 0)) || mVar.threadData.rP() == 1) {
            this.aYh.setVisibility(8);
        } else {
            this.aYh.setVisibility(0);
            mVar.threadData.Ts = 0;
            mVar.threadData.si();
            SpannableStringBuilder sa = mVar.threadData.sa();
            this.aYh.setOnTouchListener(new com.baidu.tieba.view.y(sa));
            this.aYh.setText(sa);
            ap.a(this.aYh, mVar.Kw().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (mVar.threadData.rI() != null && !StringUtils.isNull(mVar.threadData.rI())) {
            sb.append(mVar.threadData.rI());
        }
        ArrayList<MediaData> rK = mVar.threadData.rK();
        if (rK != null) {
            i = rK.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rK.get(i2).getVideoUrl() != null && rK.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rK.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(mVar.Kw().g(sb.toString(), true))) {
                SpannableString cu = mVar.threadData.cu(sb.toString());
                this.aYn.setOnTouchListener(new com.baidu.tieba.view.y(cu));
                this.aYn.setText(cu);
                this.aYn.setVisibility(0);
                ap.a(this.aYn, mVar.threadData.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
            } else {
                this.aYn.setVisibility(8);
            }
        } else {
            this.aYn.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rO = mVar.threadData.rO();
        if (com.baidu.tbadk.core.util.y.t(rO)) {
            this.aZS.setVisibility(8);
            z = false;
        } else {
            this.aZS.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rO.get(0);
            this.aZS.setVoiceModel(voiceModel);
            this.aZS.setTag(voiceModel);
            this.aZS.bkk();
            if (voiceModel != null) {
                this.aZS.lW(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.aZU.bbU && z) {
            this.aZV.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oG().oM() && com.baidu.tbadk.core.util.y.s(rK) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.bg Kw = mVar.Kw();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.c(rK, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.s(linkedList) > 0) {
                this.aZV.setVisibility(0);
                this.aZV.setFromCDN(this.adl);
                this.aZV.setImageClickListener(new ax(this, linkedList2, Kw));
                this.aZV.setImageUrls(linkedList);
            } else {
                this.aZV.setVisibility(8);
            }
        } else {
            this.aZV.setVisibility(8);
        }
        NE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bg bgVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.GM.getPageActivity(), t.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.adl ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.GM.getPageActivity()).createConfig(arrayList, i, bgVar.getForum_name(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.adl, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void NE() {
        if (!this.aZU.avE) {
            this.aZS.setClickable(false);
            this.aYp.setBarNameClickEnabled(false);
        } else {
            this.aZS.setClickable(true);
            this.aYp.setBarNameClickEnabled(true);
        }
        int childCount = this.aZV.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aZV.getChildAt(i);
            if (childAt != null) {
                if (!this.aZU.avE) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adl = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aYp != null && this.aZB != null) {
            this.aYp.h(bdUniqueId);
            this.aZB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF() {
        if (this.aZU != null && this.aZU.threadData != null) {
            if (!Nv()) {
                ap.hG(this.aZU.threadData.getId());
            }
            this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createFromThreadCfg(this.aZU.threadData, null, ap.ND(), 18003, true, false, false).addLocateParam(this.aZU.NK())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nv() {
        return this.aZU.bbU && !this.aZU.avE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
