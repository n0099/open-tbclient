package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.pb.pb.main.pendantrecord.PbPendantRecordCacheModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class fk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public PbPendantRecordCacheModel b;
    public boolean c;
    public boolean d;
    public String e;
    public String f;
    public ArrayList<uj9> g;
    public long h;
    public final CacheModel.CacheModelCallback<uj9> i;

    /* loaded from: classes5.dex */
    public class a implements CacheModel.CacheModelCallback<uj9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk9 a;

        public a(fk9 fk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk9Var;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
        public void onCacheDataGet(ReadCacheRespMsg<List<uj9>> readCacheRespMsg, ReadCacheMessage<uj9> readCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, readCacheRespMsg, readCacheMessage) == null) {
                this.a.c = true;
                if (readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                    this.a.g.clear();
                    this.a.g.addAll(readCacheRespMsg.getData());
                }
                if (this.a.d) {
                    this.a.d = false;
                    if (!TextUtils.isEmpty(this.a.e) && !TextUtils.isEmpty(this.a.f)) {
                        fk9 fk9Var = this.a;
                        fk9Var.n(fk9Var.e, this.a.f);
                        this.a.e = null;
                        this.a.f = null;
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
        public void onCacheDataWrite(WriteCacheRespMsg<List<uj9>> writeCacheRespMsg, WriteCacheMessage<uj9> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeCacheRespMsg, writeCacheMessage) == null) {
                if (writeCacheMessage != null && writeCacheMessage.getData() != null) {
                    this.a.j(writeCacheMessage.getData().getCacheKey(), writeCacheMessage.getData().b(), ListUtils.getCount(writeCacheMessage.getData().c()));
                }
                this.a.p();
            }
        }
    }

    public fk9(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = false;
        this.g = new ArrayList<>();
        this.h = 0L;
        this.i = new a(this);
        this.a = tbPageContext;
    }

    public final ArrayList<String> k(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    @MainThread
    public void q(@NonNull String str) {
        PbPendantRecordCacheModel pbPendantRecordCacheModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || (pbPendantRecordCacheModel = this.b) == null) {
            return;
        }
        pbPendantRecordCacheModel.addCache(new uj9(str, "", new ArrayList()));
    }

    public final void j(@NonNull String str, @NonNull String str2, int i) {
        tv9 g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i) == null) && (g = uv9.e().g("pb_to_personalize")) != null && g.e() > 0 && uv9.e().b("pb_to_personalize") && i >= g.e()) {
            sr6.b().b(new te9(true, JavaTypesHelper.toLong(str2, 0L)));
            if (this.a != null && !TextUtils.isEmpty(str)) {
                String string = this.a.getResources().getString(R.string.push_tip_default_title);
                String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ff6, str);
                g.h(string);
                g.g(string2);
            }
            q(str);
        }
    }

    @NonNull
    public final ArrayList l(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (ListUtils.isEmpty(this.g)) {
                this.g = new ArrayList<>();
            }
            Iterator<uj9> it = this.g.iterator();
            while (it.hasNext()) {
                uj9 next = it.next();
                if (next != null && str.equals(next.a())) {
                    ArrayList<String> c = next.c();
                    if (next.d() < this.h) {
                        c.clear();
                        c.add(str2);
                        return c;
                    } else if (c.contains(str2)) {
                        return c;
                    } else {
                        c.add(str2);
                        return c;
                    }
                }
            }
            return k(str2);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public fk9 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b == null) {
                PbPendantRecordCacheModel pbPendantRecordCacheModel = new PbPendantRecordCacheModel(this.a);
                this.b = pbPendantRecordCacheModel;
                pbPendantRecordCacheModel.setCallback(this.i);
                this.h = UtilHelper.getTodayZeroTime();
                p();
            }
            return this;
        }
        return (fk9) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && NotificationManagerCompat.from(this.a.getPageActivity()).areNotificationsEnabled()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        PbPendantRecordCacheModel pbPendantRecordCacheModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (pbPendantRecordCacheModel = this.b) == null) {
            return;
        }
        pbPendantRecordCacheModel.loadCache();
    }

    @MainThread
    public void n(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.b != null && !TextUtils.isEmpty(str)) {
            if (!this.c) {
                this.d = true;
                this.e = str;
                this.f = str2;
                p();
                return;
            }
            this.b.addCache(new uj9(str, str2, l(str, str2)));
        }
    }
}
