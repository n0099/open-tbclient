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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class m extends l {
    private TextView dMJ;
    private View dMK;
    private TbImageView dML;
    private TextView dMM;
    private ArrayList<String> dMN;
    private View.OnClickListener dMO;
    private TbImageView.b mOnDrawListener;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dMN = new ArrayList<>();
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.m.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.a.a gP = com.baidu.tbadk.imageManager.c.Mx().gP(com.baidu.adp.lib.f.c.nm().g(tbImageView.getUrl(), m.this.aZj ? 13 : 14));
                    if (gP != null) {
                        int width = gP.getWidth();
                        i = gP.getHeight();
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
        this.dMO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.D(m.this.dMN) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                        String str = (String) m.this.dMN.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = m.this.aZj ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig createConfig = new ImageViewerConfig(m.this.mPageContext.getPageActivity()).createConfig(m.this.dMN, 0, "", "", "", m.this.aZj, str, false, concurrentHashMap, false);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
                        createConfig.setIsShowHost(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(m.this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
                }
            }
        };
        View view = getView();
        if (view != null) {
            ((ViewStub) view.findViewById(d.g.viewstub_interview_live_info)).inflate();
            View findViewById = view.findViewById(d.g.text_interview_live);
            if (findViewById instanceof TextView) {
                this.dMJ = (TextView) findViewById;
            }
            this.dMK = ((ViewStub) view.findViewById(d.g.viewstub_img_interview_live)).inflate();
            View findViewById2 = view.findViewById(d.g.img_interview_live);
            if (findViewById2 instanceof TbImageView) {
                this.dML = (TbImageView) findViewById2;
                this.dML.setPageId(bdUniqueId);
            }
            View findViewById3 = view.findViewById(d.g.interview_live_tip);
            if (findViewById3 instanceof TextView) {
                this.dMM = (TextView) findViewById3;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.l, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        if (bdVar != null && this.dMK != null && this.dML != null && this.cXd != null) {
            if (bdVar.zy() != null) {
                bdVar.zy().clear();
            }
            bdVar.a((SparseArray<String>) null);
            bb yV = bdVar.yV();
            if (yV != null) {
                super.a(bdVar);
                if (com.baidu.tbadk.core.i.xo().xu() && yV != null && !StringUtils.isNull(yV.getThreadImgUrl())) {
                    this.dMN.clear();
                    this.dMN.add(yV.getThreadImgUrl());
                    this.dMK.setVisibility(0);
                    this.dML.setSupportNoImage(true);
                    this.dML.setScaleType(ImageView.ScaleType.MATRIX);
                    this.dML.setOnDrawListener(this.mOnDrawListener);
                    this.dML.startLoad(yV.getThreadImgUrl(), this.aZj ? 13 : 14, false);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dMK.getLayoutParams();
                    layoutParams.width = com.baidu.adp.lib.util.l.ao(getContext()) - com.baidu.adp.lib.util.l.t(getContext(), d.e.ds68);
                    layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
                    this.dMK.setLayoutParams(layoutParams);
                } else {
                    this.dMK.setVisibility(8);
                }
                this.dML.setOnClickListener(this.dMO);
                this.cXd.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.l, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            aj.r(this.dMJ, d.C0140d.cp_cont_f);
            aj.r(this.dMM, d.C0140d.cp_cont_i);
        }
        super.d(tbPageContext, i);
    }

    public void gf(boolean z) {
        if (this.bQA != null) {
            this.bQA.setVisibility(z ? 0 : 8);
        }
    }
}
