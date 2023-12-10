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
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.f05;
import com.baidu.tieba.rd;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w4;
import com.baidu.tieba.yva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecommendForumInfo;
/* loaded from: classes6.dex */
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
    public f05 j;
    public LikeModel k;
    public AntiHelper.k l;

    public void n(ForumDetailActivity forumDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumDetailActivity) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class e implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity a;
        public final /* synthetic */ ItemFootNavView b;

        /* loaded from: classes6.dex */
        public class a implements yva.a {
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

            @Override // com.baidu.tieba.yva.a
            public void a(String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                    if (j == 3250013) {
                        if (rd.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                        }
                        BdToast.makeText(TbadkCoreApplication.getInst().getContext(), str).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
                        return;
                    }
                    BaseActivity baseActivity = this.a.a;
                    baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                }
            }

            @Override // com.baidu.tieba.yva.a
            public void b(String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                    this.a.b.p(false);
                    this.a.b.r(false);
                    if (this.a.b.h != null && this.a.b.h.forum_id.longValue() != 0) {
                        LikeReturnData likeReturnData = new LikeReturnData();
                        likeReturnData.setFid(j + "");
                        likeReturnData.setLike(0);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
                        MessageManager messageManager = MessageManager.getInstance();
                        messageManager.sendMessage(new CustomMessage(2003004, this.a.b.h.forum_id + ""));
                    }
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.b.j.dismiss();
                yva yvaVar = new yva();
                yvaVar.a(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                yvaVar.b(new a(this));
                yvaVar.c(this.b.h.forum_name, this.b.h.forum_id.longValue());
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void onNavigationButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.q(this.a);
        }
    }

    /* loaded from: classes6.dex */
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
                if (this.a != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(this.a.O0())) {
                    TiebaStatic.eventStat(this.c.a.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends w4 {
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

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.b.k.getErrorCode() != 22) {
                    if (AntiHelper.m(this.b.k.getErrorCode(), this.b.k.getErrorString())) {
                        if (AntiHelper.t(this.a.getPageContext().getPageActivity(), this.b.k.d0(), this.b.l) != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                            return;
                        }
                        return;
                    } else if (this.b.k.getErrorCode() != 0) {
                        this.a.showToast(this.b.k.getErrorString());
                        return;
                    } else {
                        LikeReturnData likeReturnData = (LikeReturnData) obj;
                        if (likeReturnData != null) {
                            if (likeReturnData.getErrorCode() == 3250013) {
                                BdToast.makeText(TbadkCoreApplication.getInst().getContext(), likeReturnData.getErrorMsg()).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
                                return;
                            } else if (AntiHelper.l(likeReturnData.getErrorCode())) {
                                AntiHelper.t(this.a.getPageContext().getPageActivity(), this.b.k.d0(), this.b.l);
                                return;
                            } else {
                                this.b.p(true);
                                TbadkApplication.getInst().addLikeForum(this.b.h.forum_name);
                                this.b.r(true);
                                likeReturnData.setLike(1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
                                return;
                            }
                        }
                        ForumDetailActivity forumDetailActivity = this.a;
                        forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e70));
                        return;
                    }
                }
                this.b.p(true);
                this.b.r(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
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

    public final void k(BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseActivity, z) == null) {
            if (this.j == null) {
                f05 f05Var = new f05(baseActivity.getPageContext().getPageActivity());
                this.j = f05Var;
                f05Var.setMessageId(R.string.obfuscated_res_0x7f0f07b8);
                this.j.setPositiveButton(R.string.alert_yes_button, new e(this, baseActivity));
                this.j.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new f(this));
                this.j.setCanceledOnTouchOutside(true);
            }
            this.j.create(baseActivity.getPageContext()).show();
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
            boolean z = true;
            if (recommendForumInfo.is_like.intValue() != 1) {
                z = false;
            }
            r(z);
            this.c.setOnClickListener(new b(this, forumDetailActivity));
            this.f.setOnClickListener(new c(this, forumDetailActivity, str));
            setVisibility(0);
        }
    }

    public void m(ForumDetailActivity forumDetailActivity, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, forumDetailActivity, i) == null) {
            BDLayoutMode layoutMode = forumDetailActivity.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            forumDetailActivity.getLayoutMode().onModeChanged(this);
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
            likeModel.g0(recommendForumInfo.forum_name, String.valueOf(recommendForumInfo.forum_id));
        }
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.b = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0309, (ViewGroup) this, true);
            setOrientation(1);
            setVisibility(8);
            this.c = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090bd2);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090bd3);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091071);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090bd4);
            this.g = findViewById(R.id.obfuscated_res_0x7f090bf8);
        }
    }

    public void r(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                SkinManager.setImageResource(this.e, R.drawable.icon_pop_pass);
                i = R.string.relate_forum_is_followed;
                this.c.setTag(0);
            } else {
                SkinManager.setImageResource(this.e, R.drawable.icon_brief_attention);
                i = R.string.obfuscated_res_0x7f0f02f4;
                this.c.setTag(1);
            }
            this.d.setText(this.b.getResources().getString(i));
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0308, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090317);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09031e);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0111);
            if (z) {
                return;
            }
            imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_tips_attention_cancel));
            textView.setText(R.string.unfollow_title);
            Toast toast = new Toast(this.b);
            toast.setView(inflate);
            toast.setGravity(17, 0, 0);
            toast.setDuration(1000);
            GreyUtil.grey(toast);
            toast.show();
            if (z) {
                this.a.S0(true);
            } else {
                this.a.S0(false);
            }
            this.a.U0(z);
            this.a.T0(z);
        }
    }

    public final void q(ForumDetailActivity forumDetailActivity) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, forumDetailActivity) == null) {
            if (forumDetailActivity != null && !forumDetailActivity.checkUpIsLogin()) {
                return;
            }
            int intValue = ((Integer) this.c.getTag()).intValue();
            if (intValue == 0) {
                k(forumDetailActivity, this.i);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.O0())) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                j(forumDetailActivity, this.i);
            }
            if (intValue == 1) {
                str = "detail_care_add";
            } else {
                str = "detail_care_cancel";
            }
            TiebaStatic.eventStat(this.b, str, "click", 1, new Object[0]);
        }
    }
}
