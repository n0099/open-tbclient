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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes9.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean eSL;
    private int hiS;
    private int hiT;
    private b hiU;
    private int hiV;
    private HashMap<String, Integer> hiW;
    private com.baidu.tieba.enterForum.tabfeed.b.b hiX;
    private a hiY;
    private bu hiZ;
    private com.baidu.adp.framework.listener.a hja;
    private CustomMessageListener hjb;
    private CustomMessageListener hjc;
    private CustomMessageListener hjd;
    private final com.baidu.adp.framework.listener.a hje;
    private boolean isLoading;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.hiX != null) {
            ArrayList<q> bSW = aVar.bSW();
            this.hiX.eSL = this.eSL;
            if (!this.eSL) {
                this.hiS++;
            } else {
                this.hiX.refreshCount = z ? w.getCount(bSW) : -1;
                e(bSW, aVar.bSX());
            }
            if (this.hiV + w.getCount(bSW) > this.hiT) {
                this.hiX.hiQ = bTe();
            }
            ArrayList<q> ag = ag(switchThreadDataToThreadCardInfo(bSW));
            if (this.eSL) {
                this.hiX.hiP.addAll(0, ag);
                this.hiX.hiQ = 0;
            } else {
                this.hiX.hiP.addAll(ag);
                this.hiX.hasMore = !w.isEmpty(bSW);
            }
            this.hiX.aik = aVar.bTa();
            this.hiX.hiR = aVar.bSZ();
            this.hiX.hiO = aVar.bSY();
            if (this.hiU != null) {
                this.hiU.a(this.hiX);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.hiS = 1;
        this.eSL = true;
        this.hja = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.hiX != null && EnterForumTabFeedNetModel.this.hiX.hiP != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.hiY = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.hiU.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.hiZ != null) {
                        aVar.bSW().add(0, EnterForumTabFeedNetModel.this.hiZ);
                        if (EnterForumTabFeedNetModel.this.hiW != null && EnterForumTabFeedNetModel.this.hiW.containsKey(EnterForumTabFeedNetModel.this.hiZ.getTid())) {
                            EnterForumTabFeedNetModel.this.hiW.remove(EnterForumTabFeedNetModel.this.hiZ.getTid());
                        }
                        EnterForumTabFeedNetModel.this.hiZ = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.hjb = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.hjc = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.hjd = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bc)) {
                    bc bcVar = (bc) customResponsedMessage.getData();
                    if (bcVar.dKj == 2 && bcVar.tabName != null && bcVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = as.aWR().aWS() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bcVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.hje = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                GetMyPostResIdl getMyPostResIdl = null;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                }
                if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                    bu buVar = new bu();
                    buVar.a(getMyPostResIdl.data.thread_info);
                    EnterForumTabFeedNetModel.this.hiZ = buVar;
                    if (EnterForumTabFeedNetModel.this.hiY != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.hja.getHttpMessageListener().setSelfListener(true);
        this.hja.getSocketMessageListener().setSelfListener(true);
        registerListener(this.hja);
        this.hiW = new HashMap<>();
        this.hiX = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.hiU = bVar;
        this.hiT = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("home_page_max_thread_count", 300);
        registerListener(this.hjb);
        registerListener(this.hjc);
        this.hje.setTag(getUniqueId());
        if (this.hje.getHttpMessageListener() != null) {
            this.hje.getHttpMessageListener().setSelfListener(true);
        }
        if (this.hje.getSocketMessageListener() != null) {
            this.hje.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.hje);
    }

    public void bTc() {
        registerListener(this.hjd);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.hja);
    }

    public void ec(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    private ArrayList<q> ag(ArrayList<q> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = true;
            Iterator<q> it = arrayList.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = !(it.next() instanceof bo) ? false : z;
            }
            if (z) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    private void e(ArrayList<q> arrayList, ArrayList<bo> arrayList2) {
        bTd();
        if (!w.isEmpty(arrayList) && !w.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<bo>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bo boVar, bo boVar2) {
                    if (boVar.dKF == boVar2.dKF) {
                        return 0;
                    }
                    return boVar.dKF > boVar2.dKF ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<bo> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    bo next = it.next();
                    int i3 = next.dKF + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.dKF != 0 && i3 <= arrayList.size()) {
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

    private void bTd() {
        if (!w.isEmpty(this.hiX.hiP)) {
            int i = 0;
            Iterator<q> it = this.hiX.hiP.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    if (it.next() instanceof bo) {
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

    private int bTe() {
        int i;
        if (this.hiX == null || this.hiX.hiP == null) {
            return 0;
        }
        if (!this.eSL) {
            i = 30;
        } else {
            i = this.hiV - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.hiV || i2 < 0 || i2 > this.hiV || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.hiX.hiP.size()) {
                i3 = -1;
                break;
            }
            q qVar = this.hiX.hiP.get(i3);
            if (qVar instanceof bt) {
                if (i4 == -1 && ((bt) qVar).position > i) {
                    i4 = i3;
                } else if (((bt) qVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bt) qVar).dLi != null) {
                    this.hiW.remove(((bt) qVar).dLi.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.hiX.hiP.subList(0, i4));
        arrayList.addAll(this.hiX.hiP.subList(i3, this.hiX.hiP.size()));
        this.hiX.hiP = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hiV > 0 && this.hiX != null && !w.isEmpty(this.hiX.hiP)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.hiW.containsKey(optString)) {
                Iterator<q> it = this.hiX.hiP.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof bt) && ((bt) next).dLi != null) {
                        if (i7 >= 0) {
                            if (((bt) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (ar.equals(optString, ((bt) next).dLi.getTid())) {
                            int i8 = ((bt) next).position;
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
                    this.hiU.bQ(i6, i5);
                }
            }
        }
    }

    public void btv() {
        if (!this.isLoading) {
            this.eSL = false;
            tD(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.eSL = true;
            tD(1);
        }
    }

    private void tD(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.hiS + 1;
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
        return (this.hiX == null || w.isEmpty(this.hiX.hiP)) ? false : true;
    }

    private ArrayList<q> switchThreadDataToThreadCardInfo(ArrayList<q> arrayList) {
        int i = this.hiV;
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bo) {
                arrayList2.add(next);
            } else if (next instanceof bu) {
                bu buVar = (bu) next;
                if (!this.hiW.containsKey(buVar.getTid())) {
                    this.hiW.put(buVar.getTid(), 0);
                    int[] imageWidthAndHeight = buVar.getImageWidthAndHeight();
                    if (buVar.getType() == bu.dLm) {
                        bt btVar = new bt();
                        btVar.dLi = buVar;
                        btVar.position = i2;
                        btVar.dKS = true;
                        arrayList2.add(btVar);
                        bt btVar2 = new bt();
                        btVar2.dLi = buVar;
                        btVar2.position = i2;
                        if (buVar.aUl()) {
                            btVar2.dKX = true;
                        } else if (buVar.aTv() == 1) {
                            btVar2.dKV = true;
                            btVar2.dLj = imageWidthAndHeight[0];
                            btVar2.dLk = imageWidthAndHeight[1];
                        } else if (buVar.aTv() >= 2) {
                            btVar2.dKW = true;
                        } else {
                            btVar2.dKT = true;
                        }
                        arrayList2.add(btVar2);
                        if (buVar.aUu() != null) {
                            bt btVar3 = new bt();
                            btVar3.dLe = true;
                            btVar3.dLi = buVar;
                            btVar3.position = i2;
                            arrayList2.add(btVar3);
                        }
                        if (!w.isEmpty(buVar.aUx())) {
                            bt btVar4 = new bt();
                            btVar4.dLi = buVar;
                            btVar4.position = i2;
                            if (w.getCount(buVar.aUx()) == 1) {
                                btVar4.dLg = true;
                            } else {
                                btVar4.dLh = true;
                            }
                            arrayList2.add(btVar4);
                        }
                        bt btVar5 = new bt();
                        btVar5.dLd = true;
                        btVar5.dLi = buVar;
                        btVar5.position = i2;
                        arrayList2.add(btVar5);
                        bt btVar6 = new bt();
                        btVar6.dKY = true;
                        btVar6.dLi = buVar;
                        btVar6.position = i2;
                        arrayList2.add(btVar6);
                        i2++;
                    } else if (buVar.getType() == bu.dLH) {
                        bt btVar7 = new bt();
                        btVar7.dLi = buVar;
                        btVar7.position = i2;
                        btVar7.dKS = true;
                        arrayList2.add(btVar7);
                        bt btVar8 = new bt();
                        btVar8.dLi = buVar;
                        btVar8.position = i2;
                        btVar8.dLa = true;
                        arrayList2.add(btVar8);
                        if (buVar.aUu() != null) {
                            bt btVar9 = new bt();
                            btVar9.dLe = true;
                            btVar9.dLi = buVar;
                            btVar9.position = i2;
                            arrayList2.add(btVar9);
                        }
                        if (!w.isEmpty(buVar.aUx())) {
                            bt btVar10 = new bt();
                            btVar10.dLi = buVar;
                            btVar10.position = i2;
                            if (w.getCount(buVar.aUx()) == 1) {
                                btVar10.dLg = true;
                            } else {
                                btVar10.dLh = true;
                            }
                            arrayList2.add(btVar10);
                        }
                        bt btVar11 = new bt();
                        btVar11.dLd = true;
                        btVar11.dLi = buVar;
                        btVar11.position = i2;
                        arrayList2.add(btVar11);
                        bt btVar12 = new bt();
                        btVar12.dKY = true;
                        btVar12.dLi = buVar;
                        btVar12.position = i2;
                        arrayList2.add(btVar12);
                        i2++;
                    } else if (buVar.getType() == bu.dLz && buVar.aQX()) {
                        buVar.position = i2;
                        arrayList2.add(buVar);
                        i2++;
                    } else {
                        bt btVar13 = new bt();
                        btVar13.dLi = buVar;
                        btVar13.position = i2;
                        arrayList2.add(btVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.hiV = i2;
        return arrayList2;
    }
}
