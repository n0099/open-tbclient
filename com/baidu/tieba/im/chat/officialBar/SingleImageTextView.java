package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ae7;
import com.baidu.tieba.k19;
import com.baidu.tieba.pb7;
import com.baidu.tieba.qw4;
import com.baidu.tieba.sf;
import com.baidu.tieba.uc7;
import com.baidu.tieba.vy4;
import com.baidu.tieba.xe7;
import com.baidu.tieba.yi;
import com.baidu.tieba.ym5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SingleImageTextView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TextView b;
    public TextView c;
    public TbImageView d;
    public View e;
    public TextView f;
    public ImageView g;
    public TextView h;
    public sf i;
    public int j;
    public ViewGroup k;
    public TextView l;
    public TextView m;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SingleImageTextView a;

        public a(SingleImageTextView singleImageTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleImageTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = singleImageTextView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a.i != null) {
                    this.a.i.y(view2, 9, this.a.j, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ym5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc7.a h;
        public final /* synthetic */ SingleImageTextView i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SingleImageTextView singleImageTextView, int i, String str, uc7.a aVar) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleImageTextView, Integer.valueOf(i), str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = singleImageTextView;
            this.h = aVar;
        }

        @Override // com.baidu.tieba.ym5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.i.a, this.i.k(this.h.d), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
        }

        @Override // com.baidu.tieba.ym5, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc7.a a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ int c;
        public final /* synthetic */ SingleImageTextView d;

        public c(SingleImageTextView singleImageTextView, uc7.a aVar, TbPageContext tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleImageTextView, aVar, tbPageContext, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = singleImageTextView;
            this.a = aVar;
            this.b = tbPageContext;
            this.c = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:86:0x02a5  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            String str;
            uc7.a aVar;
            String str2;
            int i;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                uc7.a aVar2 = this.a;
                if (aVar2 != null && (str3 = aVar2.d) != null && str3.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                    try {
                        this.d.a.startActivity(Intent.parseUri(this.a.d, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                if (!this.d.g(this.b.getPageActivity().getApplicationContext(), this.a.d)) {
                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.a.d});
                }
                String str4 = this.a.d;
                if (str4 != null && str4.contains("ForumGradePage")) {
                    StatisticItem param = new StatisticItem("c13783").param("uid", TbadkCoreApplication.getCurrentAccountId());
                    try {
                        Uri parse = Uri.parse(this.a.d);
                        String queryParameter = parse.getQueryParameter("forum_id");
                        String queryParameter2 = parse.getQueryParameter("obj_type");
                        param.param("fid", queryParameter);
                        param.param("obj_type", queryParameter2);
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                    TiebaStatic.log(param);
                }
                String str5 = this.a.d;
                if (str5 != null && str5.contains("weeklygodview")) {
                    TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 1));
                }
                String str6 = this.a.d;
                if (str6 != null && str6.contains("unidispatch/hotuserrank")) {
                    TiebaStatic.log(new StatisticItem("c13665").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                if (this.c == 1) {
                    TiebaStatic.eventStat(this.d.a, "official_msg_ck", "click", 1, "fid", this.a.e);
                    pb7 m = xe7.m(this.a.f);
                    if (m != null) {
                        TiebaStatic.eventStat(this.d.a, "message_open_detail", "click", 1, "task_type", m.a, "task_id", m.b, "loc", "0");
                        int i2 = this.a.g;
                        if ((i2 == 1 || i2 == 3) && !"0".equals(m.b)) {
                            ae7.c().a(m.b);
                        }
                    }
                    StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                    statisticItem.param("msg_id", this.a.h / 100);
                    statisticItem.param("official_id", this.a.i);
                    statisticItem.param("official_type", this.a.j);
                    statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                    statisticItem.param("task_id", this.a.k);
                    statisticItem.param("obj_params1", this.a.d);
                    TiebaStatic.log(statisticItem);
                }
                if (this.a.o == 35) {
                    new StatisticItem(CommonStatisticKey.KEY_QUESTION_TOP_NOTIFY_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
                }
                if (CommonStatisticKey.TbMemberOfficialStatic.TB_MEMBER_OFFICIAL_ID.equals(this.a.i)) {
                    CommonStatisticUtils.staticTbMemberNotify(CommonStatisticKey.TbMemberOfficialStatic.MEMBER_OFFICIAL_NOTIFY_LIST_PAGE_MSG_CLICK, this.a.f + "_" + this.a.o, this.a.a);
                }
                StatisticItem statisticItem2 = new StatisticItem("c13784");
                statisticItem2.param("service_id", this.a.l);
                statisticItem2.param("task_id", this.a.k);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", this.a.e);
                if (!TextUtils.isEmpty(this.a.a)) {
                    if (!TextUtils.isEmpty(this.a.d)) {
                        String str7 = null;
                        String[] split = this.a.d.split("tid=");
                        if (split.length > 1) {
                            int indexOf = split[1].indexOf("&");
                            if (indexOf != -1) {
                                str7 = split[1].substring(0, indexOf);
                            } else {
                                str7 = split[1].substring(0);
                            }
                        }
                        statisticItem2.param("tid", str7);
                    }
                    if (this.a.a.contains("互动量")) {
                        statisticItem2.param("obj_source", 2);
                        statisticItem2.param("obj_type", 9);
                    } else if (this.a.a.contains("被加精")) {
                        statisticItem2.param("obj_source", 1);
                        statisticItem2.param("obj_type", 9);
                    } else if (this.a.a.contains("热贴榜")) {
                        statisticItem2.param("obj_type", 8);
                    } else {
                        int i3 = this.a.g;
                        if (i3 == 4) {
                            statisticItem2.param("obj_type", 10);
                        } else if (i3 == 3) {
                            statisticItem2.param("obj_type", 5);
                            str = this.a.i;
                            if (str != null && str.equals("4754917018")) {
                                statisticItem2.delete("obj_type");
                                statisticItem2.param("obj_type", 9);
                                str2 = this.a.d;
                                if (str2 != null) {
                                    if (str2.contains("type=interaction")) {
                                        i = 2;
                                    } else if (this.a.d.contains("type=recommend")) {
                                        i = 3;
                                    } else if (this.a.d.contains("type=attention-bazhu")) {
                                        i = 4;
                                    } else if (this.a.d.contains("type=attention-common")) {
                                        i = 5;
                                    } else {
                                        i = -1;
                                    }
                                    if (i != -1) {
                                        statisticItem2.delete("obj_source");
                                        statisticItem2.param("obj_source", i);
                                    }
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            aVar = this.a;
                            if (aVar.d == null && aVar.i.contains("5044059141")) {
                                TiebaStatic.log(new StatisticItem("c14447").param("uid", TbadkCoreApplication.getCurrentAccount()));
                                return;
                            }
                        }
                    }
                }
                str = this.a.i;
                if (str != null) {
                    statisticItem2.delete("obj_type");
                    statisticItem2.param("obj_type", 9);
                    str2 = this.a.d;
                    if (str2 != null) {
                    }
                }
                TiebaStatic.log(statisticItem2);
                aVar = this.a;
                if (aVar.d == null) {
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleImageTextView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleImageTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final boolean g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                UrlSchemaJumpHelper.jumpPersonChat(context, str, true);
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ALBUM)) {
                UrlSchemaJumpHelper.jumpGameAlbum(context, str);
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_SKILL_DETAIL)) {
                UrlSchemaJumpHelper.jumpGameSkillDetail(context, str);
            } else if (str.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                UrlSchemaJumpHelper.jumpGameGodsPage(context, str);
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ORDER_PAGE)) {
                UrlSchemaJumpHelper.jumpGameOrderPage(context, str);
            } else {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleImageTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = null;
        this.a = context;
        i();
    }

    public final String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return Uri.parse(str).getQueryParameter(TbTitleActivityConfig.FORUM_ID);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public void setOnItemViewLongClickListener(sf sfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sfVar) == null) {
            this.i = sfVar;
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.j = i;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.h.setVisibility(8);
                this.h.setText("");
                return;
            }
            this.h.setVisibility(0);
            this.h.setText(str);
        }
    }

    public void f(uc7.a aVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, aVar) != null) || aVar == null) {
            return;
        }
        this.k.setVisibility(0);
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        this.b.setTypeface(Typeface.defaultFromStyle(0));
        this.b.setMaxLines(1);
        String str3 = "";
        if (TextUtils.isEmpty(aVar.b)) {
            str = "";
        } else {
            str = aVar.b;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("reply");
            try {
                str3 = jSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
            } catch (JSONException e) {
                e = e;
                e.printStackTrace();
                this.l.setText(str2);
                this.m.setText(h(str3));
                new StatisticItem(CommonStatisticKey.KEY_QUESTION_TOP_NOTIFY_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
            }
        } catch (JSONException e2) {
            e = e2;
            str2 = "";
        }
        this.l.setText(str2);
        this.m.setText(h(str3));
        new StatisticItem(CommonStatisticKey.KEY_QUESTION_TOP_NOTIFY_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.d.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 1, skinType);
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0107, 1, skinType);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f080605, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.h, R.color.common_color_10067, 1, skinType);
            SkinManager.setBackgroundResource(this.e, R.drawable.multi_single_divider_selector, skinType);
            qw4 d = qw4.d(this.l);
            d.v(R.color.CAM_X0107);
            d.w(R.dimen.M_T_X003);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f0802b4);
        }
    }

    public final SpannableStringBuilder h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return null;
            }
            int g = yi.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g5 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int g6 = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g7 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e0b);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) string);
            vy4 vy4Var = new vy4(g, -1, R.color.CAM_X0302, g3, R.color.CAM_X0101, g4, g7);
            vy4Var.f(true);
            vy4Var.b(g2);
            vy4Var.h(g5);
            vy4Var.i(g6);
            vy4Var.g(true);
            vy4Var.d(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
            spannableStringBuilder.setSpan(vy4Var, 0, string.length(), 17);
            spannableStringBuilder.append((CharSequence) str);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05b9, (ViewGroup) this, true);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091f56);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091f52);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f53);
            this.d = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.d.setRadius(yi.g(getContext(), R.dimen.tbds20));
            this.d.setConrers(15);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091bab);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f0902c9);
            this.e = findViewById(R.id.obfuscated_res_0x7f091f54);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091f24);
            this.k = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912d7);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f092446);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f092447);
            setOnLongClickListener(new a(this));
            int dimension = (int) this.a.getResources().getDimension(R.dimen.tbds38);
            int dimension2 = (int) this.a.getResources().getDimension(R.dimen.tbds10);
            setPadding(dimension, dimension2, dimension, dimension2);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.setText("");
            this.c.setText("");
            this.d.setBackgroundDrawable(null);
            this.d.setImageDrawable(null);
            this.h.setText("");
            this.h.setVisibility(8);
            this.b.setTypeface(Typeface.defaultFromStyle(1));
            this.b.setMaxLines(2);
            this.d.setVisibility(0);
            this.c.setVisibility(0);
            this.m.setText("");
            this.l.setText("");
            this.k.setBackgroundDrawable(null);
            this.k.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, uc7.a aVar, View view2, int i) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048583, this, tbPageContext, aVar, view2, i) != null) || aVar == null) {
            return;
        }
        String str2 = "";
        if (TextUtils.isEmpty(aVar.a)) {
            str = "";
        } else {
            str = aVar.a;
        }
        this.b.setText(str);
        if (!TextUtils.isEmpty(aVar.b)) {
            str2 = aVar.b;
        }
        if (!TextUtils.isEmpty(aVar.b) && aVar.b.contains(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0913))) {
            b bVar = new b(this, 2, aVar.d, aVar);
            int indexOf = aVar.b.indexOf(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0913));
            SpannableString spannableString = new SpannableString(aVar.b);
            spannableString.setSpan(bVar, indexOf - 1, indexOf + 6, 33);
            this.c.setOnTouchListener(new k19(spannableString));
            this.c.setText(spannableString);
            this.f.setText(R.string.obfuscated_res_0x7f0f02fa);
        } else {
            this.c.setText(str2);
        }
        if (!TextUtils.isEmpty(aVar.d)) {
            if (NewUrlSchemaHelper.SCHEME.equals(aVar.d)) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
            setOnClickListener(new c(this, aVar, tbPageContext, i));
        }
        if (aVar.o == 35) {
            f(aVar);
            return;
        }
        this.k.setVisibility(8);
        this.d.setVisibility(0);
        this.c.setVisibility(0);
        this.b.setTypeface(Typeface.defaultFromStyle(1));
        this.b.setMaxLines(2);
        if (!TextUtils.isEmpty(aVar.c)) {
            this.d.setTag(aVar.c);
            this.d.K(aVar.c, 10, false);
        }
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = 0;
            this.c.setLayoutParams(marginLayoutParams);
        }
    }
}
