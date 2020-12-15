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
    private PkRankView gHV;
    private RelativeLayout hYN;
    private HeadImageView hYO;
    private TextView hYP;
    private TextView hYQ;
    private RelativeLayout hYR;
    private ImageView hYS;
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
        cpY();
        cpI();
    }

    private void cpY() {
        this.hYN = (RelativeLayout) this.mView.findViewById(a.f.mvp_layout);
        this.hYO = (HeadImageView) this.mView.findViewById(a.f.mvp_head);
        this.hYP = (TextView) this.mView.findViewById(a.f.mvp_name);
        this.hYQ = (TextView) this.mView.findViewById(a.f.mvp_score);
        this.hYR = (RelativeLayout) this.mView.findViewById(a.f.mvp_get_layout);
        this.hYS = (ImageView) this.mView.findViewById(a.f.mvp_get_image);
        this.hYO.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hYO.setIsRound(true);
        this.hYO.setAutoChangeStyle(false);
        this.hYO.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hYO.setBorderColor(872415231);
    }

    public void e(final PkInfoData pkInfoData) {
        this.hYN.setVisibility(0);
        this.hYO.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.hYP.setText(pkInfoData.mvpInfoData.userNickName);
        this.hYQ.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.hYQ.setText(this.context.getString(a.h.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.hYO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gHV.aLD.aJV.userId) {
                    PkRankMvpView.this.gHV.B(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.hYR.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.hYS.setImageResource(a.e.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.hYS.setImageResource(a.e.pk_rank_boom);
            }
        }
    }

    private void cpI() {
        this.hYN.setVisibility(8);
        this.hYR.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gHV = pkRankView;
    }
}
