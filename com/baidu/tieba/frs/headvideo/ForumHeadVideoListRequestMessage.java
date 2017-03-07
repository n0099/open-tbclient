package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.ForumHeadVideo.DataReq;
import tbclient.ForumHeadVideo.ForumHeadVideoReqIdl;
/* loaded from: classes.dex */
public class ForumHeadVideoListRequestMessage extends NetMessage {
    private long activeTid;
    private long fid;
    private int pn;
    private int rn;

    public ForumHeadVideoListRequestMessage() {
        super(CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, 309387);
    }

    public int getPn() {
        return this.pn;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public long getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setActiveTid(long j) {
        this.activeTid = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.rn = Integer.valueOf(this.rn);
            builder.pn = Integer.valueOf(this.pn);
            builder.fid = Long.valueOf(this.fid);
            builder.active_tid = Long.valueOf(this.activeTid);
            int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
            int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst().getApp());
            int viewImageQuality = com.baidu.tbadk.core.l.oQ().getViewImageQuality();
            builder.scr_w = Integer.valueOf(ag);
            builder.scr_h = Integer.valueOf(ah);
            builder.scr_dip = Double.valueOf(com.baidu.adp.lib.util.k.ai(TbadkCoreApplication.m9getInst().getApp()));
            builder.q_type = Integer.valueOf(viewImageQuality);
            if (z) {
                com.baidu.tbadk.util.n.bindCommonParamsToProtobufData(builder, true);
            }
            ForumHeadVideoReqIdl.Builder builder2 = new ForumHeadVideoReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
