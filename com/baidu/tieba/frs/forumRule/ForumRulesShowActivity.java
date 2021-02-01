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
    private ForumRulesShowModel juA;
    private c juB;
    a.InterfaceC0725a juC = new a.InterfaceC0725a() { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.1
        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0725a
        public void A(boolean z, String str) {
            if (ForumRulesShowActivity.this.juB != null) {
                if (z) {
                    ForumRulesShowActivity.this.juB.KG(str);
                } else {
                    ForumRulesShowActivity.this.juB.cHL();
                }
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0725a
        public void Kt(String str) {
            if (ForumRulesShowActivity.this.juB != null) {
                ForumRulesShowActivity.this.juB.addTitle(str);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0725a
        public void a(b bVar) {
            if (ForumRulesShowActivity.this.juB != null) {
                ForumRulesShowActivity.this.juB.c(bVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0725a
        public void dp(List<com.baidu.tieba.frs.forumRule.b.c> list) {
            if (ForumRulesShowActivity.this.juB != null) {
                ForumRulesShowActivity.this.juB.dt(list);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0725a
        public void a(com.baidu.tieba.frs.forumRule.b.a aVar) {
            if (ForumRulesShowActivity.this.juB != null) {
                ForumRulesShowActivity.this.juB.b(aVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0725a
        public void bCh() {
            if (ForumRulesShowActivity.this.juB != null) {
                ForumRulesShowActivity.this.juB.cHJ();
                ForumRulesShowActivity.this.juB.cHF();
                ForumRulesShowActivity.this.showNetRefreshView(ForumRulesShowActivity.this.juB.cHE(), "");
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0725a
        public void finish() {
            if (ForumRulesShowActivity.this.juB != null) {
                ForumRulesShowActivity.this.hideNetRefreshView(ForumRulesShowActivity.this.juB.cHE());
                ForumRulesShowActivity.this.juB.cHG();
                ForumRulesShowActivity.this.juB.cHI();
                ForumRulesShowActivity.this.juB.cHH();
            }
        }
    };
    private CustomMessageListener juD = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.2
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
        this.juA.ao(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.juB != null) {
            this.juB.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.juD);
    }

    private void initData(Bundle bundle) {
        this.juA = new ForumRulesShowModel(this);
        cGT();
    }

    private void initView() {
        if (getIntent() != null) {
            this.mFrom = getIntent().getStringExtra("from");
        }
        this.juB = new c(this, this.mFrom);
        this.juB.a(getRefreshView());
    }

    private void cGT() {
        this.juA.a(this.juC);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.juB != null) {
            this.juB.setFrom(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.juD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.juA != null) {
            this.juA.destory();
        }
        if (this.juB != null) {
            this.juB.destory();
        }
    }

    public void cGU() {
        if (this.juA != null) {
            this.juA.cHl();
        }
    }

    public c cGV() {
        return this.juB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25053) {
            String stringExtra = intent.getStringExtra("group_name");
            if (!intent.getBooleanExtra("from", true)) {
                this.juB.remove();
                this.juB.mData.clear();
                this.juA.cHl();
            }
            new BdTopToast(this, 3000).zn(true).UN(stringExtra).aR(this.juB.getRootView());
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
