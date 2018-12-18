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
    private j.b aIE;
    private j.a aIF;
    private j.c aIG;
    private TextView ewA;
    private com.baidu.tbadk.core.bigday.a ewB;
    private String ewC;
    private String ewD;
    private String ewE;
    private String ewF;
    private TbImageView ewx;
    private LottieAnimationView ewy;
    private ImageView ewz;

    public b(Context context) {
        super(context);
        this.aIE = null;
        this.aIF = null;
        this.aIG = null;
        if (context != null) {
            this.ewC = context.getText(e.j.adp_pull_to_refresh).toString();
            this.ewD = context.getText(e.j.bigday_refreshing).toString();
            this.ewE = context.getText(e.j.bigday_release_to_refresh).toString();
            this.ewF = context.getText(e.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.b bVar) {
        this.aIE = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.a aVar) {
        this.aIF = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.c cVar) {
        this.aIG = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oD() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.bigday_pull_view, (ViewGroup) null, false);
        this.ewx = (TbImageView) inflate.findViewById(e.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(e.g.bigday_close);
        this.ewy = (LottieAnimationView) inflate.findViewById(e.g.bigday_lotti);
        this.ewz = (ImageView) inflate.findViewById(e.g.text_mask);
        this.ewA = (TextView) inflate.findViewById(e.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds25));
        }
        this.ewx.setAutoChangeStyle(false);
        this.ewA.setText(this.ewC);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.xR()) {
            this.ewB = aVar;
        }
        if (aVar.aov == 1) {
            this.ewA.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha60));
            this.ewz.setBackgroundResource(e.f.bigday_text_mask_black);
            this.ewy.setAnimation(e.i.lottie_refresh_light);
        } else {
            this.ewA.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b_alpha40));
            this.ewz.setBackgroundResource(e.f.bigday_text_mask_white);
            this.ewy.setAnimation(e.i.lottie_refresh_dark);
        }
        this.ewy.setFrame(0);
        this.ewx.startLoad(aVar.imgUrl, 41, false);
        this.ewx.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.ewx.getBdImage() == null && b.this.ewB != null && !ao.isEmpty(b.this.ewB.imgUrl)) {
                    b.this.ewx.startLoad(b.this.ewB.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a aLw() {
        return this.ewB;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        setAlpha(1.0f);
        this.ewA.setText(this.ewC);
        if (this.aIG != null) {
            this.aIG.bI(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.ewA.setText(this.ewE);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.ewA.setText(this.ewD);
        this.ewy.setAlpha(1.0f);
        this.ewy.setMinAndMaxFrame(8, 58);
        this.ewy.G(true);
        this.ewy.cv();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        if (this.aIE != null) {
            this.aIE.bH(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oE() {
        this.ewA.setText("");
        this.ewy.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        setAlpha(1.0f);
        this.ewy.setAlpha(1.0f);
        this.ewA.setText(this.ewC);
        if (this.aIF != null) {
            this.aIF.b(getView(), z);
        }
        this.ewy.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aLt() {
        this.ewA.setText(this.ewF);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aLu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.ewA.animate().alpha(0.0f).setDuration(200L).start();
        this.ewz.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aLv() {
        if (this.ewB != null && this.ewB.xR()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.ewB.imgUrl, this.ewB.aou, this.ewB.aow)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int aLs() {
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
            this.ewy.setProgress(f3);
            return;
        }
        this.ewy.setAlpha(1.0f - ((f4 - dimension2) / (aLs() - dimension2)));
    }

    private void setAlpha(float f) {
        this.ewA.setAlpha(f);
        this.ewz.setAlpha(f);
        if (this.ewz.getBackground() == null && this.ewB != null) {
            if (this.ewB.aov == 1) {
                this.ewz.setBackgroundResource(e.f.bigday_text_mask_black);
            } else {
                this.ewz.setBackgroundResource(e.f.bigday_text_mask_white);
            }
        }
    }
}
