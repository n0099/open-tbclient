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
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ao extends a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> GM;
    private TextView aMI;
    public ViewStub aYH;
    public TbImageView aYI;
    private TextView aYP;
    public ThreadCommentAndPraiseInfoLayout aYR;
    protected LinearLayout aZA;
    private com.baidu.tbadk.core.view.o aZB;
    private CustomMessageListener aZT;
    private boolean adw;
    private final View.OnClickListener ahd;
    private final View.OnClickListener ahz;
    private View aqu;
    public ClickableHeaderImageView bai;
    public PlayVoiceBntNew baj;
    public UserIconLayout bak;
    private com.baidu.tieba.card.data.m bal;
    private ConstrainImageGroup bam;
    private View.OnClickListener ban;
    private FrsCommonImageLayout.b bao;
    private final View.OnClickListener bap;
    private int mSkinType;

    public ao(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aZB = null;
        this.mSkinType = 3;
        this.adw = true;
        this.ban = new ap(this);
        this.aZT = new aq(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bao = new ar(this);
        this.bap = new as(this);
        this.ahz = new at(this);
        this.ahd = new au(this);
        View view = getView();
        this.GM = tbPageContext;
        this.aqu = view.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.bai = (ClickableHeaderImageView) view.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.aYH = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bai.setDefaultResource(17170445);
        this.bai.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bai.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bai.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds70));
        this.bak = (UserIconLayout) view.findViewById(r.g.card_home_page_normal_thread_user_layout);
        this.aMI = (TextView) view.findViewById(r.g.card_home_page_normal_thread_title);
        this.baj = (PlayVoiceBntNew) view.findViewById(r.g.card_home_page_normal_thread_abstract_voice);
        this.baj.setAfterClickListener(this.bap);
        this.aYP = (TextView) view.findViewById(r.g.card_home_page_normal_thread_abstract);
        this.bam = (ConstrainImageGroup) view.findViewById(r.g.card_home_page_normal_thread_img_layout);
        this.bam.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4));
        this.bam.setChildClickListener(this.ban);
        this.aYR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_home_page_normal_thread_info_layout);
        this.aZB = new com.baidu.tbadk.core.view.o(this.GM.getPageActivity());
        this.aZB.wp();
        this.aYR.addView(this.aZB);
        this.aYR.setOnClickListener(this.ban);
        this.aZA = (LinearLayout) view.findViewById(r.g.card_home_page_normal_thread_content_layout);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bam != null) {
            this.bam.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.bam != null) {
            this.bam.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aqu, r.d.cp_bg_line_b);
            this.bam.tx();
            this.bak.tx();
            this.aYR.tx();
            if (this.aZB != null) {
                this.aZB.tx();
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
        this.bal = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ban);
        }
        if (this.aZB != null) {
            this.aZB.setData(this.bal);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bal.bcm) {
            this.bai.setVisibility(8);
            this.bak.setVisibility(8);
        } else {
            this.bak.setVisibility(0);
            this.bai.setVisibility(0);
            this.bai.setData(mVar.threadData);
            this.bai.setAfterClickListener(this.ahz);
            UserTbVipInfoData rO = this.bal.threadData.rO();
            if (rO != null && rO.getvipV_url() != null && this.aYH != null) {
                if (this.aYI == null) {
                    this.aYH.inflate();
                    this.aYI = (TbImageView) getView().findViewById(r.g.user_head_mask);
                }
                this.aYI.c(rO.getvipV_url(), 10, false);
                this.bai.setIsBigV(true);
            }
        }
        this.bak.setData(mVar.threadData);
        this.bak.setUserAfterClickListener(this.ahz);
        this.aYR.setData(mVar.threadData);
        this.aYR.setForumAfterClickListener(this.ahd);
        this.aYR.setStType(an.Od());
        this.aYR.setYuelaouLocate("feed#" + mVar.Ok());
        com.baidu.tbadk.core.data.bi Jv = mVar.Jv();
        an.a(Jv, this.aMI);
        StringBuilder sb = new StringBuilder();
        if (Jv.rU() != null && !StringUtils.isNull(Jv.rU())) {
            sb.append(Jv.rU());
        }
        ArrayList<MediaData> rW = mVar.threadData.rW();
        if (rW != null) {
            i = rW.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rW.get(i2).getVideoUrl() != null && rW.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rW.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(mVar.Jv().g(sb.toString(), true))) {
                SpannableString cw = mVar.threadData.cw(sb.toString());
                this.aYP.setOnTouchListener(new com.baidu.tieba.view.y(cw));
                this.aYP.setText(cw);
                this.aYP.setVisibility(0);
                an.a(this.aYP, mVar.threadData.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
            } else {
                this.aYP.setVisibility(8);
            }
        } else {
            this.aYP.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> sa = mVar.threadData.sa();
        if (com.baidu.tbadk.core.util.y.t(sa)) {
            this.baj.setVisibility(8);
            z = false;
        } else {
            this.baj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sa.get(0);
            this.baj.setVoiceModel(voiceModel);
            this.baj.setTag(voiceModel);
            this.baj.aCk();
            if (voiceModel != null) {
                this.baj.me(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bal.bcm && z) {
            this.bam.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oH().oN() && com.baidu.tbadk.core.util.y.s(rW) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.c(rW, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.s(linkedList) > 0) {
                this.bam.setVisibility(0);
                this.bam.setFromCDN(this.adw);
                this.bam.setImageClickListener(new av(this, linkedList2, Jv));
                this.bam.setImageUrls(linkedList);
            } else {
                this.bam.setVisibility(8);
            }
        } else {
            this.bam.setVisibility(8);
        }
        Oe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bi biVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.GM.getPageActivity(), r.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.adw ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(biVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.GM.getPageActivity()).createConfig(arrayList, i, biVar.getForum_name(), String.valueOf(biVar.getFid()), biVar.getTid(), this.adw, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Oe() {
        if (!this.bal.avh) {
            this.baj.setClickable(false);
            this.aYR.setBarNameClickEnabled(false);
        } else {
            this.baj.setClickable(true);
            this.aYR.setBarNameClickEnabled(true);
        }
        int childCount = this.bam.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bam.getChildAt(i);
            if (childAt != null) {
                if (!this.bal.avh) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adw = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aYR != null && this.aZT != null) {
            this.aYR.h(bdUniqueId);
            this.aZT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Of() {
        if (this.bal != null && this.bal.threadData != null) {
            if (!NW()) {
                an.hN(this.bal.threadData.getId());
            }
            this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createFromThreadCfg(this.bal.threadData, null, an.Od(), 18003, true, false, false).addLocateParam(this.bal.Ol())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean NW() {
        return this.bal.bcm && !this.bal.avh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
