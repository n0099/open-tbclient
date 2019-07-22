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
    private String clJ;
    private String clK;
    protected Button clL;
    protected TbImageView clM;
    private TbImageView clN;
    private View clO;
    private boolean clP;
    private float clQ;
    private boolean clR;
    private x clS;
    private a clT;
    View.OnClickListener clU;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aqf();

        void aqg();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.clS = xVar;
        s.a(this.clS.bGS, this.clN, this.clS.bGT, l.g(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.clJ = str;
            this.clK = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clJ = "";
        this.clK = "";
        this.clP = false;
        this.clQ = 0.16875f;
        this.clR = false;
        this.clU = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.clL) {
                    if (!TextUtils.isEmpty(BannerView.this.clK)) {
                        TiebaStatic.log(BannerView.this.clK);
                    }
                    BannerView.this.clP = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.clT != null) {
                        BannerView.this.clT.aqg();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.clJ)) {
                    TiebaStatic.log(BannerView.this.clJ);
                }
                if (BannerView.this.clT == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        bb.ajC().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.clT.aqf();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.clL = (Button) findViewById(R.id.btn_close);
        this.clL.setOnClickListener(this.clU);
        this.clM = (TbImageView) findViewById(R.id.banner_image);
        this.clM.setAutoChangeStyle(true);
        this.clM.setOnClickListener(this.clU);
        this.clN = (TbImageView) findViewById(R.id.tv_advert);
        this.clO = findViewById(R.id.banner_mask);
        am.l(this.clO, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.clM != null && aVar != null) {
            this.clM.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.clN.setVisibility(0);
        } else {
            this.clN.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.clR = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.clP && this.clR) {
            ViewGroup.LayoutParams layoutParams = this.clM.getLayoutParams();
            layoutParams.width = l.af(getContext());
            layoutParams.height = (int) ((l.af(getContext()) * this.clQ) + 0.5d);
            this.clM.setLayoutParams(layoutParams);
            this.clM.startLoad(str, 10, 640, 108, false);
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
        this.clT = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.clO.setBackgroundColor(i);
    }

    public boolean aqd() {
        return this.clR;
    }

    public TbImageView getBannerView() {
        return this.clM;
    }

    public void reset() {
        this.clP = false;
        this.clR = false;
    }

    public void aqe() {
        this.clM.postInvalidate();
    }
}
