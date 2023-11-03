package com.baidu.tbadk.editortools.meme.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.editortools.meme.view.SpriteMemeGenerateView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/list/MemeGenerateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "spriteMemeGenerateView", "Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeGenerateView;", "(Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeGenerateView;)V", "getSpriteMemeGenerateView", "()Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeGenerateView;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MemeGenerateViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SpriteMemeGenerateView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemeGenerateViewHolder(SpriteMemeGenerateView spriteMemeGenerateView) {
        super(spriteMemeGenerateView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spriteMemeGenerateView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(spriteMemeGenerateView, "spriteMemeGenerateView");
        this.a = spriteMemeGenerateView;
        int dimens = BdUtilHelper.getDimens(spriteMemeGenerateView.getContext(), R.dimen.tbds182);
        this.a.setLayoutParams(new RecyclerView.LayoutParams(dimens, dimens));
    }

    public final SpriteMemeGenerateView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (SpriteMemeGenerateView) invokeV.objValue;
    }
}
