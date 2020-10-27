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
/* loaded from: classes22.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean fIe;
    private int ijV;
    private int ijW;
    private b ijX;
    private int ijY;
    private HashMap<String, Integer> ijZ;
    private com.baidu.tieba.enterForum.tabfeed.b.b ika;
    private a ikb;
    private bw ikc;
    private CustomMessageListener ikd;
    private CustomMessageListener ike;
    private CustomMessageListener ikf;
    private final com.baidu.adp.framework.listener.a ikg;
    private boolean isLoading;
    private com.baidu.adp.framework.listener.a netMessageListener;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.ika != null) {
            ArrayList<q> cqt = aVar.cqt();
            this.ika.fIe = this.fIe;
            if (!this.fIe) {
                this.ijV++;
            } else {
                this.ika.refreshCount = z ? y.getCount(cqt) : -1;
                e(cqt, aVar.cqu());
            }
            if (this.ijY + y.getCount(cqt) > this.ijW) {
                this.ika.ijT = cqB();
            }
            ArrayList<q> aq = aq(switchThreadDataToThreadCardInfo(cqt));
            if (this.fIe) {
                this.ika.ijS.addAll(0, aq);
                this.ika.ijT = 0;
            } else {
                this.ika.ijS.addAll(aq);
                this.ika.hasMore = !y.isEmpty(cqt);
            }
            this.ika.akk = aVar.cqx();
            this.ika.ijU = aVar.cqw();
            this.ika.ijR = aVar.cqv();
            if (this.ijX != null) {
                this.ijX.a(this.ika);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.ijV = 1;
        this.fIe = true;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.ika != null && EnterForumTabFeedNetModel.this.ika.ijS != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.ikb = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.ijX.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.ikc != null) {
                        aVar.cqt().add(0, EnterForumTabFeedNetModel.this.ikc);
                        if (EnterForumTabFeedNetModel.this.ijZ != null && EnterForumTabFeedNetModel.this.ijZ.containsKey(EnterForumTabFeedNetModel.this.ikc.getTid())) {
                            EnterForumTabFeedNetModel.this.ijZ.remove(EnterForumTabFeedNetModel.this.ikc.getTid());
                        }
                        EnterForumTabFeedNetModel.this.ikc = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.ikd = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.ike = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.ikf = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
                    be beVar = (be) customResponsedMessage.getData();
                    if (beVar.ewE == 2 && beVar.tabName != null && beVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = au.boO().boP() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(beVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.ikg = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
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
                    EnterForumTabFeedNetModel.this.ikc = bwVar;
                    if (EnterForumTabFeedNetModel.this.ikb != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.netMessageListener);
        this.ijZ = new HashMap<>();
        this.ika = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.ijX = bVar;
        this.ijW = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("home_page_max_thread_count", 300);
        registerListener(this.ikd);
        registerListener(this.ike);
        this.ikg.setTag(getUniqueId());
        if (this.ikg.getHttpMessageListener() != null) {
            this.ikg.getHttpMessageListener().setSelfListener(true);
        }
        if (this.ikg.getSocketMessageListener() != null) {
            this.ikg.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.ikg);
    }

    public void cqz() {
        registerListener(this.ikf);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }

    public void eM(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    private ArrayList<q> aq(ArrayList<q> arrayList) {
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
        cqA();
        if (!y.isEmpty(arrayList) && !y.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<bq>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bq bqVar, bq bqVar2) {
                    if (bqVar.exb == bqVar2.exb) {
                        return 0;
                    }
                    return bqVar.exb > bqVar2.exb ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<bq> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    bq next = it.next();
                    int i3 = next.exb + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.exb != 0 && i3 <= arrayList.size()) {
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

    private void cqA() {
        if (!y.isEmpty(this.ika.ijS)) {
            int i = 0;
            Iterator<q> it = this.ika.ijS.iterator();
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

    private int cqB() {
        int i;
        if (this.ika == null || this.ika.ijS == null) {
            return 0;
        }
        if (!this.fIe) {
            i = 30;
        } else {
            i = this.ijY - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.ijY || i2 < 0 || i2 > this.ijY || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.ika.ijS.size()) {
                i3 = -1;
                break;
            }
            q qVar = this.ika.ijS.get(i3);
            if (qVar instanceof bv) {
                if (i4 == -1 && ((bv) qVar).position > i) {
                    i4 = i3;
                } else if (((bv) qVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bv) qVar).erH != null) {
                    this.ijZ.remove(((bv) qVar).erH.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.ika.ijS.subList(0, i4));
        arrayList.addAll(this.ika.ijS.subList(i3, this.ika.ijS.size()));
        this.ika.ijS = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ijY > 0 && this.ika != null && !y.isEmpty(this.ika.ijS)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.ijZ.containsKey(optString)) {
                Iterator<q> it = this.ika.ijS.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof bv) && ((bv) next).erH != null) {
                        if (i7 >= 0) {
                            if (((bv) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (at.equals(optString, ((bv) next).erH.getTid())) {
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
                    this.ijX.cg(i6, i5);
                }
            }
        }
    }

    public void bMi() {
        if (!this.isLoading) {
            this.fIe = false;
            xI(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.fIe = true;
            xI(1);
        }
    }

    private void xI(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.ijV + 1;
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
        return (this.ika == null || y.isEmpty(this.ika.ijS)) ? false : true;
    }

    private ArrayList<q> switchThreadDataToThreadCardInfo(ArrayList<q> arrayList) {
        int i = this.ijY;
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bq) {
                arrayList2.add(next);
            } else if (next instanceof bw) {
                bw bwVar = (bw) next;
                if (!this.ijZ.containsKey(bwVar.getTid())) {
                    this.ijZ.put(bwVar.getTid(), 0);
                    bwVar.eBd = true;
                    int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                    if (bwVar.getType() == bw.exJ) {
                        bv bvVar = new bv();
                        bvVar.erH = bwVar;
                        bvVar.position = i2;
                        bvVar.exo = true;
                        arrayList2.add(bvVar);
                        bv bvVar2 = new bv();
                        bvVar2.erH = bwVar;
                        bvVar2.position = i2;
                        if (bwVar.blV()) {
                            bvVar2.exu = true;
                        } else if (bwVar.blg() == 1) {
                            bvVar2.exr = true;
                            bvVar2.exG = imageWidthAndHeight[0];
                            bvVar2.exH = imageWidthAndHeight[1];
                        } else if (bwVar.blg() >= 2) {
                            bvVar2.exs = true;
                        } else {
                            bvVar2.exp = true;
                        }
                        arrayList2.add(bvVar2);
                        if (bwVar.bmd() != null) {
                            bv bvVar3 = new bv();
                            bvVar3.exB = true;
                            bvVar3.erH = bwVar;
                            bvVar3.position = i2;
                            arrayList2.add(bvVar3);
                        }
                        if (!y.isEmpty(bwVar.bmg()) || !y.isEmpty(bwVar.bmh())) {
                            bv bvVar4 = new bv();
                            bvVar4.erH = bwVar;
                            bvVar4.position = i2;
                            if (y.getCount(bwVar.bmg()) + y.getCount(bwVar.bmh()) == 1) {
                                bvVar4.exD = true;
                            } else if (y.getCount(bwVar.bmg()) + y.getCount(bwVar.bmh()) > 1) {
                                bvVar4.exE = true;
                            }
                            arrayList2.add(bvVar4);
                        }
                        bv bvVar5 = new bv();
                        bvVar5.exA = true;
                        bvVar5.erH = bwVar;
                        bvVar5.position = i2;
                        arrayList2.add(bvVar5);
                        bv bvVar6 = new bv();
                        bvVar6.exv = true;
                        bvVar6.erH = bwVar;
                        bvVar6.position = i2;
                        arrayList2.add(bvVar6);
                        i2++;
                    } else if (bwVar.getType() == bw.eyg) {
                        bv bvVar7 = new bv();
                        bvVar7.erH = bwVar;
                        bvVar7.position = i2;
                        bvVar7.exo = true;
                        arrayList2.add(bvVar7);
                        bv bvVar8 = new bv();
                        bvVar8.erH = bwVar;
                        bvVar8.position = i2;
                        bvVar8.exx = true;
                        arrayList2.add(bvVar8);
                        if (bwVar.bmd() != null) {
                            bv bvVar9 = new bv();
                            bvVar9.exB = true;
                            bvVar9.erH = bwVar;
                            bvVar9.position = i2;
                            arrayList2.add(bvVar9);
                        }
                        if (!y.isEmpty(bwVar.bmg()) || !y.isEmpty(bwVar.bmh())) {
                            bv bvVar10 = new bv();
                            bvVar10.erH = bwVar;
                            bvVar10.position = i2;
                            if (y.getCount(bwVar.bmg()) + y.getCount(bwVar.bmh()) == 1) {
                                bvVar10.exD = true;
                            } else if (y.getCount(bwVar.bmg()) + y.getCount(bwVar.bmh()) > 1) {
                                bvVar10.exE = true;
                            }
                            arrayList2.add(bvVar10);
                        }
                        bv bvVar11 = new bv();
                        bvVar11.exA = true;
                        bvVar11.erH = bwVar;
                        bvVar11.position = i2;
                        arrayList2.add(bvVar11);
                        bv bvVar12 = new bv();
                        bvVar12.exv = true;
                        bvVar12.erH = bwVar;
                        bvVar12.position = i2;
                        arrayList2.add(bvVar12);
                        i2++;
                    } else if (bwVar.getType() == bw.exX && bwVar.biI()) {
                        bwVar.position = i2;
                        arrayList2.add(bwVar);
                        i2++;
                    } else {
                        bv bvVar13 = new bv();
                        bvVar13.erH = bwVar;
                        bvVar13.position = i2;
                        arrayList2.add(bvVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.ijY = i2;
        com.baidu.tbadk.a.a.a.aX(arrayList2);
        return arrayList2;
    }
}
