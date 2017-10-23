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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class f extends d {
    private boolean aiu;
    public PlayVoiceBntNew bLf;
    private ConstrainImageGroup bLi;
    private final View.OnClickListener bLj;
    private View cWu;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aiu = true;
        this.bLj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.homepage.concern.b.b> Xn = f.this.Xn();
                if (Xn != null) {
                    view.setTag("2");
                    Xn.a(view, f.this.cWB);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void aa(View view) {
        if (view != null) {
            this.bLf = (PlayVoiceBntNew) view.findViewById(d.h.card_recommend_god_therad_voice);
            this.bLf.setAfterClickListener(this.bLj);
            this.bLi = (ConstrainImageGroup) view.findViewById(d.h.card_recommend_god_therad_img_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
            this.bLi.setChildClickListener(this.cWE);
            this.bLi.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
            fVar.e(1.0d);
            this.bLi.setImageProcessor(fVar);
            this.cWu = view.findViewById(d.h.no_image_divider_line);
        }
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

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bLi.onChangeSkinType();
        aj.k(this.cWu, d.e.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void Q(bh bhVar) {
        ArrayList<MediaData> arrayList;
        int i;
        if (bhVar == null || bhVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.bmZ.setVisibility(8);
            ((LinearLayout.LayoutParams) this.cWA.getLayoutParams()).bottomMargin = (int) this.mH.getResources().getDimension(d.f.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cWE);
        }
        this.bmZ.setVisibility(0);
        if (this.cWC) {
            arrayList = null;
            i = 0;
        } else {
            StringBuilder sb = new StringBuilder();
            if (bhVar.rw() != null && !StringUtils.isNull(bhVar.rw())) {
                sb.append(bhVar.rw());
            }
            arrayList = bhVar.ry();
            if (arrayList != null) {
                i = arrayList.size();
                StringBuilder sb2 = new StringBuilder();
                for (int i2 = 0; i2 < i; i2++) {
                    if (arrayList.get(i2).getVideoUrl() != null && arrayList.get(i2).getVideoUrl().endsWith("swf")) {
                        sb2.append(arrayList.get(i2).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bhVar.g(sb.toString(), true))) {
                    SpannableString cD = bhVar.cD(sb.toString());
                    this.mTitle.setOnTouchListener(new k(cD));
                    this.mTitle.setText(cD);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
                i = 0;
            }
        }
        ArrayList<VoiceData.VoiceModel> rC = bhVar.rC();
        if (v.u(rC)) {
            this.bLf.setVisibility(8);
        } else {
            this.bLf.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rC.get(0);
            this.bLf.setVoiceModel(voiceModel);
            this.bLf.setTag(voiceModel);
            this.bLf.bgc();
            if (voiceModel != null) {
                this.bLf.ng(voiceModel.voice_status.intValue());
            }
        }
        if (h.oM().oS() && v.t(arrayList) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) v.c(arrayList, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.t(linkedList) > 0) {
                this.bLi.setVisibility(0);
                this.cWu.setVisibility(8);
                this.bLi.setFromCDN(this.aiu);
                this.bLi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i4, boolean z) {
                        x<com.baidu.tieba.homepage.concern.b.b> Xn = f.this.Xn();
                        if (Xn != null) {
                            view.setTag("1");
                            Xn.a(view, f.this.cWB);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i4, f.this.bie);
                        } else {
                            f.this.XF();
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
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mH.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
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

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bLi != null) {
            this.bLi.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
