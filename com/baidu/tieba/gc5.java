package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tieba.kf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class gc5 extends ec5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gc5(int i, String str, Class cls) {
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
    public CustomResponsedMessage run(CustomMessage customMessage) {
        InterceptResult invokeL;
        String str;
        ?? arrayList;
        String str2;
        tb5 tb5Var;
        byte[] bArr;
        tb5 tb5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            tb5 tb5Var3 = null;
            if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
                return null;
            }
            ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
            tb5 tb5Var4 = (tb5) a();
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
                    if (tb5Var4 != null) {
                        if (readCacheMessage.getRequestData() == null) {
                            try {
                                if (tb5Var4 instanceof sb5) {
                                    ou4.f();
                                    List<kf.b> a = lj.a(ou4.e(this.b, str));
                                    if (a != null) {
                                        arrayList = new ArrayList(a.size());
                                        for (kf.b bVar : a) {
                                            if (bVar != null && (bArr = (byte[]) bVar.b) != null && (tb5Var2 = (tb5) a()) != null) {
                                                ((sb5) tb5Var2).initByByteArray(bArr);
                                                arrayList.add(tb5Var2);
                                            }
                                        }
                                        tb5Var3 = arrayList;
                                    }
                                } else if (tb5Var4 instanceof vb5) {
                                    ou4.f();
                                    List<kf.b> b = lj.b(ou4.h(this.b, str));
                                    if (b != null) {
                                        arrayList = new ArrayList(b.size());
                                        for (kf.b bVar2 : b) {
                                            if (bVar2 != null && (str2 = (String) bVar2.b) != null && (tb5Var = (tb5) a()) != null) {
                                                ((vb5) tb5Var).q(str2);
                                                arrayList.add(tb5Var);
                                            }
                                        }
                                        tb5Var3 = arrayList;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                tb5Var3 = tb5Var4;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, tb5Var3);
                            } catch (Throwable th) {
                                th = th;
                                tb5Var3 = tb5Var4;
                                new ReadCacheRespMsg(this.a, tb5Var3);
                                throw th;
                            }
                        } else {
                            String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                            String y = readCacheMessage.getRequestData().y();
                            try {
                                if (tb5Var4 instanceof sb5) {
                                    ou4.f();
                                    byte[] bArr2 = (byte[]) ou4.e(y, str).get(cacheKey);
                                    if (bArr2 != null) {
                                        ((sb5) tb5Var4).initByByteArray(bArr2);
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(tb5Var4);
                                        y = arrayList2;
                                        tb5Var3 = y;
                                    }
                                } else if (tb5Var4 instanceof vb5) {
                                    ou4.f();
                                    String str3 = (String) ou4.h(y, str).get(cacheKey);
                                    if (str3 != null) {
                                        ((vb5) tb5Var4).q(str3);
                                        ?? arrayList3 = new ArrayList();
                                        arrayList3.add(tb5Var4);
                                        y = arrayList3;
                                        tb5Var3 = y;
                                    }
                                }
                            } catch (Exception e2) {
                                tb5Var3 = y;
                                e = e2;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, tb5Var3);
                            } catch (Throwable th2) {
                                tb5Var3 = y;
                                th = th2;
                                new ReadCacheRespMsg(this.a, tb5Var3);
                                throw th;
                            }
                        }
                    }
                    return new ReadCacheRespMsg(this.a, tb5Var3);
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
