package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f51721e;

    /* renamed from: f  reason: collision with root package name */
    public Context f51722f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51723g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51724h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f51725i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f51726j;

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
        this.f51722f = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
            this.f51721e = linearLayout;
            this.f51723g = (TextView) linearLayout.findViewById(R.id.frs_broadcast_guide_title);
            this.f51724h = (TextView) this.f51721e.findViewById(R.id.frs_broadcast_guide_content);
            this.f51725i = (ImageView) this.f51721e.findViewById(R.id.guide_iv);
            this.f51726j = (TextView) this.f51721e.findViewById(R.id.to_next_tv);
            this.f51723g.setText(R.string.forum_broadcast_copy_guide_title);
            this.f51724h.setText(R.string.forum_broadcast_copy_guide_hint);
            this.f51726j.setText(R.string.comment_tab_dialog_botton_text);
            SkinManager.setViewTextColor(this.f51723g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f51724h, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f51726j, R.color.CAM_X0302);
            SkinManager.setImageResource(this.f51725i, R.drawable.pic_frs_guide_copylink);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(l.g(this.f51722f, R.dimen.tbds30)).brRadius(l.g(this.f51722f, R.dimen.tbds30)).tlRadius(l.g(this.f51722f, R.dimen.tbds32)).trRadius(l.g(this.f51722f, R.dimen.tbds32)).into(this.f51721e);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f51726j.setOnClickListener(onClickListener);
    }
}
