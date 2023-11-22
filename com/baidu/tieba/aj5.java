package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class aj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<cj5> a;
    public volatile a b;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, cj5, cj5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<cj5> a;
        public final /* synthetic */ aj5 b;

        public a(aj5 aj5Var, Queue<cj5> queue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aj5Var, queue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aj5Var;
            this.a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public cj5 doInBackground(Void... voidArr) {
            boolean z;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (cj5) invokeL.objValue;
            }
            while (true) {
                cj5 poll = this.a.poll();
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.a.add(poll);
                    return null;
                }
                ImageFileInfo imageFileInfo = poll.a;
                if (imageFileInfo != null) {
                    poll.d = aj5.f(imageFileInfo, poll.c);
                    if (TbImageMemoryCache.B().D(poll.a.toCachedKey(poll.c)) != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    poll.e = z;
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(cj5 cj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cj5Var) == null) {
                super.onPostExecute(cj5Var);
                this.b.b = null;
                this.b.h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(cj5... cj5VarArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cj5VarArr) == null) && cj5VarArr != null) {
                for (cj5 cj5Var : cj5VarArr) {
                    BdImage bdImage = cj5Var.d;
                    if (bdImage != null && !cj5Var.e) {
                        TbImageMemoryCache.B().l(cj5Var.a.toCachedKey(cj5Var.c), bdImage);
                    }
                    xi5 xi5Var = cj5Var.b;
                    if (xi5Var != null) {
                        xi5Var.a(bdImage, cj5Var.a.toCachedKey(cj5Var.c), cj5Var.e);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
                this.b.b = null;
                while (true) {
                    cj5 poll = this.a.poll();
                    if (poll == null) {
                        return;
                    }
                    xi5 xi5Var = poll.b;
                    if (xi5Var != null) {
                        xi5Var.a(null, poll.a.toCachedKey(poll.c), false);
                    }
                }
            }
        }
    }

    public aj5() {
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
        this.a = new ConcurrentLinkedQueue();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = new ConcurrentLinkedQueue();
            if (this.b != null) {
                this.b.cancel(true);
                this.b = null;
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b == null && !this.a.isEmpty()) {
            this.b = new a(this, this.a);
            this.b.execute(new Void[0]);
        }
    }

    public BdImage c(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            return TbImageMemoryCache.B().D(imageFileInfo.toCachedKey(z));
        }
        return (BdImage) invokeLZ.objValue;
    }

    @Nullable
    public static BdImage f(@NonNull ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, imageFileInfo, z)) == null) {
            BdImage D = TbImageMemoryCache.B().D(imageFileInfo.toCachedKey(z));
            if (D != null) {
                return D;
            }
            Bitmap g = g(imageFileInfo, z);
            if (g != null) {
                int i = 0;
                Bitmap bitmap = null;
                try {
                    i = BitmapHelper.readPictureDegree(imageFileInfo.getFilePath());
                    if (i != 0) {
                        Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(g, i);
                        if (g != rotateBitmapBydegree) {
                            try {
                                g.recycle();
                                g = null;
                            } catch (Exception unused) {
                            }
                        }
                        bitmap = rotateBitmapBydegree;
                    }
                } catch (Exception unused2) {
                }
                if (i != 0 && bitmap != null) {
                    return new BdImage(bitmap, imageFileInfo.isGif(), imageFileInfo.getFilePath());
                }
                return new BdImage(g, imageFileInfo.isGif(), imageFileInfo.getFilePath());
            }
            return D;
        }
        return (BdImage) invokeLZ.objValue;
    }

    public static Bitmap g(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            if (z && imageFileInfo.getPersistActionsList() != null) {
                linkedList.addAll(imageFileInfo.getPersistActionsList());
            }
            if (imageFileInfo.getPageActionsList() != null) {
                linkedList.addAll(imageFileInfo.getPageActionsList());
            }
            if (imageFileInfo.getOrginalBitmap() != null) {
                try {
                    jj5 d = jj5.d();
                    Bitmap orginalBitmap = imageFileInfo.getOrginalBitmap();
                    if (!imageFileInfo.isOrginalBitmapShared()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    return d.b(orginalBitmap, z2, linkedList, imageFileInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } else if (imageFileInfo.hasActions(z)) {
                try {
                    return jj5.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            } else {
                return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
            }
        }
        return (Bitmap) invokeLZ.objValue;
    }

    public BdImage d(ImageFileInfo imageFileInfo, xi5 xi5Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, xi5Var, z)) == null) {
            return e(imageFileInfo, xi5Var, z, false);
        }
        return (BdImage) invokeLLZ.objValue;
    }

    public BdImage e(ImageFileInfo imageFileInfo, xi5 xi5Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, xi5Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            BdImage c = c(imageFileInfo, z);
            if (c != null) {
                return c;
            }
            if (z2) {
                return null;
            }
            cj5 cj5Var = new cj5();
            cj5Var.b = xi5Var;
            cj5Var.a = imageFileInfo;
            cj5Var.c = z;
            this.a.add(cj5Var);
            h();
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }
}
