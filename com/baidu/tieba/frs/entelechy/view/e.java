package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<bd> implements u {
    protected boolean aXA;
    private bd aYc;
    private final View.OnClickListener bbZ;
    public ClickableHeaderImageView bch;
    public ViewStub bcj;
    public TbImageView bck;
    private final View.OnClickListener bcm;
    private View.OnClickListener cSO;
    public View cTI;
    private CardGroupDividerView cTs;
    public PlayVoiceBntNew cUt;
    protected TextView cUv;
    protected ConstrainImageGroup cUw;
    private final View.OnClickListener cUz;
    public TbImageView cWl;
    public HeadPendantClickableView cjC;
    public LinearLayout cjQ;
    public ThreadSkinView cjR;
    private com.baidu.tieba.frs.f.g dII;
    public ThreadCommentAndPraiseInfoLayout dIS;
    public UserIconLayout dIT;
    public RelativeLayout dIU;
    protected TbImageView dIV;
    protected TextView dIW;
    private View.OnClickListener dIX;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aXA = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.cSO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aYc != null && e.this.aYc.yT() != null && e.this.aYc.yT().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").s("obj_locate", 3).aa("tid", e.this.aYc.getId()));
                }
                if (e.this.aYc != null && e.this.aYc.yA()) {
                    TiebaStatic.log(new ak("c11663").s("obj_param1", 1).aa("post_id", e.this.aYc.getTid()));
                }
                if (e.this.akg() != null) {
                    e.this.akg().a(view, e.this.aYc);
                }
                e.this.akA();
            }
        };
        this.dIX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akg() != null) {
                    e.this.akg().a(view, e.this.aYc);
                }
                e.this.akA();
            }
        };
        this.cUz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> akg = e.this.akg();
                if (akg != null) {
                    akg.a(view, e.this.aYc);
                }
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akg() != null) {
                    e.this.akg().a(view, e.this.aYc);
                }
            }
        };
        this.bbZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akg() != null) {
                    e.this.akg().a(view, e.this.aYc);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.ds16 = (int) this.mPageContext.getResources().getDimension(d.e.ds16);
        this.ds32 = (int) this.mPageContext.getResources().getDimension(d.e.ds32);
        this.bch = (ClickableHeaderImageView) view.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.cjC = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        this.bch.setDefaultResource(17170445);
        this.bch.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.bch.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.bch.setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        this.bcj = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        if (this.cjC.getHeadView() != null) {
            this.cjC.getHeadView().setIsRound(true);
            this.cjC.getHeadView().setDrawBorder(false);
            this.cjC.getHeadView().setDefaultResource(17170445);
            this.cjC.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cjC.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cjC.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cjC.Dz();
        if (this.cjC.getPendantView() != null) {
            this.cjC.getPendantView().setIsRound(true);
            this.cjC.getPendantView().setDrawBorder(false);
        }
        this.dIT = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.dIT.bdq = true;
        this.dIT.setEntelechyEnabled(true);
        this.dIT.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cUt = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cUt.setAfterClickListener(this.cUz);
        this.cUt.setPlayTimeTextView(d.e.fontsize28);
        this.cWl = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cWl.setPageId(getTag());
        this.cUv = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cUv.setFocusable(true);
        this.cUw = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds4);
        this.cUw.setSingleImageRatio(0.75d);
        this.cUw.setImageMargin(dimensionPixelSize);
        this.cUw.setChildClickListener(this.dIX);
        this.dIS = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.dIS.setFrom(2);
        this.dIS.bbX = 3;
        this.cTI = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cjQ = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.dIU = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.dIV = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.dIV.setPageId(getTag());
        this.dIW = (TextView) view.findViewById(d.g.app_code_btn);
        this.cjR = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.cTs = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.cTs.setTitleClickListener(this.cSO);
        this.dII = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dIU);
        this.dII.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUw != null) {
            this.cUw.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUw != null) {
            this.cUw.setImageViewPool(bVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout akL() {
        return this.dIS;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0108d.cp_bg_line_d);
            aj.s(this.dIU, d.f.addresslist_item_bg);
            this.cUw.onChangeSkinType();
            this.dIT.onChangeSkinType();
            this.dIS.onChangeSkinType();
            if (this.cTs != null) {
                this.cTs.onChangeSkinType();
            }
            this.dII.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(final bd bdVar) {
        int i;
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aYc = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.dIU != null) {
                this.dIU.setOnClickListener(this.cSO);
                this.dIU.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.cSO);
                getView().setLongClickable(true);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tieba.card.k.kl(this.aYc.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.aYc.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cUv, this.aYc.getId(), d.C0108d.cp_cont_c, d.C0108d.cp_cont_d);
        }
        this.dIT.setVisibility(0);
        if (this.aYc.yT() != null && !StringUtils.isNull(this.aYc.yT().getSealPrefix())) {
            this.dIT.bt(true);
        }
        if (this.aYc.yT() == null || this.aYc.yT().getPendantData() == null || StringUtils.isNull(this.aYc.yT().getPendantData().xu())) {
            UserTbVipInfoData yU = this.aYc.yU();
            if (yU != null && yU.getvipV_url() != null) {
                if (this.bcj != null) {
                    if (this.bck == null) {
                        this.bcj.inflate();
                        this.bck = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bck.setVisibility(0);
                    this.bck.startLoad(yU.getvipV_url(), 10, false);
                    this.bch.setIsBigV(true);
                }
            } else {
                this.bch.setIsBigV(false);
                if (this.bck != null) {
                    this.bck.setVisibility(8);
                }
            }
            this.cjC.setVisibility(8);
            this.bch.setVisibility(0);
            this.bch.setData(bdVar);
            this.bch.setAfterClickListener(this.bcm);
        } else {
            this.bch.setVisibility(4);
            this.bch.setIsBigV(false);
            if (this.bck != null) {
                this.bck.setVisibility(8);
            }
            this.cjC.setVisibility(0);
            this.cjC.setData(bdVar);
        }
        this.dIT.setData(bdVar);
        this.dIT.setUserAfterClickListener(this.bcm);
        if (this.dIS.setData(bdVar)) {
            this.cTI.setVisibility(8);
        } else {
            this.cTI.setVisibility(0);
        }
        this.dIS.updataMoreView(this.mTbPageContext);
        this.dIS.setForumAfterClickListener(this.bbZ);
        this.dIS.setStType("frs_page");
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.yR() == null || bdVar.yR().size() == 0)) || bdVar.zj() == 1) {
            bdVar.h(false, true);
            if (bdVar.zt() == null || StringUtils.isNull(bdVar.zt().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bdVar.zt());
            }
        } else {
            this.mTitle.setVisibility(0);
            bdVar.aNq = 0;
            bdVar.h(false, bdVar.zO());
            SpannableStringBuilder zt = bdVar.zt();
            this.mTitle.setOnTouchListener(new m(zt));
            this.mTitle.setText(zt);
            com.baidu.tieba.card.k.a(this.mTitle, bdVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bdVar.getAbstract() != null && !StringUtils.isNull(bdVar.getAbstract())) {
            sb.append(bdVar.getAbstract());
        }
        ArrayList<MediaData> ze = bdVar.ze();
        if (ze != null) {
            i = ze.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (ze.get(i2).getVideoUrl() != null && ze.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(ze.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bdVar.g(sb.toString(), true))) {
                SpannableString cQ = bdVar.cQ(sb.toString());
                this.cUv.setOnTouchListener(new m(cQ));
                this.cUv.setText(cQ);
                this.cUv.setContentDescription(sb.toString());
                this.cUv.setVisibility(0);
                com.baidu.tieba.card.k.a(this.cUv, bdVar.getId(), d.C0108d.cp_cont_c, d.C0108d.cp_cont_d);
            } else {
                this.cUv.setVisibility(8);
            }
        } else {
            this.cUv.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dIS.getLayoutParams();
        if (layoutParams != null) {
            if (this.cUv.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.cUt.getVisibility() == 8 && this.dIS.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mPageContext.getResources().getDimension(d.e.ds56), 0, 0);
                this.dIS.setPadding(0, 0, 0, 0);
            } else if (this.dIS.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.dIS.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.dIS.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.dII.T(this.aYc);
        ArrayList<VoiceData.VoiceModel> zi = bdVar.zi();
        if (com.baidu.tbadk.core.util.v.E(zi)) {
            this.cUt.setVisibility(8);
        } else {
            this.cUt.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zi.get(0);
            this.cUt.setVoiceModel(voiceModel);
            this.cUt.setTag(voiceModel);
            this.cUt.bng();
            if (voiceModel != null) {
                this.cUt.qE(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.i.wB().wH() && com.baidu.tbadk.core.util.v.D(ze) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(ze, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                this.cUw.setVisibility(0);
                this.cUw.setFromCDN(this.aXA);
                if (this.aYc.zN() != null) {
                    this.cUw.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                com.baidu.tbadk.core.data.m zN = e.this.aYc.zN();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mPageContext.getPageActivity(), zN.getCartoonId(), zN.getChapterId(), 2)));
                                return;
                            }
                            ax.ba(e.this.mContext);
                        }
                    });
                } else {
                    this.cUw.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i4, boolean z) {
                            v<bd> akg = e.this.akg();
                            if (z) {
                                if (akg != null) {
                                    akg.bLL = true;
                                    akg.a(view, e.this.aYc);
                                }
                                e.this.akA();
                                return;
                            }
                            if (akg != null) {
                                akg.bLL = false;
                                akg.a(view, e.this.aYc);
                            }
                            e.this.a(view, linkedList, i4, bdVar);
                        }
                    });
                }
                this.cUw.setImageMediaList(linkedList);
            } else {
                this.cUw.setVisibility(8);
            }
        } else {
            this.cUw.setVisibility(8);
        }
        if (this.dIV != null) {
            if (bdVar.zg() != null) {
                String Av = bdVar.zg().Av();
                if (!StringUtils.isNull(Av)) {
                    this.dIV.setVisibility(0);
                    this.dIV.startLoad(Av, 10, true);
                } else {
                    this.dIV.setVisibility(8);
                }
            } else {
                this.dIV.setVisibility(8);
            }
        }
        if (this.dIW != null) {
            if (bdVar.zh() != null) {
                String xd = bdVar.zh().xd();
                if (!StringUtils.isNull(xd)) {
                    String fixedText = am.getFixedText(xd, 20, true);
                    aj.s(this.dIW, d.f.btn_red_frame_n);
                    aj.r(this.dIW, d.C0108d.cp_cont_h);
                    this.dIW.setText(fixedText);
                    this.dIW.setVisibility(0);
                } else {
                    this.dIW.setVisibility(8);
                }
            } else {
                this.dIW.setVisibility(8);
            }
        }
        akz();
        b.a(this.aYc, this.cTs);
        H(bdVar);
    }

    public void H(bd bdVar) {
        MetaData yT;
        if (bdVar != null && this.cWl != null && (yT = bdVar.yT()) != null) {
            final ThemeCardInUserData themeCard = yT.getThemeCard();
            SkinInfo zp = bdVar.zp();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bch.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cjQ.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cWl.setVisibility(8);
                if (this.cjR != null) {
                    if (zp != null) {
                        this.cjR.a(this.mPageContext, zp, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.yZ(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.cjR.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.cWl.setVisibility(0);
                this.cWl.setImageBitmap(null);
                this.cWl.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cWl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cjR.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.bch.setLayoutParams(layoutParams);
            this.cjQ.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aXA ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bdVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yZ(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXA, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void akz() {
        this.cUt.setClickable(true);
        this.dIS.setBarNameClickEnabled(true);
        int childCount = this.cUw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cUw.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aXA = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dIS != null) {
            this.dIS.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        PbActivityConfig createFromThreadCfg;
        if (this.aYc != null) {
            com.baidu.tieba.card.k.kk(this.aYc.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.aYc.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cUv, this.aYc.getId(), d.C0108d.cp_cont_c, d.C0108d.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aYc));
            com.baidu.tbadk.core.data.m zN = this.aYc.zN();
            if (zN != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.ba(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zN.getCartoonId(), zN.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.j jVar = this.aYc.aOA;
            if (this.aYc.aOz == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aKn;
                long j = jVar.aKo;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.aKB = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
            } else if (this.aYc.zh() != null) {
                if (ax.bb(this.mPageContext.getPageActivity())) {
                    String postUrl = this.aYc.zh().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.pa()) {
                        com.baidu.tbadk.browser.a.Q(this.mPageContext.getPageActivity(), postUrl);
                    }
                }
            } else {
                t.hi(this.aYc.getId());
                boolean z = this.aYc.getType() != bd.aNb;
                if (this.aYc.zq() > 0 && com.baidu.tieba.tbadkCore.util.f.bwK()) {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aYc.getTid(), String.valueOf(this.aYc.zq()), false, z, "frs_page");
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aYc, this.mForumName, "frs_page", 18003, z, false, false);
                }
                createFromThreadCfg.setStartFrom(this.currentPageType);
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.aYc.zU());
                    createFromThreadCfg.setSmartFrsPosition(this.aYc.Ab());
                    createFromThreadCfg.setForumId(String.valueOf(this.aYc.getFid()));
                    createFromThreadCfg.setStartFrom(3);
                    this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
