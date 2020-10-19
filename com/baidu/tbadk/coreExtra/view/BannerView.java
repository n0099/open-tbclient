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
    private String eTK;
    private String eTL;
    protected Button eTM;
    protected TbImageView eTN;
    private TbImageView eTO;
    private View eTP;
    private float eTQ;
    private boolean eTR;
    private ad eTS;
    private a eTT;
    View.OnClickListener eTU;
    private TbPageContext<?> etO;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void btn();

        void bto();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ad adVar) {
        this.eTS = adVar;
        s.a(this.eTS.emF, this.eTO, this.eTS.emG, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.eTK = str;
            this.eTL = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eTK = "";
        this.eTL = "";
        this.mIsClose = false;
        this.eTQ = 0.16875f;
        this.eTR = false;
        this.eTU = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.eTM) {
                    if (!TextUtils.isEmpty(BannerView.this.eTL)) {
                        TiebaStatic.log(BannerView.this.eTL);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.eTT != null) {
                        BannerView.this.eTT.bto();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.eTK)) {
                    TiebaStatic.log(BannerView.this.eTK);
                }
                if (BannerView.this.eTT == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        be.bmY().b(BannerView.this.etO, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.etO.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.etO.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.eTT.btn();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.eTM = (Button) findViewById(R.id.btn_close);
        this.eTM.setOnClickListener(this.eTU);
        this.eTN = (TbImageView) findViewById(R.id.banner_image);
        this.eTN.setAutoChangeStyle(true);
        this.eTN.setOnClickListener(this.eTU);
        this.eTO = (TbImageView) findViewById(R.id.tv_advert);
        this.eTP = findViewById(R.id.banner_mask);
        ap.setBackgroundColor(this.eTP, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.eTN != null && aVar != null) {
            this.eTN.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.eTO.setVisibility(0);
        } else {
            this.eTO.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.etO = tbPageContext;
        this.link = str2;
        this.eTR = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.eTR) {
            ViewGroup.LayoutParams layoutParams = this.eTN.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.eTQ) + 0.5d);
            this.eTN.setLayoutParams(layoutParams);
            this.eTN.a(str, 10, 640, 108, false);
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
        this.eTT = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.eTP.setBackgroundColor(i);
    }

    public boolean btl() {
        return this.eTR;
    }

    public TbImageView getBannerView() {
        return this.eTN;
    }

    public void reset() {
        this.mIsClose = false;
        this.eTR = false;
    }

    public void btm() {
        this.eTN.postInvalidate();
    }
}
