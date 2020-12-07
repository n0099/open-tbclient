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
    private PkRankView gHT;
    private RelativeLayout hYL;
    private HeadImageView hYM;
    private TextView hYN;
    private TextView hYO;
    private RelativeLayout hYP;
    private ImageView hYQ;
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
        cpX();
        cpH();
    }

    private void cpX() {
        this.hYL = (RelativeLayout) this.mView.findViewById(a.f.mvp_layout);
        this.hYM = (HeadImageView) this.mView.findViewById(a.f.mvp_head);
        this.hYN = (TextView) this.mView.findViewById(a.f.mvp_name);
        this.hYO = (TextView) this.mView.findViewById(a.f.mvp_score);
        this.hYP = (RelativeLayout) this.mView.findViewById(a.f.mvp_get_layout);
        this.hYQ = (ImageView) this.mView.findViewById(a.f.mvp_get_image);
        this.hYM.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hYM.setIsRound(true);
        this.hYM.setAutoChangeStyle(false);
        this.hYM.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hYM.setBorderColor(872415231);
    }

    public void e(final PkInfoData pkInfoData) {
        this.hYL.setVisibility(0);
        this.hYM.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.hYN.setText(pkInfoData.mvpInfoData.userNickName);
        this.hYO.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.hYO.setText(this.context.getString(a.h.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.hYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gHT.aLD.aJV.userId) {
                    PkRankMvpView.this.gHT.B(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.hYP.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.hYQ.setImageResource(a.e.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.hYQ.setImageResource(a.e.pk_rank_boom);
            }
        }
    }

    private void cpH() {
        this.hYL.setVisibility(8);
        this.hYP.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gHT = pkRankView;
    }
}
