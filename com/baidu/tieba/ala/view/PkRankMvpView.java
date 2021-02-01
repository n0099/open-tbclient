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
/* loaded from: classes11.dex */
public class PkRankMvpView extends RelativeLayout {
    Context context;
    private PkRankView gRJ;
    private RelativeLayout ilY;
    private HeadImageView ilZ;
    private TextView ima;
    private TextView imb;
    private RelativeLayout imc;
    private ImageView imd;
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
        cqh();
        cpP();
    }

    private void cqh() {
        this.ilY = (RelativeLayout) this.mView.findViewById(a.f.mvp_layout);
        this.ilZ = (HeadImageView) this.mView.findViewById(a.f.mvp_head);
        this.ima = (TextView) this.mView.findViewById(a.f.mvp_name);
        this.imb = (TextView) this.mView.findViewById(a.f.mvp_score);
        this.imc = (RelativeLayout) this.mView.findViewById(a.f.mvp_get_layout);
        this.imd = (ImageView) this.mView.findViewById(a.f.mvp_get_image);
        this.ilZ.setDefaultBgResource(a.e.sdk_default_avatar);
        this.ilZ.setIsRound(true);
        this.ilZ.setAutoChangeStyle(false);
        this.ilZ.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.ilZ.setBorderColor(872415231);
    }

    public void f(final PkInfoData pkInfoData) {
        this.ilY.setVisibility(0);
        this.ilZ.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.ima.setText(pkInfoData.mvpInfoData.userNickName);
        this.imb.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.imb.setText(this.context.getString(a.h.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.ilZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gRJ.aJZ.aId.userId) {
                    PkRankMvpView.this.gRJ.A(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.imc.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.imd.setImageResource(a.e.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.imd.setImageResource(a.e.pk_rank_boom);
            }
        }
    }

    private void cpP() {
        this.ilY.setVisibility(8);
        this.imc.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gRJ = pkRankView;
    }
}
