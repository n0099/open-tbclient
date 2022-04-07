package com.baidu.tieba.external.music.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MusicData extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MUSIC_CLOUD_ID = "-200";
    public static final String MUSIC_NORMAL_ID = "-100";
    public static final int TYPE_CLOUD = 2;
    public static final int TYPE_MUSIC = 0;
    public static final int TYPE_NORMAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String duration;
    public int editMusicType;
    public String id;
    public String img;
    public String name;
    public String resource;
    public String seq;
    public String status;
    public String type;

    public MusicData() {
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
        this.editMusicType = 0;
    }

    public MusicData(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.editMusicType = 0;
        this.id = str;
        this.editMusicType = i;
        this.name = str2;
    }
}
