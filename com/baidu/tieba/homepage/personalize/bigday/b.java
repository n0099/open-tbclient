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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes4.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private h.c caJ;
    private h.b caK;
    private h.d caL;
    private h.a caM;
    private TbImageView gkX;
    private LottieAnimationView gkY;
    private ImageView gkZ;
    private TextView gla;
    private com.baidu.tbadk.core.bigday.a glb;
    private String glc;
    private String gld;
    private String gle;
    private String glf;

    public b(Context context) {
        super(context);
        this.caJ = null;
        this.caK = null;
        this.caL = null;
        this.caM = null;
        if (context != null) {
            this.glc = context.getText(R.string.adp_pull_to_refresh).toString();
            this.gld = context.getText(R.string.bigday_refreshing).toString();
            this.gle = context.getText(R.string.bigday_release_to_refresh).toString();
            this.glf = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(h.c cVar) {
        this.caJ = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.b bVar) {
        this.caK = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.d dVar) {
        this.caL = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.a aVar) {
        this.caM = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nZ() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.gkX = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.gkY = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.gkZ = (ImageView) inflate.findViewById(R.id.text_mask);
        this.gla = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.gkX.setAutoChangeStyle(false);
        this.gla.setText(this.glc);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.acn()) {
            this.glb = aVar;
        }
        if (aVar.bDO == 1) {
            this.gla.setTextColor(getContext().getResources().getColor(R.color.cp_btn_a));
            this.gkZ.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.gkY.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.gla.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.gkZ.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.gkY.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.gkY.setFrame(0);
        this.gkX.startLoad(aVar.imgUrl, 41, false);
        this.gkX.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.gkX.getBdImage() == null && b.this.glb != null && !aq.isEmpty(b.this.glb.imgUrl)) {
                    b.this.gkX.startLoad(b.this.glb.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bxo() {
        return this.glb;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ar(boolean z) {
        setAlpha(1.0f);
        this.gla.setText(this.glc);
        if (this.caL != null) {
            this.caL.es(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.gla.setText(this.gle);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.gla.setText(this.gld);
        this.gkY.setAlpha(1.0f);
        this.gkY.setMinAndMaxFrame(8, 58);
        this.gkY.y(true);
        this.gkY.br();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void at(boolean z) {
        if (this.caJ != null) {
            this.caJ.er(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oa() {
        this.gla.setText("");
        this.gkY.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void as(boolean z) {
        setAlpha(1.0f);
        this.gkY.setAlpha(1.0f);
        this.gla.setText(this.glc);
        if (this.caM != null) {
            this.caM.akW();
        }
        if (this.caK != null) {
            this.caK.f(getView(), z);
        }
        this.gkY.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bxl() {
        this.gla.setText(this.glf);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bxm() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.gla.animate().alpha(0.0f).setDuration(200L).start();
        this.gkZ.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bxn() {
        if (this.glb != null && this.glb.acn()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.glb.imgUrl, this.glb.bDN, this.glb.bDP)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bxk() {
        return (int) (l.ah(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
        float f3 = 0.0f;
        super.n(f, f2);
        float dimension = getView().getResources().getDimension(R.dimen.tbds120);
        float dimension2 = getView().getResources().getDimension(R.dimen.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.gkY.setProgress(f3);
            return;
        }
        this.gkY.setAlpha(1.0f - ((f4 - dimension2) / (bxk() - dimension2)));
    }

    private void setAlpha(float f) {
        this.gla.setAlpha(f);
        this.gkZ.setAlpha(f);
        if (this.gkZ.getBackground() == null && this.glb != null) {
            if (this.glb.bDO == 1) {
                this.gkZ.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.gkZ.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
