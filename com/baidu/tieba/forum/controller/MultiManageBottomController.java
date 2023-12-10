package com.baidu.tieba.forum.controller;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ak7;
import com.baidu.tieba.ar6;
import com.baidu.tieba.br6;
import com.baidu.tieba.cg7;
import com.baidu.tieba.ci7;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.er6;
import com.baidu.tieba.f05;
import com.baidu.tieba.feed.data.ThreadManageType;
import com.baidu.tieba.forum.controller.MultiManageBottomController;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.management.ThreadManageDialog;
import com.baidu.tieba.forum.view.FrsMoveAreaChooseView;
import com.baidu.tieba.forum.view.FrsMultiDeleteBottomView;
import com.baidu.tieba.forum.view.FrsMultiMoveBottomView;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.g67;
import com.baidu.tieba.h87;
import com.baidu.tieba.i67;
import com.baidu.tieba.ii7;
import com.baidu.tieba.k16;
import com.baidu.tieba.k57;
import com.baidu.tieba.n16;
import com.baidu.tieba.nl7;
import com.baidu.tieba.o16;
import com.baidu.tieba.p77;
import com.baidu.tieba.r77;
import com.baidu.tieba.r87;
import com.baidu.tieba.s87;
import com.baidu.tieba.sb7;
import com.baidu.tieba.si7;
import com.baidu.tieba.t87;
import com.baidu.tieba.w57;
import com.baidu.tieba.wm7;
import com.baidu.tieba.xh7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\u00020\u0001:\u0001CB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00172\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0015H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0015H\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\u001f2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001bH\u0002J\u001a\u0010'\u001a\u0004\u0018\u00010\"2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001bH\u0002J\u0018\u0010(\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u0015H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\u0010\u0010/\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0015H\u0002J\b\u00100\u001a\u00020\fH\u0016J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u000203H\u0016J\u001a\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u0017H\u0016J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u000203H\u0002J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u000203H\u0002J \u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020@2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001bH\u0002J\b\u0010B\u001a\u00020\u0017H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/baidu/tieba/forum/controller/MultiManageBottomController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "deleteManager", "Lcom/baidu/tieba/NEGFeedBack/UEGDeleteThreadManager;", "deleteViewController", "Lcom/baidu/tieba/NEGFeedBack/UEGNewDeleteThreadViewController;", "inDeleteThreadMode", "", "moveChooseView", "Lcom/baidu/tieba/forum/view/FrsMoveAreaChooseView;", "multiDeleteBottomView", "Lcom/baidu/tieba/forum/view/FrsMultiDeleteBottomView;", "multiMoveBottomView", "Lcom/baidu/tieba/forum/view/FrsMultiMoveBottomView;", "selectedThreadSet", "", "Lcom/baidu/tieba/feed/data/event/ThreadEditSelectEvent;", "cancelEditMode", "", "checkSelectedSize", "doDeleteThreadInList", "successItems", "", "", "doMoveThreadInList", "findDeleteThreadItemData", "Lcom/baidu/tieba/feed/data/DeleteThreadItemData;", "event", "findMoveThreadItemData", "Lcom/baidu/tieba/feed/data/MoveThreadItemData;", "data", "findMultiDeleteThreadItemData", "manageItemList", "Lcom/baidu/tieba/feed/data/ThreadManageItemData;", "findMultiMoveThreadItemData", "findSocialMeta", "handleDeleteThread", "handleEditModeEvent", "inEditMode", "formDeleteThread", "handleForbiddenAndDeleteThread", "handleMoveThread", "handleSelectEvent", "onBackPressed", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", MissionEvent.MESSAGE_DESTROY, "requestMove", "toId", "showDeleteThreadPopupWindow", "deleteType", "showThreadManageDialog", "context", "Landroid/content/Context;", "manageList", "updateMultiBottomLayout", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MultiManageBottomController extends xh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public FrsMultiDeleteBottomView c;
    public FrsMultiMoveBottomView d;
    public final Set<t87> e;
    public boolean f;
    public final k16 g;
    public o16 h;
    public FrsMoveAreaChooseView i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(782704717, "Lcom/baidu/tieba/forum/controller/MultiManageBottomController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(782704717, "Lcom/baidu/tieba/forum/controller/MultiManageBottomController;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends er6<s87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiManageBottomController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MultiManageBottomController multiManageBottomController, Class<s87> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiManageBottomController, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = multiManageBottomController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(s87 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (!Intrinsics.areEqual(event.a(), this.b.J())) {
                    return;
                }
                this.b.L(event.c(), event.b());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends er6<t87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiManageBottomController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MultiManageBottomController multiManageBottomController, Class<t87> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiManageBottomController, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = multiManageBottomController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(t87 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event.b(), this.b.J())) {
                    this.b.R(event);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends er6<r87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiManageBottomController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MultiManageBottomController multiManageBottomController, Class<r87> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiManageBottomController, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = multiManageBottomController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(r87 event) {
            Long l;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (!Intrinsics.areEqual(event.a(), this.b.J())) {
                    return;
                }
                this.b.U(event.a(), event.b());
                si7 value = ((ForumViewModel) new ViewModelProvider(this.b.J()).get(ForumViewModel.class)).c().getValue();
                wm7.a aVar = wm7.a;
                String c = event.c();
                if (value != null) {
                    l = Long.valueOf(value.f());
                } else {
                    l = null;
                }
                aVar.a(c, String.valueOf(l));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements k16.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiManageBottomController a;

        public d(MultiManageBottomController multiManageBottomController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiManageBottomController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiManageBottomController;
        }

        public static final void b(f05 f05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, null, f05Var) == null) && f05Var != null) {
                f05Var.dismiss();
            }
        }

        public static final void c(f05 f05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65538, null, f05Var) == null) && f05Var != null) {
                f05Var.dismiss();
            }
        }

        @Override // com.baidu.tieba.k16.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            String string;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) != null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.a.A();
            o16 o16Var = this.a.h;
            if (o16Var != null) {
                o16Var.y();
                o16Var.x();
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                if (!TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText())) {
                    string = deleteThreadHttpResponseMessage.getText();
                } else {
                    string = this.a.J().getString(R.string.delete_fail);
                }
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    f05 f05Var = new f05(this.a.J());
                    f05Var.setMessage(string);
                    f05Var.setPositiveButton(R.string.dialog_known, new f05.e() { // from class: com.baidu.tieba.jh7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.f05.e
                        public final void onClick(f05 f05Var2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, f05Var2) == null) {
                                MultiManageBottomController.d.b(f05Var2);
                            }
                        }
                    });
                    f05Var.setCanceledOnTouchOutside(false);
                    if ((this.a.J() instanceof TbPageContextSupport) && ((TbPageContextSupport) this.a.J()).getPageContext() != null) {
                        f05Var.create(((TbPageContextSupport) this.a.J()).getPageContext());
                        f05Var.show();
                    }
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    f05 f05Var2 = new f05(this.a.J());
                    f05Var2.setMessage(string);
                    f05Var2.setPositiveButton(R.string.obfuscated_res_0x7f0f0b86, new f05.e() { // from class: com.baidu.tieba.uh7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.f05.e
                        public final void onClick(f05 f05Var3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, f05Var3) == null) {
                                MultiManageBottomController.d.c(f05Var3);
                            }
                        }
                    });
                    f05Var2.setCanceledOnTouchOutside(false);
                    if ((this.a.J() instanceof TbPageContextSupport) && ((TbPageContextSupport) this.a.J()).getPageContext() != null) {
                        f05Var2.create(((TbPageContextSupport) this.a.J()).getPageContext());
                        f05Var2.show();
                    }
                } else {
                    BdUtilHelper.showToast(this.a.J(), deleteThreadHttpResponseMessage.getText());
                }
                this.a.C(deleteThreadHttpResponseMessage.getSuccessItems());
                return;
            }
            BdUtilHelper.showToast(this.a.J(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiManageBottomController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MultiManageBottomController multiManageBottomController) {
            super(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiManageBottomController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiManageBottomController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                BdUtilHelper.showToast(this.a.J(), (int) R.string.obfuscated_res_0x7f0f086a);
                this.a.D();
            } else {
                BdUtilHelper.showToast(this.a.J(), httpResponsedMessage.getErrorString());
            }
            this.a.A();
        }
    }

    public MultiManageBottomController(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.e = new LinkedHashSet();
        this.f = true;
        this.g = new k16("0", f());
    }

    public final List<h87> I(t87 t87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t87Var)) == null) {
            if (t87Var.a() instanceof w57) {
                for (sb7<? extends Object> sb7Var : ((w57) t87Var.a()).c()) {
                    Object b2 = sb7Var.b();
                    if (b2 instanceof k57) {
                        return ((k57) b2).m().m;
                    }
                }
                return null;
            } else if (t87Var.a() instanceof cg7) {
                return ((cg7) t87Var.a()).l().e();
            } else {
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    public final void R(t87 t87Var) {
        boolean d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, t87Var) == null) {
            d2 = ii7.d(t87Var);
            boolean z = !d2;
            if (z) {
                if (this.f) {
                    if (this.e.size() >= 30) {
                        BdUtilHelper.showToast(this.b, (int) R.string.obfuscated_res_0x7f0f0872);
                        return;
                    }
                } else if (this.e.size() >= 30) {
                    BdUtilHelper.showToast(this.b, (int) R.string.obfuscated_res_0x7f0f0865);
                    return;
                }
                this.e.add(t87Var);
                ii7.e(t87Var, z);
            } else {
                this.e.remove(t87Var);
                ii7.e(t87Var, z);
            }
            V();
        }
    }

    public static final void O(FrsMoveAreaChooseView this_apply, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this_apply, view2) == null) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            this_apply.setVisibility(8);
        }
    }

    public static final void P(MultiManageBottomController this$0, r77 it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "it");
            FrsMoveAreaChooseView frsMoveAreaChooseView = this$0.i;
            if (frsMoveAreaChooseView != null) {
                this$0.S(frsMoveAreaChooseView.getMoveTabId());
            }
        }
    }

    public static final void Q(FrsMoveAreaChooseView this_apply, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this_apply, view2) == null) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            this_apply.setVisibility(8);
        }
    }

    public final void C(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && list != null) {
            br6.b().c(new ak7(this.b, list, 0));
        }
    }

    public final g67 E(t87 t87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t87Var)) == null) {
            return G(I(t87Var));
        }
        return (g67) invokeL.objValue;
    }

    public final p77 F(t87 t87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t87Var)) == null) {
            return H(I(t87Var));
        }
        return (p77) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xh7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            FrsMultiDeleteBottomView frsMultiDeleteBottomView = this.c;
            FrsMultiMoveBottomView frsMultiMoveBottomView = null;
            if (frsMultiDeleteBottomView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiDeleteBottomView");
                frsMultiDeleteBottomView = null;
            }
            frsMultiDeleteBottomView.a();
            FrsMultiMoveBottomView frsMultiMoveBottomView2 = this.d;
            if (frsMultiMoveBottomView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiMoveBottomView");
            } else {
                frsMultiMoveBottomView = frsMultiMoveBottomView2;
            }
            frsMultiMoveBottomView.a();
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            br6.b().c(new s87(this.b, false, false, 4, null));
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.e.size() > 0) {
                return false;
            }
            BdUtilHelper.showToast(this.b, (int) R.string.obfuscated_res_0x7f0f0873);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final FragmentActivity J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            wm7.a.c();
            if (B()) {
                return;
            }
            T(1);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            wm7.a.d();
            if (B()) {
                return;
            }
            T(2);
        }
    }

    @Override // com.baidu.tieba.xh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.l();
            this.g.f(null);
            this.g.d();
        }
    }

    public final void D() {
        String f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ForumTabItem B = ci7.m(this.b).B();
            boolean z = true;
            if ((B == null || !B.isGeneralTab()) ? false : false) {
                ArrayList arrayList = new ArrayList();
                for (t87 t87Var : this.e) {
                    f = ii7.f(t87Var);
                    if (f != null) {
                        arrayList.add(f);
                    }
                }
                C(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.xh7
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            FrsMoveAreaChooseView frsMoveAreaChooseView = this.i;
            boolean z = false;
            if (frsMoveAreaChooseView != null && frsMoveAreaChooseView.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.i;
                if (frsMoveAreaChooseView2 != null) {
                    frsMoveAreaChooseView2.setVisibility(8);
                }
                return true;
            } else if (Intrinsics.areEqual(((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).h().getValue(), Boolean.TRUE)) {
                A();
                return true;
            } else {
                return super.h();
            }
        }
        return invokeV.booleanValue;
    }

    public final g67 G(List<h87> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null) {
                return null;
            }
            for (h87 h87Var : list) {
                if (h87Var.c() == ThreadManageType.ID_MULTI_DEL.getValue()) {
                    Object a2 = h87Var.a();
                    if (!(a2 instanceof g67)) {
                        return null;
                    }
                    return (g67) a2;
                }
            }
            return null;
        }
        return (g67) invokeL.objValue;
    }

    public final p77 H(List<h87> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            if (list == null) {
                return null;
            }
            for (h87 h87Var : list) {
                if (h87Var.c() == ThreadManageType.ID_MOVE_AREA.getValue()) {
                    Object a2 = h87Var.a();
                    if (!(a2 instanceof p77)) {
                        return null;
                    }
                    return (p77) a2;
                }
            }
            return null;
        }
        return (p77) invokeL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v14, types: [com.baidu.tieba.forum.view.FrsMultiDeleteBottomView] */
    public final void L(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f = z2;
            FrsMultiMoveBottomView frsMultiMoveBottomView = null;
            if (z) {
                if (z2) {
                    ?? r6 = this.c;
                    if (r6 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("multiDeleteBottomView");
                    } else {
                        frsMultiMoveBottomView = r6;
                    }
                    frsMultiMoveBottomView.setVisibility(0);
                } else {
                    FrsMultiMoveBottomView frsMultiMoveBottomView2 = this.d;
                    if (frsMultiMoveBottomView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("multiMoveBottomView");
                    } else {
                        frsMultiMoveBottomView = frsMultiMoveBottomView2;
                    }
                    frsMultiMoveBottomView.setVisibility(0);
                }
            } else {
                FrsMultiDeleteBottomView frsMultiDeleteBottomView = this.c;
                if (frsMultiDeleteBottomView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("multiDeleteBottomView");
                    frsMultiDeleteBottomView = null;
                }
                frsMultiDeleteBottomView.setVisibility(8);
                FrsMultiMoveBottomView frsMultiMoveBottomView3 = this.d;
                if (frsMultiMoveBottomView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("multiMoveBottomView");
                    frsMultiMoveBottomView3 = null;
                }
                frsMultiMoveBottomView3.setVisibility(8);
                FrsMultiDeleteBottomView frsMultiDeleteBottomView2 = this.c;
                if (frsMultiDeleteBottomView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("multiDeleteBottomView");
                    frsMultiDeleteBottomView2 = null;
                }
                frsMultiDeleteBottomView2.setSelectNumber(0);
                FrsMultiMoveBottomView frsMultiMoveBottomView4 = this.d;
                if (frsMultiMoveBottomView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("multiMoveBottomView");
                } else {
                    frsMultiMoveBottomView = frsMultiMoveBottomView4;
                }
                frsMultiMoveBottomView.setSelectNumber(0);
            }
            this.e.clear();
            FrsMoveAreaChooseView frsMoveAreaChooseView = this.i;
            if (frsMoveAreaChooseView != null) {
                frsMoveAreaChooseView.setVisibility(8);
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || B()) {
            return;
        }
        FragmentActivity fragmentActivity = this.b;
        if (fragmentActivity instanceof TbPageContextSupport) {
            TbPageContext pageContext = ((TbPageContextSupport) fragmentActivity).getPageContext();
            if (this.i == null) {
                final FrsMoveAreaChooseView frsMoveAreaChooseView = new FrsMoveAreaChooseView(pageContext);
                frsMoveAreaChooseView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.eh7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            MultiManageBottomController.O(FrsMoveAreaChooseView.this, view2);
                        }
                    }
                });
                FrsMultiMoveBottomView frsMultiMoveBottomView = this.d;
                if (frsMultiMoveBottomView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("multiMoveBottomView");
                    frsMultiMoveBottomView = null;
                }
                ViewParent parent = frsMultiMoveBottomView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).addView(frsMoveAreaChooseView, -1, -1);
                    frsMoveAreaChooseView.setDoneListener(new FrsMoveAreaChooseView.a() { // from class: com.baidu.tieba.th7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.forum.view.FrsMoveAreaChooseView.a
                        public final void a(r77 r77Var) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, r77Var) == null) {
                                MultiManageBottomController.P(MultiManageBottomController.this, r77Var);
                            }
                        }
                    });
                    frsMoveAreaChooseView.setCancelListener(new View.OnClickListener() { // from class: com.baidu.tieba.eg7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                MultiManageBottomController.Q(FrsMoveAreaChooseView.this, view2);
                            }
                        }
                    });
                    this.i = frsMoveAreaChooseView;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            p77 F = F((t87) CollectionsKt___CollectionsKt.last(this.e));
            if (F == null) {
                return;
            }
            FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.i;
            if (frsMoveAreaChooseView2 != null) {
                frsMoveAreaChooseView2.setData(F.d(), F.b(), F.c());
            }
            FrsMoveAreaChooseView frsMoveAreaChooseView3 = this.i;
            if (frsMoveAreaChooseView3 != null) {
                frsMoveAreaChooseView3.setVisibility(0);
            }
        }
    }

    public final void S(int i) {
        Object obj;
        String f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            try {
                si7 value = ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().getValue();
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
                JSONArray jSONArray = new JSONArray();
                Iterator<t87> it = this.e.iterator();
                while (true) {
                    obj = "";
                    if (!it.hasNext()) {
                        break;
                    }
                    JSONObject jSONObject = new JSONObject();
                    f = ii7.f(it.next());
                    if (f != null) {
                        obj = f;
                    }
                    jSONObject.put("thread_id", obj);
                    jSONObject.put("to_tab_id", i);
                    jSONArray.put(jSONObject);
                }
                httpMessage.addParam("threads", jSONArray.toString());
                if (value != null) {
                    obj = Long.valueOf(value.f());
                }
                httpMessage.addParam("forum_id", obj);
                httpMessage.setTag(f());
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void T(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (this.b instanceof TbPageContextSupport) && this.e.size() > 0) {
            TbPageContext pageContext = ((TbPageContextSupport) this.b).getPageContext();
            g67 E = E((t87) CollectionsKt___CollectionsKt.last(this.e));
            if (E == null) {
                return;
            }
            n16 k = nl7.k(E);
            UserData l = nl7.l(E);
            SparseArray<String> sparseArray = new SparseArray<>();
            for (i67 i67Var : E.f()) {
                sparseArray.put(i67Var.a(), i67Var.b());
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (t87 t87Var : this.e) {
                g67 E2 = E(t87Var);
                if (E2 != null) {
                    jSONArray.put(E2.g());
                    jSONArray2.put(E2.e());
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            negativeFeedBackData.setDeleteType(i);
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(E.b());
            String string = this.b.getString(R.string.delete_thread_reason_1);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…g.delete_thread_reason_1)");
            String string2 = this.b.getString(R.string.delete_thread_reason_2);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…g.delete_thread_reason_2)");
            String string3 = this.b.getString(R.string.delete_thread_reason_3);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(R.str…g.delete_thread_reason_3)");
            String string4 = this.b.getString(R.string.delete_thread_reason_4);
            Intrinsics.checkNotNullExpressionValue(string4, "activity.getString(R.str…g.delete_thread_reason_4)");
            String string5 = this.b.getString(R.string.delete_thread_reason_5);
            Intrinsics.checkNotNullExpressionValue(string5, "activity.getString(R.str…g.delete_thread_reason_5)");
            String[] strArr = {string, string2, string3, string4, string5};
            o16 o16Var = this.h;
            if (o16Var != null) {
                o16Var.x();
                o16Var.y();
            }
            FrsMultiDeleteBottomView frsMultiDeleteBottomView = this.c;
            if (frsMultiDeleteBottomView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiDeleteBottomView");
                frsMultiDeleteBottomView = null;
            }
            o16 o16Var2 = new o16(pageContext, frsMultiDeleteBottomView, k, l, f());
            o16Var2.G(false);
            o16Var2.I(strArr);
            o16Var2.H(negativeFeedBackData);
            o16Var2.K("2");
            this.h = o16Var2;
        }
    }

    public final void U(Context context, List<h87> list) {
        TbPageContext tbPageContext;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, list) == null) {
            if (context instanceof TbPageContextSupport) {
                tbPageContext = ((TbPageContextSupport) context).getPageContext();
            } else {
                tbPageContext = null;
            }
            if (tbPageContext != null) {
                if (list != null && !list.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    new ThreadManageDialog(tbPageContext, list).l();
                }
            }
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            FrsMultiMoveBottomView frsMultiMoveBottomView = null;
            FrsMultiDeleteBottomView frsMultiDeleteBottomView = null;
            if (this.f) {
                FrsMultiDeleteBottomView frsMultiDeleteBottomView2 = this.c;
                if (frsMultiDeleteBottomView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("multiDeleteBottomView");
                } else {
                    frsMultiDeleteBottomView = frsMultiDeleteBottomView2;
                }
                frsMultiDeleteBottomView.setSelectNumber(this.e.size());
                return;
            }
            FrsMultiMoveBottomView frsMultiMoveBottomView2 = this.d;
            if (frsMultiMoveBottomView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiMoveBottomView");
            } else {
                frsMultiMoveBottomView = frsMultiMoveBottomView2;
            }
            frsMultiMoveBottomView.setSelectNumber(this.e.size());
        }
    }

    @Override // com.baidu.tieba.xh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            FrsMultiDeleteBottomView frsMultiDeleteBottomView = binding.n;
            Intrinsics.checkNotNullExpressionValue(frsMultiDeleteBottomView, "binding.multiMultiDeleteBottomLayout");
            this.c = frsMultiDeleteBottomView;
            FrsMultiMoveBottomView frsMultiMoveBottomView = binding.o;
            Intrinsics.checkNotNullExpressionValue(frsMultiMoveBottomView, "binding.multiMultiMoveBottomLayout");
            this.d = frsMultiMoveBottomView;
            br6.b().b(new ar6(f(), Reflection.getOrCreateKotlinClass(s87.class)), new a(this, s87.class));
            br6.b().b(new ar6(f(), Reflection.getOrCreateKotlinClass(t87.class)), new b(this, t87.class));
            br6.b().b(new ar6(f(), Reflection.getOrCreateKotlinClass(r87.class)), new c(this, r87.class));
            FrsMultiDeleteBottomView frsMultiDeleteBottomView2 = this.c;
            FrsMultiMoveBottomView frsMultiMoveBottomView2 = null;
            if (frsMultiDeleteBottomView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiDeleteBottomView");
                frsMultiDeleteBottomView2 = null;
            }
            frsMultiDeleteBottomView2.setCancelBtnClickListener(new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.controller.MultiManageBottomController$onCreate$4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiManageBottomController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.this$0.A();
                }
            });
            FrsMultiDeleteBottomView frsMultiDeleteBottomView3 = this.c;
            if (frsMultiDeleteBottomView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiDeleteBottomView");
                frsMultiDeleteBottomView3 = null;
            }
            frsMultiDeleteBottomView3.setDelBtnClickListener(new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.controller.MultiManageBottomController$onCreate$5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiManageBottomController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.this$0.K();
                }
            });
            FrsMultiDeleteBottomView frsMultiDeleteBottomView4 = this.c;
            if (frsMultiDeleteBottomView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiDeleteBottomView");
                frsMultiDeleteBottomView4 = null;
            }
            frsMultiDeleteBottomView4.setForbiddenBtnClickListener(new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.controller.MultiManageBottomController$onCreate$6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiManageBottomController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.this$0.M();
                }
            });
            FrsMultiMoveBottomView frsMultiMoveBottomView3 = this.d;
            if (frsMultiMoveBottomView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiMoveBottomView");
                frsMultiMoveBottomView3 = null;
            }
            frsMultiMoveBottomView3.setCancelBtnClickListener(new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.controller.MultiManageBottomController$onCreate$7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiManageBottomController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.this$0.A();
                }
            });
            FrsMultiMoveBottomView frsMultiMoveBottomView4 = this.d;
            if (frsMultiMoveBottomView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiMoveBottomView");
            } else {
                frsMultiMoveBottomView2 = frsMultiMoveBottomView4;
            }
            frsMultiMoveBottomView2.setDelBtnClickListener(new Function0<Unit>(this) { // from class: com.baidu.tieba.forum.controller.MultiManageBottomController$onCreate$8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiManageBottomController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.this$0.N();
                }
            });
            this.g.e();
            this.g.f(new d(this));
            e eVar = new e(this);
            eVar.setTag(f());
            o(eVar);
        }
    }
}
