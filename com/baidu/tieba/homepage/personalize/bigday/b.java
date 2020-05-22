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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes9.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.c dVt;
    private f.b dVu;
    private f.d dVv;
    private f.a dVw;
    private TbImageView ieB;
    private LottieAnimationView ieC;
    private ImageView ieD;
    private TextView ieE;
    private com.baidu.tbadk.core.bigday.a ieF;
    private String ieG;
    private String ieH;
    private String ieI;
    private String ieJ;

    public b(Context context) {
        super(context);
        this.dVt = null;
        this.dVu = null;
        this.dVv = null;
        this.dVw = null;
        if (context != null) {
            this.ieG = context.getText(R.string.adp_pull_to_refresh).toString();
            this.ieH = context.getText(R.string.bigday_refreshing).toString();
            this.ieI = context.getText(R.string.bigday_release_to_refresh).toString();
            this.ieJ = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.dVt = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.dVu = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.dVv = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.dVw = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.ieB = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.ieC = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.ieD = (ImageView) inflate.findViewById(R.id.text_mask);
        this.ieE = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.ieB.setAutoChangeStyle(false);
        this.ieE.setText(this.ieG);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.aNX()) {
            this.ieF = aVar;
        }
        if (aVar.dzo == 1) {
            this.ieE.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.ieD.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.ieC.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.ieE.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.ieD.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.ieC.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.ieC.setFrame(0);
        this.ieB.startLoad(aVar.imgUrl, 41, false);
        this.ieB.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.ieB.getBdImage() == null && b.this.ieF != null && !aq.isEmpty(b.this.ieF.imgUrl)) {
                    b.this.ieB.startLoad(b.this.ieF.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cgo() {
        return this.ieF;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.ieE.setText(this.ieG);
        if (this.dVv != null) {
            this.dVv.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.ieE.setText(this.ieI);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.ieE.setText(this.ieH);
        this.ieC.setAlpha(1.0f);
        this.ieC.setMinAndMaxFrame(8, 58);
        this.ieC.loop(true);
        this.ieC.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.dVt != null) {
            this.dVt.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.ieE.setText("");
        this.ieC.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.ieC.setAlpha(1.0f);
        this.ieE.setText(this.ieG);
        if (this.dVw != null) {
            this.dVw.aWz();
        }
        if (this.dVu != null) {
            this.dVu.onListPullRefreshFinished(getView(), z);
        }
        this.ieC.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cgl() {
        this.ieE.setText(this.ieJ);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cgm() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.ieE.animate().alpha(0.0f).setDuration(200L).start();
        this.ieD.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cgn() {
        if (this.ieF != null && this.ieF.aNX()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.ieF.imgUrl, this.ieF.auL, this.ieF.dzp)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cgk() {
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
            this.ieC.setProgress(f3);
            return;
        }
        this.ieC.setAlpha(1.0f - ((f4 - dimension2) / (cgk() - dimension2)));
    }

    private void setAlpha(float f) {
        this.ieE.setAlpha(f);
        this.ieD.setAlpha(f);
        if (this.ieD.getBackground() == null && this.ieF != null) {
            if (this.ieF.dzo == 1) {
                this.ieD.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.ieD.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
