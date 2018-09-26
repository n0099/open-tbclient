package com.baidu.tieba.addresslist.im.newFriend;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tbadk.newFriends.RequestPassFriendMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NewFriendDbManagerStatic {
    private static NewFriendDbManagerStatic buK = new NewFriendDbManagerStatic();

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001216) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.1
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
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001169) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.12
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
                    aVar.oy(0);
                    x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.12.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.w
                        /* renamed from: Tl */
                        public Void doInBackground() {
                            if (!b.Tp().aO(id)) {
                                b.Tp().g(aVar);
                                return null;
                            }
                            return null;
                        }
                    }, null);
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(304100) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15
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
                    aVar.oy(0);
                    aVar.setContent(requestAddFriendMessage.getMessage());
                    if (error == 0) {
                        aVar.setStatus(3);
                        x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.w
                            /* renamed from: Tl */
                            public Void doInBackground() {
                                com.baidu.tieba.im.data.a aP = b.Tp().aP(friendId);
                                if (aP != null) {
                                    aVar.setName(aP.getName());
                                    aVar.setPortrait(aP.getPortrait());
                                    b.Tp().g(aVar);
                                }
                                return null;
                            }
                        }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            /* renamed from: b */
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
                            x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.3
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.w
                                /* renamed from: Tl */
                                public Void doInBackground() {
                                    if (0 != friendId2 && b.Tp().aO(friendId2)) {
                                        com.baidu.tieba.im.data.a aVar2 = new com.baidu.tieba.im.data.a();
                                        aVar2.setId(friendId2);
                                        aVar2.setStatus(3);
                                        aVar2.oy(0);
                                        b.Tp().h(aVar2);
                                    }
                                    return null;
                                }
                            }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.15.4
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.h
                                /* renamed from: b */
                                public void onReturnDataInUI(Void r9) {
                                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, friendId2, "", "", "", ""));
                                }
                            });
                        }
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(304102) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
                    ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                    int error = responseDeleteFriendMessage.getError();
                    final long friendId = responseDeleteFriendMessage.getFriendId();
                    if (error == 0) {
                        x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.16.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.w
                            /* renamed from: Tl */
                            public Void doInBackground() {
                                if (0 != friendId) {
                                    b.Tp().aN(friendId);
                                    m.aMd().oK(String.valueOf(friendId));
                                }
                                return null;
                            }
                        }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.16.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            /* renamed from: b */
                            public void onReturnDataInUI(Void r9) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(1, friendId, "", "", "", ""));
                            }
                        });
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(304101) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17
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
                    aVar.oy(0);
                    if (error == 0) {
                        x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.w
                            /* renamed from: Tl */
                            public Void doInBackground() {
                                com.baidu.tieba.im.data.a aP;
                                if (0 != friendId && (aP = b.Tp().aP(friendId)) != null) {
                                    aVar.setContent(aP.getContent());
                                    aVar.setName(aP.getName());
                                    aVar.setPortrait(aP.getPortrait());
                                    b.Tp().g(aVar);
                                }
                                return null;
                            }
                        }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            /* renamed from: b */
                            public void onReturnDataInUI(Void r9) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, friendId, portrait, name, key, quanpin));
                            }
                        });
                    } else if (error == 3100098) {
                        Message<?> orginalMessage = responsePassFriendMessage.getOrginalMessage();
                        if (orginalMessage instanceof RequestPassFriendMessage) {
                            final long friendId2 = ((RequestPassFriendMessage) orginalMessage).getFriendId();
                            x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.3
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.w
                                /* renamed from: Tl */
                                public Void doInBackground() {
                                    if (0 != friendId2 && b.Tp().aO(friendId2)) {
                                        com.baidu.tieba.im.data.a aVar2 = new com.baidu.tieba.im.data.a();
                                        aVar2.setId(friendId2);
                                        aVar2.setStatus(2);
                                        aVar2.oy(0);
                                        b.Tp().h(aVar2);
                                    }
                                    return null;
                                }
                            }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.17.4
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tbadk.util.h
                                /* renamed from: b */
                                public void onReturnDataInUI(Void r9) {
                                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, friendId2, "", "", "", ""));
                                }
                            });
                        }
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new AnonymousClass18(2001175));
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001189) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().remove("get_addresslist_switch" + ((String) customResponsedMessage.getData()));
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
                                NewFriendDbManagerStatic.Tk().jp(content);
                            } else if (cmd.equals("passed_new_friend")) {
                                NewFriendDbManagerStatic.Tk().jq(content);
                            } else if (cmd.equals("delete_new_friend")) {
                                NewFriendDbManagerStatic.Tk().jr(content);
                            } else if (cmd.equals("apply_reply_message")) {
                                NewFriendDbManagerStatic.Tk().js(content);
                            } else if (cmd.equals("apply_add_friend")) {
                                NewFriendDbManagerStatic.Tk().jt(content);
                            } else if (cmd.equals("apply_pass_friend")) {
                                NewFriendDbManagerStatic.Tk().ju(content);
                            }
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(2001209, customMessageListener);
        MessageManager.getInstance().registerListener(2001172, customMessageListener);
        MessageManager.getInstance().registerListener(2001173, customMessageListener);
        MessageManager.getInstance().registerListener(2001219, customMessageListener);
        MessageManager.getInstance().registerListener(2001220, customMessageListener);
        MessageManager.getInstance().registerListener(2001221, customMessageListener);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001305, new CustomMessageTask.CustomRunnable<Long>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.21
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.im.data.a> run(CustomMessage<Long> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new ResponseNewFriendDataMessage(b.Tp().aP(customMessage.getData().longValue()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private NewFriendDbManagerStatic() {
    }

    public static NewFriendDbManagerStatic Tk() {
        return buK;
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
                x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.18.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.w
                    /* renamed from: Tl */
                    public Void doInBackground() {
                        AnonymousClass18.this.num = b.Tp().Tq();
                        return null;
                    }
                }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.18.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: b */
                    public void onReturnDataInUI(Void r4) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(AnonymousClass18.this.num, false));
                    }
                });
            }
        }
    }

    public void jp(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                aVar.setId(optJSONObject.optLong("user_id"));
                aVar.setName(optJSONObject.optString("user_name"));
                aVar.setPortrait(optJSONObject.optString(IntentConfig.PORTRAIT));
                aVar.setContent(optJSONObject.optString("message"));
                aVar.oy(0);
                aVar.setStatus(1);
                x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.w
                    /* renamed from: Tl */
                    public Void doInBackground() {
                        b.Tp().g(aVar);
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(b.Tp().Tq(), true));
                        return null;
                    }
                }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: b */
                    public void onReturnDataInUI(Void r9) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, 0L, "", "", "", ""));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jq(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                aVar.setId(optJSONObject.optLong("user_id"));
                aVar.setName(optJSONObject.optString("user_name"));
                aVar.setPortrait(optJSONObject.optString(IntentConfig.PORTRAIT));
                aVar.setContent(optJSONObject.optString("message"));
                final String optString = optJSONObject.optString(RimArmor.KEY);
                final String optString2 = optJSONObject.optString("pinyin");
                aVar.oy(0);
                aVar.setStatus(4);
                x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.w
                    /* renamed from: Tl */
                    public Void doInBackground() {
                        b.Tp().g(aVar);
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(b.Tp().Tq(), true));
                        return null;
                    }
                }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.5
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: b */
                    public void onReturnDataInUI(Void r9) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, aVar.getId(), aVar.getPortrait(), aVar.getName(), optString, optString2));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jr(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                final long optLong = optJSONObject.optLong("user_id");
                x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.w
                    /* renamed from: Tl */
                    public Void doInBackground() {
                        b.Tp().aN(optLong);
                        return null;
                    }
                }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.7
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: b */
                    public void onReturnDataInUI(Void r1) {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void js(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                final long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(IntentConfig.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                int optInt = optJSONObject.optInt("type");
                if (optInt == 1) {
                    aVar.setStatus(3);
                } else if (optInt == 2) {
                    aVar.setStatus(1);
                }
                aVar.setContent(optString3);
                aVar.setId(optLong);
                aVar.oy(1);
                aVar.setName(optString);
                aVar.setPortrait(optString2);
                x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.8
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.w
                    /* renamed from: Tl */
                    public Void doInBackground() {
                        b.Tp().g(aVar);
                        return null;
                    }
                }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.9
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: b */
                    public void onReturnDataInUI(Void r9) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, optLong, "", "", "", ""));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jt(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                final long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(IntentConfig.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                aVar.setStatus(3);
                aVar.setContent(optString3);
                aVar.setId(optLong);
                aVar.oy(1);
                aVar.setName(optString);
                aVar.setPortrait(optString2);
                x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.10
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.w
                    /* renamed from: Tl */
                    public Void doInBackground() {
                        b.Tp().g(aVar);
                        return null;
                    }
                }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: b */
                    public void onReturnDataInUI(Void r9) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, optLong, "", "", "", ""));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ju(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("eventParam");
            if (optJSONObject != null) {
                final com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                final long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString(IntentConfig.PORTRAIT);
                String optString3 = optJSONObject.optString("message");
                aVar.setStatus(2);
                aVar.setContent(optString3);
                aVar.setId(optLong);
                aVar.oy(1);
                aVar.setName(optString);
                aVar.setPortrait(optString2);
                x.b(new w<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.13
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.w
                    /* renamed from: Tl */
                    public Void doInBackground() {
                        b.Tp().g(aVar);
                        return null;
                    }
                }, new h<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic.14
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.h
                    /* renamed from: b */
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
