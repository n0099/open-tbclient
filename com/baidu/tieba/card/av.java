package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
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
public class av extends a<com.baidu.tieba.card.a.l> {
    private TbPageContext<?> DV;
    private boolean Zv;
    private View aOD;
    private TextView aOG;
    private TextView aOM;
    public ThreadCommentAndPraiseInfoLayout aOO;
    protected LinearLayout aPG;
    private CustomMessageListener aQc;
    public ClickableHeaderImageView aQn;
    public PlayVoiceBntNew aQo;
    public UserIconLayout aQp;
    private com.baidu.tieba.card.a.l aQq;
    private ConstrainImageGroup aQr;
    private View.OnClickListener aQs;
    private FrsCommonImageLayout.b aQt;
    private final View.OnClickListener aQu;
    private final View.OnClickListener adK;
    private final View.OnClickListener adn;
    private int mSkinType;

    public av(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Zv = true;
        this.aQs = new aw(this);
        this.aQc = new ax(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aQt = new ay(this);
        this.aQu = new az(this);
        this.adK = new ba(this);
        this.adn = new bb(this);
        View view = getView();
        this.DV = tbPageContext;
        this.aOD = view.findViewById(t.g.card_home_page_normal_thread_top_line);
        this.aQn = (ClickableHeaderImageView) view.findViewById(t.g.card_home_page_normal_thread_user_header);
        this.aQn.setDefaultResource(17170445);
        this.aQn.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aQn.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aQn.setRadius(com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds70));
        this.aQp = (UserIconLayout) view.findViewById(t.g.card_home_page_normal_thread_user_layout);
        this.aOG = (TextView) view.findViewById(t.g.card_home_page_normal_thread_title);
        this.aQo = (PlayVoiceBntNew) view.findViewById(t.g.card_home_page_normal_thread_abstract_voice);
        this.aQo.setAfterClickListener(this.aQu);
        this.aOM = (TextView) view.findViewById(t.g.card_home_page_normal_thread_abstract);
        this.aQr = (ConstrainImageGroup) view.findViewById(t.g.card_home_page_normal_thread_img_layout);
        this.aQr.setImageMargin(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds4));
        this.aQr.setChildClickListener(this.aQs);
        this.aOO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_home_page_normal_thread_info_layout);
        this.aOO.setOnClickListener(this.aQs);
        this.aPG = (LinearLayout) view.findViewById(t.g.card_home_page_normal_thread_content_layout);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.aQr != null) {
            this.aQr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.aQr != null) {
            this.aQr.setImageViewPool(bVar);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aOD, t.d.cp_bg_line_b);
            this.aQr.sg();
            this.aQp.sg();
            this.aOO.sg();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JP() {
        return t.h.card_home_page_multi_img;
    }

    public void a(com.baidu.tieba.card.a.l lVar) {
        int i;
        boolean z;
        if (lVar == null || lVar.aRG == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aQq = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aQs);
        }
        d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        if (this.aQq.aRY) {
            this.aQn.setVisibility(8);
            this.aQp.setVisibility(8);
        } else {
            this.aQp.setVisibility(0);
            this.aQn.setVisibility(0);
            this.aQn.setData(lVar.aRG);
            this.aQn.setAfterClickListener(this.adK);
        }
        this.aQp.setData(lVar.aRG);
        this.aQp.setUserAfterClickListener(this.adK);
        this.aOO.setData(lVar.aRG);
        this.aOO.setForumAfterClickListener(this.adn);
        this.aOO.setStType(au.Kd());
        this.aOO.setYuelaouLocate("feed#" + lVar.Kj());
        if (StringUtils.isNull(lVar.aRG.getTitle()) || lVar.aRG.qZ() == 1) {
            this.aOG.setVisibility(8);
        } else {
            this.aOG.setVisibility(0);
            lVar.aRG.Qa = 0;
            if (this.aQq.aRY || lVar.aRG.ro()) {
                this.aOG.setText(lVar.aRG.getTitle());
            } else {
                lVar.aRG.parser_title();
                this.aOG.setText(lVar.aRG.getSpan_str());
            }
            au.a(this.aOG, lVar.Kn().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (lVar.aRG.qT() != null && !StringUtils.isNull(lVar.aRG.qT())) {
            sb.append(lVar.aRG.qT());
        }
        ArrayList<MediaData> medias = lVar.aRG.getMedias();
        if (medias != null) {
            i = medias.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (medias.get(i2).getVideoUrl() != null && medias.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(medias.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (sb.length() > 0) {
                this.aOM.setText(sb.toString());
                this.aOM.setVisibility(0);
                au.a(this.aOM, lVar.aRG.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
            } else {
                this.aOM.setVisibility(8);
            }
        } else {
            this.aOM.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> qY = lVar.aRG.qY();
        if (com.baidu.tbadk.core.util.y.s(qY)) {
            this.aQo.setVisibility(8);
            z = false;
        } else {
            this.aQo.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qY.get(0);
            this.aQo.setVoiceModel(voiceModel);
            this.aQo.setTag(voiceModel);
            this.aQo.aVd();
            if (voiceModel != null) {
                this.aQo.jL(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.aQq.aRY && z) {
            this.aQr.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.ob().oh() && com.baidu.tbadk.core.util.y.r(medias) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.ax Kn = lVar.Kn();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.c(medias, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.r(linkedList) > 0) {
                this.aQr.setVisibility(0);
                this.aQr.setFromCDN(this.Zv);
                this.aQr.setImageClickListener(new bc(this, linkedList2, Kn));
                this.aQr.setImageUrls(linkedList);
            } else {
                this.aQr.setVisibility(8);
            }
        } else {
            this.aQr.setVisibility(8);
        }
        Ke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.ax axVar) {
        if (!TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.DV.getPageActivity(), t.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.Zv ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(axVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.DV.getPageActivity()).createConfig(arrayList, i, axVar.qQ(), String.valueOf(axVar.getFid()), axVar.getTid(), this.Zv, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Ke() {
        if (!this.aQq.aqS) {
            this.aQo.setClickable(false);
            this.aOO.setBarNameClickEnabled(false);
        } else {
            this.aQo.setClickable(true);
            this.aOO.setBarNameClickEnabled(true);
        }
        int childCount = this.aQr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aQr.getChildAt(i);
            if (childAt != null) {
                if (!this.aQq.aqS) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.Zv = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aOO != null && this.aQc != null) {
            this.aOO.h(bdUniqueId);
            this.aQc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kf() {
        if (this.aQq != null && this.aQq.aRG != null) {
            if (!JV()) {
                au.hb(this.aQq.aRG.getId());
            }
            this.DV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.DV.getPageActivity()).createFromThreadCfg(this.aQq.aRG, null, au.Kd(), 18003, true, false, false).addLocateParam(this.aQq.Kk()).addFrom(getClass().getName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JV() {
        return this.aQq.aRY && !this.aQq.aqS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
