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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
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
    private boolean gae;
    private int iJh;
    private int iJi;
    private b iJj;
    private int iJk;
    private HashMap<String, Integer> iJl;
    private com.baidu.tieba.enterForum.tabfeed.b.b iJm;
    private a iJn;
    private bz iJo;
    private CustomMessageListener iJp;
    private CustomMessageListener iJq;
    private CustomMessageListener iJr;
    private final com.baidu.adp.framework.listener.a iJs;
    private boolean isLoading;
    private com.baidu.adp.framework.listener.a netMessageListener;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.iJm != null) {
            ArrayList<n> cvP = aVar.cvP();
            this.iJm.gae = this.gae;
            if (!this.gae) {
                this.iJh++;
            } else {
                this.iJm.refreshCount = z ? x.getCount(cvP) : -1;
                e(cvP, aVar.cvQ());
            }
            if (this.iJk + x.getCount(cvP) > this.iJi) {
                this.iJm.iJf = cvX();
            }
            ArrayList<n> an = an(switchThreadDataToThreadCardInfo(cvP));
            if (this.gae) {
                this.iJm.iJe.addAll(0, an);
                this.iJm.iJf = 0;
            } else {
                this.iJm.iJe.addAll(an);
                this.iJm.hasMore = !x.isEmpty(cvP);
            }
            this.iJm.akY = aVar.cvT();
            this.iJm.iJg = aVar.cvS();
            this.iJm.iJd = aVar.cvR();
            if (this.iJj != null) {
                this.iJj.a(this.iJm);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.iJh = 1;
        this.gae = true;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.iJm != null && EnterForumTabFeedNetModel.this.iJm.iJe != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.iJn = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.iJj.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.iJo != null) {
                        aVar.cvP().add(0, EnterForumTabFeedNetModel.this.iJo);
                        if (EnterForumTabFeedNetModel.this.iJl != null && EnterForumTabFeedNetModel.this.iJl.containsKey(EnterForumTabFeedNetModel.this.iJo.getTid())) {
                            EnterForumTabFeedNetModel.this.iJl.remove(EnterForumTabFeedNetModel.this.iJo.getTid());
                        }
                        EnterForumTabFeedNetModel.this.iJo = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.iJp = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iJq = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iJr = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (bhVar.eMT == 2 && bhVar.tabName != null && bhVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = au.bsy().bsz() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bhVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.iJs = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                GetMyPostResIdl getMyPostResIdl = null;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                }
                if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                    bz bzVar = new bz();
                    bzVar.a(getMyPostResIdl.data.thread_info);
                    EnterForumTabFeedNetModel.this.iJo = bzVar;
                    if (EnterForumTabFeedNetModel.this.iJn != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.netMessageListener);
        this.iJl = new HashMap<>();
        this.iJm = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.iJj = bVar;
        this.iJi = com.baidu.tbadk.core.sharedPref.b.brx().getInt("home_page_max_thread_count", 300);
        registerListener(this.iJp);
        registerListener(this.iJq);
        this.iJs.setTag(getUniqueId());
        if (this.iJs.getHttpMessageListener() != null) {
            this.iJs.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iJs.getSocketMessageListener() != null) {
            this.iJs.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.iJs);
    }

    public void cvV() {
        registerListener(this.iJr);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }

    public void eR(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    private ArrayList<n> an(ArrayList<n> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = true;
            Iterator<n> it = arrayList.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = !(it.next() instanceof bt) ? false : z;
            }
            if (z) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    private void e(ArrayList<n> arrayList, ArrayList<bt> arrayList2) {
        cvW();
        if (!x.isEmpty(arrayList) && !x.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<bt>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bt btVar, bt btVar2) {
                    if (btVar.eNr == btVar2.eNr) {
                        return 0;
                    }
                    return btVar.eNr > btVar2.eNr ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<bt> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    bt next = it.next();
                    int i3 = next.eNr + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.eNr != 0 && i3 <= arrayList.size()) {
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

    private void cvW() {
        if (!x.isEmpty(this.iJm.iJe)) {
            int i = 0;
            Iterator<n> it = this.iJm.iJe.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    if (it.next() instanceof bt) {
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

    private int cvX() {
        int i;
        if (this.iJm == null || this.iJm.iJe == null) {
            return 0;
        }
        if (!this.gae) {
            i = 30;
        } else {
            i = this.iJk - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.iJk || i2 < 0 || i2 > this.iJk || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.iJm.iJe.size()) {
                i3 = -1;
                break;
            }
            n nVar = this.iJm.iJe.get(i3);
            if (nVar instanceof by) {
                if (i4 == -1 && ((by) nVar).position > i) {
                    i4 = i3;
                } else if (((by) nVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((by) nVar).eHK != null) {
                    this.iJl.remove(((by) nVar).eHK.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.iJm.iJe.subList(0, i4));
        arrayList.addAll(this.iJm.iJe.subList(i3, this.iJm.iJe.size()));
        this.iJm.iJe = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iJk > 0 && this.iJm != null && !x.isEmpty(this.iJm.iJe)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.iJl.containsKey(optString)) {
                Iterator<n> it = this.iJm.iJe.iterator();
                int i2 = 0;
                int i3 = -1;
                int i4 = -1;
                int i5 = -1;
                while (it.hasNext()) {
                    n next = it.next();
                    if ((next instanceof by) && ((by) next).eHK != null) {
                        if (i5 >= 0) {
                            if (((by) next).position != i5) {
                                break;
                            }
                            it.remove();
                            i = i2;
                        } else if (at.equals(optString, ((by) next).eHK.getTid())) {
                            i5 = ((by) next).position;
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
                    this.iJj.cl(i4, i3);
                }
            }
        }
    }

    public void bQy() {
        if (!this.isLoading) {
            this.gae = false;
            xF(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.gae = true;
            xF(1);
        }
    }

    private void xF(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.iJh + 1;
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
        return (this.iJm == null || x.isEmpty(this.iJm.iJe)) ? false : true;
    }

    private ArrayList<n> switchThreadDataToThreadCardInfo(ArrayList<n> arrayList) {
        int i = this.iJk;
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof bt) {
                arrayList2.add(next);
            } else if (next instanceof bz) {
                bz bzVar = (bz) next;
                if (!this.iJl.containsKey(bzVar.getTid())) {
                    this.iJl.put(bzVar.getTid(), 0);
                    bzVar.eRw = true;
                    int[] imageWidthAndHeight = bzVar.getImageWidthAndHeight();
                    if (bzVar.getType() == bz.eOa) {
                        by byVar = new by();
                        byVar.eHK = bzVar;
                        byVar.position = i2;
                        byVar.eNF = true;
                        arrayList2.add(byVar);
                        by byVar2 = new by();
                        byVar2.eHK = bzVar;
                        byVar2.position = i2;
                        if (bzVar.bpv()) {
                            byVar2.eNK = true;
                        } else if (bzVar.boF() == 1) {
                            byVar2.eNI = true;
                            byVar2.eNX = imageWidthAndHeight[0];
                            byVar2.eNY = imageWidthAndHeight[1];
                        } else if (bzVar.boF() >= 2) {
                            byVar2.eNJ = true;
                        } else {
                            byVar2.eNG = true;
                        }
                        arrayList2.add(byVar2);
                        if (bzVar.bpE() != null) {
                            by byVar3 = new by();
                            byVar3.eNS = true;
                            byVar3.eHK = bzVar;
                            byVar3.position = i2;
                            arrayList2.add(byVar3);
                        }
                        if (!x.isEmpty(bzVar.bpH()) || !x.isEmpty(bzVar.bpI())) {
                            by byVar4 = new by();
                            byVar4.eHK = bzVar;
                            byVar4.position = i2;
                            if (x.getCount(bzVar.bpH()) + x.getCount(bzVar.bpI()) == 1) {
                                byVar4.eNU = true;
                            } else if (x.getCount(bzVar.bpH()) + x.getCount(bzVar.bpI()) > 1) {
                                byVar4.eNV = true;
                            }
                            arrayList2.add(byVar4);
                        }
                        by byVar5 = new by();
                        byVar5.eNR = true;
                        byVar5.eHK = bzVar;
                        byVar5.position = i2;
                        arrayList2.add(byVar5);
                        by byVar6 = new by();
                        byVar6.eNL = true;
                        byVar6.eHK = bzVar;
                        byVar6.position = i2;
                        arrayList2.add(byVar6);
                        i2++;
                    } else if (bzVar.getType() == bz.eOy) {
                        by byVar7 = new by();
                        byVar7.eHK = bzVar;
                        byVar7.position = i2;
                        byVar7.eNF = true;
                        arrayList2.add(byVar7);
                        by byVar8 = new by();
                        byVar8.eHK = bzVar;
                        byVar8.position = i2;
                        byVar8.eNN = true;
                        arrayList2.add(byVar8);
                        if (bzVar.bpE() != null) {
                            by byVar9 = new by();
                            byVar9.eNS = true;
                            byVar9.eHK = bzVar;
                            byVar9.position = i2;
                            arrayList2.add(byVar9);
                        }
                        if (!x.isEmpty(bzVar.bpH()) || !x.isEmpty(bzVar.bpI())) {
                            by byVar10 = new by();
                            byVar10.eHK = bzVar;
                            byVar10.position = i2;
                            if (x.getCount(bzVar.bpH()) + x.getCount(bzVar.bpI()) == 1) {
                                byVar10.eNU = true;
                            } else if (x.getCount(bzVar.bpH()) + x.getCount(bzVar.bpI()) > 1) {
                                byVar10.eNV = true;
                            }
                            arrayList2.add(byVar10);
                        }
                        by byVar11 = new by();
                        byVar11.eNR = true;
                        byVar11.eHK = bzVar;
                        byVar11.position = i2;
                        arrayList2.add(byVar11);
                        by byVar12 = new by();
                        byVar12.eNL = true;
                        byVar12.eHK = bzVar;
                        byVar12.position = i2;
                        arrayList2.add(byVar12);
                        i2++;
                    } else if (bzVar.getType() == bz.eOp && bzVar.bme()) {
                        bzVar.position = i2;
                        arrayList2.add(bzVar);
                        i2++;
                    } else {
                        by byVar13 = new by();
                        byVar13.eHK = bzVar;
                        byVar13.position = i2;
                        arrayList2.add(byVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.iJk = i2;
        com.baidu.tbadk.a.a.a.bo(arrayList2);
        return arrayList2;
    }
}
