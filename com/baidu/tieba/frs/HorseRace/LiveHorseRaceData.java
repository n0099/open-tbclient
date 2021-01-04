package com.baidu.tieba.frs.HorseRace;

import java.io.Serializable;
import tbclient.GetHorseRaceLampList.LiveList;
/* loaded from: classes2.dex */
public class LiveHorseRaceData implements Serializable {
    public Integer amount;
    public Long live_id;
    public String live_title;
    public Long rob_end_tm;
    public Integer screen_direction;
    public Long user_id;
    public String user_nickname;

    public Long getLive_id() {
        return this.live_id;
    }

    public void setLive_id(Long l) {
        this.live_id = l;
    }

    public String getLive_title() {
        return this.live_title;
    }

    public void setLive_title(String str) {
        this.live_title = str;
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long l) {
        this.user_id = l;
    }

    public String getUser_nickname() {
        return this.user_nickname;
    }

    public void setUser_nickname(String str) {
        this.user_nickname = str;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer num) {
        this.amount = num;
    }

    public Long getRob_end_tm() {
        return this.rob_end_tm;
    }

    public void setRob_end_tm(Long l) {
        this.rob_end_tm = l;
    }

    public Integer getScreen_direction() {
        return this.screen_direction;
    }

    public void setScreen_direction(Integer num) {
        this.screen_direction = num;
    }

    public void parserProtobuf(LiveList liveList) {
        if (liveList != null) {
            this.live_id = liveList.live_id;
            this.live_title = liveList.live_title;
            this.user_id = liveList.user_id;
            this.user_nickname = liveList.user_nickname;
            this.amount = liveList.amount;
            this.rob_end_tm = liveList.rob_end_tm;
            this.screen_direction = liveList.screen_direction;
        }
    }
}
