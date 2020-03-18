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
    private View avB;
    private TbPageContext<?> cVv;
    private String drA;
    private String drB;
    protected Button drC;
    protected TbImageView drD;
    private TbImageView drE;
    private float drF;
    private boolean drG;
    private y drH;
    private a drI;
    View.OnClickListener drJ;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aMH();

        void aMI();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(y yVar) {
        this.drH = yVar;
        s.a(this.drH.cPg, this.drE, this.drH.cPh, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.drA = str;
            this.drB = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drA = "";
        this.drB = "";
        this.mIsClose = false;
        this.drF = 0.16875f;
        this.drG = false;
        this.drJ = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.drC) {
                    if (!TextUtils.isEmpty(BannerView.this.drB)) {
                        TiebaStatic.log(BannerView.this.drB);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.drI != null) {
                        BannerView.this.drI.aMI();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.drA)) {
                    TiebaStatic.log(BannerView.this.drA);
                }
                if (BannerView.this.drI == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.aGK().b(BannerView.this.cVv, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.cVv.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.cVv.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.drI.aMH();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.drC = (Button) findViewById(R.id.btn_close);
        this.drC.setOnClickListener(this.drJ);
        this.drD = (TbImageView) findViewById(R.id.banner_image);
        this.drD.setAutoChangeStyle(true);
        this.drD.setOnClickListener(this.drJ);
        this.drE = (TbImageView) findViewById(R.id.tv_advert);
        this.avB = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.avB, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.drD != null && aVar != null) {
            this.drD.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.drE.setVisibility(0);
        } else {
            this.drE.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.cVv = tbPageContext;
        this.link = str2;
        this.drG = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.drG) {
            ViewGroup.LayoutParams layoutParams = this.drD.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.drF) + 0.5d);
            this.drD.setLayoutParams(layoutParams);
            this.drD.a(str, 10, 640, 108, false);
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
        this.drI = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avB.setBackgroundColor(i);
    }

    public boolean aMF() {
        return this.drG;
    }

    public TbImageView getBannerView() {
        return this.drD;
    }

    public void reset() {
        this.mIsClose = false;
        this.drG = false;
    }

    public void aMG() {
        this.drD.postInvalidate();
    }
}
