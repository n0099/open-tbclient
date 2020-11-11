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
    private boolean fNU;
    private int ipU;
    private int ipV;
    private b ipW;
    private int ipX;
    private HashMap<String, Integer> ipY;
    private com.baidu.tieba.enterForum.tabfeed.b.b ipZ;
    private a iqa;
    private bw iqb;
    private CustomMessageListener iqc;
    private CustomMessageListener iqd;
    private CustomMessageListener iqe;
    private final com.baidu.adp.framework.listener.a iqf;
    private boolean isLoading;
    private com.baidu.adp.framework.listener.a netMessageListener;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.ipZ != null) {
            ArrayList<q> csU = aVar.csU();
            this.ipZ.fNU = this.fNU;
            if (!this.fNU) {
                this.ipU++;
            } else {
                this.ipZ.refreshCount = z ? y.getCount(csU) : -1;
                e(csU, aVar.csV());
            }
            if (this.ipX + y.getCount(csU) > this.ipV) {
                this.ipZ.ipS = ctc();
            }
            ArrayList<q> aq = aq(switchThreadDataToThreadCardInfo(csU));
            if (this.fNU) {
                this.ipZ.ipR.addAll(0, aq);
                this.ipZ.ipS = 0;
            } else {
                this.ipZ.ipR.addAll(aq);
                this.ipZ.hasMore = !y.isEmpty(csU);
            }
            this.ipZ.akk = aVar.csY();
            this.ipZ.ipT = aVar.csX();
            this.ipZ.ipQ = aVar.csW();
            if (this.ipW != null) {
                this.ipW.a(this.ipZ);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.ipU = 1;
        this.fNU = true;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.ipZ != null && EnterForumTabFeedNetModel.this.ipZ.ipR != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.iqa = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.ipW.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.iqb != null) {
                        aVar.csU().add(0, EnterForumTabFeedNetModel.this.iqb);
                        if (EnterForumTabFeedNetModel.this.ipY != null && EnterForumTabFeedNetModel.this.ipY.containsKey(EnterForumTabFeedNetModel.this.iqb.getTid())) {
                            EnterForumTabFeedNetModel.this.ipY.remove(EnterForumTabFeedNetModel.this.iqb.getTid());
                        }
                        EnterForumTabFeedNetModel.this.iqb = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.iqc = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iqd = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.iqe = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
                    be beVar = (be) customResponsedMessage.getData();
                    if (beVar.eCw == 2 && beVar.tabName != null && beVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = au.bro().brp() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(beVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.iqf = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
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
                    EnterForumTabFeedNetModel.this.iqb = bwVar;
                    if (EnterForumTabFeedNetModel.this.iqa != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.netMessageListener);
        this.ipY = new HashMap<>();
        this.ipZ = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.ipW = bVar;
        this.ipV = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("home_page_max_thread_count", 300);
        registerListener(this.iqc);
        registerListener(this.iqd);
        this.iqf.setTag(getUniqueId());
        if (this.iqf.getHttpMessageListener() != null) {
            this.iqf.getHttpMessageListener().setSelfListener(true);
        }
        if (this.iqf.getSocketMessageListener() != null) {
            this.iqf.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.iqf);
    }

    public void cta() {
        registerListener(this.iqe);
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
        ctb();
        if (!y.isEmpty(arrayList) && !y.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<bq>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bq bqVar, bq bqVar2) {
                    if (bqVar.eCT == bqVar2.eCT) {
                        return 0;
                    }
                    return bqVar.eCT > bqVar2.eCT ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<bq> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    bq next = it.next();
                    int i3 = next.eCT + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.eCT != 0 && i3 <= arrayList.size()) {
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

    private void ctb() {
        if (!y.isEmpty(this.ipZ.ipR)) {
            int i = 0;
            Iterator<q> it = this.ipZ.ipR.iterator();
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

    private int ctc() {
        int i;
        if (this.ipZ == null || this.ipZ.ipR == null) {
            return 0;
        }
        if (!this.fNU) {
            i = 30;
        } else {
            i = this.ipX - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.ipX || i2 < 0 || i2 > this.ipX || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.ipZ.ipR.size()) {
                i3 = -1;
                break;
            }
            q qVar = this.ipZ.ipR.get(i3);
            if (qVar instanceof bv) {
                if (i4 == -1 && ((bv) qVar).position > i) {
                    i4 = i3;
                } else if (((bv) qVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bv) qVar).exA != null) {
                    this.ipY.remove(((bv) qVar).exA.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.ipZ.ipR.subList(0, i4));
        arrayList.addAll(this.ipZ.ipR.subList(i3, this.ipZ.ipR.size()));
        this.ipZ.ipR = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ipX > 0 && this.ipZ != null && !y.isEmpty(this.ipZ.ipR)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.ipY.containsKey(optString)) {
                Iterator<q> it = this.ipZ.ipR.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof bv) && ((bv) next).exA != null) {
                        if (i7 >= 0) {
                            if (((bv) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (at.equals(optString, ((bv) next).exA.getTid())) {
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
                    this.ipW.ci(i6, i5);
                }
            }
        }
    }

    public void bOI() {
        if (!this.isLoading) {
            this.fNU = false;
            xV(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.fNU = true;
            xV(1);
        }
    }

    private void xV(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.ipU + 1;
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
        return (this.ipZ == null || y.isEmpty(this.ipZ.ipR)) ? false : true;
    }

    private ArrayList<q> switchThreadDataToThreadCardInfo(ArrayList<q> arrayList) {
        int i = this.ipX;
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bq) {
                arrayList2.add(next);
            } else if (next instanceof bw) {
                bw bwVar = (bw) next;
                if (!this.ipY.containsKey(bwVar.getTid())) {
                    this.ipY.put(bwVar.getTid(), 0);
                    bwVar.eGS = true;
                    int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                    if (bwVar.getType() == bw.eDA) {
                        bv bvVar = new bv();
                        bvVar.exA = bwVar;
                        bvVar.position = i2;
                        bvVar.eDg = true;
                        arrayList2.add(bvVar);
                        bv bvVar2 = new bv();
                        bvVar2.exA = bwVar;
                        bvVar2.position = i2;
                        if (bwVar.bov()) {
                            bvVar2.eDl = true;
                        } else if (bwVar.bnG() == 1) {
                            bvVar2.eDj = true;
                            bvVar2.eDx = imageWidthAndHeight[0];
                            bvVar2.eDy = imageWidthAndHeight[1];
                        } else if (bwVar.bnG() >= 2) {
                            bvVar2.eDk = true;
                        } else {
                            bvVar2.eDh = true;
                        }
                        arrayList2.add(bvVar2);
                        if (bwVar.boD() != null) {
                            bv bvVar3 = new bv();
                            bvVar3.eDs = true;
                            bvVar3.exA = bwVar;
                            bvVar3.position = i2;
                            arrayList2.add(bvVar3);
                        }
                        if (!y.isEmpty(bwVar.boG()) || !y.isEmpty(bwVar.boH())) {
                            bv bvVar4 = new bv();
                            bvVar4.exA = bwVar;
                            bvVar4.position = i2;
                            if (y.getCount(bwVar.boG()) + y.getCount(bwVar.boH()) == 1) {
                                bvVar4.eDu = true;
                            } else if (y.getCount(bwVar.boG()) + y.getCount(bwVar.boH()) > 1) {
                                bvVar4.eDv = true;
                            }
                            arrayList2.add(bvVar4);
                        }
                        bv bvVar5 = new bv();
                        bvVar5.eDr = true;
                        bvVar5.exA = bwVar;
                        bvVar5.position = i2;
                        arrayList2.add(bvVar5);
                        bv bvVar6 = new bv();
                        bvVar6.eDm = true;
                        bvVar6.exA = bwVar;
                        bvVar6.position = i2;
                        arrayList2.add(bvVar6);
                        i2++;
                    } else if (bwVar.getType() == bw.eDW) {
                        bv bvVar7 = new bv();
                        bvVar7.exA = bwVar;
                        bvVar7.position = i2;
                        bvVar7.eDg = true;
                        arrayList2.add(bvVar7);
                        bv bvVar8 = new bv();
                        bvVar8.exA = bwVar;
                        bvVar8.position = i2;
                        bvVar8.eDo = true;
                        arrayList2.add(bvVar8);
                        if (bwVar.boD() != null) {
                            bv bvVar9 = new bv();
                            bvVar9.eDs = true;
                            bvVar9.exA = bwVar;
                            bvVar9.position = i2;
                            arrayList2.add(bvVar9);
                        }
                        if (!y.isEmpty(bwVar.boG()) || !y.isEmpty(bwVar.boH())) {
                            bv bvVar10 = new bv();
                            bvVar10.exA = bwVar;
                            bvVar10.position = i2;
                            if (y.getCount(bwVar.boG()) + y.getCount(bwVar.boH()) == 1) {
                                bvVar10.eDu = true;
                            } else if (y.getCount(bwVar.boG()) + y.getCount(bwVar.boH()) > 1) {
                                bvVar10.eDv = true;
                            }
                            arrayList2.add(bvVar10);
                        }
                        bv bvVar11 = new bv();
                        bvVar11.eDr = true;
                        bvVar11.exA = bwVar;
                        bvVar11.position = i2;
                        arrayList2.add(bvVar11);
                        bv bvVar12 = new bv();
                        bvVar12.eDm = true;
                        bvVar12.exA = bwVar;
                        bvVar12.position = i2;
                        arrayList2.add(bvVar12);
                        i2++;
                    } else if (bwVar.getType() == bw.eDO && bwVar.bli()) {
                        bwVar.position = i2;
                        arrayList2.add(bwVar);
                        i2++;
                    } else {
                        bv bvVar13 = new bv();
                        bvVar13.exA = bwVar;
                        bvVar13.position = i2;
                        arrayList2.add(bvVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.ipX = i2;
        com.baidu.tbadk.a.a.a.be(arrayList2);
        return arrayList2;
    }
}
