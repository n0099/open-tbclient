package com.baidu.tieba.frs.smartapp;

import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class b {
    public String avatar;
    public Integer byE;
    public String fIQ;
    public Long fIR;
    public String h5_url;
    public String id;
    public String link;
    public String name;
    public String pic;

    public void a(SmartApp smartApp) {
        if (smartApp != null) {
            this.name = smartApp.name;
            this.fIQ = smartApp._abstract;
            this.avatar = smartApp.avatar;
            this.h5_url = smartApp.h5_url;
            this.pic = smartApp.pic;
            this.id = smartApp.id;
            this.link = smartApp.link;
            this.byE = smartApp.is_game;
            this.fIR = smartApp.swan_app_id;
        }
    }
}
