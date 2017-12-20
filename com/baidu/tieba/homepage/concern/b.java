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
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class b extends BaseFragment implements aj {
    private boolean cCm;
    private c dnE;
    private c.a dnF;
    private boolean dnG = false;
    private CustomMessageListener bpP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(b.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().asp != null) {
                        if (AntiHelper.a(b.this.getActivity(), updateAttentionMessage.getData().asp, b.this.cHZ) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahM));
                        }
                    } else if (updateAttentionMessage.getData().BI && updateAttentionMessage.getData().isAttention) {
                        l.showToast(b.this.getActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a cHZ = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahM));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahM));
        }
    };

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.dnE = new c(context);
        this.dnE.aoY();
        registerListener(this.bpP);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dnE.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dnE.getParent()).removeView(this.dnE);
            if (this.dnF != null) {
                this.dnE.setCallback(this.dnF);
            }
        }
        this.dnE.setPageUniqueId(getUniqueId());
        if (this.dnG) {
            this.dnE.aoY();
            this.dnG = false;
        }
        return this.dnE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        if (this.dnE != null) {
            this.dnE.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dnE != null) {
            this.dnE.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dnE != null) {
            this.dnE.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dnE.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dnE.onDestroy();
        this.dnG = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.cCm) {
                if (this.dnE != null) {
                    this.dnE.aty();
                }
                this.cCm = true;
            }
            this.dnE.atB();
            return;
        }
        this.dnE.atD();
        completePullRefresh();
    }

    public void Qo() {
        this.dnE.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.dnE.completePullRefresh();
    }

    public void setCallback(c.a aVar) {
        this.dnF = aVar;
        this.dnE.setCallback(aVar);
    }

    public void W(String str, int i) {
        this.dnE.W(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dnE != null) {
            this.dnE.a(dataRes, z);
        }
    }

    public void atx() {
        if (this.dnE != null) {
            this.dnE.aty();
            this.cCm = true;
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pj() {
        this.dnE.reload();
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pk() {
    }

    @Override // com.baidu.tieba.frs.aj
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
        this.dnE.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void wC() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }
}
