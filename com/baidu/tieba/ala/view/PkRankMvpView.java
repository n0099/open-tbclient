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
    private PkRankView gTG;
    private RelativeLayout inX;
    private HeadImageView inY;
    private TextView inZ;
    private TextView ioa;
    private RelativeLayout iob;
    private ImageView ioc;
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
        cqu();
        cqc();
    }

    private void cqu() {
        this.inX = (RelativeLayout) this.mView.findViewById(a.f.mvp_layout);
        this.inY = (HeadImageView) this.mView.findViewById(a.f.mvp_head);
        this.inZ = (TextView) this.mView.findViewById(a.f.mvp_name);
        this.ioa = (TextView) this.mView.findViewById(a.f.mvp_score);
        this.iob = (RelativeLayout) this.mView.findViewById(a.f.mvp_get_layout);
        this.ioc = (ImageView) this.mView.findViewById(a.f.mvp_get_image);
        this.inY.setDefaultBgResource(a.e.sdk_default_avatar);
        this.inY.setIsRound(true);
        this.inY.setAutoChangeStyle(false);
        this.inY.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.inY.setBorderColor(872415231);
    }

    public void f(final PkInfoData pkInfoData) {
        this.inX.setVisibility(0);
        this.inY.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.inZ.setText(pkInfoData.mvpInfoData.userNickName);
        this.ioa.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.ioa.setText(this.context.getString(a.h.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.inY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gTG.aLz.aJD.userId) {
                    PkRankMvpView.this.gTG.A(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.iob.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.ioc.setImageResource(a.e.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.ioc.setImageResource(a.e.pk_rank_boom);
            }
        }
    }

    private void cqc() {
        this.inX.setVisibility(8);
        this.iob.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gTG = pkRankView;
    }
}
