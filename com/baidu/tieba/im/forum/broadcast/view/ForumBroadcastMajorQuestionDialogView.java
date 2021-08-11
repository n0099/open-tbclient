package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f52765e;

    /* renamed from: f  reason: collision with root package name */
    public Context f52766f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52767g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52768h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52769i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBroadcastMajorQuestionDialogView(Context context) {
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
        this.f52766f = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.forum_broadcast_question);
            this.f52765e = linearLayout;
            this.f52767g = (TextView) linearLayout.findViewById(R.id.forum_broadcast_question_title);
            this.f52768h = (TextView) this.f52765e.findViewById(R.id.forum_broadcast_question_content);
            this.f52769i = (TextView) this.f52765e.findViewById(R.id.known_icon);
            this.f52767g.setText(R.string.subscribe_bar_title);
            this.f52768h.setText(R.string.forum_broadcast_major_history_hint);
            this.f52769i.setText(R.string.know);
            SkinManager.setBackgroundResource(this.f52765e, R.drawable.bg_frs_private_dialog);
            SkinManager.setViewTextColor(this.f52767g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f52768h, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f52769i, R.color.CAM_X0302);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f52769i.setOnClickListener(onClickListener);
    }
}
