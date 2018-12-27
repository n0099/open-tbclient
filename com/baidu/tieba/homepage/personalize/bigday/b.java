package com.baidu.tieba.homepage.personalize.bigday;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes6.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private j.b aIF;
    private j.a aIG;
    private j.c aIH;
    private TbImageView ezq;
    private LottieAnimationView ezr;
    private ImageView ezs;
    private TextView ezt;
    private com.baidu.tbadk.core.bigday.a ezu;
    private String ezv;
    private String ezw;
    private String ezx;
    private String ezy;

    public b(Context context) {
        super(context);
        this.aIF = null;
        this.aIG = null;
        this.aIH = null;
        if (context != null) {
            this.ezv = context.getText(e.j.adp_pull_to_refresh).toString();
            this.ezw = context.getText(e.j.bigday_refreshing).toString();
            this.ezx = context.getText(e.j.bigday_release_to_refresh).toString();
            this.ezy = context.getText(e.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.b bVar) {
        this.aIF = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.a aVar) {
        this.aIG = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.c cVar) {
        this.aIH = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oD() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.bigday_pull_view, (ViewGroup) null, false);
        this.ezq = (TbImageView) inflate.findViewById(e.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(e.g.bigday_close);
        this.ezr = (LottieAnimationView) inflate.findViewById(e.g.bigday_lotti);
        this.ezs = (ImageView) inflate.findViewById(e.g.text_mask);
        this.ezt = (TextView) inflate.findViewById(e.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds25));
        }
        this.ezq.setAutoChangeStyle(false);
        this.ezt.setText(this.ezv);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.xR()) {
            this.ezu = aVar;
        }
        if (aVar.aov == 1) {
            this.ezt.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha60));
            this.ezs.setBackgroundResource(e.f.bigday_text_mask_black);
            this.ezr.setAnimation(e.i.lottie_refresh_light);
        } else {
            this.ezt.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b_alpha40));
            this.ezs.setBackgroundResource(e.f.bigday_text_mask_white);
            this.ezr.setAnimation(e.i.lottie_refresh_dark);
        }
        this.ezr.setFrame(0);
        this.ezq.startLoad(aVar.imgUrl, 41, false);
        this.ezq.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.ezq.getBdImage() == null && b.this.ezu != null && !ao.isEmpty(b.this.ezu.imgUrl)) {
                    b.this.ezq.startLoad(b.this.ezu.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a aMk() {
        return this.ezu;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        setAlpha(1.0f);
        this.ezt.setText(this.ezv);
        if (this.aIH != null) {
            this.aIH.bI(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.ezt.setText(this.ezx);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.ezt.setText(this.ezw);
        this.ezr.setAlpha(1.0f);
        this.ezr.setMinAndMaxFrame(8, 58);
        this.ezr.G(true);
        this.ezr.cv();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        if (this.aIF != null) {
            this.aIF.bH(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oE() {
        this.ezt.setText("");
        this.ezr.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        setAlpha(1.0f);
        this.ezr.setAlpha(1.0f);
        this.ezt.setText(this.ezv);
        if (this.aIG != null) {
            this.aIG.b(getView(), z);
        }
        this.ezr.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aMh() {
        this.ezt.setText(this.ezy);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aMi() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.ezt.animate().alpha(0.0f).setDuration(200L).start();
        this.ezs.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aMj() {
        if (this.ezu != null && this.ezu.xR()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.ezu.imgUrl, this.ezu.aou, this.ezu.aow)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int aMg() {
        return (int) (l.aQ(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
        float f3 = 0.0f;
        super.n(f, f2);
        float dimension = getView().getResources().getDimension(e.C0210e.tbds120);
        float dimension2 = getView().getResources().getDimension(e.C0210e.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.ezr.setProgress(f3);
            return;
        }
        this.ezr.setAlpha(1.0f - ((f4 - dimension2) / (aMg() - dimension2)));
    }

    private void setAlpha(float f) {
        this.ezt.setAlpha(f);
        this.ezs.setAlpha(f);
        if (this.ezs.getBackground() == null && this.ezu != null) {
            if (this.ezu.aov == 1) {
                this.ezs.setBackgroundResource(e.f.bigday_text_mask_black);
            } else {
                this.ezs.setBackgroundResource(e.f.bigday_text_mask_white);
            }
        }
    }
}
