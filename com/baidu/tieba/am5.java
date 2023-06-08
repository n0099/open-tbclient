package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
public class am5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<b> a;
    public volatile c b;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageFileInfo a;
        public xl5 b;
        public boolean c;
        public gn d;
        public boolean e;

        public b(am5 am5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(am5 am5Var, a aVar) {
            this(am5Var);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, b, b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<b> a;
        public final /* synthetic */ am5 b;

        public c(am5 am5Var, Queue<b> queue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am5Var, queue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = am5Var;
            this.a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public b doInBackground(Void... voidArr) {
            int i;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (b) invokeL.objValue;
            }
            while (true) {
                b poll = this.a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.a.add(poll);
                    return null;
                }
                gn z = TbImageMemoryCache.u().z(poll.a.toCachedKey(poll.c));
                if (z != null) {
                    poll.d = z;
                    poll.e = true;
                } else {
                    Bitmap f = this.b.f(poll.a, poll.c);
                    if (f != null) {
                        try {
                            i = BitmapHelper.readPictureDegree(poll.a.getFilePath());
                            if (i != 0) {
                                try {
                                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(f, i);
                                    if (f != rotateBitmapBydegree) {
                                        try {
                                            f.recycle();
                                            f = null;
                                        } catch (Exception unused) {
                                        }
                                    }
                                    bitmap = rotateBitmapBydegree;
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (Exception unused3) {
                            i = 0;
                        }
                        if (i != 0 && bitmap != null) {
                            poll.d = new gn(bitmap, poll.a.isGif(), poll.a.getFilePath());
                        } else {
                            poll.d = new gn(f, poll.a.isGif(), poll.a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                super.onPostExecute(bVar);
                this.b.b = null;
                this.b.g();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(b... bVarArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr) == null) && bVarArr != null) {
                for (b bVar : bVarArr) {
                    gn gnVar = bVar.d;
                    if (gnVar != null && !bVar.e) {
                        TbImageMemoryCache.u().l(bVar.a.toCachedKey(bVar.c), gnVar);
                    }
                    xl5 xl5Var = bVar.b;
                    if (xl5Var != null) {
                        xl5Var.a(gnVar, bVar.a.toCachedKey(bVar.c), bVar.e);
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
                    b poll = this.a.poll();
                    if (poll == null) {
                        return;
                    }
                    xl5 xl5Var = poll.b;
                    if (xl5Var != null) {
                        xl5Var.a(null, poll.a.toCachedKey(poll.c), false);
                    }
                }
            }
        }
    }

    public am5() {
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

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.b == null && !this.a.isEmpty()) {
            this.b = new c(this, this.a);
            this.b.execute(new Void[0]);
        }
    }

    public gn c(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            return TbImageMemoryCache.u().z(imageFileInfo.toCachedKey(z));
        }
        return (gn) invokeLZ.objValue;
    }

    public gn d(ImageFileInfo imageFileInfo, xl5 xl5Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, xl5Var, z)) == null) {
            return e(imageFileInfo, xl5Var, z, false);
        }
        return (gn) invokeLLZ.objValue;
    }

    public gn e(ImageFileInfo imageFileInfo, xl5 xl5Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, xl5Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            gn c2 = c(imageFileInfo, z);
            if (c2 != null) {
                return c2;
            }
            if (z2) {
                return null;
            }
            b bVar = new b(this, null);
            bVar.b = xl5Var;
            bVar.a = imageFileInfo;
            bVar.c = z;
            this.a.add(bVar);
            g();
            return null;
        }
        return (gn) invokeCommon.objValue;
    }

    public Bitmap f(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, imageFileInfo, z)) == null) {
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
                    im5 d = im5.d();
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
                    return im5.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
}
