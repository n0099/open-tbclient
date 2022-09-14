package com.baidu.tieba.faceshop;

import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FacePackageData extends AbstractImageProvider implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int buy_status;
    public int can_download;
    public String cover_url;
    public long downloadNow;
    public long downloadTotal;
    public int downloaded;
    public int downloading;
    public ArrayList<String> face_dynamic_list;
    public ArrayList<String> face_list;
    public String pdesc;
    public int pid;
    public String pname;
    public String price;
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
    }
}
