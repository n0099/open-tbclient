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
public class MaxSignItemView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f13333e;

    /* renamed from: f  reason: collision with root package name */
    public LineView f13334f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f13335g;

    /* renamed from: h  reason: collision with root package name */
    public b f13336h;

    /* renamed from: i  reason: collision with root package name */
    public int f13337i;
    public int j;
    public int k;
    public int l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13338e;

        public a(c cVar) {
            this.f13338e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f13338e.j) {
                return;
            }
            Iterator it = MaxSignItemView.this.f13335g.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f13338e.d(true);
            if (MaxSignItemView.this.f13336h != null) {
                MaxSignItemView.this.f13336h.a(this.f13338e.k);
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
        public int f13340a = R.drawable.ic_pic_mask_task_complete_svg;

        /* renamed from: b  reason: collision with root package name */
        public int f13341b = R.drawable.ic_pic_mask_task_select_svg;

        /* renamed from: c  reason: collision with root package name */
        public int f13342c;

        /* renamed from: d  reason: collision with root package name */
        public int f13343d;

        /* renamed from: e  reason: collision with root package name */
        public int f13344e;

        /* renamed from: f  reason: collision with root package name */
        public View f13345f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f13346g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13347h;

        /* renamed from: i  reason: collision with root package name */
        public CircleView f13348i;
        public boolean j;
        public ActiveCenterData.ActiveCenterStatusData k;

        public c(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            int i2 = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f13342c = i2;
            this.f13343d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f13344e = i2;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f13345f = view;
            this.f13346g = (ImageView) view.findViewById(R.id.item_icon);
            this.f13347h = (TextView) this.f13345f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f13345f.findViewById(R.id.select_circle);
            this.f13348i = circleView;
            circleView.setVisibility(4);
            int i3 = activeCenterStatusData.is_today_mission;
            if (i3 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f13344e = this.f13340a;
                } else {
                    this.f13344e = this.f13343d;
                }
            } else if (i3 == 1) {
                this.f13348i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f13344e = this.f13340a;
                } else {
                    this.f13344e = this.f13341b;
                }
            } else {
                this.f13344e = this.f13342c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13346g, this.f13344e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f13347h, R.color.CAM_X0109);
            TextView textView = this.f13347h;
            textView.setText(activeCenterStatusData.day + "天");
        }

        public void d(boolean z) {
            if (z) {
                this.j = true;
                this.f13348i.setVisibility(0);
                return;
            }
            this.j = false;
            this.f13348i.setVisibility(4);
        }
    }

    public MaxSignItemView(Context context) {
        super(context);
        this.f13335g = new ArrayList<>();
        this.k = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.max_sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.f13333e.addView(inflate, layoutParams);
        c cVar = new c(inflate, activeCenterStatusData);
        cVar.f13346g.setOnClickListener(new a(cVar));
        return cVar;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
        this.f13333e = (LinearLayout) findViewById(R.id.sign_item_container);
        this.f13334f = (LineView) findViewById(R.id.line_view);
        this.f13337i = l.g(getContext(), R.dimen.tbds3);
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
                int i2 = marginLayoutParams.leftMargin;
                int i3 = this.j;
                if (i2 != i3 || marginLayoutParams.rightMargin != i3) {
                    int i4 = this.j;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i4;
                    setLayoutParams(marginLayoutParams);
                }
            } else {
                int i5 = marginLayoutParams.leftMargin;
                int i6 = this.f13337i;
                if (i5 != i6 || marginLayoutParams.rightMargin != i6) {
                    int i7 = this.f13337i;
                    marginLayoutParams.leftMargin = i7;
                    marginLayoutParams.rightMargin = i7;
                    setLayoutParams(layoutParams);
                }
            }
        }
        if (this.f13334f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f13334f.getLayoutParams();
            if (size <= 3) {
                int i8 = marginLayoutParams2.leftMargin;
                int i9 = this.k;
                if (i8 != i9 || marginLayoutParams2.rightMargin != i9) {
                    int i10 = this.k;
                    marginLayoutParams2.leftMargin = i10;
                    marginLayoutParams2.rightMargin = i10;
                    this.f13334f.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i11 = marginLayoutParams2.leftMargin;
                int i12 = this.l;
                if (i11 != i12 || marginLayoutParams2.rightMargin != i12) {
                    int i13 = this.l;
                    marginLayoutParams2.leftMargin = i13;
                    marginLayoutParams2.rightMargin = i13;
                    this.f13334f.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        this.f13333e.removeAllViews();
        this.f13335g.clear();
        for (int i14 = 0; i14 < size; i14++) {
            this.f13335g.add(c(arrayList.get(i14)));
        }
    }

    public void setItemClickListener(b bVar) {
        this.f13336h = bVar;
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13335g = new ArrayList<>();
        this.k = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13335g = new ArrayList<>();
        this.k = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }
}
