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
    private View arp;
    private TbPageContext<?> cRe;
    private String dmP;
    private String dmQ;
    protected Button dmR;
    protected TbImageView dmS;
    private TbImageView dmT;
    private float dmU;
    private boolean dmV;
    private y dmW;
    private a dmX;
    View.OnClickListener dmY;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aKe();

        void aKf();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(y yVar) {
        this.dmW = yVar;
        s.a(this.dmW.cKO, this.dmT, this.dmW.cKP, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.dmP = str;
            this.dmQ = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmP = "";
        this.dmQ = "";
        this.mIsClose = false;
        this.dmU = 0.16875f;
        this.dmV = false;
        this.dmY = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.dmR) {
                    if (!TextUtils.isEmpty(BannerView.this.dmQ)) {
                        TiebaStatic.log(BannerView.this.dmQ);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.dmX != null) {
                        BannerView.this.dmX.aKf();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.dmP)) {
                    TiebaStatic.log(BannerView.this.dmP);
                }
                if (BannerView.this.dmX == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.aEt().b(BannerView.this.cRe, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.cRe.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.cRe.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.dmX.aKe();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.dmR = (Button) findViewById(R.id.btn_close);
        this.dmR.setOnClickListener(this.dmY);
        this.dmS = (TbImageView) findViewById(R.id.banner_image);
        this.dmS.setAutoChangeStyle(true);
        this.dmS.setOnClickListener(this.dmY);
        this.dmT = (TbImageView) findViewById(R.id.tv_advert);
        this.arp = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.arp, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.dmS != null && aVar != null) {
            this.dmS.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.dmT.setVisibility(0);
        } else {
            this.dmT.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.cRe = tbPageContext;
        this.link = str2;
        this.dmV = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.dmV) {
            ViewGroup.LayoutParams layoutParams = this.dmS.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.dmU) + 0.5d);
            this.dmS.setLayoutParams(layoutParams);
            this.dmS.a(str, 10, 640, 108, false);
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
        this.dmX = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.arp.setBackgroundColor(i);
    }

    public boolean aKc() {
        return this.dmV;
    }

    public TbImageView getBannerView() {
        return this.dmS;
    }

    public void reset() {
        this.mIsClose = false;
        this.dmV = false;
    }

    public void aKd() {
        this.dmS.postInvalidate();
    }
}
