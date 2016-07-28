package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.ForumData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.ForumRalatedInfo;
import protobuf.GetLivableForumList.GetLivableForumListResIdl;
/* loaded from: classes.dex */
public class ResponseGetLivableForumList extends SocketResponsedMessage {
    private boolean available;
    private ArrayList<ForumData> data;
    private boolean hasMore;
    private int minLevel;
    private String tips;

    public ResponseGetLivableForumList() {
        super(107129);
        this.available = false;
        this.data = new ArrayList<>();
    }

    public boolean getAvailabel() {
        return this.available;
    }

    public void setMiniLevel(int i) {
        this.minLevel = i;
    }

    public int getMiniLevel() {
        return this.minLevel;
    }

    public void setAvailabel(int i) {
        if (i == 1) {
            this.available = true;
        } else {
            this.available = false;
        }
    }

    public String getTips() {
        return this.tips;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void setHasMore(int i) {
        if (i == 1) {
            this.hasMore = true;
        } else {
            this.hasMore = false;
        }
    }

    public void setData(List<ForumRalatedInfo> list) {
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    if (list.get(i2) != null) {
                        ForumData forumData = new ForumData();
                        forumData.setCurScore(list.get(i2).curScore.intValue());
                        forumData.setImage_url(list.get(i2).avatar);
                        forumData.setLevelupScore(list.get(i2).leftScore.intValue());
                        forumData.setUser_level(list.get(i2).level.intValue());
                        forumData.setName(list.get(i2).name);
                        forumData.setId(list.get(i2).forumId.toString());
                        this.data.add(forumData);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public ArrayList<ForumData> getData() {
        return this.data;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetLivableForumListResIdl getLivableForumListResIdl = (GetLivableForumListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetLivableForumListResIdl.class);
        setError(getLivableForumListResIdl.error.errorno.intValue());
        setErrorString(getLivableForumListResIdl.error.usermsg);
        if (getError() == 0) {
            this.tips = getLivableForumListResIdl.data.tips;
            setHasMore(getLivableForumListResIdl.data.hasMore.intValue());
            setAvailabel(getLivableForumListResIdl.data.available.intValue());
            setData(getLivableForumListResIdl.data.likeList);
            setMiniLevel(getLivableForumListResIdl.data.minLevel.intValue());
        }
    }
}
