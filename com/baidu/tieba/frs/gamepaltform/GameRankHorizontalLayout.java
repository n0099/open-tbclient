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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class GameRankHorizontalLayout extends HorizontalScrollView {
    private LinearLayout bcO;
    private a dhN;

    /* loaded from: classes3.dex */
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
        this.bcO = new LinearLayout(context);
        addView(this.bcO, -1, -1);
    }

    public void setData(com.baidu.tieba.h.b bVar) {
        if (this.bcO != null && bVar != null) {
            this.bcO.removeAllViews();
            if (!v.w(bVar.awc())) {
                for (int i = 0; i < bVar.awc().size(); i++) {
                    View a2 = a(bVar.awc().get(i), i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.e(getContext(), d.e.ds468), l.e(getContext(), d.e.ds190));
                    if (i != 0) {
                        layoutParams.leftMargin = l.e(getContext(), d.e.ds8);
                    } else {
                        layoutParams.leftMargin = l.e(getContext(), d.e.ds40);
                    }
                    if (i == bVar.awc().size() - 1) {
                        layoutParams.rightMargin = l.e(getContext(), d.e.ds40);
                    } else {
                        layoutParams.rightMargin = 0;
                    }
                    a2.setLayoutParams(layoutParams);
                    this.bcO.addView(a2);
                }
            }
        }
    }

    public void setOnCardClickListener(a aVar) {
        this.dhN = aVar;
    }

    private View a(final com.baidu.tieba.h.a aVar, final int i) {
        RoundAngleRelativeLayout roundAngleRelativeLayout = null;
        if (aVar != null) {
            if (!StringUtils.isNull(aVar.avZ())) {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(d.i.game_rank_week_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                TbImageView tbImageView = (TbImageView) roundAngleRelativeLayout.findViewById(d.g.week_card_bg);
                HeadImageView headImageView = (HeadImageView) roundAngleRelativeLayout.findViewById(d.g.head_img);
                headImageView.setIsRound(true);
                headImageView.startLoad(aVar.avZ(), 10, false);
                tbImageView.setDefaultErrorResource(d.C0126d.transparent);
                tbImageView.startLoad(aVar.avZ(), 10, false);
            } else {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(d.i.game_rank_normal_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                TbImageView tbImageView2 = (TbImageView) roundAngleRelativeLayout.findViewById(d.g.normal_card_bg);
                HeadImageView headImageView2 = (HeadImageView) roundAngleRelativeLayout.findViewById(d.g.head_img);
                headImageView2.setIsRound(true);
                headImageView2.startLoad(aVar.avY(), 10, false);
                tbImageView2.setDefaultErrorResource(d.C0126d.transparent);
                tbImageView2.startLoad(aVar.avY(), 10, false);
                ((TextView) roundAngleRelativeLayout.findViewById(d.g.user_name)).setText(aVar.avX());
                ((TextView) roundAngleRelativeLayout.findViewById(d.g.rank_title)).setText(aVar.avU());
                ((TextView) roundAngleRelativeLayout.findViewById(d.g.user_rank)).setText(getContext().getString(d.k.game_rank_no, aVar.avV()));
                ((TextView) roundAngleRelativeLayout.findViewById(d.g.rank_des)).setText(aVar.avW());
            }
            if (roundAngleRelativeLayout != null) {
                roundAngleRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (GameRankHorizontalLayout.this.dhN != null) {
                            GameRankHorizontalLayout.this.dhN.b(aVar, i);
                            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("game_rank_list_show_times", 0) != 0) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("game_rank_list_show_times", 0);
                            }
                        }
                    }
                });
            }
        }
        return roundAngleRelativeLayout;
    }
}
