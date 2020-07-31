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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes16.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean eZg;
    private int hoB;
    private int hoC;
    private b hoD;
    private int hoE;
    private HashMap<String, Integer> hoF;
    private com.baidu.tieba.enterForum.tabfeed.b.b hoG;
    private a hoH;
    private bv hoI;
    private CustomMessageListener hoJ;
    private CustomMessageListener hoK;
    private CustomMessageListener hoL;
    private final com.baidu.adp.framework.listener.a hoM;
    private boolean isLoading;
    private com.baidu.adp.framework.listener.a netMessageListener;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        if (aVar != null && this.hoG != null) {
            ArrayList<q> bWn = aVar.bWn();
            this.hoG.eZg = this.eZg;
            if (!this.eZg) {
                this.hoB++;
            } else {
                this.hoG.refreshCount = z ? x.getCount(bWn) : -1;
                e(bWn, aVar.bWo());
            }
            if (this.hoE + x.getCount(bWn) > this.hoC) {
                this.hoG.hoz = bWv();
            }
            ArrayList<q> ah = ah(switchThreadDataToThreadCardInfo(bWn));
            if (this.eZg) {
                this.hoG.hoy.addAll(0, ah);
                this.hoG.hoz = 0;
            } else {
                this.hoG.hoy.addAll(ah);
                this.hoG.hasMore = !x.isEmpty(bWn);
            }
            this.hoG.aib = aVar.bWr();
            this.hoG.hoA = aVar.bWq();
            this.hoG.hox = aVar.bWp();
            if (this.hoD != null) {
                this.hoD.a(this.hoG);
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.hoB = 1;
        this.eZg = true;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a aVar;
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.hoG != null && EnterForumTabFeedNetModel.this.hoG.hoy != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                    }
                    EnterForumTabFeedNetModel.this.hoH = aVar;
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.hoD.a(errorData);
                        return;
                    }
                    if (aVar != null && EnterForumTabFeedNetModel.this.hoI != null) {
                        aVar.bWn().add(0, EnterForumTabFeedNetModel.this.hoI);
                        if (EnterForumTabFeedNetModel.this.hoF != null && EnterForumTabFeedNetModel.this.hoF.containsKey(EnterForumTabFeedNetModel.this.hoI.getTid())) {
                            EnterForumTabFeedNetModel.this.hoF.remove(EnterForumTabFeedNetModel.this.hoI.getTid());
                        }
                        EnterForumTabFeedNetModel.this.hoI = null;
                    }
                    EnterForumTabFeedNetModel.this.a(aVar, true);
                }
            }
        };
        this.hoJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.hoK = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.hoL = new CustomMessageListener(2921453) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (bdVar.dQv == 2 && bdVar.tabName != null && bdVar.tabName.equals(EnterForumTabFeedNetModel.this.tabName)) {
                        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i = at.baS().baT() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(bdVar.tid, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                        requestGetMyPostNetMessage.setBFrom("push");
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }
        };
        this.hoM = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.6
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                GetMyPostResIdl getMyPostResIdl = null;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                }
                if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                    bv bvVar = new bv();
                    bvVar.a(getMyPostResIdl.data.thread_info);
                    EnterForumTabFeedNetModel.this.hoI = bvVar;
                    if (EnterForumTabFeedNetModel.this.hoH != null) {
                        EnterForumTabFeedNetModel.this.refresh();
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.netMessageListener);
        this.hoF = new HashMap<>();
        this.hoG = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.hoD = bVar;
        this.hoC = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("home_page_max_thread_count", 300);
        registerListener(this.hoJ);
        registerListener(this.hoK);
        this.hoM.setTag(getUniqueId());
        if (this.hoM.getHttpMessageListener() != null) {
            this.hoM.getHttpMessageListener().setSelfListener(true);
        }
        if (this.hoM.getSocketMessageListener() != null) {
            this.hoM.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.hoM);
    }

    public void bWt() {
        registerListener(this.hoL);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }

    public void ee(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    private ArrayList<q> ah(ArrayList<q> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = true;
            Iterator<q> it = arrayList.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = !(it.next() instanceof bp) ? false : z;
            }
            if (z) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    private void e(ArrayList<q> arrayList, ArrayList<bp> arrayList2) {
        bWu();
        if (!x.isEmpty(arrayList) && !x.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<bp>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bp bpVar, bp bpVar2) {
                    if (bpVar.dQR == bpVar2.dQR) {
                        return 0;
                    }
                    return bpVar.dQR > bpVar2.dQR ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<bp> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    bp next = it.next();
                    int i3 = next.dQR + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.dQR != 0 && i3 <= arrayList.size()) {
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

    private void bWu() {
        if (!x.isEmpty(this.hoG.hoy)) {
            int i = 0;
            Iterator<q> it = this.hoG.hoy.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    if (it.next() instanceof bp) {
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

    private int bWv() {
        int i;
        if (this.hoG == null || this.hoG.hoy == null) {
            return 0;
        }
        if (!this.eZg) {
            i = 30;
        } else {
            i = this.hoE - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.hoE || i2 < 0 || i2 > this.hoE || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.hoG.hoy.size()) {
                i3 = -1;
                break;
            }
            q qVar = this.hoG.hoy.get(i3);
            if (qVar instanceof bu) {
                if (i4 == -1 && ((bu) qVar).position > i) {
                    i4 = i3;
                } else if (((bu) qVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bu) qVar).dLK != null) {
                    this.hoF.remove(((bu) qVar).dLK.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.hoG.hoy.subList(0, i4));
        arrayList.addAll(this.hoG.hoy.subList(i3, this.hoG.hoy.size()));
        this.hoG.hoy = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hoE > 0 && this.hoG != null && !x.isEmpty(this.hoG.hoy)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.hoF.containsKey(optString)) {
                Iterator<q> it = this.hoG.hoy.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof bu) && ((bu) next).dLK != null) {
                        if (i7 >= 0) {
                            if (((bu) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (as.equals(optString, ((bu) next).dLK.getTid())) {
                            int i8 = ((bu) next).position;
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
                    this.hoD.bT(i6, i5);
                }
            }
        }
    }

    public void bwE() {
        if (!this.isLoading) {
            this.eZg = false;
            tV(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.eZg = true;
            tV(1);
        }
    }

    private void tV(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.hoB + 1;
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
        return (this.hoG == null || x.isEmpty(this.hoG.hoy)) ? false : true;
    }

    private ArrayList<q> switchThreadDataToThreadCardInfo(ArrayList<q> arrayList) {
        int i = this.hoE;
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bp) {
                arrayList2.add(next);
            } else if (next instanceof bv) {
                bv bvVar = (bv) next;
                if (!this.hoF.containsKey(bvVar.getTid())) {
                    this.hoF.put(bvVar.getTid(), 0);
                    bvVar.dUN = true;
                    int[] imageWidthAndHeight = bvVar.getImageWidthAndHeight();
                    if (bvVar.getType() == bv.dRx) {
                        bu buVar = new bu();
                        buVar.dLK = bvVar;
                        buVar.position = i2;
                        buVar.dRe = true;
                        arrayList2.add(buVar);
                        bu buVar2 = new bu();
                        buVar2.dLK = bvVar;
                        buVar2.position = i2;
                        if (bvVar.aYg()) {
                            buVar2.dRj = true;
                        } else if (bvVar.aXr() == 1) {
                            buVar2.dRh = true;
                            buVar2.dRu = imageWidthAndHeight[0];
                            buVar2.dRv = imageWidthAndHeight[1];
                        } else if (bvVar.aXr() >= 2) {
                            buVar2.dRi = true;
                        } else {
                            buVar2.dRf = true;
                        }
                        arrayList2.add(buVar2);
                        if (bvVar.aYo() != null) {
                            bu buVar3 = new bu();
                            buVar3.dRq = true;
                            buVar3.dLK = bvVar;
                            buVar3.position = i2;
                            arrayList2.add(buVar3);
                        }
                        if (!x.isEmpty(bvVar.aYr())) {
                            bu buVar4 = new bu();
                            buVar4.dLK = bvVar;
                            buVar4.position = i2;
                            if (x.getCount(bvVar.aYr()) == 1) {
                                buVar4.dRs = true;
                            } else {
                                buVar4.dRt = true;
                            }
                            arrayList2.add(buVar4);
                        }
                        bu buVar5 = new bu();
                        buVar5.dRp = true;
                        buVar5.dLK = bvVar;
                        buVar5.position = i2;
                        arrayList2.add(buVar5);
                        bu buVar6 = new bu();
                        buVar6.dRk = true;
                        buVar6.dLK = bvVar;
                        buVar6.position = i2;
                        arrayList2.add(buVar6);
                        i2++;
                    } else if (bvVar.getType() == bv.dRS) {
                        bu buVar7 = new bu();
                        buVar7.dLK = bvVar;
                        buVar7.position = i2;
                        buVar7.dRe = true;
                        arrayList2.add(buVar7);
                        bu buVar8 = new bu();
                        buVar8.dLK = bvVar;
                        buVar8.position = i2;
                        buVar8.dRm = true;
                        arrayList2.add(buVar8);
                        if (bvVar.aYo() != null) {
                            bu buVar9 = new bu();
                            buVar9.dRq = true;
                            buVar9.dLK = bvVar;
                            buVar9.position = i2;
                            arrayList2.add(buVar9);
                        }
                        if (!x.isEmpty(bvVar.aYr())) {
                            bu buVar10 = new bu();
                            buVar10.dLK = bvVar;
                            buVar10.position = i2;
                            if (x.getCount(bvVar.aYr()) == 1) {
                                buVar10.dRs = true;
                            } else {
                                buVar10.dRt = true;
                            }
                            arrayList2.add(buVar10);
                        }
                        bu buVar11 = new bu();
                        buVar11.dRp = true;
                        buVar11.dLK = bvVar;
                        buVar11.position = i2;
                        arrayList2.add(buVar11);
                        bu buVar12 = new bu();
                        buVar12.dRk = true;
                        buVar12.dLK = bvVar;
                        buVar12.position = i2;
                        arrayList2.add(buVar12);
                        i2++;
                    } else if (bvVar.getType() == bv.dRK && bvVar.aUT()) {
                        bvVar.position = i2;
                        arrayList2.add(bvVar);
                        i2++;
                    } else {
                        bu buVar13 = new bu();
                        buVar13.dLK = bvVar;
                        buVar13.position = i2;
                        arrayList2.add(buVar13);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.hoE = i2;
        com.baidu.tbadk.a.a.a.aG(arrayList2);
        return arrayList2;
    }
}
