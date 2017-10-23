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
import com.baidu.tbadk.util.q;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class b extends BaseFragment implements ai {
    private c cVg;
    private c.a cVh;
    private boolean clB;
    private boolean cVi = false;
    private CustomMessageListener bil = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(b.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().ars != null) {
                        if (AntiHelper.a(b.this.getActivity(), updateAttentionMessage.getData().ars, b.this.cqX) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.aha));
                        }
                    } else if (updateAttentionMessage.getData().BZ && updateAttentionMessage.getData().isAttention) {
                        l.showToast(b.this.getActivity(), d.l.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a cqX = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.aha));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.aha));
        }
    };

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.cVg = new c(context);
        this.cVg.aoH();
        registerListener(this.bil);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.cVg.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cVg.getParent()).removeView(this.cVg);
            if (this.cVh != null) {
                this.cVg.setCallback(this.cVh);
            }
        }
        this.cVg.setPageUniqueId(getUniqueId());
        if (this.cVi) {
            this.cVg.aoH();
            this.cVi = false;
        }
        return this.cVg;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        if (this.cVg != null) {
            this.cVg.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        if (this.cVg != null) {
            this.cVg.setRecommendFrsNavigationAnimDispatcher(qVar);
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
        this.cVg.setTabInForeBackgroundState(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cVg.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cVg.onDestroy();
        this.cVi = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.clB) {
                if (this.cVg != null) {
                    this.cVg.aoI();
                }
                this.clB = true;
            }
            this.cVg.aoL();
            return;
        }
        this.cVg.aoM();
        completePullRefresh();
    }

    public void aoF() {
        this.cVg.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.cVg.completePullRefresh();
    }

    public void setCallback(c.a aVar) {
        this.cVh = aVar;
        this.cVg.setCallback(aVar);
    }

    public void N(String str, int i) {
        this.cVg.N(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.cVg != null) {
            this.cVg.a(dataRes, z);
        }
    }

    public void aoG() {
        if (this.cVg != null) {
            this.cVg.aoI();
            this.clB = true;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void NC() {
        this.cVg.reload();
    }

    @Override // com.baidu.tieba.frs.ai
    public void ND() {
    }

    @Override // com.baidu.tieba.frs.ai
    public void NE() {
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
        this.cVg.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ai
    public void wu() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
