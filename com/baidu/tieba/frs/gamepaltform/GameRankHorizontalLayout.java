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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class GameRankHorizontalLayout extends HorizontalScrollView {
    private LinearLayout bnh;
    private a dyb;

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
        this.bnh = new LinearLayout(context);
        addView(this.bnh, -1, -1);
    }

    public void setData(com.baidu.tieba.h.b bVar) {
        if (this.bnh != null && bVar != null) {
            this.bnh.removeAllViews();
            if (!w.z(bVar.aCf())) {
                for (int i = 0; i < bVar.aCf().size(); i++) {
                    View a2 = a(bVar.aCf().get(i), i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.f(getContext(), f.e.ds468), l.f(getContext(), f.e.ds190));
                    if (i != 0) {
                        layoutParams.leftMargin = l.f(getContext(), f.e.ds8);
                    } else {
                        layoutParams.leftMargin = l.f(getContext(), f.e.ds40);
                    }
                    if (i == bVar.aCf().size() - 1) {
                        layoutParams.rightMargin = l.f(getContext(), f.e.ds40);
                    } else {
                        layoutParams.rightMargin = 0;
                    }
                    a2.setLayoutParams(layoutParams);
                    this.bnh.addView(a2);
                }
            }
        }
    }

    public void setOnCardClickListener(a aVar) {
        this.dyb = aVar;
    }

    private View a(final com.baidu.tieba.h.a aVar, final int i) {
        RoundAngleRelativeLayout roundAngleRelativeLayout = null;
        if (aVar != null) {
            if (!StringUtils.isNull(aVar.aCc())) {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(f.h.game_rank_week_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                TbImageView tbImageView = (TbImageView) roundAngleRelativeLayout.findViewById(f.g.week_card_bg);
                HeadImageView headImageView = (HeadImageView) roundAngleRelativeLayout.findViewById(f.g.head_img);
                headImageView.setIsRound(true);
                headImageView.startLoad(aVar.aCc(), 10, false);
                tbImageView.setDefaultErrorResource(f.d.transparent);
                tbImageView.startLoad(aVar.aCc(), 10, false);
            } else {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(f.h.game_rank_normal_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                TbImageView tbImageView2 = (TbImageView) roundAngleRelativeLayout.findViewById(f.g.normal_card_bg);
                HeadImageView headImageView2 = (HeadImageView) roundAngleRelativeLayout.findViewById(f.g.head_img);
                headImageView2.setIsRound(true);
                headImageView2.startLoad(aVar.aCb(), 10, false);
                tbImageView2.setDefaultErrorResource(f.d.transparent);
                tbImageView2.startLoad(aVar.aCb(), 10, false);
                ((TextView) roundAngleRelativeLayout.findViewById(f.g.user_name)).setText(aVar.aCa());
                ((TextView) roundAngleRelativeLayout.findViewById(f.g.rank_title)).setText(aVar.aBX());
                ((TextView) roundAngleRelativeLayout.findViewById(f.g.user_rank)).setText(getContext().getString(f.j.game_rank_no, aVar.aBY()));
                ((TextView) roundAngleRelativeLayout.findViewById(f.g.rank_des)).setText(aVar.aBZ());
            }
            if (roundAngleRelativeLayout != null) {
                roundAngleRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (GameRankHorizontalLayout.this.dyb != null) {
                            GameRankHorizontalLayout.this.dyb.b(aVar, i);
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
