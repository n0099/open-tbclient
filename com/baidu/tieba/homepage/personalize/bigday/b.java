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
/* loaded from: classes22.dex */
public class b extends d implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private f.c fci;
    private f.b fcj;
    private f.d fck;
    private f.a fcl;
    private TbImageView jUj;
    private LottieAnimationView jUk;
    private ImageView jUl;
    private TextView jUm;
    private com.baidu.tbadk.core.bigday.a jUn;
    private String jUo;
    private String jUp;
    private String jUq;
    private String jUr;

    public b(Context context) {
        super(context);
        this.fci = null;
        this.fcj = null;
        this.fck = null;
        this.fcl = null;
        if (context != null) {
            this.jUo = context.getText(R.string.adp_pull_to_refresh).toString();
            this.jUp = context.getText(R.string.bigday_refreshing).toString();
            this.jUq = context.getText(R.string.bigday_release_to_refresh).toString();
            this.jUr = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(f.c cVar) {
        this.fci = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.b bVar) {
        this.fcj = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.d dVar) {
        this.fck = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(f.a aVar) {
        this.fcl = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.jUj = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.jUk = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.jUl = (ImageView) inflate.findViewById(R.id.text_mask);
        this.jUm = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.jUj.setAutoChangeStyle(false);
        this.jUm.setText(this.jUo);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.bmc()) {
            this.jUn = aVar;
        }
        if (aVar.eDa == 1) {
            this.jUm.setTextColor(getContext().getResources().getColor(R.color.CAM_X0101));
            this.jUl.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.jUk.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.jUm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.jUl.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.jUk.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.jUk.setFrame(0);
        this.jUj.startLoad(aVar.imgUrl, 41, false);
        this.jUj.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.jUj.getBdImage() == null && b.this.jUn != null && !au.isEmpty(b.this.jUn.imgUrl)) {
                    b.this.jUj.startLoad(b.this.jUn.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a cQm() {
        return this.jUn;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.jUm.setText(this.jUo);
        if (this.fck != null) {
            this.fck.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void releaseToRefresh() {
        this.jUm.setText(this.jUq);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void refreshing() {
        setAlpha(1.0f);
        this.jUm.setText(this.jUp);
        this.jUk.setAlpha(1.0f);
        this.jUk.setMinAndMaxFrame(8, 58);
        this.jUk.loop(true);
        this.jUk.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onRefresh(boolean z) {
        if (this.fci != null) {
            this.fci.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void onCompletePullRefresh() {
        this.jUm.setText("");
        this.jUk.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void done(boolean z) {
        setAlpha(1.0f);
        this.jUk.setAlpha(1.0f);
        this.jUm.setText(this.jUo);
        if (this.fcl != null) {
            this.fcl.bvC();
        }
        if (this.fcj != null) {
            this.fcj.onListPullRefreshFinished(getView(), z);
        }
        this.jUk.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cQj() {
        this.jUm.setText(this.jUr);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cQk() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, false));
        this.jUm.animate().alpha(0.0f).setDuration(200L).start();
        this.jUl.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void cQl() {
        if (this.jUn != null && this.jUn.bmc()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.jUn.imgUrl, this.jUn.aJj, this.jUn.eDb)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int cQi() {
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
            this.jUk.setProgress(f3);
            return;
        }
        this.jUk.setAlpha(1.0f - ((f4 - dimension2) / (cQi() - dimension2)));
    }

    private void setAlpha(float f) {
        this.jUm.setAlpha(f);
        this.jUl.setAlpha(f);
        if (this.jUl.getBackground() == null && this.jUn != null) {
            if (this.jUn.eDa == 1) {
                this.jUl.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.jUl.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
