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
import d.b.b.e.m.b;
import d.b.b.e.p.l;
import d.b.i0.v.b.d;
import d.b.i0.v.b.f;
/* loaded from: classes4.dex */
public class CandidateInfoLayout extends CardBasicLayout {

    /* renamed from: h  reason: collision with root package name */
    public Context f15191h;
    public BazhuHeadView i;
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
            d dVar = CandidateInfoLayout.this.f15195g;
            if (dVar == null || dVar.l() == 0) {
                return;
            }
            long f2 = b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            long l = CandidateInfoLayout.this.f15195g.l();
            if (!(CandidateInfoLayout.this.getContext() instanceof Activity) || CandidateInfoLayout.this.f15195g.f() == 2) {
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
        this.i = bazhuHeadView;
        if (bazhuHeadView.getHeadView() != null) {
            this.i.getHeadView().setIsRound(true);
        }
        this.j = (LinearLayout) findViewById(R.id.user_name_and_active_status);
        this.k = (TextView) findViewById(R.id.user_name);
        this.l = (TextView) findViewById(R.id.vote_id);
        this.n = (TextView) findViewById(R.id.agree_post_reply_num);
        this.m = (ImageView) findViewById(R.id.grade);
    }

    public void b() {
        this.f15191h = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        setGravity(80);
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.candidate_info_layout, (ViewGroup) this, true);
        a();
    }

    public void c(int i) {
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1, i);
        d dVar = this.f15195g;
        if (dVar != null) {
            setGrade(dVar.d());
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        int i2;
        String str;
        super.setData(i, fVar);
        if (this.f15194f != null && this.f15195g != null && (i2 = this.f15193e) >= 0) {
            if (i2 == d.b.i0.v.e.a.f61957c) {
                int g2 = l.g(this.f15191h, R.dimen.tbds191);
                int g3 = l.g(this.f15191h, R.dimen.tbds157);
                int g4 = l.g(this.f15191h, R.dimen.tbds6);
                int g5 = l.g(this.f15191h, R.dimen.tbds24);
                int g6 = l.g(this.f15191h, R.dimen.tbds30);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g3, g2);
                layoutParams.setMargins(layoutParams.leftMargin - g4, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                this.i.setLayoutParams(layoutParams);
                this.i.n(true);
                this.i.setBawuLogoView(R.drawable.pic_election_bazhu);
                this.i.setPendantView(R.drawable.icon_crown);
                this.k.setTextSize(0, l.g(this.f15191h, R.dimen.tbfontsize46));
                setGravity(16);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(g6, g5, layoutParams2.rightMargin, g4);
                this.i.setLayoutParams(layoutParams);
                this.j.setLayoutParams(layoutParams2);
            } else {
                this.i.n(false);
            }
            this.i.k(this.f15195g.g());
            this.i.setOnClickListener(this.o);
            this.k.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f15195g.e(), 14, StringHelper.STRING_MORE));
            setGrade(this.f15195g.d());
            if (this.f15195g.f() == 2) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                if (this.f15195g.c() < 1000) {
                    String str2 = "0000" + this.f15195g.c();
                    str = str2.substring(str2.length() - 4, str2.length());
                } else {
                    str = "" + this.f15195g.c();
                }
                this.l.setText("NO." + str);
            }
            this.n.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(this.f15195g.a()), StringHelper.numFormatOverWanWithNegative(this.f15195g.j()), StringHelper.numFormatOverWanWithNegative(this.f15195g.h())));
            return;
        }
        setVisibility(8);
    }

    public void setGrade(int i) {
        SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new a();
        b();
    }
}
