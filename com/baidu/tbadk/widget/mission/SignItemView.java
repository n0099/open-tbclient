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
    public int f13922e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13923f;

    /* renamed from: g  reason: collision with root package name */
    public LineView f13924g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f13925h;
    public b i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13926e;

        public a(c cVar) {
            this.f13926e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f13926e.j) {
                return;
            }
            Iterator it = SignItemView.this.f13925h.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f13926e.d(true);
            if (SignItemView.this.i != null) {
                SignItemView.this.i.a(this.f13926e.k);
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
        public int f13928a = R.drawable.ic_pic_mask_task_complete_svg;

        /* renamed from: b  reason: collision with root package name */
        public int f13929b = R.drawable.ic_pic_mask_task_select_svg;

        /* renamed from: c  reason: collision with root package name */
        public int f13930c;

        /* renamed from: d  reason: collision with root package name */
        public int f13931d;

        /* renamed from: e  reason: collision with root package name */
        public int f13932e;

        /* renamed from: f  reason: collision with root package name */
        public View f13933f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f13934g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13935h;
        public CircleView i;
        public boolean j;
        public ActiveCenterData.ActiveCenterStatusData k;

        public c(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            int i = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f13930c = i;
            this.f13931d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f13932e = i;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f13933f = view;
            this.f13934g = (ImageView) view.findViewById(R.id.item_icon);
            this.f13935h = (TextView) this.f13933f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f13933f.findViewById(R.id.select_circle);
            this.i = circleView;
            circleView.setVisibility(4);
            int i2 = activeCenterStatusData.is_today_mission;
            if (i2 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f13932e = this.f13928a;
                } else {
                    this.f13932e = this.f13931d;
                }
            } else if (i2 == 1) {
                this.i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f13932e = this.f13928a;
                } else {
                    this.f13932e = this.f13929b;
                }
            } else {
                this.f13932e = this.f13930c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13934g, this.f13932e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f13935h, R.color.CAM_X0109);
            TextView textView = this.f13935h;
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
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13934g, this.f13932e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f13935h, R.color.CAM_X0109);
            this.i.b();
        }
    }

    public SignItemView(Context context) {
        super(context);
        this.f13922e = 3;
        this.f13925h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.f13923f.addView(inflate, layoutParams);
        c cVar = new c(inflate, activeCenterStatusData);
        cVar.f13934g.setOnClickListener(new a(cVar));
        return cVar;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.f13923f = (LinearLayout) findViewById(R.id.sign_item_container);
        this.f13924g = (LineView) findViewById(R.id.line_view);
        this.j = l.g(getContext(), R.dimen.tbds23);
        this.k = l.g(getContext(), R.dimen.tbds26);
    }

    public void e(int i) {
        if (this.f13922e != i) {
            this.f13924g.b();
            Iterator<c> it = this.f13925h.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
        this.f13922e = i;
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
        this.f13923f.removeAllViews();
        this.f13925h.clear();
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
        if (this.f13924g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f13924g.getLayoutParams();
            if (size <= 3) {
                int i3 = marginLayoutParams2.leftMargin;
                int i4 = this.l;
                if (i3 != i4 || marginLayoutParams2.rightMargin != i4) {
                    int i5 = this.l;
                    marginLayoutParams2.leftMargin = i5;
                    marginLayoutParams2.rightMargin = i5;
                    this.f13924g.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i6 = marginLayoutParams2.leftMargin;
                int i7 = this.m;
                if (i6 != i7 || marginLayoutParams2.rightMargin != i7) {
                    int i8 = this.m;
                    marginLayoutParams2.leftMargin = i8;
                    marginLayoutParams2.rightMargin = i8;
                    this.f13924g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            this.f13925h.add(c(arrayList.get(i9)));
        }
    }

    public void setItemClickListener(b bVar) {
        this.i = bVar;
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13922e = 3;
        this.f13925h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13922e = 3;
        this.f13925h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }
}
