package com.baidu.tieba.game;

import tbclient.GetMutilGameList.AdvInfo;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.square.y {
    private String ad_link_android;
    private String ad_link_ios;
    private String ad_link_webview;
    private String ad_pic;
    private String game_id;
    private String game_name;

    public a a(AdvInfo advInfo) {
        this.game_name = advInfo.game_name;
        this.game_id = advInfo.game_id;
        this.ad_link_android = advInfo.ad_link_android;
        this.ad_link_webview = advInfo.ad_link_webview;
        this.ad_link_ios = advInfo.ad_link_ios;
        this.ad_pic = advInfo.ad_pic;
        return this;
    }

    public String He() {
        return this.ad_link_android;
    }

    @Override // com.baidu.tieba.square.y
    public String kJ() {
        return this.ad_pic;
    }

    @Override // com.baidu.tieba.square.y
    public String getLink() {
        return this.ad_link_android;
    }
}
