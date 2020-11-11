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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.forumsearch.controller.d;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes24.dex */
public class b implements View.OnClickListener {
    private long bnV;
    private final c iFa;
    private final d iFb;
    private final a iFc;
    private String iFd;
    private OriginalThreadInfo.ShareInfo iFe;
    private String iFf;
    private String iFg;
    private String iFh;
    private String iFi;
    private String iFj;
    private ArrayList<q> igW;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener iFk = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
                    TiebaStatic.log(new aq("c12609").w("fid", bVar.getForumId()));
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
    private Runnable fMU = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.iFa.iFq);
        }
    };
    private CustomMessageListener iFl = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.iFa.iFq.setText(str);
                b.this.iFa.iFq.setSelection(str.length());
                b.this.cwT();
            }
        }
    };
    private CustomMessageListener iFm = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cwU();
            }
        }
    };
    private d.a iFn = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || y.isEmpty(cVar.cxd())) {
                if (StringUtils.isNull(b.this.iFd)) {
                    b.this.cwU();
                    return;
                } else {
                    b.this.cwR();
                    return;
                }
            }
            b.this.igW = cVar.cxd();
            b.this.setDatas(b.this.igW);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.iFa = new c(tbPageContext);
        cwS();
        this.iFb = new d(tbPageContext, tbPageContext.getUniqueId());
        this.iFb.a(this.iFn);
        this.igW = new ArrayList<>();
        this.iFc = new a(tbPageContext, this.iFa.gih);
        this.iFc.z(this.iFk);
        cwU();
        tbPageContext.registerListener(this.iFm);
        tbPageContext.registerListener(this.iFl);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fMU, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.bnV = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.iFe = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.iFf = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.iFg = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.iFi = str;
    }

    public void setMoreForumTitle(String str) {
        this.iFj = str;
    }

    public void setMoreForumUrl(String str) {
        this.iFh = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.iFi);
        writeActivityConfig.setMoreForumUrl(this.iFh);
        writeActivityConfig.setMoreForumTitle(this.iFj);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.bnV))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.iFe);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.iFf);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.iFg);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || y.isEmpty(bVar.cxc())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.cxc().size());
        for (FrsTabInfo frsTabInfo : bVar.cxc()) {
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

    public c cwQ() {
        return this.iFa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwR() {
        this.igW.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.iFv);
        this.igW.add(aVar);
        setDatas(this.igW);
    }

    public void setDatas(ArrayList<q> arrayList) {
        this.igW = arrayList;
        this.iFa.gih.setData(arrayList);
    }

    private void cwS() {
        this.iFa.mRoot.setOnClickListener(this);
        this.iFa.iFq.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.cwT();
                    return true;
                }
                return false;
            }
        });
        this.iFa.iFq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.cwT();
            }
        });
        this.iFa.iFq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.cwT();
                }
            }
        });
        this.iFa.iFq.setOnClickListener(this);
        this.iFa.hQY.setOnClickListener(this);
        this.iFa.bPL.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwT() {
        if (this.iFa.iFq.getText() == null || StringUtils.isNull(this.iFa.iFq.getText().toString())) {
            this.iFa.hQY.setVisibility(8);
            this.iFd = null;
            cwU();
            return;
        }
        q qVar = (q) y.getItem(this.igW, 0);
        if (qVar != null && qVar.getType() == com.baidu.tieba.forumsearch.b.a.iFu) {
            this.igW.clear();
            setDatas(this.igW);
        }
        this.iFa.hQY.setVisibility(0);
        this.iFd = this.iFa.iFq.getText().toString();
        this.iFb.Kn(this.iFd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwU() {
        this.iFb.cancelMessage();
        this.igW.clear();
        ArrayList<String> cwW = e.cwW();
        if (!y.isEmpty(cwW)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.iFu);
            this.igW.add(aVar);
            this.igW.add(new com.baidu.tieba.forumsearch.b.a(cwW));
            setDatas(this.igW);
            return;
        }
        this.igW.clear();
        setDatas(this.igW);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMU);
        MessageManager.getInstance().unRegisterListener(this.iFm);
        MessageManager.getInstance().unRegisterListener(this.iFl);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iFa.iFq) {
            cwT();
        } else if (view == this.iFa.bPL) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.iFa.iFq);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.iFa.hQY) {
            this.iFa.iFq.setText("");
        } else if (view == this.iFa.mRoot) {
            setDatas(this.igW);
        }
    }
}
