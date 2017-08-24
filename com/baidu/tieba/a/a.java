package com.baidu.tieba.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.StoryCompositeServiceConfig;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String XV;
    private HTypeListView aYL;
    private c aYM;
    private b aYN;
    private String fid;
    private BdUniqueId mId;
    private List<f> mList;
    private TbPageContext mTbPageContext;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private CustomMessageListener aYO = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_MY_STORY) { // from class: com.baidu.tieba.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.f fVar;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921055 && (customResponsedMessage.getData() instanceof Long)) {
                int size = a.this.mList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        if (a.this.mList.get(i) instanceof com.baidu.tbadk.data.f) {
                            fVar = (com.baidu.tbadk.data.f) a.this.mList.get(i);
                            if (fVar.user_id == ((Long) customResponsedMessage.getData()).longValue()) {
                                break;
                            }
                        }
                        i++;
                    } else {
                        fVar = null;
                        break;
                    }
                }
                if (fVar != null) {
                    a.this.mList.remove(fVar);
                    a.this.aYL.setData(a.this.mList);
                    a.this.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener aYP = new CustomMessageListener(CmdConfigCustom.CMD_STORY_CLICK_MSG) { // from class: com.baidu.tieba.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921037 && (customResponsedMessage.getData() instanceof String)) {
                int size = a.this.mList.size();
                for (int i = 0; i < size; i++) {
                    if ((a.this.mList.get(i) instanceof com.baidu.tbadk.data.f) && customResponsedMessage.getData().equals(Long.valueOf(((com.baidu.tbadk.data.f) a.this.mList.get(i)).user_id))) {
                        ((com.baidu.tbadk.data.f) a.this.mList.get(i)).bw(true);
                        a.this.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener aYQ = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_MSG) { // from class: com.baidu.tieba.a.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921038 && (customResponsedMessage.getData() instanceof Long)) {
                int size = a.this.mList.size();
                for (int i = 0; i < size; i++) {
                    if ((a.this.mList.get(i) instanceof com.baidu.tbadk.data.f) && ((com.baidu.tbadk.data.f) a.this.mList.get(i)).user_id == ((Long) customResponsedMessage.getData()).longValue()) {
                        ((com.baidu.tbadk.data.f) a.this.mList.get(i)).has_read = 1;
                        a.this.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener aYR = new CustomMessageListener(CmdConfigCustom.CMD_STORY_PUBLISH_MSG) { // from class: com.baidu.tieba.a.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921042 && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (String.valueOf(bVar.forumId).equals(a.this.fid)) {
                    int size = a.this.mList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            break;
                        }
                        if (a.this.mList.get(i) instanceof com.baidu.tbadk.data.f) {
                            com.baidu.tbadk.data.f fVar = (com.baidu.tbadk.data.f) a.this.mList.get(i);
                            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(fVar.user_id))) {
                                if (fVar.mStatus != bVar.state) {
                                    fVar.mStatus = bVar.state;
                                    if (3 == fVar.mStatus) {
                                        fVar.aAB = 3;
                                        fVar.aAC = bVar;
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_INSERT_CACHE, bVar));
                                    } else if (2 == fVar.mStatus) {
                                        fVar.aAB = 3;
                                        fVar.has_read = 0;
                                        fVar.aAC = bVar;
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_INSERT_CACHE, bVar));
                                    } else if (1 == fVar.mStatus) {
                                        fVar.aAA = i;
                                        fVar.aAB = 1;
                                        fVar.has_read = 0;
                                    }
                                    a.this.notifyDataSetChanged();
                                    z = true;
                                } else {
                                    z = true;
                                }
                            }
                        }
                        i++;
                    }
                    if (!z) {
                        if (bVar.state == 1) {
                            com.baidu.tbadk.data.f fVar2 = new com.baidu.tbadk.data.f();
                            fVar2.user_id = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                            fVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                            fVar2.portrait = TbadkCoreApplication.getCurrentPortrait();
                            fVar2.aAD = a.this.fid;
                            fVar2.aAA = 1;
                            fVar2.aAC = bVar;
                            fVar2.mStatus = bVar.state;
                            fVar2.aAB = 1;
                            a.this.mList.add(1, fVar2);
                            a.this.aYL.setData(a.this.mList);
                            a.this.notifyDataSetChanged();
                        } else if (bVar.state == 2) {
                            if (a.this.mList.get(1) instanceof com.baidu.tbadk.data.f) {
                                ((com.baidu.tbadk.data.f) a.this.mList.get(1)).aAB = 3;
                                a.this.notifyDataSetChanged();
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_INSERT_CACHE, bVar));
                        } else if (bVar.state == 3 && (a.this.mList.get(1) instanceof com.baidu.tbadk.data.f)) {
                            ((com.baidu.tbadk.data.f) a.this.mList.get(1)).aAB = 3;
                            a.this.notifyDataSetChanged();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_INSERT_CACHE, bVar));
                        }
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.aYL = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
        initListener();
    }

    public void initListener() {
        this.aYP.setTag(this.mId);
        this.aYQ.setTag(this.mId);
        this.aYR.setTag(this.mId);
        this.aYO.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.aYP);
        MessageManager.getInstance().registerListener(this.aYQ);
        MessageManager.getInstance().registerListener(this.aYR);
        MessageManager.getInstance().registerListener(this.aYO);
    }

    private void initAdapters() {
        this.aYN = new b(this.mTbPageContext, this.mId);
        this.aYM = new c(this.mTbPageContext, this.mId);
        this.mAdapters.add(this.aYM);
        this.mAdapters.add(this.aYN);
        this.aYL.addAdapters(this.mAdapters);
    }

    public void a(List<f> list, String str, String str2) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tbadk.data.f) {
                    ((com.baidu.tbadk.data.f) list.get(i)).aAD = str;
                }
            }
            if (this.aYL != null) {
                this.mList = list;
                this.aYL.setData(list);
            }
            this.fid = str;
            this.XV = str2;
        }
    }

    public void notifyDataSetChanged() {
        if (this.aYL != null && (this.aYL.getAdapter() instanceof j)) {
            ((j) this.aYL.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.aYM.setOnClick(onClickListener);
        this.aYN.a(new com.baidu.tieba.story.c() { // from class: com.baidu.tieba.a.a.1
            @Override // com.baidu.tieba.story.c
            public void a(f fVar, int i) {
                if (fVar instanceof com.baidu.tbadk.data.f) {
                    com.baidu.tbadk.data.f fVar2 = (com.baidu.tbadk.data.f) fVar;
                    if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(fVar2.user_id))) {
                        TiebaStatic.log(new aj("c12358").aa("fid", a.this.fid).r("obj_locate", "0".equals(a.this.fid) ? 1 : 2).r("obj_type", 2).g("obj_id", fVar2.user_id));
                    } else {
                        TiebaStatic.log(new aj("c12358").aa("fid", a.this.fid).r("obj_locate", "0".equals(a.this.fid) ? 1 : 2).r("obj_type", 3).g("obj_id", fVar2.user_id));
                    }
                    if (fVar2 != null && 3 == fVar2.mStatus && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(fVar2.user_id))) {
                        if (!i.hr()) {
                            fVar2.aAA = i;
                            fVar2.aAB = 3;
                            a.this.notifyDataSetChanged();
                        } else if (fVar2.aAC != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StoryCompositeServiceConfig(TbadkCoreApplication.getInst(), fVar2.aAC)));
                        }
                    } else if (fVar2 == null || 1 != fVar2.mStatus || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(fVar2.user_id))) {
                        StoryPageActivityConfig storyPageActivityConfig = new StoryPageActivityConfig(a.this.mTbPageContext.getContext());
                        ArrayList arrayList = new ArrayList();
                        ArrayList<MetaData> arrayList2 = new ArrayList<>();
                        int size = a.this.mList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if ((a.this.mList.get(i2) instanceof com.baidu.tbadk.data.f) && 3 != ((com.baidu.tbadk.data.f) a.this.mList.get(i2)).mStatus) {
                                com.baidu.tbadk.data.f fVar3 = (com.baidu.tbadk.data.f) a.this.mList.get(i2);
                                MetaData metaData = new MetaData();
                                metaData.setPortrait(fVar3.portrait);
                                metaData.setUserName(fVar3.user_name);
                                metaData.setUserId(String.valueOf(fVar3.user_id));
                                arrayList2.add(metaData);
                                arrayList.add(fVar3);
                            }
                        }
                        storyPageActivityConfig.createNormalConfig(arrayList2, arrayList.indexOf(fVar), com.baidu.adp.lib.g.b.d(a.this.fid, 0L), com.baidu.adp.lib.g.b.d(a.this.XV, 0L)).setDoneCallback(new com.baidu.tieba.story.a() { // from class: com.baidu.tieba.a.a.1.1
                            @Override // com.baidu.tieba.story.a
                            public void a(MetaData metaData2, boolean z, String str) {
                                if (metaData2 != null) {
                                    int size2 = a.this.mList.size();
                                    for (int i3 = 0; i3 < size2; i3++) {
                                        if ((a.this.mList.get(i3) instanceof com.baidu.tbadk.data.f) && metaData2.getUserId().equals(String.valueOf(((com.baidu.tbadk.data.f) a.this.mList.get(i3)).user_id))) {
                                            ((com.baidu.tbadk.data.f) a.this.mList.get(i3)).aAB = 3;
                                            a.this.notifyDataSetChanged();
                                            return;
                                        }
                                    }
                                }
                            }
                        });
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, storyPageActivityConfig));
                        fVar2.aAA = i;
                        fVar2.aAB = 1;
                        a.this.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
