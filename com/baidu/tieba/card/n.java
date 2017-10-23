package com.baidu.tieba.card;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class n extends a<com.baidu.tieba.card.data.l> {
    private boolean aiu;
    private String ane;
    private final View.OnClickListener anf;
    private final View.OnClickListener anx;
    private HeadPendantClickableView bJj;
    private ThreadGodReplyLayout bJk;
    private com.baidu.tieba.NEGFeedBack.c bJl;
    private View bJm;
    private com.baidu.tieba.card.data.l bJn;
    private View.OnClickListener bJo;
    private View.OnClickListener bKn;
    public PlayVoiceBntNew bLf;
    private View bLg;
    private TextView bLh;
    private ConstrainImageGroup bLi;
    private final View.OnClickListener bLj;
    public ThreadUserInfoLayout bmR;
    public ThreadCommentAndPraiseInfoLayout bmV;
    protected LinearLayout bmZ;
    private TbPageContext<?> mH;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJl = null;
        this.mSkinType = 3;
        this.aiu = true;
        this.bJo = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.Xn() != null) {
                    n.this.Xn().a(view, n.this.bJn);
                }
                n.this.dz(view == n.this.bJk);
            }
        };
        this.bLj = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Xn = n.this.Xn();
                if (Xn != null) {
                    view.setTag("2");
                    Xn.a(view, n.this.bJn);
                }
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.Xn() != null) {
                    n.this.Xn().a(view, n.this.bJn);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.Xn() != null) {
                    n.this.Xn().a(view, n.this.bJn);
                }
            }
        };
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.bJn != null && !StringUtils.isNull(n.this.bJn.threadData.rt())) {
                    String rt = n.this.bJn.threadData.rt();
                    if (!StringUtils.isNull(n.this.mStType) && !StringUtils.isNull(n.this.ane)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createCfgForpersonalized(rt, n.this.mStType, n.this.ane)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(rt, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                    if (n.this.anf != null) {
                        n.this.anf.onClick(view);
                    }
                }
            }
        };
        View view = getView();
        this.mH = tbPageContext;
        this.bJj = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
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
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLf = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLf.setAfterClickListener(this.bLj);
        this.bLh = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLh.setVisibility(8);
        this.bLi = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bJm = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bLi.setChildClickListener(this.bJo);
        this.bLi.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLi.setImageProcessor(fVar);
        this.bLg = view.findViewById(d.h.divider_line_above_praise);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bmR = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bJl = new com.baidu.tieba.NEGFeedBack.c(this.mH);
        this.bJl.Kl();
        this.bJl.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bmR.addView(this.bJl);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bmV.setOnClickListener(this.bJo);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(true);
        this.bmV.setShareVisible(true);
        this.bmV.setFrom(1);
        this.bmV.setShareReportFrom(3);
        this.bmV.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.Xn() != null) {
                    n.this.Xn().a(view2, n.this.bJn);
                }
            }
        });
        this.bmZ = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.bJk = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bJk.setOnClickListener(this.bJo);
    }

    public void setSingleImageRatio(double d) {
        if (this.bLi != null) {
            this.bLi.setSingleImageRatio(d);
        }
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
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.k(this.bLg, d.e.cp_bg_line_e);
            this.bLi.onChangeSkinType();
            this.bmV.onChangeSkinType();
            this.bJk.onChangeSkinType();
            this.bmR.onChangeSkinType();
            if (this.bJl != null) {
                this.bJl.onChangeSkinType();
            }
            aj.k(this.bJm, d.e.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        boolean z;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bJn = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJo);
        }
        if (this.bJl != null && this.bJn.Nd() != null) {
            al alVar = new al();
            alVar.cx(this.bJn.Nd().getTid());
            alVar.setFid(this.bJn.Nd().getFid());
            alVar.a(this.bJn.WU);
            this.bJl.setData(alVar);
            this.bJl.setFirstRowSingleColumn(true);
        }
        this.bmR.setData(lVar.threadData);
        this.bJk.setFromCDN(this.aiu);
        this.bJk.setData(lVar.threadData.sE());
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        this.bJk.onChangeSkinType();
        if (lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bJl.setVisibility(8);
            } else {
                this.bJl.setVisibility(0);
            }
        }
        if (!Xr() && m.jm(this.bJn.threadData.getId())) {
            m.a(this.mTitle, this.bJn.Nd().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLh, this.bJn.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJk.getGodReplyContent(), this.bJn.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bmR.setUserAfterClickListener(this.anx);
        this.bmV.setData(lVar.threadData);
        this.mStType = m.rf();
        this.ane = "feed#" + lVar.XQ();
        final bh Nd = lVar.Nd();
        if (this.bmR.getHeaderImg() != null) {
            if (this.bmR.getIsSimpleThread()) {
                this.bmR.getHeaderImg().setVisibility(8);
                this.bJj.setVisibility(8);
            } else if (Nd.getAuthor() == null || Nd.getAuthor().getPendantData() == null || StringUtils.isNull(Nd.getAuthor().getPendantData().pL())) {
                this.bJj.setVisibility(8);
                this.bmR.getHeaderImg().setVisibility(0);
                this.bmR.getHeaderImg().setData(Nd);
            } else {
                this.bmR.getHeaderImg().setVisibility(4);
                this.bJj.setVisibility(0);
                this.bJj.setData(Nd);
            }
        }
        y(Nd);
        ArrayList<VoiceData.VoiceModel> rC = lVar.threadData.rC();
        if (com.baidu.tbadk.core.util.v.u(rC)) {
            this.bLf.setVisibility(8);
            dA(false);
            z = false;
        } else {
            this.bLf.setVisibility(0);
            dA(true);
            VoiceData.VoiceModel voiceModel = rC.get(0);
            this.bLf.setVoiceModel(voiceModel);
            this.bLf.setTag(voiceModel);
            this.bLf.bgc();
            if (voiceModel != null) {
                this.bLf.ng(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bJn.bNu && z) {
            this.bLi.setVisibility(8);
        } else {
            ArrayList<MediaData> ry = Nd.ry();
            if (com.baidu.tbadk.core.h.oM().oS() && com.baidu.tbadk.core.util.v.t(ry) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < ry.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(ry, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.t(linkedList) > 0) {
                    this.bLi.setVisibility(0);
                    this.bLi.setFromCDN(this.aiu);
                    this.bLi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            x<com.baidu.tieba.card.data.l> Xn = n.this.Xn();
                            if (Xn != null) {
                                view.setTag("1");
                                Xn.a(view, n.this.bJn);
                            }
                            if (z2) {
                                n.this.XF();
                            } else {
                                n.this.a(view, linkedList, i2, Nd);
                            }
                        }
                    });
                    this.bLi.setImageMediaList(linkedList);
                } else {
                    this.bLi.setVisibility(8);
                }
            } else {
                this.bLi.setVisibility(8);
            }
        }
        XD();
        XE();
        setPageUniqueId(getTag());
        XG();
    }

    private void XD() {
        if (this.bLg != null && this.bLi != null && this.bJk != null) {
            if (this.bLi.getVisibility() == 8 && this.bJk.getVisibility() == 8) {
                this.bLg.setVisibility(0);
            } else {
                this.bLg.setVisibility(8);
            }
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

    private void dA(boolean z) {
        if (this.bLi != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLi.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10);
            }
            this.bLi.setLayoutParams(layoutParams);
        }
    }

    private void XE() {
        if (!this.bJn.aBN) {
            this.bLf.setClickable(false);
        } else {
            this.bLf.setClickable(true);
        }
        int childCount = this.bLi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLi.getChildAt(i);
            if (childAt != null) {
                if (!this.bJn.aBN) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiu = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bLi != null) {
            this.bLi.setPageUniqueId(bdUniqueId);
        }
        if (this.bJl != null) {
            this.bJl.setUniqueId(bdUniqueId);
        }
        if (this.bmR != null) {
            this.bmR.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.bJl != null) {
            this.bJl.setEventCallback(aVar);
        }
    }

    public View Xp() {
        return this.bJk;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bmR != null) {
            return this.bmR.ans;
        }
        return null;
    }

    public View Xq() {
        if (this.bmR != null) {
            return this.bmR.ant;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XF() {
        dz(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dz(boolean z) {
        if (this.bJn != null && this.bJn.threadData != null) {
            if (!Xr()) {
                m.jl(this.bJn.threadData.getId());
                m.a(this.mTitle, this.bJn.Nd().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bLh, this.bJn.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bJk.getGodReplyContent(), this.bJn.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mH.getPageActivity()).createFromThreadCfg(this.bJn.threadData, null, m.rf(), 18003, true, false, false).addLocateParam(this.bJn.XR());
            addLocateParam.setForumId(String.valueOf(this.bJn.threadData.getFid()));
            addLocateParam.setForumName(this.bJn.threadData.rt());
            if (this.bJn.bNb == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bJn.bNb);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xr() {
        return this.bJn.bNu && !this.bJn.aBN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean y(bh bhVar) {
        SpannableStringBuilder g = bhVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            m.a(this.mTitle, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        return true;
    }

    private void XG() {
        if (this.mTitle != null && this.bLf != null && this.bLi != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bLf.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds24);
            this.bLf.setLayoutParams(layoutParams);
            if (this.bLf.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bLi.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds24);
                this.bLi.setLayoutParams(layoutParams2);
            }
        }
    }
}
