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
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.enterForum.tabfeed.b;
import com.baidu.tieba.enterForum.tabfeed.b.a;
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
/* loaded from: classes2.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean gcC;
    private int iPd;
    private int iPe;
    private b iPf;
    private int iPg;
    private HashMap<String, Integer> iPh;
    private com.baidu.tieba.enterForum.tabfeed.b.b iPi;
    private a iPj;
    private cb iPk;
    private CustomMessageListener iPl;
    private CustomMessageListener iPm;
    private CustomMessageListener iPn;
    private final com.baidu.adp.framework.listener.a iPo;
    private boolean isLoading;
    private com.baidu.adp.framework.listener.a netMessageListener;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.iPi != null) {
            ArrayList<n> cxi = aVar.cxi();
            this.iPi.gcC = this.gcC;
            if (!this.gcC) {
                this.iPd++;
            } else {
                this.iPi.refreshCount = z ? y.getCount(cxi) : -1;
                e(cxi, aVar.cxj());
            }
            if (this.iPg + y.getCount(cxi) > this.iPe) {
                this.iPi.iPb = cxq();
            }
            ArrayList<n> am = am(switchThreadDataToThreadCardInfo(cxi));
            if (this.gcC) {
                this.iPi.iPa.addAll(0, am);
                this.iPi.iPb = 0;
            } else {
                this.iPi.iPa.addAll(am);
                this.iPi.hasMore = !y.isEmpty(cxi);
            }
            this.iPi.akO = aVar.cxm();
            this.iPi.iPc = aVar.cxl();
            this.iPi.iOZ = aVar.cxk();
            if (this.iPf != null) {
                this.iPf.a(this.iPi);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.iPd = 1;
        this.gcC = true;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.iPi != null && EnterForumTabFeedNetModel.this.iPi.iPa != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.iPj = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.iPf.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.iPk != null) {
                        aVar.cxi().add(0, EnterForumTabFeedNetModel.this.iPk);
                        if (EnterForumTabFeedNetModel.this.iPh != null && EnterForumTabFeedNetModel.this.iPh.containsKey(EnterForumTabFeedNetModel.this.iPk.getTid())) {
                            EnterForumTabFeedNetModel.this.iPh.remove(EnterForumTabFeedNetModel.this.iPk.getTid());
                        }
                        EnterForumTabFeedNetModel.this.iPk = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.iPl = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iPm = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iPn = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (bjVar.ePf == 2 && bjVar.tabName != null && bjVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = av.bsS().bsT() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bjVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.iPo = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                GetMyPostResIdl getMyPostResIdl = null;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                }
                if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                    cb cbVar = new cb();
                    cbVar.a(getMyPostResIdl.data.thread_info);
                    EnterForumTabFeedNetModel.this.iPk = cbVar;
                    if (EnterForumTabFeedNetModel.this.iPj != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.netMessageListener);
        this.iPh = new HashMap<>();
        this.iPi = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.iPf = bVar;
        this.iPe = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("home_page_max_thread_count", 300);
        registerListener(this.iPl);
        registerListener(this.iPm);
        this.iPo.setTag(getUniqueId());
        if (this.iPo.getHttpMessageListener() != null) {
            this.iPo.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iPo.getSocketMessageListener() != null) {
            this.iPo.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.iPo);
    }

    public void cxo() {
        registerListener(this.iPn);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }

    public void eR(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    private ArrayList<n> am(ArrayList<n> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = true;
            Iterator<n> it = arrayList.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = !(it.next() instanceof bv) ? false : z;
            }
            if (z) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    private void e(ArrayList<n> arrayList, ArrayList<bv> arrayList2) {
        cxp();
        if (!y.isEmpty(arrayList) && !y.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<bv>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bv bvVar, bv bvVar2) {
                    if (bvVar.ePD == bvVar2.ePD) {
                        return 0;
                    }
                    return bvVar.ePD > bvVar2.ePD ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<bv> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    bv next = it.next();
                    int i3 = next.ePD + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.ePD != 0 && i3 <= arrayList.size()) {
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

    private void cxp() {
        if (!y.isEmpty(this.iPi.iPa)) {
            int i = 0;
            Iterator<n> it = this.iPi.iPa.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    if (it.next() instanceof bv) {
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

    private int cxq() {
        int i;
        if (this.iPi == null || this.iPi.iPa == null) {
            return 0;
        }
        if (!this.gcC) {
            i = 30;
        } else {
            i = this.iPg - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.iPg || i2 < 0 || i2 > this.iPg || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.iPi.iPa.size()) {
                i3 = -1;
                break;
            }
            n nVar = this.iPi.iPa.get(i3);
            if (nVar instanceof ca) {
                if (i4 == -1 && ((ca) nVar).position > i) {
                    i4 = i3;
                } else if (((ca) nVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((ca) nVar).eJQ != null) {
                    this.iPh.remove(((ca) nVar).eJQ.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.iPi.iPa.subList(0, i4));
        arrayList.addAll(this.iPi.iPa.subList(i3, this.iPi.iPa.size()));
        this.iPi.iPa = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iPg > 0 && this.iPi != null && !y.isEmpty(this.iPi.iPa)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.iPh.containsKey(optString)) {
                Iterator<n> it = this.iPi.iPa.iterator();
                int i2 = 0;
                int i3 = -1;
                int i4 = -1;
                int i5 = -1;
                while (it.hasNext()) {
                    n next = it.next();
                    if ((next instanceof ca) && ((ca) next).eJQ != null) {
                        if (i5 >= 0) {
                            if (((ca) next).position != i5) {
                                break;
                            }
                            it.remove();
                            i = i2;
                        } else if (au.equals(optString, ((ca) next).eJQ.getTid())) {
                            i5 = ((ca) next).position;
                            it.remove();
                            i = i3;
                            i4 = i2;
                        }
                        i2++;
                        i3 = i;
                    }
                    i = i3;
                    i2++;
                    i3 = i;
                }
                if (i4 < i3) {
                    this.iPf.cj(i4, i3);
                }
            }
        }
    }

    public void bRj() {
        if (!this.isLoading) {
            this.gcC = false;
            xP(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.gcC = true;
            xP(1);
        }
    }

    private void xP(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.iPd + 1;
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
        return (this.iPi == null || y.isEmpty(this.iPi.iPa)) ? false : true;
    }

    private ArrayList<n> switchThreadDataToThreadCardInfo(ArrayList<n> arrayList) {
        int i = this.iPg;
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof bv) {
                arrayList2.add(next);
            } else if (next instanceof cb) {
                cb cbVar = (cb) next;
                if (!this.iPh.containsKey(cbVar.getTid())) {
                    this.iPh.put(cbVar.getTid(), 0);
                    cbVar.eTI = true;
                    int[] imageWidthAndHeight = cbVar.getImageWidthAndHeight();
                    if (cbVar.getType() == cb.eQm) {
                        ca caVar = new ca();
                        caVar.eJQ = cbVar;
                        caVar.position = i2;
                        caVar.ePR = true;
                        arrayList2.add(caVar);
                        ca caVar2 = new ca();
                        caVar2.eJQ = cbVar;
                        caVar2.position = i2;
                        if (cbVar.bpN()) {
                            caVar2.ePW = true;
                        } else if (cbVar.boX() == 1) {
                            caVar2.ePU = true;
                            caVar2.eQj = imageWidthAndHeight[0];
                            caVar2.eQk = imageWidthAndHeight[1];
                        } else if (cbVar.boX() >= 2) {
                            caVar2.ePV = true;
                        } else {
                            caVar2.ePS = true;
                        }
                        arrayList2.add(caVar2);
                        if (cbVar.bpW() != null) {
                            ca caVar3 = new ca();
                            caVar3.eQe = true;
                            caVar3.eJQ = cbVar;
                            caVar3.position = i2;
                            arrayList2.add(caVar3);
                        }
                        if (!y.isEmpty(cbVar.bpZ()) || !y.isEmpty(cbVar.bqa())) {
                            ca caVar4 = new ca();
                            caVar4.eJQ = cbVar;
                            caVar4.position = i2;
                            if (y.getCount(cbVar.bpZ()) + y.getCount(cbVar.bqa()) == 1) {
                                caVar4.eQg = true;
                            } else if (y.getCount(cbVar.bpZ()) + y.getCount(cbVar.bqa()) > 1) {
                                caVar4.eQh = true;
                            }
                            arrayList2.add(caVar4);
                        }
                        ca caVar5 = new ca();
                        caVar5.eQd = true;
                        caVar5.eJQ = cbVar;
                        caVar5.position = i2;
                        arrayList2.add(caVar5);
                        ca caVar6 = new ca();
                        caVar6.ePX = true;
                        caVar6.eJQ = cbVar;
                        caVar6.position = i2;
                        arrayList2.add(caVar6);
                        i2++;
                    } else if (cbVar.getType() == cb.eQK) {
                        ca caVar7 = new ca();
                        caVar7.eJQ = cbVar;
                        caVar7.position = i2;
                        caVar7.ePR = true;
                        arrayList2.add(caVar7);
                        ca caVar8 = new ca();
                        caVar8.eJQ = cbVar;
                        caVar8.position = i2;
                        caVar8.ePZ = true;
                        arrayList2.add(caVar8);
                        if (cbVar.bpW() != null) {
                            ca caVar9 = new ca();
                            caVar9.eQe = true;
                            caVar9.eJQ = cbVar;
                            caVar9.position = i2;
                            arrayList2.add(caVar9);
                        }
                        if (!y.isEmpty(cbVar.bpZ()) || !y.isEmpty(cbVar.bqa())) {
                            ca caVar10 = new ca();
                            caVar10.eJQ = cbVar;
                            caVar10.position = i2;
                            if (y.getCount(cbVar.bpZ()) + y.getCount(cbVar.bqa()) == 1) {
                                caVar10.eQg = true;
                            } else if (y.getCount(cbVar.bpZ()) + y.getCount(cbVar.bqa()) > 1) {
                                caVar10.eQh = true;
                            }
                            arrayList2.add(caVar10);
                        }
                        ca caVar11 = new ca();
                        caVar11.eQd = true;
                        caVar11.eJQ = cbVar;
                        caVar11.position = i2;
                        arrayList2.add(caVar11);
                        ca caVar12 = new ca();
                        caVar12.ePX = true;
                        caVar12.eJQ = cbVar;
                        caVar12.position = i2;
                        arrayList2.add(caVar12);
                        i2++;
                    } else if (cbVar.getType() == cb.eQB && cbVar.bmx()) {
                        cbVar.position = i2;
                        arrayList2.add(cbVar);
                        i2++;
                    } else {
                        ca caVar13 = new ca();
                        caVar13.eJQ = cbVar;
                        caVar13.position = i2;
                        arrayList2.add(caVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.iPg = i2;
        com.baidu.tbadk.a.a.a.bj(arrayList2);
        return arrayList2;
    }
}
