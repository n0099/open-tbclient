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
/* loaded from: classes21.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean fnv;
    private int hIA;
    private int hIB;
    private b hIC;
    private int hID;
    private HashMap<String, Integer> hIE;
    private com.baidu.tieba.enterForum.tabfeed.b.b hIF;
    private a hIG;
    private bw hIH;
    private CustomMessageListener hII;
    private CustomMessageListener hIJ;
    private CustomMessageListener hIK;
    private final com.baidu.adp.framework.listener.a hIL;
    private boolean isLoading;
    private com.baidu.adp.framework.listener.a netMessageListener;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.hIF != null) {
            ArrayList<q> cjQ = aVar.cjQ();
            this.hIF.fnv = this.fnv;
            if (!this.fnv) {
                this.hIA++;
            } else {
                this.hIF.refreshCount = z ? y.getCount(cjQ) : -1;
                e(cjQ, aVar.cjR());
            }
            if (this.hID + y.getCount(cjQ) > this.hIB) {
                this.hIF.hIy = cjY();
            }
            ArrayList<q> ap = ap(switchThreadDataToThreadCardInfo(cjQ));
            if (this.fnv) {
                this.hIF.hIx.addAll(0, ap);
                this.hIF.hIy = 0;
            } else {
                this.hIF.hIx.addAll(ap);
                this.hIF.hasMore = !y.isEmpty(cjQ);
            }
            this.hIF.ajR = aVar.cjU();
            this.hIF.hIz = aVar.cjT();
            this.hIF.hIw = aVar.cjS();
            if (this.hIC != null) {
                this.hIC.a(this.hIF);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.hIA = 1;
        this.fnv = true;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.hIF != null && EnterForumTabFeedNetModel.this.hIF.hIx != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.hIG = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.hIC.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.hIH != null) {
                        aVar.cjQ().add(0, EnterForumTabFeedNetModel.this.hIH);
                        if (EnterForumTabFeedNetModel.this.hIE != null && EnterForumTabFeedNetModel.this.hIE.containsKey(EnterForumTabFeedNetModel.this.hIH.getTid())) {
                            EnterForumTabFeedNetModel.this.hIE.remove(EnterForumTabFeedNetModel.this.hIH.getTid());
                        }
                        EnterForumTabFeedNetModel.this.hIH = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.hII = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.hIJ = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.hIK = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
                    be beVar = (be) customResponsedMessage.getData();
                    if (beVar.ecc == 2 && beVar.tabName != null && beVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = au.bkm().bkn() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(beVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.hIL = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
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
                    EnterForumTabFeedNetModel.this.hIH = bwVar;
                    if (EnterForumTabFeedNetModel.this.hIG != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.netMessageListener);
        this.hIE = new HashMap<>();
        this.hIF = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.hIC = bVar;
        this.hIB = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("home_page_max_thread_count", 300);
        registerListener(this.hII);
        registerListener(this.hIJ);
        this.hIL.setTag(getUniqueId());
        if (this.hIL.getHttpMessageListener() != null) {
            this.hIL.getHttpMessageListener().setSelfListener(true);
        }
        if (this.hIL.getSocketMessageListener() != null) {
            this.hIL.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.hIL);
    }

    public void cjW() {
        registerListener(this.hIK);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }

    public void eA(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    private ArrayList<q> ap(ArrayList<q> arrayList) {
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
        cjX();
        if (!y.isEmpty(arrayList) && !y.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<bq>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bq bqVar, bq bqVar2) {
                    if (bqVar.ecz == bqVar2.ecz) {
                        return 0;
                    }
                    return bqVar.ecz > bqVar2.ecz ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<bq> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    bq next = it.next();
                    int i3 = next.ecz + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.ecz != 0 && i3 <= arrayList.size()) {
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

    private void cjX() {
        if (!y.isEmpty(this.hIF.hIx)) {
            int i = 0;
            Iterator<q> it = this.hIF.hIx.iterator();
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

    private int cjY() {
        int i;
        if (this.hIF == null || this.hIF.hIx == null) {
            return 0;
        }
        if (!this.fnv) {
            i = 30;
        } else {
            i = this.hID - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.hID || i2 < 0 || i2 > this.hID || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.hIF.hIx.size()) {
                i3 = -1;
                break;
            }
            q qVar = this.hIF.hIx.get(i3);
            if (qVar instanceof bv) {
                if (i4 == -1 && ((bv) qVar).position > i) {
                    i4 = i3;
                } else if (((bv) qVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bv) qVar).dXg != null) {
                    this.hIE.remove(((bv) qVar).dXg.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.hIF.hIx.subList(0, i4));
        arrayList.addAll(this.hIF.hIx.subList(i3, this.hIF.hIx.size()));
        this.hIF.hIx = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hID > 0 && this.hIF != null && !y.isEmpty(this.hIF.hIx)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.hIE.containsKey(optString)) {
                Iterator<q> it = this.hIF.hIx.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof bv) && ((bv) next).dXg != null) {
                        if (i7 >= 0) {
                            if (((bv) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (at.equals(optString, ((bv) next).dXg.getTid())) {
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
                    this.hIC.ce(i6, i5);
                }
            }
        }
    }

    public void bGU() {
        if (!this.isLoading) {
            this.fnv = false;
            wJ(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.fnv = true;
            wJ(1);
        }
    }

    private void wJ(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.hIA + 1;
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
        return (this.hIF == null || y.isEmpty(this.hIF.hIx)) ? false : true;
    }

    private ArrayList<q> switchThreadDataToThreadCardInfo(ArrayList<q> arrayList) {
        int i = this.hID;
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bq) {
                arrayList2.add(next);
            } else if (next instanceof bw) {
                bw bwVar = (bw) next;
                if (!this.hIE.containsKey(bwVar.getTid())) {
                    this.hIE.put(bwVar.getTid(), 0);
                    bwVar.egx = true;
                    int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                    if (bwVar.getType() == bw.edg) {
                        bv bvVar = new bv();
                        bvVar.dXg = bwVar;
                        bvVar.position = i2;
                        bvVar.ecM = true;
                        arrayList2.add(bvVar);
                        bv bvVar2 = new bv();
                        bvVar2.dXg = bwVar;
                        bvVar2.position = i2;
                        if (bwVar.bht()) {
                            bvVar2.ecR = true;
                        } else if (bwVar.bgE() == 1) {
                            bvVar2.ecP = true;
                            bvVar2.edd = imageWidthAndHeight[0];
                            bvVar2.ede = imageWidthAndHeight[1];
                        } else if (bwVar.bgE() >= 2) {
                            bvVar2.ecQ = true;
                        } else {
                            bvVar2.ecN = true;
                        }
                        arrayList2.add(bvVar2);
                        if (bwVar.bhB() != null) {
                            bv bvVar3 = new bv();
                            bvVar3.ecY = true;
                            bvVar3.dXg = bwVar;
                            bvVar3.position = i2;
                            arrayList2.add(bvVar3);
                        }
                        if (!y.isEmpty(bwVar.bhE()) || !y.isEmpty(bwVar.bhF())) {
                            bv bvVar4 = new bv();
                            bvVar4.dXg = bwVar;
                            bvVar4.position = i2;
                            if (y.getCount(bwVar.bhE()) + y.getCount(bwVar.bhF()) == 1) {
                                bvVar4.eda = true;
                            } else if (y.getCount(bwVar.bhE()) + y.getCount(bwVar.bhF()) > 1) {
                                bvVar4.edb = true;
                            }
                            arrayList2.add(bvVar4);
                        }
                        bv bvVar5 = new bv();
                        bvVar5.ecX = true;
                        bvVar5.dXg = bwVar;
                        bvVar5.position = i2;
                        arrayList2.add(bvVar5);
                        bv bvVar6 = new bv();
                        bvVar6.ecS = true;
                        bvVar6.dXg = bwVar;
                        bvVar6.position = i2;
                        arrayList2.add(bvVar6);
                        i2++;
                    } else if (bwVar.getType() == bw.edC) {
                        bv bvVar7 = new bv();
                        bvVar7.dXg = bwVar;
                        bvVar7.position = i2;
                        bvVar7.ecM = true;
                        arrayList2.add(bvVar7);
                        bv bvVar8 = new bv();
                        bvVar8.dXg = bwVar;
                        bvVar8.position = i2;
                        bvVar8.ecU = true;
                        arrayList2.add(bvVar8);
                        if (bwVar.bhB() != null) {
                            bv bvVar9 = new bv();
                            bvVar9.ecY = true;
                            bvVar9.dXg = bwVar;
                            bvVar9.position = i2;
                            arrayList2.add(bvVar9);
                        }
                        if (!y.isEmpty(bwVar.bhE()) || !y.isEmpty(bwVar.bhF())) {
                            bv bvVar10 = new bv();
                            bvVar10.dXg = bwVar;
                            bvVar10.position = i2;
                            if (y.getCount(bwVar.bhE()) + y.getCount(bwVar.bhF()) == 1) {
                                bvVar10.eda = true;
                            } else if (y.getCount(bwVar.bhE()) + y.getCount(bwVar.bhF()) > 1) {
                                bvVar10.edb = true;
                            }
                            arrayList2.add(bvVar10);
                        }
                        bv bvVar11 = new bv();
                        bvVar11.ecX = true;
                        bvVar11.dXg = bwVar;
                        bvVar11.position = i2;
                        arrayList2.add(bvVar11);
                        bv bvVar12 = new bv();
                        bvVar12.ecS = true;
                        bvVar12.dXg = bwVar;
                        bvVar12.position = i2;
                        arrayList2.add(bvVar12);
                        i2++;
                    } else if (bwVar.getType() == bw.edu && bwVar.beg()) {
                        bwVar.position = i2;
                        arrayList2.add(bwVar);
                        i2++;
                    } else {
                        bv bvVar13 = new bv();
                        bvVar13.dXg = bwVar;
                        bvVar13.position = i2;
                        arrayList2.add(bvVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.hID = i2;
        com.baidu.tbadk.a.a.a.aK(arrayList2);
        return arrayList2;
    }
}
