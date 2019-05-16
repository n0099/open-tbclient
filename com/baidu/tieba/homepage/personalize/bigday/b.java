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
    private TbImageView gdS;
    private LottieAnimationView gdT;
    private ImageView gdU;
    private TextView gdV;
    private com.baidu.tbadk.core.bigday.a gdW;
    private String gdX;
    private String gdY;
    private String gdZ;
    private String gea;

    public b(Context context) {
        super(context);
        this.bZA = null;
        this.bZB = null;
        this.bZC = null;
        this.bZD = null;
        if (context != null) {
            this.gdX = context.getText(R.string.adp_pull_to_refresh).toString();
            this.gdY = context.getText(R.string.bigday_refreshing).toString();
            this.gdZ = context.getText(R.string.bigday_release_to_refresh).toString();
            this.gea = context.getText(R.string.bigday_release_to_ad).toString();
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
        this.gdS = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.gdT = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.gdU = (ImageView) inflate.findViewById(R.id.text_mask);
        this.gdV = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.gdS.setAutoChangeStyle(false);
        this.gdV.setText(this.gdX);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.abo()) {
            this.gdW = aVar;
        }
        if (aVar.bCQ == 1) {
            this.gdV.setTextColor(getContext().getResources().getColor(R.color.cp_btn_a));
            this.gdU.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.gdT.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.gdV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.gdU.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.gdT.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.gdT.setFrame(0);
        this.gdS.startLoad(aVar.imgUrl, 41, false);
        this.gdS.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.gdS.getBdImage() == null && b.this.gdW != null && !ap.isEmpty(b.this.gdW.imgUrl)) {
                    b.this.gdS.startLoad(b.this.gdW.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bus() {
        return this.gdW;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ao(boolean z) {
        setAlpha(1.0f);
        this.gdV.setText(this.gdX);
        if (this.bZC != null) {
            this.bZC.eo(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.gdV.setText(this.gdZ);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.gdV.setText(this.gdY);
        this.gdT.setAlpha(1.0f);
        this.gdT.setMinAndMaxFrame(8, 58);
        this.gdT.y(true);
        this.gdT.bo();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aq(boolean z) {
        if (this.bZA != null) {
            this.bZA.en(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nH() {
        this.gdV.setText("");
        this.gdT.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ap(boolean z) {
        setAlpha(1.0f);
        this.gdT.setAlpha(1.0f);
        this.gdV.setText(this.gdX);
        if (this.bZD != null) {
            this.bZD.ajP();
        }
        if (this.bZB != null) {
            this.bZB.f(getView(), z);
        }
        this.gdT.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bup() {
        this.gdV.setText(this.gea);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void buq() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.gdV.animate().alpha(0.0f).setDuration(200L).start();
        this.gdU.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bur() {
        if (this.gdW != null && this.gdW.abo()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.gdW.imgUrl, this.gdW.bCP, this.gdW.bCR)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int buo() {
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
            this.gdT.setProgress(f3);
            return;
        }
        this.gdT.setAlpha(1.0f - ((f4 - dimension2) / (buo() - dimension2)));
    }

    private void setAlpha(float f) {
        this.gdV.setAlpha(f);
        this.gdU.setAlpha(f);
        if (this.gdU.getBackground() == null && this.gdW != null) {
            if (this.gdW.bCQ == 1) {
                this.gdU.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.gdU.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
