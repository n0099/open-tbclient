package com.baidu.tieba.homepage.concern.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class f extends d {
    private boolean aET;
    private ConstrainImageGroup cYB;
    private final View.OnClickListener cYE;
    public PlayVoiceBntNew cYy;
    private View euN;
    private ConcernVideoImageView evb;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aET = true;
        this.cYE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.homepage.concern.b.b> aqp = f.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, f.this.euV);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void aA(View view) {
        if (view != null) {
            this.cYy = (PlayVoiceBntNew) view.findViewById(e.g.card_recommend_god_therad_voice);
            this.cYy.setAfterClickListener(this.cYE);
            this.cYB = (ConstrainImageGroup) view.findViewById(e.g.card_recommend_god_therad_img_layout);
            this.evb = (ConcernVideoImageView) view.findViewById(e.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
            this.cYB.setChildClickListener(this.euY);
            this.cYB.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
            eVar.g(1.0d);
            this.cYB.setImageProcessor(eVar);
            this.euN = view.findViewById(e.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.cYB != null) {
            this.cYB.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYB != null) {
            this.cYB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYB != null) {
            this.cYB.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cYB.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ag(bb bbVar) {
        if (bbVar == null || bbVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.ccw.setVisibility(8);
            ((LinearLayout.LayoutParams) this.euU.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(e.C0210e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.euY);
        }
        this.ccw.setVisibility(0);
        ArrayList<MediaData> Ae = bbVar.Ae();
        int H = v.H(Ae);
        if (!this.euW) {
            StringBuilder sb = new StringBuilder();
            if (bbVar.getAbstract() != null && !StringUtils.isNull(bbVar.getAbstract())) {
                sb.append(bbVar.getAbstract());
            }
            if (Ae != null && H > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < H; i++) {
                    if (Ae.get(i).getVideoUrl() != null && Ae.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(Ae.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bbVar.o(sb.toString(), true))) {
                    SpannableString ex = bbVar.ex(sb.toString());
                    this.mTitle.setOnTouchListener(new k(ex));
                    this.mTitle.setText(ex);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> Ai = bbVar.Ai();
        if (v.I(Ai)) {
            this.cYy.setVisibility(8);
        } else {
            this.cYy.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Ai.get(0);
            this.cYy.setVoiceModel(voiceModel);
            this.cYy.setTag(voiceModel);
            this.cYy.aXt();
            if (voiceModel != null) {
                this.cYy.qK(voiceModel.voice_status.intValue());
            }
        }
        if (i.xR().xV() && H > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < H; i2++) {
                MediaData mediaData = (MediaData) v.d(Ae, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (v.H(linkedList) > 0) {
                this.euN.setVisibility(8);
                this.cYB.setVisibility(0);
                this.evb.setVisibility(8);
                this.cYB.setFromCDN(this.aET);
                this.cYB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i3, boolean z) {
                        ad<com.baidu.tieba.homepage.concern.b.b> aqp = f.this.aqp();
                        if (aqp != null) {
                            view.setTag("1");
                            aqp.a(view, f.this.euV);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.bOk);
                        } else {
                            f.this.aqJ();
                        }
                    }
                });
                this.cYB.setImageMediaList(linkedList);
            } else if (v.H(linkedList2) > 0) {
                this.cYB.setVisibility(8);
                this.evb.setVisibility(0);
                this.evb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.aqJ();
                    }
                });
                this.evb.setData(linkedList2);
                this.euN.setVisibility(0);
            } else {
                this.cYB.setVisibility(8);
            }
        } else {
            this.cYB.setVisibility(8);
            this.evb.setVisibility(8);
            this.euN.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aET ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bbVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zZ(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aET, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cYB != null) {
            this.cYB.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
