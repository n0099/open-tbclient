package com.baidu.tieba.homepage.concern.view;

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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<l> {
    private boolean aiu;
    private final View.OnClickListener anf;
    private final View.OnClickListener anx;
    private HeadPendantClickableView bJj;
    private View bJm;
    private l bJn;
    private View.OnClickListener bJo;
    public PlayVoiceBntNew bLf;
    private TextView bLh;
    private ConstrainImageGroup bLi;
    private final View.OnClickListener bLj;
    public ThreadCommentAndPraiseInfoLayout bmV;
    protected LinearLayout bmZ;
    public ConcernThreadUserInfoLayout cWr;
    private View cWu;
    private TbPageContext<?> mH;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiu = true;
        this.bJo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Xn() != null) {
                    b.this.Xn().a(view, b.this.bJn);
                }
                b.this.XF();
            }
        };
        this.bLj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<l> Xn = b.this.Xn();
                if (Xn != null) {
                    view.setTag("2");
                    Xn.a(view, b.this.bJn);
                }
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Xn() != null) {
                    b.this.Xn().a(view, b.this.bJn);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Xn() != null) {
                    b.this.Xn().a(view, b.this.bJn);
                }
            }
        };
        View view = getView();
        this.mH = tbPageContext;
        this.bJj = (HeadPendantClickableView) view.findViewById(d.h.card_concern_normal_thread_user_pendant_header);
        if (this.bJj.getHeadView() != null) {
            this.bJj.getHeadView().setIsRound(true);
            this.bJj.getHeadView().setDrawBorder(false);
            this.bJj.getHeadView().setDefaultResource(17170445);
            this.bJj.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJj.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJj.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds60));
        }
        if (this.bJj.getPendantView() != null) {
            this.bJj.getPendantView().setIsRound(true);
            this.bJj.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_normal_thread_title);
        this.bLf = (PlayVoiceBntNew) view.findViewById(d.h.card_concern_normal_thread_abstract_voice);
        this.bLf.setAfterClickListener(this.bLj);
        this.bLh = (TextView) view.findViewById(d.h.card_concern_normal_thread_abstract);
        this.bLh.setVisibility(8);
        this.bLi = (ConstrainImageGroup) view.findViewById(d.h.card_concern_normal_thread_img_layout);
        this.bJm = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bLi.setChildClickListener(this.bJo);
        this.bLi.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLi.setImageProcessor(fVar);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_normal_thread_info_layout);
        this.cWr = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_normal_thread_user_info_layout);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bmV.setOnClickListener(this.bJo);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setIsBarViewVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(true);
        this.bmV.setShareVisible(true);
        this.bmV.setShareReportFrom(4);
        this.bmV.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.Xn() != null) {
                    b.this.Xn().a(view2, b.this.bJn);
                }
            }
        });
        this.bmZ = (LinearLayout) view.findViewById(d.h.card_concern_normal_thread_content_layout);
        this.cWu = view.findViewById(d.h.no_image_divider_line);
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
            aj.k(this.cWu, d.e.cp_bg_line_e);
            this.bLi.onChangeSkinType();
            this.bmV.onChangeSkinType();
            this.cWr.onChangeSkinType();
            aj.k(this.bJm, d.e.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_concern_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
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
        this.cWr.setData(lVar.threadData);
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        if (!Xr() && m.jm(this.bJn.threadData.getId())) {
            m.a(this.mTitle, this.bJn.Nd().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLh, this.bJn.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cWr.setUserAfterClickListener(this.anx);
        this.bmV.setData(lVar.threadData);
        final bh Nd = lVar.Nd();
        if (this.cWr.getHeaderImg() != null) {
            if (this.cWr.getIsSimpleThread()) {
                this.cWr.getHeaderImg().setVisibility(8);
                this.bJj.setVisibility(8);
            } else if (Nd.getAuthor() == null || Nd.getAuthor().getPendantData() == null || StringUtils.isNull(Nd.getAuthor().getPendantData().pL())) {
                this.bJj.setVisibility(8);
                this.cWr.getHeaderImg().setVisibility(0);
                this.cWr.getHeaderImg().setData(Nd);
            } else {
                this.cWr.getHeaderImg().setVisibility(4);
            }
        }
        y(Nd);
        ArrayList<VoiceData.VoiceModel> rC = lVar.threadData.rC();
        if (v.u(rC)) {
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
            this.cWu.setVisibility(0);
        } else {
            ArrayList<MediaData> ry = lVar.threadData.ry();
            if (h.oM().oS() && v.t(ry) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < ry.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(ry, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.t(linkedList) > 0) {
                    this.bLi.setVisibility(0);
                    this.cWu.setVisibility(8);
                    this.bLi.setFromCDN(this.aiu);
                    this.bLi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            x<l> Xn = b.this.Xn();
                            if (Xn != null) {
                                view.setTag("1");
                                Xn.a(view, b.this.bJn);
                            }
                            if (z2) {
                                b.this.XF();
                            } else {
                                b.this.a(view, linkedList, i2, Nd);
                            }
                        }
                    });
                    this.bLi.setImageMediaList(linkedList);
                } else {
                    this.bLi.setVisibility(8);
                    this.cWu.setVisibility(0);
                }
            } else {
                this.bLi.setVisibility(8);
                this.cWu.setVisibility(0);
            }
        }
        XE();
        setPageUniqueId(getTag());
        XG();
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
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
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
        if (this.cWr != null) {
            this.cWr.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cWr != null) {
            return this.cWr.getHeaderImg();
        }
        return null;
    }

    public View Xq() {
        if (this.cWr != null) {
            return this.cWr.ant;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XF() {
        if (this.bJn != null && this.bJn.threadData != null) {
            if (!Xr()) {
                m.jl(this.bJn.threadData.getId());
                m.a(this.mTitle, this.bJn.Nd().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bLh, this.bJn.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mH.getPageActivity()).createCfgForPersonCenter(this.bJn.threadData.getId(), this.bJn.threadData.rE(), m.rf(), 18005)));
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
            this.mTitle.setOnTouchListener(new k(g));
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
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds10);
                this.bLi.setLayoutParams(layoutParams2);
            }
        }
    }
}
