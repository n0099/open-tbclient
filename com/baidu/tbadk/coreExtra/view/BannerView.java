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
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private View avr;
    private TbPageContext<?> cVi;
    private String drm;
    private String drn;
    protected Button dro;
    protected TbImageView drp;
    private TbImageView drq;
    private float drr;
    private boolean drt;
    private y dru;
    private a drv;
    View.OnClickListener drw;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aMD();

        void aME();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(y yVar) {
        this.dru = yVar;
        s.a(this.dru.cOT, this.drq, this.dru.cOU, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.drm = str;
            this.drn = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drm = "";
        this.drn = "";
        this.mIsClose = false;
        this.drr = 0.16875f;
        this.drt = false;
        this.drw = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.dro) {
                    if (!TextUtils.isEmpty(BannerView.this.drn)) {
                        TiebaStatic.log(BannerView.this.drn);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.drv != null) {
                        BannerView.this.drv.aME();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.drm)) {
                    TiebaStatic.log(BannerView.this.drm);
                }
                if (BannerView.this.drv == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.aGG().b(BannerView.this.cVi, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.cVi.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.cVi.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.drv.aMD();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.dro = (Button) findViewById(R.id.btn_close);
        this.dro.setOnClickListener(this.drw);
        this.drp = (TbImageView) findViewById(R.id.banner_image);
        this.drp.setAutoChangeStyle(true);
        this.drp.setOnClickListener(this.drw);
        this.drq = (TbImageView) findViewById(R.id.tv_advert);
        this.avr = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.avr, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.drp != null && aVar != null) {
            this.drp.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.drq.setVisibility(0);
        } else {
            this.drq.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.cVi = tbPageContext;
        this.link = str2;
        this.drt = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.drt) {
            ViewGroup.LayoutParams layoutParams = this.drp.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.drr) + 0.5d);
            this.drp.setLayoutParams(layoutParams);
            this.drp.a(str, 10, 640, 108, false);
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
        this.drv = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avr.setBackgroundColor(i);
    }

    public boolean aMB() {
        return this.drt;
    }

    public TbImageView getBannerView() {
        return this.drp;
    }

    public void reset() {
        this.mIsClose = false;
        this.drt = false;
    }

    public void aMC() {
        this.drp.postInvalidate();
    }
}
