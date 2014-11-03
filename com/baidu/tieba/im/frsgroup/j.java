package com.baidu.tieba.im.frsgroup;

import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
import protobuf.QueryGroupsByFid.DataReq;
import protobuf.QueryGroupsByFid.QueryGroupsByFidReqIdl;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.mvc.b.d, com.baidu.tbadk.mvc.b.g {
    private boolean aXh;
    private String forumId;
    private int offset;
    private int rn;
    private int type;
    private int mImageWidth = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst(), 70.0f);
    private int mImageHeight = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst(), 70.0f);

    public String getForumId() {
        return this.forumId;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setOffset(int i) {
        this.offset = i;
        if (i == 0) {
            this.rn = 50;
        } else {
            this.rn = 20;
        }
    }

    public void Nv() {
        this.offset += this.rn;
        setOffset(this.offset);
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public void initWithBundle(Bundle bundle) {
        this.forumId = bundle.getString("forum_id");
        this.aXh = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.SHOW_RECOMMEND, true);
        if (bundle.containsKey("card_type")) {
            this.type = bundle.getInt("card_type");
        } else {
            this.type = this.aXh ? 1 : 2;
        }
        this.offset = bundle.getInt("start_position", 0);
        this.rn = bundle.getInt("end_position", 50);
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public HashMap<String, Object> tq() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public Object ay(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forumId = Integer.valueOf(com.baidu.adp.lib.g.c.f(getForumId(), 0));
        builder.offset = Integer.valueOf(this.offset);
        builder.rn = Integer.valueOf(this.rn);
        builder.type = Integer.valueOf(this.type);
        builder.width = Integer.valueOf(this.mImageWidth);
        builder.height = Integer.valueOf(this.mImageHeight);
        QueryGroupsByFidReqIdl.Builder builder2 = new QueryGroupsByFidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Override // com.baidu.tbadk.mvc.b.c
    public String getCacheKey() {
        return "frs_group_" + this.type + "_" + this.forumId;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String sY() {
        return "tb.im_frsgroup";
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public boolean to() {
        return true;
    }
}
