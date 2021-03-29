package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.view.TrapezoidButton;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
import d.b.b.e.p.l;
import d.b.i0.v.b.f;
/* loaded from: classes4.dex */
public class VoteAreaLayout extends CardBasicLayout {

    /* renamed from: h  reason: collision with root package name */
    public Context f15198h;
    public RoundAndShadowLinearLayout i;
    public View j;
    public TextView k;
    public TrapezoidButton l;
    public TextView m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f15199e;

        public a(f fVar) {
            this.f15199e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            if ((VoteAreaLayout.this.f15198h instanceof Activity) && ViewHelper.checkUpIsLogin(VoteAreaLayout.this.f15198h)) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_BUTTON).eventStat();
                if (VoteAreaLayout.this.f15195g == null || (fVar = this.f15199e) == null || fVar.a() == null) {
                    return;
                }
                if (this.f15199e.a().a()) {
                    if (this.f15199e.c() == 0 || this.f15199e.g() == null) {
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(VoteAreaLayout.this.f15195g.l(), this.f15199e.c(), VoteAreaLayout.this.f15195g.k(), 1);
                    commitVoteReqMsg.setTag(this.f15199e.g());
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                l.K(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
            }
        }
    }

    public VoteAreaLayout(Context context) {
        this(context, null);
    }

    public final void b() {
        RoundAndShadowLinearLayout roundAndShadowLinearLayout = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
        this.i = roundAndShadowLinearLayout;
        roundAndShadowLinearLayout.setRadius(l.g(this.f15198h, R.dimen.tbds8));
        this.k = (TextView) findViewById(R.id.vote_num);
        this.l = (TrapezoidButton) findViewById(R.id.vote_button);
        this.m = (TextView) findViewById(R.id.vote_button_tv);
        this.j = findViewById(R.id.button_container);
    }

    public void c() {
        this.f15198h = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        setGravity(16);
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_area_layout, (ViewGroup) this, true);
        b();
    }

    public void d(int i) {
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0303, 1, i);
        SkinManager.setBackgroundColorWithAlpha(this.j, R.color.CAM_X0303, 0.2f, i);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1, i);
        SkinManager.setBackgroundResource(this.m, R.drawable.bar_select_bg_gradient, i);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.f15194f != null && this.f15195g != null && this.f15193e >= 0) {
            TextView textView = this.k;
            textView.setText(StringHelper.numFormatOverWan(this.f15195g.m()) + "票");
            this.m.setOnClickListener(new a(fVar));
            if (this.f15195g.n()) {
                this.m.setEnabled(false);
                return;
            } else {
                this.m.setEnabled(true);
                return;
            }
        }
        setVisibility(8);
    }

    public VoteAreaLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }
}
