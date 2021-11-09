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
import b.a.e.e.p.k;
import b.a.q0.s.s.a;
import b.a.r0.l3.h0;
import b.a.r0.l3.x;
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
/* loaded from: classes9.dex */
public class ItemFootNavView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ForumDetailActivity f50394e;

    /* renamed from: f  reason: collision with root package name */
    public Context f50395f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f50396g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50397h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f50398i;
    public ViewGroup j;
    public View k;
    public RecommendForumInfo l;
    public boolean m;
    public b.a.q0.s.s.a n;
    public LikeModel o;
    public AntiHelper.k p;

    /* loaded from: classes9.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f50399a;

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
            this.f50399a = itemFootNavView;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f50400e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f50401f;

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
            this.f50401f = itemFootNavView;
            this.f50400e = forumDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50401f.m(this.f50400e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f50402e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50403f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f50404g;

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
            this.f50404g = itemFootNavView;
            this.f50402e = forumDetailActivity;
            this.f50403f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f50404g.f50395f, "detail_enter_forum", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                if (this.f50404g.m) {
                    this.f50402e.finish();
                    return;
                }
                this.f50402e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f50402e.getPageContext().getPageActivity()).createNormalCfg(this.f50403f, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                if (this.f50402e == null || !ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(this.f50402e.getFromType())) {
                    return;
                }
                TiebaStatic.eventStat(this.f50404g.f50394e.getPageContext().getPageActivity(), "squae_introduce_entry", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f50405a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f50406b;

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
            this.f50406b = itemFootNavView;
            this.f50405a = forumDetailActivity;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f50406b.o.getErrorCode() == 22) {
                    this.f50406b.l(true);
                    this.f50406b.updateCareBtn(true);
                } else if (!AntiHelper.m(this.f50406b.o.getErrorCode(), this.f50406b.o.getErrorString())) {
                    if (this.f50406b.o.getErrorCode() != 0) {
                        this.f50405a.showToast(this.f50406b.o.getErrorString());
                        return;
                    }
                    x xVar = (x) obj;
                    if (xVar != null) {
                        if (xVar.d() == 3250013) {
                            BdToast.h(TbadkCoreApplication.getInst().getContext(), xVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                            return;
                        } else if (!AntiHelper.l(xVar.d())) {
                            this.f50406b.l(true);
                            TbadkApplication.getInst().addLikeForum(this.f50406b.l.forum_name);
                            this.f50406b.updateCareBtn(true);
                            xVar.v(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                            return;
                        } else {
                            AntiHelper.t(this.f50405a.getPageContext().getPageActivity(), this.f50406b.o.J(), this.f50406b.p);
                            return;
                        }
                    }
                    ForumDetailActivity forumDetailActivity = this.f50405a;
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.t(this.f50405a.getPageContext().getPageActivity(), this.f50406b.o.J(), this.f50406b.p) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseActivity f50407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f50408f;

        /* loaded from: classes9.dex */
        public class a implements h0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f50409a;

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
                this.f50409a = eVar;
            }

            @Override // b.a.r0.l3.h0.a
            public void a(String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                    if (j == 3250013) {
                        if (k.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                        }
                        BdToast.h(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                        return;
                    }
                    BaseActivity baseActivity = this.f50409a.f50407e;
                    baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                }
            }

            @Override // b.a.r0.l3.h0.a
            public void b(String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                    this.f50409a.f50408f.l(false);
                    this.f50409a.f50408f.updateCareBtn(false);
                    if (this.f50409a.f50408f.l == null || this.f50409a.f50408f.l.forum_id.longValue() == 0) {
                        return;
                    }
                    x xVar = new x();
                    xVar.s(j + "");
                    xVar.v(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                    MessageManager messageManager = MessageManager.getInstance();
                    messageManager.sendMessage(new CustomMessage(2003004, this.f50409a.f50408f.l.forum_id + ""));
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
            this.f50408f = itemFootNavView;
            this.f50407e = baseActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f50408f.n.dismiss();
                h0 h0Var = new h0();
                h0Var.a(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                h0Var.b(new a(this));
                h0Var.c(this.f50408f.l.forum_name, this.f50408f.l.forum_id.longValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemFootNavView f50410e;

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
            this.f50410e = itemFootNavView;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f50410e.n.dismiss();
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
            this.f50395f = context;
            LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
            setOrientation(1);
            setVisibility(8);
            this.f50396g = (ViewGroup) findViewById(R.id.fn_care_box);
            this.f50397h = (TextView) findViewById(R.id.fn_care_btn);
            this.f50398i = (ImageView) findViewById(R.id.icon_brief_care);
            this.j = (ViewGroup) findViewById(R.id.fn_enter_box);
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
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(baseActivity.getPageContext().getPageActivity());
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
            View inflate = LayoutInflater.from(this.f50395f).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
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
            Toast toast = new Toast(this.f50395f);
            toast.setView(inflate);
            toast.setGravity(17, 0, 0);
            toast.setDuration(1000);
            toast.show();
            if (z) {
                this.f50394e.saveAcceptNotify(true);
            } else {
                this.f50394e.saveAcceptNotify(false);
            }
            this.f50394e.setSwitch(z);
            this.f50394e.setMsgManageVisibility(z);
        }
    }

    public final void m(ForumDetailActivity forumDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumDetailActivity) == null) {
            if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
                int intValue = ((Integer) this.f50396g.getTag()).intValue();
                if (intValue == 0) {
                    k(forumDetailActivity, this.m);
                } else if (intValue == 1) {
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.getFromType())) {
                        TiebaStatic.eventStat(this.f50394e.getPageContext().getPageActivity(), "squae_introduce_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    }
                    j(forumDetailActivity, this.m);
                }
                TiebaStatic.eventStat(this.f50395f, intValue == 1 ? "detail_care_add" : "detail_care_cancel", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
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
            this.f50394e = forumDetailActivity;
            if (recommendForumInfo == null) {
                return;
            }
            this.m = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.l = recommendForumInfo;
            String str = recommendForumInfo.forum_name;
            updateCareBtn(recommendForumInfo.is_like.intValue() == 1);
            this.f50396g.setOnClickListener(new b(this, forumDetailActivity));
            this.j.setOnClickListener(new c(this, forumDetailActivity, str));
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
                SkinManager.setImageResource(this.f50398i, R.drawable.icon_pop_pass);
                i2 = R.string.relate_forum_is_followed;
                this.f50396g.setTag(0);
            } else {
                SkinManager.setImageResource(this.f50398i, R.drawable.icon_brief_attention);
                i2 = R.string.attention;
                this.f50396g.setTag(1);
            }
            this.f50397h.setText(this.f50395f.getResources().getString(i2));
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
