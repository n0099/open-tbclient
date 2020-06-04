package com.baidu.tieba.aiapps.apps.a;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.bdprivate.a.aa;
import com.baidu.swan.bdprivate.a.l;
import com.baidu.swan.bdprivate.a.y;
import com.baidu.swan.bdprivate.a.z;
import com.baidu.swan.bdprivate.api.b;
import com.baidu.swan.bdprivate.b.a;
import com.baidu.swan.bdprivate.e.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class c implements com.baidu.swan.bdprivate.a.a.a {
    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(Context context, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a.bnZ().a(context, bundle, aVar);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public boolean isLogin(Context context) {
        return a.bnZ().isLogin();
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public String getBduss(Context context) {
        return a.bnZ().getBduss();
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(String str, ArrayList<String> arrayList, b.a aVar) {
        a.bnZ().b(str, arrayList, aVar);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public String getUid(Context context) {
        return a.bnZ().getUid();
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public String getCuid(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("aps_identity", 0);
        String string = sharedPreferences.getString("uid_v3", "");
        if (TextUtils.isEmpty(string)) {
            String generateUID = generateUID(context);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("uid_v3", generateUID);
            edit.apply();
            return generateUID;
        }
        return string;
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public z cT(Context context) {
        z zVar = new z();
        zVar.displayName = a.bnZ().getDisplayName();
        zVar.aOX = a.bnZ().bob();
        return zVar;
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void b(com.baidu.swan.apps.a.c cVar) {
        a.bnZ().a(cVar);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(final l.a aVar, String str, List<String> list) {
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.tieba.aiapps.apps.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                if (aVar != null) {
                    l lVar = new l();
                    if (getTplStokenResult != null) {
                        lVar.mStokens = getTplStokenResult.tplStokenMap;
                        lVar.mErrCode = getTplStokenResult.getResultCode();
                        lVar.mErrMsg = getTplStokenResult.getResultMsg();
                        if (getTplStokenResult.failureType != null) {
                            lVar.mFailureType = getTplStokenResult.failureType.name();
                        }
                    }
                    aVar.a(lVar);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                if (aVar != null) {
                    l lVar = new l();
                    if (getTplStokenResult != null) {
                        lVar.mStokens = getTplStokenResult.tplStokenMap;
                        lVar.mErrCode = getTplStokenResult.getResultCode();
                        lVar.mErrMsg = getTplStokenResult.getResultMsg();
                        if (getTplStokenResult.failureType != null) {
                            lVar.mFailureType = getTplStokenResult.failureType.name();
                        }
                    }
                    aVar.b(lVar);
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                if (aVar != null) {
                    aVar.onStart();
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                if (aVar != null) {
                    aVar.onFinish();
                }
            }
        }, str, list);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public String cQ(Context context) {
        return h.arO().getString("bd_box_ptoken", "");
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public String getZid(Context context) {
        return null;
    }

    private static String generateUID(Context context) {
        return CommonParam.getCUID(context);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(Activity activity, String str, String str2, final aa aaVar) {
        FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
        faceIDVerifyDTO.businessSence = str;
        faceIDVerifyDTO.bduss = str2;
        PassportSDK.getInstance().verifyUserFaceId(activity, new VerifyUserFaceIDCallback() { // from class: com.baidu.tieba.aiapps.apps.a.c.2
            @Override // com.baidu.sapi2.callback.FaceIDCallback
            public void onSuccess(SapiResult sapiResult) {
                y yVar = new y();
                if (sapiResult instanceof RealNameFaceIDResult) {
                    yVar.callbackkey = ((RealNameFaceIDResult) sapiResult).callBackKey;
                    aaVar.a(yVar);
                } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                    yVar.callbackkey = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                    aaVar.a(yVar);
                }
            }

            @Override // com.baidu.sapi2.callback.FaceIDCallback
            public void onFailure(SapiResult sapiResult) {
                aaVar.onFailure(sapiResult.getResultMsg());
            }
        }, faceIDVerifyDTO);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void b(Activity activity, String str, String str2, final aa aaVar) {
        RealNameDTO realNameDTO = new RealNameDTO();
        realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
        realNameDTO.scene = str;
        realNameDTO.needCbKey = true;
        PassportSDK.getInstance().loadAccountRealName(activity, new AccountRealNameCallback() { // from class: com.baidu.tieba.aiapps.apps.a.c.3
            @Override // com.baidu.sapi2.callback.AccountRealNameCallback
            public void onFinish(AccountRealNameResult accountRealNameResult) {
                super.onFinish(accountRealNameResult);
                if (accountRealNameResult.getResultCode() == 0) {
                    y yVar = new y();
                    if (accountRealNameResult.seniorRealNameSuc) {
                        yVar.callbackkey = accountRealNameResult.callbackkey;
                        yVar.seniorRealNameSuc = true;
                        aaVar.a(yVar);
                        return;
                    }
                }
                aaVar.onFailure(accountRealNameResult.getResultMsg());
            }
        }, realNameDTO);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(Context context, a.InterfaceC0408a interfaceC0408a) {
        a.bnZ().a(context, "1", interfaceC0408a);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(Context context, a.InterfaceC0412a interfaceC0412a) {
        a.bnZ().a(context, "1", interfaceC0412a);
    }
}
