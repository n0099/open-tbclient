package com.baidu.tieba.homepage.concern.view;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<l> {
    private boolean ajf;
    private final View.OnClickListener aoe;
    private final View.OnClickListener aow;
    private HeadPendantClickableView bJq;
    private View bJu;
    private l bJv;
    private View.OnClickListener bJw;
    public PlayVoiceBntNew bLe;
    private TextView bLf;
    private ConstrainImageGroup bLg;
    private final View.OnClickListener bLh;
    protected LinearLayout blD;
    public ThreadCommentAndPraiseInfoLayout blz;
    public ConcernThreadUserInfoLayout cZf;
    private TbPageContext<?> mF;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajf = true;
        this.bJw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.XA() != null) {
                    b.this.XA().a(view, b.this.bJv);
                }
                b.this.XR();
            }
        };
        this.bLh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<l> XA = b.this.XA();
                if (XA != null) {
                    view.setTag("2");
                    XA.a(view, b.this.bJv);
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.XA() != null) {
                    b.this.XA().a(view, b.this.bJv);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.XA() != null) {
                    b.this.XA().a(view, b.this.bJv);
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.bJq = (HeadPendantClickableView) view.findViewById(d.h.card_concern_normal_thread_user_pendant_header);
        if (this.bJq.getHeadView() != null) {
            this.bJq.getHeadView().setIsRound(true);
            this.bJq.getHeadView().setDrawBorder(false);
            this.bJq.getHeadView().setDefaultResource(17170445);
            this.bJq.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJq.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJq.getHeadView().setRadius(k.g(this.mF.getPageActivity(), d.f.ds60));
        }
        if (this.bJq.getPendantView() != null) {
            this.bJq.getPendantView().setIsRound(true);
            this.bJq.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_normal_thread_title);
        this.bLe = (PlayVoiceBntNew) view.findViewById(d.h.card_concern_normal_thread_abstract_voice);
        this.bLe.setAfterClickListener(this.bLh);
        this.bLf = (TextView) view.findViewById(d.h.card_concern_normal_thread_abstract);
        this.bLf.setVisibility(8);
        this.bLg = (ConstrainImageGroup) view.findViewById(d.h.card_concern_normal_thread_img_layout);
        this.bJu = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bLg.setChildClickListener(this.bJw);
        this.bLg.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLg.setImageProcessor(fVar);
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_normal_thread_info_layout);
        this.cZf = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_normal_thread_user_info_layout);
        if (this.blz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.blz.setLayoutParams(layoutParams);
        }
        this.blz.setOnClickListener(this.bJw);
        this.blz.setReplyTimeVisible(false);
        this.blz.setIsBarViewVisible(false);
        this.blz.setShowPraiseNum(true);
        this.blz.setNeedAddPraiseIcon(true);
        this.blz.setNeedAddReplyIcon(true);
        this.blz.setShareVisible(true);
        this.blz.setShareReportFrom(4);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.XA() != null) {
                    b.this.XA().a(view2, b.this.bJv);
                }
            }
        });
        this.blD = (LinearLayout) view.findViewById(d.h.card_concern_normal_thread_content_layout);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLg != null) {
            this.bLg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLg != null) {
            this.bLg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bLg.onChangeSkinType();
            this.blz.onChangeSkinType();
            this.cZf.onChangeSkinType();
            aj.k(this.bJu, d.e.cp_bg_line_c);
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
        boolean z2 = true;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bJv = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJw);
        }
        this.cZf.c(lVar.threadData);
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (!XE() && m.jt(this.bJv.threadData.getId())) {
            m.a(this.mTitle, this.bJv.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLf, this.bJv.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cZf.setUserAfterClickListener(this.aow);
        this.blz.c(lVar.threadData);
        final bj MR = lVar.MR();
        if (this.cZf.getHeaderImg() != null) {
            if (this.cZf.getIsSimpleThread()) {
                this.cZf.getHeaderImg().setVisibility(8);
                this.bJq.setVisibility(8);
            } else if (MR.getAuthor() == null || MR.getAuthor().getPendantData() == null || StringUtils.isNull(MR.getAuthor().getPendantData().pR())) {
                this.bJq.setVisibility(8);
                this.cZf.getHeaderImg().setVisibility(0);
                this.cZf.getHeaderImg().setData(MR);
            } else {
                this.cZf.getHeaderImg().setVisibility(4);
            }
        }
        boolean D = D(MR);
        ArrayList<VoiceData.VoiceModel> rP = lVar.threadData.rP();
        if (v.v(rP)) {
            this.bLe.setVisibility(8);
            z = false;
        } else {
            this.bLe.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rP.get(0);
            this.bLe.setVoiceModel(voiceModel);
            this.bLe.setTag(voiceModel);
            this.bLe.bhr();
            if (voiceModel != null) {
                this.bLe.nj(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bJv.bNk && z) {
            this.bLg.setVisibility(8);
            z2 = false;
        } else {
            ArrayList<MediaData> rL = lVar.threadData.rL();
            if (h.oS().oY() && v.u(rL) != 0) {
                LinkedList linkedList = new LinkedList();
                final LinkedList linkedList2 = new LinkedList();
                for (int i = 0; i < rL.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(rL, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData.getThumbnails_url());
                        linkedList2.add(mediaData);
                    }
                }
                if (v.u(linkedList) > 0) {
                    this.bLg.setVisibility(0);
                    this.bLg.setFromCDN(this.ajf);
                    this.bLg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z3) {
                            x<l> XA = b.this.XA();
                            if (XA != null) {
                                view.setTag("1");
                                XA.a(view, b.this.bJv);
                            }
                            if (z3) {
                                b.this.XR();
                            } else {
                                b.this.a(linkedList2, i2, MR);
                            }
                        }
                    });
                    this.bLg.setImageUrls(linkedList);
                } else {
                    this.bLg.setVisibility(8);
                }
            } else {
                this.bLg.setVisibility(8);
            }
            z2 = false;
        }
        XQ();
        h(D, false, z2);
        setPageUniqueId(getTag());
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLf.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bLg.getLayoutParams();
        if (!z && z2) {
            layoutParams.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams2.topMargin = k.g(this.mContext, d.f.ds2);
            } else if (z) {
                layoutParams2.topMargin = 0;
            }
        } else if (z2) {
            layoutParams3.topMargin = k.g(this.mContext, d.f.ds13);
        } else if (z) {
            layoutParams3.topMargin = k.g(this.mContext, d.f.ds10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            k.showToast(this.mF.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajf ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bjVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mF.getPageActivity()).createConfig(arrayList, i, bjVar.rG(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.ajf, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void XQ() {
        if (!this.bJv.aCJ) {
            this.bLe.setClickable(false);
        } else {
            this.bLe.setClickable(true);
        }
        int childCount = this.bLg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLg.getChildAt(i);
            if (childAt != null) {
                if (!this.bJv.aCJ) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bLg != null) {
            this.bLg.setPageUniqueId(bdUniqueId);
        }
        if (this.cZf != null) {
            this.cZf.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cZf != null) {
            return this.cZf.getHeaderImg();
        }
        return null;
    }

    public View XD() {
        if (this.cZf != null) {
            return this.cZf.aos;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XR() {
        if (this.bJv != null && this.bJv.threadData != null) {
            if (!XE()) {
                m.js(this.bJv.threadData.getId());
                m.a(this.mTitle, this.bJv.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bLf, this.bJv.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mF.getPageActivity()).createCfgForPersonCenter(this.bJv.threadData.getId(), this.bJv.threadData.rR(), m.rs(), 18005)));
        }
    }

    private boolean XE() {
        return this.bJv.bNk && !this.bJv.aCJ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean D(bj bjVar) {
        SpannableStringBuilder g = bjVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(g));
            this.mTitle.setText(g);
            m.a(this.mTitle, bjVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        return true;
    }
}
