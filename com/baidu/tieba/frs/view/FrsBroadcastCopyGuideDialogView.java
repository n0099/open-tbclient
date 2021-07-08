package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f16156e;

    /* renamed from: f  reason: collision with root package name */
    public Context f16157f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16158g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16159h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f16160i;
    public TextView j;

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
        this.f16157f = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
            this.f16156e = linearLayout;
            this.f16158g = (TextView) linearLayout.findViewById(R.id.frs_broadcast_guide_title);
            this.f16159h = (TextView) this.f16156e.findViewById(R.id.frs_broadcast_guide_content);
            this.f16160i = (ImageView) this.f16156e.findViewById(R.id.guide_iv);
            this.j = (TextView) this.f16156e.findViewById(R.id.to_next_tv);
            this.f16158g.setText(R.string.forum_broadcast_copy_guide_title);
            this.f16159h.setText(R.string.forum_broadcast_copy_guide_hint);
            this.j.setText(R.string.comment_tab_dialog_botton_text);
            SkinManager.setViewTextColor(this.f16158g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f16159h, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0302);
            SkinManager.setImageResource(this.f16160i, R.drawable.pic_frs_guide_copylink);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(l.g(this.f16157f, R.dimen.tbds30)).brRadius(l.g(this.f16157f, R.dimen.tbds30)).tlRadius(l.g(this.f16157f, R.dimen.tbds32)).trRadius(l.g(this.f16157f, R.dimen.tbds32)).into(this.f16156e);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.j.setOnClickListener(onClickListener);
    }
}
