package com.baidu.tieba.im;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialHistoryImageActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.im.c.a.i;
import com.baidu.tieba.im.c.a.j;
import com.baidu.tieba.im.c.a.m;
import com.baidu.tieba.im.c.a.n;
import com.baidu.tieba.im.c.a.o;
import com.baidu.tieba.im.c.a.p;
import com.baidu.tieba.im.c.a.q;
import com.baidu.tieba.im.c.a.r;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.MsgActivityViewItemAdapter;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.chat.OfficialMsgImageActivity;
import com.baidu.tieba.im.chat.officialBar.MsgMultiImageTextViewItemAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialHistoryImageActivity;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseOfficialBarInfoMessage;
import com.baidu.tieba.im.chat.photolive.MsgPhotoLiveItemAdapter;
import com.baidu.tieba.im.data.OfficialBarHistoryActivityConfig;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.forum.detail.ForumDetailActivity;
import com.baidu.tieba.im.forum.detail.ForumDetailHttpResponse;
import com.baidu.tieba.im.forum.detail.ForumDetailSocketResponse;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponsePushCountMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponseSendPVTJMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.IUpdatesModel;
import com.baidu.tieba.im.model.IValidateModel;
import com.baidu.tieba.im.model.UpdatesModel;
import com.baidu.tieba.im.model.ValidateModel;
import com.baidu.tieba.im.mygroup.PersonGroupActivity;
import com.baidu.tieba.im.recommend.detail.RecommendDetailActivity;
import com.baidu.tieba.im.recommend.detail.RecommendDetailHttpResponseMessage;
import com.baidu.tieba.im.recommend.detail.RecommendDetailSocketResponseMessage;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class TiebaIMActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(GroupChatActivityConfig.class, GroupChatActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialMsgImageActivityConfig.class, OfficialMsgImageActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialBarHistoryActivityConfig.class, OfficialBarHistoryActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialHistoryImageActivityConfig.class, OfficialHistoryImageActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonGroupActivityConfig.class, PersonGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(AddGroupActivityConfig.class, AddGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(ForumDetailActivityConfig.class, ForumDetailActivity.class);
        TbadkApplication.getInst().RegisterIntent(RecommendDetailActivityConfig.class, RecommendDetailActivity.class);
        bwW();
        bwX();
        bwY();
        bwZ();
        bxa();
        bxb();
        bxc();
        bxd();
        bxe();
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001275) { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.gsE != null && aVar.context != null) {
                        MsgMultiImageTextViewItemAdapter msgMultiImageTextViewItemAdapter = new MsgMultiImageTextViewItemAdapter(aVar.context, ChatMessage.TYPE_MSG_MULTI_PIC_TEXT);
                        msgMultiImageTextViewItemAdapter.lu(true);
                        aVar.gsE.add(msgMultiImageTextViewItemAdapter);
                    }
                }
            }
        });
        OfficalBarChatActivityConfig.IS_SUPPORT_OFFICIAL_CHAT = true;
        CustomMessageTask customMessageTask = new CustomMessageTask(2002006, new CustomMessageTask.CustomRunnable<OfficalBarChatActivityConfig>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<OfficalBarChatActivityConfig> run(final CustomMessage<OfficalBarChatActivityConfig> customMessage) {
                UserData userData;
                if (customMessage != null && customMessage.getData() != null && (userData = customMessage.getData().getUserData()) != null) {
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(String.valueOf(userData.getUserId()));
                    aa.b(new z<Void>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.8.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.z
                        /* renamed from: aBY */
                        public Void doInBackground() {
                            return l.bAg().p(linkedList);
                        }
                    }, new k<Void>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.8.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.k
                        /* renamed from: b */
                        public void onReturnDataInUI(Void r5) {
                            if (((OfficalBarChatActivityConfig) customMessage.getData()).getUserData().getUserIdLong() != 0) {
                                ((OfficalBarChatActivityConfig) customMessage.getData()).startActivity(OfficialBarChatActivity.class);
                            }
                        }
                    });
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        ba.aiz().a(new ba.a() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.9
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_official_chat=1")) {
                    String ce = ae.ce(str, "barid=");
                    String ce2 = ae.ce(str, "barname=");
                    String ce3 = ae.ce(str, "portrait=");
                    if (ce != null && ce.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(ce, 0L), ce2, ce3, 0)));
                    }
                    return 1;
                }
                return 3;
            }
        });
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001289, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.10
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001289, Integer.valueOf((int) R.drawable.icon_im_subscribe));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2001290, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.11
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001290, Integer.valueOf((int) R.drawable.icon_im_tie));
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2001286, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001286, Integer.valueOf((int) R.drawable.icon_new_trends));
            }
        });
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        CustomMessageTask customMessageTask5 = new CustomMessageTask(2001298, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001298, new a());
            }
        });
        customMessageTask5.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask5);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001275) { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.gsE != null && aVar.context != null) {
                        MsgPhotoLiveItemAdapter msgPhotoLiveItemAdapter = new MsgPhotoLiveItemAdapter(aVar.context, ChatMessage.TYPE_MSG_PHOTOLIVE);
                        msgPhotoLiveItemAdapter.lv(true);
                        aVar.gsE.add(msgPhotoLiveItemAdapter);
                        MsgActivityViewItemAdapter msgActivityViewItemAdapter = new MsgActivityViewItemAdapter(aVar.context, ChatMessage.TYPE_MSG_GROUP_ACTIVITY);
                        msgActivityViewItemAdapter.lv(true);
                        msgActivityViewItemAdapter.lu(true);
                        aVar.gsE.add(msgActivityViewItemAdapter);
                    }
                }
            }
        });
        CustomMessageTask customMessageTask6 = new CustomMessageTask(2012110, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_KD_MREAD, customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask6.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask6);
        CustomMessageTask customMessageTask7 = new CustomMessageTask(2003004, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage<String> customMessage) {
                if (customMessage != null) {
                    String data = customMessage.getData();
                    if (!TextUtils.isEmpty(data)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyVisibilityMessage(new MemoryModifyVisibilityMessage.a(data, 4, false)));
                    }
                }
                return null;
            }
        });
        customMessageTask7.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask7);
        CustomMessageTask customMessageTask8 = new CustomMessageTask(2001306, new com.baidu.tieba.im.recommend.detail.a());
        customMessageTask8.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask8);
        CustomMessageTask customMessageTask9 = new CustomMessageTask(2001299, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001299, new b());
            }
        });
        customMessageTask9.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask9);
    }

    private static void bwW() {
        ba.aiz().a(new ba.a() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.4
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                if (UtilHelper.parsePushMidPageUrl(lowerCase, sb, sb2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016486));
                    tbPageContext.sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(sb.toString(), sb2.toString(), Config.PUSH)));
                    return 0;
                }
                return 3;
            }
        });
    }

    private static void bwX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_FORUM_DETAIL_CMD, com.baidu.tieba.tbadkCore.a.a.bn(TbConfig.GET_FORUM_DETAIL, 303021));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ForumDetailHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(303021, ForumDetailSocketResponse.class, false);
    }

    public static boolean bwY() {
        b(103003, ResponseGroupsByUidMessage.class, false);
        b(202101, ResponsePushCountMessage.class, false);
        b(103101, ResponseAddGroupMessage.class, false);
        b(208001, ResponseOfficialBarInfoMessage.class, false);
        b(208002, ResponseHistoryMessage.class, false);
        b(104001, ResponseSendPVTJMessage.class, false);
        b(103007, ResponseSearchGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        b(303006, ResponseOfficialBarMenuMessage.class, false);
        b(208003, ResponseSendOfficialBarMenuMessage.class, false);
        return true;
    }

    private static com.baidu.tbadk.task.b b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        return c.b(i, cls, z);
    }

    private static boolean bwZ() {
        b(2001106, o.class);
        b(2001205, q.class);
        b(2001206, p.class);
        b(2001207, r.class);
        b(2001144, i.class);
        b(2001147, n.class);
        b(2001150, j.class);
        b(2001151, com.baidu.tieba.im.c.a.k.class);
        b(2001152, com.baidu.tieba.im.c.a.l.class);
        b(2001177, m.class);
        return true;
    }

    private static com.baidu.tbadk.task.a b(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        return c.b(i, cls);
    }

    private static boolean bxa() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.im.message.a());
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.im.message.b());
        return true;
    }

    private static void bxb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008022, new CustomMessageTask.CustomRunnable<OfficialBarTipActivityConfig>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<OfficialBarTipActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(OfficialBarTipActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bxc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008013, new CustomMessageTask.CustomRunnable<UpdatesActivityConfig>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<UpdatesActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().getIntent().setFlags(268435456);
                    customMessage.getData().startActivity(UpdatesActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bxd() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, com.baidu.tieba.tbadkCore.a.a.bn("c/u/user/bigvip", 303025));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(RecommendDetailHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(303025, RecommendDetailSocketResponseMessage.class, false);
    }

    private static void bxe() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008021, new CustomMessageTask.CustomRunnable<ValidateActivityConfig>() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ValidateActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(ValidateActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* loaded from: classes3.dex */
    static class a implements IUpdatesModel {
        a() {
        }

        @Override // com.baidu.tieba.im.model.IUpdatesModel
        public UpdatesItemData convertToUpdatesItem(GroupNewsPojo groupNewsPojo) {
            return UpdatesModel.convertToUpdatesItem(groupNewsPojo);
        }
    }

    /* loaded from: classes3.dex */
    static class b implements IValidateModel {
        b() {
        }

        @Override // com.baidu.tieba.im.model.IValidateModel
        public List<ValidateItemData> convertToValidateItemDataList(LinkedList<GroupNewsPojo> linkedList) {
            return ValidateModel.convertToValidateItemDataList(linkedList);
        }

        @Override // com.baidu.tieba.im.model.IValidateModel
        public ValidateItemData convertToValidateItemData(GroupNewsPojo groupNewsPojo) {
            return ValidateModel.convertToValidateItemData(groupNewsPojo);
        }
    }
}
