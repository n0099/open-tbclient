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
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> eNx;
    private String foF;
    private String foG;
    protected Button foH;
    protected TbImageView foI;
    private TbImageView foJ;
    private View foK;
    private float foL;
    private boolean foM;
    private ae foN;
    private a foO;
    View.OnClickListener foP;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bAv();

        void bAw();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ae aeVar) {
        this.foN = aeVar;
        s.a(this.foN.eGo, this.foJ, this.foN.eGp, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.foF = str;
            this.foG = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foF = "";
        this.foG = "";
        this.mIsClose = false;
        this.foL = 0.16875f;
        this.foM = false;
        this.foP = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.foH) {
                    if (!TextUtils.isEmpty(BannerView.this.foG)) {
                        TiebaStatic.log(BannerView.this.foG);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.foO != null) {
                        BannerView.this.foO.bAw();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.foF)) {
                    TiebaStatic.log(BannerView.this.foF);
                }
                if (BannerView.this.foO == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        bf.bua().b(BannerView.this.eNx, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.eNx.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.eNx.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.foO.bAv();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.foH = (Button) findViewById(R.id.btn_close);
        this.foH.setOnClickListener(this.foP);
        this.foI = (TbImageView) findViewById(R.id.banner_image);
        this.foI.setAutoChangeStyle(true);
        this.foI.setOnClickListener(this.foP);
        this.foJ = (TbImageView) findViewById(R.id.tv_advert);
        this.foK = findViewById(R.id.banner_mask);
        ap.setBackgroundColor(this.foK, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.foI != null && aVar != null) {
            this.foI.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.foJ.setVisibility(0);
        } else {
            this.foJ.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.eNx = tbPageContext;
        this.link = str2;
        this.foM = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.foM) {
            ViewGroup.LayoutParams layoutParams = this.foI.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.foL) + 0.5d);
            this.foI.setLayoutParams(layoutParams);
            this.foI.a(str, 10, 640, 108, false);
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
        this.foO = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.foK.setBackgroundColor(i);
    }

    public boolean bAt() {
        return this.foM;
    }

    public TbImageView getBannerView() {
        return this.foI;
    }

    public void reset() {
        this.mIsClose = false;
        this.foM = false;
    }

    public void bAu() {
        this.foI.postInvalidate();
    }
}
