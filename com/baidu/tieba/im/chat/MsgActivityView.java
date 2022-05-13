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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e47;
import com.repackage.ef;
import com.repackage.ff;
import com.repackage.kg;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MsgActivityView extends e47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public int F;
    public ef G;
    public ff H;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.G == null) {
                return;
            }
            this.a.G.onItemViewClick(view2, 8, this.a.F, 0L);
        }
    }

    /* loaded from: classes3.dex */
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
                if (this.a.H != null) {
                    this.a.H.onItemViewLongClick(view2, 8, this.a.F, 0L);
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d054d);
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
        this.i = (TextView) e(R.id.obfuscated_res_0x7f091f5d);
        this.C = (TextView) e(R.id.obfuscated_res_0x7f09146e);
        this.D = (TextView) e(R.id.obfuscated_res_0x7f09146d);
        this.E = (TextView) e(R.id.obfuscated_res_0x7f09146c);
        HeadImageView headImageView = (HeadImageView) e(R.id.obfuscated_res_0x7f090ec9);
        this.B = headImageView;
        headImageView.setIsRound(false);
        this.B.setClickable(true);
        g().setOnClickListener(new a(this));
        g().setOnLongClickListener(new b(this));
    }

    public void Q(ChatMessage chatMessage) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) || chatMessage == null) {
            return;
        }
        F(chatMessage);
        try {
            JSONObject optJSONObject = new JSONObject(chatMessage.getContent()).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("activityTitle");
                String optString2 = optJSONObject.optString("activityTime");
                String optString3 = optJSONObject.optString("activityArea");
                String optString4 = optJSONObject.optString("activityImage");
                String optString5 = optJSONObject.optString("activityUserId");
                String optString6 = optJSONObject.optString("activityUserName");
                this.C.setText(optString);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(kg.g(optString2, 0L) * 1000);
                int i = calendar.get(11);
                int i2 = calendar.get(12);
                int i3 = calendar.get(7) - 1;
                int i4 = calendar.get(1);
                int i5 = calendar.get(2) + 1;
                int i6 = calendar.get(5);
                String str = "";
                switch (i3) {
                    case 0:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1127);
                        break;
                    case 1:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0cd2);
                        break;
                    case 2:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1486);
                        break;
                    case 3:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f13ce);
                        break;
                    case 4:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f06bb);
                        break;
                    case 5:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0621);
                        break;
                    case 6:
                        str = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f119e);
                        break;
                }
                if (i > 12) {
                    string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0eab);
                    i -= 12;
                } else {
                    string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0276);
                }
                this.D.setText(String.format("%d-%d-%d %s %s %d:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, string, Integer.valueOf(i), Integer.valueOf(i2)));
                if (TextUtils.isEmpty(optString3)) {
                    this.E.setVisibility(4);
                } else {
                    this.E.setVisibility(0);
                    this.E.setText(optString3);
                }
                this.B.setTag(optString4);
                this.B.setOnClickListener(new c(this, optString5, optString6));
                this.B.K(optString4, 12, false);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.repackage.e47
    public void w(ef efVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, efVar) == null) {
            this.G = efVar;
        }
    }

    @Override // com.repackage.e47
    public void x(ff ffVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ffVar) == null) {
            this.H = ffVar;
        }
    }

    @Override // com.repackage.e47
    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.F = i;
        }
    }
}
