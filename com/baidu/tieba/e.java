package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.publisher.controller.IPublisherManagerInterface;
import com.baidu.searchbox.publisher.controller.PublisherManagerFactory;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.ugc.utils.UgcServerApiUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.searchbox.ugc.webjs.UnitedSchemeUGCDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.data.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private static com.baidu.tieba.publisher.service.a dWe;
    private static com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private static IPublisherManagerInterface mPublisherInterfaceManager;

    public static com.baidu.tieba.publisher.service.a aWQ() {
        if (dWe == null) {
            dWe = new com.baidu.tieba.publisher.service.a();
        }
        return dWe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean eo(Context context) {
        return bc.checkUpIsLogin(context);
    }

    public static void a(final Activity activity, final h hVar) {
        if (mPermissionJudgement == null) {
            mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        mPermissionJudgement.clearRequestPermissionList();
        mPermissionJudgement.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        mPermissionJudgement.a(new a.InterfaceC0378a() { // from class: com.baidu.tieba.e.1
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0378a
            public void onPermissionsGranted() {
                if (e.eo(activity)) {
                    UgcSchemeModel ugcSchemeModel = new UgcSchemeModel();
                    ugcSchemeModel.publishType = "0";
                    if (!StringUtils.isNull(hVar.placeholder)) {
                        ugcSchemeModel.placeholder = hVar.placeholder;
                    } else {
                        ugcSchemeModel.placeholder = TbadkCoreApplication.getInst().getString(R.string.main_body);
                    }
                    if (!StringUtils.isNull(hVar.placeTitle)) {
                        ugcSchemeModel.placeTitle = hVar.placeTitle;
                    } else {
                        ugcSchemeModel.placeTitle = TbadkCoreApplication.getInst().getString(R.string.publisher_place_title);
                    }
                    ugcSchemeModel.sourceFrom = "tieba";
                    ugcSchemeModel.serverTopicsRule = 0;
                    try {
                        JSONObject jSONObject = new JSONObject("{\"poi_id\":\"\"}");
                        jSONObject.put(UgcConstant.POI_ID, UgcServerApiUtils.getLocationInfo());
                        ugcSchemeModel.location = jSONObject.toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ugcSchemeModel.atSchema = "https://mbd.baidu.com/webpage?type=topic&action=at";
                    ugcSchemeModel.url = "publisher?action=ugc&cmd=177";
                    ugcSchemeModel.callType = 1;
                    ugcSchemeModel.ugcCallback = "tieba";
                    UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.put("publish", new CallbackHandler() { // from class: com.baidu.tieba.e.1.1
                        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
                        public void handleSchemeDispatchCallback(String str, String str2) {
                            if (hVar.dvp != null) {
                                hVar.dvp.onSuccess();
                            }
                        }

                        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
                        public String getCurrentPageUrl() {
                            return null;
                        }
                    });
                    if (e.mPublisherInterfaceManager == null) {
                        IPublisherManagerInterface unused = e.mPublisherInterfaceManager = PublisherManagerFactory.get();
                    }
                    e.mPublisherInterfaceManager.openPublisher(activity, ugcSchemeModel, -1);
                }
            }
        });
        mPermissionJudgement.startRequestPermission(activity);
    }

    public static void b(final Activity activity, final h hVar) {
        if (mPermissionJudgement == null) {
            mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        mPermissionJudgement.clearRequestPermissionList();
        mPermissionJudgement.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        mPermissionJudgement.a(new a.InterfaceC0378a() { // from class: com.baidu.tieba.e.2
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0378a
            public void onPermissionsGranted() {
                if (e.eo(activity)) {
                    UgcSchemeModel ugcSchemeModel = new UgcSchemeModel();
                    ugcSchemeModel.publishType = "4";
                    if (!StringUtils.isNull(hVar.placeholder)) {
                        ugcSchemeModel.placeholder = hVar.placeholder;
                    } else {
                        ugcSchemeModel.placeholder = TbadkCoreApplication.getInst().getString(R.string.main_body);
                    }
                    if (!StringUtils.isNull(hVar.placeTitle)) {
                        ugcSchemeModel.placeTitle = hVar.placeTitle;
                    } else {
                        ugcSchemeModel.placeTitle = TbadkCoreApplication.getInst().getString(R.string.publisher_place_title);
                    }
                    ugcSchemeModel.sourceFrom = "tieba";
                    ugcSchemeModel.serverTopicsRule = 0;
                    try {
                        JSONObject jSONObject = new JSONObject("{\"poi_id\":\"\"}");
                        jSONObject.put(UgcConstant.POI_ID, UgcServerApiUtils.getLocationInfo());
                        ugcSchemeModel.location = jSONObject.toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ugcSchemeModel.atSchema = "https://mbd.baidu.com/webpage?type=topic&action=at";
                    ugcSchemeModel.url = "publisher?action=ugc&cmd=177";
                    ugcSchemeModel.callType = 1;
                    ugcSchemeModel.ugcCallback = "tieba";
                    UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.put("publish", new CallbackHandler() { // from class: com.baidu.tieba.e.2.1
                        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
                        public void handleSchemeDispatchCallback(String str, String str2) {
                            if (hVar.dvp != null) {
                                hVar.dvp.onSuccess();
                            }
                        }

                        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
                        public String getCurrentPageUrl() {
                            return null;
                        }
                    });
                    if (e.mPublisherInterfaceManager == null) {
                        IPublisherManagerInterface unused = e.mPublisherInterfaceManager = PublisherManagerFactory.get();
                    }
                    e.mPublisherInterfaceManager.openPublisher(activity, ugcSchemeModel, -1);
                }
            }
        });
        mPermissionJudgement.startRequestPermission(activity);
    }

    public static void c(final Activity activity, final h hVar) {
        if (mPermissionJudgement == null) {
            mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        mPermissionJudgement.clearRequestPermissionList();
        mPermissionJudgement.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        mPermissionJudgement.a(new a.InterfaceC0378a() { // from class: com.baidu.tieba.e.3
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0378a
            public void onPermissionsGranted() {
                if (e.eo(activity)) {
                    UgcSchemeModel ugcSchemeModel = new UgcSchemeModel();
                    ugcSchemeModel.url = "publisher?action=ugc&cmd=177";
                    ugcSchemeModel.atSchema = "https://mbd.baidu.com/webpage?type=topic&action=at";
                    ugcSchemeModel.publishType = "5";
                    ugcSchemeModel.callType = 1;
                    if (!StringUtils.isNull(hVar.placeholder)) {
                        ugcSchemeModel.placeholder = hVar.placeholder;
                    } else {
                        ugcSchemeModel.placeholder = TbadkCoreApplication.getInst().getString(R.string.publisher_forward_place_hint);
                    }
                    if (!StringUtils.isNull(hVar.placeTitle)) {
                        ugcSchemeModel.placeTitle = hVar.placeTitle;
                    } else {
                        ugcSchemeModel.placeTitle = TbadkCoreApplication.getInst().getString(R.string.publisher_forward_place_title);
                    }
                    ugcSchemeModel.sourceFrom = "tieba";
                    if (!StringUtils.isNull(hVar.dvq)) {
                        ugcSchemeModel.forwardContent = hVar.dvq;
                    }
                    if (hVar.dvr != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("title", hVar.dvr.title);
                            jSONObject.put("ref_type", hVar.dvr.ref_type);
                            jSONObject.put("thumbpic", hVar.dvr.thumbpic);
                            jSONObject.put("channel", hVar.dvr.channel);
                            jSONObject.put("url", hVar.dvr.url);
                            jSONObject.put("account_type", hVar.dvr.dvA);
                            jSONObject.put("id", hVar.dvr.id);
                            jSONObject.put("nid", hVar.dvr.nid);
                            jSONObject.put("video_duration", hVar.dvr.video_duration);
                            jSONObject.put(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, hVar.dvr.avatar);
                            jSONObject.put("tid", hVar.dvr.tid);
                            ugcSchemeModel.referenceDt = jSONObject.toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (hVar.dvs != null) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("share_type", hVar.dvs.dvx);
                            jSONObject2.put("forward_rel_id", hVar.dvs.dvy);
                            jSONObject2.put("forward_is_comment", hVar.dvs.dvz);
                            ugcSchemeModel.ext = jSONObject2.toString();
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    ugcSchemeModel.ugcCallback = "tieba";
                    UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.put("publish", new CallbackHandler() { // from class: com.baidu.tieba.e.3.1
                        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
                        public void handleSchemeDispatchCallback(String str, String str2) {
                            if (hVar.dvp != null) {
                                hVar.dvp.onSuccess();
                            }
                        }

                        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
                        public String getCurrentPageUrl() {
                            return null;
                        }
                    });
                    if (e.mPublisherInterfaceManager == null) {
                        IPublisherManagerInterface unused = e.mPublisherInterfaceManager = PublisherManagerFactory.get();
                    }
                    e.mPublisherInterfaceManager.openPublisher(activity, ugcSchemeModel, -1);
                }
            }
        });
        mPermissionJudgement.startRequestPermission(activity);
    }
}
