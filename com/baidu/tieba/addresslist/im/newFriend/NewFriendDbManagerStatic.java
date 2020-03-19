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
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tbadk.newFriends.RequestPassFriendMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class NewFriendDbManagerStatic {
    private static NewFriendDbManagerStatic ebB = new NewFriendDbManagerStatic();

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
                    aVar.wq(0);
                    ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.12.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.ab
                        /* renamed from: aYM */
                        public Void doInBackground() {
                            if (!b.aYS().cu(id)) {
                                b.aYS().g(aVar);
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
                    aVar.wq(0);
                    aVar.setContent(requestAddFriendMessage.getMessage());
                    if (error == 0) {
                        aVar.setStatus(3);
                        ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.ab
                            /* renamed from: aYM */
                            public Void doInBackground() {
                                com.baidu.tieba.im.data.a cv = b.aYS().cv(friendId);
                                if (cv != null) {
                                    aVar.setName(cv.getName());
                                    aVar.setPortrait(cv.getPortrait());
                                    b.aYS().g(aVar);
                                }
                                return null;
                            }
                        }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
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
                            ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.3
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.ab
                                /* renamed from: aYM */
                                public Void doInBackground() {
                                    if (0 != friendId2 && b.aYS().cu(friendId2)) {
                                        com.baidu.tieba.im.data.a aVar2 = new com.baidu.tieba.im.data.a();
                                        aVar2.setId(friendId2);
                                        aVar2.setStatus(3);
                                        aVar2.wq(0);
                                        b.aYS().h(aVar2);
                                    }
                                    return null;
                                }
                            }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.4
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.l
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
                        ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.16.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.ab
                            /* renamed from: aYM */
                            public Void doInBackground() {
                                if (0 != friendId) {
                                    b.aYS().ct(friendId);
                                    m.bUX().CO(String.valueOf(friendId));
                                }
                                return null;
                            }
                        }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.16.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
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
                    aVar.wq(0);
                    if (error == 0) {
                        ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.ab
                            /* renamed from: aYM */
                            public Void doInBackground() {
                                com.baidu.tieba.im.data.a cv;
                                if (0 != friendId && (cv = b.aYS().cv(friendId)) != null) {
                                    aVar.setContent(cv.getContent());
                                    aVar.setName(cv.getName());
                                    aVar.setPortrait(cv.getPortrait());
                                    b.aYS().g(aVar);
                                }
                                return null;
                            }
                        }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
                            /* renamed from: a */
                            public void onReturnDataInUI(Void r9) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, friendId, portrait, name, key, quanpin));
                            }
                        });
                    } else if (error == 3100098) {
                        Message<?> orginalMessage = responsePassFriendMessage.getOrginalMessage();
                        if (orginalMessage instanceof RequestPassFriendMessage) {
                            final long friendId2 = ((RequestPassFriendMessage) orginalMessage).getFriendId();
                            ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.3
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.ab
                                /* renamed from: aYM */
                                public Void doInBackground() {
                                    if (0 != friendId2 && b.aYS().cu(friendId2)) {
                                        com.baidu.tieba.im.data.a aVar2 = new com.baidu.tieba.im.data.a();
                                        aVar2.setId(friendId2);
                                        aVar2.setStatus(2);
                                        aVar2.wq(0);
                                        b.aYS().h(aVar2);
                                    }
                                    return null;
                                }
                            }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.4
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.l
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
                    com.baidu.tbadk.core.sharedPref.b.aFH().remove(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + ((String) customResponsedMessage.getData()));
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
                                NewFriendDbManagerStatic.aYL().xm(content);
                            } else if (cmd.equals("passed_new_friend")) {
                                NewFriendDbManagerStatic.aYL().xn(content);
                            } else if (cmd.equals("delete_new_friend")) {
                                NewFriendDbManagerStatic.aYL().xo(content);
                            } else if (cmd.equals("apply_reply_message")) {
                                NewFriendDbManagerStatic.aYL().xp(content);
                            } else if (cmd.equals("apply_add_friend")) {
                                NewFriendDbManagerStatic.aYL().xq(content);
                            } else if (cmd.equals("apply_pass_friend")) {
                                NewFriendDbManagerStatic.aYL().xr(content);
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
                return new ResponseNewFriendDataMessage(b.aYS().cv(customMessage.getData().longValue()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private NewFriendDbManagerStatic() {
    }

    public static NewFriendDbManagerStatic aYL() {
        return ebB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic$18  reason: invalid class name */
    /* loaded from: classes8.dex */
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
                ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.18.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ab
                    /* renamed from: aYM */
                    public Void doInBackground() {
                        AnonymousClass18.this.num = b.aYS().aYT();
                        return null;
                    }
                }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.18.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: a */
                    public void onReturnDataInUI(Void r4) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(AnonymousClass18.this.num, false));
                    }
                });
            }
        }
    }

    public void xm(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                aVar.setId(optJSONObject.optLong("user_id"));
                aVar.setName(optJSONObject.optString("user_name"));
                aVar.setPortrait(optJSONObject.optString("portrait"));
                aVar.setContent(optJSONObject.optString("message"));
                aVar.wq(0);
                aVar.setStatus(1);
                ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ab
                    /* renamed from: aYM */
                    public Void doInBackground() {
                        b.aYS().g(aVar);
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(b.aYS().aYT(), true));
                        return null;
                    }
                }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
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

    public void xn(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                aVar.setId(optJSONObject.optLong("user_id"));
                aVar.setName(optJSONObject.optString("user_name"));
                aVar.setPortrait(optJSONObject.optString("portrait"));
                aVar.setContent(optJSONObject.optString("message"));
                final String optString = optJSONObject.optString("key");
                final String optString2 = optJSONObject.optString("pinyin");
                aVar.wq(0);
                aVar.setStatus(4);
                ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ab
                    /* renamed from: aYM */
                    public Void doInBackground() {
                        b.aYS().g(aVar);
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(b.aYS().aYT(), true));
                        return null;
                    }
                }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.5
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
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

    public void xo(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject != null) {
                final long optLong = optJSONObject.optLong("user_id");
                ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ab
                    /* renamed from: aYM */
                    public Void doInBackground() {
                        b.aYS().ct(optLong);
                        return null;
                    }
                }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.7
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
                    /* renamed from: a */
                    public void onReturnDataInUI(Void r1) {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xp(String str) {
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
                aVar.wq(1);
                aVar.setName(optString);
                aVar.setPortrait(optString2);
                ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.8
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ab
                    /* renamed from: aYM */
                    public Void doInBackground() {
                        b.aYS().g(aVar);
                        return null;
                    }
                }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.9
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
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

    public void xq(String str) {
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
                aVar.wq(1);
                aVar.setName(optString);
                aVar.setPortrait(optString2);
                ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.10
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ab
                    /* renamed from: aYM */
                    public Void doInBackground() {
                        b.aYS().g(aVar);
                        return null;
                    }
                }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
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

    public void xr(String str) {
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
                aVar.wq(1);
                aVar.setName(optString);
                aVar.setPortrait(optString2);
                ac.b(new ab<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.13
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.ab
                    /* renamed from: aYM */
                    public Void doInBackground() {
                        b.aYS().g(aVar);
                        return null;
                    }
                }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.14
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.l
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
