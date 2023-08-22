package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class fza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;

    /* loaded from: classes6.dex */
    public final class a extends BdAsyncTask<Void, jm5, jm5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final jm5 a;

        public a(fza fzaVar, jm5 mHoldData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fzaVar, mHoldData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(mHoldData, "mHoldData");
            this.a = mHoldData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public jm5 doInBackground(Void... params) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                jm5 jm5Var = this.a;
                ImageFileInfo imageFileInfo = jm5Var.a;
                Intrinsics.checkNotNull(imageFileInfo);
                jm5Var.d = hm5.f(imageFileInfo, this.a.c);
                return this.a;
            }
            return (jm5) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(jm5 result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.onPostExecute(result);
                ImageFileInfo imageFileInfo = this.a.a;
                Intrinsics.checkNotNull(imageFileInfo);
                String cachedKey = imageFileInfo.toCachedKey(this.a.c);
                if (TbImageMemoryCache.B().D(cachedKey) == null) {
                    result.e = false;
                    TbImageMemoryCache.B().m(cachedKey, result.d);
                }
                em5 em5Var = result.b;
                if (em5Var != null) {
                    em5Var.a(result.d, cachedKey, result.e);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
                jm5 jm5Var = this.a;
                em5 em5Var = jm5Var.b;
                if (em5Var != null) {
                    ImageFileInfo imageFileInfo = jm5Var.a;
                    Intrinsics.checkNotNull(imageFileInfo);
                    em5Var.a(null, imageFileInfo.toCachedKey(this.a.c), false);
                }
            }
        }
    }

    public fza() {
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
        this.a = BdUniqueId.gen();
    }

    public static /* synthetic */ BdImage d(fza fzaVar, ImageFileInfo imageFileInfo, em5 em5Var, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return fzaVar.c(imageFileInfo, em5Var, z, z2);
    }

    public final void a() {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask;
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (searchWaitingTask = BdAsyncTask.searchWaitingTask(this.a)) != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next instanceof a) {
                    aVar = (a) next;
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }
    }

    public final BdImage b(ImageFileInfo localImageInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, localImageInfo, z)) == null) {
            Intrinsics.checkNotNullParameter(localImageInfo, "localImageInfo");
            return TbImageMemoryCache.B().D(localImageInfo.toCachedKey(z));
        }
        return (BdImage) invokeLZ.objValue;
    }

    @JvmOverloads
    public final BdImage c(ImageFileInfo localImageInfo, em5 em5Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{localImageInfo, em5Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Intrinsics.checkNotNullParameter(localImageInfo, "localImageInfo");
            BdImage b = b(localImageInfo, z);
            if (b != null) {
                return b;
            }
            if (z2) {
                return null;
            }
            jm5 jm5Var = new jm5();
            jm5Var.b = em5Var;
            jm5Var.a = localImageInfo;
            jm5Var.c = z;
            a aVar = new a(this, jm5Var);
            aVar.setTag(this.a);
            aVar.execute(new Void[0]);
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }
}
