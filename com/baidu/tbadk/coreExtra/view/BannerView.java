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
    private View avq;
    private TbPageContext<?> cVh;
    private String dqZ;
    private String dra;
    protected Button drb;
    protected TbImageView drc;
    private TbImageView drd;
    private float dre;
    private boolean drf;
    private y drg;
    private a drh;
    View.OnClickListener dri;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aMC();

        void aMD();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(y yVar) {
        this.drg = yVar;
        s.a(this.drg.cOS, this.drd, this.drg.cOT, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.dqZ = str;
            this.dra = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dqZ = "";
        this.dra = "";
        this.mIsClose = false;
        this.dre = 0.16875f;
        this.drf = false;
        this.dri = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.drb) {
                    if (!TextUtils.isEmpty(BannerView.this.dra)) {
                        TiebaStatic.log(BannerView.this.dra);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.drh != null) {
                        BannerView.this.drh.aMD();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.dqZ)) {
                    TiebaStatic.log(BannerView.this.dqZ);
                }
                if (BannerView.this.drh == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.aGG().b(BannerView.this.cVh, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.cVh.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.cVh.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.drh.aMC();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.drb = (Button) findViewById(R.id.btn_close);
        this.drb.setOnClickListener(this.dri);
        this.drc = (TbImageView) findViewById(R.id.banner_image);
        this.drc.setAutoChangeStyle(true);
        this.drc.setOnClickListener(this.dri);
        this.drd = (TbImageView) findViewById(R.id.tv_advert);
        this.avq = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.avq, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.drc != null && aVar != null) {
            this.drc.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.drd.setVisibility(0);
        } else {
            this.drd.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.cVh = tbPageContext;
        this.link = str2;
        this.drf = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.drf) {
            ViewGroup.LayoutParams layoutParams = this.drc.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.dre) + 0.5d);
            this.drc.setLayoutParams(layoutParams);
            this.drc.a(str, 10, 640, 108, false);
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
        this.drh = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avq.setBackgroundColor(i);
    }

    public boolean aMA() {
        return this.drf;
    }

    public TbImageView getBannerView() {
        return this.drc;
    }

    public void reset() {
        this.mIsClose = false;
        this.drf = false;
    }

    public void aMB() {
        this.drc.postInvalidate();
    }
}
