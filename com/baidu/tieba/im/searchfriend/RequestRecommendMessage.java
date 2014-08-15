package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.RecommendFriend.RecommendFriendReqIdl;
import protobuf.RecommendFriend.ReqData;
/* loaded from: classes.dex */
public class RequestRecommendMessage extends TbSocketMessage {
    public static final int PIC_QUALITY_HIGH = 100;
    public static final int PIC_QUALITY_LOW = 45;
    private float dpi;
    private int height;
    private int quality;
    private int width;

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setDpi(float f) {
        this.dpi = f;
    }

    public void setQuality(String str) {
        if (TextUtils.equals(str, "80")) {
            this.quality = 100;
        } else {
            this.quality = 45;
        }
    }

    public RequestRecommendMessage() {
        super(304106);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        ReqData.Builder builder = new ReqData.Builder();
        builder.scr_dip = Double.valueOf(this.dpi);
        builder.scr_h = Integer.valueOf(this.height);
        builder.scr_w = Integer.valueOf(this.width);
        builder.q_type = Integer.valueOf(this.quality);
        RecommendFriendReqIdl.Builder builder2 = new RecommendFriendReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
