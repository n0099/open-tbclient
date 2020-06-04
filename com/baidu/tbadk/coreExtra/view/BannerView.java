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
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> dIF;
    private String efU;
    private String efV;
    protected Button efW;
    protected TbImageView efX;
    private TbImageView efY;
    private View efZ;
    private float ega;
    private boolean egb;
    private x egc;
    private a egd;
    View.OnClickListener ege;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bbn();

        void bbo();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.egc = xVar;
        r.a(this.egc.dCq, this.efY, this.egc.dCr, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.efU = str;
            this.efV = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efU = "";
        this.efV = "";
        this.mIsClose = false;
        this.ega = 0.16875f;
        this.egb = false;
        this.ege = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.efW) {
                    if (!TextUtils.isEmpty(BannerView.this.efV)) {
                        TiebaStatic.log(BannerView.this.efV);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.egd != null) {
                        BannerView.this.egd.bbo();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.efU)) {
                    TiebaStatic.log(BannerView.this.efU);
                }
                if (BannerView.this.egd == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.aVa().b(BannerView.this.dIF, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.dIF.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.dIF.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.egd.bbn();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.efW = (Button) findViewById(R.id.btn_close);
        this.efW.setOnClickListener(this.ege);
        this.efX = (TbImageView) findViewById(R.id.banner_image);
        this.efX.setAutoChangeStyle(true);
        this.efX.setOnClickListener(this.ege);
        this.efY = (TbImageView) findViewById(R.id.tv_advert);
        this.efZ = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.efZ, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.efX != null && aVar != null) {
            this.efX.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.efY.setVisibility(0);
        } else {
            this.efY.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.dIF = tbPageContext;
        this.link = str2;
        this.egb = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.egb) {
            ViewGroup.LayoutParams layoutParams = this.efX.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.ega) + 0.5d);
            this.efX.setLayoutParams(layoutParams);
            this.efX.a(str, 10, 640, 108, false);
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
        this.egd = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.efZ.setBackgroundColor(i);
    }

    public boolean bbl() {
        return this.egb;
    }

    public TbImageView getBannerView() {
        return this.efX;
    }

    public void reset() {
        this.mIsClose = false;
        this.egb = false;
    }

    public void bbm() {
        this.efX.postInvalidate();
    }
}
