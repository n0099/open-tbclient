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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes7.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private g.c dcC;
    private g.b dcD;
    private g.d dcE;
    private g.a dcF;
    private ImageView hcA;
    private TextView hcB;
    private com.baidu.tbadk.core.bigday.a hcC;
    private String hcD;
    private String hcE;
    private String hcF;
    private String hcG;
    private TbImageView hcy;
    private LottieAnimationView hcz;

    public b(Context context) {
        super(context);
        this.dcC = null;
        this.dcD = null;
        this.dcE = null;
        this.dcF = null;
        if (context != null) {
            this.hcD = context.getText(R.string.adp_pull_to_refresh).toString();
            this.hcE = context.getText(R.string.bigday_refreshing).toString();
            this.hcF = context.getText(R.string.bigday_release_to_refresh).toString();
            this.hcG = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(g.c cVar) {
        this.dcC = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.dcD = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.d dVar) {
        this.dcE = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.dcF = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.hcy = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.hcz = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.hcA = (ImageView) inflate.findViewById(R.id.text_mask);
        this.hcB = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.hcy.setAutoChangeStyle(false);
        this.hcB.setText(this.hcD);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.axF()) {
            this.hcC = aVar;
        }
        if (aVar.cHO == 1) {
            this.hcB.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.hcA.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.hcz.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.hcB.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.hcA.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.hcz.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.hcz.setFrame(0);
        this.hcy.startLoad(aVar.imgUrl, 41, false);
        this.hcy.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.hcy.getBdImage() == null && b.this.hcC != null && !aq.isEmpty(b.this.hcC.imgUrl)) {
                    b.this.hcy.startLoad(b.this.hcC.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bNA() {
        return this.hcC;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.hcB.setText(this.hcD);
        if (this.dcE != null) {
            this.dcE.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.hcB.setText(this.hcF);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.hcB.setText(this.hcE);
        this.hcz.setAlpha(1.0f);
        this.hcz.setMinAndMaxFrame(8, 58);
        this.hcz.loop(true);
        this.hcz.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.dcC != null) {
            this.dcC.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.hcB.setText("");
        this.hcz.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.hcz.setAlpha(1.0f);
        this.hcB.setText(this.hcD);
        if (this.dcF != null) {
            this.dcF.aFG();
        }
        if (this.dcD != null) {
            this.dcD.onListPullRefreshFinished(getView(), z);
        }
        this.hcz.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bNx() {
        this.hcB.setText(this.hcG);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bNy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.hcB.animate().alpha(0.0f).setDuration(200L).start();
        this.hcA.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bNz() {
        if (this.hcC != null && this.hcC.axF()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.hcC.imgUrl, this.hcC.cHN, this.hcC.cHP)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bNw() {
        return (int) (l.getEquipmentHeight(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        float f3 = 0.0f;
        super.onPullPercentChange(f, f2);
        float dimension = getView().getResources().getDimension(R.dimen.tbds120);
        float dimension2 = getView().getResources().getDimension(R.dimen.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.hcz.setProgress(f3);
            return;
        }
        this.hcz.setAlpha(1.0f - ((f4 - dimension2) / (bNw() - dimension2)));
    }

    private void setAlpha(float f) {
        this.hcB.setAlpha(f);
        this.hcA.setAlpha(f);
        if (this.hcA.getBackground() == null && this.hcC != null) {
            if (this.hcC.cHO == 1) {
                this.hcA.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.hcA.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
