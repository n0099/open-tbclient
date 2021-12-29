package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
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
    public LinearLayout f45449e;

    /* renamed from: f  reason: collision with root package name */
    public Context f45450f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45451g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f45452h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f45453i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f45454j;

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
        this.f45450f = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(g1.frs_broadcast_major_copy_guide_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(f1.frs_broadcast_guide_main);
            this.f45449e = linearLayout;
            this.f45451g = (TextView) linearLayout.findViewById(f1.frs_broadcast_guide_title);
            this.f45452h = (TextView) this.f45449e.findViewById(f1.frs_broadcast_guide_content);
            this.f45453i = (ImageView) this.f45449e.findViewById(f1.guide_iv);
            this.f45454j = (TextView) this.f45449e.findViewById(f1.to_next_tv);
            this.f45451g.setText(i1.forum_broadcast_copy_guide_title);
            this.f45452h.setText(i1.forum_broadcast_copy_guide_hint);
            this.f45454j.setText(i1.comment_tab_dialog_botton_text);
            SkinManager.setViewTextColor(this.f45451g, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f45452h, c1.CAM_X0107);
            SkinManager.setViewTextColor(this.f45454j, c1.CAM_X0302);
            SkinManager.setImageResource(this.f45453i, e1.pic_frs_guide_copylink);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(c1.CAM_X0211).blRadius(n.f(this.f45450f, d1.tbds30)).brRadius(n.f(this.f45450f, d1.tbds30)).tlRadius(n.f(this.f45450f, d1.tbds32)).trRadius(n.f(this.f45450f, d1.tbds32)).into(this.f45449e);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f45454j.setOnClickListener(onClickListener);
    }
}
