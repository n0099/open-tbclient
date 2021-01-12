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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> eSJ;
    private String ftG;
    private String ftH;
    protected Button ftI;
    protected TbImageView ftJ;
    private TbImageView ftK;
    private View ftL;
    private float ftM;
    private boolean ftN;
    private ae ftO;
    private a ftP;
    private String link;
    private boolean mIsClose;
    View.OnClickListener onClickListener;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void byW();

        void byX();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ae aeVar) {
        this.ftO = aeVar;
        s.a(this.ftO.eLt, this.ftK, this.ftO.eLu, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.ftG = str;
            this.ftH = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftG = "";
        this.ftH = "";
        this.mIsClose = false;
        this.ftM = 0.16875f;
        this.ftN = false;
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.ftI) {
                    if (!TextUtils.isEmpty(BannerView.this.ftH)) {
                        TiebaStatic.log(BannerView.this.ftH);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.ftP != null) {
                        BannerView.this.ftP.byX();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.ftG)) {
                    TiebaStatic.log(BannerView.this.ftG);
                }
                if (BannerView.this.ftP == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        be.bsB().b(BannerView.this.eSJ, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.eSJ.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.eSJ.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.ftP.byW();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.ftI = (Button) findViewById(R.id.btn_close);
        this.ftI.setOnClickListener(this.onClickListener);
        this.ftJ = (TbImageView) findViewById(R.id.banner_image);
        this.ftJ.setAutoChangeStyle(true);
        this.ftJ.setOnClickListener(this.onClickListener);
        this.ftK = (TbImageView) findViewById(R.id.tv_advert);
        this.ftL = findViewById(R.id.banner_mask);
        ao.setBackgroundColor(this.ftL, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.b bVar) {
        if (this.ftJ != null && bVar != null) {
            this.ftJ.setEvent(bVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.ftK.setVisibility(0);
        } else {
            this.ftK.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.eSJ = tbPageContext;
        this.link = str2;
        this.ftN = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.ftN) {
            ViewGroup.LayoutParams layoutParams = this.ftJ.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.ftM) + 0.5d);
            this.ftJ.setLayoutParams(layoutParams);
            this.ftJ.a(str, 10, 640, 108, false);
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
        this.ftP = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.ftL.setBackgroundColor(i);
    }

    public boolean byU() {
        return this.ftN;
    }

    public TbImageView getBannerView() {
        return this.ftJ;
    }

    public void reset() {
        this.mIsClose = false;
        this.ftN = false;
    }

    public void byV() {
        this.ftJ.postInvalidate();
    }
}
