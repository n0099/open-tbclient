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
    private TbPageContext<?> eXu;
    private String fyo;
    private String fyp;
    protected Button fyq;
    protected TbImageView fyr;
    private TbImageView fys;
    private View fyt;
    private float fyu;
    private boolean fyv;
    private ae fyw;
    private a fyx;
    private String link;
    private boolean mIsClose;
    View.OnClickListener onClickListener;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void bCQ();

        void bCR();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(ae aeVar) {
        this.fyw = aeVar;
        s.a(this.fyw.eQe, this.fys, this.fyw.eQf, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.fyo = str;
            this.fyp = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyo = "";
        this.fyp = "";
        this.mIsClose = false;
        this.fyu = 0.16875f;
        this.fyv = false;
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.fyq) {
                    if (!TextUtils.isEmpty(BannerView.this.fyp)) {
                        TiebaStatic.log(BannerView.this.fyp);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.fyx != null) {
                        BannerView.this.fyx.bCR();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.fyo)) {
                    TiebaStatic.log(BannerView.this.fyo);
                }
                if (BannerView.this.fyx == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        be.bwv().b(BannerView.this.eXu, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.eXu.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.eXu.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.fyx.bCQ();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.fyq = (Button) findViewById(R.id.btn_close);
        this.fyq.setOnClickListener(this.onClickListener);
        this.fyr = (TbImageView) findViewById(R.id.banner_image);
        this.fyr.setAutoChangeStyle(true);
        this.fyr.setOnClickListener(this.onClickListener);
        this.fys = (TbImageView) findViewById(R.id.tv_advert);
        this.fyt = findViewById(R.id.banner_mask);
        ao.setBackgroundColor(this.fyt, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.b bVar) {
        if (this.fyr != null && bVar != null) {
            this.fyr.setEvent(bVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.fys.setVisibility(0);
        } else {
            this.fys.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.eXu = tbPageContext;
        this.link = str2;
        this.fyv = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.fyv) {
            ViewGroup.LayoutParams layoutParams = this.fyr.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.fyu) + 0.5d);
            this.fyr.setLayoutParams(layoutParams);
            this.fyr.a(str, 10, 640, 108, false);
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
        this.fyx = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.fyt.setBackgroundColor(i);
    }

    public boolean bCO() {
        return this.fyv;
    }

    public TbImageView getBannerView() {
        return this.fyr;
    }

    public void reset() {
        this.mIsClose = false;
        this.fyv = false;
    }

    public void bCP() {
        this.fyr.postInvalidate();
    }
}
