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
    private View aPk;
    private String dRB;
    private String dRC;
    protected Button dRD;
    protected TbImageView dRE;
    private TbImageView dRF;
    private float dRG;
    private boolean dRH;
    private y dRI;
    private a dRJ;
    View.OnClickListener dRK;
    private TbPageContext<?> duK;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aVc();

        void aVd();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(y yVar) {
        this.dRI = yVar;
        r.a(this.dRI.doq, this.dRF, this.dRI.dor, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.dRB = str;
            this.dRC = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRB = "";
        this.dRC = "";
        this.mIsClose = false;
        this.dRG = 0.16875f;
        this.dRH = false;
        this.dRK = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.dRD) {
                    if (!TextUtils.isEmpty(BannerView.this.dRC)) {
                        TiebaStatic.log(BannerView.this.dRC);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.dRJ != null) {
                        BannerView.this.dRJ.aVd();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.dRB)) {
                    TiebaStatic.log(BannerView.this.dRB);
                }
                if (BannerView.this.dRJ == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.aOV().b(BannerView.this.duK, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.duK.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.duK.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.dRJ.aVc();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.dRD = (Button) findViewById(R.id.btn_close);
        this.dRD.setOnClickListener(this.dRK);
        this.dRE = (TbImageView) findViewById(R.id.banner_image);
        this.dRE.setAutoChangeStyle(true);
        this.dRE.setOnClickListener(this.dRK);
        this.dRF = (TbImageView) findViewById(R.id.tv_advert);
        this.aPk = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.aPk, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.dRE != null && aVar != null) {
            this.dRE.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.dRF.setVisibility(0);
        } else {
            this.dRF.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.duK = tbPageContext;
        this.link = str2;
        this.dRH = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.dRH) {
            ViewGroup.LayoutParams layoutParams = this.dRE.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.dRG) + 0.5d);
            this.dRE.setLayoutParams(layoutParams);
            this.dRE.a(str, 10, 640, 108, false);
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
        this.dRJ = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aPk.setBackgroundColor(i);
    }

    public boolean aVa() {
        return this.dRH;
    }

    public TbImageView getBannerView() {
        return this.dRE;
    }

    public void reset() {
        this.mIsClose = false;
        this.dRH = false;
    }

    public void aVb() {
        this.dRE.postInvalidate();
    }
}
