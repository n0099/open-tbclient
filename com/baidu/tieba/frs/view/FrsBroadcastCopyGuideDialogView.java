package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.s0.d1.c1;
import c.a.s0.d1.d1;
import c.a.s0.d1.e1;
import c.a.s0.d1.f1;
import c.a.s0.d1.g1;
import c.a.s0.d1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f45262e;

    /* renamed from: f  reason: collision with root package name */
    public Context f45263f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45264g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f45265h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f45266i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f45267j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsBroadcastCopyGuideDialogView(Context context) {
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
        this.f45263f = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(g1.frs_broadcast_major_copy_guide_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(f1.frs_broadcast_guide_main);
            this.f45262e = linearLayout;
            this.f45264g = (TextView) linearLayout.findViewById(f1.frs_broadcast_guide_title);
            this.f45265h = (TextView) this.f45262e.findViewById(f1.frs_broadcast_guide_content);
            this.f45266i = (ImageView) this.f45262e.findViewById(f1.guide_iv);
            this.f45267j = (TextView) this.f45262e.findViewById(f1.to_next_tv);
            this.f45264g.setText(i1.forum_broadcast_copy_guide_title);
            this.f45265h.setText(i1.forum_broadcast_copy_guide_hint);
            this.f45267j.setText(i1.comment_tab_dialog_botton_text);
            SkinManager.setViewTextColor(this.f45264g, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f45265h, c1.CAM_X0107);
            SkinManager.setViewTextColor(this.f45267j, c1.CAM_X0302);
            SkinManager.setImageResource(this.f45266i, e1.pic_frs_guide_copylink);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(c1.CAM_X0211).blRadius(m.f(this.f45263f, d1.tbds30)).brRadius(m.f(this.f45263f, d1.tbds30)).tlRadius(m.f(this.f45263f, d1.tbds32)).trRadius(m.f(this.f45263f, d1.tbds32)).into(this.f45262e);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f45267j.setOnClickListener(onClickListener);
    }
}
