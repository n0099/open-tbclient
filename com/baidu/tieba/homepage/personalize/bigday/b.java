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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes16.dex */
public class b extends d implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.c esW;
    private f.b esX;
    private f.d esY;
    private f.a esZ;
    private TextView iPA;
    private com.baidu.tbadk.core.bigday.a iPB;
    private String iPC;
    private String iPD;
    private String iPE;
    private String iPF;
    private TbImageView iPx;
    private LottieAnimationView iPy;
    private ImageView iPz;

    public b(Context context) {
        super(context);
        this.esW = null;
        this.esX = null;
        this.esY = null;
        this.esZ = null;
        if (context != null) {
            this.iPC = context.getText(R.string.adp_pull_to_refresh).toString();
            this.iPD = context.getText(R.string.bigday_refreshing).toString();
            this.iPE = context.getText(R.string.bigday_release_to_refresh).toString();
            this.iPF = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.esW = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.esX = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.esY = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.esZ = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.iPx = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.iPy = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.iPz = (ImageView) inflate.findViewById(R.id.text_mask);
        this.iPA = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.iPx.setAutoChangeStyle(false);
        this.iPA.setText(this.iPC);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.bbT()) {
            this.iPB = aVar;
        }
        if (aVar.dVb == 1) {
            this.iPA.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.iPz.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.iPy.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.iPA.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.iPz.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.iPy.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.iPy.setFrame(0);
        this.iPx.startLoad(aVar.imgUrl, 41, false);
        this.iPx.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.iPx.getBdImage() == null && b.this.iPB != null && !at.isEmpty(b.this.iPB.imgUrl)) {
                    b.this.iPx.startLoad(b.this.iPB.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cys() {
        return this.iPB;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.iPA.setText(this.iPC);
        if (this.esY != null) {
            this.esY.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.iPA.setText(this.iPE);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.iPA.setText(this.iPD);
        this.iPy.setAlpha(1.0f);
        this.iPy.setMinAndMaxFrame(8, 58);
        this.iPy.loop(true);
        this.iPy.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.esW != null) {
            this.esW.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.iPA.setText("");
        this.iPy.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.iPy.setAlpha(1.0f);
        this.iPA.setText(this.iPC);
        if (this.esZ != null) {
            this.esZ.bkO();
        }
        if (this.esX != null) {
            this.esX.onListPullRefreshFinished(getView(), z);
        }
        this.iPy.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cyp() {
        this.iPA.setText(this.iPF);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cyq() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.iPA.animate().alpha(0.0f).setDuration(200L).start();
        this.iPz.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cyr() {
        if (this.iPB != null && this.iPB.bbT()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.iPB.imgUrl, this.iPB.aDg, this.iPB.dVc)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cyo() {
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
            this.iPy.setProgress(f3);
            return;
        }
        this.iPy.setAlpha(1.0f - ((f4 - dimension2) / (cyo() - dimension2)));
    }

    private void setAlpha(float f) {
        this.iPA.setAlpha(f);
        this.iPz.setAlpha(f);
        if (this.iPz.getBackground() == null && this.iPB != null) {
            if (this.iPB.dVb == 1) {
                this.iPz.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.iPz.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
