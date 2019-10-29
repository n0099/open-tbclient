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
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private View aiX;
    private TbPageContext<?> cfl;
    private String czL;
    private String czM;
    protected Button czN;
    protected TbImageView czO;
    private TbImageView czP;
    private boolean czQ;
    private float czR;
    private boolean czS;
    private x czT;
    private a czU;
    View.OnClickListener czV;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void asn();

        void aso();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.czT = xVar;
        s.a(this.czT.bZc, this.czP, this.czT.bZd, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.czL = str;
            this.czM = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czL = "";
        this.czM = "";
        this.czQ = false;
        this.czR = 0.16875f;
        this.czS = false;
        this.czV = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.czN) {
                    if (!TextUtils.isEmpty(BannerView.this.czM)) {
                        TiebaStatic.log(BannerView.this.czM);
                    }
                    BannerView.this.czQ = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.czU != null) {
                        BannerView.this.czU.aso();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.czL)) {
                    TiebaStatic.log(BannerView.this.czL);
                }
                if (BannerView.this.czU == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.amQ().b(BannerView.this.cfl, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.cfl.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.cfl.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.czU.asn();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.czN = (Button) findViewById(R.id.btn_close);
        this.czN.setOnClickListener(this.czV);
        this.czO = (TbImageView) findViewById(R.id.banner_image);
        this.czO.setAutoChangeStyle(true);
        this.czO.setOnClickListener(this.czV);
        this.czP = (TbImageView) findViewById(R.id.tv_advert);
        this.aiX = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.aiX, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.czO != null && aVar != null) {
            this.czO.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.czP.setVisibility(0);
        } else {
            this.czP.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.cfl = tbPageContext;
        this.link = str2;
        this.czS = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.czQ && this.czS) {
            ViewGroup.LayoutParams layoutParams = this.czO.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.czR) + 0.5d);
            this.czO.setLayoutParams(layoutParams);
            this.czO.a(str, 10, 640, 108, false);
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
        this.czU = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aiX.setBackgroundColor(i);
    }

    public boolean asl() {
        return this.czS;
    }

    public TbImageView getBannerView() {
        return this.czO;
    }

    public void reset() {
        this.czQ = false;
        this.czS = false;
    }

    public void asm() {
        this.czO.postInvalidate();
    }
}
