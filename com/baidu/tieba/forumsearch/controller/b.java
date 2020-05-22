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
import com.baidu.adp.widget.ListView.o;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.forumsearch.controller.d;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private long aWv;
    private ArrayList<o> gMN;
    private final c hlf;
    private final d hlg;
    private final a hlh;
    private String hli;
    private OriginalThreadInfo.ShareInfo hlj;
    private String hlk;
    private String hll;
    private String hlm;
    private String hln;
    private String hlo;
    private View.OnClickListener hlp = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.j(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.a(bVar);
                    TiebaStatic.log(new an("c12609").s("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.eb(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable hlq = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.hlf.hlw);
        }
    };
    private CustomMessageListener hlr = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.hlf.hlw.setText(str);
                b.this.hlf.hlw.setSelection(str.length());
                b.this.bTL();
            }
        }
    };
    private CustomMessageListener hls = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bTM();
            }
        }
    };
    private d.a hlt = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.bTV())) {
                if (StringUtils.isNull(b.this.hli)) {
                    b.this.bTM();
                    return;
                } else {
                    b.this.bTJ();
                    return;
                }
            }
            b.this.gMN = cVar.bTV();
            b.this.setDatas(b.this.gMN);
        }
    };
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hlf = new c(tbPageContext);
        bTK();
        this.hlg = new d(tbPageContext, tbPageContext.getUniqueId());
        this.hlg.a(this.hlt);
        this.gMN = new ArrayList<>();
        this.hlh = new a(tbPageContext, this.hlf.faQ);
        this.hlh.x(this.hlp);
        bTM();
        tbPageContext.registerListener(this.hls);
        tbPageContext.registerListener(this.hlr);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.hlq, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.aWv = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.hlj = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.hlk = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.hll = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.hln = str;
    }

    public void setMoreForumTitle(String str) {
        this.hlo = str;
    }

    public void setMoreForumUrl(String str) {
        this.hlm = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eb(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.hln);
        writeActivityConfig.setMoreForumUrl(this.hlm);
        writeActivityConfig.setMoreForumTitle(this.hlo);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.aWv))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.hlj);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.hlk);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.hll);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || v.isEmpty(bVar.bTU())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.bTU().size());
        for (FrsTabInfo frsTabInfo : bVar.bTU()) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                arrayList.add(new FrsTabItemData(frsTabInfo));
            }
        }
        if (v.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = -1;
        return frsTabInfoData;
    }

    public c bTI() {
        return this.hlf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTJ() {
        this.gMN.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.hlB);
        this.gMN.add(aVar);
        setDatas(this.gMN);
    }

    public void setDatas(ArrayList<o> arrayList) {
        this.gMN = arrayList;
        this.hlf.faQ.setData(arrayList);
    }

    private void bTK() {
        this.hlf.mRoot.setOnClickListener(this);
        this.hlf.hlw.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bTL();
                    return true;
                }
                return false;
            }
        });
        this.hlf.hlw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bTL();
            }
        });
        this.hlf.hlw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bTL();
                }
            }
        });
        this.hlf.hlw.setOnClickListener(this);
        this.hlf.gxm.setOnClickListener(this);
        this.hlf.dhT.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTL() {
        if (this.hlf.hlw.getText() == null || StringUtils.isNull(this.hlf.hlw.getText().toString())) {
            this.hlf.gxm.setVisibility(8);
            this.hli = null;
            bTM();
            return;
        }
        o oVar = (o) v.getItem(this.gMN, 0);
        if (oVar != null && oVar.getType() == com.baidu.tieba.forumsearch.b.a.hlA) {
            this.gMN.clear();
            setDatas(this.gMN);
        }
        this.hlf.gxm.setVisibility(0);
        this.hli = this.hlf.hlw.getText().toString();
        this.hlg.Ez(this.hli);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTM() {
        this.hlg.cancelMessage();
        this.gMN.clear();
        ArrayList<String> bTO = e.bTO();
        if (!v.isEmpty(bTO)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.hlA);
            this.gMN.add(aVar);
            this.gMN.add(new com.baidu.tieba.forumsearch.b.a(bTO));
            setDatas(this.gMN);
            return;
        }
        this.gMN.clear();
        setDatas(this.gMN);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hlq);
        MessageManager.getInstance().unRegisterListener(this.hls);
        MessageManager.getInstance().unRegisterListener(this.hlr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hlf.hlw) {
            bTL();
        } else if (view == this.hlf.dhT) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.hlf.hlw);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hlf.gxm) {
            this.hlf.hlw.setText("");
        } else if (view == this.hlf.mRoot) {
            setDatas(this.gMN);
        }
    }
}
