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
    private TbImageView iAF;
    private LottieAnimationView iAG;
    private ImageView iAH;
    private TextView iAI;
    private com.baidu.tbadk.core.bigday.a iAJ;
    private String iAK;
    private String iAL;
    private String iAM;
    private String iAN;

    public b(Context context) {
        super(context);
        this.ejc = null;
        this.ejd = null;
        this.eje = null;
        this.ejf = null;
        if (context != null) {
            this.iAK = context.getText(R.string.adp_pull_to_refresh).toString();
            this.iAL = context.getText(R.string.bigday_refreshing).toString();
            this.iAM = context.getText(R.string.bigday_release_to_refresh).toString();
            this.iAN = context.getText(R.string.bigday_release_to_ad).toString();
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
        this.iAF = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.iAG = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.iAH = (ImageView) inflate.findViewById(R.id.text_mask);
        this.iAI = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.iAF.setAutoChangeStyle(false);
        this.iAI.setText(this.iAK);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.aTC()) {
            this.iAJ = aVar;
        }
        if (aVar.dLS == 1) {
            this.iAI.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.iAH.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.iAG.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.iAI.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.iAH.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.iAG.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.iAG.setFrame(0);
        this.iAF.startLoad(aVar.imgUrl, 41, false);
        this.iAF.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.iAF.getBdImage() == null && b.this.iAJ != null && !as.isEmpty(b.this.iAJ.imgUrl)) {
                    b.this.iAF.startLoad(b.this.iAJ.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cnz() {
        return this.iAJ;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.iAI.setText(this.iAK);
        if (this.eje != null) {
            this.eje.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.iAI.setText(this.iAM);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.iAI.setText(this.iAL);
        this.iAG.setAlpha(1.0f);
        this.iAG.setMinAndMaxFrame(8, 58);
        this.iAG.loop(true);
        this.iAG.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.ejc != null) {
            this.ejc.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.iAI.setText("");
        this.iAG.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.iAG.setAlpha(1.0f);
        this.iAI.setText(this.iAK);
        if (this.ejf != null) {
            this.ejf.bcr();
        }
        if (this.ejd != null) {
            this.ejd.onListPullRefreshFinished(getView(), z);
        }
        this.iAG.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cnw() {
        this.iAI.setText(this.iAN);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cnx() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.iAI.animate().alpha(0.0f).setDuration(200L).start();
        this.iAH.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cny() {
        if (this.iAJ != null && this.iAJ.aTC()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.iAJ.imgUrl, this.iAJ.aye, this.iAJ.dLT)));
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
            this.iAG.setProgress(f3);
            return;
        }
        this.iAG.setAlpha(1.0f - ((f4 - dimension2) / (cnv() - dimension2)));
    }

    private void setAlpha(float f) {
        this.iAI.setAlpha(f);
        this.iAH.setAlpha(f);
        if (this.iAH.getBackground() == null && this.iAJ != null) {
            if (this.iAJ.dLS == 1) {
                this.iAH.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.iAH.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
