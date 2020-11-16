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
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> eGu;
    private String fhf;
    private String fhg;
    protected Button fhh;
    protected TbImageView fhi;
    private TbImageView fhj;
    private View fhk;
    private float fhl;
    private boolean fhm;
    private ae fhn;
    private a fho;
    View.OnClickListener fhp;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bwV();

        void bwW();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ae aeVar) {
        this.fhn = aeVar;
        r.a(this.fhn.ezp, this.fhj, this.fhn.ezq, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.fhf = str;
            this.fhg = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhf = "";
        this.fhg = "";
        this.mIsClose = false;
        this.fhl = 0.16875f;
        this.fhm = false;
        this.fhp = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.fhh) {
                    if (!TextUtils.isEmpty(BannerView.this.fhg)) {
                        TiebaStatic.log(BannerView.this.fhg);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.fho != null) {
                        BannerView.this.fho.bwW();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.fhf)) {
                    TiebaStatic.log(BannerView.this.fhf);
                }
                if (BannerView.this.fho == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        bf.bqF().b(BannerView.this.eGu, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.eGu.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.eGu.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.fho.bwV();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.fhh = (Button) findViewById(R.id.btn_close);
        this.fhh.setOnClickListener(this.fhp);
        this.fhi = (TbImageView) findViewById(R.id.banner_image);
        this.fhi.setAutoChangeStyle(true);
        this.fhi.setOnClickListener(this.fhp);
        this.fhj = (TbImageView) findViewById(R.id.tv_advert);
        this.fhk = findViewById(R.id.banner_mask);
        ap.setBackgroundColor(this.fhk, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.fhi != null && aVar != null) {
            this.fhi.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.fhj.setVisibility(0);
        } else {
            this.fhj.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.eGu = tbPageContext;
        this.link = str2;
        this.fhm = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.fhm) {
            ViewGroup.LayoutParams layoutParams = this.fhi.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.fhl) + 0.5d);
            this.fhi.setLayoutParams(layoutParams);
            this.fhi.a(str, 10, 640, 108, false);
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
        this.fho = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.fhk.setBackgroundColor(i);
    }

    public boolean bwT() {
        return this.fhm;
    }

    public TbImageView getBannerView() {
        return this.fhi;
    }

    public void reset() {
        this.mIsClose = false;
        this.fhm = false;
    }

    public void bwU() {
        this.fhi.postInvalidate();
    }
}
