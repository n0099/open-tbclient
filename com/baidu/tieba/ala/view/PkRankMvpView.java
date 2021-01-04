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
    private PkRankView gTH;
    private RelativeLayout ilm;
    private HeadImageView iln;
    private TextView ilo;
    private TextView ilp;
    private RelativeLayout ilq;
    private ImageView ilr;
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
        csR();
        csB();
    }

    private void csR() {
        this.ilm = (RelativeLayout) this.mView.findViewById(a.f.mvp_layout);
        this.iln = (HeadImageView) this.mView.findViewById(a.f.mvp_head);
        this.ilo = (TextView) this.mView.findViewById(a.f.mvp_name);
        this.ilp = (TextView) this.mView.findViewById(a.f.mvp_score);
        this.ilq = (RelativeLayout) this.mView.findViewById(a.f.mvp_get_layout);
        this.ilr = (ImageView) this.mView.findViewById(a.f.mvp_get_image);
        this.iln.setDefaultBgResource(a.e.sdk_default_avatar);
        this.iln.setIsRound(true);
        this.iln.setAutoChangeStyle(false);
        this.iln.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.iln.setBorderColor(872415231);
    }

    public void e(final PkInfoData pkInfoData) {
        this.ilm.setVisibility(0);
        this.iln.startLoad(pkInfoData.mvpInfoData.bdPortrait, 25, false, false);
        this.ilo.setText(pkInfoData.mvpInfoData.userNickName);
        this.ilp.setText(pkInfoData.mvpInfoData.contributionHonor);
        this.ilp.setText(this.context.getString(a.h.sdk_pk_rank_contribute, String.valueOf(pkInfoData.mvpInfoData.contributionHonor)));
        this.iln.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankMvpView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (pkInfoData.mvpInfoData.userID != PkRankMvpView.this.gTH.aMh.aKu.userId) {
                    PkRankMvpView.this.gTH.B(pkInfoData.H5URL, pkInfoData.mvpInfoData.userID);
                }
            }
        });
        if (pkInfoData.mvpInfoData.propsType != null && !pkInfoData.mvpInfoData.propsType.isEmpty()) {
            this.ilq.setVisibility(0);
            int parseInt = Integer.parseInt(pkInfoData.mvpInfoData.propsType);
            if (parseInt == 1) {
                this.ilr.setImageResource(a.e.pk_rank_red_potion);
            } else if (parseInt == 2) {
                this.ilr.setImageResource(a.e.pk_rank_boom);
            }
        }
    }

    private void csB() {
        this.ilm.setVisibility(8);
        this.ilq.setVisibility(8);
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gTH = pkRankView;
    }
}
