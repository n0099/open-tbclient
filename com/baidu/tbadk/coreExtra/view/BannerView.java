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
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private View aPe;
    private TbImageView dRA;
    private float dRB;
    private boolean dRC;
    private y dRD;
    private a dRE;
    View.OnClickListener dRF;
    private String dRw;
    private String dRx;
    protected Button dRy;
    protected TbImageView dRz;
    private TbPageContext<?> duG;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aVe();

        void aVf();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(y yVar) {
        this.dRD = yVar;
        r.a(this.dRD.dom, this.dRA, this.dRD.don, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.dRw = str;
            this.dRx = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRw = "";
        this.dRx = "";
        this.mIsClose = false;
        this.dRB = 0.16875f;
        this.dRC = false;
        this.dRF = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.dRy) {
                    if (!TextUtils.isEmpty(BannerView.this.dRx)) {
                        TiebaStatic.log(BannerView.this.dRx);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.dRE != null) {
                        BannerView.this.dRE.aVf();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.dRw)) {
                    TiebaStatic.log(BannerView.this.dRw);
                }
                if (BannerView.this.dRE == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.aOY().b(BannerView.this.duG, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.duG.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.duG.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.dRE.aVe();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.dRy = (Button) findViewById(R.id.btn_close);
        this.dRy.setOnClickListener(this.dRF);
        this.dRz = (TbImageView) findViewById(R.id.banner_image);
        this.dRz.setAutoChangeStyle(true);
        this.dRz.setOnClickListener(this.dRF);
        this.dRA = (TbImageView) findViewById(R.id.tv_advert);
        this.aPe = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.aPe, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.dRz != null && aVar != null) {
            this.dRz.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.dRA.setVisibility(0);
        } else {
            this.dRA.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.duG = tbPageContext;
        this.link = str2;
        this.dRC = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.dRC) {
            ViewGroup.LayoutParams layoutParams = this.dRz.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.dRB) + 0.5d);
            this.dRz.setLayoutParams(layoutParams);
            this.dRz.a(str, 10, 640, 108, false);
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
        this.dRE = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aPe.setBackgroundColor(i);
    }

    public boolean aVc() {
        return this.dRC;
    }

    public TbImageView getBannerView() {
        return this.dRz;
    }

    public void reset() {
        this.mIsClose = false;
        this.dRC = false;
    }

    public void aVd() {
        this.dRz.postInvalidate();
    }
}
