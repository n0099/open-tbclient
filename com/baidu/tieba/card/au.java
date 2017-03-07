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
    private TextView aSO;
    private boolean ahO;
    private TbPageContext<?> ajF;
    private final View.OnClickListener alM;
    private final View.OnClickListener amj;
    private View avr;
    public ViewStub bbh;
    public TbImageView bbi;
    protected LinearLayout bbl;
    private TextView brK;
    public ThreadCommentAndPraiseInfoLayout brM;
    private com.baidu.tbadk.core.view.o bsK;
    private CustomMessageListener bsL;
    public TextView bsO;
    private CardGroupDividerView bss;
    private FrsCommonImageLayout.b btA;
    private final View.OnClickListener btB;
    public ClickableHeaderImageView btt;
    public PlayVoiceBntNew btu;
    public View btv;
    public UserIconLayout btw;
    private com.baidu.tieba.card.data.n btx;
    private ConstrainImageGroup bty;
    private View.OnClickListener btz;
    private int mSkinType;

    public au(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bsK = null;
        this.mSkinType = 3;
        this.ahO = true;
        this.btz = new av(this);
        this.bsL = new aw(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.btA = new ax(this);
        this.btB = new ay(this);
        this.amj = new az(this);
        this.alM = new ba(this);
        View view = getView();
        this.ajF = tbPageContext;
        this.avr = view.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.btt = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bbh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.btt.setDefaultResource(17170445);
        this.btt.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.btt.setDefaultBgResource(w.e.cp_bg_line_e);
        this.btt.setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds70));
        this.btw = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.aSO = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.btu = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.btu.setAfterClickListener(this.btB);
        this.brK = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bty = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bty.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4));
        this.bty.setChildClickListener(this.btz);
        this.brM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.btv = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bsK = new com.baidu.tbadk.core.view.o(this.ajF);
        this.bsK.wu();
        this.brM.addView(this.bsK);
        if (this.brM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.brM.setLayoutParams(layoutParams);
        }
        this.brM.setOnClickListener(this.btz);
        this.bbl = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.bss = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    public void Sm() {
        if (this.bsO == null) {
            this.bsO = new TextView(this.ajF.getPageActivity());
            this.bsO.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds24));
            this.bsO.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds20);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds2);
            this.bsO.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.aq.i((View) this.bsO, w.e.cp_cont_b);
            this.btw.addView(this.bsO);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.bty != null) {
            this.bty.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bty != null) {
            this.bty.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bty != null) {
            this.bty.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avr, w.e.cp_bg_line_b);
            this.bty.tD();
            this.btw.tD();
            com.baidu.tbadk.core.util.aq.i((View) this.bsO, w.e.cp_cont_b);
            this.brM.tD();
            if (this.bsK != null) {
                this.bsK.tD();
            }
            if (this.bss != null) {
                this.bss.tD();
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
        this.btx = nVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.btz);
        }
        if (this.bsK != null && this.btx.JN() != null) {
            com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
            amVar.ci(this.btx.JN().getTid());
            amVar.setFid(this.btx.JN().getFid());
            amVar.a(this.btx.WE);
            this.bsK.setData(amVar);
        }
        onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.btx.bvp) {
            this.btt.setVisibility(8);
            this.btw.setVisibility(8);
        } else {
            this.btw.setVisibility(0);
            this.btt.setVisibility(0);
            this.btt.setData(nVar.threadData);
            this.btt.setAfterClickListener(this.amj);
            UserTbVipInfoData rR = this.btx.threadData.rR();
            if (rR != null && rR.getvipV_url() != null && this.bbh != null) {
                if (this.bbi == null) {
                    this.bbh.inflate();
                    this.bbi = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.bbi.c(rR.getvipV_url(), 10, false);
                this.btt.setIsBigV(true);
            }
        }
        this.btw.setData(nVar.threadData);
        this.btw.setUserAfterClickListener(this.amj);
        if (this.brM.a(nVar.threadData)) {
            this.btv.setVisibility(8);
        } else {
            this.btv.setVisibility(0);
        }
        if (this.bsO != null) {
            if (nVar.threadData.rL() <= 0) {
                this.bsO.setVisibility(8);
            } else {
                this.bsO.setVisibility(0);
                this.bsO.setText(com.baidu.tbadk.core.util.au.r(nVar.threadData.rL() * 1000));
            }
        }
        this.brM.setForumAfterClickListener(this.alM);
        this.brM.setStType(at.rH());
        this.brM.setYuelaouLocate("feed#" + nVar.Sx());
        com.baidu.tbadk.core.data.bj JN = nVar.JN();
        at.a(JN, this.aSO);
        StringBuilder sb = new StringBuilder();
        if (JN.rY() != null && !StringUtils.isNull(JN.rY())) {
            sb.append(JN.rY());
        }
        ArrayList<MediaData> sa = nVar.threadData.sa();
        if (sa != null) {
            i = sa.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (sa.get(i2).getVideoUrl() != null && sa.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(sa.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(nVar.JN().g(sb.toString(), true))) {
                SpannableString cq = nVar.threadData.cq(sb.toString());
                this.brK.setOnTouchListener(new com.baidu.tieba.view.x(cq));
                this.brK.setText(cq);
                this.brK.setVisibility(0);
                at.a(this.brK, nVar.threadData.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            } else {
                this.brK.setVisibility(8);
            }
        } else {
            this.brK.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> se = nVar.threadData.se();
        if (com.baidu.tbadk.core.util.x.q(se)) {
            this.btu.setVisibility(8);
            z = false;
        } else {
            this.btu.setVisibility(0);
            VoiceData.VoiceModel voiceModel = se.get(0);
            this.btu.setVoiceModel(voiceModel);
            this.btu.setTag(voiceModel);
            this.btu.ayg();
            if (voiceModel != null) {
                this.btu.lZ(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.btx.bvp && z) {
            this.bty.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oQ().oW() && com.baidu.tbadk.core.util.x.p(sa) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(sa, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.p(linkedList) > 0) {
                this.bty.setVisibility(0);
                this.bty.setFromCDN(this.ahO);
                this.bty.setImageClickListener(new bb(this, linkedList2, JN));
                this.bty.setImageUrls(linkedList);
            } else {
                this.bty.setVisibility(8);
            }
        } else {
            this.bty.setVisibility(8);
        }
        Sq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bj bjVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajF.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahO ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bjVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajF.getPageActivity()).createConfig(arrayList, i, bjVar.rV(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.ahO, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Sq() {
        if (!this.btx.azY) {
            this.btu.setClickable(false);
            this.brM.setBarNameClickEnabled(false);
        } else {
            this.btu.setClickable(true);
            this.brM.setBarNameClickEnabled(true);
        }
        int childCount = this.bty.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bty.getChildAt(i);
            if (childAt != null) {
                if (!this.btx.azY) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahO = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.brM != null && this.bsL != null) {
            this.brM.h(bdUniqueId);
            this.bsL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsL);
        }
    }

    public void a(o.a aVar) {
        if (this.bsK != null) {
            this.bsK.setEventCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sr() {
        if (this.btx != null && this.btx.threadData != null) {
            if (!Sn()) {
                at.hU(this.btx.threadData.getId());
            }
            this.ajF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajF.getPageActivity()).createFromThreadCfg(this.btx.threadData, null, at.rH(), 18003, true, false, false).addLocateParam(this.btx.Sy())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sn() {
        return this.btx.bvp && !this.btx.azY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
