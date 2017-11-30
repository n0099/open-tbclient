package com.baidu.tieba.homepage.concern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class b extends BaseFragment implements ai {
    private boolean cCe;
    private c.a dmA;
    private c dmz;
    private boolean dmB = false;
    private CustomMessageListener bpO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(b.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().ask != null) {
                        if (AntiHelper.a(b.this.getActivity(), updateAttentionMessage.getData().ask, b.this.cHQ) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahS));
                        }
                    } else if (updateAttentionMessage.getData().BJ && updateAttentionMessage.getData().isAttention) {
                        l.showToast(b.this.getActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a cHQ = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahS));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahS));
        }
    };

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.dmz = new c(context);
        this.dmz.aoQ();
        registerListener(this.bpO);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dmz.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dmz.getParent()).removeView(this.dmz);
            if (this.dmA != null) {
                this.dmz.setCallback(this.dmA);
            }
        }
        this.dmz.setPageUniqueId(getUniqueId());
        if (this.dmB) {
            this.dmz.aoQ();
            this.dmB = false;
        }
        return this.dmz;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        if (this.dmz != null) {
            this.dmz.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dmz != null) {
            this.dmz.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmz != null) {
            this.dmz.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dmz.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dmz.onDestroy();
        this.dmB = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.cCe) {
                if (this.dmz != null) {
                    this.dmz.atq();
                }
                this.cCe = true;
            }
            this.dmz.att();
            return;
        }
        this.dmz.atv();
        completePullRefresh();
    }

    public void Qo() {
        this.dmz.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.dmz.completePullRefresh();
    }

    public void setCallback(c.a aVar) {
        this.dmA = aVar;
        this.dmz.setCallback(aVar);
    }

    public void V(String str, int i) {
        this.dmz.V(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dmz != null) {
            this.dmz.a(dataRes, z);
        }
    }

    public void atp() {
        if (this.dmz != null) {
            this.dmz.atq();
            this.cCe = true;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void Pj() {
        this.dmz.reload();
    }

    @Override // com.baidu.tieba.frs.ai
    public void Pk() {
    }

    @Override // com.baidu.tieba.frs.ai
    public void Pl() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a038";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dmz.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ai
    public void wE() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
