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
/* loaded from: classes9.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private g.c dhi;
    private g.b dhj;
    private g.d dhk;
    private g.a dhl;
    private TbImageView hgg;
    private LottieAnimationView hgh;
    private ImageView hgi;
    private TextView hgj;
    private com.baidu.tbadk.core.bigday.a hgk;
    private String hgl;
    private String hgm;
    private String hgn;
    private String hgo;

    public b(Context context) {
        super(context);
        this.dhi = null;
        this.dhj = null;
        this.dhk = null;
        this.dhl = null;
        if (context != null) {
            this.hgl = context.getText(R.string.adp_pull_to_refresh).toString();
            this.hgm = context.getText(R.string.bigday_refreshing).toString();
            this.hgn = context.getText(R.string.bigday_release_to_refresh).toString();
            this.hgo = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(g.c cVar) {
        this.dhi = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.dhj = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.d dVar) {
        this.dhk = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.dhl = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.hgg = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.hgh = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.hgi = (ImageView) inflate.findViewById(R.id.text_mask);
        this.hgj = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.hgg.setAutoChangeStyle(false);
        this.hgj.setText(this.hgl);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.azY()) {
            this.hgk = aVar;
        }
        if (aVar.cMe == 1) {
            this.hgj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.hgi.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.hgh.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.hgj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.hgi.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.hgh.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.hgh.setFrame(0);
        this.hgg.startLoad(aVar.imgUrl, 41, false);
        this.hgg.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.hgg.getBdImage() == null && b.this.hgk != null && !aq.isEmpty(b.this.hgk.imgUrl)) {
                    b.this.hgg.startLoad(b.this.hgk.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bPt() {
        return this.hgk;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.hgj.setText(this.hgl);
        if (this.dhk != null) {
            this.dhk.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.hgj.setText(this.hgn);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.hgj.setText(this.hgm);
        this.hgh.setAlpha(1.0f);
        this.hgh.setMinAndMaxFrame(8, 58);
        this.hgh.loop(true);
        this.hgh.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.dhi != null) {
            this.dhi.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.hgj.setText("");
        this.hgh.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.hgh.setAlpha(1.0f);
        this.hgj.setText(this.hgl);
        if (this.dhl != null) {
            this.dhl.aIc();
        }
        if (this.dhj != null) {
            this.dhj.onListPullRefreshFinished(getView(), z);
        }
        this.hgh.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPq() {
        this.hgj.setText(this.hgo);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.hgj.animate().alpha(0.0f).setDuration(200L).start();
        this.hgi.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPs() {
        if (this.hgk != null && this.hgk.azY()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.hgk.imgUrl, this.hgk.cMd, this.hgk.cMf)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bPp() {
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
            this.hgh.setProgress(f3);
            return;
        }
        this.hgh.setAlpha(1.0f - ((f4 - dimension2) / (bPp() - dimension2)));
    }

    private void setAlpha(float f) {
        this.hgj.setAlpha(f);
        this.hgi.setAlpha(f);
        if (this.hgi.getBackground() == null && this.hgk != null) {
            if (this.hgk.cMe == 1) {
                this.hgi.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.hgi.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
