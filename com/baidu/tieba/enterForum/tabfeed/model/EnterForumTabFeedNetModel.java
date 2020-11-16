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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean fNx;
    private int iqI;
    private int iqJ;
    private b iqK;
    private int iqL;
    private HashMap<String, Integer> iqM;
    private com.baidu.tieba.enterForum.tabfeed.b.b iqN;
    private a iqO;
    private bx iqP;
    private CustomMessageListener iqQ;
    private CustomMessageListener iqR;
    private CustomMessageListener iqS;
    private final com.baidu.adp.framework.listener.a iqT;
    private boolean isLoading;
    private com.baidu.adp.framework.listener.a netMessageListener;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.iqN != null) {
            ArrayList<q> csx = aVar.csx();
            this.iqN.fNx = this.fNx;
            if (!this.fNx) {
                this.iqI++;
            } else {
                this.iqN.refreshCount = z ? y.getCount(csx) : -1;
                e(csx, aVar.csy());
            }
            if (this.iqL + y.getCount(csx) > this.iqJ) {
                this.iqN.iqG = csF();
            }
            ArrayList<q> ar = ar(switchThreadDataToThreadCardInfo(csx));
            if (this.fNx) {
                this.iqN.iqF.addAll(0, ar);
                this.iqN.iqG = 0;
            } else {
                this.iqN.iqF.addAll(ar);
                this.iqN.hasMore = !y.isEmpty(csx);
            }
            this.iqN.akn = aVar.csB();
            this.iqN.iqH = aVar.csA();
            this.iqN.iqE = aVar.csz();
            if (this.iqK != null) {
                this.iqK.a(this.iqN);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.iqI = 1;
        this.fNx = true;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.iqN != null && EnterForumTabFeedNetModel.this.iqN.iqF != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.iqO = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.iqK.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.iqP != null) {
                        aVar.csx().add(0, EnterForumTabFeedNetModel.this.iqP);
                        if (EnterForumTabFeedNetModel.this.iqM != null && EnterForumTabFeedNetModel.this.iqM.containsKey(EnterForumTabFeedNetModel.this.iqP.getTid())) {
                            EnterForumTabFeedNetModel.this.iqM.remove(EnterForumTabFeedNetModel.this.iqP.getTid());
                        }
                        EnterForumTabFeedNetModel.this.iqP = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.iqQ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iqR = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iqS = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bf)) {
                    bf bfVar = (bf) customResponsedMessage.getData();
                    if (bfVar.eAN == 2 && bfVar.tabName != null && bfVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = av.bqC().bqD() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bfVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.iqT = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                GetMyPostResIdl getMyPostResIdl = null;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                }
                if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                    bx bxVar = new bx();
                    bxVar.a(getMyPostResIdl.data.thread_info);
                    EnterForumTabFeedNetModel.this.iqP = bxVar;
                    if (EnterForumTabFeedNetModel.this.iqO != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.netMessageListener);
        this.iqM = new HashMap<>();
        this.iqN = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.iqK = bVar;
        this.iqJ = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("home_page_max_thread_count", 300);
        registerListener(this.iqQ);
        registerListener(this.iqR);
        this.iqT.setTag(getUniqueId());
        if (this.iqT.getHttpMessageListener() != null) {
            this.iqT.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iqT.getSocketMessageListener() != null) {
            this.iqT.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.iqT);
    }

    public void csD() {
        registerListener(this.iqS);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }

    public void eM(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    private ArrayList<q> ar(ArrayList<q> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = true;
            Iterator<q> it = arrayList.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = !(it.next() instanceof br) ? false : z;
            }
            if (z) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    private void e(ArrayList<q> arrayList, ArrayList<br> arrayList2) {
        csE();
        if (!y.isEmpty(arrayList) && !y.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<br>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(br brVar, br brVar2) {
                    if (brVar.eBk == brVar2.eBk) {
                        return 0;
                    }
                    return brVar.eBk > brVar2.eBk ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<br> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    br next = it.next();
                    int i3 = next.eBk + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.eBk != 0 && i3 <= arrayList.size()) {
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

    private void csE() {
        if (!y.isEmpty(this.iqN.iqF)) {
            int i = 0;
            Iterator<q> it = this.iqN.iqF.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    if (it.next() instanceof br) {
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

    private int csF() {
        int i;
        if (this.iqN == null || this.iqN.iqF == null) {
            return 0;
        }
        if (!this.fNx) {
            i = 30;
        } else {
            i = this.iqL - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.iqL || i2 < 0 || i2 > this.iqL || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.iqN.iqF.size()) {
                i3 = -1;
                break;
            }
            q qVar = this.iqN.iqF.get(i3);
            if (qVar instanceof bw) {
                if (i4 == -1 && ((bw) qVar).position > i) {
                    i4 = i3;
                } else if (((bw) qVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bw) qVar).evQ != null) {
                    this.iqM.remove(((bw) qVar).evQ.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.iqN.iqF.subList(0, i4));
        arrayList.addAll(this.iqN.iqF.subList(i3, this.iqN.iqF.size()));
        this.iqN.iqF = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iqL > 0 && this.iqN != null && !y.isEmpty(this.iqN.iqF)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.iqM.containsKey(optString)) {
                Iterator<q> it = this.iqN.iqF.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof bw) && ((bw) next).evQ != null) {
                        if (i7 >= 0) {
                            if (((bw) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (au.equals(optString, ((bw) next).evQ.getTid())) {
                            int i8 = ((bw) next).position;
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
                    this.iqK.ci(i6, i5);
                }
            }
        }
    }

    public void bOb() {
        if (!this.isLoading) {
            this.fNx = false;
            yt(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.fNx = true;
            yt(1);
        }
    }

    private void yt(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.iqI + 1;
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
        return (this.iqN == null || y.isEmpty(this.iqN.iqF)) ? false : true;
    }

    private ArrayList<q> switchThreadDataToThreadCardInfo(ArrayList<q> arrayList) {
        int i = this.iqL;
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof br) {
                arrayList2.add(next);
            } else if (next instanceof bx) {
                bx bxVar = (bx) next;
                if (!this.iqM.containsKey(bxVar.getTid())) {
                    this.iqM.put(bxVar.getTid(), 0);
                    bxVar.eFk = true;
                    int[] imageWidthAndHeight = bxVar.getImageWidthAndHeight();
                    if (bxVar.getType() == bx.eBR) {
                        bw bwVar = new bw();
                        bwVar.evQ = bxVar;
                        bwVar.position = i2;
                        bwVar.eBx = true;
                        arrayList2.add(bwVar);
                        bw bwVar2 = new bw();
                        bwVar2.evQ = bxVar;
                        bwVar2.position = i2;
                        if (bxVar.bnz()) {
                            bwVar2.eBC = true;
                        } else if (bxVar.bmK() == 1) {
                            bwVar2.eBA = true;
                            bwVar2.eBO = imageWidthAndHeight[0];
                            bwVar2.eBP = imageWidthAndHeight[1];
                        } else if (bxVar.bmK() >= 2) {
                            bwVar2.eBB = true;
                        } else {
                            bwVar2.eBy = true;
                        }
                        arrayList2.add(bwVar2);
                        if (bxVar.bnH() != null) {
                            bw bwVar3 = new bw();
                            bwVar3.eBJ = true;
                            bwVar3.evQ = bxVar;
                            bwVar3.position = i2;
                            arrayList2.add(bwVar3);
                        }
                        if (!y.isEmpty(bxVar.bnK()) || !y.isEmpty(bxVar.bnL())) {
                            bw bwVar4 = new bw();
                            bwVar4.evQ = bxVar;
                            bwVar4.position = i2;
                            if (y.getCount(bxVar.bnK()) + y.getCount(bxVar.bnL()) == 1) {
                                bwVar4.eBL = true;
                            } else if (y.getCount(bxVar.bnK()) + y.getCount(bxVar.bnL()) > 1) {
                                bwVar4.eBM = true;
                            }
                            arrayList2.add(bwVar4);
                        }
                        bw bwVar5 = new bw();
                        bwVar5.eBI = true;
                        bwVar5.evQ = bxVar;
                        bwVar5.position = i2;
                        arrayList2.add(bwVar5);
                        bw bwVar6 = new bw();
                        bwVar6.eBD = true;
                        bwVar6.evQ = bxVar;
                        bwVar6.position = i2;
                        arrayList2.add(bwVar6);
                        i2++;
                    } else if (bxVar.getType() == bx.eCo) {
                        bw bwVar7 = new bw();
                        bwVar7.evQ = bxVar;
                        bwVar7.position = i2;
                        bwVar7.eBx = true;
                        arrayList2.add(bwVar7);
                        bw bwVar8 = new bw();
                        bwVar8.evQ = bxVar;
                        bwVar8.position = i2;
                        bwVar8.eBF = true;
                        arrayList2.add(bwVar8);
                        if (bxVar.bnH() != null) {
                            bw bwVar9 = new bw();
                            bwVar9.eBJ = true;
                            bwVar9.evQ = bxVar;
                            bwVar9.position = i2;
                            arrayList2.add(bwVar9);
                        }
                        if (!y.isEmpty(bxVar.bnK()) || !y.isEmpty(bxVar.bnL())) {
                            bw bwVar10 = new bw();
                            bwVar10.evQ = bxVar;
                            bwVar10.position = i2;
                            if (y.getCount(bxVar.bnK()) + y.getCount(bxVar.bnL()) == 1) {
                                bwVar10.eBL = true;
                            } else if (y.getCount(bxVar.bnK()) + y.getCount(bxVar.bnL()) > 1) {
                                bwVar10.eBM = true;
                            }
                            arrayList2.add(bwVar10);
                        }
                        bw bwVar11 = new bw();
                        bwVar11.eBI = true;
                        bwVar11.evQ = bxVar;
                        bwVar11.position = i2;
                        arrayList2.add(bwVar11);
                        bw bwVar12 = new bw();
                        bwVar12.eBD = true;
                        bwVar12.evQ = bxVar;
                        bwVar12.position = i2;
                        arrayList2.add(bwVar12);
                        i2++;
                    } else if (bxVar.getType() == bx.eCg && bxVar.bkk()) {
                        bxVar.position = i2;
                        arrayList2.add(bxVar);
                        i2++;
                    } else {
                        bw bwVar13 = new bw();
                        bwVar13.evQ = bxVar;
                        bwVar13.position = i2;
                        arrayList2.add(bwVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.iqL = i2;
        com.baidu.tbadk.a.a.a.be(arrayList2);
        return arrayList2;
    }
}
