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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private String clQ;
    private String clR;
    protected Button clS;
    protected TbImageView clT;
    private TbImageView clU;
    private View clV;
    private boolean clW;
    private float clX;
    private boolean clY;
    private x clZ;
    private a cma;
    View.OnClickListener cmb;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aqh();

        void aqi();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.clZ = xVar;
        s.a(this.clZ.bGT, this.clU, this.clZ.bGU, l.g(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.clQ = str;
            this.clR = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clQ = "";
        this.clR = "";
        this.clW = false;
        this.clX = 0.16875f;
        this.clY = false;
        this.cmb = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.clS) {
                    if (!TextUtils.isEmpty(BannerView.this.clR)) {
                        TiebaStatic.log(BannerView.this.clR);
                    }
                    BannerView.this.clW = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.cma != null) {
                        BannerView.this.cma.aqi();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.clQ)) {
                    TiebaStatic.log(BannerView.this.clQ);
                }
                if (BannerView.this.cma == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        bb.ajE().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.cma.aqh();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.clS = (Button) findViewById(R.id.btn_close);
        this.clS.setOnClickListener(this.cmb);
        this.clT = (TbImageView) findViewById(R.id.banner_image);
        this.clT.setAutoChangeStyle(true);
        this.clT.setOnClickListener(this.cmb);
        this.clU = (TbImageView) findViewById(R.id.tv_advert);
        this.clV = findViewById(R.id.banner_mask);
        am.l(this.clV, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.clT != null && aVar != null) {
            this.clT.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.clU.setVisibility(0);
        } else {
            this.clU.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.clY = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.clW && this.clY) {
            ViewGroup.LayoutParams layoutParams = this.clT.getLayoutParams();
            layoutParams.width = l.af(getContext());
            layoutParams.height = (int) ((l.af(getContext()) * this.clX) + 0.5d);
            this.clT.setLayoutParams(layoutParams);
            this.clT.startLoad(str, 10, 640, 108, false);
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
        this.cma = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.clV.setBackgroundColor(i);
    }

    public boolean aqf() {
        return this.clY;
    }

    public TbImageView getBannerView() {
        return this.clT;
    }

    public void reset() {
        this.clW = false;
        this.clY = false;
    }

    public void aqg() {
        this.clT.postInvalidate();
    }
}
