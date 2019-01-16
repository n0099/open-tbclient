package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    protected TbImageView aTA;
    private TbImageView aTB;
    private View aTC;
    private boolean aTD;
    private float aTE;
    private boolean aTF;
    private v aTG;
    private a aTH;
    View.OnClickListener aTI;
    private String aTx;
    private String aTy;
    protected Button aTz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void KE();

        void KF();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.aTG = vVar;
        s.a(this.aTG.arK, this.aTB, this.aTG.arL, l.h(getContext(), e.C0210e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.aTx = str;
            this.aTy = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTx = "";
        this.aTy = "";
        this.aTD = false;
        this.aTE = 0.16875f;
        this.aTF = false;
        this.aTI = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.aTz) {
                    if (!TextUtils.isEmpty(BannerView.this.aTy)) {
                        TiebaStatic.log(BannerView.this.aTy);
                    }
                    BannerView.this.aTD = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aTH != null) {
                        BannerView.this.aTH.KF();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aTx)) {
                    TiebaStatic.log(BannerView.this.aTx);
                }
                if (BannerView.this.aTH == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ay.Es().c(BannerView.this.mContext, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.mContext.getPageActivity(), "enterforum_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.mContext.getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.aTH.KE();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.bannerview, this);
        this.aTz = (Button) findViewById(e.g.btn_close);
        this.aTz.setOnClickListener(this.aTI);
        this.aTA = (TbImageView) findViewById(e.g.banner_image);
        this.aTA.setAutoChangeStyle(true);
        this.aTA.setOnClickListener(this.aTI);
        this.aTB = (TbImageView) findViewById(e.g.tv_advert);
        this.aTC = findViewById(e.g.banner_mask);
        al.j(this.aTC, e.d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aTA != null && aVar != null) {
            this.aTA.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aTB.setVisibility(0);
        } else {
            this.aTB.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aTF = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aTD && this.aTF) {
            ViewGroup.LayoutParams layoutParams = this.aTA.getLayoutParams();
            layoutParams.width = l.aO(getContext());
            layoutParams.height = (int) ((l.aO(getContext()) * this.aTE) + 0.5d);
            this.aTA.setLayoutParams(layoutParams);
            this.aTA.startLoad(str, 10, 640, 108, false);
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = layoutParams.height;
                setLayoutParams(layoutParams2);
            }
            setVisibility(0);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str) {
        setData(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.aTH = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aTC.setBackgroundColor(i);
    }

    public boolean KC() {
        return this.aTF;
    }

    public TbImageView getBannerView() {
        return this.aTA;
    }

    public void reset() {
        this.aTD = false;
        this.aTF = false;
    }

    public void KD() {
        this.aTA.postInvalidate();
    }
}
