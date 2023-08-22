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
/* loaded from: classes6.dex */
public class hm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<jm5> a;
    public volatile a b;

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Void, jm5, jm5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<jm5> a;
        public final /* synthetic */ hm5 b;

        public a(hm5 hm5Var, Queue<jm5> queue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm5Var, queue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm5Var;
            this.a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public jm5 doInBackground(Void... voidArr) {
            boolean z;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (jm5) invokeL.objValue;
            }
            while (true) {
                jm5 poll = this.a.poll();
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.a.add(poll);
                    return null;
                }
                ImageFileInfo imageFileInfo = poll.a;
                if (imageFileInfo != null) {
                    poll.d = hm5.f(imageFileInfo, poll.c);
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
        public void onPostExecute(jm5 jm5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jm5Var) == null) {
                super.onPostExecute(jm5Var);
                this.b.b = null;
                this.b.h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(jm5... jm5VarArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jm5VarArr) == null) && jm5VarArr != null) {
                for (jm5 jm5Var : jm5VarArr) {
                    BdImage bdImage = jm5Var.d;
                    if (bdImage != null && !jm5Var.e) {
                        TbImageMemoryCache.B().m(jm5Var.a.toCachedKey(jm5Var.c), bdImage);
                    }
                    em5 em5Var = jm5Var.b;
                    if (em5Var != null) {
                        em5Var.a(bdImage, jm5Var.a.toCachedKey(jm5Var.c), jm5Var.e);
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
                    jm5 poll = this.a.poll();
                    if (poll == null) {
                        return;
                    }
                    em5 em5Var = poll.b;
                    if (em5Var != null) {
                        em5Var.a(null, poll.a.toCachedKey(poll.c), false);
                    }
                }
            }
        }
    }

    public hm5() {
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
                    qm5 d = qm5.d();
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
                    return qm5.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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

    public BdImage d(ImageFileInfo imageFileInfo, em5 em5Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, em5Var, z)) == null) {
            return e(imageFileInfo, em5Var, z, false);
        }
        return (BdImage) invokeLLZ.objValue;
    }

    public BdImage e(ImageFileInfo imageFileInfo, em5 em5Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, em5Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            BdImage c = c(imageFileInfo, z);
            if (c != null) {
                return c;
            }
            if (z2) {
                return null;
            }
            jm5 jm5Var = new jm5();
            jm5Var.b = em5Var;
            jm5Var.a = imageFileInfo;
            jm5Var.c = z;
            this.a.add(jm5Var);
            h();
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }
}
