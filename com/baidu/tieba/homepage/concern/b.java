package com.baidu.tieba.homepage.concern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes2.dex */
public class b extends BaseFragment implements aj {
    private boolean dyG;
    private c efI;
    private c.a efJ;
    private boolean efK = false;
    private CustomMessageListener cht = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.concern.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(b.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().biU != null) {
                        if (AntiHelper.a(b.this.getActivity(), updateAttentionMessage.getData().biU, b.this.dFu) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXK));
                        }
                    } else if (updateAttentionMessage.getData().apP && updateAttentionMessage.getData().isAttention) {
                        l.showToast(b.this.getActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a dFu = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXK));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXK));
        }
    };

    public b() {
    }

    @SuppressLint({"ValidFragment"})
    public b(Context context) {
        this.efI = new c(context);
        this.efI.ayf();
        registerListener(this.cht);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.efI.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.efI.getParent()).removeView(this.efI);
            if (this.efJ != null) {
                this.efI.setCallback(this.efJ);
            }
        }
        this.efI.setPageUniqueId(getUniqueId());
        if (this.efK) {
            this.efI.ayf();
            this.efK = false;
        }
        return this.efI;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        if (this.efI != null) {
            this.efI.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.efI != null) {
            this.efI.setRecommendFrsNavigationAnimDispatcher(sVar);
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
        if (this.efI != null) {
            this.efI.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.efI.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.cht);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.efI.onDestroy();
        this.efK = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.dyG) {
                if (this.efI != null) {
                    this.efI.aCf();
                }
                this.dyG = true;
            }
            this.efI.aCi();
            return;
        }
        this.efI.aCj();
        completePullRefresh();
    }

    public void XL() {
        this.efI.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.efI.completePullRefresh();
    }

    public void setCallback(c.a aVar) {
        this.efJ = aVar;
        this.efI.setCallback(aVar);
    }

    public void Y(String str, int i) {
        this.efI.Y(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.efI != null) {
            this.efI.a(dataRes, z);
        }
    }

    public void aCe() {
        if (this.efI != null) {
            this.efI.aCf();
            this.dyG = true;
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xp() {
        if (this.dyG) {
            this.efI.reload();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xq() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xr() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.f(arrayList, arrayList.size() - 1))) {
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
        this.efI.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void En() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }
}
