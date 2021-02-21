package com.baidu.tieba.frs.forumRule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tieba.frs.forumRule.a.a;
import com.baidu.tieba.frs.forumRule.b.b;
import com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel;
import com.baidu.tieba.frs.forumRule.view.c;
import com.baidu.tieba.view.BdTopToast;
import java.util.List;
/* loaded from: classes2.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements h {
    private ForumRulesShowModel juO;
    private c juP;
    a.InterfaceC0726a juQ = new a.InterfaceC0726a() { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.1
        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0726a
        public void A(boolean z, String str) {
            if (ForumRulesShowActivity.this.juP != null) {
                if (z) {
                    ForumRulesShowActivity.this.juP.KH(str);
                } else {
                    ForumRulesShowActivity.this.juP.cHS();
                }
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0726a
        public void Ku(String str) {
            if (ForumRulesShowActivity.this.juP != null) {
                ForumRulesShowActivity.this.juP.addTitle(str);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0726a
        public void a(b bVar) {
            if (ForumRulesShowActivity.this.juP != null) {
                ForumRulesShowActivity.this.juP.c(bVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0726a
        public void dp(List<com.baidu.tieba.frs.forumRule.b.c> list) {
            if (ForumRulesShowActivity.this.juP != null) {
                ForumRulesShowActivity.this.juP.dt(list);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0726a
        public void a(com.baidu.tieba.frs.forumRule.b.a aVar) {
            if (ForumRulesShowActivity.this.juP != null) {
                ForumRulesShowActivity.this.juP.b(aVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0726a
        public void bCh() {
            if (ForumRulesShowActivity.this.juP != null) {
                ForumRulesShowActivity.this.juP.cHQ();
                ForumRulesShowActivity.this.juP.cHM();
                ForumRulesShowActivity.this.showNetRefreshView(ForumRulesShowActivity.this.juP.cHL(), "");
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0726a
        public void finish() {
            if (ForumRulesShowActivity.this.juP != null) {
                ForumRulesShowActivity.this.hideNetRefreshView(ForumRulesShowActivity.this.juP.cHL());
                ForumRulesShowActivity.this.juP.cHN();
                ForumRulesShowActivity.this.juP.cHP();
                ForumRulesShowActivity.this.juP.cHO();
            }
        }
    };
    private CustomMessageListener juR = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(ForumRulesShowActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private String mFrom;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initView();
        this.juO.ao(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.juP != null) {
            this.juP.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.juR);
    }

    private void initData(Bundle bundle) {
        this.juO = new ForumRulesShowModel(this);
        cHa();
    }

    private void initView() {
        if (getIntent() != null) {
            this.mFrom = getIntent().getStringExtra("from");
        }
        this.juP = new c(this, this.mFrom);
        this.juP.a(getRefreshView());
    }

    private void cHa() {
        this.juO.a(this.juQ);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.juP != null) {
            this.juP.setFrom(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.juR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.juO != null) {
            this.juO.destory();
        }
        if (this.juP != null) {
            this.juP.destory();
        }
    }

    public void cHb() {
        if (this.juO != null) {
            this.juO.cHs();
        }
    }

    public c cHc() {
        return this.juP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25053) {
            String stringExtra = intent.getStringExtra("group_name");
            if (!intent.getBooleanExtra("from", true)) {
                this.juP.remove();
                this.juP.mData.clear();
                this.juO.cHs();
            }
            new BdTopToast(this, 3000).zn(true).UZ(stringExtra).aR(this.juP.getRootView());
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bIg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bIh() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bIi() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bIj() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bIk() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bIl() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bIm() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        bf.bsV().b(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
    }
}
