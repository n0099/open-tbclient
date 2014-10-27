package com.baidu.tieba.im.groupCard;

import com.baidu.adp.base.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b extends e {
    private static Long aZG = 0L;
    private static final Long aZH = 300000L;
    private final GroupCardActivity aZE;
    private c aZF;
    private String imageUrl;
    private final long mGroupId;

    public static void Op() {
        aZG = 0L;
    }

    public b(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity);
        this.aZF = null;
        this.imageUrl = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/p/groupShareImg?group_id=";
        this.mGroupId = j;
        this.imageUrl = String.valueOf(this.imageUrl) + this.mGroupId;
        this.imageUrl = String.valueOf(this.imageUrl) + "&w=" + LocalViewSize.lV().lW();
        this.aZE = groupCardActivity;
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
        if (System.currentTimeMillis() - aZG.longValue() > aZH.longValue()) {
            aZG = Long.valueOf(System.currentTimeMillis());
        }
        return String.valueOf(this.imageUrl) + "&t=" + aZG;
    }

    public void Oq() {
        this.aZF = new c(this);
        this.aZF.execute(new String[0]);
    }
}
