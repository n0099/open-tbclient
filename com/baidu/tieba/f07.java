package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter;
import com.baidu.tieba.enterForum.callback.LikeForumDragCallBack;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.m45;
import com.baidu.tieba.oy6;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class f07 extends pq5<fy6, by6> implements wx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public RecyclerView i;
    public LikeForumItemAdapter j;
    public oy6 k;
    public EnterForumModel l;
    public ViewEventCenter m;

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f07 a;

        /* loaded from: classes5.dex */
        public class a implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921372, bc5.b()));
                    m45Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    m45Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.f07$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0283c implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0283c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    m45Var.dismiss();
                }
            }
        }

        public c(f07 f07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String N;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l.P()) {
                    if (this.a.m != null) {
                        this.a.m.dispatchMvcEvent(new iq5(14, null, null, null));
                    }
                } else if (this.a.b() == null) {
                } else {
                    boolean z = false;
                    ForumCreateInfoData b2 = this.a.l.R().b();
                    if (b2 != null) {
                        int O = b2.O();
                        if (O != 220012) {
                            if (O == 2121002) {
                                DialogUtil.createAlertDialog(this.a.b(), (String) null, this.a.b().getString(R.string.obfuscated_res_0x7f0f0509), this.a.b().getString(R.string.obfuscated_res_0x7f0f16a5), this.a.b().getString(R.string.obfuscated_res_0x7f0f162a), new a(this), new b(this)).show();
                            }
                        } else {
                            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                            if (bi.isEmpty(b2.N())) {
                                N = this.a.b().getString(R.string.obfuscated_res_0x7f0f0505);
                            } else {
                                N = b2.N();
                            }
                            blockPopInfoData.block_info = N;
                            blockPopInfoData.ahead_info = this.a.b().getString(R.string.obfuscated_res_0x7f0f0507);
                            blockPopInfoData.ok_info = this.a.b().getString(R.string.obfuscated_res_0x7f0f0b3e);
                            blockPopInfoData.ahead_url = AntiHelper.a;
                            AntiHelper.s(this.a.b().getPageActivity(), blockPopInfoData);
                        }
                        z = true;
                    }
                    if (!z) {
                        String string = this.a.b().getString(R.string.obfuscated_res_0x7f0f0506);
                        if (b2 != null) {
                            if (bi.isEmpty(b2.N())) {
                                string = this.a.b().getResources().getString(R.string.obfuscated_res_0x7f0f0506);
                            } else {
                                string = b2.N();
                            }
                        }
                        DialogUtil.createAlertDialog(this.a.b(), (String) null, string, this.a.b().getResources().getString(R.string.obfuscated_res_0x7f0f0b3e), (String) null, new C0283c(this), (m45.e) null).show();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements oy6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public a(f07 f07Var, EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f07Var, enterForumModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumModel;
        }

        @Override // com.baidu.tieba.oy6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.Z(true, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements LikeForumItemAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j07 a;
        public final /* synthetic */ ItemTouchHelper b;
        public final /* synthetic */ f07 c;

        public b(f07 f07Var, j07 j07Var, ItemTouchHelper itemTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f07Var, j07Var, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f07Var;
            this.a = j07Var;
            this.b = itemTouchHelper;
        }

        @Override // com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter.b
        public boolean a(Object obj, RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, viewHolder)) == null) {
                if (this.a.p()) {
                    return false;
                }
                if (this.c.k.o() == 1) {
                    if (obj instanceof ey6) {
                        this.b.startDrag(viewHolder);
                    }
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        new BdTopToast(currentActivity, 2000).setIcon(false).setContent(currentActivity.getString(R.string.obfuscated_res_0x7f0f0b85)).show((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f07(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, j07 j07Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, j07Var, enterForumModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f09150f);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092560);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09223a);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.recycler_view);
        this.i = recyclerView;
        this.l = enterForumModel;
        this.m = viewEventCenter;
        recyclerView.setNestedScrollingEnabled(false);
        this.i.setLayoutManager(new GridLayoutManager(getContext(), 2));
        LikeForumItemAdapter likeForumItemAdapter = new LikeForumItemAdapter(tbPageContext, null, viewEventCenter);
        this.j = likeForumItemAdapter;
        likeForumItemAdapter.n(m());
        this.i.setAdapter(this.j);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new LikeForumDragCallBack(this.j, this));
        itemTouchHelper.attachToRecyclerView(this.i);
        oy6 oy6Var = new oy6(tbPageContext.getPageActivity(), Integer.valueOf(ux6.a(1)).intValue(), 0, j07Var);
        this.k = oy6Var;
        oy6Var.u(new a(this, enterForumModel));
        this.j.o(new b(this, j07Var, itemTouchHelper));
    }

    @Override // com.baidu.tieba.wx6
    public void a(String str, String str2) {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && (enterForumModel = this.l) != null) {
            enterForumModel.k0(str, str2);
        }
    }

    @Override // com.baidu.tieba.qaa
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, tbPageContext, i)) == null) {
            EMManager.from(this.f).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final View.OnClickListener m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new c(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sq5
    /* renamed from: n */
    public void f(fy6 fy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fy6Var) == null) {
            super.f(fy6Var);
            o(fy6Var.d);
            List<ey6> list = fy6Var.e;
            int i = 1;
            if (list != null) {
                i = 1 + list.size();
            }
            int ceil = (int) Math.ceil((i * 1.0f) / 2.0f);
            this.i.getLayoutParams().height = BdUtilHelper.getDimens(getContext(), R.dimen.tbds156) * ceil;
            this.i.getRecycledViewPool().setMaxRecycledViews(0, i);
            this.j.update(fy6Var.e);
            onChangeSkinType(b(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void o(dy6 dy6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, dy6Var) != null) || dy6Var == null) {
            return;
        }
        this.k.v(this.h);
        this.k.r();
        this.k.q(TbadkCoreApplication.getInst().getSkinType());
        this.g.setText(dy6Var.d);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        TextView textView = this.h;
        if (textView != null) {
            if (dy6Var.e) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.h, R.color.transparent);
        }
    }
}
