package com.baidu.tieba.im.frsgroup;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupsByFid.DataReq;
import protobuf.QueryGroupsByFid.QueryGroupsByFidReqIdl;
/* loaded from: classes5.dex */
public class FrsGroupRequestMessage extends TbSocketMessage {
    public static final int CARD_HOT = 2;
    public static final int CARD_OFFICIAL = 3;
    public static final int CARD_RECOMMEND = 1;
    public static final int IMAGE_HEIGHT = 70;
    public static final int IMAGE_WIDTH = 70;
    public static final int LEN_FIRST = 50;
    public static final int LEN_MORE = 20;
    private String forumId;
    private String forumName;
    private boolean isNeedCache;
    private int mImageHeight;
    private int mImageWidth;
    private int offset;
    private int rn;
    private int type;

    public FrsGroupRequestMessage() {
        super(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID);
        this.isNeedCache = false;
        this.mImageWidth = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst(), 70.0f);
        this.mImageHeight = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst(), 70.0f);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forumId = Integer.valueOf(com.baidu.adp.lib.g.b.toInt(getForumId(), 0));
        builder.offset = Integer.valueOf(this.offset);
        builder.rn = Integer.valueOf(this.rn);
        builder.type = Integer.valueOf(this.type);
        builder.width = Integer.valueOf(this.mImageWidth);
        builder.height = Integer.valueOf(this.mImageHeight);
        QueryGroupsByFidReqIdl.Builder builder2 = new QueryGroupsByFidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
        if (i == 0) {
            this.rn = 50;
        } else {
            this.rn = 20;
        }
    }

    public void toNextPage() {
        this.offset += this.rn;
        setOffset(this.offset);
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }
}
