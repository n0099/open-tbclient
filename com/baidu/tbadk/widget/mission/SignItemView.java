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
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class SignItemView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f14246e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14247f;

    /* renamed from: g  reason: collision with root package name */
    public LineView f14248g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f14249h;
    public b i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f14250e;

        public a(c cVar) {
            this.f14250e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f14250e.j) {
                return;
            }
            Iterator it = SignItemView.this.f14249h.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f14250e.d(true);
            if (SignItemView.this.i != null) {
                SignItemView.this.i.a(this.f14250e.k);
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
        public int f14252a = R.drawable.ic_pic_mask_task_complete_svg;

        /* renamed from: b  reason: collision with root package name */
        public int f14253b = R.drawable.ic_pic_mask_task_select_svg;

        /* renamed from: c  reason: collision with root package name */
        public int f14254c;

        /* renamed from: d  reason: collision with root package name */
        public int f14255d;

        /* renamed from: e  reason: collision with root package name */
        public int f14256e;

        /* renamed from: f  reason: collision with root package name */
        public View f14257f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f14258g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14259h;
        public CircleView i;
        public boolean j;
        public ActiveCenterData.ActiveCenterStatusData k;

        public c(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            int i = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f14254c = i;
            this.f14255d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f14256e = i;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f14257f = view;
            this.f14258g = (ImageView) view.findViewById(R.id.item_icon);
            this.f14259h = (TextView) this.f14257f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f14257f.findViewById(R.id.select_circle);
            this.i = circleView;
            circleView.setVisibility(4);
            int i2 = activeCenterStatusData.is_today_mission;
            if (i2 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f14256e = this.f14252a;
                } else {
                    this.f14256e = this.f14255d;
                }
            } else if (i2 == 1) {
                this.i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f14256e = this.f14252a;
                } else {
                    this.f14256e = this.f14253b;
                }
            } else {
                this.f14256e = this.f14254c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f14258g, this.f14256e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f14259h, R.color.CAM_X0109);
            TextView textView = this.f14259h;
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
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f14258g, this.f14256e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f14259h, R.color.CAM_X0109);
            this.i.b();
        }
    }

    public SignItemView(Context context) {
        super(context);
        this.f14246e = 3;
        this.f14249h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.f14247f.addView(inflate, layoutParams);
        c cVar = new c(inflate, activeCenterStatusData);
        cVar.f14258g.setOnClickListener(new a(cVar));
        return cVar;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.f14247f = (LinearLayout) findViewById(R.id.sign_item_container);
        this.f14248g = (LineView) findViewById(R.id.line_view);
        this.j = l.g(getContext(), R.dimen.tbds23);
        this.k = l.g(getContext(), R.dimen.tbds26);
    }

    public void e(int i) {
        if (this.f14246e != i) {
            this.f14248g.b();
            Iterator<c> it = this.f14249h.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
        this.f14246e = i;
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
        this.f14247f.removeAllViews();
        this.f14249h.clear();
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
        if (this.f14248g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f14248g.getLayoutParams();
            if (size <= 3) {
                int i3 = marginLayoutParams2.leftMargin;
                int i4 = this.l;
                if (i3 != i4 || marginLayoutParams2.rightMargin != i4) {
                    int i5 = this.l;
                    marginLayoutParams2.leftMargin = i5;
                    marginLayoutParams2.rightMargin = i5;
                    this.f14248g.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i6 = marginLayoutParams2.leftMargin;
                int i7 = this.m;
                if (i6 != i7 || marginLayoutParams2.rightMargin != i7) {
                    int i8 = this.m;
                    marginLayoutParams2.leftMargin = i8;
                    marginLayoutParams2.rightMargin = i8;
                    this.f14248g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            this.f14249h.add(c(arrayList.get(i9)));
        }
    }

    public void setItemClickListener(b bVar) {
        this.i = bVar;
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14246e = 3;
        this.f14249h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14246e = 3;
        this.f14249h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }
}
