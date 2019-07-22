package com.baidu.tbadk.game;

import android.text.TextUtils;
import com.baidu.adp.lib.g.b;
import java.io.Serializable;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetGameCenter.RecommendGame;
import tbclient.GetGameDetailNew.CodeInfo;
import tbclient.GetGameDetailNew.GiftPkgInfo;
import tbclient.GetNewGameList.NewGameInfo;
/* loaded from: classes3.dex */
public class GameInfoData implements com.baidu.tbadk.mvc.b.a, Serializable {
    public static final int APP_TYPE = 1;
    public static final int H5_TYPE = 2;
    public static final String IS_FROM_DETAIL = "1";
    public static final int NEW_MARK = 2;
    public static final String NOT_FROM_DETAIL = "0";
    public static final int NO_MARK = 0;
    public static final int WAITING_MARK = 1;
    private static final long serialVersionUID = -3662330595966807760L;
    private String app_id;
    private String apple_id;
    private String bundle_id;
    private int category_id;
    private String category_name;
    private String category_name_sim;
    private CodeInfo codeInfo;
    private boolean currentStatusUpSuccess;
    private int day_downloads;
    private long deadline;
    private long downloadTime;
    private String editor_rec;
    private String game_desc;
    private String game_id;
    private String game_link;
    private String game_name;
    private List<String> game_pic;
    private int game_status;
    private int game_type;
    private List<GiftPkgInfo> giftPackages;
    private String icon_pic1;
    private String icon_pic2;
    private String icon_pic3;
    private String icon_url;
    private long installTime;
    private String introduce;
    private String launcherActivity;
    private int mark;
    private long orderTime;
    private String packageName;
    private String package_link;
    private String package_size;
    private int player_num;
    private String schema_url;
    private int score;
    private String secret_key;
    private String server_id;
    private String server_name;
    private int server_open_time;
    private int server_type;
    private int star;
    private String superscript_color;
    private int upStatus;
    private List<GameInfoData> userRecommendList;
    private String version;
    public int fromView = 0;
    private String ref_id = "5000901";
    private String ref_type = "606";
    private String is_detail = "0";

    public List<GameInfoData> getUserRecommendList() {
        return this.userRecommendList;
    }

    public void setUserRecommendList(List<GameInfoData> list) {
        this.userRecommendList = list;
    }

    public CodeInfo getCodeInfo() {
        return this.codeInfo;
    }

    public void setCodeInfo(CodeInfo codeInfo) {
        this.codeInfo = codeInfo;
    }

    public String getServerId() {
        return this.server_id;
    }

    public void setServerId(String str) {
        this.server_id = str;
    }

    public String getServerName() {
        return this.server_name;
    }

    public void setServerName(String str) {
        this.server_name = str;
    }

    public int getServerOpenTime() {
        return this.server_open_time;
    }

    public void setServerOpenTime(int i) {
        this.server_open_time = i;
    }

    public int getServerType() {
        return this.server_type;
    }

    public void setServerType(int i) {
        this.server_type = i;
    }

    public String getGameId() {
        return this.game_id;
    }

    public void setGameId(String str) {
        this.game_id = str;
    }

    public String getGameName() {
        return this.game_name;
    }

    public void setGameName(String str) {
        this.game_name = str;
    }

    public int getGameType() {
        return this.game_type;
    }

    public void setGameType(int i) {
        this.game_type = i;
    }

    public String getIconUrl() {
        return this.icon_url;
    }

    public void setIconUrl(String str) {
        this.icon_url = str;
    }

    public int getPlayerNum() {
        return this.player_num;
    }

    public void setPlayerNum(Integer num) {
        this.player_num = num.intValue();
    }

    public String getPackageLink() {
        return this.package_link;
    }

    public void setPackageLink(String str) {
        this.package_link = str;
    }

    public String getPackageSize() {
        return this.package_size;
    }

    public void setPackageSize(String str) {
        this.package_size = qz(str);
    }

    public String getGameLink() {
        return this.game_link;
    }

    public void setGameLink(String str) {
        this.game_link = str;
    }

    public int getMark() {
        return this.mark;
    }

    public void setMark(int i) {
        this.mark = i;
    }

    public String getAppleId() {
        return this.apple_id;
    }

    public void setAppleId(String str) {
        this.apple_id = str;
    }

    public String getBundleId() {
        return this.bundle_id;
    }

    public void setBundleId(String str) {
        this.bundle_id = str;
    }

    public String getSchemaUrl() {
        return this.schema_url;
    }

    public void setSchemaUrl(String str) {
        this.schema_url = str;
    }

    public List<String> getGamePic() {
        return this.game_pic;
    }

    public void setGamePic(List<String> list) {
        this.game_pic = list;
    }

    public long getInstallTime() {
        return this.installTime;
    }

    public void setInstallTime(long j) {
        this.installTime = j;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public void setDownloadTime(long j) {
        this.downloadTime = j;
    }

    public long getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(long j) {
        this.orderTime = j;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getLauncherActivity() {
        return this.launcherActivity;
    }

    public void setLauncherActivity(String str) {
        this.launcherActivity = str;
    }

    public String getIntroduce() {
        return this.introduce;
    }

    public void setIntroduce(String str) {
        this.introduce = str;
    }

    public String getSecretKey() {
        return this.secret_key;
    }

    public void setSecretKey(String str) {
        this.secret_key = str;
    }

    public int getCategoryId() {
        return this.category_id;
    }

    public void setCategoryId(int i) {
        this.category_id = i;
    }

    public String getCategoryName() {
        return this.category_name;
    }

    public void setCategoryName(String str) {
        this.category_name = str;
    }

    public String getCategoryNameSim() {
        return this.category_name_sim;
    }

    public void setCategoryNameSim(String str) {
        this.category_name_sim = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public int getStar() {
        return this.star;
    }

    public void setStar(int i) {
        this.star = i;
    }

    public long getDeadline() {
        return this.deadline;
    }

    public void setDeadline(long j) {
        this.deadline = j;
    }

    public int getDayDownloads() {
        return this.day_downloads;
    }

    public void setDayDownloads(int i) {
        this.day_downloads = i;
    }

    public int getGameStatus() {
        return this.game_status;
    }

    public void setGamestatus(int i) {
        this.game_status = i;
    }

    public int getUpStatus() {
        return this.upStatus;
    }

    public void setUpStatus(int i) {
        this.upStatus = i;
    }

    public boolean isCurrentStatusUpSuccess() {
        return this.currentStatusUpSuccess;
    }

    public void setCurrentStatusUpSuccess(boolean z) {
        this.currentStatusUpSuccess = z;
    }

    public static GameInfoData fromGameInfo(GameInfo gameInfo) {
        GameInfoData gameInfoData = new GameInfoData();
        if (gameInfo != null) {
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
            if (gameInfo.deadline != null) {
                gameInfoData.setDeadline(gameInfo.deadline.longValue());
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
            gameInfoData.setRefId("5000901");
        }
        return gameInfoData;
    }

    public static GameInfoData fromRecommendGames(RecommendGame recommendGame) {
        GameInfoData gameInfoData = new GameInfoData();
        if (recommendGame != null) {
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
            gameInfoData.setRefId("5000901");
            if (recommendGame.deadline != null) {
                gameInfoData.setDeadline(recommendGame.deadline.longValue());
            }
            gameInfoData.setEditorRec(recommendGame.editor_rec);
            gameInfoData.setDayDownloads(recommendGame.day_downloads.intValue());
            gameInfoData.setCategoryId(recommendGame.category_id.intValue());
            gameInfoData.setCategoryName(recommendGame.category_name);
            gameInfoData.setVersion(recommendGame.version);
            gameInfoData.setStar(recommendGame.star.intValue());
            gameInfoData.setSuperscriptColor(recommendGame.superscript_color);
        }
        return gameInfoData;
    }

    public static GameInfoData fromNewGame(NewGameInfo newGameInfo) {
        GameInfoData gameInfoData = new GameInfoData();
        if (newGameInfo != null) {
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
            if (newGameInfo.deadline != null) {
                gameInfoData.setDeadline(newGameInfo.deadline.longValue());
            }
            gameInfoData.setCategoryId(newGameInfo.category_id.intValue());
            gameInfoData.setCategoryName(newGameInfo.category_name);
            gameInfoData.setCategoryNameSim(newGameInfo.category_name_sim);
            gameInfoData.setVersion(newGameInfo.version);
            gameInfoData.setStar(newGameInfo.score.intValue());
            gameInfoData.setSecretKey(newGameInfo.secret_key);
            gameInfoData.setSuperscriptColor(newGameInfo.subscript_color);
            gameInfoData.setApp_id(String.valueOf(newGameInfo.app_id));
            gameInfoData.setRefId("5000901");
        }
        return gameInfoData;
    }

    public String getEditorRec() {
        return this.editor_rec;
    }

    public void setEditorRec(String str) {
        this.editor_rec = str;
    }

    public String getSuperscriptColor() {
        return this.superscript_color;
    }

    public void setSuperscriptColor(String str) {
        this.superscript_color = str;
    }

    public String getRefId() {
        return this.ref_id;
    }

    public void setRefId(String str) {
        this.ref_id = str;
    }

    public String getRefType() {
        return this.ref_type;
    }

    public void setRefType(String str) {
        this.ref_type = str;
    }

    public String getIsDetail() {
        return this.is_detail;
    }

    public void setIsDetail(String str) {
        this.is_detail = str;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    private String qz(String str) {
        return String.format("%.1f", Float.valueOf(b.c(str, 0.0f)));
    }

    public String getIconPic1() {
        return this.icon_pic1;
    }

    public void setIconPic1(String str) {
        this.icon_pic1 = str;
    }

    public String getIconPic2() {
        return this.icon_pic2;
    }

    public void setIconPic2(String str) {
        this.icon_pic2 = str;
    }

    public String getIconPic3() {
        return this.icon_pic3;
    }

    public void setIconPic3(String str) {
        this.icon_pic3 = str;
    }

    public String getGameDesc() {
        return this.game_desc;
    }

    public void setGameDesc(String str) {
        this.game_desc = str;
    }

    public List<GiftPkgInfo> getGiftPackages() {
        return this.giftPackages;
    }

    public void setGiftPackages(List<GiftPkgInfo> list) {
        this.giftPackages = list;
    }
}
