package com.baidu.tbadk.game;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kg;
import com.repackage.y65;
import java.io.Serializable;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetGameCenter.RecommendGame;
import tbclient.GetGameDetailNew.CodeInfo;
import tbclient.GetGameDetailNew.GiftPkgInfo;
import tbclient.GetNewGameList.NewGameInfo;
/* loaded from: classes3.dex */
public class GameInfoData implements Serializable, y65 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_TYPE = 1;
    public static final int H5_TYPE = 2;
    public static final String IS_FROM_DETAIL = "1";
    public static final int NEW_MARK = 2;
    public static final String NOT_FROM_DETAIL = "0";
    public static final int NO_MARK = 0;
    public static final int WAITING_MARK = 1;
    public static final long serialVersionUID = -3662330595966807760L;
    public transient /* synthetic */ FieldHolder $fh;
    public String app_id;
    public String apple_id;
    public String bundle_id;
    public int category_id;
    public String category_name;
    public String category_name_sim;
    public CodeInfo codeInfo;
    public boolean currentStatusUpSuccess;
    public int day_downloads;
    public long deadline;
    public long downloadTime;
    public String editor_rec;
    public int fromView;
    public String game_desc;
    public String game_id;
    public String game_link;
    public String game_name;
    public List<String> game_pic;
    public int game_status;
    public int game_type;
    public List<GiftPkgInfo> giftPackages;
    public String icon_pic1;
    public String icon_pic2;
    public String icon_pic3;
    public String icon_url;
    public long installTime;
    public String introduce;
    public String is_detail;
    public String launcherActivity;
    public int mark;
    public long orderTime;
    public String packageName;
    public String package_link;
    public String package_size;
    public int player_num;
    public String ref_id;
    public String ref_type;
    public String schema_url;
    public int score;
    public String secret_key;
    public String server_id;
    public String server_name;
    public int server_open_time;
    public int server_type;
    public int star;
    public String superscript_color;
    public int upStatus;
    public List<GameInfoData> userRecommendList;
    public String version;

    public GameInfoData() {
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
        this.fromView = 0;
        this.ref_id = GameCenterCoreUtils.REF_TYPE_OTHER;
        this.ref_type = GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER;
        this.is_detail = "0";
    }

    private String dealPackageSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) ? String.format("%.1f", Float.valueOf(kg.d(str, 0.0f))) : (String) invokeL.objValue;
    }

    public static GameInfoData fromGameInfo(GameInfo gameInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gameInfo)) == null) {
            GameInfoData gameInfoData = new GameInfoData();
            if (gameInfo == null) {
                return gameInfoData;
            }
            gameInfoData.setAppleId(gameInfo.apple_id);
            gameInfoData.setBundleId(gameInfo.bundle_id);
            gameInfoData.setGameId(gameInfo.game_id);
            gameInfoData.setGameLink(gameInfo.game_link);
            gameInfoData.setGameName(gameInfo.game_name);
            gameInfoData.setGamePic(gameInfo.game_pic);
            if (TextUtils.isEmpty(gameInfo.icon_pic1)) {
                gameInfoData.setIconUrl(gameInfo.icon_url);
            } else {
                gameInfoData.setIconUrl(gameInfo.icon_pic1);
            }
            gameInfoData.setGameType(gameInfo.game_type.intValue());
            gameInfoData.setMark(gameInfo.mark.intValue());
            gameInfoData.setPackageLink(gameInfo.package_link);
            gameInfoData.setPackageSize(gameInfo.package_size);
            gameInfoData.setPlayerNum(gameInfo.player_num);
            gameInfoData.setSchemaUrl(gameInfo.schema_url);
            if (TextUtils.isEmpty(gameInfo.game_desc)) {
                gameInfoData.setIntroduce(gameInfo.introduce);
            } else {
                gameInfoData.setIntroduce(gameInfo.game_desc);
            }
            if (TextUtils.isEmpty(gameInfo.launchComponent)) {
                gameInfoData.setLauncherActivity(gameInfo.launch_component);
            } else {
                gameInfoData.setLauncherActivity(gameInfo.launchComponent);
            }
            gameInfoData.setPackageName(gameInfo.andr_pk_name);
            Long l = gameInfo.deadline;
            if (l != null) {
                gameInfoData.setDeadline(l.longValue());
            }
            gameInfoData.setEditorRec(gameInfo.editor_rec);
            gameInfoData.setDayDownloads(gameInfo.day_downloads.intValue());
            gameInfoData.setCategoryId(gameInfo.category_id.intValue());
            gameInfoData.setCategoryName(gameInfo.category_name);
            gameInfoData.setCategoryNameSim(gameInfo.category_name_sim);
            gameInfoData.setVersion(gameInfo.version);
            if (gameInfo.score.intValue() != 0) {
                gameInfoData.setStar(gameInfo.score.intValue());
            } else {
                gameInfoData.setStar(gameInfo.star.intValue());
            }
            gameInfoData.setSecretKey(gameInfo.secret_key);
            if (TextUtils.isEmpty(gameInfo.subscript_color)) {
                gameInfoData.setSuperscriptColor(gameInfo.superscript_color);
            } else {
                gameInfoData.setSuperscriptColor(gameInfo.subscript_color);
            }
            gameInfoData.setApp_id(String.valueOf(gameInfo.app_id));
            gameInfoData.setRefId(GameCenterCoreUtils.REF_TYPE_OTHER);
            return gameInfoData;
        }
        return (GameInfoData) invokeL.objValue;
    }

    public static GameInfoData fromNewGame(NewGameInfo newGameInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, newGameInfo)) == null) {
            GameInfoData gameInfoData = new GameInfoData();
            if (newGameInfo == null) {
                return gameInfoData;
            }
            gameInfoData.setServerId(newGameInfo.server_id);
            gameInfoData.setServerName(newGameInfo.server_name);
            gameInfoData.setServerOpenTime(newGameInfo.server_open_time.intValue());
            gameInfoData.setServerType(newGameInfo.server_type.intValue());
            gameInfoData.setAppleId(newGameInfo.apple_id);
            gameInfoData.setBundleId(newGameInfo.bundle_id);
            gameInfoData.setGameId(newGameInfo.game_id);
            gameInfoData.setGameLink(newGameInfo.game_link);
            gameInfoData.setGameName(newGameInfo.game_name);
            gameInfoData.setGamePic(newGameInfo.game_pic);
            if (TextUtils.isEmpty(newGameInfo.icon_pic1)) {
                gameInfoData.setIconUrl(newGameInfo.icon_url);
            } else {
                gameInfoData.setIconUrl(newGameInfo.icon_pic1);
            }
            gameInfoData.setGameType(newGameInfo.game_type.intValue());
            gameInfoData.setMark(newGameInfo.mark.intValue());
            gameInfoData.setPackageLink(newGameInfo.package_link);
            gameInfoData.setPackageSize(newGameInfo.package_size);
            gameInfoData.setSchemaUrl(newGameInfo.schema_url);
            gameInfoData.setIntroduce(newGameInfo.game_desc);
            gameInfoData.setLauncherActivity(newGameInfo.launchComponent);
            gameInfoData.setPackageName(newGameInfo.andr_pk_name);
            Long l = newGameInfo.deadline;
            if (l != null) {
                gameInfoData.setDeadline(l.longValue());
            }
            gameInfoData.setCategoryId(newGameInfo.category_id.intValue());
            gameInfoData.setCategoryName(newGameInfo.category_name);
            gameInfoData.setCategoryNameSim(newGameInfo.category_name_sim);
            gameInfoData.setVersion(newGameInfo.version);
            gameInfoData.setStar(newGameInfo.score.intValue());
            gameInfoData.setSecretKey(newGameInfo.secret_key);
            gameInfoData.setSuperscriptColor(newGameInfo.subscript_color);
            gameInfoData.setApp_id(String.valueOf(newGameInfo.app_id));
            gameInfoData.setRefId(GameCenterCoreUtils.REF_TYPE_OTHER);
            return gameInfoData;
        }
        return (GameInfoData) invokeL.objValue;
    }

    public static GameInfoData fromRecommendGames(RecommendGame recommendGame) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, recommendGame)) == null) {
            GameInfoData gameInfoData = new GameInfoData();
            if (recommendGame == null) {
                return gameInfoData;
            }
            gameInfoData.setAppleId(recommendGame.apple_id);
            gameInfoData.setBundleId(recommendGame.bundle_id);
            gameInfoData.setGameId(recommendGame.game_id);
            gameInfoData.setGameLink(recommendGame.game_link);
            gameInfoData.setGameName(recommendGame.game_name);
            gameInfoData.setGamePic(recommendGame.game_pic);
            gameInfoData.setIconUrl(recommendGame.icon_url);
            gameInfoData.setGameType(recommendGame.game_type.intValue());
            gameInfoData.setMark(recommendGame.mark.intValue());
            gameInfoData.setPackageLink(recommendGame.package_link);
            gameInfoData.setPackageSize(recommendGame.package_size);
            gameInfoData.setPlayerNum(recommendGame.player_num);
            gameInfoData.setSchemaUrl(recommendGame.schema_url);
            gameInfoData.setIntroduce(recommendGame.introduce);
            gameInfoData.setLauncherActivity(recommendGame.launch_component);
            gameInfoData.setPackageName(recommendGame.andr_pk_name);
            gameInfoData.setSecretKey(recommendGame.secret_key);
            gameInfoData.setRefId(GameCenterCoreUtils.REF_TYPE_OTHER);
            Long l = recommendGame.deadline;
            if (l != null) {
                gameInfoData.setDeadline(l.longValue());
            }
            gameInfoData.setEditorRec(recommendGame.editor_rec);
            gameInfoData.setDayDownloads(recommendGame.day_downloads.intValue());
            gameInfoData.setCategoryId(recommendGame.category_id.intValue());
            gameInfoData.setCategoryName(recommendGame.category_name);
            gameInfoData.setVersion(recommendGame.version);
            gameInfoData.setStar(recommendGame.star.intValue());
            gameInfoData.setSuperscriptColor(recommendGame.superscript_color);
            return gameInfoData;
        }
        return (GameInfoData) invokeL.objValue;
    }

    public String getApp_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.app_id : (String) invokeV.objValue;
    }

    public String getAppleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.apple_id : (String) invokeV.objValue;
    }

    public String getBundleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bundle_id : (String) invokeV.objValue;
    }

    public int getCategoryId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.category_id : invokeV.intValue;
    }

    public String getCategoryName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.category_name : (String) invokeV.objValue;
    }

    public String getCategoryNameSim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.category_name_sim : (String) invokeV.objValue;
    }

    public CodeInfo getCodeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.codeInfo : (CodeInfo) invokeV.objValue;
    }

    public int getDayDownloads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.day_downloads : invokeV.intValue;
    }

    public long getDeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.deadline : invokeV.longValue;
    }

    public long getDownloadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.downloadTime : invokeV.longValue;
    }

    public String getEditorRec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.editor_rec : (String) invokeV.objValue;
    }

    public String getGameDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.game_desc : (String) invokeV.objValue;
    }

    public String getGameId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.game_id : (String) invokeV.objValue;
    }

    public String getGameLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.game_link : (String) invokeV.objValue;
    }

    public String getGameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.game_name : (String) invokeV.objValue;
    }

    public List<String> getGamePic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.game_pic : (List) invokeV.objValue;
    }

    public int getGameStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.game_status : invokeV.intValue;
    }

    public int getGameType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.game_type : invokeV.intValue;
    }

    public List<GiftPkgInfo> getGiftPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.giftPackages : (List) invokeV.objValue;
    }

    public String getIconPic1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.icon_pic1 : (String) invokeV.objValue;
    }

    public String getIconPic2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.icon_pic2 : (String) invokeV.objValue;
    }

    public String getIconPic3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.icon_pic3 : (String) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.icon_url : (String) invokeV.objValue;
    }

    public long getInstallTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.installTime : invokeV.longValue;
    }

    public String getIntroduce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.introduce : (String) invokeV.objValue;
    }

    public String getIsDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.is_detail : (String) invokeV.objValue;
    }

    public String getLauncherActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.launcherActivity : (String) invokeV.objValue;
    }

    public int getMark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mark : invokeV.intValue;
    }

    public long getOrderTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.orderTime : invokeV.longValue;
    }

    public String getPackageLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.package_link : (String) invokeV.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.packageName : (String) invokeV.objValue;
    }

    public String getPackageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.package_size : (String) invokeV.objValue;
    }

    public int getPlayerNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.player_num : invokeV.intValue;
    }

    public String getRefId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.ref_id : (String) invokeV.objValue;
    }

    public String getRefType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.ref_type : (String) invokeV.objValue;
    }

    public String getSchemaUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.schema_url : (String) invokeV.objValue;
    }

    public String getSecretKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.secret_key : (String) invokeV.objValue;
    }

    public String getServerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.server_id : (String) invokeV.objValue;
    }

    public String getServerName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.server_name : (String) invokeV.objValue;
    }

    public int getServerOpenTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.server_open_time : invokeV.intValue;
    }

    public int getServerType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.server_type : invokeV.intValue;
    }

    public int getStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.star : invokeV.intValue;
    }

    public String getSuperscriptColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.superscript_color : (String) invokeV.objValue;
    }

    public int getUpStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.upStatus : invokeV.intValue;
    }

    public List<GameInfoData> getUserRecommendList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.userRecommendList : (List) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.version : (String) invokeV.objValue;
    }

    public boolean isCurrentStatusUpSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.currentStatusUpSuccess : invokeV.booleanValue;
    }

    public void setApp_id(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.app_id = str;
        }
    }

    public void setAppleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.apple_id = str;
        }
    }

    public void setBundleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.bundle_id = str;
        }
    }

    public void setCategoryId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.category_id = i;
        }
    }

    public void setCategoryName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.category_name = str;
        }
    }

    public void setCategoryNameSim(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.category_name_sim = str;
        }
    }

    public void setCodeInfo(CodeInfo codeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, codeInfo) == null) {
            this.codeInfo = codeInfo;
        }
    }

    public void setCurrentStatusUpSuccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.currentStatusUpSuccess = z;
        }
    }

    public void setDayDownloads(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.day_downloads = i;
        }
    }

    public void setDeadline(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048632, this, j) == null) {
            this.deadline = j;
        }
    }

    public void setDownloadTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048633, this, j) == null) {
            this.downloadTime = j;
        }
    }

    public void setEditorRec(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.editor_rec = str;
        }
    }

    public void setGameDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.game_desc = str;
        }
    }

    public void setGameId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.game_id = str;
        }
    }

    public void setGameLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.game_link = str;
        }
    }

    public void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.game_name = str;
        }
    }

    public void setGamePic(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, list) == null) {
            this.game_pic = list;
        }
    }

    public void setGameType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            this.game_type = i;
        }
    }

    public void setGamestatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            this.game_status = i;
        }
    }

    public void setGiftPackages(List<GiftPkgInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, list) == null) {
            this.giftPackages = list;
        }
    }

    public void setIconPic1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.icon_pic1 = str;
        }
    }

    public void setIconPic2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.icon_pic2 = str;
        }
    }

    public void setIconPic3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.icon_pic3 = str;
        }
    }

    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.icon_url = str;
        }
    }

    public void setInstallTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048647, this, j) == null) {
            this.installTime = j;
        }
    }

    public void setIntroduce(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            this.introduce = str;
        }
    }

    public void setIsDetail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.is_detail = str;
        }
    }

    public void setLauncherActivity(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.launcherActivity = str;
        }
    }

    public void setMark(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            this.mark = i;
        }
    }

    public void setOrderTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048652, this, j) == null) {
            this.orderTime = j;
        }
    }

    public void setPackageLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
            this.package_link = str;
        }
    }

    public void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.packageName = str;
        }
    }

    public void setPackageSize(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            this.package_size = dealPackageSize(str);
        }
    }

    public void setPlayerNum(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, num) == null) {
            this.player_num = num.intValue();
        }
    }

    public void setRefId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            this.ref_id = str;
        }
    }

    public void setRefType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.ref_type = str;
        }
    }

    public void setSchemaUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, str) == null) {
            this.schema_url = str;
        }
    }

    public void setSecretKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.secret_key = str;
        }
    }

    public void setServerId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            this.server_id = str;
        }
    }

    public void setServerName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, str) == null) {
            this.server_name = str;
        }
    }

    public void setServerOpenTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i) == null) {
            this.server_open_time = i;
        }
    }

    public void setServerType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i) == null) {
            this.server_type = i;
        }
    }

    public void setStar(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i) == null) {
            this.star = i;
        }
    }

    public void setSuperscriptColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, str) == null) {
            this.superscript_color = str;
        }
    }

    public void setUpStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048667, this, i) == null) {
            this.upStatus = i;
        }
    }

    public void setUserRecommendList(List<GameInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, list) == null) {
            this.userRecommendList = list;
        }
    }

    public void setVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            this.version = str;
        }
    }
}
