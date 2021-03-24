package com.baidu.tbadk.game;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import d.b.b.e.m.b;
import d.b.h0.g0.b.a;
import java.io.Serializable;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetGameCenter.RecommendGame;
import tbclient.GetGameDetailNew.CodeInfo;
import tbclient.GetGameDetailNew.GiftPkgInfo;
import tbclient.GetNewGameList.NewGameInfo;
/* loaded from: classes3.dex */
public class GameInfoData implements Serializable, a {
    public static final int APP_TYPE = 1;
    public static final int H5_TYPE = 2;
    public static final String IS_FROM_DETAIL = "1";
    public static final int NEW_MARK = 2;
    public static final String NOT_FROM_DETAIL = "0";
    public static final int NO_MARK = 0;
    public static final int WAITING_MARK = 1;
    public static final long serialVersionUID = -3662330595966807760L;
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
    public String launcherActivity;
    public int mark;
    public long orderTime;
    public String packageName;
    public String package_link;
    public String package_size;
    public int player_num;
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
    public int fromView = 0;
    public String ref_id = GameCenterCoreUtils.REF_TYPE_OTHER;
    public String ref_type = "606";
    public String is_detail = "0";

    private String dealPackageSize(String str) {
        return String.format("%.1f", Float.valueOf(b.c(str, 0.0f)));
    }

    public static GameInfoData fromGameInfo(GameInfo gameInfo) {
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

    public static GameInfoData fromNewGame(NewGameInfo newGameInfo) {
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

    public static GameInfoData fromRecommendGames(RecommendGame recommendGame) {
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

    public String getApp_id() {
        return this.app_id;
    }

    public String getAppleId() {
        return this.apple_id;
    }

    public String getBundleId() {
        return this.bundle_id;
    }

    public int getCategoryId() {
        return this.category_id;
    }

    public String getCategoryName() {
        return this.category_name;
    }

    public String getCategoryNameSim() {
        return this.category_name_sim;
    }

    public CodeInfo getCodeInfo() {
        return this.codeInfo;
    }

    public int getDayDownloads() {
        return this.day_downloads;
    }

    public long getDeadline() {
        return this.deadline;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public String getEditorRec() {
        return this.editor_rec;
    }

    public String getGameDesc() {
        return this.game_desc;
    }

    public String getGameId() {
        return this.game_id;
    }

    public String getGameLink() {
        return this.game_link;
    }

    public String getGameName() {
        return this.game_name;
    }

    public List<String> getGamePic() {
        return this.game_pic;
    }

    public int getGameStatus() {
        return this.game_status;
    }

    public int getGameType() {
        return this.game_type;
    }

    public List<GiftPkgInfo> getGiftPackages() {
        return this.giftPackages;
    }

    public String getIconPic1() {
        return this.icon_pic1;
    }

    public String getIconPic2() {
        return this.icon_pic2;
    }

    public String getIconPic3() {
        return this.icon_pic3;
    }

    public String getIconUrl() {
        return this.icon_url;
    }

    public long getInstallTime() {
        return this.installTime;
    }

    public String getIntroduce() {
        return this.introduce;
    }

    public String getIsDetail() {
        return this.is_detail;
    }

    public String getLauncherActivity() {
        return this.launcherActivity;
    }

    public int getMark() {
        return this.mark;
    }

    public long getOrderTime() {
        return this.orderTime;
    }

    public String getPackageLink() {
        return this.package_link;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPackageSize() {
        return this.package_size;
    }

    public int getPlayerNum() {
        return this.player_num;
    }

    public String getRefId() {
        return this.ref_id;
    }

    public String getRefType() {
        return this.ref_type;
    }

    public String getSchemaUrl() {
        return this.schema_url;
    }

    public String getSecretKey() {
        return this.secret_key;
    }

    public String getServerId() {
        return this.server_id;
    }

    public String getServerName() {
        return this.server_name;
    }

    public int getServerOpenTime() {
        return this.server_open_time;
    }

    public int getServerType() {
        return this.server_type;
    }

    public int getStar() {
        return this.star;
    }

    public String getSuperscriptColor() {
        return this.superscript_color;
    }

    public int getUpStatus() {
        return this.upStatus;
    }

    public List<GameInfoData> getUserRecommendList() {
        return this.userRecommendList;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isCurrentStatusUpSuccess() {
        return this.currentStatusUpSuccess;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public void setAppleId(String str) {
        this.apple_id = str;
    }

    public void setBundleId(String str) {
        this.bundle_id = str;
    }

    public void setCategoryId(int i) {
        this.category_id = i;
    }

    public void setCategoryName(String str) {
        this.category_name = str;
    }

    public void setCategoryNameSim(String str) {
        this.category_name_sim = str;
    }

    public void setCodeInfo(CodeInfo codeInfo) {
        this.codeInfo = codeInfo;
    }

    public void setCurrentStatusUpSuccess(boolean z) {
        this.currentStatusUpSuccess = z;
    }

    public void setDayDownloads(int i) {
        this.day_downloads = i;
    }

    public void setDeadline(long j) {
        this.deadline = j;
    }

    public void setDownloadTime(long j) {
        this.downloadTime = j;
    }

    public void setEditorRec(String str) {
        this.editor_rec = str;
    }

    public void setGameDesc(String str) {
        this.game_desc = str;
    }

    public void setGameId(String str) {
        this.game_id = str;
    }

    public void setGameLink(String str) {
        this.game_link = str;
    }

    public void setGameName(String str) {
        this.game_name = str;
    }

    public void setGamePic(List<String> list) {
        this.game_pic = list;
    }

    public void setGameType(int i) {
        this.game_type = i;
    }

    public void setGamestatus(int i) {
        this.game_status = i;
    }

    public void setGiftPackages(List<GiftPkgInfo> list) {
        this.giftPackages = list;
    }

    public void setIconPic1(String str) {
        this.icon_pic1 = str;
    }

    public void setIconPic2(String str) {
        this.icon_pic2 = str;
    }

    public void setIconPic3(String str) {
        this.icon_pic3 = str;
    }

    public void setIconUrl(String str) {
        this.icon_url = str;
    }

    public void setInstallTime(long j) {
        this.installTime = j;
    }

    public void setIntroduce(String str) {
        this.introduce = str;
    }

    public void setIsDetail(String str) {
        this.is_detail = str;
    }

    public void setLauncherActivity(String str) {
        this.launcherActivity = str;
    }

    public void setMark(int i) {
        this.mark = i;
    }

    public void setOrderTime(long j) {
        this.orderTime = j;
    }

    public void setPackageLink(String str) {
        this.package_link = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPackageSize(String str) {
        this.package_size = dealPackageSize(str);
    }

    public void setPlayerNum(Integer num) {
        this.player_num = num.intValue();
    }

    public void setRefId(String str) {
        this.ref_id = str;
    }

    public void setRefType(String str) {
        this.ref_type = str;
    }

    public void setSchemaUrl(String str) {
        this.schema_url = str;
    }

    public void setSecretKey(String str) {
        this.secret_key = str;
    }

    public void setServerId(String str) {
        this.server_id = str;
    }

    public void setServerName(String str) {
        this.server_name = str;
    }

    public void setServerOpenTime(int i) {
        this.server_open_time = i;
    }

    public void setServerType(int i) {
        this.server_type = i;
    }

    public void setStar(int i) {
        this.star = i;
    }

    public void setSuperscriptColor(String str) {
        this.superscript_color = str;
    }

    public void setUpStatus(int i) {
        this.upStatus = i;
    }

    public void setUserRecommendList(List<GameInfoData> list) {
        this.userRecommendList = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
