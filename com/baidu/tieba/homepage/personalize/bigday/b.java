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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes4.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private h.c bZB;
    private h.b bZC;
    private h.d bZD;
    private h.a bZE;
    private TbImageView gdV;
    private LottieAnimationView gdW;
    private ImageView gdX;
    private TextView gdY;
    private com.baidu.tbadk.core.bigday.a gdZ;
    private String gea;
    private String geb;
    private String gec;
    private String ged;

    public b(Context context) {
        super(context);
        this.bZB = null;
        this.bZC = null;
        this.bZD = null;
        this.bZE = null;
        if (context != null) {
            this.gea = context.getText(R.string.adp_pull_to_refresh).toString();
            this.geb = context.getText(R.string.bigday_refreshing).toString();
            this.gec = context.getText(R.string.bigday_release_to_refresh).toString();
            this.ged = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(h.c cVar) {
        this.bZB = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.b bVar) {
        this.bZC = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.d dVar) {
        this.bZD = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.a aVar) {
        this.bZE = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nG() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.gdV = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.gdW = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.gdX = (ImageView) inflate.findViewById(R.id.text_mask);
        this.gdY = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.gdV.setAutoChangeStyle(false);
        this.gdY.setText(this.gea);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.abo()) {
            this.gdZ = aVar;
        }
        if (aVar.bCR == 1) {
            this.gdY.setTextColor(getContext().getResources().getColor(R.color.cp_btn_a));
            this.gdX.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.gdW.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.gdY.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.gdX.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.gdW.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.gdW.setFrame(0);
        this.gdV.startLoad(aVar.imgUrl, 41, false);
        this.gdV.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.gdV.getBdImage() == null && b.this.gdZ != null && !ap.isEmpty(b.this.gdZ.imgUrl)) {
                    b.this.gdV.startLoad(b.this.gdZ.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a buw() {
        return this.gdZ;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ao(boolean z) {
        setAlpha(1.0f);
        this.gdY.setText(this.gea);
        if (this.bZD != null) {
            this.bZD.eo(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.gdY.setText(this.gec);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.gdY.setText(this.geb);
        this.gdW.setAlpha(1.0f);
        this.gdW.setMinAndMaxFrame(8, 58);
        this.gdW.y(true);
        this.gdW.bo();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aq(boolean z) {
        if (this.bZB != null) {
            this.bZB.en(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nH() {
        this.gdY.setText("");
        this.gdW.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ap(boolean z) {
        setAlpha(1.0f);
        this.gdW.setAlpha(1.0f);
        this.gdY.setText(this.gea);
        if (this.bZE != null) {
            this.bZE.ajP();
        }
        if (this.bZC != null) {
            this.bZC.f(getView(), z);
        }
        this.gdW.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void but() {
        this.gdY.setText(this.ged);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void buu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.gdY.animate().alpha(0.0f).setDuration(200L).start();
        this.gdX.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void buv() {
        if (this.gdZ != null && this.gdZ.abo()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.gdZ.imgUrl, this.gdZ.bCQ, this.gdZ.bCS)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bus() {
        return (int) (l.ah(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
        float f3 = 0.0f;
        super.n(f, f2);
        float dimension = getView().getResources().getDimension(R.dimen.tbds120);
        float dimension2 = getView().getResources().getDimension(R.dimen.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.gdW.setProgress(f3);
            return;
        }
        this.gdW.setAlpha(1.0f - ((f4 - dimension2) / (bus() - dimension2)));
    }

    private void setAlpha(float f) {
        this.gdY.setAlpha(f);
        this.gdX.setAlpha(f);
        if (this.gdX.getBackground() == null && this.gdZ != null) {
            if (this.gdZ.bCR == 1) {
                this.gdX.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.gdX.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
