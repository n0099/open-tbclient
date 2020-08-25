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
/* loaded from: classes2.dex */
public class BannerView extends RelativeLayout {
    private ad eFA;
    private a eFB;
    View.OnClickListener eFC;
    private String eFs;
    private String eFt;
    protected Button eFu;
    protected TbImageView eFv;
    private TbImageView eFw;
    private View eFx;
    private float eFy;
    private boolean eFz;
    private TbPageContext<?> efn;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes2.dex */
    public interface a {
        void bpI();

        void bpJ();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ad adVar) {
        this.eFA = adVar;
        s.a(this.eFA.dYp, this.eFw, this.eFA.dYq, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.eFs = str;
            this.eFt = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFs = "";
        this.eFt = "";
        this.mIsClose = false;
        this.eFy = 0.16875f;
        this.eFz = false;
        this.eFC = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.eFu) {
                    if (!TextUtils.isEmpty(BannerView.this.eFt)) {
                        TiebaStatic.log(BannerView.this.eFt);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.eFB != null) {
                        BannerView.this.eFB.bpJ();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.eFs)) {
                    TiebaStatic.log(BannerView.this.eFs);
                }
                if (BannerView.this.eFB == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        be.bju().b(BannerView.this.efn, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.efn.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.efn.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.eFB.bpI();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.eFu = (Button) findViewById(R.id.btn_close);
        this.eFu.setOnClickListener(this.eFC);
        this.eFv = (TbImageView) findViewById(R.id.banner_image);
        this.eFv.setAutoChangeStyle(true);
        this.eFv.setOnClickListener(this.eFC);
        this.eFw = (TbImageView) findViewById(R.id.tv_advert);
        this.eFx = findViewById(R.id.banner_mask);
        ap.setBackgroundColor(this.eFx, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.eFv != null && aVar != null) {
            this.eFv.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.eFw.setVisibility(0);
        } else {
            this.eFw.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.efn = tbPageContext;
        this.link = str2;
        this.eFz = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.eFz) {
            ViewGroup.LayoutParams layoutParams = this.eFv.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.eFy) + 0.5d);
            this.eFv.setLayoutParams(layoutParams);
            this.eFv.a(str, 10, 640, 108, false);
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
        this.eFB = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.eFx.setBackgroundColor(i);
    }

    public boolean bpG() {
        return this.eFz;
    }

    public TbImageView getBannerView() {
        return this.eFv;
    }

    public void reset() {
        this.mIsClose = false;
        this.eFz = false;
    }

    public void bpH() {
        this.eFv.postInvalidate();
    }
}
