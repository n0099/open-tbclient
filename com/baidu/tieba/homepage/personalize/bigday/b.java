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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes9.dex */
public class b extends d implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.c ecS;
    private f.b ecT;
    private f.d ecU;
    private f.a ecV;
    private LottieAnimationView iuA;
    private ImageView iuB;
    private TextView iuC;
    private com.baidu.tbadk.core.bigday.a iuD;
    private String iuE;
    private String iuF;
    private String iuG;
    private String iuH;
    private TbImageView iuz;

    public b(Context context) {
        super(context);
        this.ecS = null;
        this.ecT = null;
        this.ecU = null;
        this.ecV = null;
        if (context != null) {
            this.iuE = context.getText(R.string.adp_pull_to_refresh).toString();
            this.iuF = context.getText(R.string.bigday_refreshing).toString();
            this.iuG = context.getText(R.string.bigday_release_to_refresh).toString();
            this.iuH = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.ecS = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.ecT = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.ecU = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.ecV = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.iuz = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.iuA = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.iuB = (ImageView) inflate.findViewById(R.id.text_mask);
        this.iuC = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.iuz.setAutoChangeStyle(false);
        this.iuC.setText(this.iuE);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.aPH()) {
            this.iuD = aVar;
        }
        if (aVar.dFH == 1) {
            this.iuC.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.iuB.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.iuA.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.iuC.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.iuB.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.iuA.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.iuA.setFrame(0);
        this.iuz.startLoad(aVar.imgUrl, 41, false);
        this.iuz.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.iuz.getBdImage() == null && b.this.iuD != null && !ar.isEmpty(b.this.iuD.imgUrl)) {
                    b.this.iuz.startLoad(b.this.iuD.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cjX() {
        return this.iuD;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.iuC.setText(this.iuE);
        if (this.ecU != null) {
            this.ecU.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.iuC.setText(this.iuG);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.iuC.setText(this.iuF);
        this.iuA.setAlpha(1.0f);
        this.iuA.setMinAndMaxFrame(8, 58);
        this.iuA.loop(true);
        this.iuA.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.ecS != null) {
            this.ecS.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.iuC.setText("");
        this.iuA.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.iuA.setAlpha(1.0f);
        this.iuC.setText(this.iuE);
        if (this.ecV != null) {
            this.ecV.aYs();
        }
        if (this.ecT != null) {
            this.ecT.onListPullRefreshFinished(getView(), z);
        }
        this.iuA.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cjU() {
        this.iuC.setText(this.iuH);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cjV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.iuC.animate().alpha(0.0f).setDuration(200L).start();
        this.iuB.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cjW() {
        if (this.iuD != null && this.iuD.aPH()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.iuD.imgUrl, this.iuD.awR, this.iuD.dFI)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cjT() {
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
            this.iuA.setProgress(f3);
            return;
        }
        this.iuA.setAlpha(1.0f - ((f4 - dimension2) / (cjT() - dimension2)));
    }

    private void setAlpha(float f) {
        this.iuC.setAlpha(f);
        this.iuB.setAlpha(f);
        if (this.iuB.getBackground() == null && this.iuD != null) {
            if (this.iuD.dFH == 1) {
                this.iuB.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.iuB.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
