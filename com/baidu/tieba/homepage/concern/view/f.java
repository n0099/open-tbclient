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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class f extends d {
    private boolean aXt;
    private final View.OnClickListener cPC;
    public PlayVoiceBntNew cPw;
    private ConstrainImageGroup cPz;
    private View ebc;
    private ConcernVideoImageView ebq;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aXt = true;
        this.cPC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.homepage.concern.b.b> aiY = f.this.aiY();
                if (aiY != null) {
                    view.setTag("2");
                    aiY.a(view, f.this.ebk);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void bx(View view) {
        if (view != null) {
            this.cPw = (PlayVoiceBntNew) view.findViewById(d.g.card_recommend_god_therad_voice);
            this.cPw.setAfterClickListener(this.cPC);
            this.cPz = (ConstrainImageGroup) view.findViewById(d.g.card_recommend_god_therad_img_layout);
            this.ebq = (ConcernVideoImageView) view.findViewById(d.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            this.cPz.setChildClickListener(this.ebn);
            this.cPz.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
            fVar.f(1.0d);
            this.cPz.setImageProcessor(fVar);
            this.ebc = view.findViewById(d.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.cPz != null) {
            this.cPz.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cPz != null) {
            this.cPz.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cPz != null) {
            this.cPz.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cPz.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void U(be beVar) {
        if (beVar == null || beVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.cjA.setVisibility(8);
            ((LinearLayout.LayoutParams) this.ebj.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(d.e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ebn);
        }
        this.cjA.setVisibility(0);
        ArrayList<MediaData> zi = beVar.zi();
        int F = com.baidu.tbadk.core.util.v.F(zi);
        if (!this.ebl) {
            StringBuilder sb = new StringBuilder();
            if (beVar.getAbstract() != null && !StringUtils.isNull(beVar.getAbstract())) {
                sb.append(beVar.getAbstract());
            }
            if (zi != null && F > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < F; i++) {
                    if (zi.get(i).getVideoUrl() != null && zi.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(zi.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(beVar.g(sb.toString(), true))) {
                    SpannableString cQ = beVar.cQ(sb.toString());
                    this.mTitle.setOnTouchListener(new m(cQ));
                    this.mTitle.setText(cQ);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> zm = beVar.zm();
        if (com.baidu.tbadk.core.util.v.G(zm)) {
            this.cPw.setVisibility(8);
        } else {
            this.cPw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zm.get(0);
            this.cPw.setVoiceModel(voiceModel);
            this.cPw.setTag(voiceModel);
            this.cPw.btM();
            if (voiceModel != null) {
                this.cPw.qL(voiceModel.voice_status.intValue());
            }
        }
        if (i.wB().wH() && F > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < F; i2++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zi, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (com.baidu.tbadk.core.util.v.F(linkedList) > 0) {
                this.ebc.setVisibility(8);
                this.cPz.setVisibility(0);
                this.ebq.setVisibility(8);
                this.cPz.setFromCDN(this.aXt);
                this.cPz.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void f(View view, int i3, boolean z) {
                        v<com.baidu.tieba.homepage.concern.b.b> aiY = f.this.aiY();
                        if (aiY != null) {
                            view.setTag("1");
                            aiY.a(view, f.this.ebk);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.bXF);
                        } else {
                            f.this.ajs();
                        }
                    }
                });
                this.cPz.setImageMediaList(linkedList);
            } else if (com.baidu.tbadk.core.util.v.F(linkedList2) > 0) {
                this.cPz.setVisibility(8);
                this.ebq.setVisibility(0);
                this.ebq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.ajs();
                    }
                });
                this.ebq.setData(linkedList2);
                this.ebc.setVisibility(0);
            } else {
                this.cPz.setVisibility(8);
            }
        } else {
            this.cPz.setVisibility(8);
            this.ebq.setVisibility(8);
            this.ebc.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, be beVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aXt ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(beVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, beVar.zd(), String.valueOf(beVar.getFid()), beVar.getTid(), this.aXt, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cPz != null) {
            this.cPz.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
