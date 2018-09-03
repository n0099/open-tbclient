package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ap;
import tbclient.TalkBall.Country;
/* loaded from: classes3.dex */
public class d {
    private String mIcon;
    private String mName;

    public void a(Country country) {
        if (country != null) {
            this.mIcon = country.icon;
            this.mName = country.name;
        }
    }

    public boolean aBz() {
        return (ap.isEmpty(this.mIcon) || ap.isEmpty(this.mName)) ? false : true;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String getName() {
        return this.mName;
    }
}
