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
    private View aqD;
    private TbPageContext<?> cQU;
    private String dmB;
    private String dmC;
    protected Button dmD;
    protected TbImageView dmE;
    private TbImageView dmF;
    private float dmG;
    private boolean dmH;
    private y dmI;
    private a dmJ;
    View.OnClickListener dmK;
    private String link;
    private boolean mIsClose;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void aJK();

        void aJL();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(y yVar) {
        this.dmI = yVar;
        s.a(this.dmI.cKD, this.dmF, this.dmI.cKE, l.getDimens(getContext(), R.dimen.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.dmB = str;
            this.dmC = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmB = "";
        this.dmC = "";
        this.mIsClose = false;
        this.dmG = 0.16875f;
        this.dmH = false;
        this.dmK = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.dmD) {
                    if (!TextUtils.isEmpty(BannerView.this.dmC)) {
                        TiebaStatic.log(BannerView.this.dmC);
                    }
                    BannerView.this.mIsClose = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.dmJ != null) {
                        BannerView.this.dmJ.aJL();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.dmB)) {
                    TiebaStatic.log(BannerView.this.dmB);
                }
                if (BannerView.this.dmJ == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.aEa().b(BannerView.this.cQU, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.cQU.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", TbadkCoreStatisticKey.REF_TYPE_MAINTAB_AD, "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.cQU.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.dmJ.aJK();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        this.dmD = (Button) findViewById(R.id.btn_close);
        this.dmD.setOnClickListener(this.dmK);
        this.dmE = (TbImageView) findViewById(R.id.banner_image);
        this.dmE.setAutoChangeStyle(true);
        this.dmE.setOnClickListener(this.dmK);
        this.dmF = (TbImageView) findViewById(R.id.tv_advert);
        this.aqD = findViewById(R.id.banner_mask);
        am.setBackgroundColor(this.aqD, R.color.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.dmE != null && aVar != null) {
            this.dmE.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.dmF.setVisibility(0);
        } else {
            this.dmF.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.cQU = tbPageContext;
        this.link = str2;
        this.dmH = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.mIsClose && this.dmH) {
            ViewGroup.LayoutParams layoutParams = this.dmE.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = (int) ((l.getEquipmentWidth(getContext()) * this.dmG) + 0.5d);
            this.dmE.setLayoutParams(layoutParams);
            this.dmE.a(str, 10, 640, 108, false);
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
        this.dmJ = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aqD.setBackgroundColor(i);
    }

    public boolean aJI() {
        return this.dmH;
    }

    public TbImageView getBannerView() {
        return this.dmE;
    }

    public void reset() {
        this.mIsClose = false;
        this.dmH = false;
    }

    public void aJJ() {
        this.dmE.postInvalidate();
    }
}
