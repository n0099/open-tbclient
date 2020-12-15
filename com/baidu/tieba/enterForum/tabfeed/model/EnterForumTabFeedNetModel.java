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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean fVi;
    private int iBC;
    private int iBD;
    private b iBE;
    private int iBF;
    private HashMap<String, Integer> iBG;
    private com.baidu.tieba.enterForum.tabfeed.b.b iBH;
    private a iBI;
    private by iBJ;
    private CustomMessageListener iBK;
    private CustomMessageListener iBL;
    private CustomMessageListener iBM;
    private final com.baidu.adp.framework.listener.a iBN;
    private boolean isLoading;
    private com.baidu.adp.framework.listener.a netMessageListener;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.iBH != null) {
            ArrayList<q> cwN = aVar.cwN();
            this.iBH.fVi = this.fVi;
            if (!this.fVi) {
                this.iBC++;
            } else {
                this.iBH.refreshCount = z ? y.getCount(cwN) : -1;
                e(cwN, aVar.cwO());
            }
            if (this.iBF + y.getCount(cwN) > this.iBD) {
                this.iBH.iBA = cwV();
            }
            ArrayList<q> as = as(switchThreadDataToThreadCardInfo(cwN));
            if (this.fVi) {
                this.iBH.iBz.addAll(0, as);
                this.iBH.iBA = 0;
            } else {
                this.iBH.iBz.addAll(as);
                this.iBH.hasMore = !y.isEmpty(cwN);
            }
            this.iBH.alo = aVar.cwR();
            this.iBH.iBB = aVar.cwQ();
            this.iBH.iBy = aVar.cwP();
            if (this.iBE != null) {
                this.iBE.a(this.iBH);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.iBC = 1;
        this.fVi = true;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.iBH != null && EnterForumTabFeedNetModel.this.iBH.iBz != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.iBI = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.iBE.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.iBJ != null) {
                        aVar.cwN().add(0, EnterForumTabFeedNetModel.this.iBJ);
                        if (EnterForumTabFeedNetModel.this.iBG != null && EnterForumTabFeedNetModel.this.iBG.containsKey(EnterForumTabFeedNetModel.this.iBJ.getTid())) {
                            EnterForumTabFeedNetModel.this.iBG.remove(EnterForumTabFeedNetModel.this.iBJ.getTid());
                        }
                        EnterForumTabFeedNetModel.this.iBJ = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.iBK = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iBL = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iBM = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                    bg bgVar = (bg) customResponsedMessage.getData();
                    if (bgVar.eHM == 2 && bgVar.tabName != null && bgVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = av.btX().btY() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bgVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.iBN = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                GetMyPostResIdl getMyPostResIdl = null;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                }
                if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                    by byVar = new by();
                    byVar.a(getMyPostResIdl.data.thread_info);
                    EnterForumTabFeedNetModel.this.iBJ = byVar;
                    if (EnterForumTabFeedNetModel.this.iBI != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.netMessageListener);
        this.iBG = new HashMap<>();
        this.iBH = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.iBE = bVar;
        this.iBD = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("home_page_max_thread_count", 300);
        registerListener(this.iBK);
        registerListener(this.iBL);
        this.iBN.setTag(getUniqueId());
        if (this.iBN.getHttpMessageListener() != null) {
            this.iBN.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iBN.getSocketMessageListener() != null) {
            this.iBN.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.iBN);
    }

    public void cwT() {
        registerListener(this.iBM);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }

    public void eR(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    private ArrayList<q> as(ArrayList<q> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = true;
            Iterator<q> it = arrayList.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = !(it.next() instanceof bs) ? false : z;
            }
            if (z) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    private void e(ArrayList<q> arrayList, ArrayList<bs> arrayList2) {
        cwU();
        if (!y.isEmpty(arrayList) && !y.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<bs>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bs bsVar, bs bsVar2) {
                    if (bsVar.eIk == bsVar2.eIk) {
                        return 0;
                    }
                    return bsVar.eIk > bsVar2.eIk ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<bs> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    bs next = it.next();
                    int i3 = next.eIk + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.eIk != 0 && i3 <= arrayList.size()) {
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

    private void cwU() {
        if (!y.isEmpty(this.iBH.iBz)) {
            int i = 0;
            Iterator<q> it = this.iBH.iBz.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    if (it.next() instanceof bs) {
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

    private int cwV() {
        int i;
        if (this.iBH == null || this.iBH.iBz == null) {
            return 0;
        }
        if (!this.fVi) {
            i = 30;
        } else {
            i = this.iBF - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.iBF || i2 < 0 || i2 > this.iBF || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.iBH.iBz.size()) {
                i3 = -1;
                break;
            }
            q qVar = this.iBH.iBz.get(i3);
            if (qVar instanceof bx) {
                if (i4 == -1 && ((bx) qVar).position > i) {
                    i4 = i3;
                } else if (((bx) qVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bx) qVar).eCR != null) {
                    this.iBG.remove(((bx) qVar).eCR.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.iBH.iBz.subList(0, i4));
        arrayList.addAll(this.iBH.iBz.subList(i3, this.iBH.iBz.size()));
        this.iBH.iBz = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iBF > 0 && this.iBH != null && !y.isEmpty(this.iBH.iBz)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.iBG.containsKey(optString)) {
                Iterator<q> it = this.iBH.iBz.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof bx) && ((bx) next).eCR != null) {
                        if (i7 >= 0) {
                            if (((bx) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (au.equals(optString, ((bx) next).eCR.getTid())) {
                            int i8 = ((bx) next).position;
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
                    this.iBE.cm(i6, i5);
                }
            }
        }
    }

    public void bRN() {
        if (!this.isLoading) {
            this.fVi = false;
            yY(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.fVi = true;
            yY(1);
        }
    }

    private void yY(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.iBC + 1;
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
        return (this.iBH == null || y.isEmpty(this.iBH.iBz)) ? false : true;
    }

    private ArrayList<q> switchThreadDataToThreadCardInfo(ArrayList<q> arrayList) {
        int i = this.iBF;
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bs) {
                arrayList2.add(next);
            } else if (next instanceof by) {
                by byVar = (by) next;
                if (!this.iBG.containsKey(byVar.getTid())) {
                    this.iBG.put(byVar.getTid(), 0);
                    byVar.eMm = true;
                    int[] imageWidthAndHeight = byVar.getImageWidthAndHeight();
                    if (byVar.getType() == by.eIS) {
                        bx bxVar = new bx();
                        bxVar.eCR = byVar;
                        bxVar.position = i2;
                        bxVar.eIy = true;
                        arrayList2.add(bxVar);
                        bx bxVar2 = new bx();
                        bxVar2.eCR = byVar;
                        bxVar2.position = i2;
                        if (byVar.bqM()) {
                            bxVar2.eID = true;
                        } else if (byVar.bpX() == 1) {
                            bxVar2.eIB = true;
                            bxVar2.eIP = imageWidthAndHeight[0];
                            bxVar2.eIQ = imageWidthAndHeight[1];
                        } else if (byVar.bpX() >= 2) {
                            bxVar2.eIC = true;
                        } else {
                            bxVar2.eIz = true;
                        }
                        arrayList2.add(bxVar2);
                        if (byVar.bqV() != null) {
                            bx bxVar3 = new bx();
                            bxVar3.eIK = true;
                            bxVar3.eCR = byVar;
                            bxVar3.position = i2;
                            arrayList2.add(bxVar3);
                        }
                        if (!y.isEmpty(byVar.bqY()) || !y.isEmpty(byVar.bqZ())) {
                            bx bxVar4 = new bx();
                            bxVar4.eCR = byVar;
                            bxVar4.position = i2;
                            if (y.getCount(byVar.bqY()) + y.getCount(byVar.bqZ()) == 1) {
                                bxVar4.eIM = true;
                            } else if (y.getCount(byVar.bqY()) + y.getCount(byVar.bqZ()) > 1) {
                                bxVar4.eIN = true;
                            }
                            arrayList2.add(bxVar4);
                        }
                        bx bxVar5 = new bx();
                        bxVar5.eIJ = true;
                        bxVar5.eCR = byVar;
                        bxVar5.position = i2;
                        arrayList2.add(bxVar5);
                        bx bxVar6 = new bx();
                        bxVar6.eIE = true;
                        bxVar6.eCR = byVar;
                        bxVar6.position = i2;
                        arrayList2.add(bxVar6);
                        i2++;
                    } else if (byVar.getType() == by.eJq) {
                        bx bxVar7 = new bx();
                        bxVar7.eCR = byVar;
                        bxVar7.position = i2;
                        bxVar7.eIy = true;
                        arrayList2.add(bxVar7);
                        bx bxVar8 = new bx();
                        bxVar8.eCR = byVar;
                        bxVar8.position = i2;
                        bxVar8.eIG = true;
                        arrayList2.add(bxVar8);
                        if (byVar.bqV() != null) {
                            bx bxVar9 = new bx();
                            bxVar9.eIK = true;
                            bxVar9.eCR = byVar;
                            bxVar9.position = i2;
                            arrayList2.add(bxVar9);
                        }
                        if (!y.isEmpty(byVar.bqY()) || !y.isEmpty(byVar.bqZ())) {
                            bx bxVar10 = new bx();
                            bxVar10.eCR = byVar;
                            bxVar10.position = i2;
                            if (y.getCount(byVar.bqY()) + y.getCount(byVar.bqZ()) == 1) {
                                bxVar10.eIM = true;
                            } else if (y.getCount(byVar.bqY()) + y.getCount(byVar.bqZ()) > 1) {
                                bxVar10.eIN = true;
                            }
                            arrayList2.add(bxVar10);
                        }
                        bx bxVar11 = new bx();
                        bxVar11.eIJ = true;
                        bxVar11.eCR = byVar;
                        bxVar11.position = i2;
                        arrayList2.add(bxVar11);
                        bx bxVar12 = new bx();
                        bxVar12.eIE = true;
                        bxVar12.eCR = byVar;
                        bxVar12.position = i2;
                        arrayList2.add(bxVar12);
                        i2++;
                    } else if (byVar.getType() == by.eJh && byVar.bnx()) {
                        byVar.position = i2;
                        arrayList2.add(byVar);
                        i2++;
                    } else {
                        bx bxVar13 = new bx();
                        bxVar13.eCR = byVar;
                        bxVar13.position = i2;
                        arrayList2.add(bxVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.iBF = i2;
        com.baidu.tbadk.a.a.a.bh(arrayList2);
        return arrayList2;
    }
}
