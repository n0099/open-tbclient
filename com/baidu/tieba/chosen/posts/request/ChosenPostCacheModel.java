package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
/* loaded from: classes3.dex */
public class ChosenPostCacheModel extends CacheModel<b, ChosenPostActivity> {
    public static final String CACHE_KEY = "chosen_post_cache";

    public ChosenPostCacheModel(TbPageContext<ChosenPostActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<b> JN() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String Jy() {
        return "tb.pb_normal";
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int JO() {
        return 2001312;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int JP() {
        return 2001313;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    protected boolean JG() {
        return false;
    }
}
