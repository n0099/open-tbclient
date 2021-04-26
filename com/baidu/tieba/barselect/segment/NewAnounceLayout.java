package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.v.b.d;
import d.a.j0.v.b.f;
/* loaded from: classes4.dex */
public class NewAnounceLayout extends CardBasicLayout {

    /* renamed from: h  reason: collision with root package name */
    public float f14962h;

    /* renamed from: i  reason: collision with root package name */
    public Context f14963i;
    public View j;
    public TextView k;
    public View l;
    public TextView m;
    public TextView n;
    public View.OnClickListener o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new StatisticItem(TbadkCoreStatisticKey.KEY_ANNOUNCE_AREA).eventStat();
            d dVar = NewAnounceLayout.this.f14961g;
            if (dVar == null || dVar.k() == 0 || TextUtils.isEmpty(NewAnounceLayout.this.f14961g.b()) || NewAnounceLayout.this.f14961g.f() == 2) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(NewAnounceLayout.this.f14963i);
            pbActivityConfig.createNormalCfg(NewAnounceLayout.this.f14961g.k() + "", (String) null, (String) null, true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    public NewAnounceLayout(Context context) {
        this(context, null);
    }

    public final void b() {
        View findViewById = findViewById(R.id.announce_content);
        this.j = findViewById;
        findViewById.setOnClickListener(this.o);
        this.k = (TextView) findViewById(R.id.first_line_tv);
        this.l = findViewById(R.id.second_content);
        this.m = (TextView) findViewById(R.id.second_line_tv);
        this.n = (TextView) findViewById(R.id.announce_tail);
    }

    public void c() {
        this.f14963i = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setGravity(17);
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.new_announce_layout, (ViewGroup) this, true);
        b();
    }

    public void d(int i2) {
        if (this.f14961g == null) {
            return;
        }
        if (this.f14959e != d.a.j0.v.e.a.f61617c) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205, i2);
        } else {
            View view = this.j;
            if (view != null) {
                view.setBackgroundColor(0);
            }
        }
        if (TextUtils.isEmpty(this.f14961g.b())) {
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1, i2);
        } else {
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
        }
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0304, 1, i2);
    }

    public final void e(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.l.setVisibility(0);
            int lineEnd = new StaticLayout(str, this.k.getPaint(), (int) this.f14962h, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0);
            String substring = str.substring(0, lineEnd);
            if (lineEnd >= str.length()) {
                this.l.setVisibility(8);
                this.k.setText(substring);
                return;
            }
            String substring2 = str.substring(lineEnd, str.length());
            if (new StaticLayout(substring2, this.m.getPaint(), (int) this.f14962h, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineEnd(0) >= substring2.length()) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
            this.l.setVisibility(0);
            this.k.setText(substring);
            this.m.setText(substring2);
            return;
        }
        this.l.setVisibility(8);
        this.k.setText(getResources().getString(R.string.empty_announce));
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        super.setData(i2, fVar);
        if (this.f14960f != null && this.f14961g != null && this.f14959e >= 0) {
            this.f14962h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds70) * 2);
            if (this.f14959e == d.a.j0.v.e.a.f61616b) {
                this.f14962h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds116) * 2);
            }
            if (this.f14959e == d.a.j0.v.e.a.f61618d) {
                this.f14962h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds96) * 2);
            }
            if (this.f14959e == d.a.j0.v.e.a.f61617c) {
                this.f14962h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds86) * 2);
                this.j.setPadding(0, 0, 0, 0);
                this.k.setPadding(0, 0, 0, 0);
                this.m.setPadding(0, 0, 0, 0);
                this.n.setPadding(0, 0, 0, 0);
            }
            e(this.f14961g.b());
            return;
        }
        setVisibility(8);
    }

    public NewAnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new a();
        c();
    }
}
