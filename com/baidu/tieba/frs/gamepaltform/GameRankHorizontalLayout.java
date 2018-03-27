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
    private LinearLayout bSK;
    private a dPl;

    /* loaded from: classes3.dex */
    public interface a {
        void b(com.baidu.tieba.g.a aVar, int i);
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
        this.bSK = new LinearLayout(context);
        addView(this.bSK, -1, -1);
    }

    public void setData(com.baidu.tieba.g.b bVar) {
        if (this.bSK != null && bVar != null) {
            this.bSK.removeAllViews();
            if (!v.E(bVar.aBg())) {
                for (int i = 0; i < bVar.aBg().size(); i++) {
                    View a2 = a(bVar.aBg().get(i), i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.t(getContext(), d.e.ds468), l.t(getContext(), d.e.ds190));
                    if (i != 0) {
                        layoutParams.leftMargin = l.t(getContext(), d.e.ds8);
                    } else {
                        layoutParams.leftMargin = l.t(getContext(), d.e.ds40);
                    }
                    if (i == bVar.aBg().size() - 1) {
                        layoutParams.rightMargin = l.t(getContext(), d.e.ds40);
                    } else {
                        layoutParams.rightMargin = 0;
                    }
                    a2.setLayoutParams(layoutParams);
                    this.bSK.addView(a2);
                }
            }
        }
    }

    public void setOnCardClickListener(a aVar) {
        this.dPl = aVar;
    }

    private View a(final com.baidu.tieba.g.a aVar, final int i) {
        RoundAngleRelativeLayout roundAngleRelativeLayout = null;
        if (aVar != null) {
            if (!StringUtils.isNull(aVar.aBd())) {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.game_rank_week_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                TbImageView tbImageView = (TbImageView) roundAngleRelativeLayout.findViewById(d.g.week_card_bg);
                HeadImageView headImageView = (HeadImageView) roundAngleRelativeLayout.findViewById(d.g.head_img);
                headImageView.setIsRound(true);
                headImageView.startLoad(aVar.aBd(), 10, false);
                tbImageView.setDefaultErrorResource(d.C0141d.transparent);
                tbImageView.startLoad(aVar.aBd(), 10, false);
            } else {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.game_rank_normal_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                TbImageView tbImageView2 = (TbImageView) roundAngleRelativeLayout.findViewById(d.g.normal_card_bg);
                HeadImageView headImageView2 = (HeadImageView) roundAngleRelativeLayout.findViewById(d.g.head_img);
                headImageView2.setIsRound(true);
                headImageView2.startLoad(aVar.aBc(), 10, false);
                tbImageView2.setDefaultErrorResource(d.C0141d.transparent);
                tbImageView2.startLoad(aVar.aBc(), 10, false);
                ((TextView) roundAngleRelativeLayout.findViewById(d.g.user_name)).setText(aVar.aBb());
                ((TextView) roundAngleRelativeLayout.findViewById(d.g.rank_title)).setText(aVar.aAY());
                ((TextView) roundAngleRelativeLayout.findViewById(d.g.user_rank)).setText(getContext().getString(d.j.game_rank_no, aVar.aAZ()));
                ((TextView) roundAngleRelativeLayout.findViewById(d.g.rank_des)).setText(aVar.aBa());
            }
            if (roundAngleRelativeLayout != null) {
                roundAngleRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (GameRankHorizontalLayout.this.dPl != null) {
                            GameRankHorizontalLayout.this.dPl.b(aVar, i);
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
