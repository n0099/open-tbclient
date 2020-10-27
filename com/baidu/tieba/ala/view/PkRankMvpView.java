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
    private PkRankView gtC;
    private RelativeLayout hIn;
    private HeadImageView hIo;
    private TextView hIp;
    private TextView hIq;
    private RelativeLayout hIr;
    private ImageView hIs;
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
        cjN();
        cjx();
    }

    private void cjN() {
        this.hIn = (RelativeLayout) this.mView.findViewById(a.g.mvp_layout);
        this.hIo = (HeadImageView) this.mView.findViewById(a.g.mvp_head);
        this.hIp = (TextView) this.mView.findViewById(a.g.mvp_name);
        this.hIq = (TextView) this.mView.findViewById(a.g.mvp_score);
        this.hIr = (RelativeLayout) this.mView.findViewById(a.g.mvp_get_layout);
        this.hIs = (ImageView) this.mView.findViewById(a.g.mvp_get_image);
        this.hIo.setDefaultBgResource(a.f.sdk_default_avatar);
        this.hIo.setIsRound(true);
        this.hIo.setAutoChangeStyle(false);
        this.hIo.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.hIo.setBorderColor(872415231);
    }

    public void e(final PkInfoData pkInfoData) {
        this.hIn.setVisibility(0);
        this.hIo.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.hIp.setText(pkInfoData.mvpInfoData.userNickName);
        this.hIq.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.hIq.setText(this.context.getString(a.i.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.hIo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gtC.aJv.aIe.userId) {
                    PkRankMvpView.this.gtC.B(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.hIr.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.hIs.setImageResource(a.f.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.hIs.setImageResource(a.f.pk_rank_boom);
            }
        }
    }

    private void cjx() {
        this.hIn.setVisibility(8);
        this.hIr.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gtC = pkRankView;
    }
}
