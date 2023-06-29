package com.baidu.tieba;

import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes6.dex */
public class i59 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804636, "Lcom/baidu/tieba/i59;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804636, "Lcom/baidu/tieba/i59;");
                return;
            }
        }
        a = a59.c + "draft/";
        b = a + "upload_draft";
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            File file = new File(b);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0010 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft] */
    public static FaceGroupDraft b() {
        InterceptResult invokeV;
        FaceGroupDraft faceGroupDraft;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File file = new File(b);
            ?? r2 = 0;
            r2 = null;
            r2 = null;
            r2 = null;
            r2 = null;
            FaceGroupDraft faceGroupDraft2 = null;
            r2 = null;
            r2 = null;
            ObjectInputStream objectInputStream = null;
            try {
                if (!file.exists()) {
                    return null;
                }
                try {
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(file));
                    try {
                        Object readObject = objectInputStream2.readObject();
                        if (readObject != null && (readObject instanceof FaceGroupDraft)) {
                            faceGroupDraft2 = (FaceGroupDraft) readObject;
                        }
                        objectInputStream2.close();
                        ug.c(objectInputStream2);
                        return faceGroupDraft2;
                    } catch (IOException e) {
                        e = e;
                        FaceGroupDraft faceGroupDraft3 = faceGroupDraft2;
                        objectInputStream = objectInputStream2;
                        faceGroupDraft = faceGroupDraft3;
                        e.printStackTrace();
                        ug.c(objectInputStream);
                        r2 = faceGroupDraft;
                        return r2;
                    } catch (ClassNotFoundException e2) {
                        e = e2;
                        FaceGroupDraft faceGroupDraft4 = faceGroupDraft2;
                        objectInputStream = objectInputStream2;
                        faceGroupDraft = faceGroupDraft4;
                        e.printStackTrace();
                        ug.c(objectInputStream);
                        r2 = faceGroupDraft;
                        return r2;
                    } catch (Throwable th) {
                        th = th;
                        FaceGroupDraft faceGroupDraft5 = faceGroupDraft2;
                        objectInputStream = objectInputStream2;
                        faceGroupDraft = faceGroupDraft5;
                        th.printStackTrace();
                        ug.c(objectInputStream);
                        r2 = faceGroupDraft;
                        return r2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    faceGroupDraft = null;
                } catch (ClassNotFoundException e4) {
                    e = e4;
                    faceGroupDraft = null;
                } catch (Throwable th2) {
                    th = th2;
                    faceGroupDraft = null;
                }
            } catch (Throwable th3) {
                ug.c(r2);
                throw th3;
            }
        } else {
            return (FaceGroupDraft) invokeV.objValue;
        }
    }

    public static void c(FaceGroupDraft faceGroupDraft) {
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, faceGroupDraft) == null) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    File file = new File(a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    a();
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(b));
                } finally {
                    ug.d(objectOutputStream2);
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(faceGroupDraft);
                ug.d(objectOutputStream);
            } catch (FileNotFoundException e3) {
                e = e3;
                objectOutputStream2 = objectOutputStream;
                e.printStackTrace();
            } catch (IOException e4) {
                e = e4;
                objectOutputStream2 = objectOutputStream;
                e.printStackTrace();
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                th.printStackTrace();
            }
        }
    }
}
