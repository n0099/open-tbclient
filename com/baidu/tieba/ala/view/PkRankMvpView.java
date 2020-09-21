package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.data.PkInfoData;
/* loaded from: classes4.dex */
public class PkRankMvpView extends RelativeLayout {
    Context context;
    private PkRankView fXi;
    private RelativeLayout hgU;
    private HeadImageView hgV;
    private TextView hgW;
    private TextView hgX;
    private RelativeLayout hgY;
    private ImageView hgZ;
    private View mView;

    public PkRankMvpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankMvpView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_mvp_layout, (ViewGroup) this, true);
        cdk();
        ccU();
    }

    private void cdk() {
        this.hgU = (RelativeLayout) this.mView.findViewById(a.g.mvp_layout);
        this.hgV = (HeadImageView) this.mView.findViewById(a.g.mvp_head);
        this.hgW = (TextView) this.mView.findViewById(a.g.mvp_name);
        this.hgX = (TextView) this.mView.findViewById(a.g.mvp_score);
        this.hgY = (RelativeLayout) this.mView.findViewById(a.g.mvp_get_layout);
        this.hgZ = (ImageView) this.mView.findViewById(a.g.mvp_get_image);
        this.hgV.setDefaultBgResource(a.f.sdk_default_avatar);
        this.hgV.setIsRound(true);
        this.hgV.setAutoChangeStyle(false);
        this.hgV.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.hgV.setBorderColor(872415231);
    }

    public void e(final PkInfoData pkInfoData) {
        this.hgU.setVisibility(0);
        this.hgV.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.hgW.setText(pkInfoData.mvpInfoData.userNickName);
        this.hgX.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.hgX.setText(this.context.getString(a.i.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.hgV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.fXi.aFP.aEz.userId) {
                    PkRankMvpView.this.fXi.y(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.hgY.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.hgZ.setImageResource(a.f.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.hgZ.setImageResource(a.f.pk_rank_boom);
            }
        }
    }

    private void ccU() {
        this.hgU.setVisibility(8);
        this.hgY.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.fXi = pkRankView;
    }
}
