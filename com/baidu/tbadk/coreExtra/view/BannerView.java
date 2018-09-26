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
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private String aJW;
    private String aJX;
    protected Button aJY;
    protected TbImageView aJZ;
    private TbImageView aKa;
    private View aKb;
    private boolean aKc;
    private float aKd;
    private boolean aKe;
    private v aKf;
    private a aKg;
    View.OnClickListener aKh;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void GX();

        void GY();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.aKf = vVar;
        s.a(this.aKf.ahZ, this.aKa, this.aKf.aia, l.h(getContext(), e.C0141e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.aJW = str;
            this.aJX = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJW = "";
        this.aJX = "";
        this.aKc = false;
        this.aKd = 0.16875f;
        this.aKe = false;
        this.aKh = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.aJY) {
                    if (!TextUtils.isEmpty(BannerView.this.aJX)) {
                        TiebaStatic.log(BannerView.this.aJX);
                    }
                    BannerView.this.aKc = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aKg != null) {
                        BannerView.this.aKg.GY();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aJW)) {
                    TiebaStatic.log(BannerView.this.aJW);
                }
                if (BannerView.this.aKg == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ay.AN().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.aKg.GX();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.bannerview, this);
        this.aJY = (Button) findViewById(e.g.btn_close);
        this.aJY.setOnClickListener(this.aKh);
        this.aJZ = (TbImageView) findViewById(e.g.banner_image);
        this.aJZ.setAutoChangeStyle(true);
        this.aJZ.setOnClickListener(this.aKh);
        this.aKa = (TbImageView) findViewById(e.g.tv_advert);
        this.aKb = findViewById(e.g.banner_mask);
        al.j(this.aKb, e.d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aJZ != null && aVar != null) {
            this.aJZ.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aKa.setVisibility(0);
        } else {
            this.aKa.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aKe = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aKc && this.aKe) {
            ViewGroup.LayoutParams layoutParams = this.aJZ.getLayoutParams();
            layoutParams.width = l.aO(getContext());
            layoutParams.height = (int) ((l.aO(getContext()) * this.aKd) + 0.5d);
            this.aJZ.setLayoutParams(layoutParams);
            this.aJZ.startLoad(str, 10, 640, 108, false);
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
        this.aKg = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aKb.setBackgroundColor(i);
    }

    public boolean GV() {
        return this.aKe;
    }

    public TbImageView getBannerView() {
        return this.aJZ;
    }

    public void reset() {
        this.aKc = false;
        this.aKe = false;
    }

    public void GW() {
        this.aJZ.postInvalidate();
    }
}
