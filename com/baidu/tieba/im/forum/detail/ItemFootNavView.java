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
import com.baidu.tieba.au4;
import com.baidu.tieba.dj;
import com.baidu.tieba.fm8;
import com.baidu.tieba.q9;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.vl8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class ItemFootNavView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumDetailActivity a;
    public Context b;
    public ViewGroup c;
    public TextView d;
    public ImageView e;
    public ViewGroup f;
    public View g;
    public RecommendForumInfo h;
    public boolean i;
    public au4 j;
    public LikeModel k;
    public AntiHelper.k l;

    /* loaded from: classes4.dex */
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
        public void onNavigationButtonClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, au4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;
        public final /* synthetic */ ItemFootNavView b;

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
            this.b = itemFootNavView;
            this.a = forumDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.q(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ItemFootNavView c;

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
            this.c = itemFootNavView;
            this.a = forumDetailActivity;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.eventStat(this.c.b, "detail_enter_forum", "click", 1, new Object[0]);
                if (this.c.i) {
                    this.a.finish();
                    return;
                }
                this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(this.b, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                if (this.a == null || !ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(this.a.E1())) {
                    return;
                }
                TiebaStatic.eventStat(this.c.a.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;
        public final /* synthetic */ ItemFootNavView b;

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
            this.b = itemFootNavView;
            this.a = forumDetailActivity;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.b.k.getErrorCode() == 22) {
                    this.b.p(true);
                    this.b.r(true);
                } else if (!AntiHelper.m(this.b.k.getErrorCode(), this.b.k.getErrorString())) {
                    if (this.b.k.getErrorCode() != 0) {
                        this.a.showToast(this.b.k.getErrorString());
                        return;
                    }
                    vl8 vl8Var = (vl8) obj;
                    if (vl8Var != null) {
                        if (vl8Var.d() == 3250013) {
                            BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), vl8Var.e());
                            b.f(BdToast.ToastIcon.FAILURE);
                            b.c(3000);
                            b.i();
                            return;
                        } else if (!AntiHelper.l(vl8Var.d())) {
                            this.b.p(true);
                            TbadkApplication.getInst().addLikeForum(this.b.h.forum_name);
                            this.b.r(true);
                            vl8Var.x(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, vl8Var));
                            return;
                        } else {
                            AntiHelper.t(this.a.getPageContext().getPageActivity(), this.b.k.N(), this.b.l);
                            return;
                        }
                    }
                    ForumDetailActivity forumDetailActivity = this.a;
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c59));
                } else if (AntiHelper.t(this.a.getPageContext().getPageActivity(), this.b.k.N(), this.b.l) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity a;
        public final /* synthetic */ ItemFootNavView b;

        /* loaded from: classes4.dex */
        public class a implements fm8.a {
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

            @Override // com.baidu.tieba.fm8.a
            public void a(String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                    if (j == 3250013) {
                        if (dj.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0288);
                        }
                        BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), str);
                        b.f(BdToast.ToastIcon.FAILURE);
                        b.c(3000);
                        b.i();
                        return;
                    }
                    BaseActivity baseActivity = this.a.a;
                    baseActivity.showToast(baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f14de));
                }
            }

            @Override // com.baidu.tieba.fm8.a
            public void b(String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                    this.a.b.p(false);
                    this.a.b.r(false);
                    if (this.a.b.h == null || this.a.b.h.forum_id.longValue() == 0) {
                        return;
                    }
                    vl8 vl8Var = new vl8();
                    vl8Var.u(j + "");
                    vl8Var.x(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, vl8Var));
                    MessageManager messageManager = MessageManager.getInstance();
                    messageManager.sendMessage(new CustomMessage(2003004, this.a.b.h.forum_id + ""));
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
            this.b = itemFootNavView;
            this.a = baseActivity;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                this.b.j.dismiss();
                fm8 fm8Var = new fm8();
                fm8Var.a(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                fm8Var.b(new a(this));
                fm8Var.c(this.b.h.forum_name, this.b.h.forum_id.longValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements au4.e {
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

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
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
            RecommendForumInfo recommendForumInfo = this.h;
            likeModel.Q(recommendForumInfo.forum_name, String.valueOf(recommendForumInfo.forum_id));
        }
    }

    public final void k(BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseActivity, z) == null) {
            if (this.j == null) {
                au4 au4Var = new au4(baseActivity.getPageContext().getPageActivity());
                this.j = au4Var;
                au4Var.setMessageId(R.string.obfuscated_res_0x7f0f0695);
                this.j.setPositiveButton(R.string.obfuscated_res_0x7f0f026a, new e(this, baseActivity));
                this.j.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new f(this));
                this.j.setCanceledOnTouchOutside(true);
            }
            this.j.create(baseActivity.getPageContext()).show();
        }
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.b = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02a8, (ViewGroup) this, true);
            setOrientation(1);
            setVisibility(8);
            this.c = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090a14);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090a15);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e27);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090a16);
            this.g = findViewById(R.id.obfuscated_res_0x7f090a38);
        }
    }

    public void m(ForumDetailActivity forumDetailActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, forumDetailActivity, i) == null) {
            forumDetailActivity.getLayoutMode().l(i == 1);
            forumDetailActivity.getLayoutMode().k(this);
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
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d02a7, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0902db);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902e3);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0111);
            if (z) {
                return;
            }
            imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_tips_attention_cancel));
            textView.setText(R.string.obfuscated_res_0x7f0f14c3);
            Toast toast = new Toast(this.b);
            toast.setView(inflate);
            toast.setGravity(17, 0, 0);
            toast.setDuration(1000);
            toast.show();
            if (z) {
                this.a.H1(true);
            } else {
                this.a.H1(false);
            }
            this.a.J1(z);
            this.a.I1(z);
        }
    }

    public final void q(ForumDetailActivity forumDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, forumDetailActivity) == null) {
            if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
                int intValue = ((Integer) this.c.getTag()).intValue();
                if (intValue == 0) {
                    k(forumDetailActivity, this.i);
                } else if (intValue == 1) {
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.E1())) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                    }
                    j(forumDetailActivity, this.i);
                }
                TiebaStatic.eventStat(this.b, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
            }
        }
    }

    public void r(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                SkinManager.setImageResource(this.e, R.drawable.icon_pop_pass);
                i = R.string.obfuscated_res_0x7f0f0fdc;
                this.c.setTag(0);
            } else {
                SkinManager.setImageResource(this.e, R.drawable.icon_brief_attention);
                i = R.string.obfuscated_res_0x7f0f02b0;
                this.c.setTag(1);
            }
            this.d.setText(this.b.getResources().getString(i));
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
            this.h = recommendForumInfo;
            String str = recommendForumInfo.forum_name;
            r(recommendForumInfo.is_like.intValue() == 1);
            this.c.setOnClickListener(new b(this, forumDetailActivity));
            this.f.setOnClickListener(new c(this, forumDetailActivity, str));
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
