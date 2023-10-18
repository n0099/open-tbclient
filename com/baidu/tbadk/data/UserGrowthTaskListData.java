package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes5.dex */
public class UserGrowthTaskListData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("daily_task")
    public List<UserGrowthTaskData> dailyTask;
    @SerializedName("switch")
    public int growthSwitch;
    @SerializedName("icon_task")
    public List<UserGrowthTaskData> iconTask;
    @SerializedName("novice_task")
    public List<UserGrowthTaskData> noviceTask;

    /* loaded from: classes5.dex */
    public static class UserGrowthTaskData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("act_type")
        public String actType;
        @SerializedName("activate_token")
        public String activateToken;
        public String brief;
        @SerializedName("client_type")
        public int clientType;
        public String comment;
        @SerializedName("complete_time")
        public String completeTime;
        @SerializedName("create_time")
        public long createTime;
        @SerializedName("dotask_status")
        public int dotaskStatus;
        public String ext;
        public int id;
        @SerializedName("is_continuous")
        public int isContinuous;
        @SerializedName("is_need_active")
        public int isNeedActive;
        @SerializedName("is_plat_task")
        public int isPlatTask;
        public int month;
        public String name;
        @SerializedName("plat_act_id")
        public int platActId;
        @SerializedName("plat_act_token")
        public String platActToken;
        @SerializedName("plat_platform_type_id")
        public int platPlatformTypeId;
        @SerializedName("plat_task_id")
        public int platTaskId;
        @SerializedName("plat_task_token")
        public String platTaskToken;
        @SerializedName("scene_callback")
        public String sceneCallback;
        @SerializedName("scene_id")
        public int sceneId;
        @SerializedName("scene_task_key")
        public String sceneTaskKey;
        @SerializedName("start_time")
        public long startTime;
        public int status;
        @SerializedName("target_num")
        public int targetNum;
        @SerializedName("task_icon_url")
        public String taskIconUrl;
        @SerializedName("task_progress")
        public UserGrowthTaskProgressData taskProgress;
        @SerializedName("task_type")
        public int taskType;
        @SerializedName("time_interval")
        public long timeInterval;
        @SerializedName("update_time")
        public long updateTime;
        public int week;
        public int weight;

        /* loaded from: classes5.dex */
        public static class UserGrowthTaskProgressData implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long current;
            public long total;

            public UserGrowthTaskProgressData() {
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

            public long getCurrent() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.current;
                }
                return invokeV.longValue;
            }

            public long getTotal() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.total;
                }
                return invokeV.longValue;
            }

            public void setCurrent(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                    this.current = j;
                }
            }

            public void setTotal(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
                    this.total = j;
                }
            }
        }

        public UserGrowthTaskData() {
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

        public String getActType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.actType;
            }
            return (String) invokeV.objValue;
        }

        public String getActivateToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.activateToken;
            }
            return (String) invokeV.objValue;
        }

        public String getBrief() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.brief;
            }
            return (String) invokeV.objValue;
        }

        public int getClientType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.clientType;
            }
            return invokeV.intValue;
        }

        public String getComment() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.comment;
            }
            return (String) invokeV.objValue;
        }

        public String getCompleteTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.completeTime;
            }
            return (String) invokeV.objValue;
        }

        public long getCreateTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.createTime;
            }
            return invokeV.longValue;
        }

        public int getDotaskStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.dotaskStatus;
            }
            return invokeV.intValue;
        }

        public String getExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.ext;
            }
            return (String) invokeV.objValue;
        }

        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.id;
            }
            return invokeV.intValue;
        }

        public int getIsContinuous() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.isContinuous;
            }
            return invokeV.intValue;
        }

        public int getIsNeedActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.isNeedActive;
            }
            return invokeV.intValue;
        }

        public int getIsPlatTask() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.isPlatTask;
            }
            return invokeV.intValue;
        }

        public int getMonth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.month;
            }
            return invokeV.intValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }

        public int getPlatActId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.platActId;
            }
            return invokeV.intValue;
        }

        public String getPlatActToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.platActToken;
            }
            return (String) invokeV.objValue;
        }

        public int getPlatPlatformTypeId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.platPlatformTypeId;
            }
            return invokeV.intValue;
        }

        public int getPlatTaskId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.platTaskId;
            }
            return invokeV.intValue;
        }

        public String getPlatTaskToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.platTaskToken;
            }
            return (String) invokeV.objValue;
        }

        public String getSceneCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.sceneCallback;
            }
            return (String) invokeV.objValue;
        }

        public int getSceneId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.sceneId;
            }
            return invokeV.intValue;
        }

        public String getSceneTaskKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.sceneTaskKey;
            }
            return (String) invokeV.objValue;
        }

        public long getStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.startTime;
            }
            return invokeV.longValue;
        }

        public int getStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.status;
            }
            return invokeV.intValue;
        }

        public int getTargetNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.targetNum;
            }
            return invokeV.intValue;
        }

        public String getTaskIconUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                return this.taskIconUrl;
            }
            return (String) invokeV.objValue;
        }

        public UserGrowthTaskProgressData getTaskProgress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return this.taskProgress;
            }
            return (UserGrowthTaskProgressData) invokeV.objValue;
        }

        public int getTaskType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                return this.taskType;
            }
            return invokeV.intValue;
        }

        public long getTimeInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                return this.timeInterval;
            }
            return invokeV.longValue;
        }

        public long getUpdateTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                return this.updateTime;
            }
            return invokeV.longValue;
        }

        public int getWeek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                return this.week;
            }
            return invokeV.intValue;
        }

        public int getWeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                return this.weight;
            }
            return invokeV.intValue;
        }

        public void setActType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
                this.actType = str;
            }
        }

        public void setActivateToken(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
                this.activateToken = str;
            }
        }

        public void setBrief(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
                this.brief = str;
            }
        }

        public void setClientType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
                this.clientType = i;
            }
        }

        public void setComment(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
                this.comment = str;
            }
        }

        public void setCompleteTime(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
                this.completeTime = str;
            }
        }

        public void setCreateTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048615, this, j) == null) {
                this.createTime = j;
            }
        }

        public void setDotaskStatus(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
                this.dotaskStatus = i;
            }
        }

        public void setExt(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
                this.ext = str;
            }
        }

        public void setId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
                this.id = i;
            }
        }

        public void setIsContinuous(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
                this.isContinuous = i;
            }
        }

        public void setIsNeedActive(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
                this.isNeedActive = i;
            }
        }

        public void setIsPlatTask(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
                this.isPlatTask = i;
            }
        }

        public void setMonth(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
                this.month = i;
            }
        }

        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
                this.name = str;
            }
        }

        public void setPlatActId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
                this.platActId = i;
            }
        }

        public void setPlatActToken(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
                this.platActToken = str;
            }
        }

        public void setPlatPlatformTypeId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
                this.platPlatformTypeId = i;
            }
        }

        public void setPlatTaskId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
                this.platTaskId = i;
            }
        }

        public void setPlatTaskToken(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
                this.platTaskToken = str;
            }
        }

        public void setSceneCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
                this.sceneCallback = str;
            }
        }

        public void setSceneId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
                this.sceneId = i;
            }
        }

        public void setSceneTaskKey(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
                this.sceneTaskKey = str;
            }
        }

        public void setStartTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048632, this, j) == null) {
                this.startTime = j;
            }
        }

        public void setStatus(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
                this.status = i;
            }
        }

        public void setTargetNum(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
                this.targetNum = i;
            }
        }

        public void setTaskIconUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
                this.taskIconUrl = str;
            }
        }

        public void setTaskProgress(UserGrowthTaskProgressData userGrowthTaskProgressData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048636, this, userGrowthTaskProgressData) == null) {
                this.taskProgress = userGrowthTaskProgressData;
            }
        }

        public void setTaskType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048637, this, i) == null) {
                this.taskType = i;
            }
        }

        public void setTimeInterval(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048638, this, j) == null) {
                this.timeInterval = j;
            }
        }

        public void setUpdateTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048639, this, j) == null) {
                this.updateTime = j;
            }
        }

        public void setWeek(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
                this.week = i;
            }
        }

        public void setWeight(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
                this.weight = i;
            }
        }
    }

    public UserGrowthTaskListData() {
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

    public List<UserGrowthTaskData> getDailyTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.dailyTask;
        }
        return (List) invokeV.objValue;
    }

    public int getGrowthSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.growthSwitch;
        }
        return invokeV.intValue;
    }

    public List<UserGrowthTaskData> getIconTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.iconTask;
        }
        return (List) invokeV.objValue;
    }

    public List<UserGrowthTaskData> getNoviceTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.noviceTask;
        }
        return (List) invokeV.objValue;
    }

    public void setDailyTask(List<UserGrowthTaskData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.dailyTask = list;
        }
    }

    public void setGrowthSwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.growthSwitch = i;
        }
    }

    public void setIconTask(List<UserGrowthTaskData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.iconTask = list;
        }
    }

    public void setNoviceTask(List<UserGrowthTaskData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.noviceTask = list;
        }
    }
}
