package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.e1;
import c.a.r0.d1.f1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f44771e;

    /* renamed from: f  reason: collision with root package name */
    public Context f44772f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44773g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44774h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f44775i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f44776j;

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
        this.f44772f = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(g1.frs_broadcast_major_copy_guide_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(f1.frs_broadcast_guide_main);
            this.f44771e = linearLayout;
            this.f44773g = (TextView) linearLayout.findViewById(f1.frs_broadcast_guide_title);
            this.f44774h = (TextView) this.f44771e.findViewById(f1.frs_broadcast_guide_content);
            this.f44775i = (ImageView) this.f44771e.findViewById(f1.guide_iv);
            this.f44776j = (TextView) this.f44771e.findViewById(f1.to_next_tv);
            this.f44773g.setText(i1.forum_broadcast_copy_guide_title);
            this.f44774h.setText(i1.forum_broadcast_copy_guide_hint);
            this.f44776j.setText(i1.comment_tab_dialog_botton_text);
            SkinManager.setViewTextColor(this.f44773g, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f44774h, c1.CAM_X0107);
            SkinManager.setViewTextColor(this.f44776j, c1.CAM_X0302);
            SkinManager.setImageResource(this.f44775i, e1.pic_frs_guide_copylink);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(c1.CAM_X0211).blRadius(l.f(this.f44772f, d1.tbds30)).brRadius(l.f(this.f44772f, d1.tbds30)).tlRadius(l.f(this.f44772f, d1.tbds32)).trRadius(l.f(this.f44772f, d1.tbds32)).into(this.f44771e);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f44776j.setOnClickListener(onClickListener);
    }
}
