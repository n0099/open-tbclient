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
import c.a.d.f.p.m;
import c.a.r0.f1.n.f;
import c.a.s0.m4.h;
import c.a.s0.s1.g.d;
import c.a.s0.s1.l.c.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URISyntaxException;
/* loaded from: classes12.dex */
public class SingleImageTextView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f46424e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46425f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46426g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f46427h;

    /* renamed from: i  reason: collision with root package name */
    public View f46428i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46429j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f46430k;
    public TextView l;
    public c.a.d.f.h.b m;
    public int n;

    /* loaded from: classes12.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SingleImageTextView f46431e;

        public a(SingleImageTextView singleImageTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleImageTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46431e = singleImageTextView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f46431e.m != null) {
                    this.f46431e.m.onItemViewLongClick(view, 9, this.f46431e.n, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.C1326a l;
        public final /* synthetic */ SingleImageTextView m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SingleImageTextView singleImageTextView, int i2, String str, a.C1326a c1326a) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleImageTextView, Integer.valueOf(i2), str, c1326a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = singleImageTextView;
            this.l = c1326a;
        }

        @Override // c.a.r0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.m.f46424e, this.m.f(this.l.f22269d), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
            }
        }

        @Override // c.a.r0.f1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0306));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1326a f46432e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f46433f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46434g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SingleImageTextView f46435h;

        public c(SingleImageTextView singleImageTextView, a.C1326a c1326a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleImageTextView, c1326a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46435h = singleImageTextView;
            this.f46432e = c1326a;
            this.f46433f = tbPageContext;
            this.f46434g = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:77:0x0244  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            a.C1326a c1326a;
            String str2;
            int i2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a.C1326a c1326a2 = this.f46432e;
                if (c1326a2 != null && (str3 = c1326a2.f22269d) != null && str3.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                    try {
                        this.f46435h.f46424e.startActivity(Intent.parseUri(this.f46432e.f22269d, 1));
                    } catch (URISyntaxException e2) {
                        e2.printStackTrace();
                    }
                }
                UrlManager.getInstance().dealOneLink(this.f46433f, new String[]{this.f46432e.f22269d});
                String str4 = this.f46432e.f22269d;
                if (str4 != null && str4.contains("ForumGradePage")) {
                    StatisticItem param = new StatisticItem("c13783").param("uid", TbadkCoreApplication.getCurrentAccountId());
                    try {
                        Uri parse = Uri.parse(this.f46432e.f22269d);
                        String queryParameter = parse.getQueryParameter("forum_id");
                        String queryParameter2 = parse.getQueryParameter("obj_type");
                        param.param("fid", queryParameter);
                        param.param("obj_type", queryParameter2);
                    } catch (Exception e3) {
                        BdLog.e(e3);
                    }
                    TiebaStatic.log(param);
                }
                String str5 = this.f46432e.f22269d;
                if (str5 != null && str5.contains("weeklygodview")) {
                    TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 1));
                }
                String str6 = this.f46432e.f22269d;
                if (str6 != null && str6.contains("unidispatch/hotuserrank")) {
                    TiebaStatic.log(new StatisticItem("c13665").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                if (this.f46434g == 1) {
                    TiebaStatic.eventStat(this.f46435h.f46424e, "official_msg_ck", "click", 1, "fid", this.f46432e.f22270e);
                    d j2 = c.a.s0.s1.w.c.j(this.f46432e.f22271f);
                    if (j2 != null) {
                        TiebaStatic.eventStat(this.f46435h.f46424e, "message_open_detail", "click", 1, "task_type", j2.a, "task_id", j2.f22152b, "loc", "0");
                        int i3 = this.f46432e.f22272g;
                        if ((i3 == 1 || i3 == 3) && !"0".equals(j2.f22152b)) {
                            c.a.s0.s1.u.a.c().a(j2.f22152b);
                        }
                    }
                    StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                    statisticItem.param("msg_id", this.f46432e.f22273h / 100);
                    statisticItem.param("official_id", this.f46432e.f22274i);
                    statisticItem.param("official_type", this.f46432e.f22275j);
                    statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                    statisticItem.param("task_id", this.f46432e.f22276k);
                    statisticItem.param("obj_params1", this.f46432e.f22269d);
                    TiebaStatic.log(statisticItem);
                }
                StatisticItem statisticItem2 = new StatisticItem("c13784");
                statisticItem2.param("service_id", this.f46432e.l);
                statisticItem2.param("task_id", this.f46432e.f22276k);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", this.f46432e.f22270e);
                if (!TextUtils.isEmpty(this.f46432e.a)) {
                    if (!TextUtils.isEmpty(this.f46432e.f22269d)) {
                        String str7 = null;
                        String[] split = this.f46432e.f22269d.split("tid=");
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
                    if (this.f46432e.a.contains("互动量")) {
                        statisticItem2.param("obj_source", 2);
                        statisticItem2.param("obj_type", 9);
                    } else if (this.f46432e.a.contains("被加精")) {
                        statisticItem2.param("obj_source", 1);
                        statisticItem2.param("obj_type", 9);
                    } else if (this.f46432e.a.contains("热贴榜")) {
                        statisticItem2.param("obj_type", 8);
                    } else {
                        int i4 = this.f46432e.f22272g;
                        if (i4 == 4) {
                            statisticItem2.param("obj_type", 10);
                        } else if (i4 == 3) {
                            statisticItem2.param("obj_type", 5);
                            str = this.f46432e.f22274i;
                            if (str != null && str.equals("4754917018")) {
                                statisticItem2.delete("obj_type");
                                statisticItem2.param("obj_type", 9);
                                str2 = this.f46432e.f22269d;
                                if (str2 != null) {
                                    if (str2.contains("type=interaction")) {
                                        i2 = 2;
                                    } else if (this.f46432e.f22269d.contains("type=recommend")) {
                                        i2 = 3;
                                    } else if (this.f46432e.f22269d.contains("type=attention-bazhu")) {
                                        i2 = 4;
                                    } else {
                                        i2 = this.f46432e.f22269d.contains("type=attention-common") ? 5 : -1;
                                    }
                                    if (i2 != -1) {
                                        statisticItem2.delete("obj_source");
                                        statisticItem2.param("obj_source", i2);
                                    }
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            c1326a = this.f46432e;
                            if (c1326a.f22269d == null && c1326a.f22274i.contains("5044059141")) {
                                TiebaStatic.log(new StatisticItem("c14447").param("uid", TbadkCoreApplication.getCurrentAccount()));
                                return;
                            }
                        }
                    }
                }
                str = this.f46432e.f22274i;
                if (str != null) {
                    statisticItem2.delete("obj_type");
                    statisticItem2.param("obj_type", 9);
                    str2 = this.f46432e.f22269d;
                    if (str2 != null) {
                    }
                }
                TiebaStatic.log(statisticItem2);
                c1326a = this.f46432e;
                if (c1326a.f22269d == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            LayoutInflater.from(this.f46424e).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
            this.f46425f = (TextView) findViewById(R.id.single_title);
            this.f46426g = (TextView) findViewById(R.id.single_abstract);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.single_content_pic);
            this.f46427h = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f46427h.setRadius(m.f(getContext(), R.dimen.tbds20));
            this.f46427h.setConrers(15);
            this.f46429j = (TextView) findViewById(R.id.read_all);
            this.f46430k = (ImageView) findViewById(R.id.arrow);
            this.f46428i = findViewById(R.id.single_divider);
            this.l = (TextView) findViewById(R.id.show_time_single);
            setOnLongClickListener(new a(this));
            int dimension = (int) this.f46424e.getResources().getDimension(R.dimen.tbds38);
            int dimension2 = (int) this.f46424e.getResources().getDimension(R.dimen.tbds10);
            setPadding(dimension, dimension2, dimension, dimension2);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return Uri.parse(str).getQueryParameter(TbTitleActivityConfig.FORUM_ID);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public void onSkinChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.f46427h.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f46425f, R.color.CAM_X0105, 1, skinType);
            SkinManager.setViewTextColor(this.f46426g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f46429j, R.color.CAM_X0107, 1, skinType);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f46430k, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.l, R.color.common_color_10067, 1, skinType);
            SkinManager.setBackgroundResource(this.f46428i, R.drawable.multi_single_divider_selector, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f46425f.setText("");
            this.f46426g.setText("");
            this.f46427h.setBackgroundDrawable(null);
            this.f46427h.setImageDrawable(null);
            this.l.setText("");
            this.l.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1326a c1326a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048580, this, tbPageContext, c1326a, view, i2) == null) || c1326a == null) {
            return;
        }
        this.f46425f.setText(!TextUtils.isEmpty(c1326a.a) ? c1326a.a : "");
        String str = TextUtils.isEmpty(c1326a.f22267b) ? "" : c1326a.f22267b;
        if (!TextUtils.isEmpty(c1326a.f22267b) && c1326a.f22267b.contains(this.f46424e.getResources().getString(R.string.inconformity_forum_rules))) {
            b bVar = new b(this, 2, c1326a.f22269d, c1326a);
            int indexOf = c1326a.f22267b.indexOf(this.f46424e.getResources().getString(R.string.inconformity_forum_rules));
            SpannableString spannableString = new SpannableString(c1326a.f22267b);
            spannableString.setSpan(bVar, indexOf - 1, indexOf + 6, 33);
            this.f46426g.setOnTouchListener(new h(spannableString));
            this.f46426g.setText(spannableString);
            this.f46429j.setText(R.string.bar_tie_complain);
        } else {
            this.f46426g.setText(str);
        }
        if (!TextUtils.isEmpty(c1326a.f22269d)) {
            if (NewUrlSchemaHelper.SCHEME.equals(c1326a.f22269d)) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
            setOnClickListener(new c(this, c1326a, tbPageContext, i2));
        }
        if (!TextUtils.isEmpty(c1326a.f22268c)) {
            this.f46427h.setTag(c1326a.f22268c);
            this.f46427h.startLoad(c1326a.f22268c, 10, false);
        }
        ViewGroup.LayoutParams layoutParams = this.f46426g.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = 0;
            this.f46426g.setLayoutParams(marginLayoutParams);
        }
    }

    public void setOnItemViewLongClickListener(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.l.setVisibility(8);
                this.l.setText("");
                return;
            }
            this.l.setVisibility(0);
            this.l.setText(str);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleImageTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = null;
        this.f46424e = context;
        e();
    }
}
