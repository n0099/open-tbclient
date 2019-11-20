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
    private View aiF;
    private TbPageContext<?> ceu;
    private String cyU;
    private String cyV;
    protected Button cyW;
    protected TbImageView cyX;
    private TbImageView cyY;
    private boolean cyZ;
    private float cza;
    private boolean czb;
    private x czc;
    private a czd;
    View.OnClickListener cze;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void asl();

        void asm();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.czc = xVar;
        s.a(this.czc.bYl, this.cyY, this.czc.bYm, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.cyU = str;
            this.cyV = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyU = "";
        this.cyV = "";
        this.cyZ = false;
        this.cza = 0.16875f;
        this.czb = false;
        this.cze = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.cyW) {
                    if (!TextUtils.isEmpty(BannerView.this.cyV)) {
                        TiebaStatic.log(BannerView.this.cyV);
                    }
                    BannerView.this.cyZ = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.czd != null) {
                        BannerView.this.czd.asm();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.cyU)) {
                    TiebaStatic.log(BannerView.this.cyU);
                }
                if (BannerView.this.czd == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.amO().b(BannerView.this.ceu, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.ceu.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.ceu.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.czd.asl();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.cyW = (Button) findViewById(R.id.btn_close);
        this.cyW.setOnClickListener(this.cze);
        this.cyX = (TbImageView) findViewById(R.id.banner_image);
        this.cyX.setAutoChangeStyle(true);
        this.cyX.setOnClickListener(this.cze);
        this.cyY = (TbImageView) findViewById(R.id.tv_advert);
        this.aiF = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.aiF, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.cyX != null && aVar != null) {
            this.cyX.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.cyY.setVisibility(0);
        } else {
            this.cyY.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.ceu = tbPageContext;
        this.link = str2;
        this.czb = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.cyZ && this.czb) {
            ViewGroup.LayoutParams layoutParams = this.cyX.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.cza) + 0.5d);
            this.cyX.setLayoutParams(layoutParams);
            this.cyX.a(str, 10, 640, 108, false);
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
        this.czd = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aiF.setBackgroundColor(i);
    }

    public boolean asj() {
        return this.czb;
    }

    public TbImageView getBannerView() {
        return this.cyX;
    }

    public void reset() {
        this.cyZ = false;
        this.czb = false;
    }

    public void ask() {
        this.cyX.postInvalidate();
    }
}
