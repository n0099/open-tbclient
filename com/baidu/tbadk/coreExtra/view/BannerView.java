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
    protected TbImageView ckA;
    private TbImageView ckB;
    private View ckC;
    private boolean ckD;
    private float ckE;
    private boolean ckF;
    private x ckG;
    private a ckH;
    View.OnClickListener ckI;
    private String ckx;
    private String cky;
    protected Button ckz;
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
        this.ckG = xVar;
        s.a(this.ckG.bFR, this.ckB, this.ckG.bFS, l.g(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.ckx = str;
            this.cky = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckx = "";
        this.cky = "";
        this.ckD = false;
        this.ckE = 0.16875f;
        this.ckF = false;
        this.ckI = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.ckz) {
                    if (!TextUtils.isEmpty(BannerView.this.cky)) {
                        TiebaStatic.log(BannerView.this.cky);
                    }
                    BannerView.this.ckD = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.ckH != null) {
                        BannerView.this.ckH.apa();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.ckx)) {
                    TiebaStatic.log(BannerView.this.ckx);
                }
                if (BannerView.this.ckH == null) {
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
                BannerView.this.ckH.aoZ();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.ckz = (Button) findViewById(R.id.btn_close);
        this.ckz.setOnClickListener(this.ckI);
        this.ckA = (TbImageView) findViewById(R.id.banner_image);
        this.ckA.setAutoChangeStyle(true);
        this.ckA.setOnClickListener(this.ckI);
        this.ckB = (TbImageView) findViewById(R.id.tv_advert);
        this.ckC = findViewById(R.id.banner_mask);
        al.l(this.ckC, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ckA != null && aVar != null) {
            this.ckA.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.ckB.setVisibility(0);
        } else {
            this.ckB.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.ckF = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ckD && this.ckF) {
            ViewGroup.LayoutParams layoutParams = this.ckA.getLayoutParams();
            layoutParams.width = l.af(getContext());
            layoutParams.height = (int) ((l.af(getContext()) * this.ckE) + 0.5d);
            this.ckA.setLayoutParams(layoutParams);
            this.ckA.startLoad(str, 10, 640, 108, false);
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
        this.ckH = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.ckC.setBackgroundColor(i);
    }

    public boolean aoX() {
        return this.ckF;
    }

    public TbImageView getBannerView() {
        return this.ckA;
    }

    public void reset() {
        this.ckD = false;
        this.ckF = false;
    }

    public void aoY() {
        this.ckA.postInvalidate();
    }
}
