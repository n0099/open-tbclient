package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Point;
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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.at;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.u;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.card.a<be> implements aw {
    private static HashMap<Point, Integer> Rs = new HashMap<>();
    private TbPageContext<?> EA;
    private View aSU;
    public ViewStub aSW;
    public TbImageView aSX;
    private TextView aSZ;
    public LinearLayout aTY;
    protected TextView aTf;
    public ThreadCommentAndPraiseInfoLayout aTh;
    public ClickableHeaderImageView aUG;
    public PlayVoiceBntNew aUH;
    public UserIconLayout aUI;
    protected ConstrainImageGroup aUK;
    private View.OnClickListener aUL;
    private final View.OnClickListener aUN;
    private CustomMessageListener aUs;
    protected boolean aav;
    private be abb;
    private final View.OnClickListener aeW;
    private final View.OnClickListener aez;
    public TbImageView bHg;
    protected TextView bHw;
    public ThreadSkinView bHx;
    private GuessYourLikeHeaderView bLR;
    private View bLS;
    public RelativeLayout bLY;
    protected TbImageView bLZ;
    private View.OnClickListener bMa;
    private String mForumName;
    protected int mSkinType;

    static {
        Rs.put(new Point(1, 1), Integer.valueOf(u.j.lottery_status_ing));
        Rs.put(new Point(1, 2), Integer.valueOf(u.j.lottery_status_over));
        Rs.put(new Point(1, 3), Integer.valueOf(u.j.lottery_status_off));
        Rs.put(new Point(1, 4), Integer.valueOf(u.j.lottery_status_not_start));
        Rs.put(new Point(2, 1), Integer.valueOf(u.j.share_picture_status_ing));
        Rs.put(new Point(2, 2), Integer.valueOf(u.j.share_picture_status_over));
        Rs.put(new Point(2, 3), Integer.valueOf(u.j.share_picture_status_off));
        Rs.put(new Point(2, 4), Integer.valueOf(u.j.share_picture_status_not_start));
    }

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aav = true;
        this.aUL = new w(this);
        this.bMa = new x(this);
        this.aUs = new y(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aUN = new z(this);
        this.aeW = new aa(this);
        this.aez = new ab(this);
        View view = getView();
        this.EA = tbPageContext;
        this.aSU = view.findViewById(u.g.card_home_page_normal_thread_top_line);
        this.aUG = (ClickableHeaderImageView) view.findViewById(u.g.card_home_page_normal_thread_user_header);
        this.aSW = (ViewStub) view.findViewById(u.g.viewstub_headimage_mask);
        this.aUG.setDefaultResource(17170445);
        this.aUG.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aUG.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aUG.setRadius(com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds70));
        this.aUI = (UserIconLayout) view.findViewById(u.g.card_home_page_normal_thread_user_layout);
        this.aUI.aeV = true;
        this.aUI.setEntelechyEnabled(true);
        this.aUI.setPageName(1);
        this.aSZ = (TextView) view.findViewById(u.g.card_home_page_normal_thread_title);
        this.aUH = (PlayVoiceBntNew) view.findViewById(u.g.card_home_page_normal_thread_abstract_voice);
        this.aUH.setAfterClickListener(this.aUN);
        this.aUH.setPlayTimeTextView(u.e.fontsize28);
        this.bHg = (TbImageView) view.findViewById(u.g.frs_normal_item_theme_card);
        this.aTf = (TextView) view.findViewById(u.g.card_home_page_normal_thread_abstract);
        this.aTf.setFocusable(true);
        this.aUK = (ConstrainImageGroup) view.findViewById(u.g.card_home_page_normal_thread_img_layout);
        this.aUK.setImageMargin(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds4));
        this.aUK.setChildClickListener(this.bMa);
        this.aTh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.card_home_page_normal_thread_info_layout);
        this.aTh.setLocationEnabled(true);
        this.aTh.setCommentNumClickListener(this.aUL);
        this.aTY = (LinearLayout) view.findViewById(u.g.card_home_page_normal_thread_content_layout);
        this.bLY = (RelativeLayout) view.findViewById(u.g.card_home_page_normal_thread_root_content);
        this.bLZ = (TbImageView) view.findViewById(u.g.game_activity_banner);
        this.bHw = (TextView) view.findViewById(u.g.app_code_btn);
        this.bHx = (ThreadSkinView) view.findViewById(u.g.frs_thread_skin);
        this.bLR = (GuessYourLikeHeaderView) view.findViewById(u.g.guess_your_like_header);
        this.bLS = view.findViewById(u.g.guess_your_like_bottom_line);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.aUK != null) {
            this.aUK.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.aUK != null) {
            this.aUK.setImageViewPool(bVar);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.l(getView(), u.d.cp_bg_line_d);
            av.k(this.bLY, u.f.addresslist_item_bg);
            if (this.abb != null && this.abb.aVQ) {
                av.l(this.aSU, u.d.cp_bg_line_c);
            } else {
                av.l(this.aSU, u.d.cp_bg_line_b);
            }
            this.aUK.sd();
            this.aUI.sd();
            this.aTh.sd();
            if (this.bLR != null) {
                this.bLR.sd();
            }
            av.l(this.bLS, u.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_multi_img;
    }

    public void i(be beVar) {
        int i;
        if (beVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.abb = beVar;
        if (getView() != null) {
            getView().setVisibility(0);
            if (this.bLY != null) {
                this.bLY.setOnClickListener(this.aUL);
                this.bLY.setLongClickable(true);
            } else {
                getView().setOnClickListener(this.aUL);
                getView().setLongClickable(true);
            }
        }
        d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
        this.aUI.setVisibility(0);
        UserTbVipInfoData qx = this.abb.qx();
        if (qx != null && qx.getvipV_url() != null) {
            if (this.aSW != null) {
                if (this.aSX == null) {
                    this.aSW.inflate();
                    this.aSX = (TbImageView) getView().findViewById(u.g.user_head_mask);
                }
                this.aSX.setVisibility(0);
                this.aSX.c(qx.getvipV_url(), 10, false);
                this.aUG.setIsBigV(true);
            }
        } else {
            this.aUG.setIsBigV(false);
            if (this.aSX != null) {
                this.aSX.setVisibility(8);
            }
        }
        this.aUG.setVisibility(0);
        this.aUG.setData(beVar);
        this.aUG.setAfterClickListener(this.aeW);
        this.aUI.setData(beVar);
        this.aUI.setUserAfterClickListener(this.aeW);
        this.aTh.setData(beVar);
        this.aTh.setForumAfterClickListener(this.aez);
        this.aTh.setStType(at.La());
        if (StringUtils.isNull(beVar.getTitle()) || beVar.qK() == 1) {
            this.aSZ.setVisibility(8);
        } else {
            ArrayList arrayList = new ArrayList();
            this.aSZ.setVisibility(0);
            beVar.QJ = 0;
            if (k(beVar)) {
                if (beVar.qv() == 1 && !beVar.rn()) {
                    arrayList.add(new at.a(u.j.kn_zhibo));
                }
                if (beVar.qu() == 1) {
                    arrayList.add(new at.a(u.j.good));
                }
                if (beVar.qt() == 1) {
                    arrayList.add(new at.a(u.j.commit_top));
                }
                if (beVar.rn() && beVar.qh() != null && beVar.qX() == 2) {
                    arrayList.add(new at.a(u.j.interview_live));
                }
                if (beVar.ra()) {
                    Integer num = Rs.get(new Point(beVar.qZ(), beVar.qY()));
                    if (num != null) {
                        arrayList.add(new at.a(num.intValue(), u.d.cp_other_b, u.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(u.j.card_promotion_text));
                    }
                }
                if (beVar.RQ == 1) {
                    arrayList.add(new at.a(u.j.card_tbread_text));
                }
                if (beVar.qI() != null) {
                    arrayList.add(new at.a(u.j.send_app_code_gift, u.d.cp_other_b, u.f.pic_dot_title_red));
                }
                if (beVar.qH() != null) {
                    arrayList.add(new at.a(u.j.card_promotion_text, u.d.cp_other_b, u.f.pic_dot_title_red));
                }
                if (beVar.ro()) {
                    arrayList.add(new at.a(u.j.evaluation));
                }
                if (!ba.isEmpty(beVar.qq())) {
                    arrayList.add(new at.a(beVar.qq()));
                }
                this.aSZ.setText(at.a(getContext(), String.valueOf(beVar.getTitle()) + " ", arrayList));
            } else if (beVar.ri()) {
                this.aSZ.setText(String.valueOf(beVar.getTitle()) + " ");
            } else {
                beVar.rd();
                this.aSZ.setText(beVar.qV());
            }
            at.a(this.aSZ, beVar.getId(), u.d.cp_cont_b, u.d.cp_cont_c);
        }
        StringBuilder sb = new StringBuilder();
        if (beVar.qD() != null && !StringUtils.isNull(beVar.qD())) {
            sb.append(beVar.qD());
        }
        ArrayList<MediaData> qF = beVar.qF();
        if (qF != null) {
            i = qF.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (qF.get(i2).getVideoUrl() != null && qF.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(qF.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (sb.length() > 0) {
                this.aTf.setText(sb.toString());
                this.aTf.setContentDescription(sb.toString());
                this.aTf.setVisibility(0);
                at.a(this.aTf, beVar.getId(), u.d.cp_cont_j, u.d.cp_cont_c);
            } else {
                this.aTf.setVisibility(8);
            }
        } else {
            this.aTf.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aTh.getLayoutParams();
        if (layoutParams != null) {
            if (this.aTf.getVisibility() == 8 && this.aSZ.getVisibility() == 8 && this.aUH.getVisibility() == 8 && this.aTh.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.EA.getResources().getDimension(u.e.ds40), 0, 0);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
        }
        ArrayList<VoiceData.VoiceModel> qJ = beVar.qJ();
        if (com.baidu.tbadk.core.util.y.t(qJ)) {
            this.aUH.setVisibility(8);
        } else {
            this.aUH.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qJ.get(0);
            this.aUH.setVoiceModel(voiceModel);
            this.aUH.setTag(voiceModel);
            this.aUH.bgJ();
            if (voiceModel != null) {
                this.aUH.lt(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.l.nL().nR() && com.baidu.tbadk.core.util.y.s(qF) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.c(qF, i3);
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
                this.aUK.setVisibility(0);
                this.aUK.setFromCDN(this.aav);
                if (this.abb.rr() != null) {
                    this.aUK.setImageClickListener(new ac(this));
                } else {
                    this.aUK.setImageClickListener(new ad(this, linkedList2, beVar));
                }
                this.aUK.setImageUrls(linkedList);
            } else {
                this.aUK.setVisibility(8);
            }
        } else {
            this.aUK.setVisibility(8);
        }
        if (this.bLZ != null) {
            if (beVar.qH() != null) {
                String rM = beVar.qH().rM();
                if (!StringUtils.isNull(rM)) {
                    this.bLZ.setVisibility(0);
                    this.bLZ.c(rM, 10, true);
                } else {
                    this.bLZ.setVisibility(8);
                }
            } else {
                this.bLZ.setVisibility(8);
            }
        }
        if (this.bHw != null) {
            if (beVar.qI() != null) {
                String lo = beVar.qI().lo();
                if (!StringUtils.isNull(lo)) {
                    String fixedText = ba.getFixedText(lo, 20, true);
                    av.k(this.bHw, u.f.btn_red_frame_n);
                    av.j((View) this.bHw, u.d.cp_cont_h);
                    this.bHw.setText(fixedText);
                    this.bHw.setVisibility(0);
                } else {
                    this.bHw.setVisibility(8);
                }
            } else {
                this.bHw.setVisibility(8);
            }
        }
        Lb();
        if (this.bLR != null) {
            if ((beVar.qT() || beVar.qU()) && com.baidu.tieba.tbadkCore.util.t.bgD()) {
                this.bLR.setTitleText(StringUtils.isNull(beVar.qS()) ? getContext().getResources().getString(u.j.group_fourm_recommend_title) : beVar.qS());
                this.bLR.show();
                this.aSU.setVisibility(8);
                if (this.bLS != null) {
                    this.bLS.setVisibility(0);
                }
                if (beVar.aVQ) {
                    this.bLR.bmD();
                    return;
                }
                this.bLR.bmC();
                if (beVar.aVR) {
                    this.aSU.setVisibility(0);
                    return;
                }
                return;
            }
            this.bLR.hide();
            this.aSU.setVisibility(0);
            if (this.bLS != null) {
                this.bLS.setVisibility(8);
            }
        }
    }

    private boolean k(be beVar) {
        if (beVar == null) {
            return false;
        }
        if (beVar.qv() == 1 || beVar.qu() == 1 || beVar.qt() == 1 || beVar.ra() || beVar.RQ == 1) {
            return true;
        }
        if (beVar.qI() == null && beVar.qH() == null) {
            return !com.baidu.adp.lib.util.j.isEmpty(beVar.qq()) || beVar.ro();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, be beVar) {
        if (!TbadkCoreApplication.m10getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.EA.getPageActivity(), u.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aav ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(beVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.EA.getPageActivity()).createConfig(arrayList, i, beVar.getForum_name(), String.valueOf(beVar.getFid()), beVar.getTid(), this.aav, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Lb() {
        this.aUH.setClickable(true);
        this.aTh.setBarNameClickEnabled(true);
        int childCount = this.aUK.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aUK.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aav = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aTh != null && this.aUs != null) {
            this.aTh.h(bdUniqueId);
            this.aUs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lc() {
        if (this.abb != null) {
            at.hb(this.abb.getId());
            com.baidu.tbadk.core.data.m rr = this.abb.rr();
            if (rr != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.EA.getPageActivity(), rr.getCartoonId(), rr.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.abb.RR;
            if (this.abb.RQ == 1 && jVar != null && TbadkCoreApplication.m10getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.NA;
                long j = jVar.NB;
                com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
                aiVar.pageContext = this.EA;
                aiVar.bookId = str;
                aiVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aiVar));
            } else if (this.abb.qI() != null) {
                if (bn.ab(this.EA.getPageActivity())) {
                    String postUrl = this.abb.qI().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.fH()) {
                        com.baidu.tbadk.browser.f.v(this.EA.getPageActivity(), postUrl);
                    }
                }
            } else {
                com.baidu.tbadk.util.s.gv(this.abb.getId());
                if (this.abb.qQ() > 0 && com.baidu.tieba.tbadkCore.util.t.bgD()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.EA.getPageActivity()).createHistoryCfg(this.abb.getTid(), String.valueOf(this.abb.qQ()), false, true, at.La());
                    createHistoryCfg.setVideo_source("frs");
                    this.EA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.EA.getPageActivity()).createFromThreadCfg(this.abb, this.mForumName, at.La(), 18003, true, false, false);
                createFromThreadCfg.setVideo_source("frs");
                this.EA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aw
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
