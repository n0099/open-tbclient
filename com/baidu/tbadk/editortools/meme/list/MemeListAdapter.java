package com.baidu.tbadk.editortools.meme.list;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.editortools.meme.SpriteMemeShowStrategy;
import com.baidu.tbadk.editortools.meme.list.MemeListAdapter;
import com.baidu.tbadk.editortools.meme.view.AigcGenerateImageView;
import com.baidu.tbadk.editortools.meme.view.AigcImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.ag5;
import com.baidu.tieba.bg5;
import com.baidu.tieba.br6;
import com.baidu.tieba.dr6;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.xd;
import com.baidu.tieba.zf5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0019H\u0002J\u0018\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0006H\u0002J\u0014\u0010*\u001a\u00020\u001d2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060,R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006-"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/list/MemeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataList", "", "Lcom/baidu/tbadk/editortools/meme/list/MemeData;", "getDataList", "()Ljava/util/List;", "fname", "", "getFname", "()Ljava/lang/String;", "setFname", "(Ljava/lang/String;)V", "permissionJudgePolicy", "Lcom/baidu/tbadk/core/util/permission/PermissionJudgePolicy;", "getPermissionJudgePolicy", "()Lcom/baidu/tbadk/core/util/permission/PermissionJudgePolicy;", "permissionJudgePolicy$delegate", "Lkotlin/Lazy;", "tid", "getTid", "setTid", "getItemCount", "", "getItemViewType", CriusAttrConstants.POSITION, "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", PopItemMethodConstant.showToast, "context", "Landroid/content/Context;", "contentResId", "statMeme", "type", "memeData", "updateData", "data", "", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MemeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final List<MemeData> b;
    public String c;
    public String d;

    public MemeListAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(MemeListAdapter$permissionJudgePolicy$2.INSTANCE);
        this.b = new ArrayList();
        this.c = "";
        this.d = "";
    }

    public static final void n(MemeListAdapter this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Context context = view2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            this$0.s(context, R.string.generate_loading_toast);
        }
    }

    public static final void o(MemeListAdapter this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Context context = view2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            this$0.s(context, R.string.generate_error_toast);
        }
    }

    public static final void p(RecyclerView.ViewHolder holder, MemeListAdapter this$0, MemeData memeData, View view2) {
        String str;
        Bitmap rawBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, holder, this$0, memeData, view2) == null) {
            Intrinsics.checkNotNullParameter(holder, "$holder");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(memeData, "$memeData");
            MemeViewHolder memeViewHolder = (MemeViewHolder) holder;
            Context context = memeViewHolder.a().getContext();
            if (!(context instanceof Activity)) {
                return;
            }
            BdImage bdImage = memeViewHolder.a().getBdImage();
            if (bdImage != null && (rawBitmap = bdImage.getRawBitmap()) != null) {
                this$0.l().clearRequestPermissionList();
                Activity activity = (Activity) context;
                this$0.l().appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this$0.l().startRequestPermission(activity)) {
                    return;
                }
                str = FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_PIC_DIR, xd.c(memeData.getImgUrl()), rawBitmap, 100);
                Intrinsics.checkNotNullExpressionValue(str, "saveBitmapByRelativelyPa…                        )");
            } else {
                str = "";
            }
            SpriteMemeShowStrategy.a.e();
            BdPageContext<?> a = a5.a(view2.getContext());
            if (!StringsKt__StringsJVMKt.isBlank(str)) {
                if (a != null) {
                    dr6 b = br6.b();
                    BdUniqueId uniqueId = a.getUniqueId();
                    Intrinsics.checkNotNullExpressionValue(uniqueId, "pageContext.uniqueId");
                    b.c(new bg5(memeData, str, uniqueId));
                }
                this$0.t(2, memeData);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    public final PermissionJudgePolicy l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (PermissionJudgePolicy) this.a.getValue();
        }
        return (PermissionJudgePolicy) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.b.get(i).getType();
        }
        return invokeI.intValue;
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.d = str;
        }
    }

    public final void updateData(List<? extends MemeData> data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.b.clear();
            this.b.addAll(data);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof MemeViewHolder) {
                final MemeData memeData = this.b.get(i);
                MemeViewHolder memeViewHolder = (MemeViewHolder) holder;
                memeViewHolder.a().h(memeData);
                memeViewHolder.a().setOnLoadingClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.eg5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            MemeListAdapter.n(MemeListAdapter.this, view2);
                        }
                    }
                }, new View.OnClickListener() { // from class: com.baidu.tieba.dg5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            MemeListAdapter.o(MemeListAdapter.this, view2);
                        }
                    }
                });
                memeViewHolder.a().setOnImageClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.cg5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            MemeListAdapter.p(RecyclerView.ViewHolder.this, this, memeData, view2);
                        }
                    }
                });
                t(1, memeData);
            } else if (!GlobalBuildConfig.isDebug()) {
            } else {
                throw new RuntimeException("MemeListAdapter has unknown view holder");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        RecyclerView.ViewHolder memeViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i != 1) {
                if (i != 2) {
                    if (!GlobalBuildConfig.isDebug()) {
                        final View view2 = new View(parent.getContext());
                        return new RecyclerView.ViewHolder(view2) { // from class: com.baidu.tbadk.editortools.meme.list.MemeListAdapter$onCreateViewHolder$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(view2);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {view2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        super((View) newInitContext.callArgs[0]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                            }
                        };
                    }
                    throw new RuntimeException("MemeListAdapter has unknown view type");
                }
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                memeViewHolder = new MemeGenerateViewHolder(new AigcGenerateImageView(context, null, 2, null));
            } else {
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                memeViewHolder = new MemeViewHolder(new AigcImageView(context2, null, 2, null));
            }
            return memeViewHolder;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public final void s(Context context, int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, context, i) == null) {
            ViewGroup viewGroup = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                View findViewById = activity.findViewById(16908290);
                if (findViewById instanceof ViewGroup) {
                    viewGroup = (ViewGroup) findViewById;
                }
                if (viewGroup != null) {
                    new BdTopToast(context).setIcon(false).setContent(activity.getString(i)).show(viewGroup);
                }
            }
        }
    }

    public final void t(int i, MemeData memeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, memeData) == null) {
            ag5 ag5Var = new ag5();
            ag5Var.l(i);
            ag5Var.h(memeData.getId());
            ag5Var.i(memeData.getRequestQuery());
            ag5Var.j(memeData.getObjSource());
            ag5Var.g(this.c);
            ag5Var.k(this.d);
            zf5.a.b(ag5Var);
        }
    }
}
