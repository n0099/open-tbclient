package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class f extends e {
    private TextView dfa;
    private View dfb;
    private TbImageView dfc;
    private TextView dfd;
    private ArrayList<String> dfe;
    private View.OnClickListener dff;
    private TbImageView.b mOnDrawListener;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dfe = new ArrayList<>();
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.f.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a gG = com.baidu.tbadk.imageManager.c.Fa().gG(com.baidu.adp.lib.f.c.fp().f(tbImageView.getUrl(), f.this.akC ? 13 : 14));
                    if (gG != null) {
                        int width = gG.getWidth();
                        i = gG.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f5 = height / i;
                                f2 = f5;
                                f3 = (width2 - (i2 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i2;
                                f = (height - (i * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        this.dff = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.v(f.this.dfe) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                        String str = (String) f.this.dfe.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = f.this.akC ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig createConfig = new ImageViewerConfig(f.this.mPageContext.getPageActivity()).createConfig(f.this.dfe, 0, "", "", "", f.this.akC, str, false, concurrentHashMap, false);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view2.getGlobalVisibleRect(rect);
                        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
                        createConfig.setIsShowHost(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
                        return;
                    }
                    l.showToast(f.this.mPageContext.getPageActivity(), d.k.plugin_image_viewer_install_error_tips);
                }
            }
        };
        View view2 = getView();
        if (view2 != null) {
            ((ViewStub) view2.findViewById(d.g.viewstub_interview_live_info)).inflate();
            View findViewById = view2.findViewById(d.g.text_interview_live);
            if (findViewById instanceof TextView) {
                this.dfa = (TextView) findViewById;
            }
            this.dfb = ((ViewStub) view2.findViewById(d.g.viewstub_img_interview_live)).inflate();
            View findViewById2 = view2.findViewById(d.g.img_interview_live);
            if (findViewById2 instanceof TbImageView) {
                this.dfc = (TbImageView) findViewById2;
                this.dfc.setPageId(bdUniqueId);
            }
            View findViewById3 = view2.findViewById(d.g.interview_live_tip);
            if (findViewById3 instanceof TextView) {
                this.dfd = (TextView) findViewById3;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        if (bdVar != null && this.dfb != null && this.dfc != null && this.coS != null) {
            if (bdVar.sa() != null) {
                bdVar.sa().clear();
            }
            bdVar.a((SparseArray<String>) null);
            bb rA = bdVar.rA();
            if (rA != null) {
                super.a(bdVar);
                if (com.baidu.tbadk.core.i.pY().qe() && rA != null && !StringUtils.isNull(rA.getThreadImgUrl())) {
                    this.dfe.clear();
                    this.dfe.add(rA.getThreadImgUrl());
                    this.dfb.setVisibility(0);
                    this.dfc.setSupportNoImage(true);
                    this.dfc.setScaleType(ImageView.ScaleType.MATRIX);
                    this.dfc.setOnDrawListener(this.mOnDrawListener);
                    this.dfc.startLoad(rA.getThreadImgUrl(), this.akC ? 13 : 14, false);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfb.getLayoutParams();
                    layoutParams.width = l.af(getContext()) - l.e(getContext(), d.e.ds68);
                    layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
                    this.dfb.setLayoutParams(layoutParams);
                } else {
                    this.dfb.setVisibility(8);
                }
                this.dfc.setOnClickListener(this.dff);
                this.coS.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            ak.h(this.dfa, d.C0126d.cp_cont_f);
            ak.h(this.dfd, d.C0126d.cp_cont_i);
        }
        super.d(tbPageContext, i);
    }

    public void fL(boolean z) {
        if (this.bam != null) {
            this.bam.setVisibility(z ? 0 : 8);
        }
    }
}
