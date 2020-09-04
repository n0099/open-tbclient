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
    private f.c eta;
    private f.b etb;
    private f.d etd;
    private f.a ete;
    private TbImageView iPD;
    private LottieAnimationView iPE;
    private ImageView iPF;
    private TextView iPG;
    private com.baidu.tbadk.core.bigday.a iPH;
    private String iPI;
    private String iPJ;
    private String iPK;
    private String iPL;

    public b(Context context) {
        super(context);
        this.eta = null;
        this.etb = null;
        this.etd = null;
        this.ete = null;
        if (context != null) {
            this.iPI = context.getText(R.string.adp_pull_to_refresh).toString();
            this.iPJ = context.getText(R.string.bigday_refreshing).toString();
            this.iPK = context.getText(R.string.bigday_release_to_refresh).toString();
            this.iPL = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.eta = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.etb = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.etd = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.ete = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.iPD = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.iPE = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.iPF = (ImageView) inflate.findViewById(R.id.text_mask);
        this.iPG = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.iPD.setAutoChangeStyle(false);
        this.iPG.setText(this.iPI);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.bbT()) {
            this.iPH = aVar;
        }
        if (aVar.dVf == 1) {
            this.iPG.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.iPF.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.iPE.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.iPG.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.iPF.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.iPE.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.iPE.setFrame(0);
        this.iPD.startLoad(aVar.imgUrl, 41, false);
        this.iPD.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.iPD.getBdImage() == null && b.this.iPH != null && !at.isEmpty(b.this.iPH.imgUrl)) {
                    b.this.iPD.startLoad(b.this.iPH.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cyt() {
        return this.iPH;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.iPG.setText(this.iPI);
        if (this.etd != null) {
            this.etd.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.iPG.setText(this.iPK);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.iPG.setText(this.iPJ);
        this.iPE.setAlpha(1.0f);
        this.iPE.setMinAndMaxFrame(8, 58);
        this.iPE.loop(true);
        this.iPE.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.eta != null) {
            this.eta.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.iPG.setText("");
        this.iPE.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.iPE.setAlpha(1.0f);
        this.iPG.setText(this.iPI);
        if (this.ete != null) {
            this.ete.bkO();
        }
        if (this.etb != null) {
            this.etb.onListPullRefreshFinished(getView(), z);
        }
        this.iPE.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cyq() {
        this.iPG.setText(this.iPL);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cyr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.iPG.animate().alpha(0.0f).setDuration(200L).start();
        this.iPF.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cys() {
        if (this.iPH != null && this.iPH.bbT()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.iPH.imgUrl, this.iPH.aDi, this.iPH.dVg)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cyp() {
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
            this.iPE.setProgress(f3);
            return;
        }
        this.iPE.setAlpha(1.0f - ((f4 - dimension2) / (cyp() - dimension2)));
    }

    private void setAlpha(float f) {
        this.iPG.setAlpha(f);
        this.iPF.setAlpha(f);
        if (this.iPF.getBackground() == null && this.iPH != null) {
            if (this.iPH.dVf == 1) {
                this.iPF.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.iPF.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
