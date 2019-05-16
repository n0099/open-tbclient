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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbImageView ckA;
    private View ckB;
    private boolean ckC;
    private float ckD;
    private boolean ckE;
    private x ckF;
    private a ckG;
    View.OnClickListener ckH;
    private String ckw;
    private String ckx;
    protected Button cky;
    protected TbImageView ckz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aoZ();

        void apa();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.ckF = xVar;
        s.a(this.ckF.bFQ, this.ckA, this.ckF.bFR, l.g(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.ckw = str;
            this.ckx = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckw = "";
        this.ckx = "";
        this.ckC = false;
        this.ckD = 0.16875f;
        this.ckE = false;
        this.ckH = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.cky) {
                    if (!TextUtils.isEmpty(BannerView.this.ckx)) {
                        TiebaStatic.log(BannerView.this.ckx);
                    }
                    BannerView.this.ckC = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.ckG != null) {
                        BannerView.this.ckG.apa();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.ckw)) {
                    TiebaStatic.log(BannerView.this.ckw);
                }
                if (BannerView.this.ckG == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.aiz().c(BannerView.this.mContext, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.mContext.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.mContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.ckG.aoZ();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.cky = (Button) findViewById(R.id.btn_close);
        this.cky.setOnClickListener(this.ckH);
        this.ckz = (TbImageView) findViewById(R.id.banner_image);
        this.ckz.setAutoChangeStyle(true);
        this.ckz.setOnClickListener(this.ckH);
        this.ckA = (TbImageView) findViewById(R.id.tv_advert);
        this.ckB = findViewById(R.id.banner_mask);
        al.l(this.ckB, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ckz != null && aVar != null) {
            this.ckz.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.ckA.setVisibility(0);
        } else {
            this.ckA.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.ckE = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ckC && this.ckE) {
            ViewGroup.LayoutParams layoutParams = this.ckz.getLayoutParams();
            layoutParams.width = l.af(getContext());
            layoutParams.height = (int) ((l.af(getContext()) * this.ckD) + 0.5d);
            this.ckz.setLayoutParams(layoutParams);
            this.ckz.startLoad(str, 10, 640, 108, false);
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
        this.ckG = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.ckB.setBackgroundColor(i);
    }

    public boolean aoX() {
        return this.ckE;
    }

    public TbImageView getBannerView() {
        return this.ckz;
    }

    public void reset() {
        this.ckC = false;
        this.ckE = false;
    }

    public void aoY() {
        this.ckz.postInvalidate();
    }
}
