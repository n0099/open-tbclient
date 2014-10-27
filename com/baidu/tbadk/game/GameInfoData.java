package com.baidu.tbadk.game;

import java.io.Serializable;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetGameCenter.RecommendGame;
/* loaded from: classes.dex */
public class GameInfoData implements Serializable {
    public static final int APP_TYPE = 1;
    public static final int H5_TYPE = 2;
    public static final int NEW_MARK = 2;
    public static final int NO_MARK = 0;
    public static final int WAITING_MARK = 1;
    private static final long serialVersionUID = -3662330595966807760L;
    private String apple_id;
    private String bundle_id;
    private int category_id;
    private String category_name;
    private int day_downloads;
    private long deadline;
    private long downloadTime;
    private String editor_rec;
    private String game_id;
    private String game_link;
    private String game_name;
    private List<String> game_pic;
    private int game_status;
    private int game_type;
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
    private String ref_id = "5000901";
    private String schema_url;
    private String secret_key;
    private int star;
    private String superscript_color;
    private String version;

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
        this.package_size = str;
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

    public static GameInfoData fromGameInfo(GameInfo gameInfo) {
        GameInfoData gameInfoData = new GameInfoData();
        if (gameInfo != null) {
            gameInfoData.setAppleId(gameInfo.apple_id);
            gameInfoData.setBundleId(gameInfo.bundle_id);
            gameInfoData.setGameId(gameInfo.game_id);
            gameInfoData.setGameLink(gameInfo.game_link);
            gameInfoData.setGameName(gameInfo.game_name);
            gameInfoData.setGamePic(gameInfo.game_pic);
            gameInfoData.setIconUrl(gameInfo.icon_url);
            gameInfoData.setGameType(gameInfo.game_type.intValue());
            gameInfoData.setMark(gameInfo.mark.intValue());
            gameInfoData.setPackageLink(gameInfo.package_link);
            gameInfoData.setPackageSize(gameInfo.package_size);
            gameInfoData.setPlayerNum(gameInfo.player_num);
            gameInfoData.setSchemaUrl(gameInfo.schema_url);
            gameInfoData.setIntroduce(gameInfo.introduce);
            gameInfoData.setLauncherActivity(gameInfo.launch_component);
            gameInfoData.setPackageName(gameInfo.andr_pk_name);
            if (gameInfo.deadline != null) {
                gameInfoData.setDeadline(gameInfo.deadline.longValue());
            }
            gameInfoData.setEditorRec(gameInfo.editor_rec);
            gameInfoData.setDayDownloads(gameInfo.day_downloads.intValue());
            gameInfoData.setCategoryId(gameInfo.category_id.intValue());
            gameInfoData.setCategoryName(gameInfo.category_name);
            gameInfoData.setVersion(gameInfo.version);
            gameInfoData.setStar(gameInfo.star.intValue());
            gameInfoData.setSecretKey(gameInfo.secret_key);
            gameInfoData.setSuperscriptColor(gameInfo.superscript_color);
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
}
