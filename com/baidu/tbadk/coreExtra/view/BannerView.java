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
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private String aFR;
    private String aFS;
    protected Button aFT;
    protected TbImageView aFU;
    private TbImageView aFV;
    private View aFW;
    private boolean aFX;
    private float aFY;
    private boolean aFZ;
    private w aGa;
    private a aGb;
    View.OnClickListener aGc;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Ft();

        void Fu();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(w wVar) {
        this.aGa = wVar;
        s.a(this.aGa.afP, this.aFV, this.aGa.afQ, l.e(getContext(), d.e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.aFR = str;
            this.aFS = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFR = "";
        this.aFS = "";
        this.aFX = false;
        this.aFY = 0.16875f;
        this.aFZ = false;
        this.aGc = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.aFT) {
                    if (!TextUtils.isEmpty(BannerView.this.aFS)) {
                        TiebaStatic.log(BannerView.this.aFS);
                    }
                    BannerView.this.aFX = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aGb != null) {
                        BannerView.this.aGb.Fu();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aFR)) {
                    TiebaStatic.log(BannerView.this.aFR);
                }
                if (BannerView.this.aGb == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ay.zG().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.aGb.Ft();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.bannerview, this);
        this.aFT = (Button) findViewById(d.g.btn_close);
        this.aFT.setOnClickListener(this.aGc);
        this.aFU = (TbImageView) findViewById(d.g.banner_image);
        this.aFU.setAutoChangeStyle(true);
        this.aFU.setOnClickListener(this.aGc);
        this.aFV = (TbImageView) findViewById(d.g.tv_advert);
        this.aFW = findViewById(d.g.banner_mask);
        al.j(this.aFW, d.C0141d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aFU != null && aVar != null) {
            this.aFU.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aFV.setVisibility(0);
        } else {
            this.aFV.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aFZ = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aFX && this.aFZ) {
            ViewGroup.LayoutParams layoutParams = this.aFU.getLayoutParams();
            layoutParams.width = l.ah(getContext());
            layoutParams.height = (int) ((l.ah(getContext()) * this.aFY) + 0.5d);
            this.aFU.setLayoutParams(layoutParams);
            this.aFU.startLoad(str, 10, 640, 108, false);
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
        this.aGb = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aFW.setBackgroundColor(i);
    }

    public boolean Fr() {
        return this.aFZ;
    }

    public TbImageView getBannerView() {
        return this.aFU;
    }

    public void reset() {
        this.aFX = false;
        this.aFZ = false;
    }

    public void Fs() {
        this.aFU.postInvalidate();
    }
}
