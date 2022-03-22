package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.o0.r.t.a;
import c.a.p0.a4.i0;
import c.a.p0.a4.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class ItemFootNavView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumDetailActivity a;

    /* renamed from: b  reason: collision with root package name */
    public Context f33806b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f33807c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33808d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f33809e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f33810f;

    /* renamed from: g  reason: collision with root package name */
    public View f33811g;

    /* renamed from: h  reason: collision with root package name */
    public RecommendForumInfo f33812h;
    public boolean i;
    public c.a.o0.r.t.a j;
    public LikeModel k;
    public AntiHelper.k l;

    /* loaded from: classes5.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemFootNavView a;

        public a(ItemFootNavView itemFootNavView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemFootNavView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemFootNavView;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f33813b;

        public b(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemFootNavView, forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33813b = itemFootNavView;
            this.a = forumDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f33813b.q(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f33814b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f33815c;

        public c(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemFootNavView, forumDetailActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33815c = itemFootNavView;
            this.a = forumDetailActivity;
            this.f33814b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f33815c.f33806b, "detail_enter_forum", "click", 1, new Object[0]);
                if (this.f33815c.i) {
                    this.a.finish();
                    return;
                }
                this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(this.f33814b, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                if (this.a == null || !ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(this.a.getFromType())) {
                    return;
                }
                TiebaStatic.eventStat(this.f33815c.a.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f33816b;

        public d(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemFootNavView, forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33816b = itemFootNavView;
            this.a = forumDetailActivity;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f33816b.k.getErrorCode() == 22) {
                    this.f33816b.p(true);
                    this.f33816b.r(true);
                } else if (!AntiHelper.m(this.f33816b.k.getErrorCode(), this.f33816b.k.getErrorString())) {
                    if (this.f33816b.k.getErrorCode() != 0) {
                        this.a.showToast(this.f33816b.k.getErrorString());
                        return;
                    }
                    y yVar = (y) obj;
                    if (yVar != null) {
                        if (yVar.d() == 3250013) {
                            BdToast.h(TbadkCoreApplication.getInst().getContext(), yVar.e(), R.drawable.obfuscated_res_0x7f08099f, 3000, true).q();
                            return;
                        } else if (!AntiHelper.l(yVar.d())) {
                            this.f33816b.p(true);
                            TbadkApplication.getInst().addLikeForum(this.f33816b.f33812h.forum_name);
                            this.f33816b.r(true);
                            yVar.y(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, yVar));
                            return;
                        } else {
                            AntiHelper.t(this.a.getPageContext().getPageActivity(), this.f33816b.k.M(), this.f33816b.l);
                            return;
                        }
                    }
                    ForumDetailActivity forumDetailActivity = this.a;
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c15));
                } else if (AntiHelper.t(this.a.getPageContext().getPageActivity(), this.f33816b.k.M(), this.f33816b.l) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f33817b;

        /* loaded from: classes5.dex */
        public class a implements i0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // c.a.p0.a4.i0.a
            public void a(String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                    if (j == 3250013) {
                        if (m.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0277);
                        }
                        BdToast.h(TbadkCoreApplication.getInst().getContext(), str, R.drawable.obfuscated_res_0x7f08099f, 3000, true).q();
                        return;
                    }
                    BaseActivity baseActivity = this.a.a;
                    baseActivity.showToast(baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f147f));
                }
            }

            @Override // c.a.p0.a4.i0.a
            public void b(String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                    this.a.f33817b.p(false);
                    this.a.f33817b.r(false);
                    if (this.a.f33817b.f33812h == null || this.a.f33817b.f33812h.forum_id.longValue() == 0) {
                        return;
                    }
                    y yVar = new y();
                    yVar.v(j + "");
                    yVar.y(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, yVar));
                    MessageManager messageManager = MessageManager.getInstance();
                    messageManager.sendMessage(new CustomMessage(2003004, this.a.f33817b.f33812h.forum_id + ""));
                }
            }
        }

        public e(ItemFootNavView itemFootNavView, BaseActivity baseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemFootNavView, baseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33817b = itemFootNavView;
            this.a = baseActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f33817b.j.dismiss();
                i0 i0Var = new i0();
                i0Var.a(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                i0Var.b(new a(this));
                i0Var.c(this.f33817b.f33812h.forum_name, this.f33817b.f33812h.forum_id.longValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemFootNavView a;

        public f(ItemFootNavView itemFootNavView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemFootNavView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemFootNavView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.j.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemFootNavView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.l = new a(this);
        l(context);
    }

    public final void j(ForumDetailActivity forumDetailActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, forumDetailActivity, z) == null) {
            if (this.k == null) {
                this.k = new LikeModel(forumDetailActivity.getPageContext());
            }
            this.k.setFrom("detail_follow");
            this.k.setLoadDataCallBack(new d(this, forumDetailActivity));
            LikeModel likeModel = this.k;
            RecommendForumInfo recommendForumInfo = this.f33812h;
            likeModel.P(recommendForumInfo.forum_name, String.valueOf(recommendForumInfo.forum_id));
        }
    }

    public final void k(BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseActivity, z) == null) {
            if (this.j == null) {
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(baseActivity.getPageContext().getPageActivity());
                this.j = aVar;
                aVar.setMessageId(R.string.obfuscated_res_0x7f0f0663);
                this.j.setPositiveButton(R.string.obfuscated_res_0x7f0f025c, new e(this, baseActivity));
                this.j.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new f(this));
                this.j.setCanceledOnTouchOutside(true);
            }
            this.j.create(baseActivity.getPageContext()).show();
        }
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f33806b = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02ad, (ViewGroup) this, true);
            setOrientation(1);
            setVisibility(8);
            this.f33807c = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0909e4);
            this.f33808d = (TextView) findViewById(R.id.obfuscated_res_0x7f0909e5);
            this.f33809e = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e16);
            this.f33810f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0909e6);
            this.f33811g = findViewById(R.id.obfuscated_res_0x7f090a07);
        }
    }

    public void m(ForumDetailActivity forumDetailActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, forumDetailActivity, i) == null) {
            forumDetailActivity.getLayoutMode().k(i == 1);
            forumDetailActivity.getLayoutMode().j(this);
        }
    }

    public void n(ForumDetailActivity forumDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumDetailActivity) == null) {
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.f33811g.setVisibility(0);
            } else {
                this.f33811g.setVisibility(8);
            }
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            View inflate = LayoutInflater.from(this.f33806b).inflate(R.layout.obfuscated_res_0x7f0d02ac, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0902c0);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902c8);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0111);
            if (z) {
                imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_tips_attention_ok));
                textView.setText(R.string.obfuscated_res_0x7f0f029b);
            } else {
                imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_tips_attention_cancel));
                textView.setText(R.string.obfuscated_res_0x7f0f1467);
            }
            Toast toast = new Toast(this.f33806b);
            toast.setView(inflate);
            toast.setGravity(17, 0, 0);
            toast.setDuration(1000);
            toast.show();
            if (z) {
                this.a.saveAcceptNotify(true);
            } else {
                this.a.saveAcceptNotify(false);
            }
            this.a.setSwitch(z);
            this.a.setMsgManageVisibility(z);
        }
    }

    public final void q(ForumDetailActivity forumDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, forumDetailActivity) == null) {
            if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
                int intValue = ((Integer) this.f33807c.getTag()).intValue();
                if (intValue == 0) {
                    k(forumDetailActivity, this.i);
                } else if (intValue == 1) {
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.getFromType())) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                    }
                    j(forumDetailActivity, this.i);
                }
                TiebaStatic.eventStat(this.f33806b, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
            }
        }
    }

    public void r(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                SkinManager.setImageResource(this.f33809e, R.drawable.icon_pop_pass);
                i = R.string.obfuscated_res_0x7f0f0f68;
                this.f33807c.setTag(0);
            } else {
                SkinManager.setImageResource(this.f33809e, R.drawable.icon_brief_attention);
                i = R.string.obfuscated_res_0x7f0f029b;
                this.f33807c.setTag(1);
            }
            this.f33808d.setText(this.f33806b.getResources().getString(i));
        }
    }

    public void setData(RecommendForumInfo recommendForumInfo, ForumDetailActivity forumDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, recommendForumInfo, forumDetailActivity) == null) {
            this.a = forumDetailActivity;
            if (recommendForumInfo == null) {
                return;
            }
            this.i = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.f33812h = recommendForumInfo;
            String str = recommendForumInfo.forum_name;
            r(recommendForumInfo.is_like.intValue() == 1);
            this.f33807c.setOnClickListener(new b(this, forumDetailActivity));
            this.f33810f.setOnClickListener(new c(this, forumDetailActivity, str));
            setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = false;
        this.l = new a(this);
        l(context);
    }
}
