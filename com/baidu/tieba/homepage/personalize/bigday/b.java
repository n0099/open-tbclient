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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes6.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private g.c dcr;
    private g.b dcs;
    private g.d dct;
    private g.a dcv;
    private TbImageView gZa;
    private LottieAnimationView gZb;
    private ImageView gZc;
    private TextView gZd;
    private com.baidu.tbadk.core.bigday.a gZe;
    private String gZf;
    private String gZg;
    private String gZh;
    private String gZi;

    public b(Context context) {
        super(context);
        this.dcr = null;
        this.dcs = null;
        this.dct = null;
        this.dcv = null;
        if (context != null) {
            this.gZf = context.getText(R.string.adp_pull_to_refresh).toString();
            this.gZg = context.getText(R.string.bigday_refreshing).toString();
            this.gZh = context.getText(R.string.bigday_release_to_refresh).toString();
            this.gZi = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(g.c cVar) {
        this.dcr = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.dcs = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.d dVar) {
        this.dct = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.dcv = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.gZa = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.gZb = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.gZc = (ImageView) inflate.findViewById(R.id.text_mask);
        this.gZd = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.gZa.setAutoChangeStyle(false);
        this.gZd.setText(this.gZf);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.axm()) {
            this.gZe = aVar;
        }
        if (aVar.cHC == 1) {
            this.gZd.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.gZc.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.gZb.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.gZd.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.gZc.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.gZb.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.gZb.setFrame(0);
        this.gZa.startLoad(aVar.imgUrl, 41, false);
        this.gZa.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.gZa.getBdImage() == null && b.this.gZe != null && !aq.isEmpty(b.this.gZe.imgUrl)) {
                    b.this.gZa.startLoad(b.this.gZe.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bMs() {
        return this.gZe;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.gZd.setText(this.gZf);
        if (this.dct != null) {
            this.dct.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.gZd.setText(this.gZh);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.gZd.setText(this.gZg);
        this.gZb.setAlpha(1.0f);
        this.gZb.setMinAndMaxFrame(8, 58);
        this.gZb.loop(true);
        this.gZb.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.dcr != null) {
            this.dcr.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.gZd.setText("");
        this.gZb.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.gZb.setAlpha(1.0f);
        this.gZd.setText(this.gZf);
        if (this.dcv != null) {
            this.dcv.aFn();
        }
        if (this.dcs != null) {
            this.dcs.onListPullRefreshFinished(getView(), z);
        }
        this.gZb.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bMp() {
        this.gZd.setText(this.gZi);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bMq() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.gZd.animate().alpha(0.0f).setDuration(200L).start();
        this.gZc.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bMr() {
        if (this.gZe != null && this.gZe.axm()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.gZe.imgUrl, this.gZe.cHB, this.gZe.cHD)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bMo() {
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
            this.gZb.setProgress(f3);
            return;
        }
        this.gZb.setAlpha(1.0f - ((f4 - dimension2) / (bMo() - dimension2)));
    }

    private void setAlpha(float f) {
        this.gZd.setAlpha(f);
        this.gZc.setAlpha(f);
        if (this.gZc.getBackground() == null && this.gZe != null) {
            if (this.gZe.cHC == 1) {
                this.gZc.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.gZc.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
