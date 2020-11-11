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
    private TbPageContext<?> eIc;
    private String fhX;
    private String fhY;
    protected Button fhZ;
    protected TbImageView fia;
    private TbImageView fib;
    private View fic;
    private float fie;
    private boolean fif;
    private ad fig;
    private a fih;
    View.OnClickListener fii;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bxF();

        void bxG();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ad adVar) {
        this.fig = adVar;
        s.a(this.fig.eAY, this.fib, this.fig.eAZ, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.fhX = str;
            this.fhY = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhX = "";
        this.fhY = "";
        this.mIsClose = false;
        this.fie = 0.16875f;
        this.fif = false;
        this.fii = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.fhZ) {
                    if (!TextUtils.isEmpty(BannerView.this.fhY)) {
                        TiebaStatic.log(BannerView.this.fhY);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.fih != null) {
                        BannerView.this.fih.bxG();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.fhX)) {
                    TiebaStatic.log(BannerView.this.fhX);
                }
                if (BannerView.this.fih == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        be.brr().b(BannerView.this.eIc, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.eIc.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.eIc.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.fih.bxF();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.fhZ = (Button) findViewById(R.id.btn_close);
        this.fhZ.setOnClickListener(this.fii);
        this.fia = (TbImageView) findViewById(R.id.banner_image);
        this.fia.setAutoChangeStyle(true);
        this.fia.setOnClickListener(this.fii);
        this.fib = (TbImageView) findViewById(R.id.tv_advert);
        this.fic = findViewById(R.id.banner_mask);
        ap.setBackgroundColor(this.fic, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.fia != null && aVar != null) {
            this.fia.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.fib.setVisibility(0);
        } else {
            this.fib.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.eIc = tbPageContext;
        this.link = str2;
        this.fif = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.fif) {
            ViewGroup.LayoutParams layoutParams = this.fia.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.fie) + 0.5d);
            this.fia.setLayoutParams(layoutParams);
            this.fia.a(str, 10, 640, 108, false);
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
        this.fih = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.fic.setBackgroundColor(i);
    }

    public boolean bxD() {
        return this.fif;
    }

    public TbImageView getBannerView() {
        return this.fia;
    }

    public void reset() {
        this.mIsClose = false;
        this.fif = false;
    }

    public void bxE() {
        this.fia.postInvalidate();
    }
}
