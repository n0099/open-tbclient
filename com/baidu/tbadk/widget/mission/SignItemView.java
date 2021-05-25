package com.baidu.tbadk.widget.mission;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignItemView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f13202e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13203f;

    /* renamed from: g  reason: collision with root package name */
    public LineView f13204g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f13205h;

    /* renamed from: i  reason: collision with root package name */
    public b f13206i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13207e;

        public a(c cVar) {
            this.f13207e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f13207e.j) {
                return;
            }
            Iterator it = SignItemView.this.f13205h.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f13207e.d(true);
            if (SignItemView.this.f13206i != null) {
                SignItemView.this.f13206i.a(this.f13207e.k);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f13209a = R.drawable.ic_pic_mask_task_complete_svg;

        /* renamed from: b  reason: collision with root package name */
        public int f13210b = R.drawable.ic_pic_mask_task_select_svg;

        /* renamed from: c  reason: collision with root package name */
        public int f13211c;

        /* renamed from: d  reason: collision with root package name */
        public int f13212d;

        /* renamed from: e  reason: collision with root package name */
        public int f13213e;

        /* renamed from: f  reason: collision with root package name */
        public View f13214f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f13215g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13216h;

        /* renamed from: i  reason: collision with root package name */
        public CircleView f13217i;
        public boolean j;
        public ActiveCenterData.ActiveCenterStatusData k;

        public c(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            int i2 = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f13211c = i2;
            this.f13212d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f13213e = i2;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f13214f = view;
            this.f13215g = (ImageView) view.findViewById(R.id.item_icon);
            this.f13216h = (TextView) this.f13214f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f13214f.findViewById(R.id.select_circle);
            this.f13217i = circleView;
            circleView.setVisibility(4);
            int i3 = activeCenterStatusData.is_today_mission;
            if (i3 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f13213e = this.f13209a;
                } else {
                    this.f13213e = this.f13212d;
                }
            } else if (i3 == 1) {
                this.f13217i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f13213e = this.f13209a;
                } else {
                    this.f13213e = this.f13210b;
                }
            } else {
                this.f13213e = this.f13211c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13215g, this.f13213e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f13216h, R.color.CAM_X0109);
            TextView textView = this.f13216h;
            textView.setText(activeCenterStatusData.day + "天");
        }

        public void d(boolean z) {
            if (z) {
                this.j = true;
                this.f13217i.setVisibility(0);
                return;
            }
            this.j = false;
            this.f13217i.setVisibility(4);
        }

        public void e() {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13215g, this.f13213e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f13216h, R.color.CAM_X0109);
            this.f13217i.b();
        }
    }

    public SignItemView(Context context) {
        super(context);
        this.f13202e = 3;
        this.f13205h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.f13203f.addView(inflate, layoutParams);
        c cVar = new c(inflate, activeCenterStatusData);
        cVar.f13215g.setOnClickListener(new a(cVar));
        return cVar;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.f13203f = (LinearLayout) findViewById(R.id.sign_item_container);
        this.f13204g = (LineView) findViewById(R.id.line_view);
        this.j = l.g(getContext(), R.dimen.tbds23);
        this.k = l.g(getContext(), R.dimen.tbds26);
    }

    public void e(int i2) {
        if (this.f13202e != i2) {
            this.f13204g.b();
            Iterator<c> it = this.f13205h.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
        this.f13202e = i2;
    }

    public void setData(ActiveCenterData activeCenterData) {
        if (activeCenterData == null) {
            return;
        }
        ArrayList<ActiveCenterData.ActiveCenterStatusData> arrayList = activeCenterData.mission_status_list;
        int size = arrayList.size();
        if (arrayList == null || size == 0) {
            return;
        }
        this.f13203f.removeAllViews();
        this.f13205h.clear();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (size <= 3) {
                int i2 = this.k;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
            } else {
                int i3 = this.j;
                marginLayoutParams.leftMargin = i3;
                marginLayoutParams.rightMargin = i3;
            }
            setLayoutParams(marginLayoutParams);
        }
        if (this.f13204g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f13204g.getLayoutParams();
            if (size <= 3) {
                int i4 = marginLayoutParams2.leftMargin;
                int i5 = this.l;
                if (i4 != i5 || marginLayoutParams2.rightMargin != i5) {
                    int i6 = this.l;
                    marginLayoutParams2.leftMargin = i6;
                    marginLayoutParams2.rightMargin = i6;
                    this.f13204g.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i7 = marginLayoutParams2.leftMargin;
                int i8 = this.m;
                if (i7 != i8 || marginLayoutParams2.rightMargin != i8) {
                    int i9 = this.m;
                    marginLayoutParams2.leftMargin = i9;
                    marginLayoutParams2.rightMargin = i9;
                    this.f13204g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            this.f13205h.add(c(arrayList.get(i10)));
        }
    }

    public void setItemClickListener(b bVar) {
        this.f13206i = bVar;
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13202e = 3;
        this.f13205h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13202e = 3;
        this.f13205h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }
}
