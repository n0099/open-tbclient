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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.card.a<bg> implements az {
    private static HashMap<Point, Integer> Ub = new HashMap<>();
    private TbPageContext<?> GM;
    private View aYc;
    public ViewStub aYe;
    public TbImageView aYf;
    private TextView aYh;
    protected TextView aYn;
    public ThreadCommentAndPraiseInfoLayout aYp;
    private CustomMessageListener aZB;
    public ClickableHeaderImageView aZR;
    public PlayVoiceBntNew aZS;
    public UserIconLayout aZT;
    protected ConstrainImageGroup aZV;
    private View.OnClickListener aZW;
    private final View.OnClickListener aZY;
    public LinearLayout aZg;
    private bg adL;
    protected boolean adl;
    private final View.OnClickListener ahR;
    private final View.OnClickListener ahu;
    protected TextView bSC;
    public ThreadSkinView bSD;
    public TbImageView bSm;
    private GuessYourLikeHeaderView bXi;
    private View bXj;
    public HeadPendantClickableView bXp;
    public RelativeLayout bXq;
    protected TbImageView bXr;
    private View.OnClickListener bXs;
    private String mForumName;
    protected int mSkinType;

    static {
        Ub.put(new Point(1, 1), Integer.valueOf(t.j.lottery_status_ing));
        Ub.put(new Point(1, 2), Integer.valueOf(t.j.lottery_status_over));
        Ub.put(new Point(1, 3), Integer.valueOf(t.j.lottery_status_off));
        Ub.put(new Point(1, 4), Integer.valueOf(t.j.lottery_status_not_start));
        Ub.put(new Point(2, 1), Integer.valueOf(t.j.share_picture_status_ing));
        Ub.put(new Point(2, 2), Integer.valueOf(t.j.share_picture_status_over));
        Ub.put(new Point(2, 3), Integer.valueOf(t.j.share_picture_status_off));
        Ub.put(new Point(2, 4), Integer.valueOf(t.j.share_picture_status_not_start));
    }

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.adl = true;
        this.aZW = new y(this);
        this.bXs = new z(this);
        this.aZB = new aa(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aZY = new ab(this);
        this.ahR = new ac(this);
        this.ahu = new ad(this);
        View view = getView();
        this.GM = tbPageContext;
        this.aYc = view.findViewById(t.g.card_home_page_normal_thread_top_line);
        this.aZR = (ClickableHeaderImageView) view.findViewById(t.g.card_home_page_normal_thread_user_header);
        this.bXp = (HeadPendantClickableView) view.findViewById(t.g.card_home_page_normal_thread_user_pendant_header);
        this.aZR.setDefaultResource(17170445);
        this.aZR.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aZR.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aZR.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds70));
        this.aYe = (ViewStub) view.findViewById(t.g.viewstub_headimage_mask);
        if (this.bXp.getHeadView() != null) {
            this.bXp.getHeadView().setIsRound(true);
            this.bXp.getHeadView().setDrawBorder(false);
            this.bXp.getHeadView().setDefaultResource(17170445);
            this.bXp.getHeadView().setDefaultErrorResource(t.f.icon_default_avatar100);
            this.bXp.getHeadView().setDefaultBgResource(t.d.cp_bg_line_e);
            this.bXp.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds70));
        }
        this.bXp.vW();
        if (this.bXp.getPendantView() != null) {
            this.bXp.getPendantView().setIsRound(true);
            this.bXp.getPendantView().setDrawBorder(false);
        }
        this.aZT = (UserIconLayout) view.findViewById(t.g.card_home_page_normal_thread_user_layout);
        this.aZT.ahQ = true;
        this.aZT.setEntelechyEnabled(true);
        this.aZT.setPageName(1);
        this.aYh = (TextView) view.findViewById(t.g.card_home_page_normal_thread_title);
        this.aZS = (PlayVoiceBntNew) view.findViewById(t.g.card_home_page_normal_thread_abstract_voice);
        this.aZS.setAfterClickListener(this.aZY);
        this.aZS.setPlayTimeTextView(t.e.fontsize28);
        this.bSm = (TbImageView) view.findViewById(t.g.frs_normal_item_theme_card);
        this.aYn = (TextView) view.findViewById(t.g.card_home_page_normal_thread_abstract);
        this.aYn.setFocusable(true);
        this.aZV = (ConstrainImageGroup) view.findViewById(t.g.card_home_page_normal_thread_img_layout);
        this.aZV.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds4));
        this.aZV.setChildClickListener(this.bXs);
        this.aYp = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_home_page_normal_thread_info_layout);
        this.aYp.setLocationEnabled(true);
        this.aYp.setCommentNumClickListener(this.aZW);
        this.aZg = (LinearLayout) view.findViewById(t.g.card_home_page_normal_thread_content_layout);
        this.bXq = (RelativeLayout) view.findViewById(t.g.card_home_page_normal_thread_root_content);
        this.bXr = (TbImageView) view.findViewById(t.g.game_activity_banner);
        this.bSC = (TextView) view.findViewById(t.g.app_code_btn);
        this.bSD = (ThreadSkinView) view.findViewById(t.g.frs_thread_skin);
        this.bXi = (GuessYourLikeHeaderView) view.findViewById(t.g.guess_your_like_header);
        this.bXj = view.findViewById(t.g.guess_your_like_bottom_line);
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
            av.l(getView(), t.d.cp_bg_line_d);
            av.k(this.bXq, t.f.addresslist_item_bg);
            if (this.adL != null && this.adL.bbt) {
                av.l(this.aYc, t.d.cp_bg_line_c);
            } else {
                av.l(this.aYc, t.d.cp_bg_line_b);
            }
            this.aZV.ti();
            this.aZT.ti();
            this.aYp.ti();
            if (this.bXi != null) {
                this.bXi.ti();
            }
            av.l(this.bXj, t.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: i */
    public void onBindDataToView(bg bgVar) {
        int i;
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.adL = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.bXq != null) {
                this.bXq.setOnClickListener(this.aZW);
                this.bXq.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.aZW);
                getView().setLongClickable(true);
            }
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        this.aZT.setVisibility(0);
        if (this.adL.getAuthor() == null || this.adL.getAuthor().getPendantData() == null || StringUtils.isNull(this.adL.getAuthor().getPendantData().rc())) {
            UserTbVipInfoData rC = this.adL.rC();
            if (rC != null && rC.getvipV_url() != null) {
                if (this.aYe != null) {
                    if (this.aYf == null) {
                        this.aYe.inflate();
                        this.aYf = (TbImageView) getView().findViewById(t.g.user_head_mask);
                    }
                    this.aYf.setVisibility(0);
                    this.aYf.c(rC.getvipV_url(), 10, false);
                    this.aZR.setIsBigV(true);
                }
            } else {
                this.aZR.setIsBigV(false);
                if (this.aYf != null) {
                    this.aYf.setVisibility(8);
                }
            }
            this.bXp.setVisibility(8);
            this.aZR.setVisibility(0);
            this.aZR.setData(bgVar);
            this.aZR.setAfterClickListener(this.ahR);
        } else {
            this.aZR.setVisibility(4);
            this.aZR.setIsBigV(false);
            if (this.aYf != null) {
                this.aYf.setVisibility(8);
            }
            this.bXp.setVisibility(0);
            this.bXp.setData(bgVar);
        }
        this.aZT.setData(bgVar);
        this.aZT.setUserAfterClickListener(this.ahR);
        this.aYp.setData(bgVar);
        this.aYp.setForumAfterClickListener(this.ahu);
        this.aYp.setStType(com.baidu.tieba.card.ap.ND());
        if ((StringUtils.isNull(bgVar.getTitle()) && (bgVar.rA() == null || bgVar.rA().size() == 0)) || bgVar.rP() == 1) {
            this.aYh.setVisibility(8);
        } else {
            this.aYh.setVisibility(0);
            bgVar.Ts = 0;
            if (k(bgVar)) {
                bgVar.e(false, true);
            } else {
                bgVar.e(false, false);
            }
            SpannableStringBuilder sa = bgVar.sa();
            this.aYh.setOnTouchListener(new com.baidu.tieba.view.y(sa));
            this.aYh.setText(sa);
            com.baidu.tieba.card.ap.a(this.aYh, bgVar.getId(), t.d.cp_cont_b, t.d.cp_cont_c);
        }
        StringBuilder sb = new StringBuilder();
        if (bgVar.rI() != null && !StringUtils.isNull(bgVar.rI())) {
            sb.append(bgVar.rI());
        }
        ArrayList<MediaData> rK = bgVar.rK();
        if (rK != null) {
            i = rK.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rK.get(i2).getVideoUrl() != null && rK.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rK.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bgVar.g(sb.toString(), true))) {
                SpannableString cu = bgVar.cu(sb.toString());
                this.aYn.setOnTouchListener(new com.baidu.tieba.view.y(cu));
                this.aYn.setText(cu);
                this.aYn.setContentDescription(sb.toString());
                this.aYn.setVisibility(0);
                com.baidu.tieba.card.ap.a(this.aYn, bgVar.getId(), t.d.cp_cont_j, t.d.cp_cont_c);
            } else {
                this.aYn.setVisibility(8);
            }
        } else {
            this.aYn.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aYp.getLayoutParams();
        if (layoutParams != null) {
            if (this.aYn.getVisibility() == 8 && this.aYh.getVisibility() == 8 && this.aZS.getVisibility() == 8 && this.aYp.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.GM.getResources().getDimension(t.e.ds40), 0, 0);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
        }
        ArrayList<VoiceData.VoiceModel> rO = bgVar.rO();
        if (com.baidu.tbadk.core.util.y.t(rO)) {
            this.aZS.setVisibility(8);
        } else {
            this.aZS.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rO.get(0);
            this.aZS.setVoiceModel(voiceModel);
            this.aZS.setTag(voiceModel);
            this.aZS.bkk();
            if (voiceModel != null) {
                this.aZS.lW(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.l.oG().oM() && com.baidu.tbadk.core.util.y.s(rK) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.c(rK, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !ba.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.s(linkedList) > 0) {
                this.aZV.setVisibility(0);
                this.aZV.setFromCDN(this.adl);
                if (this.adL.sw() != null) {
                    this.aZV.setImageClickListener(new ae(this));
                } else {
                    this.aZV.setImageClickListener(new af(this, linkedList2, bgVar));
                }
                this.aZV.setImageUrls(linkedList);
            } else {
                this.aZV.setVisibility(8);
            }
        } else {
            this.aZV.setVisibility(8);
        }
        if (this.bXr != null) {
            if (bgVar.rM() != null) {
                String sR = bgVar.rM().sR();
                if (!StringUtils.isNull(sR)) {
                    this.bXr.setVisibility(0);
                    this.bXr.c(sR, 10, true);
                } else {
                    this.bXr.setVisibility(8);
                }
            } else {
                this.bXr.setVisibility(8);
            }
        }
        if (this.bSC != null) {
            if (bgVar.rN() != null) {
                String mj = bgVar.rN().mj();
                if (!StringUtils.isNull(mj)) {
                    String fixedText = ba.getFixedText(mj, 20, true);
                    av.k(this.bSC, t.f.btn_red_frame_n);
                    av.j((View) this.bSC, t.d.cp_cont_h);
                    this.bSC.setText(fixedText);
                    this.bSC.setVisibility(0);
                } else {
                    this.bSC.setVisibility(8);
                }
            } else {
                this.bSC.setVisibility(8);
            }
        }
        NE();
        if (this.bXi != null) {
            if ((bgVar.rY() || bgVar.rZ()) && com.baidu.tieba.tbadkCore.util.t.bke()) {
                this.bXi.setTitleText(StringUtils.isNull(bgVar.rX()) ? getContext().getResources().getString(t.j.group_fourm_recommend_title) : bgVar.rX());
                this.bXi.show();
                this.aYc.setVisibility(8);
                if (this.bXj != null) {
                    this.bXj.setVisibility(0);
                }
                if (bgVar.bbt) {
                    this.bXi.bqo();
                } else {
                    this.bXi.bqn();
                    if (bgVar.bbu) {
                        this.aYc.setVisibility(0);
                    }
                }
            } else {
                this.bXi.hide();
                this.aYc.setVisibility(0);
                if (this.bXj != null) {
                    this.bXj.setVisibility(8);
                }
            }
        }
        j(bgVar);
    }

    public void j(bg bgVar) {
        MetaData author;
        if (bgVar != null && this.bSm != null && (author = bgVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rU = bgVar.rU();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aZR.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aZg.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bSm.setVisibility(8);
                if (this.bSD != null) {
                    if (rU != null) {
                        this.bSD.a(this.GM, rU, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(bgVar.getFid()), bgVar.getForum_name(), bgVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds16);
                    } else {
                        this.bSD.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds30);
                    }
                }
            } else {
                this.bSm.setVisibility(0);
                this.bSm.setImageBitmap(null);
                this.bSm.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bSm.setOnClickListener(new ag(this, themeCard));
                this.bSD.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds30);
            }
            this.aZR.setLayoutParams(layoutParams);
            this.aZg.setLayoutParams(layoutParams2);
        }
    }

    private boolean k(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        if (bgVar.rz() == 1 || bgVar.ry() == 1 || bgVar.rx() == 1 || bgVar.sf() || bgVar.Uy == 1) {
            return true;
        }
        if (bgVar.rN() == null && bgVar.rM() == null) {
            return !com.baidu.adp.lib.util.j.isEmpty(bgVar.ru()) || bgVar.st();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bg bgVar) {
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
        this.aZS.setClickable(true);
        this.aYp.setBarNameClickEnabled(true);
        int childCount = this.aZV.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aZV.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
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
        if (this.adL != null) {
            com.baidu.tieba.card.ap.hG(this.adL.getId());
            com.baidu.tbadk.core.data.m sw = this.adL.sw();
            if (sw != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.GM.getPageActivity(), sw.getCartoonId(), sw.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.adL.Uz;
            if (this.adL.Uy == 1 && jVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.PY;
                long j = jVar.PZ;
                com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
                ajVar.pageContext = this.GM;
                ajVar.bookId = str;
                ajVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, ajVar));
            } else if (this.adL.rN() != null) {
                if (bn.al(this.GM.getPageActivity())) {
                    String postUrl = this.adL.rN().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.gD()) {
                        com.baidu.tbadk.browser.f.v(this.GM.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.s.gy(this.adL.getId());
                if (this.adL.rV() > 0 && com.baidu.tieba.tbadkCore.util.t.bke()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.GM.getPageActivity()).createHistoryCfg(this.adL.getTid(), String.valueOf(this.adL.rV()), false, true, com.baidu.tieba.card.ap.ND());
                    createHistoryCfg.setVideo_source("frs");
                    this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.GM.getPageActivity()).createFromThreadCfg(this.adL, this.mForumName, com.baidu.tieba.card.ap.ND(), 18003, true, false, false);
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
