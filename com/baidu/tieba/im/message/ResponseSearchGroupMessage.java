package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.BaseGroupData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ResponseSearchGroupMessage extends ResponsedMessage {
    private List<BaseGroupData> searchResult;

    public ResponseSearchGroupMessage() {
        this.searchResult = new ArrayList();
    }

    public ResponseSearchGroupMessage(int i) {
        super(i);
        this.searchResult = new ArrayList();
    }

    public List<BaseGroupData> getSearchResult() {
        return this.searchResult;
    }

    public void setSearchResult(List<BaseGroupData> list) {
        this.searchResult = list;
    }
}
