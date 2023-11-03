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
import com.baidu.tieba.a87;
import com.baidu.tieba.b16;
import com.baidu.tieba.b87;
import com.baidu.tieba.c16;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.e57;
import com.baidu.tieba.feed.data.ThreadManageType;
import com.baidu.tieba.fi7;
import com.baidu.tieba.forum.controller.MultiManageBottomController;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.management.ThreadManageDialog;
import com.baidu.tieba.forum.view.FrsMoveAreaChooseView;
import com.baidu.tieba.forum.view.FrsMultiDeleteBottomView;
import com.baidu.tieba.forum.view.FrsMultiMoveBottomView;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.gh7;
import com.baidu.tieba.k77;
import com.baidu.tieba.lq6;
import com.baidu.tieba.mq6;
import com.baidu.tieba.o57;
import com.baidu.tieba.og7;
import com.baidu.tieba.p77;
import com.baidu.tieba.pj7;
import com.baidu.tieba.pq6;
import com.baidu.tieba.q57;
import com.baidu.tieba.s47;
import com.baidu.tieba.tg7;
import com.baidu.tieba.x67;
import com.baidu.tieba.y06;
import com.baidu.tieba.z67;
import com.baidu.tieba.z77;
import com.baidu.tieba.za7;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00172\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J\u0016\u0010!\u001a\u0004\u0018\u00010\"2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0014\u0010&\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0016\u0010'\u001a\u0004\u0018\u00010%2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\u0018\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\fH\u0016J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0016J\u001a\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u0017H\u0016J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u000204H\u0002J\u0010\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u000204H\u0002J\u0018\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020A2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010B\u001a\u00020\u0017H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/baidu/tieba/forum/controller/MultiManageBottomController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "deleteManager", "Lcom/baidu/tieba/NEGFeedBack/UEGDeleteThreadManager;", "deleteViewController", "Lcom/baidu/tieba/NEGFeedBack/UEGNewDeleteThreadViewController;", "inDeleteThreadMode", "", "moveChooseView", "Lcom/baidu/tieba/forum/view/FrsMoveAreaChooseView;", "multiDeleteBottomView", "Lcom/baidu/tieba/forum/view/FrsMultiDeleteBottomView;", "multiMoveBottomView", "Lcom/baidu/tieba/forum/view/FrsMultiMoveBottomView;", "selectedThreadSet", "", "Lcom/baidu/tieba/feed/data/CardData;", "cancelEditMode", "", "checkSelectedSize", "doDeleteThreadInList", "successItems", "", "", "doMoveThreadInList", "findDeleteThreadItemData", "Lcom/baidu/tieba/feed/data/DeleteThreadItemData;", "cardData", "findMoveThreadItemData", "Lcom/baidu/tieba/feed/data/MoveThreadItemData;", "findMultiDeleteThreadItemData", "socialMeta", "Lcom/baidu/tieba/feed/data/SocialMeta;", "findMultiMoveThreadItemData", "findSocialMeta", "handleDeleteThread", "handleEditModeEvent", "inEditMode", "formDeleteThread", "handleForbiddenAndDeleteThread", "handleMoveThread", "handleSelectEvent", "event", "Lcom/baidu/tieba/feed/data/event/ThreadEditSelectEvent;", "onBackPressed", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", MissionEvent.MESSAGE_DESTROY, "requestMove", "toId", "showDeleteThreadPopupWindow", "deleteType", "showThreadManageDialog", "context", "Landroid/content/Context;", "updateMultiBottomLayout", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MultiManageBottomController extends og7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public FrsMultiDeleteBottomView c;
    public FrsMultiMoveBottomView d;
    public final Set<e57<?>> e;
    public boolean f;
    public final y06 g;
    public c16 h;
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
    public static final class a extends pq6<a87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiManageBottomController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MultiManageBottomController multiManageBottomController, Class<a87> cls) {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(a87 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (!Intrinsics.areEqual(event.a(), this.b.I())) {
                    return;
                }
                this.b.K(event.c(), event.b());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends pq6<b87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiManageBottomController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MultiManageBottomController multiManageBottomController, Class<b87> cls) {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(b87 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event.b(), this.b.I())) {
                    this.b.Q(event);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends pq6<z77> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiManageBottomController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MultiManageBottomController multiManageBottomController, Class<z77> cls) {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(z77 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (!Intrinsics.areEqual(event.a(), this.b.I())) {
                    return;
                }
                this.b.T(event.a(), event.b());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements y06.c {
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

        public static final void b(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, null, zz4Var) == null) && zz4Var != null) {
                zz4Var.dismiss();
            }
        }

        public static final void c(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65538, null, zz4Var) == null) && zz4Var != null) {
                zz4Var.dismiss();
            }
        }

        @Override // com.baidu.tieba.y06.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            String string;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) != null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.a.z();
            c16 c16Var = this.a.h;
            if (c16Var != null) {
                c16Var.y();
                c16Var.x();
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                if (!TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText())) {
                    string = deleteThreadHttpResponseMessage.getText();
                } else {
                    string = this.a.I().getString(R.string.delete_fail);
                }
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    zz4 zz4Var = new zz4(this.a.I());
                    zz4Var.setMessage(string);
                    zz4Var.setPositiveButton(R.string.dialog_known, new zz4.e() { // from class: com.baidu.tieba.zf7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.zz4.e
                        public final void onClick(zz4 zz4Var2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, zz4Var2) == null) {
                                MultiManageBottomController.d.b(zz4Var2);
                            }
                        }
                    });
                    zz4Var.setCanceledOnTouchOutside(false);
                    if ((this.a.I() instanceof TbPageContextSupport) && ((TbPageContextSupport) this.a.I()).getPageContext() != null) {
                        zz4Var.create(((TbPageContextSupport) this.a.I()).getPageContext());
                        zz4Var.show();
                    }
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    zz4 zz4Var2 = new zz4(this.a.I());
                    zz4Var2.setMessage(string);
                    zz4Var2.setPositiveButton(R.string.obfuscated_res_0x7f0f0b79, new zz4.e() { // from class: com.baidu.tieba.lg7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.zz4.e
                        public final void onClick(zz4 zz4Var3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, zz4Var3) == null) {
                                MultiManageBottomController.d.c(zz4Var3);
                            }
                        }
                    });
                    zz4Var2.setCanceledOnTouchOutside(false);
                    if ((this.a.I() instanceof TbPageContextSupport) && ((TbPageContextSupport) this.a.I()).getPageContext() != null) {
                        zz4Var2.create(((TbPageContextSupport) this.a.I()).getPageContext());
                        zz4Var2.show();
                    }
                } else {
                    BdUtilHelper.showToast(this.a.I(), deleteThreadHttpResponseMessage.getText());
                }
                this.a.B(deleteThreadHttpResponseMessage.getSuccessItems());
                return;
            }
            BdUtilHelper.showToast(this.a.I(), deleteThreadHttpResponseMessage.getErrorString());
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
                BdUtilHelper.showToast(this.a.I(), (int) R.string.obfuscated_res_0x7f0f0862);
                this.a.C();
            } else {
                BdUtilHelper.showToast(this.a.I(), httpResponsedMessage.getErrorString());
            }
            this.a.z();
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
        this.g = new y06("0", f());
    }

    public static final void N(FrsMoveAreaChooseView this_apply, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this_apply, view2) == null) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            this_apply.setVisibility(8);
        }
    }

    public static final void O(MultiManageBottomController this$0, z67 it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "it");
            FrsMoveAreaChooseView frsMoveAreaChooseView = this$0.i;
            if (frsMoveAreaChooseView != null) {
                this$0.R(frsMoveAreaChooseView.getMoveTabId());
            }
        }
    }

    public static final void P(FrsMoveAreaChooseView this_apply, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this_apply, view2) == null) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            this_apply.setVisibility(8);
        }
    }

    public final void B(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && list != null) {
            mq6.b().c(new fi7(this.b, list, 0));
        }
    }

    public final o57 D(e57<?> e57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, e57Var)) == null) {
            return F(H(e57Var));
        }
        return (o57) invokeL.objValue;
    }

    public final x67 E(e57<?> e57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e57Var)) == null) {
            return G(H(e57Var));
        }
        return (x67) invokeL.objValue;
    }

    @Override // com.baidu.tieba.og7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
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

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.e.size() > 0) {
                return false;
            }
            BdUtilHelper.showToast(this.b, (int) R.string.obfuscated_res_0x7f0f086b);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final FragmentActivity I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || A()) {
            return;
        }
        S(1);
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || A()) {
            return;
        }
        S(2);
    }

    @Override // com.baidu.tieba.og7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.l();
            this.g.f(null);
            this.g.d();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            mq6.b().c(new a87(this.b, false, false, 4, null));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ForumTabItem A = tg7.k(this.b).A();
            boolean z = true;
            if ((A == null || !A.isGeneralTab()) ? false : false) {
                ArrayList arrayList = new ArrayList();
                for (e57<?> e57Var : this.e) {
                    String m = e57Var.m();
                    if (m != null) {
                        arrayList.add(m);
                    }
                }
                B(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.og7
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
            } else if (Intrinsics.areEqual(((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).f().getValue(), Boolean.TRUE)) {
                z();
                return true;
            } else {
                return super.h();
            }
        }
        return invokeV.booleanValue;
    }

    public final o57 F(k77 k77Var) {
        InterceptResult invokeL;
        List<p77> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k77Var)) == null) {
            if (k77Var != null) {
                list = k77Var.m;
            } else {
                list = null;
            }
            if (list == null) {
                return null;
            }
            for (p77 p77Var : list) {
                if (p77Var.c() == ThreadManageType.ID_MULTI_DEL.getValue()) {
                    Object a2 = p77Var.a();
                    if (!(a2 instanceof o57)) {
                        return null;
                    }
                    return (o57) a2;
                }
            }
            return null;
        }
        return (o57) invokeL.objValue;
    }

    public final x67 G(k77 k77Var) {
        InterceptResult invokeL;
        List<p77> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k77Var)) == null) {
            if (k77Var != null) {
                list = k77Var.m;
            } else {
                list = null;
            }
            if (list == null) {
                return null;
            }
            for (p77 p77Var : list) {
                if (p77Var.c() == ThreadManageType.ID_MOVE_AREA.getValue()) {
                    Object a2 = p77Var.a();
                    if (!(a2 instanceof x67)) {
                        return null;
                    }
                    return (x67) a2;
                }
            }
            return null;
        }
        return (x67) invokeL.objValue;
    }

    public final k77 H(e57<?> e57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e57Var)) == null) {
            for (za7<? extends Object> za7Var : e57Var.c()) {
                Object b2 = za7Var.b();
                if (b2 instanceof s47) {
                    return ((s47) b2).m();
                }
            }
            return null;
        }
        return (k77) invokeL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v14, types: [com.baidu.tieba.forum.view.FrsMultiDeleteBottomView] */
    public final void K(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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

    public final void M() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || A()) {
            return;
        }
        FragmentActivity fragmentActivity = this.b;
        if (fragmentActivity instanceof TbPageContextSupport) {
            TbPageContext pageContext = ((TbPageContextSupport) fragmentActivity).getPageContext();
            if (this.i == null) {
                final FrsMoveAreaChooseView frsMoveAreaChooseView = new FrsMoveAreaChooseView(pageContext);
                frsMoveAreaChooseView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.uf7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            MultiManageBottomController.N(FrsMoveAreaChooseView.this, view2);
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
                    frsMoveAreaChooseView.setDoneListener(new FrsMoveAreaChooseView.a() { // from class: com.baidu.tieba.jg7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.forum.view.FrsMoveAreaChooseView.a
                        public final void a(z67 z67Var) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, z67Var) == null) {
                                MultiManageBottomController.O(MultiManageBottomController.this, z67Var);
                            }
                        }
                    });
                    frsMoveAreaChooseView.setCancelListener(new View.OnClickListener() { // from class: com.baidu.tieba.ze7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                MultiManageBottomController.P(FrsMoveAreaChooseView.this, view2);
                            }
                        }
                    });
                    this.i = frsMoveAreaChooseView;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            x67 E = E((e57) CollectionsKt___CollectionsKt.last(this.e));
            if (E == null) {
                return;
            }
            FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.i;
            if (frsMoveAreaChooseView2 != null) {
                frsMoveAreaChooseView2.setData(E.c(), E.a(), E.b());
            }
            FrsMoveAreaChooseView frsMoveAreaChooseView3 = this.i;
            if (frsMoveAreaChooseView3 != null) {
                frsMoveAreaChooseView3.setVisibility(0);
            }
        }
    }

    public final void Q(b87 b87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, b87Var) == null) {
            boolean z = !b87Var.a().q();
            if (z) {
                if (this.f) {
                    if (this.e.size() >= 30) {
                        BdUtilHelper.showToast(this.b, (int) R.string.obfuscated_res_0x7f0f086a);
                        return;
                    }
                } else if (this.e.size() >= 30) {
                    BdUtilHelper.showToast(this.b, (int) R.string.obfuscated_res_0x7f0f085d);
                    return;
                }
                this.e.add(b87Var.a());
                b87Var.a().r(z);
            } else {
                this.e.remove(b87Var.a());
                b87Var.a().r(z);
            }
            V();
        }
    }

    public final void R(int i) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            try {
                gh7 value = ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().getValue();
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
                JSONArray jSONArray = new JSONArray();
                for (e57<?> e57Var : this.e) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", e57Var.m());
                    jSONObject.put("to_tab_id", i);
                    jSONArray.put(jSONObject);
                }
                httpMessage.addParam("threads", jSONArray.toString());
                if (value != null) {
                    obj = Long.valueOf(value.d());
                } else {
                    obj = "";
                }
                httpMessage.addParam("forum_id", obj);
                httpMessage.setTag(f());
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void S(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && (this.b instanceof TbPageContextSupport) && this.e.size() > 0) {
            TbPageContext pageContext = ((TbPageContextSupport) this.b).getPageContext();
            o57 D = D((e57) CollectionsKt___CollectionsKt.last(this.e));
            if (D == null) {
                return;
            }
            b16 k = pj7.k(D);
            UserData l = pj7.l(D);
            SparseArray<String> sparseArray = new SparseArray<>();
            for (q57 q57Var : D.f()) {
                sparseArray.put(q57Var.a(), q57Var.b());
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (e57<?> e57Var : this.e) {
                o57 D2 = D(e57Var);
                if (D2 != null) {
                    jSONArray.put(D2.g());
                    jSONArray2.put(D2.e());
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            negativeFeedBackData.setDeleteType(i);
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(D.b());
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
            c16 c16Var = this.h;
            if (c16Var != null) {
                c16Var.x();
                c16Var.y();
            }
            FrsMultiDeleteBottomView frsMultiDeleteBottomView = this.c;
            if (frsMultiDeleteBottomView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiDeleteBottomView");
                frsMultiDeleteBottomView = null;
            }
            c16 c16Var2 = new c16(pageContext, frsMultiDeleteBottomView, k, l, f());
            c16Var2.G(false);
            c16Var2.I(strArr);
            c16Var2.H(negativeFeedBackData);
            c16Var2.K("2");
            this.h = c16Var2;
        }
    }

    public final void T(Context context, k77 k77Var) {
        TbPageContext tbPageContext;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, k77Var) == null) {
            if (context instanceof TbPageContextSupport) {
                tbPageContext = ((TbPageContextSupport) context).getPageContext();
            } else {
                tbPageContext = null;
            }
            List<p77> itemList = k77Var.m;
            if (tbPageContext != null) {
                if (itemList != null && !itemList.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    Intrinsics.checkNotNullExpressionValue(itemList, "itemList");
                    new ThreadManageDialog(tbPageContext, itemList).l();
                }
            }
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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

    @Override // com.baidu.tieba.og7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            FrsMultiDeleteBottomView frsMultiDeleteBottomView = binding.n;
            Intrinsics.checkNotNullExpressionValue(frsMultiDeleteBottomView, "binding.multiMultiDeleteBottomLayout");
            this.c = frsMultiDeleteBottomView;
            FrsMultiMoveBottomView frsMultiMoveBottomView = binding.o;
            Intrinsics.checkNotNullExpressionValue(frsMultiMoveBottomView, "binding.multiMultiMoveBottomLayout");
            this.d = frsMultiMoveBottomView;
            mq6.b().b(new lq6(f(), Reflection.getOrCreateKotlinClass(a87.class)), new a(this, a87.class));
            mq6.b().b(new lq6(f(), Reflection.getOrCreateKotlinClass(b87.class)), new b(this, b87.class));
            mq6.b().b(new lq6(f(), Reflection.getOrCreateKotlinClass(z77.class)), new c(this, z77.class));
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
                    this.this$0.z();
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
                    this.this$0.J();
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
                    this.this$0.L();
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
                    this.this$0.z();
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
                    this.this$0.M();
                }
            });
            this.g.e();
            this.g.f(new d(this));
            e eVar = new e(this);
            eVar.setTag(f());
            MessageManager.getInstance().registerListener(eVar);
        }
    }
}
