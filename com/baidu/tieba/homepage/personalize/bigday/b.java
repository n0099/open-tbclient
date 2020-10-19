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
    private f.c eHp;
    private f.b eHq;
    private f.d eHr;
    private f.a eHs;
    private TbImageView jni;
    private LottieAnimationView jnj;
    private ImageView jnk;
    private TextView jnl;
    private com.baidu.tbadk.core.bigday.a jnm;
    private String jnn;
    private String jno;
    private String jnp;
    private String jnq;

    public b(Context context) {
        super(context);
        this.eHp = null;
        this.eHq = null;
        this.eHr = null;
        this.eHs = null;
        if (context != null) {
            this.jnn = context.getText(R.string.adp_pull_to_refresh).toString();
            this.jno = context.getText(R.string.bigday_refreshing).toString();
            this.jnp = context.getText(R.string.bigday_release_to_refresh).toString();
            this.jnq = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.eHp = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.eHq = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.eHr = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.eHs = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.jni = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.jnj = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.jnk = (ImageView) inflate.findViewById(R.id.text_mask);
        this.jnl = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.jni.setAutoChangeStyle(false);
        this.jnl.setText(this.jnn);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.bfv()) {
            this.jnm = aVar;
        }
        if (aVar.ejr == 1) {
            this.jnl.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.jnk.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.jnj.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.jnl.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.jnk.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.jnj.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.jnj.setFrame(0);
        this.jni.startLoad(aVar.imgUrl, 41, false);
        this.jni.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.jni.getBdImage() == null && b.this.jnm != null && !at.isEmpty(b.this.jnm.imgUrl)) {
                    b.this.jni.startLoad(b.this.jnm.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cFJ() {
        return this.jnm;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.jnl.setText(this.jnn);
        if (this.eHr != null) {
            this.eHr.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.jnl.setText(this.jnp);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.jnl.setText(this.jno);
        this.jnj.setAlpha(1.0f);
        this.jnj.setMinAndMaxFrame(8, 58);
        this.jnj.loop(true);
        this.jnj.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.eHp != null) {
            this.eHp.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.jnl.setText("");
        this.jnj.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.jnj.setAlpha(1.0f);
        this.jnl.setText(this.jnn);
        if (this.eHs != null) {
            this.eHs.bot();
        }
        if (this.eHq != null) {
            this.eHq.onListPullRefreshFinished(getView(), z);
        }
        this.jnj.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cFG() {
        this.jnl.setText(this.jnq);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cFH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, false));
        this.jnl.animate().alpha(0.0f).setDuration(200L).start();
        this.jnk.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cFI() {
        if (this.jnm != null && this.jnm.bfv()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.jnm.imgUrl, this.jnm.aHf, this.jnm.ejs)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cFF() {
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
            this.jnj.setProgress(f3);
            return;
        }
        this.jnj.setAlpha(1.0f - ((f4 - dimension2) / (cFF() - dimension2)));
    }

    private void setAlpha(float f) {
        this.jnl.setAlpha(f);
        this.jnk.setAlpha(f);
        if (this.jnk.getBackground() == null && this.jnm != null) {
            if (this.jnm.ejr == 1) {
                this.jnk.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.jnk.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
