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
    private f.c eVA;
    private f.b eVB;
    private f.d eVC;
    private f.a eVD;
    private TbImageView jFF;
    private LottieAnimationView jFG;
    private ImageView jFH;
    private TextView jFI;
    private com.baidu.tbadk.core.bigday.a jFJ;
    private String jFK;
    private String jFL;
    private String jFM;
    private String jFN;

    public b(Context context) {
        super(context);
        this.eVA = null;
        this.eVB = null;
        this.eVC = null;
        this.eVD = null;
        if (context != null) {
            this.jFK = context.getText(R.string.adp_pull_to_refresh).toString();
            this.jFL = context.getText(R.string.bigday_refreshing).toString();
            this.jFM = context.getText(R.string.bigday_release_to_refresh).toString();
            this.jFN = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.eVA = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.eVB = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.eVC = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.eVD = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.jFF = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.jFG = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.jFH = (ImageView) inflate.findViewById(R.id.text_mask);
        this.jFI = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.jFF.setAutoChangeStyle(false);
        this.jFI.setText(this.jFK);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.bjO()) {
            this.jFJ = aVar;
        }
        if (aVar.exJ == 1) {
            this.jFI.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.jFH.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.jFG.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.jFI.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.jFH.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.jFG.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.jFG.setFrame(0);
        this.jFF.startLoad(aVar.imgUrl, 41, false);
        this.jFF.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.jFF.getBdImage() == null && b.this.jFJ != null && !at.isEmpty(b.this.jFJ.imgUrl)) {
                    b.this.jFF.startLoad(b.this.jFJ.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cLr() {
        return this.jFJ;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.jFI.setText(this.jFK);
        if (this.eVC != null) {
            this.eVC.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.jFI.setText(this.jFM);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.jFI.setText(this.jFL);
        this.jFG.setAlpha(1.0f);
        this.jFG.setMinAndMaxFrame(8, 58);
        this.jFG.loop(true);
        this.jFG.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.eVA != null) {
            this.eVA.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.jFI.setText("");
        this.jFG.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.jFG.setAlpha(1.0f);
        this.jFI.setText(this.jFK);
        if (this.eVD != null) {
            this.eVD.bsM();
        }
        if (this.eVB != null) {
            this.eVB.onListPullRefreshFinished(getView(), z);
        }
        this.jFG.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cLo() {
        this.jFI.setText(this.jFN);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cLp() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, false));
        this.jFI.animate().alpha(0.0f).setDuration(200L).start();
        this.jFH.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cLq() {
        if (this.jFJ != null && this.jFJ.bjO()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.jFJ.imgUrl, this.jFJ.aIk, this.jFJ.exK)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cLn() {
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
            this.jFG.setProgress(f3);
            return;
        }
        this.jFG.setAlpha(1.0f - ((f4 - dimension2) / (cLn() - dimension2)));
    }

    private void setAlpha(float f) {
        this.jFI.setAlpha(f);
        this.jFH.setAlpha(f);
        if (this.jFH.getBackground() == null && this.jFJ != null) {
            if (this.jFJ.exJ == 1) {
                this.jFH.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.jFH.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
