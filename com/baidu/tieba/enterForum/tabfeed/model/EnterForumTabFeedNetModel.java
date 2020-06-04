package com.baidu.tieba.enterForum.tabfeed.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.enterForum.tabfeed.b;
import com.baidu.tieba.enterForum.tabfeed.b.a;
import com.baidu.tieba.enterForum.tabfeed.b.d;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes9.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean eIz;
    private int gWd;
    private int gWe;
    private b gWf;
    private int gWg;
    private HashMap<String, Integer> gWh;
    private com.baidu.tieba.enterForum.tabfeed.b.b gWi;
    private a gWj;
    private bk gWk;
    private com.baidu.adp.framework.listener.a gWl;
    private CustomMessageListener gWm;
    private CustomMessageListener gWn;
    private CustomMessageListener gWo;
    private final com.baidu.adp.framework.listener.a gWp;
    private boolean isLoading;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.gWi != null) {
            ArrayList<o> bPS = aVar.bPS();
            this.gWi.eIz = this.eIz;
            if (!this.eIz) {
                this.gWd++;
            } else {
                this.gWi.refreshCount = z ? v.getCount(bPS) : -1;
                e(bPS, aVar.bPT());
            }
            if (this.gWg + v.getCount(bPS) > this.gWe) {
                this.gWi.gVZ = bQa();
            }
            ArrayList<o> ag = ag(switchThreadDataToThreadCardInfo(bPS));
            if (this.eIz) {
                this.gWi.gVY.addAll(0, ag);
                this.gWi.gVZ = 0;
            } else {
                this.gWi.gVY.addAll(ag);
                this.gWi.hasMore = !v.isEmpty(bPS);
            }
            this.gWi.aha = aVar.bPW();
            this.gWi.gWa = aVar.bPV();
            this.gWi.gVX = aVar.bPU();
            if (this.gWf != null) {
                this.gWf.a(this.gWi);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.gWd = 1;
        this.eIz = true;
        this.gWl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.gWi != null && EnterForumTabFeedNetModel.this.gWi.gVY != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.gWj = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.gWf.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.gWk != null) {
                        aVar.bPS().add(0, EnterForumTabFeedNetModel.this.gWk);
                        if (EnterForumTabFeedNetModel.this.gWh != null && EnterForumTabFeedNetModel.this.gWh.containsKey(EnterForumTabFeedNetModel.this.gWk.getTid())) {
                            EnterForumTabFeedNetModel.this.gWh.remove(EnterForumTabFeedNetModel.this.gWk.getTid());
                        }
                        EnterForumTabFeedNetModel.this.gWk = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.gWm = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.gWn = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.gWo = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ax)) {
                    ax axVar = (ax) customResponsedMessage.getData();
                    if (axVar.dDN == 2 && axVar.tabName != null && axVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = ar.aUX().aUY() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(axVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.gWp = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                GetMyPostResIdl getMyPostResIdl = null;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                }
                if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                    bk bkVar = new bk();
                    bkVar.a(getMyPostResIdl.data.thread_info);
                    EnterForumTabFeedNetModel.this.gWk = bkVar;
                    if (EnterForumTabFeedNetModel.this.gWj != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.gWl.getHttpMessageListener().setSelfListener(true);
        this.gWl.getSocketMessageListener().setSelfListener(true);
        registerListener(this.gWl);
        this.gWh = new HashMap<>();
        this.gWi = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.gWf = bVar;
        this.gWe = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("home_page_max_thread_count", 300);
        registerListener(this.gWm);
        registerListener(this.gWn);
        this.gWp.setTag(getUniqueId());
        if (this.gWp.getHttpMessageListener() != null) {
            this.gWp.getHttpMessageListener().setSelfListener(true);
        }
        if (this.gWp.getSocketMessageListener() != null) {
            this.gWp.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.gWp);
    }

    public void bPY() {
        registerListener(this.gWo);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.gWl);
    }

    public void dX(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    private ArrayList<o> ag(ArrayList<o> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = true;
            Iterator<o> it = arrayList.iterator();
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

    private void e(ArrayList<o> arrayList, ArrayList<d> arrayList2) {
        bPZ();
        if (!v.isEmpty(arrayList) && !v.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<d>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(d dVar, d dVar2) {
                    if (dVar.gWc == dVar2.gWc) {
                        return 0;
                    }
                    return dVar.gWc > dVar2.gWc ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<d> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    d next = it.next();
                    int i3 = next.gWc + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.gWc != 0 && i3 <= arrayList.size()) {
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

    private void bPZ() {
        if (!v.isEmpty(this.gWi.gVY)) {
            int i = 0;
            Iterator<o> it = this.gWi.gVY.iterator();
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

    private int bQa() {
        int i;
        if (this.gWi == null || this.gWi.gVY == null) {
            return 0;
        }
        if (!this.eIz) {
            i = 30;
        } else {
            i = this.gWg - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.gWg || i2 < 0 || i2 > this.gWg || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.gWi.gVY.size()) {
                i3 = -1;
                break;
            }
            o oVar = this.gWi.gVY.get(i3);
            if (oVar instanceof bj) {
                if (i4 == -1 && ((bj) oVar).position > i) {
                    i4 = i3;
                } else if (((bj) oVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bj) oVar).dEA != null) {
                    this.gWh.remove(((bj) oVar).dEA.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<o> arrayList = new ArrayList<>();
        arrayList.addAll(this.gWi.gVY.subList(0, i4));
        arrayList.addAll(this.gWi.gVY.subList(i3, this.gWi.gVY.size()));
        this.gWi.gVY = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gWg > 0 && this.gWi != null && !v.isEmpty(this.gWi.gVY)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.gWh.containsKey(optString)) {
                Iterator<o> it = this.gWi.gVY.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    o next = it.next();
                    if ((next instanceof bj) && ((bj) next).dEA != null) {
                        if (i7 >= 0) {
                            if (((bj) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (aq.equals(optString, ((bj) next).dEA.getTid())) {
                            int i8 = ((bj) next).position;
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
                    this.gWf.bM(i6, i5);
                }
            }
        }
    }

    public void bqx() {
        if (!this.isLoading) {
            this.eIz = false;
            tc(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.eIz = true;
            tc(1);
        }
    }

    private void tc(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.gWd + 1;
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
        return (this.gWi == null || v.isEmpty(this.gWi.gVY)) ? false : true;
    }

    private ArrayList<o> switchThreadDataToThreadCardInfo(ArrayList<o> arrayList) {
        int i = this.gWg;
        ArrayList<o> arrayList2 = new ArrayList<>();
        Iterator<o> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            o next = it.next();
            if (next instanceof d) {
                arrayList2.add(next);
            } else if (next instanceof bk) {
                bk bkVar = (bk) next;
                if (!this.gWh.containsKey(bkVar.getTid())) {
                    this.gWh.put(bkVar.getTid(), 0);
                    int[] imageWidthAndHeight = bkVar.getImageWidthAndHeight();
                    if (bkVar.getType() == bk.dEE) {
                        bj bjVar = new bj();
                        bjVar.dEA = bkVar;
                        bjVar.position = i2;
                        bjVar.dEo = true;
                        arrayList2.add(bjVar);
                        bj bjVar2 = new bj();
                        bjVar2.dEA = bkVar;
                        bjVar2.position = i2;
                        if (bkVar.aSv()) {
                            bjVar2.dEt = true;
                        } else if (bkVar.aRE() == 1) {
                            bjVar2.dEr = true;
                            bjVar2.dEB = imageWidthAndHeight[0];
                            bjVar2.dEC = imageWidthAndHeight[1];
                        } else if (bkVar.aRE() >= 2) {
                            bjVar2.dEs = true;
                        } else {
                            bjVar2.dEp = true;
                        }
                        arrayList2.add(bjVar2);
                        bj bjVar3 = new bj();
                        bjVar3.dEz = true;
                        bjVar3.dEA = bkVar;
                        bjVar3.position = i2;
                        arrayList2.add(bjVar3);
                        bj bjVar4 = new bj();
                        bjVar4.dEu = true;
                        bjVar4.dEA = bkVar;
                        bjVar4.position = i2;
                        arrayList2.add(bjVar4);
                        i2++;
                    } else if (bkVar.getType() == bk.dEV) {
                        bj bjVar5 = new bj();
                        bjVar5.dEA = bkVar;
                        bjVar5.position = i2;
                        bjVar5.dEo = true;
                        arrayList2.add(bjVar5);
                        bj bjVar6 = new bj();
                        bjVar6.dEA = bkVar;
                        bjVar6.position = i2;
                        bjVar6.dEw = true;
                        arrayList2.add(bjVar6);
                        bj bjVar7 = new bj();
                        bjVar7.dEz = true;
                        bjVar7.dEA = bkVar;
                        bjVar7.position = i2;
                        arrayList2.add(bjVar7);
                        bj bjVar8 = new bj();
                        bjVar8.dEu = true;
                        bjVar8.dEA = bkVar;
                        bjVar8.position = i2;
                        arrayList2.add(bjVar8);
                        i2++;
                    } else if (bkVar.getType() == bk.dER && bkVar.aPm()) {
                        bkVar.position = i2;
                        arrayList2.add(bkVar);
                        i2++;
                    } else {
                        bj bjVar9 = new bj();
                        bjVar9.dEA = bkVar;
                        bjVar9.position = i2;
                        arrayList2.add(bjVar9);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.gWg = i2;
        return arrayList2;
    }
}
