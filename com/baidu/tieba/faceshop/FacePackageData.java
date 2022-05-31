package com.baidu.tieba.faceshop;

import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ki;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FacePackageData extends AbstractImageProvider implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String banner_url;
    public int buy_status;
    public int can_download;
    public String cover_url;
    public long downloadNow;
    public long downloadTotal;
    public int downloaded;
    public int downloading;
    public ArrayList<String> face_dynamic_list;
    public ArrayList<String> face_list;
    public ArrayList<String> face_name_list;
    public String icon_url;
    public String new_icon;
    public String orderId;
    public String pack_url;
    public String pdesc;
    public int pid;
    public String pname;
    public String price;
    public String recmd_url;
    public int size_height;
    public int size_width;
    public String tag_url;

    public FacePackageData() {
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
        this.downloaded = 0;
        this.downloading = 0;
        this.downloadTotal = 0L;
        this.downloadNow = 0L;
        this.orderId = "";
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (!ki.isEmpty(this.banner_url)) {
                arrayList.add(this.banner_url);
            }
            if (!ki.isEmpty(this.new_icon)) {
                arrayList.add(this.new_icon);
            }
            if (!ki.isEmpty(this.tag_url)) {
                arrayList.add(this.tag_url);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
