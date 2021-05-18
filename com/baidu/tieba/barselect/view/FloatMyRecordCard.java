package com.baidu.tieba.barselect.view;

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
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
import d.a.c.e.m.b;
import d.a.k0.v.b.d;
import d.a.k0.v.b.e;
import d.a.k0.v.b.f;
import d.a.k0.v.e.c;
/* loaded from: classes4.dex */
public class FloatMyRecordCard extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f14286e;

    /* renamed from: f  reason: collision with root package name */
    public int f14287f;

    /* renamed from: g  reason: collision with root package name */
    public f f14288g;

    /* renamed from: h  reason: collision with root package name */
    public d f14289h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14290i;
    public BazhuHeadView j;
    public TextView k;
    public ImageView l;
    public TextView m;
    public VotedAreaLayout n;
    public View.OnClickListener o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FloatMyRecordCard.this.f14289h == null || FloatMyRecordCard.this.f14289h.l() == 0) {
                return;
            }
            long f2 = b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            long l = FloatMyRecordCard.this.f14289h.l();
            if (FloatMyRecordCard.this.getContext() instanceof Activity) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FloatMyRecordCard.this.getContext()).createNormalConfig(l, l == f2, false)));
            }
        }
    }

    public FloatMyRecordCard(Context context) {
        this(context, null);
    }

    public final void b() {
        this.f14290i = (TextView) findViewById(R.id.tv_voted_rank);
        BazhuHeadView bazhuHeadView = (BazhuHeadView) findViewById(R.id.user_avatar);
        this.j = bazhuHeadView;
        if (bazhuHeadView.getHeadView() != null) {
            this.j.getHeadView().setIsRound(true);
        }
        this.k = (TextView) findViewById(R.id.user_name);
        this.l = (ImageView) findViewById(R.id.grade);
        this.m = (TextView) findViewById(R.id.vote_id);
        this.n = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
    }

    public final void c() {
        this.f14286e = getContext();
        setOrientation(0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.float_my_record_card, (ViewGroup) this, true);
        b();
    }

    public void d(int i2) {
        d dVar = this.f14289h;
        if (dVar == null) {
            return;
        }
        if (dVar.i() > 3) {
            SkinManager.setViewTextColor(this.f14290i, R.color.CAM_X0105, 1, i2);
        }
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
        setGrade(this.f14289h.d());
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1, i2);
        this.n.c(i2);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i2);
        setGrade(this.f14289h.d());
    }

    public void setData(f fVar) {
        d dVar;
        String str;
        this.f14288g = fVar;
        if (fVar != null && fVar.a() != null) {
            e a2 = this.f14288g.a();
            if (a2 != null) {
                this.f14287f = a2.g();
            }
            this.f14289h = this.f14288g.f();
        }
        if (this.f14288g != null && (dVar = this.f14289h) != null && this.f14287f == c.f62345c) {
            int i2 = dVar.i();
            if (i2 < 10) {
                this.f14290i.setText("0" + i2);
            } else {
                this.f14290i.setText("" + i2);
            }
            if (i2 == 2) {
                this.f14290i.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (i2 == 3) {
                this.f14290i.setTextColor(getResources().getColor(R.color.common_color_10266));
            }
            this.j.k(this.f14289h.g());
            this.j.setOnClickListener(this.o);
            this.k.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f14289h.e(), 14, StringHelper.STRING_MORE));
            setGrade(this.f14289h.d());
            if (this.f14289h.c() < 1000) {
                String str2 = "0000" + this.f14289h.c();
                str = str2.substring(str2.length() - 4, str2.length());
            } else {
                str = "" + this.f14289h.c();
            }
            this.m.setText("NO." + str);
            this.n.setMyRecordData(this.f14289h);
            return;
        }
        setVisibility(8);
    }

    public void setGrade(int i2) {
        SkinManager.setImageResource(this.l, BitmapHelper.getGradeResourceIdInEnterForum(i2));
    }

    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new a();
        c();
    }
}
