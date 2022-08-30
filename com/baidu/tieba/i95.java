package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tieba.v85;
import com.baidu.tieba.ve;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i95<T extends v85> extends g95<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i95(int i, String str, Class<T> cls) {
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
        v85 v85Var;
        byte[] bArr;
        v85 v85Var2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
            return (CustomResponsedMessage) invokeL.objValue;
        }
        v85 v85Var3 = null;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        v85 v85Var4 = (v85) a();
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
                if (v85Var4 != null) {
                    if (readCacheMessage.getRequestData() == null) {
                        try {
                            if (v85Var4 instanceof u85) {
                                vr4.f();
                                List<ve.b<byte[]>> a = wi.a(vr4.e(this.b, str));
                                if (a != null) {
                                    arrayList = new ArrayList(a.size());
                                    for (ve.b<byte[]> bVar : a) {
                                        if (bVar != null && (bArr = bVar.b) != null && (v85Var2 = (v85) a()) != null) {
                                            ((u85) v85Var2).initByByteArray(bArr);
                                            arrayList.add(v85Var2);
                                        }
                                    }
                                    v85Var3 = arrayList;
                                }
                            } else if (v85Var4 instanceof x85) {
                                vr4.f();
                                List<ve.b<String>> b = wi.b(vr4.h(this.b, str));
                                if (b != null) {
                                    arrayList = new ArrayList(b.size());
                                    for (ve.b<String> bVar2 : b) {
                                        if (bVar2 != null && (str2 = bVar2.b) != null && (v85Var = (v85) a()) != null) {
                                            ((x85) v85Var).q(str2);
                                            arrayList.add(v85Var);
                                        }
                                    }
                                    v85Var3 = arrayList;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            v85Var3 = v85Var4;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.a, v85Var3);
                        } catch (Throwable th) {
                            th = th;
                            v85Var3 = v85Var4;
                            new ReadCacheRespMsg(this.a, v85Var3);
                            throw th;
                        }
                    } else {
                        String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                        String y = readCacheMessage.getRequestData().y();
                        try {
                            if (v85Var4 instanceof u85) {
                                vr4.f();
                                byte[] bArr2 = vr4.e(y, str).get(cacheKey);
                                if (bArr2 != null) {
                                    ((u85) v85Var4).initByByteArray(bArr2);
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(v85Var4);
                                    y = arrayList2;
                                    v85Var3 = y;
                                }
                            } else if (v85Var4 instanceof x85) {
                                vr4.f();
                                String str3 = vr4.h(y, str).get(cacheKey);
                                if (str3 != null) {
                                    ((x85) v85Var4).q(str3);
                                    ?? arrayList3 = new ArrayList();
                                    arrayList3.add(v85Var4);
                                    y = arrayList3;
                                    v85Var3 = y;
                                }
                            }
                        } catch (Exception e2) {
                            v85Var3 = y;
                            e = e2;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.a, v85Var3);
                        } catch (Throwable th2) {
                            v85Var3 = y;
                            th = th2;
                            new ReadCacheRespMsg(this.a, v85Var3);
                            throw th;
                        }
                    }
                }
                return new ReadCacheRespMsg(this.a, v85Var3);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
