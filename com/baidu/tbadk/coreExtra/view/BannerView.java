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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> dVN;
    private String euU;
    private String euV;
    protected Button euW;
    protected TbImageView euX;
    private TbImageView euY;
    private View euZ;
    private float eva;
    private boolean evb;
    private ac evc;
    private a evd;
    View.OnClickListener eve;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bgW();

        void bgX();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ac acVar) {
        this.evc = acVar;
        s.a(this.evc.dOW, this.euY, this.evc.dOX, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.euU = str;
            this.euV = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.euU = "";
        this.euV = "";
        this.mIsClose = false;
        this.eva = 0.16875f;
        this.evb = false;
        this.eve = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.euW) {
                    if (!TextUtils.isEmpty(BannerView.this.euV)) {
                        TiebaStatic.log(BannerView.this.euV);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.evd != null) {
                        BannerView.this.evd.bgX();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.euU)) {
                    TiebaStatic.log(BannerView.this.euU);
                }
                if (BannerView.this.evd == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        bd.baV().b(BannerView.this.dVN, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.dVN.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.dVN.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.evd.bgW();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.euW = (Button) findViewById(R.id.btn_close);
        this.euW.setOnClickListener(this.eve);
        this.euX = (TbImageView) findViewById(R.id.banner_image);
        this.euX.setAutoChangeStyle(true);
        this.euX.setOnClickListener(this.eve);
        this.euY = (TbImageView) findViewById(R.id.tv_advert);
        this.euZ = findViewById(R.id.banner_mask);
        ao.setBackgroundColor(this.euZ, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.euX != null && aVar != null) {
            this.euX.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.euY.setVisibility(0);
        } else {
            this.euY.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.dVN = tbPageContext;
        this.link = str2;
        this.evb = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.evb) {
            ViewGroup.LayoutParams layoutParams = this.euX.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.eva) + 0.5d);
            this.euX.setLayoutParams(layoutParams);
            this.euX.a(str, 10, 640, 108, false);
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
        this.evd = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.euZ.setBackgroundColor(i);
    }

    public boolean bgU() {
        return this.evb;
    }

    public TbImageView getBannerView() {
        return this.euX;
    }

    public void reset() {
        this.mIsClose = false;
        this.evb = false;
    }

    public void bgV() {
        this.euX.postInvalidate();
    }
}
