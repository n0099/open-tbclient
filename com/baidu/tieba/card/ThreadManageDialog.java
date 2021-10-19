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
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.s.q.a0;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.m0;
import c.a.q0.s.s.a;
import c.a.q0.s.s.i;
import c.a.r0.x0.v0;
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
/* loaded from: classes7.dex */
public class ThreadManageDialog extends PopupDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public final CompoundButton.OnCheckedChangeListener B;
    public final c.a.e.a.e C;
    public final i.e D;
    public TbPageContext n;
    public Context o;
    public final c.a.q0.s.s.i p;
    public AlertDialog q;
    public AlertDialog r;
    public c.a.q0.s.s.a s;
    public Dialog t;
    public final List<c.a.q0.s.s.f> u;
    public String v;
    public String w;
    public List<BlueCheckRadioButton> x;
    public d2 y;
    public ForumManageModel z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f50024e;

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
            this.f50024e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50024e.q != null) {
                    this.f50024e.q.dismiss();
                }
                if (!j.A()) {
                    l.L(this.f50024e.o, R.string.neterror);
                } else {
                    this.f50024e.T(null, false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f50025e;

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
            this.f50025e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50025e.q == null) {
                return;
            }
            this.f50025e.q.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f50026e;

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
            this.f50026e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50026e.r != null) {
                    this.f50026e.r.dismiss();
                }
                if (!j.A()) {
                    l.L(this.f50026e.o, R.string.neterror);
                    return;
                }
                this.f50026e.T(null, true);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CONFIRM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.f50026e.y.f0());
                statisticItem.param("fid", this.f50026e.y.T());
                statisticItem.param("fname", this.f50026e.y.Z());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f50027e;

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
            this.f50027e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50027e.r != null) {
                    this.f50027e.r.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CANCEL_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.f50027e.y.f0());
                statisticItem.param("fid", this.f50027e.y.T());
                statisticItem.param("fname", this.f50027e.y.Z());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f50028e;

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
            this.f50028e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.m.g.b(this.f50028e.t, this.f50028e.n);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f50029e;

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
            this.f50029e = threadManageDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.m.g.b(this.f50029e.t, this.f50029e.n);
                ThreadManageDialog threadManageDialog = this.f50029e;
                threadManageDialog.V(threadManageDialog.w, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f50030e;

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
            this.f50030e = threadManageDialog;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z && (compoundButton.getTag() instanceof String)) {
                this.f50030e.w = (String) compoundButton.getTag();
                if (this.f50030e.x != null) {
                    for (BlueCheckRadioButton blueCheckRadioButton : this.f50030e.x) {
                        String str = (String) blueCheckRadioButton.getTag();
                        if (str != null && this.f50030e.w != null && !str.equals(this.f50030e.w)) {
                            blueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f50031a;

        /* loaded from: classes7.dex */
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

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
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
            this.f50031a = threadManageDialog;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.f50031a.z == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.f50031a.N();
            switch (this.f50031a.z.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.f57179d != 0) {
                        if (bVar.f57183h) {
                            new BdTopToast(this.f50031a.getContext()).setIcon(false).setContent(this.f50031a.O(R.string.shield_fail, new Object[0])).show(viewGroup);
                            return;
                        } else {
                            new BdTopToast(this.f50031a.getContext()).setIcon(false).setContent(this.f50031a.O(R.string.delete_fail, new Object[0])).show(viewGroup);
                            return;
                        }
                    } else if (bVar.f57176a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.f50031a.y.f0()));
                        if (bVar.f57183h) {
                            new BdTopToast(this.f50031a.getContext()).setIcon(true).setContent(this.f50031a.O(R.string.shield_success, new Object[0])).show(viewGroup);
                            return;
                        } else {
                            new BdTopToast(this.f50031a.getContext()).setIcon(true).setContent(this.f50031a.O(R.string.delete_success, new Object[0])).show(viewGroup);
                            return;
                        }
                    } else {
                        String O = !TextUtils.isEmpty(bVar.f57177b) ? bVar.f57177b : this.f50031a.O(R.string.delete_fail, new Object[0]);
                        if (bVar.f57178c == 1211066) {
                            if (this.f50031a.s == null) {
                                ThreadManageDialog threadManageDialog = this.f50031a;
                                threadManageDialog.s = new c.a.q0.s.s.a(threadManageDialog.n.getPageActivity());
                                this.f50031a.s.setMessage(O);
                                this.f50031a.s.setPositiveButton(R.string.dialog_known, new a(this));
                                this.f50031a.s.setCancelable(true);
                                this.f50031a.s.create(this.f50031a.n);
                            }
                            this.f50031a.s.show();
                            return;
                        }
                        new BdTopToast(this.f50031a.getContext()).setIcon(false).setContent(O).show(viewGroup);
                        return;
                    }
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    if (dVar == null) {
                        l.M(this.f50031a.o, this.f50031a.O(R.string.mute_fail, new Object[0]));
                        return;
                    } else if (dVar.f57184a) {
                        l.M(this.f50031a.o, !TextUtils.isEmpty(dVar.f57185b) ? dVar.f57185b : this.f50031a.O(R.string.mute_success, new Object[0]));
                        return;
                    } else {
                        l.M(this.f50031a.o, !TextUtils.isEmpty(dVar.f57185b) ? dVar.f57185b : this.f50031a.O(R.string.mute_fail, new Object[0]));
                        return;
                    }
                case 2:
                case 3:
                case 4:
                case 5:
                    ThreadManageDialog threadManageDialog2 = this.f50031a;
                    threadManageDialog2.M(threadManageDialog2.z.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    if (gVar == null || !gVar.f57198a) {
                        l.M(this.f50031a.o, this.f50031a.O(R.string.operation_failed, new Object[0]));
                        return;
                    } else {
                        this.f50031a.S(gVar.f57200c);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadManageDialog f50032e;

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
            this.f50032e = threadManageDialog;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f50032e.dismiss();
                if (!j.z()) {
                    l.L(this.f50032e.o, R.string.network_not_available);
                    return;
                }
                if (i2 == 1) {
                    if (this.f50032e.y != null && this.f50032e.y.J() != null) {
                        if (UtilHelper.isCurrentAccount(this.f50032e.y.J().getUserId())) {
                            this.f50032e.showDeleteMeDialog();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new c.a.r0.j.h(1, this.f50032e.z, this.f50032e.y)));
                        }
                    }
                } else if (i2 == 9) {
                    if (this.f50032e.y != null && this.f50032e.y.J() != null) {
                        if (UtilHelper.isCurrentAccount(this.f50032e.y.J().getUserId())) {
                            this.f50032e.showBlockMeDialog();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new c.a.r0.j.h(3, this.f50032e.z, this.f50032e.y)));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("tid", this.f50032e.y.f0());
                            if (this.f50032e.y.Y() != null) {
                                statisticItem.param("fid", this.f50032e.y.Y().getForumId());
                                statisticItem.param("fname", this.f50032e.y.Y().getForumName());
                            }
                            statisticItem.param("obj_source", 1);
                            TiebaStatic.log(statisticItem);
                        }
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_BAWU_FRS_MUSK_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("tid", this.f50032e.y.f0());
                        statisticItem2.param("fid", this.f50032e.y.T());
                        statisticItem2.param("fname", this.f50032e.y.Z());
                        TiebaStatic.log(statisticItem2);
                    }
                } else if (i2 == 2) {
                    this.f50032e.U();
                } else if (i2 == 3) {
                    this.f50032e.W();
                } else if (i2 == 4) {
                    ThreadManageDialog threadManageDialog = this.f50032e;
                    threadManageDialog.V(threadManageDialog.v, true);
                } else if (i2 == 5) {
                    this.f50032e.J();
                } else if (i2 == 10) {
                    this.f50032e.I();
                    StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_BAWU_MULTI_MUSK_CLICK);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem3.param("tid", this.f50032e.y.f0());
                    statisticItem3.param("fid", this.f50032e.y.T());
                    statisticItem3.param("fname", this.f50032e.y.Z());
                    TiebaStatic.log(statisticItem3);
                } else if (i2 == 6) {
                    this.f50032e.R();
                } else if (i2 == 7) {
                    this.f50032e.H();
                } else if (i2 == 8) {
                    this.f50032e.G();
                }
                this.f50032e.Q(i2);
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
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
        c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.o);
        this.p = iVar;
        iVar.q(O(R.string.thread_manager, new Object[0]));
        this.p.n(this.D);
        ForumManageModel forumManageModel = new ForumManageModel(this.n);
        this.z = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.C);
        this.A = z;
        setContentView(this.p);
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.y));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.x0.a.h().p(true, false);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.x0.b.f().o(true);
            c.a.r0.x0.b.f().p(true, false);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.y.f0());
            statisticItem.param("fid", this.y.T());
            statisticItem.param("fname", this.y.Z());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.x0.b.f().o(false);
            c.a.r0.x0.b.f().p(true, false);
        }
    }

    public final BlueCheckRadioButton K(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.o);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.g(this.o, R.dimen.ds100));
            blueCheckRadioButton.setOnCheckedChangeListener(this.B);
            blueCheckRadioButton.setTag(str);
            blueCheckRadioButton.setText(str2);
            blueCheckRadioButton.setLayoutParams(layoutParams);
            return blueCheckRadioButton;
        }
        return (BlueCheckRadioButton) invokeLL.objValue;
    }

    public final void L() {
        List<c.a.q0.s.s.f> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.y == null || (list = this.u) == null || this.p == null) {
            return;
        }
        list.clear();
        if (c.a.r0.x0.j.d(c.a.r0.x0.j.a()) && !c.a.r0.x0.j.f()) {
            if (!this.y.Q1() && ((this.y.J() == null || !this.y.J().isForumBusinessAccount() || this.y.isSelf() || v0.isOn()) && !c.a.r0.x0.j.g() && !this.y.I2() && !this.y.s2() && (!this.y.z2() || this.y.isSelf()))) {
                this.u.add(new c.a.q0.s.s.f(1, O(R.string.delete_page, new Object[0]), this.p));
            }
            if (this.y.I2() || this.y.s2() || (c.a.r0.x0.j.g() && !this.y.Q1() && (this.y.J() == null || !this.y.J().isForumBusinessAccount() || this.y.isSelf() || v0.isOn()))) {
                this.u.add(new c.a.q0.s.s.f(9, O(R.string.forum_shield, new Object[0]), this.p));
            }
            if (!UtilHelper.isCurrentAccount(this.y.J() != null ? this.y.J().getUserId() : "") && ((this.y.J() == null || !this.y.J().isForumBusinessAccount()) && !this.y.z2())) {
                this.u.add(new c.a.q0.s.s.f(2, O(R.string.thread_forbid, new Object[0]), this.p));
            }
        }
        if (c.a.r0.x0.j.e() || c.a.r0.x0.j.f()) {
            this.u.add(new c.a.q0.s.s.f(3, O(this.y.r0() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.p));
        }
        if (c.a.r0.x0.j.e() || c.a.r0.x0.j.h()) {
            this.u.add(new c.a.q0.s.s.f(4, O(this.y.q0() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.p));
        }
        if (c.a.r0.x0.j.e()) {
            this.u.add(new c.a.q0.s.s.f(6, O(R.string.frs_recommend_thread, new Object[0]), this.p));
        }
        if (c.a.r0.x0.j.e() || c.a.r0.x0.j.f()) {
            this.u.add(new c.a.q0.s.s.f(8, O(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.p));
        }
        if (c.a.r0.x0.j.e() && this.A) {
            this.u.add(new c.a.q0.s.s.f(7, O(R.string.frs_move_area_thread, new Object[0]), this.p));
        }
        if (!c.a.r0.x0.j.f() && c.a.r0.x0.b.f().j() && this.A && ((this.y.J() == null || !this.y.J().isForumBusinessAccount() || this.y.isSelf() || v0.isOn()) && !c.a.r0.x0.j.g())) {
            this.u.add(new c.a.q0.s.s.f(5, O(R.string.multi_delete, new Object[0]), this.p));
        }
        if (c.a.r0.x0.j.g() && !c.a.r0.x0.j.f() && c.a.r0.x0.b.f().j() && this.A && (this.y.J() == null || !this.y.J().isForumBusinessAccount() || this.y.isSelf() || v0.isOn())) {
            this.u.add(new c.a.q0.s.s.f(10, O(R.string.multi_shield, new Object[0]), this.p));
        }
        if (c.a.r0.x0.j.g() && this.y.isSelf() && !this.y.Q1()) {
            this.u.add(new c.a.q0.s.s.f(1, O(R.string.delete, new Object[0]), this.p));
        }
        this.p.k(this.u);
    }

    public final void M(int i2, ForumManageModel.g gVar) {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, gVar) == null) {
            d2 d2Var = this.y;
            if (d2Var != null && gVar != null && gVar.f57198a) {
                String str = "";
                boolean z = true;
                if (i2 == 2) {
                    d2Var.W3(1);
                    a0 a0Var = new a0();
                    a0Var.f14080a = 2;
                    a0Var.f14081b = this.y.s1();
                    if (c.a.r0.x0.j.e()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, a0Var));
                    } else {
                        str = P(gVar.f57199b, R.string.set_good_success);
                        z = false;
                    }
                } else {
                    if (i2 == 3) {
                        d2Var.W3(0);
                        str = P(gVar.f57199b, R.string.operation_success);
                    } else if (i2 == 4) {
                        d2Var.X3(1);
                        a0 a0Var2 = new a0();
                        a0Var2.f14080a = 1;
                        a0Var2.f14081b = this.y.s1();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, a0Var2));
                    } else if (i2 == 5) {
                        d2Var.X3(0);
                        str = P(gVar.f57199b, R.string.operation_success);
                    }
                    z = false;
                }
                ForumManageModel.e eVar = new ForumManageModel.e();
                eVar.f57186a = this.y.f0();
                eVar.f57188c = this.y.Z();
                eVar.f57187b = String.valueOf(this.y.T());
                eVar.f57189d = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
                if (TextUtils.isEmpty(str)) {
                    str = O(R.string.operation_success, new Object[0]);
                }
                if (z) {
                    return;
                }
                l.M(this.o, str);
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f57199b)) {
                O = gVar.f57199b;
            } else {
                O = O(R.string.operation_failed, new Object[0]);
            }
            l.M(this.o, O);
        }
    }

    public final View N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context = this.o;
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final String O(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, objArr)) == null) {
            Context context = this.o;
            if (context == null) {
                return null;
            }
            return context.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public final String P(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i2)) == null) ? !TextUtils.isEmpty(str) ? str : O(i2, new Object[0]) : (String) invokeLI.objValue;
    }

    public final void Q(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.y == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.y.T()).param("tid", this.y.f0()));
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.n == null || this.y == null) {
            return;
        }
        BawuThrones b2 = c.a.r0.x0.c.c().b();
        if (b2 == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (b2.total_recommend_num.intValue() == b2.used_recommend_num.intValue()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (c.a.q0.s.d0.b.j().g("key_frs_recommend_tip", true)) {
            c.a.r0.x0.c.c().f(this.n, String.valueOf(this.y.T()), this.y.f0());
        } else {
            c.a.r0.x0.c.c().d(String.valueOf(this.y.T()), this.y.f0());
        }
    }

    public final void S(ArrayList<m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) {
            if (this.t == null) {
                View inflate = LayoutInflater.from(this.o).inflate(R.layout.commit_good, (ViewGroup) null);
                Dialog dialog = new Dialog(this.o, R.style.common_alert_dialog);
                this.t = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.t.setCancelable(true);
                this.t.setContentView(inflate);
                WindowManager.LayoutParams attributes = this.t.getWindow().getAttributes();
                attributes.width = l.g(this.o, R.dimen.ds540);
                this.t.getWindow().setAttributes(attributes);
                inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new e(this));
                inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new f(this));
            }
            c.a.q0.w0.a.a(this.n, this.t.findViewById(R.id.commit_good_layout));
            LinearLayout linearLayout = (LinearLayout) this.t.findViewById(R.id.good_class_group);
            linearLayout.removeAllViews();
            this.x = new ArrayList();
            BlueCheckRadioButton K = K(this.v, O(R.string.thread_good_class, new Object[0]));
            K.setChecked(true);
            linearLayout.addView(K);
            this.x.add(K);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        BlueCheckRadioButton K2 = K(String.valueOf(m0Var.a()), m0Var.b());
                        this.x.add(K2);
                        View view = new View(this.o);
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(this.o, R.dimen.ds1)));
                        linearLayout.addView(view);
                        linearLayout.addView(K2);
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                    }
                }
                ScrollView scrollView = (ScrollView) this.t.findViewById(R.id.good_scroll);
                ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
                int size2 = arrayList.size();
                if (size2 == 0 || size2 == 1) {
                    layoutParams.height = l.e(this.o, 120.0f);
                } else if (size2 != 2) {
                    layoutParams.height = l.e(this.o, 220.0f);
                } else {
                    layoutParams.height = l.e(this.o, 186.0f);
                }
                scrollView.setLayoutParams(layoutParams);
                scrollView.removeAllViews();
                scrollView.addView(linearLayout);
            }
            c.a.e.e.m.g.j(this.t, this.n);
        }
    }

    public final void T(JSONArray jSONArray, boolean z) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, jSONArray, z) == null) || this.z == null || (d2Var = this.y) == null || d2Var.J() == null) {
            return;
        }
        String userId = this.y.J().getUserId();
        String f0 = this.y.f0();
        String Z = this.y.Z();
        String valueOf = String.valueOf(this.y.T());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            this.z.R(StringHelper.JsonArrayToString(jSONArray));
        }
        this.z.S(valueOf, Z, f0, null, 0, 1, isCurrentAccount, this.y.L(), z);
    }

    public final void U() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.o == null || (d2Var = this.y) == null || d2Var.J() == null) {
            return;
        }
        String userId = this.y.J().getUserId();
        String userName = this.y.J().getUserName();
        String name_show = this.y.J().getName_show();
        String f0 = this.y.f0();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.o, String.valueOf(this.y.T()), this.y.Z(), f0, userId, userName, name_show, null, this.y.J().getPortrait())));
    }

    public final void V(String str, boolean z) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) || (d2Var = this.y) == null || this.z == null) {
            return;
        }
        this.z.T(String.valueOf(this.y.T()), this.y.Z(), this.y.f0(), d2Var.q0() == 1 ? 3 : z ? 6 : 2, str);
    }

    public final void W() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (d2Var = this.y) == null || this.z == null) {
            return;
        }
        int i2 = d2Var.r0() == 1 ? 5 : 4;
        this.z.T(String.valueOf(this.y.T()), this.y.Z(), this.y.f0(), i2, null);
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            dismissAllDialog();
        }
    }

    public void dismissAllDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            dismissDeleteDialog();
            dismissBlockDialog();
            dismissGoodListDialog();
            dismiss();
        }
    }

    public void dismissBlockDialog() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (alertDialog = this.r) != null && alertDialog.isShowing()) {
            this.r.dismiss();
        }
    }

    public void dismissDeleteDialog() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (alertDialog = this.q) != null && alertDialog.isShowing()) {
            this.q.dismiss();
        }
    }

    public void dismissGoodListDialog() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (dialog = this.t) != null && dialog.isShowing()) {
            this.t.dismiss();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            c.a.q0.s.s.i iVar = this.p;
            if (iVar != null) {
                iVar.j();
            }
            c.a.q0.s.s.a aVar = this.s;
            if (aVar != null) {
                c.a.q0.w0.a.a(this.n, aVar.getRealView());
            }
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, d2Var) == null) {
            this.y = d2Var;
            L();
        }
    }

    public void showBlockMeDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            dismissBlockDialog();
            if (this.n == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.shield, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
            c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.n.getPageActivity());
            lVar.p(R.string.musk_my_thread_confirm);
            lVar.j(R.string.musk_my_thread_confirm_subtitle);
            lVar.l(true);
            lVar.o(aVar2, aVar);
            lVar.g(false);
            this.r = lVar.s();
            aVar.a(new c(this));
            aVar2.a(new d(this));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.y.f0());
            statisticItem.param("fid", this.y.T());
            statisticItem.param("fname", this.y.Z());
            TiebaStatic.log(statisticItem);
        }
    }

    public void showDeleteMeDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            dismissDeleteDialog();
            if (this.n == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.delete, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
            c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.n.getPageActivity());
            lVar.p(R.string.del_my_thread_confirm);
            lVar.j(R.string.del_my_thread_confirm_subtitle);
            lVar.l(true);
            lVar.o(aVar2, aVar);
            lVar.g(false);
            this.q = lVar.s();
            aVar.a(new a(this));
            aVar2.a(new b(this));
        }
    }
}
