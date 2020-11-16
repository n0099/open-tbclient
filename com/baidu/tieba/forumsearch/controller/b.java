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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.forumsearch.controller.d;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes23.dex */
public class b implements View.OnClickListener {
    private long bmk;
    private final c iFO;
    private final d iFP;
    private final a iFQ;
    private String iFR;
    private OriginalThreadInfo.ShareInfo iFS;
    private String iFT;
    private String iFU;
    private String iFV;
    private String iFW;
    private String iFX;
    private ArrayList<q> ihK;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener iFY = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.l(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.a(bVar);
                    TiebaStatic.log(new ar("c12609").w("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.eQ(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fMx = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.iFO.iGe);
        }
    };
    private CustomMessageListener iFZ = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.iFO.iGe.setText(str);
                b.this.iFO.iGe.setSelection(str.length());
                b.this.cww();
            }
        }
    };
    private CustomMessageListener iGa = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cwx();
            }
        }
    };
    private d.a iGb = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || y.isEmpty(cVar.cwF())) {
                if (StringUtils.isNull(b.this.iFR)) {
                    b.this.cwx();
                    return;
                } else {
                    b.this.cwu();
                    return;
                }
            }
            b.this.ihK = cVar.cwF();
            b.this.setDatas(b.this.ihK);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.iFO = new c(tbPageContext);
        cwv();
        this.iFP = new d(tbPageContext, tbPageContext.getUniqueId());
        this.iFP.a(this.iGb);
        this.ihK = new ArrayList<>();
        this.iFQ = new a(tbPageContext, this.iFO.ghN);
        this.iFQ.z(this.iFY);
        cwx();
        tbPageContext.registerListener(this.iGa);
        tbPageContext.registerListener(this.iFZ);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fMx, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.bmk = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.iFS = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.iFT = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.iFU = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.iFW = str;
    }

    public void setMoreForumTitle(String str) {
        this.iFX = str;
    }

    public void setMoreForumUrl(String str) {
        this.iFV = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.iFW);
        writeActivityConfig.setMoreForumUrl(this.iFV);
        writeActivityConfig.setMoreForumTitle(this.iFX);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.bmk))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.iFS);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.iFT);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.iFU);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || y.isEmpty(bVar.cwE())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.cwE().size());
        for (FrsTabInfo frsTabInfo : bVar.cwE()) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                arrayList.add(new FrsTabItemData(frsTabInfo));
            }
        }
        if (y.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = -1;
        return frsTabInfoData;
    }

    public c cwt() {
        return this.iFO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwu() {
        this.ihK.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.iGj);
        this.ihK.add(aVar);
        setDatas(this.ihK);
    }

    public void setDatas(ArrayList<q> arrayList) {
        this.ihK = arrayList;
        this.iFO.ghN.setData(arrayList);
    }

    private void cwv() {
        this.iFO.mRoot.setOnClickListener(this);
        this.iFO.iGe.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.cww();
                    return true;
                }
                return false;
            }
        });
        this.iFO.iGe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.cww();
            }
        });
        this.iFO.iGe.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.cww();
                }
            }
        });
        this.iFO.iGe.setOnClickListener(this);
        this.iFO.hRy.setOnClickListener(this);
        this.iFO.bOb.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cww() {
        if (this.iFO.iGe.getText() == null || StringUtils.isNull(this.iFO.iGe.getText().toString())) {
            this.iFO.hRy.setVisibility(8);
            this.iFR = null;
            cwx();
            return;
        }
        q qVar = (q) y.getItem(this.ihK, 0);
        if (qVar != null && qVar.getType() == com.baidu.tieba.forumsearch.b.a.iGi) {
            this.ihK.clear();
            setDatas(this.ihK);
        }
        this.iFO.hRy.setVisibility(0);
        this.iFR = this.iFO.iGe.getText().toString();
        this.iFP.JO(this.iFR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwx() {
        this.iFP.cancelMessage();
        this.ihK.clear();
        ArrayList<String> cwz = e.cwz();
        if (!y.isEmpty(cwz)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.iGi);
            this.ihK.add(aVar);
            this.ihK.add(new com.baidu.tieba.forumsearch.b.a(cwz));
            setDatas(this.ihK);
            return;
        }
        this.ihK.clear();
        setDatas(this.ihK);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMx);
        MessageManager.getInstance().unRegisterListener(this.iGa);
        MessageManager.getInstance().unRegisterListener(this.iFZ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iFO.iGe) {
            cww();
        } else if (view == this.iFO.bOb) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.iFO.iGe);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.iFO.hRy) {
            this.iFO.iGe.setText("");
        } else if (view == this.iFO.mRoot) {
            setDatas(this.ihK);
        }
    }
}
