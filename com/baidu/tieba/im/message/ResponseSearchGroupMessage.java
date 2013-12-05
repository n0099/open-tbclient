package com.baidu.tieba.im.message;

import com.baidu.adp.lib.cache.t;
import com.baidu.tieba.im.data.BaseGroupData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ResponseSearchGroupMessage extends ResponsedMessage {
    private List<t<String>> cacheList;
    private long gid;
    private List<BaseGroupData> searchResult;

    public ResponseSearchGroupMessage() {
        this.searchResult = new ArrayList();
        this.cacheList = new ArrayList();
    }

    public ResponseSearchGroupMessage(int i) {
        super(i);
        this.searchResult = new ArrayList();
        this.cacheList = new ArrayList();
    }

    public List<BaseGroupData> getSearchResult() {
        return this.searchResult;
    }

    public void setSearchResult(List<BaseGroupData> list) {
        this.searchResult = list;
    }

    public List<t<String>> getCacheList() {
        return this.cacheList;
    }

    public void setCacheList(List<t<String>> list) {
        this.cacheList = list;
    }

    public long getGid() {
        return this.gid;
    }

    public void setGid(long j) {
        this.gid = j;
    }
}
