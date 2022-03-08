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
/* loaded from: classes5.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f43545e;

    /* renamed from: f  reason: collision with root package name */
    public Context f43546f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43547g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43548h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f43549i;

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
        this.f43546f = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.forum_broadcast_question);
            this.f43545e = linearLayout;
            this.f43547g = (TextView) linearLayout.findViewById(R.id.forum_broadcast_question_title);
            this.f43548h = (TextView) this.f43545e.findViewById(R.id.forum_broadcast_question_content);
            this.f43549i = (TextView) this.f43545e.findViewById(R.id.known_icon);
            this.f43547g.setText(R.string.subscribe_bar_title);
            this.f43548h.setText(R.string.forum_broadcast_major_history_hint);
            this.f43549i.setText(R.string.know);
            SkinManager.setBackgroundResource(this.f43545e, R.drawable.bg_frs_private_dialog);
            SkinManager.setViewTextColor(this.f43547g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f43548h, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f43549i, (int) R.color.CAM_X0302);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f43549i.setOnClickListener(onClickListener);
    }
}
