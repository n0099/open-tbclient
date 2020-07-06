package com.baidu.tieba.forumsearch.controller;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.forumsearch.controller.d;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private long aZe;
    private ArrayList<q> gZU;
    private String hxA;
    private OriginalThreadInfo.ShareInfo hxB;
    private String hxC;
    private String hxD;
    private String hxE;
    private String hxF;
    private String hxG;
    private View.OnClickListener hxH = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.i(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.a(bVar);
                    TiebaStatic.log(new ao("c12609").s("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.eg(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable hxI = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.hxx.hxO);
        }
    };
    private CustomMessageListener hxJ = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.hxx.hxO.setText(str);
                b.this.hxx.hxO.setSelection(str.length());
                b.this.bWK();
            }
        }
    };
    private CustomMessageListener hxK = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bWL();
            }
        }
    };
    private d.a hxL = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || w.isEmpty(cVar.bWU())) {
                if (StringUtils.isNull(b.this.hxA)) {
                    b.this.bWL();
                    return;
                } else {
                    b.this.bWI();
                    return;
                }
            }
            b.this.gZU = cVar.bWU();
            b.this.setDatas(b.this.gZU);
        }
    };
    private final c hxx;
    private final d hxy;
    private final a hxz;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hxx = new c(tbPageContext);
        bWJ();
        this.hxy = new d(tbPageContext, tbPageContext.getUniqueId());
        this.hxy.a(this.hxL);
        this.gZU = new ArrayList<>();
        this.hxz = new a(tbPageContext, this.hxx.fml);
        this.hxz.y(this.hxH);
        bWL();
        tbPageContext.registerListener(this.hxK);
        tbPageContext.registerListener(this.hxJ);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.hxI, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.aZe = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.hxB = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.hxC = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.hxD = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.hxF = str;
    }

    public void setMoreForumTitle(String str) {
        this.hxG = str;
    }

    public void setMoreForumUrl(String str) {
        this.hxE = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eg(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.hxF);
        writeActivityConfig.setMoreForumUrl(this.hxE);
        writeActivityConfig.setMoreForumTitle(this.hxG);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.aZe))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.hxB);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.hxC);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.hxD);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || w.isEmpty(bVar.bWT())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.bWT().size());
        for (FrsTabInfo frsTabInfo : bVar.bWT()) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                arrayList.add(new FrsTabItemData(frsTabInfo));
            }
        }
        if (w.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = -1;
        return frsTabInfoData;
    }

    public c bWH() {
        return this.hxx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWI() {
        this.gZU.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.hxT);
        this.gZU.add(aVar);
        setDatas(this.gZU);
    }

    public void setDatas(ArrayList<q> arrayList) {
        this.gZU = arrayList;
        this.hxx.fml.setData(arrayList);
    }

    private void bWJ() {
        this.hxx.mRoot.setOnClickListener(this);
        this.hxx.hxO.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bWK();
                    return true;
                }
                return false;
            }
        });
        this.hxx.hxO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bWK();
            }
        });
        this.hxx.hxO.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bWK();
                }
            }
        });
        this.hxx.hxO.setOnClickListener(this);
        this.hxx.gKl.setOnClickListener(this);
        this.hxx.dmF.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWK() {
        if (this.hxx.hxO.getText() == null || StringUtils.isNull(this.hxx.hxO.getText().toString())) {
            this.hxx.gKl.setVisibility(8);
            this.hxA = null;
            bWL();
            return;
        }
        q qVar = (q) w.getItem(this.gZU, 0);
        if (qVar != null && qVar.getType() == com.baidu.tieba.forumsearch.b.a.hxS) {
            this.gZU.clear();
            setDatas(this.gZU);
        }
        this.hxx.gKl.setVisibility(0);
        this.hxA = this.hxx.hxO.getText().toString();
        this.hxy.Fa(this.hxA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWL() {
        this.hxy.cancelMessage();
        this.gZU.clear();
        ArrayList<String> bWN = e.bWN();
        if (!w.isEmpty(bWN)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.hxS);
            this.gZU.add(aVar);
            this.gZU.add(new com.baidu.tieba.forumsearch.b.a(bWN));
            setDatas(this.gZU);
            return;
        }
        this.gZU.clear();
        setDatas(this.gZU);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hxI);
        MessageManager.getInstance().unRegisterListener(this.hxK);
        MessageManager.getInstance().unRegisterListener(this.hxJ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hxx.hxO) {
            bWK();
        } else if (view == this.hxx.dmF) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.hxx.hxO);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hxx.gKl) {
            this.hxx.hxO.setText("");
        } else if (view == this.hxx.mRoot) {
            setDatas(this.gZU);
        }
    }
}
