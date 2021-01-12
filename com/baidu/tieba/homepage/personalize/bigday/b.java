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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes2.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.c fhg;
    private f.b fhh;
    private f.d fhi;
    private f.a fhj;
    private TbImageView kcO;
    private LottieAnimationView kcP;
    private ImageView kcQ;
    private TextView kcR;
    private com.baidu.tbadk.core.bigday.a kcS;
    private String kcT;
    private String kcU;
    private String kcV;
    private String kcW;

    public b(Context context) {
        super(context);
        this.fhg = null;
        this.fhh = null;
        this.fhi = null;
        this.fhj = null;
        if (context != null) {
            this.kcT = context.getText(R.string.adp_pull_to_refresh).toString();
            this.kcU = context.getText(R.string.bigday_refreshing).toString();
            this.kcV = context.getText(R.string.bigday_release_to_refresh).toString();
            this.kcW = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.fhg = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.fhh = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.fhi = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.fhj = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.kcO = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.kcP = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.kcQ = (ImageView) inflate.findViewById(R.id.text_mask);
        this.kcR = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.kcO.setAutoChangeStyle(false);
        this.kcR.setText(this.kcT);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.bkI()) {
            this.kcS = aVar;
        }
        if (aVar.eHT == 1) {
            this.kcR.setTextColor(getContext().getResources().getColor(R.color.CAM_X0101));
            this.kcQ.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.kcP.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.kcR.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.kcQ.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.kcP.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.kcP.setFrame(0);
        this.kcO.startLoad(aVar.imgUrl, 41, false);
        this.kcO.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.kcO.getBdImage() == null && b.this.kcS != null && !at.isEmpty(b.this.kcS.imgUrl)) {
                    b.this.kcO.startLoad(b.this.kcS.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cPB() {
        return this.kcS;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.kcR.setText(this.kcT);
        if (this.fhi != null) {
            this.fhi.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.kcR.setText(this.kcV);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.kcR.setText(this.kcU);
        this.kcP.setAlpha(1.0f);
        this.kcP.setMinAndMaxFrame(8, 58);
        this.kcP.loop(true);
        this.kcP.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.fhg != null) {
            this.fhg.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.kcR.setText("");
        this.kcP.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.kcP.setAlpha(1.0f);
        this.kcR.setText(this.kcT);
        if (this.fhj != null) {
            this.fhj.bue();
        }
        if (this.fhh != null) {
            this.fhh.onListPullRefreshFinished(getView(), z);
        }
        this.kcP.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cPy() {
        this.kcR.setText(this.kcW);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cPz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, false));
        this.kcR.animate().alpha(0.0f).setDuration(200L).start();
        this.kcQ.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cPA() {
        if (this.kcS != null && this.kcS.bkI()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.kcS.imgUrl, this.kcS.aEU, this.kcS.eHU)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cPx() {
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
            this.kcP.setProgress(f3);
            return;
        }
        this.kcP.setAlpha(1.0f - ((f4 - dimension2) / (cPx() - dimension2)));
    }

    private void setAlpha(float f) {
        this.kcR.setAlpha(f);
        this.kcQ.setAlpha(f);
        if (this.kcQ.getBackground() == null && this.kcS != null) {
            if (this.kcS.eHT == 1) {
                this.kcQ.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.kcQ.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
