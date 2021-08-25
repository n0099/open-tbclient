package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.q0.j1.f.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class MsgActivityView extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public int x;
    public c.a.e.e.h.a y;
    public c.a.e.e.h.b z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgActivityView f52726e;

        public a(MsgActivityView msgActivityView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgActivityView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52726e = msgActivityView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52726e.y == null) {
                return;
            }
            this.f52726e.y.onItemViewClick(view, 8, this.f52726e.x, 0L);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgActivityView f52727e;

        public b(MsgActivityView msgActivityView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgActivityView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52727e = msgActivityView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f52727e.z != null) {
                    this.f52727e.z.onItemViewLongClick(view, 8, this.f52727e.x, 0L);
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52729f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ MsgActivityView f52730g;

        public c(MsgActivityView msgActivityView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgActivityView, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52730g = msgActivityView;
            this.f52728e = str;
            this.f52729f = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f52730g.getPageContext().getPageActivity(), this.f52728e, this.f52729f)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgActivityView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgactivity_view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20634h = (TextView) c(R.id.tex_msgitem_time);
        this.u = (TextView) c(R.id.msg_msgactivity_title);
        this.v = (TextView) c(R.id.msg_msgactivity_time);
        this.w = (TextView) c(R.id.msg_msgactivity_address);
        HeadImageView headImageView = (HeadImageView) c(R.id.img_msgactivity_photo);
        this.t = headImageView;
        headImageView.setIsRound(false);
        this.t.setClickable(true);
        d().setOnClickListener(new a(this));
        d().setOnLongClickListener(new b(this));
    }

    public void D(ChatMessage chatMessage) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) || chatMessage == null) {
            return;
        }
        u(chatMessage);
        try {
            JSONObject optJSONObject = new JSONObject(chatMessage.getContent()).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("activityTitle");
                String optString2 = optJSONObject.optString("activityTime");
                String optString3 = optJSONObject.optString("activityArea");
                String optString4 = optJSONObject.optString("activityImage");
                String optString5 = optJSONObject.optString("activityUserId");
                String optString6 = optJSONObject.optString("activityUserName");
                this.u.setText(optString);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(c.a.e.e.m.b.f(optString2, 0L) * 1000);
                int i2 = calendar.get(11);
                int i3 = calendar.get(12);
                int i4 = calendar.get(7) - 1;
                int i5 = calendar.get(1);
                int i6 = calendar.get(2) + 1;
                int i7 = calendar.get(5);
                String str = "";
                switch (i4) {
                    case 0:
                        str = this.mContext.getResources().getString(R.string.seven);
                        break;
                    case 1:
                        str = this.mContext.getResources().getString(R.string.one);
                        break;
                    case 2:
                        str = this.mContext.getResources().getString(R.string.two);
                        break;
                    case 3:
                        str = this.mContext.getResources().getString(R.string.three);
                        break;
                    case 4:
                        str = this.mContext.getResources().getString(R.string.four);
                        break;
                    case 5:
                        str = this.mContext.getResources().getString(R.string.five);
                        break;
                    case 6:
                        str = this.mContext.getResources().getString(R.string.six);
                        break;
                }
                if (i2 > 12) {
                    string = this.mContext.getResources().getString(R.string.pm);
                    i2 -= 12;
                } else {
                    string = this.mContext.getResources().getString(R.string.am);
                }
                this.v.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str, string, Integer.valueOf(i2), Integer.valueOf(i3)));
                if (TextUtils.isEmpty(optString3)) {
                    this.w.setVisibility(4);
                } else {
                    this.w.setVisibility(0);
                    this.w.setText(optString3);
                }
                this.t.setTag(optString4);
                this.t.setOnClickListener(new c(this, optString5, optString6));
                this.t.startLoad(optString4, 12, false);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.a.q0.j1.f.e
    public void n(c.a.e.e.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.y = aVar;
        }
    }

    @Override // c.a.q0.j1.f.e
    public void o(c.a.e.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.z = bVar;
        }
    }

    @Override // c.a.q0.j1.f.e
    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.x = i2;
        }
    }
}
