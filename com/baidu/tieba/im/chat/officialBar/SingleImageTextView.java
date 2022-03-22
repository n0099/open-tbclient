package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.o0.e1.n.f;
import c.a.p0.q4.i;
import c.a.p0.u1.g.d;
import c.a.p0.u1.l.c.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URISyntaxException;
/* loaded from: classes5.dex */
public class SingleImageTextView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33759b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33760c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f33761d;

    /* renamed from: e  reason: collision with root package name */
    public View f33762e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33763f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33764g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33765h;
    public c.a.d.f.h.b i;
    public int j;

    /* loaded from: classes5.dex */
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
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.a.i != null) {
                    this.a.i.onItemViewLongClick(view, 9, this.a.j, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a.C1417a f33766h;
        public final /* synthetic */ SingleImageTextView i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SingleImageTextView singleImageTextView, int i, String str, a.C1417a c1417a) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleImageTextView, Integer.valueOf(i), str, c1417a};
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
            this.f33766h = c1417a;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.i.a, this.i.g(this.f33766h.f18836d), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
            }
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.C1417a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f33767b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f33768c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SingleImageTextView f33769d;

        public c(SingleImageTextView singleImageTextView, a.C1417a c1417a, TbPageContext tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleImageTextView, c1417a, tbPageContext, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33769d = singleImageTextView;
            this.a = c1417a;
            this.f33767b = tbPageContext;
            this.f33768c = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:77:0x0244  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            a.C1417a c1417a;
            String str2;
            int i;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a.C1417a c1417a2 = this.a;
                if (c1417a2 != null && (str3 = c1417a2.f18836d) != null && str3.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                    try {
                        this.f33769d.a.startActivity(Intent.parseUri(this.a.f18836d, 1));
                    } catch (URISyntaxException e2) {
                        e2.printStackTrace();
                    }
                }
                UrlManager.getInstance().dealOneLink(this.f33767b, new String[]{this.a.f18836d});
                String str4 = this.a.f18836d;
                if (str4 != null && str4.contains("ForumGradePage")) {
                    StatisticItem param = new StatisticItem("c13783").param("uid", TbadkCoreApplication.getCurrentAccountId());
                    try {
                        Uri parse = Uri.parse(this.a.f18836d);
                        String queryParameter = parse.getQueryParameter("forum_id");
                        String queryParameter2 = parse.getQueryParameter("obj_type");
                        param.param("fid", queryParameter);
                        param.param("obj_type", queryParameter2);
                    } catch (Exception e3) {
                        BdLog.e(e3);
                    }
                    TiebaStatic.log(param);
                }
                String str5 = this.a.f18836d;
                if (str5 != null && str5.contains("weeklygodview")) {
                    TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 1));
                }
                String str6 = this.a.f18836d;
                if (str6 != null && str6.contains("unidispatch/hotuserrank")) {
                    TiebaStatic.log(new StatisticItem("c13665").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                if (this.f33768c == 1) {
                    TiebaStatic.eventStat(this.f33769d.a, "official_msg_ck", "click", 1, "fid", this.a.f18837e);
                    d j = c.a.p0.u1.w.c.j(this.a.f18838f);
                    if (j != null) {
                        TiebaStatic.eventStat(this.f33769d.a, "message_open_detail", "click", 1, StampMissionHttpRequestMessage.KEY_TASK_TYPE, j.a, "task_id", j.f18756b, "loc", "0");
                        int i2 = this.a.f18839g;
                        if ((i2 == 1 || i2 == 3) && !"0".equals(j.f18756b)) {
                            c.a.p0.u1.u.a.c().a(j.f18756b);
                        }
                    }
                    StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                    statisticItem.param("msg_id", this.a.f18840h / 100);
                    statisticItem.param("official_id", this.a.i);
                    statisticItem.param("official_type", this.a.j);
                    statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                    statisticItem.param("task_id", this.a.k);
                    statisticItem.param("obj_params1", this.a.f18836d);
                    TiebaStatic.log(statisticItem);
                }
                StatisticItem statisticItem2 = new StatisticItem("c13784");
                statisticItem2.param("service_id", this.a.l);
                statisticItem2.param("task_id", this.a.k);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", this.a.f18837e);
                if (!TextUtils.isEmpty(this.a.a)) {
                    if (!TextUtils.isEmpty(this.a.f18836d)) {
                        String str7 = null;
                        String[] split = this.a.f18836d.split("tid=");
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
                        int i3 = this.a.f18839g;
                        if (i3 == 4) {
                            statisticItem2.param("obj_type", 10);
                        } else if (i3 == 3) {
                            statisticItem2.param("obj_type", 5);
                            str = this.a.i;
                            if (str != null && str.equals("4754917018")) {
                                statisticItem2.delete("obj_type");
                                statisticItem2.param("obj_type", 9);
                                str2 = this.a.f18836d;
                                if (str2 != null) {
                                    if (str2.contains("type=interaction")) {
                                        i = 2;
                                    } else if (this.a.f18836d.contains("type=recommend")) {
                                        i = 3;
                                    } else if (this.a.f18836d.contains("type=attention-bazhu")) {
                                        i = 4;
                                    } else {
                                        i = this.a.f18836d.contains("type=attention-common") ? 5 : -1;
                                    }
                                    if (i != -1) {
                                        statisticItem2.delete("obj_source");
                                        statisticItem2.param("obj_source", i);
                                    }
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            c1417a = this.a;
                            if (c1417a.f18836d == null && c1417a.i.contains("5044059141")) {
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
                    str2 = this.a.f18836d;
                    if (str2 != null) {
                    }
                }
                TiebaStatic.log(statisticItem2);
                c1417a = this.a;
                if (c1417a.f18836d == null) {
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

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d056e, (ViewGroup) this, true);
            this.f33759b = (TextView) findViewById(R.id.obfuscated_res_0x7f091d2a);
            this.f33760c = (TextView) findViewById(R.id.obfuscated_res_0x7f091d26);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091d27);
            this.f33761d = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f33761d.setRadius(n.f(getContext(), R.dimen.tbds20));
            this.f33761d.setConrers(15);
            this.f33763f = (TextView) findViewById(R.id.obfuscated_res_0x7f0919c4);
            this.f33764g = (ImageView) findViewById(R.id.obfuscated_res_0x7f0902a3);
            this.f33762e = findViewById(R.id.obfuscated_res_0x7f091d28);
            this.f33765h = (TextView) findViewById(R.id.obfuscated_res_0x7f091cfa);
            setOnLongClickListener(new a(this));
            int dimension = (int) this.a.getResources().getDimension(R.dimen.tbds38);
            int dimension2 = (int) this.a.getResources().getDimension(R.dimen.tbds10);
            setPadding(dimension, dimension2, dimension, dimension2);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.f33761d.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f33759b, R.color.CAM_X0105, 1, skinType);
            SkinManager.setViewTextColor(this.f33760c, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f33763f, R.color.CAM_X0107, 1, skinType);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33764g, R.drawable.obfuscated_res_0x7f0805f8, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.f33765h, R.color.common_color_10067, 1, skinType);
            SkinManager.setBackgroundResource(this.f33762e, R.drawable.multi_single_divider_selector, skinType);
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return Uri.parse(str).getQueryParameter(TbTitleActivityConfig.FORUM_ID);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f33759b.setText("");
            this.f33760c.setText("");
            this.f33761d.setBackgroundDrawable(null);
            this.f33761d.setImageDrawable(null);
            this.f33765h.setText("");
            this.f33765h.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1417a c1417a, View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048580, this, tbPageContext, c1417a, view, i) == null) || c1417a == null) {
            return;
        }
        this.f33759b.setText(!TextUtils.isEmpty(c1417a.a) ? c1417a.a : "");
        String str = TextUtils.isEmpty(c1417a.f18834b) ? "" : c1417a.f18834b;
        if (!TextUtils.isEmpty(c1417a.f18834b) && c1417a.f18834b.contains(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f08cd))) {
            b bVar = new b(this, 2, c1417a.f18836d, c1417a);
            int indexOf = c1417a.f18834b.indexOf(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f08cd));
            SpannableString spannableString = new SpannableString(c1417a.f18834b);
            spannableString.setSpan(bVar, indexOf - 1, indexOf + 6, 33);
            this.f33760c.setOnTouchListener(new i(spannableString));
            this.f33760c.setText(spannableString);
            this.f33763f.setText(R.string.obfuscated_res_0x7f0f02e4);
        } else {
            this.f33760c.setText(str);
        }
        if (!TextUtils.isEmpty(c1417a.f18836d)) {
            if (NewUrlSchemaHelper.SCHEME.equals(c1417a.f18836d)) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
            setOnClickListener(new c(this, c1417a, tbPageContext, i));
        }
        if (!TextUtils.isEmpty(c1417a.f18835c)) {
            this.f33761d.setTag(c1417a.f18835c);
            this.f33761d.J(c1417a.f18835c, 10, false);
        }
        ViewGroup.LayoutParams layoutParams = this.f33760c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = 0;
            this.f33760c.setLayoutParams(marginLayoutParams);
        }
    }

    public void setOnItemViewLongClickListener(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.j = i;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f33765h.setVisibility(8);
                this.f33765h.setText("");
                return;
            }
            this.f33765h.setVisibility(0);
            this.f33765h.setText(str);
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
        e();
    }
}
