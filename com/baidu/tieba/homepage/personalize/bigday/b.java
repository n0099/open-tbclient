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
import com.baidu.adp.widget.ListView.d;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes16.dex */
public class b extends d implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.c ejc;
    private f.b ejd;
    private f.d eje;
    private f.a ejf;
    private TbImageView iAD;
    private LottieAnimationView iAE;
    private ImageView iAF;
    private TextView iAG;
    private com.baidu.tbadk.core.bigday.a iAH;
    private String iAI;
    private String iAJ;
    private String iAK;
    private String iAL;

    public b(Context context) {
        super(context);
        this.ejc = null;
        this.ejd = null;
        this.eje = null;
        this.ejf = null;
        if (context != null) {
            this.iAI = context.getText(R.string.adp_pull_to_refresh).toString();
            this.iAJ = context.getText(R.string.bigday_refreshing).toString();
            this.iAK = context.getText(R.string.bigday_release_to_refresh).toString();
            this.iAL = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.ejc = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.ejd = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.eje = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.ejf = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.iAD = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.iAE = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.iAF = (ImageView) inflate.findViewById(R.id.text_mask);
        this.iAG = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.iAD.setAutoChangeStyle(false);
        this.iAG.setText(this.iAI);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.aTC()) {
            this.iAH = aVar;
        }
        if (aVar.dLS == 1) {
            this.iAG.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.iAF.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.iAE.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.iAG.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.iAF.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.iAE.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.iAE.setFrame(0);
        this.iAD.startLoad(aVar.imgUrl, 41, false);
        this.iAD.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.iAD.getBdImage() == null && b.this.iAH != null && !as.isEmpty(b.this.iAH.imgUrl)) {
                    b.this.iAD.startLoad(b.this.iAH.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cnz() {
        return this.iAH;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.iAG.setText(this.iAI);
        if (this.eje != null) {
            this.eje.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.iAG.setText(this.iAK);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.iAG.setText(this.iAJ);
        this.iAE.setAlpha(1.0f);
        this.iAE.setMinAndMaxFrame(8, 58);
        this.iAE.loop(true);
        this.iAE.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.ejc != null) {
            this.ejc.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.iAG.setText("");
        this.iAE.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.iAE.setAlpha(1.0f);
        this.iAG.setText(this.iAI);
        if (this.ejf != null) {
            this.ejf.bcr();
        }
        if (this.ejd != null) {
            this.ejd.onListPullRefreshFinished(getView(), z);
        }
        this.iAE.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cnw() {
        this.iAG.setText(this.iAL);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cnx() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.iAG.animate().alpha(0.0f).setDuration(200L).start();
        this.iAF.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cny() {
        if (this.iAH != null && this.iAH.aTC()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.iAH.imgUrl, this.iAH.aye, this.iAH.dLT)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cnv() {
        return (int) (l.getEquipmentHeight(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
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
            this.iAE.setProgress(f3);
            return;
        }
        this.iAE.setAlpha(1.0f - ((f4 - dimension2) / (cnv() - dimension2)));
    }

    private void setAlpha(float f) {
        this.iAG.setAlpha(f);
        this.iAF.setAlpha(f);
        if (this.iAF.getBackground() == null && this.iAH != null) {
            if (this.iAH.dLS == 1) {
                this.iAF.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.iAF.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
