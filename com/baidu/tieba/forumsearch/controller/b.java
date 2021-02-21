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
import com.baidu.adp.widget.ListView.n;
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
/* loaded from: classes8.dex */
public class b implements View.OnClickListener {
    private long buN;
    private ArrayList<n> iGj;
    private final c jei;
    private final d jej;
    private final a jek;
    private String jel;
    private OriginalThreadInfo.ShareInfo jem;
    private String jen;
    private String jeo;
    private String jep;
    private String jeq;
    private String jer;
    private BaijiahaoData mBaijiahaoData;
    private int mFrom;
    private TbPageContext mPageContext;
    private View.OnClickListener jes = new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.controller.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.forumsearch.b.b) {
                Intent intent = new Intent();
                b.this.mPageContext.getPageActivity().setResult(-1, intent);
                com.baidu.tieba.forumsearch.b.b bVar = (com.baidu.tieba.forumsearch.b.b) view.getTag();
                if (b.this.mFrom == 1) {
                    b.this.n(bVar.getForumId(), bVar.getForumName());
                } else if (b.this.mFrom == 2) {
                    b.this.a(bVar);
                    TiebaStatic.log(new ar("c12609").v("fid", bVar.getForumId()));
                } else if (b.this.mFrom != 3) {
                    if (b.this.mFrom == 4) {
                        b.this.eV(String.valueOf(bVar.getForumId()), bVar.getForumName());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.getForumId()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.getForumName());
                    b.this.mPageContext.getPageActivity().finish();
                }
            }
        }
    };
    private Runnable gbv = new Runnable() { // from class: com.baidu.tieba.forumsearch.controller.b.2
        @Override // java.lang.Runnable
        public void run() {
            l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.jei.jey);
        }
    };
    private CustomMessageListener jet = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                b.this.jei.jey.setText(str);
                b.this.jei.jey.setSelection(str.length());
                b.this.cBg();
            }
        }
    };
    private CustomMessageListener jeu = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY) { // from class: com.baidu.tieba.forumsearch.controller.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.this.cBh();
            }
        }
    };
    private d.a jev = new d.a() { // from class: com.baidu.tieba.forumsearch.controller.b.5
        @Override // com.baidu.tieba.forumsearch.controller.d.a
        public void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar) {
            if (!z || cVar == null || y.isEmpty(cVar.cBp())) {
                if (StringUtils.isNull(b.this.jel)) {
                    b.this.cBh();
                    return;
                } else {
                    b.this.cBe();
                    return;
                }
            }
            b.this.iGj = cVar.cBp();
            b.this.setDatas(b.this.iGj);
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.jei = new c(tbPageContext);
        cBf();
        this.jej = new d(tbPageContext, tbPageContext.getUniqueId());
        this.jej.a(this.jev);
        this.iGj = new ArrayList<>();
        this.jek = new a(tbPageContext, this.jei.gzp);
        this.jek.A(this.jes);
        cBh();
        tbPageContext.registerListener(this.jeu);
        tbPageContext.registerListener(this.jet);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.gbv, 500L);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setLiveId(long j) {
        this.buN = j;
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        this.jem = shareInfo;
    }

    public void setTransmitOriginThreadComment(String str) {
        this.jen = str;
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        this.jeo = str;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahaoData = baijiahaoData;
    }

    public void setMoreForumImg(String str) {
        this.jeq = str;
    }

    public void setMoreForumTitle(String str) {
        this.jer = str;
    }

    public void setMoreForumUrl(String str) {
        this.jep = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eV(String str, String str2) {
        if (!WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig.newInstance(this.mPageContext.getPageActivity()).setType(9).setForumId(str).setForumName(str2).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).send();
            this.mPageContext.getPageActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(this.mPageContext.getPageActivity(), arrayList, String.valueOf(this.buN))));
        this.mPageContext.getPageActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar != null) {
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mPageContext.getPageActivity(), 9, String.valueOf(bVar.getForumId()), bVar.getForumName(), null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.jem);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.jen);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.jeo);
            transmitPostEditActivityConfig.setFrsTabInfo(b(bVar));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            this.mPageContext.getPageActivity().finish();
        }
    }

    private FrsTabInfoData b(com.baidu.tieba.forumsearch.b.b bVar) {
        if (bVar == null || y.isEmpty(bVar.cBo())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.cBo().size());
        for (FrsTabInfo frsTabInfo : bVar.cBo()) {
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

    public c cBd() {
        return this.jei;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBe() {
        this.iGj.clear();
        com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
        aVar.g(com.baidu.tieba.forumsearch.b.a.jeD);
        this.iGj.add(aVar);
        setDatas(this.iGj);
    }

    public void setDatas(ArrayList<n> arrayList) {
        this.iGj = arrayList;
        this.jei.gzp.setData(arrayList);
    }

    private void cBf() {
        this.jei.mRoot.setOnClickListener(this);
        this.jei.jey.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.forumsearch.controller.b.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    b.this.cBg();
                    return true;
                }
                return false;
            }
        });
        this.jei.jey.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.forumsearch.controller.b.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.cBg();
            }
        });
        this.jei.jey.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.forumsearch.controller.b.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), view);
                } else {
                    b.this.cBg();
                }
            }
        });
        this.jei.jey.setOnClickListener(this);
        this.jei.fgA.setOnClickListener(this);
        this.jei.bYe.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBg() {
        if (this.jei.jey.getText() == null || StringUtils.isNull(this.jei.jey.getText().toString())) {
            this.jei.fgA.setVisibility(8);
            this.jel = null;
            cBh();
            return;
        }
        n nVar = (n) y.getItem(this.iGj, 0);
        if (nVar != null && nVar.getType() == com.baidu.tieba.forumsearch.b.a.jeC) {
            this.iGj.clear();
            setDatas(this.iGj);
        }
        this.jei.fgA.setVisibility(0);
        this.jel = this.jei.jey.getText().toString();
        this.jej.Kc(this.jel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBh() {
        this.jej.cancelMessage();
        this.iGj.clear();
        ArrayList<String> cBj = e.cBj();
        if (!y.isEmpty(cBj)) {
            com.baidu.tieba.forumsearch.b.a aVar = new com.baidu.tieba.forumsearch.b.a();
            aVar.g(com.baidu.tieba.forumsearch.b.a.jeC);
            this.iGj.add(aVar);
            this.iGj.add(new com.baidu.tieba.forumsearch.b.a(cBj));
            setDatas(this.iGj);
            return;
        }
        this.iGj.clear();
        setDatas(this.iGj);
    }

    public void onDestory() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gbv);
        MessageManager.getInstance().unRegisterListener(this.jeu);
        MessageManager.getInstance().unRegisterListener(this.jet);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jei.jey) {
            cBg();
        } else if (view == this.jei.bYe) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jei.jey);
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jei.fgA) {
            this.jei.jey.setText("");
        } else if (view == this.jei.mRoot) {
            setDatas(this.iGj);
        }
    }
}
