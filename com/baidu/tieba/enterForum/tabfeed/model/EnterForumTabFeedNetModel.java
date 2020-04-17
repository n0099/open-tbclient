package com.baidu.tieba.enterForum.tabfeed.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.enterForum.tabfeed.b;
import com.baidu.tieba.enterForum.tabfeed.b.d;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    private boolean etK;
    private int gHf;
    private int gHg;
    private b gHh;
    private int gHi;
    private HashMap<String, Integer> gHj;
    private com.baidu.tieba.enterForum.tabfeed.b.b gHk;
    private a gHl;
    private CustomMessageListener gHm;
    private CustomMessageListener gHn;
    private boolean isLoading;
    private String tabCode;
    private String tabName;

    static /* synthetic */ int g(EnterForumTabFeedNetModel enterForumTabFeedNetModel) {
        int i = enterForumTabFeedNetModel.gHf;
        enterForumTabFeedNetModel.gHf = i + 1;
        return i;
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.isLoading = false;
        this.gHf = 1;
        this.etK = true;
        this.gHl = new a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                EnterForumTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null && EnterForumTabFeedNetModel.this.gHk != null && EnterForumTabFeedNetModel.this.gHk.gHa != null) {
                    com.baidu.tieba.enterForum.tabfeed.b.a aVar = null;
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else if (responsedMessage instanceof TabFeedListSocketResponsedMessage) {
                        aVar = ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData;
                    }
                    EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
                    if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                        EnterForumTabFeedNetModel.this.gHh.a(errorData);
                        return;
                    }
                    ArrayList<m> bJy = aVar.bJy();
                    EnterForumTabFeedNetModel.this.gHk.etK = EnterForumTabFeedNetModel.this.etK;
                    if (EnterForumTabFeedNetModel.this.etK) {
                        EnterForumTabFeedNetModel.this.gHk.refreshCount = v.getCount(bJy);
                        EnterForumTabFeedNetModel.this.e(bJy, aVar.bJz());
                    } else {
                        EnterForumTabFeedNetModel.g(EnterForumTabFeedNetModel.this);
                    }
                    if (EnterForumTabFeedNetModel.this.gHi + v.getCount(bJy) > EnterForumTabFeedNetModel.this.gHg) {
                        EnterForumTabFeedNetModel.this.gHk.gHb = EnterForumTabFeedNetModel.this.bJE();
                    }
                    ArrayList ag = EnterForumTabFeedNetModel.this.ag(EnterForumTabFeedNetModel.this.switchThreadDataToThreadCardInfo(bJy));
                    if (EnterForumTabFeedNetModel.this.etK) {
                        EnterForumTabFeedNetModel.this.gHk.gHa.addAll(0, ag);
                        EnterForumTabFeedNetModel.this.gHk.gHb = 0;
                    } else {
                        EnterForumTabFeedNetModel.this.gHk.gHa.addAll(ag);
                        EnterForumTabFeedNetModel.this.gHk.hasMore = v.isEmpty(bJy) ? false : true;
                    }
                    EnterForumTabFeedNetModel.this.gHk.agt = aVar.bJC();
                    EnterForumTabFeedNetModel.this.gHk.gHc = aVar.bJB();
                    EnterForumTabFeedNetModel.this.gHk.gGZ = aVar.bJA();
                    if (EnterForumTabFeedNetModel.this.gHh != null) {
                        EnterForumTabFeedNetModel.this.gHh.a(EnterForumTabFeedNetModel.this.gHk);
                    }
                }
            }
        };
        this.gHm = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        this.gHn = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                EnterForumTabFeedNetModel.this.g(customResponsedMessage);
            }
        };
        setUniqueId(bdUniqueId);
        this.gHl.getHttpMessageListener().setSelfListener(true);
        this.gHl.getSocketMessageListener().setSelfListener(true);
        registerListener(this.gHl);
        this.gHj = new HashMap<>();
        this.gHk = new com.baidu.tieba.enterForum.tabfeed.b.b();
        this.gHh = bVar;
        this.gHg = com.baidu.tbadk.core.sharedPref.b.aNV().getInt("home_page_max_thread_count", 300);
        registerListener(this.gHm);
        registerListener(this.gHn);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.gHl);
    }

    public void dw(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<m> ag(ArrayList<m> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z2 = true;
            Iterator<m> it = arrayList.iterator();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ArrayList<m> arrayList, ArrayList<d> arrayList2) {
        bJD();
        if (!v.isEmpty(arrayList) && !v.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<d>() { // from class: com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(d dVar, d dVar2) {
                    if (dVar.gHe == dVar2.gHe) {
                        return 0;
                    }
                    return dVar.gHe > dVar2.gHe ? 1 : -1;
                }
            });
            int i = 0;
            Iterator<d> it = arrayList2.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    d next = it.next();
                    int i3 = next.gHe + i2;
                    if (!TextUtils.isEmpty(next.res_image) && !TextUtils.isEmpty(next.res_link) && next.gHe != 0 && i3 <= arrayList.size()) {
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

    private void bJD() {
        if (!v.isEmpty(this.gHk.gHa)) {
            int i = 0;
            Iterator<m> it = this.gHk.gHa.iterator();
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

    /* JADX INFO: Access modifiers changed from: private */
    public int bJE() {
        int i;
        if (this.gHk == null || this.gHk.gHa == null) {
            return 0;
        }
        if (!this.etK) {
            i = 30;
        } else {
            i = this.gHi - 60;
        }
        int i2 = i + 30;
        if (i < 0 || i > this.gHi || i2 < 0 || i2 > this.gHi || i2 < i) {
            return 0;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            if (i3 >= this.gHk.gHa.size()) {
                i3 = -1;
                break;
            }
            m mVar = this.gHk.gHa.get(i3);
            if (mVar instanceof bi) {
                if (i4 == -1 && ((bi) mVar).position > i) {
                    i4 = i3;
                } else if (((bi) mVar).position > i2) {
                    break;
                }
                if (i4 > 0 && ((bi) mVar).dqA != null) {
                    this.gHj.remove(((bi) mVar).dqA.getTid());
                }
            }
            i3++;
            i4 = i4;
        }
        if (i4 >= i3 || i3 < 0 || i4 < 0) {
            return 0;
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.gHk.gHa.subList(0, i4));
        arrayList.addAll(this.gHk.gHa.subList(i3, this.gHk.gHa.size()));
        this.gHk.gHa = arrayList;
        return i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gHi > 0 && this.gHk != null && !v.isEmpty(this.gHk.gHa)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.gHj.containsKey(optString)) {
                Iterator<m> it = this.gHk.gHa.iterator();
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    m next = it.next();
                    if ((next instanceof bi) && ((bi) next).dqA != null) {
                        if (i7 >= 0) {
                            if (((bi) next).position != i7) {
                                break;
                            }
                            it.remove();
                            i = i4;
                            i2 = i6;
                            i3 = i7;
                        } else if (aq.equals(optString, ((bi) next).dqA.getTid())) {
                            int i8 = ((bi) next).position;
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
                    this.gHh.bI(i6, i5);
                }
            }
        }
    }

    public void blb() {
        if (!this.isLoading) {
            this.etK = false;
            sv(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.etK = true;
            sv(1);
        }
    }

    private void sv(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.gHf + 1;
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
        return (this.gHk == null || v.isEmpty(this.gHk.gHa)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<m> switchThreadDataToThreadCardInfo(ArrayList<m> arrayList) {
        int i = this.gHi;
        ArrayList<m> arrayList2 = new ArrayList<>();
        Iterator<m> it = arrayList.iterator();
        int i2 = i;
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof d) {
                arrayList2.add(next);
            } else if (next instanceof bj) {
                bj bjVar = (bj) next;
                if (!this.gHj.containsKey(bjVar.getTid())) {
                    this.gHj.put(bjVar.getTid(), 0);
                    int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                    if (bjVar.getType() == bj.dqE) {
                        bi biVar = new bi();
                        biVar.dqA = bjVar;
                        biVar.position = i2;
                        biVar.dqo = true;
                        arrayList2.add(biVar);
                        bi biVar2 = new bi();
                        biVar2.dqA = bjVar;
                        biVar2.position = i2;
                        if (bjVar.aMy()) {
                            biVar2.dqt = true;
                        } else if (bjVar.aLH() == 1) {
                            biVar2.dqr = true;
                            biVar2.dqB = imageWidthAndHeight[0];
                            biVar2.dqC = imageWidthAndHeight[1];
                        } else if (bjVar.aLH() >= 2) {
                            biVar2.dqs = true;
                        } else {
                            biVar2.dqp = true;
                        }
                        arrayList2.add(biVar2);
                        bi biVar3 = new bi();
                        biVar3.dqz = true;
                        biVar3.dqA = bjVar;
                        biVar3.position = i2;
                        arrayList2.add(biVar3);
                        bi biVar4 = new bi();
                        biVar4.dqu = true;
                        biVar4.dqA = bjVar;
                        biVar4.position = i2;
                        arrayList2.add(biVar4);
                        i2++;
                    } else if (bjVar.getType() == bj.dqV) {
                        bi biVar5 = new bi();
                        biVar5.dqA = bjVar;
                        biVar5.position = i2;
                        biVar5.dqo = true;
                        arrayList2.add(biVar5);
                        bi biVar6 = new bi();
                        biVar6.dqA = bjVar;
                        biVar6.position = i2;
                        biVar6.dqw = true;
                        arrayList2.add(biVar6);
                        bi biVar7 = new bi();
                        biVar7.dqz = true;
                        biVar7.dqA = bjVar;
                        biVar7.position = i2;
                        arrayList2.add(biVar7);
                        bi biVar8 = new bi();
                        biVar8.dqu = true;
                        biVar8.dqA = bjVar;
                        biVar8.position = i2;
                        arrayList2.add(biVar8);
                        i2++;
                    } else if (bjVar.getType() == bj.dqR && bjVar.aJt()) {
                        bjVar.position = i2;
                        arrayList2.add(bjVar);
                        i2++;
                    } else {
                        bi biVar9 = new bi();
                        biVar9.dqA = bjVar;
                        biVar9.position = i2;
                        arrayList2.add(biVar9);
                        i2++;
                    }
                }
            }
            i2 = i2;
        }
        this.gHi = i2;
        return arrayList2;
    }
}
