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
    private long blh;
    private ArrayList<q> hOy;
    private final c imG;
    private final d imH;
    private final a imI;
    private String imJ;
    private OriginalThreadInfo.ShareInfo imK;
    private String imL;
    private String imM;
    private String imN;
    private String imO;
    private String imP;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener imQ = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.k(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.a(bVar);
                    TiebaStatic.log(new aq("c12609").u("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.eL(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable fyJ = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.imG.imW);
        }
    };
    private CustomMessageListener imR = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.imG.imW.setText(str);
                b.this.imG.imW.setSelection(str.length());
                b.this.crl();
            }
        }
    };
    private CustomMessageListener imS = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.crm();
            }
        }
    };
    private d.a imT = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || y.isEmpty(cVar.crv())) {
                if (StringUtils.isNull(b.this.imJ)) {
                    b.this.crm();
                    return;
                } else {
                    b.this.crj();
                    return;
                }
            }
            b.this.hOy = cVar.crv();
            b.this.setDatas(b.this.hOy);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.imG = new c(tbPageContext);
        crk();
        this.imH = new d(tbPageContext, tbPageContext.getUniqueId());
        this.imH.a(this.imT);
        this.hOy = new ArrayList<>();
        this.imI = new a(tbPageContext, this.imG.fSo);
        this.imI.y(this.imQ);
        crm();
        tbPageContext.registerListener(this.imS);
        tbPageContext.registerListener(this.imR);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fyJ, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.blh = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.imK = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.imL = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.imM = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.imO = str;
    }

    public void setMoreForumTitle(String str) {
        this.imP = str;
    }

    public void setMoreForumUrl(String str) {
        this.imN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.imO);
        writeActivityConfig.setMoreForumUrl(this.imN);
        writeActivityConfig.setMoreForumTitle(this.imP);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.blh))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.imK);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.imL);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.imM);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || y.isEmpty(bVar.cru())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.cru().size());
        for (FrsTabInfo frsTabInfo : bVar.cru()) {
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

    public c cri() {
        return this.imG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crj() {
        this.hOy.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.inb);
        this.hOy.add(aVar);
        setDatas(this.hOy);
    }

    public void setDatas(ArrayList<q> arrayList) {
        this.hOy = arrayList;
        this.imG.fSo.setData(arrayList);
    }

    private void crk() {
        this.imG.mRoot.setOnClickListener(this);
        this.imG.imW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.crl();
                    return true;
                }
                return false;
            }
        });
        this.imG.imW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.crl();
            }
        });
        this.imG.imW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.crl();
                }
            }
        });
        this.imG.imW.setOnClickListener(this);
        this.imG.hyF.setOnClickListener(this);
        this.imG.dQH.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crl() {
        if (this.imG.imW.getText() == null || StringUtils.isNull(this.imG.imW.getText().toString())) {
            this.imG.hyF.setVisibility(8);
            this.imJ = null;
            crm();
            return;
        }
        q qVar = (q) y.getItem(this.hOy, 0);
        if (qVar != null && qVar.getType() == com.baidu.tieba.forumsearch.b.a.ina) {
            this.hOy.clear();
            setDatas(this.hOy);
        }
        this.imG.hyF.setVisibility(0);
        this.imJ = this.imG.imW.getText().toString();
        this.imH.Jx(this.imJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crm() {
        this.imH.cancelMessage();
        this.hOy.clear();
        ArrayList<String> cro = e.cro();
        if (!y.isEmpty(cro)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.ina);
            this.hOy.add(aVar);
            this.hOy.add(new com.baidu.tieba.forumsearch.b.a(cro));
            setDatas(this.hOy);
            return;
        }
        this.hOy.clear();
        setDatas(this.hOy);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fyJ);
        MessageManager.getInstance().unRegisterListener(this.imS);
        MessageManager.getInstance().unRegisterListener(this.imR);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.imG.imW) {
            crl();
        } else if (view == this.imG.dQH) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.imG.imW);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.imG.hyF) {
            this.imG.imW.setText("");
        } else if (view == this.imG.mRoot) {
            setDatas(this.hOy);
        }
    }
}
