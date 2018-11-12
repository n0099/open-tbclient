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
    private String aPo;
    private String aPp;
    protected Button aPq;
    protected TbImageView aPr;
    private TbImageView aPs;
    private View aPt;
    private boolean aPu;
    private float aPv;
    private boolean aPw;
    private v aPx;
    private a aPy;
    View.OnClickListener aPz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Jk();

        void Jl();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.aPx = vVar;
        s.a(this.aPx.anH, this.aPs, this.aPx.anI, l.h(getContext(), e.C0200e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.aPo = str;
            this.aPp = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPo = "";
        this.aPp = "";
        this.aPu = false;
        this.aPv = 0.16875f;
        this.aPw = false;
        this.aPz = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.aPq) {
                    if (!TextUtils.isEmpty(BannerView.this.aPp)) {
                        TiebaStatic.log(BannerView.this.aPp);
                    }
                    BannerView.this.aPu = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aPy != null) {
                        BannerView.this.aPy.Jl();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aPo)) {
                    TiebaStatic.log(BannerView.this.aPo);
                }
                if (BannerView.this.aPy == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ay.Db().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.aPy.Jk();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.bannerview, this);
        this.aPq = (Button) findViewById(e.g.btn_close);
        this.aPq.setOnClickListener(this.aPz);
        this.aPr = (TbImageView) findViewById(e.g.banner_image);
        this.aPr.setAutoChangeStyle(true);
        this.aPr.setOnClickListener(this.aPz);
        this.aPs = (TbImageView) findViewById(e.g.tv_advert);
        this.aPt = findViewById(e.g.banner_mask);
        al.j(this.aPt, e.d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aPr != null && aVar != null) {
            this.aPr.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aPs.setVisibility(0);
        } else {
            this.aPs.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aPw = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aPu && this.aPw) {
            ViewGroup.LayoutParams layoutParams = this.aPr.getLayoutParams();
            layoutParams.width = l.aO(getContext());
            layoutParams.height = (int) ((l.aO(getContext()) * this.aPv) + 0.5d);
            this.aPr.setLayoutParams(layoutParams);
            this.aPr.startLoad(str, 10, 640, 108, false);
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
        this.aPy = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aPt.setBackgroundColor(i);
    }

    public boolean Ji() {
        return this.aPw;
    }

    public TbImageView getBannerView() {
        return this.aPr;
    }

    public void reset() {
        this.aPu = false;
        this.aPw = false;
    }

    public void Jj() {
        this.aPr.postInvalidate();
    }
}
