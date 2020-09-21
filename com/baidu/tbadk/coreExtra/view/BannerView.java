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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private String eHD;
    private String eHE;
    protected Button eHF;
    protected TbImageView eHG;
    private TbImageView eHH;
    private View eHI;
    private float eHJ;
    private boolean eHK;
    private ad eHL;
    private a eHM;
    View.OnClickListener eHN;
    private TbPageContext<?> ehG;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bqD();

        void bqE();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ad adVar) {
        this.eHL = adVar;
        s.a(this.eHL.eaD, this.eHH, this.eHL.eaE, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.eHD = str;
            this.eHE = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHD = "";
        this.eHE = "";
        this.mIsClose = false;
        this.eHJ = 0.16875f;
        this.eHK = false;
        this.eHN = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.eHF) {
                    if (!TextUtils.isEmpty(BannerView.this.eHE)) {
                        TiebaStatic.log(BannerView.this.eHE);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.eHM != null) {
                        BannerView.this.eHM.bqE();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.eHD)) {
                    TiebaStatic.log(BannerView.this.eHD);
                }
                if (BannerView.this.eHM == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        be.bkp().b(BannerView.this.ehG, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.ehG.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.ehG.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.eHM.bqD();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.eHF = (Button) findViewById(R.id.btn_close);
        this.eHF.setOnClickListener(this.eHN);
        this.eHG = (TbImageView) findViewById(R.id.banner_image);
        this.eHG.setAutoChangeStyle(true);
        this.eHG.setOnClickListener(this.eHN);
        this.eHH = (TbImageView) findViewById(R.id.tv_advert);
        this.eHI = findViewById(R.id.banner_mask);
        ap.setBackgroundColor(this.eHI, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.eHG != null && aVar != null) {
            this.eHG.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.eHH.setVisibility(0);
        } else {
            this.eHH.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.ehG = tbPageContext;
        this.link = str2;
        this.eHK = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.eHK) {
            ViewGroup.LayoutParams layoutParams = this.eHG.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.eHJ) + 0.5d);
            this.eHG.setLayoutParams(layoutParams);
            this.eHG.a(str, 10, 640, 108, false);
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
        this.eHM = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.eHI.setBackgroundColor(i);
    }

    public boolean bqB() {
        return this.eHK;
    }

    public TbImageView getBannerView() {
        return this.eHG;
    }

    public void reset() {
        this.mIsClose = false;
        this.eHK = false;
    }

    public void bqC() {
        this.eHG.postInvalidate();
    }
}
