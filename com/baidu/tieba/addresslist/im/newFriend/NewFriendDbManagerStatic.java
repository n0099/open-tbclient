package com.baidu.tieba.addresslist.im.newFriend;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tbadk.newFriends.RequestPassFriendMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NewFriendDbManagerStatic {
    private static NewFriendDbManagerStatic djb = new NewFriendDbManagerStatic();

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_APPLY_MESSAGE) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof RequestApplyLocalMessage) {
                    RequestApplyLocalMessage requestApplyLocalMessage = (RequestApplyLocalMessage) customResponsedMessage;
                    long uid = requestApplyLocalMessage.getUid();
                    long friendId = requestApplyLocalMessage.getFriendId();
                    String message = requestApplyLocalMessage.getMessage();
                    RequestApplyMessage requestApplyMessage = new RequestApplyMessage();
                    requestApplyMessage.setFriendId(friendId);
                    requestApplyMessage.setMessage(message);
                    requestApplyMessage.setUid(uid);
                    MessageManager.getInstance().sendMessage(requestApplyMessage);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_ADD_LOCAL) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001169) {
                    RequestNewFriendActionLocalMessage requestNewFriendActionLocalMessage = (RequestNewFriendActionLocalMessage) customResponsedMessage;
                    final long id = requestNewFriendActionLocalMessage.getId();
                    String name = requestNewFriendActionLocalMessage.getName();
                    String portrait = requestNewFriendActionLocalMessage.getPortrait();
                    String content = requestNewFriendActionLocalMessage.getContent();
                    String st_type = requestNewFriendActionLocalMessage.getSt_type();
                    RequestAddFriendMessage requestAddFriendMessage = new RequestAddFriendMessage();
                    requestAddFriendMessage.setFriendId(id);
                    requestAddFriendMessage.setMessage(content);
                    requestAddFriendMessage.setSt_type(st_type);
                    MessageManager.getInstance().sendMessage(requestAddFriendMessage);
                    final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                    aVar.setId(id);
                    aVar.setName(name);
                    aVar.setStatus(0);
                    aVar.setPortrait(portrait);
                    aVar.setContent(content);
                    aVar.tV(0);
                    z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.12.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.y
                        /* renamed from: aEe */
                        public Void doInBackground() {
                            if (!b.aEj().bJ(id)) {
                                b.aEj().g(aVar);
                                return null;
                            }
                            return null;
                        }
                    }, null);
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_ADD_NEW_FRIEND) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
                    ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
                    final RequestAddFriendMessage requestAddFriendMessage = (RequestAddFriendMessage) responseAddFriendMessage.getOrginalMessage();
                    int error = responseAddFriendMessage.getError();
                    final long friendId = responseAddFriendMessage.getFriendId();
                    final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                    aVar.setId(friendId);
                    aVar.tV(0);
                    aVar.setContent(requestAddFriendMessage.getMessage());
                    if (error == 0) {
                        aVar.setStatus(3);
                        z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.y
                            /* renamed from: aEe */
                            public Void doInBackground() {
                                com.baidu.tieba.im.data.a bK = b.aEj().bK(friendId);
                                if (bK != null) {
                                    aVar.setName(bK.getName());
                                    aVar.setPortrait(bK.getPortrait());
                                    b.aEj().g(aVar);
                                }
                                return null;
                            }
                        }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.j
                            /* renamed from: a */
                            public void onReturnDataInUI(Void r9) {
                                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, friendId, "", "", "", "");
                                responseNewFriendUpdateUiMsg.setContent(requestAddFriendMessage.getMessage());
                                MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
                            }
                        });
                    } else if (error == 3100097) {
                        Message<?> orginalMessage = responseAddFriendMessage.getOrginalMessage();
                        if (orginalMessage instanceof RequestAddFriendMessage) {
                            final long friendId2 = ((RequestAddFriendMessage) orginalMessage).getFriendId();
                            z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.3
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.y
                                /* renamed from: aEe */
                                public Void doInBackground() {
                                    if (0 != friendId2 && b.aEj().bJ(friendId2)) {
                                        com.baidu.tieba.im.data.a aVar2 = new com.baidu.tieba.im.data.a();
                                        aVar2.setId(friendId2);
                                        aVar2.setStatus(3);
                                        aVar2.tV(0);
                                        b.aEj().h(aVar2);
                                    }
                                    return null;
                                }
                            }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.4
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.j
                                /* renamed from: a */
                                public void onReturnDataInUI(Void r9) {
                                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, friendId2, "", "", "", ""));
                                }
                            });
                        }
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_DELETE_NEW_FRIEND) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
                    ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                    int error = responseDeleteFriendMessage.getError();
                    final long friendId = responseDeleteFriendMessage.getFriendId();
                    if (error == 0) {
                        z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.16.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.y
                            /* renamed from: aEe */
                            public Void doInBackground() {
                                if (0 != friendId) {
                                    b.aEj().bI(friendId);
                                    m.bAD().xE(String.valueOf(friendId));
                                }
                                return null;
                            }
                        }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.16.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.j
                            /* renamed from: a */
                            public void onReturnDataInUI(Void r9) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(1, friendId, "", "", "", ""));
                            }
                        });
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_PASS_NEW_FRIEND) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePassFriendMessage)) {
                    ResponsePassFriendMessage responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage;
                    int error = responsePassFriendMessage.getError();
                    final long friendId = responsePassFriendMessage.getFriendId();
                    final String name = responsePassFriendMessage.getName();
                    final String portrait = responsePassFriendMessage.getPortrait();
                    final String key = responsePassFriendMessage.getKey();
                    final String quanpin = responsePassFriendMessage.getQuanpin();
                    final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                    aVar.setId(friendId);
                    aVar.setStatus(2);
                    aVar.tV(0);
                    if (error == 0) {
                        z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.y
                            /* renamed from: aEe */
                            public Void doInBackground() {
                                com.baidu.tieba.im.data.a bK;
                                if (0 != friendId && (bK = b.aEj().bK(friendId)) != null) {
                                    aVar.setContent(bK.getContent());
                                    aVar.setName(bK.getName());
                                    aVar.setPortrait(bK.getPortrait());
                                    b.aEj().g(aVar);
                                }
                                return null;
                            }
                        }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.j
                            /* renamed from: a */
                            public void onReturnDataInUI(Void r9) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, friendId, portrait, name, key, quanpin));
                            }
                        });
                    } else if (error == 3100098) {
                        Message<?> orginalMessage = responsePassFriendMessage.getOrginalMessage();
                        if (orginalMessage instanceof RequestPassFriendMessage) {
                            final long friendId2 = ((RequestPassFriendMessage) orginalMessage).getFriendId();
                            z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.3
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.y
                                /* renamed from: aEe */
                                public Void doInBackground() {
                                    if (0 != friendId2 && b.aEj().bJ(friendId2)) {
                                        com.baidu.tieba.im.data.a aVar2 = new com.baidu.tieba.im.data.a();
                                        aVar2.setId(friendId2);
                                        aVar2.setStatus(2);
                                        aVar2.tV(0);
                                        b.aEj().h(aVar2);
                                    }
                                    return null;
                                }
                            }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.4
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.j
                                /* renamed from: a */
                                public void onReturnDataInUI(Void r9) {
                                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, friendId2, "", "", "", ""));
                                }
                            });
                        }
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new AnonymousClass18(CmdConfigCustom.CMD_REQUEST_UNREAD_NEW_FRIENDS_NUM));
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_DELETE_ACCOUNT) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    com.baidu.tbadk.core.sharedPref.b.alP().remove(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + ((String) customResponsedMessage.getData()));
                }
            }
        });
        CustomMessageListener customMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                GroupNewsPojo p;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                    String cmd = p.getCmd();
                    if (!TextUtils.isEmpty(cmd)) {
                        String content = p.getContent();
                        if (!TextUtils.isEmpty(content)) {
                            if (cmd.equals("apply_new_friend")) {
                                NewFriendDbManagerStatic.aEd().rG(content);
                            } else if (cmd.equals("passed_new_friend")) {
                                NewFriendDbManagerStatic.aEd().rH(content);
                            } else if (cmd.equals("delete_new_friend")) {
                                NewFriendDbManagerStatic.aEd().rI(content);
                            } else if (cmd.equals("apply_reply_message")) {
                                NewFriendDbManagerStatic.aEd().rJ(content);
                            } else if (cmd.equals("apply_add_friend")) {
                                NewFriendDbManagerStatic.aEd().rK(content);
                            } else if (cmd.equals("apply_pass_friend")) {
                                NewFriendDbManagerStatic.aEd().rL(content);
                            }
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_NEW_FRIEND_LOCAL, customMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, customMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, customMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, customMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, customMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, customMessageListener);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID, new CustomMessageTask.CustomRunnable<Long>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.21
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.im.data.a> run(CustomMessage<Long> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new ResponseNewFriendDataMessage(b.aEj().bK(customMessage.getData().longValue()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private NewFriendDbManagerStatic() {
    }

    public static NewFriendDbManagerStatic aEd() {
        return djb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic$18  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static class AnonymousClass18 extends CustomMessageListener {
        int num;

        AnonymousClass18(int i) {
            super(i);
            this.num = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001175) {
                z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.18.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.y
                    /* renamed from: aEe */
                    public Void doInBackground() {
                        AnonymousClass18.this.num = b.aEj().aEk();
                        return null;
                    }
                }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.18.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    /* renamed from: a */
                    public void onReturnDataInUI(Void r4) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(AnonymousClass18.this.num, false));
                    }
                });
            }
        }
    }

    public void rG(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                aVar.setId(optJSONObject.optLong("user_id"));
                aVar.setName(optJSONObject.optString("user_name"));
                aVar.setPortrait(optJSONObject.optString("portrait"));
                aVar.setContent(optJSONObject.optString("message"));
                aVar.tV(0);
                aVar.setStatus(1);
                z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.y
                    /* renamed from: aEe */
                    public Void doInBackground() {
                        b.aEj().g(aVar);
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(b.aEj().aEk(), true));
                        return null;
                    }
                }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    /* renamed from: a */
                    public void onReturnDataInUI(Void r9) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, 0L, "", "", "", ""));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rH(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                aVar.setId(optJSONObject.optLong("user_id"));
                aVar.setName(optJSONObject.optString("user_name"));
                aVar.setPortrait(optJSONObject.optString("portrait"));
                aVar.setContent(optJSONObject.optString("message"));
                final String optString = optJSONObject.optString(TiebaInitialize.Params.KEY);
                final String optString2 = optJSONObject.optString("pinyin");
                aVar.tV(0);
                aVar.setStatus(4);
                z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.y
                    /* renamed from: aEe */
                    public Void doInBackground() {
                        b.aEj().g(aVar);
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(b.aEj().aEk(), true));
                        return null;
                    }
                }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.5
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    /* renamed from: a */
                    public void onReturnDataInUI(Void r9) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, aVar.getId(), aVar.getPortrait(), aVar.getName(), optString, optString2));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rI(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                final long optLong = optJSONObject.optLong("user_id");
                z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.y
                    /* renamed from: aEe */
                    public Void doInBackground() {
                        b.aEj().bI(optLong);
                        return null;
                    }
                }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.7
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    /* renamed from: a */
                    public void onReturnDataInUI(Void r1) {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rJ(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                final long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString("portrait");
                String optString3 = optJSONObject.optString("message");
                int optInt = optJSONObject.optInt("type");
                if (optInt == 1) {
                    aVar.setStatus(3);
                } else if (optInt == 2) {
                    aVar.setStatus(1);
                }
                aVar.setContent(optString3);
                aVar.setId(optLong);
                aVar.tV(1);
                aVar.setName(optString);
                aVar.setPortrait(optString2);
                z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.8
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.y
                    /* renamed from: aEe */
                    public Void doInBackground() {
                        b.aEj().g(aVar);
                        return null;
                    }
                }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.9
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    /* renamed from: a */
                    public void onReturnDataInUI(Void r9) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, optLong, "", "", "", ""));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rK(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                final long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString("portrait");
                String optString3 = optJSONObject.optString("message");
                aVar.setStatus(3);
                aVar.setContent(optString3);
                aVar.setId(optLong);
                aVar.tV(1);
                aVar.setName(optString);
                aVar.setPortrait(optString2);
                z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.10
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.y
                    /* renamed from: aEe */
                    public Void doInBackground() {
                        b.aEj().g(aVar);
                        return null;
                    }
                }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    /* renamed from: a */
                    public void onReturnDataInUI(Void r9) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, optLong, "", "", "", ""));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rL(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                final long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString("portrait");
                String optString3 = optJSONObject.optString("message");
                aVar.setStatus(2);
                aVar.setContent(optString3);
                aVar.setId(optLong);
                aVar.tV(1);
                aVar.setName(optString);
                aVar.setPortrait(optString2);
                z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.13
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.y
                    /* renamed from: aEe */
                    public Void doInBackground() {
                        b.aEj().g(aVar);
                        return null;
                    }
                }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.14
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.j
                    /* renamed from: a */
                    public void onReturnDataInUI(Void r9) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, optLong, "", "", "", ""));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
