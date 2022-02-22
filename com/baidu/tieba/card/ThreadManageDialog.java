package com.baidu.tieba.card;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.s.r.a0;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.m0;
import c.a.t0.s.t.a;
import c.a.t0.s.t.j;
import c.a.t0.s.t.m;
import c.a.u0.e1.w0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes12.dex */
public class ThreadManageDialog extends PopupDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public final CompoundButton.OnCheckedChangeListener B;
    public final c.a.d.a.e C;
    public final j.e D;
    public TbPageContext n;
    public Context o;
    public final j p;
    public AlertDialog q;
    public AlertDialog r;
    public c.a.t0.s.t.a s;
    public Dialog t;
    public final List<c.a.t0.s.t.g> u;
    public String v;
    public String w;
    public List<BlueCheckRadioButton> x;
    public e2 y;
    public ForumManageModel z;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f42595e;

        public a(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42595e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f42595e.q != null) {
                    this.f42595e.q.dismiss();
                }
                if (!l.A()) {
                    n.M(this.f42595e.o, R.string.neterror);
                } else {
                    this.f42595e.V(null, false);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f42596e;

        public b(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42596e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42596e.q == null) {
                return;
            }
            this.f42596e.q.dismiss();
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f42597e;

        public c(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42597e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f42597e.r != null) {
                    this.f42597e.r.dismiss();
                }
                if (!l.A()) {
                    n.M(this.f42597e.o, R.string.neterror);
                    return;
                }
                this.f42597e.V(null, true);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CONFIRM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.f42597e.y.h0());
                statisticItem.param("fid", this.f42597e.y.U());
                statisticItem.param("fname", this.f42597e.y.b0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f42598e;

        public d(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42598e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f42598e.r != null) {
                    this.f42598e.r.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CANCEL_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.f42598e.y.h0());
                statisticItem.param("fid", this.f42598e.y.U());
                statisticItem.param("fname", this.f42598e.y.b0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f42599e;

        public e(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42599e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.m.g.b(this.f42599e.t, this.f42599e.n);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f42600e;

        public f(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42600e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.m.g.b(this.f42600e.t, this.f42600e.n);
                ThreadManageDialog threadManageDialog = this.f42600e;
                threadManageDialog.X(threadManageDialog.w, false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f42601e;

        public g(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42601e = threadManageDialog;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z && (compoundButton.getTag() instanceof String)) {
                this.f42601e.w = (String) compoundButton.getTag();
                if (this.f42601e.x != null) {
                    for (BlueCheckRadioButton blueCheckRadioButton : this.f42601e.x) {
                        String str = (String) blueCheckRadioButton.getTag();
                        if (str != null && this.f42601e.w != null && !str.equals(this.f42601e.w)) {
                            blueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadManageDialog a;

        /* loaded from: classes12.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.t0.s.t.a.e
            public void onClick(c.a.t0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        public h(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadManageDialog;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.a.z == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.a.P();
            switch (this.a.z.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.f48364d != 0) {
                        if (bVar.f48368h) {
                            new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.Q(R.string.shield_fail, new Object[0])).show(viewGroup);
                            return;
                        } else {
                            new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.Q(R.string.delete_fail, new Object[0])).show(viewGroup);
                            return;
                        }
                    } else if (bVar.a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.y.h0()));
                        if (bVar.f48368h) {
                            new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.Q(R.string.shield_success, new Object[0])).show(viewGroup);
                            return;
                        } else {
                            new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.Q(R.string.delete_success, new Object[0])).show(viewGroup);
                            return;
                        }
                    } else {
                        String Q = !TextUtils.isEmpty(bVar.f48362b) ? bVar.f48362b : this.a.Q(R.string.delete_fail, new Object[0]);
                        if (bVar.f48363c == 1211066) {
                            if (this.a.s == null) {
                                ThreadManageDialog threadManageDialog = this.a;
                                threadManageDialog.s = new c.a.t0.s.t.a(threadManageDialog.n.getPageActivity());
                                this.a.s.setMessage(Q);
                                this.a.s.setPositiveButton(R.string.dialog_known, new a(this));
                                this.a.s.setCancelable(true);
                                this.a.s.create(this.a.n);
                            }
                            this.a.s.show();
                            return;
                        }
                        new BdTopToast(this.a.getContext()).setIcon(false).setContent(Q).show(viewGroup);
                        return;
                    }
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    if (dVar == null) {
                        n.N(this.a.o, this.a.Q(R.string.mute_fail, new Object[0]));
                        return;
                    } else if (dVar.a) {
                        n.N(this.a.o, !TextUtils.isEmpty(dVar.f48369b) ? dVar.f48369b : this.a.Q(R.string.mute_success, new Object[0]));
                        return;
                    } else {
                        n.N(this.a.o, !TextUtils.isEmpty(dVar.f48369b) ? dVar.f48369b : this.a.Q(R.string.mute_fail, new Object[0]));
                        return;
                    }
                case 2:
                case 3:
                case 4:
                case 5:
                    ThreadManageDialog threadManageDialog2 = this.a;
                    threadManageDialog2.O(threadManageDialog2.z.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    if (gVar == null || !gVar.a) {
                        n.N(this.a.o, this.a.Q(R.string.operation_failed, new Object[0]));
                        return;
                    } else if (gVar.f48381c.size() != 0) {
                        this.a.U(gVar.f48381c);
                        return;
                    } else {
                        ThreadManageDialog threadManageDialog3 = this.a;
                        threadManageDialog3.N(threadManageDialog3.z.getLoadDataMode(), gVar);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f42602e;

        public i(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42602e = threadManageDialog;
        }

        @Override // c.a.t0.s.t.j.e
        public void onItemClick(j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f42602e.dismiss();
                if (!l.z()) {
                    n.M(this.f42602e.o, R.string.network_not_available);
                    return;
                }
                if (i2 == 1) {
                    if (this.f42602e.y != null && this.f42602e.y.J() != null) {
                        if (UtilHelper.isCurrentAccount(this.f42602e.y.J().getUserId())) {
                            this.f42602e.showDeleteMeDialog();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new c.a.u0.k.h(1, this.f42602e.z, this.f42602e.y)));
                        }
                    }
                } else if (i2 == 9) {
                    if (this.f42602e.y != null && this.f42602e.y.J() != null) {
                        if (UtilHelper.isCurrentAccount(this.f42602e.y.J().getUserId())) {
                            this.f42602e.showBlockMeDialog();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new c.a.u0.k.h(3, this.f42602e.z, this.f42602e.y)));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("tid", this.f42602e.y.h0());
                            if (this.f42602e.y.Z() != null) {
                                statisticItem.param("fid", this.f42602e.y.Z().getForumId());
                                statisticItem.param("fname", this.f42602e.y.Z().getForumName());
                            }
                            statisticItem.param("obj_source", 1);
                            TiebaStatic.log(statisticItem);
                        }
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_BAWU_FRS_MUSK_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("tid", this.f42602e.y.h0());
                        statisticItem2.param("fid", this.f42602e.y.U());
                        statisticItem2.param("fname", this.f42602e.y.b0());
                        TiebaStatic.log(statisticItem2);
                    }
                } else if (i2 == 2) {
                    this.f42602e.W();
                } else if (i2 == 3) {
                    this.f42602e.Y();
                } else if (i2 == 4) {
                    ThreadManageDialog threadManageDialog = this.f42602e;
                    threadManageDialog.X(threadManageDialog.v, true);
                } else if (i2 == 5) {
                    this.f42602e.K();
                } else if (i2 == 10) {
                    this.f42602e.J();
                    StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_BAWU_MULTI_MUSK_CLICK);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem3.param("tid", this.f42602e.y.h0());
                    statisticItem3.param("fid", this.f42602e.y.U());
                    statisticItem3.param("fname", this.f42602e.y.b0());
                    TiebaStatic.log(statisticItem3);
                } else if (i2 == 6) {
                    this.f42602e.T();
                } else if (i2 == 7) {
                    this.f42602e.I();
                } else if (i2 == 8) {
                    this.f42602e.H();
                }
                this.f42602e.S(i2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadManageDialog(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = "0";
        this.w = "0";
        this.A = false;
        this.B = new g(this);
        this.C = new h(this);
        this.D = new i(this);
        this.n = tbPageContext;
        this.o = tbPageContext.getPageActivity();
        this.u = new ArrayList();
        j jVar = new j(this.o);
        this.p = jVar;
        jVar.q(Q(R.string.thread_manager, new Object[0]));
        this.p.n(this.D);
        ForumManageModel forumManageModel = new ForumManageModel(this.n);
        this.z = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.C);
        this.A = z;
        setContentView(this.p);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.y));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.u0.e1.a.h().p(true, false);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.u0.e1.b.f().o(true);
            c.a.u0.e1.b.f().p(true, false);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.y.h0());
            statisticItem.param("fid", this.y.U());
            statisticItem.param("fname", this.y.b0());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.u0.e1.b.f().o(false);
            c.a.u0.e1.b.f().p(true, false);
        }
    }

    public final BlueCheckRadioButton L(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.o);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, n.f(this.o, R.dimen.ds100));
            blueCheckRadioButton.setOnCheckedChangeListener(this.B);
            blueCheckRadioButton.setTag(str);
            blueCheckRadioButton.setText(str2);
            blueCheckRadioButton.setLayoutParams(layoutParams);
            return blueCheckRadioButton;
        }
        return (BlueCheckRadioButton) invokeLL.objValue;
    }

    public final void M() {
        List<c.a.t0.s.t.g> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.y == null || (list = this.u) == null || this.p == null) {
            return;
        }
        list.clear();
        if (c.a.u0.e1.j.d(c.a.u0.e1.j.a()) && !c.a.u0.e1.j.f()) {
            if (!this.y.U1() && ((this.y.J() == null || !this.y.J().isForumBusinessAccount() || this.y.isSelf() || w0.isOn()) && !c.a.u0.e1.j.g() && !this.y.N2() && !this.y.w2() && (!this.y.D2() || this.y.isSelf()))) {
                this.u.add(new c.a.t0.s.t.g(1, Q(R.string.delete_page, new Object[0]), this.p));
            }
            if (this.y.N2() || this.y.w2() || (c.a.u0.e1.j.g() && !this.y.U1() && (this.y.J() == null || !this.y.J().isForumBusinessAccount() || this.y.isSelf() || w0.isOn()))) {
                this.u.add(new c.a.t0.s.t.g(9, Q(R.string.forum_shield, new Object[0]), this.p));
            }
            if (!UtilHelper.isCurrentAccount(this.y.J() != null ? this.y.J().getUserId() : "") && ((this.y.J() == null || !this.y.J().isForumBusinessAccount()) && !this.y.D2())) {
                this.u.add(new c.a.t0.s.t.g(2, Q(R.string.thread_forbid, new Object[0]), this.p));
            }
        }
        if (c.a.u0.e1.j.e() || c.a.u0.e1.j.f()) {
            this.u.add(new c.a.t0.s.t.g(3, Q(this.y.t0() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.p));
        }
        if (c.a.u0.e1.j.e() || c.a.u0.e1.j.h()) {
            this.u.add(new c.a.t0.s.t.g(4, Q(this.y.s0() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.p));
        }
        if (c.a.u0.e1.j.e()) {
            this.u.add(new c.a.t0.s.t.g(6, Q(R.string.frs_recommend_thread, new Object[0]), this.p));
        }
        if (c.a.u0.e1.j.e() || c.a.u0.e1.j.f()) {
            this.u.add(new c.a.t0.s.t.g(8, Q(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.p));
        }
        if (c.a.u0.e1.j.e() && this.A) {
            this.u.add(new c.a.t0.s.t.g(7, Q(R.string.frs_move_area_thread, new Object[0]), this.p));
        }
        if (!c.a.u0.e1.j.f() && c.a.u0.e1.b.f().j() && this.A && ((this.y.J() == null || !this.y.J().isForumBusinessAccount() || this.y.isSelf() || w0.isOn()) && !c.a.u0.e1.j.g())) {
            this.u.add(new c.a.t0.s.t.g(5, Q(R.string.multi_delete, new Object[0]), this.p));
        }
        if (c.a.u0.e1.j.g() && !c.a.u0.e1.j.f() && c.a.u0.e1.b.f().j() && this.A && (this.y.J() == null || !this.y.J().isForumBusinessAccount() || this.y.isSelf() || w0.isOn())) {
            this.u.add(new c.a.t0.s.t.g(10, Q(R.string.multi_shield, new Object[0]), this.p));
        }
        if (c.a.u0.e1.j.g() && this.y.isSelf() && !this.y.U1()) {
            this.u.add(new c.a.t0.s.t.g(1, Q(R.string.delete, new Object[0]), this.p));
        }
        this.p.j(this.u);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N(int i2, ForumManageModel.g gVar) {
        String Q;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIL(1048582, this, i2, gVar) != null) {
            return;
        }
        e2 e2Var = this.y;
        if (e2Var != null && gVar != null && gVar.a) {
            boolean z = true;
            String str = "";
            if (i2 == 6) {
                e2Var.c4(1);
                a0 a0Var = new a0();
                a0Var.a = 2;
                a0Var.f13742b = this.y.w1();
                if (c.a.u0.e1.j.e()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, a0Var));
                    ForumManageModel.e eVar = new ForumManageModel.e();
                    eVar.a = this.y.h0();
                    eVar.f48371c = this.y.b0();
                    eVar.f48370b = String.valueOf(this.y.U());
                    eVar.f48372d = i2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
                    if (TextUtils.isEmpty(str)) {
                        str = Q(R.string.operation_success, new Object[0]);
                    }
                    if (z) {
                        n.N(this.o, str);
                        return;
                    }
                    return;
                }
                str = R(gVar.f48380b, R.string.set_good_success);
            }
            z = false;
            ForumManageModel.e eVar2 = new ForumManageModel.e();
            eVar2.a = this.y.h0();
            eVar2.f48371c = this.y.b0();
            eVar2.f48370b = String.valueOf(this.y.U());
            eVar2.f48372d = i2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar2));
            if (TextUtils.isEmpty(str)) {
            }
            if (z) {
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.f48380b)) {
                Q = gVar.f48380b;
            } else {
                Q = Q(R.string.operation_failed, new Object[0]);
            }
            n.N(this.o, Q);
        }
    }

    public final void O(int i2, ForumManageModel.g gVar) {
        String Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, gVar) == null) {
            e2 e2Var = this.y;
            if (e2Var != null && gVar != null && gVar.a) {
                String str = "";
                boolean z = true;
                if (i2 == 2) {
                    e2Var.c4(1);
                    a0 a0Var = new a0();
                    a0Var.a = 2;
                    a0Var.f13742b = this.y.w1();
                    if (c.a.u0.e1.j.e()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, a0Var));
                    } else {
                        str = R(gVar.f48380b, R.string.set_good_success);
                        z = false;
                    }
                } else {
                    if (i2 == 3) {
                        e2Var.c4(0);
                        str = R(gVar.f48380b, R.string.operation_success);
                    } else if (i2 == 4) {
                        e2Var.d4(1);
                        a0 a0Var2 = new a0();
                        a0Var2.a = 1;
                        a0Var2.f13742b = this.y.w1();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, a0Var2));
                    } else if (i2 == 5) {
                        e2Var.d4(0);
                        str = R(gVar.f48380b, R.string.operation_success);
                    }
                    z = false;
                }
                ForumManageModel.e eVar = new ForumManageModel.e();
                eVar.a = this.y.h0();
                eVar.f48371c = this.y.b0();
                eVar.f48370b = String.valueOf(this.y.U());
                eVar.f48372d = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
                if (TextUtils.isEmpty(str)) {
                    str = Q(R.string.operation_success, new Object[0]);
                }
                if (z) {
                    return;
                }
                n.N(this.o, str);
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f48380b)) {
                Q = gVar.f48380b;
            } else {
                Q = Q(R.string.operation_failed, new Object[0]);
            }
            n.N(this.o, Q);
        }
    }

    public final View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Context context = this.o;
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final String Q(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, objArr)) == null) {
            Context context = this.o;
            if (context == null) {
                return null;
            }
            return context.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public final String R(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i2)) == null) ? !TextUtils.isEmpty(str) ? str : Q(i2, new Object[0]) : (String) invokeLI.objValue;
    }

    public final void S(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || this.y == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.y.U()).param("tid", this.y.h0()));
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.n == null || this.y == null) {
            return;
        }
        BawuThrones b2 = c.a.u0.e1.c.c().b();
        if (b2 == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (b2.total_recommend_num.intValue() == b2.used_recommend_num.intValue()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (c.a.t0.s.j0.b.k().h("key_frs_recommend_tip", true)) {
            c.a.u0.e1.c.c().f(this.n, String.valueOf(this.y.U()), this.y.h0());
        } else {
            c.a.u0.e1.c.c().d(String.valueOf(this.y.U()), this.y.h0());
        }
    }

    public final void U(ArrayList<m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, arrayList) == null) {
            if (this.t == null) {
                View inflate = LayoutInflater.from(this.o).inflate(R.layout.commit_good, (ViewGroup) null);
                Dialog dialog = new Dialog(this.o, R.style.common_alert_dialog);
                this.t = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.t.setCancelable(true);
                this.t.setContentView(inflate);
                WindowManager.LayoutParams attributes = this.t.getWindow().getAttributes();
                attributes.width = n.f(this.o, R.dimen.ds540);
                this.t.getWindow().setAttributes(attributes);
                inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new e(this));
                inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new f(this));
            }
            c.a.t0.x0.a.a(this.n, this.t.findViewById(R.id.commit_good_layout));
            LinearLayout linearLayout = (LinearLayout) this.t.findViewById(R.id.good_class_group);
            linearLayout.removeAllViews();
            this.x = new ArrayList();
            BlueCheckRadioButton L = L(this.v, Q(R.string.thread_good_class, new Object[0]));
            L.setChecked(true);
            linearLayout.addView(L);
            this.x.add(L);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        BlueCheckRadioButton L2 = L(String.valueOf(m0Var.a()), m0Var.b());
                        this.x.add(L2);
                        View view = new View(this.o);
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, n.f(this.o, R.dimen.ds1)));
                        linearLayout.addView(view);
                        linearLayout.addView(L2);
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                    }
                }
                ScrollView scrollView = (ScrollView) this.t.findViewById(R.id.good_scroll);
                ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
                int size2 = arrayList.size();
                if (size2 == 0 || size2 == 1) {
                    layoutParams.height = n.d(this.o, 120.0f);
                } else if (size2 != 2) {
                    layoutParams.height = n.d(this.o, 220.0f);
                } else {
                    layoutParams.height = n.d(this.o, 186.0f);
                }
                scrollView.setLayoutParams(layoutParams);
                scrollView.removeAllViews();
                scrollView.addView(linearLayout);
            }
            c.a.d.f.m.g.j(this.t, this.n);
        }
    }

    public final void V(JSONArray jSONArray, boolean z) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, jSONArray, z) == null) || this.z == null || (e2Var = this.y) == null || e2Var.J() == null) {
            return;
        }
        String userId = this.y.J().getUserId();
        String h0 = this.y.h0();
        String b0 = this.y.b0();
        String valueOf = String.valueOf(this.y.U());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            this.z.R(StringHelper.JsonArrayToString(jSONArray));
        }
        this.z.S(valueOf, b0, h0, null, 0, 1, isCurrentAccount, this.y.L(), z);
    }

    public final void W() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.o == null || (e2Var = this.y) == null || e2Var.J() == null) {
            return;
        }
        String userId = this.y.J().getUserId();
        String userName = this.y.J().getUserName();
        String name_show = this.y.J().getName_show();
        String h0 = this.y.h0();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.o, String.valueOf(this.y.U()), this.y.b0(), h0, userId, userName, name_show, null, this.y.J().getPortrait())));
    }

    public final void X(String str, boolean z) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048592, this, str, z) == null) || (e2Var = this.y) == null || this.z == null) {
            return;
        }
        this.z.T(String.valueOf(this.y.U()), this.y.b0(), this.y.h0(), e2Var.s0() == 1 ? 3 : z ? 6 : 2, str);
    }

    public final void Y() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (e2Var = this.y) == null || this.z == null) {
            return;
        }
        int i2 = e2Var.t0() == 1 ? 5 : 4;
        this.z.T(String.valueOf(this.y.U()), this.y.b0(), this.y.h0(), i2, null);
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            dismissAllDialog();
        }
    }

    public void dismissAllDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            dismissDeleteDialog();
            dismissBlockDialog();
            dismissGoodListDialog();
            dismiss();
        }
    }

    public void dismissBlockDialog() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (alertDialog = this.r) != null && alertDialog.isShowing()) {
            this.r.dismiss();
        }
    }

    public void dismissDeleteDialog() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (alertDialog = this.q) != null && alertDialog.isShowing()) {
            this.q.dismiss();
        }
    }

    public void dismissGoodListDialog() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (dialog = this.t) != null && dialog.isShowing()) {
            this.t.dismiss();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            j jVar = this.p;
            if (jVar != null) {
                jVar.i();
            }
            c.a.t0.s.t.a aVar = this.s;
            if (aVar != null) {
                c.a.t0.x0.a.a(this.n, aVar.getRealView());
            }
        }
    }

    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, e2Var) == null) {
            this.y = e2Var;
            M();
        }
    }

    public void showBlockMeDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            dismissBlockDialog();
            if (this.n == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.shield, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
            m mVar = new m(this.n.getPageActivity());
            mVar.v(R.string.musk_my_thread_confirm);
            mVar.l(R.string.musk_my_thread_confirm_subtitle);
            mVar.n(true);
            mVar.r(aVar2, aVar);
            mVar.i(false);
            this.r = mVar.y();
            aVar.a(new c(this));
            aVar2.a(new d(this));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.y.h0());
            statisticItem.param("fid", this.y.U());
            statisticItem.param("fname", this.y.b0());
            TiebaStatic.log(statisticItem);
        }
    }

    public void showDeleteMeDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            dismissDeleteDialog();
            if (this.n == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.delete, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
            m mVar = new m(this.n.getPageActivity());
            mVar.v(R.string.del_my_thread_confirm);
            mVar.l(R.string.del_my_thread_confirm_subtitle);
            mVar.n(true);
            mVar.r(aVar2, aVar);
            mVar.i(false);
            this.q = mVar.y();
            aVar.a(new a(this));
            aVar2.a(new b(this));
        }
    }
}
