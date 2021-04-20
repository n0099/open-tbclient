package com.baidu.tieba.flutter.plugin.networkService;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseGetLivableForumList;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import d.b.h0.g0.b.g;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ProtoHelper {
    public static HashMap<String, Integer> platformImageNameMap;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        platformImageNameMap = hashMap;
        hashMap.put(TbConfig.SERVER_ADDRESS + "c/f/forum/getforumlist", Integer.valueOf((int) CmdConfigHttp.SIGNALL_GET_FOURMS));
        HashMap<String, Integer> hashMap2 = platformImageNameMap;
        hashMap2.put(TbConfig.SERVER_ADDRESS + "c/c/forum/msign", 0);
        HashMap<String, Integer> hashMap3 = platformImageNameMap;
        hashMap3.put(TbConfig.SERVER_ADDRESS + "c/u/user/profile", Integer.valueOf((int) CmdConfigHttp.PROFILE_HTTP_CMD));
        HashMap<String, Integer> hashMap4 = platformImageNameMap;
        hashMap4.put(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP, 0);
        HashMap<String, Integer> hashMap5 = platformImageNameMap;
        hashMap5.put(TbConfig.SERVER_ADDRESS + TbConfig.GET_FORUM_DETAIL, Integer.valueOf((int) CmdConfigHttp.MSG_FORUM_DETAIL_CMD));
        HashMap<String, Integer> hashMap6 = platformImageNameMap;
        hashMap6.put(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS, 0);
        HashMap<String, Integer> hashMap7 = platformImageNameMap;
        hashMap7.put(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS, Integer.valueOf((int) CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD));
        HashMap<String, Integer> hashMap8 = platformImageNameMap;
        hashMap8.put(TbConfig.SERVER_ADDRESS + "c/e/meme/checkForumPkg", Integer.valueOf((int) CmdConfigHttp.MSG_FORUM_EMOTION_CMD));
        HashMap<String, Integer> hashMap9 = platformImageNameMap;
        hashMap9.put(TbConfig.SERVER_ADDRESS + TbConfig.DEBUG_UPLOAD, 0);
        HashMap<String, Integer> hashMap10 = platformImageNameMap;
        hashMap10.put(TbConfig.SERVER_ADDRESS + TbConfig.SET_PRIVATE, Integer.valueOf((int) CmdConfigHttp.SET_PRIVATE_CMD));
        HashMap<String, Integer> hashMap11 = platformImageNameMap;
        hashMap11.put(TbConfig.SERVER_ADDRESS + "c/f/forum/like", Integer.valueOf((int) CmdConfigHttp.PIC_LIKE_BAR_CMD));
    }

    public static int getHttpCmdFromUrl(String str) {
        if (platformImageNameMap.containsKey(str)) {
            return platformImageNameMap.get(str).intValue();
        }
        return 0;
    }

    public static FlutterNetModelAuto getImNetModel(String str, int i, HashMap<String, Object> hashMap) {
        if (i == 104102) {
            FlutterNetModelAuto flutterNetModelAuto = new FlutterNetModelAuto(str, FlutterNetModelAuto.NetModelType.TYPE_SOCKET);
            flutterNetModelAuto.setSocketRequestMsg(getSocketRequestMsg(i, hashMap));
            flutterNetModelAuto.setSocketCmd(i);
            flutterNetModelAuto.setRequestDataClass(RequestUpdateMaskInfoMessage.class);
            flutterNetModelAuto.setResponseDataClass(ResponseUpdateMaskInfoMessage.class);
            return flutterNetModelAuto;
        } else if (i == 107129) {
            FlutterNetModelAuto flutterNetModelAuto2 = new FlutterNetModelAuto(str, FlutterNetModelAuto.NetModelType.TYPE_SOCKET);
            flutterNetModelAuto2.setSocketRequestMsg(getSocketRequestMsg(i, hashMap));
            flutterNetModelAuto2.setNeedCompress(false);
            flutterNetModelAuto2.setNeedParallel(true);
            flutterNetModelAuto2.setSocketCmd(i);
            flutterNetModelAuto2.setRequestDataClass(RequestGetLivableForumList.class);
            flutterNetModelAuto2.setResponseDataClass(ResponseGetLivableForumList.class);
            return flutterNetModelAuto2;
        } else if (i == 304102) {
            FlutterNetModelAuto flutterNetModelAuto3 = new FlutterNetModelAuto(str, FlutterNetModelAuto.NetModelType.TYPE_SOCKET);
            flutterNetModelAuto3.setSocketRequestMsg(getSocketRequestMsg(i, hashMap));
            flutterNetModelAuto3.setNeedCompress(false);
            flutterNetModelAuto3.setNeedParallel(true);
            flutterNetModelAuto3.setSocketCmd(i);
            flutterNetModelAuto3.setRequestDataClass(RequestDeleteFriendMessage.class);
            flutterNetModelAuto3.setResponseDataClass(ResponseDeleteFriendMessage.class);
            return flutterNetModelAuto3;
        } else {
            return null;
        }
    }

    public static FlutterNetModelAuto getNetModel(String str, int i) {
        FlutterNetModelAuto flutterNetModelAuto = new FlutterNetModelAuto(str, FlutterNetModelAuto.NetModelType.TYPE_SOCKET);
        flutterNetModelAuto.setHttpCmd(i);
        return flutterNetModelAuto;
    }

    public static g getRequestData(int i, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        return null;
    }

    public static g getSocketRequestData(int i, HashMap<String, Object> hashMap) {
        return null;
    }

    public static TbSocketMessage getSocketRequestMsg(int i, HashMap<String, Object> hashMap) {
        if (i == 104102) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setIsMask(Integer.valueOf((String) hashMap.get(IntentConfig.IS_MASK)).intValue());
            requestUpdateMaskInfoMessage.setMaskType(Integer.valueOf((String) hashMap.get("type")).intValue());
            requestUpdateMaskInfoMessage.setList((String) hashMap.get("list"));
            return requestUpdateMaskInfoMessage;
        } else if (i != 107129) {
            if (i == 304102) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(Long.valueOf((String) hashMap.get("uid")).longValue());
                return requestDeleteFriendMessage;
            }
            return null;
        } else {
            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
            requestGetLivableForumList.setGetLikeForum(1);
            requestGetLivableForumList.setPageNo(Integer.valueOf((String) hashMap.get("page_no")).intValue());
            requestGetLivableForumList.setPageSize(Integer.valueOf((String) hashMap.get("page_size")).intValue());
            requestGetLivableForumList.setUserId(Long.valueOf((String) hashMap.get("uid")).longValue());
            return requestGetLivableForumList;
        }
    }

    public static String parseSocketResp(SocketResponsedMessage socketResponsedMessage) {
        int cmd = socketResponsedMessage.getCmd();
        if (cmd == 104102) {
            if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("errno", responseUpdateMaskInfoMessage.getError());
                    jSONObject2.put("errmsg", responseUpdateMaskInfoMessage.getErrorString());
                    jSONObject2.put("errorInfo", jSONObject2);
                    return jSONObject.toString();
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return null;
        } else if (cmd == 107129) {
            if (socketResponsedMessage instanceof ResponseGetLivableForumList) {
                ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                if (responseGetLivableForumList.getError() == 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("has_more", responseGetLivableForumList.hasMore() ? 1 : 0);
                        JSONObject jSONObject4 = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        ArrayList<ForumData> data = responseGetLivableForumList.getData();
                        for (int i = 0; i < data.size(); i++) {
                            ForumData forumData = data.get(i);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("id", forumData.getId());
                            jSONObject5.put("name", forumData.getName());
                            jSONObject5.put("favo_type", forumData.getFavo_type());
                            jSONObject5.put("level_id", forumData.getUser_level());
                            jSONObject5.put("level_name", forumData.getLevelName());
                            jSONObject5.put("cur_score", forumData.getCurScore());
                            jSONObject5.put("levelup_score", forumData.getLevelupScore());
                            jSONObject5.put("avatar", forumData.getImage_url());
                            jSONObject5.put("slogan", forumData.getSlogan());
                            jSONArray.put(jSONObject5);
                        }
                        jSONObject4.put("non-gconforum", jSONArray);
                        jSONObject3.put("forum_list", jSONObject4);
                        return jSONObject3.toString();
                    } catch (Exception e3) {
                        BdLog.e(e3);
                        return null;
                    }
                }
                return null;
            }
            return null;
        } else if (cmd == 304102 && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            try {
                JSONObject jSONObject6 = new JSONObject();
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("errno", responseDeleteFriendMessage.getError());
                jSONObject7.put("errmsg", responseDeleteFriendMessage.getErrorString());
                jSONObject7.put("errorInfo", jSONObject7);
                return jSONObject6.toString();
            } catch (Exception e4) {
                BdLog.e(e4);
                return null;
            }
        } else {
            return null;
        }
    }
}
