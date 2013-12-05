package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.NearbyGroupsData;
/* loaded from: classes.dex */
public class ResponseNearbyGroupsMessage extends ResponsedMessage {
    private static final long serialVersionUID = 5970126981799423191L;
    private NearbyGroupsData nearbyGroups;

    public ResponseNearbyGroupsMessage() {
    }

    public ResponseNearbyGroupsMessage(int i) {
        super(i);
    }

    public NearbyGroupsData getNearbyGroups() {
        return this.nearbyGroups;
    }

    public void setNearbyGroups(NearbyGroupsData nearbyGroupsData) {
        this.nearbyGroups = nearbyGroupsData;
    }
}
