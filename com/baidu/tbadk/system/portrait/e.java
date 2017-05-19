package com.baidu.tbadk.system.portrait;

import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends GetPopularPortraitsCallback {
    final /* synthetic */ ChangeSystemPhotoActivity aIN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIN = changeSystemPhotoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    /* renamed from: a */
    public void onSuccess(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
        h hVar;
        ArrayList<i> arrayList;
        h hVar2;
        ArrayList arrayList2;
        if (getPopularPortraitsInfoResult != null && getPopularPortraitsInfoResult.popularPortraitsInfoList != null && getPopularPortraitsInfoResult.popularPortraitsInfoList.size() > 0) {
            for (GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo : getPopularPortraitsInfoResult.popularPortraitsInfoList) {
                if (popularPortraitsInfo != null && popularPortraitsInfo.url != null) {
                    i iVar = new i();
                    iVar.setUrl(popularPortraitsInfo.url);
                    iVar.setNum(popularPortraitsInfo.num);
                    iVar.ff(popularPortraitsInfo.myItem);
                    iVar.fZ(popularPortraitsInfo.series);
                    arrayList2 = this.aIN.aIF;
                    arrayList2.add(iVar);
                }
            }
            hVar = this.aIN.aIE;
            arrayList = this.aIN.aIF;
            hVar.s(arrayList);
            hVar2 = this.aIN.aIE;
            hVar2.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    /* renamed from: b */
    public void onFailure(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
    }
}
