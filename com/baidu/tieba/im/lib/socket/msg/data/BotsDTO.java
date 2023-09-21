package com.baidu.tieba.im.lib.socket.msg.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.im.dispatcher.PersonalMsgSettingDispatcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class BotsDTO extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -313586391413374981L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("bot_list")
    public List<BotListDTO> botList;
    @SerializedName("guide")
    public String guide;

    /* loaded from: classes6.dex */
    public static class BotListDTO extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("at_guide")
        public String atGuide;
        @SerializedName("guide")
        public String guide;
        @SerializedName("scene")
        public String scene;
        @SerializedName("skill")
        public List<SkillDTO> skill;
        @SerializedName("user")
        public UserDTO user;

        /* loaded from: classes6.dex */
        public static class SkillDTO extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final String ALIAS = "alias";
            public static final String FORMAT = "\\$\\{skill.%1$s\\}";
            public static final String KEYBOARD = "keyboard";
            public static final String NAME = "name";
            public static final long serialVersionUID = -757491177728675334L;
            public transient /* synthetic */ FieldHolder $fh;
            @SerializedName("func_conf")
            public AbilityItem abilityItem;
            @SerializedName("alias")
            public String alias;
            @SerializedName(ShareCallPacking.StatModel.KEY_CALL_TYPE)
            public int callType;
            @SerializedName("desc")
            public String desc;
            @SerializedName("exec")
            public int exec;
            @SerializedName("exp")
            public String exp;
            @SerializedName("func_type")
            public int funcType;
            @SerializedName("is_show")
            public int isShow;
            @SerializedName("items")
            public List<ItemsDTO> items;
            @SerializedName("keyboard")
            public int keyboard;
            @Nullable
            @SerializedName("keyboard_content")
            public String keyboardContent;
            @SerializedName("keyboard_type")
            public int keyboardType;
            @SerializedName("name")
            public String name;
            @Nullable
            @SerializedName(MediaTrackConfig.AE_IMPORT_TEMPLATE)
            public String showTemplate;
            @SerializedName("sub_skill")
            public List<SkillDTO> subSkill;
            @SerializedName("type")
            public int type;

            /* loaded from: classes6.dex */
            public static class ItemsDTO extends OrmObject implements Serializable {
                public static /* synthetic */ Interceptable $ic = null;
                public static final String FORMAT = "\\$\\{%1$s.key.%2$s\\}";
                public static final long serialVersionUID = -5238062091986617562L;
                public transient /* synthetic */ FieldHolder $fh;
                @Nullable
                public String alias;
                @SerializedName("type")
                public int itemType;
                @SerializedName("name")
                public String name;
                @SerializedName("optional")
                public int optional;
                @SerializedName("opts")
                public List<OptsDTO> opts;
                @SerializedName("value")
                public String value;

                /* loaded from: classes6.dex */
                public static class OptsDTO extends OrmObject implements Serializable {
                    public static /* synthetic */ Interceptable $ic = null;
                    public static final String FORMAT = "\\$\\{%1$s.value.%2$s\\}";
                    public static final long serialVersionUID = 4936592687580444738L;
                    public transient /* synthetic */ FieldHolder $fh;
                    @Nullable
                    public String alias;
                    @SerializedName("default")
                    public int defaultX;
                    @Nullable
                    public Ext ext;
                    @SerializedName("name")
                    public String name;
                    @Nullable
                    @SerializedName(MediaTrackConfig.AE_IMPORT_TEMPLATE)
                    public String showTemplate;

                    /* loaded from: classes6.dex */
                    public static class Ext extends OrmObject implements Serializable {
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = -3301778482938927776L;
                        public transient /* synthetic */ FieldHolder $fh;
                        @Nullable
                        public List<AtSelectData> atUserInfos;
                        public String picPath;
                        public String picSize;

                        public Ext() {
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

                        @Nullable
                        public List<AtSelectData> getAtUserInfos() {
                            InterceptResult invokeV;
                            Interceptable interceptable = $ic;
                            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                                return this.atUserInfos;
                            }
                            return (List) invokeV.objValue;
                        }

                        public String getPicPath() {
                            InterceptResult invokeV;
                            Interceptable interceptable = $ic;
                            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return this.picPath;
                            }
                            return (String) invokeV.objValue;
                        }

                        public String getPicSize() {
                            InterceptResult invokeV;
                            Interceptable interceptable = $ic;
                            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                                return this.picSize;
                            }
                            return (String) invokeV.objValue;
                        }

                        public void setAtUserInfos(@Nullable List<AtSelectData> list) {
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                                this.atUserInfos = list;
                            }
                        }

                        public void setPicPath(String str) {
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                                this.picPath = str;
                            }
                        }

                        public void setPicSize(String str) {
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                                this.picSize = str;
                            }
                        }
                    }

                    public OptsDTO() {
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

                    public OptsDTO copy() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                            OptsDTO optsDTO = new OptsDTO();
                            optsDTO.defaultX = this.defaultX;
                            optsDTO.name = this.name;
                            optsDTO.alias = this.alias;
                            optsDTO.ext = this.ext;
                            optsDTO.showTemplate = this.showTemplate;
                            return optsDTO;
                        }
                        return (OptsDTO) invokeV.objValue;
                    }

                    @Nullable
                    public String getAlias() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return this.alias;
                        }
                        return (String) invokeV.objValue;
                    }

                    public int getDefaultX() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                            return this.defaultX;
                        }
                        return invokeV.intValue;
                    }

                    @Nullable
                    public Ext getExt() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                            return this.ext;
                        }
                        return (Ext) invokeV.objValue;
                    }

                    public String getName() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                            return this.name;
                        }
                        return (String) invokeV.objValue;
                    }

                    @Nullable
                    public String getShowTemplate() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                            return this.showTemplate;
                        }
                        return (String) invokeV.objValue;
                    }

                    @Nullable
                    public String getAliasHolder(@NonNull String str) {
                        InterceptResult invokeL;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                            return String.format(FORMAT, str, "alias");
                        }
                        return (String) invokeL.objValue;
                    }

                    @Nullable
                    public String getNameHolder(@NonNull String str) {
                        InterceptResult invokeL;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                            return String.format(FORMAT, str, "name");
                        }
                        return (String) invokeL.objValue;
                    }

                    public void setDefaultX(int i) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                            this.defaultX = i;
                        }
                    }

                    public void setExt(@Nullable Ext ext) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeL(1048585, this, ext) == null) {
                            this.ext = ext;
                        }
                    }

                    public void setName(String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                            this.name = str;
                        }
                    }
                }

                public ItemsDTO() {
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

                @Nullable
                public String getAlias() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return this.alias;
                    }
                    return (String) invokeV.objValue;
                }

                @Nullable
                public String getAliasHolder() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return String.format(FORMAT, this.value, "alias");
                    }
                    return (String) invokeV.objValue;
                }

                public int getItemType() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                        return this.itemType;
                    }
                    return invokeV.intValue;
                }

                public String getName() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                        return this.name;
                    }
                    return (String) invokeV.objValue;
                }

                @Nullable
                public String getNameHolder() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                        return String.format(FORMAT, this.value, "name");
                    }
                    return (String) invokeV.objValue;
                }

                @Nullable
                public List<OptsDTO> getOpts() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                        return this.opts;
                    }
                    return (List) invokeV.objValue;
                }

                public String getValue() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                        return this.value;
                    }
                    return (String) invokeV.objValue;
                }

                public boolean isAtType() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        if (this.itemType == 2) {
                            return true;
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                public boolean isFileType() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                        if (this.itemType == 1) {
                            return true;
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                public boolean isNormalType() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                        if (this.itemType == 0) {
                            return true;
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                public boolean isOptional() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                        if (this.optional == 1) {
                            return true;
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                public ItemsDTO copy() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        ItemsDTO itemsDTO = new ItemsDTO();
                        itemsDTO.name = this.name;
                        itemsDTO.value = this.value;
                        itemsDTO.alias = this.alias;
                        itemsDTO.itemType = this.itemType;
                        itemsDTO.optional = this.optional;
                        if (!ListUtils.isEmpty(this.opts)) {
                            itemsDTO.opts = new ArrayList();
                            for (OptsDTO optsDTO : this.opts) {
                                itemsDTO.opts.add(optsDTO.copy());
                            }
                        }
                        return itemsDTO;
                    }
                    return (ItemsDTO) invokeV.objValue;
                }

                public void setItemType(int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                        this.itemType = i;
                    }
                }

                public void setName(String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                        this.name = str;
                    }
                }

                public void setOpts(List<OptsDTO> list) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
                        this.opts = list;
                    }
                }

                public void setValue(String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                        this.value = str;
                    }
                }
            }

            public SkillDTO() {
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

            @Nullable
            public AbilityItem getAbilityItem() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.abilityItem;
                }
                return (AbilityItem) invokeV.objValue;
            }

            public String getAlias() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.alias;
                }
                return (String) invokeV.objValue;
            }

            @Nullable
            public String getAliasHolder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return String.format(FORMAT, "alias");
                }
                return (String) invokeV.objValue;
            }

            public int getCallType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    return this.callType;
                }
                return invokeV.intValue;
            }

            public String getDesc() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return this.desc;
                }
                return (String) invokeV.objValue;
            }

            public int getExec() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    return this.exec;
                }
                return invokeV.intValue;
            }

            public String getExp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    return this.exp;
                }
                return (String) invokeV.objValue;
            }

            public int getFuncType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    return this.funcType;
                }
                return invokeV.intValue;
            }

            @Nullable
            public List<ItemsDTO> getItems() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    return this.items;
                }
                return (List) invokeV.objValue;
            }

            public int getKeyboard() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    return this.keyboard;
                }
                return invokeV.intValue;
            }

            @Nullable
            public String getKeyboardContent() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    return this.keyboardContent;
                }
                return (String) invokeV.objValue;
            }

            @Nullable
            public String getKeyboardHolder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    return String.format(FORMAT, "keyboard");
                }
                return (String) invokeV.objValue;
            }

            public int getKeyboardType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    return this.keyboardType;
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

            @Nullable
            public List<SkillDTO> getSubSkill() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    return this.subSkill;
                }
                return (List) invokeV.objValue;
            }

            public int getType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    return this.type;
                }
                return invokeV.intValue;
            }

            public boolean isCanKeyboardInput() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    if (this.keyboard == 1) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            public boolean isFuncJump() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    if (this.funcType == 1) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            public boolean isFuncSendMsg() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    if (this.funcType == 2) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            public boolean isFuncShowPanel() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    if (this.funcType == 0) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            public boolean isShow() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                    if (this.isShow == 1) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            public SkillDTO copy() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    SkillDTO skillDTO = new SkillDTO();
                    skillDTO.type = this.type;
                    skillDTO.name = this.name;
                    skillDTO.alias = this.alias;
                    skillDTO.desc = this.desc;
                    skillDTO.exp = this.exp;
                    skillDTO.exec = this.exec;
                    skillDTO.callType = this.callType;
                    skillDTO.keyboard = this.keyboard;
                    skillDTO.keyboardType = this.keyboardType;
                    skillDTO.keyboardContent = this.keyboardContent;
                    skillDTO.showTemplate = this.showTemplate;
                    skillDTO.funcType = this.funcType;
                    skillDTO.isShow = this.isShow;
                    skillDTO.abilityItem = this.abilityItem;
                    if (!ListUtils.isEmpty(this.items)) {
                        skillDTO.items = new ArrayList();
                        for (ItemsDTO itemsDTO : this.items) {
                            skillDTO.items.add(itemsDTO.copy());
                        }
                    }
                    if (!ListUtils.isEmpty(this.subSkill)) {
                        skillDTO.subSkill = new ArrayList();
                        for (SkillDTO skillDTO2 : this.subSkill) {
                            skillDTO.subSkill.add(skillDTO2.copy());
                        }
                    }
                    return skillDTO;
                }
                return (SkillDTO) invokeV.objValue;
            }

            @Nullable
            public String getShowTemplate(@Nullable List<ItemsDTO> list) {
                InterceptResult invokeL;
                List<ItemsDTO.OptsDTO> opts;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, list)) == null) {
                    String str = this.showTemplate;
                    if (list != null && !list.isEmpty()) {
                        for (ItemsDTO itemsDTO : list) {
                            if (itemsDTO != null && (opts = itemsDTO.getOpts()) != null && !opts.isEmpty()) {
                                String showTemplate = opts.get(0).getShowTemplate();
                                if (!TextUtils.isEmpty(showTemplate)) {
                                    return showTemplate;
                                }
                            }
                        }
                        return str;
                    }
                    return str;
                }
                return (String) invokeL.objValue;
            }

            public boolean trySetAtUserList(@NonNull ArrayList<AtSelectData> arrayList) {
                InterceptResult invokeL;
                List<ItemsDTO.OptsDTO> opts;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, arrayList)) == null) {
                    List<ItemsDTO> list = this.items;
                    if (list != null && !list.isEmpty()) {
                        for (ItemsDTO itemsDTO : this.items) {
                            if (itemsDTO.isAtType() && (opts = itemsDTO.getOpts()) != null && !opts.isEmpty()) {
                                ItemsDTO.OptsDTO optsDTO = opts.get(0);
                                if (optsDTO.getExt() == null) {
                                    optsDTO.setExt(new ItemsDTO.OptsDTO.Ext());
                                }
                                optsDTO.getExt().setAtUserInfos(arrayList);
                                return true;
                            }
                        }
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public void setAlias(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
                    this.alias = str;
                }
            }

            public void setCallType(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
                    this.callType = i;
                }
            }

            public void setDesc(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
                    this.desc = str;
                }
            }

            public void setExec(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
                    this.exec = i;
                }
            }

            public void setExp(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
                    this.exp = str;
                }
            }

            public void setFuncType(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
                    this.funcType = i;
                }
            }

            public void setItems(List<ItemsDTO> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
                    this.items = list;
                }
            }

            public void setKeyboard(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
                    this.keyboard = i;
                }
            }

            public void setKeyboardContent(@Nullable String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
                    this.keyboardContent = str;
                }
            }

            public void setName(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
                    this.name = str;
                }
            }

            public void setSubSkill(List<SkillDTO> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
                    this.subSkill = list;
                }
            }

            public void setType(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
                    this.type = i;
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class UserDTO extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @SerializedName("forum_level")
            public int forumLevel;
            @SerializedName("name")
            public String name;
            @SerializedName("name_show")
            public String nameShow;
            @SerializedName("portrait")
            public String portrait;
            @SerializedName(PersonalMsgSettingDispatcher.PERSONAL_ROBOT_ROLE)
            public int robotRole;
            @SerializedName("uk")
            public String uk;

            public UserDTO() {
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

            public int getForumLevel() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.forumLevel;
                }
                return invokeV.intValue;
            }

            public String getName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.name;
                }
                return (String) invokeV.objValue;
            }

            public String getNameShow() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.nameShow;
                }
                return (String) invokeV.objValue;
            }

            public String getPortrait() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return this.portrait;
                }
                return (String) invokeV.objValue;
            }

            public int getRobotRole() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    return this.robotRole;
                }
                return invokeV.intValue;
            }

            public String getUk() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return this.uk;
                }
                return (String) invokeV.objValue;
            }

            public void setForumLevel(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                    this.forumLevel = i;
                }
            }

            public void setName(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                    this.name = str;
                }
            }

            public void setNameShow(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                    this.nameShow = str;
                }
            }

            public void setPortrait(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                    this.portrait = str;
                }
            }

            public void setRobotRole(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                    this.robotRole = i;
                }
            }

            public void setUk(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                    this.uk = str;
                }
            }
        }

        public BotListDTO() {
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

        public String getAtGuide() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.atGuide;
            }
            return (String) invokeV.objValue;
        }

        public String getGuide() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.guide;
            }
            return (String) invokeV.objValue;
        }

        public String getScene() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.scene;
            }
            return (String) invokeV.objValue;
        }

        public List<SkillDTO> getSkill() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.skill;
            }
            return (List) invokeV.objValue;
        }

        public UserDTO getUser() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.user;
            }
            return (UserDTO) invokeV.objValue;
        }

        @Nullable
        public SkillDTO cloneSkillById(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                List<SkillDTO> list = this.skill;
                if (list != null && !list.isEmpty()) {
                    for (SkillDTO skillDTO : this.skill) {
                        if (i == skillDTO.getType()) {
                            return skillDTO.copy();
                        }
                    }
                }
                return null;
            }
            return (SkillDTO) invokeI.objValue;
        }

        public void setAtGuide(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.atGuide = str;
            }
        }

        public void setGuide(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.guide = str;
            }
        }

        public void setScene(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.scene = str;
            }
        }

        public void setSkill(List<SkillDTO> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
                this.skill = list;
            }
        }

        public void setUser(UserDTO userDTO) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, userDTO) == null) {
                this.user = userDTO;
            }
        }
    }

    public BotsDTO() {
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

    public List<BotListDTO> getBotList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.botList;
        }
        return (List) invokeV.objValue;
    }

    public String getGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.guide)) {
                return TbadkCoreApplication.getInst().getString(R.string.im_msg_input_hint);
            }
            return this.guide;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public BotListDTO.SkillDTO cloneSkillByBotUkAndSkillId(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            BotListDTO findBotByUk = findBotByUk(str);
            if (findBotByUk == null) {
                return null;
            }
            return findBotByUk.cloneSkillById(i);
        }
        return (BotListDTO.SkillDTO) invokeLI.objValue;
    }

    @Nullable
    public BotListDTO findBotByUk(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            List<BotListDTO> list = this.botList;
            if (list != null && !list.isEmpty()) {
                for (BotListDTO botListDTO : this.botList) {
                    if (botListDTO != null && botListDTO.getUser() != null && str.equals(botListDTO.getUser().getUk())) {
                        return botListDTO;
                    }
                }
            }
            return null;
        }
        return (BotListDTO) invokeL.objValue;
    }

    public void setBotList(List<BotListDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.botList = list;
        }
    }

    public void setGuide(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.guide = str;
        }
    }
}
