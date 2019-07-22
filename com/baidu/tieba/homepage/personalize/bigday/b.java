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
    private h.c caD;
    private h.b caE;
    private h.d caF;
    private h.a caG;
    private TbImageView gkh;
    private LottieAnimationView gki;
    private ImageView gkj;
    private TextView gkk;
    private com.baidu.tbadk.core.bigday.a gkl;
    private String gkm;
    private String gkn;
    private String gko;
    private String gkp;

    public b(Context context) {
        super(context);
        this.caD = null;
        this.caE = null;
        this.caF = null;
        this.caG = null;
        if (context != null) {
            this.gkm = context.getText(R.string.adp_pull_to_refresh).toString();
            this.gkn = context.getText(R.string.bigday_refreshing).toString();
            this.gko = context.getText(R.string.bigday_release_to_refresh).toString();
            this.gkp = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(h.c cVar) {
        this.caD = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.b bVar) {
        this.caE = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.d dVar) {
        this.caF = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.a aVar) {
        this.caG = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nZ() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.gkh = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.gki = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.gkj = (ImageView) inflate.findViewById(R.id.text_mask);
        this.gkk = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.gkh.setAutoChangeStyle(false);
        this.gkk.setText(this.gkm);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.acn()) {
            this.gkl = aVar;
        }
        if (aVar.bDO == 1) {
            this.gkk.setTextColor(getContext().getResources().getColor(R.color.cp_btn_a));
            this.gkj.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.gki.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.gkk.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.gkj.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.gki.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.gki.setFrame(0);
        this.gkh.startLoad(aVar.imgUrl, 41, false);
        this.gkh.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.gkh.getBdImage() == null && b.this.gkl != null && !aq.isEmpty(b.this.gkl.imgUrl)) {
                    b.this.gkh.startLoad(b.this.gkl.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bxa() {
        return this.gkl;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ar(boolean z) {
        setAlpha(1.0f);
        this.gkk.setText(this.gkm);
        if (this.caF != null) {
            this.caF.es(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.gkk.setText(this.gko);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.gkk.setText(this.gkn);
        this.gki.setAlpha(1.0f);
        this.gki.setMinAndMaxFrame(8, 58);
        this.gki.y(true);
        this.gki.br();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void at(boolean z) {
        if (this.caD != null) {
            this.caD.er(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oa() {
        this.gkk.setText("");
        this.gki.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void as(boolean z) {
        setAlpha(1.0f);
        this.gki.setAlpha(1.0f);
        this.gkk.setText(this.gkm);
        if (this.caG != null) {
            this.caG.akU();
        }
        if (this.caE != null) {
            this.caE.f(getView(), z);
        }
        this.gki.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bwX() {
        this.gkk.setText(this.gkp);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bwY() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.gkk.animate().alpha(0.0f).setDuration(200L).start();
        this.gkj.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bwZ() {
        if (this.gkl != null && this.gkl.acn()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.gkl.imgUrl, this.gkl.bDN, this.gkl.bDP)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bwW() {
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
            this.gki.setProgress(f3);
            return;
        }
        this.gki.setAlpha(1.0f - ((f4 - dimension2) / (bwW() - dimension2)));
    }

    private void setAlpha(float f) {
        this.gkk.setAlpha(f);
        this.gkj.setAlpha(f);
        if (this.gkj.getBackground() == null && this.gkl != null) {
            if (this.gkl.bDO == 1) {
                this.gkj.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.gkj.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
