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
    private TbImageView eFA;
    private View eFB;
    private float eFC;
    private boolean eFD;
    private ad eFE;
    private a eFF;
    View.OnClickListener eFG;
    private String eFw;
    private String eFx;
    protected Button eFy;
    protected TbImageView eFz;
    private TbPageContext<?> efr;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bpJ();

        void bpK();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ad adVar) {
        this.eFE = adVar;
        s.a(this.eFE.dYt, this.eFA, this.eFE.dYu, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.eFw = str;
            this.eFx = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFw = "";
        this.eFx = "";
        this.mIsClose = false;
        this.eFC = 0.16875f;
        this.eFD = false;
        this.eFG = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.eFy) {
                    if (!TextUtils.isEmpty(BannerView.this.eFx)) {
                        TiebaStatic.log(BannerView.this.eFx);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.eFF != null) {
                        BannerView.this.eFF.bpK();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.eFw)) {
                    TiebaStatic.log(BannerView.this.eFw);
                }
                if (BannerView.this.eFF == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        be.bju().b(BannerView.this.efr, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.efr.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.efr.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.eFF.bpJ();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.eFy = (Button) findViewById(R.id.btn_close);
        this.eFy.setOnClickListener(this.eFG);
        this.eFz = (TbImageView) findViewById(R.id.banner_image);
        this.eFz.setAutoChangeStyle(true);
        this.eFz.setOnClickListener(this.eFG);
        this.eFA = (TbImageView) findViewById(R.id.tv_advert);
        this.eFB = findViewById(R.id.banner_mask);
        ap.setBackgroundColor(this.eFB, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.eFz != null && aVar != null) {
            this.eFz.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.eFA.setVisibility(0);
        } else {
            this.eFA.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.efr = tbPageContext;
        this.link = str2;
        this.eFD = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.eFD) {
            ViewGroup.LayoutParams layoutParams = this.eFz.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.eFC) + 0.5d);
            this.eFz.setLayoutParams(layoutParams);
            this.eFz.a(str, 10, 640, 108, false);
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
        this.eFF = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.eFB.setBackgroundColor(i);
    }

    public boolean bpH() {
        return this.eFD;
    }

    public TbImageView getBannerView() {
        return this.eFz;
    }

    public void reset() {
        this.mIsClose = false;
        this.eFD = false;
    }

    public void bpI() {
        this.eFz.postInvalidate();
    }
}
