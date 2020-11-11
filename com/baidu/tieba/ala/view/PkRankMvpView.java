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
    private PkRankView gzq;
    private RelativeLayout hOk;
    private HeadImageView hOl;
    private TextView hOm;
    private TextView hOn;
    private RelativeLayout hOo;
    private ImageView hOp;
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
        cmp();
        clZ();
    }

    private void cmp() {
        this.hOk = (RelativeLayout) this.mView.findViewById(a.f.mvp_layout);
        this.hOl = (HeadImageView) this.mView.findViewById(a.f.mvp_head);
        this.hOm = (TextView) this.mView.findViewById(a.f.mvp_name);
        this.hOn = (TextView) this.mView.findViewById(a.f.mvp_score);
        this.hOo = (RelativeLayout) this.mView.findViewById(a.f.mvp_get_layout);
        this.hOp = (ImageView) this.mView.findViewById(a.f.mvp_get_image);
        this.hOl.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hOl.setIsRound(true);
        this.hOl.setAutoChangeStyle(false);
        this.hOl.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hOl.setBorderColor(872415231);
    }

    public void e(final PkInfoData pkInfoData) {
        this.hOk.setVisibility(0);
        this.hOl.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.hOm.setText(pkInfoData.mvpInfoData.userNickName);
        this.hOn.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.hOn.setText(this.context.getString(a.h.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.hOl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gzq.aKv.aIV.userId) {
                    PkRankMvpView.this.gzq.B(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.hOo.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.hOp.setImageResource(a.e.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.hOp.setImageResource(a.e.pk_rank_boom);
            }
        }
    }

    private void clZ() {
        this.hOk.setVisibility(8);
        this.hOo.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gzq = pkRankView;
    }
}
