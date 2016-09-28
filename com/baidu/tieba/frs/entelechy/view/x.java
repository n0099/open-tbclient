package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Point;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.card.a<bi> implements az {
    private static HashMap<Point, Integer> Ul = new HashMap<>();
    private TbPageContext<?> GM;
    private TextView aMI;
    public ViewStub aYH;
    public TbImageView aYI;
    protected TextView aYP;
    public ThreadCommentAndPraiseInfoLayout aYR;
    public LinearLayout aZA;
    private CustomMessageListener aZT;
    private bi adW;
    protected boolean adw;
    private final View.OnClickListener ahd;
    private final View.OnClickListener ahz;
    private View aqu;
    public TbImageView bSf;
    protected TextView bSv;
    public ThreadSkinView bSw;
    private GuessYourLikeHeaderView bXc;
    private View bXd;
    public HeadPendantClickableView bXk;
    public RelativeLayout bXl;
    protected TbImageView bXm;
    private View.OnClickListener bXn;
    public ClickableHeaderImageView bai;
    public PlayVoiceBntNew baj;
    public UserIconLayout bak;
    protected ConstrainImageGroup bam;
    private View.OnClickListener ban;
    private final View.OnClickListener bap;
    private String mForumName;
    protected int mSkinType;

    static {
        Ul.put(new Point(1, 1), Integer.valueOf(r.j.lottery_status_ing));
        Ul.put(new Point(1, 2), Integer.valueOf(r.j.lottery_status_over));
        Ul.put(new Point(1, 3), Integer.valueOf(r.j.lottery_status_off));
        Ul.put(new Point(1, 4), Integer.valueOf(r.j.lottery_status_not_start));
        Ul.put(new Point(2, 1), Integer.valueOf(r.j.share_picture_status_ing));
        Ul.put(new Point(2, 2), Integer.valueOf(r.j.share_picture_status_over));
        Ul.put(new Point(2, 3), Integer.valueOf(r.j.share_picture_status_off));
        Ul.put(new Point(2, 4), Integer.valueOf(r.j.share_picture_status_not_start));
    }

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.adw = true;
        this.ban = new y(this);
        this.bXn = new z(this);
        this.aZT = new aa(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bap = new ab(this);
        this.ahz = new ac(this);
        this.ahd = new ad(this);
        View view = getView();
        this.GM = tbPageContext;
        this.aqu = view.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.bai = (ClickableHeaderImageView) view.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.bXk = (HeadPendantClickableView) view.findViewById(r.g.card_home_page_normal_thread_user_pendant_header);
        this.bai.setDefaultResource(17170445);
        this.bai.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bai.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bai.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds70));
        this.aYH = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        if (this.bXk.getHeadView() != null) {
            this.bXk.getHeadView().setIsRound(true);
            this.bXk.getHeadView().setDrawBorder(false);
            this.bXk.getHeadView().setDefaultResource(17170445);
            this.bXk.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.bXk.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.bXk.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds70));
        }
        this.bXk.wk();
        if (this.bXk.getPendantView() != null) {
            this.bXk.getPendantView().setIsRound(true);
            this.bXk.getPendantView().setDrawBorder(false);
        }
        this.bak = (UserIconLayout) view.findViewById(r.g.card_home_page_normal_thread_user_layout);
        this.bak.ahy = true;
        this.bak.setEntelechyEnabled(true);
        this.bak.setPageName(1);
        this.aMI = (TextView) view.findViewById(r.g.card_home_page_normal_thread_title);
        this.baj = (PlayVoiceBntNew) view.findViewById(r.g.card_home_page_normal_thread_abstract_voice);
        this.baj.setAfterClickListener(this.bap);
        this.baj.setPlayTimeTextView(r.e.fontsize28);
        this.bSf = (TbImageView) view.findViewById(r.g.frs_normal_item_theme_card);
        this.aYP = (TextView) view.findViewById(r.g.card_home_page_normal_thread_abstract);
        this.aYP.setFocusable(true);
        this.bam = (ConstrainImageGroup) view.findViewById(r.g.card_home_page_normal_thread_img_layout);
        this.bam.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds4));
        this.bam.setChildClickListener(this.bXn);
        this.aYR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_home_page_normal_thread_info_layout);
        this.aYR.setLocationEnabled(true);
        this.aYR.setCommentNumClickListener(this.ban);
        this.aZA = (LinearLayout) view.findViewById(r.g.card_home_page_normal_thread_content_layout);
        this.bXl = (RelativeLayout) view.findViewById(r.g.card_home_page_normal_thread_root_content);
        this.bXm = (TbImageView) view.findViewById(r.g.game_activity_banner);
        this.bSv = (TextView) view.findViewById(r.g.app_code_btn);
        this.bSw = (ThreadSkinView) view.findViewById(r.g.frs_thread_skin);
        this.bXc = (GuessYourLikeHeaderView) view.findViewById(r.g.guess_your_like_header);
        this.bXd = view.findViewById(r.g.guess_your_like_bottom_line);
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
            av.l(getView(), r.d.cp_bg_line_d);
            av.k(this.bXl, r.f.addresslist_item_bg);
            if (this.adW != null && this.adW.bbL) {
                av.l(this.aqu, r.d.cp_bg_line_c);
            } else {
                av.l(this.aqu, r.d.cp_bg_line_b);
            }
            this.bam.tx();
            this.bak.tx();
            this.aYR.tx();
            if (this.bXc != null) {
                this.bXc.tx();
            }
            av.l(this.bXd, r.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: k */
    public void onBindDataToView(bi biVar) {
        int i;
        if (biVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.adW = biVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.bXl != null) {
                this.bXl.setOnClickListener(this.ban);
                this.bXl.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.ban);
                getView().setLongClickable(true);
            }
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        this.bak.setVisibility(0);
        if (this.adW.getAuthor() == null || this.adW.getAuthor().getPendantData() == null || StringUtils.isNull(this.adW.getAuthor().getPendantData().pO())) {
            UserTbVipInfoData rO = this.adW.rO();
            if (rO != null && rO.getvipV_url() != null) {
                if (this.aYH != null) {
                    if (this.aYI == null) {
                        this.aYH.inflate();
                        this.aYI = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.aYI.setVisibility(0);
                    this.aYI.c(rO.getvipV_url(), 10, false);
                    this.bai.setIsBigV(true);
                }
            } else {
                this.bai.setIsBigV(false);
                if (this.aYI != null) {
                    this.aYI.setVisibility(8);
                }
            }
            this.bXk.setVisibility(8);
            this.bai.setVisibility(0);
            this.bai.setData(biVar);
            this.bai.setAfterClickListener(this.ahz);
        } else {
            this.bai.setVisibility(4);
            this.bai.setIsBigV(false);
            if (this.aYI != null) {
                this.aYI.setVisibility(8);
            }
            this.bXk.setVisibility(0);
            this.bXk.setData(biVar);
        }
        this.bak.setData(biVar);
        this.bak.setUserAfterClickListener(this.ahz);
        this.aYR.setData(biVar);
        this.aYR.setForumAfterClickListener(this.ahd);
        this.aYR.setStType(com.baidu.tieba.card.an.Od());
        if ((StringUtils.isNull(biVar.getTitle()) && (biVar.rM() == null || biVar.rM().size() == 0)) || biVar.sb() == 1) {
            this.aMI.setVisibility(8);
        } else {
            this.aMI.setVisibility(0);
            biVar.TA = 0;
            biVar.e(false, biVar.sJ());
            SpannableStringBuilder sm = biVar.sm();
            this.aMI.setOnTouchListener(new com.baidu.tieba.view.y(sm));
            this.aMI.setText(sm);
            com.baidu.tieba.card.an.a(this.aMI, biVar.getId(), r.d.cp_cont_b, r.d.cp_cont_c);
        }
        StringBuilder sb = new StringBuilder();
        if (biVar.rU() != null && !StringUtils.isNull(biVar.rU())) {
            sb.append(biVar.rU());
        }
        ArrayList<MediaData> rW = biVar.rW();
        if (rW != null) {
            i = rW.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rW.get(i2).getVideoUrl() != null && rW.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rW.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(biVar.g(sb.toString(), true))) {
                SpannableString cw = biVar.cw(sb.toString());
                this.aYP.setOnTouchListener(new com.baidu.tieba.view.y(cw));
                this.aYP.setText(cw);
                this.aYP.setContentDescription(sb.toString());
                this.aYP.setVisibility(0);
                com.baidu.tieba.card.an.a(this.aYP, biVar.getId(), r.d.cp_cont_j, r.d.cp_cont_c);
            } else {
                this.aYP.setVisibility(8);
            }
        } else {
            this.aYP.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aYR.getLayoutParams();
        if (layoutParams != null) {
            if (this.aYP.getVisibility() == 8 && this.aMI.getVisibility() == 8 && this.baj.getVisibility() == 8 && this.aYR.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.GM.getResources().getDimension(r.e.ds40), 0, 0);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
        }
        ArrayList<VoiceData.VoiceModel> sa = biVar.sa();
        if (com.baidu.tbadk.core.util.y.t(sa)) {
            this.baj.setVisibility(8);
        } else {
            this.baj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sa.get(0);
            this.baj.setVoiceModel(voiceModel);
            this.baj.setTag(voiceModel);
            this.baj.aCk();
            if (voiceModel != null) {
                this.baj.me(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.l.oH().oN() && com.baidu.tbadk.core.util.y.s(rW) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.c(rW, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.az.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.s(linkedList) > 0) {
                this.bam.setVisibility(0);
                this.bam.setFromCDN(this.adw);
                if (this.adW.sI() != null) {
                    this.bam.setImageClickListener(new ae(this));
                } else {
                    this.bam.setImageClickListener(new af(this, linkedList2, biVar));
                }
                this.bam.setImageUrls(linkedList);
            } else {
                this.bam.setVisibility(8);
            }
        } else {
            this.bam.setVisibility(8);
        }
        if (this.bXm != null) {
            if (biVar.rY() != null) {
                String tg = biVar.rY().tg();
                if (!StringUtils.isNull(tg)) {
                    this.bXm.setVisibility(0);
                    this.bXm.c(tg, 10, true);
                } else {
                    this.bXm.setVisibility(8);
                }
            } else {
                this.bXm.setVisibility(8);
            }
        }
        if (this.bSv != null) {
            if (biVar.rZ() != null) {
                String mj = biVar.rZ().mj();
                if (!StringUtils.isNull(mj)) {
                    String fixedText = com.baidu.tbadk.core.util.az.getFixedText(mj, 20, true);
                    av.k(this.bSv, r.f.btn_red_frame_n);
                    av.j((View) this.bSv, r.d.cp_cont_h);
                    this.bSv.setText(fixedText);
                    this.bSv.setVisibility(0);
                } else {
                    this.bSv.setVisibility(8);
                }
            } else {
                this.bSv.setVisibility(8);
            }
        }
        Oe();
        if (this.bXc != null) {
            if ((biVar.sk() || biVar.sl()) && com.baidu.tieba.tbadkCore.util.t.bkQ()) {
                this.bXc.setTitleText(StringUtils.isNull(biVar.sj()) ? getContext().getResources().getString(r.j.group_fourm_recommend_title) : biVar.sj());
                this.bXc.show();
                this.aqu.setVisibility(8);
                if (this.bXd != null) {
                    this.bXd.setVisibility(0);
                }
                if (biVar.bbL) {
                    this.bXc.bqS();
                } else {
                    this.bXc.bqR();
                    if (biVar.bbM) {
                        this.aqu.setVisibility(0);
                    }
                }
            } else {
                this.bXc.hide();
                this.aqu.setVisibility(0);
                if (this.bXd != null) {
                    this.bXd.setVisibility(8);
                }
            }
        }
        l(biVar);
    }

    public void l(bi biVar) {
        MetaData author;
        if (biVar != null && this.bSf != null && (author = biVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sg = biVar.sg();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bai.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aZA.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bSf.setVisibility(8);
                if (this.bSw != null) {
                    if (sg != null) {
                        this.bSw.a(this.GM, sg, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(biVar.getFid()), biVar.getForum_name(), biVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds16);
                    } else {
                        this.bSw.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds30);
                    }
                }
            } else {
                this.bSf.setVisibility(0);
                this.bSf.setImageBitmap(null);
                this.bSf.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bSf.setOnClickListener(new ag(this, themeCard));
                this.bSw.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds30);
            }
            this.bai.setLayoutParams(layoutParams);
            this.aZA.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bi biVar) {
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
        this.baj.setClickable(true);
        this.aYR.setBarNameClickEnabled(true);
        int childCount = this.bam.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bam.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
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
        if (this.adW != null) {
            com.baidu.tieba.card.an.hN(this.adW.getId());
            com.baidu.tbadk.core.data.m sI = this.adW.sI();
            if (sI != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.GM.getPageActivity(), sI.getCartoonId(), sI.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.adW.UK;
            if (this.adW.UJ == 1 && jVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.PW;
                long j = jVar.PX;
                com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                alVar.pageContext = this.GM;
                alVar.bookId = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, alVar));
            } else if (this.adW.rZ() != null) {
                if (bm.ak(this.GM.getPageActivity())) {
                    String postUrl = this.adW.rZ().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.gD()) {
                        com.baidu.tbadk.browser.f.v(this.GM.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.s.gC(this.adW.getId());
                if (this.adW.sh() > 0 && com.baidu.tieba.tbadkCore.util.t.bkQ()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.GM.getPageActivity()).createHistoryCfg(this.adW.getTid(), String.valueOf(this.adW.sh()), false, true, com.baidu.tieba.card.an.Od());
                    createHistoryCfg.setVideo_source("frs");
                    this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.GM.getPageActivity()).createFromThreadCfg(this.adW, this.mForumName, com.baidu.tieba.card.an.Od(), 18003, true, false, false);
                createFromThreadCfg.setVideo_source("frs");
                this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
