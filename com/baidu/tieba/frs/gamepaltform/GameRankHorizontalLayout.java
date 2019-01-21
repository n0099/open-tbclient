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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class GameRankHorizontalLayout extends HorizontalScrollView {
    private LinearLayout bCb;
    private a dXP;

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
        this.bCb = new LinearLayout(context);
        addView(this.bCb, -1, -1);
    }

    public void setData(com.baidu.tieba.h.b bVar) {
        if (this.bCb != null && bVar != null) {
            this.bCb.removeAllViews();
            if (!v.I(bVar.aKm())) {
                for (int i = 0; i < bVar.aKm().size(); i++) {
                    View a2 = a(bVar.aKm().get(i), i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.h(getContext(), e.C0210e.ds468), l.h(getContext(), e.C0210e.ds190));
                    if (i != 0) {
                        layoutParams.leftMargin = l.h(getContext(), e.C0210e.ds8);
                    } else {
                        layoutParams.leftMargin = l.h(getContext(), e.C0210e.ds40);
                    }
                    if (i == bVar.aKm().size() - 1) {
                        layoutParams.rightMargin = l.h(getContext(), e.C0210e.ds40);
                    } else {
                        layoutParams.rightMargin = 0;
                    }
                    a2.setLayoutParams(layoutParams);
                    this.bCb.addView(a2);
                }
            }
        }
    }

    public void setOnCardClickListener(a aVar) {
        this.dXP = aVar;
    }

    private View a(final com.baidu.tieba.h.a aVar, final int i) {
        RoundAngleRelativeLayout roundAngleRelativeLayout = null;
        if (aVar != null) {
            if (!StringUtils.isNull(aVar.aKj())) {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(e.h.game_rank_week_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                TbImageView tbImageView = (TbImageView) roundAngleRelativeLayout.findViewById(e.g.week_card_bg);
                HeadImageView headImageView = (HeadImageView) roundAngleRelativeLayout.findViewById(e.g.head_img);
                headImageView.setIsRound(true);
                headImageView.startLoad(aVar.aKj(), 10, false);
                tbImageView.setDefaultErrorResource(e.d.transparent);
                tbImageView.startLoad(aVar.aKj(), 10, false);
            } else {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(e.h.game_rank_normal_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                TbImageView tbImageView2 = (TbImageView) roundAngleRelativeLayout.findViewById(e.g.normal_card_bg);
                HeadImageView headImageView2 = (HeadImageView) roundAngleRelativeLayout.findViewById(e.g.head_img);
                headImageView2.setIsRound(true);
                headImageView2.startLoad(aVar.aKi(), 10, false);
                tbImageView2.setDefaultErrorResource(e.d.transparent);
                tbImageView2.startLoad(aVar.aKi(), 10, false);
                ((TextView) roundAngleRelativeLayout.findViewById(e.g.user_name)).setText(aVar.aKh());
                ((TextView) roundAngleRelativeLayout.findViewById(e.g.rank_title)).setText(aVar.aKe());
                ((TextView) roundAngleRelativeLayout.findViewById(e.g.user_rank)).setText(getContext().getString(e.j.game_rank_no, aVar.aKf()));
                ((TextView) roundAngleRelativeLayout.findViewById(e.g.rank_des)).setText(aVar.aKg());
            }
            if (roundAngleRelativeLayout != null) {
                roundAngleRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (GameRankHorizontalLayout.this.dXP != null) {
                            GameRankHorizontalLayout.this.dXP.b(aVar, i);
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
