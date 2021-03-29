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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class GameRankHorizontalLayout extends HorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f16361e;

    /* renamed from: f  reason: collision with root package name */
    public b f16362f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.s0.a f16363e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16364f;

        public a(d.b.i0.s0.a aVar, int i) {
            this.f16363e = aVar;
            this.f16364f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameRankHorizontalLayout.this.f16362f != null) {
                GameRankHorizontalLayout.this.f16362f.a(this.f16363e, this.f16364f);
                if (d.b.h0.r.d0.b.i().j("game_rank_list_show_times", 0) != 0) {
                    d.b.h0.r.d0.b.i().u("game_rank_list_show_times", 0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d.b.i0.s0.a aVar, int i);
    }

    public GameRankHorizontalLayout(Context context) {
        super(context);
        b(context);
    }

    public final void b(Context context) {
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f16361e = linearLayout;
        addView(linearLayout, -1, -1);
    }

    public final View c(d.b.i0.s0.a aVar, int i) {
        RoundAngleRelativeLayout roundAngleRelativeLayout;
        if (aVar == null) {
            return null;
        }
        if (!StringUtils.isNull(aVar.b())) {
            roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.game_rank_week_card, (ViewGroup) null);
            roundAngleRelativeLayout.setRadius(4.0f);
            HeadImageView headImageView = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.head_img);
            headImageView.setIsRound(true);
            headImageView.W(aVar.b(), 10, false);
            ((TbImageView) roundAngleRelativeLayout.findViewById(R.id.week_card_bg)).W(aVar.b(), 10, false);
        } else {
            roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.game_rank_normal_card, (ViewGroup) null);
            roundAngleRelativeLayout.setRadius(4.0f);
            HeadImageView headImageView2 = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.head_img);
            headImageView2.setIsRound(true);
            headImageView2.W(aVar.f(), 10, false);
            ((TbImageView) roundAngleRelativeLayout.findViewById(R.id.normal_card_bg)).W(aVar.f(), 10, false);
            ((TextView) roundAngleRelativeLayout.findViewById(R.id.user_name)).setText(aVar.e());
            ((TextView) roundAngleRelativeLayout.findViewById(R.id.rank_title)).setText(aVar.g());
            ((TextView) roundAngleRelativeLayout.findViewById(R.id.user_rank)).setText(getContext().getString(R.string.game_rank_no, aVar.d()));
            ((TextView) roundAngleRelativeLayout.findViewById(R.id.rank_des)).setText(aVar.a());
        }
        if (roundAngleRelativeLayout != null) {
            roundAngleRelativeLayout.setOnClickListener(new a(aVar, i));
        }
        return roundAngleRelativeLayout;
    }

    public void setData(d.b.i0.s0.b bVar) {
        LinearLayout linearLayout = this.f16361e;
        if (linearLayout == null || bVar == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (ListUtils.isEmpty(bVar.e())) {
            return;
        }
        for (int i = 0; i < bVar.e().size(); i++) {
            View c2 = c(bVar.e().get(i), i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.ds468), l.g(getContext(), R.dimen.ds190));
            if (i != 0) {
                layoutParams.leftMargin = l.g(getContext(), R.dimen.ds8);
            } else {
                layoutParams.leftMargin = l.g(getContext(), R.dimen.ds40);
            }
            if (i == bVar.e().size() - 1) {
                layoutParams.rightMargin = l.g(getContext(), R.dimen.ds40);
            } else {
                layoutParams.rightMargin = 0;
            }
            c2.setLayoutParams(layoutParams);
            this.f16361e.addView(c2);
        }
    }

    public void setOnCardClickListener(b bVar) {
        this.f16362f = bVar;
    }

    public GameRankHorizontalLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public GameRankHorizontalLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context);
    }
}
