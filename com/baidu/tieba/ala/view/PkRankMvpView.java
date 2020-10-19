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
    private PkRankView gjB;
    private RelativeLayout hvQ;
    private HeadImageView hvR;
    private TextView hvS;
    private TextView hvT;
    private RelativeLayout hvU;
    private ImageView hvV;
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
        cgG();
        cgq();
    }

    private void cgG() {
        this.hvQ = (RelativeLayout) this.mView.findViewById(a.g.mvp_layout);
        this.hvR = (HeadImageView) this.mView.findViewById(a.g.mvp_head);
        this.hvS = (TextView) this.mView.findViewById(a.g.mvp_name);
        this.hvT = (TextView) this.mView.findViewById(a.g.mvp_score);
        this.hvU = (RelativeLayout) this.mView.findViewById(a.g.mvp_get_layout);
        this.hvV = (ImageView) this.mView.findViewById(a.g.mvp_get_image);
        this.hvR.setDefaultBgResource(a.f.sdk_default_avatar);
        this.hvR.setIsRound(true);
        this.hvR.setAutoChangeStyle(false);
        this.hvR.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.hvR.setBorderColor(872415231);
    }

    public void e(final PkInfoData pkInfoData) {
        this.hvQ.setVisibility(0);
        this.hvR.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.hvS.setText(pkInfoData.mvpInfoData.userNickName);
        this.hvT.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.hvT.setText(this.context.getString(a.i.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.hvR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gjB.aIT.aHD.userId) {
                    PkRankMvpView.this.gjB.y(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.hvU.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.hvV.setImageResource(a.f.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.hvV.setImageResource(a.f.pk_rank_boom);
            }
        }
    }

    private void cgq() {
        this.hvQ.setVisibility(8);
        this.hvU.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gjB = pkRankView;
    }
}
