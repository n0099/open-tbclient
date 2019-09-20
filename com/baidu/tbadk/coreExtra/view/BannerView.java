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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private String cmM;
    private String cmN;
    protected Button cmO;
    protected TbImageView cmP;
    private TbImageView cmQ;
    private View cmR;
    private boolean cmS;
    private float cmT;
    private boolean cmU;
    private x cmV;
    private a cmW;
    View.OnClickListener cmX;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aqt();

        void aqu();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.cmV = xVar;
        s.a(this.cmV.bHr, this.cmQ, this.cmV.bHs, l.g(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.cmM = str;
            this.cmN = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmM = "";
        this.cmN = "";
        this.cmS = false;
        this.cmT = 0.16875f;
        this.cmU = false;
        this.cmX = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.cmO) {
                    if (!TextUtils.isEmpty(BannerView.this.cmN)) {
                        TiebaStatic.log(BannerView.this.cmN);
                    }
                    BannerView.this.cmS = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.cmW != null) {
                        BannerView.this.cmW.aqu();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.cmM)) {
                    TiebaStatic.log(BannerView.this.cmM);
                }
                if (BannerView.this.cmW == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.ajK().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.cmW.aqt();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.cmO = (Button) findViewById(R.id.btn_close);
        this.cmO.setOnClickListener(this.cmX);
        this.cmP = (TbImageView) findViewById(R.id.banner_image);
        this.cmP.setAutoChangeStyle(true);
        this.cmP.setOnClickListener(this.cmX);
        this.cmQ = (TbImageView) findViewById(R.id.tv_advert);
        this.cmR = findViewById(R.id.banner_mask);
        am.l(this.cmR, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.cmP != null && aVar != null) {
            this.cmP.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.cmQ.setVisibility(0);
        } else {
            this.cmQ.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.cmU = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.cmS && this.cmU) {
            ViewGroup.LayoutParams layoutParams = this.cmP.getLayoutParams();
            layoutParams.width = l.af(getContext());
            layoutParams.height = (int) ((l.af(getContext()) * this.cmT) + 0.5d);
            this.cmP.setLayoutParams(layoutParams);
            this.cmP.startLoad(str, 10, 640, 108, false);
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
        this.cmW = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.cmR.setBackgroundColor(i);
    }

    public boolean aqr() {
        return this.cmU;
    }

    public TbImageView getBannerView() {
        return this.cmP;
    }

    public void reset() {
        this.cmS = false;
        this.cmU = false;
    }

    public void aqs() {
        this.cmP.postInvalidate();
    }
}
