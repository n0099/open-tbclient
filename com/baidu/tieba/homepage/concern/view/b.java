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
    private boolean aiG;
    private final View.OnClickListener anJ;
    private final View.OnClickListener anr;
    private View.OnClickListener bJA;
    private HeadPendantClickableView bJv;
    private View bJy;
    private l bJz;
    public PlayVoiceBntNew bLr;
    private TextView bLt;
    private ConstrainImageGroup bLu;
    private final View.OnClickListener bLv;
    public ThreadCommentAndPraiseInfoLayout bnj;
    protected LinearLayout bnn;
    public ConcernThreadUserInfoLayout cWD;
    private View cWG;
    private TbPageContext<?> mG;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiG = true;
        this.bJA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Xr() != null) {
                    b.this.Xr().a(view, b.this.bJz);
                }
                b.this.XJ();
            }
        };
        this.bLv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<l> Xr = b.this.Xr();
                if (Xr != null) {
                    view.setTag("2");
                    Xr.a(view, b.this.bJz);
                }
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Xr() != null) {
                    b.this.Xr().a(view, b.this.bJz);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Xr() != null) {
                    b.this.Xr().a(view, b.this.bJz);
                }
            }
        };
        View view = getView();
        this.mG = tbPageContext;
        this.bJv = (HeadPendantClickableView) view.findViewById(d.h.card_concern_normal_thread_user_pendant_header);
        if (this.bJv.getHeadView() != null) {
            this.bJv.getHeadView().setIsRound(true);
            this.bJv.getHeadView().setDrawBorder(false);
            this.bJv.getHeadView().setDefaultResource(17170445);
            this.bJv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJv.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds60));
        }
        if (this.bJv.getPendantView() != null) {
            this.bJv.getPendantView().setIsRound(true);
            this.bJv.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_normal_thread_title);
        this.bLr = (PlayVoiceBntNew) view.findViewById(d.h.card_concern_normal_thread_abstract_voice);
        this.bLr.setAfterClickListener(this.bLv);
        this.bLt = (TextView) view.findViewById(d.h.card_concern_normal_thread_abstract);
        this.bLt.setVisibility(8);
        this.bLu = (ConstrainImageGroup) view.findViewById(d.h.card_concern_normal_thread_img_layout);
        this.bJy = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bLu.setChildClickListener(this.bJA);
        this.bLu.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLu.setImageProcessor(fVar);
        this.bnj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_normal_thread_info_layout);
        this.cWD = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_normal_thread_user_info_layout);
        if (this.bnj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bnj.setLayoutParams(layoutParams);
        }
        this.bnj.setOnClickListener(this.bJA);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setIsBarViewVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setNeedAddReplyIcon(true);
        this.bnj.setShareVisible(true);
        this.bnj.setShareReportFrom(4);
        this.bnj.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.Xr() != null) {
                    b.this.Xr().a(view2, b.this.bJz);
                }
            }
        });
        this.bnn = (LinearLayout) view.findViewById(d.h.card_concern_normal_thread_content_layout);
        this.cWG = view.findViewById(d.h.no_image_divider_line);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLu != null) {
            this.bLu.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLu != null) {
            this.bLu.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.k(this.cWG, d.e.cp_bg_line_e);
            this.bLu.onChangeSkinType();
            this.bnj.onChangeSkinType();
            this.cWD.onChangeSkinType();
            aj.k(this.bJy, d.e.cp_bg_line_e);
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
        this.bJz = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJA);
        }
        this.cWD.setData(lVar.threadData);
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        if (!Xv() && m.jn(this.bJz.threadData.getId())) {
            m.a(this.mTitle, this.bJz.Nj().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLt, this.bJz.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cWD.setUserAfterClickListener(this.anJ);
        this.bnj.setData(lVar.threadData);
        final bh Nj = lVar.Nj();
        if (this.cWD.getHeaderImg() != null) {
            if (this.cWD.getIsSimpleThread()) {
                this.cWD.getHeaderImg().setVisibility(8);
                this.bJv.setVisibility(8);
            } else if (Nj.getAuthor() == null || Nj.getAuthor().getPendantData() == null || StringUtils.isNull(Nj.getAuthor().getPendantData().pS())) {
                this.bJv.setVisibility(8);
                this.cWD.getHeaderImg().setVisibility(0);
                this.cWD.getHeaderImg().setData(Nj);
            } else {
                this.cWD.getHeaderImg().setVisibility(4);
            }
        }
        y(Nj);
        ArrayList<VoiceData.VoiceModel> rJ = lVar.threadData.rJ();
        if (v.u(rJ)) {
            this.bLr.setVisibility(8);
            dB(false);
            z = false;
        } else {
            this.bLr.setVisibility(0);
            dB(true);
            VoiceData.VoiceModel voiceModel = rJ.get(0);
            this.bLr.setVoiceModel(voiceModel);
            this.bLr.setTag(voiceModel);
            this.bLr.bgh();
            if (voiceModel != null) {
                this.bLr.nh(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bJz.bNG && z) {
            this.bLu.setVisibility(8);
            this.cWG.setVisibility(0);
        } else {
            ArrayList<MediaData> rF = lVar.threadData.rF();
            if (h.oT().oZ() && v.t(rF) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < rF.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(rF, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.t(linkedList) > 0) {
                    this.bLu.setVisibility(0);
                    this.cWG.setVisibility(8);
                    this.bLu.setFromCDN(this.aiG);
                    this.bLu.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            x<l> Xr = b.this.Xr();
                            if (Xr != null) {
                                view.setTag("1");
                                Xr.a(view, b.this.bJz);
                            }
                            if (z2) {
                                b.this.XJ();
                            } else {
                                b.this.a(view, linkedList, i2, Nj);
                            }
                        }
                    });
                    this.bLu.setImageMediaList(linkedList);
                } else {
                    this.bLu.setVisibility(8);
                    this.cWG.setVisibility(0);
                }
            } else {
                this.bLu.setVisibility(8);
                this.cWG.setVisibility(0);
            }
        }
        XI();
        setPageUniqueId(getTag());
        XK();
    }

    private void dB(boolean z) {
        if (this.bLu != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLu.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10);
            }
            this.bLu.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mG.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aiG ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mG.getPageActivity()).createConfig(arrayList, i, bhVar.rA(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiG, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void XI() {
        if (!this.bJz.aCa) {
            this.bLr.setClickable(false);
        } else {
            this.bLr.setClickable(true);
        }
        int childCount = this.bLu.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLu.getChildAt(i);
            if (childAt != null) {
                if (!this.bJz.aCa) {
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
        if (this.bLu != null) {
            this.bLu.setPageUniqueId(bdUniqueId);
        }
        if (this.cWD != null) {
            this.cWD.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cWD != null) {
            return this.cWD.getHeaderImg();
        }
        return null;
    }

    public View Xu() {
        if (this.cWD != null) {
            return this.cWD.anF;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XJ() {
        if (this.bJz != null && this.bJz.threadData != null) {
            if (!Xv()) {
                m.jm(this.bJz.threadData.getId());
                m.a(this.mTitle, this.bJz.Nj().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bLt, this.bJz.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mG.getPageActivity()).createCfgForPersonCenter(this.bJz.threadData.getId(), this.bJz.threadData.rL(), m.rm(), 18005)));
        }
    }

    private boolean Xv() {
        return this.bJz.bNG && !this.bJz.aCa;
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

    private void XK() {
        if (this.mTitle != null && this.bLr != null && this.bLu != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bLr.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds24);
            this.bLr.setLayoutParams(layoutParams);
            if (this.bLr.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bLu.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds10);
                this.bLu.setLayoutParams(layoutParams2);
            }
        }
    }
}
