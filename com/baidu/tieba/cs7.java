package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.a55;
import com.baidu.tieba.ky9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public class cs7 extends BaseAdapter implements mo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<vn> a;
    public Context b;
    public TbPageContext c;
    public String d;
    public String e;
    public UserData f;
    public fo g;
    public int h;
    public String i;
    public HashSet<String> j;
    public boolean k;
    public ko7 l;
    public final View.OnClickListener m;
    public View.OnClickListener n;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return 2;
        }
        return invokeI.intValue;
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
        }
    }

    public void t(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, forumData) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs7 a;

        public a(cs7 cs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cs7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((this.a.b == null || ViewHelper.checkUpIsLogin(this.a.b)) && view2 != null) {
                    if ((view2.getTag() instanceof qw9) || (view2.getTag() instanceof e)) {
                        qw9 qw9Var = null;
                        if (view2.getTag() instanceof qw9) {
                            qw9Var = (qw9) view2.getTag();
                        } else if ((view2.getTag() instanceof e) && (textView = (eVar = (e) view2.getTag()).c) != null && (textView.getTag() instanceof qw9)) {
                            qw9Var = (qw9) eVar.c.getTag();
                        }
                        if (qw9Var != null && qw9Var.h() == 2) {
                            if (!StringUtils.isNull(qw9Var.f())) {
                                String f = qw9Var.f();
                                if ((f.contains("nohead:url") || f.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                    vi.P(this.a.b, R.string.book_plugin_not_install_tip);
                                    return;
                                }
                                UrlManager.getInstance().dealOneLink(this.a.c, new String[]{f});
                                ky9.b b = ky9.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", qw9Var.b(), this.a.d, this.a.e, null);
                                b.d(TiebaStatic.Params.OBJ_URL, qw9Var.f());
                                b.e();
                            }
                        } else if (qw9Var != null && qw9Var.h() == 3) {
                            new StatisticItem("c13442").param("forum_id", this.a.d).eventStat();
                            if (this.a.c != null && !TextUtils.isEmpty(this.a.d)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.c.getPageActivity()).createNormalConfig(tg.g(this.a.d, 0L), 1)));
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs7 a;

        public b(cs7 cs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cs7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setPressed(false);
                if (this.a.g == null || !(view2.getTag() instanceof e) || (eVar = (e) view2.getTag()) == null) {
                    return;
                }
                vn vnVar = (vn) ListUtils.getItem(this.a.a, eVar.a);
                if (vnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) vnVar;
                    fo foVar = this.a.g;
                    BdUniqueId gen = BdUniqueId.gen();
                    if (this.a.k) {
                        i = eVar.a + 1;
                    } else {
                        i = eVar.a;
                    }
                    foVar.b(view2, threadData, gen, null, i, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", threadData.getFid()).param("tid", threadData.getTid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", eVar.a + 1));
                } else if (vnVar instanceof xw9) {
                    this.a.g.b(view2, (xw9) vnVar, BdUniqueId.gen(), null, eVar.a, 0L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ cs7 d;

        public c(cs7 cs7Var, f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs7Var, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cs7Var;
            this.a = fVar;
            this.b = str;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c.getLayout().getEllipsisCount(this.a.c.getLineCount() - 1) <= 0) {
                return;
            }
            this.d.x(this.b, this.c);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a55 a;

        public d(cs7 cs7Var, a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs7Var, a55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a55Var;
        }

        @Override // com.baidu.tieba.a55.e
        public void onClick(a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a55Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;
        public TextView d;

        public e(cs7 cs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView e;
        public View f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(cs7 cs7Var) {
            super(cs7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((cs7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView e;
        public TextView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(cs7 cs7Var) {
            super(cs7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((cs7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public cs7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.e = "";
        this.h = SkinManager.getColor(R.color.CAM_X0302);
        this.i = "";
        this.j = new HashSet<>();
        this.l = new ko7();
        this.m = new a(this);
        this.n = new b(this);
        this.b = context;
        this.c = p();
    }

    public final String o(qw9 qw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, qw9Var)) == null) {
            if (!TextUtils.isEmpty(qw9Var.e()) && qw9Var.e().trim().length() != 0) {
                return qw9Var.e();
            }
            if (qw9Var.a() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return (String) invokeL.objValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return ListUtils.getItem(this.a, i);
        }
        return invokeI.objValue;
    }

    public final void h(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, eVar) != null) || eVar == null) {
            return;
        }
        SkinManager.setViewTextColor(eVar.c, (int) R.color.CAM_X0105);
    }

    public void r(List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.i = str;
        }
    }

    public void v(fo foVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, foVar) == null) {
            this.g = foVar;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.h = i;
        }
    }

    public void s(String str, String str2, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, userData) == null) {
            this.d = str;
            this.e = str2;
            this.f = userData;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mo7
    public ko7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return (ko7) invokeV.objValue;
    }

    public List<vn> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public TbPageContext p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Context context = this.b;
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            if (getItemViewType(i) == 1) {
                if (view2 != null && (view2.getTag() instanceof g)) {
                    gVar = (g) view2.getTag();
                } else {
                    gVar = new g(this);
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0361, (ViewGroup) null, false);
                    gVar.b = view2;
                    gVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ca5);
                    gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ca6);
                    gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09253e);
                    gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09253c);
                    view2.setTag(gVar);
                }
                m(gVar, (vn) ListUtils.getItem(this.a, i));
            } else if (getItemViewType(i) == 2) {
                if (view2 != null && (view2.getTag() instanceof f)) {
                    fVar = (f) view2.getTag();
                } else {
                    fVar = new f(this);
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0360, (ViewGroup) null, false);
                    fVar.b = view2;
                    fVar.f = view2.findViewById(R.id.obfuscated_res_0x7f09253f);
                    fVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09253e);
                    fVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09253d);
                    fVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09253c);
                    view2.setTag(fVar);
                }
                vn vnVar = (vn) ListUtils.getItem(this.a, i);
                if (vnVar instanceof ThreadData) {
                    j(fVar, (ThreadData) vnVar, i);
                    fVar.a = i;
                } else if (vnVar instanceof qw9) {
                    k(fVar, (qw9) vnVar);
                } else if (vnVar instanceof ww9) {
                    y((ww9) vnVar, fVar, i);
                } else if (vnVar instanceof xw9) {
                    fVar.a = i;
                    l(fVar, (xw9) vnVar, i);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void l(f fVar, xw9 xw9Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048585, this, fVar, xw9Var, i) == null) && fVar != null && xw9Var != null && xw9Var.a() != null && this.f != null) {
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
            do7.b(fVar.d, this.h);
            if (this.f.getIs_manager() == 1) {
                if (xw9Var.a().audit_status.intValue() == 0 && xw9Var.a().has_forum_rule.intValue() == 0) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
                } else if (xw9Var.a().audit_status.intValue() == 0) {
                    fVar.c.setText(xw9Var.a().title);
                } else if (xw9Var.a().audit_status.intValue() == 1) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
                } else if (xw9Var.a().audit_status.intValue() == 2) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
                }
            } else {
                fVar.c.setText(xw9Var.a().title);
            }
            fVar.b.setOnClickListener(this.n);
            h(fVar);
        }
    }

    public final void j(f fVar, ThreadData threadData, int i) {
        CharSequence abstractText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048583, this, fVar, threadData, i) == null) && fVar != null && threadData != null) {
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1679));
            do7.b(fVar.d, this.h);
            threadData.parserTitleFrsForTop();
            SpannableStringBuilder span_str = threadData.getSpan_str();
            if (ListUtils.isNotEmpty(threadData.getItemStar())) {
                abstractText = threadData.getAbstract();
            } else {
                abstractText = threadData.getAbstractText();
            }
            if ((span_str == null || ui.isEmptyStringAfterTrim(span_str.toString())) && abstractText != null) {
                span_str = new SpannableStringBuilder(abstractText);
                TiePlusEventController.r(threadData.getTiePlusLinkOriginData());
            }
            fVar.c.setOnTouchListener(new gba(span_str));
            fVar.c.setText(span_str);
            fVar.b.setOnClickListener(this.n);
            h(fVar);
        }
    }

    public final void k(f fVar, qw9 qw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, qw9Var) == null) {
            String o = o(qw9Var);
            fVar.c.setText(qw9Var.d());
            fVar.d.setText(o);
            do7.b(fVar.d, this.h);
            if (qw9Var.c() != 0) {
                fVar.e.setVisibility(0);
                if (qw9Var.c() == -1) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0e39));
                } else if (qw9Var.c() > 999) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f118a));
                } else {
                    TextView textView = fVar.e;
                    textView.setText(this.b.getString(R.string.obfuscated_res_0x7f0f1189) + qw9Var.c());
                }
                if (!StringUtils.isNull(qw9Var.d())) {
                    fVar.c.setText(qw9Var.d());
                }
            } else {
                fVar.e.setVisibility(8);
            }
            h(fVar);
            fVar.c.setTag(qw9Var);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                fVar.b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.j;
            if (hashSet != null && hashSet.add(qw9Var.b())) {
                ky9.b b2 = ky9.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", qw9Var.b(), this.d, this.e, null);
                b2.d(TiebaStatic.Params.OBJ_URL, qw9Var.f());
                b2.e();
            }
        }
    }

    public final void m(g gVar, vn vnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, gVar, vnVar) == null) && gVar != null && vnVar != null) {
            if (vnVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) vnVar;
                threadData.parserTitleFrsForTop();
                SpannableStringBuilder span_str = threadData.getSpan_str();
                if ((span_str == null || ui.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
                    span_str = new SpannableStringBuilder(threadData.getAbstractText());
                    TiePlusEventController.r(threadData.getTiePlusLinkOriginData());
                }
                gVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1679));
                gVar.c.setOnTouchListener(new gba(span_str));
                gVar.c.setText(span_str);
                if (StringUtils.isNull(this.i)) {
                    gVar.e.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.d.getLayoutParams();
                    layoutParams.setMargins((int) this.b.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    gVar.e.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.d.getLayoutParams();
                    layoutParams2.setMargins((int) this.b.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    gVar.e.N(this.i, 10, false);
                }
                gVar.d.setTextColor(this.h);
                gVar.b.setOnClickListener(this.n);
                h(gVar);
            } else if (vnVar instanceof qw9) {
                qw9 qw9Var = (qw9) vnVar;
                String o = o(qw9Var);
                if (StringUtils.isNull(this.i)) {
                    gVar.d.setText(o);
                    gVar.d.setVisibility(0);
                    gVar.c.setText(qw9Var.d());
                    gVar.e.setVisibility(8);
                } else {
                    gVar.d.setVisibility(8);
                    gVar.e.setVisibility(0);
                    TextView textView = gVar.c;
                    textView.setText(o + "：" + qw9Var.d());
                    gVar.e.N(this.i, 10, false);
                }
                if (qw9Var.c() != 0) {
                    gVar.f.setVisibility(0);
                    if (qw9Var.c() == -1) {
                        gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0e39));
                    } else if (qw9Var.c() > 999) {
                        gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f118a));
                    } else {
                        TextView textView2 = gVar.f;
                        textView2.setText(this.b.getString(R.string.obfuscated_res_0x7f0f1189) + qw9Var.c());
                    }
                    if (!StringUtils.isNull(qw9Var.d())) {
                        gVar.c.setText(qw9Var.d());
                    }
                } else {
                    gVar.f.setVisibility(8);
                }
                gVar.d.setTextColor(this.h);
                h(gVar);
                gVar.c.setTag(qw9Var);
                View.OnClickListener onClickListener = this.m;
                if (onClickListener != null) {
                    gVar.b.setOnClickListener(onClickListener);
                }
                HashSet<String> hashSet = this.j;
                if (hashSet != null && hashSet.add(qw9Var.b())) {
                    ky9.b b2 = ky9.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", qw9Var.b(), this.d, this.e, null);
                    b2.d(TiebaStatic.Params.OBJ_URL, qw9Var.f());
                    b2.e();
                }
            }
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) && !ui.isEmpty(str) && !ui.isEmpty(str2)) {
            a55 a55Var = new a55((BaseFragmentActivity) this.b);
            a55Var.setTitle(str2);
            a55Var.setTitleShowCenter(true);
            a55Var.setMessage(str);
            a55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0857, new d(this, a55Var));
            a55Var.create(p()).show();
        }
    }

    public final boolean y(ww9 ww9Var, f fVar, int i) {
        InterceptResult invokeLLI;
        boolean z;
        String riskTipNotice;
        String riskTipPopTitle;
        String riskTipPop;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, ww9Var, fVar, i)) == null) {
            if (i != 0 || ww9Var == null || ww9Var.a() == null) {
                return false;
            }
            ForumData a2 = ww9Var.a();
            if (ww9Var.b() && !ListUtils.isEmpty(a2.getTipInfos())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                riskTipNotice = a2.getTipInfos().get(0).tip_notice;
            } else {
                riskTipNotice = a2.getRiskTipNotice();
            }
            if (z) {
                riskTipPopTitle = a2.getTipInfos().get(0).tip_pop_title;
            } else {
                riskTipPopTitle = a2.getRiskTipPopTitle();
            }
            if (z) {
                riskTipPop = a2.getTipInfos().get(0).tip_pop;
            } else {
                riskTipPop = a2.getRiskTipPop();
            }
            if (StringUtils.isNull(riskTipNotice)) {
                return false;
            }
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
            do7.b(fVar.d, this.h);
            fVar.c.setText(riskTipNotice);
            fVar.c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
