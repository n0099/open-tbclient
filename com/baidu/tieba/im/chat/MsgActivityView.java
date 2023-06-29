package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.k78;
import com.baidu.tieba.pf;
import com.baidu.tieba.qf;
import com.baidu.tieba.vg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MsgActivityView extends k78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public int L;
    public pf M;
    public qf N;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgActivityView a;

        public a(MsgActivityView msgActivityView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgActivityView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgActivityView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.M != null) {
                this.a.M.D(view2, 8, this.a.L, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgActivityView a;

        public b(MsgActivityView msgActivityView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgActivityView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgActivityView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a.N != null) {
                    this.a.N.Q(view2, 8, this.a.L, 0L);
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ MsgActivityView c;

        public c(MsgActivityView msgActivityView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgActivityView, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = msgActivityView;
            this.a = str;
            this.b = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.a, this.b)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgActivityView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0617);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = (TextView) x(R.id.tex_msgitem_time);
        this.I = (TextView) x(R.id.obfuscated_res_0x7f0917b0);
        this.J = (TextView) x(R.id.obfuscated_res_0x7f0917af);
        this.K = (TextView) x(R.id.obfuscated_res_0x7f0917ae);
        HeadImageView headImageView = (HeadImageView) x(R.id.obfuscated_res_0x7f0910c1);
        this.H = headImageView;
        headImageView.setIsRound(false);
        this.H.setClickable(true);
        y().setOnClickListener(new a(this));
        y().setOnLongClickListener(new b(this));
    }

    @Override // com.baidu.tieba.k78
    public void T(pf pfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pfVar) == null) {
            this.M = pfVar;
        }
    }

    @Override // com.baidu.tieba.k78
    public void U(qf qfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qfVar) == null) {
            this.N = qfVar;
        }
    }

    @Override // com.baidu.tieba.k78
    public void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.L = i;
        }
    }

    public void p0(ChatMessage chatMessage) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, chatMessage) != null) || chatMessage == null) {
            return;
        }
        e0(chatMessage);
        try {
            JSONObject optJSONObject = new JSONObject(chatMessage.getContent()).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("activityTitle");
                String optString2 = optJSONObject.optString("activityTime");
                String optString3 = optJSONObject.optString("activityArea");
                String optString4 = optJSONObject.optString("activityImage");
                String optString5 = optJSONObject.optString("activityUserId");
                String optString6 = optJSONObject.optString("activityUserName");
                this.I.setText(optString);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(vg.g(optString2, 0L) * 1000);
                int i = calendar.get(11);
                int i2 = calendar.get(12);
                int i3 = calendar.get(7) - 1;
                int i4 = calendar.get(1);
                int i5 = calendar.get(2) + 1;
                int i6 = calendar.get(5);
                String str = "";
                switch (i3) {
                    case 0:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f135e);
                        break;
                    case 1:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0ec2);
                        break;
                    case 2:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1743);
                        break;
                    case 3:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f162e);
                        break;
                    case 4:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f07df);
                        break;
                    case 5:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f073f);
                        break;
                    case 6:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f13dd);
                        break;
                }
                if (i > 12) {
                    string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f10ea);
                    i -= 12;
                } else {
                    string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f02b3);
                }
                this.J.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, string, Integer.valueOf(i), Integer.valueOf(i2)));
                if (TextUtils.isEmpty(optString3)) {
                    this.K.setVisibility(4);
                } else {
                    this.K.setVisibility(0);
                    this.K.setText(optString3);
                }
                this.H.setTag(optString4);
                this.H.setOnClickListener(new c(this, optString5, optString6));
                this.H.N(optString4, 12, false);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
