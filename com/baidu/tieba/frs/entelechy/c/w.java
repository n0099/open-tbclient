package com.baidu.tieba.frs.entelechy.c;

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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.card.a<ax> {
    private static HashMap<Point, Integer> QB = new HashMap<>();
    private TbPageContext<?> DV;
    protected boolean Zv;
    private View aOD;
    private TextView aOG;
    protected TextView aOM;
    public ThreadCommentAndPraiseInfoLayout aOO;
    protected LinearLayout aPG;
    private CustomMessageListener aQc;
    public ClickableHeaderImageView aQn;
    public PlayVoiceBntNew aQo;
    public UserIconLayout aQp;
    protected ConstrainImageGroup aQr;
    private View.OnClickListener aQs;
    private final View.OnClickListener aQu;
    private ax aab;
    private final View.OnClickListener adK;
    private final View.OnClickListener adn;
    public TbImageView bkR;
    protected TextView blb;
    public RelativeLayout bpJ;
    protected TbImageView bpK;
    private View.OnClickListener bpL;
    protected int mSkinType;

    static {
        QB.put(new Point(1, 1), Integer.valueOf(t.j.lottery_status_ing));
        QB.put(new Point(1, 2), Integer.valueOf(t.j.lottery_status_over));
        QB.put(new Point(1, 3), Integer.valueOf(t.j.lottery_status_off));
        QB.put(new Point(1, 4), Integer.valueOf(t.j.lottery_status_not_start));
        QB.put(new Point(2, 1), Integer.valueOf(t.j.share_picture_status_ing));
        QB.put(new Point(2, 2), Integer.valueOf(t.j.share_picture_status_over));
        QB.put(new Point(2, 3), Integer.valueOf(t.j.share_picture_status_off));
        QB.put(new Point(2, 4), Integer.valueOf(t.j.share_picture_status_not_start));
    }

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Zv = true;
        this.aQs = new x(this);
        this.bpL = new y(this);
        this.aQc = new z(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aQu = new aa(this);
        this.adK = new ab(this);
        this.adn = new ac(this);
        View view = getView();
        this.DV = tbPageContext;
        this.aOD = view.findViewById(t.g.card_home_page_normal_thread_top_line);
        this.aQn = (ClickableHeaderImageView) view.findViewById(t.g.card_home_page_normal_thread_user_header);
        this.aQn.setDefaultResource(17170445);
        this.aQn.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aQn.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aQn.setRadius(com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds70));
        this.aQp = (UserIconLayout) view.findViewById(t.g.card_home_page_normal_thread_user_layout);
        this.aQp.adJ = true;
        this.aQp.setEntelechyEnabled(true);
        this.aQp.setPageName(1);
        this.aOG = (TextView) view.findViewById(t.g.card_home_page_normal_thread_title);
        this.aQo = (PlayVoiceBntNew) view.findViewById(t.g.card_home_page_normal_thread_abstract_voice);
        this.aQo.setAfterClickListener(this.aQu);
        this.aQo.setPlayTimeTextView(t.e.fontsize28);
        this.bkR = (TbImageView) view.findViewById(t.g.frs_normal_item_theme_card);
        this.aOM = (TextView) view.findViewById(t.g.card_home_page_normal_thread_abstract);
        this.aOM.setFocusable(true);
        this.aQr = (ConstrainImageGroup) view.findViewById(t.g.card_home_page_normal_thread_img_layout);
        this.aQr.setImageMargin(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds4));
        this.aQr.setChildClickListener(this.bpL);
        this.aOO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_home_page_normal_thread_info_layout);
        this.aOO.setLocationEnabled(true);
        this.aOO.setCommentNumClickListener(this.aQs);
        this.aPG = (LinearLayout) view.findViewById(t.g.card_home_page_normal_thread_content_layout);
        this.bpJ = (RelativeLayout) view.findViewById(t.g.card_home_page_normal_thread_root_content);
        this.bpK = (TbImageView) view.findViewById(t.g.game_activity_banner);
        this.blb = (TextView) view.findViewById(t.g.app_code_btn);
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

    public void h(ax axVar) {
        int i;
        if (axVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aab = axVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aQs);
            getView().setLongClickable(true);
        }
        d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        this.aQp.setVisibility(0);
        this.aQn.setVisibility(0);
        this.aQn.setData(axVar);
        this.aQn.setAfterClickListener(this.adK);
        this.aQp.setData(axVar);
        this.aQp.setUserAfterClickListener(this.adK);
        this.aOO.setData(axVar);
        this.aOO.setForumAfterClickListener(this.adn);
        this.aOO.setStType(com.baidu.tieba.card.au.Kd());
        if (StringUtils.isNull(axVar.getTitle()) || axVar.qZ() == 1) {
            this.aOG.setVisibility(8);
        } else {
            ArrayList arrayList = new ArrayList();
            this.aOG.setVisibility(0);
            axVar.Qa = 0;
            if (i(axVar)) {
                if (axVar.qN() == 1 && !axVar.rt()) {
                    arrayList.add(Integer.valueOf(t.j.kn_zhibo));
                }
                if (axVar.getIs_good() == 1) {
                    arrayList.add(Integer.valueOf(t.j.good));
                }
                if (axVar.getIs_top() == 1) {
                    arrayList.add(Integer.valueOf(t.j.commit_top));
                }
                if (axVar.rt() && axVar.qF() != null && axVar.rf() == 2) {
                    arrayList.add(Integer.valueOf(t.j.interview_live));
                }
                if (axVar.ri()) {
                    Integer num = QB.get(new Point(axVar.rh(), axVar.rg()));
                    if (num != null) {
                        arrayList.add(num);
                    } else {
                        arrayList.add(Integer.valueOf(t.j.card_promotion_text));
                    }
                }
                this.aOG.setText(com.baidu.tieba.card.au.a(getContext(), String.valueOf(axVar.getTitle()) + " ", arrayList, -2));
            } else if (j(axVar)) {
                if (axVar.qX() != null) {
                    arrayList.add(Integer.valueOf(t.j.send_app_code_gift));
                }
                if (axVar.qW() != null) {
                    arrayList.add(Integer.valueOf(t.j.card_promotion_text));
                }
                this.aOG.setText(com.baidu.tieba.card.au.b(getContext(), String.valueOf(axVar.getTitle()) + " ", arrayList, -2));
            } else if (axVar.ro()) {
                this.aOG.setText(String.valueOf(axVar.getTitle()) + " ");
            } else {
                axVar.parser_title();
                this.aOG.setText(((Object) axVar.getSpan_str()) + " ");
            }
            com.baidu.tieba.card.au.a(this.aOG, axVar.getId(), t.d.cp_cont_b, t.d.cp_cont_c);
        }
        StringBuilder sb = new StringBuilder();
        if (axVar.qT() != null && !StringUtils.isNull(axVar.qT())) {
            sb.append(axVar.qT());
        }
        ArrayList<MediaData> medias = axVar.getMedias();
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
                this.aOM.setContentDescription(sb.toString());
                this.aOM.setVisibility(0);
                com.baidu.tieba.card.au.a(this.aOM, axVar.getId(), t.d.cp_cont_j, t.d.cp_cont_c);
            } else {
                this.aOM.setVisibility(8);
            }
        } else {
            this.aOM.setVisibility(8);
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aOO.getLayoutParams();
        if (layoutParams != null) {
            if (this.aOM.getVisibility() == 8 && this.aOG.getVisibility() == 8 && this.aQo.getVisibility() == 8 && this.aOO.getVisibility() == 8) {
                layoutParams.setMargins(0, (int) this.DV.getResources().getDimension(t.e.ds40), 0, 0);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
        }
        ArrayList<VoiceData.VoiceModel> qY = axVar.qY();
        if (com.baidu.tbadk.core.util.y.s(qY)) {
            this.aQo.setVisibility(8);
        } else {
            this.aQo.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qY.get(0);
            this.aQo.setVoiceModel(voiceModel);
            this.aQo.setTag(voiceModel);
            this.aQo.aVd();
            if (voiceModel != null) {
                this.aQo.jL(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.l.ob().oh() && com.baidu.tbadk.core.util.y.r(medias) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.c(medias, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !ay.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.r(linkedList) > 0) {
                this.aQr.setVisibility(0);
                this.aQr.setFromCDN(this.Zv);
                if (this.aab.rv() != null) {
                    this.aQr.setImageClickListener(new ad(this));
                } else {
                    this.aQr.setImageClickListener(new ae(this, linkedList2, axVar));
                }
                this.aQr.setImageUrls(linkedList);
            } else {
                this.aQr.setVisibility(8);
            }
        } else {
            this.aQr.setVisibility(8);
        }
        if (this.bpK != null) {
            if (axVar.qW() != null) {
                String rQ = axVar.qW().rQ();
                if (!StringUtils.isNull(rQ)) {
                    this.bpK.setVisibility(0);
                    this.bpK.c(rQ, 10, true);
                } else {
                    this.bpK.setVisibility(8);
                }
            } else {
                this.bpK.setVisibility(8);
            }
        }
        if (this.blb != null) {
            if (axVar.qX() != null) {
                String lo = axVar.qX().lo();
                if (!StringUtils.isNull(lo)) {
                    String fixedText = ay.getFixedText(lo, 20, true);
                    com.baidu.tbadk.core.util.at.k(this.blb, t.f.btn_red_frame_n);
                    com.baidu.tbadk.core.util.at.j((View) this.blb, t.d.cp_cont_h);
                    this.blb.setText(fixedText);
                    this.blb.setVisibility(0);
                } else {
                    this.blb.setVisibility(8);
                }
            } else {
                this.blb.setVisibility(8);
            }
        }
        Ke();
    }

    private boolean i(ax axVar) {
        if (axVar == null) {
            return false;
        }
        return axVar.qN() == 1 || axVar.getIs_good() == 1 || axVar.getIs_top() == 1 || axVar.ri();
    }

    private boolean j(ax axVar) {
        if (axVar == null) {
            return false;
        }
        return (axVar.qX() == null && axVar.qW() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, ax axVar) {
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
        this.aQo.setClickable(true);
        this.aOO.setBarNameClickEnabled(true);
        int childCount = this.aQr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aQr.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
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
        if (this.aab != null) {
            com.baidu.tieba.card.au.hb(this.aab.getId());
            com.baidu.tbadk.core.data.k rv = this.aab.rv();
            if (rv != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.DV.getPageActivity(), rv.getCartoonId(), rv.getChapterId(), 2)));
            } else if (this.aab.qX() != null) {
                if (bl.ac(this.DV.getPageActivity())) {
                    String postUrl = this.aab.qX().getPostUrl();
                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.fH()) {
                        com.baidu.tbadk.browser.f.u(this.DV.getPageActivity(), postUrl);
                    }
                }
            } else {
                this.DV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.DV.getPageActivity()).createFromThreadCfg(this.aab, null, com.baidu.tieba.card.au.Kd(), 18003, true, false, false).addFrom(getClass().getName())));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
