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
/* loaded from: classes12.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f44969e;

    /* renamed from: f  reason: collision with root package name */
    public Context f44970f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44971g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44972h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44973i;

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
        this.f44970f = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.forum_broadcast_major_question_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.forum_broadcast_question);
            this.f44969e = linearLayout;
            this.f44971g = (TextView) linearLayout.findViewById(R.id.forum_broadcast_question_title);
            this.f44972h = (TextView) this.f44969e.findViewById(R.id.forum_broadcast_question_content);
            this.f44973i = (TextView) this.f44969e.findViewById(R.id.known_icon);
            this.f44971g.setText(R.string.subscribe_bar_title);
            this.f44972h.setText(R.string.forum_broadcast_major_history_hint);
            this.f44973i.setText(R.string.know);
            SkinManager.setBackgroundResource(this.f44969e, R.drawable.bg_frs_private_dialog);
            SkinManager.setViewTextColor(this.f44971g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f44972h, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f44973i, R.color.CAM_X0302);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f44973i.setOnClickListener(onClickListener);
    }
}
