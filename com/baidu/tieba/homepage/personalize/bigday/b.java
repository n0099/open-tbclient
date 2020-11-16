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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes21.dex */
public class b extends d implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.c eUM;
    private f.b eUN;
    private f.d eUO;
    private f.a eUP;
    private TbImageView jGE;
    private LottieAnimationView jGF;
    private ImageView jGG;
    private TextView jGH;
    private com.baidu.tbadk.core.bigday.a jGI;
    private String jGJ;
    private String jGK;
    private String jGL;
    private String jGM;

    public b(Context context) {
        super(context);
        this.eUM = null;
        this.eUN = null;
        this.eUO = null;
        this.eUP = null;
        if (context != null) {
            this.jGJ = context.getText(R.string.adp_pull_to_refresh).toString();
            this.jGK = context.getText(R.string.bigday_refreshing).toString();
            this.jGL = context.getText(R.string.bigday_release_to_refresh).toString();
            this.jGM = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.eUM = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.eUN = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.eUO = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.eUP = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.jGE = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.jGF = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.jGG = (ImageView) inflate.findViewById(R.id.text_mask);
        this.jGH = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.jGE.setAutoChangeStyle(false);
        this.jGH.setText(this.jGJ);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.biS()) {
            this.jGI = aVar;
        }
        if (aVar.evZ == 1) {
            this.jGH.setTextColor(getContext().getResources().getColor(R.color.CAM_X0101));
            this.jGG.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.jGF.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.jGH.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.jGG.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.jGF.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.jGF.setFrame(0);
        this.jGE.startLoad(aVar.imgUrl, 41, false);
        this.jGE.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.jGE.getBdImage() == null && b.this.jGI != null && !au.isEmpty(b.this.jGI.imgUrl)) {
                    b.this.jGE.startLoad(b.this.jGI.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cKX() {
        return this.jGI;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.jGH.setText(this.jGJ);
        if (this.eUO != null) {
            this.eUO.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.jGH.setText(this.jGL);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.jGH.setText(this.jGK);
        this.jGF.setAlpha(1.0f);
        this.jGF.setMinAndMaxFrame(8, 58);
        this.jGF.loop(true);
        this.jGF.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.eUM != null) {
            this.eUM.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.jGH.setText("");
        this.jGF.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.jGF.setAlpha(1.0f);
        this.jGH.setText(this.jGJ);
        if (this.eUP != null) {
            this.eUP.bsc();
        }
        if (this.eUN != null) {
            this.eUN.onListPullRefreshFinished(getView(), z);
        }
        this.jGF.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cKU() {
        this.jGH.setText(this.jGM);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cKV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, false));
        this.jGH.animate().alpha(0.0f).setDuration(200L).start();
        this.jGG.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cKW() {
        if (this.jGI != null && this.jGI.biS()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.jGI.imgUrl, this.jGI.aGz, this.jGI.ewa)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cKT() {
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
            this.jGF.setProgress(f3);
            return;
        }
        this.jGF.setAlpha(1.0f - ((f4 - dimension2) / (cKT() - dimension2)));
    }

    private void setAlpha(float f) {
        this.jGH.setAlpha(f);
        this.jGG.setAlpha(f);
        if (this.jGG.getBackground() == null && this.jGI != null) {
            if (this.jGI.evZ == 1) {
                this.jGG.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.jGG.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
