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
import c.a.e.e.p.k;
import c.a.q0.s.s.a;
import c.a.r0.j3.g0;
import c.a.r0.j3.x;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
/* loaded from: classes7.dex */
public class ItemFootNavView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ForumDetailActivity f53206e;

    /* renamed from: f  reason: collision with root package name */
    public Context f53207f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f53208g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53209h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f53210i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f53211j;
    public View k;
    public RecommendForumInfo l;
    public boolean m;
    public c.a.q0.s.s.a n;
    public LikeModel o;
    public AntiHelper.k p;

    /* loaded from: classes7.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f53212a;

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
            this.f53212a = itemFootNavView;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f53213e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f53214f;

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
            this.f53214f = itemFootNavView;
            this.f53213e = forumDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53214f.m(this.f53213e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f53215e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f53216f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f53217g;

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
            this.f53217g = itemFootNavView;
            this.f53215e = forumDetailActivity;
            this.f53216f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f53217g.f53207f, "detail_enter_forum", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                if (this.f53217g.m) {
                    this.f53215e.finish();
                    return;
                }
                this.f53215e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f53215e.getPageContext().getPageActivity()).createNormalCfg(this.f53216f, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                if (this.f53215e == null || !ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(this.f53215e.getFromType())) {
                    return;
                }
                TiebaStatic.eventStat(this.f53217g.f53206e.getPageContext().getPageActivity(), "squae_introduce_entry", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f53218a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f53219b;

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
            this.f53219b = itemFootNavView;
            this.f53218a = forumDetailActivity;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f53219b.o.getErrorCode() == 22) {
                    this.f53219b.l(true);
                    this.f53219b.updateCareBtn(true);
                } else if (!AntiHelper.m(this.f53219b.o.getErrorCode(), this.f53219b.o.getErrorString())) {
                    if (this.f53219b.o.getErrorCode() != 0) {
                        this.f53218a.showToast(this.f53219b.o.getErrorString());
                        return;
                    }
                    x xVar = (x) obj;
                    if (xVar != null) {
                        if (xVar.d() == 3250013) {
                            BdToast.h(TbadkCoreApplication.getInst().getContext(), xVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                            return;
                        } else if (!AntiHelper.l(xVar.d())) {
                            this.f53219b.l(true);
                            TbadkApplication.getInst().addLikeForum(this.f53219b.l.forum_name);
                            this.f53219b.updateCareBtn(true);
                            xVar.v(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                            return;
                        } else {
                            AntiHelper.t(this.f53218a.getPageContext().getPageActivity(), this.f53219b.o.J(), this.f53219b.p);
                            return;
                        }
                    }
                    ForumDetailActivity forumDetailActivity = this.f53218a;
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.t(this.f53218a.getPageContext().getPageActivity(), this.f53219b.o.J(), this.f53219b.p) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseActivity f53220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f53221f;

        /* loaded from: classes7.dex */
        public class a implements g0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f53222a;

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
                this.f53222a = eVar;
            }

            @Override // c.a.r0.j3.g0.a
            public void a(String str, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
                    if (j2 == 3250013) {
                        if (k.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                        }
                        BdToast.h(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                        return;
                    }
                    BaseActivity baseActivity = this.f53222a.f53220e;
                    baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                }
            }

            @Override // c.a.r0.j3.g0.a
            public void b(String str, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                    this.f53222a.f53221f.l(false);
                    this.f53222a.f53221f.updateCareBtn(false);
                    if (this.f53222a.f53221f.l == null || this.f53222a.f53221f.l.forum_id.longValue() == 0) {
                        return;
                    }
                    x xVar = new x();
                    xVar.s(j2 + "");
                    xVar.v(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                    MessageManager messageManager = MessageManager.getInstance();
                    messageManager.sendMessage(new CustomMessage(2003004, this.f53222a.f53221f.l.forum_id + ""));
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
            this.f53221f = itemFootNavView;
            this.f53220e = baseActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f53221f.n.dismiss();
                g0 g0Var = new g0();
                g0Var.a(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                g0Var.b(new a(this));
                g0Var.c(this.f53221f.l.forum_name, this.f53221f.l.forum_id.longValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f53223e;

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
            this.f53223e = itemFootNavView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f53223e.n.dismiss();
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
            this.f53207f = context;
            LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
            setOrientation(1);
            setVisibility(8);
            this.f53208g = (ViewGroup) findViewById(R.id.fn_care_box);
            this.f53209h = (TextView) findViewById(R.id.fn_care_btn);
            this.f53210i = (ImageView) findViewById(R.id.icon_brief_care);
            this.f53211j = (ViewGroup) findViewById(R.id.fn_enter_box);
            this.k = findViewById(R.id.foot_line);
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
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(baseActivity.getPageContext().getPageActivity());
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
            View inflate = LayoutInflater.from(this.f53207f).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
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
            Toast toast = new Toast(this.f53207f);
            toast.setView(inflate);
            toast.setGravity(17, 0, 0);
            toast.setDuration(1000);
            toast.show();
            if (z) {
                this.f53206e.saveAcceptNotify(true);
            } else {
                this.f53206e.saveAcceptNotify(false);
            }
            this.f53206e.setSwitch(z);
            this.f53206e.setMsgManageVisibility(z);
        }
    }

    public final void m(ForumDetailActivity forumDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumDetailActivity) == null) {
            if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
                int intValue = ((Integer) this.f53208g.getTag()).intValue();
                if (intValue == 0) {
                    k(forumDetailActivity, this.m);
                } else if (intValue == 1) {
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.getFromType())) {
                        TiebaStatic.eventStat(this.f53206e.getPageContext().getPageActivity(), "squae_introduce_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    }
                    j(forumDetailActivity, this.m);
                }
                TiebaStatic.eventStat(this.f53207f, intValue == 1 ? "detail_care_add" : "detail_care_cancel", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
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
            this.f53206e = forumDetailActivity;
            if (recommendForumInfo == null) {
                return;
            }
            this.m = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.l = recommendForumInfo;
            String str = recommendForumInfo.forum_name;
            updateCareBtn(recommendForumInfo.is_like.intValue() == 1);
            this.f53208g.setOnClickListener(new b(this, forumDetailActivity));
            this.f53211j.setOnClickListener(new c(this, forumDetailActivity, str));
            setVisibility(0);
        }
    }

    public void showLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public void updateCareBtn(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                SkinManager.setImageResource(this.f53210i, R.drawable.icon_pop_pass);
                i2 = R.string.relate_forum_is_followed;
                this.f53208g.setTag(0);
            } else {
                SkinManager.setImageResource(this.f53210i, R.drawable.icon_brief_attention);
                i2 = R.string.attention;
                this.f53208g.setTag(1);
            }
            this.f53209h.setText(this.f53207f.getResources().getString(i2));
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
