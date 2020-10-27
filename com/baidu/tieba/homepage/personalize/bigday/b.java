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
/* loaded from: classes22.dex */
public class b extends d implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.c ePL;
    private f.b ePM;
    private f.d ePN;
    private f.a ePO;
    private TbImageView jzI;
    private LottieAnimationView jzJ;
    private ImageView jzK;
    private TextView jzL;
    private com.baidu.tbadk.core.bigday.a jzM;
    private String jzN;
    private String jzO;
    private String jzP;
    private String jzQ;

    public b(Context context) {
        super(context);
        this.ePL = null;
        this.ePM = null;
        this.ePN = null;
        this.ePO = null;
        if (context != null) {
            this.jzN = context.getText(R.string.adp_pull_to_refresh).toString();
            this.jzO = context.getText(R.string.bigday_refreshing).toString();
            this.jzP = context.getText(R.string.bigday_release_to_refresh).toString();
            this.jzQ = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.ePL = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.ePM = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.ePN = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.ePO = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.jzI = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.jzJ = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.jzK = (ImageView) inflate.findViewById(R.id.text_mask);
        this.jzL = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.jzI.setAutoChangeStyle(false);
        this.jzL.setText(this.jzN);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.bho()) {
            this.jzM = aVar;
        }
        if (aVar.erQ == 1) {
            this.jzL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.jzK.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.jzJ.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.jzL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.jzK.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.jzJ.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.jzJ.setFrame(0);
        this.jzI.startLoad(aVar.imgUrl, 41, false);
        this.jzI.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.jzI.getBdImage() == null && b.this.jzM != null && !at.isEmpty(b.this.jzM.imgUrl)) {
                    b.this.jzI.startLoad(b.this.jzM.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cIQ() {
        return this.jzM;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.jzL.setText(this.jzN);
        if (this.ePN != null) {
            this.ePN.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.jzL.setText(this.jzP);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.jzL.setText(this.jzO);
        this.jzJ.setAlpha(1.0f);
        this.jzJ.setMinAndMaxFrame(8, 58);
        this.jzJ.loop(true);
        this.jzJ.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.ePL != null) {
            this.ePL.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.jzL.setText("");
        this.jzJ.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.jzJ.setAlpha(1.0f);
        this.jzL.setText(this.jzN);
        if (this.ePO != null) {
            this.ePO.bqm();
        }
        if (this.ePM != null) {
            this.ePM.onListPullRefreshFinished(getView(), z);
        }
        this.jzJ.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cIN() {
        this.jzL.setText(this.jzQ);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cIO() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, false));
        this.jzL.animate().alpha(0.0f).setDuration(200L).start();
        this.jzK.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cIP() {
        if (this.jzM != null && this.jzM.bho()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.jzM.imgUrl, this.jzM.aHs, this.jzM.erR)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cIM() {
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
            this.jzJ.setProgress(f3);
            return;
        }
        this.jzJ.setAlpha(1.0f - ((f4 - dimension2) / (cIM() - dimension2)));
    }

    private void setAlpha(float f) {
        this.jzL.setAlpha(f);
        this.jzK.setAlpha(f);
        if (this.jzK.getBackground() == null && this.jzM != null) {
            if (this.jzM.erQ == 1) {
                this.jzK.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.jzK.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
