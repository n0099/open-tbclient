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
    private ArrayList<o> gMY;
    private View.OnClickListener hlA = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
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
    private Runnable hlB = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.hlq.hlH);
        }
    };
    private CustomMessageListener hlC = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.hlq.hlH.setText(str);
                b.this.hlq.hlH.setSelection(str.length());
                b.this.bTN();
            }
        }
    };
    private CustomMessageListener hlD = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.bTO();
            }
        }
    };
    private d.a hlE = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || v.isEmpty(cVar.bTX())) {
                if (StringUtils.isNull(b.this.hlt)) {
                    b.this.bTO();
                    return;
                } else {
                    b.this.bTL();
                    return;
                }
            }
            b.this.gMY = cVar.bTX();
            b.this.setDatas(b.this.gMY);
        }
    };
    private final c hlq;
    private final d hlr;
    private final a hls;
    private String hlt;
    private OriginalThreadInfo.ShareInfo hlu;
    private String hlv;
    private String hlw;
    private String hlx;
    private String hly;
    private String hlz;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hlq = new c(tbPageContext);
        bTM();
        this.hlr = new d(tbPageContext, tbPageContext.getUniqueId());
        this.hlr.a(this.hlE);
        this.gMY = new ArrayList<>();
        this.hls = new a(tbPageContext, this.hlq.fbb);
        this.hls.x(this.hlA);
        bTO();
        tbPageContext.registerListener(this.hlD);
        tbPageContext.registerListener(this.hlC);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.hlB, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.aWv = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.hlu = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.hlv = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.hlw = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.hly = str;
    }

    public void setMoreForumTitle(String str) {
        this.hlz = str;
    }

    public void setMoreForumUrl(String str) {
        this.hlx = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eb(String str, String str2) {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.hly);
        writeActivityConfig.setMoreForumUrl(this.hlx);
        writeActivityConfig.setMoreForumTitle(this.hlz);
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
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.hlu);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.hlv);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.hlw);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || v.isEmpty(bVar.bTW())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.bTW().size());
        for (FrsTabInfo frsTabInfo : bVar.bTW()) {
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

    public c bTK() {
        return this.hlq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTL() {
        this.gMY.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.hlM);
        this.gMY.add(aVar);
        setDatas(this.gMY);
    }

    public void setDatas(ArrayList<o> arrayList) {
        this.gMY = arrayList;
        this.hlq.fbb.setData(arrayList);
    }

    private void bTM() {
        this.hlq.mRoot.setOnClickListener(this);
        this.hlq.hlH.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.bTN();
                    return true;
                }
                return false;
            }
        });
        this.hlq.hlH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.bTN();
            }
        });
        this.hlq.hlH.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.bTN();
                }
            }
        });
        this.hlq.hlH.setOnClickListener(this);
        this.hlq.gxx.setOnClickListener(this);
        this.hlq.dhT.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTN() {
        if (this.hlq.hlH.getText() == null || StringUtils.isNull(this.hlq.hlH.getText().toString())) {
            this.hlq.gxx.setVisibility(8);
            this.hlt = null;
            bTO();
            return;
        }
        o oVar = (o) v.getItem(this.gMY, 0);
        if (oVar != null && oVar.getType() == com.baidu.tieba.forumsearch.b.a.hlL) {
            this.gMY.clear();
            setDatas(this.gMY);
        }
        this.hlq.gxx.setVisibility(0);
        this.hlt = this.hlq.hlH.getText().toString();
        this.hlr.Ez(this.hlt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTO() {
        this.hlr.cancelMessage();
        this.gMY.clear();
        ArrayList<String> bTQ = e.bTQ();
        if (!v.isEmpty(bTQ)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.hlL);
            this.gMY.add(aVar);
            this.gMY.add(new com.baidu.tieba.forumsearch.b.a(bTQ));
            setDatas(this.gMY);
            return;
        }
        this.gMY.clear();
        setDatas(this.gMY);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hlB);
        MessageManager.getInstance().unRegisterListener(this.hlD);
        MessageManager.getInstance().unRegisterListener(this.hlC);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hlq.hlH) {
            bTN();
        } else if (view == this.hlq.dhT) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.hlq.hlH);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hlq.gxx) {
            this.hlq.hlH.setText("");
        } else if (view == this.hlq.mRoot) {
            setDatas(this.gMY);
        }
    }
}
