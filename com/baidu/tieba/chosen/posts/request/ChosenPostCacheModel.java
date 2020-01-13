package com.baidu.tieba.chosen.posts.request;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
/* loaded from: classes8.dex */
public class ChosenPostCacheModel extends CacheModel<b, ChosenPostActivity> {
    public static final String CACHE_KEY = "chosen_post_cache";

    public ChosenPostCacheModel(TbPageContext<ChosenPostActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<b> aOc() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String aNL() {
        return "tb.pb_normal";
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int aOd() {
        return CmdConfigCustom.CMD_CHOSEN_POST_READ_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int aOe() {
        return CmdConfigCustom.CMD_CHOSEN_POST_WRITE_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    protected boolean aNV() {
        return false;
    }
}
