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
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignItemView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f13930e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13931f;

    /* renamed from: g  reason: collision with root package name */
    public LineView f13932g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f13933h;
    public b i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13934e;

        public a(c cVar) {
            this.f13934e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f13934e.j) {
                return;
            }
            Iterator it = SignItemView.this.f13933h.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f13934e.d(true);
            if (SignItemView.this.i != null) {
                SignItemView.this.i.a(this.f13934e.k);
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
        public int f13936a = R.drawable.ic_pic_mask_task_complete_svg;

        /* renamed from: b  reason: collision with root package name */
        public int f13937b = R.drawable.ic_pic_mask_task_select_svg;

        /* renamed from: c  reason: collision with root package name */
        public int f13938c;

        /* renamed from: d  reason: collision with root package name */
        public int f13939d;

        /* renamed from: e  reason: collision with root package name */
        public int f13940e;

        /* renamed from: f  reason: collision with root package name */
        public View f13941f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f13942g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13943h;
        public CircleView i;
        public boolean j;
        public ActiveCenterData.ActiveCenterStatusData k;

        public c(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            int i = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f13938c = i;
            this.f13939d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f13940e = i;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f13941f = view;
            this.f13942g = (ImageView) view.findViewById(R.id.item_icon);
            this.f13943h = (TextView) this.f13941f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f13941f.findViewById(R.id.select_circle);
            this.i = circleView;
            circleView.setVisibility(4);
            int i2 = activeCenterStatusData.is_today_mission;
            if (i2 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f13940e = this.f13936a;
                } else {
                    this.f13940e = this.f13939d;
                }
            } else if (i2 == 1) {
                this.i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f13940e = this.f13936a;
                } else {
                    this.f13940e = this.f13937b;
                }
            } else {
                this.f13940e = this.f13938c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13942g, this.f13940e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f13943h, R.color.CAM_X0109);
            TextView textView = this.f13943h;
            textView.setText(activeCenterStatusData.day + "天");
        }

        public void d(boolean z) {
            if (z) {
                this.j = true;
                this.i.setVisibility(0);
                return;
            }
            this.j = false;
            this.i.setVisibility(4);
        }

        public void e() {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13942g, this.f13940e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f13943h, R.color.CAM_X0109);
            this.i.b();
        }
    }

    public SignItemView(Context context) {
        super(context);
        this.f13930e = 3;
        this.f13933h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.f13931f.addView(inflate, layoutParams);
        c cVar = new c(inflate, activeCenterStatusData);
        cVar.f13942g.setOnClickListener(new a(cVar));
        return cVar;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.f13931f = (LinearLayout) findViewById(R.id.sign_item_container);
        this.f13932g = (LineView) findViewById(R.id.line_view);
        this.j = l.g(getContext(), R.dimen.tbds23);
        this.k = l.g(getContext(), R.dimen.tbds26);
    }

    public void e(int i) {
        if (this.f13930e != i) {
            this.f13932g.b();
            Iterator<c> it = this.f13933h.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
        this.f13930e = i;
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
        this.f13931f.removeAllViews();
        this.f13933h.clear();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (size <= 3) {
                int i = this.k;
                marginLayoutParams.leftMargin = i;
                marginLayoutParams.rightMargin = i;
            } else {
                int i2 = this.j;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
            }
            setLayoutParams(marginLayoutParams);
        }
        if (this.f13932g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f13932g.getLayoutParams();
            if (size <= 3) {
                int i3 = marginLayoutParams2.leftMargin;
                int i4 = this.l;
                if (i3 != i4 || marginLayoutParams2.rightMargin != i4) {
                    int i5 = this.l;
                    marginLayoutParams2.leftMargin = i5;
                    marginLayoutParams2.rightMargin = i5;
                    this.f13932g.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i6 = marginLayoutParams2.leftMargin;
                int i7 = this.m;
                if (i6 != i7 || marginLayoutParams2.rightMargin != i7) {
                    int i8 = this.m;
                    marginLayoutParams2.leftMargin = i8;
                    marginLayoutParams2.rightMargin = i8;
                    this.f13932g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            this.f13933h.add(c(arrayList.get(i9)));
        }
    }

    public void setItemClickListener(b bVar) {
        this.i = bVar;
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13930e = 3;
        this.f13933h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13930e = 3;
        this.f13933h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }
}
