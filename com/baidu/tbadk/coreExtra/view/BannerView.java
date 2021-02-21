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
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.t;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> eUY;
    private String fvW;
    private String fvX;
    protected Button fvY;
    protected TbImageView fvZ;
    private TbImageView fwa;
    private View fwb;
    private float fwc;
    private boolean fwd;
    private af fwe;
    private a fwf;
    private String link;
    private boolean mIsClose;
    View.OnClickListener onClickListener;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bzo();

        void bzp();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(af afVar) {
        this.fwe = afVar;
        t.a(this.fwe.eNF, this.fwa, this.fwe.eNG, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.fvW = str;
            this.fvX = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fvW = "";
        this.fvX = "";
        this.mIsClose = false;
        this.fwc = 0.16875f;
        this.fwd = false;
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.fvY) {
                    if (!TextUtils.isEmpty(BannerView.this.fvX)) {
                        TiebaStatic.log(BannerView.this.fvX);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.fwf != null) {
                        BannerView.this.fwf.bzp();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.fvW)) {
                    TiebaStatic.log(BannerView.this.fvW);
                }
                if (BannerView.this.fwf == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        bf.bsV().b(BannerView.this.eUY, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.eUY.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.eUY.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.fwf.bzo();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.fvY = (Button) findViewById(R.id.btn_close);
        this.fvY.setOnClickListener(this.onClickListener);
        this.fvZ = (TbImageView) findViewById(R.id.banner_image);
        this.fvZ.setAutoChangeStyle(true);
        this.fvZ.setOnClickListener(this.onClickListener);
        this.fwa = (TbImageView) findViewById(R.id.tv_advert);
        this.fwb = findViewById(R.id.banner_mask);
        ap.setBackgroundColor(this.fwb, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.b bVar) {
        if (this.fvZ != null && bVar != null) {
            this.fvZ.setEvent(bVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.fwa.setVisibility(0);
        } else {
            this.fwa.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.eUY = tbPageContext;
        this.link = str2;
        this.fwd = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.fwd) {
            ViewGroup.LayoutParams layoutParams = this.fvZ.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.fwc) + 0.5d);
            this.fvZ.setLayoutParams(layoutParams);
            this.fvZ.a(str, 10, 640, 108, false);
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
        this.fwf = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.fwb.setBackgroundColor(i);
    }

    public boolean bzm() {
        return this.fwd;
    }

    public TbImageView getBannerView() {
        return this.fvZ;
    }

    public void reset() {
        this.mIsClose = false;
        this.fwd = false;
    }

    public void bzn() {
        this.fvZ.postInvalidate();
    }
}
