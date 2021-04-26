package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.view.BazhuHeadView;
import d.a.c.e.m.b;
import d.a.c.e.p.l;
import d.a.j0.v.b.d;
import d.a.j0.v.b.f;
/* loaded from: classes4.dex */
public class CandidateInfoLayout extends CardBasicLayout {

    /* renamed from: h  reason: collision with root package name */
    public Context f14956h;

    /* renamed from: i  reason: collision with root package name */
    public BazhuHeadView f14957i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public View.OnClickListener o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = CandidateInfoLayout.this.f14961g;
            if (dVar == null || dVar.l() == 0) {
                return;
            }
            long f2 = b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            long l = CandidateInfoLayout.this.f14961g.l();
            if (!(CandidateInfoLayout.this.getContext() instanceof Activity) || CandidateInfoLayout.this.f14961g.f() == 2) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(CandidateInfoLayout.this.getContext()).createNormalConfig(l, l == f2, false)));
        }
    }

    public CandidateInfoLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        BazhuHeadView bazhuHeadView = (BazhuHeadView) findViewById(R.id.user_avatar);
        this.f14957i = bazhuHeadView;
        if (bazhuHeadView.getHeadView() != null) {
            this.f14957i.getHeadView().setIsRound(true);
        }
        this.j = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.k = (TextView) findViewById(R.id.user_name);
        this.l = (TextView) findViewById(R.id.vote_id);
        this.n = (TextView) findViewById(R.id.agree_post_reply_num);
        this.m = (ImageView) findViewById(R.id.grade);
    }

    public void b() {
        this.f14956h = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        setGravity(80);
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.candidate_info_layout, (ViewGroup) this, true);
        a();
    }

    public void c(int i2) {
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i2);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1, i2);
        d dVar = this.f14961g;
        if (dVar != null) {
            setGrade(dVar.d());
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        int i3;
        String str;
        super.setData(i2, fVar);
        if (this.f14960f != null && this.f14961g != null && (i3 = this.f14959e) >= 0) {
            if (i3 == d.a.j0.v.e.a.f61617c) {
                int g2 = l.g(this.f14956h, R.dimen.tbds191);
                int g3 = l.g(this.f14956h, R.dimen.tbds157);
                int g4 = l.g(this.f14956h, R.dimen.tbds6);
                int g5 = l.g(this.f14956h, R.dimen.tbds24);
                int g6 = l.g(this.f14956h, R.dimen.tbds30);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g3, g2);
                layoutParams.setMargins(layoutParams.leftMargin - g4, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                this.f14957i.setLayoutParams(layoutParams);
                this.f14957i.n(true);
                this.f14957i.setBawuLogoView(R.drawable.pic_election_bazhu);
                this.f14957i.setPendantView(R.drawable.icon_crown);
                this.k.setTextSize(0, l.g(this.f14956h, R.dimen.tbfontsize46));
                setGravity(16);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(g6, g5, layoutParams2.rightMargin, g4);
                this.f14957i.setLayoutParams(layoutParams);
                this.j.setLayoutParams(layoutParams2);
            } else {
                this.f14957i.n(false);
            }
            this.f14957i.k(this.f14961g.g());
            this.f14957i.setOnClickListener(this.o);
            this.k.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f14961g.e(), 14, StringHelper.STRING_MORE));
            setGrade(this.f14961g.d());
            if (this.f14961g.f() == 2) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                if (this.f14961g.c() < 1000) {
                    String str2 = "0000" + this.f14961g.c();
                    str = str2.substring(str2.length() - 4, str2.length());
                } else {
                    str = "" + this.f14961g.c();
                }
                this.l.setText("NO." + str);
            }
            this.n.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(this.f14961g.a()), StringHelper.numFormatOverWanWithNegative(this.f14961g.j()), StringHelper.numFormatOverWanWithNegative(this.f14961g.h())));
            return;
        }
        setVisibility(8);
    }

    public void setGrade(int i2) {
        SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(i2));
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new a();
        b();
    }
}
