package com.baidu.tieba.enterForum.tabfeed.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.enterForum.tabfeed.b;
import com.baidu.tieba.enterForum.tabfeed.b.d;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean etP;
    private int gHl;
    private int gHm;
    private b gHn;
    private int gHo;
    private HashMap<String, Integer> gHp;
    private com.baidu.tieba.enterForum.tabfeed.b.b gHq;
    private a gHr;
    private CustomMessageListener gHs;
    private CustomMessageListener gHt;
    private boolean isLoading;
    private String tabCode;
    private String tabName;

    static /* synthetic */ int g(EnterForumTabFeedNetModel enterForumTabFeedNetModel) {
        int i = enterForumTabFeedNetModel.gHl;
        enterForumTabFeedNetModel.gHl = i + 1;
        return i;
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.gHl = 1;
        this.etP = true;
        this.gHr = new a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.gHq != null && EnterForumTabFeedNetModel.this.gHq.gHg != null) {
                    com.baidu.tieba.enterForum.tabfeed.b.a aVar = null;
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else if (responsedMessage instanceof TabFeedListSocketResponsedMessage) {
                        aVar = ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData;
                    }
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.gHn.a(errorData);
                        return;
                    }
                    ArrayList<m> bJw = aVar.bJw();
                    EnterForumTabFeedNetModel.this.gHq.etP = EnterForumTabFeedNetModel.this.etP;
                    if (EnterForumTabFeedNetModel.this.etP) {
                        EnterForumTabFeedNetModel.this.gHq.refreshCount = v.getCount(bJw);
                        EnterForumTabFeedNetModel.this.e(bJw, aVar.bJx());
                    } else {
                        EnterForumTabFeedNetModel.g(EnterForumTabFeedNetModel.this);
                    }
                    if (EnterForumTabFeedNetModel.this.gHo + v.getCount(bJw) > EnterForumTabFeedNetModel.this.gHm) {
                        EnterForumTabFeedNetModel.this.gHq.gHh = EnterForumTabFeedNetModel.this.bJC();
                    }
                    ArrayList ag = EnterForumTabFeedNetModel.this.ag(EnterForumTabFeedNetModel.this.switchThreadDataToThreadCardInfo(bJw));
                    if (EnterForumTabFeedNetModel.this.etP) {
                        EnterForumTabFeedNetModel.this.gHq.gHg.addAll(0, ag);
                        EnterForumTabFeedNetModel.this.gHq.gHh = 0;
                    } else {
                        EnterForumTabFeedNetModel.this.gHq.gHg.addAll(ag);
                        EnterForumTabFeedNetModel.this.gHq.hasMore = v.isEmpty(bJw) ? false : true;
                    }
                    EnterForumTabFeedNetModel.this.gHq.agw = aVar.bJA();
                    EnterForumTabFeedNetModel.this.gHq.gHi = aVar.bJz();
                    EnterForumTabFeedNetModel.this.gHq.gHf = aVar.bJy();
                    if (EnterForumTabFeedNetModel.this.gHn != null) {
                        EnterForumTabFeedNetModel.this.gHn.a(EnterForumTabFeedNetModel.this.gHq);
                    }
                }
            }
        };
        this.gHs = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.gHt = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        setUniqueId(bdUniqueId);
        this.gHr.getHttpMessageListener().setSelfListener(true);
        this.gHr.getSocketMessageListener().setSelfListener(true);
        registerListener(this.gHr);
        this.gHp = new HashMap<>();
        this.gHq = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.gHn = bVar;
        this.gHm = com.baidu.tbadk.core.sharedPref.b.aNT().getInt("home_page_max_thread_count", 300);
        registerListener(this.gHs);
        registerListener(this.gHt);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.gHr);
    }

    public void dw(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<m> ag(ArrayList<m> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = true;
            Iterator<m> it = arrayList.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = !(it.next() instanceof d) ? false : z;
            }
            if (z) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ArrayList<m> arrayList, ArrayList<d> arrayList2) {
        bJB();
        if (!v.isEmpty(arrayList) && !v.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<d>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(d dVar, d dVar2) {
                    if (dVar.gHk == dVar2.gHk) {
                        return 0;
                    }
                    return dVar.gHk > dVar2.gHk ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<d> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    d next = it.next();
                    int i3 = next.gHk + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.gHk != 0 && i3 <= arrayList.size()) {
                        arrayList.add(i3, next);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bJB() {
        if (!v.isEmpty(this.gHq.gHg)) {
            int i = 0;
            Iterator<m> it = this.gHq.gHg.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    if (it.next() instanceof d) {
                        it.remove();
                    }
                    i = i2 + 1;
                    if (i > 93) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJC() {
        int i;
        if (this.gHq == null || this.gHq.gHg == null) {
            return 0;
        }
        if (!this.etP) {
            i = 30;
        } else {
            i = this.gHo - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.gHo || i2 < 0 || i2 > this.gHo || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.gHq.gHg.size()) {
                i3 = -1;
                break;
            }
            m mVar = this.gHq.gHg.get(i3);
            if (mVar instanceof bi) {
                if (i4 == -1 && ((bi) mVar).position > i) {
                    i4 = i3;
                } else if (((bi) mVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bi) mVar).dqE != null) {
                    this.gHp.remove(((bi) mVar).dqE.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.gHq.gHg.subList(0, i4));
        arrayList.addAll(this.gHq.gHg.subList(i3, this.gHq.gHg.size()));
        this.gHq.gHg = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gHo > 0 && this.gHq != null && !v.isEmpty(this.gHq.gHg)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.gHp.containsKey(optString)) {
                Iterator<m> it = this.gHq.gHg.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    m next = it.next();
                    if ((next instanceof bi) && ((bi) next).dqE != null) {
                        if (i7 >= 0) {
                            if (((bi) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (aq.equals(optString, ((bi) next).dqE.getTid())) {
                            int i8 = ((bi) next).position;
                            it.remove();
                            i = i5;
                            i3 = i8;
                            i2 = i4;
                        }
                        i4++;
                        i7 = i3;
                        i6 = i2;
                        i5 = i;
                    }
                    i = i5;
                    i2 = i6;
                    i3 = i7;
                    i4++;
                    i7 = i3;
                    i6 = i2;
                    i5 = i;
                }
                if (i6 < i5) {
                    this.gHn.bI(i6, i5);
                }
            }
        }
    }

    public void bkZ() {
        if (!this.isLoading) {
            this.etP = false;
            sv(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.etP = true;
            sv(1);
        }
    }

    private void sv(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.gHl + 1;
        } else if (i == 1) {
            tabFeedListRequestMessage.pn = 1;
        } else {
            return;
        }
        this.isLoading = true;
        sendMessage(tabFeedListRequestMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.isLoading = false;
    }

    public boolean hasData() {
        return (this.gHq == null || v.isEmpty(this.gHq.gHg)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<m> switchThreadDataToThreadCardInfo(ArrayList<m> arrayList) {
        int i = this.gHo;
        ArrayList<m> arrayList2 = new ArrayList<>();
        Iterator<m> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof d) {
                arrayList2.add(next);
            } else if (next instanceof bj) {
                bj bjVar = (bj) next;
                if (!this.gHp.containsKey(bjVar.getTid())) {
                    this.gHp.put(bjVar.getTid(), 0);
                    int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                    if (bjVar.getType() == bj.dqI) {
                        bi biVar = new bi();
                        biVar.dqE = bjVar;
                        biVar.position = i2;
                        biVar.dqs = true;
                        arrayList2.add(biVar);
                        bi biVar2 = new bi();
                        biVar2.dqE = bjVar;
                        biVar2.position = i2;
                        if (bjVar.aMw()) {
                            biVar2.dqx = true;
                        } else if (bjVar.aLF() == 1) {
                            biVar2.dqv = true;
                            biVar2.dqF = imageWidthAndHeight[0];
                            biVar2.dqG = imageWidthAndHeight[1];
                        } else if (bjVar.aLF() >= 2) {
                            biVar2.dqw = true;
                        } else {
                            biVar2.dqt = true;
                        }
                        arrayList2.add(biVar2);
                        bi biVar3 = new bi();
                        biVar3.dqD = true;
                        biVar3.dqE = bjVar;
                        biVar3.position = i2;
                        arrayList2.add(biVar3);
                        bi biVar4 = new bi();
                        biVar4.dqy = true;
                        biVar4.dqE = bjVar;
                        biVar4.position = i2;
                        arrayList2.add(biVar4);
                        i2++;
                    } else if (bjVar.getType() == bj.dqZ) {
                        bi biVar5 = new bi();
                        biVar5.dqE = bjVar;
                        biVar5.position = i2;
                        biVar5.dqs = true;
                        arrayList2.add(biVar5);
                        bi biVar6 = new bi();
                        biVar6.dqE = bjVar;
                        biVar6.position = i2;
                        biVar6.dqA = true;
                        arrayList2.add(biVar6);
                        bi biVar7 = new bi();
                        biVar7.dqD = true;
                        biVar7.dqE = bjVar;
                        biVar7.position = i2;
                        arrayList2.add(biVar7);
                        bi biVar8 = new bi();
                        biVar8.dqy = true;
                        biVar8.dqE = bjVar;
                        biVar8.position = i2;
                        arrayList2.add(biVar8);
                        i2++;
                    } else if (bjVar.getType() == bj.dqV && bjVar.aJr()) {
                        bjVar.position = i2;
                        arrayList2.add(bjVar);
                        i2++;
                    } else {
                        bi biVar9 = new bi();
                        biVar9.dqE = bjVar;
                        biVar9.position = i2;
                        arrayList2.add(biVar9);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.gHo = i2;
        return arrayList2;
    }
}
