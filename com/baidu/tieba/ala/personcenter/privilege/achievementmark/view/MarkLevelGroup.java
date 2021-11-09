package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.r0.w.l.g.c.b.d;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class MarkLevelGroup extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f47205e;

    /* renamed from: f  reason: collision with root package name */
    public List<View> f47206f;

    /* renamed from: g  reason: collision with root package name */
    public b f47207g;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47208e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkLevelGroup f47209f;

        public a(MarkLevelGroup markLevelGroup, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {markLevelGroup, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47209f = markLevelGroup;
            this.f47208e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                for (View view2 : this.f47209f.f47206f) {
                    if (view == view2) {
                        this.f47209f.e((FrameLayout) view2.findViewById(R.id.mark_level_layout), true);
                    } else {
                        this.f47209f.e((FrameLayout) view2.findViewById(R.id.mark_level_layout), false);
                    }
                }
                if (this.f47209f.f47207g != null) {
                    this.f47209f.f47207g.a(this.f47208e.b(), this.f47208e.a());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(String str, String str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkLevelGroup(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
            setGravity(1);
            LayoutInflater.from(getContext()).inflate(R.layout.ala_achievement_mark_level_layout, (ViewGroup) this, true);
            this.f47205e = (LinearLayout) findViewById(R.id.mark_level_list_container);
        }
    }

    public final void e(FrameLayout frameLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout, z) == null) {
            if (z) {
                frameLayout.setBackgroundResource(R.drawable.pic_live_honor_show_s);
            } else {
                frameLayout.setBackgroundResource(0);
            }
        }
    }

    public void setCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f47207g = bVar;
        }
    }

    public void updateData(b.a.r0.w.l.g.c.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null) {
            return;
        }
        List<d> c2 = bVar.c();
        if (ListUtils.isEmpty(c2)) {
            if (getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds118);
                setLayoutParams(layoutParams);
            }
            setVisibility(4);
            return;
        }
        setVisibility(0);
        this.f47205e.removeAllViews();
        List<View> list = this.f47206f;
        if (list == null) {
            this.f47206f = new ArrayList();
        } else {
            list.clear();
        }
        int size = c2.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = c2.get(i2);
            if (dVar != null) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_achievement_mark_level_item_view, (ViewGroup) null);
                FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.mark_level_layout);
                TextView textView = (TextView) inflate.findViewById(R.id.mark_level_tv);
                textView.setText(String.valueOf(i2 + 1));
                ((TextView) inflate.findViewById(R.id.mark_level_score_tv)).setText(AlaStringHelper.numFormatMarkLevel(dVar.d()));
                this.f47206f.add(inflate);
                boolean z = bVar.j() == 0;
                if (bVar.g() == dVar.c()) {
                    e(frameLayout, true);
                    if (z) {
                        textView.setBackgroundResource(R.drawable.pic_live_honor_show_off);
                    } else {
                        textView.setBackgroundResource(R.drawable.pic_live_honor_show_on);
                    }
                } else if (bVar.g() > dVar.c()) {
                    e(frameLayout, false);
                    if (z) {
                        textView.setBackgroundResource(R.drawable.pic_live_honor_show_off);
                    } else {
                        textView.setBackgroundResource(R.drawable.pic_live_honor_show_on);
                    }
                } else if (bVar.g() < dVar.c()) {
                    e(frameLayout, false);
                    textView.setBackgroundResource(R.drawable.pic_live_honor_show_off);
                }
                inflate.setOnClickListener(new a(this, dVar));
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds82), -2);
                } else {
                    layoutParams2.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds82);
                    layoutParams2.height = -2;
                }
                this.f47205e.addView(inflate, layoutParams2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkLevelGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkLevelGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        d();
    }
}
