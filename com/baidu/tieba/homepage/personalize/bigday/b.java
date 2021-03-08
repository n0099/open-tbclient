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
    private f.c fkY;
    private f.b fkZ;
    private f.d fla;
    private f.a flb;
    private TbImageView kno;
    private LottieAnimationView knp;
    private ImageView knq;
    private TextView knr;
    private com.baidu.tbadk.core.bigday.a kns;
    private String knt;
    private String knu;
    private String knv;
    private String knw;

    public b(Context context) {
        super(context);
        this.fkY = null;
        this.fkZ = null;
        this.fla = null;
        this.flb = null;
        if (context != null) {
            this.knt = context.getText(R.string.adp_pull_to_refresh).toString();
            this.knu = context.getText(R.string.bigday_refreshing).toString();
            this.knv = context.getText(R.string.bigday_release_to_refresh).toString();
            this.knw = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.fkY = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.fkZ = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.fla = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.flb = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.kno = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.knp = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.knq = (ImageView) inflate.findViewById(R.id.text_mask);
        this.knr = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.kno.setAutoChangeStyle(false);
        this.knr.setText(this.knt);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.blc()) {
            this.kns = aVar;
        }
        if (aVar.eLA == 1) {
            this.knr.setTextColor(getContext().getResources().getColor(R.color.CAM_X0101));
            this.knq.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.knp.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.knr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.knq.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.knp.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.knp.setFrame(0);
        this.kno.startLoad(aVar.imgUrl, 41, false);
        this.kno.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.kno.getBdImage() == null && b.this.kns != null && !au.isEmpty(b.this.kns.imgUrl)) {
                    b.this.kno.startLoad(b.this.kns.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cRO() {
        return this.kns;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.knr.setText(this.knt);
        if (this.fla != null) {
            this.fla.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.knr.setText(this.knv);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.knr.setText(this.knu);
        this.knp.setAlpha(1.0f);
        this.knp.setMinAndMaxFrame(8, 58);
        this.knp.loop(true);
        this.knp.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.fkY != null) {
            this.fkY.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.knr.setText("");
        this.knp.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.knp.setAlpha(1.0f);
        this.knr.setText(this.knt);
        if (this.flb != null) {
            this.flb.buB();
        }
        if (this.fkZ != null) {
            this.fkZ.onListPullRefreshFinished(getView(), z);
        }
        this.knp.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cRL() {
        this.knr.setText(this.knw);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cRM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, false));
        this.knr.animate().alpha(0.0f).setDuration(200L).start();
        this.knq.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cRN() {
        if (this.kns != null && this.kns.blc()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.kns.imgUrl, this.kns.aIQ, this.kns.eLB)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cRK() {
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
            this.knp.setProgress(f3);
            return;
        }
        this.knp.setAlpha(1.0f - ((f4 - dimension2) / (cRK() - dimension2)));
    }

    private void setAlpha(float f) {
        this.knr.setAlpha(f);
        this.knq.setAlpha(f);
        if (this.knq.getBackground() == null && this.kns != null) {
            if (this.kns.eLA == 1) {
                this.knq.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.knq.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
