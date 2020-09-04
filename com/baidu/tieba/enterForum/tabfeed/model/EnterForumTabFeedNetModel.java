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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes16.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean fkC;
    private b hBA;
    private int hBB;
    private HashMap<String, Integer> hBC;
    private com.baidu.tieba.enterForum.tabfeed.b.b hBD;
    private a hBE;
    private bw hBF;
    private CustomMessageListener hBG;
    private CustomMessageListener hBH;
    private CustomMessageListener hBI;
    private final com.baidu.adp.framework.listener.a hBJ;
    private int hBy;
    private int hBz;
    private boolean isLoading;
    private com.baidu.adp.framework.listener.a netMessageListener;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.hBD != null) {
            ArrayList<q> cgB = aVar.cgB();
            this.hBD.fkC = this.fkC;
            if (!this.fkC) {
                this.hBy++;
            } else {
                this.hBD.refreshCount = z ? y.getCount(cgB) : -1;
                e(cgB, aVar.cgC());
            }
            if (this.hBB + y.getCount(cgB) > this.hBz) {
                this.hBD.hBw = cgJ();
            }
            ArrayList<q> an = an(switchThreadDataToThreadCardInfo(cgB));
            if (this.fkC) {
                this.hBD.hBv.addAll(0, an);
                this.hBD.hBw = 0;
            } else {
                this.hBD.hBv.addAll(an);
                this.hBD.hasMore = !y.isEmpty(cgB);
            }
            this.hBD.ajt = aVar.cgF();
            this.hBD.hBx = aVar.cgE();
            this.hBD.hBu = aVar.cgD();
            if (this.hBA != null) {
                this.hBA.a(this.hBD);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.hBy = 1;
        this.fkC = true;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.hBD != null && EnterForumTabFeedNetModel.this.hBD.hBv != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.hBE = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.hBA.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.hBF != null) {
                        aVar.cgB().add(0, EnterForumTabFeedNetModel.this.hBF);
                        if (EnterForumTabFeedNetModel.this.hBC != null && EnterForumTabFeedNetModel.this.hBC.containsKey(EnterForumTabFeedNetModel.this.hBF.getTid())) {
                            EnterForumTabFeedNetModel.this.hBC.remove(EnterForumTabFeedNetModel.this.hBF.getTid());
                        }
                        EnterForumTabFeedNetModel.this.hBF = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.hBG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.hBH = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.hBI = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
                    be beVar = (be) customResponsedMessage.getData();
                    if (beVar.dZS == 2 && beVar.tabName != null && beVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = au.bjr().bjs() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(beVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.hBJ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                GetMyPostResIdl getMyPostResIdl = null;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                }
                if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                    bw bwVar = new bw();
                    bwVar.a(getMyPostResIdl.data.thread_info);
                    EnterForumTabFeedNetModel.this.hBF = bwVar;
                    if (EnterForumTabFeedNetModel.this.hBE != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.netMessageListener);
        this.hBC = new HashMap<>();
        this.hBD = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.hBA = bVar;
        this.hBz = com.baidu.tbadk.core.sharedPref.b.bik().getInt("home_page_max_thread_count", 300);
        registerListener(this.hBG);
        registerListener(this.hBH);
        this.hBJ.setTag(getUniqueId());
        if (this.hBJ.getHttpMessageListener() != null) {
            this.hBJ.getHttpMessageListener().setSelfListener(true);
        }
        if (this.hBJ.getSocketMessageListener() != null) {
            this.hBJ.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.hBJ);
    }

    public void cgH() {
        registerListener(this.hBI);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }

    public void ew(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    private ArrayList<q> an(ArrayList<q> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = true;
            Iterator<q> it = arrayList.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = !(it.next() instanceof bq) ? false : z;
            }
            if (z) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    private void e(ArrayList<q> arrayList, ArrayList<bq> arrayList2) {
        cgI();
        if (!y.isEmpty(arrayList) && !y.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<bq>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bq bqVar, bq bqVar2) {
                    if (bqVar.eap == bqVar2.eap) {
                        return 0;
                    }
                    return bqVar.eap > bqVar2.eap ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<bq> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    bq next = it.next();
                    int i3 = next.eap + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.eap != 0 && i3 <= arrayList.size()) {
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

    private void cgI() {
        if (!y.isEmpty(this.hBD.hBv)) {
            int i = 0;
            Iterator<q> it = this.hBD.hBv.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    if (it.next() instanceof bq) {
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

    private int cgJ() {
        int i;
        if (this.hBD == null || this.hBD.hBv == null) {
            return 0;
        }
        if (!this.fkC) {
            i = 30;
        } else {
            i = this.hBB - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.hBB || i2 < 0 || i2 > this.hBB || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.hBD.hBv.size()) {
                i3 = -1;
                break;
            }
            q qVar = this.hBD.hBv.get(i3);
            if (qVar instanceof bv) {
                if (i4 == -1 && ((bv) qVar).position > i) {
                    i4 = i3;
                } else if (((bv) qVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bv) qVar).dUW != null) {
                    this.hBC.remove(((bv) qVar).dUW.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.hBD.hBv.subList(0, i4));
        arrayList.addAll(this.hBD.hBv.subList(i3, this.hBD.hBv.size()));
        this.hBD.hBv = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hBB > 0 && this.hBD != null && !y.isEmpty(this.hBD.hBv)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.hBC.containsKey(optString)) {
                Iterator<q> it = this.hBD.hBv.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof bv) && ((bv) next).dUW != null) {
                        if (i7 >= 0) {
                            if (((bv) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (at.equals(optString, ((bv) next).dUW.getTid())) {
                            int i8 = ((bv) next).position;
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
                    this.hBA.cb(i6, i5);
                }
            }
        }
    }

    public void bFE() {
        if (!this.isLoading) {
            this.fkC = false;
            wk(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.fkC = true;
            wk(1);
        }
    }

    private void wk(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.hBy + 1;
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
        return (this.hBD == null || y.isEmpty(this.hBD.hBv)) ? false : true;
    }

    private ArrayList<q> switchThreadDataToThreadCardInfo(ArrayList<q> arrayList) {
        int i = this.hBB;
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bq) {
                arrayList2.add(next);
            } else if (next instanceof bw) {
                bw bwVar = (bw) next;
                if (!this.hBC.containsKey(bwVar.getTid())) {
                    this.hBC.put(bwVar.getTid(), 0);
                    bwVar.een = true;
                    int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                    if (bwVar.getType() == bw.eaW) {
                        bv bvVar = new bv();
                        bvVar.dUW = bwVar;
                        bvVar.position = i2;
                        bvVar.eaC = true;
                        arrayList2.add(bvVar);
                        bv bvVar2 = new bv();
                        bvVar2.dUW = bwVar;
                        bvVar2.position = i2;
                        if (bwVar.bgz()) {
                            bvVar2.eaH = true;
                        } else if (bwVar.bfK() == 1) {
                            bvVar2.eaF = true;
                            bvVar2.eaT = imageWidthAndHeight[0];
                            bvVar2.eaU = imageWidthAndHeight[1];
                        } else if (bwVar.bfK() >= 2) {
                            bvVar2.eaG = true;
                        } else {
                            bvVar2.eaD = true;
                        }
                        arrayList2.add(bvVar2);
                        if (bwVar.bgH() != null) {
                            bv bvVar3 = new bv();
                            bvVar3.eaO = true;
                            bvVar3.dUW = bwVar;
                            bvVar3.position = i2;
                            arrayList2.add(bvVar3);
                        }
                        if (!y.isEmpty(bwVar.bgK()) || !y.isEmpty(bwVar.bgL())) {
                            bv bvVar4 = new bv();
                            bvVar4.dUW = bwVar;
                            bvVar4.position = i2;
                            if (y.getCount(bwVar.bgK()) + y.getCount(bwVar.bgL()) == 1) {
                                bvVar4.eaQ = true;
                            } else if (y.getCount(bwVar.bgK()) + y.getCount(bwVar.bgL()) > 1) {
                                bvVar4.eaR = true;
                            }
                            arrayList2.add(bvVar4);
                        }
                        bv bvVar5 = new bv();
                        bvVar5.eaN = true;
                        bvVar5.dUW = bwVar;
                        bvVar5.position = i2;
                        arrayList2.add(bvVar5);
                        bv bvVar6 = new bv();
                        bvVar6.eaI = true;
                        bvVar6.dUW = bwVar;
                        bvVar6.position = i2;
                        arrayList2.add(bvVar6);
                        i2++;
                    } else if (bwVar.getType() == bw.ebs) {
                        bv bvVar7 = new bv();
                        bvVar7.dUW = bwVar;
                        bvVar7.position = i2;
                        bvVar7.eaC = true;
                        arrayList2.add(bvVar7);
                        bv bvVar8 = new bv();
                        bvVar8.dUW = bwVar;
                        bvVar8.position = i2;
                        bvVar8.eaK = true;
                        arrayList2.add(bvVar8);
                        if (bwVar.bgH() != null) {
                            bv bvVar9 = new bv();
                            bvVar9.eaO = true;
                            bvVar9.dUW = bwVar;
                            bvVar9.position = i2;
                            arrayList2.add(bvVar9);
                        }
                        if (!y.isEmpty(bwVar.bgK()) || !y.isEmpty(bwVar.bgL())) {
                            bv bvVar10 = new bv();
                            bvVar10.dUW = bwVar;
                            bvVar10.position = i2;
                            if (y.getCount(bwVar.bgK()) + y.getCount(bwVar.bgL()) == 1) {
                                bvVar10.eaQ = true;
                            } else if (y.getCount(bwVar.bgK()) + y.getCount(bwVar.bgL()) > 1) {
                                bvVar10.eaR = true;
                            }
                            arrayList2.add(bvVar10);
                        }
                        bv bvVar11 = new bv();
                        bvVar11.eaN = true;
                        bvVar11.dUW = bwVar;
                        bvVar11.position = i2;
                        arrayList2.add(bvVar11);
                        bv bvVar12 = new bv();
                        bvVar12.eaI = true;
                        bvVar12.dUW = bwVar;
                        bvVar12.position = i2;
                        arrayList2.add(bvVar12);
                        i2++;
                    } else if (bwVar.getType() == bw.ebk && bwVar.bdm()) {
                        bwVar.position = i2;
                        arrayList2.add(bwVar);
                        i2++;
                    } else {
                        bv bvVar13 = new bv();
                        bvVar13.dUW = bwVar;
                        bvVar13.position = i2;
                        arrayList2.add(bvVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.hBB = i2;
        com.baidu.tbadk.a.a.a.aG(arrayList2);
        return arrayList2;
    }
}
