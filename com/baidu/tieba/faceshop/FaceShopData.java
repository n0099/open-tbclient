package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class FaceShopData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int ctime;
    public String errmsg;
    public int errno;
    public int error_code;
    public int has_more;
    public long logid;
    public ArrayList<FacePackageData> pack_list;
    public long time;
    public int total_num;
    public String usermsg;

    public FaceShopData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.total_num = 0;
        this.has_more = 0;
    }

    public void add(FaceShopData faceShopData) {
        ArrayList<FacePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, faceShopData) == null) || faceShopData == null || (arrayList = faceShopData.pack_list) == null || arrayList.size() == 0) {
            return;
        }
        this.has_more = faceShopData.has_more;
        ArrayList<FacePackageData> arrayList2 = this.pack_list;
        if (arrayList2 != null) {
            arrayList2.addAll(faceShopData.pack_list);
        } else {
            this.pack_list = faceShopData.pack_list;
        }
    }
}
