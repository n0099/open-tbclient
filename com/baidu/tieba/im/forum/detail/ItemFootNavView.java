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
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c9;
import com.repackage.dr4;
import com.repackage.oh8;
import com.repackage.oi;
import com.repackage.yh8;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
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
    public dr4 j;
    public LikeModel k;
    public AntiHelper.k l;

    /* loaded from: classes3.dex */
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
        public void onNavigationButtonClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                if (this.a == null || !ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(this.a.F1())) {
                    return;
                }
                TiebaStatic.eventStat(this.c.a.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends c9 {
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

        @Override // com.repackage.c9
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
                    oh8 oh8Var = (oh8) obj;
                    if (oh8Var != null) {
                        if (oh8Var.d() == 3250013) {
                            BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), oh8Var.e());
                            b.f(BdToast.ToastIcon.FAILURE);
                            b.c(3000);
                            b.h();
                            return;
                        } else if (!AntiHelper.l(oh8Var.d())) {
                            this.b.p(true);
                            TbadkApplication.getInst().addLikeForum(this.b.h.forum_name);
                            this.b.r(true);
                            oh8Var.y(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, oh8Var));
                            return;
                        } else {
                            AntiHelper.t(this.a.getPageContext().getPageActivity(), this.b.k.O(), this.b.l);
                            return;
                        }
                    }
                    ForumDetailActivity forumDetailActivity = this.a;
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c17));
                } else if (AntiHelper.t(this.a.getPageContext().getPageActivity(), this.b.k.O(), this.b.l) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity a;
        public final /* synthetic */ ItemFootNavView b;

        /* loaded from: classes3.dex */
        public class a implements yh8.a {
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

            @Override // com.repackage.yh8.a
            public void a(String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                    if (j == 3250013) {
                        if (oi.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f027f);
                        }
                        BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), str);
                        b.f(BdToast.ToastIcon.FAILURE);
                        b.c(3000);
                        b.h();
                        return;
                    }
                    BaseActivity baseActivity = this.a.a;
                    baseActivity.showToast(baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f147b));
                }
            }

            @Override // com.repackage.yh8.a
            public void b(String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                    this.a.b.p(false);
                    this.a.b.r(false);
                    if (this.a.b.h == null || this.a.b.h.forum_id.longValue() == 0) {
                        return;
                    }
                    oh8 oh8Var = new oh8();
                    oh8Var.v(j + "");
                    oh8Var.y(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, oh8Var));
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.b.j.dismiss();
                yh8 yh8Var = new yh8();
                yh8Var.a(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                yh8Var.b(new a(this));
                yh8Var.c(this.b.h.forum_name, this.b.h.forum_id.longValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
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
            likeModel.R(recommendForumInfo.forum_name, String.valueOf(recommendForumInfo.forum_id));
        }
    }

    public final void k(BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseActivity, z) == null) {
            if (this.j == null) {
                dr4 dr4Var = new dr4(baseActivity.getPageContext().getPageActivity());
                this.j = dr4Var;
                dr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0673);
                this.j.setPositiveButton(R.string.obfuscated_res_0x7f0f0262, new e(this, baseActivity));
                this.j.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new f(this));
                this.j.setCanceledOnTouchOutside(true);
            }
            this.j.create(baseActivity.getPageContext()).show();
        }
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.b = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02a0, (ViewGroup) this, true);
            setOrientation(1);
            setVisibility(8);
            this.c = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0909be);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0909bf);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f090dc1);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0909c0);
            this.g = findViewById(R.id.obfuscated_res_0x7f0909e2);
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
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d029f, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0902c0);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902c8);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0111);
            if (z) {
                imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_tips_attention_ok));
                textView.setText(R.string.obfuscated_res_0x7f0f02a7);
            } else {
                imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_tips_attention_cancel));
                textView.setText(R.string.obfuscated_res_0x7f0f1460);
            }
            Toast toast = new Toast(this.b);
            toast.setView(inflate);
            toast.setGravity(17, 0, 0);
            toast.setDuration(1000);
            toast.show();
            if (z) {
                this.a.I1(true);
            } else {
                this.a.I1(false);
            }
            this.a.K1(z);
            this.a.J1(z);
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
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.F1())) {
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
                i = R.string.obfuscated_res_0x7f0f0f87;
                this.c.setTag(0);
            } else {
                SkinManager.setImageResource(this.e, R.drawable.icon_brief_attention);
                i = R.string.obfuscated_res_0x7f0f02a7;
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
