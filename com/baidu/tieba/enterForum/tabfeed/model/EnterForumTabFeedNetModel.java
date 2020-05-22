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
    private boolean eIo;
    private int gVS;
    private int gVT;
    private b gVU;
    private int gVV;
    private HashMap<String, Integer> gVW;
    private com.baidu.tieba.enterForum.tabfeed.b.b gVX;
    private a gVY;
    private bk gVZ;
    private com.baidu.adp.framework.listener.a gWa;
    private CustomMessageListener gWb;
    private CustomMessageListener gWc;
    private CustomMessageListener gWd;
    private final com.baidu.adp.framework.listener.a gWe;
    private boolean isLoading;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.gVX != null) {
            ArrayList<o> bPQ = aVar.bPQ();
            this.gVX.eIo = this.eIo;
            if (!this.eIo) {
                this.gVS++;
            } else {
                this.gVX.refreshCount = z ? v.getCount(bPQ) : -1;
                e(bPQ, aVar.bPR());
            }
            if (this.gVV + v.getCount(bPQ) > this.gVT) {
                this.gVX.gVO = bPY();
            }
            ArrayList<o> ag = ag(switchThreadDataToThreadCardInfo(bPQ));
            if (this.eIo) {
                this.gVX.gVN.addAll(0, ag);
                this.gVX.gVO = 0;
            } else {
                this.gVX.gVN.addAll(ag);
                this.gVX.hasMore = !v.isEmpty(bPQ);
            }
            this.gVX.aha = aVar.bPU();
            this.gVX.gVP = aVar.bPT();
            this.gVX.gVM = aVar.bPS();
            if (this.gVU != null) {
                this.gVU.a(this.gVX);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.gVS = 1;
        this.eIo = true;
        this.gWa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.gVX != null && EnterForumTabFeedNetModel.this.gVX.gVN != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.gVY = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.gVU.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.gVZ != null) {
                        aVar.bPQ().add(0, EnterForumTabFeedNetModel.this.gVZ);
                        if (EnterForumTabFeedNetModel.this.gVW != null && EnterForumTabFeedNetModel.this.gVW.containsKey(EnterForumTabFeedNetModel.this.gVZ.getTid())) {
                            EnterForumTabFeedNetModel.this.gVW.remove(EnterForumTabFeedNetModel.this.gVZ.getTid());
                        }
                        EnterForumTabFeedNetModel.this.gVZ = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.gWb = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.gWc = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.gWd = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ax)) {
                    ax axVar = (ax) customResponsedMessage.getData();
                    if (axVar.dDN == 2 && axVar.tabName != null && axVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = ar.aUW().aUX() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(axVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.gWe = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
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
                    EnterForumTabFeedNetModel.this.gVZ = bkVar;
                    if (EnterForumTabFeedNetModel.this.gVY != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.gWa.getHttpMessageListener().setSelfListener(true);
        this.gWa.getSocketMessageListener().setSelfListener(true);
        registerListener(this.gWa);
        this.gVW = new HashMap<>();
        this.gVX = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.gVU = bVar;
        this.gVT = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("home_page_max_thread_count", 300);
        registerListener(this.gWb);
        registerListener(this.gWc);
        this.gWe.setTag(getUniqueId());
        if (this.gWe.getHttpMessageListener() != null) {
            this.gWe.getHttpMessageListener().setSelfListener(true);
        }
        if (this.gWe.getSocketMessageListener() != null) {
            this.gWe.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.gWe);
    }

    public void bPW() {
        registerListener(this.gWd);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.gWa);
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
        bPX();
        if (!v.isEmpty(arrayList) && !v.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<d>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(d dVar, d dVar2) {
                    if (dVar.gVR == dVar2.gVR) {
                        return 0;
                    }
                    return dVar.gVR > dVar2.gVR ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<d> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    d next = it.next();
                    int i3 = next.gVR + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.gVR != 0 && i3 <= arrayList.size()) {
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

    private void bPX() {
        if (!v.isEmpty(this.gVX.gVN)) {
            int i = 0;
            Iterator<o> it = this.gVX.gVN.iterator();
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

    private int bPY() {
        int i;
        if (this.gVX == null || this.gVX.gVN == null) {
            return 0;
        }
        if (!this.eIo) {
            i = 30;
        } else {
            i = this.gVV - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.gVV || i2 < 0 || i2 > this.gVV || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.gVX.gVN.size()) {
                i3 = -1;
                break;
            }
            o oVar = this.gVX.gVN.get(i3);
            if (oVar instanceof bj) {
                if (i4 == -1 && ((bj) oVar).position > i) {
                    i4 = i3;
                } else if (((bj) oVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bj) oVar).dEA != null) {
                    this.gVW.remove(((bj) oVar).dEA.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<o> arrayList = new ArrayList<>();
        arrayList.addAll(this.gVX.gVN.subList(0, i4));
        arrayList.addAll(this.gVX.gVN.subList(i3, this.gVX.gVN.size()));
        this.gVX.gVN = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gVV > 0 && this.gVX != null && !v.isEmpty(this.gVX.gVN)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.gVW.containsKey(optString)) {
                Iterator<o> it = this.gVX.gVN.iterator();
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
                    this.gVU.bM(i6, i5);
                }
            }
        }
    }

    public void bqv() {
        if (!this.isLoading) {
            this.eIo = false;
            ta(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.eIo = true;
            ta(1);
        }
    }

    private void ta(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.gVS + 1;
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
        return (this.gVX == null || v.isEmpty(this.gVX.gVN)) ? false : true;
    }

    private ArrayList<o> switchThreadDataToThreadCardInfo(ArrayList<o> arrayList) {
        int i = this.gVV;
        ArrayList<o> arrayList2 = new ArrayList<>();
        Iterator<o> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            o next = it.next();
            if (next instanceof d) {
                arrayList2.add(next);
            } else if (next instanceof bk) {
                bk bkVar = (bk) next;
                if (!this.gVW.containsKey(bkVar.getTid())) {
                    this.gVW.put(bkVar.getTid(), 0);
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
        this.gVV = i2;
        return arrayList2;
    }
}
