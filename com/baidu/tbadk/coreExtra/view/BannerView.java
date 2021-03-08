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
    private TbPageContext<?> eWx;
    private View fxA;
    private float fxB;
    private boolean fxC;
    private af fxD;
    private a fxE;
    private String fxv;
    private String fxw;
    protected Button fxx;
    protected TbImageView fxy;
    private TbImageView fxz;
    private String link;
    private boolean mIsClose;
    View.OnClickListener onClickListener;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bzr();

        void bzs();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(af afVar) {
        this.fxD = afVar;
        t.a(this.fxD.ePg, this.fxz, this.fxD.ePh, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.fxv = str;
            this.fxw = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fxv = "";
        this.fxw = "";
        this.mIsClose = false;
        this.fxB = 0.16875f;
        this.fxC = false;
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.fxx) {
                    if (!TextUtils.isEmpty(BannerView.this.fxw)) {
                        TiebaStatic.log(BannerView.this.fxw);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.fxE != null) {
                        BannerView.this.fxE.bzs();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.fxv)) {
                    TiebaStatic.log(BannerView.this.fxv);
                }
                if (BannerView.this.fxE == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        bf.bsY().b(BannerView.this.eWx, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.eWx.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.eWx.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.fxE.bzr();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.fxx = (Button) findViewById(R.id.btn_close);
        this.fxx.setOnClickListener(this.onClickListener);
        this.fxy = (TbImageView) findViewById(R.id.banner_image);
        this.fxy.setAutoChangeStyle(true);
        this.fxy.setOnClickListener(this.onClickListener);
        this.fxz = (TbImageView) findViewById(R.id.tv_advert);
        this.fxA = findViewById(R.id.banner_mask);
        ap.setBackgroundColor(this.fxA, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.b bVar) {
        if (this.fxy != null && bVar != null) {
            this.fxy.setEvent(bVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.fxz.setVisibility(0);
        } else {
            this.fxz.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.eWx = tbPageContext;
        this.link = str2;
        this.fxC = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.fxC) {
            ViewGroup.LayoutParams layoutParams = this.fxy.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.fxB) + 0.5d);
            this.fxy.setLayoutParams(layoutParams);
            this.fxy.a(str, 10, 640, 108, false);
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
        this.fxE = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.fxA.setBackgroundColor(i);
    }

    public boolean bzp() {
        return this.fxC;
    }

    public TbImageView getBannerView() {
        return this.fxy;
    }

    public void reset() {
        this.mIsClose = false;
        this.fxC = false;
    }

    public void bzq() {
        this.fxy.postInvalidate();
    }
}
