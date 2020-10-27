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
    private TbPageContext<?> eCn;
    private String fcg;
    private String fch;
    protected Button fci;
    protected TbImageView fcj;
    private TbImageView fck;
    private View fcl;
    private float fcm;
    private boolean fcn;
    private ad fco;
    private a fcq;
    View.OnClickListener fcr;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bvg();

        void bvh();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ad adVar) {
        this.fco = adVar;
        s.a(this.fco.evf, this.fck, this.fco.evg, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.fcg = str;
            this.fch = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fcg = "";
        this.fch = "";
        this.mIsClose = false;
        this.fcm = 0.16875f;
        this.fcn = false;
        this.fcr = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.fci) {
                    if (!TextUtils.isEmpty(BannerView.this.fch)) {
                        TiebaStatic.log(BannerView.this.fch);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.fcq != null) {
                        BannerView.this.fcq.bvh();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.fcg)) {
                    TiebaStatic.log(BannerView.this.fcg);
                }
                if (BannerView.this.fcq == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        be.boR().b(BannerView.this.eCn, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.eCn.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.eCn.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.fcq.bvg();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.fci = (Button) findViewById(R.id.btn_close);
        this.fci.setOnClickListener(this.fcr);
        this.fcj = (TbImageView) findViewById(R.id.banner_image);
        this.fcj.setAutoChangeStyle(true);
        this.fcj.setOnClickListener(this.fcr);
        this.fck = (TbImageView) findViewById(R.id.tv_advert);
        this.fcl = findViewById(R.id.banner_mask);
        ap.setBackgroundColor(this.fcl, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.fcj != null && aVar != null) {
            this.fcj.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.fck.setVisibility(0);
        } else {
            this.fck.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.eCn = tbPageContext;
        this.link = str2;
        this.fcn = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.fcn) {
            ViewGroup.LayoutParams layoutParams = this.fcj.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.fcm) + 0.5d);
            this.fcj.setLayoutParams(layoutParams);
            this.fcj.a(str, 10, 640, 108, false);
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
        this.fcq = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.fcl.setBackgroundColor(i);
    }

    public boolean bve() {
        return this.fcn;
    }

    public TbImageView getBannerView() {
        return this.fcj;
    }

    public void reset() {
        this.mIsClose = false;
        this.fcn = false;
    }

    public void bvf() {
        this.fcj.postInvalidate();
    }
}
