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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ao extends a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> GO;
    private TextView aOH;
    private boolean adU;
    private final View.OnClickListener ahD;
    private final View.OnClickListener ahZ;
    private View aro;
    public ViewStub bbQ;
    public TbImageView bbR;
    private TextView bbY;
    protected LinearLayout bcK;
    private com.baidu.tbadk.core.view.o bcL;
    public ThreadCommentAndPraiseInfoLayout bca;
    private CustomMessageListener bdb;
    public ClickableHeaderImageView bdr;
    public PlayVoiceBntNew bds;
    public View bdt;
    public UserIconLayout bdu;
    private com.baidu.tieba.card.data.m bdv;
    private ConstrainImageGroup bdw;
    private View.OnClickListener bdx;
    private FrsCommonImageLayout.b bdy;
    private final View.OnClickListener bdz;
    private int mSkinType;

    public ao(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bcL = null;
        this.mSkinType = 3;
        this.adU = true;
        this.bdx = new ap(this);
        this.bdb = new aq(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bdy = new ar(this);
        this.bdz = new as(this);
        this.ahZ = new at(this);
        this.ahD = new au(this);
        View view = getView();
        this.GO = tbPageContext;
        this.aro = view.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.bdr = (ClickableHeaderImageView) view.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.bbQ = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bdr.setDefaultResource(17170445);
        this.bdr.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bdr.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bdr.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.bdu = (UserIconLayout) view.findViewById(r.g.card_home_page_normal_thread_user_layout);
        this.aOH = (TextView) view.findViewById(r.g.card_home_page_normal_thread_title);
        this.bds = (PlayVoiceBntNew) view.findViewById(r.g.card_home_page_normal_thread_abstract_voice);
        this.bds.setAfterClickListener(this.bdz);
        this.bbY = (TextView) view.findViewById(r.g.card_home_page_normal_thread_abstract);
        this.bdw = (ConstrainImageGroup) view.findViewById(r.g.card_home_page_normal_thread_img_layout);
        this.bdw.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4));
        this.bdw.setChildClickListener(this.bdx);
        this.bca = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_home_page_normal_thread_info_layout);
        this.bdt = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bcL = new com.baidu.tbadk.core.view.o(this.GO.getPageActivity());
        this.bcL.wt();
        this.bca.addView(this.bcL);
        this.bca.setOnClickListener(this.bdx);
        this.bcK = (LinearLayout) view.findViewById(r.g.card_home_page_normal_thread_content_layout);
    }

    public void setSingleImageRatio(double d) {
        if (this.bdw != null) {
            this.bdw.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bdw != null) {
            this.bdw.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.bdw != null) {
            this.bdw.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aro, r.d.cp_bg_line_b);
            this.bdw.tB();
            this.bdu.tB();
            this.bca.tB();
            if (this.bcL != null) {
                this.bcL.tB();
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
        this.bdv = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bdx);
        }
        if (this.bcL != null) {
            this.bcL.setData(this.bdv);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bdv.bfl) {
            this.bdr.setVisibility(8);
            this.bdu.setVisibility(8);
        } else {
            this.bdu.setVisibility(0);
            this.bdr.setVisibility(0);
            this.bdr.setData(mVar.threadData);
            this.bdr.setAfterClickListener(this.ahZ);
            UserTbVipInfoData rQ = this.bdv.threadData.rQ();
            if (rQ != null && rQ.getvipV_url() != null && this.bbQ != null) {
                if (this.bbR == null) {
                    this.bbQ.inflate();
                    this.bbR = (TbImageView) getView().findViewById(r.g.user_head_mask);
                }
                this.bbR.c(rQ.getvipV_url(), 10, false);
                this.bdr.setIsBigV(true);
            }
        }
        this.bdu.setData(mVar.threadData);
        this.bdu.setUserAfterClickListener(this.ahZ);
        if (this.bca.a(mVar.threadData)) {
            this.bdt.setVisibility(8);
        } else {
            this.bdt.setVisibility(0);
        }
        this.bca.setForumAfterClickListener(this.ahD);
        this.bca.setStType(an.Pf());
        this.bca.setYuelaouLocate("feed#" + mVar.Pn());
        com.baidu.tbadk.core.data.bk Jz = mVar.Jz();
        an.a(Jz, this.aOH);
        StringBuilder sb = new StringBuilder();
        if (Jz.rW() != null && !StringUtils.isNull(Jz.rW())) {
            sb.append(Jz.rW());
        }
        ArrayList<MediaData> rY = mVar.threadData.rY();
        if (rY != null) {
            i = rY.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rY.get(i2).getVideoUrl() != null && rY.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rY.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(mVar.Jz().g(sb.toString(), true))) {
                SpannableString cy = mVar.threadData.cy(sb.toString());
                this.bbY.setOnTouchListener(new com.baidu.tieba.view.x(cy));
                this.bbY.setText(cy);
                this.bbY.setVisibility(0);
                an.a(this.bbY, mVar.threadData.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
            } else {
                this.bbY.setVisibility(8);
            }
        } else {
            this.bbY.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> sc = mVar.threadData.sc();
        if (com.baidu.tbadk.core.util.x.t(sc)) {
            this.bds.setVisibility(8);
            z = false;
        } else {
            this.bds.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sc.get(0);
            this.bds.setVoiceModel(voiceModel);
            this.bds.setTag(voiceModel);
            this.bds.aEg();
            if (voiceModel != null) {
                this.bds.mm(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bdv.bfl && z) {
            this.bdw.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oJ().oP() && com.baidu.tbadk.core.util.x.s(rY) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(rY, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.s(linkedList) > 0) {
                this.bdw.setVisibility(0);
                this.bdw.setFromCDN(this.adU);
                this.bdw.setImageClickListener(new av(this, linkedList2, Jz));
                this.bdw.setImageUrls(linkedList);
            } else {
                this.bdw.setVisibility(8);
            }
        } else {
            this.bdw.setVisibility(8);
        }
        Pg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bk bkVar) {
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
                    imageUrlData.urlType = this.adU ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(bkVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.GO.getPageActivity()).createConfig(arrayList, i, bkVar.getForum_name(), String.valueOf(bkVar.getFid()), bkVar.getTid(), this.adU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Pg() {
        if (!this.bdv.awb) {
            this.bds.setClickable(false);
            this.bca.setBarNameClickEnabled(false);
        } else {
            this.bds.setClickable(true);
            this.bca.setBarNameClickEnabled(true);
        }
        int childCount = this.bdw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bdw.getChildAt(i);
            if (childAt != null) {
                if (!this.bdv.awb) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adU = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bca != null && this.bdb != null) {
            this.bca.h(bdUniqueId);
            this.bdb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdb);
        }
    }

    public void a(o.a aVar) {
        if (this.bcL != null) {
            this.bcL.setEventCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        if (this.bdv != null && this.bdv.threadData != null) {
            if (!Pa()) {
                an.hR(this.bdv.threadData.getId());
            }
            this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createFromThreadCfg(this.bdv.threadData, null, an.Pf(), 18003, true, false, false).addLocateParam(this.bdv.Po())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Pa() {
        return this.bdv.bfl && !this.bdv.awb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
