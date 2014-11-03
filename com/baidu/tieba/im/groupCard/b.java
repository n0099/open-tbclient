package com.baidu.tieba.im.groupCard;

import com.baidu.adp.base.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b extends e {
    private static Long aZT = 0L;
    private static final Long aZU = 300000L;
    private final GroupCardActivity aZR;
    private c aZS;
    private String imageUrl;
    private final long mGroupId;

    public static void Os() {
        aZT = 0L;
    }

    public b(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity);
        this.aZS = null;
        this.imageUrl = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl = String.valueOf(this.imageUrl) + this.mGroupId;
        this.imageUrl = String.valueOf(this.imageUrl) + "&w=" + LocalViewSize.lV().lW();
        this.aZR = groupCardActivity;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public String O(int i, int i2) {
        if (System.currentTimeMillis() - aZT.longValue() > aZU.longValue()) {
            aZT = Long.valueOf(System.currentTimeMillis());
        }
        return String.valueOf(this.imageUrl) + "&t=" + aZT;
    }

    public void Ot() {
        this.aZS = new c(this);
        this.aZS.execute(new String[0]);
    }
}
