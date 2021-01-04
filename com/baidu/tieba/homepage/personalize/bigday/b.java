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
    private f.c flR;
    private f.b flS;
    private f.d flT;
    private f.a flU;
    private String khA;
    private String khB;
    private String khC;
    private TbImageView khu;
    private LottieAnimationView khv;
    private ImageView khw;
    private TextView khx;
    private com.baidu.tbadk.core.bigday.a khy;
    private String khz;

    public b(Context context) {
        super(context);
        this.flR = null;
        this.flS = null;
        this.flT = null;
        this.flU = null;
        if (context != null) {
            this.khz = context.getText(R.string.adp_pull_to_refresh).toString();
            this.khA = context.getText(R.string.bigday_refreshing).toString();
            this.khB = context.getText(R.string.bigday_release_to_refresh).toString();
            this.khC = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.flR = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.flS = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.flT = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.flU = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.khu = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.khv = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.khw = (ImageView) inflate.findViewById(R.id.text_mask);
        this.khx = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.khu.setAutoChangeStyle(false);
        this.khx.setText(this.khz);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.boB()) {
            this.khy = aVar;
        }
        if (aVar.eME == 1) {
            this.khx.setTextColor(getContext().getResources().getColor(R.color.CAM_X0101));
            this.khw.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.khv.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.khx.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.khw.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.khv.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.khv.setFrame(0);
        this.khu.startLoad(aVar.imgUrl, 41, false);
        this.khu.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.khu.getBdImage() == null && b.this.khy != null && !at.isEmpty(b.this.khy.imgUrl)) {
                    b.this.khu.startLoad(b.this.khy.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cTs() {
        return this.khy;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.khx.setText(this.khz);
        if (this.flT != null) {
            this.flT.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.khx.setText(this.khB);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.khx.setText(this.khA);
        this.khv.setAlpha(1.0f);
        this.khv.setMinAndMaxFrame(8, 58);
        this.khv.loop(true);
        this.khv.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.flR != null) {
            this.flR.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.khx.setText("");
        this.khv.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.khv.setAlpha(1.0f);
        this.khx.setText(this.khz);
        if (this.flU != null) {
            this.flU.bxX();
        }
        if (this.flS != null) {
            this.flS.onListPullRefreshFinished(getView(), z);
        }
        this.khv.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cTp() {
        this.khx.setText(this.khC);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cTq() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, false));
        this.khx.animate().alpha(0.0f).setDuration(200L).start();
        this.khw.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cTr() {
        if (this.khy != null && this.khy.boB()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.khy.imgUrl, this.khy.aJH, this.khy.eMF)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cTo() {
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
            this.khv.setProgress(f3);
            return;
        }
        this.khv.setAlpha(1.0f - ((f4 - dimension2) / (cTo() - dimension2)));
    }

    private void setAlpha(float f) {
        this.khx.setAlpha(f);
        this.khw.setAlpha(f);
        if (this.khw.getBackground() == null && this.khy != null) {
            if (this.khy.eME == 1) {
                this.khw.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.khw.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
