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
public class bd extends a<com.baidu.tieba.card.a.t> {
    private TbPageContext<?> ND;
    private View aSe;
    private TextView aSh;
    private TextView aSn;
    public ThreadCommentAndPraiseInfoLayout aSp;
    private CustomMessageListener aTI;
    public ClickableHeaderImageView aTT;
    public PlayVoiceBntNew aTU;
    public UserIconLayout aTV;
    private com.baidu.tieba.card.a.t aTW;
    private ConstrainImageGroup aTX;
    private View.OnClickListener aTY;
    private FrsCommonImageLayout.b aTZ;
    protected LinearLayout aTs;
    private final View.OnClickListener aUa;
    private boolean adX;
    private final View.OnClickListener ahQ;
    private final View.OnClickListener ahw;
    private int mSkinType;

    public bd(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.adX = true;
        this.aTY = new be(this);
        this.aTI = new bf(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aTZ = new bg(this);
        this.aUa = new bh(this);
        this.ahQ = new bi(this);
        this.ahw = new bj(this);
        View view = getView();
        this.ND = tbPageContext;
        this.aSe = view.findViewById(t.g.card_home_page_normal_thread_top_line);
        this.aTT = (ClickableHeaderImageView) view.findViewById(t.g.card_home_page_normal_thread_user_header);
        this.aTT.setDefaultResource(17170445);
        this.aTT.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aTT.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aTT.setRadius(com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds70));
        this.aTV = (UserIconLayout) view.findViewById(t.g.card_home_page_normal_thread_user_layout);
        this.aSh = (TextView) view.findViewById(t.g.card_home_page_normal_thread_title);
        this.aTU = (PlayVoiceBntNew) view.findViewById(t.g.card_home_page_normal_thread_abstract_voice);
        this.aTU.setAfterClickListener(this.aUa);
        this.aSn = (TextView) view.findViewById(t.g.card_home_page_normal_thread_abstract);
        this.aTX = (ConstrainImageGroup) view.findViewById(t.g.card_home_page_normal_thread_img_layout);
        this.aTX.setImageMargin(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds4));
        this.aTX.setChildClickListener(this.aTY);
        this.aSp = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_home_page_normal_thread_info_layout);
        this.aTs = (LinearLayout) view.findViewById(t.g.card_home_page_normal_thread_content_layout);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.aTX != null) {
            this.aTX.setConstrainLayoutPool(bVar);
        }
    }

    public void a(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.aTX != null) {
            this.aTX.setImageViewPool(bVar);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aSe, t.d.cp_bg_line_b);
            this.aTX.uA();
            this.aTV.uA();
            this.aSp.uA();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_home_page_multi_img;
    }

    public void a(com.baidu.tieba.card.a.t tVar) {
        int i;
        boolean z;
        if (tVar == null || tVar.aVJ == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aTW = tVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aTY);
        }
        d(this.ND, TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aTW.aWe) {
            this.aTT.setVisibility(8);
            this.aTV.setVisibility(8);
        } else {
            this.aTV.setVisibility(0);
            this.aTT.setVisibility(0);
            this.aTT.setData(tVar.aVJ);
            this.aTT.setAfterClickListener(this.ahQ);
        }
        this.aTV.setData(tVar.aVJ);
        this.aTV.setUserAfterClickListener(this.ahQ);
        this.aSp.setData(tVar.aVJ);
        this.aSp.setForumAfterClickListener(this.ahw);
        this.aSp.setStType(bc.Ls());
        this.aSp.setYuelaouLocate("feed#" + tVar.Ly());
        if (StringUtils.isNull(tVar.aVJ.getTitle()) || tVar.aVJ.tA() == 1) {
            this.aSh.setVisibility(8);
        } else {
            this.aSh.setVisibility(0);
            tVar.aVJ.Va = 0;
            if (this.aTW.aWe || tVar.aVJ.tP()) {
                this.aSh.setText(tVar.aVJ.getTitle());
            } else {
                tVar.aVJ.parser_title();
                this.aSh.setText(tVar.aVJ.getSpan_str());
            }
            bc.a(this.aSh, tVar.LC().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (tVar.aVJ.tu() != null && !StringUtils.isNull(tVar.aVJ.tu())) {
            sb.append(tVar.aVJ.tu());
        }
        ArrayList<MediaData> medias = tVar.aVJ.getMedias();
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
                this.aSn.setText(sb.toString());
                this.aSn.setVisibility(0);
                bc.a(this.aSn, tVar.aVJ.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
            } else {
                this.aSn.setVisibility(8);
            }
        } else {
            this.aSn.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> tz = tVar.aVJ.tz();
        if (com.baidu.tbadk.core.util.y.q(tz)) {
            this.aTU.setVisibility(8);
            z = false;
        } else {
            this.aTU.setVisibility(0);
            VoiceData.VoiceModel voiceModel = tz.get(0);
            this.aTU.setVoiceModel(voiceModel);
            this.aTU.setTag(voiceModel);
            this.aTU.aUC();
            if (voiceModel != null) {
                this.aTU.kh(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.aTW.aWe && z) {
            this.aTX.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.qE().qK() && com.baidu.tbadk.core.util.y.p(medias) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.as LC = tVar.LC();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.b(medias, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.p(linkedList) > 0) {
                this.aTX.setVisibility(0);
                this.aTX.setFromCDN(this.adX);
                this.aTX.setImageClickListener(new bk(this, linkedList2, LC));
                this.aTX.setImageUrls(linkedList);
            } else {
                this.aTX.setVisibility(8);
            }
        } else {
            this.aTX.setVisibility(8);
        }
        Lt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.as asVar) {
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ND.getPageActivity(), t.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.adX ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(asVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ND.getPageActivity()).createConfig(arrayList, i, asVar.tr(), String.valueOf(asVar.getFid()), asVar.getTid(), this.adX, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Lt() {
        if (!this.aTW.auT) {
            this.aTU.setClickable(false);
            this.aSp.setBarNameClickEnabled(false);
        } else {
            this.aTU.setClickable(true);
            this.aSp.setBarNameClickEnabled(true);
        }
        int childCount = this.aTX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aTX.getChildAt(i);
            if (childAt != null) {
                if (!this.aTW.auT) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adX = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSp != null && this.aTI != null) {
            this.aSp.h(bdUniqueId);
            this.aTI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lu() {
        if (this.aTW != null && this.aTW.aVJ != null) {
            if (!Lm()) {
                bc.ha(this.aTW.aVJ.getId());
            }
            this.ND.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ND.getPageActivity()).createFromThreadCfg(this.aTW.aVJ, null, bc.Ls(), 18003, true, false, false).addLocateParam(this.aTW.Lz()).addFrom(getClass().getName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lm() {
        return this.aTW.aWe && !this.aTW.auT;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
