package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.at;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.card.a<az> implements au {
    private static HashMap<Point, Integer> QP = new HashMap<>();
    private TbPageContext<?> Ea;
    protected boolean ZM;
    private View aSa;
    private TextView aSd;
    protected TextView aSj;
    public ThreadCommentAndPraiseInfoLayout aSl;
    public ClickableHeaderImageView aTK;
    public PlayVoiceBntNew aTL;
    public UserIconLayout aTM;
    protected ConstrainImageGroup aTO;
    private View.OnClickListener aTP;
    private final View.OnClickListener aTR;
    public LinearLayout aTc;
    private CustomMessageListener aTw;
    private az aas;
    private final View.OnClickListener adL;
    private final View.OnClickListener aei;
    public TbImageView bFR;
    protected TextView bGb;
    public ThreadSkinView bGc;
    public RelativeLayout bKq;
    protected TbImageView bKr;
    private View.OnClickListener bKs;
    private String mForumName;
    protected int mSkinType;

    static {
        QP.put(new Point(1, 1), Integer.valueOf(u.j.lottery_status_ing));
        QP.put(new Point(1, 2), Integer.valueOf(u.j.lottery_status_over));
        QP.put(new Point(1, 3), Integer.valueOf(u.j.lottery_status_off));
        QP.put(new Point(1, 4), Integer.valueOf(u.j.lottery_status_not_start));
        QP.put(new Point(2, 1), Integer.valueOf(u.j.share_picture_status_ing));
        QP.put(new Point(2, 2), Integer.valueOf(u.j.share_picture_status_over));
        QP.put(new Point(2, 3), Integer.valueOf(u.j.share_picture_status_off));
        QP.put(new Point(2, 4), Integer.valueOf(u.j.share_picture_status_not_start));
    }

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ZM = true;
        this.aTP = new v(this);
        this.bKs = new w(this);
        this.aTw = new x(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aTR = new y(this);
        this.aei = new z(this);
        this.adL = new aa(this);
        View view = getView();
        this.Ea = tbPageContext;
        this.aSa = view.findViewById(u.g.card_home_page_normal_thread_top_line);
        this.aTK = (ClickableHeaderImageView) view.findViewById(u.g.card_home_page_normal_thread_user_header);
        this.aTK.setDefaultResource(17170445);
        this.aTK.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aTK.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aTK.setRadius(com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds70));
        this.aTM = (UserIconLayout) view.findViewById(u.g.card_home_page_normal_thread_user_layout);
        this.aTM.aeh = true;
        this.aTM.setEntelechyEnabled(true);
        this.aTM.setPageName(1);
        this.aSd = (TextView) view.findViewById(u.g.card_home_page_normal_thread_title);
        this.aTL = (PlayVoiceBntNew) view.findViewById(u.g.card_home_page_normal_thread_abstract_voice);
        this.aTL.setAfterClickListener(this.aTR);
        this.aTL.setPlayTimeTextView(u.e.fontsize28);
        this.bFR = (TbImageView) view.findViewById(u.g.frs_normal_item_theme_card);
        this.aSj = (TextView) view.findViewById(u.g.card_home_page_normal_thread_abstract);
        this.aSj.setFocusable(true);
        this.aTO = (ConstrainImageGroup) view.findViewById(u.g.card_home_page_normal_thread_img_layout);
        this.aTO.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds4));
        this.aTO.setChildClickListener(this.bKs);
        this.aSl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.card_home_page_normal_thread_info_layout);
        this.aSl.setLocationEnabled(true);
        this.aSl.setCommentNumClickListener(this.aTP);
        this.aTc = (LinearLayout) view.findViewById(u.g.card_home_page_normal_thread_content_layout);
        this.bKq = (RelativeLayout) view.findViewById(u.g.card_home_page_normal_thread_root_content);
        this.bKr = (TbImageView) view.findViewById(u.g.game_activity_banner);
        this.bGb = (TextView) view.findViewById(u.g.app_code_btn);
        this.bGc = (ThreadSkinView) view.findViewById(u.g.frs_thread_skin);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.aTO != null) {
            this.aTO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.aTO != null) {
            this.aTO.setImageViewPool(bVar);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(getView(), u.f.addresslist_item_bg);
            av.l(this.aSa, u.d.cp_bg_line_b);
            this.aTO.se();
            this.aTM.se();
            this.aSl.se();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_multi_img;
    }

    public void h(az azVar) {
        int i;
        if (azVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aas = azVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aTP);
            getView().setLongClickable(true);
        }
        d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        this.aTM.setVisibility(0);
        this.aTK.setVisibility(0);
        this.aTK.setData(azVar);
        this.aTK.setAfterClickListener(this.aei);
        this.aTM.setData(azVar);
        this.aTM.setUserAfterClickListener(this.aei);
        this.aSl.setData(azVar);
        this.aSl.setForumAfterClickListener(this.adL);
        this.aSl.setStType(at.Lb());
        if (StringUtils.isNull(azVar.getTitle()) || azVar.qU() == 1) {
            this.aSd.setVisibility(8);
        } else {
            ArrayList arrayList = new ArrayList();
            this.aSd.setVisibility(0);
            azVar.Qo = 0;
            if (i(azVar)) {
                if (azVar.qH() == 1 && !azVar.rp()) {
                    arrayList.add(new at.a(u.j.kn_zhibo));
                }
                if (azVar.getIs_good() == 1) {
                    arrayList.add(new at.a(u.j.good));
                }
                if (azVar.getIs_top() == 1) {
                    arrayList.add(new at.a(u.j.commit_top));
                }
                if (azVar.rp() && azVar.qy() != null && azVar.rb() == 2) {
                    arrayList.add(new at.a(u.j.interview_live));
                }
                if (azVar.re()) {
                    Integer num = QP.get(new Point(azVar.rd(), azVar.rc()));
                    if (num != null) {
                        arrayList.add(new at.a(num.intValue(), u.d.cp_other_b, u.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(u.j.card_promotion_text));
                    }
                }
                if (azVar.Rn == 1) {
                    arrayList.add(new at.a(u.j.card_tbread_text));
                }
                if (azVar.qS() != null) {
                    arrayList.add(new at.a(u.j.send_app_code_gift, u.d.cp_other_b, u.f.pic_dot_title_red));
                }
                if (azVar.qR() != null) {
                    arrayList.add(new at.a(u.j.card_promotion_text, u.d.cp_other_b, u.f.pic_dot_title_red));
                }
                if (!ba.isEmpty(azVar.qG())) {
                    arrayList.add(new at.a(azVar.qG()));
                }
                this.aSd.setText(at.a(getContext(), String.valueOf(azVar.getTitle()) + " ", arrayList));
            } else if (azVar.rk()) {
                this.aSd.setText(String.valueOf(azVar.getTitle()) + " ");
            } else {
                azVar.parser_title();
                this.aSd.setText(((Object) azVar.getSpan_str()) + " ");
            }
            at.a(this.aSd, azVar.getId(), u.d.cp_cont_b, u.d.cp_cont_c);
        }
        StringBuilder sb = new StringBuilder();
        if (azVar.qO() != null && !StringUtils.isNull(azVar.qO())) {
            sb.append(azVar.qO());
        }
        ArrayList<MediaData> medias = azVar.getMedias();
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
                this.aSj.setText(sb.toString());
                this.aSj.setContentDescription(sb.toString());
                this.aSj.setVisibility(0);
                at.a(this.aSj, azVar.getId(), u.d.cp_cont_j, u.d.cp_cont_c);
            } else {
                this.aSj.setVisibility(8);
            }
        } else {
            this.aSj.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aSl.getLayoutParams();
        if (layoutParams != null) {
            if (this.aSj.getVisibility() == 8 && this.aSd.getVisibility() == 8 && this.aTL.getVisibility() == 8 && this.aSl.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.Ea.getResources().getDimension(u.e.ds40), 0, 0);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
        }
        ArrayList<VoiceData.VoiceModel> qT = azVar.qT();
        if (com.baidu.tbadk.core.util.y.t(qT)) {
            this.aTL.setVisibility(8);
        } else {
            this.aTL.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qT.get(0);
            this.aTL.setVoiceModel(voiceModel);
            this.aTL.setTag(voiceModel);
            this.aTL.bdr();
            if (voiceModel != null) {
                this.aTL.ln(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.l.nW().oc() && com.baidu.tbadk.core.util.y.s(medias) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.c(medias, i3);
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
                this.aTO.setVisibility(0);
                this.aTO.setFromCDN(this.ZM);
                if (this.aas.rs() != null) {
                    this.aTO.setImageClickListener(new ab(this));
                } else {
                    this.aTO.setImageClickListener(new ac(this, linkedList2, azVar));
                }
                this.aTO.setImageUrls(linkedList);
            } else {
                this.aTO.setVisibility(8);
            }
        } else {
            this.aTO.setVisibility(8);
        }
        if (this.bKr != null) {
            if (azVar.qR() != null) {
                String rN = azVar.qR().rN();
                if (!StringUtils.isNull(rN)) {
                    this.bKr.setVisibility(0);
                    this.bKr.c(rN, 10, true);
                } else {
                    this.bKr.setVisibility(8);
                }
            } else {
                this.bKr.setVisibility(8);
            }
        }
        if (this.bGb != null) {
            if (azVar.qS() != null) {
                String ls = azVar.qS().ls();
                if (!StringUtils.isNull(ls)) {
                    String fixedText = ba.getFixedText(ls, 20, true);
                    av.k(this.bGb, u.f.btn_red_frame_n);
                    av.j((View) this.bGb, u.d.cp_cont_h);
                    this.bGb.setText(fixedText);
                    this.bGb.setVisibility(0);
                } else {
                    this.bGb.setVisibility(8);
                }
            } else {
                this.bGb.setVisibility(8);
            }
        }
        Lc();
    }

    private boolean i(az azVar) {
        if (azVar == null) {
            return false;
        }
        if (azVar.qH() == 1 || azVar.getIs_good() == 1 || azVar.getIs_top() == 1 || azVar.re() || azVar.Rn == 1) {
            return true;
        }
        if (azVar.qS() == null && azVar.qR() == null) {
            return !com.baidu.adp.lib.util.j.isEmpty(azVar.qG());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, az azVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.Ea.getPageActivity(), u.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ZM ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(azVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.Ea.getPageActivity()).createConfig(arrayList, i, azVar.getForum_name(), String.valueOf(azVar.getFid()), azVar.getTid(), this.ZM, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Lc() {
        this.aTL.setClickable(true);
        this.aSl.setBarNameClickEnabled(true);
        int childCount = this.aTO.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aTO.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ZM = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSl != null && this.aTw != null) {
            this.aSl.h(bdUniqueId);
            this.aTw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld() {
        if (this.aas != null) {
            at.hb(this.aas.getId());
            com.baidu.tbadk.core.data.l rs = this.aas.rs();
            if (rs != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.Ea.getPageActivity(), rs.getCartoonId(), rs.getChapterId(), 2)));
            } else if (this.aas.qS() != null) {
                if (bn.ab(this.Ea.getPageActivity())) {
                    String postUrl = this.aas.qS().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.fI()) {
                        com.baidu.tbadk.browser.f.v(this.Ea.getPageActivity(), postUrl);
                    }
                }
            } else {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.Ea.getPageActivity()).createFromThreadCfg(this.aas, this.mForumName, at.Lb(), 18003, true, false, false);
                createFromThreadCfg.setVideo_source("frs");
                this.Ea.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.view.au
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
