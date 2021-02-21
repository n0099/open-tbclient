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
    private PkRankView gRX;
    private RelativeLayout imn;
    private HeadImageView imo;
    private TextView imp;
    private TextView imq;
    private RelativeLayout imr;
    private ImageView ims;
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
        cqo();
        cpW();
    }

    private void cqo() {
        this.imn = (RelativeLayout) this.mView.findViewById(a.f.mvp_layout);
        this.imo = (HeadImageView) this.mView.findViewById(a.f.mvp_head);
        this.imp = (TextView) this.mView.findViewById(a.f.mvp_name);
        this.imq = (TextView) this.mView.findViewById(a.f.mvp_score);
        this.imr = (RelativeLayout) this.mView.findViewById(a.f.mvp_get_layout);
        this.ims = (ImageView) this.mView.findViewById(a.f.mvp_get_image);
        this.imo.setDefaultBgResource(a.e.sdk_default_avatar);
        this.imo.setIsRound(true);
        this.imo.setAutoChangeStyle(false);
        this.imo.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.imo.setBorderColor(872415231);
    }

    public void f(final PkInfoData pkInfoData) {
        this.imn.setVisibility(0);
        this.imo.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.imp.setText(pkInfoData.mvpInfoData.userNickName);
        this.imq.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.imq.setText(this.context.getString(a.h.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.imo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gRX.aJZ.aId.userId) {
                    PkRankMvpView.this.gRX.A(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.imr.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.ims.setImageResource(a.e.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.ims.setImageResource(a.e.pk_rank_boom);
            }
        }
    }

    private void cpW() {
        this.imn.setVisibility(8);
        this.imr.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gRX = pkRankView;
    }
}
