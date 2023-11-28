package com.baidu.tieba.forum.management;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.c67;
import com.baidu.tieba.d87;
import com.baidu.tieba.dk7;
import com.baidu.tieba.do7;
import com.baidu.tieba.f87;
import com.baidu.tieba.feed.data.ThreadManageType;
import com.baidu.tieba.fl7;
import com.baidu.tieba.forum.management.ThreadManageDialog;
import com.baidu.tieba.gx4;
import com.baidu.tieba.i05;
import com.baidu.tieba.il7;
import com.baidu.tieba.jl7;
import com.baidu.tieba.k05;
import com.baidu.tieba.l77;
import com.baidu.tieba.m05;
import com.baidu.tieba.m57;
import com.baidu.tieba.o57;
import com.baidu.tieba.o87;
import com.baidu.tieba.rm7;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tj7;
import com.baidu.tieba.tx4;
import com.baidu.tieba.u67;
import com.baidu.tieba.u77;
import com.baidu.tieba.vj7;
import com.baidu.tieba.w4;
import com.baidu.tieba.x67;
import com.baidu.tieba.xq6;
import com.baidu.tieba.zq6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010)\u001a\u00020 H\u0002J\u0018\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020#H\u0002J)\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020,2\u0012\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020#01\"\u00020#H\u0002¢\u0006\u0002\u00102J\u001a\u00103\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u00112\u0006\u00104\u001a\u00020,H\u0002J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000208H\u0002J\u0006\u00109\u001a\u00020 J\u0010\u0010:\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010?\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J\"\u0010@\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u001d\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u001c\u0012\u0004\u0012\u00020 0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/baidu/tieba/forum/management/ThreadManageDialog;", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "manageItemList", "", "Lcom/baidu/tieba/feed/data/ThreadManageItemData;", "(Lcom/baidu/tbadk/TbPageContext;Ljava/util/List;)V", "mCommitGoodListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mContext", "Landroid/app/Activity;", "mCurGoodThreadItemData", "Lcom/baidu/tieba/feed/data/GoodThreadItemData;", "mCurTopThreadItemData", "Lcom/baidu/tieba/feed/data/TopThreadItemData;", "mCurrentClassId", "", "mDialogItemList", "", "Lcom/baidu/tbadk/core/dialog/DefaultPopupDialogItem;", "mDialogView", "Lcom/baidu/tbadk/core/dialog/PopupDialogView;", "mForumManageModel", "Lcom/baidu/tieba/tbadkCore/model/ForumManageModel;", "mPopUpRadioButtons", "Ljava/util/ArrayList;", "Lcom/baidu/tbadk/core/view/BlueCheckRadioButton;", "Lkotlin/collections/ArrayList;", "showGoodClassListDialog", "Lkotlin/Function1;", "Lcom/baidu/tbadk/core/data/GoodData;", "", "changeSendBroadcast", "extData", "", "changeToMoveAreaMode", "changeToMultiDelMode", "createRadioButton", "tag", "text", "createView", "finishTopGoodTask", "type", "", "result", "getString", "resId", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getToastText", "defaultResId", "initForumManageCallBack", "Lcom/baidu/adp/base/BdLoadDataCallBack;", "initItemClickListener", "Lcom/baidu/tbadk/core/dialog/PopupDialogView$OnItemClickListener;", "onChangeSkinType", "recommendThread", "startDelPostAsyncTask", "deleteThreadItemData", "Lcom/baidu/tieba/feed/data/DeleteThreadItemData;", "startDeleteThread", "startForbidTask", "startGoodAsyncTask", "commitGoodId", "isGoodList", "", "startTopAsyncTask", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ThreadManageDialog extends k05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> l;
    public final List<d87> m;
    public final Activity n;
    public final m05 o;
    public final List<i05> p;
    public final ForumManageModel q;
    public String r;
    public x67 s;
    public ArrayList<BlueCheckRadioButton> t;
    public f87 u;
    public final Function1<ArrayList<tx4>, Unit> v;
    public final CompoundButton.OnCheckedChangeListener w;

    /* loaded from: classes6.dex */
    public static final class a extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadManageDialog a;

        public a(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadManageDialog;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || obj == null) {
                return;
            }
            switch (this.a.q.getLoadDataMode()) {
                case 0:
                    jl7.b(obj, this.a.n);
                    return;
                case 1:
                    jl7.c(obj, this.a.n);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    ThreadManageDialog threadManageDialog = this.a;
                    threadManageDialog.M(threadManageDialog.q.getLoadDataMode(), obj);
                    return;
                case 6:
                    jl7.d(obj, this.a.n, this.a.v);
                    return;
                default:
                    do7.b(null, 1, null);
                    return;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements m05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadManageDialog a;

        public b(ThreadManageDialog threadManageDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadManageDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadManageDialog;
        }

        @Override // com.baidu.tieba.m05.f
        public void E0(m05 m05Var, int i, View view2) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, m05Var, i, view2) == null) {
                this.a.dismiss();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(this.a.n, (int) R.string.network_not_available);
                    return;
                }
                if (view2 != null) {
                    obj = view2.getTag(R.id.item_data);
                } else {
                    obj = null;
                }
                if (obj == null) {
                    do7.a("ThreadManageItemData extData must not be null！！！");
                } else if (i == ThreadManageType.ID_DEL.getValue()) {
                    this.a.U(obj);
                } else if (i == ThreadManageType.ID_FORBID.getValue()) {
                    this.a.V(obj);
                } else if (i == ThreadManageType.ID_TOP.getValue()) {
                    this.a.X(obj);
                } else if (i == ThreadManageType.ID_GOOD.getValue()) {
                    ThreadManageDialog threadManageDialog = this.a;
                    threadManageDialog.W(obj, threadManageDialog.r, true);
                } else if (i == ThreadManageType.ID_MULTI_DEL.getValue()) {
                    this.a.J(obj);
                } else if (i == ThreadManageType.ID_RECOMMEND.getValue()) {
                    this.a.S(obj);
                } else if (i == ThreadManageType.ID_MOVE_AREA.getValue()) {
                    this.a.I(obj);
                } else if (i == ThreadManageType.ID_BROADCAST.getValue()) {
                    this.a.H(obj);
                } else {
                    do7.b(null, 1, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadManageDialog(TbPageContext<?> pageContext, List<d87> manageItemList) {
        super(pageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, manageItemList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(manageItemList, "manageItemList");
        this.l = pageContext;
        this.m = manageItemList;
        Activity pageActivity = pageContext.getPageActivity();
        Intrinsics.checkNotNullExpressionValue(pageActivity, "pageContext.pageActivity");
        this.n = pageActivity;
        this.r = "0";
        this.p = new ArrayList();
        m05 m05Var = new m05(this.n);
        this.o = m05Var;
        m05Var.u(N(R.string.thread_manager, new Object[0]));
        this.o.r(Q());
        ForumManageModel forumManageModel = new ForumManageModel(this.l);
        this.q = forumManageModel;
        forumManageModel.isNewFrs = 1;
        forumManageModel.setLoadDataCallBack(P());
        h(this.o);
        L();
        this.v = new ThreadManageDialog$showGoodClassListDialog$1(this);
        this.w = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.yk7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                    ThreadManageDialog.R(ThreadManageDialog.this, compoundButton, z);
                }
            }
        };
    }

    public final String N(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, objArr)) == null) {
            String string = this.n.getString(i, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(resId, *formatArgs)");
            return string;
        }
        return (String) invokeIL.objValue;
    }

    public final String O(String str, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return N(i, new Object[0]);
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public static final void R(ThreadManageDialog this$0, CompoundButton compoundButton, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, this$0, compoundButton, z) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z && (compoundButton.getTag() instanceof String)) {
                Object tag = compoundButton.getTag();
                if (tag != null) {
                    this$0.r = (String) tag;
                    ArrayList<BlueCheckRadioButton> arrayList = this$0.t;
                    if (arrayList != null) {
                        Intrinsics.checkNotNull(arrayList);
                        Iterator<BlueCheckRadioButton> it = arrayList.iterator();
                        while (it.hasNext()) {
                            BlueCheckRadioButton next = it.next();
                            Object tag2 = next.getTag();
                            if (tag2 != null) {
                                if (!Intrinsics.areEqual((String) tag2, this$0.r)) {
                                    next.setChecked(false);
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        }
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
    }

    public final void T(c67 c67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, c67Var) == null) {
            String h = c67Var.h();
            String g = c67Var.g();
            String c = c67Var.c();
            this.q.k0(c67Var.b(), c, g, null, 0, 1, UtilHelper.isCurrentAccount(h), null, false);
        }
    }

    public final void H(Object obj) {
        o57 o57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            if (obj instanceof o57) {
                o57Var = (o57) obj;
            } else {
                o57Var = null;
            }
            if (o57Var == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("forum_id", o57Var.a());
            httpMessage.addParam("thread_id", o57Var.b());
            this.l.sendMessage(httpMessage);
        }
    }

    public final void I(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            if (obj instanceof l77) {
                l77 l77Var = (l77) obj;
                rm7.a.b(l77Var.e(), l77Var.a(), 7);
            }
            xq6.b().c(new o87(this.n, true, false));
        }
    }

    public final void J(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            if (obj instanceof c67) {
                c67 c67Var = (c67) obj;
                rm7.a.b(c67Var.g(), c67Var.b(), 5);
            }
            xq6.b().c(new o87(this.n, true, false, 4, null));
        }
    }

    public final BlueCheckRadioButton K(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.n);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, BdUtilHelper.getDimens(this.n, R.dimen.obfuscated_res_0x7f07019a));
            blueCheckRadioButton.setOnCheckedChangeListener(this.w);
            blueCheckRadioButton.setTag(str);
            blueCheckRadioButton.setText(str2);
            blueCheckRadioButton.setLayoutParams(layoutParams);
            return blueCheckRadioButton;
        }
        return (BlueCheckRadioButton) invokeLL.objValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p.clear();
            for (d87 d87Var : this.m) {
                this.p.add(new i05(d87Var.c(), d87Var.b(), d87Var.a(), this.o));
            }
            this.o.m(this.p);
        }
    }

    public final void M(int i, Object obj) {
        ForumManageModel.g gVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, obj) == null) {
            if (obj instanceof ForumManageModel.g) {
                gVar = (ForumManageModel.g) obj;
            } else {
                gVar = null;
            }
            if (gVar == null) {
                return;
            }
            if (gVar.a) {
                String str = "";
                boolean z5 = true;
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                f87 f87Var = this.u;
                                if (f87Var != null) {
                                    f87Var.g(false);
                                }
                                str = O(gVar.b, R.string.operation_success);
                            }
                        } else {
                            gx4 gx4Var = new gx4();
                            gx4Var.a = 1;
                            gx4Var.b = gVar.f;
                            String str2 = gVar.i;
                            if (str2 != null && str2.length() != 0) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            if (z3) {
                                f87 f87Var2 = this.u;
                                if (f87Var2 != null) {
                                    f87Var2.g(true);
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, gx4Var));
                            } else {
                                if (((ForumManageModel.g) obj).h < 0) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                f87 f87Var3 = this.u;
                                if (f87Var3 != null) {
                                    f87Var3.g(z4);
                                }
                                Activity activity = this.n;
                                int i2 = gVar.h;
                                String str3 = gVar.i;
                                Intrinsics.checkNotNullExpressionValue(str3, "retData.topScheme");
                                il7.i(activity, i2, str3, gVar.d);
                                z5 = z4;
                            }
                            z2 = true;
                        }
                    } else {
                        x67 x67Var = this.s;
                        if (x67Var != null) {
                            x67Var.h(false);
                        }
                        str = O(gVar.b, R.string.operation_success);
                        zq6 b2 = xq6.b();
                        String str4 = gVar.d;
                        Intrinsics.checkNotNullExpressionValue(str4, "retData.mForumId");
                        String str5 = gVar.g;
                        Intrinsics.checkNotNullExpressionValue(str5, "retData.mCommitGoodId");
                        b2.c(new tj7(str4, str5, false));
                    }
                    z2 = false;
                } else {
                    x67 x67Var2 = this.s;
                    if (x67Var2 != null) {
                        x67Var2.h(true);
                    }
                    gx4 gx4Var2 = new gx4();
                    gx4Var2.a = 2;
                    x67 x67Var3 = this.s;
                    if (x67Var3 != null && x67Var3.f()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, gx4Var2));
                        z2 = true;
                    } else {
                        str = O(gVar.b, R.string.set_good_success);
                        z2 = false;
                    }
                    zq6 b3 = xq6.b();
                    String str6 = gVar.d;
                    Intrinsics.checkNotNullExpressionValue(str6, "retData.mForumId");
                    String str7 = gVar.g;
                    Intrinsics.checkNotNullExpressionValue(str7, "retData.mCommitGoodId");
                    b3.c(new tj7(str6, str7, true));
                }
                ForumManageModel.e eVar = new ForumManageModel.e();
                eVar.a = gVar.f;
                eVar.c = gVar.e;
                eVar.b = gVar.d;
                eVar.d = i;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
                if (z5) {
                    xq6.b().c(new vj7(this.n, CollectionsKt__CollectionsJVMKt.listOf(gVar.f), i));
                }
                if (TextUtils.isEmpty(str)) {
                    str = N(R.string.operation_success, new Object[0]);
                }
                if (!z2) {
                    BdUtilHelper.showToast(this.n, str);
                    return;
                }
                return;
            }
            BdUtilHelper.showToast(this.n, O(gVar.b, R.string.operation_failed));
        }
    }

    public final w4 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new a(this);
        }
        return (w4) invokeV.objValue;
    }

    public final m05.f Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return new b(this);
        }
        return (m05.f) invokeV.objValue;
    }

    public final void S(Object obj) {
        u77 u77Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, obj) == null) {
            dk7.a();
            if (obj instanceof u77) {
                u77Var = (u77) obj;
            } else {
                u77Var = null;
            }
            if (u77Var == null) {
                return;
            }
            u77 u77Var2 = (u77) obj;
            rm7.a.b(u77Var2.c(), u77Var2.b(), 6);
            m57 a2 = u77Var.a();
            if (a2 == null) {
                fl7.a(this.l.getUniqueId());
            } else if (a2.b() <= a2.c()) {
                fl7.a(this.l.getUniqueId());
            } else if (SharedPrefHelper.getInstance().getBoolean("key_frs_recommend_tip", true)) {
                fl7.d(this.l, u77Var.b(), u77Var.c(), a2, ThreadManageDialog$recommendThread$1.INSTANCE);
            } else {
                fl7.b(u77Var.b(), u77Var.c(), this.l.getUniqueId());
            }
        }
    }

    public final void U(Object obj) {
        final c67 c67Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, obj) == null) {
            if (obj instanceof c67) {
                c67Var = (c67) obj;
            } else {
                c67Var = null;
            }
            if (c67Var == null) {
                return;
            }
            c67 c67Var2 = (c67) obj;
            rm7.a.b(c67Var2.g(), c67Var2.b(), 1);
            if (UtilHelper.isCurrentAccount(c67Var.h())) {
                il7.d(this.n, new Function0<Unit>(this, c67Var) { // from class: com.baidu.tieba.forum.management.ThreadManageDialog$startDeleteThread$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ c67 $deleteThreadItemData;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ThreadManageDialog this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, c67Var};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$deleteThreadItemData = c67Var;
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.this$0.T(this.$deleteThreadItemData);
                        }
                    }
                });
            } else {
                il7.f(this.l, this.q, c67Var);
            }
        }
    }

    public final void V(Object obj) {
        u67 u67Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            if (obj instanceof u67) {
                u67Var = (u67) obj;
            } else {
                u67Var = null;
            }
            if (u67Var == null) {
                return;
            }
            String c = u67Var.c();
            String f = u67Var.f();
            String d = u67Var.d();
            String e = u67Var.e();
            String b2 = u67Var.b();
            String a2 = u67Var.a();
            String g = u67Var.g();
            rm7.a.b(e, a2, 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.n, a2, b2, e, c, f, d, null, g)));
        }
    }

    public final void X(Object obj) {
        f87 f87Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, obj) == null) {
            if (obj instanceof f87) {
                f87Var = (f87) obj;
            } else {
                f87Var = null;
            }
            if (f87Var == null) {
                return;
            }
            f87 f87Var2 = (f87) obj;
            rm7.a.b(f87Var2.e(), f87Var2.b(), 3);
            this.u = f87Var;
            if (f87Var.f()) {
                i = 5;
            } else {
                i = 4;
            }
            String e = f87Var.e();
            String c = f87Var.c();
            this.q.l0(f87Var.b(), c, e, i, null);
        }
    }

    public final void W(Object obj, String str, boolean z) {
        x67 x67Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, obj, str, z) == null) {
            if (obj instanceof x67) {
                x67Var = (x67) obj;
            } else {
                x67Var = null;
            }
            if (x67Var == null) {
                return;
            }
            x67 x67Var2 = (x67) obj;
            rm7.a.b(x67Var2.e(), x67Var2.b(), 4);
            this.s = x67Var;
            if (x67Var.g()) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String e = x67Var.e();
            String c = x67Var.c();
            this.q.l0(x67Var.b(), c, e, i, str);
        }
    }
}
