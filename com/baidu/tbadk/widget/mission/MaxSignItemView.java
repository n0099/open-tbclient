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
public class MaxSignItemView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14232e;

    /* renamed from: f  reason: collision with root package name */
    public LineView f14233f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f14234g;

    /* renamed from: h  reason: collision with root package name */
    public b f14235h;
    public int i;
    public int j;
    public int k;
    public int l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f14236e;

        public a(c cVar) {
            this.f14236e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f14236e.j) {
                return;
            }
            Iterator it = MaxSignItemView.this.f14234g.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f14236e.d(true);
            if (MaxSignItemView.this.f14235h != null) {
                MaxSignItemView.this.f14235h.a(this.f14236e.k);
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
        public int f14238a = R.drawable.ic_pic_mask_task_complete_svg;

        /* renamed from: b  reason: collision with root package name */
        public int f14239b = R.drawable.ic_pic_mask_task_select_svg;

        /* renamed from: c  reason: collision with root package name */
        public int f14240c;

        /* renamed from: d  reason: collision with root package name */
        public int f14241d;

        /* renamed from: e  reason: collision with root package name */
        public int f14242e;

        /* renamed from: f  reason: collision with root package name */
        public View f14243f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f14244g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14245h;
        public CircleView i;
        public boolean j;
        public ActiveCenterData.ActiveCenterStatusData k;

        public c(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            int i = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f14240c = i;
            this.f14241d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f14242e = i;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f14243f = view;
            this.f14244g = (ImageView) view.findViewById(R.id.item_icon);
            this.f14245h = (TextView) this.f14243f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f14243f.findViewById(R.id.select_circle);
            this.i = circleView;
            circleView.setVisibility(4);
            int i2 = activeCenterStatusData.is_today_mission;
            if (i2 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f14242e = this.f14238a;
                } else {
                    this.f14242e = this.f14241d;
                }
            } else if (i2 == 1) {
                this.i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f14242e = this.f14238a;
                } else {
                    this.f14242e = this.f14239b;
                }
            } else {
                this.f14242e = this.f14240c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f14244g, this.f14242e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f14245h, R.color.CAM_X0109);
            TextView textView = this.f14245h;
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
        this.f14234g = new ArrayList<>();
        this.k = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.max_sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.f14232e.addView(inflate, layoutParams);
        c cVar = new c(inflate, activeCenterStatusData);
        cVar.f14244g.setOnClickListener(new a(cVar));
        return cVar;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
        this.f14232e = (LinearLayout) findViewById(R.id.sign_item_container);
        this.f14233f = (LineView) findViewById(R.id.line_view);
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
        if (this.f14233f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f14233f.getLayoutParams();
            if (size <= 3) {
                int i7 = marginLayoutParams2.leftMargin;
                int i8 = this.k;
                if (i7 != i8 || marginLayoutParams2.rightMargin != i8) {
                    int i9 = this.k;
                    marginLayoutParams2.leftMargin = i9;
                    marginLayoutParams2.rightMargin = i9;
                    this.f14233f.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i10 = marginLayoutParams2.leftMargin;
                int i11 = this.l;
                if (i10 != i11 || marginLayoutParams2.rightMargin != i11) {
                    int i12 = this.l;
                    marginLayoutParams2.leftMargin = i12;
                    marginLayoutParams2.rightMargin = i12;
                    this.f14233f.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        this.f14232e.removeAllViews();
        this.f14234g.clear();
        for (int i13 = 0; i13 < size; i13++) {
            this.f14234g.add(c(arrayList.get(i13)));
        }
    }

    public void setItemClickListener(b bVar) {
        this.f14235h = bVar;
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14234g = new ArrayList<>();
        this.k = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14234g = new ArrayList<>();
        this.k = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }
}
