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
import c.a.s0.f1.n.f;
import c.a.t0.n4.h;
import c.a.t0.t1.g.d;
import c.a.t0.t1.l.c.a;
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
    public Context f44948e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44949f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44950g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f44951h;

    /* renamed from: i  reason: collision with root package name */
    public View f44952i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f44953j;
    public ImageView k;
    public TextView l;
    public c.a.d.f.h.b m;
    public int n;

    /* loaded from: classes12.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SingleImageTextView f44954e;

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
            this.f44954e = singleImageTextView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f44954e.m != null) {
                    this.f44954e.m.onItemViewLongClick(view, 9, this.f44954e.n, 0L);
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
        public final /* synthetic */ a.C1381a l;
        public final /* synthetic */ SingleImageTextView m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SingleImageTextView singleImageTextView, int i2, String str, a.C1381a c1381a) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleImageTextView, Integer.valueOf(i2), str, c1381a};
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
            this.l = c1381a;
        }

        @Override // c.a.s0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.m.f44948e, this.m.f(this.l.f22434d), ForumRulesShowActivityConfig.FORUM_RULE_SHOW_FROM_MESSAGE)));
            }
        }

        @Override // c.a.s0.f1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
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
        public final /* synthetic */ a.C1381a f44955e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f44956f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44957g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SingleImageTextView f44958h;

        public c(SingleImageTextView singleImageTextView, a.C1381a c1381a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleImageTextView, c1381a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44958h = singleImageTextView;
            this.f44955e = c1381a;
            this.f44956f = tbPageContext;
            this.f44957g = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:77:0x0244  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            a.C1381a c1381a;
            String str2;
            int i2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a.C1381a c1381a2 = this.f44955e;
                if (c1381a2 != null && (str3 = c1381a2.f22434d) != null && str3.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                    try {
                        this.f44958h.f44948e.startActivity(Intent.parseUri(this.f44955e.f22434d, 1));
                    } catch (URISyntaxException e2) {
                        e2.printStackTrace();
                    }
                }
                UrlManager.getInstance().dealOneLink(this.f44956f, new String[]{this.f44955e.f22434d});
                String str4 = this.f44955e.f22434d;
                if (str4 != null && str4.contains("ForumGradePage")) {
                    StatisticItem param = new StatisticItem("c13783").param("uid", TbadkCoreApplication.getCurrentAccountId());
                    try {
                        Uri parse = Uri.parse(this.f44955e.f22434d);
                        String queryParameter = parse.getQueryParameter("forum_id");
                        String queryParameter2 = parse.getQueryParameter("obj_type");
                        param.param("fid", queryParameter);
                        param.param("obj_type", queryParameter2);
                    } catch (Exception e3) {
                        BdLog.e(e3);
                    }
                    TiebaStatic.log(param);
                }
                String str5 = this.f44955e.f22434d;
                if (str5 != null && str5.contains("weeklygodview")) {
                    TiebaStatic.log(new StatisticItem("c13691").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", 1));
                }
                String str6 = this.f44955e.f22434d;
                if (str6 != null && str6.contains("unidispatch/hotuserrank")) {
                    TiebaStatic.log(new StatisticItem("c13665").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                if (this.f44957g == 1) {
                    TiebaStatic.eventStat(this.f44958h.f44948e, "official_msg_ck", "click", 1, "fid", this.f44955e.f22435e);
                    d j2 = c.a.t0.t1.w.c.j(this.f44955e.f22436f);
                    if (j2 != null) {
                        TiebaStatic.eventStat(this.f44958h.f44948e, "message_open_detail", "click", 1, "task_type", j2.a, "task_id", j2.f22322b, "loc", "0");
                        int i3 = this.f44955e.f22437g;
                        if ((i3 == 1 || i3 == 3) && !"0".equals(j2.f22322b)) {
                            c.a.t0.t1.u.a.c().a(j2.f22322b);
                        }
                    }
                    StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                    statisticItem.param("msg_id", this.f44955e.f22438h / 100);
                    statisticItem.param("official_id", this.f44955e.f22439i);
                    statisticItem.param("official_type", this.f44955e.f22440j);
                    statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                    statisticItem.param("task_id", this.f44955e.k);
                    statisticItem.param("obj_params1", this.f44955e.f22434d);
                    TiebaStatic.log(statisticItem);
                }
                StatisticItem statisticItem2 = new StatisticItem("c13784");
                statisticItem2.param("service_id", this.f44955e.l);
                statisticItem2.param("task_id", this.f44955e.k);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", this.f44955e.f22435e);
                if (!TextUtils.isEmpty(this.f44955e.a)) {
                    if (!TextUtils.isEmpty(this.f44955e.f22434d)) {
                        String str7 = null;
                        String[] split = this.f44955e.f22434d.split("tid=");
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
                    if (this.f44955e.a.contains("互动量")) {
                        statisticItem2.param("obj_source", 2);
                        statisticItem2.param("obj_type", 9);
                    } else if (this.f44955e.a.contains("被加精")) {
                        statisticItem2.param("obj_source", 1);
                        statisticItem2.param("obj_type", 9);
                    } else if (this.f44955e.a.contains("热贴榜")) {
                        statisticItem2.param("obj_type", 8);
                    } else {
                        int i4 = this.f44955e.f22437g;
                        if (i4 == 4) {
                            statisticItem2.param("obj_type", 10);
                        } else if (i4 == 3) {
                            statisticItem2.param("obj_type", 5);
                            str = this.f44955e.f22439i;
                            if (str != null && str.equals("4754917018")) {
                                statisticItem2.delete("obj_type");
                                statisticItem2.param("obj_type", 9);
                                str2 = this.f44955e.f22434d;
                                if (str2 != null) {
                                    if (str2.contains("type=interaction")) {
                                        i2 = 2;
                                    } else if (this.f44955e.f22434d.contains("type=recommend")) {
                                        i2 = 3;
                                    } else if (this.f44955e.f22434d.contains("type=attention-bazhu")) {
                                        i2 = 4;
                                    } else {
                                        i2 = this.f44955e.f22434d.contains("type=attention-common") ? 5 : -1;
                                    }
                                    if (i2 != -1) {
                                        statisticItem2.delete("obj_source");
                                        statisticItem2.param("obj_source", i2);
                                    }
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            c1381a = this.f44955e;
                            if (c1381a.f22434d == null && c1381a.f22439i.contains("5044059141")) {
                                TiebaStatic.log(new StatisticItem("c14447").param("uid", TbadkCoreApplication.getCurrentAccount()));
                                return;
                            }
                        }
                    }
                }
                str = this.f44955e.f22439i;
                if (str != null) {
                    statisticItem2.delete("obj_type");
                    statisticItem2.param("obj_type", 9);
                    str2 = this.f44955e.f22434d;
                    if (str2 != null) {
                    }
                }
                TiebaStatic.log(statisticItem2);
                c1381a = this.f44955e;
                if (c1381a.f22434d == null) {
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
            LayoutInflater.from(this.f44948e).inflate(R.layout.msg_single_pic_text_view, (ViewGroup) this, true);
            this.f44949f = (TextView) findViewById(R.id.single_title);
            this.f44950g = (TextView) findViewById(R.id.single_abstract);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.single_content_pic);
            this.f44951h = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f44951h.setRadius(n.f(getContext(), R.dimen.tbds20));
            this.f44951h.setConrers(15);
            this.f44953j = (TextView) findViewById(R.id.read_all);
            this.k = (ImageView) findViewById(R.id.arrow);
            this.f44952i = findViewById(R.id.single_divider);
            this.l = (TextView) findViewById(R.id.show_time_single);
            setOnLongClickListener(new a(this));
            int dimension = (int) this.f44948e.getResources().getDimension(R.dimen.tbds38);
            int dimension2 = (int) this.f44948e.getResources().getDimension(R.dimen.tbds10);
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
            this.f44951h.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f44949f, R.color.CAM_X0105, 1, skinType);
            SkinManager.setViewTextColor(this.f44950g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f44953j, R.color.CAM_X0107, 1, skinType);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.l, R.color.common_color_10067, 1, skinType);
            SkinManager.setBackgroundResource(this.f44952i, R.drawable.multi_single_divider_selector, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f44949f.setText("");
            this.f44950g.setText("");
            this.f44951h.setBackgroundDrawable(null);
            this.f44951h.setImageDrawable(null);
            this.l.setText("");
            this.l.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1381a c1381a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048580, this, tbPageContext, c1381a, view, i2) == null) || c1381a == null) {
            return;
        }
        this.f44949f.setText(!TextUtils.isEmpty(c1381a.a) ? c1381a.a : "");
        String str = TextUtils.isEmpty(c1381a.f22432b) ? "" : c1381a.f22432b;
        if (!TextUtils.isEmpty(c1381a.f22432b) && c1381a.f22432b.contains(this.f44948e.getResources().getString(R.string.inconformity_forum_rules))) {
            b bVar = new b(this, 2, c1381a.f22434d, c1381a);
            int indexOf = c1381a.f22432b.indexOf(this.f44948e.getResources().getString(R.string.inconformity_forum_rules));
            SpannableString spannableString = new SpannableString(c1381a.f22432b);
            spannableString.setSpan(bVar, indexOf - 1, indexOf + 6, 33);
            this.f44950g.setOnTouchListener(new h(spannableString));
            this.f44950g.setText(spannableString);
            this.f44953j.setText(R.string.bar_tie_complain);
        } else {
            this.f44950g.setText(str);
        }
        if (!TextUtils.isEmpty(c1381a.f22434d)) {
            if (NewUrlSchemaHelper.SCHEME.equals(c1381a.f22434d)) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
            setOnClickListener(new c(this, c1381a, tbPageContext, i2));
        }
        if (!TextUtils.isEmpty(c1381a.f22433c)) {
            this.f44951h.setTag(c1381a.f22433c);
            this.f44951h.startLoad(c1381a.f22433c, 10, false);
        }
        ViewGroup.LayoutParams layoutParams = this.f44950g.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = 0;
            this.f44950g.setLayoutParams(marginLayoutParams);
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
        this.f44948e = context;
        e();
    }
}
