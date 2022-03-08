package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class EmotionPackageData extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EMOTION_HITS_STATUS = 5;
    public static final int EMOTION_MINE = 1;
    public static final int EMOTION_NORMAL = 0;
    public static final int EMOTION_SINGLE_THREAD = 2;
    public static final int FOR_CHECK_STATUS = 0;
    public static final int FOR_PACKAGE_STATUS = 3;
    public static final int HAS_DELETE_STATUS = 4;
    public static final int NOT_FOLLOW_FORUM_ERROR_CODE = 170003;
    public static final int NOT_OK_STATUS = 2;
    public static final int OK_STATUS = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String author;
    public String avatar;
    public String cover;
    public String covername;
    public long download;
    public String forum_avatar;
    public int forum_id;
    public String forum_name;
    public int has_vote;
    public int id;
    public boolean isUndownloadheader;
    public boolean ishasdownload;
    public String name;
    public int num;
    public String owner;
    public ArrayList<SingleEmotionData> pics;
    public long share;
    public int status;
    public long timestamp;
    public int type;
    public int typeofemotion;
    public String url;
    public String vote_num;

    /* loaded from: classes5.dex */
    public static class SingleEmotionData extends OrmObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int height;
        public long id;
        public String thumbnail;
        public String url;
        public int width;

        public SingleEmotionData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public EmotionPackageData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
