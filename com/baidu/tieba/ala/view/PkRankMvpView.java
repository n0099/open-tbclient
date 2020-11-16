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
    private PkRankView gyX;
    private RelativeLayout hNR;
    private HeadImageView hNS;
    private TextView hNT;
    private TextView hNU;
    private RelativeLayout hNV;
    private ImageView hNW;
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
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_mvp_layout, (ViewGroup) this, true);
        clI();
        cls();
    }

    private void clI() {
        this.hNR = (RelativeLayout) this.mView.findViewById(a.f.mvp_layout);
        this.hNS = (HeadImageView) this.mView.findViewById(a.f.mvp_head);
        this.hNT = (TextView) this.mView.findViewById(a.f.mvp_name);
        this.hNU = (TextView) this.mView.findViewById(a.f.mvp_score);
        this.hNV = (RelativeLayout) this.mView.findViewById(a.f.mvp_get_layout);
        this.hNW = (ImageView) this.mView.findViewById(a.f.mvp_get_image);
        this.hNS.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hNS.setIsRound(true);
        this.hNS.setAutoChangeStyle(false);
        this.hNS.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hNS.setBorderColor(872415231);
    }

    public void e(final PkInfoData pkInfoData) {
        this.hNR.setVisibility(0);
        this.hNS.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.hNT.setText(pkInfoData.mvpInfoData.userNickName);
        this.hNU.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.hNU.setText(this.context.getString(a.h.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.hNS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gyX.aIK.aHk.userId) {
                    PkRankMvpView.this.gyX.B(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.hNV.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.hNW.setImageResource(a.e.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.hNW.setImageResource(a.e.pk_rank_boom);
            }
        }
    }

    private void cls() {
        this.hNR.setVisibility(8);
        this.hNV.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gyX = pkRankView;
    }
}
