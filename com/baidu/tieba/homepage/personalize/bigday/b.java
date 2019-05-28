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
    private h.c bZA;
    private h.b bZB;
    private h.d bZC;
    private h.a bZD;
    private TbImageView gdT;
    private LottieAnimationView gdU;
    private ImageView gdV;
    private TextView gdW;
    private com.baidu.tbadk.core.bigday.a gdX;
    private String gdY;
    private String gdZ;
    private String gea;
    private String geb;

    public b(Context context) {
        super(context);
        this.bZA = null;
        this.bZB = null;
        this.bZC = null;
        this.bZD = null;
        if (context != null) {
            this.gdY = context.getText(R.string.adp_pull_to_refresh).toString();
            this.gdZ = context.getText(R.string.bigday_refreshing).toString();
            this.gea = context.getText(R.string.bigday_release_to_refresh).toString();
            this.geb = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(h.c cVar) {
        this.bZA = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.b bVar) {
        this.bZB = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.d dVar) {
        this.bZC = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.a aVar) {
        this.bZD = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nG() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.gdT = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.gdU = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.gdV = (ImageView) inflate.findViewById(R.id.text_mask);
        this.gdW = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.gdT.setAutoChangeStyle(false);
        this.gdW.setText(this.gdY);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.abo()) {
            this.gdX = aVar;
        }
        if (aVar.bCQ == 1) {
            this.gdW.setTextColor(getContext().getResources().getColor(R.color.cp_btn_a));
            this.gdV.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.gdU.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.gdW.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.gdV.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.gdU.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.gdU.setFrame(0);
        this.gdT.startLoad(aVar.imgUrl, 41, false);
        this.gdT.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.gdT.getBdImage() == null && b.this.gdX != null && !ap.isEmpty(b.this.gdX.imgUrl)) {
                    b.this.gdT.startLoad(b.this.gdX.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a buv() {
        return this.gdX;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ao(boolean z) {
        setAlpha(1.0f);
        this.gdW.setText(this.gdY);
        if (this.bZC != null) {
            this.bZC.eo(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.gdW.setText(this.gea);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.gdW.setText(this.gdZ);
        this.gdU.setAlpha(1.0f);
        this.gdU.setMinAndMaxFrame(8, 58);
        this.gdU.y(true);
        this.gdU.bo();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aq(boolean z) {
        if (this.bZA != null) {
            this.bZA.en(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nH() {
        this.gdW.setText("");
        this.gdU.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ap(boolean z) {
        setAlpha(1.0f);
        this.gdU.setAlpha(1.0f);
        this.gdW.setText(this.gdY);
        if (this.bZD != null) {
            this.bZD.ajP();
        }
        if (this.bZB != null) {
            this.bZB.f(getView(), z);
        }
        this.gdU.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bus() {
        this.gdW.setText(this.geb);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void but() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.gdW.animate().alpha(0.0f).setDuration(200L).start();
        this.gdV.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void buu() {
        if (this.gdX != null && this.gdX.abo()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.gdX.imgUrl, this.gdX.bCP, this.gdX.bCR)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bur() {
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
            this.gdU.setProgress(f3);
            return;
        }
        this.gdU.setAlpha(1.0f - ((f4 - dimension2) / (bur() - dimension2)));
    }

    private void setAlpha(float f) {
        this.gdW.setAlpha(f);
        this.gdV.setAlpha(f);
        if (this.gdV.getBackground() == null && this.gdX != null) {
            if (this.gdX.bCQ == 1) {
                this.gdV.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.gdV.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
