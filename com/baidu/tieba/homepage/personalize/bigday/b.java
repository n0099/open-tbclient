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
/* loaded from: classes21.dex */
public class b extends d implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.c evf;
    private f.b evg;
    private f.d evh;
    private f.a evi;
    private TbImageView iYj;
    private LottieAnimationView iYk;
    private ImageView iYl;
    private TextView iYm;
    private com.baidu.tbadk.core.bigday.a iYn;
    private String iYo;
    private String iYp;
    private String iYq;
    private String iYr;

    public b(Context context) {
        super(context);
        this.evf = null;
        this.evg = null;
        this.evh = null;
        this.evi = null;
        if (context != null) {
            this.iYo = context.getText(R.string.adp_pull_to_refresh).toString();
            this.iYp = context.getText(R.string.bigday_refreshing).toString();
            this.iYq = context.getText(R.string.bigday_release_to_refresh).toString();
            this.iYr = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.evf = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.evg = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.evh = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.evi = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.iYj = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.iYk = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.iYl = (ImageView) inflate.findViewById(R.id.text_mask);
        this.iYm = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.iYj.setAutoChangeStyle(false);
        this.iYm.setText(this.iYo);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.bcN()) {
            this.iYn = aVar;
        }
        if (aVar.dXp == 1) {
            this.iYm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.iYl.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.iYk.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.iYm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.iYl.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.iYk.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.iYk.setFrame(0);
        this.iYj.startLoad(aVar.imgUrl, 41, false);
        this.iYj.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.iYj.getBdImage() == null && b.this.iYn != null && !at.isEmpty(b.this.iYn.imgUrl)) {
                    b.this.iYj.startLoad(b.this.iYn.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cCa() {
        return this.iYn;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.iYm.setText(this.iYo);
        if (this.evh != null) {
            this.evh.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.iYm.setText(this.iYq);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.iYm.setText(this.iYp);
        this.iYk.setAlpha(1.0f);
        this.iYk.setMinAndMaxFrame(8, 58);
        this.iYk.loop(true);
        this.iYk.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.evf != null) {
            this.evf.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.iYm.setText("");
        this.iYk.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.iYk.setAlpha(1.0f);
        this.iYm.setText(this.iYo);
        if (this.evi != null) {
            this.evi.blJ();
        }
        if (this.evg != null) {
            this.evg.onListPullRefreshFinished(getView(), z);
        }
        this.iYk.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cBX() {
        this.iYm.setText(this.iYr);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cBY() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.iYm.animate().alpha(0.0f).setDuration(200L).start();
        this.iYl.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cBZ() {
        if (this.iYn != null && this.iYn.bcN()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.iYn.imgUrl, this.iYn.aEb, this.iYn.dXq)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cBW() {
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
            this.iYk.setProgress(f3);
            return;
        }
        this.iYk.setAlpha(1.0f - ((f4 - dimension2) / (cBW() - dimension2)));
    }

    private void setAlpha(float f) {
        this.iYm.setAlpha(f);
        this.iYl.setAlpha(f);
        if (this.iYl.getBackground() == null && this.iYn != null) {
            if (this.iYn.dXp == 1) {
                this.iYl.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.iYl.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
