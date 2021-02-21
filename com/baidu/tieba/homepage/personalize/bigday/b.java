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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes2.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.b fjA;
    private f.d fjB;
    private f.a fjC;
    private f.c fjz;
    private TbImageView klm;
    private LottieAnimationView kln;
    private ImageView klo;
    private TextView klp;
    private com.baidu.tbadk.core.bigday.a klq;
    private String klr;
    private String kls;
    private String klt;
    private String klu;

    public b(Context context) {
        super(context);
        this.fjz = null;
        this.fjA = null;
        this.fjB = null;
        this.fjC = null;
        if (context != null) {
            this.klr = context.getText(R.string.adp_pull_to_refresh).toString();
            this.kls = context.getText(R.string.bigday_refreshing).toString();
            this.klt = context.getText(R.string.bigday_release_to_refresh).toString();
            this.klu = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.fjz = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.fjA = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.fjB = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.fjC = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.klm = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.kln = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.klo = (ImageView) inflate.findViewById(R.id.text_mask);
        this.klp = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.klm.setAutoChangeStyle(false);
        this.klp.setText(this.klr);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.bla()) {
            this.klq = aVar;
        }
        if (aVar.eJZ == 1) {
            this.klp.setTextColor(getContext().getResources().getColor(R.color.CAM_X0101));
            this.klo.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.kln.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.klp.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.klo.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.kln.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.kln.setFrame(0);
        this.klm.startLoad(aVar.imgUrl, 41, false);
        this.klm.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.klm.getBdImage() == null && b.this.klq != null && !au.isEmpty(b.this.klq.imgUrl)) {
                    b.this.klm.startLoad(b.this.klq.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cRH() {
        return this.klq;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.klp.setText(this.klr);
        if (this.fjB != null) {
            this.fjB.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.klp.setText(this.klt);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.klp.setText(this.kls);
        this.kln.setAlpha(1.0f);
        this.kln.setMinAndMaxFrame(8, 58);
        this.kln.loop(true);
        this.kln.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.fjz != null) {
            this.fjz.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.klp.setText("");
        this.kln.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.kln.setAlpha(1.0f);
        this.klp.setText(this.klr);
        if (this.fjC != null) {
            this.fjC.buy();
        }
        if (this.fjA != null) {
            this.fjA.onListPullRefreshFinished(getView(), z);
        }
        this.kln.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cRE() {
        this.klp.setText(this.klu);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cRF() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, false));
        this.klp.animate().alpha(0.0f).setDuration(200L).start();
        this.klo.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cRG() {
        if (this.klq != null && this.klq.bla()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.klq.imgUrl, this.klq.aHq, this.klq.eKa)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cRD() {
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
            this.kln.setProgress(f3);
            return;
        }
        this.kln.setAlpha(1.0f - ((f4 - dimension2) / (cRD() - dimension2)));
    }

    private void setAlpha(float f) {
        this.klp.setAlpha(f);
        this.klo.setAlpha(f);
        if (this.klo.getBackground() == null && this.klq != null) {
            if (this.klq.eJZ == 1) {
                this.klo.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.klo.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
