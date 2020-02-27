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
    private TbPageContext<?> cVg;
    private String dqY;
    private String dqZ;
    protected Button dra;
    protected TbImageView drb;
    private TbImageView drc;
    private float drd;
    private boolean dre;
    private y drf;
    private a drg;
    View.OnClickListener drh;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aMA();

        void aMB();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(y yVar) {
        this.drf = yVar;
        s.a(this.drf.cOR, this.drc, this.drf.cOS, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.dqY = str;
            this.dqZ = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dqY = "";
        this.dqZ = "";
        this.mIsClose = false;
        this.drd = 0.16875f;
        this.dre = false;
        this.drh = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.dra) {
                    if (!TextUtils.isEmpty(BannerView.this.dqZ)) {
                        TiebaStatic.log(BannerView.this.dqZ);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.drg != null) {
                        BannerView.this.drg.aMB();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.dqY)) {
                    TiebaStatic.log(BannerView.this.dqY);
                }
                if (BannerView.this.drg == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.aGE().b(BannerView.this.cVg, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.cVg.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.cVg.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.drg.aMA();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.dra = (Button) findViewById(R.id.btn_close);
        this.dra.setOnClickListener(this.drh);
        this.drb = (TbImageView) findViewById(R.id.banner_image);
        this.drb.setAutoChangeStyle(true);
        this.drb.setOnClickListener(this.drh);
        this.drc = (TbImageView) findViewById(R.id.tv_advert);
        this.avq = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.avq, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.drb != null && aVar != null) {
            this.drb.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.drc.setVisibility(0);
        } else {
            this.drc.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.cVg = tbPageContext;
        this.link = str2;
        this.dre = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.dre) {
            ViewGroup.LayoutParams layoutParams = this.drb.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.drd) + 0.5d);
            this.drb.setLayoutParams(layoutParams);
            this.drb.a(str, 10, 640, 108, false);
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
        this.drg = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avq.setBackgroundColor(i);
    }

    public boolean aMy() {
        return this.dre;
    }

    public TbImageView getBannerView() {
        return this.drb;
    }

    public void reset() {
        this.mIsClose = false;
        this.dre = false;
    }

    public void aMz() {
        this.drb.postInvalidate();
    }
}
