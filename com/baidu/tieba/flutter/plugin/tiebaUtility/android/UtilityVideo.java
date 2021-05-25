package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto;
import d.a.m0.z0.m0;
import d.a.n0.k2.n;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class UtilityVideo implements TiebaUtilityVideoAuto.HostUtilityVideo {
    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void getResumeTimeForVideo(TiebaUtilityVideoAuto.VideoStringParam videoStringParam, TiebaUtilityVideoAuto.Result<TiebaUtilityVideoAuto.ResumeTimeResult> result) {
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void getVideoMute(TiebaUtilityVideoAuto.Result<TiebaUtilityVideoAuto.VideoBoolValue> result) {
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void isVideoCardMute(TiebaUtilityVideoAuto.Result<TiebaUtilityVideoAuto.VideoBoolValue> result) {
        TiebaUtilityVideoAuto.VideoBoolValue videoBoolValue = new TiebaUtilityVideoAuto.VideoBoolValue();
        videoBoolValue.setResult(Boolean.valueOf(TbSingleton.getInstance().isVideoCardMute()));
        result.success(videoBoolValue);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void setVideoCardMute(TiebaUtilityVideoAuto.VideoBoolValue videoBoolValue) {
        boolean booleanValue = videoBoolValue.getResult().booleanValue();
        TbSingleton.getInstance().setVideoCardMute(booleanValue);
        m0.e(new WeakReference(TbadkCoreApplication.getInst()), !booleanValue);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void setVideoMute(TiebaUtilityVideoAuto.VideoBoolValue videoBoolValue, TiebaUtilityVideoAuto.Result<TiebaUtilityVideoAuto.VideoBoolValue> result) {
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void updateTime(TiebaUtilityVideoAuto.VideoTimeParam videoTimeParam) {
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void videoPositionCacheManagerGetCachePosition(TiebaUtilityVideoAuto.VideoStringParam videoStringParam, TiebaUtilityVideoAuto.Result<TiebaUtilityVideoAuto.CachePosition> result) {
        int c2 = n.d().c(videoStringParam.getResult());
        TiebaUtilityVideoAuto.CachePosition cachePosition = new TiebaUtilityVideoAuto.CachePosition();
        cachePosition.setResult(Long.valueOf(c2));
        result.success(cachePosition);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void videoPositionCacheManagerRemove(TiebaUtilityVideoAuto.VideoStringParam videoStringParam) {
        n.d().e(videoStringParam.getResult());
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityVideoAuto.HostUtilityVideo
    public void videoPositionCacheManagerUpdate(TiebaUtilityVideoAuto.VideoTimeParam videoTimeParam) {
        n.d().f(videoTimeParam.getVideoUrl(), videoTimeParam.getDurtion() != null ? videoTimeParam.getDurtion().intValue() : 0);
    }
}
