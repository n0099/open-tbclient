package com.baidu.tieba.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.StoryCompositeServiceConfig;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private HTypeListView bdD;
    private e bdE;
    private d bdF;
    private b bdG;
    private c bdH;
    private String fid;
    private BdUniqueId mId;
    private List<com.baidu.adp.widget.ListView.f> mList;
    private TbPageContext mTbPageContext;
    private String tid;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private CustomMessageListener bdI = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_MY_STORY) { // from class: com.baidu.tieba.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.g gVar;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921055 && (customResponsedMessage.getData() instanceof Long)) {
                int size = a.this.mList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        if (a.this.mList.get(i) instanceof com.baidu.tbadk.data.g) {
                            gVar = (com.baidu.tbadk.data.g) a.this.mList.get(i);
                            if (gVar.user_id == ((Long) customResponsedMessage.getData()).longValue()) {
                                break;
                            }
                        }
                        i++;
                    } else {
                        gVar = null;
                        break;
                    }
                }
                if (gVar != null) {
                    a.this.mList.remove(gVar);
                    a.this.bdD.setData(a.this.mList);
                    a.this.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bdJ = new CustomMessageListener(CmdConfigCustom.CMD_STORY_CLICK_MSG) { // from class: com.baidu.tieba.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921037 && (customResponsedMessage.getData() instanceof String)) {
                int size = a.this.mList.size();
                for (int i = 0; i < size; i++) {
                    if ((a.this.mList.get(i) instanceof com.baidu.tbadk.data.g) && customResponsedMessage.getData().equals(Long.valueOf(((com.baidu.tbadk.data.g) a.this.mList.get(i)).user_id))) {
                        ((com.baidu.tbadk.data.g) a.this.mList.get(i)).bp(true);
                        a.this.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener bdK = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_MSG) { // from class: com.baidu.tieba.a.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921038 && (customResponsedMessage.getData() instanceof Long)) {
                int size = a.this.mList.size();
                for (int i = 0; i < size; i++) {
                    if ((a.this.mList.get(i) instanceof com.baidu.tbadk.data.g) && ((com.baidu.tbadk.data.g) a.this.mList.get(i)).user_id == ((Long) customResponsedMessage.getData()).longValue()) {
                        ((com.baidu.tbadk.data.g) a.this.mList.get(i)).has_read = 1;
                        a.this.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener bdL = new CustomMessageListener(CmdConfigCustom.CMD_STORY_PUBLISH_MSG) { // from class: com.baidu.tieba.a.a.5
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
                        if (a.this.mList.get(i) instanceof com.baidu.tbadk.data.g) {
                            com.baidu.tbadk.data.g gVar = (com.baidu.tbadk.data.g) a.this.mList.get(i);
                            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(gVar.user_id))) {
                                if (gVar.mStatus != bVar.state) {
                                    gVar.mStatus = bVar.state;
                                    if (3 == gVar.mStatus) {
                                        gVar.aAl = 3;
                                        gVar.aAm = bVar;
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_INSERT_CACHE, bVar));
                                    } else if (2 == gVar.mStatus) {
                                        gVar.aAl = 3;
                                        gVar.has_read = 0;
                                        gVar.aAm = bVar;
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_INSERT_CACHE, bVar));
                                    } else if (1 == gVar.mStatus) {
                                        gVar.aAk = i;
                                        gVar.aAl = 1;
                                        gVar.has_read = 0;
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
                            com.baidu.tbadk.data.g gVar2 = new com.baidu.tbadk.data.g();
                            gVar2.user_id = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                            gVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                            gVar2.portrait = TbadkCoreApplication.getCurrentPortrait();
                            gVar2.aAn = a.this.fid;
                            gVar2.aAk = 1;
                            gVar2.aAm = bVar;
                            gVar2.mStatus = bVar.state;
                            gVar2.aAl = 1;
                            a.this.mList.add(1, gVar2);
                            a.this.bdD.setData(a.this.mList);
                            a.this.notifyDataSetChanged();
                        } else if (bVar.state == 2) {
                            if (a.this.mList.get(1) instanceof com.baidu.tbadk.data.g) {
                                ((com.baidu.tbadk.data.g) a.this.mList.get(1)).aAl = 3;
                                a.this.notifyDataSetChanged();
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_INSERT_CACHE, bVar));
                        } else if (bVar.state == 3 && (a.this.mList.get(1) instanceof com.baidu.tbadk.data.g)) {
                            ((com.baidu.tbadk.data.g) a.this.mList.get(1)).aAl = 3;
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
        this.bdD = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
        initListener();
    }

    public void initListener() {
        this.bdJ.setTag(this.mId);
        this.bdK.setTag(this.mId);
        this.bdL.setTag(this.mId);
        this.bdI.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.bdJ);
        MessageManager.getInstance().registerListener(this.bdK);
        MessageManager.getInstance().registerListener(this.bdL);
        MessageManager.getInstance().registerListener(this.bdI);
    }

    public void i(BdUniqueId bdUniqueId) {
        this.bdJ.setTag(bdUniqueId);
        this.bdK.setTag(bdUniqueId);
        this.bdL.setTag(bdUniqueId);
        this.bdI.setTag(bdUniqueId);
        this.bdE.setPageId(bdUniqueId);
        this.bdF.setPageId(bdUniqueId);
        this.bdG.setPageId(bdUniqueId);
        this.bdH.setPageId(bdUniqueId);
    }

    private void initAdapters() {
        this.bdF = new d(this.mTbPageContext, this.mId);
        this.bdE = new e(this.mTbPageContext, this.mId);
        this.bdG = new b(this.mTbPageContext, this.mId);
        this.bdH = new c(this.mTbPageContext, this.mId);
        this.mAdapters.add(this.bdE);
        this.mAdapters.add(this.bdF);
        this.mAdapters.add(this.bdG);
        this.mAdapters.add(this.bdH);
        this.bdD.addAdapters(this.mAdapters);
    }

    public void a(List<com.baidu.adp.widget.ListView.f> list, String str, String str2) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tbadk.data.g) {
                    ((com.baidu.tbadk.data.g) list.get(i)).aAn = str;
                }
            }
            if (this.bdD != null) {
                this.mList = list;
                this.bdD.setData(list);
                this.bdG.setData(list);
            }
            this.fid = str;
            this.tid = str2;
        }
    }

    public void notifyDataSetChanged() {
        if (this.bdD != null && (this.bdD.getAdapter() instanceof j)) {
            ((j) this.bdD.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.bdE.setOnClick(onClickListener);
        this.bdF.a(new com.baidu.tieba.story.c() { // from class: com.baidu.tieba.a.a.1
            @Override // com.baidu.tieba.story.c
            public void a(com.baidu.adp.widget.ListView.f fVar, int i) {
                if (fVar instanceof com.baidu.tbadk.data.g) {
                    com.baidu.tbadk.data.g gVar = (com.baidu.tbadk.data.g) fVar;
                    if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(gVar.user_id))) {
                        TiebaStatic.log(new ak("c12358").ac(ImageViewerConfig.FORUM_ID, a.this.fid).r("obj_locate", "0".equals(a.this.fid) ? 1 : 2).r("obj_type", 2).f("obj_id", gVar.user_id));
                    } else {
                        TiebaStatic.log(new ak("c12358").ac(ImageViewerConfig.FORUM_ID, a.this.fid).r("obj_locate", "0".equals(a.this.fid) ? 1 : 2).r("obj_type", 3).f("obj_id", gVar.user_id));
                    }
                    if (gVar != null && 3 == gVar.mStatus && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(gVar.user_id))) {
                        if (!com.baidu.adp.lib.util.j.hh()) {
                            gVar.aAk = i;
                            gVar.aAl = 3;
                            a.this.notifyDataSetChanged();
                        } else if (gVar.aAm != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StoryCompositeServiceConfig(TbadkCoreApplication.getInst(), gVar.aAm)));
                        }
                    } else if (gVar == null || 1 != gVar.mStatus || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(gVar.user_id))) {
                        StoryPageActivityConfig storyPageActivityConfig = new StoryPageActivityConfig(a.this.mTbPageContext.getContext());
                        ArrayList arrayList = new ArrayList();
                        ArrayList<MetaData> arrayList2 = new ArrayList<>();
                        int size = a.this.mList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if ((a.this.mList.get(i2) instanceof com.baidu.tbadk.data.g) && 3 != ((com.baidu.tbadk.data.g) a.this.mList.get(i2)).mStatus) {
                                com.baidu.tbadk.data.g gVar2 = (com.baidu.tbadk.data.g) a.this.mList.get(i2);
                                MetaData metaData = new MetaData();
                                metaData.setPortrait(gVar2.portrait);
                                metaData.setUserName(gVar2.user_name);
                                metaData.setUserId(String.valueOf(gVar2.user_id));
                                arrayList2.add(metaData);
                                arrayList.add(gVar2);
                            }
                        }
                        storyPageActivityConfig.createNormalConfig(arrayList2, arrayList.indexOf(fVar), com.baidu.adp.lib.g.b.c(a.this.fid, 0L), com.baidu.adp.lib.g.b.c(a.this.tid, 0L)).setDoneCallback(new com.baidu.tieba.story.a() { // from class: com.baidu.tieba.a.a.1.1
                            @Override // com.baidu.tieba.story.a
                            public void a(MetaData metaData2, boolean z, String str) {
                                if (metaData2 != null) {
                                    int size2 = a.this.mList.size();
                                    for (int i3 = 0; i3 < size2; i3++) {
                                        if ((a.this.mList.get(i3) instanceof com.baidu.tbadk.data.g) && metaData2.getUserId().equals(String.valueOf(((com.baidu.tbadk.data.g) a.this.mList.get(i3)).user_id))) {
                                            ((com.baidu.tbadk.data.g) a.this.mList.get(i3)).aAl = 3;
                                            a.this.notifyDataSetChanged();
                                            return;
                                        }
                                    }
                                }
                            }
                        });
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, storyPageActivityConfig));
                        gVar.aAk = i;
                        gVar.aAl = 1;
                        a.this.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
