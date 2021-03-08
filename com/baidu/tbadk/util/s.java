package com.baidu.tbadk.util;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    public static void a(boolean z, Context context, cb cbVar, int i, Rect rect, String str, String str2, String str3, String str4, String str5) {
        if (cbVar != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            if (z) {
                videoItemData.buildWithOriginThreadData(cbVar.eUD);
            } else {
                videoItemData.buildWithThreadData(cbVar);
            }
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, arrayList, i, rect, str, str2, str3, str4, str5);
            if (cbVar.eUD != null && cbVar.eUD.oriUgcInfo != null) {
                videoPlayActivityConfig.setNid(cbVar.eUD.oriUgcInfo.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    public static void a(boolean z, Context context, cb cbVar, String str) {
        if (cbVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            if (z) {
                videoSerializeVideoThreadInfo.copyFromTransmitThreadData(cbVar);
            } else {
                videoSerializeVideoThreadInfo.copyFromThreadInfo(cbVar);
            }
            VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(context, str, videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.m.bnE(), cbVar.bls(), videoSerializeVideoThreadInfo);
            if (videoSerializeVideoThreadInfo.mBaijiahaoData != null && !TextUtils.isEmpty(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid)) {
                videoMiddlePageLightActivityConfig.setNid(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageLightActivityConfig));
        }
    }

    private static void b(Context context, cb cbVar, String str) {
        if (cbVar != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(cbVar);
            a(context, cbVar, str, videoSerializeVideoThreadInfo.threadId, com.baidu.tieba.card.m.bnE(), cbVar.bls(), videoSerializeVideoThreadInfo);
        }
    }

    private static void a(Context context, cb cbVar, String str, String str2, String str3, String str4, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(context, str, str2, str3, str4, videoSerializeVideoThreadInfo);
        if (videoSerializeVideoThreadInfo.mBaijiahaoData != null && !TextUtils.isEmpty(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid)) {
            videoMiddlePageActivityConfig.setNid(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    public static void a(int i, Context context, cb cbVar, int i2, Rect rect, String str, String str2, String str3, String str4, String str5) {
        if (cbVar != null) {
            if (com.baidu.tbadk.a.d.bjw()) {
                a(true, context, cbVar, str4);
            } else if (com.baidu.tbadk.a.d.bjx()) {
                a(true, context, cbVar.blp(), i2, rect, str, str2, str3, str4, str5);
            } else {
                az.a(cbVar.eUD, context, i);
            }
        }
    }

    public static void a(int i, boolean z, Context context, cb cbVar, int i2, Rect rect, String str, String str2, String str3, String str4, String str5) {
        if (cbVar != null) {
            if (com.baidu.tbadk.a.d.bjC()) {
                a(true, context, cbVar, str4);
            } else if (com.baidu.tbadk.a.d.bjD()) {
                a(true, context, cbVar.blp(), i2, rect, str, str2, str3, str4, str5);
            } else if (com.baidu.tbadk.a.d.bjA()) {
                az.a(cbVar.eUD, context, i);
            } else if (z) {
                a(true, context, cbVar.blp(), i2, rect, str, str2, str3, str4, str5);
            } else {
                b(context, cbVar, str4);
            }
        }
    }
}
