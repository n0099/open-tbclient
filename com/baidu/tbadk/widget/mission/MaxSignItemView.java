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
public class MaxSignItemView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f13916e;

    /* renamed from: f  reason: collision with root package name */
    public LineView f13917f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f13918g;

    /* renamed from: h  reason: collision with root package name */
    public b f13919h;
    public int i;
    public int j;
    public int k;
    public int l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13920e;

        public a(c cVar) {
            this.f13920e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f13920e.j) {
                return;
            }
            Iterator it = MaxSignItemView.this.f13918g.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f13920e.d(true);
            if (MaxSignItemView.this.f13919h != null) {
                MaxSignItemView.this.f13919h.a(this.f13920e.k);
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
        public int f13922a = R.drawable.ic_pic_mask_task_complete_svg;

        /* renamed from: b  reason: collision with root package name */
        public int f13923b = R.drawable.ic_pic_mask_task_select_svg;

        /* renamed from: c  reason: collision with root package name */
        public int f13924c;

        /* renamed from: d  reason: collision with root package name */
        public int f13925d;

        /* renamed from: e  reason: collision with root package name */
        public int f13926e;

        /* renamed from: f  reason: collision with root package name */
        public View f13927f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f13928g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13929h;
        public CircleView i;
        public boolean j;
        public ActiveCenterData.ActiveCenterStatusData k;

        public c(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            int i = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f13924c = i;
            this.f13925d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f13926e = i;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f13927f = view;
            this.f13928g = (ImageView) view.findViewById(R.id.item_icon);
            this.f13929h = (TextView) this.f13927f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f13927f.findViewById(R.id.select_circle);
            this.i = circleView;
            circleView.setVisibility(4);
            int i2 = activeCenterStatusData.is_today_mission;
            if (i2 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f13926e = this.f13922a;
                } else {
                    this.f13926e = this.f13925d;
                }
            } else if (i2 == 1) {
                this.i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f13926e = this.f13922a;
                } else {
                    this.f13926e = this.f13923b;
                }
            } else {
                this.f13926e = this.f13924c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13928g, this.f13926e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f13929h, R.color.CAM_X0109);
            TextView textView = this.f13929h;
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
    }

    public MaxSignItemView(Context context) {
        super(context);
        this.f13918g = new ArrayList<>();
        this.k = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.max_sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.f13916e.addView(inflate, layoutParams);
        c cVar = new c(inflate, activeCenterStatusData);
        cVar.f13928g.setOnClickListener(new a(cVar));
        return cVar;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
        this.f13916e = (LinearLayout) findViewById(R.id.sign_item_container);
        this.f13917f = (LineView) findViewById(R.id.line_view);
        this.i = l.g(getContext(), R.dimen.tbds3);
        this.j = l.g(getContext(), R.dimen.tbds0);
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
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (size <= 3) {
                int i = marginLayoutParams.leftMargin;
                int i2 = this.j;
                if (i != i2 || marginLayoutParams.rightMargin != i2) {
                    int i3 = this.j;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i3;
                    setLayoutParams(marginLayoutParams);
                }
            } else {
                int i4 = marginLayoutParams.leftMargin;
                int i5 = this.i;
                if (i4 != i5 || marginLayoutParams.rightMargin != i5) {
                    int i6 = this.i;
                    marginLayoutParams.leftMargin = i6;
                    marginLayoutParams.rightMargin = i6;
                    setLayoutParams(layoutParams);
                }
            }
        }
        if (this.f13917f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f13917f.getLayoutParams();
            if (size <= 3) {
                int i7 = marginLayoutParams2.leftMargin;
                int i8 = this.k;
                if (i7 != i8 || marginLayoutParams2.rightMargin != i8) {
                    int i9 = this.k;
                    marginLayoutParams2.leftMargin = i9;
                    marginLayoutParams2.rightMargin = i9;
                    this.f13917f.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i10 = marginLayoutParams2.leftMargin;
                int i11 = this.l;
                if (i10 != i11 || marginLayoutParams2.rightMargin != i11) {
                    int i12 = this.l;
                    marginLayoutParams2.leftMargin = i12;
                    marginLayoutParams2.rightMargin = i12;
                    this.f13917f.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        this.f13916e.removeAllViews();
        this.f13918g.clear();
        for (int i13 = 0; i13 < size; i13++) {
            this.f13918g.add(c(arrayList.get(i13)));
        }
    }

    public void setItemClickListener(b bVar) {
        this.f13919h = bVar;
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13918g = new ArrayList<>();
        this.k = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13918g = new ArrayList<>();
        this.k = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }
}
