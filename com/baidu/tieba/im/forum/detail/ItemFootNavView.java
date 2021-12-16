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
import c.a.d.f.p.l;
import c.a.r0.s.t.a;
import c.a.s0.v3.h0;
import c.a.s0.v3.x;
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
/* loaded from: classes12.dex */
public class ItemFootNavView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ForumDetailActivity f46491e;

    /* renamed from: f  reason: collision with root package name */
    public Context f46492f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f46493g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46494h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f46495i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f46496j;

    /* renamed from: k  reason: collision with root package name */
    public View f46497k;
    public RecommendForumInfo l;
    public boolean m;
    public c.a.r0.s.t.a n;
    public LikeModel o;
    public AntiHelper.k p;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemFootNavView;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f46498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f46499f;

        public b(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemFootNavView, forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46499f = itemFootNavView;
            this.f46498e = forumDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f46499f.m(this.f46498e);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f46500e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46501f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f46502g;

        public c(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemFootNavView, forumDetailActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46502g = itemFootNavView;
            this.f46500e = forumDetailActivity;
            this.f46501f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f46502g.f46492f, "detail_enter_forum", "click", 1, new Object[0]);
                if (this.f46502g.m) {
                    this.f46500e.finish();
                    return;
                }
                this.f46500e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f46500e.getPageContext().getPageActivity()).createNormalCfg(this.f46501f, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                if (this.f46500e == null || !ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(this.f46500e.getFromType())) {
                    return;
                }
                TiebaStatic.eventStat(this.f46502g.f46491e.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f46503b;

        public d(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemFootNavView, forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46503b = itemFootNavView;
            this.a = forumDetailActivity;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f46503b.o.getErrorCode() == 22) {
                    this.f46503b.l(true);
                    this.f46503b.updateCareBtn(true);
                } else if (!AntiHelper.m(this.f46503b.o.getErrorCode(), this.f46503b.o.getErrorString())) {
                    if (this.f46503b.o.getErrorCode() != 0) {
                        this.a.showToast(this.f46503b.o.getErrorString());
                        return;
                    }
                    x xVar = (x) obj;
                    if (xVar != null) {
                        if (xVar.d() == 3250013) {
                            BdToast.h(TbadkCoreApplication.getInst().getContext(), xVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                            return;
                        } else if (!AntiHelper.l(xVar.d())) {
                            this.f46503b.l(true);
                            TbadkApplication.getInst().addLikeForum(this.f46503b.l.forum_name);
                            this.f46503b.updateCareBtn(true);
                            xVar.v(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                            return;
                        } else {
                            AntiHelper.t(this.a.getPageContext().getPageActivity(), this.f46503b.o.J(), this.f46503b.p);
                            return;
                        }
                    }
                    ForumDetailActivity forumDetailActivity = this.a;
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.t(this.a.getPageContext().getPageActivity(), this.f46503b.o.J(), this.f46503b.p) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseActivity f46504e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f46505f;

        /* loaded from: classes12.dex */
        public class a implements h0.a {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // c.a.s0.v3.h0.a
            public void a(String str, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
                    if (j2 == 3250013) {
                        if (l.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                        }
                        BdToast.h(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                        return;
                    }
                    BaseActivity baseActivity = this.a.f46504e;
                    baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                }
            }

            @Override // c.a.s0.v3.h0.a
            public void b(String str, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                    this.a.f46505f.l(false);
                    this.a.f46505f.updateCareBtn(false);
                    if (this.a.f46505f.l == null || this.a.f46505f.l.forum_id.longValue() == 0) {
                        return;
                    }
                    x xVar = new x();
                    xVar.s(j2 + "");
                    xVar.v(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                    MessageManager messageManager = MessageManager.getInstance();
                    messageManager.sendMessage(new CustomMessage(2003004, this.a.f46505f.l.forum_id + ""));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46505f = itemFootNavView;
            this.f46504e = baseActivity;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f46505f.n.dismiss();
                h0 h0Var = new h0();
                h0Var.a(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                h0Var.b(new a(this));
                h0Var.c(this.f46505f.l.forum_name, this.f46505f.l.forum_id.longValue());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f46506e;

        public f(ItemFootNavView itemFootNavView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemFootNavView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46506e = itemFootNavView;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f46506e.n.dismiss();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.p = new a(this);
        init(context);
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f46492f = context;
            LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
            setOrientation(1);
            setVisibility(8);
            this.f46493g = (ViewGroup) findViewById(R.id.fn_care_box);
            this.f46494h = (TextView) findViewById(R.id.fn_care_btn);
            this.f46495i = (ImageView) findViewById(R.id.icon_brief_care);
            this.f46496j = (ViewGroup) findViewById(R.id.fn_enter_box);
            this.f46497k = findViewById(R.id.foot_line);
        }
    }

    public final void j(ForumDetailActivity forumDetailActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumDetailActivity, z) == null) {
            if (this.o == null) {
                this.o = new LikeModel(forumDetailActivity.getPageContext());
            }
            this.o.setFrom("detail_follow");
            this.o.setLoadDataCallBack(new d(this, forumDetailActivity));
            LikeModel likeModel = this.o;
            RecommendForumInfo recommendForumInfo = this.l;
            likeModel.L(recommendForumInfo.forum_name, String.valueOf(recommendForumInfo.forum_id));
        }
    }

    public final void k(BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, baseActivity, z) == null) {
            if (this.n == null) {
                c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(baseActivity.getPageContext().getPageActivity());
                this.n = aVar;
                aVar.setMessageId(R.string.forum_info_unlike_msg);
                this.n.setPositiveButton(R.string.alert_yes_button, new e(this, baseActivity));
                this.n.setNegativeButton(R.string.cancel, new f(this));
                this.n.setCanceledOnTouchOutside(true);
            }
            this.n.create(baseActivity.getPageContext()).show();
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            View inflate = LayoutInflater.from(this.f46492f).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0111);
            if (z) {
                imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_tips_attention_ok));
                textView.setText(R.string.attention);
            } else {
                imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_tips_attention_cancel));
                textView.setText(R.string.unfollow_title);
            }
            Toast toast = new Toast(this.f46492f);
            toast.setView(inflate);
            toast.setGravity(17, 0, 0);
            toast.setDuration(1000);
            toast.show();
            if (z) {
                this.f46491e.saveAcceptNotify(true);
            } else {
                this.f46491e.saveAcceptNotify(false);
            }
            this.f46491e.setSwitch(z);
            this.f46491e.setMsgManageVisibility(z);
        }
    }

    public final void m(ForumDetailActivity forumDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumDetailActivity) == null) {
            if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
                int intValue = ((Integer) this.f46493g.getTag()).intValue();
                if (intValue == 0) {
                    k(forumDetailActivity, this.m);
                } else if (intValue == 1) {
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.getFromType())) {
                        TiebaStatic.eventStat(this.f46491e.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                    }
                    j(forumDetailActivity, this.m);
                }
                TiebaStatic.eventStat(this.f46492f, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
            }
        }
    }

    public void onChangeSkinType(ForumDetailActivity forumDetailActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, forumDetailActivity, i2) == null) {
            forumDetailActivity.getLayoutMode().k(i2 == 1);
            forumDetailActivity.getLayoutMode().j(this);
        }
    }

    public void onResume(ForumDetailActivity forumDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, forumDetailActivity) == null) {
        }
    }

    public void setData(RecommendForumInfo recommendForumInfo, ForumDetailActivity forumDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, recommendForumInfo, forumDetailActivity) == null) {
            this.f46491e = forumDetailActivity;
            if (recommendForumInfo == null) {
                return;
            }
            this.m = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.l = recommendForumInfo;
            String str = recommendForumInfo.forum_name;
            updateCareBtn(recommendForumInfo.is_like.intValue() == 1);
            this.f46493g.setOnClickListener(new b(this, forumDetailActivity));
            this.f46496j.setOnClickListener(new c(this, forumDetailActivity, str));
            setVisibility(0);
        }
    }

    public void showLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.f46497k.setVisibility(0);
            } else {
                this.f46497k.setVisibility(8);
            }
        }
    }

    public void updateCareBtn(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                SkinManager.setImageResource(this.f46495i, R.drawable.icon_pop_pass);
                i2 = R.string.relate_forum_is_followed;
                this.f46493g.setTag(0);
            } else {
                SkinManager.setImageResource(this.f46495i, R.drawable.icon_brief_attention);
                i2 = R.string.attention;
                this.f46493g.setTag(1);
            }
            this.f46494h.setText(this.f46492f.getResources().getString(i2));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = false;
        this.p = new a(this);
        init(context);
    }
}
