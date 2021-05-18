package com.baidu.tieba.chosen.posts.request;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
import d.a.k0.y.a.d.b;
/* loaded from: classes4.dex */
public class ChosenPostCacheModel extends CacheModel<b, ChosenPostActivity> {
    public static final String CACHE_KEY = "chosen_post_cache";

    public ChosenPostCacheModel(TbPageContext<ChosenPostActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<b> D() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int E() {
        return 2001312;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int F() {
        return 2001313;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public boolean G() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String r() {
        return "tb.pb_normal";
    }
}
