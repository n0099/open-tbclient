package com.baidu.tieba.frs.gamepaltform;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class GameRankHorizontalLayout extends HorizontalScrollView {
    private LinearLayout eNL;
    private a hBt;

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.h.a aVar, int i);
    }

    public GameRankHorizontalLayout(Context context) {
        super(context);
        init(context);
    }

    public GameRankHorizontalLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public GameRankHorizontalLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.eNL = new LinearLayout(context);
        addView(this.eNL, -1, -1);
    }

    public void setData(com.baidu.tieba.h.b bVar) {
        if (this.eNL != null && bVar != null) {
            this.eNL.removeAllViews();
            if (!v.isEmpty(bVar.cdv())) {
                for (int i = 0; i < bVar.cdv().size(); i++) {
                    View a2 = a(bVar.cdv().get(i), i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.ds468), l.getDimens(getContext(), R.dimen.ds190));
                    if (i != 0) {
                        layoutParams.leftMargin = l.getDimens(getContext(), R.dimen.ds8);
                    } else {
                        layoutParams.leftMargin = l.getDimens(getContext(), R.dimen.ds40);
                    }
                    if (i == bVar.cdv().size() - 1) {
                        layoutParams.rightMargin = l.getDimens(getContext(), R.dimen.ds40);
                    } else {
                        layoutParams.rightMargin = 0;
                    }
                    a2.setLayoutParams(layoutParams);
                    this.eNL.addView(a2);
                }
            }
        }
    }

    public void setOnCardClickListener(a aVar) {
        this.hBt = aVar;
    }

    private View a(final com.baidu.tieba.h.a aVar, final int i) {
        RoundAngleRelativeLayout roundAngleRelativeLayout = null;
        if (aVar != null) {
            if (!StringUtils.isNull(aVar.cds())) {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.game_rank_week_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                TbImageView tbImageView = (TbImageView) roundAngleRelativeLayout.findViewById(R.id.week_card_bg);
                HeadImageView headImageView = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.head_img);
                headImageView.setIsRound(true);
                headImageView.startLoad(aVar.cds(), 10, false);
                tbImageView.setDefaultErrorResource(R.color.transparent);
                tbImageView.startLoad(aVar.cds(), 10, false);
            } else {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.game_rank_normal_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                TbImageView tbImageView2 = (TbImageView) roundAngleRelativeLayout.findViewById(R.id.normal_card_bg);
                HeadImageView headImageView2 = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.head_img);
                headImageView2.setIsRound(true);
                headImageView2.startLoad(aVar.cdr(), 10, false);
                tbImageView2.setDefaultErrorResource(R.color.transparent);
                tbImageView2.startLoad(aVar.cdr(), 10, false);
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.user_name)).setText(aVar.cdq());
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.rank_title)).setText(aVar.cdn());
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.user_rank)).setText(getContext().getString(R.string.game_rank_no, aVar.cdo()));
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.rank_des)).setText(aVar.cdp());
            }
            if (roundAngleRelativeLayout != null) {
                roundAngleRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (GameRankHorizontalLayout.this.hBt != null) {
                            GameRankHorizontalLayout.this.hBt.b(aVar, i);
                            if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.GAME_RANK_LIST_SHOW_TIMES, 0) != 0) {
                                com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.GAME_RANK_LIST_SHOW_TIMES, 0);
                            }
                        }
                    }
                });
            }
        }
        return roundAngleRelativeLayout;
    }
}
