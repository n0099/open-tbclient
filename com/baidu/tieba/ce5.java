package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tieba.df;
import com.baidu.tieba.pd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ce5<T extends pd5> extends ae5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ce5(int i, String str, Class<T> cls) {
        super(i, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x0073 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x00d6 */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v12. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v9. Raw type applied. Possible types: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v36 */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        InterceptResult invokeL;
        String str;
        ?? arrayList;
        String str2;
        pd5 pd5Var;
        byte[] bArr;
        pd5 pd5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            pd5 pd5Var3 = null;
            if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
                return null;
            }
            ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
            pd5 pd5Var4 = (pd5) a();
            try {
                try {
                    if (readCacheMessage.isNeedUid()) {
                        str = TbadkCoreApplication.getCurrentAccount();
                        if (str == null) {
                            str = "";
                        }
                    } else {
                        str = null;
                    }
                    if (pd5Var4 != null) {
                        if (readCacheMessage.getRequestData() == null) {
                            try {
                                if (pd5Var4 instanceof od5) {
                                    kv4.f();
                                    List<df.b<byte[]>> a = ej.a(kv4.e(this.b, str));
                                    if (a != null) {
                                        arrayList = new ArrayList(a.size());
                                        for (df.b<byte[]> bVar : a) {
                                            if (bVar != null && (bArr = bVar.b) != null && (pd5Var2 = (pd5) a()) != null) {
                                                ((od5) pd5Var2).initByByteArray(bArr);
                                                arrayList.add(pd5Var2);
                                            }
                                        }
                                        pd5Var3 = arrayList;
                                    }
                                } else if (pd5Var4 instanceof rd5) {
                                    kv4.f();
                                    List<df.b<String>> b = ej.b(kv4.h(this.b, str));
                                    if (b != null) {
                                        arrayList = new ArrayList(b.size());
                                        for (df.b<String> bVar2 : b) {
                                            if (bVar2 != null && (str2 = bVar2.b) != null && (pd5Var = (pd5) a()) != null) {
                                                ((rd5) pd5Var).w(str2);
                                                arrayList.add(pd5Var);
                                            }
                                        }
                                        pd5Var3 = arrayList;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                pd5Var3 = pd5Var4;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, pd5Var3);
                            } catch (Throwable th) {
                                th = th;
                                pd5Var3 = pd5Var4;
                                new ReadCacheRespMsg(this.a, pd5Var3);
                                throw th;
                            }
                        } else {
                            String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                            String F = readCacheMessage.getRequestData().F();
                            try {
                                if (pd5Var4 instanceof od5) {
                                    kv4.f();
                                    byte[] bArr2 = kv4.e(F, str).get(cacheKey);
                                    if (bArr2 != null) {
                                        ((od5) pd5Var4).initByByteArray(bArr2);
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(pd5Var4);
                                        F = arrayList2;
                                        pd5Var3 = F;
                                    }
                                } else if (pd5Var4 instanceof rd5) {
                                    kv4.f();
                                    String str3 = kv4.h(F, str).get(cacheKey);
                                    if (str3 != null) {
                                        ((rd5) pd5Var4).w(str3);
                                        ?? arrayList3 = new ArrayList();
                                        arrayList3.add(pd5Var4);
                                        F = arrayList3;
                                        pd5Var3 = F;
                                    }
                                }
                            } catch (Exception e2) {
                                pd5Var3 = F;
                                e = e2;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, pd5Var3);
                            } catch (Throwable th2) {
                                pd5Var3 = F;
                                th = th2;
                                new ReadCacheRespMsg(this.a, pd5Var3);
                                throw th;
                            }
                        }
                    }
                    return new ReadCacheRespMsg(this.a, pd5Var3);
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }
}
