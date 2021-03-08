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
    private boolean gec;
    private int iQM;
    private int iQN;
    private b iQO;
    private int iQP;
    private HashMap<String, Integer> iQQ;
    private com.baidu.tieba.enterForum.tabfeed.b.b iQR;
    private a iQS;
    private cb iQT;
    private CustomMessageListener iQU;
    private CustomMessageListener iQV;
    private CustomMessageListener iQW;
    private final com.baidu.adp.framework.listener.a iQX;
    private boolean isLoading;
    private com.baidu.adp.framework.listener.a netMessageListener;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.iQR != null) {
            ArrayList<n> cxo = aVar.cxo();
            this.iQR.gec = this.gec;
            if (!this.gec) {
                this.iQM++;
            } else {
                this.iQR.refreshCount = z ? y.getCount(cxo) : -1;
                e(cxo, aVar.cxp());
            }
            if (this.iQP + y.getCount(cxo) > this.iQN) {
                this.iQR.iQK = cxw();
            }
            ArrayList<n> am = am(switchThreadDataToThreadCardInfo(cxo));
            if (this.gec) {
                this.iQR.iQJ.addAll(0, am);
                this.iQR.iQK = 0;
            } else {
                this.iQR.iQJ.addAll(am);
                this.iQR.hasMore = !y.isEmpty(cxo);
            }
            this.iQR.amh = aVar.cxs();
            this.iQR.iQL = aVar.cxr();
            this.iQR.iQI = aVar.cxq();
            if (this.iQO != null) {
                this.iQO.a(this.iQR);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.iQM = 1;
        this.gec = true;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.iQR != null && EnterForumTabFeedNetModel.this.iQR.iQJ != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.iQS = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.iQO.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.iQT != null) {
                        aVar.cxo().add(0, EnterForumTabFeedNetModel.this.iQT);
                        if (EnterForumTabFeedNetModel.this.iQQ != null && EnterForumTabFeedNetModel.this.iQQ.containsKey(EnterForumTabFeedNetModel.this.iQT.getTid())) {
                            EnterForumTabFeedNetModel.this.iQQ.remove(EnterForumTabFeedNetModel.this.iQT.getTid());
                        }
                        EnterForumTabFeedNetModel.this.iQT = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.iQU = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iQV = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iQW = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (bjVar.eQG == 2 && bjVar.tabName != null && bjVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = av.bsV().bsW() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bjVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.iQX = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
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
                    EnterForumTabFeedNetModel.this.iQT = cbVar;
                    if (EnterForumTabFeedNetModel.this.iQS != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.netMessageListener);
        this.iQQ = new HashMap<>();
        this.iQR = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.iQO = bVar;
        this.iQN = com.baidu.tbadk.core.sharedPref.b.brR().getInt("home_page_max_thread_count", 300);
        registerListener(this.iQU);
        registerListener(this.iQV);
        this.iQX.setTag(getUniqueId());
        if (this.iQX.getHttpMessageListener() != null) {
            this.iQX.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iQX.getSocketMessageListener() != null) {
            this.iQX.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.iQX);
    }

    public void cxu() {
        registerListener(this.iQW);
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
        cxv();
        if (!y.isEmpty(arrayList) && !y.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<bv>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bv bvVar, bv bvVar2) {
                    if (bvVar.eRe == bvVar2.eRe) {
                        return 0;
                    }
                    return bvVar.eRe > bvVar2.eRe ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<bv> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    bv next = it.next();
                    int i3 = next.eRe + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.eRe != 0 && i3 <= arrayList.size()) {
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

    private void cxv() {
        if (!y.isEmpty(this.iQR.iQJ)) {
            int i = 0;
            Iterator<n> it = this.iQR.iQJ.iterator();
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

    private int cxw() {
        int i;
        if (this.iQR == null || this.iQR.iQJ == null) {
            return 0;
        }
        if (!this.gec) {
            i = 30;
        } else {
            i = this.iQP - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.iQP || i2 < 0 || i2 > this.iQP || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.iQR.iQJ.size()) {
                i3 = -1;
                break;
            }
            n nVar = this.iQR.iQJ.get(i3);
            if (nVar instanceof ca) {
                if (i4 == -1 && ((ca) nVar).position > i) {
                    i4 = i3;
                } else if (((ca) nVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((ca) nVar).eLr != null) {
                    this.iQQ.remove(((ca) nVar).eLr.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.iQR.iQJ.subList(0, i4));
        arrayList.addAll(this.iQR.iQJ.subList(i3, this.iQR.iQJ.size()));
        this.iQR.iQJ = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iQP > 0 && this.iQR != null && !y.isEmpty(this.iQR.iQJ)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.iQQ.containsKey(optString)) {
                Iterator<n> it = this.iQR.iQJ.iterator();
                int i2 = 0;
                int i3 = -1;
                int i4 = -1;
                int i5 = -1;
                while (it.hasNext()) {
                    n next = it.next();
                    if ((next instanceof ca) && ((ca) next).eLr != null) {
                        if (i5 >= 0) {
                            if (((ca) next).position != i5) {
                                break;
                            }
                            it.remove();
                            i = i2;
                        } else if (au.equals(optString, ((ca) next).eLr.getTid())) {
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
                    this.iQO.cj(i4, i3);
                }
            }
        }
    }

    public void bRp() {
        if (!this.isLoading) {
            this.gec = false;
            xQ(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.gec = true;
            xQ(1);
        }
    }

    private void xQ(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.iQM + 1;
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
        return (this.iQR == null || y.isEmpty(this.iQR.iQJ)) ? false : true;
    }

    private ArrayList<n> switchThreadDataToThreadCardInfo(ArrayList<n> arrayList) {
        int i = this.iQP;
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof bv) {
                arrayList2.add(next);
            } else if (next instanceof cb) {
                cb cbVar = (cb) next;
                if (!this.iQQ.containsKey(cbVar.getTid())) {
                    this.iQQ.put(cbVar.getTid(), 0);
                    cbVar.eVj = true;
                    int[] imageWidthAndHeight = cbVar.getImageWidthAndHeight();
                    if (cbVar.getType() == cb.eRN) {
                        ca caVar = new ca();
                        caVar.eLr = cbVar;
                        caVar.position = i2;
                        caVar.eRs = true;
                        arrayList2.add(caVar);
                        ca caVar2 = new ca();
                        caVar2.eLr = cbVar;
                        caVar2.position = i2;
                        if (cbVar.bpP()) {
                            caVar2.eRx = true;
                        } else if (cbVar.boZ() == 1) {
                            caVar2.eRv = true;
                            caVar2.eRK = imageWidthAndHeight[0];
                            caVar2.eRL = imageWidthAndHeight[1];
                        } else if (cbVar.boZ() >= 2) {
                            caVar2.eRw = true;
                        } else {
                            caVar2.eRt = true;
                        }
                        arrayList2.add(caVar2);
                        if (cbVar.bpY() != null) {
                            ca caVar3 = new ca();
                            caVar3.eRF = true;
                            caVar3.eLr = cbVar;
                            caVar3.position = i2;
                            arrayList2.add(caVar3);
                        }
                        if (!y.isEmpty(cbVar.bqb()) || !y.isEmpty(cbVar.bqc())) {
                            ca caVar4 = new ca();
                            caVar4.eLr = cbVar;
                            caVar4.position = i2;
                            if (y.getCount(cbVar.bqb()) + y.getCount(cbVar.bqc()) == 1) {
                                caVar4.eRH = true;
                            } else if (y.getCount(cbVar.bqb()) + y.getCount(cbVar.bqc()) > 1) {
                                caVar4.eRI = true;
                            }
                            arrayList2.add(caVar4);
                        }
                        ca caVar5 = new ca();
                        caVar5.eRE = true;
                        caVar5.eLr = cbVar;
                        caVar5.position = i2;
                        arrayList2.add(caVar5);
                        ca caVar6 = new ca();
                        caVar6.eRy = true;
                        caVar6.eLr = cbVar;
                        caVar6.position = i2;
                        arrayList2.add(caVar6);
                        i2++;
                    } else if (cbVar.getType() == cb.eSl) {
                        ca caVar7 = new ca();
                        caVar7.eLr = cbVar;
                        caVar7.position = i2;
                        caVar7.eRs = true;
                        arrayList2.add(caVar7);
                        ca caVar8 = new ca();
                        caVar8.eLr = cbVar;
                        caVar8.position = i2;
                        caVar8.eRA = true;
                        arrayList2.add(caVar8);
                        if (cbVar.bpY() != null) {
                            ca caVar9 = new ca();
                            caVar9.eRF = true;
                            caVar9.eLr = cbVar;
                            caVar9.position = i2;
                            arrayList2.add(caVar9);
                        }
                        if (!y.isEmpty(cbVar.bqb()) || !y.isEmpty(cbVar.bqc())) {
                            ca caVar10 = new ca();
                            caVar10.eLr = cbVar;
                            caVar10.position = i2;
                            if (y.getCount(cbVar.bqb()) + y.getCount(cbVar.bqc()) == 1) {
                                caVar10.eRH = true;
                            } else if (y.getCount(cbVar.bqb()) + y.getCount(cbVar.bqc()) > 1) {
                                caVar10.eRI = true;
                            }
                            arrayList2.add(caVar10);
                        }
                        ca caVar11 = new ca();
                        caVar11.eRE = true;
                        caVar11.eLr = cbVar;
                        caVar11.position = i2;
                        arrayList2.add(caVar11);
                        ca caVar12 = new ca();
                        caVar12.eRy = true;
                        caVar12.eLr = cbVar;
                        caVar12.position = i2;
                        arrayList2.add(caVar12);
                        i2++;
                    } else if (cbVar.getType() == cb.eSc && cbVar.bmz()) {
                        cbVar.position = i2;
                        arrayList2.add(cbVar);
                        i2++;
                    } else {
                        ca caVar13 = new ca();
                        caVar13.eLr = cbVar;
                        caVar13.position = i2;
                        arrayList2.add(caVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.iQP = i2;
        com.baidu.tbadk.a.a.a.bj(arrayList2);
        return arrayList2;
    }
}
