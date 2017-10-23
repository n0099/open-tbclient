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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<bh> implements v {
    private bh aiU;
    protected boolean aiu;
    private final View.OnClickListener anf;
    public ClickableHeaderImageView ans;
    public ViewStub anu;
    public TbImageView anv;
    private final View.OnClickListener anx;
    private CardGroupDividerView bJS;
    public HeadPendantClickableView bJj;
    private View.OnClickListener bJo;
    public View bKk;
    public PlayVoiceBntNew bLf;
    protected TextView bLh;
    protected ConstrainImageGroup bLi;
    private final View.OnClickListener bLj;
    public ThreadCommentAndPraiseInfoLayout bLn;
    public UserIconLayout bLq;
    public LinearLayout bmZ;
    public ThreadSkinView bna;
    public TbImageView csi;
    protected TextView csy;
    private com.baidu.tieba.frs.h.g cxr;
    public RelativeLayout cxw;
    protected TbImageView cxx;
    private View.OnClickListener cxy;
    private int ds16;
    private int ds32;
    private String mForumName;
    private TbPageContext<?> mH;
    protected int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiu = true;
        this.ds16 = 0;
        this.ds32 = 0;
        this.bJo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aiU != null && e.this.aiU.getAuthor() != null && e.this.aiU.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", e.this.aiU.getId()));
                }
                if (e.this.aiU != null && e.this.aiU.qU()) {
                    TiebaStatic.log(new ak("c11663").r("obj_param1", 1).ac("post_id", e.this.aiU.getTid()));
                }
                if (e.this.Xn() != null) {
                    e.this.Xn().a(view, e.this.aiU);
                }
                e.this.XF();
            }
        };
        this.cxy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Xn() != null) {
                    e.this.Xn().a(view, e.this.aiU);
                }
                e.this.XF();
            }
        };
        this.bLj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bh> Xn = e.this.Xn();
                if (Xn != null) {
                    Xn.a(view, e.this.aiU);
                }
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Xn() != null) {
                    e.this.Xn().a(view, e.this.aiU);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Xn() != null) {
                    e.this.Xn().a(view, e.this.aiU);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mH = tbPageContext;
        this.ds16 = (int) this.mH.getResources().getDimension(d.f.ds16);
        this.ds32 = (int) this.mH.getResources().getDimension(d.f.ds32);
        this.ans = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.bJj = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        this.ans.setDefaultResource(17170445);
        this.ans.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.ans.setDefaultBgResource(d.e.cp_bg_line_e);
        this.ans.setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds70));
        this.anu = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        if (this.bJj.getHeadView() != null) {
            this.bJj.getHeadView().setIsRound(true);
            this.bJj.getHeadView().setDrawBorder(false);
            this.bJj.getHeadView().setDefaultResource(17170445);
            this.bJj.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJj.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJj.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds70));
        }
        this.bJj.vZ();
        if (this.bJj.getPendantView() != null) {
            this.bJj.getPendantView().setIsRound(true);
            this.bJj.getPendantView().setDrawBorder(false);
        }
        this.bLq = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.bLq.aok = true;
        this.bLq.setEntelechyEnabled(true);
        this.bLq.setPageName(1);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLf = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLf.setAfterClickListener(this.bLj);
        this.bLf.setPlayTimeTextView(d.f.fontsize28);
        this.csi = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.csi.setPageId(getTag());
        this.bLh = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLh.setFocusable(true);
        this.bLi = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds4);
        this.bLi.setSingleImageRatio(0.75d);
        this.bLi.setImageMargin(dimensionPixelSize);
        this.bLi.setChildClickListener(this.cxy);
        this.bLn = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bLn.setLocationEnabled(true);
        this.bLn.setViewNumEnabled(true);
        this.bLn.setCommentNumClickListener(this.bJo);
        this.bLn.setFrom(2);
        this.bKk = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bmZ = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.cxw = (RelativeLayout) view.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.cxx = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.cxx.setPageId(getTag());
        this.csy = (TextView) view.findViewById(d.h.app_code_btn);
        this.bna = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bJS = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.bJS.setTitleClickListener(this.bJo);
        this.cxr = new com.baidu.tieba.frs.h.g(this.mH, this.bLn);
        this.cxr.setUniqueId(getTag());
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLi != null) {
            this.bLi.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLi != null) {
            this.bLi.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            aj.j(this.cxw, d.g.addresslist_item_bg);
            this.bLi.onChangeSkinType();
            this.bLq.onChangeSkinType();
            this.bLn.onChangeSkinType();
            if (this.bJS != null) {
                this.bJS.onChangeSkinType();
            }
            this.cxr.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(final bh bhVar) {
        int i;
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiU = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.cxw != null) {
                this.cxw.setOnClickListener(this.bJo);
                this.cxw.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.bJo);
                getView().setLongClickable(true);
            }
        }
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        if (m.jm(this.aiU.getId())) {
            m.a(this.mTitle, this.aiU.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLh, this.aiU.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
        }
        this.bLq.setVisibility(0);
        if (this.aiU.getAuthor() != null && !StringUtils.isNull(this.aiU.getAuthor().getSealPrefix())) {
            this.bLq.aN(true);
        }
        if (this.aiU.getAuthor() == null || this.aiU.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiU.getAuthor().getPendantData().pL())) {
            UserTbVipInfoData ro = this.aiU.ro();
            if (ro != null && ro.getvipV_url() != null) {
                if (this.anu != null) {
                    if (this.anv == null) {
                        this.anu.inflate();
                        this.anv = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.anv.setVisibility(0);
                    this.anv.c(ro.getvipV_url(), 10, false);
                    this.ans.setIsBigV(true);
                }
            } else {
                this.ans.setIsBigV(false);
                if (this.anv != null) {
                    this.anv.setVisibility(8);
                }
            }
            this.bJj.setVisibility(8);
            this.ans.setVisibility(0);
            this.ans.setData(bhVar);
            this.ans.setAfterClickListener(this.anx);
        } else {
            this.ans.setVisibility(4);
            this.ans.setIsBigV(false);
            if (this.anv != null) {
                this.anv.setVisibility(8);
            }
            this.bJj.setVisibility(0);
            this.bJj.setData(bhVar);
        }
        this.bLq.setData(bhVar);
        this.bLq.setUserAfterClickListener(this.anx);
        if (this.bLn.setData(bhVar)) {
            this.bKk.setVisibility(8);
        } else {
            this.bKk.setVisibility(0);
        }
        this.bLn.updataMoreView(this.mTbPageContext);
        this.bLn.setForumAfterClickListener(this.anf);
        this.bLn.setStType(m.rf());
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rm() == null || bhVar.rm().size() == 0)) || bhVar.rD() == 1) {
            bhVar.e(false, true);
            if (bhVar.rO() == null || StringUtils.isNull(bhVar.rO().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bhVar.rO());
            }
        } else {
            this.mTitle.setVisibility(0);
            bhVar.Yk = 0;
            bhVar.e(false, bhVar.sl());
            SpannableStringBuilder rO = bhVar.rO();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(rO));
            this.mTitle.setText(rO);
            m.a(this.mTitle, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (bhVar.rw() != null && !StringUtils.isNull(bhVar.rw())) {
            sb.append(bhVar.rw());
        }
        ArrayList<MediaData> ry = bhVar.ry();
        if (ry != null) {
            i = ry.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (ry.get(i2).getVideoUrl() != null && ry.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(ry.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bhVar.g(sb.toString(), true))) {
                SpannableString cD = bhVar.cD(sb.toString());
                this.bLh.setOnTouchListener(new com.baidu.tieba.view.k(cD));
                this.bLh.setText(cD);
                this.bLh.setContentDescription(sb.toString());
                this.bLh.setVisibility(0);
                m.a(this.bLh, bhVar.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            } else {
                this.bLh.setVisibility(8);
            }
        } else {
            this.bLh.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLn.getLayoutParams();
        if (layoutParams != null) {
            if (this.bLh.getVisibility() == 8 && this.mTitle.getVisibility() == 8 && this.bLf.getVisibility() == 8 && this.bLn.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.mH.getResources().getDimension(d.f.ds56), 0, 0);
                this.bLn.setPadding(0, 0, 0, 0);
            } else if (this.bLn.isMoreViewVisible()) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bLn.setPadding(0, 0, 0, this.ds16);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bLn.setPadding(0, this.ds16, 0, this.ds32);
            }
        }
        this.cxr.O(this.aiU);
        ArrayList<VoiceData.VoiceModel> rC = bhVar.rC();
        if (com.baidu.tbadk.core.util.v.u(rC)) {
            this.bLf.setVisibility(8);
        } else {
            this.bLf.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rC.get(0);
            this.bLf.setVoiceModel(voiceModel);
            this.bLf.setTag(voiceModel);
            this.bLf.bgc();
            if (voiceModel != null) {
                this.bLf.ng(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oM().oS() && com.baidu.tbadk.core.util.v.t(ry) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(ry, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.t(linkedList) > 0) {
                this.bLi.setVisibility(0);
                this.bLi.setFromCDN(this.aiu);
                if (this.aiU.sk() != null) {
                    this.bLi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                n sk = e.this.aiU.sk();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(e.this.mH.getPageActivity(), sk.getCartoonId(), sk.getChapterId(), 2)));
                                return;
                            }
                            ax.aS(e.this.mContext);
                        }
                    });
                } else {
                    this.bLi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i4, boolean z) {
                            x<bh> Xn = e.this.Xn();
                            if (z) {
                                if (Xn != null) {
                                    Xn.aUn = true;
                                    Xn.a(view, e.this.aiU);
                                }
                                e.this.XF();
                                return;
                            }
                            if (Xn != null) {
                                Xn.aUn = false;
                                Xn.a(view, e.this.aiU);
                            }
                            e.this.a(view, linkedList, i4, bhVar);
                        }
                    });
                }
                this.bLi.setImageMediaList(linkedList);
            } else {
                this.bLi.setVisibility(8);
            }
        } else {
            this.bLi.setVisibility(8);
        }
        if (this.cxx != null) {
            if (bhVar.rA() != null) {
                String sV = bhVar.rA().sV();
                if (!StringUtils.isNull(sV)) {
                    this.cxx.setVisibility(0);
                    this.cxx.c(sV, 10, true);
                } else {
                    this.cxx.setVisibility(8);
                }
            } else {
                this.cxx.setVisibility(8);
            }
        }
        if (this.csy != null) {
            if (bhVar.rB() != null) {
                String pq = bhVar.rB().pq();
                if (!StringUtils.isNull(pq)) {
                    String fixedText = am.getFixedText(pq, 20, true);
                    aj.j(this.csy, d.g.btn_red_frame_n);
                    aj.i(this.csy, d.e.cp_cont_h);
                    this.csy.setText(fixedText);
                    this.csy.setVisibility(0);
                } else {
                    this.csy.setVisibility(8);
                }
            } else {
                this.csy.setVisibility(8);
            }
        }
        XE();
        b.a(this.aiU, this.bJS);
        F(bhVar);
    }

    public void F(bh bhVar) {
        MetaData author;
        if (bhVar != null && this.csi != null && (author = bhVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rJ = bhVar.rJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ans.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bmZ.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.csi.setVisibility(8);
                if (this.bna != null) {
                    if (rJ != null) {
                        this.bna.a(this.mH, rJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bhVar.getFid()), bhVar.rt(), bhVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds16);
                    } else {
                        this.bna.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.csi.setVisibility(0);
                this.csi.setImageBitmap(null);
                this.csi.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.csi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(e.this.mH.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.bna.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds30);
            }
            this.ans.setLayoutParams(layoutParams);
            this.bmZ.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mH.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aiu ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mH.getPageActivity()).createConfig(arrayList, i, bhVar.rt(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiu, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void XE() {
        this.bLf.setClickable(true);
        this.bLn.setBarNameClickEnabled(true);
        int childCount = this.bLi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLi.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bLn != null) {
            this.bLn.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XF() {
        PbActivityConfig createFromThreadCfg;
        if (this.aiU != null) {
            m.jl(this.aiU.getId());
            m.a(this.mTitle, this.aiU.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLh, this.aiU.getId(), d.e.cp_cont_c, d.e.cp_cont_d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiU));
            n sk = this.aiU.sk();
            if (sk != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aS(this.mContext);
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mH.getPageActivity(), sk.getCartoonId(), sk.getChapterId(), 2)));
                    return;
                }
            }
            com.baidu.tbadk.core.data.k kVar = this.aiU.Zp;
            if (this.aiU.Zo == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.UT;
                long j = kVar.UU;
                ao aoVar = new ao();
                aoVar.pageContext = this.mH;
                aoVar.Vr = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
            } else if (this.aiU.rB() != null) {
                if (ax.aT(this.mH.getPageActivity())) {
                    String postUrl = this.aiU.rB().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                        com.baidu.tbadk.browser.a.P(this.mH.getPageActivity(), postUrl);
                    }
                }
            } else {
                r.gN(this.aiU.getId());
                boolean z = this.aiU.getType() != bh.XW;
                if (this.aiU.rK() > 0 && com.baidu.tieba.tbadkCore.util.f.bso()) {
                    createFromThreadCfg = new PbActivityConfig(this.mH.getPageActivity()).createHistoryCfg(this.aiU.getTid(), String.valueOf(this.aiU.rK()), false, z, m.rf());
                } else {
                    createFromThreadCfg = new PbActivityConfig(this.mH.getPageActivity()).createFromThreadCfg(this.aiU, this.mForumName, m.rf(), 18003, z, false, false);
                }
                if (createFromThreadCfg != null) {
                    createFromThreadCfg.setVideo_source("frs");
                    createFromThreadCfg.setFromSmartFrs(this.aiU.sr());
                    createFromThreadCfg.setSmartFrsPosition(this.aiU.sy());
                    createFromThreadCfg.setForumId(String.valueOf(this.aiU.getFid()));
                    createFromThreadCfg.setStartFrom(1);
                    this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
