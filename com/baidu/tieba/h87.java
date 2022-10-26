package com.baidu.tieba;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h87 extends o9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public LinearLayout c;
    public TextView d;
    public TextView e;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ h87 d;

        public a(h87 h87Var, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h87Var, Long.valueOf(j), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = h87Var;
            this.a = j;
            this.b = str;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.d.mContext.getPageActivity(), String.valueOf(this.a), this.b, this.c, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends rh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMessage a;
        public final /* synthetic */ h87 b;

        public b(h87 h87Var, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h87Var, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h87Var;
            this.a = chatMessage;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            a28 a28Var = new a28(TbadkCoreApplication.getInst());
            a28Var.b(this.b.mContext.getUniqueId());
            a28Var.c(String.valueOf(this.a.getUserId()));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_IM_CYBER_VIOLENCE_MESSAGE_RECEIVER_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", 1));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends rh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(h87 h87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(TbadkCoreApplication.getInst())));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_IM_CYBER_VIOLENCE_MESSAGE_RECEIVER_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", 2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h87(TbPageContext tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d059d);
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
                super((r9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        o();
    }

    public void r(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) {
            this.c.setVisibility(8);
            if (chatMessage == null) {
                this.b.setText("");
            } else if (!p(chatMessage) && !q(chatMessage)) {
                this.b.setVisibility(0);
                String B = bd7.B(chatMessage);
                if (!TextUtils.isEmpty(B)) {
                    this.b.setText(B);
                } else {
                    this.b.setText("");
                }
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = (TextView) j(R.id.obfuscated_res_0x7f0920f9);
            this.b = textView;
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            this.c = (LinearLayout) j(R.id.obfuscated_res_0x7f091251);
            this.d = (TextView) j(R.id.obfuscated_res_0x7f090431);
            this.e = (TextView) j(R.id.obfuscated_res_0x7f092107);
            this.c.setVisibility(8);
        }
    }

    public final boolean p(ChatMessage chatMessage) {
        InterceptResult invokeL;
        UserData toUserInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) {
            if (chatMessage != null && (chatMessage instanceof PersonalChatMessage) && chatMessage.getMsgType() == 11 && !TextUtils.isEmpty(chatMessage.getContent())) {
                try {
                    JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                    String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                    if (optString != null && optString.equals(TbEnum.SystemMessage.EVENT_ID_ADD_FRIEND)) {
                        this.c.setVisibility(0);
                        this.b.setVisibility(8);
                        String optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG);
                        JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                        if (optJSONObject == null) {
                            return false;
                        }
                        int optInt = optJSONObject.optInt("button_type");
                        String optString3 = optJSONObject.optString("name");
                        long optLong = optJSONObject.optLong("userId");
                        if (chatMessage.getUserId() == optLong) {
                            toUserInfo = chatMessage.getUserInfo();
                        } else {
                            toUserInfo = chatMessage.getToUserInfo();
                        }
                        String userName = toUserInfo.getUserName();
                        String portrait = toUserInfo.getPortrait();
                        this.e.setText(optString2);
                        if (optInt == 1) {
                            this.d.setVisibility(0);
                            this.d.setText(optString3);
                            this.d.setOnClickListener(new a(this, optLong, userName, portrait));
                            return true;
                        }
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean q(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage)) == null) {
            if (chatMessage != null && (chatMessage instanceof PersonalChatMessage) && chatMessage.getMsgType() == 11 && !TextUtils.isEmpty(chatMessage.getContent())) {
                try {
                    String optString = new JSONObject(chatMessage.getContent()).optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                    if (!TextUtils.isEmpty(optString) && optString.equals(TbEnum.SystemMessage.EVENT_ID_CYBER_VIOLENCE)) {
                        this.c.setVisibility(8);
                        this.b.setVisibility(0);
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        String string = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08d7);
                        SpannableString spannableString = new SpannableString(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08db));
                        String string2 = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08d8);
                        SpannableString spannableString2 = new SpannableString(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08da));
                        String string3 = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08d9);
                        b bVar = new b(this, chatMessage);
                        c cVar = new c(this);
                        spannableString.setSpan(bVar, 0, spannableString.length(), 33);
                        spannableString2.setSpan(cVar, 0, spannableString2.length(), 33);
                        spannableStringBuilder.append((CharSequence) string).append((CharSequence) spannableString).append((CharSequence) string2).append((CharSequence) spannableString2).append((CharSequence) string3);
                        this.b.setText(spannableStringBuilder);
                        this.b.setMovementMethod(LinkMovementMethod.getInstance());
                        return true;
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
