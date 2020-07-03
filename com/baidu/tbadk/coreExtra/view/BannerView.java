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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> dPv;
    private String eoF;
    private String eoG;
    protected Button eoH;
    protected TbImageView eoI;
    private TbImageView eoJ;
    private View eoK;
    private float eoL;
    private boolean eoM;
    private ab eoN;
    private a eoO;
    View.OnClickListener eoP;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bdp();

        void bdq();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ab abVar) {
        this.eoN = abVar;
        r.a(this.eoN.dIL, this.eoJ, this.eoN.dIM, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.eoF = str;
            this.eoG = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eoF = "";
        this.eoG = "";
        this.mIsClose = false;
        this.eoL = 0.16875f;
        this.eoM = false;
        this.eoP = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.eoH) {
                    if (!TextUtils.isEmpty(BannerView.this.eoG)) {
                        TiebaStatic.log(BannerView.this.eoG);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.eoO != null) {
                        BannerView.this.eoO.bdq();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.eoF)) {
                    TiebaStatic.log(BannerView.this.eoF);
                }
                if (BannerView.this.eoO == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        bc.aWU().b(BannerView.this.dPv, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.dPv.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.dPv.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.eoO.bdp();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.eoH = (Button) findViewById(R.id.btn_close);
        this.eoH.setOnClickListener(this.eoP);
        this.eoI = (TbImageView) findViewById(R.id.banner_image);
        this.eoI.setAutoChangeStyle(true);
        this.eoI.setOnClickListener(this.eoP);
        this.eoJ = (TbImageView) findViewById(R.id.tv_advert);
        this.eoK = findViewById(R.id.banner_mask);
        an.setBackgroundColor(this.eoK, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.eoI != null && aVar != null) {
            this.eoI.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.eoJ.setVisibility(0);
        } else {
            this.eoJ.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.dPv = tbPageContext;
        this.link = str2;
        this.eoM = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.eoM) {
            ViewGroup.LayoutParams layoutParams = this.eoI.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.eoL) + 0.5d);
            this.eoI.setLayoutParams(layoutParams);
            this.eoI.a(str, 10, 640, 108, false);
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
        this.eoO = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.eoK.setBackgroundColor(i);
    }

    public boolean bdn() {
        return this.eoM;
    }

    public TbImageView getBannerView() {
        return this.eoI;
    }

    public void reset() {
        this.mIsClose = false;
        this.eoM = false;
    }

    public void bdo() {
        this.eoI.postInvalidate();
    }
}
