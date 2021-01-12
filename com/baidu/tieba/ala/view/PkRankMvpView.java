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
/* loaded from: classes10.dex */
public class PkRankMvpView extends RelativeLayout {
    Context context;
    private PkRankView gPb;
    private RelativeLayout igF;
    private HeadImageView igG;
    private TextView igH;
    private TextView igI;
    private RelativeLayout igJ;
    private ImageView igK;
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
        cpa();
        coK();
    }

    private void cpa() {
        this.igF = (RelativeLayout) this.mView.findViewById(a.f.mvp_layout);
        this.igG = (HeadImageView) this.mView.findViewById(a.f.mvp_head);
        this.igH = (TextView) this.mView.findViewById(a.f.mvp_name);
        this.igI = (TextView) this.mView.findViewById(a.f.mvp_score);
        this.igJ = (RelativeLayout) this.mView.findViewById(a.f.mvp_get_layout);
        this.igK = (ImageView) this.mView.findViewById(a.f.mvp_get_image);
        this.igG.setDefaultBgResource(a.e.sdk_default_avatar);
        this.igG.setIsRound(true);
        this.igG.setAutoChangeStyle(false);
        this.igG.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.igG.setBorderColor(872415231);
    }

    public void e(final PkInfoData pkInfoData) {
        this.igF.setVisibility(0);
        this.igG.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.igH.setText(pkInfoData.mvpInfoData.userNickName);
        this.igI.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.igI.setText(this.context.getString(a.h.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.igG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gPb.aHu.aFH.userId) {
                    PkRankMvpView.this.gPb.B(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.igJ.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.igK.setImageResource(a.e.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.igK.setImageResource(a.e.pk_rank_boom);
            }
        }
    }

    private void coK() {
        this.igF.setVisibility(8);
        this.igJ.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gPb = pkRankView;
    }
}
