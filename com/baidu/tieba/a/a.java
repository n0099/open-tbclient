package com.baidu.tieba.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private String Xf;
    private HTypeListView bah;
    private c bai;
    private b baj;
    private String fid;
    private BdUniqueId mId;
    private List<f> mList;
    private TbPageContext mTbPageContext;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private CustomMessageListener bak = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_MY_STORY) { // from class: com.baidu.tieba.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.e eVar;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921055 && (customResponsedMessage.getData() instanceof Long)) {
                int size = a.this.mList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        if (a.this.mList.get(i) instanceof com.baidu.tbadk.data.e) {
                            eVar = (com.baidu.tbadk.data.e) a.this.mList.get(i);
                            if (eVar.user_id == ((Long) customResponsedMessage.getData()).longValue()) {
                                break;
                            }
                        }
                        i++;
                    } else {
                        eVar = null;
                        break;
                    }
                }
                if (eVar != null) {
                    a.this.mList.remove(eVar);
                    a.this.bah.setData(a.this.mList);
                    a.this.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bal = new CustomMessageListener(CmdConfigCustom.CMD_STORY_CLICK_MSG) { // from class: com.baidu.tieba.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921037 && (customResponsedMessage.getData() instanceof String)) {
                int size = a.this.mList.size();
                for (int i = 0; i < size; i++) {
                    if ((a.this.mList.get(i) instanceof com.baidu.tbadk.data.e) && customResponsedMessage.getData().equals(Long.valueOf(((com.baidu.tbadk.data.e) a.this.mList.get(i)).user_id))) {
                        ((com.baidu.tbadk.data.e) a.this.mList.get(i)).bu(true);
                        a.this.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener bam = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_MSG) { // from class: com.baidu.tieba.a.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921038 && (customResponsedMessage.getData() instanceof Long)) {
                int size = a.this.mList.size();
                for (int i = 0; i < size; i++) {
                    if ((a.this.mList.get(i) instanceof com.baidu.tbadk.data.e) && ((com.baidu.tbadk.data.e) a.this.mList.get(i)).user_id == ((Long) customResponsedMessage.getData()).longValue()) {
                        ((com.baidu.tbadk.data.e) a.this.mList.get(i)).has_read = 1;
                        a.this.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener ban = new CustomMessageListener(CmdConfigCustom.CMD_STORY_PUBLISH_MSG) { // from class: com.baidu.tieba.a.a.5
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
                        if (a.this.mList.get(i) instanceof com.baidu.tbadk.data.e) {
                            com.baidu.tbadk.data.e eVar = (com.baidu.tbadk.data.e) a.this.mList.get(i);
                            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(eVar.user_id))) {
                                if (eVar.mStatus != bVar.state) {
                                    eVar.mStatus = bVar.state;
                                    if (3 == eVar.mStatus) {
                                        eVar.azd = 3;
                                        eVar.aze = bVar;
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_INSERT_CACHE, bVar));
                                    } else if (2 == eVar.mStatus) {
                                        eVar.azd = 3;
                                        eVar.has_read = 0;
                                        eVar.aze = bVar;
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_INSERT_CACHE, bVar));
                                    } else if (1 == eVar.mStatus) {
                                        eVar.azc = i;
                                        eVar.azd = 1;
                                        eVar.has_read = 0;
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
                            com.baidu.tbadk.data.e eVar2 = new com.baidu.tbadk.data.e();
                            eVar2.user_id = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                            eVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                            eVar2.portrait = TbadkCoreApplication.getCurrentPortrait();
                            eVar2.azf = a.this.fid;
                            eVar2.azc = 1;
                            eVar2.aze = bVar;
                            eVar2.mStatus = bVar.state;
                            eVar2.azd = 1;
                            a.this.mList.add(1, eVar2);
                            a.this.bah.setData(a.this.mList);
                            a.this.notifyDataSetChanged();
                        } else if (bVar.state == 2) {
                            if (a.this.mList.get(1) instanceof com.baidu.tbadk.data.e) {
                                ((com.baidu.tbadk.data.e) a.this.mList.get(1)).azd = 3;
                                a.this.notifyDataSetChanged();
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_STORY_INSERT_CACHE, bVar));
                        } else if (bVar.state == 3 && (a.this.mList.get(1) instanceof com.baidu.tbadk.data.e)) {
                            ((com.baidu.tbadk.data.e) a.this.mList.get(1)).azd = 3;
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
        this.bah = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        initAdapters();
        initListener();
    }

    public void initListener() {
        this.bal.setTag(this.mId);
        this.bam.setTag(this.mId);
        this.ban.setTag(this.mId);
        this.bak.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.bal);
        MessageManager.getInstance().registerListener(this.bam);
        MessageManager.getInstance().registerListener(this.ban);
        MessageManager.getInstance().registerListener(this.bak);
    }

    public void i(BdUniqueId bdUniqueId) {
        this.bal.setTag(bdUniqueId);
        this.bam.setTag(bdUniqueId);
        this.ban.setTag(bdUniqueId);
        this.bak.setTag(bdUniqueId);
        this.bai.setPageId(bdUniqueId);
        this.baj.setPageId(bdUniqueId);
    }

    private void initAdapters() {
        this.baj = new b(this.mTbPageContext, this.mId);
        this.bai = new c(this.mTbPageContext, this.mId);
        this.mAdapters.add(this.bai);
        this.mAdapters.add(this.baj);
        this.bah.addAdapters(this.mAdapters);
    }

    public void a(List<f> list, String str, String str2) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tbadk.data.e) {
                    ((com.baidu.tbadk.data.e) list.get(i)).azf = str;
                }
            }
            if (this.bah != null) {
                this.mList = list;
                this.bah.setData(list);
            }
            this.fid = str;
            this.Xf = str2;
        }
    }

    public void notifyDataSetChanged() {
        if (this.bah != null && (this.bah.getAdapter() instanceof j)) {
            ((j) this.bah.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.bai.setOnClick(onClickListener);
        this.baj.a(new com.baidu.tieba.story.c() { // from class: com.baidu.tieba.a.a.1
            @Override // com.baidu.tieba.story.c
            public void a(f fVar, int i) {
                if (fVar instanceof com.baidu.tbadk.data.e) {
                    com.baidu.tbadk.data.e eVar = (com.baidu.tbadk.data.e) fVar;
                    if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(eVar.user_id))) {
                        TiebaStatic.log(new ak("c12358").ad("fid", a.this.fid).r("obj_locate", "0".equals(a.this.fid) ? 1 : 2).r("obj_type", 2).f("obj_id", eVar.user_id));
                    } else {
                        TiebaStatic.log(new ak("c12358").ad("fid", a.this.fid).r("obj_locate", "0".equals(a.this.fid) ? 1 : 2).r("obj_type", 3).f("obj_id", eVar.user_id));
                    }
                    if (eVar != null && 3 == eVar.mStatus && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(eVar.user_id))) {
                        if (!com.baidu.adp.lib.util.j.hh()) {
                            eVar.azc = i;
                            eVar.azd = 3;
                            a.this.notifyDataSetChanged();
                        } else if (eVar.aze != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StoryCompositeServiceConfig(TbadkCoreApplication.getInst(), eVar.aze)));
                        }
                    } else if (eVar == null || 1 != eVar.mStatus || TbadkCoreApplication.getCurrentAccount() == null || !TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(eVar.user_id))) {
                        StoryPageActivityConfig storyPageActivityConfig = new StoryPageActivityConfig(a.this.mTbPageContext.getContext());
                        ArrayList arrayList = new ArrayList();
                        ArrayList<MetaData> arrayList2 = new ArrayList<>();
                        int size = a.this.mList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if ((a.this.mList.get(i2) instanceof com.baidu.tbadk.data.e) && 3 != ((com.baidu.tbadk.data.e) a.this.mList.get(i2)).mStatus) {
                                com.baidu.tbadk.data.e eVar2 = (com.baidu.tbadk.data.e) a.this.mList.get(i2);
                                MetaData metaData = new MetaData();
                                metaData.setPortrait(eVar2.portrait);
                                metaData.setUserName(eVar2.user_name);
                                metaData.setUserId(String.valueOf(eVar2.user_id));
                                arrayList2.add(metaData);
                                arrayList.add(eVar2);
                            }
                        }
                        storyPageActivityConfig.createNormalConfig(arrayList2, arrayList.indexOf(fVar), com.baidu.adp.lib.g.b.c(a.this.fid, 0L), com.baidu.adp.lib.g.b.c(a.this.Xf, 0L)).setDoneCallback(new com.baidu.tieba.story.a() { // from class: com.baidu.tieba.a.a.1.1
                            @Override // com.baidu.tieba.story.a
                            public void a(MetaData metaData2, boolean z, String str) {
                                if (metaData2 != null) {
                                    int size2 = a.this.mList.size();
                                    for (int i3 = 0; i3 < size2; i3++) {
                                        if ((a.this.mList.get(i3) instanceof com.baidu.tbadk.data.e) && metaData2.getUserId().equals(String.valueOf(((com.baidu.tbadk.data.e) a.this.mList.get(i3)).user_id))) {
                                            ((com.baidu.tbadk.data.e) a.this.mList.get(i3)).azd = 3;
                                            a.this.notifyDataSetChanged();
                                            return;
                                        }
                                    }
                                }
                            }
                        });
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, storyPageActivityConfig));
                        eVar.azc = i;
                        eVar.azd = 1;
                        a.this.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
