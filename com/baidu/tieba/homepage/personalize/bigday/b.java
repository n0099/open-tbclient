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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes9.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.c dVt;
    private f.b dVu;
    private f.d dVv;
    private f.a dVw;
    private TbImageView ifo;
    private LottieAnimationView ifp;
    private ImageView ifq;
    private TextView ifr;
    private com.baidu.tbadk.core.bigday.a ifs;
    private String ift;
    private String ifu;
    private String ifv;
    private String ifw;

    public b(Context context) {
        super(context);
        this.dVt = null;
        this.dVu = null;
        this.dVv = null;
        this.dVw = null;
        if (context != null) {
            this.ift = context.getText(R.string.adp_pull_to_refresh).toString();
            this.ifu = context.getText(R.string.bigday_refreshing).toString();
            this.ifv = context.getText(R.string.bigday_release_to_refresh).toString();
            this.ifw = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.dVt = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.dVu = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.dVv = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.dVw = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.ifo = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.ifp = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.ifq = (ImageView) inflate.findViewById(R.id.text_mask);
        this.ifr = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.ifo.setAutoChangeStyle(false);
        this.ifr.setText(this.ift);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.aNX()) {
            this.ifs = aVar;
        }
        if (aVar.dzo == 1) {
            this.ifr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.ifq.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.ifp.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.ifr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.ifq.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.ifp.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.ifp.setFrame(0);
        this.ifo.startLoad(aVar.imgUrl, 41, false);
        this.ifo.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.ifo.getBdImage() == null && b.this.ifs != null && !aq.isEmpty(b.this.ifs.imgUrl)) {
                    b.this.ifo.startLoad(b.this.ifs.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cgx() {
        return this.ifs;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.ifr.setText(this.ift);
        if (this.dVv != null) {
            this.dVv.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.ifr.setText(this.ifv);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.ifr.setText(this.ifu);
        this.ifp.setAlpha(1.0f);
        this.ifp.setMinAndMaxFrame(8, 58);
        this.ifp.loop(true);
        this.ifp.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.dVt != null) {
            this.dVt.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.ifr.setText("");
        this.ifp.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.ifp.setAlpha(1.0f);
        this.ifr.setText(this.ift);
        if (this.dVw != null) {
            this.dVw.aWA();
        }
        if (this.dVu != null) {
            this.dVu.onListPullRefreshFinished(getView(), z);
        }
        this.ifp.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cgu() {
        this.ifr.setText(this.ifw);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cgv() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.ifr.animate().alpha(0.0f).setDuration(200L).start();
        this.ifq.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cgw() {
        if (this.ifs != null && this.ifs.aNX()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.ifs.imgUrl, this.ifs.auL, this.ifs.dzp)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cgt() {
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
            this.ifp.setProgress(f3);
            return;
        }
        this.ifp.setAlpha(1.0f - ((f4 - dimension2) / (cgt() - dimension2)));
    }

    private void setAlpha(float f) {
        this.ifr.setAlpha(f);
        this.ifq.setAlpha(f);
        if (this.ifq.getBackground() == null && this.ifs != null) {
            if (this.ifs.dzo == 1) {
                this.ifq.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.ifq.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
