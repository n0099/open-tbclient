package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes4.dex */
public class dv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public a d;
    public a e;
    public int f;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public String c;
        public String d;
        public boolean e;
        public long f;
        public String g;

        public a(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public dv7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(PkModule pkModule) {
        String str;
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, pkModule) == null) && pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.b = pkModule.pk_id.longValue();
            this.c = pkModule.user_pk_id.longValue();
            a aVar = new a(this);
            this.d = aVar;
            aVar.a = pkModule.agree.pk_num.longValue();
            a aVar2 = this.d;
            if (StringUtils.isNull(pkModule.agree.pk_desc)) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1535);
            } else {
                str = pkModule.agree.pk_desc;
            }
            aVar2.b = str;
            a aVar3 = this.d;
            PkItem pkItem = pkModule.agree;
            aVar3.c = pkItem.last_username;
            aVar3.d = pkItem.pk_icon;
            boolean z2 = true;
            if (pkItem.has_clicked.longValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            aVar3.e = z;
            this.d.f = pkModule.agree.pk_index.longValue();
            this.d.g = pkModule.agree.pk_icon_after;
            a aVar4 = new a(this);
            this.e = aVar4;
            aVar4.a = pkModule.disagree.pk_num.longValue();
            a aVar5 = this.e;
            if (StringUtils.isNull(pkModule.disagree.pk_desc)) {
                str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1534);
            } else {
                str2 = pkModule.disagree.pk_desc;
            }
            aVar5.b = str2;
            a aVar6 = this.e;
            PkItem pkItem2 = pkModule.disagree;
            aVar6.c = pkItem2.last_username;
            aVar6.d = pkItem2.pk_icon;
            if (pkItem2.has_clicked.longValue() != 1) {
                z2 = false;
            }
            aVar6.e = z2;
            this.e.f = pkModule.disagree.pk_index.longValue();
            this.e.g = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        String str;
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) && pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.b = pkModule.pk_id.longValue();
            this.c = pkModule.user_pk_id.longValue();
            a aVar = new a(this);
            this.d = aVar;
            aVar.a = pkModule.agree.pk_num.longValue();
            a aVar2 = this.d;
            if (StringUtils.isNull(pkModule.agree.pk_desc)) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1535);
            } else {
                str = pkModule.agree.pk_desc;
            }
            aVar2.b = str;
            a aVar3 = this.d;
            tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
            aVar3.c = pkItem.last_username;
            aVar3.d = pkItem.pk_icon;
            boolean z2 = true;
            if (pkItem.has_clicked.longValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            aVar3.e = z;
            this.d.f = pkModule.agree.pk_index.longValue();
            this.d.g = pkModule.agree.pk_icon_after;
            a aVar4 = new a(this);
            this.e = aVar4;
            aVar4.a = pkModule.disagree.pk_num.longValue();
            a aVar5 = this.e;
            if (StringUtils.isNull(pkModule.disagree.pk_desc)) {
                str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1534);
            } else {
                str2 = pkModule.disagree.pk_desc;
            }
            aVar5.b = str2;
            a aVar6 = this.e;
            tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
            aVar6.c = pkItem2.last_username;
            aVar6.d = pkItem2.pk_icon;
            if (pkItem2.has_clicked.longValue() != 1) {
                z2 = false;
            }
            aVar6.e = z2;
            this.e.f = pkModule.disagree.pk_index.longValue();
            this.e.g = pkModule.disagree.pk_icon_after;
        }
    }

    public void c(tbclient.PkModule pkModule) {
        String str;
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) && pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.b = pkModule.pk_id.longValue();
            this.c = pkModule.user_pk_id.longValue();
            a aVar = new a(this);
            this.d = aVar;
            aVar.a = pkModule.agree.pk_num.longValue();
            a aVar2 = this.d;
            if (StringUtils.isNull(pkModule.agree.pk_desc)) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1535);
            } else {
                str = pkModule.agree.pk_desc;
            }
            aVar2.b = str;
            a aVar3 = this.d;
            tbclient.PkItem pkItem = pkModule.agree;
            aVar3.c = pkItem.last_username;
            aVar3.d = pkItem.pk_icon;
            boolean z2 = true;
            if (pkItem.has_clicked.longValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            aVar3.e = z;
            this.d.f = pkModule.agree.pk_index.longValue();
            this.d.g = pkModule.agree.pk_icon_after;
            a aVar4 = new a(this);
            this.e = aVar4;
            aVar4.a = pkModule.disagree.pk_num.longValue();
            a aVar5 = this.e;
            if (StringUtils.isNull(pkModule.disagree.pk_desc)) {
                str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1534);
            } else {
                str2 = pkModule.disagree.pk_desc;
            }
            aVar5.b = str2;
            a aVar6 = this.e;
            tbclient.PkItem pkItem2 = pkModule.disagree;
            aVar6.c = pkItem2.last_username;
            aVar6.d = pkItem2.pk_icon;
            if (pkItem2.has_clicked.longValue() != 1) {
                z2 = false;
            }
            aVar6.e = z2;
            this.e.f = pkModule.disagree.pk_index.longValue();
            this.e.g = pkModule.disagree.pk_icon_after;
        }
    }
}
