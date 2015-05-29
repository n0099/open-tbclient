package com.baidu.tbadk.system.portrait;

import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends GetPopularPortraitsCallback {
    final /* synthetic */ ChangeSystemPhotoActivity arP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.arP = changeSystemPhotoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    /* renamed from: a */
    public void onSuccess(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
        i iVar;
        ArrayList<k> arrayList;
        i iVar2;
        ArrayList arrayList2;
        if (getPopularPortraitsInfoResult != null && getPopularPortraitsInfoResult.popularPortraitsInfoList != null && getPopularPortraitsInfoResult.popularPortraitsInfoList.size() > 0) {
            for (GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo : getPopularPortraitsInfoResult.popularPortraitsInfoList) {
                if (popularPortraitsInfo != null && popularPortraitsInfo.url != null) {
                    k kVar = new k();
                    kVar.setUrl(popularPortraitsInfo.url);
                    kVar.setNum(popularPortraitsInfo.num);
                    kVar.eq(popularPortraitsInfo.myItem);
                    kVar.fc(popularPortraitsInfo.series);
                    arrayList2 = this.arP.arJ;
                    arrayList2.add(kVar);
                }
            }
            iVar = this.arP.arI;
            arrayList = this.arP.arJ;
            iVar.s(arrayList);
            iVar2 = this.arP.arI;
            iVar2.notifyDataSetChanged();
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
